package com.ss.android.lark.chat.message.menu.v2.popup;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byted.cast.common.CastMonitor;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.message.menu.v2.PanelType;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010.\u001a\u00020\u0019J\u0014\u0010/\u001a\u00020\u00192\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001901J<\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020*2\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\n\b\u0002\u00106\u001a\u0004\u0018\u00010-2\n\b\u0002\u00107\u001a\u0004\u0018\u0001082\b\b\u0002\u00109\u001a\u00020\u0012J\u000e\u0010:\u001a\u00020\u00192\u0006\u00103\u001a\u00020*J\u000e\u0010;\u001a\u00020\u00192\u0006\u0010<\u001a\u00020=J\u0010\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020@H\u0016J0\u0010A\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u00122\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u0007H\u0014J\u0012\u0010G\u001a\u00020\u00122\b\u0010H\u001a\u0004\u0018\u00010IH\u0016R&\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00078\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fRc\u0010\u0010\u001aK\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuRootView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "backgroundColorRes", "getBackgroundColorRes", "()I", "setBackgroundColorRes", "(I)V", "dismiss", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "isClickActionItem", "Lcom/ss/android/lark/biz/im/extension/message_action/MessageActionType;", "clickActionType", "isClickInputContainer", "", "getDismiss", "()Lkotlin/jvm/functions/Function3;", "setDismiss", "(Lkotlin/jvm/functions/Function3;)V", "needAdapterInputText", "getNeedAdapterInputText", "()Z", "setNeedAdapterInputText", "(Z)V", "bottomInputContainerHeight", "getBottomInputContainerHeight", "()Ljava/lang/Integer;", "setBottomInputContainerHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "dimView", "Landroid/view/View;", "anchorMargin", "safeEdge", "Landroid/graphics/Rect;", "startShowAnim", "startDismissAnim", "completion", "Lkotlin/Function0;", "addMenuView", "view", "anchorPoint", "Landroid/graphics/Point;", "anchorRect", "anchorStyle", "Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContentContainer$AnchorStyle;", "alignmentParentItemRight", "removeMenuView", "performSwitchAnim", "toPanelType", "Lcom/ss/android/lark/chat/message/menu/v2/PanelType;", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopupMenuRootView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f415863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function3<? super Boolean, ? super MessageActionType, ? super Boolean, Unit> f415864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f415865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f415866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f415867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f415868f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f415869g;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f415870a;

        public a(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f415870a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f415870a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public PopupMenuRootView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PopupMenuRootView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final int getBackgroundColorRes() {
        return this.f415863a;
    }

    public final Integer getBottomInputContainerHeight() {
        return this.f415866d;
    }

    public final Function3<Boolean, MessageActionType, Boolean, Unit> getDismiss() {
        return this.f415864b;
    }

    public final boolean getNeedAdapterInputText() {
        return this.f415865c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100.getKeyCode() != 4) goto L12;
        if (r100.getAction() != 0) goto L12;
        Function3<? super Boolean, ? super MessageActionType, ? super Boolean, Unit> r101 = this.f415864b;
        if (r101 == null) goto L13;
        Boolean r102 = Boolean.FALSE;
        r101.invoke(r102, null, r102);
        return true;
    L13:
        return true;
    L12:
        return super.dispatchKeyEvent(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (this.f415865c == false) goto L25;
        if (r100 == null) goto L25;
        Integer r101 = this.f415866d;
        if (r101 == null) goto L23;
        if (r101.intValue() <= 0) goto L23;
        if (r100.getAction() != 0) goto L21;
        if (r100.getY() <= (getHeight() - r101.intValue())) goto L21;
        Function3<? super Boolean, ? super MessageActionType, ? super Boolean, Unit> r102 = this.f415864b;
        if (r102 == null) goto L26;
        r102.invoke(Boolean.FALSE, null, Boolean.TRUE);
        return false;
    L26:
        return false;
    L21:
        return super.dispatchTouchEvent(r100);
    L23:
        return super.dispatchTouchEvent(r100);
    L25:
        return super.dispatchTouchEvent(r100);
    }

    public final void setBackgroundColorRes(int r100) {
        this.f415863a = r100;
        this.f415867e.setBackgroundColor(UIUtils.getColor(getContext(), this.f415863a));
    }

    public final void setBottomInputContainerHeight(Integer r100) {
        this.f415866d = r100;
    }

    public final void setDismiss(Function3<? super Boolean, ? super MessageActionType, ? super Boolean, Unit> r100) {
        this.f415864b = r100;
    }

    public final void setNeedAdapterInputText(boolean r100) {
        this.f415865c = r100;
    }

    public PopupMenuRootView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f415863a = -1;
        View r103 = new View(r100);
        r103.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(r103);
        this.f415867e = r103;
        this.f415868f = UIUtils.dp2px(r100, 16.0f);
        this.f415869g = new Rect(0, UIUtils.dp2px(r100, 32.0f), 0, UIUtils.dp2px(r100, 32.0f));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
    }

    public /* synthetic */ PopupMenuRootView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static /* synthetic */ void b(PopupMenuRootView r100, View r101, Point r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.a(r101, r102, null, null, false);
    }

    public final void a(View r100, Point r101, Rect r102, PopupMenuContentContainer.AnchorStyle r103, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        AttributeSet r104 = null;
        PopupMenuContentContainer r105 = new PopupMenuContentContainer(getContext(), r104, 6, 0);
        r105.setLayoutParams(new ViewGroup.LayoutParams(r100.getLayoutParams()));
        r105.addView(r100);
        r105.setAnchorPoint(r101);
        r105.setAnchorRect(r102);
        if (r110 == false) goto L5;
        PopupMenuContentContainer.AnchorAlignment r106 = PopupMenuContentContainer.AnchorAlignment.RIGHT;
    L6:
        r105.setAnchorAlignment(r106);
        if (r103 == null) goto L9;
        r105.setAnchorStyle(r103);
    L9:
        addView(r105);
        return;
    L5:
        r106 = PopupMenuContentContainer.AnchorAlignment.LEFT;
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r110, int r111, int r112, int r113) {
        View r101 = this.f415867e;
        r101.layout(0, 0, r101.getMeasuredWidth(), this.f415867e.getMeasuredHeight());
        int r102 = getChildCount();
        int r114 = 0;
    L3:
        if (r114 >= r102) goto L49;
        View r115 = getChildAt(r114);
        if (Intrinsics.areEqual(r115, this.f415867e) == true) goto L48;
        if ((r115 instanceof PopupMenuContentContainer) == false) goto L10;
        PopupMenuContentContainer r116 = (PopupMenuContentContainer) r115;
    L11:
        if (r116 == null) goto L48;
        boolean r103 = true;
        if (r116.getAnchorRect() == null) goto L16;
    L19:
        boolean r117 = true;
    L20:
        if (r117 == false) goto L45;
        int r118 = r116.getMeasuredWidth();
        int r104 = r116.getMeasuredHeight();
        if (r116.getAnchorStyle() != PopupMenuContentContainer.AnchorStyle.OVERLAY) goto L31;
        Rect r105 = r116.getAnchorRect();
        if (r105 == null) goto L25;
        if (r116.getAnchorAlignment() != PopupMenuContentContainer.AnchorAlignment.LEFT) goto L29;
        int r106 = r105.left - r116.getPaddingStart();
    L30:
        int r107 = RangesKt.coerceIn(r106, 0, Math.max(0, getMeasuredWidth() - r118));
        int r108 = RangesKt.coerceIn(r105.top - r116.getPaddingTop(), 0, getMeasuredHeight() - r104);
        r116.layout(r107, r108, r118 + r107, r104 + r108);
        goto L48
    L29:
        r106 = (r105.right + r116.getPaddingEnd()) - r118;
        goto L30
    L25:
        return;
    L31:
        Point r109 = r116.getAnchorPoint();
        if (r109 == null) goto L33;
        int r119 = r109.x;
        int r120 = r109.y;
        int r121 = RangesKt.coerceIn(r119 - (r118 / 2), 0, Math.max(0, getMeasuredWidth() - r118));
        int r122 = (r120 - this.f415868f) - this.f415869g.top;
        int r123 = ((getMeasuredHeight() - r120) - this.f415868f) - this.f415869g.bottom;
        if (r122 < ((r104 - r116.getPaddingTop()) - r116.getPaddingBottom())) goto L38;
    L40:
        if (r103 == false) goto L42;
        int r124 = ((r120 - this.f415868f) - r104) + r116.getPaddingBottom();
        int r125 = this.f415869g.top;
        int r126 = RangesKt.coerceIn(r124, r125, Math.max(r125, getMeasuredHeight() - r104));
    L43:
        r116.layout(r121, r126, r118 + r121, r104 + r126);
        goto L48
    L42:
        int r127 = (r120 + this.f415868f) - r116.getPaddingTop();
        int r128 = this.f415869g.top;
        r126 = RangesKt.coerceIn(r127, r128, Math.max(r128, getMeasuredHeight() - r104));
        goto L43
    L38:
        if (r123 < ((r104 - r116.getPaddingTop()) - r116.getPaddingBottom())) goto L40;
        r103 = false;
        goto L40
    L33:
        return;
    L45:
        if (r116.getPanelType() != PanelType.EMOJI) goto L47;
        r116.layout(0, getMeasuredHeight() - r116.getMeasuredHeight(), r116.getMeasuredWidth(), getMeasuredHeight());
        goto L48
    L47:
        r116.layout(0, 0, r116.getMeasuredWidth(), r116.getMeasuredHeight());
        goto L48
    L16:
        if (r116.getAnchorPoint() != null) goto L19;
        r117 = false;
        goto L20
    L10:
        r116 = null;
    L48:
        r114 = r114 + 1;
        goto L3
    }
}
