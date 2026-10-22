package ke7;

import androidx.core.app.NotificationCompat;
import com.alipay.sdk.m.p.e;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthSuccessCode;
import com.bytedance.sdk.xbridge.cn.auth.n;
import com.bytedance.sdk.xbridge.cn.auth.o;
import com.bytedance.sdk.xbridge.cn.protocol.auth.AuthPriority;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<ke7.a> f503035a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f503036a = null;

        static {
            int[] r100 = new int[AuthPriority.values().length];
            r100[AuthPriority.HIGH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f503036a = r100;
        }
    }

    public c() {
        this.f503035a = new CopyOnWriteArrayList();
    }

    public final ld7.c a(le7.a<?> r110, IDLXBridgeMethod r111) {
        Intrinsics.checkNotNullParameter(r110, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r111, e.f25671s);
        if (id7.c.f489344d.f489346a == true) goto L6;
        id7.c.a("XBridgeAuthManager.doAuth: skip by disable auth");
        ld7.c r112 = new ld7.c(true, false, "XBridge unable auth", null, AuthSuccessCode.DISABLE_AUTH, 42);
        r112.f508722l = r110.f508958p;
        return r112;
    L6:
        n r100 = n.f269851a;
        String r101 = r110.f508958p;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "url");
        o r102 = n.f269853c;
        boolean r103 = false;
        if (r102 == null) goto L9;
        boolean r104 = r102.a();
    L10:
        if (r104 == true) goto L41;
        o r105 = n.f269853c;
        if (r105 == null) goto L16;
        List<String> r106 = r105.b();
        if (r106 == null) goto L16;
    L18:
        if (r106.isEmpty() == false) goto L59;
    L42:
        if (r103 == false) goto L45;
        id7.c.a("XBridgeAuthManager.doAuth: skip by auth recovery");
        ld7.c r113 = new ld7.c(true, false, "recovery over auth", null, AuthSuccessCode.MATCH_RECOVERY_CONFIG, 42);
        r113.f508722l = r110.f508958p;
        return r113;
    L45:
        Iterator<ke7.a> r107 = this.f503035a.iterator();
        ld7.c r108 = null;
    L47:
        if (r107.hasNext() == false) goto L54;
        r108 = r107.next().a(r110, r111);
        if (r108.f508712b == true) goto L50;
        if (r108.f508711a == true) goto L47;
        return r108;
    L50:
        return r108;
    L54:
        if (r108 == null) goto L56;
        return r108;
    L56:
        return new ld7.c(true, false, null, null, null, 62);
    L59:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L22
        Object r114 = Result.m9449constructorimpl(URLDecoder.decode(r101, Charsets.UTF_8.name()));     // Catch: Throwable -> L22
    L24:
        Object r115 = r101;
        if (Result.m9452exceptionOrNullimpl(r114) != null) goto L27;
        r115 = r114;
    L27:
        String r116 = (String) r115;
        List<String> r117 = r106;
        if ((r117 instanceof Collection) == true) goto L30;
    L32:
        Iterator<T> r118 = r117.iterator();
    L34:
        if (r118.hasNext() == false) goto L42;
        String r119 = (String) r118.next();
        n.f269851a.getClass();
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L38
        boolean r121 = PatternProtector.compile(r119).matcher(r116).find();     // Catch: Throwable -> L38
    L40:
        if (r121 == false) goto L34;
    L38:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        r121 = false;
        goto L40
    L30:
        if (r117.isEmpty() == false) goto L32;
    L22:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L16:
        r106 = CollectionsKt.emptyList();
    L41:
        r103 = true;
        goto L42
    L9:
        r104 = false;
        goto L10
    }
}
