package com.larus.avlink.env.diary.style;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f292138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f292139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f292140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f292141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f292142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f292143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f292144g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f292145h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r101 = (e0) r100;
        if (Intrinsics.areEqual(this.f292138a, r101.f292138a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f292139b, r101.f292139b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f292140c, r101.f292140c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f292141d, r101.f292141d) == true) goto L21;
        return false;
    L21:
        if (this.f292142e == r101.f292142e) goto L24;
        return false;
    L24:
        if (this.f292143f == r101.f292143f) goto L27;
        return false;
    L27:
        if (this.f292144g == r101.f292144g) goto L30;
        return false;
    L30:
        if (this.f292145h == r101.f292145h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f292138a.hashCode() * 31) + this.f292139b.hashCode()) * 31) + this.f292140c.hashCode()) * 31;
        String r101 = this.f292141d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        int r104 = 1231;
        if (this.f292142e == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f292143f == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.f292144g == true) goto L18;
        r104 = 1237;
    L18:
        long r109 = this.f292145h;
        return ((r108 + r104) * 31) + ((int) (r109 ^ (r109 >>> 32)));
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DiaryStyleItem(id=" + this.f292138a + ", name=" + this.f292139b + ", prompt=" + this.f292140c + ", iconUrl=" + this.f292141d + ", isSelected=" + this.f292142e + ", isCustom=" + this.f292143f + ", isAddButton=" + this.f292144g + ", createTime=" + this.f292145h + ')';
    }

    public static e0 a(e0 r110, String r111, String r112, boolean r113, boolean r114, int r115) {
        String r100 = null;
        if ((r115 & 1) == 0) goto L5;
        String r101 = r110.f292138a;
    L7:
        if ((r115 & 2) == 0) goto L9;
        String r102 = r110.f292139b;
    L11:
        if ((r115 & 4) == 0) goto L13;
        String r103 = r110.f292140c;
    L15:
        if ((r115 & 8) == 0) goto L17;
        r100 = r110.f292141d;
    L17:
        String r104 = r100;
        if ((r115 & 16) == 0) goto L20;
        boolean r105 = r110.f292142e;
    L22:
        if ((r115 & 32) == 0) goto L24;
        boolean r116 = r110.f292143f;
    L26:
        if ((r115 & 64) == 0) goto L28;
        boolean r117 = r110.f292144g;
    L30:
        if ((r115 & 128) == 0) goto L32;
        long r106 = r110.f292145h;
    L33:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "name");
        Intrinsics.checkNotNullParameter(r103, EventConstant.Key.RETAIN_PROMPT);
        return new e0(r101, r102, r103, r104, r105, r116, r117, r106);
    L32:
        r106 = 0;
        goto L33
    L28:
        r117 = false;
        goto L30
    L24:
        r116 = r114;
        goto L26
    L20:
        r105 = r113;
        goto L22
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public /* synthetic */ e0(String r110, String r111, String r112, String r113, boolean r114, boolean r115, boolean r116, int r210) {
        if ((r210 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r210 & 16) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r210 & 32) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r210 & 64) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r210 & 128) == 0) goto L21;
        long r104 = System.currentTimeMillis();
    L22:
        this(r110, r111, r112, r100, r101, r102, r103, r104);
        return;
    L21:
        r104 = 0;
        goto L22
    L17:
        r103 = r116;
        goto L19
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }

    public e0(String r100, String r101, String r102, String r103, boolean r104, boolean r105, boolean r106, long r107) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, EventConstant.Key.RETAIN_PROMPT);
        this.f292138a = r100;
        this.f292139b = r101;
        this.f292140c = r102;
        this.f292141d = r103;
        this.f292142e = r104;
        this.f292143f = r105;
        this.f292144g = r106;
        this.f292145h = r107;
    }
}
