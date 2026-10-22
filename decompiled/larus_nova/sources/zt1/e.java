package zt1;

import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import yt1.o;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<ViewGroup> f573567a;

    @Override // zt1.d
    public final int a() {
        return 1;
    }

    @Override // zt1.d
    public final void b() {
    }

    @Override // zt1.d
    public final void d(o r100, String r101) {
        Intrinsics.checkNotNullParameter("", "biz_data");
        Intrinsics.checkNotNullParameter(r100, "dslData");
        Intrinsics.checkNotNullParameter(r101, "data");
    }

    @Override // zt1.d
    public final ViewGroup c() {
        Intrinsics.checkNotNullParameter("", "biz_data");
        return this.f573567a.get();
    }

    @Override // zt1.d
    public final void e() {
        ViewGroup r100 = this.f573567a.get();
        if (r100 == null) goto L6;
        r100.removeAllViews();
        return;
    }

    public e(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        this.f573567a = new WeakReference(r100);
    }
}
