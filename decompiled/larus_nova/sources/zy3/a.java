package zy3;

import android.view.View;
import com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.AbstractUIModule;
import com.bytedance.awemeopen.apps.framework.comment.write.refactor.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractUIModule<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> f573918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public az3.a<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> f573919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wy3.a f573920c;

    public abstract az3.a<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> a(wy3.a r100);

    public abstract AbstractUIModule<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> b(wy3.a r100);

    public void e() {
    }

    public void g() {
    }

    public void h() {
    }

    public void c() {
        az3.a<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> r100 = this.f573919b;
        if (r100 == null) goto L6;
        r100.C();
        return;
    }

    public void f() {
        az3.a<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> r100 = this.f573919b;
        if (r100 == null) goto L6;
        r100.D();
        return;
    }

    public a(wy3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "cmtContext");
        this.f573920c = r100;
    }

    public void d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        this.f573918a = b(this.f573920c);
        this.f573919b = a(this.f573920c);
        AbstractUIModule<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> r101 = this.f573918a;
        if (r101 == null) goto L16;
        Intrinsics.checkNotNull(r101);
        r101.f194398d = r100;
        AbstractUIModule<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> r102 = this.f573918a;
        Intrinsics.checkNotNull(r102);
        AbstractUIModule<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> r103 = this.f573918a;
        Intrinsics.checkNotNull(r103);
        View r104 = r103.b(r100.getContext(), r100);
        if (r104 == null) goto L8;
        r100 = r104;
    L8:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r102.f194396b = r100;
        AbstractUIModule<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> r105 = this.f573918a;
        Intrinsics.checkNotNull(r105);
        AbstractUIModule<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> r106 = this.f573918a;
        Intrinsics.checkNotNull(r106);
        View r107 = r106.f194396b;
        if (r107 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r107 = null;
    L12:
        r105.c(r107, this.f573920c.f561866d);
        az3.a<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> r108 = this.f573919b;
        if (r108 == null) goto L17;
        AbstractUIModule<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> r109 = this.f573918a;
        Intrinsics.checkNotNull(r109);
        n r110 = r109.a();
        Intrinsics.checkNotNullParameter(r110, "viewFinder");
        r108.f16805b = r110;
        r108.A(r110);
        return;
    L17:
        return;
    }
}
