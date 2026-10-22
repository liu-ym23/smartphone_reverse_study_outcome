package com.ss.android.ugc.aweme.search.vision.background.image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.vision.result.panel.PhotoSearchBottomPanelViewModel;
import fua.a;
import fua.b;
import fua.c;
import fua.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0016\u0012\b\u00108\u001a\u0004\u0018\u000107¢\u0006\u0004\b9\u0010:B\u001d\b\u0016\u0012\b\u00108\u001a\u0004\u0018\u000107\u0012\b\u0010<\u001a\u0004\u0018\u00010;¢\u0006\u0004\b9\u0010=B%\b\u0016\u0012\b\u00108\u001a\u0004\u0018\u000107\u0012\b\u0010<\u001a\u0004\u0018\u00010;\u0012\u0006\u0010>\u001a\u00020&¢\u0006\u0004\b9\u0010?J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001b\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001f\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010!\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010#\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\"J\n\u0010$\u001a\u0004\u0018\u00010\u001eH\u0016J\n\u0010%\u001a\u0004\u0018\u00010 H\u0016J\u0018\u0010)\u001a\u00020\b2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0016J\u000e\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u0014J\b\u0010-\u001a\u0004\u0018\u00010,R.\u00106\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010.8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006@"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/background/image/SearchPhotoDraweeView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Lfua/a;", "", "getMinimumScale", "getMediumScale", "getMaximumScale", "minimumScale", "", "setMinimumScale", "mediumScale", "setMediumScale", "maximumScale", "setMaximumScale", "getScale", "scale", "setScale", "", "duration", "setZoomTransitionDuration", "", "allow", "setAllowParentInterceptOnEdge", "Landroid/view/GestureDetector$OnDoubleTapListener;", "listener", "setOnDoubleTapListener", "Lfua/c;", "setOnScaleChangeListener", "Landroid/view/View$OnLongClickListener;", "setOnLongClickListener", "Lfua/b;", "setOnPhotoTapListener", "Lfua/e;", "setOnViewTapListener", "Lcom/ss/android/ugc/aweme/search/vision/background/image/OnViewDragListener;", "setOnViewDragListener", "getOnPhotoTapListener", "getOnViewTapListener", "", "imageInfoWidth", "imageInfoHeight", "update", "canDrag", "setCanDrag", "Lcom/ss/android/ugc/aweme/search/vision/background/image/Attacher;", "getAttacher", "Lcom/ss/android/ugc/aweme/search/vision/result/panel/PhotoSearchBottomPanelViewModel;", "value", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/ss/android/ugc/aweme/search/vision/result/panel/PhotoSearchBottomPanelViewModel;", "getMBottomPanelViewModel", "()Lcom/ss/android/ugc/aweme/search/vision/result/panel/PhotoSearchBottomPanelViewModel;", "setMBottomPanelViewModel", "(Lcom/ss/android/ugc/aweme/search/vision/result/panel/PhotoSearchBottomPanelViewModel;)V", "mBottomPanelViewModel", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class SearchPhotoDraweeView extends SimpleDraweeView implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PhotoSearchBottomPanelViewModel f453478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Attacher f453479b;

    public b getOnPhotoTapListener() {
        return null;
    }

    public e getOnViewTapListener() {
        return null;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener r100) {
    }

    public void setOnPhotoTapListener(b r100) {
    }

    public void setOnScaleChangeListener(c r100) {
    }

    public void setOnViewTapListener(e r100) {
    }

    public final void f() {
        Attacher r100 = this.f453479b;
        if (r100 == null) goto L8;
        if (r100 == null) goto L6;
        DraweeView<GenericDraweeHierarchy> r101 = r100.f();
    L7:
        if (r101 == null) goto L8;
        return;
    L6:
        r101 = null;
    L8:
        this.f453479b = new Attacher(this);
    }

    public float getMaximumScale() {
        Attacher r100 = this.f453479b;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.f453440g;
    }

    public float getMediumScale() {
        Attacher r100 = this.f453479b;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.f453439f;
    }

    public float getMinimumScale() {
        Attacher r100 = this.f453479b;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.f453438e;
    }

    public float getScale() {
        Attacher r100 = this.f453479b;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.f453437d;
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        f();
        super.onAttachedToWindow();
    }

    public final Attacher getAttacher() {
        return this.f453479b;
    }

    public final PhotoSearchBottomPanelViewModel getMBottomPanelViewModel() {
        return this.f453478a;
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public SearchPhotoDraweeView(Context r100) {
        super(r100);
        f();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        int r101 = r100.save();
        Attacher r102 = this.f453479b;
        if (r102 == null) goto L8;
        if (r102 == null) goto L6;
        Matrix r103 = r102.f453447n;
    L7:
        r100.concat(r103);
        goto L8
    L6:
        r103 = null;
    L8:
        super.onDraw(r100);
        r100.restoreToCount(r101);
    }

    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        PhotoSearchBottomPanelViewModel r101 = this.f453478a;
        if (r101 != null) goto L5;
    L6:
        PhotoSearchBottomPanelViewModel r102 = this.f453478a;
        if (r102 != null) goto L9;
    L10:
        PhotoSearchBottomPanelViewModel r103 = this.f453478a;
        if (r103 == null) goto L17;
        if (r103.getBottomStatus() != 7) goto L17;
    L14:
        getParent().requestDisallowInterceptTouchEvent(false);
        return false;
    L17:
        if (r100.getAction() != 0) goto L30;
        PhotoSearchBottomPanelViewModel r104 = this.f453478a;
        if (r104 == null) goto L30;
        if (r104.getBottomStatus() != 5) goto L30;
        PhotoSearchBottomPanelViewModel r105 = this.f453478a;
        if (r105 == null) goto L25;
        boolean r106 = r105.isPointAtIndicatorRectF(getContext(), r100);
    L26:
        if (r106 == false) goto L30;
        getParent().requestDisallowInterceptTouchEvent(false);
        return false;
    L25:
        r106 = false;
    L30:
        return super.onTouchEvent(r100);
    L9:
        if (r102.getBottomStatus() == 4) goto L14;
    L5:
        if (r101.getBottomStatus() == 3) goto L14;
        goto L6
    }

    public void setAllowParentInterceptOnEdge(boolean r100) {
        Attacher r101 = this.f453479b;
        if (r101 == null) goto L6;
        r101.f453445l = r100;
        return;
    }

    public final void setCanDrag(boolean r100) {
        Attacher r101 = this.f453479b;
        if (r101 == null) goto L6;
        r101.f453455v = r100;
        return;
    }

    public final void setMBottomPanelViewModel(PhotoSearchBottomPanelViewModel r100) {
        this.f453478a = r100;
        Attacher r101 = this.f453479b;
        if (r101 == null) goto L6;
        r101.f453451r = r100;
        return;
    }

    public void setMaximumScale(float r100) {
        Attacher r101 = this.f453479b;
        if (r101 == null) goto L6;
        Attacher.d(r101.f453438e, r101.f453439f, r100);
        r101.f453440g = r100;
        return;
    }

    public void setMediumScale(float r100) {
        Attacher r101 = this.f453479b;
        if (r101 == null) goto L6;
        Attacher.d(r101.f453438e, r100, r101.f453440g);
        r101.f453439f = r100;
        return;
    }

    public void setMinimumScale(float r100) {
        Attacher r101 = this.f453479b;
        if (r101 == null) goto L6;
        Attacher.d(r100, r101.f453439f, r101.f453440g);
        r101.f453438e = r100;
        return;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r100) {
        Attacher r101 = this.f453479b;
        if (r101 == null) goto L6;
        r101.f453452s = r100;
        return;
    }

    public final void setOnViewDragListener(OnViewDragListener r100) {
        Attacher r101 = this.f453479b;
        if (r101 == null) goto L6;
        r101.f453453t = r100;
        return;
    }

    public void setScale(float r100) {
        Attacher r101 = this.f453479b;
        if (r101 == null) goto L15;
        DraweeView<GenericDraweeHierarchy> r102 = r101.f();
        if (r102 == null) goto L16;
        float r103 = r102.getRight() / 2;
        float r104 = r102.getBottom() / 2;
        if (r101.f() != null) goto L9;
        return;
    L9:
        if (r100 >= r101.f453438e) goto L11;
        return;
    L11:
        if (r100 > r101.f453440g) goto L19;
        r101.f453447n.setScale(r100, r100, r103, r104);
        r101.b();
        return;
    L19:
        return;
    L16:
        return;
    }

    public void setZoomTransitionDuration(long r100) {
        Attacher r101 = this.f453479b;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 >= 0) goto L7;
        r100 = 200;
    L7:
        r101.f453441h = r100;
    }

    public SearchPhotoDraweeView(Context r100, AttributeSet r101) {
        super(r100, r101);
        f();
    }

    @Override // fua.a
    public void update(int r100, int r101) {
        Attacher r102 = this.f453479b;
        if (r102 == null) goto L6;
        r102.update(r100, r101);
        return;
    }

    public SearchPhotoDraweeView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        f();
    }
}
