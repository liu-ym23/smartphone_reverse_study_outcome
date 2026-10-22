package com.bytedance.ee.bear.document.toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes16.dex */
public abstract class BaseAttrSubToolbarFragment extends BaseSubToolbarFragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f222281i = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f222282h;

    public class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ItemId f222283c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ View f222284d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ BaseAttrSubToolbarFragment f222285e;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            if (ItemId.BusinessId.insertSeparator.name().equals(this.f222283c.name()) == true) goto L5;
            this.f222284d.setSelected(true);
        L5:
            this.f222285e.da0().processToolbarItemClick(this.f222283c, String.valueOf(r100.isSelected()));
        }

        public a(BaseAttrSubToolbarFragment r100, ItemId r101, View r102) {
            this.f222285e = r100;
            this.f222283c = r101;
            this.f222284d = r102;
        }
    }

    public abstract ItemId ba0();

    public abstract int ca0();

    public abstract BaseToolbarPanelViewModel da0();

    public BaseAttrSubToolbarFragment() {
        this.f222282h = "BaseAttrSubToolbarFragment";
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseSubToolbarFragment
    public View getContentView() {
        final View r100 = LayoutInflater.from(getContext()).inflate(ca0(), null);
        da0().getSubToolbar(ba0()).observe(this, new com.bytedance.ee.bear.document.toolbar.a(this, r100));
        return r100;
    }

    public final Item aa0(ItemId r100) {
        Item[] r101 = da0().getSubToolbar(ba0()).getValue();
        if (r101 != null) goto L5;
        return null;
    L5:
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L11;
        Item r104 = r101[r103];
        if (r104.id() == r100) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return r104;
    L11:
        return null;
    }

    public void Z90(Item[] r110, View r111) {
        int r100 = r110.length;
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L14;
        Item r102 = r110[r101];
        ItemId r103 = r102.id();
        View r104 = r111.findViewWithTag(r103.name());
        if (r104 != null) goto L7;
        tt5.a.d(this.f222282h, "Item view not found:" + r102);
    L13:
        r101 = r101 + 1;
        goto L3
    L7:
        r104.setSelected(r102.isSelected());
        r104.setEnabled(r102.isEnable());
        if ((r104 instanceof ViewGroup) == false) goto L12;
        ViewGroup r105 = (ViewGroup) r104;
        int r106 = r105.getChildCount();
        int r107 = 0;
    L10:
        if (r107 >= r106) goto L12;
        r105.getChildAt(r107).setEnabled(r102.isEnable());
        r107 = r107 + 1;
    L12:
        r104.setOnClickListener(new a(this, r103, r104));
        goto L13
    }
}
