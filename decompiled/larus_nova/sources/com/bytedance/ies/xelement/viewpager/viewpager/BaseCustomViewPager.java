package com.bytedance.ies.xelement.viewpager.viewpager;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ies.xelement.viewpager.Pager;
import com.bytedance.ies.xelement.viewpager.ReversingAdapter;
import com.lynx.tasm.base.LLog;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010<\u001a\u00020;¢\u0006\u0004\b=\u0010>J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0004J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rR\"\u0010\u0016\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010*\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\"\u00101\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001d\u00107\u001a\b\u0012\u0002\b\u0003\u0018\u0001028\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\"\u00109\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0011\u001a\u0004\b9\u0010\u0013\"\u0004\b:\u0010\u0015¨\u0006?"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/viewpager/BaseCustomViewPager;", "Landroidx/viewpager/widget/ViewPager;", "Ljava/lang/reflect/Field;", "getIsUnableToDrag", "", "getCurrentItem", "Landroidx/viewpager/widget/PagerAdapter;", "adapter", "", "setAdapter", "getAdapter", "Lcom/bytedance/ies/xelement/viewpager/ReversingAdapter;", "getReversingAdapter", "", "rtlMode", "setRTL", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getMAllowHorizontalGesture", "()Z", "setMAllowHorizontalGesture", "(Z)V", "mAllowHorizontalGesture", "Lcom/bytedance/ies/xelement/viewpager/Pager$g;", "b", "Lcom/bytedance/ies/xelement/viewpager/Pager$g;", "getMInterceptTouchEventListener", "()Lcom/bytedance/ies/xelement/viewpager/Pager$g;", "setMInterceptTouchEventListener", "(Lcom/bytedance/ies/xelement/viewpager/Pager$g;)V", "mInterceptTouchEventListener", "", "c", FaceService.girlLabel, "getMLastMotionX", "()F", "setMLastMotionX", "(F)V", "mLastMotionX", "d", "getMLastMotionY", "setMLastMotionY", "mLastMotionY", "e", "I", "getMActivePointerId", "()I", "setMActivePointerId", "(I)V", "mActivePointerId", "Ljava/lang/Class;", "f", "Ljava/lang/Class;", "getSuperclass", "()Ljava/lang/Class;", "superclass", ce.f26391f, "isRTLMode", "setRTLMode", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0})
public class BaseCustomViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f250585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Pager.g f250586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f250587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f250588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f250589e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Class<?> f250590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f250591g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap<ViewPager.OnPageChangeListener, ReversingOnPageChangeListener> f250592h;

    public final Field getIsUnableToDrag() {
        Class<?> r100 = this.f250590f;     // Catch: NoSuchFieldException -> L7
        if (r100 == null) goto L11;
        return r100.getDeclaredField("mIsUnableToDrag");
    L11:
        return null;
    L7:
        LLog.e("Foldview#BaseViewPagerImpl", "no such field mIsUnableToDrag");
        return null;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public PagerAdapter getAdapter() {
        ReversingAdapter r100 = (ReversingAdapter) super.getAdapter();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f250497a;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public int getCurrentItem() {
        int r100 = super.getCurrentItem();
        PagerAdapter r101 = super.getAdapter();
        if (r101 != null) goto L5;
        return r100;
    L5:
        if (this.f250591g == true) goto L7;
        return r100;
    L7:
        return (r101.getCount() - r100) - 1;
    }

    public final ReversingAdapter getReversingAdapter() {
        PagerAdapter r100 = super.getAdapter();
        if ((r100 instanceof ReversingAdapter) == true) goto L7;
        return null;
    L7:
        return (ReversingAdapter) r100;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Class<?> r100 = this.f250590f;     // Catch: Throwable -> L13
        if (r100 == null) goto L6;
        Method r101 = r100.getDeclaredMethod("populate", new Class[0]);     // Catch: Throwable -> L13
    L7:
        if (r101 == null) goto L10;
        r101.setAccessible(true);     // Catch: Throwable -> L13
    L10:
        if (r101 == null) goto L17;
        r101.invoke(this, new Object[0]);     // Catch: Throwable -> L13
        return;
    L17:
        return;
    L6:
        r101 = null;
    L13:
        LLog.e("Foldview#BaseViewPagerImpl", "populate failed");
        requestLayout();
    }

    public final int getMActivePointerId() {
        return this.f250589e;
    }

    public final boolean getMAllowHorizontalGesture() {
        return this.f250585a;
    }

    public final Pager.g getMInterceptTouchEventListener() {
        return this.f250586b;
    }

    public final float getMLastMotionX() {
        return this.f250587c;
    }

    public final float getMLastMotionY() {
        return this.f250588d;
    }

    public final Class<?> getSuperclass() {
        return this.f250590f;
    }

    public BaseCustomViewPager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
        this.f250585a = true;
        this.f250589e = -1;
        Class<? super Object> r101 = getClass().getSuperclass();
        if (r101 == null) goto L5;
        Class<? super Object> r102 = r101.getSuperclass();
    L6:
        this.f250590f = r102;
        this.f250592h = new HashMap();
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void addOnPageChangeListener(ViewPager.OnPageChangeListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ReversingOnPageChangeListener r101 = new ReversingOnPageChangeListener(r100, this, super.getAdapter());
        this.f250592h.put(r100, r101);
        super.addOnPageChangeListener(r101);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int r100) {
        if (this.f250585a == true) goto L6;
        return false;
    L6:
        return super.canScrollHorizontally(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        return super.dispatchTouchEvent(r100);
    L4:
        e = move-exception;
        LLog.e("Foldview#BaseViewPagerImpl", e.toString());
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void removeOnPageChangeListener(ViewPager.OnPageChangeListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ReversingOnPageChangeListener r101 = this.f250592h.remove(r100);
        if (r101 == null) goto L6;
        super.removeOnPageChangeListener(r101);
        return;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter r100) {
        if (r100 == null) goto L4;
        r100 = new ReversingAdapter(r100);
    L4:
        super.setAdapter(r100);
    }

    public final void setMActivePointerId(int r100) {
        this.f250589e = r100;
    }

    public final void setMAllowHorizontalGesture(boolean r100) {
        this.f250585a = r100;
    }

    public final void setMInterceptTouchEventListener(Pager.g r100) {
        this.f250586b = r100;
    }

    public final void setMLastMotionX(float r100) {
        this.f250587c = r100;
    }

    public final void setMLastMotionY(float r100) {
        this.f250588d = r100;
    }

    public final void setRTL(boolean r100) {
        this.f250591g = r100;
    }

    public final void setRTLMode(boolean r100) {
        this.f250591g = r100;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final boolean canScroll(View r100, boolean r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "childView");
        if ((r100 instanceof BaseCustomViewPager) == false) goto L11;
        if (super.canScroll(r100, r101, r102, r103, r104) == true) goto L7;
    L9:
        return false;
    L7:
        if (((BaseCustomViewPager) r100).f250585a == false) goto L9;
        return true;
    L11:
        return super.canScroll(r100, r101, r102, r103, r104);
    }
}
