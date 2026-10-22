package h09;

import android.util.Pair;
import com.bytedance.common.utility.StringUtils;
import com.larus.common.audit.SecurityAuditStage;
import com.larus.settings.value.e10;
import com.larus.settings.value.mz;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import java.net.URI;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zv9.p;
import zv9.q;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f483499a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f483500b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f483501c = null;

    static {
        f483499a = new AtomicBoolean(false);
        f483500b = LazyKt.lazy(new b());
        f483501c = LazyKt.lazy(new c());
    }

    public static p b() {
        return (p) f483500b.getValue();
    }

    public static String a(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L16;
        return null;
    L16:
        return new URI(r100).getPath();
    L13:
        e = move-exception;
        FLogger.f375446a.e("SecurityAuditEntry", "Failed to extract path from url: " + r100, e);
        return null;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L9
    }

    public static void c(SecurityAuditStage r110) {
        Intrinsics.checkNotNullParameter(r110, "stage");
        Boolean r100 = b().i();
        Boolean r101 = Boolean.TRUE;
        if (Intrinsics.areEqual(r100, r101) == true) goto L6;
        FLogger.f375446a.i("SecurityAuditEntry", "on ttnet audit prepare, audit is disabled");
        return;
    L6:
        long r102 = System.nanoTime();
        Integer r103 = b().k();
        FLogger r104 = FLogger.f375446a;
        r104.i("SecurityAuditEntry", "on ttnet audit prepare, curStage = " + r110 + ", initStage = " + r103 + ", entire config = " + b());
        int r105 = SecurityAuditStage.CLOSED.getType();
        if (r103 != null) goto L10;
    L11:
        int r106 = r110.getType();
        if (r103 != null) goto L15;
    L28:
        r104.d("SecurityAuditEntry", "startup conditions are not match");
        return;
    L15:
        if (r106 != r103.intValue()) goto L28;
        boolean r107 = false;
        if (f483499a.compareAndSet(false, true) == true) goto L20;
        return;
    L20:
        if (Intrinsics.areEqual(b().i(), r101) == true) goto L23;
        r104.i("SecurityAuditEntry", "on " + r110 + ", audit is disabled");
        return;
    L23:
        int r108 = i.f483502a;
        long r109 = System.nanoTime();
        a r111 = new a();
        AtomicBoolean r112 = vx5.d.f557490a;
        if (StringUtils.isEmpty("security-audit") == true) goto L26;
        ((CopyOnWriteArrayList) vx5.d.f557491b).add(new Pair("security-audit", r111));
        r107 = true;
    L26:
        final long r113 = ((Number) TuplesKt.to(Boolean.valueOf(r107), Long.valueOf((System.nanoTime() - r109) / 1000)).component2()).longValue();
        r104.i("SecurityAuditEntry", "on ttnet audit prepare end, stage = " + r110);
        final long r114 = (System.nanoTime() - r102) / 1000;
        final int r115 = r110.getType();
        e10 r116 = e10.f368561a;
        int r117 = l0.f375430a;
        new q();
        p r118 = (p) l0.a(q.a(), new mz());
        int r119 = u09.c.f548208a;
        u09.c.a("security_ttnet_audit_init", r118.c(), new g(r114, r113, r115));
        return;
    L10:
        if (r105 == r103.intValue()) goto L28;
        goto L11
    }

    public static boolean d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "requestUrl");
        if (Intrinsics.areEqual(b().j(), Boolean.TRUE) == false) goto L34;
        List<String> r101 = b().d();
        if (r101 == null) goto L25;
        List<String> r102 = r101;
        if ((r102 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r103 = r102.iterator();
    L13:
        if (r103.hasNext() == false) goto L22;
        String r104 = (String) r103.next();
        if (r104 != null) goto L17;
    L19:
        boolean r105 = false;
    L20:
        if (r105 == false) goto L13;
        boolean r106 = true;
    L23:
        if (r106 != true) goto L25;
        boolean r107 = true;
    L26:
        if (r107 == false) goto L35;
        return true;
    L35:
        return false;
    L17:
        if (StringsKt.contains$default(r100, r104, false, 2, null) != true) goto L19;
        r105 = true;
    L22:
        r106 = false;
        goto L23
    L9:
        if (r102.isEmpty() == false) goto L11;
    L25:
        r107 = false;
        goto L26
    L34:
        return false;
    }
}
