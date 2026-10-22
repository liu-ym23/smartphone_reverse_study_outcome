package com.larksuite.component.ui.layout;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.larksuite.component.ui.layout.plus.BaseInnerPlus;
import com.larksuite.component.ui.layout.plus.InnerPlusType;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0016J%\u0010\u0019\u001a\u0002H\u001a\"\b\b\u0000\u0010\u001a*\u00020\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001cH\u0016¢\u0006\u0002\u0010\u001dJ \u0010\u001e\u001a\u00020\u000f\"\b\b\u0000\u0010\u001a*\u00020\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001cH\u0016J'\u0010\u001f\u001a\u0004\u0018\u0001H\u001a\"\b\b\u0000\u0010\u001a*\u00020\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001cH\u0016¢\u0006\u0002\u0010\u001dJ\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010/\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020,H\u0016J\u0017\u00100\u001a\u0004\u0018\u00010!2\u0006\u00101\u001a\u000202H\u0016¢\u0006\u0002\u00103J\u0017\u00104\u001a\u0004\u0018\u00010!2\u0006\u00101\u001a\u000202H\u0016¢\u0006\u0002\u00103J\u0017\u00105\u001a\u0004\u0018\u00010!2\u0006\u00106\u001a\u000202H\u0016¢\u0006\u0002\u00103J\u0017\u00107\u001a\u0004\u0018\u00010!2\u0006\u00106\u001a\u000202H\u0016¢\u0006\u0002\u00103J\u0017\u00108\u001a\u0004\u0018\u00010!2\u0006\u00106\u001a\u000209H\u0016¢\u0006\u0002\u0010:J\b\u0010;\u001a\u00020\u000fH\u0016J\b\u0010<\u001a\u00020\u000fH\u0016J\b\u0010=\u001a\u00020\u000fH\u0016J\"\u0010>\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020!2\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u0010\u0010D\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020FH\u0016J(\u0010G\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020A2\u0006\u0010I\u001a\u00020A2\u0006\u0010J\u001a\u00020A2\u0006\u0010K\u001a\u00020AH\u0016J\u0010\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020CH\u0016J\u0010\u0010N\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020CH\u0016J\b\u0010O\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/larksuite/component/ui/layout/LKUILayoutDispatcher;", "Lcom/larksuite/component/ui/layout/ILKUILayout;", "<init>", "()V", "mLayout", "Landroid/view/ViewGroup;", "mContext", "Landroid/content/Context;", "mAttrs", "Landroid/util/AttributeSet;", "mPlusList", "Ljava/util/ArrayList;", "Lcom/larksuite/component/ui/layout/plus/BaseLKUIPlus;", "Lkotlin/collections/ArrayList;", "onConstructor", "", "layout", PerfLog.PARAM_KEY_CONTEXT_ID, "attrs", "parseInnerPluses", "array", "Landroid/content/res/TypedArray;", "getLayout", "getLKUIContext", "getAttrs", "registerPlus", ExifInterface.GPS_DIRECTION_TRUE, "plusClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/larksuite/component/ui/layout/plus/BaseLKUIPlus;", "unRegisterPlus", "getPlus", "hasPlus", "", "onDelegateMeasureStart", "onMeasureData", "Lcom/larksuite/component/ui/layout/OnMeasureData;", "onDelegateMeasureEnd", "onDelegateLayoutStart", "onLayoutData", "Lcom/larksuite/component/ui/layout/OnLayoutData;", "onDelegateLayoutEnd", "onDelegateDrawStart", "canvas", "Landroid/graphics/Canvas;", "onDelegateDrawEnd", "onDelegateDispatchDrawStart", "onDelegateDispatchDrawEnd", "onDelegateDispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "(Landroid/view/MotionEvent;)Ljava/lang/Boolean;", "onDelegateInterceptTouchEvent", "onDelegateTouchEvent", "event", "onDelegateInterceptHoverEvent", "onDelegateDragEvent", "Landroid/view/DragEvent;", "(Landroid/view/DragEvent;)Ljava/lang/Boolean;", "onDelegateAttachedToWindow", "onDelegateDetachedFromWindow", "onDelegateFinishInflate", "onDelegateFocusChanged", "gainFocus", "direction", "", "previouslyFocusedRect", "Landroid/graphics/Rect;", "onDelegateConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDelegateSizeChanged", "w", "h", "oldw", "oldh", "onDelegateSetPaddingStart", "paddingData", "onDelegateSetPaddingEnd", "onDelegateComputeScroll", "suite-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LKUILayoutDispatcher implements ILKUILayout {
    private AttributeSet mAttrs;
    private Context mContext;
    private ViewGroup mLayout;
    private final ArrayList<com.larksuite.component.ui.layout.plus.a> mPlusList;

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public Context getLKUIContext() {
        Context r100 = this.mContext;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        return null;
    L6:
        return r100;
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public ViewGroup getLayout() {
        ViewGroup r100 = this.mLayout;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mLayout");
        return null;
    L6:
        return r100;
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public boolean hasPlus() {
        if (this.mPlusList.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateAttachedToWindow() {
        Iterator<com.larksuite.component.ui.layout.plus.a> r100 = this.mPlusList.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onDelegateAttachedToWindow();
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateComputeScroll() {
        Iterator<com.larksuite.component.ui.layout.plus.a> r100 = this.mPlusList.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onDelegateComputeScroll();
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateDetachedFromWindow() {
        Iterator<com.larksuite.component.ui.layout.plus.a> r100 = this.mPlusList.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onDelegateDetachedFromWindow();
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateFinishInflate() {
        Iterator<com.larksuite.component.ui.layout.plus.a> r100 = this.mPlusList.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onDelegateFinishInflate();
        goto L4
    }

    public LKUILayoutDispatcher() {
        this.mPlusList = new ArrayList();
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public AttributeSet getAttrs() {
        return this.mAttrs;
    }

    private final void parseInnerPluses(TypedArray r100) {
        int r101 = 0;
        int r102 = r100.getInt(0, InnerPlusType.UNKNOWN.getValue());
        ArrayList<com.larksuite.component.ui.layout.plus.a> r103 = this.mPlusList;
        int r104 = com.larksuite.component.ui.layout.plus.b.f284237a;
        Intrinsics.checkNotNullParameter(this, "layout");
        ArrayList r105 = new ArrayList();
        InnerPlusType[] r106 = InnerPlusType.values();
        int r107 = r106.length;
    L3:
        if (r101 >= r107) goto L10;
        InnerPlusType r108 = r106[r101];
        int r109 = r108.getValue();
        if ((r102 & r109) != r109) goto L9;
        BaseInnerPlus r110 = r108.createPlus(this);
        if (r110 == null) goto L9;
        r105.add(r110);
    L9:
        r101 = r101 + 1;
        goto L3
    L10:
        r103.addAll(r105);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public <T extends com.larksuite.component.ui.layout.plus.a> T getPlus(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "plusClass");
        Iterator<com.larksuite.component.ui.layout.plus.a> r101 = this.mPlusList.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        T r102 = (T) r101.next();
        if (Intrinsics.areEqual(r102.getClass(), r100) == false) goto L4;
        return r102;
    L8:
        return null;
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        Iterator<com.larksuite.component.ui.layout.plus.a> r101 = this.mPlusList.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onDelegateConfigurationChanged(r100);
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateDispatchDrawEnd(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Iterator<com.larksuite.component.ui.layout.plus.a> r101 = this.mPlusList.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onDelegateDispatchDrawEnd(r100);
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateDispatchDrawStart(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Iterator<com.larksuite.component.ui.layout.plus.a> r101 = this.mPlusList.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onDelegateDispatchDrawStart(r100);
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public Boolean onDelegateDispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        Iterator<com.larksuite.component.ui.layout.plus.a> r101 = this.mPlusList.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Boolean r102 = r101.next().onDelegateDispatchTouchEvent(r100);
        if (r102 == null) goto L4;
        return r102;
    L8:
        return null;
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public Boolean onDelegateDragEvent(DragEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Iterator<com.larksuite.component.ui.layout.plus.a> r101 = this.mPlusList.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Boolean r102 = r101.next().onDelegateDragEvent(r100);
        if (r102 == null) goto L4;
        return r102;
    L8:
        return null;
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateDrawEnd(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Iterator<com.larksuite.component.ui.layout.plus.a> r101 = this.mPlusList.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onDelegateDrawEnd(r100);
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateDrawStart(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Iterator<com.larksuite.component.ui.layout.plus.a> r101 = this.mPlusList.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onDelegateDrawStart(r100);
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public Boolean onDelegateInterceptHoverEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Iterator<com.larksuite.component.ui.layout.plus.a> r101 = this.mPlusList.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Boolean r102 = r101.next().onDelegateInterceptHoverEvent(r100);
        if (r102 == null) goto L4;
        return r102;
    L8:
        return null;
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public Boolean onDelegateInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        Iterator<com.larksuite.component.ui.layout.plus.a> r101 = this.mPlusList.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Boolean r102 = r101.next().onDelegateInterceptTouchEvent(r100);
        if (r102 == null) goto L4;
        return r102;
    L8:
        return null;
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateLayoutEnd(c r100) {
        Intrinsics.checkNotNullParameter(r100, "onLayoutData");
        Iterator<com.larksuite.component.ui.layout.plus.a> r101 = this.mPlusList.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onDelegateLayoutEnd(r100);
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateLayoutStart(c r100) {
        Intrinsics.checkNotNullParameter(r100, "onLayoutData");
        Iterator<com.larksuite.component.ui.layout.plus.a> r101 = this.mPlusList.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onDelegateLayoutStart(r100);
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateMeasureEnd(d r100) {
        Intrinsics.checkNotNullParameter(r100, "onMeasureData");
        Iterator<com.larksuite.component.ui.layout.plus.a> r101 = this.mPlusList.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onDelegateMeasureEnd(r100);
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateMeasureStart(d r100) {
        Intrinsics.checkNotNullParameter(r100, "onMeasureData");
        Iterator<com.larksuite.component.ui.layout.plus.a> r101 = this.mPlusList.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onDelegateMeasureStart(r100);
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateSetPaddingEnd(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "paddingData");
        Iterator<com.larksuite.component.ui.layout.plus.a> r101 = this.mPlusList.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onDelegateSetPaddingEnd(r100);
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateSetPaddingStart(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "paddingData");
        Iterator<com.larksuite.component.ui.layout.plus.a> r101 = this.mPlusList.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onDelegateSetPaddingStart(r100);
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public Boolean onDelegateTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Iterator<com.larksuite.component.ui.layout.plus.a> r101 = this.mPlusList.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Boolean r102 = r101.next().onDelegateTouchEvent(r100);
        if (r102 == null) goto L4;
        return r102;
    L8:
        return null;
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public <T extends com.larksuite.component.ui.layout.plus.a> T registerPlus(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "plusClass");
        T r101 = (T) getPlus(r100);
        if (r101 != null) goto L5;
        r101 = r100.getDeclaredConstructor(new Class[]{ILKUILayout.class}).newInstance(new Object[]{this});
        this.mPlusList.add(r101);
    L5:
        Intrinsics.checkNotNull(r101);
        return r101;
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public <T extends com.larksuite.component.ui.layout.plus.a> void unRegisterPlus(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "plusClass");
        Iterator<com.larksuite.component.ui.layout.plus.a> r101 = this.mPlusList.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (Intrinsics.areEqual(r101.next().getClass(), r100) == false) goto L4;
        r101.remove();
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onConstructor(ViewGroup r100, Context r101, AttributeSet r102) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.mLayout = r100;
        this.mContext = r101;
        this.mAttrs = r102;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        r101 = null;
    L5:
        TypedArray r103 = r101.obtainStyledAttributes(r102, new int[]{R.attr.pluses}, 0, 0);
        parseInnerPluses(r103);
        r103.recycle();
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateFocusChanged(boolean r100, int r101, Rect r102) {
        Iterator<com.larksuite.component.ui.layout.plus.a> r103 = this.mPlusList.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().onDelegateFocusChanged(r100, r101, r102);
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateSizeChanged(int r100, int r101, int r102, int r103) {
        Iterator<com.larksuite.component.ui.layout.plus.a> r104 = this.mPlusList.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r104.next().onDelegateSizeChanged(r100, r101, r102, r103);
        goto L4
    }
}
