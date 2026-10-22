package rp7;

import com.ss.ttvideoengine.model.VideoRef;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BufferedInputStream f538858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ByteArrayOutputStream f538859b;

    public c(pp7.a r100) {
        this.f538859b = new ByteArrayOutputStream();
        this.f538858a = new BufferedInputStream(r100, 1024);
    }

    public final void a(h.a r110) throws IOException {
    L3:
        BufferedInputStream r100 = this.f538858a;
        byte r101 = a.a(r100);
        if ((r101 & ByteCompanionObject.MIN_VALUE) == 0) goto L6;
        boolean r102 = true;
    L7:
        byte r103 = (byte) (r101 & 15);
        byte r104 = a.a(r100);
        if ((r104 & ByteCompanionObject.MIN_VALUE) == 0) goto L10;
        boolean r105 = true;
    L11:
        int r106 = (byte) (r104 & ByteCompanionObject.MAX_VALUE);
        if (r106 > 125) goto L15;
    L17:
        long r111 = r106;
    L24:
        if (r105 == false) goto L32;
        int r107 = 4;
        byte[] r108 = new byte[4];
        int r112 = 0;
    L26:
        if (r107 <= 0) goto L33;
        int r113 = r100.read(r108, r112, r107);
        if (r113 == (-1)) goto L31;
        r107 = r107 - r113;
        r112 = r112 + r113;
        goto L26
    L31:
        throw new EOFException();
    L33:
        int r109 = (int) r111;
        byte[] r114 = new byte[r109];
        int r115 = r109;
        int r116 = 0;
    L34:
        if (r115 <= 0) goto L40;
        int r117 = r100.read(r114, r116, r115);
        if (r117 == (-1)) goto L39;
        r115 = r115 - r117;
        r116 = r116 + r117;
        goto L34
    L39:
        throw new EOFException();
    L40:
        int r118 = r109;
        int r119 = 0;
        int r120 = 0;
    L41:
        int r121 = r118 - 1;
        if (r118 <= 0) goto L44;
        r114[r119] = (byte) (r108[r120 % r108.length] ^ r114[r119]);
        r119 = r119 + 1;
        r118 = r121;
        r120 = r120 + 1;
        goto L41
    L44:
        this.f538859b.write(r114, 0, r109);
        if (r102 == false) goto L70;
        byte[] r122 = this.f538859b.toByteArray();
        int r123 = r122.length;
        r110.getClass();
        if (r103 != 1) goto L49;
        h r124 = r110.f538869a;
        d r125 = r124.f538864c;
        ((op7.a) r125).f524729a.b(r124, new String(r122, 0, r123));
    L68:
        this.f538859b.reset();
        goto L70
    L49:
        if (r103 == 2) goto L66;
        switch(r103) {
            case 8: goto L53;
            case 9: goto L52;
            case 10: goto L68;
            default: goto L51;
        };
    L51:
        r110.f538869a.c(new IOException("Unsupported frame opcode=" + r103));
        goto L68
    L52:
        r110.f538869a.a(b.a((byte) 10, r122, r123));
        goto L68
    L53:
        if (r123 < 2) goto L58;
        byte r126 = r122[0];
        byte r127 = r122[1];
        if (r123 <= 2) goto L58;
        new String(r122, 2, r123 - 2);
    L58:
        if (r110.f538869a.f538866e == true) goto L65;
        h r128 = r110.f538869a;
        r128.getClass();
        int r129 = f.f538860a;
        byte[] r130 = "Received close frame".getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L62
        int r131 = r130.length + 2;
        byte[] r132 = new byte[r131];
        r132[0] = (byte) 3;
        r132[1] = (byte) VideoRef.VALUE_VIDEO_REF_CATEGORY;
        System.arraycopy(r130, 0, r132, 2, r130.length);
        r128.a(b.a((byte) 8, r132, r131));
        r128.f538866e = true;
    L62:
        e = move-exception;
        throw new RuntimeException(e);
    L65:
        r110.f538869a.b();
        goto L68
    L66:
        r110.f538869a.f538864c.getClass();
    L70:
        if (r103 != 8) goto L3;
        return;
    L32:
        r108 = null;
        goto L33
    L15:
        if (r106 != 126) goto L19;
        r106 = ((a.a(r100) & UByte.MAX_VALUE) << 8) | (a.a(r100) & UByte.MAX_VALUE);
        goto L17
    L19:
        if (r106 != 127) goto L73;
        r111 = 0;
        int r133 = 0;
    L21:
        if (r133 >= 8) goto L24;
        r111 = (r111 << 8) | ((long) (a.a(r100) & UByte.MAX_VALUE));
        r133 = r133 + 1;
        goto L21
    L73:
        throw new IOException("Unexpected length byte: " + r106);
    L10:
        r105 = false;
        goto L11
    L6:
        r102 = false;
        goto L7
    }
}
