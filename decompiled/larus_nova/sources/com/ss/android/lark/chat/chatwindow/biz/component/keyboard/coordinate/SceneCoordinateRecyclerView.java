package com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.recyclerview.PointRecoderRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001(B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000bJ\u0012\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0014J\b\u0010 \u001a\u00020\u001bH\u0014J\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0007J\u0018\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J\u0006\u0010&\u001a\u00020'R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/coordinate/SceneCoordinateRecyclerView;", "Lcom/ss/android/lark/widget/recyclerview/PointRecoderRecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isInAnimation", "", "()Z", "setInAnimation", "(Z)V", "interceptAllTouch", "viewLifecycleInterface", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/coordinate/SceneCoordinateRecyclerView$ViewLifecycleInterface;", "getViewLifecycleInterface", "()Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/coordinate/SceneCoordinateRecyclerView$ViewLifecycleInterface;", "setViewLifecycleInterface", "(Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/coordinate/SceneCoordinateRecyclerView$ViewLifecycleInterface;)V", "extraHeight", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "setInterceptAllTouchEvent", "", "intercept", "onInterceptTouchEvent", "e", "onAttachedToWindow", "onDetachedFromWindow", "setExtraHeight", "height", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "computeBlankRegionOfRv", "", "ViewLifecycleInterface", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SceneCoordinateRecyclerView extends PointRecoderRecyclerView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f412074l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f412075m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public a f412076n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f412077o;

    public interface a {
        void onAttachedToWindow();

        void onDetachedFromWindow();
    }

    public SceneCoordinateRecyclerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SceneCoordinateRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.ss.android.lark.widget.recyclerview.CommonRecyclerView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a r100 = this.f412076n;
        if (r100 == null) goto L6;
        r100.onAttachedToWindow();
        return;
    }

    @Override // com.ss.android.lark.widget.recyclerview.CommonRecyclerView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a r100 = this.f412076n;
        if (r100 == null) goto L6;
        r100.onDetachedFromWindow();
        return;
    }

    public final a getViewLifecycleInterface() {
        return this.f412076n;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (this.f412074l == false) goto L9;
        if (Math.abs(getTranslationY()) <= 0.0f) goto L9;
        if (r100 == null) goto L9;
        r100.offsetLocation(0.0f, getTranslationY());
    L9:
        return super.dispatchTouchEvent(r100);
    }

    @Override // com.ss.android.lark.widget.recyclerview.PointRecoderRecyclerView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        boolean r101 = super.onInterceptTouchEvent(r100);
        if (this.f412075m == false) goto L6;
        return true;
    L6:
        return r101;
    }

    public final void setExtraHeight(int r100) {
        this.f412077o = r100;
        requestLayout();
    }

    public final void setInAnimation(boolean r100) {
        this.f412074l = r100;
    }

    public final void setInterceptAllTouchEvent(boolean r100) {
        this.f412075m = r100;
    }

    public final void setViewLifecycleInterface(a r100) {
        this.f412076n = r100;
    }

    @Override // com.ss.android.lark.widget.recyclerview.PointRecoderRecyclerView, androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r101);
        if (this.f412077o <= 0) goto L6;
        if (r102 <= 0) goto L6;
        int r103 = View.MeasureSpec.getMode(r101);
        r101 = View.MeasureSpec.makeMeasureSpec(r102 + this.f412077o, r103);
    L6:
        super.onMeasure(r100, r101);
    }

    public SceneCoordinateRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f448123h = false;
        setTag(SceneCoordinateRecyclerView.class);
    }

    public /* synthetic */ SceneCoordinateRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
