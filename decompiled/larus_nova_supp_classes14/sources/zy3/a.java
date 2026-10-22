package zy3;

import android.view.View;
import com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.AbstractUIModule;
import com.bytedance.awemeopen.apps.framework.comment.write.refactor.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class a {
    public AbstractUIModule<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> a;
    public az3.a<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> b;
    public final wy3.a c;

    public abstract az3.a<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> a(wy3.a r1);

    public abstract AbstractUIModule<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> b(wy3.a r1);

    public void e() {
    }

    public void g() {
    }

    public void h() {
    }

    public void c() {
        az3.a<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> r0 = this.b;
        if (r0 == null) goto L6;
        r0.C();
        return;
    }

    public void f() {
        az3.a<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> r0 = this.b;
        if (r0 == null) goto L6;
        r0.D();
        return;
    }

    public a(wy3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "cmtContext");
        this.c = r2;
    }

    public void d(View r4) {
        Intrinsics.checkNotNullParameter(r4, "rootView");
        this.a = b(this.c);
        this.b = a(this.c);
        AbstractUIModule<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> r0 = this.a;
        if (r0 == null) goto L16;
        Intrinsics.checkNotNull(r0);
        r0.d = r4;
        AbstractUIModule<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> r1 = this.a;
        Intrinsics.checkNotNull(r1);
        AbstractUIModule<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> r2 = this.a;
        Intrinsics.checkNotNull(r2);
        View r3 = r2.b(r4.getContext(), r4);
        if (r3 == null) goto L8;
        r4 = r3;
    L8:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r1.b = r4;
        AbstractUIModule<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> r5 = this.a;
        Intrinsics.checkNotNull(r5);
        AbstractUIModule<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> r6 = this.a;
        Intrinsics.checkNotNull(r6);
        View r7 = r6.b;
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r7 = null;
    L12:
        r5.c(r7, this.c.d);
        az3.a<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> r8 = this.b;
        if (r8 == null) goto L17;
        AbstractUIModule<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> r9 = this.a;
        Intrinsics.checkNotNull(r9);
        n r10 = r9.a();
        Intrinsics.checkNotNullParameter(r10, "viewFinder");
        r8.b = r10;
        r8.A(r10);
        return;
    L17:
        return;
    }
}
