package com.huawei.hms.common.size;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.common.internal.Objects;

/* JADX INFO: loaded from: classes23.dex */
public class Size {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f277127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f277128b;

    public int hashCode() {
        return Objects.hashCode(new Object[]{Integer.valueOf(getWidth()), Integer.valueOf(getHeight())});
    }

    public final String toString() {
        return "Width is " + this.f277127a + " Height is " + this.f277128b;
    }

    public final int getHeight() {
        return this.f277128b;
    }

    public final int getWidth() {
        return this.f277127a;
    }

    public static Size parseSize(String r100) {
        int r101 = r100.indexOf("x");     // Catch: Exception -> L7
        if (r101 >= 0) goto L5;
        r101 = r100.indexOf("*");     // Catch: Exception -> L7
    L5:
        return new Size(CastIntegerProtector.parseInt(r100.substring(0, r101)), CastIntegerProtector.parseInt(r100.substring(r101 + 1)));
    L8:
        throw new IllegalArgumentException("Size parses failed");
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this != r100) goto L9;
        return true;
    L9:
        if ((r100 instanceof Size) == false) goto L16;
        Size r101 = (Size) r100;
        if (this.f277127a == r101.f277127a) goto L13;
        return false;
    L13:
        if (this.f277128b != r101.f277128b) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    }

    public Size(int r100, int r101) {
        this.f277127a = r100;
        this.f277128b = r101;
    }
}
