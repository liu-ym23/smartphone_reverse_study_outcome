package mg2;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements f70.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f513704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f513705b;

    @Override // f70.a
    public final ViewGroup a(f70.b r100) {
        Intrinsics.checkNotNullParameter(r100, "layerType");
        if (Intrinsics.areEqual(r100, e.f513710c) == false) goto L6;
        return this.f513704a;
    L6:
        if (Intrinsics.areEqual(r100, e.f513712e) == false) goto L9;
        return this.f513705b;
    L9:
        return this.f513705b;
    }

    public c(FrameLayout r100, FrameLayout r101) {
        this.f513704a = r100;
        this.f513705b = r101;
    }
}
