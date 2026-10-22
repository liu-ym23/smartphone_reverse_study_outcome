package com.ss.android.lark.chat.message.menu.v2.popup;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.message.menu.v2.PanelType;
import com.ss.android.lark.chat.message.menu.v2.emoji.BuiltInTopEmojiView;
import com.ss.android.lark.chat.message.menu.v2.i0;
import com.ss.android.lark.chat.message.menu.v2.o0;
import com.ss.android.lark.monitor.page.WindowFreezeMonitor;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u00108\u001a\u000209J\u0006\u0010:\u001a\u000209J\b\u0010;\u001a\u000209H\u0002J\b\u0010<\u001a\u000209H\u0002J\u0018\u0010=\u001a\u0002092\u0006\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\bH\u0014J\u0012\u0010@\u001a\u00020!2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010C\u001a\u0002092\u0006\u0010D\u001a\u00020EH\u0014J\b\u0010F\u001a\u000209H\u0002J\b\u0010G\u001a\u000209H\u0002J\u0010\u0010H\u001a\u0002092\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010K\u001a\u0002092\u0006\u0010I\u001a\u00020JH\u0002R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R(\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010'\u001a\u0004\b0\u00101R\u001b\u00103\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010'\u001a\u0004\b5\u00106¨\u0006L"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuMainContent;", "Landroid/widget/LinearLayout;", "Lcom/ss/android/lark/chat/message/menu/v2/popup/IPopupMenuContent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "panelType", "Lcom/ss/android/lark/chat/message/menu/v2/PanelType;", "getPanelType", "()Lcom/ss/android/lark/chat/message/menu/v2/PanelType;", "shadowTarget", "Lcom/ss/android/lark/chat/message/menu/v2/popup/IPopupMenuContent$ShadowTarget;", "getShadowTarget", "()Lcom/ss/android/lark/chat/message/menu/v2/popup/IPopupMenuContent$ShadowTarget;", "value", "Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContext;", "menuContext", "getMenuContext", "()Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContext;", "setMenuContext", "(Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContext;)V", "onReactionClickListener", "Lcom/ss/android/lark/chat/message/menu/v2/ReactionClickListener;", "getOnReactionClickListener", "()Lcom/ss/android/lark/chat/message/menu/v2/ReactionClickListener;", "setOnReactionClickListener", "(Lcom/ss/android/lark/chat/message/menu/v2/ReactionClickListener;)V", "subMenuShowing", "", "maskPaint", "Landroid/graphics/Paint;", "getMaskPaint", "()Landroid/graphics/Paint;", "maskPaint$delegate", "Lkotlin/Lazy;", "maskAlphaRatio", "", "maskAnimator", "Landroid/animation/ValueAnimator;", "maskRectF", "Landroid/graphics/RectF;", "reactionContainer", "Lcom/larksuite/component/ui/layout/LKUIRoundableLayout;", "getReactionContainer", "()Lcom/larksuite/component/ui/layout/LKUIRoundableLayout;", "reactionContainer$delegate", "menuContainer", "Lcom/larksuite/component/ui/layout/LKUIRoundLinearLayout;", "getMenuContainer", "()Lcom/larksuite/component/ui/layout/LKUIRoundLinearLayout;", "menuContainer$delegate", "onSubMenuShown", "", "onSubMenuDismissed", "showMask", "hideMask", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "refreshContainer", "refreshActions", "setReaction", SlcCommonAction.KEY_ACTIONS, "Lcom/ss/android/lark/chat/message/menu/MessageActionParseResult;", "setMenuItems", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopupMenuMainContent extends LinearLayout implements IPopupMenuContent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PanelType f415823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IPopupMenuContent.ShadowTarget f415824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.ss.android.lark.chat.message.menu.v2.popup.d f415825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public o0 f415826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f415827e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f415828f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f415829g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ValueAnimator f415830h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f415831i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f415832j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f415833k;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zya.e f415834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PopupMenuItemGrid f415835b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f415836c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ PopupMenuMainContent f415837d;

        public a(zya.e r100, PopupMenuItemGrid r101, boolean r102, PopupMenuMainContent r103) {
            this.f415834a = r100;
            this.f415835b = r101;
            this.f415836c = r102;
            this.f415837d = r103;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (g.a((zya.b) this.f415834a, this.f415835b, this.f415836c) == false) goto L10;
            com.ss.android.lark.chat.message.menu.v2.popup.d r101 = this.f415837d.getMenuContext();
            if (r101 == null) goto L11;
            com.ss.android.lark.chat.message.menu.v2.popup.a r102 = r101.a();
            if (r102 == null) goto L12;
            i0.a(r102, false, null, 7);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zya.e f415838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PopupMenuItem f415839b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f415840c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ PopupMenuMainContent f415841d;

        public b(zya.e r100, PopupMenuItem r101, boolean r102, PopupMenuMainContent r103) {
            this.f415838a = r100;
            this.f415839b = r101;
            this.f415840c = r102;
            this.f415841d = r103;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (g.a((zya.b) this.f415838a, this.f415839b, this.f415840c) == false) goto L10;
            com.ss.android.lark.chat.message.menu.v2.popup.d r101 = this.f415841d.getMenuContext();
            if (r101 == null) goto L11;
            com.ss.android.lark.chat.message.menu.v2.popup.a r102 = r101.a();
            if (r102 == null) goto L12;
            i0.a(r102, false, null, 7);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zya.e f415842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PopupMenuItem f415843b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f415844c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ List<zya.b> f415845d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ PopupMenuMainContent f415846e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.chat.message.menu.d f415847f;

        public c(zya.e r100, PopupMenuItem r101, boolean r102, List<zya.b> r103, PopupMenuMainContent r104, com.ss.android.lark.chat.message.menu.d r105) {
            this.f415842a = r100;
            this.f415843b = r101;
            this.f415844c = r102;
            this.f415845d = r103;
            this.f415846e = r104;
            this.f415847f = r105;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (g.a((zya.b) this.f415842a, this.f415843b, this.f415844c) == false) goto L31;
            boolean r101 = false;
            if (this.f415844c == false) goto L25;
            List r102 = CollectionsKt.mutableListOf(new zya.b[]{this.f415842a});
            r102.addAll(this.f415845d);
            com.ss.android.lark.chat.message.menu.v2.popup.d r103 = this.f415846e.getMenuContext();
            if (r103 == null) goto L32;
            com.ss.android.lark.chat.message.menu.v2.popup.a r104 = r103.a();
            if (r104 == null) goto L33;
            PopupMenuItem r105 = this.f415843b;
            if (this.f415847f.f415496c == false) goto L23;
            com.ss.android.lark.chat.message.menu.v2.popup.d r106 = this.f415846e.getMenuContext();
            if (r106 == null) goto L21;
            yya.a r107 = r106.f415883a;
            if (r107 == null) goto L21;
            v5b.c<?> r108 = r107.m();
            if (r108 == null) goto L21;
            if (r108.h() != true) goto L21;
            boolean r109 = true;
        L22:
            if (r109 == true) goto L23;
        L24:
            r104.b(r102, r105, r101);
            return;
        L21:
            r109 = false;
        L23:
            r101 = true;
            goto L24
        L33:
            return;
        L32:
            return;
        L25:
            com.ss.android.lark.chat.message.menu.v2.popup.d r110 = this.f415846e.getMenuContext();
            if (r110 == null) goto L35;
            com.ss.android.lark.chat.message.menu.v2.popup.a r111 = r110.a();
            if (r111 == null) goto L36;
            i0.a(r111, false, null, 7);
            return;
        L36:
            return;
        L35:
            return;
        }
    }

    public static final class d implements o0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PopupMenuMainContent f415848a;

        public d(PopupMenuMainContent r100) {
            this.f415848a = r100;
        }

        @Override // com.ss.android.lark.chat.message.menu.v2.o0
        public final void a(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "reactionKey");
            o0 r102 = this.f415848a.getOnReactionClickListener();
            if (r102 == null) goto L6;
            r102.a(r100, r101);
            return;
        }
    }

    public PopupMenuMainContent(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PopupMenuMainContent(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final Paint getMaskPaint() {
        return (Paint) this.f415828f.getValue();
    }

    private final LKUIRoundLinearLayout getMenuContainer() {
        return (LKUIRoundLinearLayout) this.f415833k.getValue();
    }

    private final LKUIRoundableLayout getReactionContainer() {
        return (LKUIRoundableLayout) this.f415832j.getValue();
    }

    public final com.ss.android.lark.chat.message.menu.v2.popup.d getMenuContext() {
        return this.f415825c;
    }

    public final o0 getOnReactionClickListener() {
        return this.f415826d;
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.popup.IPopupMenuContent
    public PanelType getPanelType() {
        return this.f415823a;
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.popup.IPopupMenuContent
    public IPopupMenuContent.ShadowTarget getShadowTarget() {
        return this.f415824b;
    }

    private final void setMenuItems(com.ss.android.lark.chat.message.menu.d r210) {
        Context r100 = getContext();
        com.ss.android.lark.chat.message.menu.v2.popup.d r101 = this.f415825c;
        if (r101 == null) goto L9;
        com.ss.android.lark.biz.im.api.message.params.m r102 = r101.f415885c;
        if (r102 == null) goto L9;
        Integer r103 = r102.f410369f;
        if (r103 == null) goto L9;
        int r104 = r103.intValue();
    L10:
        int r110 = UIUtils.getColor(r100, r104);
        getMenuContainer().removeAllViews();
        Iterator<T> r111 = r210.f415494a.iterator();
    L12:
        if (r111.hasNext() == false) goto L102;
        zya.e r105 = (zya.e) r111.next();
        if ((r105 instanceof zya.h) == false) goto L25;
        Context r106 = getContext();
        com.ss.android.lark.chat.message.menu.v2.popup.d r107 = this.f415825c;
        if (r107 == null) goto L22;
        com.ss.android.lark.biz.im.api.message.params.m r108 = r107.f415885c;
        if (r108 == null) goto L22;
        Integer r109 = r108.f410366c;
        if (r109 == null) goto L22;
        int r112 = r109.intValue();
    L23:
        getMenuContainer().addView(new h(r106, false, 8.0f, r112, 0.0f));
    L22:
        r112 = R.color.ud_divider_color;
        goto L23
    L25:
        if ((r105 instanceof zya.b) == false) goto L12;
        zya.b r113 = (zya.b) r105;
        boolean r114 = g.b(r113);
        int r115 = 6;
        Integer r116 = null;
        boolean r117 = false;
        int r118 = 0;
        if (r113.f573993h != 5) goto L58;
        int r119 = WindowFreezeMonitor.f432426a;
        if (WindowFreezeMonitor.a(getMenuContainer()) == false) goto L31;
    L34:
        PopupMenuGridContainer r120 = new PopupMenuGridContainer(getContext(), null, 6, 0);
        r120.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        getMenuContainer().addView(r120);
        LinearLayout r121 = r120;
    L35:
        PopupMenuItemGrid r122 = new PopupMenuItemGrid(getContext(), r117 ? 1 : 0, r115, r118);
        LinearLayout.LayoutParams r123 = new LinearLayout.LayoutParams(-1, -2);
        r123.weight = 1.0f;
        r122.setLayoutParams(r123);
        r122.setIcon(r113.f573987b);
        r122.setText(r113.f573990e);
        Context r124 = getContext();
        int r125 = UIUtils.getColor(getContext(), R.color.icon_disable);
        com.ss.android.lark.chat.message.menu.v2.popup.d r126 = this.f415825c;
        if (r126 == null) goto L41;
        com.ss.android.lark.biz.im.api.message.params.m r127 = r126.f415885c;
        if (r127 == null) goto L41;
        r116 = r127.f410370g;
    L41:
        boolean r128 = false;
        g.c(r122, r124, r113, r110, r125, r116, r114);
        if (r114 == true) goto L44;
        r122.setAlpha(0.5f);
    L44:
        r122.setOnClickListener(new a(r105, r122, r114, this));
        if (r121.getChildCount() == 0) goto L47;
        r128 = true;
    L47:
        if (r128 == false) goto L57;
        Context r129 = getContext();
        com.ss.android.lark.chat.message.menu.v2.popup.d r130 = this.f415825c;
        if (r130 == null) goto L55;
        com.ss.android.lark.biz.im.api.message.params.m r131 = r130.f415885c;
        if (r131 == null) goto L55;
        Integer r132 = r131.f410367d;
        if (r132 == null) goto L55;
        int r133 = r132.intValue();
    L56:
        r121.addView(new h(r129, true, 0.0f, r133, 20));
    L55:
        r133 = R.color.ud_N00_10;
    L57:
        r121.addView(r122);
        goto L12
    L31:
        if ((getMenuContainer().getChildAt(getMenuContainer().getChildCount() - 1) instanceof PopupMenuGridContainer) == false) goto L34;
        View r134 = getMenuContainer().getChildAt(getMenuContainer().getChildCount() - 1);
        Intrinsics.checkNotNull(r134, "null cannot be cast to non-null type com.ss.android.lark.chat.message.menu.v2.popup.PopupMenuGridContainer");
        r121 = (PopupMenuGridContainer) r134;
        goto L35
    L58:
        boolean r135 = false;
        PopupMenuItem r136 = new PopupMenuItem(getContext(), null, 6, 0);
        r136.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r136.setIcon(r113.f573987b);
        r136.setText(r113.f573990e);
        Context r137 = getContext();
        int r138 = UIUtils.getColor(getContext(), R.color.icon_disable);
        com.ss.android.lark.chat.message.menu.v2.popup.d r139 = this.f415825c;
        if (r139 == null) goto L63;
        com.ss.android.lark.biz.im.api.message.params.m r140 = r139.f415885c;
        if (r140 == null) goto L63;
        Integer r141 = r140.f410370g;
    L64:
        g.c(r136, r137, r113, r110, r138, r141, r114);
        if (r114 == true) goto L67;
        r136.setAlpha(0.5f);
    L67:
        List<zya.b> r142 = r113.f573996k;
        List<zya.b> r143 = r142;
        if (r143 != null) goto L70;
    L73:
        boolean r144 = true;
    L74:
        boolean r145 = !r144;
        r136.a(r145);
        if (r145 == false) goto L77;
        r136.setArrowTint(r110);
    L77:
        if (r143 != null) goto L79;
    L80:
        r135 = true;
    L81:
        if (r135 == false) goto L83;
        r136.setOnClickListener(new b(r105, r136, r114, this));
        PopupMenuItem r146 = r136;
    L84:
        int r147 = WindowFreezeMonitor.f432426a;
        if (WindowFreezeMonitor.a(getMenuContainer()) == false) goto L87;
        View r148 = null;
    L88:
        if (r148 != null) goto L90;
    L100:
        getMenuContainer().addView(r146);
        goto L12
    L90:
        if ((r148 instanceof h) == true) goto L100;
        LKUIRoundLinearLayout r149 = getMenuContainer();
        Context r150 = getContext();
        com.ss.android.lark.chat.message.menu.v2.popup.d r151 = this.f415825c;
        if (r151 == null) goto L98;
        com.ss.android.lark.biz.im.api.message.params.m r152 = r151.f415885c;
        if (r152 == null) goto L98;
        Integer r153 = r152.f410367d;
        if (r153 == null) goto L98;
        int r154 = r153.intValue();
    L99:
        r149.addView(new h(r150, false, 0.0f, r154, 20));
    L98:
        r154 = R.color.ud_N00_10;
        goto L99
    L87:
        r148 = getMenuContainer().getChildAt(getMenuContainer().getChildCount() - 1);
        goto L88
    L83:
        r146 = r136;
        r146.setOnClickListener(new c(r105, r136, r114, r142, this, r210));
        goto L84
    L79:
        if (r143.isEmpty() == false) goto L81;
    L70:
        if (r143.isEmpty() == true) goto L73;
        r144 = false;
    L63:
        r141 = null;
        goto L64
    L102:
        return;
    L9:
        r104 = R.color.icon_n1;
        goto L10
    }

    private final void setReaction(com.ss.android.lark.chat.message.menu.d r100) {
        if (r100.f415496c == false) goto L26;
        com.ss.android.lark.chat.message.menu.v2.popup.d r101 = this.f415825c;
        if (r101 == null) goto L25;
        com.ss.android.lark.chat.message.menu.v2.popup.a r102 = r101.a();
        if (r102 == null) goto L28;
        BuiltInTopEmojiView r103 = new BuiltInTopEmojiView(getContext());
        int r104 = UIUtils.dp2px(getContext(), 28.0f);
        int r105 = UIUtils.dp2px(getContext(), 40.0f);
        int r106 = UIUtils.dp2px(getContext(), 40.0f);
        int r107 = UIUtils.dp2px(getContext(), 0.0f);
        r103.f415733b = r104;
        r103.f415734c = r105;
        r103.f415735d = r106;
        r103.f415736e = r107;
        if (r103.getWidth() <= 0) goto L12;
        r103.a();
    L12:
        d r108 = new d(this);
        Intrinsics.checkNotNullParameter(r102, "control");
        Intrinsics.checkNotNullParameter(r108, "reactionClickListener");
        r103.f415741j = r102;
        r103.f415742k = r108;
        com.ss.android.lark.chat.message.menu.v2.popup.d r109 = this.f415825c;
        if (r109 == null) goto L19;
        yya.a r110 = r109.f415883a;
        if (r110 == null) goto L19;
        v5b.c<?> r111 = r110.m();
        if (r111 == null) goto L19;
        Message.Type r112 = r111.getType();
    L21:
        if (r112 != Message.Type.DOUBAO) goto L23;
        boolean r113 = true;
    L24:
        r103.setLikeInFront(r113);
        ViewGroup.LayoutParams r114 = new ViewGroup.LayoutParams(-1, -2);
        getReactionContainer().removeAllViews();
        getReactionContainer().addView(r103, r114);
        getReactionContainer().setVisibility(0);
        return;
    L23:
        r113 = false;
    L19:
        r112 = null;
        goto L21
    L28:
        return;
    L25:
        return;
    L26:
        getReactionContainer().removeAllViews();
        getReactionContainer().setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        if (this.f415827e == false) goto L6;
        this.f415831i.set(getMenuContainer().getLeft(), getMenuContainer().getTop(), getMenuContainer().getRight(), getMenuContainer().getBottom());
        getMaskPaint().setAlpha((int) (this.f415829g * 128));
        r100.drawRoundRect(this.f415831i, getMenuContainer().getRadius(), getMenuContainer().getRadius(), getMaskPaint());
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f415827e == false) goto L7;
        return true;
    L7:
        return super.onInterceptTouchEvent(r100);
    }

    public final void setMenuContext(com.ss.android.lark.chat.message.menu.v2.popup.d r100) {
        this.f415825c = r100;
        if (r100 == null) goto L17;
        LKUIRoundLinearLayout r101 = getMenuContainer();
        Context r102 = getContext();
        com.ss.android.lark.biz.im.api.message.params.m r103 = r100.f415885c;
        int r104 = R.color.ud_background_color;
        if (r103 == null) goto L10;
        Integer r105 = r103.f410365b;
        if (r105 == null) goto L10;
        int r106 = r105.intValue();
    L11:
        r101.setBackgroundColor(UIUtils.getColor(r102, r106));
        LKUIRoundableLayout r107 = getReactionContainer();
        Context r108 = getContext();
        com.ss.android.lark.biz.im.api.message.params.m r109 = r100.f415885c;
        if (r109 == null) goto L16;
        Integer r110 = r109.f410365b;
        if (r110 == null) goto L16;
        r104 = r110.intValue();
    L16:
        r107.setBackgroundColor(UIUtils.getColor(r108, r104));
    L10:
        r106 = R.color.ud_background_color;
    L17:
        com.ss.android.lark.chat.message.menu.v2.popup.d r111 = this.f415825c;
        if (r111 == null) goto L29;
        com.ss.android.lark.chat.message.menu.d r112 = r111.f415884b;
        setReaction(r112);
        setMenuItems(r112);
        boolean r113 = r111.f415883a.m().h();
        ViewGroup.LayoutParams r114 = getMenuContainer().getLayoutParams();
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r115 = (LinearLayout.LayoutParams) r114;
        if (r112.f415496c == false) goto L26;
        if (r113 == false) goto L24;
        int r116 = GravityCompat.END;
    L25:
        r115.gravity = r116;
    L27:
        getMenuContainer().setLayoutParams(r115);
        return;
    L24:
        r116 = GravityCompat.START;
        goto L25
    L26:
        r115.gravity = 1;
        goto L27
    }

    public final void setOnReactionClickListener(o0 r100) {
        this.f415826d = r100;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = (int) (((double) getMeasuredWidth()) * 0.7d);
        if (getMenuContainer().getMeasuredWidth() == r102) goto L6;
        getMenuContainer().measure(View.MeasureSpec.makeMeasureSpec(r102, 1073741824), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r101), Integer.MIN_VALUE));
        return;
    }

    public PopupMenuMainContent(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f415823a = PanelType.ACTION;
        this.f415824b = IPopupMenuContent.ShadowTarget.CHILD;
        this.f415828f = LazyKt.lazy(new PopupMenuMainContent$maskPaint$2(r100, this));
        this.f415831i = new RectF();
        this.f415832j = LazyKt.lazy(new PopupMenuMainContent$reactionContainer$2(r100, this));
        this.f415833k = LazyKt.lazy(new PopupMenuMainContent$menuContainer$2(r100, this));
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        addView(getReactionContainer());
        addView(getMenuContainer());
    }

    public /* synthetic */ PopupMenuMainContent(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
