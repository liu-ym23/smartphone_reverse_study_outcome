package com.obric.assistant.special_input;

import android.graphics.Typeface;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f392701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f392702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f392703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f392704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f392705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Typeface f392706f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f392701a == r101.f392701a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f392702b, r101.f392702b) == true) goto L15;
        return false;
    L15:
        if (this.f392703c == r101.f392703c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f392704d, r101.f392704d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f392705e, r101.f392705e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f392706f, r101.f392706f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f392701a * 31;
        Integer r101 = this.f392702b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f392703c) * 31;
        int[] r105 = this.f392704d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f392705e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Typeface r111 = this.f392706f;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = Arrays.hashCode(r105);
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "HintContentStyle(textSize=" + this.f392701a + ", textColor=" + this.f392702b + ", typeStyle=" + this.f392703c + ", gradientColor=" + Arrays.toString(this.f392704d) + ", content=" + this.f392705e + ", typeface=" + this.f392706f + ')';
    }

    public /* synthetic */ a(int r100, Integer r101, int r110, int[] r111, String r112) {
        this(r100, r101, r110, r111, r112, null);
    }

    public a(int r100, Integer r101, int r102, int[] r103, String r104, Typeface r105) {
        this.f392701a = r100;
        this.f392702b = r101;
        this.f392703c = r102;
        this.f392704d = r103;
        this.f392705e = r104;
        this.f392706f = r105;
    }
}
