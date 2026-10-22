package kotlinx.serialization.json.internal;

import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes42.dex */
public final class n extends l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f505448c;

    @Override // kotlinx.serialization.json.internal.l
    public final void d(byte r100) {
        boolean r101 = this.f505448c;
        String r102 = UByte.m9511toStringimpl(UByte.m9467constructorimpl(r100));
        if (r101 == false) goto L5;
        j(r102);
        return;
    L5:
        h(r102);
    }

    @Override // kotlinx.serialization.json.internal.l
    public final void f(int r100) {
        boolean r101 = this.f505448c;
        String r102 = Long.toString(((long) UInt.m9544constructorimpl(r100)) & BodyPartID.bodyIdMax, 10);
        if (r101 == false) goto L5;
        j(r102);
        return;
    L5:
        h(r102);
    }

    @Override // kotlinx.serialization.json.internal.l
    public final void g(long r110) {
        boolean r100 = this.f505448c;
        long r111 = ULong.m9623constructorimpl(r110);
        int r101 = 63;
        String r102 = "0";
        if (r100 == false) goto L16;
        if (r111 == 0) goto L14;
        if (r111 <= 0) goto L9;
        r102 = Long.toString(r111, 10);
        goto L14
    L9:
        char[] r103 = new char[64];
        long r104 = (r111 >>> 1) / ((long) 5);
        long r105 = 10;
        r103[63] = Character.forDigit((int) (r111 - (r104 * r105)), 10);
    L11:
        if (r104 <= 0) goto L13;
        r101 = r101 - 1;
        r103[r101] = Character.forDigit((int) (r104 % r105), 10);
        r104 = r104 / r105;
        goto L11
    L13:
        r102 = new String(r103, r101, 64 - r101);
    L14:
        j(r102);
        return;
    L16:
        if (r111 == 0) goto L25;
        if (r111 <= 0) goto L20;
        r102 = Long.toString(r111, 10);
        goto L25
    L20:
        char[] r106 = new char[64];
        long r107 = (r111 >>> 1) / ((long) 5);
        long r108 = 10;
        r106[63] = Character.forDigit((int) (r111 - (r107 * r108)), 10);
    L22:
        if (r107 <= 0) goto L24;
        r101 = r101 - 1;
        r106[r101] = Character.forDigit((int) (r107 % r108), 10);
        r107 = r107 / r108;
        goto L22
    L24:
        r102 = new String(r106, r101, 64 - r101);
    L25:
        h(r102);
    }

    @Override // kotlinx.serialization.json.internal.l
    public final void i(short r100) {
        boolean r101 = this.f505448c;
        String r102 = UShort.m9774toStringimpl(UShort.m9730constructorimpl(r100));
        if (r101 == false) goto L5;
        j(r102);
        return;
    L5:
        h(r102);
    }

    public n(q r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "writer");
        super(r100);
        this.f505448c = r101;
    }
}
