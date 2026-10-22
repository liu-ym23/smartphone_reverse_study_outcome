package com.obric.oui.popover.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverFilterMenuView;", "Lcom/obric/oui/popover/menu/OPopoverMenuView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OPopoverFilterMenuView extends OPopoverMenuView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<ViewGroup> f402304e;

    public OPopoverFilterMenuView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OPopoverFilterMenuView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public OPopoverFilterMenuView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        new ArrayList();
        new LinkedHashMap();
        this.f402304e = new ArrayList();
        d.n(this, 4);
        d.n(this, 188);
        r100.getResources().getDimension(R.dimen.oui_h_list_item_menu);
    }

    public /* synthetic */ OPopoverFilterMenuView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // com.obric.oui.popover.menu.OPopoverMenuView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        Iterator<T> r104 = this.f402304e.iterator();
    L4:
        if (r104.hasNext() == false) goto L24;
        ViewGroup r105 = (ViewGroup) r104.next();
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L23;
        ViewGroup.LayoutParams r107 = r105.getLayoutParams();
        ViewGroup.LayoutParams r108 = null;
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == true) goto L10;
        r107 = null;
    L10:
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r107;
        int r110 = 0;
        if (r109 == null) goto L13;
        int r111 = r109.leftMargin;
    L14:
        int r112 = r100 - r111;
        ViewGroup.LayoutParams r113 = r105.getLayoutParams();
        if ((r113 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        r108 = r113;
    L18:
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r108;
        if (r114 == null) goto L21;
        r110 = r114.rightMargin;
    L21:
        r106.width = r112 - r110;
        r105.setLayoutParams(r106);
        goto L4
    L13:
        r111 = 0;
        goto L14
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
