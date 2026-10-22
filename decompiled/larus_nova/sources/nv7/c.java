package nv7;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.zxing.common.CharacterSetECI;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<CharsetEncoder> f520916c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharsetEncoder[] f520917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f520918b;

    static {
        f520916c = new ArrayList();
        String[] r100 = {"IBM437", "ISO-8859-2", "ISO-8859-3", "ISO-8859-4", "ISO-8859-5", "ISO-8859-6", "ISO-8859-7", "ISO-8859-8", "ISO-8859-9", "ISO-8859-10", "ISO-8859-11", "ISO-8859-13", "ISO-8859-14", "ISO-8859-15", "ISO-8859-16", "windows-1250", "windows-1251", "windows-1252", "windows-1256", "Shift_JIS"};
        int r101 = 0;
    L4:
        if (r101 >= 20) goto L9;
        String r102 = r100[r101];
        if (CharacterSetECI.getCharacterSetECIByName(r102) == null) goto L8;
        f520916c.add(Charset.forName(r102).newEncoder());     // Catch: UnsupportedCharsetException -> L10
    L8:
        r101 = r101 + 1;
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(String r110, Charset r111) {
        ArrayList r100 = new ArrayList();
        r100.add(StandardCharsets.ISO_8859_1.newEncoder());
        int r101 = 0;
        if (r111 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        int r103 = 0;
    L9:
        int r104 = -1;
        if (r103 >= r110.length()) goto L31;
        Iterator r105 = r100.iterator();
    L13:
        if (r105.hasNext() == false) goto L19;
        CharsetEncoder r106 = (CharsetEncoder) r105.next();
        char r107 = r110.charAt(r103);
        if (r107 == (-1)) goto L18;
        if (r106.canEncode(r107) == false) goto L13;
    L18:
        boolean r108 = true;
    L20:
        if (r108 == true) goto L27;
        Iterator r109 = ((ArrayList) f520916c).iterator();
    L23:
        if (r109.hasNext() == false) goto L27;
        CharsetEncoder r112 = (CharsetEncoder) r109.next();
        if (r112.canEncode(r110.charAt(r103)) == false) goto L23;
        r100.add(r112);
        r108 = true;
    L27:
        if (r108 == true) goto L29;
        r102 = true;
    L29:
        r103 = r103 + 1;
        goto L9
    L19:
        r108 = false;
        goto L20
    L31:
        if (r100.size() != 1) goto L34;
        if (r102 == true) goto L34;
        this.f520917a = new CharsetEncoder[]{(CharsetEncoder) ListProtector.get(r100, 0)};
    L39:
        if (r111 == null) goto L48;
    L40:
        CharsetEncoder[] r113 = this.f520917a;
        if (r101 >= r113.length) goto L48;
        if (r113[r101] == null) goto L47;
        if (r111.name().equals(this.f520917a[r101].charset().name()) == false) goto L47;
        r104 = r101;
    L47:
        r101 = r101 + 1;
    L48:
        this.f520918b = r104;
        return;
    L34:
        this.f520917a = new CharsetEncoder[r100.size() + 2];
        Iterator r114 = r100.iterator();
        int r115 = 0;
    L36:
        if (r114.hasNext() == false) goto L38;
        this.f520917a[r115] = (CharsetEncoder) r114.next();
        r115 = r115 + 1;
        goto L36
    L38:
        this.f520917a[r115] = StandardCharsets.UTF_8.newEncoder();
        this.f520917a[r115 + 1] = StandardCharsets.UTF_16BE.newEncoder();
        goto L39
    L5:
        if (r111.name().startsWith("UTF") == false) goto L7;
        r102 = true;
        goto L8
    }
}
