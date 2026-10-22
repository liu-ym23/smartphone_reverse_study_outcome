package com.bytedance.ies.xelement.picker.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends h86.a implements View.OnClickListener {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e f250263j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d86.b f250264k;

    @Override // h86.a
    public final void e() {
        this.f250264k.getClass();
    }

    @Override // h86.a
    public final d86.a f() {
        return this.f250264k;
    }

    public b(d86.b r110) {
        super(r110.f467411c);
        this.f250264k = r110;
        Context r100 = r110.f467411c;
        Dialog r101 = this.f484208e;
        if (r101 == null) goto L5;
        f().getClass();
        r101.setCancelable(true);
    L5:
        d();
        c();
        LayoutInflater.from(r100).inflate(r110.f467410b, this.f484205b);
        TextView r102 = (TextView) b(R.id.tvTitle);
        RelativeLayout r103 = (RelativeLayout) b(R.id.rv_topbar);
        Button r104 = (Button) b(R.id.btnSubmit);
        Button r105 = (Button) b(R.id.btnCancel);
        r104.setTag(LocationMonitorConst.SUBMIT);
        r105.setTag("cancel");
        r104.setOnClickListener(this);
        r105.setOnClickListener(this);
        Map<String, String> r106 = r110.f467424p.a();
        if (TextUtils.isEmpty(null) == false) goto L8;
        String r107 = r106.get("confirm");
    L9:
        r104.setText(r107);
        if (TextUtils.isEmpty(null) == false) goto L12;
        String r108 = r106.get("cancel");
    L13:
        r105.setText(r108);
        if (TextUtils.isEmpty(r110.f467412d) == false) goto L16;
        String r109 = "";
    L17:
        r102.setText(r109);
        r104.setTextColor(r110.f467413e);
        r105.setTextColor(r110.f467414f);
        r102.setTextColor(r110.f467415g);
        r103.setBackgroundColor(-657931);
        float r111 = 17;
        r104.setTextSize(r111);
        r105.setTextSize(r111);
        r102.setTextSize(r110.f467416h);
        LinearLayout r112 = (LinearLayout) b(R.id.optionspicker);
        r112.setBackgroundColor(-1);
        e r113 = new e(r112);
        this.f250263j = r113;
        r113.f250287f = r110;
        f86.e r114 = r110.f467420l;
        if (r114 == null) goto L20;
        r113.f250286e = r114;
    L20:
        List<List<String>> r115 = r110.f467422n;
        if (r115 != null) goto L25;
        r113.f250284c = null;
        ((ArrayList) r113.f250283b).clear();
        View r116 = r113.f250282a;
        if ((r116 instanceof ViewGroup) == false) goto L46;
        ((ViewGroup) r116).removeAllViews();
    L46:
        e r117 = this.f250263j;
        this.f250264k.getClass();
        Iterator r118 = ((ArrayList) r117.f250283b).iterator();
    L48:
        if (r118.hasNext() == false) goto L50;
        ((WheelView) r118.next()).setTextSize(18);
        goto L48
    L50:
        e r119 = this.f250263j;
        int r120 = this.f250264k.f467419k;
        Iterator r121 = ((ArrayList) r119.f250283b).iterator();
    L52:
        if (r121.hasNext() == false) goto L54;
        ((WheelView) r121.next()).setItemsVisibleCount(r120);
        goto L52
    L54:
        e r122 = this.f250263j;
        this.f250264k.getClass();
        Iterator r123 = ((ArrayList) r122.f250283b).iterator();
    L56:
        if (r123.hasNext() == false) goto L58;
        ((WheelView) r123.next()).setAlphaGradient(false);
        goto L56
    L58:
        e r124 = this.f250263j;
        this.f250264k.getClass();
        Iterator r125 = ((ArrayList) r124.f250283b).iterator();
    L60:
        if (r125.hasNext() == false) goto L62;
        ((WheelView) r125.next()).setLabel(null);
        goto L60
    L62:
        e r126 = this.f250263j;
        this.f250264k.getClass();
        Iterator r127 = ((ArrayList) r126.f250283b).iterator();
    L64:
        if (r127.hasNext() == false) goto L66;
        WheelView r128 = (WheelView) r127.next();
        goto L64
    L66:
        this.f250264k.getClass();
        this.f250264k.getClass();
        e r129 = this.f250263j;
        this.f250264k.getClass();
        Iterator r130 = ((ArrayList) r129.f250283b).iterator();
    L68:
        if (r130.hasNext() == false) goto L70;
        ((WheelView) r130.next()).setCyclic(false);
        goto L68
    L70:
        e r131 = this.f250263j;
        Typeface r132 = this.f250264k.f467417i;
        Iterator r133 = ((ArrayList) r131.f250283b).iterator();
    L72:
        if (r133.hasNext() == false) goto L74;
        ((WheelView) r133.next()).setTypeface(r132);
        goto L72
    L74:
        this.f250264k.getClass();
        g();
        e r134 = this.f250263j;
        this.f250264k.getClass();
        Iterator r135 = ((ArrayList) r134.f250283b).iterator();
    L76:
        if (r135.hasNext() == false) goto L78;
        ((WheelView) r135.next()).setDividerColor(-2763307);
        goto L76
    L78:
        e r136 = this.f250263j;
        WheelView.DividerType r137 = this.f250264k.f467418j;
        Iterator r138 = ((ArrayList) r136.f250283b).iterator();
    L80:
        if (r138.hasNext() == false) goto L82;
        ((WheelView) r138.next()).setDividerType(r137);
        goto L80
    L82:
        e r139 = this.f250263j;
        this.f250264k.getClass();
        Iterator r140 = ((ArrayList) r139.f250283b).iterator();
    L84:
        if (r140.hasNext() == false) goto L86;
        ((WheelView) r140.next()).setLineSpacingMultiplier(1.6f);
        goto L84
    L86:
        e r141 = this.f250263j;
        this.f250264k.getClass();
        Iterator r142 = ((ArrayList) r141.f250283b).iterator();
    L88:
        if (r142.hasNext() == false) goto L90;
        ((WheelView) r142.next()).setTextColorOut(-5723992);
        goto L88
    L90:
        e r143 = this.f250263j;
        this.f250264k.getClass();
        Iterator r144 = ((ArrayList) r143.f250283b).iterator();
    L92:
        if (r144.hasNext() == false) goto L94;
        ((WheelView) r144.next()).setTextColorCenter(-14013910);
        goto L92
    L94:
        e r145 = this.f250263j;
        this.f250264k.getClass();
        Iterator r146 = ((ArrayList) r145.f250283b).iterator();
    L96:
        if (r146.hasNext() == false) goto L98;
        ((WheelView) r146.next()).f250239g = false;
        goto L96
    L98:
        List<Integer> r147 = this.f250264k.f467423o;
        e r148 = this.f250263j;
        if (r148 == null) goto L120;
        r148.a(r147);
        return;
    L120:
        return;
    L25:
        List<List<String>> r149 = r113.f250284c;
        if (r149 != null) goto L28;
        r113.f250284c = new ArrayList();
    L29:
        ((ArrayList) r113.f250284c).addAll(r115);
        int r150 = 0;
    L31:
        if (r150 >= ((ArrayList) r115).size()) goto L44;
        List r151 = (List) ListProtector.get(r115, r150);
        if (r151 == null) goto L42;
    L35:
        if (((ArrayList) r113.f250283b).size() > r150) goto L40;
        WheelView r152 = new WheelView(r113.f250282a.getContext());
        r152.setLocalizeAdapter(r113.f250287f.f467424p);
        LinearLayout.LayoutParams r153 = new LinearLayout.LayoutParams(0, -1);
        r153.weight = 1.0f;
        r152.setLayoutParams(r153);
        r152.setOnItemSelectedListener(new h86.f(r113, r150));
        View r154 = r113.f250282a;
        if ((r154 instanceof ViewGroup) == false) goto L39;
        ((ViewGroup) r154).addView(r152);
    L39:
        ((ArrayList) r113.f250283b).add(r152);
        goto L35
    L40:
        ((WheelView) ListProtector.get(r113.f250283b, r150)).setAdapter(new b86.a(r151));
        r150 = r150 + 1;
        goto L31
    L42:
        throw new IllegalArgumentException("items can not be null");
    L44:
        if (((ArrayList) r113.f250285d).size() == ((ArrayList) r113.f250284c).size()) goto L46;
        r113.a(null);
        goto L46
    L28:
        ((ArrayList) r149).clear();
        goto L29
    L16:
        r109 = r110.f467412d;
        goto L17
    L12:
        r108 = null;
        goto L13
    L8:
        r107 = null;
        goto L9
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        String r101 = (String) r100.getTag();
        if (r101.equals(LocationMonitorConst.SUBMIT) == false) goto L9;
        if (this.f250264k.f467421m == null) goto L7;
        e r102 = this.f250263j;
        r102.getClass();
        ArrayList r103 = new ArrayList(r102.f250285d);
        this.f250264k.f467421m.a(r103);
    L7:
        this.f484210g = true;
    L14:
        a();
        return;
    L9:
        if (r101.equals("cancel") == false) goto L14;
        f86.a r104 = this.f250264k.f467409a;
        if (r104 == null) goto L13;
        r104.onCancel();
    L13:
        this.f484210g = true;
        goto L14
    }
}
