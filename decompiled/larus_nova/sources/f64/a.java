package f64;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import kotlin.text.Typography;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements XmlSerializer {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f475695h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char[] f475696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f475697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Writer f475698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OutputStream f475699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharsetEncoder f475700e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ByteBuffer f475701f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f475702g;

    static {
        f475695h = new String[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&quot;", null, null, null, "&amp;", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&lt;", null, "&gt;", null};
    }

    public final void d() throws IOException {
        int r100 = this.f475701f.position();
        if (r100 <= 0) goto L6;
        this.f475701f.flip();
        this.f475699d.write(this.f475701f.array(), 0, r100);
        this.f475701f.clear();
        return;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void flush() throws IOException {
        int r100 = this.f475697b;
        if (r100 > 0) goto L5;
        return;
    L5:
        if (this.f475699d == null) goto L15;
        CharBuffer r101 = CharBuffer.wrap(this.f475696a, 0, r100);
        CoderResult r102 = this.f475700e.encode(r101, this.f475701f, true);
    L8:
        if (r102.isError() == true) goto L14;
        if (r102.isOverflow() == false) goto L12;
        d();
        r102 = this.f475700e.encode(r101, this.f475701f, true);
        goto L8
    L12:
        d();
        this.f475699d.flush();
    L16:
        this.f475697b = 0;
        return;
    L14:
        throw new IOException(r102.toString());
    L15:
        this.f475698c.write(this.f475696a, 0, r100);
        this.f475698c.flush();
        goto L16
    }

    public a() {
        this.f475696a = new char[8192];
        this.f475701f = ByteBuffer.allocate(8192);
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
        flush();
    }

    public final void a(char r100) throws IOException {
        int r101 = this.f475697b;
        if (r101 < 8191) goto L5;
        flush();
        r101 = this.f475697b;
    L5:
        this.f475696a[r101] = r100;
        this.f475697b = r101 + 1;
    }

    public final void c(String r100) throws IOException {
        int r101 = r100.length();
        String[] r102 = f475695h;
        char r103 = (char) r102.length;
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r101) goto L14;
        char r106 = r100.charAt(r104);
        if (r106 >= r103) goto L13;
        String r107 = r102[r106];
        if (r107 == null) goto L13;
        if (r105 >= r104) goto L12;
        b(r100, r105, r104 - r105);
    L12:
        r105 = r104 + 1;
        b(r107, 0, r107.length());
    L13:
        r104 = r104 + 1;
        goto L3
    L14:
        if (r105 >= r104) goto L21;
        b(r100, r105, r104 - r105);
        return;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void setOutput(Writer r100) throws IOException, IllegalArgumentException, IllegalStateException {
        this.f475698c = r100;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final XmlSerializer text(String r100) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f475702g == false) goto L5;
        b(">", 0, 1);
        this.f475702g = false;
    L5:
        c(r100);
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final XmlSerializer endTag(String r100, String r101) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f475702g == false) goto L5;
        b(" />\n", 0, 4);
    L9:
        this.f475702g = false;
        return this;
    L5:
        b("</", 0, 2);
        if (r100 == null) goto L8;
        b(r100, 0, r100.length());
        a(':');
    L8:
        b(r101, 0, r101.length());
        b(">\n", 0, 2);
        goto L9
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void setFeature(String r100, boolean r101) throws IllegalArgumentException, IllegalStateException {
        if (r100.equals("http://xmlpull.org/v1/doc/features.html#indent-output") == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void setOutput(OutputStream r100, String r101) throws IOException, IllegalArgumentException, IllegalStateException {
        if (r100 == null) goto L13;
        this.f475700e = Charset.forName(r101).newEncoder();     // Catch: UnsupportedCharsetException -> L6 IllegalCharsetNameException -> L9
        this.f475699d = r100;
        return;
    L9:
        e = move-exception;
        throw ((UnsupportedEncodingException) new UnsupportedEncodingException(r101).initCause(e));
    L6:
        e = move-exception;
        throw ((UnsupportedEncodingException) new UnsupportedEncodingException(r101).initCause(e));
    L13:
        throw new IllegalArgumentException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void setPrefix(String r100, String r101) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void startDocument(String r100, Boolean r101) throws IOException, IllegalArgumentException, IllegalStateException {
        StringBuilder r102 = new StringBuilder("<?xml version='1.0' encoding='utf-8' standalone='");
        if (r101.booleanValue() == false) goto L5;
        String r103 = BdpAppEventConstant.YES;
    L6:
        r102.append(r103);
        r102.append("' ?>\n");
        String r104 = r102.toString();
        b(r104, 0, r104.length());
        return;
    L5:
        r103 = BdpAppEventConstant.NO;
        goto L6
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final XmlSerializer startTag(String r100, String r101) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f475702g == false) goto L5;
        b(">\n", 0, 2);
    L5:
        a(Typography.less);
        if (r100 == null) goto L8;
        b(r100, 0, r100.length());
        a(':');
    L8:
        b(r101, 0, r101.length());
        this.f475702g = true;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final XmlSerializer attribute(String r100, String r101, String r102) throws IOException, IllegalArgumentException, IllegalStateException {
        a(' ');
        if (r100 == null) goto L5;
        b(r100, 0, r100.length());
        a(':');
    L5:
        b(r101, 0, r101.length());
        b("=\"", 0, 2);
        c(r102);
        a(Typography.quote);
        return this;
    }

    public final void b(String r100, int r101, int r102) throws IOException {
        if (r102 <= 8192) goto L12;
        int r103 = r102 + r101;
    L5:
        if (r101 >= r103) goto L11;
        int r104 = r101 + 8192;
        if (r104 >= r103) goto L9;
        int r105 = 8192;
    L10:
        b(r100, r101, r105);
        r101 = r104;
        goto L5
    L9:
        r105 = r103 - r101;
        goto L10
    L11:
        return;
    L12:
        int r106 = this.f475697b;
        if ((r106 + r102) <= 8192) goto L15;
        flush();
        r106 = this.f475697b;
    L15:
        r100.getChars(r101, r101 + r102, this.f475696a, r106);
        this.f475697b = r106 + r102;
    }
}
