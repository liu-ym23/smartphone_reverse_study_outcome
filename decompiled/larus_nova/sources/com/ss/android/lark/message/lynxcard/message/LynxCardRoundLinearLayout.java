package com.ss.android.lark.message.lynxcard.message;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.larksuite.component.card.navigation.UniversalCardLargeScreenAdapt;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001'B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u001c\u001a\u00020\u00122\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J\u0016\u0010\u001e\u001a\u00020\u00122\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0002R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/ss/android/lark/message/lynxcard/message/LynxCardRoundLinearLayout;", "Lcom/larksuite/component/ui/layout/LKUIRoundLinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widthMode", "Lcom/ss/android/lark/chat/entity/message/content/CardContent$WidthMode;", "getWidthMode", "()Lcom/ss/android/lark/chat/entity/message/content/CardContent$WidthMode;", "setWidthMode", "(Lcom/ss/android/lark/chat/entity/message/content/CardContent$WidthMode;)V", "cardTapListener", "Lkotlin/Function0;", "", "cardTapObserver", "downX", "", "downY", "downTime", "", "trackingTap", "", "touchSlop", "setOnCardTapListener", "listener", "setOnCardTapObserver", "observer", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "handleCardTap", "Companion", "message-card_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxCardRoundLinearLayout extends LKUIRoundLinearLayout {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CardContent.WidthMode f432158r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Function0<Unit> f432159s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Function0<Unit> f432160t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f432161u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f432162v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f432163w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f432164x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f432165y;

    public static final class a {
    }

    static {
    }

    public LynxCardRoundLinearLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LynxCardRoundLinearLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final CardContent.WidthMode getWidthMode() {
        return this.f432158r;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f432159s == null) goto L5;
        boolean r101 = true;
    L6:
        boolean r102 = super.dispatchTouchEvent(r100);
        int r103 = r100.getActionMasked();
        if (r103 == 0) goto L33;
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L34;
        this.f432164x = false;
    L34:
        if (r102 == true) goto L39;
        if (r101 == true) goto L40;
        return false;
    L40:
        return true;
    L39:
        return true;
    L16:
        if (this.f432164x == false) goto L34;
        if (Math.abs(r100.getX() - this.f432161u) <= this.f432165y) goto L20;
    L21:
        this.f432164x = false;
        goto L34
    L20:
        if (Math.abs(r100.getY() - this.f432162v) <= this.f432165y) goto L34;
    L23:
        if (this.f432164x == true) goto L25;
    L32:
        this.f432164x = false;
        goto L34
    L25:
        if ((r100.getEventTime() - this.f432163w) >= ViewConfiguration.getLongPressTimeout()) goto L32;
        Function0<Unit> r104 = this.f432160t;
        if (r104 == null) goto L29;
        r104.invoke();
    L29:
        Function0<Unit> r105 = this.f432159s;
        if (r105 == null) goto L32;
        r105.invoke();
        goto L32
    L33:
        this.f432161u = r100.getX();
        this.f432162v = r100.getY();
        this.f432163w = r100.getEventTime();
        this.f432164x = true;
        goto L34
    L5:
        r101 = false;
        goto L6
    }

    public final void setOnCardTapListener(Function0<Unit> r100) {
        this.f432159s = r100;
        this.f432164x = false;
    }

    public final void setOnCardTapObserver(Function0<Unit> r100) {
        this.f432160t = r100;
    }

    public final void setWidthMode(CardContent.WidthMode r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f432158r = r100;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getSize(r100);
        Log.d("LynxCardRoundLinearLayout", "onMeasure: widthMode=" + r102 + ", widthSize=" + r103 + ", heightMode=" + View.MeasureSpec.getMode(r101) + ", heightSize=" + View.MeasureSpec.getSize(r101));
        Lazy r104 = UniversalCardLargeScreenAdapt.f283725a;
        if (UniversalCardLargeScreenAdapt.d(getContext(), this.f432158r) == false) goto L6;
        super.onMeasure(r100, r101);
        return;
    L6:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(UniversalCardLargeScreenAdapt.a(getContext(), r103, this.f432158r), 1073741824), r101);
    }

    public LynxCardRoundLinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f432158r = CardContent.WidthMode.DEFAULT;
        this.f432165y = ViewConfiguration.get(r100).getScaledTouchSlop();
    }

    public /* synthetic */ LynxCardRoundLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
