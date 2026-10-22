package com.bytedance.relax.ttmlstatic.prewarm.page;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.relax.ttmlstatic.CardSession;
import com.bytedance.relax.ttmlstatic.g;
import com.bytedance.relax.ttmlstatic.h;
import com.bytedance.rts.kmp.foundation.i;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.ArrayList;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f267289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f267290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Long> f267291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f267292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f267293e;

    public b() {
        this.f267291c = i.b(new Long[]{0L});
    }

    public final void a(CardSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        long r101 = this.f267292d;
        if (r101 == 0) goto L9;
        long r102 = this.f267293e;
        if (r102 == 0) goto L7;
        r100.f267193a.j(r101, r102);
        r100.f267193a.i(this.f267293e);
        this.f267293e = 0;
    L7:
        h r103 = r100.f267193a;
        r103.j(r103.f267237b, this.f267292d);
        r100.f267193a.i(this.f267292d);
        this.f267292d = 0;
        return;
    }

    public final void c(CardSession r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f267290b = r100.f267193a.f267238c;
        Intrinsics.checkNotNullParameter(r101, "data");
        int r102 = g.f267235a;
        if (g.a.b(r101) == false) goto L17;
        ArrayList r103 = g.a.c(r101);
        a r104 = new a();
        IntCompanionObject r105 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        int r106 = r103.size();
        Intrinsics.checkNotNullParameter(r105, "<this>");
        if (r106 == 0) goto L14;
        int r107 = 0;
    L8:
        IntCompanionObject r108 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        int r109 = r103.size();
        Intrinsics.checkNotNullParameter(r108, "<this>");
        if (r107 >= r109) goto L14;
        String r110 = (String) ListProtector.get(r103, r107);
        int r111 = g.f267235a;
        Object r112 = g.a.a(r101, r110);
        if (Intrinsics.areEqual(r110, "label") == false) goto L13;
        String r113 = g.a.f(r112, "$.label");
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        r104.f267288a = r113;
    L13:
        r107 = r107 + 1;
    L14:
        this.f267289a = r104;
        long r114 = r100.f267193a.e(this.f267290b);
        this.f267292d = r114;
        r100.f267193a.n(r114, "0 1");
        h r115 = r100.f267193a;
        r115.b(r115.f267237b, this.f267292d);
        long r116 = r100.f267193a.d(this.f267290b);
        this.f267293e = r116;
        r100.f267193a.b(this.f267292d, r116);
        h r117 = r100.f267193a;
        long r118 = this.f267293e;
        a r119 = this.f267289a;
        Intrinsics.checkNotNull(r119);
        r117.o(r118, r119.f267288a);
        return;
    L17:
        throw new Throwable("[TTML Static] Expected Card data object at $.");
    }

    public final boolean b(CardSession r110, Object r111, Object r112) {
        Intrinsics.checkNotNullParameter(r110, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r111, "data");
        Intrinsics.checkNotNullParameter(r112, "options");
        ArrayList r100 = i.b(new Long[]{0L});
        Intrinsics.checkNotNullParameter(r111, "patch");
        Intrinsics.checkNotNullParameter(r100, "dirty");
        int r113 = g.f267235a;
        if (g.a.b(r111) == false) goto L27;
        a r114 = this.f267289a;
        Intrinsics.checkNotNull(r114);
        String r115 = r114.f267288a;
        ArrayList r116 = g.a.c(r111);
        int r117 = 0;
        boolean r118 = false;
    L5:
        IntCompanionObject r119 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r116, "<this>");
        int r101 = r116.size();
        Intrinsics.checkNotNullParameter(r119, "<this>");
        if (r117 >= r101) goto L12;
        String r102 = (String) ListProtector.get(r116, r117);
        int r120 = g.f267235a;
        Object r121 = g.a.a(r111, r102);
        if (Intrinsics.areEqual(r102, "label") == false) goto L10;
        r115 = g.a.f(r121, "$.label");
        r118 = true;
    L10:
        r117 = r117 + 1;
        goto L5
    L12:
        if (r118 == false) goto L16;
        a r103 = this.f267289a;
        Intrinsics.checkNotNull(r103);
        if (Intrinsics.areEqual(r103.f267288a, r115) == true) goto L16;
        a r104 = this.f267289a;
        Intrinsics.checkNotNull(r104);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        r104.f267288a = r115;
        ListProtector.set(r100, 0, Long.valueOf(((Number) ListProtector.get(r100, 0)).longValue() | 1));
        boolean r105 = true;
    L17:
        if (r105 == true) goto L19;
        return false;
    L19:
        Intrinsics.checkNotNullParameter(r110, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r100, "dirty");
        i.b(new Boolean[0]);
        if ((((Number) ListProtector.get(r100, 0)).longValue() & 1) == 0) goto L31;
        long r106 = this.f267293e;
        if (r106 == 0) goto L32;
        h r107 = r110.f267193a;
        a r108 = this.f267289a;
        Intrinsics.checkNotNull(r108);
        r107.o(r106, r108.f267288a);
        return true;
    L32:
        return true;
    L31:
        return true;
    L16:
        r105 = false;
        goto L17
    L27:
        throw new Throwable("[TTML Static] Expected Card patch object at $.");
    }
}
