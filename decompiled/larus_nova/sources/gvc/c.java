package gvc;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ByteString f482871a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f482872b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f482873c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f482874d = null;

    static {
        f482871a = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        f482872b = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        f482873c = new String[64];
        f482874d = new String[256];
        int r100 = 0;
        int r101 = 0;
    L3:
        String[] r102 = f482874d;
        if (r101 >= r102.length) goto L6;
        r102[r101] = cvc.c.l("%8s", new Object[]{Integer.toBinaryString(r101)}).replace(' ', '0');
        r101 = r101 + 1;
        goto L3
    L6:
        String[] r103 = f482873c;
        r103[0] = "";
        r103[1] = "END_STREAM";
        int[] r104 = {1};
        r103[8] = "PADDED";
        r103[1 | 8] = r103[1] + "|PADDED";
        r103[4] = "END_HEADERS";
        r103[32] = "PRIORITY";
        r103[36] = "END_HEADERS|PRIORITY";
        int[] r105 = {4, 32, 36};
        int r106 = 0;
    L7:
        if (r106 >= 3) goto L9;
        int r107 = r105[r106];
        int r108 = r104[0];
        String[] r109 = f482873c;
        int r110 = r108 | r107;
        r109[r110] = r109[r108] + '|' + r109[r107];
        r109[r110 | 8] = r109[r108] + '|' + r109[r107] + "|PADDED";
        r106 = r106 + 1;
    L9:
        String[] r111 = f482873c;
        if (r100 >= r111.length) goto L15;
        if (r111[r100] != null) goto L14;
        r111[r100] = f482874d[r100];
    L14:
        r100 = r100 + 1;
        goto L9
    }

    public c() {
    }

    public static void b(String r100, Object... r101) throws IOException {
        throw new IOException(cvc.c.l(r100, r101));
    }

    public static String a(boolean r100, int r110, int r111, byte r112, byte r113) {
        String[] r101 = f482872b;
        if (r112 >= r101.length) goto L5;
        String r102 = r101[r112];
    L7:
        if (r113 != 0) goto L9;
        String r114 = "";
    L35:
        Object[] r115 = new Object[5];
        if (r100 == false) goto L38;
        String r103 = AbsMethodDelegate.TAG_BEFORE;
    L39:
        r115[0] = r103;
        r115[1] = Integer.valueOf(r110);
        r115[2] = Integer.valueOf(r111);
        r115[3] = r102;
        r115[4] = r114;
        return cvc.c.l("%s 0x%08x %5d %-13s %s", r115);
    L38:
        r103 = AbsMethodDelegate.TAG_AFTER;
        goto L39
    L9:
        if (r112 == 2) goto L34;
        if (r112 == 3) goto L34;
        if (r112 != 4) goto L13;
    L31:
        if (r113 != 1) goto L33;
        r114 = "ACK";
        goto L35
    L33:
        r114 = f482874d[r113];
        goto L35
    L13:
        if (r112 == 6) goto L31;
        if (r112 == 7) goto L34;
        if (r112 == 8) goto L34;
        String[] r104 = f482873c;
        if (r113 >= r104.length) goto L21;
        String r105 = r104[r113];
    L22:
        if (r112 == 5) goto L24;
    L26:
        if (r112 == 0) goto L28;
    L30:
        r114 = r105;
        goto L35
    L28:
        if ((r113 & 32) == 0) goto L30;
        r114 = r105.replace("PRIORITY", "COMPRESSED");
        goto L35
    L24:
        if ((r113 & 4) == 0) goto L26;
        r114 = r105.replace("HEADERS", "PUSH_PROMISE");
        goto L35
    L21:
        r105 = f482874d[r113];
    L34:
        r114 = f482874d[r113];
        goto L35
    L5:
        r102 = cvc.c.l("0x%02x", new Object[]{Byte.valueOf(r112)});
        goto L7
    }
}
