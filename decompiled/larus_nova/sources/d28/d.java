package d28;

import android.content.Context;
import android.text.TextUtils;
import com.franmontiel.persistentcookiejar.persistence.CookiePersistor;
import com.franmontiel.persistentcookiejar.persistence.SerializableCookie;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import okhttp3.g;

/* JADX INFO: loaded from: classes24.dex */
public final class d implements CookiePersistor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KVRepo f466552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KVRepo f466553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f466554c;

    @Override // com.franmontiel.persistentcookiejar.persistence.CookiePersistor
    public final List<g> a() {
        Log.i("SharedPrefsCookiePersistor", "loadAll!!!!-cookies in process " + z.b(this.f466554c));
        ArrayList r100 = new ArrayList();
        d(this.f466552a, r100);
        if (r100.isEmpty() == false) goto L5;
        Log.i("SharedPrefsCookiePersistor", "loadAll called, cookies is empty");
        d(this.f466553b, r100);
    L5:
        Log.i("SharedPrefsCookiePersistor", "loadAll!!!!-cookies");
        return r100;
    }

    public static String c(g r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100.f523860f == false) goto L5;
        String r102 = "https";
    L6:
        r101.append(r102);
        r101.append("://");
        r101.append(r100.f523858d);
        r101.append(r100.f523859e);
        r101.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        r101.append(r100.f523855a);
        return r101.toString();
    L5:
        r102 = "http";
        goto L6
    }

    @Override // com.franmontiel.persistentcookiejar.persistence.CookiePersistor
    public final void b(Collection<g> r100) {
        Log.i("SharedPrefsCookiePersistor", "saveAll!!!!-cookies in process " + z.b(this.f466554c));
        if (CollectionUtils.isEmpty(r100) == false) goto L6;
        Log.i("SharedPrefsCookiePersistor", "saveAll!!!!-cookies empty return");
        return;
    L6:
        Log.i("SharedPrefsCookiePersistor", "saveAll!!!!-cookies");
        Iterator r101 = ((ArrayList) r100).iterator();
    L8:
        if (r101.hasNext() == false) goto L14;
        g r102 = (g) r101.next();
        String r103 = c(r102);
        String r104 = new SerializableCookie().encode(r102);
        this.f466552a.putString(r103, r104);
        if (r104 == null) goto L12;
        int r105 = r104.length();
    L13:
        Log.i("SharedPrefsCookiePersistor", "Cookie PUT - key: " + r103 + ", value size: " + r105 + " characters");
        StringBuilder r106 = new StringBuilder("saveAll called, key: ");
        r106.append(r103);
        r106.append(", cookie: ");
        r106.append(r102);
        Log.d("SharedPrefsCookiePersistor", r106.toString());
        goto L8
    L12:
        r105 = 0;
        goto L13
    }

    @Override // com.franmontiel.persistentcookiejar.persistence.CookiePersistor
    public final void removeAll(Collection<g> r100) {
        Log.i("SharedPrefsCookiePersistor", "remove specified cookies in process " + z.b(this.f466554c));
        if (CollectionUtils.isEmpty(r100) == false) goto L6;
        Log.i("SharedPrefsCookiePersistor", "no cookies in process");
        return;
    L6:
        Iterator r101 = ((ArrayList) r100).iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        g r102 = (g) r101.next();
        this.f466552a.remove(c(r102));
        Log.d("SharedPrefsCookiePersistor", "removeAll called, key: " + c(r102) + ", cookie: " + r102);
        goto L8
    }

    public static void d(KVRepo r110, List<g> r111) {
        String[] r100 = r110.b();
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L17;
        String r103 = r100[r102];
        String r104 = r110.getString(r103, "");
        if (TextUtils.isEmpty(r104) == false) goto L7;
        Log.e("SharedPrefsCookiePersistor", "load cookie failed in CookiePersistenceSP, key:" + r103);
    L14:
        r102 = r102 + 1;
        goto L3
    L7:
        if (r104 == null) goto L9;
        int r105 = r104.length();
    L10:
        Log.i("SharedPrefsCookiePersistor", "Cookie GET - key: " + r103 + ", value size: " + r105 + " characters");
        g r106 = new SerializableCookie().decode(r104);     // Catch: Exception -> L15
        if (r106 == null) goto L14;
        Log.d("SharedPrefsCookiePersistor", "loadAllDataFromSP called, key: " + c(r106) + ", cookie: " + r106);
        ((ArrayList) r111).add(r106);
    L16:
        throw new IllegalStateException("Failed to code cookie from sp, key: " + r103 + ", value: " + r104 + ", size: " + r104.length());
    L9:
        r105 = 0;
        goto L10
    }

    public d(Context r100, com.ss.android.lark.storage.kv.repo.a r101, com.ss.android.lark.storage.kv.repo.a r102) {
        this.f466554c = r100;
        this.f466552a = r101;
        this.f466553b = r102;
    }
}
