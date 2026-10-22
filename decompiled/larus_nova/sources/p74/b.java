package p74;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.bdinstall.dtrait.model.DTraitLogLevel;
import com.bytedance.security.Sword.Sword;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import y74.d;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v74.a f528020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f528021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f528022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, JSONObject> f528023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, JSONObject> f528024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f528025f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ReentrantLock f528026g;

    public final void a(String r100) {
        if (((HashMap) this.f528023d).isEmpty() == false) goto L5;
    L7:
        byte[] r101 = Sword.clientUnpackedBase64(r100);
        if (r101 != null) goto L10;
    L23:
        m74.a.a("[dt] parseDTraitConfig# error bytesData is null");
        return;
    L10:
        if (r101.length == 0) goto L23;
        JSONObject r102 = new JSONObject(new String(r101));     // Catch: Exception -> L20
        this.f528025f = r102.optString("version", "");     // Catch: Exception -> L20
        b(r102, SlcCommonAction.KEY_PARAMS, this.f528023d);     // Catch: Exception -> L20
        int r103 = r102.optInt("delay_sec", 0);     // Catch: Exception -> L20
        if (r103 <= 0) goto L15;
        this.f528021b = ((long) r103) * 1000;     // Catch: Exception -> L20
    L15:
        int r104 = r102.optInt("dtrait_mem_ttl_sec", 0);     // Catch: Exception -> L20
        if (r104 <= 0) goto L18;
        this.f528022c = ((long) r104) * 1000;     // Catch: Exception -> L20
    L18:
        b(r102, "dtrait_fields", this.f528024e);     // Catch: Exception -> L20
        m74.a.a("[dt] " + String.format("parseConfigFields# fields: status_collect delay time:%s, dtraitExpireTime:%s", new Object[]{Long.valueOf(this.f528021b), Long.valueOf(this.f528022c)}));     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        m74.a.b("[dt] parseConfigFields# error: " + e.getMessage());
        return;
    L5:
        if (((HashMap) this.f528024e).isEmpty() == true) goto L7;
    }

    public final void c(JSONObject r100) {
        this.f528026g.lock();
    L8:
        e = move-exception;
        m74.a.b("[dt] parseDTraitConfig# error " + e.getMessage());     // Catch: Throwable -> L6
    L16:
        this.f528026g.unlock();
        return;
    L4:
        if (r100.optString("message", "").equals(com.bytedance.android.ec.core.event.a.VALUE_CLICK_TYPE) == true) goto L10;
        m74.a.a("[dt] parseDTraitConfig# error response.message not equals ok");     // Catch: Throwable -> L6 Exception -> L8
        boolean r101 = false;
    L11:
        if (r101 == false) goto L16;
        String r102 = r100.optString("data");     // Catch: Throwable -> L6 Exception -> L8
        if (TextUtils.isEmpty(r102) == false) goto L18;
        m74.a.a("[dt] parseLoaderConfig error response.data is null");     // Catch: Throwable -> L6 Exception -> L8
        goto L16
    L18:
        d(r102);     // Catch: Throwable -> L6 Exception -> L8
        a(r102);     // Catch: Throwable -> L6 Exception -> L8
        m74.a.a("[dt] parseDTraitConfig# updateMemCacheAndRisk config parse success");     // Catch: Throwable -> L6 Exception -> L8
        goto L16
    L10:
        r101 = true;
    L6:
        th = move-exception;
        this.f528026g.unlock();
        throw th;
    }

    public final void d(String r100) {
        v74.a r101 = this.f528020a;
        r101.getClass();
        r101.f553476f.putString(Constants.Keys.SP_D_DATA, r100);     // Catch: Exception -> L5
        r101.f553476f.commit();     // Catch: Exception -> L5
    L7:
        v74.a r102 = this.f528020a;
        r102.f553472b.lock();
        ((HashMap) r102.f553474d).put(Constants.Keys.SP_D_DATA, r100);     // Catch: Throwable -> L11
        m74.a.a("[dt] updateMemoryCacheBySync# update mem success, key: d_data");     // Catch: Throwable -> L11
        r102.f553472b.unlock();
        return;
    L11:
        th = move-exception;
        r102.f553472b.unlock();
        throw th;
    L5:
        e = move-exception;
        m74.a.b("[dt] updateDiskCache# error " + e.getMessage());
        goto L7
    }

    public b(Context r100, v74.a r101) {
        this.f528021b = 5000;
        this.f528022c = 1800000;
        this.f528023d = new HashMap();
        HashMap r102 = new HashMap();
        this.f528024e = r102;
        this.f528025f = "";
        this.f528026g = new ReentrantLock();
        this.f528020a = r101;
        a(d.f566592a.b(new Object[]{r100}).getString(Constants.Keys.SP_D_DATA, ""));
        y74.a.c(DTraitLogLevel.DEBUG, "[device]", "extra_loader_config_handler ", String.format("ExtraLoaderConfigHandler# init config from sp, dtraitFields: %s", new Object[]{new JSONObject(r102)}), null);
    }

    public static void b(JSONObject r100, String r101, Map r102) throws JSONException {
        JSONArray r103 = r100.optJSONArray(r101);
        if (r103 != null) goto L6;
        m74.a.b("[dt] parseFieldsConfig# fields config is null, key: ".concat(r101));
        return;
    L6:
        int r104 = 0;
    L8:
        if (r104 >= r103.length()) goto L10;
        JSONObject r105 = (JSONObject) r103.get(r104);
        r102.put(r105.optString("name"), r105);
        r104 = r104 + 1;
        goto L8
    }
}
