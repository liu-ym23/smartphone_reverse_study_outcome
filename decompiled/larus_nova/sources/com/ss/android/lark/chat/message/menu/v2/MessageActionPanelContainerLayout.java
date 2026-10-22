package com.ss.android.lark.chat.message.menu.v2;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 G2\u00020\u0001:\u0001GB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010$\u001a\u00020%2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u001a\u001a\u00020%J\u0006\u0010&\u001a\u00020%J\u0010\u0010'\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000fJ\u0012\u0010,\u001a\u00020\u00122\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020%2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00103\u001a\u00020%2\u0006\u00100\u001a\u000201H\u0002J\u0017\u00104\u001a\u0004\u0018\u00010\u00122\u0006\u00100\u001a\u000201H\u0002¢\u0006\u0002\u00105J\u0010\u00106\u001a\u00020\u00122\u0006\u00100\u001a\u000201H\u0002J \u00107\u001a\u00020\u00122\u0006\u00108\u001a\u0002092\u0006\u00100\u001a\u0002012\u0006\u0010:\u001a\u00020\u000fH\u0002J\u0010\u0010;\u001a\u00020\u00122\u0006\u00108\u001a\u000209H\u0002J\b\u0010<\u001a\u00020\u0012H\u0002J&\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f0>2\u0006\u0010?\u001a\u00020@2\u0006\u00100\u001a\u000201H\u0002J\u0010\u0010A\u001a\u00020\u00122\u0006\u0010-\u001a\u000201H\u0016J\u0012\u0010B\u001a\u00020%2\b\b\u0002\u0010C\u001a\u00020\u0012H\u0002J\u0018\u0010D\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u000f2\u0006\u0010-\u001a\u000201H\u0002J \u0010F\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u000f2\u0006\u00100\u001a\u0002012\u0006\u0010\u001d\u001a\u00020\u001cH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010#¨\u0006H"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/MessageActionPanelContainerLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "startY", "", "dependency", "Lcom/ss/android/lark/chat/message/menu/v2/PanelDependency;", "parentOtherChild", "Landroid/view/View;", "touchSlop", "resetCancelNextUpFlagFixDisabled", "", "getResetCancelNextUpFlagFixDisabled", "()Z", "resetCancelNextUpFlagFixDisabled$delegate", "Lkotlin/Lazy;", "childOnlyConsumeDownAction", "consumeTouchDownChildView", "parentConsumeDownAction", "ignoreNextTouchUpClose", "childLocation", "", "parentLocation", "touchBoundsTargetMap", "", "allowPassThroughTouch", "getAllowPassThroughTouch", "setAllowPassThroughTouch", "(Z)V", "setPanelDependency", "", "closePanelImmediately", "setParentOtherChildView", "view", "setTouchBoundsTarget", "containerView", "actualTouchView", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "dispatchCancelEventToParentOtherChildCompat", "dispatchCancelEventToParentOtherChild", "safeDispatchTouchEventToParentOtherChild", "(Landroid/view/MotionEvent;)Ljava/lang/Boolean;", "safeSuperDispatchTouchEvent", "handleResetCancelNextUpFlagException", "t", "", PickerReporterConstants.KEY.TARGET, "isResetCancelNextUpFlagException", "isResetCancelNextUpFlagFixDisabled", "isTouchChildArea", "Lkotlin/Pair;", "viewGroup", "Landroid/view/ViewGroup;", "onTouchEvent", "resetTouchState", "resetIgnoreNextTouchUpClose", "dispatchTouchEventToChild", "childView", "isLocationInView", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageActionPanelContainerLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f415596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k0 f415597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f415598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f415599d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f415600e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f415601f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f415602g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f415603h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f415604i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f415605j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int[] f415606k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<View, View> f415607l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f415608m;

    public static final class a {
    }

    static {
    }

    public MessageActionPanelContainerLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MessageActionPanelContainerLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final boolean getResetCancelNextUpFlagFixDisabled() {
        return ((Boolean) this.f415600e.getValue()).booleanValue();
    }

    public final boolean getAllowPassThroughTouch() {
        return this.f415608m;
    }

    public final void T5(boolean r100) {
        this.f415601f = false;
        this.f415602g = null;
        this.f415603h = false;
        if (r100 == false) goto L6;
        this.f415604i = false;
        return;
    }

    public final Boolean U5(MotionEvent r100) {
        View r101 = this.f415598c;
        if (r101 != null) goto L7;
        return null;
    L7:
        if (getResetCancelNextUpFlagFixDisabled() == true) goto L9;
        return Boolean.valueOf(R5(r101, r100));
    L12:
        th = move-exception;
        S5(th, r100, r101);
        return Boolean.FALSE;
    L9:
        return Boolean.valueOf(R5(r101, r100));
    }

    public final boolean V5(MotionEvent r100) {
        if (getResetCancelNextUpFlagFixDisabled() == true) goto L5;
        return super.dispatchTouchEvent(r100);
    L8:
        th = move-exception;
        S5(th, r100, this);
        return false;
    L5:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L13;
        k0 r102 = this.f415597b;
        if (r102 == null) goto L11;
        r102.a();
    L11:
        return true;
    L13:
        return super.dispatchKeyEvent(r100);
    L5:
        if (r100.getKeyCode() != 4) goto L7;
        r101 = true;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "ev");
        if (this.f415604i == false) goto L8;
        if (r110.getActionMasked() != 0) goto L8;
        this.f415604i = false;
    L8:
        if (this.f415604i == true) goto L10;
    L20:
        getLocationInWindow(this.f415606k);
        int r100 = getChildCount();
        int r101 = 0;
    L21:
        if (r101 >= r100) goto L32;
        View r102 = getChildAt(r101);
        if (r102 == null) goto L31;
        View r103 = (View) ((LinkedHashMap) this.f415607l).get(r102);
        if (r103 != null) goto L28;
        r103 = r102;
    L28:
        int[] r104 = this.f415606k;
        r103.getLocationInWindow(this.f415605j);
        float r105 = r110.getX() + r104[0];
        float r106 = r110.getY() + r104[1];
        int[] r111 = this.f415605j;
        int r112 = r111[0];
        if (new RectF(r112, r111[1], r112 + r103.getWidth(), this.f415605j[1] + r103.getHeight()).contains(r105, r106) == false) goto L31;
        Pair r107 = TuplesKt.to(Boolean.TRUE, r102);
    L33:
        Log.d("MessageActionPanelContainerLayout", "dispatchTouchEvent, ev = " + r110.getActionMasked() + ", parentConsumeDownAction = " + this.f415603h + " isTouchChildArea = " + ((Boolean) r107.getFirst()).booleanValue());
        if (this.f415603h == true) goto L47;
        if (((Boolean) r107.getFirst()).booleanValue() == false) goto L47;
        int r108 = r110.getActionMasked();
        if (r108 == 0) goto L43;
        if (r108 == 1) goto L42;
        if (r108 == 3) goto L42;
    L45:
        return V5(r110);
    L42:
        T5(false);
        goto L45
    L43:
        this.f415601f = true;
        this.f415602g = (View) r107.getSecond();
    L47:
        if (((Boolean) r107.getFirst()).booleanValue() == true) goto L60;
        if (this.f415601f == false) goto L60;
        if (r110.getActionMasked() == 0) goto L60;
        if (r110.getActionMasked() != 1) goto L55;
    L56:
        T5(false);
    L58:
        return V5(r110);
    L55:
        if (r110.getActionMasked() != 3) goto L58;
    L60:
        if (this.f415608m == false) goto L62;
        int r109 = r110.getActionMasked();
        if (r109 == 0) goto L86;
        if (r109 == 1) goto L70;
        if (r109 != 3) goto L87;
        T5(false);
    L87:
        Boolean r113 = U5(r110);
        if (r113 == null) goto L91;
        return r113.booleanValue();
    L91:
        return V5(r110);
    L70:
        if (Math.abs(r110.getRawY() - this.f415596a) < this.f415599d) goto L72;
        T5(false);
        goto L87
    L72:
        if (getResetCancelNextUpFlagFixDisabled() == false) goto L77;
        r110.setAction(3);
        View r114 = this.f415598c;
        if (r114 == null) goto L76;
        R5(r114, r110);
    L76:
        r110.setAction(1);
    L80:
        T5(false);
        return V5(r110);
    L77:
        MotionEvent r115 = MotionEvent.obtain(r110);
        r115.setAction(3);
        Intrinsics.checkNotNull(r115);     // Catch: Throwable -> L82
        U5(r115);     // Catch: Throwable -> L82
        r115.recycle();
    L82:
        th = move-exception;
        r115.recycle();
        throw th;
    L86:
        this.f415596a = r110.getRawY();
        this.f415603h = true;
        goto L87
    L62:
        return V5(r110);
    L31:
        r101 = r101 + 1;
        goto L21
    L32:
        r107 = TuplesKt.to(Boolean.FALSE, null);
        goto L33
    L10:
        if (r110.getActionMasked() != 1) goto L12;
    L13:
        View r116 = this.f415602g;
        if (r116 != null) goto L16;
        r116 = this.f415598c;
    L16:
        if (r116 == null) goto L18;
        R5(r116, r110);
    L18:
        T5(true);
        return true;
    L12:
        if (r110.getActionMasked() != 3) goto L20;
        goto L13
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        StringBuilder r101 = new StringBuilder("onTouchEvent, action = ");
        r101.append(r100.getActionMasked());
        r101.append(", childConsumeTouchDown = ");
        r101.append(this.f415601f);
        r101.append(", childView is null = ");
        if (this.f415602g != null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        Log.d("MessageActionPanelContainerLayout", r101.toString());
        if (this.f415604i == false) goto L15;
        if (r100.getActionMasked() != 1) goto L11;
    L12:
        T5(true);
        return true;
    L11:
        if (r100.getActionMasked() == 3) goto L12;
    L15:
        if (this.f415601f == false) goto L25;
        View r103 = this.f415602g;
        if (r103 == null) goto L20;
        R5(r103, r100);
    L20:
        if (r100.getActionMasked() != 3) goto L22;
    L23:
        T5(false);
    L24:
        return true;
    L22:
        if (r100.getActionMasked() != 1) goto L24;
    L25:
        k0 r104 = this.f415597b;
        if (r104 == null) goto L28;
        r104.a();
    L28:
        return true;
    L5:
        r102 = false;
        goto L6
    }

    public final void setAllowPassThroughTouch(boolean r100) {
        this.f415608m = r100;
    }

    public final void setPanelDependency(k0 r100) {
        Intrinsics.checkNotNullParameter(r100, "dependency");
        this.f415597b = r100;
    }

    public final void setParentOtherChildView(View r100) {
        this.f415598c = r100;
    }

    public final boolean R5(View r100, MotionEvent r101) {
        getLocationInWindow(this.f415606k);
        r100.getLocationInWindow(this.f415605j);
        int[] r102 = this.f415606k;
        int r103 = r102[0];
        int[] r104 = this.f415605j;
        float r105 = r103 - r104[0];
        float r106 = r102[1] - r104[1];
        r101.offsetLocation(r105, r106);
        boolean r107 = r100.dispatchTouchEvent(r101);     // Catch: Throwable -> L6
        r101.offsetLocation(-r105, -r106);
        return r107;
    L6:
        th = move-exception;
        r101.offsetLocation(-r105, -r106);
        throw th;
    }

    public MessageActionPanelContainerLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f415599d = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f415600e = LazyKt.lazy(MessageActionPanelContainerLayout$resetCancelNextUpFlagFixDisabled$2.INSTANCE);
        this.f415605j = new int[2];
        this.f415606k = new int[2];
        this.f415607l = new LinkedHashMap();
        this.f415608m = true;
        setFocusableInTouchMode(true);
    }

    public final void S5(Throwable r100, MotionEvent r110, View r111) {
        boolean r101 = false;
        if ((r100 instanceof NullPointerException) == false) goto L18;
        StackTraceElement[] r102 = ((NullPointerException) r100).getStackTrace();
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L15;
        StackTraceElement r105 = r102[r104];
        if (Intrinsics.areEqual(r105.getClassName(), "android.view.ViewGroup") == true) goto L9;
    L11:
        boolean r106 = false;
    L12:
        if (r106 == true) goto L13;
        r104 = r104 + 1;
        goto L5
    L13:
        boolean r107 = true;
    L16:
        if (r107 == false) goto L18;
        boolean r108 = true;
    L19:
        if (r108 == false) goto L25;
        StringBuilder r109 = new StringBuilder("ignore resetCancelNextUpFlag npe, action=");
        r109.append(r110.getActionMasked());
        r109.append(", target=");
        r109.append(r111.getClass().getSimpleName());
        r109.append(", targetAttached=");
        r109.append(r111.isAttachedToWindow());
        r109.append(", panelAttached=");
        r109.append(isAttachedToWindow());
        r109.append(", childCount=");
        r109.append(getChildCount());
        r109.append(", parentOtherChildNull=");
        if (this.f415598c != null) goto L23;
        r101 = true;
    L23:
        r109.append(r101);
        Log.e("MessageActionPanelContainerLayout", r109.toString(), r100, true);
        return;
    L25:
        throw r100;
    L9:
        if (Intrinsics.areEqual(r105.getMethodName(), "resetCancelNextUpFlag") == false) goto L11;
        r106 = true;
        goto L12
    L15:
        r107 = false;
    L18:
        r108 = false;
        goto L19
    }

    public /* synthetic */ MessageActionPanelContainerLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
