package com.larus.bmhome.view.chatinput;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.activity.result.ActivityResultCaller;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.component.bottom.core.speaker.l;
import com.larus.bmhome.chat.i4;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.i;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.y0;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import et8.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ye8.d;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u001b\u0018\u0000 02\u00020\u0001:\u00010B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u000fJ\u0012\u0010%\u001a\u00020\u000f2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u001a\u0010(\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020'H\u0002J\u0012\u0010,\u001a\u00020\u000f2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010-\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020'H\u0016J\u0006\u0010.\u001a\u00020/R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b\"\u0010#¨\u00061"}, d2 = {"Lcom/larus/bmhome/view/chatinput/ChatInput;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/input/impl/databinding/LarusWidgetInputBinding;", "getBinding", "()Lcom/larus/input/impl/databinding/LarusWidgetInputBinding;", "isImmersiveSlidingFeedVertical", "", "actionDownInActionBar", "onUserTouchInput", "Lkotlin/Function0;", "", "getOnUserTouchInput", "()Lkotlin/jvm/functions/Function0;", "setOnUserTouchInput", "(Lkotlin/jvm/functions/Function0;)V", "setIsImmersiveSlidingFeedVertical", "isVertical", "gestureListener", "com/larus/bmhome/view/chatinput/ChatInput$gestureListener$2$1", "getGestureListener", "()Lcom/larus/bmhome/view/chatinput/ChatInput$gestureListener$2$1;", "gestureListener$delegate", "Lkotlin/Lazy;", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "gestureDetector$delegate", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isTouchInView", "view", "Landroid/view/View;", "event", "onInterceptTouchEvent", "onTouchEvent", "inputAreaContainer", "Landroid/view/ViewGroup;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatInput extends ConstraintLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f316859g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusWidgetInputBinding f316860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f316861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f316862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f316863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f316864e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f316865f;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes26.dex */
    public static final class b extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatInput f316866a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            return true;
        }

        public b(ChatInput r100) {
            this.f316866a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            this.f316866a.performClick();
            return true;
        }
    }

    static {
    }

    public ChatInput(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChatInput(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final GestureDetector getGestureDetector() {
        return (GestureDetector) this.f316865f.getValue();
    }

    private final b getGestureListener() {
        return (b) this.f316864e.getValue();
    }

    public final LarusWidgetInputBinding getBinding() {
        return this.f316860a;
    }

    public final Function0<Unit> getOnUserTouchInput() {
        return this.f316863d;
    }

    public static GestureDetector R5(ChatInput r100) {
        return new GestureDetector(r100.getContext(), r100.getGestureListener());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100 != null) goto L70;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L21;
        Function0<Unit> r102 = this.f316863d;     // Catch: Throwable -> L7
        if (r102 == null) goto L14;
        r102.invoke();     // Catch: Throwable -> L7
    L14:
        ViewParent r103 = getParent();     // Catch: Throwable -> L7
        if (r103 == null) goto L68;
        r103.requestDisallowInterceptTouchEvent(true);     // Catch: Throwable -> L7
    L68:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L19
        this.f316862c = S5(findViewById(R.id.action_bar_container), r100);     // Catch: Throwable -> L19
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L64:
        return super.dispatchTouchEvent(r100);
    L19:
        th = move-exception;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L7
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        FLogger.f375446a.e("ChatInput", "dispatchTouchEvent failed:" + th);
        return true;
    L21:
        if (r100 != null) goto L23;
    L25:
        boolean r106 = false;
    L26:
        if (r106 == false) goto L64;
        if (S5(this, r100) == true) goto L64;
        if (this.f316861b == false) goto L64;
        if (this.f316862c == false) goto L64;
        ComponentCallbacks2 r107 = AppHost.f326268a.a().getCurrentActivity();     // Catch: Throwable -> L7
        l r108 = null;
        if ((r107 instanceof i4) == false) goto L36;
        i4 r109 = (i4) r107;     // Catch: Throwable -> L7
    L37:
        if (r109 == null) goto L40;
        Fragment r110 = r109.getCurrentFragment();     // Catch: Throwable -> L7
        if (r110 == null) goto L40;
    L53:
        if (r110 == null) goto L55;
        r108 = (l) s1a.a.g(r110).getAbility(l.class);     // Catch: Throwable -> L7
    L55:
        if (r108 != null) goto L57;
    L59:
        boolean r111 = false;
    L60:
        if (r111 == true) goto L64;
        ViewParent r112 = getParent();     // Catch: Throwable -> L7
        if (r112 == null) goto L64;
        r112.requestDisallowInterceptTouchEvent(false);     // Catch: Throwable -> L7
        goto L64
    L57:
        if (r108.m0() != true) goto L59;
        r111 = true;
    L40:
        IFlowSdkDepend r113 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L7
        if (r113 == null) goto L45;
        r113.f0();     // Catch: Throwable -> L7
        ActivityResultCaller r114 = i.f346186a.a();     // Catch: Throwable -> L7
    L47:
        if ((r114 instanceof i4) == false) goto L49;
        i4 r115 = (i4) r114;     // Catch: Throwable -> L7
    L50:
        if (r115 == null) goto L52;
        r110 = r115.getCurrentFragment();     // Catch: Throwable -> L7
        goto L53
    L52:
        r110 = null;
        goto L53
    L49:
        r115 = null;
        goto L50
    L45:
        r114 = null;
        goto L47
    L36:
        r109 = null;
        goto L37
    L23:
        if (r100.getActionMasked() != 2) goto L25;
        r106 = true;
        goto L26
    L70:
        if (r100.getActionMasked() != 0) goto L9;
        r101 = true;
        goto L10
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        boolean r101 = y0.f365861a.h();
        if (r100 == null) goto L11;
        if (r101 == true) goto L11;
        ArrayList<d> r102 = c.f473940a;
        Intrinsics.checkNotNullParameter(getContext(), PerfLog.PARAM_KEY_CONTEXT_ID);
        Iterator<d> r103 = c.f473940a.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r103.next().onIntercept();
        goto L7
    L9:
        return true;
    L11:
        if (isEnabled() == true) goto L16;
        if (this.f316862c == true) goto L16;
        return true;
    L16:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (isEnabled() == true) goto L9;
        if (this.f316862c == true) goto L9;
        return getGestureDetector().onTouchEvent(r100);
    L9:
        return super.onTouchEvent(r100);
    }

    public final void setIsImmersiveSlidingFeedVertical(boolean r100) {
        this.f316861b = r100;
    }

    public final void setOnUserTouchInput(Function0<Unit> r100) {
        this.f316863d = r100;
    }

    public final boolean S5(View r100, MotionEvent r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int[] r102 = new int[2];
        r100.getLocationOnScreen(r102);
        float r103 = r101.getRawX();
        float r104 = r101.getRawY();
        int r105 = r102[0];
        if (r103 >= r105) goto L8;
        return false;
    L8:
        if (r103 > (r105 + r100.getWidth())) goto L16;
        int r106 = r102[1];
        if (r104 >= r106) goto L12;
        return false;
    L12:
        if (r104 > (r106 + r100.getHeight())) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    }

    public ChatInput(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_widget_input, this);
        this.f316860a = LarusWidgetInputBinding.a(this);
        this.f316864e = LazyKt.lazy(new et8.a(this));
        this.f316865f = LazyKt.lazy(new et8.b(this));
    }

    public /* synthetic */ ChatInput(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
