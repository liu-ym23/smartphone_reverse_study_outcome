package com.bytedance.dux.popover.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/dux/popover/menu/DuxPopoverFilterMenuView;", "Lcom/bytedance/dux/popover/menu/DuxPopoverMenuView;", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxPopoverFilterMenuView extends DuxPopoverMenuView {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<ViewGroup> f205462j;

    public DuxPopoverFilterMenuView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public DuxPopoverFilterMenuView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public DuxPopoverFilterMenuView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    public DuxPopoverFilterMenuView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, null);
        new ArrayList();
        new LinkedHashMap();
        this.f205462j = new ArrayList();
    }

    @Override // com.bytedance.dux.popover.menu.DuxPopoverMenuView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        Iterator<T> r104 = this.f205462j.iterator();
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
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
