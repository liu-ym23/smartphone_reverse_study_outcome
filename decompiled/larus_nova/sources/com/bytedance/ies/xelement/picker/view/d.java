package com.bytedance.ies.xelement.picker.view;

import android.view.View;
import com.larus.nova.R;
import com.tencent.connect.common.Constants;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final List<String> f250267n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final List<String> f250268o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f250269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WheelView f250270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WheelView f250271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WheelView f250272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f250273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f250274f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f250275g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f250276h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f250277i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f250278j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f250279k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f250280l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f250281m;

    static {
        f250267n = Arrays.asList(new String[]{"1", "3", "5", "7", "8", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "12"});
        f250268o = Arrays.asList(new String[]{"4", "6", Constants.VIA_SHARE_TYPE_MINI_PROGRAM, "11"});
    }

    public d(View r100, boolean[] r101, y76.a r102) {
        this.f250273e = 1900;
        this.f250274f = 2100;
        this.f250275g = 1;
        this.f250276h = 12;
        this.f250277i = 1;
        this.f250278j = 31;
        this.f250269a = r100;
        WheelView r103 = (WheelView) r100.findViewById(R.id.year);
        this.f250270b = r103;
        WheelView r104 = (WheelView) r100.findViewById(R.id.month);
        this.f250271c = r104;
        WheelView r105 = (WheelView) r100.findViewById(R.id.day);
        this.f250272d = r105;
        r103.setLocalizeAdapter(r102);
        r104.setLocalizeAdapter(r102);
        r105.setLocalizeAdapter(r102);
        if (r101.length != 3) goto L19;
        int r106 = 0;
        if (r101[0] == false) goto L7;
        int r107 = 0;
    L8:
        r103.setVisibility(r107);
        if (r101[1] == false) goto L11;
        int r108 = 0;
    L12:
        r104.setVisibility(r108);
        if (r101[2] == true) goto L16;
        r106 = 8;
    L16:
        r105.setVisibility(r106);
        r103.setGravity(17);
        r104.setGravity(17);
        r105.setGravity(17);
        float r109 = 18;
        r105.setTextSize(r109);
        r104.setTextSize(r109);
        r103.setTextSize(r109);
        r103.setOnItemSelectedListener(new h86.c(this));
        r104.setOnItemSelectedListener(new h86.d(this));
        r105.setOnItemSelectedListener(new h86.e(this));
        return;
    L11:
        r108 = 8;
        goto L12
    L7:
        r107 = 8;
        goto L8
    L19:
        throw new IllegalArgumentException("type[] length is not 3");
    }

    public static int a(int r100, int r101, int r102) {
        if (f250267n.contains(String.valueOf(r101)) == false) goto L6;
        return Math.min(r102, 31);
    L6:
        if (f250268o.contains(String.valueOf(r101)) == false) goto L9;
        return Math.min(r102, 30);
    L9:
        if ((r100 % 4) == 0) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == false) goto L17;
        return Math.min(r102, 29);
    L17:
        return Math.min(r102, 28);
    L11:
        if ((r100 % 100) == 0) goto L13;
        r103 = true;
        goto L14
    }

    public final void b(boolean r100, int r101, int r102, int r103) {
        this.f250272d.setAdapter(new b86.b(r102, r103));
        if (r100 == false) goto L6;
        this.f250272d.setCurrentIndex(r101);
    L8:
        this.f250281m = r101 + r102;
        return;
    L6:
        if (r101 <= (this.f250272d.getAdapter().getItemsCount() - 1)) goto L8;
        r101 = this.f250272d.getAdapter().getItemsCount() - 1;
        this.f250272d.setCurrentIndex(r101);
        goto L8
    }

    public final void c(boolean r100, int r101, int r102, int r103) {
        int r104 = this.f250273e;
        int r105 = this.f250274f;
        if (r104 == r105) goto L5;
    L7:
        if (r101 == r104) goto L9;
    L11:
        int r106 = 1;
        if (r101 == r105) goto L14;
    L16:
        int r107 = 31;
    L17:
        int r108 = a(r101, r102, r107);
        if (r100 == false) goto L20;
        int r109 = r103 - r106;
    L21:
        b(r100, r109, r106, r108);
        return;
    L20:
        r109 = this.f250272d.getCurrentItem();
        goto L21
    L14:
        if (r102 != this.f250276h) goto L16;
        r107 = this.f250278j;
        goto L17
    L9:
        if (r102 != this.f250275g) goto L11;
        r106 = this.f250277i;
        goto L16
    L5:
        if (this.f250275g != this.f250276h) goto L7;
        r106 = this.f250277i;
        r107 = this.f250278j;
        goto L17
    }
}
