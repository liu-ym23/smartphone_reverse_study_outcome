package com.bytedance.android.ui.ec.widget.photodraweeview.transition;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001&\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010-\u001a\u00020.2\u0006\u0010%\u001a\u00020\u0011J\u0010\u0010/\u001a\u00020.2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u00100\u001a\u00020.H\u0016J\u0015\u00101\u001a\u00020.2\u0006\u00102\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00103J\u0015\u00104\u001a\u00020.2\u0006\u00102\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00103J\u000e\u00105\u001a\u00020.2\u0006\u0010%\u001a\u00020\u0011J\u0016\u00106\u001a\u00020.2\u0006\u00107\u001a\u0002082\u0006\u0010 \u001a\u00020\u001fJ\u000e\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020;R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u00020\b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000ej\b\u0012\u0004\u0012\u00020\u0002`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\fR\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R&\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f8B@BX\u0082\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'R\u001e\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00110)j\b\u0012\u0004\u0012\u00020\u0011`*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001f0,X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionPagerAdapter;", "T", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "()V", "enterAnimLayout", "Landroid/view/View;", "hideViewBeforeEnterAnim", "", "getHideViewBeforeEnterAnim", "()Z", "setHideViewBeforeEnterAnim", "(Z)V", "holders", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "internalTransitionListener", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionListener;", "getInternalTransitionListener", "()Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionListener;", "setInternalTransitionListener", "(Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionListener;)V", "isEnterAnimationRunning", "setEnterAnimationRunning", "needEnterAnimation", "optEnterTransition", "getOptEnterTransition", "setOptEnterTransition", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "value", "Landroid/graphics/Rect;", "startRect", "getStartRect", "()Landroid/graphics/Rect;", "setStartRect", "(Landroid/graphics/Rect;)V", "transitionListener", "com/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionPagerAdapter$transitionListener$1", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionPagerAdapter$transitionListener$1;", "transitionListeners", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "transitionStartRectMap", "Landroid/util/SparseArray;", "addTransitionListener", "", "onAttachedToRecyclerView", "onDestroy", "onViewAttachedToWindow", "holder", "(Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionViewHolder;)V", "onViewDetachedFromWindow", "removeTransitionListener", "setEnterAnimationParams", "position", "", "setOnScrollListener", "listener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class TransitionPagerAdapter<T extends TransitionViewHolder> extends RecyclerView.Adapter<T> {
    private View enterAnimLayout;
    private boolean hideViewBeforeEnterAnim;
    private final HashSet<TransitionViewHolder> holders;
    private TransitionListener internalTransitionListener;
    private boolean isEnterAnimationRunning;
    private boolean needEnterAnimation;
    private boolean optEnterTransition;
    private RecyclerView recyclerView;
    private Rect startRect;
    private final TransitionPagerAdapter$transitionListener$1 transitionListener;
    private final ArrayList<TransitionListener> transitionListeners;
    private SparseArray<Rect> transitionStartRectMap;

    public void onDestroy() {
    }

    public final boolean getHideViewBeforeEnterAnim() {
        if (this.optEnterTransition == false) goto L7;
        return false;
    L7:
        return this.hideViewBeforeEnterAnim;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter$transitionListener$1] */
    public TransitionPagerAdapter() {
        this.transitionListeners = new ArrayList();
        this.holders = new HashSet();
        this.transitionStartRectMap = new SparseArray();
        this.startRect = new Rect();
        this.transitionListener = new TransitionPagerAdapter$transitionListener$1(this);
    }

    private final Rect getStartRect() {
        return this.startRect;
    }

    public final TransitionListener getInternalTransitionListener() {
        return this.internalTransitionListener;
    }

    public final boolean getOptEnterTransition() {
        return this.optEnterTransition;
    }

    public final boolean isEnterAnimationRunning() {
        return this.isEnterAnimationRunning;
    }

    public static final /* synthetic */ View access$getEnterAnimLayout$p(TransitionPagerAdapter r0) {
        return r0.enterAnimLayout;
    }

    private final void setStartRect(Rect r2) {
        this.startRect.set(r2);
    }

    public final void addTransitionListener(TransitionListener r2) {
        Intrinsics.checkNotNullParameter(r2, "transitionListener");
        this.transitionListeners.add(r2);
    }

    public void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onAttachedToRecyclerView(r2);
        this.recyclerView = r2;
    }

    public void onViewAttachedToWindow(T r5) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        super.onViewAttachedToWindow(r5);
        this.holders.add(r5);
        Iterator<T> r0 = this.transitionListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        TransitionListener r1 = (TransitionListener) r0.next();
        r5.getTransitionLayout().addTransitionListener(r1);
        goto L4
    L6:
        RecyclerView r2 = this.recyclerView;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L9:
        int r3 = r2.getChildAdapterPosition(((RecyclerView.ViewHolder) r5).itemView);
        r5.getTransitionLayout().setStartRect(this.transitionStartRectMap.get(r3, new Rect()));
        r5.getTransitionLayout().addTransitionListener(this.transitionListener);
        if (this.needEnterAnimation == false) goto L21;
        this.needEnterAnimation = false;
        if (this.optEnterTransition == false) goto L14;
        r5.getTransitionLayout().setOptEnterTransition(true);
        r5.getTransitionLayout().setStartRect(getStartRect());
    L14:
        r5.getTransitionLayout().startEnterTransition(getStartRect());
        this.enterAnimLayout = r5.getTransitionLayout();
        if (getHideViewBeforeEnterAnim() == false) goto L22;
        View r6 = this.enterAnimLayout;
        if (r6 == null) goto L23;
        r6.setVisibility(4);
        return;
    L23:
        return;
    L22:
        return;
    }

    public void onViewDetachedFromWindow(T r4) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        super.onViewDetachedFromWindow(r4);
        Iterator<T> r0 = this.transitionListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        TransitionListener r1 = (TransitionListener) r0.next();
        r4.getTransitionLayout().removeTransitionListener(r1);
        goto L4
    L6:
        r4.getTransitionLayout().removeTransitionListener(this.transitionListener);
    }

    public final void removeTransitionListener(TransitionListener r2) {
        Intrinsics.checkNotNullParameter(r2, "transitionListener");
        this.transitionListeners.remove(r2);
    }

    public final void setEnterAnimationRunning(boolean r1) {
        this.isEnterAnimationRunning = r1;
    }

    public final void setHideViewBeforeEnterAnim(boolean r1) {
        this.hideViewBeforeEnterAnim = r1;
    }

    public final void setInternalTransitionListener(TransitionListener r1) {
        this.internalTransitionListener = r1;
    }

    public final void setOnScrollListener(RecyclerView.OnScrollListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        RecyclerView r0 = this.recyclerView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L5:
        r0.addOnScrollListener(r3);
    }

    public final void setOptEnterTransition(boolean r1) {
        this.optEnterTransition = r1;
    }

    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder r1) {
        onViewAttachedToWindow((TransitionViewHolder) r1);
    }

    public /* bridge */ /* synthetic */ void onViewDetachedFromWindow(RecyclerView.ViewHolder r1) {
        onViewDetachedFromWindow((TransitionViewHolder) r1);
    }

    public static final /* synthetic */ void access$setEnterAnimLayout$p(TransitionPagerAdapter r0, View r1) {
        r0.enterAnimLayout = r1;
    }

    public final void setEnterAnimationParams(int r2, Rect r3) {
        Intrinsics.checkNotNullParameter(r3, "startRect");
        if (r2 < getItemCount()) goto L5;
        return;
    L5:
        this.transitionStartRectMap.put(r2, r3);
        this.needEnterAnimation = true;
        this.isEnterAnimationRunning = true;
        setStartRect(r3);
    }
}
