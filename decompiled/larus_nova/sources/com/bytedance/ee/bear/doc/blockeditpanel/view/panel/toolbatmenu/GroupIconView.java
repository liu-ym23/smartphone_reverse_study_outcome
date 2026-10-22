package com.bytedance.ee.bear.doc.blockeditpanel.view.panel.toolbatmenu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.doc.blockeditpanel.model.BlockEditPanelMenusModel;
import com.bytedance.ee.bear.doc.blockeditpanel.model.EMenuItemConfig;
import com.bytedance.ee.bear.doc.blockeditpanel.view.f;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import dy4.b;
import iy4.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class GroupIconView extends LinearLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f217720e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<BlockEditPanelMenusModel.BlockEditPanelMenuItem> f217721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ImageView> f217722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f217723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f217724d;

    static {
        f217720e = n.d(1);
    }

    public GroupIconView(Context r100) {
        this(r100, null);
    }

    public void setIconWidth(int r100) {
        this.f217723c = r100;
        int r101 = getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        View r103 = getChildAt(r102);
        LinearLayout.LayoutParams r104 = (LinearLayout.LayoutParams) r103.getLayoutParams();
        r104.width = this.f217723c;
        r103.setLayoutParams(r104);
        r102 = r102 + 1;
        goto L3
    }

    public void setMenuItems(List<BlockEditPanelMenusModel.BlockEditPanelMenuItem> r100) {
        ((ArrayList) this.f217721a).clear();
        ((ArrayList) this.f217721a).addAll(r100);
        removeAllViews();
        Iterator r101 = new ArrayList(this.f217721a).iterator();
    L4:
        if (r101.hasNext() == false) goto L34;
        BlockEditPanelMenusModel.BlockEditPanelMenuItem r102 = (BlockEditPanelMenusModel.BlockEditPanelMenuItem) r101.next();
        boolean r103 = true;
        if (((ArrayList) this.f217722b).isEmpty() == true) goto L8;
        List<ImageView> r104 = this.f217722b;
        ImageView r105 = (ImageView) ListProtector.get(r104, ((ArrayList) r104).size() - 1);
        LinearLayout.LayoutParams r106 = (LinearLayout.LayoutParams) r105.getLayoutParams();
        r106.rightMargin = f217720e;
        r105.setLayoutParams(r106);
    L8:
        ImageView r107 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.doc_block_edit_panel_icon_menu_item, this, false);
        if (this.f217723c <= 0) goto L11;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        r108.width = this.f217723c;
        r107.setLayoutParams(r108);
    L11:
        EMenuItemConfig r109 = EMenuItemConfig.getMenuItemConfigById(r102.getId());
        if (r109 == EMenuItemConfig.UNKNOWN) goto L4;
        int r110 = r109.imageRes;
        if (r110 == (-1)) goto L17;
        r107.setImageResource(r110);
    L24:
        int r111 = r109.bgRes;
        if (r111 == (-1)) goto L27;
        r107.setBackgroundResource(r111);
    L27:
        f.g(r107, r109.iconStateColorList);
        f.f(r107, r109.backgroundStateColorList);
        if (r102.isEnable() == true) goto L30;
    L32:
        r103 = false;
    L33:
        r107.setSelected(r103);
        r107.setEnabled(r102.isEnable());
        r107.setOnClickListener(new a(this, r102));
        addView(r107);
        ((ArrayList) this.f217722b).add(r107);
        ((ArrayList) this.f217721a).add(r102);
        goto L4
    L30:
        if (r102.isSelected() == false) goto L32;
    L17:
        Context r112 = r107.getContext();
        int r113 = this.f217723c;
        if (r113 > 0) goto L21;
        r113 = n.d(48);
    L21:
        Drawable r114 = r109.getImageDrawable(r112, r113);
        if (r114 == null) goto L24;
        r107.setImageDrawable(r114);
        goto L24
    }

    public void setOnClickMenuItemListener(b r100) {
        this.f217724d = r100;
    }

    public GroupIconView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public GroupIconView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f217721a = new ArrayList();
        this.f217722b = new ArrayList();
        this.f217723c = 0;
    }
}
