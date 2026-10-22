package com.larus.commercecredit.impl.page.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001dB\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J%\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0002\u0010\u0018J%\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0002\u0010\u001cR\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/commercecredit/impl/page/behavior/BottomSheetDialogWebViewBehavior;", "V", "Landroid/view/View;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "webViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/webkit/WebView;", "initialX", "", "initialY", "findWebView", "parent", "onLayoutChild", "", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "layoutDirection", "", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;I)Z", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/MotionEvent;)Z", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BottomSheetDialogWebViewBehavior<V extends View> extends BottomSheetBehavior<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f325754d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<WebView> f325755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f325756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f325757c;

    public static final class a {
    }

    static {
    }

    public BottomSheetDialogWebViewBehavior(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "event");
        WeakReference<WebView> r103 = this.f325755a;
        if (r103 == null) goto L30;
        WebView r104 = r103.get();
        if (r104 == null) goto L30;
        int r105 = r102.getActionMasked();
        if (r105 != 0) goto L10;
        this.f325756b = r102.getX();
        this.f325757c = r102.getY();
    L28:
        return super.onInterceptTouchEvent(r100, r101, r102);
    L10:
        if (r105 != 1) goto L12;
    L25:
        this.f325756b = 0.0f;
        this.f325757c = 0.0f;
        goto L28
    L12:
        if (r105 == 2) goto L17;
        if (r105 == 3) goto L25;
    L17:
        if (Math.abs(r102.getX() - this.f325756b) <= Math.abs(r102.getY() - this.f325757c)) goto L19;
        return false;
    L19:
        Object r106 = r104.getTag(R.id.tag_web_view_scroll_top);
        if (r106 != null) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(r106, Boolean.TRUE) == true) goto L24;
        return false;
    L24:
        return super.onInterceptTouchEvent(r100, r101, r102);
    L30:
        return super.onInterceptTouchEvent(r100, r101, r102);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout r100, V r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        boolean r103 = super.onLayoutChild(r100, r101, r102);
        ArrayDeque r104 = new ArrayDeque();
        r104.add(r101);
    L4:
        if ((!r104.isEmpty()) == false) goto L14;
        View r105 = (View) r104.removeFirst();
        if ((r105 instanceof WebView) == true) goto L7;
        if ((r105 instanceof ViewGroup) == false) goto L4;
        ViewGroup r106 = (ViewGroup) r105;
        Iterator<Integer> r107 = RangesKt.until(0, r106.getChildCount()).iterator();
    L12:
        if (r107.hasNext() == false) goto L4;
        r104.add(r106.getChildAt(((IntIterator) r107).nextInt()));
        goto L12
    L7:
        WebView r108 = (WebView) r105;
    L15:
        this.f325755a = new WeakReference(r108);
        return r103;
    L14:
        r108 = null;
        goto L15
    }
}
