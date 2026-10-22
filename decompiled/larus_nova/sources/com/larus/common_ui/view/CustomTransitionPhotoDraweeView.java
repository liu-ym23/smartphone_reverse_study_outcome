package com.larus.common_ui.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.larus.common_ui.photoviewer.PhotoDraweeView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rB'\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u000eJ\u0010\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0013H\u0016J\u0006\u0010(\u001a\u00020\u0017J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0013H\u0016J\u001a\u0010*\u001a\u00020\u00172\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00170,J\u0010\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020-2\u0006\u00102\u001a\u000203H\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u00104\u001a\u00020\tX\u0096\u000f¢\u0006\f\u001a\u0004\b5\u0010\"\"\u0004\b6\u0010$R\u0018\u00107\u001a\u000208X\u0096\u000f¢\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0018\u0010=\u001a\u00020-X\u0096\u000f¢\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0018\u0010A\u001a\u00020-X\u0096\u000f¢\u0006\f\u001a\u0004\bA\u0010>\"\u0004\bB\u0010@R\u0018\u0010C\u001a\u00020-X\u0096\u000f¢\u0006\f\u001a\u0004\bC\u0010>\"\u0004\bD\u0010@R\u0018\u0010E\u001a\u00020\u001dX\u0096\u000f¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0018\u0010J\u001a\u00020\tX\u0096\u000f¢\u0006\f\u001a\u0004\bK\u0010\"\"\u0004\bL\u0010$R\u001a\u0010M\u001a\u0004\u0018\u00010NX\u0096\u000f¢\u0006\f\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0018\u0010S\u001a\u00020TX\u0096\u000f¢\u0006\f\u001a\u0004\bU\u0010V\"\u0004\bW\u0010X¨\u0006Y"}, d2 = {"Lcom/larus/common_ui/view/CustomTransitionPhotoDraweeView;", "Lcom/larus/common_ui/photoviewer/PhotoDraweeView;", "Lcom/larus/common_ui/photoviewer/transition/TransitionView;", "Lcom/larus/common_ui/photoviewer/transition/ITransitionParams;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "controllerImp", "Lcom/larus/common_ui/view/CustomZoomableControllerImpl;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/larus/common_ui/view/CustomZoomableControllerImpl;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getControllerImp", "()Lcom/larus/common_ui/view/CustomZoomableControllerImpl;", "transitionListeners", "Ljava/util/LinkedHashSet;", "Lcom/larus/common_ui/photoviewer/transition/TransitionListener;", "Lkotlin/collections/LinkedHashSet;", "dismissCallback", "Lkotlin/Function0;", "", "getDismissCallback", "()Lkotlin/jvm/functions/Function0;", "setDismissCallback", "(Lkotlin/jvm/functions/Function0;)V", "dismissOffset", "", "startX", "startY", "slideDirection", "getSlideDirection", "()I", "setSlideDirection", "(I)V", "transitionListenerWrapper", "addTransitionListener", "listener", "dismissAnimated", "removeTransitionListener", "setOnScaleChangeCallback", "callback", "Lkotlin/Function1;", "", "hasScale", "matrix", "Landroid/graphics/Matrix;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "dismissAnimationType", "getDismissAnimationType", "setDismissAnimationType", "enterTransitionStartRect", "Landroid/graphics/Rect;", "getEnterTransitionStartRect", "()Landroid/graphics/Rect;", "setEnterTransitionStartRect", "(Landroid/graphics/Rect;)V", "isDismissAnimatedEnable", "()Z", "setDismissAnimatedEnable", "(Z)V", "isDragTransitionEnabled", "setDragTransitionEnabled", "isSingleTagDismissEnabled", "setSingleTagDismissEnabled", "maxDragTransitionFactor", "getMaxDragTransitionFactor", "()F", "setMaxDragTransitionFactor", "(F)V", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "getPos", "setPos", "restoreTransitionProvider", "Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "getRestoreTransitionProvider", "()Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "setRestoreTransitionProvider", "(Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;)V", "transitionAnimationDuration", "", "getTransitionAnimationDuration", "()J", "setTransitionAnimationDuration", "(J)V", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomTransitionPhotoDraweeView extends PhotoDraweeView implements l19.i, l19.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f328214s = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final s f328215l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedHashSet<l19.f> f328216m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function0<Unit> f328217n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f328218o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f328219p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f328220q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f328221r;

    public CustomTransitionPhotoDraweeView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CustomTransitionPhotoDraweeView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // l19.i
    public final View b() {
        return null;
    }

    @Override // l19.a
    public void setEnterTransitionStartRect(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f328215l.setEnterTransitionStartRect(r100);
    }

    @Override // l19.a
    public int getDismissAnimationType() {
        return this.f328215l.R;
    }

    @Override // l19.a
    public Rect getEnterTransitionStartRect() {
        return this.f328215l.N;
    }

    @Override // l19.a
    public float getMaxDragTransitionFactor() {
        return this.f328215l.I.f496872d;
    }

    @Override // l19.a
    public int getPos() {
        return this.f328215l.Q;
    }

    @Override // l19.a
    public j19.e getRestoreTransitionProvider() {
        return this.f328215l.P;
    }

    @Override // l19.a
    public long getTransitionAnimationDuration() {
        return this.f328215l.K;
    }

    @Override // l19.a
    public final boolean isDragTransitionEnabled() {
        return this.f328215l.L;
    }

    @Override // l19.a
    public final boolean isSingleTagDismissEnabled() {
        return this.f328215l.M;
    }

    public final s getControllerImp() {
        return this.f328215l;
    }

    public final Function0<Unit> getDismissCallback() {
        return this.f328217n;
    }

    public final int getSlideDirection() {
        return this.f328221r;
    }

    @Override // l19.i
    public final void c(l19.f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f328216m.add(r100);
    }

    @Override // l19.i
    public final void e(l19.f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f328216m.remove(r100);
    }

    @Override // com.larus.common_ui.photoviewer.PhotoDraweeView, com.facebook.drawee.view.DraweeView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        boolean r101 = super.onTouchEvent(r100);
        int r102 = r100.getAction();
        if (r102 != 0) goto L5;
        this.f328219p = (int) r100.getX();
        this.f328220q = (int) r100.getY();
    L32:
        return r101;
    L5:
        if (r102 != 2) goto L32;
        int r103 = (int) r100.getX();
        int r104 = (int) r100.getY();
        int r105 = Math.abs(r103 - this.f328219p);
        int r106 = Math.abs(r104 - this.f328220q);
        boolean r107 = false;
        if ((r103 - this.f328219p) <= 0) goto L16;
        if (r105 <= r106) goto L16;
        if (r105 <= this.f328218o) goto L16;
        if (r101 == true) goto L16;
        if (this.f328221r != 1) goto L16;
        boolean r108 = true;
    L18:
        if ((r104 - this.f328220q) <= 0) goto L26;
        if (r106 <= r105) goto L26;
        if (r106 <= this.f328218o) goto L26;
        if (r101 == true) goto L26;
        if (this.f328221r != 0) goto L26;
        r107 = true;
    L26:
        if (r108 == true) goto L28;
        if (r107 == false) goto L32;
    L28:
        Function0<Unit> r109 = this.f328217n;
        if (r109 == null) goto L32;
        r109.invoke();
    L16:
        r108 = false;
        goto L18
    }

    public void setDismissAnimatedEnable(boolean r100) {
        this.f328215l.O = r100;
    }

    @Override // l19.a
    public void setDismissAnimationType(int r100) {
        this.f328215l.R = r100;
    }

    public final void setDismissCallback(Function0<Unit> r100) {
        this.f328217n = r100;
    }

    @Override // l19.a
    public void setDragTransitionEnabled(boolean r100) {
        this.f328215l.L = r100;
    }

    @Override // l19.a
    public void setMaxDragTransitionFactor(float r100) {
        this.f328215l.I.f496872d = r100;
    }

    public final void setOnScaleChangeCallback(final Function1<? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        s r101 = this.f328215l;
        Function1<? super Matrix, Unit> r102 = new o(r100, this);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "listener");
        r101.T = r102;
    }

    @Override // l19.a
    public void setPos(int r100) {
        this.f328215l.Q = r100;
    }

    @Override // l19.a
    public void setRestoreTransitionProvider(j19.e r100) {
        this.f328215l.P = r100;
    }

    @Override // l19.a
    public void setSingleTagDismissEnabled(boolean r100) {
        this.f328215l.M = r100;
    }

    public final void setSlideDirection(int r100) {
        this.f328221r = r100;
    }

    @Override // l19.a
    public void setTransitionAnimationDuration(long r100) {
        this.f328215l.K = r100;
    }

    public CustomTransitionPhotoDraweeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        s r103 = new s(new k19.e(), r100);
        super(r100, r101, r102);
        this.f328215l = r103;
        this.f328216m = new LinkedHashSet();
        this.f328218o = 30.0f;
        this.f328221r = 1;
        r103.c(new p(this));
        setZoomableControllerImp(r103);
        setGestureHandler(new k19.f(r103));
    }

    public /* synthetic */ CustomTransitionPhotoDraweeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
