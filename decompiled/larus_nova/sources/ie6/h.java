package ie6;

import android.view.View;
import com.bytedance.lark.lynxlib.widget.udtabs.LynxViewPager;
import com.bytedance.lark.lynxlib.widget.udtabs.Pager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxViewPager f489496a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
    }

    public h(LynxViewPager r100) {
        this.f489496a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Pager r101 = this.f489496a.f253298b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPager");
        r101 = null;
    L5:
        final LynxViewPager r102 = this.f489496a;
        r101.post(new g(r102));
    }
}
