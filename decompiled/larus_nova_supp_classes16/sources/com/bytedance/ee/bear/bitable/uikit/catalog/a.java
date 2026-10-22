package com.bytedance.ee.bear.bitable.uikit.catalog;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import gv4.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends e {
    public final /* synthetic */ CatalogItemTreeAdapter b;

    public a(CatalogItemTreeAdapter r1) {
        this.b = r1;
    }

    @Override // gv4.e
    public final boolean b(Action r5) {
        Intrinsics.checkNotNullParameter(r5, JSEventListener.ACTION);
        if (TextUtils.equals(r5.getAction(), "ToggleFolder") == false) goto L9;
        CatalogItemTreeAdapter r0 = this.b;
        String r6 = r5.getId();
        int r2 = CatalogItemTreeAdapter.x;
        Integer r7 = r0.getIndex(r6);
        if (r7 == null) goto L7;
        this.b.K2(r7.intValue());
    L7:
        return false;
    L9:
        if (TextUtils.equals(r5.getAction(), "SelectSortTarget") == false) goto L26;
        CatalogItemModel r1 = this.b.u;
        if (r1 == null) goto L13;
        r1.setSelected(false);
    L13:
        CatalogItemTreeAdapter r3 = this.b;
        CatalogItemModel r4 = r3.u;
        if (r4 == null) goto L16;
        String r8 = r4.getId();
    L17:
        Integer r9 = r3.getIndex(r8);
        if (r9 == null) goto L20;
        this.b.notifyItemChanged(r9.intValue());
    L20:
        Integer r10 = this.b.getIndex(r5.getId());
        if (r10 == null) goto L26;
        CatalogItemTreeAdapter r11 = this.b;
        int r12 = r10.intValue();
        CatalogItemModel r13 = r11.H2(r12);
        r11.u = r13;
        if (r13 == null) goto L25;
        r13.setSelected(true);
    L25:
        r11.notifyItemChanged(r12);
        goto L26
    L16:
        r8 = null;
    L26:
        return false;
    }
}
