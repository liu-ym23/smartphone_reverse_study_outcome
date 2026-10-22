package com.larus.bmhome.chat.cell.view;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.component.collection.o;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.layout.item.i;
import com.larus.bmhome.utils.z1;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import ed8.c;
import ed8.e;
import ed8.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import s1a.a;
import t1a.b;
import v19.c7;
import va8.p;
import va8.t;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010(\u001a\u00020)2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0011\u001a\u00020*J\u000e\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020\nJ\u0010\u0010/\u001a\u00020)2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u0016H\u0002J\u0018\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\u001eH\u0014J\u0010\u00105\u001a\u00020)2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010:\u001a\u00020\nH\u0002J\b\u0010;\u001a\u00020\nH\u0002J\u0012\u0010<\u001a\u00020)2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010=\u001a\u00020)H\u0002J\u0010\u0010>\u001a\u00020\n2\u0006\u00101\u001a\u00020\u0016H\u0002J\u0010\u0010?\u001a\u00020\u00182\u0006\u00101\u001a\u00020\u0016H\u0002J\u0018\u0010@\u001a\u00020)2\u0006\u0010A\u001a\u00020\n2\u0006\u0010B\u001a\u00020*H\u0002J\f\u0010C\u001a\u00020\u001e*\u00020*H\u0002J\b\u0010D\u001a\u00020\u001eH'J\b\u0010E\u001a\u00020)H\u0004J\u0012\u0010F\u001a\u00020\n2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u0010\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020HH\u0017J\u0006\u0010K\u001a\u00020\u0012J\b\u0010L\u001a\u00020)H\u0014J\b\u0010M\u001a\u00020)H\u0014R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\"R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/larus/bmhome/chat/cell/view/AbstractMessageBoxContainerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/chat/cell/view/IMessageHolderTouchInterceptor;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "enableReceiveMsgBubbleExpand", "", "getEnableReceiveMsgBubbleExpand", "()Z", "enableReceiveMsgBubbleExpand$delegate", "Lkotlin/Lazy;", "contentView", "Lcom/larus/bmhome/chat/cell/view/CustomStubView;", "boxView", "Landroid/view/View;", "longMessageExpandView", "Landroid/widget/TextView;", "currentMessage", "Lcom/larus/im/bean/message/Message;", "currentLongMessageCollapseScope", "", "boundCollapseGeneration", "", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "lastDispatchedContainerWidth", "", "needTopMargin", "getNeedTopMargin", "setNeedTopMargin", "(Z)V", "needBottomMargin", "getNeedBottomMargin", "setNeedBottomMargin", "gestureInterceptor", "Lcom/larus/bmhome/chat/cell/view/GestureInterceptor;", "setupContainerView", "", "Lcom/larus/bmhome/chat/layout/item/BaseMessageBox;", "bindViewExtra", "data", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "isRequestFocus", "setupMainView", "bindCollapseConfig", "message", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setupRuyiCardView", "chatShareCoreAbility", "Lcom/larus/bmhome/ability/IChatShareCoreAbility;", "chatCollectMessageAbility", "Lcom/larus/bmhome/chat/component/collection/IChatCollectMessageAbility;", "isShareMode", "isCollectionMode", "setGestureInterceptor", "internalInit", "isSearchLandingTarget", "longMessageCollapseScope", "updateLongMessageExpandView", "collapsed", "messageBox", "backgroundColorForLongMessageCollapse", "getLayoutId", "prepareMessageBoxMeasureIfContainerWidthChanged", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "event", "getBoxView", "onAttachedToWindow", "onDetachedFromWindow", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbstractMessageBoxContainerView extends ConstraintLayout implements g {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f297851o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f297852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CustomStubView f297853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f297854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f297855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Message f297856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f297857f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f297858g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Fragment f297859h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f297860i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f297861j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f297862k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public e f297863l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public t f297864m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public o f297865n;

    public abstract int getLayoutId();

    private final boolean getEnableReceiveMsgBubbleExpand() {
        return ((Boolean) this.f297852a.getValue()).booleanValue();
    }

    public final boolean T5() {
        Fragment r100 = this.f297859h;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L32;
        Fragment r102 = this.f297859h;
        if (r102 != null) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == false) goto L32;
        if (this.f297864m != null) goto L25;
        Fragment r104 = this.f297859h;
        if (r104 == null) goto L23;
        b r105 = a.g(r104);
        if (r105 == null) goto L23;
        t r106 = (t) r105.getAbility(t.class);
    L24:
        this.f297864m = r106;
    L23:
        r106 = null;
    L25:
        t r107 = this.f297864m;
        if (r107 != null) goto L28;
    L30:
        return false;
    L28:
        if (r107.H1() != true) goto L30;
        return true;
    L12:
        if (r102.isDetached() == true) goto L14;
        r103 = true;
    L32:
        return false;
    L5:
        if (r100.isAdded() != true) goto L7;
        r101 = true;
        goto L8
    }

    public final void U5() {
        if (this.f297854c != null) goto L5;
        return;
    L5:
        Lazy r100 = z1.f315157a;
        int r101 = z1.e(this.f297859h);
        if (r101 > 0) goto L8;
        return;
    L8:
        if (r101 == this.f297860i) goto L25;
        this.f297860i = r101;
        i r102 = this.f297854c;
        if (r102 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("boxView");
        r102 = null;
    L14:
        if ((r102 instanceof i) == true) goto L17;
        r102 = null;
    L17:
        if (r102 != null) goto L19;
        return;
    L19:
        if (z1.a(this.f297859h) == false) goto L26;
        r102.f304396c = null;
        r102.f304395b.f304350e = -1;
        r102.forceLayout();
        FLogger.f375446a.i("MsgBoxWidthTag", "[notifyContainerWidthChanged] called");
        return;
    L26:
        return;
    }

    public final View getBoxView() {
        i r100 = this.f297854c;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("boxView");
        return null;
    L6:
        return r100;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        long r100 = this.f297858g;
        dh8.b.f468639a.getClass();
        if (r100 == dh8.b.f468641c) goto L8;
        Message r101 = this.f297856e;
        if (r101 == null) goto L9;
        R5(r101);
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ViewParent r100 = getParent();
        if ((r100 instanceof RecyclerView) == false) goto L5;
        RecyclerView r101 = (RecyclerView) r100;
    L6:
        if (r101 != null) goto L8;
    L15:
        boolean r102 = true;
    L16:
        if (r102 == false) goto L26;
        i r103 = this.f297854c;
        if (r103 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("boxView");
        r103 = null;
    L21:
        if ((r103 instanceof i) == true) goto L24;
        r103 = null;
    L24:
        if (r103 == null) goto L26;
        r103.f304400g = null;
    L26:
        super.onDetachedFromWindow();
        return;
    L8:
        if (r101.isAttachedToWindow() == false) goto L15;
        if (getBottom() <= r101.getPaddingTop()) goto L15;
        if (getTop() >= (r101.getHeight() - r101.getPaddingBottom())) goto L15;
        r102 = false;
        goto L16
    L5:
        r101 = null;
        goto L6
    }

    public final boolean getNeedBottomMargin() {
        return this.f297862k;
    }

    public final boolean getNeedTopMargin() {
        return this.f297861j;
    }

    public AbstractMessageBoxContainerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    private final void setupMainView(xc8.b r100) {
        this.f297856e = r100.getMessage();
        if (getEnableReceiveMsgBubbleExpand() == false) goto L14;
        i r101 = this.f297854c;
        i r102 = null;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("boxView");
        r101 = null;
    L8:
        if ((r101 instanceof i) == false) goto L10;
        r102 = r101;
    L10:
        if (r102 == null) goto L14;
        Lazy r103 = z1.f315157a;
        if (z1.b(r102.getBoxType(), r102.getImmerseBgColor()) == false) goto L14;
        r102.l(T5(), d.J0(r100.getMessage()));
    L14:
        R5(r100.getMessage());
        setupRuyiCardView(r100);
    }

    private final void setupRuyiCardView(xc8.b r100) {
        i r101 = this.f297854c;
        i r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("boxView");
        r101 = null;
    L6:
        if ((r101 instanceof i) == false) goto L8;
        r102 = r101;
    L8:
        if (r102 == null) goto L28;
        List<String> r103 = d.K(r100.getMessage());
        boolean r104 = false;
        if (r103 != null) goto L12;
    L14:
        boolean r105 = false;
    L15:
        r102.setRequestFocus(r105);
        List<String> r106 = d.K(r100.getMessage());
        if (r106 != null) goto L18;
    L20:
        if (r104 == true) goto L22;
        return;
    L22:
        if (d.j0(r100.getMessage()) == true) goto L24;
    L26:
        r102.setBackground(r102.getInboxBackground());
        return;
    L24:
        if (d.A0(r100.getMessage()) == false) goto L26;
        r102.setBackgroundResource(R.color.transparent);
        return;
    L18:
        if ((!((ArrayList) r106).isEmpty()) != true) goto L20;
        r104 = true;
        goto L20
    L12:
        if (((ArrayList) r103).contains("exchange_rate") != true) goto L14;
        r105 = true;
        goto L15
    }

    public final void R5(Message r310) {
        i r100 = this.f297854c;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("boxView");
        r100 = null;
    L6:
        if ((r100 instanceof i) == true) goto L9;
        r100 = null;
    L9:
        if (r100 != null) goto L11;
        return;
    L11:
        Fragment r101 = this.f297859h;
        if (r101 != null) goto L14;
    L28:
        wc9.e r102 = null;
    L29:
        StringBuilder r103 = new StringBuilder();
        String r104 = "";
        if (r102 == null) goto L33;
        String r105 = r102.f559198a;
        if (r105 == null) goto L33;
    L36:
        r103.append(r105);
        r103.append(':');
        if (r102 == null) goto L40;
        String r106 = r102.B;
        if (r106 == null) goto L40;
    L43:
        r104 = r106;
    L44:
        r103.append(r104);
        this.f297857f = r103.toString();
        if (d.G0(r310) == false) goto L47;
        dh8.b.f468639a.getClass();
        int r107 = ra9.a.f536860a;
        boolean r108 = ga9.a.b("message_send_long_message_collapse_enabled", false);
    L48:
        if (r108 == false) goto L191;
        dh8.b r109 = dh8.b.f468639a;
        Context r110 = getContext();
        r109.getClass();
        boolean r111 = dh8.b.f(dh8.b.c(r310));
        boolean r210 = T5();
        boolean r112 = d.J0(r310);
        Fragment r113 = this.f297859h;
        if (r113 != null) goto L52;
    L54:
        boolean r114 = false;
    L55:
        if (r114 == false) goto L77;
        Fragment r115 = this.f297859h;
        if (r115 != null) goto L59;
    L61:
        boolean r116 = false;
    L62:
        if (r116 == false) goto L77;
        if (this.f297865n != null) goto L72;
        Fragment r117 = this.f297859h;
        if (r117 == null) goto L70;
        b r118 = a.g(r117);
        if (r118 == null) goto L70;
        o r119 = (o) r118.getAbility(o.class);
    L71:
        this.f297865n = r119;
    L70:
        r119 = null;
    L72:
        o r120 = this.f297865n;
        if (r120 == null) goto L77;
        if (r120.i0() != true) goto L77;
        boolean r121 = true;
    L78:
        Fragment r122 = this.f297859h;
        if (r122 != null) goto L81;
    L83:
        boolean r123 = false;
    L84:
        if (r123 == false) goto L102;
        Fragment r124 = this.f297859h;
        if (r124 != null) goto L88;
    L90:
        boolean r125 = false;
    L91:
        if (r125 == true) goto L102;
        Fragment r126 = this.f297859h;
        if (r126 == null) goto L102;
        b r127 = a.g(r126);
        if (r127 == null) goto L102;
        p r128 = (p) r127.getAbility(p.class);
        if (r128 == null) goto L102;
        if (r128.Q80(r310.getMessageId()) != true) goto L102;
        boolean r129 = true;
    L103:
        String r130 = this.f297857f;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r310, "message");
        Intrinsics.checkNotNullParameter(r130, "stateScope");
        boolean r131 = d.G0(r310);
        if (r131 == false) goto L106;
        boolean r132 = ga9.a.b("message_send_long_message_collapse_enabled", false);
    L107:
        Message r133 = dh8.b.c(r310);
        String r134 = dh8.b.j(r310);
        String r135 = dh8.b.n(r310);
        Integer r136 = dh8.b.m(r310, r135);
        if (r136 == null) goto L122;
        String r137 = com.larus.im.bean.message.a.D(r310);
        if (r137 != null) goto L113;
    L116:
        boolean r138 = true;
    L117:
        if (r138 == true) goto L119;
        Message r139 = r310;
    L123:
        String r140 = dh8.b.i(r310, r134, r136);
        if (r136 == null) goto L134;
        int r141 = r136.intValue();
        Message r142 = r139;
        Context r143 = r110;
        Integer r144 = dh8.b.f468644f.put(dh8.b.d(r130, r134), Integer.valueOf(r141));
        if (r144 != null) goto L128;
    L130:
        boolean r145 = false;
    L132:
        if (r145 != true) goto L135;
        boolean r211 = true;
    L136:
        if (r211 == false) goto L138;
    L143:
        dh8.b.f468642d.add(r140);
    L144:
        String r146 = dh8.b.d(r130, r140);
        if (r132 == false) goto L160;
        if (r111 == false) goto L160;
        if (dh8.b.f(r133) == false) goto L160;
        if (r112 == true) goto L160;
        if (r121 == true) goto L160;
        if (r129 == true) goto L160;
        if (r131 == true) goto L159;
        if (r133 != null) goto L155;
    L157:
        boolean r147 = false;
    L158:
        if (r147 == false) goto L160;
    L155:
        if (d.j0(r133) != true) goto L157;
        r147 = true;
    L159:
        boolean r148 = true;
    L161:
        if (r148 == false) goto L163;
        int r149 = dh8.b.b(r143);
    L164:
        if (r148 == false) goto L166;
        int r150 = dh8.b.e(r149);
    L168:
        if (r131 == false) goto L170;
        r149 = r149 / 3;
    L170:
        if (r148 == true) goto L172;
    L174:
        boolean r151 = false;
    L175:
        long r152 = dh8.b.f468641c;
        if (r131 == false) goto L178;
        String r153 = "send";
    L179:
        String r212 = r153;
        if (r148 == true) goto L182;
    L186:
        boolean r213 = false;
    L187:
        if (r142 == null) goto L189;
        String r214 = r142.getMessageId();
    L190:
        dh8.a r154 = new dh8.a(r148, r150, r149, r151, r152, r140, r130, r212, r210, r213, r134, r135, r136, r214, r211);
    L192:
        dh8.b.f468639a.getClass();
        this.f297858g = dh8.b.f468641c;
        final i r155 = r100;
        Function1<? super Boolean, Unit> r156 = new ed8.a(this, r155);
        Intrinsics.checkNotNullParameter(r156, "stateListener");
        dh8.a r157 = r155.f304398e;
        if (r154 != null) goto L198;
        r155.f304398e = null;
        r155.f304400g = null;
        r155.f304401h = null;
        r155.f304399f = false;
        r155.setClipToOutline(false);
        r156.invoke(Boolean.FALSE);
        if (r157 == null) goto L253;
        r155.requestLayout();
        return;
    L253:
        return;
    L198:
        if (r157 == null) goto L205;
        String r158 = r157.f468629f;
        if (r158 == null) goto L205;
        if ((!StringsKt.isBlank(r158)) != true) goto L205;
        boolean r159 = true;
    L206:
        if (r159 == true) goto L208;
    L214:
        boolean r160 = false;
    L215:
        if (r160 == false) goto L228;
        if (r157 != null) goto L219;
    L221:
        boolean r161 = false;
    L222:
        if (r161 == false) goto L227;
        if (r154.f468632i == false) goto L227;
        Boolean r162 = Boolean.valueOf(r155.f304399f);
    L230:
        r155.f304400g = r162;
        if (r160 == true) goto L233;
    L238:
        boolean r163 = true;
    L239:
        r155.f304398e = r154;
        r155.f304401h = r156;
        if (r163 == true) goto L242;
        r156.invoke(Boolean.valueOf(r155.f304399f));
    L251:
        r155.requestLayout();
        return;
    L242:
        if (r154.f468624a == true) goto L244;
    L248:
        boolean r164 = false;
    L249:
        r155.f304399f = r164;
        r156.invoke(Boolean.valueOf(r164));
        goto L251
    L244:
        if (r154.f468627d == true) goto L248;
        if (r154.f468633j == false) goto L248;
        r164 = true;
        goto L249
    L233:
        if (r154.f468624a == false) goto L238;
        if (r154.f468627d == true) goto L238;
        r163 = false;
    L227:
        if (r154.f468632i == false) goto L228;
        r162 = r155.f304400g;
        goto L230
    L219:
        if (r157.f468632i == true) goto L221;
        r161 = true;
    L228:
        r162 = null;
        goto L230
    L208:
        if (Intrinsics.areEqual(r157.f468629f, r154.f468629f) == false) goto L214;
        if (Intrinsics.areEqual(r157.f468630g, r154.f468630g) == false) goto L214;
        if (r157.f468628e != r154.f468628e) goto L214;
        r160 = true;
    L205:
        r159 = false;
        goto L206
    L189:
        r214 = null;
        goto L190
    L182:
        if (dh8.b.f468643e.contains(r146) == false) goto L186;
        if (dh8.b.f468642d.contains(r140) == true) goto L186;
        r213 = true;
        goto L187
    L178:
        r153 = "reply";
        goto L179
    L172:
        if (dh8.b.f468642d.contains(r140) == false) goto L174;
        r151 = true;
        goto L175
    L166:
        r150 = 0;
        goto L168
    L163:
        r149 = 0;
    L160:
        r148 = false;
        goto L161
    L138:
        if (dh8.b.f468649k.contains(r310.getConversationId() + ':' + r140) == true) goto L143;
        if (dh8.b.f468645g.contains(r135 + "#sub:" + r136) == true) goto L143;
        if (Intrinsics.areEqual(r134, dh8.b.f468647i) == false) goto L144;
    L135:
        r211 = false;
        goto L136
    L128:
        if (r144.intValue() == r141) goto L130;
        r145 = true;
        goto L132
    L134:
        r142 = r139;
        r143 = r110;
        goto L135
    L119:
        List<Message> r165 = r310.getSubList();
        if (r165 == null) goto L122;
        r139 = (Message) CollectionsKt.getOrNull(r165, r136.intValue());
        goto L123
    L113:
        if (StringsKt.isBlank(r137) == true) goto L116;
        r138 = false;
    L122:
        r139 = null;
        goto L123
    L106:
        r132 = ga9.a.b("message_reply_long_message_collapse_enabled", false);
        goto L107
    L88:
        if (r124.isDetached() != true) goto L90;
        r125 = true;
    L102:
        r129 = false;
        goto L103
    L81:
        if (r122.isAdded() != true) goto L83;
        r123 = true;
        goto L84
    L59:
        if (r115.isDetached() == true) goto L61;
        r116 = true;
    L77:
        r121 = false;
        goto L78
    L52:
        if (r113.isAdded() != true) goto L54;
        r114 = true;
        goto L55
    L191:
        r100 = r100;
        r154 = null;
        goto L192
    L47:
        dh8.b.f468639a.getClass();
        int r166 = ra9.a.f536860a;
        r108 = ga9.a.b("message_reply_long_message_collapse_enabled", false);
    L40:
        r106 = r310.getSectionId();
        if (r106 != null) goto L43;
    L33:
        r105 = r310.getConversationId();
        if (r105 != null) goto L36;
        r105 = "";
        goto L36
    L14:
        if (r101.isAdded() == true) goto L16;
    L18:
        boolean r167 = false;
    L19:
        if (r167 == true) goto L22;
        r101 = null;
    L22:
        if (r101 == null) goto L28;
        b r168 = a.g(r101);
        if (r168 == null) goto L28;
        y r169 = (y) r168.getAbility(y.class);
        if (r169 == null) goto L28;
        r102 = r169.h();
        goto L29
    L16:
        if (r101.isDetached() == true) goto L18;
        r167 = true;
        goto L19
    }

    public final void S5(xc8.b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        setupMainView(r100);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        e r101 = this.f297863l;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L11;
        return true;
    L11:
        return super.onInterceptTouchEvent(r100);
    L5:
        if (r101.c() != true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        e r101 = this.f297863l;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        if (r102 == false) goto L16;
        e r103 = this.f297863l;
        if (r103 == null) goto L14;
        GestureDetector r104 = r103.b();
        if (r104 == null) goto L14;
        return r104.onTouchEvent(r100);
    L14:
        return super.onTouchEvent(r100);
    L16:
        return super.onTouchEvent(r100);
    L5:
        if (r101.a(r100) != true) goto L7;
        r102 = true;
        goto L7
    }

    @Override // ed8.g
    public void setGestureInterceptor(e r100) {
        this.f297863l = r100;
    }

    public final void setNeedBottomMargin(boolean r100) {
        this.f297862k = r100;
    }

    public final void setNeedTopMargin(boolean r100) {
        this.f297861j = r100;
    }

    public AbstractMessageBoxContainerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f297852a = LazyKt.lazy(new ed8.b());
        this.f297857f = "";
        this.f297858g = -1;
        this.f297860i = -1;
        this.f297861j = true;
        this.f297862k = true;
        this.f297853b = (CustomStubView) LayoutInflater.from(getContext()).inflate(getLayoutId(), this).findViewById(com.larus.nova.R.id.content_view);
        TextView r102 = new TextView(getContext());
        r102.setId(com.larus.nova.R.id.larus_long_message_expand);
        r102.setText(r102.getContext().getString(com.larus.nova.R.string.larus_infra_expandLongMsg_cta_expand));
        r102.setTextSize(15.0f);
        r102.setGravity(81);
        r102.setIncludeFontPadding(false);
        TextViewCompat.setLineHeight(r102, c7.b(16));
        r102.setPadding(0, 0, 0, c7.b(12));
        r102.setVisibility(8);
        r102.setClickable(true);
        r102.setFocusable(true);
        r102.setImportantForAccessibility(1);
        r102.setContentDescription(r102.getText());
        r102.setOnClickListener(new c(this));
        this.f297855d = r102;
        dh8.b.f468639a.getClass();
        ConstraintLayout.LayoutParams r103 = new ConstraintLayout.LayoutParams(0, c7.b(60));
        r103.startToStart = com.larus.nova.R.id.content_view;
        r103.endToEnd = com.larus.nova.R.id.content_view;
        r103.bottomToBottom = com.larus.nova.R.id.content_view;
        Unit r104 = Unit.INSTANCE;
        addView(r102, r103);
        TextView r105 = this.f297855d;
        if (r105 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("longMessageExpandView");
        r105 = null;
    L5:
        ViewCompat.setElevation(r105, c7.b(1));
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    public final void V5(Fragment r100, i r101) {
        Intrinsics.checkNotNullParameter(r101, "boxView");
        this.f297854c = r101;
        this.f297859h = r100;
        this.f297860i = -1;
        CustomStubView r102 = this.f297853b;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        r102 = null;
    L5:
        CustomStubView.a(r102, r101);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        long r102 = this.f297858g;
        dh8.b.f468639a.getClass();
        if (r102 == dh8.b.f468641c) goto L7;
        Message r103 = this.f297856e;
        if (r103 == null) goto L7;
        R5(r103);
    L7:
        super.onMeasure(r100, r101);
    }
}
