package com.obric.oui.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.oui.titlebar.floating.o;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0014\u0015\u0016B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\bJ\b\u0010\u000b\u001a\u0004\u0018\u00010\n¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBarActionHost;", "Landroid/widget/FrameLayout;", "Lkotlin/Function0;", "", "listener", "setFloatingTransitionDrawUpdateListener$OUI_standardRelease", "(Lkotlin/jvm/functions/Function0;)V", "setFloatingTransitionDrawUpdateListener", "Lcom/obric/oui/titlebar/OFloatingTitleBarActionHost$b;", "setFloatingTransitionEndListener", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "getBoundTitleBar", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OFloatingTitleBarActionHost extends FrameLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f403446e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PathInterpolator f403447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f403448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f403449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OFloatingTitleBar f403450d;

    public static final class a {
    }

    public interface b {
    }

    public static final class c {
    }

    static {
    }

    public OFloatingTitleBarActionHost(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OFloatingTitleBarActionHost(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setFloatingTransitionEndListener(b r100) {
    }

    public final void b() {
        this.f403449c++;
        animate().cancel();
        this.f403450d.animate().cancel();
        this.f403450d.animate().setUpdateListener(null);
        this.f403450d.setFloatingTransitionDrawUpdateListener$OUI_standardRelease(null);
        this.f403450d.I();
    }

    public final float c() {
        return this.f403450d.s().f403622b.f403661e + this.f403450d.getTranslationY();
    }

    public final OFloatingTitleBar getBoundTitleBar() {
        o.c();
        return null;
    }

    public static void d(View r100) {
        if ((r100 instanceof ViewGroup) == false) goto L5;
        ViewGroup r101 = (ViewGroup) r100;
    L6:
        if (r101 == null) goto L11;
        int r102 = 0;
        r101.setClipChildren(false);
        r101.setClipToPadding(false);
        int r103 = r101.getChildCount();
    L9:
        if (r102 >= r103) goto L13;
        int r104 = r102 + 1;
        d(r101.getChildAt(r102));
        r102 = r104;
        goto L9
    L13:
        return;
    L11:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void setFloatingTransitionDrawUpdateListener$OUI_standardRelease(Function0<Unit> r100) {
        this.f403450d.setFloatingTransitionDrawUpdateListener$OUI_standardRelease(r100);
    }

    public OFloatingTitleBarActionHost(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f403447a = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        OFloatingTitleBar r103 = new OFloatingTitleBar(r100, null, 6, 0);
        r103.setClipChildren(false);
        r103.setClipToPadding(false);
        r103.setImportantForAccessibility(4);
        r103.setKeepActionInteractiveWhenHidden$OUI_standardRelease(true);
        r103.setActionChangeInterruptCallback$OUI_standardRelease(new OFloatingTitleBarActionHost$actionTitleBar$1$1(this));
        r103.setFloatingTransitionOwnerActive$OUI_standardRelease(false);
        r103.O(true, true);
        r103.setNonActionContentVisible$OUI_standardRelease(false);
        r103.setTitleBarContainerClickable$OUI_standardRelease(false);
        this.f403450d = r103;
        setClipChildren(false);
        setClipToPadding(false);
        setWillNotDraw(false);
        setVisibility(8);
        addView(r103, new FrameLayout.LayoutParams(-1, -2));
        d(this);
    }

    public /* synthetic */ OFloatingTitleBarActionHost(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void a(k r110, boolean r111, boolean r112, Float r210, final Function0<Unit> r211) {
        Intrinsics.checkNotNullParameter(r110, "state");
        final int r113 = this.f403449c + 1;
        this.f403449c = r113;
        this.f403450d.s().f403622b.getClass();
        if (r210 != null) goto L5;
        float r100 = c();
    L6:
        int r101 = r110.f403622b.f403661e;
        final Ref.IntRef r114 = new Ref.IntRef();
        r114.element = 1;
        final Ref.BooleanRef r115 = new Ref.BooleanRef();
        this.f403450d.animate().cancel();
        OFloatingTitleBar r102 = this.f403450d;
        boolean r103 = !this.f403448b;
        Token$Bounce r104 = OFloatingTitleBar.H0;
        r102.O(r103, r103);
        this.f403450d.setNonActionContentVisible$OUI_standardRelease(false);
        this.f403450d.W(r101);
        if (r111 == false) goto L12;
        if (r112 == false) goto L12;
        float r105 = r100 - r101;
        if (Math.abs(r105) <= 0.5f) goto L12;
        r114.element++;
        final Ref.BooleanRef r106 = new Ref.BooleanRef();
        final Function0<Unit> r107 = new OFloatingTitleBarActionHost$applyState$await$1(r106, r113, this, r114, r115, r211);
        this.f403450d.setTranslationY(r105);
        this.f403450d.animate().translationY(0.0f).setDuration(500).setInterpolator(this.f403447a).setUpdateListener(new i(this)).withEndAction(new j(this, r107)).start();
    L13:
        r114.element++;
        final Ref.BooleanRef r108 = new Ref.BooleanRef();
        final Function0<Unit> r116 = new OFloatingTitleBarActionHost$applyState$await$1(r108, r113, this, r114, r115, r211);
        this.f403450d.n(r110, r111, new OFloatingTitleBarActionHost$applyState$3(r116));
        OFloatingTitleBar r109 = this.f403450d;
        boolean r117 = !this.f403448b;
        r109.O(r117, r117);
        this.f403450d.setNonActionContentVisible$OUI_standardRelease(false);
        if (r113 == this.f403449c) goto L16;
        return;
    L16:
        int r118 = r114.element - 1;
        r114.element = r118;
        if (r118 == 0) goto L19;
        return;
    L19:
        if (r115.element == true) goto L26;
        r115.element = true;
        if (r211 == null) goto L27;
        r211.invoke();
        return;
    L27:
        return;
    L26:
        return;
    L12:
        this.f403450d.animate().setUpdateListener(null);
        this.f403450d.setTranslationY(0.0f);
        goto L13
    L5:
        r100 = r210.floatValue();
        goto L6
    }
}
