package r74;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f536428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f536429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f536430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f536431d;

    public final void a() {
        JSONObject r100 = new JSONObject();
        this.f536428a.putOpt("encrypted_dtrait", this.f536431d.f536434h);     // Catch: Exception -> L7
        this.f536428a.putOpt("device_type", Build.MODEL);     // Catch: Exception -> L7
        this.f536428a.putOpt("device_platform", "android");     // Catch: Exception -> L7
        r100.putOpt("header", y74.d.b(this.f536428a));     // Catch: Exception -> L7
        r100.putOpt(Constants.Keys.KEY_CLIENT_TIME, Long.valueOf(System.currentTimeMillis() / 1000));     // Catch: Exception -> L7
        r100.putOpt("data", this.f536429b);     // Catch: Exception -> L7
        r100.putOpt("version", CastIntegerProtector.valueOf(this.f536431d.f540927d.f528025f));     // Catch: Exception -> L7
        if (Logger.debug() == false) goto L9;
        StringBuilder r101 = new StringBuilder("[dt] [collectLoader] LoaderManager#statsCollect request body.headers: ");     // Catch: Exception -> L7
        this.f536431d.getClass();     // Catch: Exception -> L7
        r101.append(this.f536428a);     // Catch: Exception -> L7
        Logger.d(r101.toString());     // Catch: Exception -> L7
    L9:
        Context r102 = this.f536431d.f540925b;
        JSONObject r103 = x74.c.b(r100, this.f536430c);
        p74.b r104 = this.f536431d.f540927d;
        r104.getClass();
    L21:
        e = move-exception;
        m74.a.b("[dt] updateSpLoaderConfig# error " + e.getMessage());
        return;
    L11:
        if (r103.optString("message", "").equals(com.bytedance.android.ec.core.event.a.VALUE_CLICK_TYPE) == true) goto L13;
        m74.a.a("[dt] parseDTraitConfig# error response.message not equals ok");     // Catch: Exception -> L21
        boolean r105 = false;
    L14:
        if (r105 == false) goto L27;
        String r106 = r103.optString("data");     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r106) == false) goto L19;
        m74.a.a("[dt] updateSpLoaderConfig# error response.data is null");     // Catch: Exception -> L21
        return;
    L19:
        r104.d(r106);     // Catch: Exception -> L21
        r104.a(r106);     // Catch: Exception -> L21
        m74.a.a("[dt] updateSpLoaderConfig# updateMemCacheAndRisk success");     // Catch: Exception -> L21
        return;
    L27:
        return;
    L13:
        r105 = true;
    L7:
        e = move-exception;
        StringBuilder r107 = new StringBuilder("[dt] [collectLoader] LoaderManager#parse json error: ");
        this.f536431d.getClass();
        r107.append(e.getMessage());
        Logger.d(r107.toString());
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(c r100, JSONObject r101, JSONObject r102, boolean r103) {
        this.f536431d = r100;
        this.f536428a = r101;
        this.f536429b = r102;
        this.f536430c = r103;
    }
}
