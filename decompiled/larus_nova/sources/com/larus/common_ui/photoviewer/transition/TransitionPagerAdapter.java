package com.larus.common_ui.photoviewer.transition;

import android.graphics.Rect;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.larus.common_ui.photoviewer.transition.TransitionViewHolder;
import j19.e;
import j19.g;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l19.b;
import l19.f;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e*\u00012\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J!\u00104\u001a\u0002052\u0006\u0010*\u001a\u00020)2\n\b\u0002\u0010/\u001a\u0004\u0018\u000100H\u0000¢\u0006\u0002\b6J\u001d\u00104\u001a\u0002052\u0006\u00107\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020)H\u0000¢\u0006\u0002\b6J\u0010\u00108\u001a\u0002052\u0006\u0010\"\u001a\u00020#H\u0016J\u0015\u00109\u001a\u0002052\u0006\u0010:\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010;J\u0015\u0010<\u001a\u0002052\u0006\u0010:\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010;J\u000e\u0010=\u001a\u0002052\u0006\u00101\u001a\u00020\u000eJ\u000e\u0010>\u001a\u0002052\u0006\u00101\u001a\u00020\u000eJ\b\u0010?\u001a\u000205H\u0016J\u0010\u0010@\u001a\u0002052\u0006\u0010A\u001a\u00020\u001dH\u0016J\u0010\u0010B\u001a\u0002052\u0006\u0010A\u001a\u00020\u001dH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0014j\b\u0012\u0004\u0012\u00020\u000e`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R&\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020)8B@BX\u0082\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103¨\u0006C"}, d2 = {"Lcom/larus/common_ui/photoviewer/transition/TransitionPagerAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/larus/common_ui/photoviewer/transition/TransitionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/common_ui/photoviewer/OnPageSelectedListener;", "<init>", "()V", "needEnterAnimation", "", "isEnterAnimationRunning", "()Z", "setEnterAnimationRunning", "(Z)V", "internalTransitionListener", "Lcom/larus/common_ui/photoviewer/transition/TransitionListener;", "getInternalTransitionListener", "()Lcom/larus/common_ui/photoviewer/transition/TransitionListener;", "setInternalTransitionListener", "(Lcom/larus/common_ui/photoviewer/transition/TransitionListener;)V", "transitionListeners", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "restoreTransitionProvider", "Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "getRestoreTransitionProvider$common_ui_mainlandRelease", "()Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "setRestoreTransitionProvider$common_ui_mainlandRelease", "(Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;)V", "dismissAnimationType", "", "getDismissAnimationType$common_ui_mainlandRelease", "()I", "setDismissAnimationType$common_ui_mainlandRelease", "(I)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "value", "Landroid/graphics/Rect;", "startRect", "getStartRect", "()Landroid/graphics/Rect;", "setStartRect", "(Landroid/graphics/Rect;)V", "endViewInfo", "Lcom/larus/common_ui/photoviewer/transition/TransitionEndViewInfo;", "transitionListener", "com/larus/common_ui/photoviewer/transition/TransitionPagerAdapter$transitionListener$1", "Lcom/larus/common_ui/photoviewer/transition/TransitionPagerAdapter$transitionListener$1;", "setEnterAnimationParams", "", "setEnterAnimationParams$common_ui_mainlandRelease", "position", "onAttachedToRecyclerView", "onViewAttachedToWindow", "holder", "(Lcom/larus/common_ui/photoviewer/transition/TransitionViewHolder;)V", "onViewDetachedFromWindow", "addTransitionListener", "removeTransitionListener", LiveCommonConstants.REASON_ON_DEDTROY, "onPageSelected", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "onPageUnselected", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class TransitionPagerAdapter<T extends TransitionViewHolder> extends RecyclerView.Adapter<T> implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f327748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f327749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<f> f327750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f327751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f327752e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView f327753f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f327754g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f327755h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f327756i;

    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TransitionPagerAdapter<T> f327757a;

        public a(TransitionPagerAdapter<T> r100) {
            this.f327757a = r100;
        }

        @Override // l19.f
        public final void onTransitionBegin(int r100) {
            f r101 = this.f327757a.f327749b;
            if (r101 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("internalTransitionListener");
            r101 = null;
        L6:
            r101.onTransitionBegin(r100);
        }

        @Override // l19.f
        public final void onTransitionEnd(int r100) {
            f r101 = this.f327757a.f327749b;
            if (r101 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("internalTransitionListener");
            r101 = null;
        L6:
            r101.onTransitionEnd(r100);
            if (r100 != 0) goto L10;
            this.f327757a.getClass();
            return;
        }

        @Override // l19.f
        public final void onTransitionChanged(int r100, float r101) {
            f r102 = this.f327757a.f327749b;
            if (r102 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("internalTransitionListener");
            r102 = null;
        L6:
            r102.onTransitionChanged(r100, r101);
        }
    }

    @Override // j19.g
    public void S80(int r100) {
    }

    @Override // j19.g
    public void onPageSelected(int r100) {
    }

    @Override // j19.g
    public final void onPageSelected(int r100, boolean r101) {
    }

    public final RecyclerView getRecyclerView() {
        RecyclerView r100 = this.f327753f;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    public TransitionPagerAdapter() {
        this.f327750c = new ArrayList();
        this.f327754g = new Rect();
        this.f327756i = new a(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f327753f = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        y2((TransitionViewHolder) r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        z2((TransitionViewHolder) r100);
    }

    public void y2(T r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onViewAttachedToWindow(r100);
        Iterator<T> r101 = this.f327750c.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        f r102 = (f) r101.next();
        r100.T3().c(r102);
        goto L4
    L6:
        int r103 = getRecyclerView().getChildAdapterPosition(r100.itemView);
        r100.T3().setPos(r103);
        r100.T3().setRestoreTransitionProvider(this.f327751d);
        r100.T3().setDismissAnimationType(this.f327752e);
        r100.T3().c(this.f327756i);
        if (this.f327748a == false) goto L20;
        this.f327748a = false;
        final TransitionLayout r104 = r100.T3();
        final Rect r105 = this.f327754g;
        b r106 = this.f327755h;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "startRect");
        if (r104.f327732h.isRunning() == true) goto L21;
        r104.f327746v = r106;
        if (r106 == null) goto L14;
        r104.g();
    L14:
        final View r107 = r104.a();
        if (r107 == null) goto L22;
        r107.setAlpha(0.0f);
        r104.post(new l19.e(r104, r105, r107));
        return;
    L22:
        return;
    L21:
        return;
    }

    public void z2(T r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onViewDetachedFromWindow(r100);
        Iterator<T> r101 = this.f327750c.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        f r102 = (f) r101.next();
        r100.T3().e(r102);
        goto L4
    L6:
        r100.T3().e(this.f327756i);
    }
}
