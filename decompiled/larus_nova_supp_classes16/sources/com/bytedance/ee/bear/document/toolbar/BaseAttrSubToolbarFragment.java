package com.bytedance.ee.bear.document.toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BaseAttrSubToolbarFragment extends BaseSubToolbarFragment {
    public static final /* synthetic */ int i = 0;
    public final String h;

    public class a extends t {
        public final /* synthetic */ ItemId c;
        public final /* synthetic */ View d;
        public final /* synthetic */ BaseAttrSubToolbarFragment e;

        public final void a(View r3) {
            if (ItemId.BusinessId.insertSeparator.name().equals(this.c.name()) == true) goto L5;
            this.d.setSelected(true);
        L5:
            this.e.da0().processToolbarItemClick(this.c, String.valueOf(r3.isSelected()));
        }

        public a(BaseAttrSubToolbarFragment r1, ItemId r2, View r3) {
            this.e = r1;
            this.c = r2;
            this.d = r3;
        }
    }

    public abstract ItemId ba0();

    public abstract int ca0();

    public abstract BaseToolbarPanelViewModel da0();

    public BaseAttrSubToolbarFragment() {
        this.h = "BaseAttrSubToolbarFragment";
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseSubToolbarFragment
    public View getContentView() {
        final View r0 = LayoutInflater.from(getContext()).inflate(ca0(), null);
        da0().getSubToolbar(ba0()).observe(this, new com.bytedance.ee.bear.document.toolbar.a(this, r0));
        return r0;
    }

    public final Item aa0(ItemId r7) {
        Item[] r0 = (Item[]) da0().getSubToolbar(ba0()).getValue();
        if (r0 != null) goto L5;
        return null;
    L5:
        int r2 = r0.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L11;
        Item r4 = r0[r3];
        if (r4.id() == r7) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return r4;
    L11:
        return null;
    }

    public void Z90(Item[] r12, View r13) {
        int r0 = r12.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L14;
        Item r3 = r12[r2];
        ItemId r4 = r3.id();
        View r5 = r13.findViewWithTag(r4.name());
        if (r5 != null) goto L7;
        tt5.a.d(this.h, "Item view not found:" + r3);
    L13:
        r2 = r2 + 1;
        goto L3
    L7:
        r5.setSelected(r3.isSelected());
        r5.setEnabled(r3.isEnable());
        if ((r5 instanceof ViewGroup) == false) goto L12;
        ViewGroup r6 = (ViewGroup) r5;
        int r7 = r6.getChildCount();
        int r8 = 0;
    L10:
        if (r8 >= r7) goto L12;
        r6.getChildAt(r8).setEnabled(r3.isEnable());
        r8 = r8 + 1;
    L12:
        r5.setOnClickListener(new a(this, r4, r5));
        goto L13
    }
}
