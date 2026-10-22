package ie6;

import android.view.View;
import com.bytedance.lark.lynxlib.widget.udtabs.LynxTabBarView;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxTabBarView f489490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f489491b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        LynxTabBarView r101 = this.f489490a;
        if (r101.f253295e == true) goto L9;
        UDTabLayout r102 = r101.f253293c;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r102 = null;
    L7:
        final LynxTabBarView r103 = this.f489490a;
        final c r104 = this.f489491b;
        r102.post(new a(r103, r104));
        return;
    }

    public b(LynxTabBarView r100, c r101) {
        this.f489490a = r100;
        this.f489491b = r101;
    }
}
