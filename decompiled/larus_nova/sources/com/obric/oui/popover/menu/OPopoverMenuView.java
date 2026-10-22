package com.obric.oui.popover.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.obric.oui.popover.OPopoverLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\r\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0011\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\"\u0010\u0015\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverMenuView;", "Landroid/widget/LinearLayout;", "", "maxHeight", "", "setPopoverMaxHeight", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getForceDark", "()Z", "setForceDark", "(Z)V", "forceDark", "b", "getPressedWithArrow", "setPressedWithArrow", "pressedWithArrow", "c", "getIgnoreWidthConstraint", "setIgnoreWidthConstraint", "ignoreWidthConstraint", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public abstract class OPopoverMenuView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f402305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f402306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f402307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f402308d;

    public OPopoverMenuView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OPopoverMenuView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public void setPopoverMaxHeight(int r100) {
    }

    public final boolean getForceDark() {
        return this.f402305a;
    }

    public final boolean getIgnoreWidthConstraint() {
        return this.f402307c;
    }

    public final boolean getPressedWithArrow() {
        return this.f402306b;
    }

    public static OPopoverLayout b(View r100) {
        if (r100 != null) goto L4;
    L13:
        return null;
    L4:
        if ((r100 instanceof OPopoverLayout) == false) goto L7;
        return (OPopoverLayout) r100;
    L7:
        if (r100.getParent() == null) goto L13;
        ViewParent r101 = r100.getParent();
        if (r101 == null) goto L12;
        return b((ViewGroup) r101);
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void setForceDark(boolean r100) {
        this.f402305a = r100;
    }

    public final void setIgnoreWidthConstraint(boolean r100) {
        this.f402307c = r100;
    }

    public final void setPressedWithArrow(boolean r100) {
        this.f402306b = r100;
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

    public OPopoverMenuView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f402307c = true;
    }

    public /* synthetic */ OPopoverMenuView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        d.k(getContext(), r100);
        if (r100 > 0) goto L5;
    L14:
        d.n(this, 188);
        return;
    L5:
        if (this.f402308d == true) goto L14;
        this.f402308d = true;
        ArrayList r104 = new ArrayList();
        a(this, r104);
        Iterator r105 = r104.iterator();
    L8:
        if (r105.hasNext() == false) goto L14;
        PopoverMenuLinearLayout r106 = (PopoverMenuLinearLayout) r105.next();
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if (r107 == null) goto L13;
        r107.width = (r100 - getPaddingLeft()) - getPaddingRight();
        r106.setLayoutParams(r107);
        goto L8
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
