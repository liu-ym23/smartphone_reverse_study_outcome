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
import dy4.b;
import iy4.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class GroupIconView extends LinearLayout {
    public static final int e = 0;
    public final List<BlockEditPanelMenusModel.BlockEditPanelMenuItem> a;
    public final List<ImageView> b;
    public int c;
    public b d;

    static {
        e = n.d(1);
    }

    public GroupIconView(Context r2) {
        this(r2, null);
    }

    public void setIconWidth(int r5) {
        this.c = r5;
        int r6 = getChildCount();
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L5;
        View r1 = getChildAt(r0);
        LinearLayout.LayoutParams r2 = (LinearLayout.LayoutParams) r1.getLayoutParams();
        r2.width = this.c;
        r1.setLayoutParams(r2);
        r0 = r0 + 1;
        goto L3
    }

    public void setMenuItems(List<BlockEditPanelMenusModel.BlockEditPanelMenuItem> r9) {
        ((ArrayList) this.a).clear();
        ((ArrayList) this.a).addAll(r9);
        removeAllViews();
        Iterator r10 = new ArrayList(this.a).iterator();
    L4:
        if (r10.hasNext() == false) goto L34;
        BlockEditPanelMenusModel.BlockEditPanelMenuItem r0 = (BlockEditPanelMenusModel.BlockEditPanelMenuItem) r10.next();
        boolean r2 = true;
        if (((ArrayList) this.b).isEmpty() == true) goto L8;
        List<ImageView> r1 = this.b;
        ImageView r3 = (ImageView) ListProtector.get(r1, ((ArrayList) r1).size() - 1);
        LinearLayout.LayoutParams r4 = (LinearLayout.LayoutParams) r3.getLayoutParams();
        r4.rightMargin = e;
        r3.setLayoutParams(r4);
    L8:
        ImageView r5 = (ImageView) LayoutInflater.from(getContext()).inflate(2131560067, this, false);
        if (this.c <= 0) goto L11;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        r6.width = this.c;
        r5.setLayoutParams(r6);
    L11:
        EMenuItemConfig r7 = EMenuItemConfig.getMenuItemConfigById(r0.getId());
        if (r7 == EMenuItemConfig.UNKNOWN) goto L4;
        int r8 = r7.imageRes;
        if (r8 == (-1)) goto L17;
        r5.setImageResource(r8);
    L24:
        int r11 = r7.bgRes;
        if (r11 == (-1)) goto L27;
        r5.setBackgroundResource(r11);
    L27:
        f.g(r5, r7.iconStateColorList);
        f.f(r5, r7.backgroundStateColorList);
        if (r0.isEnable() == true) goto L30;
    L32:
        r2 = false;
    L33:
        r5.setSelected(r2);
        r5.setEnabled(r0.isEnable());
        r5.setOnClickListener(new a(this, r0));
        addView(r5);
        ((ArrayList) this.b).add(r5);
        ((ArrayList) this.a).add(r0);
        goto L4
    L30:
        if (r0.isSelected() == false) goto L32;
    L17:
        Context r12 = r5.getContext();
        int r13 = this.c;
        if (r13 > 0) goto L21;
        r13 = n.d(48);
    L21:
        Drawable r14 = r7.getImageDrawable(r12, r13);
        if (r14 == null) goto L24;
        r5.setImageDrawable(r14);
        goto L24
    }

    public void setOnClickMenuItemListener(b r1) {
        this.d = r1;
    }

    public GroupIconView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public GroupIconView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = 0;
    }
}
