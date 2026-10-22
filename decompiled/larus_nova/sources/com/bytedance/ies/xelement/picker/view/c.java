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
import h86.g;
import h86.h;
import h86.i;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends h86.a implements View.OnClickListener {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f f250265j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d86.c f250266k;

    @Override // h86.a
    public final void e() {
        this.f250266k.getClass();
    }

    @Override // h86.a
    public final d86.a f() {
        return this.f250266k;
    }

    public c(d86.c r110) {
        super(r110.f467411c);
        this.f250266k = r110;
        Context r100 = r110.f467411c;
        Dialog r101 = this.f484208e;
        if (r101 == null) goto L5;
        f().getClass();
        r101.setCancelable(true);
    L5:
        d();
        c();
        LayoutInflater.from(r100).inflate(R.layout.lynx_picker_time, this.f484205b);
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
        LinearLayout r112 = (LinearLayout) b(R.id.timepicker);
        r112.setBackgroundColor(-1);
        f r113 = new f(r112, r110.f467427n, r110.f467431r);
        this.f250265j = r113;
        Calendar r114 = r110.f467429p;
        Calendar r115 = r110.f467430q;
        if (r114 != null) goto L19;
        r114 = Calendar.getInstance();
    L19:
        if (r115 != null) goto L21;
        r115 = Calendar.getInstance();
    L21:
        r114.set(2000, 0, 1);
        r115.set(2000, 0, 1);
        if (r114.getTimeInMillis() <= r115.getTimeInMillis()) goto L24;
        r115.add(5, 1);
    L24:
        r113.f250289b.setAdapter(new b86.c(r114.get(11), r115.get(11)));
        r113.f250290c.setAdapter(new b86.b(0, 59));
        r113.f250291d.setAdapter(new b86.b(0, 59));
        r113.f250292e = r114;
        r113.f250293f = r115;
        r113.f250289b.setOnItemSelectedListener(new g(r113));
        r113.f250290c.setOnItemSelectedListener(new h(r113));
        r113.f250291d.setOnItemSelectedListener(new i(r113));
        Calendar r116 = r110.f467428o;
        f r117 = this.f250265j;
        if (r117.f250292e != null) goto L27;
    L32:
        this.f250265j.getClass();
        f r118 = this.f250265j;
        r118.f250289b.setTextXOffset(0);
        r118.f250290c.setTextXOffset(0);
        r118.f250291d.setTextXOffset(0);
        f r119 = this.f250265j;
        int r120 = r110.f467419k;
        r119.f250289b.setItemsVisibleCount(r120);
        r119.f250290c.setItemsVisibleCount(r120);
        r119.f250291d.setItemsVisibleCount(r120);
        f r121 = this.f250265j;
        r121.f250289b.setAlphaGradient(false);
        r121.f250290c.setAlphaGradient(false);
        r121.f250291d.setAlphaGradient(false);
        g();
        f r122 = this.f250265j;
        r122.f250289b.setCyclic(false);
        r122.f250290c.setCyclic(false);
        r122.f250291d.setCyclic(false);
        f r123 = this.f250265j;
        r123.f250289b.setDividerColor(-2763307);
        r123.f250290c.setDividerColor(-2763307);
        r123.f250291d.setDividerColor(-2763307);
        f r124 = this.f250265j;
        WheelView.DividerType r125 = r110.f467418j;
        r124.f250289b.setDividerType(r125);
        r124.f250290c.setDividerType(r125);
        r124.f250291d.setDividerType(r125);
        f r126 = this.f250265j;
        r126.f250289b.setLineSpacingMultiplier(1.6f);
        r126.f250290c.setLineSpacingMultiplier(1.6f);
        r126.f250291d.setLineSpacingMultiplier(1.6f);
        f r127 = this.f250265j;
        r127.f250289b.setTextColorOut(-5723992);
        r127.f250290c.setTextColorOut(-5723992);
        r127.f250291d.setTextColorOut(-5723992);
        f r128 = this.f250265j;
        r128.f250289b.setTextColorCenter(-14013910);
        r128.f250290c.setTextColorCenter(-14013910);
        r128.f250291d.setTextColorCenter(-14013910);
        f r129 = this.f250265j;
        r129.f250289b.f250239g = false;
        r129.f250290c.f250239g = false;
        r129.f250291d.f250239g = false;
        return;
    L27:
        if (r117.f250293f == null) goto L32;
        if (r116 != null) goto L31;
        r116 = Calendar.getInstance();
    L31:
        r116.set(2000, 0, 1);
        r117.a(r116);
        goto L32
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
        if (r111.equals(LocationMonitorConst.SUBMIT) == false) goto L26;
        d86.c r112 = this.f250266k;
        f86.g r100 = r112.f467425l;
        if (r100 == null) goto L24;
        String r101 = r112.f467432s;
        if (r101 != null) goto L10;
        r101 = ":";
    L10:
        boolean[] r113 = r112.f467427n;
        Calendar r102 = this.f250265j.f250294g;
        int r103 = r102.get(11);
        int r104 = r102.get(12);
        int r105 = r102.get(13);
        if (r113 != null) goto L13;
    L22:
        String r114 = String.format(Locale.getDefault(), "%02d%s%02d%s%02d", new Object[]{Integer.valueOf(r103), r101, Integer.valueOf(r104), r101, Integer.valueOf(r105)});
    L23:
        r100.onConfirm(r114);
        goto L24
    L13:
        if (r113.length != 3) goto L22;
        if (r113[2] == false) goto L19;
        r114 = String.format(Locale.getDefault(), "%02d%s%02d%s%02d", new Object[]{Integer.valueOf(r103), r101, Integer.valueOf(r104), r101, Integer.valueOf(r105)});
        goto L23
    L19:
        if (r113[1] == false) goto L21;
        r114 = String.format(Locale.getDefault(), "%02d%s%02d", new Object[]{Integer.valueOf(r103), r101, Integer.valueOf(r104)});
        goto L23
    L21:
        r114 = String.format(Locale.getDefault(), "%02d", new Object[]{Integer.valueOf(r103)});
    L24:
        this.f484210g = true;
    L31:
        a();
        return;
    L26:
        if (r111.equals("cancel") == false) goto L31;
        f86.a r115 = this.f250266k.f467409a;
        if (r115 == null) goto L30;
        r115.onCancel();
    L30:
        this.f484210g = true;
        goto L31
    }
}
