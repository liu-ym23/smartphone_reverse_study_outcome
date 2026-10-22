package mg2;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements f70.a {
    public final /* synthetic */ FrameLayout a;
    public final /* synthetic */ FrameLayout b;

    public final ViewGroup a(f70.b r2) {
        Intrinsics.checkNotNullParameter(r2, "layerType");
        if (Intrinsics.areEqual(r2, e.c) == false) goto L6;
        return this.a;
    L6:
        if (Intrinsics.areEqual(r2, e.e) == false) goto L9;
        return this.b;
    L9:
        return this.b;
    }

    public c(FrameLayout r1, FrameLayout r2) {
        this.a = r1;
        this.b = r2;
    }
}
