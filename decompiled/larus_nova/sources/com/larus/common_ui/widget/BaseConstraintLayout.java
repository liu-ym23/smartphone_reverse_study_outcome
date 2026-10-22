package com.larus.common_ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.byted.cast.common.CastMonitor;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nda.d;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 +2\u00020\u0001:\u0001+B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J0\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0014J\u0006\u0010$\u001a\u00020\u001dJ\u000e\u0010%\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\nJ\b\u0010&\u001a\u00020\u001dH\u0002J\u0006\u0010'\u001a\u00020\u001dJ\u000e\u0010(\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\u001dJ\u0006\u0010)\u001a\u00020\u001dJ\u0006\u0010*\u001a\u00020\u001dR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015¨\u0006,"}, d2 = {"Lcom/larus/common_ui/widget/BaseConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "statusBarAllowZero", "", "hideStatusBar", "runtimeStatusBarTop", "Ljava/lang/Integer;", "disableBottomPadding", "getDisableBottomPadding", "()Z", "setDisableBottomPadding", "(Z)V", "disableTopPadding", "getDisableTopPadding", "setDisableTopPadding", "enableSmallWindowTopInsetAdaptation", "getEnableSmallWindowTopInsetAdaptation", "setEnableSmallWindowTopInsetAdaptation", "cinit", "", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "adaptDecorViewPadding", "updateRuntimeStatusBarTop", "stashBarHeight", "checkPadding", "updatePaddingBottom", "hideNavigationBarHeight", "hideStatusBarHeight", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseConstraintLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static float f328383g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f328384h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f328385i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f328386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f328387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f328388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f328389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f328390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f328391f;

    public static final class a {
    }

    static {
    }

    public final void U5() {
        this.f328387b = true;
        int r100 = getPaddingStart();
        int r101 = getPaddingEnd();
        int r102 = getPaddingBottom();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + getClass().getSimpleName() + ",source:hideStatusBarHeight,start:" + r100 + ",top:0,end:" + r101 + ",bottom:" + r102);
        setPaddingRelative(r100, 0, r101, r102);
    }

    public final void R5() {
        FLogger r100 = FLogger.f375446a;
        r100.d("BaseConstraintLayout", "adaptDecorViewPadding: called, disableBottomPadding=" + getDisableBottomPadding() + ", hideStatusBar=" + this.f328387b + ", navigationBarHeight = " + f328385i + ", disableTopPadding=" + getDisableTopPadding() + ", statusBarHeight = " + f328384h + ", paddingBottom = " + getPaddingBottom() + ", minPaddingBottom:" + f328383g);
        int r101 = 0;
        if (getDisableBottomPadding() == false) goto L5;
    L8:
        int r102 = 0;
    L10:
        if (getDisableTopPadding() == true) goto L21;
        if (getEnableSmallWindowTopInsetAdaptation() == false) goto L19;
        Integer r103 = this.f328388c;
        if (r103 == null) goto L19;
        if (r103 == null) goto L18;
        r101 = r103.intValue();
        goto L21
    L18:
        r101 = f328384h;
    L19:
        r101 = f328384h;
    L21:
        if (getPaddingBottom() <= f328383g) goto L25;
        r100.i("BaseConstraintLayout", "Ime is show, don't update the bottom padding !!!");
        return;
    L25:
        if ((getContext() instanceof FragmentActivity) == false) goto L28;
        int r104 = getPaddingStart();
        int r105 = getPaddingEnd();
        r100.i("updatePaddingRelative", "view:" + getClass().getSimpleName() + ",source:adaptDecorViewPadding,start:" + r104 + ",top:" + r101 + ",end:" + r105 + ",bottom:" + r102);
        setPaddingRelative(r104, r101, r105, r102);
        return;
    L28:
        return;
    L5:
        if (this.f328387b == true) goto L8;
        r102 = f328385i;
        goto L10
    }

    public final void S5() {
        int r100 = f328384h;
        int r101 = f328385i;
        V5();
        if (r100 == f328384h) goto L5;
    L6:
        FLogger.f375446a.d("BaseConstraintLayout", "checkPadding " + r100 + ' ' + r101 + ' ' + f328384h + ' ' + f328385i);
        R5();
        return;
    L5:
        if (r101 != f328385i) goto L6;
    }

    public final void T5() {
        int r100 = f328384h;
        int r101 = getPaddingStart();
        int r102 = getPaddingEnd();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + getClass().getSimpleName() + ",source:hideNavigationBarHeight,start:" + r101 + ",top:" + r100 + ",end:" + r102 + ",bottom:0");
        setPaddingRelative(r101, r100, r102, 0);
    }

    public final void V5() {
        if ((getContext() instanceof FragmentActivity) == false) goto L27;
        Context r100 = getContext();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentActivity r101 = (FragmentActivity) r100;
        Integer r102 = Integer.valueOf(u.c(r101));
        int r103 = r102.intValue();
        boolean r104 = false;
        if (r103 > 0) goto L11;
        if (r103 == 0) goto L8;
    L10:
        boolean r105 = false;
    L12:
        Integer r106 = null;
        if (r105 == true) goto L16;
        r102 = null;
    L16:
        if (r102 == null) goto L18;
        f328384h = r102.intValue();
    L18:
        Integer r107 = Integer.valueOf(u.b(r101));
        if (r107.intValue() < 0) goto L21;
        r104 = true;
    L21:
        if (r104 == false) goto L23;
        r106 = r107;
    L23:
        if (r106 == null) goto L25;
        f328385i = r106.intValue();
    L25:
        f328385i = d.a().b(this, f328385i);
        return;
    L8:
        if (this.f328386a == false) goto L10;
    L11:
        r105 = true;
        goto L12
    }

    public boolean getDisableBottomPadding() {
        return this.f328389d;
    }

    public boolean getDisableTopPadding() {
        return this.f328390e;
    }

    public boolean getEnableSmallWindowTopInsetAdaptation() {
        return this.f328391f;
    }

    public BaseConstraintLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f328386a = true;
    }

    public void setDisableBottomPadding(boolean r100) {
        this.f328389d = r100;
    }

    public void setDisableTopPadding(boolean r100) {
        this.f328390e = r100;
    }

    public void setEnableSmallWindowTopInsetAdaptation(boolean r100) {
        this.f328391f = r100;
    }

    public BaseConstraintLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f328386a = true;
    }

    public BaseConstraintLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        this.f328386a = true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        S5();
    }
}
