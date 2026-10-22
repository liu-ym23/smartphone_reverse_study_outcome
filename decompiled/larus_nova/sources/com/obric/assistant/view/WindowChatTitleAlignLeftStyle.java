package com.obric.assistant.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PointF;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.lynx.lottieadapter.LottieAdapterView;
import com.obric.assistant.ability.PageStateChangedReason;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import com.obric.assistant.util.m2;
import com.obric.assistant.window.materials.MaterialSceneType;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001TB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J0\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u001dH\u0016J\b\u0010,\u001a\u00020%H\u0002J\b\u0010-\u001a\u00020%H\u0002J\b\u0010.\u001a\u00020%H\u0002J\b\u0010/\u001a\u00020%H\u0002J\b\u00100\u001a\u00020%H\u0002J\f\u00101\u001a\u00020%*\u000202H\u0002J\"\u00103\u001a\u00020%2\u0006\u00104\u001a\u00020(2\b\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\u001dH\u0016J\u0010\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020\u001dH\u0016J\u0016\u0010:\u001a\u00020%2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020%0<H\u0016J \u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020\u001dH\u0002J\b\u0010B\u001a\u00020\u001dH\u0002J\u0010\u0010C\u001a\u00020%2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020FH\u0016J \u0010G\u001a\u00020%2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\u0006\u0010H\u001a\u00020\u001dH\u0016J\u0010\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020KH\u0016J\u0010\u0010L\u001a\u00020%2\u0006\u0010M\u001a\u00020KH\u0002J\u0018\u0010N\u001a\u00020%2\u0006\u0010O\u001a\u00020?2\u0006\u0010H\u001a\u00020\u001dH\u0016J\u000e\u0010P\u001a\u00020%2\u0006\u0010Q\u001a\u00020?J\b\u0010R\u001a\u00020%H\u0002J\b\u0010S\u001a\u00020%H\u0016R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006U"}, d2 = {"Lcom/obric/assistant/view/WindowChatTitleAlignLeftStyle;", "Lcom/obric/assistant/view/ObricChatTitleAlignLeftStyle;", "Lcom/obric/assistant/view/ObricSwipeGestureView$OnSwipeGestureListener;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "Lkotlin/Lazy;", "pageUIAbility", "Lcom/obric/assistant/window/ability/IObricPageUIAbility;", "getPageUIAbility", "()Lcom/obric/assistant/window/ability/IObricPageUIAbility;", "pageUIAbility$delegate", "viewTopMargin", "", "viewBottomMargin", "buttonWidth", "buttonHeight", "gestureView", "Lcom/obric/assistant/view/ObricSwipeGestureView;", "getGestureView", "()Lcom/obric/assistant/view/ObricSwipeGestureView;", "gestureView$delegate", "interruptMoveAction", "", "downTopEmptyHeight", "actionInMiddleRange", "showItemIds", "", "getShowItemIds", "()Ljava/util/List;", "initView", "", "isMainCvs", "titleName", "", "ttsChecked", "isSideBar", "isEnterpriseColdStart", "setupEnterpriseTitle", "setupGestureView", "setupTtsContainer", "setupMultiTaskManagement", "bringInteractiveButtonsToFront", "setupMaterialInternal", "Landroid/view/View;", com.alipay.sdk.m.x.d.f25925o, "title", "tagConfig", "Lcom/larus/platform/api/ChatTitleTagConfig;", "isDefaultName", "setCvsOnlyRead", "isOnlyRead", "setOnTtsLongPressAction", "longClickAction", "Lkotlin/Function0;", "doMoveAction", "distance", "", "velocity", VideoEventOneOutSync.END_TYPE_FINISH, "isLandscapeDragDisabled", "tryVibrate", "onDown", "e", "Landroid/view/MotionEvent;", "onSwipeFinish", "swipeUp", "onClickNextFloorView", "pointF", "Landroid/graphics/PointF;", "onClickTitleBar", "downPoint", "onSwipe", "delta", "changeTitleAlpha", "alpha", "setupViewGone", "updateAllIconVisibilityForObric", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowChatTitleAlignLeftStyle extends ObricChatTitleAlignLeftStyle implements ObricSwipeGestureView.c {

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final /* synthetic */ int f394010k1 = 0;
    public final int H0;
    public final int L0;
    public final int P0;
    public final int V0;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public final Lazy f394011b1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public int f394012g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public boolean f394013h1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final Lazy f394014k0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final Lazy f394015p0;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.view.ChatTitleAlignLeftStyle, com.larus.platform.api.g0
    public void setOnTtsLongPressAction(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "longClickAction");
    }

    private final ObricSwipeGestureView getGestureView() {
        return (ObricSwipeGestureView) this.f394011b1.getValue();
    }

    private final laa.d getPageStateAbility() {
        return (laa.d) this.f394014k0.getValue();
    }

    private final xha.c getPageUIAbility() {
        return (xha.c) this.f394015p0.getValue();
    }

    private final List<Integer> getShowItemIds() {
        List r100 = CollectionsKt.createListBuilder();
        r100.add(Integer.valueOf(R.id.tts_container));
        r100.add(Integer.valueOf(R.id.window_title_gesture_bar));
        r100.add(Integer.valueOf(R.id.multitask_management_icon));
        r100.add(Integer.valueOf(R.id.obric_enterprise_account_title));
        return CollectionsKt.build(r100);
    }

    public final void E7() {
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L10;
        View r102 = getChildAt(r101);
        if (getShowItemIds().contains(Integer.valueOf(r102.getId())) == true) goto L9;
        if (r102.getVisibility() == 8) goto L9;
        e1.o(r102);
    L9:
        r101 = r101 + 1;
        goto L3
    }

    @Override // com.larus.bmhome.view.ChatTitleAlignLeftStyle
    public final void o7() {
        E7();
    }

    public WindowChatTitleAlignLeftStyle(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f394014k0 = LazyKt.lazy(new k0(this));
        this.f394015p0 = LazyKt.lazy(new l0(this));
        this.H0 = i5.q();
        this.L0 = i5.r0();
        this.P0 = c7.b(40);
        this.V0 = c7.b(40);
        this.f394011b1 = LazyKt.lazy(new m0(r100));
        this.f394013h1 = true;
        setClipChildren(false);
        setClipToPadding(false);
    }

    private final void setupMaterialInternal(View r100) {
        FLogger.f375446a.i("WindowChatTitleAlignLeftStyle", "set up title bar material");
        r100.setTag(R.id.obric_material_target_view, r100);
        Lazy r101 = bia.g.f19194a;
        bia.g.a(r100, true, MaterialSceneType.FLOATING_BG);
    }

    @Override // com.obric.assistant.view.ObricSwipeGestureView.c
    public final void E(float r100) {
        laa.d r101 = getPageStateAbility();
        boolean r102 = true;
        if (r101 == null) goto L9;
        ObricFloatChatPageState r103 = r101.getPageState();
        if (r103 == null) goto L9;
        ObricFloatChatPageData.Companion.getClass();
        if ((r103 instanceof vda.a) != true) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == true) goto L23;
        laa.d r105 = getPageStateAbility();
        if (r105 == null) goto L18;
        ObricFloatChatPageState r106 = r105.getPageState();
        if (r106 == null) goto L18;
        ObricFloatChatPageData.Companion.getClass();
        if ((r106 instanceof vda.b) != true) goto L18;
    L19:
        if (r102 == true) goto L24;
        C7(r100, 0.0f, false);
        return;
    L24:
        return;
    L18:
        r102 = false;
        goto L19
    L23:
        return;
    L9:
        r104 = false;
        goto L10
    }

    @Override // com.obric.assistant.view.ObricSwipeGestureView.c
    public final void F4(PointF r110) {
        Intrinsics.checkNotNullParameter(r110, "pointF");
        PointF r100 = new PointF(r110.x, r110.y);
        FLogger.f375446a.i("WindowChatTitleAlignLeftStyle", "onClickTitleBar, downPoint = " + r100);
        if (getVisibility() != 0) goto L5;
        boolean r111 = true;
    L6:
        if (r111 == false) goto L36;
        int r112 = getChildCount();
        int r101 = 0;
    L9:
        if (r101 >= r112) goto L43;
        View r102 = getChildAt(r101);
        if (r102.getVisibility() != 0) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L35;
        if (r102.getAlpha() != 1.0f) goto L18;
        boolean r104 = true;
    L19:
        if (r104 == false) goto L35;
        float r105 = r102.getX();
        float r106 = r102.getX() + r102.getWidth();
        float r107 = r100.x;
        if (r105 <= r107) goto L23;
    L25:
        boolean r108 = false;
    L26:
        if (r108 == false) goto L35;
        float r109 = r102.getY();
        float r113 = r102.getY() + r102.getHeight();
        float r114 = r100.y;
        if (r109 <= r114) goto L30;
    L32:
        boolean r115 = false;
    L33:
        if (r115 == false) goto L35;
        r102.performClick();
        goto L35
    L30:
        if (r114 > r113) goto L32;
        r115 = true;
        goto L33
    L23:
        if (r107 > r106) goto L25;
        r108 = true;
        goto L26
    L18:
        r104 = false;
    L35:
        FLogger.f375446a.i("WindowChatTitleAlignLeftStyle", "onClickTitleBar, it is " + r102 + ", \nrect is " + r102.getX() + ", " + r102.getY() + ", " + (r102.getX() + r102.getWidth()) + ", " + (r102.getY() + r102.getHeight()));
        r101 = r101 + 1;
        goto L9
    L13:
        r103 = false;
        goto L14
    L43:
        return;
    L36:
        return;
    L5:
        r111 = false;
        goto L6
    }

    @Override // com.obric.assistant.view.ObricSwipeGestureView.c
    public final void onDown(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        xha.c r101 = getPageUIAbility();
        Integer r102 = null;
        if (r101 == null) goto L5;
        Integer r103 = r101.w40();
    L6:
        laa.d r104 = getPageStateAbility();
        if (r104 == null) goto L12;
        ObricFloatChatPageState r105 = r104.getPageState();
        if (r105 == null) goto L12;
        r102 = Integer.valueOf(r105.getHeight());
    L12:
        if (Intrinsics.areEqual(r103, r102) == false) goto L21;
        xha.c r106 = getPageUIAbility();
        if (r106 == null) goto L18;
        Integer r107 = r106.w40();
        if (r107 == null) goto L18;
        int r108 = r107.intValue();
    L19:
        this.f394012g1 = r108;
        return;
    L18:
        r108 = 0;
        goto L19
    L21:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.larus.bmhome.view.ChatTitleAlignLeftStyle
    public void setCvsOnlyRead(boolean r100) {
        e1.o(getBinding().f323935t);
    }

    public final void y7(float r100) {
        FLogger.f375446a.i("WindowChatTitleAlignLeftStyle", "change title bar alpha");
        setAlpha(r100);
        ObricSwipeGestureView r101 = getGestureView();
        if (r100 <= 0.0f) goto L5;
        boolean r102 = true;
    L6:
        r101.setEnabled(r102);
        E7();
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.obric.assistant.view.ObricSwipeGestureView.c
    public final void s5(float r100, float r101) {
        C7(r100, r101, true);
    }

    public final void C7(float r210, float r211, boolean r212) {
        ObricFloatChatPageData.a r100 = ObricFloatChatPageData.Companion;
        laa.d r101 = getPageStateAbility();
        if (r101 == null) goto L5;
        ObricFloatChatPageState r102 = r101.getPageState();
    L6:
        r100.getClass();
        boolean r103 = true;
        if ((r102 instanceof vda.f) == true) goto L21;
        Context r104 = getContext();
        if (r104 == null) goto L17;
        Resources r105 = r104.getResources();
        if (r105 == null) goto L17;
        Configuration r106 = r105.getConfiguration();
        if (r106 == null) goto L17;
        if (r106.orientation != 2) goto L17;
        boolean r107 = true;
    L18:
        if (r107 == true) goto L21;
        boolean r108 = false;
    L22:
        if (r108 == false) goto L24;
        return;
    L24:
        laa.d r109 = getPageStateAbility();
        if (r109 == null) goto L31;
        ObricFloatChatPageState r110 = r109.getPageState();
        if (r110 == null) goto L31;
        if ((r110 instanceof vda.c) != true) goto L31;
        boolean r111 = true;
    L32:
        if (r111 == true) goto L36;
        laa.d r112 = getPageStateAbility();
        if (r112 == null) goto L36;
        r112.o2(this.f394012g1);
    L36:
        if (r212 == true) goto L38;
        laa.d r113 = getPageStateAbility();
        if (r113 == null) goto L82;
        r113.o2(this.f394012g1 + ((int) r210));
    L82:
        int r114 = -m2.f393771c;
        int r115 = m2.f393772d;
        int r116 = (int) r210;
        if (r114 > r116) goto L86;
        if (r116 > r115) goto L86;
    L87:
        if (r103 == false) goto L89;
    L93:
        this.f394013h1 = r103;
        return;
    L89:
        if (this.f394013h1 == false) goto L93;
        if (r116 < r114) goto L93;
        if (r116 <= r115) goto L93;
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_SOFT);
    L86:
        r103 = false;
        goto L87
    L38:
        if (r211 >= (-1500.0f)) goto L47;
        if (r210 >= 0.0f) goto L47;
        laa.d r117 = getPageStateAbility();
        if (r117 == null) goto L44;
        laa.d.a.c(r117, Float.valueOf(r211), false, "swipe_up", 2);
    L44:
        int r118 = fia.a.f477427a;
        fia.a.b(ObricFloatChatPageData.access$getFULL_SCREEN_SIMPLE_NAME$cp());
        return;
    L47:
        if (r211 <= 1500.0f) goto L55;
        if (r210 <= 0.0f) goto L55;
        laa.d r119 = getPageStateAbility();
        if (r119 == null) goto L95;
        laa.d.a.a(r119, r211, false, 2);
        return;
    L95:
        return;
    L55:
        if (r210 <= 0.0f) goto L65;
        if (r210 >= m2.f393772d) goto L61;
        laa.d r120 = getPageStateAbility();
        if (r120 == null) goto L96;
        laa.d.a.d(r120, false, this.f394012g1, null, false, false, PageStateChangedReason.SWIPE_GESTURE_VIEW, 29);
        return;
    L96:
        return;
    L61:
        laa.d r121 = getPageStateAbility();
        if (r121 == null) goto L98;
        laa.d.a.a(r121, r211, false, 2);
        return;
    L98:
        return;
    L65:
        if (Math.abs(r210) >= m2.f393771c) goto L70;
        laa.d r122 = getPageStateAbility();
        if (r122 == null) goto L69;
        laa.d.a.d(r122, false, this.f394012g1, null, false, false, PageStateChangedReason.SWIPE_GESTURE_VIEW, 29);
    L69:
        fia.a.b(null);
        return;
    L70:
        laa.d r123 = getPageStateAbility();
        if (r123 == null) goto L101;
        int r124 = r123.getPageState().getHeight();
        int r125 = m2.f393770b;
        if (r124 > r125) goto L78;
        laa.d r126 = getPageStateAbility();
        if (r126 == null) goto L77;
        laa.d.a.c(r126, Float.valueOf(r211), false, "swipe_up", 2);
    L77:
        int r127 = fia.a.f477427a;
        fia.a.b(ObricFloatChatPageData.access$getFULL_SCREEN_SIMPLE_NAME$cp());
        return;
    L78:
        laa.d.a.d(r123, false, r125, null, true, false, PageStateChangedReason.SWIPE_GESTURE_VIEW, 21);
        return;
    L101:
        return;
    L31:
        r111 = false;
    L17:
        r107 = false;
    L21:
        r108 = true;
        goto L22
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larus.bmhome.view.ChatTitleAlignLeftStyle, com.larus.platform.api.g0
    public final void Ia(String r100, com.larus.platform.api.j r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "title");
        super.Ia(r100, r101, r102);
        E7();
    }

    @Override // com.obric.assistant.view.ObricChatTitleAlignLeftStyle, com.larus.bmhome.view.ChatTitleAlignLeftStyle
    public final void i6(boolean r100, String r101, boolean r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r101, "titleName");
        super.i6(r100, r101, r102, r103, r104);
        pla.j.g(getGestureView());
        ObricSwipeGestureView r105 = getGestureView();
        ConstraintLayout.LayoutParams r106 = new ConstraintLayout.LayoutParams(-1, 0);
        r106.topToTop = 0;
        r106.bottomToBottom = 0;
        r106.startToStart = 0;
        r106.endToEnd = 0;
        Unit r107 = Unit.INSTANCE;
        addView(r105, r106);
        getGestureView().setOnSwipeGestureListener(this);
        E7();
        FrameLayout r108 = getBinding().E;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if ((r109 instanceof ConstraintLayout.LayoutParams) == false) goto L5;
        ConstraintLayout.LayoutParams r110 = (ConstraintLayout.LayoutParams) r109;
    L6:
        if (r110 == null) goto L8;
        ((ViewGroup.MarginLayoutParams) r110).width = this.P0;
        ((ViewGroup.MarginLayoutParams) r110).height = this.V0;
        r110.setMarginEnd(i5.q());
        ((ViewGroup.MarginLayoutParams) r110).topMargin = this.H0;
        ((ViewGroup.MarginLayoutParams) r110).bottomMargin = this.L0;
    L9:
        r108.setLayoutParams(r110);
        r108.setClipChildren(false);
        r108.setClipToPadding(false);
        LottieAdapterView r111 = getBinding().D;
        ViewGroup.LayoutParams r112 = getBinding().D.getLayoutParams();
        if (r112 == null) goto L12;
        r112.width = this.P0;
        r112.height = this.V0;
    L13:
        r111.setLayoutParams(r112);
        r111.setClipChildren(false);
        r111.setClipToPadding(false);
        Intrinsics.checkNotNull(r111);
        setupMaterialInternal(r111);
        View r113 = getBinding().f323932q;
        Intrinsics.checkNotNull(r113);
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if (r114 == null) goto L24;
        ConstraintLayout.LayoutParams r115 = (ConstraintLayout.LayoutParams) r114;
        ((ViewGroup.MarginLayoutParams) r115).width = this.P0;
        ((ViewGroup.MarginLayoutParams) r115).height = this.V0;
        r115.startToStart = 0;
        r115.setMarginStart(i5.q());
        ((ViewGroup.MarginLayoutParams) r115).topMargin = this.H0;
        ((ViewGroup.MarginLayoutParams) r115).bottomMargin = this.L0;
        r113.setLayoutParams(r115);
        setupMaterialInternal(r113);
        getBinding().E.bringToFront();
        getBinding().f323932q.bringToFront();
        if (AccountService.f365697a.isEnterpriseAccount() == false) goto L22;
        int r116 = (int) getContext().getResources().getDimension(R.dimen.larus_dp_63);
        int r117 = (int) getContext().getResources().getDimension(R.dimen.larus_dp_32);
        View r118 = LayoutInflater.from(getContext()).inflate(R.layout.layout_obric_enterprise_account_title, null, false);
        if (r118 == null) goto L21;
        View r119 = (FrameLayout) r118;
        Intrinsics.checkNotNull(r119);
        setupMaterialInternal(r119);
        ConstraintLayout.LayoutParams r120 = new ConstraintLayout.LayoutParams(r116, r117);
        r120.topToTop = R.id.tts_container;
        r120.bottomToBottom = R.id.tts_container;
        r120.startToStart = 0;
        r120.endToEnd = 0;
        addView(r119, r120);
        return;
    L21:
        throw new NullPointerException("rootView");
    L22:
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L12:
        r112 = null;
        goto L13
    L8:
        r110 = null;
        goto L9
    L5:
        r110 = null;
        goto L6
    }
}
