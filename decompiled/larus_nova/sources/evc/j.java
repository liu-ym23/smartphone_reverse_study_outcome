package evc;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes42.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Protocol f474521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f474522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f474523c;

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.f474521a != Protocol.HTTP_1_0) goto L5;
        String r101 = "HTTP/1.0";
    L6:
        r100.append(r101);
        r100.append(' ');
        r100.append(this.f474522b);
        if (this.f474523c == null) goto L10;
        r100.append(' ');
        r100.append(this.f474523c);
    L10:
        return r100.toString();
    L5:
        r101 = "HTTP/1.1";
        goto L6
    }

    public static j a(String r100) throws IOException {
        if (r100.startsWith("HTTP/1.") == false) goto L19;
        int r101 = 9;
        if (r100.length() < 9) goto L17;
        if (r100.charAt(8) != ' ') goto L17;
        int r102 = r100.charAt(7) - '0';
        if (r102 != 0) goto L12;
        Protocol r103 = Protocol.HTTP_1_0;
    L21:
        int r104 = r101 + 3;
        if (r100.length() < r104) goto L37;
        int r105 = CastIntegerProtector.parseInt(r100.substring(r101, r104));     // Catch: NumberFormatException -> L34
        if (r100.length() > r104) goto L27;
        String r106 = "";
    L33:
        return new j(r103, r105, r106);
    L27:
        if (r100.charAt(r104) != ' ') goto L30;
        r106 = r100.substring(r101 + 4);
        goto L33
    L30:
        throw new ProtocolException("Unexpected status line: ".concat(r100));
    L35:
        throw new ProtocolException("Unexpected status line: ".concat(r100));
    L37:
        throw new ProtocolException("Unexpected status line: ".concat(r100));
    L12:
        if (r102 != 1) goto L15;
        r103 = Protocol.HTTP_1_1;
        goto L21
    L15:
        throw new ProtocolException("Unexpected status line: ".concat(r100));
    L17:
        throw new ProtocolException("Unexpected status line: ".concat(r100));
    L19:
        if (r100.startsWith("ICY ") == false) goto L39;
        r103 = Protocol.HTTP_1_0;
        r101 = 4;
        goto L21
    L39:
        throw new ProtocolException("Unexpected status line: ".concat(r100));
    }

    public j(Protocol r100, int r101, String r102) {
        this.f474521a = r100;
        this.f474522b = r101;
        this.f474523c = r102;
    }
}
