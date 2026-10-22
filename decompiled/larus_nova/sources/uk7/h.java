package uk7;

import android.os.SystemClock;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements Interceptor {
    public h() {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse intercept(Interceptor.Chain r110) throws Exception {
        Request r100 = r110.request();
        String r101 = null;
        if (r100 != null) goto L7;
        return r110.proceed(null);
    L7:
        if (b.a(r100.getPath()) == false) goto L52;
        long r102 = SystemClock.elapsedRealtime();
        ArrayList r103 = new ArrayList();
        if (r100.getHeaders() == null) goto L11;
        r103.addAll(r100.getHeaders());
    L11:
        r103.add(new Header("X-Bdn-Client-Timestamp", String.valueOf(System.currentTimeMillis())));
        Request r104 = r100.newBuilder().headers(r103).build();
        SsResponse r111 = r110.proceed(r104);
        List<Header> r105 = r111.headers();     // Catch: Throwable -> L43
        if (r105 == null) goto L50;
        Iterator<Header> r106 = r105.iterator();     // Catch: Throwable -> L43
        long r107 = 0;
    L17:
        if (r106.hasNext() == false) goto L33;
        Header r108 = r106.next();     // Catch: Throwable -> L43
        if (r108 == null) goto L17;
        if ("X-Bdn-Timestamp".equalsIgnoreCase(r108.getName()) == true) goto L23;
        if ("X-Bdn-Env".equalsIgnoreCase(r108.getName()) == true) goto L26;
        if (Constants.Keys.KEY_X_TT_LOGID.equalsIgnoreCase(r108.getName()) == false) goto L17;
        r101 = r108.getValue();     // Catch: Throwable -> L43
        goto L17
    L26:
        String r109 = r108.getValue();     // Catch: Throwable -> L43
        int r112 = com.bytedance.ug.sdk.luckydog.api.settings.e.f271651a;     // Catch: Throwable -> L43
        LuckyDogLocalSettings r113 = com.bytedance.ug.sdk.luckydog.api.settings.h.a();     // Catch: Throwable -> L43
        if (r113 == null) goto L17;
        r113.setBdnEnv(r109);     // Catch: Throwable -> L43
        goto L17
    L23:
        r107 = CastLongProtector.parseLong(r108.getValue());     // Catch: Throwable -> L43
        goto L17
    L33:
        if (r107 == 0) goto L35;
        hl7.b.b().c(r107, r102);     // Catch: Throwable -> L43
        goto L50
    L35:
        String r114 = r104.getUrl();     // Catch: Throwable -> L43
        int r115 = com.bytedance.ug.sdk.luckydog.api.settings.e.f271651a;     // Catch: Throwable -> L43
        LuckyDogLocalSettings r116 = com.bytedance.ug.sdk.luckydog.api.settings.h.a();     // Catch: Throwable -> L43
        if (r116 == null) goto L40;
        String r117 = r116.getBdnEnv();     // Catch: Throwable -> L43
        if (r117 == null) goto L40;
    L41:
        hl7.c.b(r114, r117, r101);     // Catch: Throwable -> L43
    L40:
        r117 = "";
    L50:
        return r111;
    L43:
        th = move-exception;
        if (com.bytedance.ug.sdk.luckydog.api.log.d.f271582a > 3) goto L47;
        boolean r118 = true;
    L48:
        if (r118 == false) goto L50;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckyDogTimeInterceptor", "time manager:" + th.getLocalizedMessage());
        goto L50
    L47:
        r118 = false;
        goto L48
    L52:
        return r110.proceed(r100);
    }
}
