package com.larus.common_ui.photoviewer.transition;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.larus.common_ui.photoviewer.PhotoDraweeView;
import com.ss.android.lark.utils.statistics.PerfLog;
import j19.e;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l19.a;
import l19.f;
import l19.g;
import l19.i;
import l19.l;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rB'\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u000eJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0006\u0010\u0016\u001a\u00020\u0014J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\u00020\tX\u0096\u000f¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u00020\u001eX\u0096\u000f¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0018\u0010#\u001a\u00020$X\u0096\u000f¢\u0006\f\u001a\u0004\b#\u0010%\"\u0004\b&\u0010'R\u0018\u0010(\u001a\u00020$X\u0096\u000f¢\u0006\f\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R\u0018\u0010*\u001a\u00020$X\u0096\u000f¢\u0006\f\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\u0018\u0010,\u001a\u00020-X\u0096\u000f¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0018\u00102\u001a\u00020\tX\u0096\u000f¢\u0006\f\u001a\u0004\b3\u0010\u001a\"\u0004\b4\u0010\u001cR\u001a\u00105\u001a\u0004\u0018\u000106X\u0096\u000f¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0018\u0010;\u001a\u00020<X\u0096\u000f¢\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006A"}, d2 = {"Lcom/larus/common_ui/photoviewer/transition/TransitionPhotoDraweeView;", "Lcom/larus/common_ui/photoviewer/PhotoDraweeView;", "Lcom/larus/common_ui/photoviewer/transition/TransitionView;", "Lcom/larus/common_ui/photoviewer/transition/ITransitionParams;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "controllerImp", "Lcom/larus/common_ui/photoviewer/transition/TransitionZoomableControllerImp;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/larus/common_ui/photoviewer/transition/TransitionZoomableControllerImp;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "transitionListeners", "Ljava/util/LinkedHashSet;", "Lcom/larus/common_ui/photoviewer/transition/TransitionListener;", "transitionListenerWrapper", "addTransitionListener", "", "listener", "dismissAnimated", "removeTransitionListener", "dismissAnimationType", "getDismissAnimationType", "()I", "setDismissAnimationType", "(I)V", "enterTransitionStartRect", "Landroid/graphics/Rect;", "getEnterTransitionStartRect", "()Landroid/graphics/Rect;", "setEnterTransitionStartRect", "(Landroid/graphics/Rect;)V", "isDismissAnimatedEnable", "", "()Z", "setDismissAnimatedEnable", "(Z)V", "isDragTransitionEnabled", "setDragTransitionEnabled", "isSingleTagDismissEnabled", "setSingleTagDismissEnabled", "maxDragTransitionFactor", "", "getMaxDragTransitionFactor", "()F", "setMaxDragTransitionFactor", "(F)V", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "getPos", "setPos", "restoreTransitionProvider", "Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "getRestoreTransitionProvider", "()Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "setRestoreTransitionProvider", "(Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;)V", "transitionAnimationDuration", "", "getTransitionAnimationDuration", "()J", "setTransitionAnimationDuration", "(J)V", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TransitionPhotoDraweeView extends PhotoDraweeView implements i, a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final l f327758l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedHashSet<f> f327759m;

    public TransitionPhotoDraweeView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TransitionPhotoDraweeView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // l19.i
    public final View b() {
        return null;
    }

    @Override // l19.a
    public final boolean isSingleTagDismissEnabled() {
        return this.f327758l.isSingleTagDismissEnabled();
    }

    public void setDismissAnimatedEnable(boolean r100) {
        this.f327758l.B(r100);
    }

    @Override // l19.a
    public void setEnterTransitionStartRect(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f327758l.setEnterTransitionStartRect(r100);
    }

    @Override // l19.a
    public void setSingleTagDismissEnabled(boolean r100) {
        this.f327758l.setSingleTagDismissEnabled(r100);
    }

    @Override // l19.a
    public int getDismissAnimationType() {
        return this.f327758l.R;
    }

    @Override // l19.a
    public Rect getEnterTransitionStartRect() {
        return this.f327758l.N;
    }

    @Override // l19.a
    public float getMaxDragTransitionFactor() {
        return this.f327758l.I.f496872d;
    }

    @Override // l19.a
    public int getPos() {
        return this.f327758l.Q;
    }

    @Override // l19.a
    public e getRestoreTransitionProvider() {
        return this.f327758l.P;
    }

    @Override // l19.a
    public long getTransitionAnimationDuration() {
        return this.f327758l.K;
    }

    @Override // l19.a
    public final boolean isDragTransitionEnabled() {
        return this.f327758l.L;
    }

    @Override // l19.i
    public final void c(f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f327759m.add(r100);
    }

    @Override // l19.i
    public final void e(f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f327759m.remove(r100);
    }

    @Override // l19.a
    public void setDismissAnimationType(int r100) {
        this.f327758l.R = r100;
    }

    @Override // l19.a
    public void setDragTransitionEnabled(boolean r100) {
        this.f327758l.L = r100;
    }

    @Override // l19.a
    public void setMaxDragTransitionFactor(float r100) {
        this.f327758l.I.f496872d = r100;
    }

    @Override // l19.a
    public void setPos(int r100) {
        this.f327758l.Q = r100;
    }

    @Override // l19.a
    public void setRestoreTransitionProvider(e r100) {
        this.f327758l.P = r100;
    }

    @Override // l19.a
    public void setTransitionAnimationDuration(long r100) {
        this.f327758l.K = r100;
    }

    public TransitionPhotoDraweeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        l r103 = new l(new k19.e(), r100);
        super(r100, r101, r102);
        this.f327758l = r103;
        this.f327759m = new LinkedHashSet();
        r103.c(new g(this));
        setZoomableControllerImp(r103);
        setGestureHandler(new k19.f(r103));
    }

    public /* synthetic */ TransitionPhotoDraweeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
