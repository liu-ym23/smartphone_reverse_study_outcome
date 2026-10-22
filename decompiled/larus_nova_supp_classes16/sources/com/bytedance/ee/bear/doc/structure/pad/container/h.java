package com.bytedance.ee.bear.doc.structure.pad.container;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.doc.structure.pad.CatalogListView;
import com.bytedance.ee.bear.doc.structure.pad.viewmodel.CatalogMode;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import nz4.l;
import nz4.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ PadCatalogController a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CatalogMode.values().length];
            r0[CatalogMode.DIALOG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public h(PadCatalogController r1) {
        this.a = r1;
    }

    public final void onChanged(Object r8) {
        com.bytedance.ee.bear.doc.structure.pad.viewmodel.a r9 = (com.bytedance.ee.bear.doc.structure.pad.viewmodel.a) r8;
        CatalogMode r0 = r9.a;
        CatalogMode r10 = r9.b;
        tt5.a.h("PadCatalogController", "getCatalogModeLiveData preMode=" + r0 + ", currentMode=" + r10);
        if (r10 == null) goto L50;
        CatalogListView r1 = this.a.f;
        if (r10 != CatalogMode.COVERAGE) goto L8;
        boolean r2 = true;
    L9:
        r1.setShadowVisible(r2);
        PadCatalogController r3 = this.a;
        r3.getClass();
        int r4 = r3.d(r3.d.getCatalogMode());
        tt5.a.h("PadCatalogController", "changeCatalogWidth catalogWidthDp=" + r4);
        ViewGroup.LayoutParams r5 = r3.f.getLayoutParams();
        if (r5 == null) goto L12;
        r5.width = u0c.a.a(r4);
    L12:
        ViewGroup r6 = (ViewGroup) r3.b.getValue();
        if (r6 == null) goto L15;
        r6.requestLayout();
    L15:
        PluginHost r7 = this.a.f();
        if (r7 == null) goto L45;
        t r11 = r7.getUIContainer();
        if (r11 == null) goto L46;
        TitleBar r12 = r11.getTitleBar();
        if (r12 == null) goto L51;
        r12.setMenuIconTint(2131105828);
        if (a.a[r10.ordinal()] != 1) goto L33;
        int r13 = l.a;
        Intrinsics.checkNotNullParameter(r12, "titleBar");
        View r14 = r12.findMenuView("pad_catalog_menu");
        if (r14 == null) goto L28;
        r14.setVisibility(8);
    L28:
        r12.b(TitleBar.TitleGravity.Left);
        ViewGroup r16 = (ViewGroup) this.a.c.getValue();
        if (r16 == null) goto L47;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 == null) goto L48;
        r17.width = -1;
        return;
    L48:
        return;
    L47:
        return;
    L33:
        int r18 = l.a;
        PluginHost r19 = this.a.f();
        if (r19 == null) goto L36;
        Context r20 = r19.getContext();
    L37:
        g r21 = new g(this.a);
        Intrinsics.checkNotNullParameter(r12, "titleBar");
        Intrinsics.checkNotNullParameter(r21, "clickListener");
        View r22 = r12.findMenuView("pad_catalog_menu");
        if (r22 == null) goto L40;
        r22.setVisibility(0);
    L43:
        r12.b(TitleBar.TitleGravity.Center);
        return;
    L40:
        if (r20 == null) goto L43;
        MenuItem r23 = new MenuItem();
        r23.setId("pad_catalog_menu");
        r23.setClickListener(new o(r21));
        r23.setEnable(com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a());
        r23.setIcon(com.bytedance.ee.util.ui.l.a(r20, 2131255955, 2131105828));
        TitleBar.MenuType r24 = TitleBar.MenuType.Left;
        List<MenuItem> r26 = r12.i(r24);
        Intrinsics.checkNotNull(r26);
        ListProtector.add(r26, r26.size(), r23);
        r12.j(r26, r24);
        goto L43
    L36:
        r20 = null;
        goto L37
    L51:
        return;
    L46:
        return;
    L45:
        return;
    L8:
        r2 = false;
        goto L9
    }
}
