package com.bytedance.ies.xelement.picker.view;

import android.view.View;
import com.larus.nova.R;
import java.util.Calendar;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f250288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WheelView f250289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WheelView f250290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WheelView f250291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Calendar f250292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Calendar f250293f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Calendar f250294g;

    public final void a(Calendar r110) {
        if (r110.getTimeInMillis() >= this.f250292e.getTimeInMillis()) goto L7;
        Calendar r111 = this.f250292e;
        Calendar r100 = Calendar.getInstance();
        r100.setTimeInMillis(r111.getTimeInMillis());
    L5:
        r110 = r100;
    L9:
        int r101 = r110.get(11);
        int r102 = r110.get(12);
        int r103 = r110.get(13);
        int r104 = this.f250292e.get(11);
        int r105 = this.f250292e.get(12);
        int r106 = this.f250292e.get(13);
        int r107 = this.f250293f.get(11);
        int r108 = this.f250293f.get(12);
        int r109 = this.f250293f.get(13);
        if (r104 != r107) goto L20;
        this.f250289b.setAdapter(new b86.b(r104, r107));
        int r112 = r101 - r104;
        this.f250290c.setAdapter(new b86.b(r105, r108));
        int r113 = r102 - r105;
        if (r105 != r108) goto L14;
        this.f250291d.setAdapter(new b86.b(r106, r109));
    L16:
        r103 = r103 - r106;
    L38:
        this.f250294g = r110;
        this.f250289b.setCurrentIndex(r112);
        this.f250290c.setCurrentIndex(r113);
        this.f250291d.setCurrentIndex(r103);
        return;
    L14:
        if (r102 != r105) goto L17;
        this.f250291d.setAdapter(new b86.b(r106, 59));
        goto L16
    L17:
        if (r102 != r108) goto L19;
        this.f250291d.setAdapter(new b86.b(0, r109));
        goto L38
    L19:
        this.f250291d.setAdapter(new b86.b(0, 59));
        goto L38
    L20:
        if (r104 >= r107) goto L22;
        this.f250289b.setAdapter(new b86.b(r104, r107));
        int r114 = r101 - r104;
    L25:
        if (r101 != r104) goto L31;
        this.f250290c.setAdapter(new b86.b(r105, 59));
        int r115 = r102 - r105;
        if (r102 != r105) goto L29;
        this.f250291d.setAdapter(new b86.b(r106, 59));
        r103 = r103 - r106;
    L30:
        r102 = r115;
    L37:
        r113 = r102;
        r112 = r114;
        goto L38
    L29:
        this.f250291d.setAdapter(new b86.b(0, 59));
        goto L30
    L31:
        if (r101 != r107) goto L36;
        this.f250290c.setAdapter(new b86.b(0, r108));
        if (r102 != r108) goto L35;
        this.f250291d.setAdapter(new b86.b(0, r109));
        goto L37
    L35:
        this.f250291d.setAdapter(new b86.b(0, 59));
        goto L37
    L36:
        this.f250290c.setAdapter(new b86.b(0, 59));
        this.f250291d.setAdapter(new b86.b(0, 59));
        goto L37
    L22:
        this.f250289b.setAdapter(new b86.c(r104, r107));
        r114 = r101 - r104;
        if (r114 >= 0) goto L25;
        r114 = r114 + 24;
        goto L25
    L7:
        if (r110.getTimeInMillis() <= this.f250293f.getTimeInMillis()) goto L9;
        Calendar r116 = this.f250293f;
        r100 = Calendar.getInstance();
        r100.setTimeInMillis(r116.getTimeInMillis());
        goto L5
    }

    public f(View r210, boolean[] r211, y76.a r212) {
        Calendar r110 = Calendar.getInstance();
        r110.set(2000, 0, 1, 0, 0, 0);
        this.f250292e = r110;
        Calendar r100 = Calendar.getInstance();
        r100.set(2000, 0, 1, 23, 59, 59);
        this.f250293f = r100;
        Calendar r101 = Calendar.getInstance();
        int r102 = 0;
        r101.set(2000, 0, 1);
        this.f250294g = r101;
        this.f250288a = r210;
        WheelView r103 = (WheelView) r210.findViewById(R.id.hour);
        this.f250289b = r103;
        WheelView r104 = (WheelView) r210.findViewById(R.id.min);
        this.f250290c = r104;
        WheelView r105 = (WheelView) r210.findViewById(R.id.second);
        this.f250291d = r105;
        r103.setLocalizeAdapter(r212);
        r104.setLocalizeAdapter(r212);
        r105.setLocalizeAdapter(r212);
        r103.setGravity(17);
        r104.setGravity(17);
        r105.setGravity(17);
        if (r211.length != 3) goto L19;
        if (r211[0] == false) goto L7;
        int r106 = 0;
    L8:
        r103.setVisibility(r106);
        if (r211[1] == false) goto L11;
        int r107 = 0;
    L12:
        r104.setVisibility(r107);
        if (r211[2] == true) goto L16;
        r102 = 8;
    L16:
        r105.setVisibility(r102);
        float r108 = 18;
        r103.setTextSize(r108);
        r104.setTextSize(r108);
        r105.setTextSize(r108);
        return;
    L11:
        r107 = 8;
        goto L12
    L7:
        r106 = 8;
        goto L8
    L19:
        throw new IllegalArgumentException("type[] length is not 3");
    }
}
