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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class b extends a {
    public final List<a> d;

    @Override // zy3.a
    public final void e() {
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).e();
        goto L4
    }

    @Override // zy3.a
    public final void g() {
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).g();
        goto L4
    }

    @Override // zy3.a
    public final void h() {
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).h();
        goto L4
    }

    @Override // zy3.a
    public final void c() {
        super.c();
        Iterator r0 = ((ArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).c();
        goto L4
    }

    @Override // zy3.a
    public final void f() {
        super.f();
        Iterator r0 = ((ArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).f();
        goto L4
    }

    public b(wy3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "cmtContext");
        super(r2);
        this.d = new ArrayList();
    }

    @Override // zy3.a
    public final void d(View r8) {
        Intrinsics.checkNotNullParameter(r8, "rootView");
        super.d(r8);
        List<a> r0 = this.d;
        wy3.a r1 = this.c;
        p r2 = (p) this;
        Intrinsics.checkNotNullParameter(r1, "cmtContext");
        if (r1.e == false) goto L5;
        List r3 = CollectionsKt.mutableListOf(new a[]{new f(r2.e), new com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.a(r2.e)});
    L6:
        ((ArrayList) r0).addAll(r3);
        Iterator r4 = ((ArrayList) this.d).iterator();
    L8:
        if (r4.hasNext() == false) goto L18;
        a r5 = (a) r4.next();
        AbstractUIModule<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> r6 = this.a;
        if (r6 == null) goto L16;
        View r7 = r6.b;
        if (r7 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r7 = null;
    L15:
        if (r7 == null) goto L16;
    L17:
        r5.d(r7);
    L16:
        r7 = r8;
        goto L17
    L18:
        return;
    L5:
        r3 = CollectionsKt.mutableListOf(new a[]{new f(r2.e), new com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.a(r2.e)});
        goto L6
    }
}
