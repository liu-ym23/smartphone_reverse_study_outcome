package com.larus.bmhome.chat.component.bottom.floating.button;

import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000  2\u00020\u0001:\u0002 !B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010\u0018\u001a\u00020\u0015J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000fH\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000fH\u0002J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000fH\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0014J\b\u0010\u001f\u001a\u00020\u0015H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/floating/button/BottomFloatingButton;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dependency", "Lcom/larus/bmhome/chat/component/bottom/floating/button/BottomFloatingButton$IDependency;", "currentType", "Lcom/larus/bmhome/chat/component/bottom/floating/button/ButtonType;", "showAnimator", "Landroid/animation/AnimatorSet;", "mainHandler", "Landroid/os/Handler;", "init", "", "show", "type", "hide", "firstShowWithAnimation", "changeTypeWithAnimation", "newType", "updateContent", "delayAutoHide", "onDetachedFromWindow", "cleanIfNeed", "Companion", "IDependency", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BottomFloatingButton extends FrameLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f299602e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f299603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ButtonType f299604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnimatorSet f299605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f299606d;

    public static final class a {
    }

    public interface b {
        void a();

        void b(BottomFloatingButton r100, ButtonType r101);
    }

    static {
    }

    public final void a() {
        FLogger.f375446a.i("BottomFloatingButton", "cleanIfNeed");
        if (getVisibility() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
    L10:
        e1.o(this);
        setAlpha(1.0f);
        ViewGroup.LayoutParams r101 = getLayoutParams();
        if (r101 == null) goto L18;
        FrameLayout.LayoutParams r102 = (FrameLayout.LayoutParams) r101;
        r102.width = -2;
        setLayoutParams(r102);
        removeAllViews();
        this.f299606d.removeCallbacksAndMessages(null);
        AnimatorSet r103 = this.f299605c;
        if (r103 == null) goto L15;
        r103.cancel();
    L15:
        this.f299605c = null;
        this.f299604b = null;
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L8:
        if (getChildCount() != 0) goto L10;
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final void b() {
        FLogger.f375446a.i("BottomFloatingButton", "hide, currentType:" + this.f299604b);
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FLogger.f375446a.i("BottomFloatingButton", "onDetachedFromWindow");
        a();
    }

    public BottomFloatingButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f299606d = new Handler(Looper.getMainLooper());
    }

    public BottomFloatingButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f299606d = new Handler(Looper.getMainLooper());
    }

    public BottomFloatingButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f299606d = new Handler(Looper.getMainLooper());
    }
}
