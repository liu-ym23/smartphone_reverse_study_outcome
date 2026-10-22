package rp7;

import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f538853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte f538854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f538855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f538856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f538857e;

    public a() {
    }

    public static byte a(InputStream r100) throws IOException {
        int r101 = r100.read();
        if (r101 == (-1)) goto L7;
        return (byte) r101;
    L7:
        throw new EOFException();
    }

    public final void b(BufferedOutputStream r110) throws IOException {
        if (this.f538853a == false) goto L5;
        byte r100 = (byte) 128;
    L6:
        r110.write((byte) (r100 | (this.f538854b & 15)));
        long r101 = this.f538856d;
        if (r101 > 125) goto L10;
        byte[] r102 = {(byte) r101};
    L15:
        if (this.f538855c == false) goto L17;
        r102[0] = (byte) (128 | r102[0]);
    L17:
        r110.write(r102, 0, r102.length);
        if (this.f538855c == true) goto L22;
        r110.write(this.f538857e, 0, (int) this.f538856d);
        return;
    L22:
        throw new UnsupportedOperationException("Writing masked data not implemented");
    L10:
        if (r101 > 65535) goto L12;
        byte[] r103 = {126, (byte) ((r101 >> 8) & 255), (byte) (r101 & 255)};
    L13:
        r102 = r103;
        goto L15
    L12:
        r103 = new byte[]{ByteCompanionObject.MAX_VALUE, (byte) ((r101 >> 56) & 255), (byte) ((r101 >> 48) & 255), (byte) ((r101 >> 40) & 255), (byte) ((r101 >> 32) & 255), (byte) ((r101 >> 24) & 255), (byte) ((r101 >> 16) & 255), (byte) ((r101 >> 8) & 255), (byte) (r101 & 255)};
        goto L13
    L5:
        r100 = 0;
        goto L6
    }
}
