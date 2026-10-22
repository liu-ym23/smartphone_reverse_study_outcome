package com.bytedance.ies.xelement.picker.view;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.nova.R;
import f86.g;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends h86.a implements View.OnClickListener {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f250261j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d86.c f250262k;

    @Override // h86.a
    public final void e() {
        this.f250262k.getClass();
    }

    @Override // h86.a
    public final d86.a f() {
        return this.f250262k;
    }

    public a(d86.c r110) {
        super(r110.f467411c);
        this.f250262k = r110;
        Context r100 = r110.f467411c;
        Dialog r101 = this.f484208e;
        if (r101 == null) goto L5;
        f().getClass();
        r101.setCancelable(true);
    L5:
        d();
        c();
        LayoutInflater.from(r100).inflate(R.layout.lynx_picker_date, this.f484205b);
        TextView r102 = (TextView) b(R.id.tvTitle);
        RelativeLayout r103 = (RelativeLayout) b(R.id.rv_topbar);
        Button r104 = (Button) b(R.id.btnSubmit);
        Button r105 = (Button) b(R.id.btnCancel);
        r104.setTag(LocationMonitorConst.SUBMIT);
        r105.setTag("cancel");
        r104.setOnClickListener(this);
        r105.setOnClickListener(this);
        Map<String, String> r106 = r110.f467431r.a();
        String r107 = null;
        if (TextUtils.isEmpty(null) == false) goto L8;
        String r108 = r106.get("confirm");
    L9:
        r104.setText(r108);
        if (TextUtils.isEmpty(null) == false) goto L12;
        r107 = r106.get("cancel");
    L12:
        r105.setText(r107);
        if (TextUtils.isEmpty(r110.f467412d) == false) goto L15;
        String r109 = "";
    L16:
        r102.setText(r109);
        r104.setTextColor(r110.f467413e);
        r105.setTextColor(r110.f467414f);
        r102.setTextColor(r110.f467415g);
        r103.setBackgroundColor(-657931);
        float r111 = 17;
        r104.setTextSize(r111);
        r105.setTextSize(r111);
        r102.setTextSize(r110.f467416h);
        LinearLayout r112 = (LinearLayout) b(R.id.datepicker);
        r112.setBackgroundColor(-1);
        this.f250261j = new d(r112, r110.f467426m, r110.f467431r);
        if (r110.f467429p != null) goto L20;
        Calendar r113 = Calendar.getInstance();
        r110.f467429p = r113;
        r113.set(1900, 0, 1);
    L20:
        if (r110.f467430q != null) goto L23;
        Calendar r114 = Calendar.getInstance();
        r110.f467430q = r114;
        r114.set(2100, 11, 31);
    L23:
        if (r110.f467429p.get(1) >= 1900) goto L25;
    L26:
        r110.f467429p.set(1900, 0, 1);
    L28:
        if (r110.f467430q.get(1) >= 1900) goto L30;
    L31:
        r110.f467430q.set(2100, 11, 31);
    L32:
        d r115 = this.f250261j;
        Calendar r116 = r110.f467429p;
        Calendar r117 = r110.f467430q;
        r115.getClass();
        if (r116 != null) goto L46;
        if (r117 == null) goto L46;
        int r118 = r117.get(1);
        int r119 = r117.get(2) + 1;
        int r120 = r117.get(5);
        int r121 = r115.f250273e;
        if (r118 <= r121) goto L38;
        r115.f250274f = r118;
        r115.f250276h = r119;
        r115.f250278j = r120;
    L63:
        if (r110.f467429p == null) goto L87;
        if (r110.f467430q == null) goto L87;
        if (r110.f467428o != null) goto L70;
        r110.f467428o = Calendar.getInstance();
    L70:
        if (r110.f467428o.getTimeInMillis() >= r110.f467429p.getTimeInMillis()) goto L73;
        r110.f467428o.setTimeInMillis(r110.f467429p.getTimeInMillis());
    L73:
        if (r110.f467428o.getTimeInMillis() <= r110.f467430q.getTimeInMillis()) goto L75;
        r110.f467428o.setTimeInMillis(r110.f467430q.getTimeInMillis());
    L75:
        int r122 = r110.f467428o.get(1);
        int r123 = r110.f467428o.get(2) + 1;
        int r124 = r110.f467428o.get(5);
        d r125 = this.f250261j;
        r125.f250279k = r122;
        r125.f250280l = r123;
        r125.f250281m = r124;
        r125.f250270b.setAdapter(new b86.b(r125.f250273e, r125.f250274f));
        r125.f250270b.setCurrentIndex(r122 - r125.f250273e);
        int r126 = r125.f250273e;
        int r127 = r125.f250274f;
        if (r126 != r127) goto L78;
        int r128 = r125.f250275g;
        int r129 = r125.f250276h;
    L84:
        r125.f250271c.setAdapter(new b86.b(r128, r129));
        r125.f250271c.setCurrentIndex(r123 - r128);
        r125.c(true, r122, r123, r124);
        this.f250261j.getClass();
        d r130 = this.f250261j;
        r130.f250270b.setTextXOffset(0);
        r130.f250271c.setTextXOffset(0);
        r130.f250272d.setTextXOffset(0);
        d r131 = this.f250261j;
        int r132 = r110.f467419k;
        r131.f250272d.setItemsVisibleCount(r132);
        r131.f250271c.setItemsVisibleCount(r132);
        r131.f250270b.setItemsVisibleCount(r132);
        d r133 = this.f250261j;
        r133.f250272d.setAlphaGradient(false);
        r133.f250271c.setAlphaGradient(false);
        r133.f250270b.setAlphaGradient(false);
        g();
        d r134 = this.f250261j;
        r134.f250270b.setCyclic(false);
        r134.f250271c.setCyclic(false);
        r134.f250272d.setCyclic(false);
        d r135 = this.f250261j;
        r135.f250272d.setDividerColor(-2763307);
        r135.f250271c.setDividerColor(-2763307);
        r135.f250270b.setDividerColor(-2763307);
        d r136 = this.f250261j;
        WheelView.DividerType r137 = r110.f467418j;
        r136.f250272d.setDividerType(r137);
        r136.f250271c.setDividerType(r137);
        r136.f250270b.setDividerType(r137);
        d r138 = this.f250261j;
        r138.f250272d.setLineSpacingMultiplier(1.6f);
        r138.f250271c.setLineSpacingMultiplier(1.6f);
        r138.f250270b.setLineSpacingMultiplier(1.6f);
        d r139 = this.f250261j;
        r139.f250272d.setTextColorOut(-5723992);
        r139.f250271c.setTextColorOut(-5723992);
        r139.f250270b.setTextColorOut(-5723992);
        d r140 = this.f250261j;
        r140.f250272d.setTextColorCenter(-14013910);
        r140.f250271c.setTextColorCenter(-14013910);
        r140.f250270b.setTextColorCenter(-14013910);
        d r141 = this.f250261j;
        r141.f250272d.f250239g = false;
        r141.f250271c.f250239g = false;
        r141.f250270b.f250239g = false;
        return;
    L78:
        if (r122 != r126) goto L80;
        r128 = r125.f250275g;
    L83:
        r129 = 12;
        goto L84
    L80:
        if (r122 != r127) goto L82;
        r129 = r125.f250276h;
        r128 = 1;
        goto L84
    L82:
        r128 = 1;
    L87:
        throw new IllegalStateException("you should call setRangDate() first");
    L38:
        if (r118 != r121) goto L63;
        int r142 = r115.f250275g;
        if (r119 <= r142) goto L42;
        r115.f250274f = r118;
        r115.f250276h = r119;
        r115.f250278j = r120;
        goto L63
    L42:
        if (r119 != r142) goto L63;
        if (r120 <= r115.f250277i) goto L63;
        r115.f250274f = r118;
        r115.f250276h = r119;
        r115.f250278j = r120;
    L46:
        if (r116 == null) goto L59;
        if (r117 != null) goto L59;
        int r143 = r116.get(1);
        int r144 = r116.get(2) + 1;
        int r145 = r116.get(5);
        int r146 = r115.f250274f;
        if (r143 >= r146) goto L51;
        r115.f250275g = r144;
        r115.f250277i = r145;
        r115.f250273e = r143;
        goto L63
    L51:
        if (r143 != r146) goto L63;
        int r147 = r115.f250276h;
        if (r144 >= r147) goto L55;
        r115.f250275g = r144;
        r115.f250277i = r145;
        r115.f250273e = r143;
        goto L63
    L55:
        if (r144 != r147) goto L63;
        if (r145 >= r115.f250278j) goto L63;
        r115.f250275g = r144;
        r115.f250277i = r145;
        r115.f250273e = r143;
    L59:
        if (r116 == null) goto L63;
        if (r117 == null) goto L63;
        r115.f250273e = r116.get(1);
        r115.f250274f = r117.get(1);
        r115.f250275g = r116.get(2) + 1;
        r115.f250276h = r117.get(2) + 1;
        r115.f250277i = r116.get(5);
        r115.f250278j = r117.get(5);
        goto L63
    L30:
        if (r110.f467430q.get(1) <= 2100) goto L32;
    L25:
        if (r110.f467429p.get(1) <= 2100) goto L28;
    L15:
        r109 = r110.f467412d;
        goto L16
    L8:
        r108 = null;
        goto L9
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        String r111 = (String) r110.getTag();
        if (r111.equals(LocationMonitorConst.SUBMIT) == false) goto L23;
        g r112 = this.f250262k.f467425l;
        if (r112 == null) goto L21;
        d r100 = this.f250261j;
        r100.getClass();
        Calendar r101 = Calendar.getInstance();
        r101.set(r100.f250279k, r100.f250280l - 1, r100.f250281m);
        String r102 = this.f250262k.f467432s;
        if (r102 != null) goto L10;
        r102 = "-";
    L10:
        int r103 = r101.get(1);
        int r104 = r101.get(2) + 1;
        int r105 = r101.get(5);
        boolean[] r106 = this.f250262k.f467426m;
        if (r106.length == 3) goto L14;
        String r107 = String.format(Locale.getDefault(), "%04d%s%02d%s%02d", new Object[]{Integer.valueOf(r103), r102, Integer.valueOf(r104), r102, Integer.valueOf(r105)});
    L20:
        r112.onConfirm(r107);
        goto L21
    L14:
        if (r106[2] == false) goto L17;
        r107 = String.format(Locale.getDefault(), "%04d%s%02d%s%02d", new Object[]{Integer.valueOf(r103), r102, Integer.valueOf(r104), r102, Integer.valueOf(r105)});
        goto L20
    L17:
        if (r106[1] == false) goto L19;
        r107 = String.format(Locale.getDefault(), "%04d%s%02d", new Object[]{Integer.valueOf(r103), r102, Integer.valueOf(r104)});
        goto L20
    L19:
        r107 = String.format(Locale.getDefault(), "%04d", new Object[]{Integer.valueOf(r103)});
    L21:
        this.f484210g = true;
    L28:
        a();
        return;
    L23:
        if (r111.equals("cancel") == false) goto L28;
        f86.a r113 = this.f250262k.f467409a;
        if (r113 == null) goto L27;
        r113.onCancel();
    L27:
        this.f484210g = true;
        goto L28
    }
}
