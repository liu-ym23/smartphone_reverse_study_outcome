package com.ss.android.lark.coremd.facade.gennode;

import com.ss.android.socialbase.appdownloader.ah.DevicePlans;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import u9b.c;
import v7b.i;
import v7b.q;
import v7b.s;
import v7b.v;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f419720b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Class<? extends s>, Integer> f419721c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC4943b f419722a;

    public static final class a implements InterfaceC4943b {
        public a() {
        }

        @Override // com.ss.android.lark.coremd.facade.gennode.b.InterfaceC4943b
        public final int a(s r100) {
            Intrinsics.checkNotNullParameter(r100, "node");
            Integer r101 = b.f419721c.get(r100.getClass());
            if (r101 != null) goto L7;
            return Integer.MAX_VALUE;
        L7:
            return r101.intValue();
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.coremd.facade.gennode.b$b, reason: collision with other inner class name */
    public interface InterfaceC4943b {
        int a(s r100);
    }

    static {
        f419720b = new a();
        f419721c = MapsKt.mapOf(new Pair[]{TuplesKt.to(v7b.b.class, 1), TuplesKt.to(i.class, 2), TuplesKt.to(q.class, 3), TuplesKt.to(v.class, 4)});
    }

    public b() {
        a r100 = f419720b;
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f419722a = r100;
    }

    @Override // u9b.c
    public final int a(s r100, s r101) {
        Intrinsics.checkNotNullParameter(r100, DevicePlans.DEVICE_PLAN_OPPO1);
        Intrinsics.checkNotNullParameter(r101, DevicePlans.DEVICE_PLAN_OPPO2);
        return this.f419722a.a(r100) - this.f419722a.a(r101);
    }
}
