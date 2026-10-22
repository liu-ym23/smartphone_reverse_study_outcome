package q26;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.api.FailedBinderCallBack;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class i {
    public static final String a() {
        String r100 = UUID.randomUUID().toString();
        if (com.bytedance.ies.bullet.core.h.f246501h.f246502a == false) goto L5;
        ExecutorService r101 = BulletLogger.f247763a;
        BulletLogger.i(r100, "create sessionId. just print for local_test, take it easy = ", "XRouter", new Throwable());
    L6:
        return r100;
    L5:
        BulletLogger.g(r100, "create sessionId.", "XRouter", 8);
        goto L6
    }

    public static final String b(Uri r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Map<String, Map<Class<?>, Object>> r102 = x26.a.f562251a;
        w26.g r103 = (w26.g) x26.a.a(w26.g.class);
        boolean r104 = true;
        if (r103 == null) goto L9;
        w26.e r105 = (w26.e) r103.n0(w26.e.class);
        if (r105 == null) goto L9;
        Boolean r106 = r105.a();
        if (r106 == null) goto L9;
        boolean r107 = r106.booleanValue();
    L10:
        if (r107 == false) goto L38;
        String r108 = w36.a.a(r100, "__x_session_id");
        if (r108 != null) goto L16;
        if (r101 == null) goto L15;
        r108 = r101.getString("__x_session_id");
        goto L16
    L15:
        r108 = null;
    L16:
        if (r108 != null) goto L18;
    L21:
        if (r104 == false) goto L39;
        String r109 = UriProtector.getQueryParameter(r100, "__bullet_trident_starter_session_id");
        String r110 = UriProtector.getQueryParameter(r100, "__bullet_trident_call_id");
        w36.a.b(r100, "__bullet_trident_starter_session_id");
        String r111 = a();
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r109) == false) goto L32;
        HybridLogger r112 = HybridLogger.f246343a;
        com.bytedance.ies.bullet.base.utils.logger.a r113 = new com.bytedance.ies.bullet.base.utils.logger.a();
        if (r110 != null) goto L27;
        r110 = "";
    L27:
        r113.a(FailedBinderCallBack.CALLER_ID, r110);
        r113.a("sessionId", r111);
        if (r109 != null) goto L30;
        r109 = "";
    L30:
        r113.a("originSessionId", r109);
        Unit r114 = Unit.INSTANCE;
        HybridLogger.k("XRouter", "associated session", null, r113);
    L32:
        if (com.bytedance.ies.bullet.service.base.h.f() == true) goto L36;
        if (r101 == null) goto L36;
        r101.putString("__x_session_id", r111);
    L36:
        return r111;
    L39:
        return r108;
    L18:
        if (r108.length() == 0) goto L21;
        r104 = false;
        goto L21
    L38:
        return c(r100, r101);
    L9:
        r107 = true;
        goto L10
    }

    public static final String c(Uri r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (r101 == null) goto L5;
        String r102 = r101.getString("__x_session_id");
    L6:
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L26;
        String r104 = UriProtector.getQueryParameter(r100, "__bullet_trident_starter_session_id");
        String r105 = UriProtector.getQueryParameter(r100, "__bullet_trident_call_id");
        w36.a.b(r100, "__bullet_trident_starter_session_id");
        r102 = a();
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r104) == false) goto L23;
        HybridLogger r106 = HybridLogger.f246343a;
        com.bytedance.ies.bullet.base.utils.logger.a r107 = new com.bytedance.ies.bullet.base.utils.logger.a();
        if (r105 != null) goto L18;
        r105 = "";
    L18:
        r107.a(FailedBinderCallBack.CALLER_ID, r105);
        r107.a("sessionId", r102);
        if (r104 != null) goto L21;
        r104 = "";
    L21:
        r107.a("originSessionId", r104);
        Unit r108 = Unit.INSTANCE;
        HybridLogger.k("XRouter", "associated session", null, r107);
    L23:
        if (com.bytedance.ies.bullet.service.base.h.f() == true) goto L26;
        if (r101 == null) goto L26;
        r101.putString("__x_session_id", r102);
    L26:
        return r102;
    L8:
        if (r102.length() == 0) goto L11;
        r103 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }
}
