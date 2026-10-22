package com.larus.common_ui.widget;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.common_ui.utils.ViewExtKt$watchOnImeInsetsAnimationInternal$1;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import v19.j7;
import v19.k7;
import v19.z5;
import z19.l;
import z19.m;
import z19.n;
import z19.o;
import z19.p;
import z19.q;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0013\u001a\u00020\rH\u0014J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0014\u0010\u001b\u001a\u00020\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0014\u0010\u001d\u001a\u00020\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0014\u0010\u001e\u001a\u00020\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0006\u0010\u001f\u001a\u00020\rJ*\u0010 \u001a\u00020\r2\"\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/common_ui/widget/InjectInputContainer;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "navigationPadding", "onShowImeCallback", "Lkotlin/Function0;", "", "onHideImeCallback", "onTouchDownCallback", "safeBottomResolver", "Lkotlin/Function3;", "Landroidx/core/view/WindowInsetsCompat;", "onAttachedToWindow", "addView", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onShowIme", "block", "onHideIme", "onTouchDown", "resetImePadding", "setSafeBottomResolver", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InjectInputContainer extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f328470f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f328471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f328472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f328473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f328474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function3<? super Context, ? super WindowInsetsCompat, ? super Integer, Integer> f328475e;

    public InjectInputContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public InjectInputContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f328475e == null) goto L6;
        post(new l(this));
        return;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-1, -2);
        r101.gravity = 80;
        addView(r100, r101);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (r100.getAction() != 0) goto L6;
        getClass();
        Unit r101 = Unit.INSTANCE;
    L6:
        return super.onInterceptTouchEvent(r100);
    }

    public final void setSafeBottomResolver(Function3<? super Context, ? super WindowInsetsCompat, ? super Integer, Integer> r100) {
        this.f328475e = r100;
    }

    /* JADX WARN: Type inference failed for: r8v8, types: [z19.o] */
    public InjectInputContainer(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Activity r103 = null;
        if ((r100 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r104 = (FragmentActivity) r100;
    L6:
        if (r104 == null) goto L8;
        int r105 = u.b(r104);
    L9:
        this.f328471a = r105;
        this.f328472b = new m();
        this.f328473c = new n();
        this.f328474d = new o();
        Function1 r106 = new p();
        Function2 r107 = new q(this, r100);
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (z5.d() == false) goto L13;
        z5.e(this, r106, r107, null);
        return;
    L13:
        if (Build.VERSION.SDK_INT < 30) goto L15;
        Intrinsics.checkNotNullParameter(this, "<this>");
        ViewCompat.setWindowInsetsAnimationCallback(this, new ViewExtKt$watchOnImeInsetsAnimationInternal$1(r106, null, null, r107, null));
        return;
    L15:
        Context r108 = getContext();
    L16:
        boolean r109 = r108 instanceof Activity;
        if (r109 == true) goto L21;
        if ((r108 instanceof ContextWrapper) == false) goto L21;
        r108 = ((ContextWrapper) r108).getBaseContext();
    L21:
        if (r109 == false) goto L23;
        r103 = (Activity) r108;
    L23:
        if (r103 == null) goto L44;
        Window r110 = r103.getWindow();
        if (r110 == null) goto L43;
        View r111 = r110.getDecorView();
        if (c.f346345e == false) goto L32;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r112 = ThreadMethodProxy.currentThread();
        if (r112 == c.f346341a) goto L32;
        c.a(r112, "getDecorView");
    L32:
        if (r111 == null) goto L45;
        View r113 = r103.findViewById(R.id.content);
        if (r113 != null) goto L37;
        r113 = r111;
    L37:
        k7 r114 = new k7(r113, r111, r107);
        r113.getViewTreeObserver().addOnGlobalLayoutListener(r114);
        addOnAttachStateChangeListener(new j7(r113, r114));
        return;
    L45:
        return;
    L43:
        return;
    L44:
        return;
    L8:
        r105 = 0;
        goto L9
    L5:
        r104 = null;
        goto L6
    }

    public /* synthetic */ InjectInputContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
