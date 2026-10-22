package r86;

import android.view.View;
import com.bytedance.ies.xelement.viewpager.LynxTabBarView;
import com.bytedance.ies.xelement.viewpager.tabbar.LynxTabLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxTabBarView f536522a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
    }

    public f(LynxTabBarView r100) {
        this.f536522a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        LynxTabLayout r101 = this.f536522a.f250451b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r101 = null;
    L5:
        final LynxTabBarView r102 = this.f536522a;
        r101.post(new e(r102));
    }
}
