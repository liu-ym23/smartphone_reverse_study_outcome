package k43;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public class c implements n43.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f501756a;

    @Override // n43.c
    public final View getView() {
        return this.f501756a;
    }

    public c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "platformView");
        this.f501756a = r100;
    }

    public final void e(y33.a r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        if (r100.f565847a == false) goto L5;
        this.f501756a.setVisibility(0);
        return;
    L5:
        this.f501756a.setVisibility(8);
    }
}
