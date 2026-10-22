package com.ss.android.lark.widget.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f446469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b.a> f446470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f446471c;

    /* JADX INFO: renamed from: com.ss.android.lark.widget.menu.a$a, reason: collision with other inner class name */
    public class ViewOnHoverListenerC5403a implements View.OnHoverListener {
        public ViewOnHoverListenerC5403a() {
        }

        @Override // android.view.View.OnHoverListener
        public final boolean onHover(View r100, MotionEvent r101) {
            int r102 = r101.getAction();
            if (r102 != 9) goto L5;
            r100.setHovered(true);
        L9:
            return false;
        L5:
            if (r102 != 10) goto L9;
            r100.setHovered(false);
            goto L9
        }
    }

    @Override // android.widget.Adapter
    public final long getItemId(int r100) {
        return r100;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f446470b.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int r100) {
        return (b.a) ListProtector.get(this.f446470b, r100);
    }

    public a(Context r100, List<b.a> r101) {
        this.f446470b = new ArrayList();
        this.f446469a = r100;
        this.f446470b = r101;
    }

    @Override // android.widget.Adapter
    public final View getView(int r100, View r110, ViewGroup r111) {
        b.a r101 = (b.a) ListProtector.get(this.f446470b, r100);
        Context r102 = this.f446469a;
        r101.getClass();
        int r103 = 0;
        if (r110 != null) goto L5;
    L7:
        b.a.C5404a r112 = new b.a.C5404a();
        View r113 = LayoutInflater.from(r102).inflate(R.layout.global_dialog_list_item, r111, false);
        r112.f446477a = r113;
        r112.f446479c = r113.findViewById(R.id.divider);
        r112.f446478b = (TextView) r113.findViewById(R.id.text_menu);
        r112.f446480d = r113.findViewById(R.id.content);
        r112.f446481e = r113.findViewById(R.id.header_divider);
        r112.f446482f = r113.findViewById(R.id.layout_container);
        r113.setTag(r112);
        b.a.C5404a r114 = r112;
        r110 = r113;
    L8:
        r114.f446478b.setText(r101.f446472a);
        if (r100 != (getCount() - 1)) goto L11;
        r114.f446479c.setVisibility(8);
    L13:
        if (r101.f446474c == (-1)) goto L15;
        r114.f446478b.setTextColor(r102.getResources().getColor(r101.f446474c));
    L16:
        int r104 = r101.f446475d;
        if (r104 == (-1)) goto L19;
        r114.f446479c.setBackgroundResource(r104);
    L19:
        View r115 = r114.f446481e;
        if (r101.f446476e == true) goto L23;
        r103 = 8;
    L23:
        r115.setVisibility(r103);
        r110.setOnHoverListener(new ViewOnHoverListenerC5403a());
        if (this.f446471c == false) goto L35;
        if (getCount() != 1) goto L28;
        r110.setBackground(this.f446469a.getResources().getDrawable(R.drawable.dialog_list_bottom_item_selector));
    L43:
        return r110;
    L28:
        if (r100 != 0) goto L31;
        r110.setBackground(this.f446469a.getResources().getDrawable(R.drawable.dialog_list_center_item_selector));
        goto L43
    L31:
        if ((getCount() - 1) != r100) goto L33;
        r110.setBackground(this.f446469a.getResources().getDrawable(R.drawable.dialog_list_bottom_item_selector));
        goto L43
    L33:
        r110.setBackground(this.f446469a.getResources().getDrawable(R.drawable.dialog_list_center_item_selector));
        goto L43
    L35:
        if (getCount() != 1) goto L37;
        r110.setBackground(this.f446469a.getResources().getDrawable(R.drawable.dialog_list_onlyone_item_selector));
        goto L43
    L37:
        if (r100 != 0) goto L40;
        r110.setBackground(this.f446469a.getResources().getDrawable(R.drawable.dialog_list_top_item_selector));
        goto L43
    L40:
        if ((getCount() - 1) != r100) goto L42;
        r110.setBackground(this.f446469a.getResources().getDrawable(R.drawable.dialog_list_bottom_item_selector));
        goto L43
    L42:
        r110.setBackground(this.f446469a.getResources().getDrawable(R.drawable.dialog_list_center_item_selector));
        goto L43
    L15:
        r114.f446478b.setTextColor(r102.getResources().getColor(R.color.text_title));
        goto L16
    L11:
        r114.f446479c.setVisibility(0);
        goto L13
    L5:
        if ((r110.getTag() instanceof b.a.C5404a) == false) goto L7;
        r114 = (b.a.C5404a) r110.getTag();
        goto L8
    }
}
