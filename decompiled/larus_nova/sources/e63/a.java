package e63;

import android.view.View;
import com.bytedance.android.shopping.anchorv3.detail.widget.expandable.ExpandableLinearLayout;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f471126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ExpandableLinearLayout f471127b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        this.f471126a.removeOnAttachStateChangeListener(this);
        this.f471127b.getOnBottomViewAttachListener();
    }

    public a(View r100, ExpandableLinearLayout r101) {
        this.f471126a = r100;
        this.f471127b = r101;
    }
}
