package zy3;

import android.view.View;
import com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.AbstractUIModule;
import com.bytedance.awemeopen.apps.framework.comment.write.refactor.p;
import ez3.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<a> f573921d;

    @Override // zy3.a
    public final void e() {
        Iterator<T> r100 = this.f573921d.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).e();
        goto L4
    }

    @Override // zy3.a
    public final void g() {
        Iterator<T> r100 = this.f573921d.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).g();
        goto L4
    }

    @Override // zy3.a
    public final void h() {
        Iterator<T> r100 = this.f573921d.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).h();
        goto L4
    }

    @Override // zy3.a
    public final void c() {
        super.c();
        Iterator r100 = ((ArrayList) this.f573921d).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).c();
        goto L4
    }

    @Override // zy3.a
    public final void f() {
        super.f();
        Iterator r100 = ((ArrayList) this.f573921d).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).f();
        goto L4
    }

    public b(wy3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "cmtContext");
        super(r100);
        this.f573921d = new ArrayList();
    }

    @Override // zy3.a
    public final void d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        super.d(r100);
        List<a> r101 = this.f573921d;
        wy3.a r102 = this.f573920c;
        p r103 = (p) this;
        Intrinsics.checkNotNullParameter(r102, "cmtContext");
        if (r102.f561867e == false) goto L5;
        List r104 = CollectionsKt.mutableListOf(new a[]{new f(r103.f194563e), new com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.a(r103.f194563e)});
    L6:
        ((ArrayList) r101).addAll(r104);
        Iterator r105 = ((ArrayList) this.f573921d).iterator();
    L8:
        if (r105.hasNext() == false) goto L18;
        a r106 = (a) r105.next();
        AbstractUIModule<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> r107 = this.f573918a;
        if (r107 == null) goto L16;
        View r108 = r107.f194396b;
        if (r108 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r108 = null;
    L15:
        if (r108 == null) goto L16;
    L17:
        r106.d(r108);
    L16:
        r108 = r100;
        goto L17
    L18:
        return;
    L5:
        r104 = CollectionsKt.mutableListOf(new a[]{new f(r103.f194563e), new com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.a(r103.f194563e)});
        goto L6
    }
}
