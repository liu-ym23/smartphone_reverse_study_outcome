package com.bytedance.ee.bear.widgets.collapse;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.widgets.BaseItemAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/widgets/collapse/CollapsibleItemAnimator;", "Lcom/bytedance/ee/bear/widgets/BaseItemAnimator;", "<init>", "()V", "addAnimationPrepare", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "addAnimation", "Landroidx/core/view/ViewPropertyAnimatorCompat;", "addAnimationCleanup", "removeAnimation", "moveDeltaY", "", "removeAnimationCleanup", "getRemoveTargetTranslationY", "Companion", "ICollapsibleItem", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CollapsibleItemAnimator extends BaseItemAnimator {

    public static final class a {
    }

    public interface b {
        int A2();

        int V();
    }

    static {
    }

    public CollapsibleItemAnimator() {
        setAddDuration(250);
        setRemoveDuration(250);
        setMoveDuration(250);
        setChangeDuration(250);
    }

    @Override // com.bytedance.ee.bear.widgets.BaseItemAnimator
    public final ViewPropertyAnimatorCompat a(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        return ViewCompat.animate(r100.itemView).alpha(1.0f).translationY(0.0f).z(0.0f);
    }

    @Override // com.bytedance.ee.bear.widgets.BaseItemAnimator
    public final void b(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        View r101 = r100.itemView;
        r101.setAlpha(1.0f);
        r101.setTranslationY(0.0f);
        r101.setTranslationZ(0.0f);
    }

    @Override // com.bytedance.ee.bear.widgets.BaseItemAnimator
    public final void c(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        View r101 = r100.itemView;
        r101.setAlpha(0.0f);
        r101.setTranslationY(g(r100, 0));
        r101.setTranslationZ(-5.0f);
    }

    @Override // com.bytedance.ee.bear.widgets.BaseItemAnimator
    public final void f(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        View r101 = r100.itemView;
        r101.setAlpha(1.0f);
        r101.setTranslationY(0.0f);
        r101.setTranslationZ(0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int g(RecyclerView.ViewHolder r100, int r101) {
        b r102 = null;
        if (r101 <= 0) goto L12;
        if ((r100 instanceof b) == false) goto L7;
        r102 = (b) r100;
    L7:
        if (r102 == null) goto L10;
        int r103 = r102.V() - r102.A2();
        int r104 = r100.itemView.getHeight();
    L17:
        return r103 * r104;
    L10:
        return r100.itemView.getHeight();
    L12:
        if ((r100 instanceof b) == false) goto L14;
        r102 = (b) r100;
    L14:
        if (r102 == null) goto L19;
        r103 = -r102.A2();
        r104 = r100.itemView.getHeight();
        goto L17
    L19:
        return -r100.itemView.getHeight();
    }

    @Override // com.bytedance.ee.bear.widgets.BaseItemAnimator
    public final ViewPropertyAnimatorCompat e(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        return ViewCompat.animate(r100.itemView).alpha(0.0f).translationY(g(r100, r101)).z(-5.0f);
    }
}
