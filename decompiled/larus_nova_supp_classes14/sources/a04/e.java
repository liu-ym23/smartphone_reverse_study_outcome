package a04;

import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements q24.a {
    public final /* synthetic */ d a;

    public final void b() {
    }

    public final void a() {
        zx3.a.b(this.a.getContext(), 2131894241).d();
        this.a.l = false;
    }

    public final void onFail() {
        zx3.a.b(this.a.getContext(), 2131894246).d();
        this.a.l = false;
    }

    public e(d r1) {
        this.a = r1;
    }

    public final void onSuccess(String r5) {
        Intrinsics.checkNotNullParameter(r5, "aid");
        Intrinsics.checkNotNullParameter(r5, "aid");
        jz3.a r0 = this.a.j;
        jz3.a r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r0 = null;
    L6:
        if (Intrinsics.areEqual(r5, r0.a.c()) == false) goto L13;
        AosEventReporter r6 = AosEventReporter.a;
        d r2 = this.a;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r3 = r2.h;
        jz3.a r4 = r2.j;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L11:
        r14.c r7 = r1.a;
        r6.getClass();
        AosEventReporter.F(r3, r7);
        this.a.h().a.b(Boolean.FALSE);
        this.a.r();
        this.a.l = false;
        return;
    L10:
        r1 = r4;
        goto L11
    }
}
