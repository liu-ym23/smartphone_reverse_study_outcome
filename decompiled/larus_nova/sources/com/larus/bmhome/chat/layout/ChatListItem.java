package com.larus.bmhome.chat.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.layout.widget.ChatCheckBox;
import com.larus.bmhome.chat.layout.widget.ChatRetry;
import com.larus.bmhome.chat.layout.widget.ChatRetryWithText;
import com.larus.bmhome.chat.layout.widget.ChatStatus;
import com.larus.bmhome.chat.layout.widget.UserRefMsgView;
import com.larus.bmhome.chat.layout.widget.h0;
import com.larus.bmhome.chat.layout.widget.w;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001V\u0018\u0000 _2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001_B)\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0010\u001a\u00020\u000eJ\b\u0010/\u001a\u000200H\u0016J\u0014\u00106\u001a\u00020\u000e2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u000f\u0010G\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010HJ\u0010\u0010I\u001a\u00020&2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010J\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010K\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010L\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020AH\u0002J\u0010\u0010M\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020AH\u0002J\u0010\u0010N\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020AH\u0002J\u0010\u0010O\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020AH\u0002J\u0010\u0010P\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020AH\u0002J\u0012\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\u0010\u0010]\u001a\u00020R2\u0006\u0010^\u001a\u00020TH\u0016R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001b\u0010%\u001a\u00020&8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0016\u001a\u0004\b'\u0010(R\u001b\u0010*\u001a\u00020+8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0016\u001a\u0004\b,\u0010-R\u001b\u00101\u001a\u0002028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0016\u001a\u0004\b3\u00104R&\u00109\u001a\u00020\t2\u0006\u00108\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010;\"\u0004\b@\u0010=R*\u0010B\u001a\u0004\u0018\u00010A2\b\u00108\u001a\u0004\u0018\u00010A8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0010\u0010U\u001a\u00020VX\u0082\u0004¢\u0006\u0004\n\u0002\u0010WR\u001b\u0010X\u001a\u00020Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010\u0016\u001a\u0004\bZ\u0010[¨\u0006`"}, d2 = {"Lcom/larus/bmhome/chat/layout/ChatListItem;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/chat/layout/MessageBoxTyped;", "Lcom/larus/bmhome/chat/layout/IChatListItem;", "ctx", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;Ljava/lang/Integer;)V", "afterRelayout", "Lkotlin/Function0;", "", "retrySpacing", "cinit", "retryView1", "Lcom/larus/bmhome/chat/layout/widget/ChatRetry;", "getRetryView1", "()Lcom/larus/bmhome/chat/layout/widget/ChatRetry;", "retryView1$delegate", "Lkotlin/Lazy;", "retryView2", "Lcom/larus/bmhome/chat/layout/widget/ChatRetryWithText;", "getRetryView2", "()Lcom/larus/bmhome/chat/layout/widget/ChatRetryWithText;", "retryView2$delegate", "chatRetryDelegate", "Lcom/larus/bmhome/chat/layout/widget/ChatRetryDelegate;", "getChatRetryDelegate", "()Lcom/larus/bmhome/chat/layout/widget/ChatRetryDelegate;", "chatRetryDelegate$delegate", "retryView", "Lcom/larus/bmhome/chat/layout/widget/IChatRetry;", "getRetryView", "()Lcom/larus/bmhome/chat/layout/widget/IChatRetry;", "checkBox", "Lcom/larus/bmhome/chat/layout/widget/ChatCheckBox;", "getCheckBox", "()Lcom/larus/bmhome/chat/layout/widget/ChatCheckBox;", "checkBox$delegate", "refMsgView", "Lcom/larus/bmhome/chat/layout/widget/UserRefMsgView;", "getRefMsgView", "()Lcom/larus/bmhome/chat/layout/widget/UserRefMsgView;", "refMsgView$delegate", "asView", "Landroid/view/ViewGroup;", "statusView", "Lcom/larus/bmhome/chat/layout/widget/ChatStatus;", "getStatusView", "()Lcom/larus/bmhome/chat/layout/widget/ChatStatus;", "statusView$delegate", "doAfterRelayout", "callback", "value", "boxType", "getBoxType", "()I", "setBoxType", "(I)V", "messageType", "getMessageType", "setMessageType", "Landroid/view/View;", "mainView", "getMainView", "()Landroid/view/View;", "setMainView", "(Landroid/view/View;)V", "relayout", "()Lkotlin/Unit;", "generateCheckBox", "generateRetryViewWithTxt", "generateRetryView", "layoutRetry", "layoutMainView", "layoutState", "layoutCheckBox", "layoutRefMsgView", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "gestureListener", "com/larus/bmhome/chat/layout/ChatListItem$gestureListener$1", "Lcom/larus/bmhome/chat/layout/ChatListItem$gestureListener$1;", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "gestureDetector$delegate", "onTouchEvent", "event", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatListItem extends ConstraintLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f303464m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f303465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f303466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f303467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f303468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f303469e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f303470f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f303471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f303472h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f303473i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f303474j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h f303475k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f303476l;

    public static final class a {
    }

    static {
    }

    public ChatListItem(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this(r100, 0);
    }

    public ChatListItem(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this(r100, 0);
    }

    private final GestureDetector getGestureDetector() {
        return (GestureDetector) this.f303476l.getValue();
    }

    private final ChatRetry getRetryView1() {
        return (ChatRetry) this.f303466b.getValue();
    }

    private final ChatRetryWithText getRetryView2() {
        return (ChatRetryWithText) this.f303467c.getValue();
    }

    public final w getChatRetryDelegate() {
        return (w) this.f303468d.getValue();
    }

    public ChatCheckBox getCheckBox() {
        return (ChatCheckBox) this.f303469e.getValue();
    }

    /* JADX INFO: renamed from: getRefMsgView, reason: collision with other method in class */
    public UserRefMsgView m8541getRefMsgView() {
        return (UserRefMsgView) this.f303470f.getValue();
    }

    public ChatStatus getStatusView() {
        return (ChatStatus) this.f303471g.getValue();
    }

    public final void S5() {
        View r100 = getMainView();
        if (r100 == null) goto L47;
        ViewGroup.LayoutParams r101 = getRetryView1().getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r101;
        ViewGroup.LayoutParams r103 = getRetryView2().getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r104 = (ConstraintLayout.LayoutParams) r103;
        int r105 = getBoxType();
        if (r105 == 0) goto L9;
        if (r105 != 1) goto L10;
        r102.startToEnd = -1;
        r102.endToStart = r100.getId();
        r102.setMarginStart(0);
        r102.setMarginEnd(this.f303465a);
        ((ViewGroup.MarginLayoutParams) r102).bottomMargin = i5.h();
        r102.bottomToBottom = r100.getId();
    L10:
        ViewGroup.LayoutParams r106 = getStatusView().getLayoutParams();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r107 = (ConstraintLayout.LayoutParams) r106;
        r107.matchConstraintMinWidth = i5.g0();
        r107.startToStart = r100.getId();
        r107.endToEnd = r100.getId();
        int r108 = getBoxType();
        if (r108 == 0) goto L15;
        if (r108 != 1) goto L16;
        getStatusView().setGravity(GravityCompat.END);
        ChatStatus r109 = getStatusView();
        int r110 = i5.r0();
        int r111 = r109.getPaddingTop();
        int r112 = r109.getPaddingBottom();
        FLogger.f375446a.i("updatePaddingRelative", "view:ChatStatus,source:,start:0,top:" + r111 + ",end:" + r110 + ",bottom:" + r112);
        r109.setPaddingRelative(0, r111, r110, r112);
    L16:
        r107.topToBottom = r100.getId();
        ((ViewGroup.MarginLayoutParams) r107).topMargin = i5.Y();
        ViewGroup.LayoutParams r113 = getCheckBox().getLayoutParams();
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r114 = (ConstraintLayout.LayoutParams) r113;
        r114.topToTop = r100.getId();
        r114.bottomToBottom = r100.getId();
        int r115 = getBoxType();
        if (r115 == 0) goto L23;
        if (r115 == 1) goto L22;
        if (r115 != 3) goto L24;
        r114.startToStart = 0;
    L24:
        r114.setMarginStart(i5.h());
        r114.setMarginEnd(i5.j0());
        ViewGroup.LayoutParams r116 = m8541getRefMsgView().getLayoutParams();
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r117 = (ConstraintLayout.LayoutParams) r116;
        if (getBoxType() != 1) goto L28;
        r117.startToStart = -1;
        r117.endToEnd = 0;
        r117.setMarginEnd(i5.h());
    L28:
        r117.topToTop = 0;
        r117.bottomToTop = r100.getId();
        if ((r100 instanceof com.larus.bmhome.chat.layout.item.i) == false) goto L31;
        com.larus.bmhome.chat.layout.item.i r118 = (com.larus.bmhome.chat.layout.item.i) r100;
    L32:
        if (r118 == null) goto L34;
        ((ViewGroup.MarginLayoutParams) r117).width = r118.getMaxWidth();
    L34:
        ViewGroup.LayoutParams r119 = r100.getLayoutParams();
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r120 = (ConstraintLayout.LayoutParams) r119;
        int r121 = getBoxType();
        if (r121 == 0) goto L44;
        if (r121 != 1) goto L38;
        r120.startToEnd = getCheckBox().getId();
        r120.endToEnd = 0;
        r120.horizontalBias = 1.0f;
        r120.constrainedWidth = true;
    L45:
        r120.topToBottom = m8541getRefMsgView().getId();
        ((ViewGroup.MarginLayoutParams) r120).topMargin = i5.j0();
        r120.goneTopMargin = 0;
        return;
    L38:
        if (r121 == 2) goto L42;
        if (r121 != 3) goto L45;
        r120.startToEnd = getCheckBox().getId();
        goto L45
    L42:
        r120.startToStart = 0;
        r120.endToEnd = 0;
        goto L45
    L44:
        r120.endToEnd = -1;
        r120.startToEnd = getCheckBox().getId();
        r120.goneStartMargin = i5.h();
        r120.setMarginStart(i5.r0());
        goto L45
    L31:
        r118 = null;
        goto L32
    L22:
        r114.startToStart = 0;
        goto L24
    L23:
        r114.startToStart = 0;
        goto L24
    L15:
        getStatusView().setGravity(GravityCompat.START);
        ChatStatus r122 = getStatusView();
        int r123 = i5.r0();
        int r124 = r122.getPaddingTop();
        int r125 = r122.getPaddingBottom();
        FLogger.f375446a.i("updatePaddingRelative", "view:ChatStatus,source:,start:" + r123 + ",top:" + r124 + ",end:0,bottom:" + r125);
        r122.setPaddingRelative(r123, r124, 0, r125);
        goto L16
    L9:
        r102.startToEnd = r100.getId();
        r102.endToStart = -1;
        r102.setMarginStart(this.f303465a);
        r102.setMarginEnd(0);
        ((ViewGroup.MarginLayoutParams) r102).bottomMargin = i5.h();
        r102.bottomToBottom = r100.getId();
        r104.startToStart = r100.getId();
        r104.endToEnd = -1;
        r104.topToBottom = r100.getId();
        r104.setMarginStart(0);
        r104.setMarginEnd(0);
        ((ViewGroup.MarginLayoutParams) r104).topMargin = i5.r0();
        ((ViewGroup.MarginLayoutParams) r104).bottomMargin = 0;
        goto L10
    }

    public h0 getRetryView() {
        return getChatRetryDelegate().f305295a;
    }

    public int getBoxType() {
        return this.f303472h;
    }

    public View getMainView() {
        return this.f303474j;
    }

    public final int getMessageType() {
        return this.f303473i;
    }

    public /* bridge */ /* synthetic */ l getRefMsgView() {
        return m8541getRefMsgView();
    }

    public static w R5(ChatListItem r100) {
        return new w(r100.getRetryView1(), r100.getRetryView2());
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (getCheckBox().getInterceptTouchEvent() == false) goto L7;
        return true;
    L7:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (getCheckBox().getVisibility() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        return getGestureDetector().onTouchEvent(r100);
    L10:
        return super.onTouchEvent(r100);
    L5:
        r101 = false;
        goto L6
    }

    public void setBoxType(int r100) {
        this.f303472h = r100;
        S5();
    }

    public void setMainView(View r100) {
        View r101 = this.f303474j;
        if (r101 == null) goto L5;
        removeView(r101);
        removeView(getRetryView1());
        removeView(getRetryView2());
    L5:
        this.f303474j = r100;
        if (r100 != null) goto L9;
        return;
    L9:
        if (r100.getId() != (-1)) goto L11;
        r100.setId(R.id.chat_item);
    L11:
        boolean r102 = false;
        addView(r100, 0);
        if (indexOfChild(getRetryView1()) == (-1)) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == true) goto L18;
        addView(getRetryView1(), 1);
    L18:
        if (indexOfChild(getStatusView()) == (-1)) goto L20;
        boolean r104 = true;
    L21:
        if (r104 == true) goto L24;
        addView(getStatusView(), 2);
    L24:
        if (indexOfChild(getCheckBox()) == (-1)) goto L26;
        boolean r105 = true;
    L27:
        if (r105 == true) goto L33;
        if (getCheckBox().getId() != (-1)) goto L31;
        getCheckBox().setId(R.id.chat_item_checkbox);
    L31:
        addView(getCheckBox(), 3);
    L33:
        if (indexOfChild(m8541getRefMsgView()) == (-1)) goto L35;
        boolean r106 = true;
    L36:
        if (r106 == true) goto L42;
        if (m8541getRefMsgView().getId() != (-1)) goto L40;
        m8541getRefMsgView().setId(R.id.chat_item_ref_msg);
    L40:
        addView(m8541getRefMsgView(), 4);
    L42:
        if (indexOfChild(getRetryView2()) == (-1)) goto L44;
        r102 = true;
    L44:
        if (r102 == true) goto L46;
        addView(getRetryView2(), 5);
    L46:
        S5();
        return;
    L35:
        r106 = false;
        goto L36
    L26:
        r105 = false;
        goto L27
    L20:
        r104 = false;
        goto L21
    L14:
        r103 = false;
        goto L15
    }

    public final void setMessageType(int r100) {
        this.f303473i = r100;
    }

    public ChatListItem(final Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f303465a = getResources().getDimensionPixelSize(R.dimen.larus_message_widget_retry_spacing);
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.f303466b = LazyKt.lazy(new com.larus.bmhome.chat.layout.a(this, r100));
        this.f303467c = LazyKt.lazy(new b(this));
        this.f303468d = LazyKt.lazy(new c(this));
        this.f303469e = LazyKt.lazy(new d(this));
        this.f303470f = LazyKt.lazy(new e(this));
        this.f303471g = LazyKt.lazy(new f(this));
        this.f303472h = -1;
        this.f303475k = new h(this);
        this.f303476l = LazyKt.lazy(new g(this));
    }
}
