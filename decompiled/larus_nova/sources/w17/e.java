package w17;

import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f557929a;

    public final int hashCode() {
        return Arrays.hashCode(this.f557929a);
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("0x");
        byte[] r101 = this.f557929a;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        r100.append(Integer.toHexString(r101[r103] & UByte.MAX_VALUE));
        r103 = r103 + 1;
        goto L3
    L6:
        return r100.toString();
    }

    public e(byte[] r100) {
        int r101 = r100.length;
        byte[] r102 = new byte[r101];
        this.f557929a = r102;
        System.arraycopy(r100, 0, r102, 0, r101);
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof e) == true) goto L7;
        return false;
    L7:
        return Arrays.equals(this.f557929a, ((e) r100).f557929a);
    }
}
