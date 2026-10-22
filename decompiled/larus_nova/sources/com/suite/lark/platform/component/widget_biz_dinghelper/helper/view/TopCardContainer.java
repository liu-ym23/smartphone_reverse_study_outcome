package com.suite.lark.platform.component.widget_biz_dinghelper.helper.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001+B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ$\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00132\u0006\u0010!\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010$\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010'\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\n\u0010(\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010)\u001a\u00020\u001fH\u0002J\b\u0010*\u001a\u00020\u001fH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006,"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_dinghelper/helper/view/TopCardContainer;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "downY", "", "startScrollY", "touchSlop", "getTouchSlop", "()I", "touchSlop$delegate", "Lkotlin/Lazy;", "draggingView", "Landroid/view/View;", "ignoreTouchEvent", "", "draggingAnimator", "Landroid/view/ViewPropertyAnimator;", "onTopCardMoveOutListener", "Lcom/suite/lark/platform/component/widget_biz_dinghelper/helper/view/TopCardContainer$OnTopCardMoveOutListener;", "getOnTopCardMoveOutListener", "()Lcom/suite/lark/platform/component/widget_biz_dinghelper/helper/view/TopCardContainer$OnTopCardMoveOutListener;", "setOnTopCardMoveOutListener", "(Lcom/suite/lark/platform/component/widget_biz_dinghelper/helper/view/TopCardContainer$OnTopCardMoveOutListener;)V", "addView", "", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "captureView", "removeDraggingView", "settleDraggingView", "OnTopCardMoveOutListener", "widget-biz-dinghelper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TopCardContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f460869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f460870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f460871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f460872d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f460873e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewPropertyAnimator f460874f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f460875g;

    public interface a {
        void a();
    }

    public TopCardContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TopCardContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final int getTouchSlop() {
        return ((Number) this.f460871c.getValue()).intValue();
    }

    public final a getOnTopCardMoveOutListener() {
        return this.f460875g;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L23;
        int r101 = r100.getActionMasked();
        if (getChildCount() != 0) goto L8;
        return false;
    L8:
        if (r101 != 0) goto L10;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f460869a = r100.getY();
        this.f460873e = false;
        return false;
    L10:
        if (r101 != 2) goto L27;
        float r102 = r100.getY();
        if ((this.f460869a - r102) <= getTouchSlop()) goto L24;
        this.f460870b = r102;
        if (getChildCount() != 0) goto L17;
        View r103 = null;
    L18:
        this.f460872d = r103;
        if (r103 == null) goto L25;
        return true;
    L25:
        return false;
    L17:
        r103 = getChildAt(getChildCount() - 1);
        goto L18
    L24:
        return false;
    L27:
        return false;
    L23:
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L28;
        int r101 = r100.getActionMasked();
        View r102 = this.f460872d;
        if (r102 != null) goto L8;
        return false;
    L8:
        if (this.f460873e == false) goto L11;
        return false;
    L11:
        if (r101 == 1) goto L18;
        if (r101 != 2) goto L14;
        r102.setTranslationY(Math.min(r100.getY() - this.f460870b, 0.0f));
    L27:
        return true;
    L14:
        if (r101 != 3) goto L27;
    L18:
        if (Math.abs(r102.getTranslationY()) < (r102.getHeight() / 2)) goto L23;
        View r103 = this.f460872d;
        if (r103 == null) goto L27;
        ViewPropertyAnimator r104 = r103.animate().translationY(r103.getHeight() * (-1.0f)).setDuration(300).setListener(new d(this));
        this.f460874f = r104;
        r104.start();
        goto L27
    L23:
        View r105 = this.f460872d;
        if (r105 == null) goto L27;
        ViewPropertyAnimator r106 = r105.animate().translationY(0.0f).setDuration(300);
        this.f460874f = r106;
        r106.start();
        goto L27
    L28:
        return false;
    }

    public final void setOnTopCardMoveOutListener(a r100) {
        this.f460875g = r100;
    }

    public TopCardContainer(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f460871c = LazyKt.lazy(new TopCardContainer$touchSlop$2(r100));
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        super.addView(r100, r101, r102);
        View r103 = this.f460872d;
        if (r103 == null) goto L8;
        r103.setTranslationY(0.0f);
        this.f460873e = true;
        this.f460872d = null;
        ViewPropertyAnimator r104 = this.f460874f;
        if (r104 == null) goto L7;
        r104.cancel();
    L7:
        this.f460874f = null;
    L8:
        int r105 = getChildCount();
        int r106 = 0;
    L9:
        if (r106 >= r105) goto L15;
        View r107 = getChildAt(r106);
        if (Intrinsics.areEqual(r107, r100) == true) goto L14;
        r107.setOnClickListener(null);
    L14:
        r106 = r106 + 1;
        goto L9
    }

    public /* synthetic */ TopCardContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
