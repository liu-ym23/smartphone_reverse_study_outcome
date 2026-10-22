package x9c;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.ss.android.lark.forseti.widget.ForsetiStackChainViewGroup;
import com.ss.android.lark.ui.component_container.ResponsiveBaseFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ResponsiveBaseFragment f563018a;

    public a(ResponsiveBaseFragment r100) {
        this.f563018a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ResponsiveBaseFragment r101 = this.f563018a;
        int r102 = ResponsiveBaseFragment.f444576r;
        r101.getClass();
        BottomSheetBehavior<ForsetiStackChainViewGroup> r103 = this.f563018a.f444589p;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        r103 = null;
    L5:
        r103.setState(5);
    }
}
