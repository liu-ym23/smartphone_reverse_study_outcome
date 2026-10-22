package com.bytedance.dux.popover.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.amap.api.col.s.ce;
import com.bytedance.dux.api.DuxComponent;
import com.bytedance.dux.largefont.DuxLargeFontHelper;
import com.bytedance.dux.popover.DuxPopoverLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import em4.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0001\u0007J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0011\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\"\u0010\u0015\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR\"\u0010\u0019\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\"\u0010\u0003\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\b\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u0005\u0010\fR\"\u0010\u001f\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\fR\"\u0010'\u001a\u00020 8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/bytedance/dux/popover/menu/DuxPopoverMenuView;", "Landroid/widget/LinearLayout;", "", "adaptLargeFont", "", "setAdaptLargeFont", "(Ljava/lang/Boolean;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getForceDark", "()Z", "setForceDark", "(Z)V", "forceDark", "b", "getForceLight", "setForceLight", "forceLight", "c", "getPressedWithArrow", "setPressedWithArrow", "pressedWithArrow", "d", "getIgnoreWidthConstraint", "setIgnoreWidthConstraint", "ignoreWidthConstraint", "e", "getAdaptLargeFont", "f", "getLimitLargeFontScale", "setLimitLargeFontScale", "limitLargeFontScale", "", ce.f26391f, "I", "getMinWidth", "()I", "setMinWidth", "(I)V", "minWidth", "dux_release"}, k = 1, mv = {1, 7, 1})
public abstract class DuxPopoverMenuView extends LinearLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final DuxComponent f205463i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f205464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f205465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f205466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f205467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f205468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f205469f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f205470g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f205471h;

    public static final class a {
    }

    public DuxPopoverMenuView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 0, 14);
    }

    public DuxPopoverMenuView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public DuxPopoverMenuView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    static {
        f205463i = DuxComponent.POPOVER_MENU;
    }

    public final boolean getAdaptLargeFont() {
        return this.f205468e;
    }

    public final boolean getForceDark() {
        return this.f205464a;
    }

    public final boolean getForceLight() {
        return this.f205465b;
    }

    public final boolean getIgnoreWidthConstraint() {
        return this.f205467d;
    }

    public final boolean getLimitLargeFontScale() {
        return this.f205469f;
    }

    public final int getMinWidth() {
        return this.f205470g;
    }

    public final boolean getPressedWithArrow() {
        return this.f205466c;
    }

    public static DuxPopoverLayout b(View r100) {
        if (r100 != null) goto L4;
    L9:
        return null;
    L4:
        if ((r100 instanceof DuxPopoverLayout) == false) goto L7;
        return (DuxPopoverLayout) r100;
    L7:
        if (r100.getParent() == null) goto L9;
        ViewParent r101 = r100.getParent();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup");
        return b((ViewGroup) r101);
    }

    public final void c(final PopoverMenuLinearLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        if (this.f205466c == false) goto L6;
        r100.setNotifyPressedCallback(new DuxPopoverMenuView$registerPressedCallback$1(this, r100));
        return;
    }

    public final void setAdaptLargeFont(Boolean r100) {
        Lazy r101 = DuxLargeFontHelper.f205243a;
        this.f205468e = DuxLargeFontHelper.a(f205463i, r100);
    }

    public final void setForceDark(boolean r100) {
        this.f205464a = r100;
    }

    public final void setForceLight(boolean r100) {
        this.f205465b = r100;
    }

    public final void setIgnoreWidthConstraint(boolean r100) {
        this.f205467d = r100;
    }

    public final void setLimitLargeFontScale(boolean r100) {
        this.f205469f = r100;
    }

    public final void setMinWidth(int r100) {
        this.f205470g = r100;
    }

    public final void setPressedWithArrow(boolean r100) {
        this.f205466c = r100;
    }

    public final void setAdaptLargeFont(boolean r100) {
        this.f205468e = r100;
    }

    public static void a(View r100, List r101) {
        if ((r100 instanceof PopoverMenuLinearLayout) == false) goto L7;
        ((ArrayList) r101).add(r100);
        return;
    L7:
        if ((r100 instanceof ViewGroup) == false) goto L12;
        Iterator<View> r102 = ViewGroupKt.getChildren((ViewGroup) r100).iterator();
    L10:
        if (r102.hasNext() == false) goto L14;
        a(r102.next(), r101);
        goto L10
    L14:
        return;
    }

    public DuxPopoverMenuView(Context r100, AttributeSet r101, int r102, Boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Lazy r104 = DuxLargeFontHelper.f205243a;
        this.f205468e = DuxLargeFontHelper.a(f205463i, r103);
        this.f205470g = -1;
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        Context r104 = getContext();
        Intrinsics.checkNotNullParameter(r104, "<this>");
        MathKt.roundToInt(r100 / g.a(r104.getResources()).density);
        if (r100 > 0) goto L5;
        return;
    L5:
        if (this.f205471h == true) goto L17;
        this.f205471h = true;
        ArrayList r105 = new ArrayList();
        a(this, r105);
        Iterator r106 = r105.iterator();
    L8:
        if (r106.hasNext() == false) goto L18;
        PopoverMenuLinearLayout r107 = (PopoverMenuLinearLayout) r106.next();
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if (r108 == null) goto L13;
        r108.width = r100;
        r107.setLayoutParams(r108);
        goto L8
    L13:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L18:
        return;
    }

    public /* synthetic */ DuxPopoverMenuView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102, null);
    }
}
