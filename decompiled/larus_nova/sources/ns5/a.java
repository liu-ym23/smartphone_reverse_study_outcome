package ns5;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;
import qs5.c;
import rxb.d;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f520318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f520319b;

    /* JADX INFO: renamed from: ns5.a$a, reason: collision with other inner class name */
    public static final class C6970a {
    }

    static {
    }

    @Override // rxb.d
    public final View b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "viewId");
        return null;
    }

    @Override // rxb.d
    public final void destroy() {
    }

    @Override // rxb.d
    public final String viewId() {
        return this.f520318a;
    }

    @Override // rxb.d
    public final View a(ViewGroup r100) {
        return this.f520319b.b();
    }

    public a(String r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "mViewId");
        Intrinsics.checkNotNullParameter(r101, "mNativeViewContainer");
        this.f520318a = r100;
        this.f520319b = r101;
    }
}
