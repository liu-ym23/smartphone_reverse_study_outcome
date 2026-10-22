package com.ss.android.lark.coremd.utils;

import com.bytedance.android.ec.model.response.anchorv3.PromotionCrossBorderStruct;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import v7b.p;
import v7b.q;
import v7b.s;
import v7b.u;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f419966a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f419967b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f419968c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f419969d = null;

    static {
        f419966a = new String[]{"", "M", "MM", "MMM"};
        f419967b = new String[]{"", "C", PromotionCrossBorderStruct.CLEAR_CC_TYPE, "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        f419968c = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        f419969d = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    }

    public static int a(v7b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        int r101 = -1;
    L4:
        if ((r100 instanceof v7b.c) == true) goto L9;
        if ((r100 instanceof u) == true) goto L9;
        return r101;
    L9:
        r100 = (v7b.a) ((p) r100).f553568d;
        r101 = r101 + 1;
        goto L4
    }

    public static int b(u r100, s r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        Integer r102 = r100.f553577k;
        if (r102 == null) goto L5;
        int r103 = r102.intValue();
    L6:
        s r104 = r100.f553569e;
    L7:
        if (r104 == null) goto L13;
        if (Intrinsics.areEqual(r104, r101) == true) goto L13;
        r104 = r104.f553572h;
        if ((r104 instanceof q) == false) goto L7;
        r103 = r103 + 1;
    L13:
        return r103;
    L5:
        r103 = 1;
        goto L6
    }

    public static String c(int r100, int r101) {
        int r102 = r101 % 3;
        if (r102 != 0) goto L5;
        StringBuilder r103 = new StringBuilder();
        r103.append(r100);
        r103.append('.');
        return r103.toString();
    L5:
        if (r102 != 1) goto L7;
        StringBuilder r104 = new StringBuilder();
        StringBuilder r105 = new StringBuilder();
        int r106 = Math.max(1, r100);
    L15:
        if (r106 <= 0) goto L17;
        int r107 = r106 - 1;
        r105.insert(0, String.valueOf((char) (((r107 % 26) + 1) + 96)));
        r106 = r107 / 26;
        goto L15
    L17:
        r104.append(r105.toString());
        r104.append('.');
        return r104.toString();
    L7:
        if (r102 == 2) goto L9;
        StringBuilder r108 = new StringBuilder();
        r108.append(r100);
        r108.append('.');
        return r108.toString();
    L9:
        StringBuilder r109 = new StringBuilder();
        if (r100 != 0) goto L12;
        String r110 = "";
    L13:
        r109.append(r110);
        r109.append('.');
        return r109.toString();
    L12:
        r110 = (f419966a[r100 / 1000] + f419967b[(r100 % 1000) / 100] + f419968c[(r100 % 100) / 10] + f419969d[r100 % 10]).toLowerCase(Locale.getDefault());
        goto L13
    }
}
