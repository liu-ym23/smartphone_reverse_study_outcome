package qwc;

import com.alipay.sdk.m.u.i;
import com.baidu.mapapi.http.HttpClient;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Hashtable;
import kotlin.text.Typography;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes42.dex */
public final class a implements XmlPullParser {
    public String[] A;
    public int B;
    public String C;
    public final int[] D;
    public int E;
    public boolean F;
    public boolean G;
    public boolean H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f535072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f535073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f535074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f535075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f535076e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Hashtable f535077f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f535078g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String[] f535079h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String[] f535080i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f535081j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Reader f535082k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f535083l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final char[] f535084m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f535085n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f535086o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f535087p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f535088q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public char[] f535089r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f535090s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f535091t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f535092u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f535093v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f535094w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f535095x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f535096y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f535097z;

    public a() {
        this.f535079h = new String[16];
        this.f535080i = new String[8];
        this.f535081j = new int[4];
        int r100 = 128;
        this.f535089r = new char[128];
        this.A = new String[16];
        this.B = 0;
        this.D = new int[2];
        if (Runtime.getRuntime().freeMemory() < 1048576) goto L5;
        r100 = 8192;
    L5:
        this.f535084m = new char[r100];
    }

    public static boolean c(String r100, boolean r101, String r102) {
        if (r100.startsWith("http://xmlpull.org/v1/doc/") == true) goto L6;
        return false;
    L6:
        if (r101 == false) goto L8;
        int r103 = 42;
    L10:
        return r100.substring(r103).equals(r102);
    L8:
        r103 = 40;
        goto L10
    }

    public final void a(String r100) throws XmlPullParserException {
        if (this.f535076e == true) goto L5;
        b(r100);
        throw null;
    L5:
        if (this.C != null) goto L10;
        StringBuffer r101 = new StringBuffer("ERR: ");
        r101.append(r100);
        this.C = r101.toString();
        return;
    }

    public final void b(String r100) throws XmlPullParserException {
        if (r100.length() < 100) goto L7;
        StringBuffer r101 = new StringBuffer();
        r101.append(r100.substring(0, 100));
        r101.append("\n");
        r100 = r101.toString();
    L7:
        throw new XmlPullParserException(r100, this, null);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final void defineEntityReplacementText(String r100, String r101) throws XmlPullParserException {
        Hashtable r102 = this.f535077f;
        if (r102 == null) goto L7;
        r102.put(r100, r101);
        return;
    L7:
        throw new RuntimeException("entity replacement text must be defined after setInput!");
    }

    public final int f(int r100) throws IOException {
    L3:
        if (r100 < this.E) goto L25;
        char[] r101 = this.f535084m;
        if (r101.length > 1) goto L7;
        int r102 = this.f535082k.read();
    L16:
        if (r102 == 13) goto L17;
        if (r102 == 10) goto L20;
        int[] r103 = this.D;
        int r104 = this.E;
        this.E = r104 + 1;
        r103[r104] = r102;
    L23:
        this.F = false;
        goto L3
    L20:
        if (this.F == true) goto L23;
        int[] r105 = this.D;
        int r106 = this.E;
        this.E = r106 + 1;
        r105[r106] = 10;
        goto L23
    L17:
        this.F = true;
        int[] r107 = this.D;
        int r108 = this.E;
        this.E = r108 + 1;
        r107[r108] = 10;
        goto L3
    L7:
        int r109 = this.f535085n;
        if (r109 >= this.f535086o) goto L10;
        this.f535085n = r109 + 1;
        r102 = r101[r109];
        goto L16
    L10:
        int r110 = this.f535082k.read(r101, 0, r101.length);
        this.f535086o = r110;
        if (r110 > 0) goto L13;
        int r111 = -1;
    L14:
        this.f535085n = 1;
        r102 = r111;
        goto L16
    L13:
        r111 = this.f535084m[0];
        goto L14
    L25:
        return this.D[r100];
    }

    public final int g() throws IOException {
        int r100 = f(0);
        if (r100 != (-1)) goto L5;
        return 1;
    L5:
        if (r100 != 38) goto L7;
        return 6;
    L7:
        if (r100 == 60) goto L10;
        return 4;
    L10:
        int r101 = f(1);
        if (r101 != 33) goto L13;
        return 999;
    L13:
        if (r101 != 47) goto L15;
        return 3;
    L15:
        if (r101 == 63) goto L25;
        return 2;
    L25:
        return 999;
    }

    @Override // org.xmlpull.v1.XmlPullParser, com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public final int getAttributeCount() {
        return this.f535097z;
    }

    @Override // org.xmlpull.v1.XmlPullParser, com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public final String getAttributeName(int r100) {
        if (r100 >= this.f535097z) goto L7;
        return this.A[(r100 << 2) + 2];
    L7:
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getAttributeNamespace(int r100) {
        if (r100 >= this.f535097z) goto L7;
        return this.A[r100 << 2];
    L7:
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getAttributePrefix(int r100) {
        if (r100 >= this.f535097z) goto L7;
        return this.A[(r100 << 2) + 1];
    L7:
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getAttributeType(int r100) {
        return "CDATA";
    }

    @Override // org.xmlpull.v1.XmlPullParser, com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public final String getAttributeValue(int r100) {
        if (r100 >= this.f535097z) goto L7;
        return this.A[(r100 << 2) + 3];
    L7:
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser, com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public final String getAttributeValue(String r100, String r101) {
        int r102 = (this.f535097z << 2) - 4;
    L3:
        if (r102 < 0) goto L12;
        if (this.A[r102 + 2].equals(r101) == false) goto L11;
        if (r100 == null) goto L10;
        if (this.A[r102].equals(r100) == false) goto L11;
    L10:
        return this.A[r102 + 3];
    L11:
        r102 = r102 - 4;
        goto L3
    L12:
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int getColumnNumber() {
        return this.f535088q;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int getDepth() {
        return this.f535078g;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int getEventType() throws XmlPullParserException {
        return this.f535091t;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final boolean getFeature(String r100) {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(r100) == false) goto L7;
        return this.f535075d;
    L7:
        if (c(r100, false, "relaxed") == true) goto L9;
        return false;
    L9:
        return this.f535076e;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getInputEncoding() {
        return this.f535083l;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int getLineNumber() {
        return this.f535087p;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getName() {
        return this.f535095x;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getNamespace() {
        return this.f535093v;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getNamespace(String r100) {
        if ("xml".equals(r100) == false) goto L7;
        return "http://www.w3.org/XML/1998/namespace";
    L7:
        if ("xmlns".equals(r100) == false) goto L10;
        return "http://www.w3.org/2000/xmlns/";
    L10:
        int r101 = (getNamespaceCount(this.f535078g) << 1) - 2;
    L11:
        if (r101 < 0) goto L23;
        String[] r102 = this.f535080i;
        if (r100 != null) goto L19;
        if (r102[r101] != null) goto L22;
        return r102[r101 + 1];
    L22:
        r101 = r101 - 2;
        goto L11
    L19:
        if (r100.equals(r102[r101]) == false) goto L22;
        return this.f535080i[r101 + 1];
    L23:
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int getNamespaceCount(int r100) {
        if (r100 > this.f535078g) goto L7;
        return this.f535081j[r100];
    L7:
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getNamespacePrefix(int r100) {
        return this.f535080i[r100 << 1];
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getNamespaceUri(int r100) {
        return this.f535080i[(r100 << 1) + 1];
    }

    @Override // org.xmlpull.v1.XmlPullParser, com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public final String getPositionDescription() {
        int r100 = this.f535091t;
        String[] r101 = XmlPullParser.TYPES;
        if (r100 >= r101.length) goto L5;
        String r102 = r101[r100];
    L6:
        StringBuffer r103 = new StringBuffer(r102);
        r103.append(' ');
        int r104 = this.f535091t;
        int r105 = 0;
        if (r104 == 2) goto L24;
        if (r104 == 3) goto L24;
        if (r104 != 7) goto L14;
    L39:
        StringBuffer r106 = new StringBuffer("@");
        r106.append(this.f535087p);
        r106.append(":");
        r106.append(this.f535088q);
        r103.append(r106.toString());
        if (this.f535072a == null) goto L43;
        r103.append(" in ");
        r103.append(this.f535072a);
    L46:
        return r103.toString();
    L43:
        if (this.f535082k == null) goto L46;
        r103.append(" in ");
        r103.append(this.f535082k.toString());
        goto L46
    L14:
        if (r104 == 4) goto L18;
        String r107 = getText();
    L16:
        r103.append(r107);
        goto L39
    L18:
        if (this.f535092u == false) goto L20;
        r107 = "(whitespace)";
        goto L16
    L20:
        r107 = getText();
        if (r107.length() <= 16) goto L16;
        StringBuffer r108 = new StringBuffer();
        r108.append(r107.substring(0, 16));
        r108.append("...");
        r107 = r108.toString();
    L24:
        if (this.f535096y == false) goto L26;
        r103.append("(empty) ");
    L26:
        r103.append(Typography.less);
        if (this.f535091t != 3) goto L30;
        r103.append('/');
    L30:
        if (this.f535094w == null) goto L32;
        StringBuffer r109 = new StringBuffer("{");
        r109.append(this.f535093v);
        r109.append(i.f25855d);
        r109.append(this.f535094w);
        r109.append(":");
        r103.append(r109.toString());
    L32:
        r103.append(this.f535095x);
        int r110 = this.f535097z << 2;
    L33:
        if (r105 >= r110) goto L38;
        r103.append(' ');
        int r111 = r105 + 1;
        if (this.A[r111] == null) goto L37;
        StringBuffer r112 = new StringBuffer("{");
        r112.append(this.A[r105]);
        r112.append(i.f25855d);
        r112.append(this.A[r111]);
        r112.append(":");
        r103.append(r112.toString());
    L37:
        StringBuffer r113 = new StringBuffer();
        r113.append(this.A[r105 + 2]);
        r113.append("='");
        r113.append(this.A[r105 + 3]);
        r113.append("'");
        r103.append(r113.toString());
        r105 = r105 + 4;
        goto L33
    L38:
        r103.append(Typography.greater);
        goto L39
    L5:
        r102 = "unknown";
        goto L6
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getPrefix() {
        return this.f535094w;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final Object getProperty(String r100) {
        if (c(r100, true, "xmldecl-version") == false) goto L7;
        return this.f535073b;
    L7:
        if (c(r100, true, "xmldecl-standalone") == false) goto L11;
        return this.f535074c;
    L11:
        if (c(r100, true, "location") == false) goto L17;
        Object r101 = this.f535072a;
        if (r101 == null) goto L16;
        return r101;
    L16:
        return this.f535082k.toString();
    L17:
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final char[] getTextCharacters(int[] r100) {
        int r101 = this.f535091t;
        if (r101 >= 4) goto L5;
        r100[0] = -1;
        r100[1] = -1;
        return null;
    L5:
        if (r101 != 6) goto L8;
        r100[0] = 0;
        r100[1] = this.f535095x.length();
        return this.f535095x.toCharArray();
    L8:
        r100[0] = 0;
        r100[1] = this.f535090s;
        return this.f535089r;
    }

    public final void h(int r100) {
        boolean r101 = this.f535092u;
        if (r100 > 32) goto L5;
        boolean r102 = true;
    L6:
        this.f535092u = r101 & r102;
        int r103 = this.f535090s;
        char[] r104 = this.f535089r;
        if (r103 != r104.length) goto L9;
        char[] r105 = new char[((r103 * 4) / 3) + 4];
        System.arraycopy(r104, 0, r105, 0, r103);
        this.f535089r = r105;
    L9:
        char[] r106 = this.f535089r;
        int r107 = this.f535090s;
        this.f535090s = r107 + 1;
        r106[r107] = (char) r100;
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final boolean isAttributeDefault(int r100) {
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final boolean isEmptyElementTag() throws XmlPullParserException {
        if (this.f535091t == 2) goto L5;
        b("Wrong event type");
        throw null;
    L5:
        return this.f535096y;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final boolean isWhitespace() throws XmlPullParserException {
        int r100 = this.f535091t;
        if (r100 == 4) goto L12;
        if (r100 == 7) goto L12;
        if (r100 == 5) goto L12;
        b("Wrong event type");
        throw null;
    L12:
        return this.f535092u;
    }

    public final void j(int r100, boolean r101) throws IOException, XmlPullParserException {
        int r102 = f(0);
        int r103 = 0;
    L4:
        if (r102 == (-1)) goto L32;
        if (r102 == r100) goto L40;
        int r104 = 32;
        if (r100 != 32) goto L12;
        if (r102 <= 32) goto L41;
        if (r102 != 62) goto L12;
        return;
    L41:
        return;
    L12:
        if (r102 != 38) goto L17;
        if (r101 == false) goto L43;
        i();
    L24:
        if (r102 != 62) goto L28;
        if (r103 < 2) goto L28;
        if (r100 == 93) goto L28;
        a("Illegal: ]]>");
    L28:
        if (r102 != 93) goto L30;
        r103 = r103 + 1;
    L31:
        r102 = f(0);
        goto L4
    L30:
        r103 = 0;
        goto L31
    L43:
        return;
    L17:
        if (r102 == 10) goto L19;
    L21:
        r104 = k();
    L22:
        h(r104);
        goto L24
    L19:
        if (this.f535091t != 2) goto L21;
        k();
        goto L22
    L40:
        return;
    }

    public final int k() throws IOException {
        if (this.E != 0) goto L5;
        int r100 = f(0);
    L6:
        this.E--;
        this.f535088q++;
        if (r100 != 10) goto L9;
        this.f535087p++;
        this.f535088q = 1;
    L9:
        return r100;
    L5:
        int[] r101 = this.D;
        int r102 = r101[0];
        r101[0] = r101[1];
        r100 = r102;
        goto L6
    }

    public final void l(char r100) throws IOException, XmlPullParserException {
        int r101 = k();
        if (r101 == r100) goto L6;
        StringBuffer r102 = new StringBuffer("expected: '");
        r102.append(r100);
        r102.append("' actual: '");
        r102.append((char) r101);
        r102.append("'");
        a(r102.toString());
        return;
    }

    public final void n() throws IOException {
    L2:
        int r100 = f(0);
        if (r100 > 32) goto L8;
        if (r100 == (-1)) goto L11;
        k();
        goto L2
    L11:
        return;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int next() throws XmlPullParserException, IOException {
        this.f535090s = 0;
        this.f535092u = true;
        this.H = false;
        int r100 = 9999;
    L3:
        d();
        int r101 = this.f535091t;
        if (r101 >= r100) goto L7;
        r100 = r101;
    L7:
        if (r100 > 6) goto L3;
        if (r100 < 4) goto L12;
        if (g() >= 4) goto L3;
    L12:
        this.f535091t = r100;
        if (r100 <= 4) goto L16;
        this.f535091t = 4;
    L16:
        return this.f535091t;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int nextTag() throws XmlPullParserException, IOException {
        next();
        if (this.f535091t == 4) goto L5;
    L7:
        int r100 = this.f535091t;
        if (r100 != 3) goto L10;
    L14:
        return r100;
    L10:
        if (r100 == 2) goto L14;
        b("unexpected type");
        throw null;
    L5:
        if (this.f535092u == false) goto L7;
        next();
        goto L7
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String nextText() throws XmlPullParserException, IOException {
        if (this.f535091t != 2) goto L13;
        next();
        if (this.f535091t != 4) goto L7;
        String r100 = getText();
        next();
    L9:
        if (this.f535091t != 3) goto L11;
        return r100;
    L11:
        b("END_TAG expected");
        throw null;
    L7:
        r100 = "";
        goto L9
    L13:
        b("precondition: START_TAG");
        throw null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int nextToken() throws XmlPullParserException, IOException {
        this.f535092u = true;
        this.f535090s = 0;
        this.H = true;
        d();
        return this.f535091t;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final void setFeature(String r100, boolean r101) throws XmlPullParserException {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(r100) == false) goto L6;
        this.f535075d = r101;
        return;
    L6:
        if (c(r100, false, "relaxed") == false) goto L9;
        this.f535076e = r101;
        return;
    L9:
        b("unsupported feature: ".concat(r100));
        throw null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final void setInput(InputStream r110, String r111) throws XmlPullParserException {
        this.f535085n = 0;
        this.f535086o = 0;
        if (r110 == null) goto L61;
        String r100 = "UTF-8";
        if (r111 != null) goto L51;
        int r101 = 0;
    L62:
    L57:
        e = move-exception;
        StringBuffer r102 = new StringBuffer("Invalid stream or encoding: ");
        r102.append(e.toString());
        throw new XmlPullParserException(r102.toString(), this, e);
    L8:
        if (this.f535086o >= 4) goto L14;
        int r103 = r110.read();     // Catch: Exception -> L57
        if (r103 == (-1)) goto L14;
        r101 = (r101 << 8) | r103;     // Catch: Exception -> L57
        char[] r104 = this.f535084m;     // Catch: Exception -> L57
        int r105 = this.f535086o;     // Catch: Exception -> L57
        this.f535086o = r105 + 1;     // Catch: Exception -> L57
        r104[r105] = (char) r103;     // Catch: Exception -> L57
    L14:
        if (this.f535086o != 4) goto L51;
        String r106 = "UTF-16LE";
        switch(r101) {
            case -131072: goto L38;
            case 60: goto L37;
            case 65279: goto L35;
            case 3932223: goto L33;
            case 1006632960: goto L32;
            case 1006649088: goto L31;
            case 1010792557: goto L18;
            default: goto L40;
        };
    L18:
        int r107 = r110.read();     // Catch: Exception -> L57
        if (r107 == (-1)) goto L40;
        char[] r108 = this.f535084m;     // Catch: Exception -> L57
        int r109 = this.f535086o;     // Catch: Exception -> L57
        int r112 = r109 + 1;     // Catch: Exception -> L57
        this.f535086o = r112;     // Catch: Exception -> L57
        r108[r109] = (char) r107;     // Catch: Exception -> L57
        if (r107 != 62) goto L18;
        String r113 = new String(r108, 0, r112);     // Catch: Exception -> L57
        int r114 = r113.indexOf("encoding");     // Catch: Exception -> L57
        if (r114 == (-1)) goto L40;
    L26:
        if (r113.charAt(r114) == '\"') goto L30;
        if (r113.charAt(r114) == '\'') goto L30;
        r114 = r114 + 1;     // Catch: Exception -> L57
    L30:
        int r115 = r114 + 1;     // Catch: Exception -> L57
        String r116 = r113.substring(r115, r113.indexOf(r113.charAt(r114), r115));     // Catch: Exception -> L57
    L41:
        int r117 = (-65536) & r101;     // Catch: Exception -> L57
        if (r117 != (-16842752)) goto L45;
        char[] r118 = this.f535084m;     // Catch: Exception -> L57
        r118[0] = (char) ((r118[2] << '\b') | r118[3]);     // Catch: Exception -> L57
        this.f535086o = 1;     // Catch: Exception -> L57
    L34:
        r106 = "UTF-16BE";
    L52:
        if (r106 == null) goto L55;
        r100 = r106;
    L55:
        int r119 = this.f535086o;     // Catch: Exception -> L57
        setInput(new InputStreamReader(r110, r100));     // Catch: Exception -> L57
        this.f535083l = r111;     // Catch: Exception -> L57
        this.f535086o = r119;     // Catch: Exception -> L57
        return;
    L45:
        if (r117 != (-131072)) goto L48;
        char[] r120 = this.f535084m;     // Catch: Exception -> L57
        r120[0] = (char) ((r120[3] << '\b') | r120[2]);     // Catch: Exception -> L57
        this.f535086o = 1;     // Catch: Exception -> L57
        goto L52
    L48:
        if ((r101 & (-256)) != (-272908544)) goto L50;
        char[] r121 = this.f535084m;     // Catch: Exception -> L57
        r121[0] = r121[3];     // Catch: Exception -> L57
        this.f535086o = 1;     // Catch: Exception -> L57
        r106 = "UTF-8";
        goto L52
    L50:
        r106 = r116;
        goto L52
    L31:
        char[] r122 = this.f535084m;     // Catch: Exception -> L57
        r122[0] = Typography.less;     // Catch: Exception -> L57
        r122[1] = '?';     // Catch: Exception -> L57
        this.f535086o = 2;     // Catch: Exception -> L57
        goto L52
    L32:
        this.f535084m[0] = Typography.less;     // Catch: Exception -> L57
        this.f535086o = 1;     // Catch: Exception -> L57
    L39:
        r106 = "UTF-32LE";
        goto L52
    L33:
        char[] r123 = this.f535084m;     // Catch: Exception -> L57
        r123[0] = Typography.less;     // Catch: Exception -> L57
        r123[1] = '?';     // Catch: Exception -> L57
        this.f535086o = 2;     // Catch: Exception -> L57
        goto L34
    L35:
        this.f535086o = 0;     // Catch: Exception -> L57
    L36:
        r106 = "UTF-32BE";
        goto L52
    L37:
        this.f535084m[0] = Typography.less;     // Catch: Exception -> L57
        this.f535086o = 1;     // Catch: Exception -> L57
        goto L36
    L38:
        this.f535086o = 0;     // Catch: Exception -> L57
    L40:
        r116 = r111;
    L51:
        r106 = r111;
        goto L52
    L61:
        throw new IllegalArgumentException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final void setInput(Reader r100) throws XmlPullParserException {
        this.f535082k = r100;
        this.f535087p = 1;
        this.f535088q = 0;
        this.f535091t = 0;
        this.f535095x = null;
        this.f535093v = null;
        this.f535096y = false;
        this.f535097z = -1;
        this.f535083l = null;
        this.f535073b = null;
        this.f535074c = null;
        if (r100 != null) goto L5;
        return;
    L5:
        this.f535085n = 0;
        this.f535086o = 0;
        this.E = 0;
        this.f535078g = 0;
        Hashtable r101 = new Hashtable();
        this.f535077f = r101;
        r101.put("amp", "&");
        this.f535077f.put("apos", "'");
        this.f535077f.put("gt", ">");
        this.f535077f.put("lt", "<");
        this.f535077f.put("quot", "\"");
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final void setProperty(String r100, Object r101) throws XmlPullParserException {
        if (c(r100, true, "location") == false) goto L7;
        this.f535072a = r101;
        return;
    L7:
        throw new XmlPullParserException("unsupported property: ".concat(r100));
    }

    public final void d() throws IOException, XmlPullParserException {
        String r100 = null;
        if (this.f535082k != null) goto L5;
        b("No Input specified");
        throw null;
    L5:
        if (this.f535091t != 3) goto L7;
        this.f535078g--;
    L7:
        this.f535097z = -1;
        int r101 = 0;
        if (this.f535096y == true) goto L9;
        if (this.C != null) goto L14;
        int r102 = 2;
        if (this.f535076e == true) goto L21;
    L33:
        this.f535094w = r100;
        this.f535095x = r100;
        this.f535093v = r100;
        int r103 = g();
        this.f535091t = r103;
        if (r103 == 1) goto L213;
        if (r103 == 2) goto L179;
        if (r103 == 3) goto L164;
        if (r103 == 4) goto L158;
        if (r103 == 6) goto L156;
        boolean r104 = this.H;
        k();
        int r110 = k();
        if (r110 != 63) goto L95;
        if (f(0) == 120) goto L49;
        if (f(0) == 88) goto L49;
    L93:
        String r105 = "";
        boolean r106 = r104;
        int r107 = 63;
        int r111 = 8;
    L103:
        int r112 = 0;
    L105:
        if (r112 >= r105.length()) goto L108;
        l(r105.charAt(r112));
        r112 = r112 + 1;
        goto L105
    L108:
        if (r111 != 10) goto L127;
        int r108 = 1;
    L110:
        int r109 = k();
        if (r109 == (-1)) goto L126;
        if (r109 == 39) goto L123;
        if (r109 == 60) goto L121;
        if (r109 != 62) goto L124;
        if (r101 != 0) goto L124;
        r108 = r108 - 1;
        if (r108 != 0) goto L124;
    L148:
        int r113 = r111;
    L152:
        this.f535091t = r113;
        if (r113 != 998) goto L154;
        r100 = null;
        goto L7
    L154:
        return;
    L124:
        if (r106 == false) goto L110;
        h(r109);
        goto L110
    L121:
        if (r101 != 0) goto L124;
        r108 = r108 + 1;
        goto L124
    L123:
        r101 = r101 ^ 1;
        goto L124
    L126:
        a("Unexpected EOF");
        goto L148
    L127:
        int r114 = 0;
    L128:
        int r115 = k();
        if (r115 == (-1)) goto L130;
        if (r106 == false) goto L134;
        h(r115);
    L134:
        if (r107 == 63) goto L137;
        if (r115 == r107) goto L137;
    L149:
        r114 = r115;
    L137:
        if (f(0) != r107) goto L149;
        if (f(1) != 62) goto L149;
        if (r107 != 45) goto L143;
        if (r114 != 45) goto L143;
        a("illegal comment delimiter: --->");
    L143:
        k();
        k();
        if (r106 == false) goto L148;
        if (r107 == 63) goto L148;
        this.f535090s--;
        goto L148
    L130:
        a("Unexpected EOF");
    L151:
        r113 = 9;
    L49:
        if (f(1) != 109) goto L51;
    L52:
        if (r104 == false) goto L54;
        h(f(0));
        h(f(1));
    L54:
        k();
        k();
        if (f(0) == 108) goto L59;
        if (f(0) != 76) goto L93;
    L59:
        if (f(1) > 32) goto L93;
        if (this.f535087p == 1) goto L63;
    L64:
        a("PI must not start with xml");
    L65:
        e(true);
        if (this.f535097z >= 1) goto L68;
    L69:
        a("version expected");
    L70:
        String[] r116 = this.A;
        this.f535073b = r116[3];
        if (1 < this.f535097z) goto L73;
    L75:
        r102 = 1;
    L77:
        if (r102 >= this.f535097z) goto L90;
        int r117 = r102 * 4;
        if ("standalone".equals(this.A[r117 + 2]) == false) goto L90;
        String r118 = this.A[r117 + 3];
        if (BdpAppEventConstant.YES.equals(r118) == false) goto L84;
        Boolean r119 = new Boolean(true);
    L86:
        this.f535074c = r119;
    L88:
        r102 = r102 + 1;
        goto L90
    L84:
        if (BdpAppEventConstant.NO.equals(r118) == false) goto L87;
        r119 = new Boolean(false);
        goto L86
    L87:
        StringBuffer r120 = new StringBuffer("illegal standalone value: ");
        r120.append(r118);
        a(r120.toString());
    L90:
        if (r102 == this.f535097z) goto L92;
        a("illegal xmldecl");
    L92:
        this.f535092u = true;
        this.f535090s = 0;
        r113 = 998;
        goto L152
    L73:
        if ("encoding".equals(r116[6]) == false) goto L75;
        this.f535083l = this.A[7];
        goto L77
    L68:
        if ("version".equals(this.A[2]) == true) goto L70;
    L63:
        if (this.f535088q <= 4) goto L65;
    L51:
        if (f(1) != 77) goto L93;
    L95:
        if (r110 == 33) goto L97;
        StringBuffer r121 = new StringBuffer("illegal: <");
        r121.append(r110);
        a(r121.toString());
        goto L151
    L97:
        if (f(0) != 45) goto L100;
        r105 = HttpClient.ENDFLAG;
        r106 = r104;
        r107 = 45;
        r111 = 9;
        goto L103
    L100:
        if (f(0) != 91) goto L102;
        r105 = "[CDATA[";
        r107 = 93;
        r106 = true;
        r111 = 5;
        goto L103
    L102:
        r105 = "DOCTYPE";
        r106 = r104;
        r107 = -1;
        r111 = 10;
        goto L103
    L156:
        i();
        return;
    L158:
        j(60, !this.H);
        if (this.f535078g == 0) goto L161;
        return;
    L161:
        if (this.f535092u == false) goto L211;
        this.f535091t = 7;
        return;
    L211:
        return;
    L164:
        k();
        k();
        this.f535095x = m();
        n();
        l(Typography.greater);
        int r122 = this.f535078g;
        int r123 = (r122 - 1) << 2;
        if (r122 != 0) goto L168;
        a("element stack empty");
    L167:
        this.f535091t = 9;
        return;
    L168:
        int r124 = r123 + 3;
        if (this.f535095x.equals(this.f535079h[r124]) == true) goto L177;
        StringBuffer r125 = new StringBuffer("expected: /");
        r125.append(this.f535079h[r124]);
        r125.append(" read: ");
        r125.append(this.f535095x);
        a(r125.toString());
        int r126 = r123;
    L171:
        if (r126 < 0) goto L175;
        if (this.f535095x.toLowerCase().equals(this.f535079h[r126 + 3].toLowerCase()) == true) goto L175;
        this.B++;
        r126 = r126 - 4;
    L175:
        if (r126 >= 0) goto L177;
        this.B = 0;
    L177:
        String[] r127 = this.f535079h;
        this.f535093v = r127[r123];
        this.f535094w = r127[r123 + 1];
        this.f535095x = r127[r123 + 2];
        return;
    L179:
        e(false);
        return;
    L213:
        return;
    L21:
        if (this.B > 0) goto L26;
        if (f(0) != (-1)) goto L33;
        if (this.f535078g <= 0) goto L33;
    L26:
        int r128 = (this.f535078g - 1) << 2;
        this.f535091t = 3;
        String[] r129 = this.f535079h;
        this.f535093v = r129[r128];
        this.f535094w = r129[r128 + 1];
        this.f535095x = r129[r128 + 2];
        if (this.B == 1) goto L29;
        StringBuffer r130 = new StringBuffer("missing end tag /");
        r130.append(this.f535095x);
        r130.append(" inserted");
        this.C = r130.toString();
    L29:
        int r131 = this.B;
        if (r131 <= 0) goto L209;
        this.B = r131 - 1;
        return;
    L209:
        return;
    L14:
        if (r101 >= this.C.length()) goto L16;
        h(this.C.charAt(r101));
        r101 = r101 + 1;
        goto L14
    L16:
        this.C = r100;
        this.f535091t = 9;
        return;
    L9:
        this.f535096y = false;
        this.f535091t = 3;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getText() {
        int r100 = this.f535091t;
        if (r100 >= 4) goto L5;
    L10:
        return null;
    L5:
        if (r100 != 6) goto L12;
        if (this.G == true) goto L10;
    L12:
        return new String(this.f535089r, 0, this.f535090s - 0);
    }

    public final String m() throws IOException, XmlPullParserException {
        int r100 = this.f535090s;
        int r101 = f(0);
        if (r101 < 97) goto L5;
        if (r101 > 122) goto L5;
    L14:
        h(k());
        int r102 = f(0);
        if (r102 < 97) goto L17;
        if (r102 <= 122) goto L14;
    L17:
        if (r102 < 65) goto L20;
        if (r102 <= 90) goto L14;
    L20:
        if (r102 < 48) goto L23;
        if (r102 <= 57) goto L14;
    L23:
        if (r102 == 95) goto L14;
        if (r102 == 45) goto L14;
        if (r102 == 58) goto L14;
        if (r102 == 46) goto L14;
        if (r102 >= 183) goto L14;
        String r103 = new String(this.f535089r, r100, this.f535090s - r100);
        this.f535090s = r100;
        return r103;
    L5:
        if (r101 < 65) goto L7;
        if (r101 <= 90) goto L14;
    L7:
        if (r101 == 95) goto L14;
        if (r101 == 58) goto L14;
        if (r101 >= 192) goto L14;
        if (this.f535076e == true) goto L14;
        a("name expected");
        goto L14
    }

    public final void i() throws IOException, XmlPullParserException {
        h(k());
        int r100 = this.f535090s;
    L3:
        int r101 = k();
        if (r101 == 59) goto L5;
        if (r101 >= 128) goto L57;
        if (r101 < 48) goto L38;
        if (r101 <= 57) goto L57;
    L38:
        if (r101 < 97) goto L42;
        if (r101 <= 122) goto L57;
    L42:
        if (r101 < 65) goto L46;
        if (r101 <= 90) goto L57;
    L46:
        if (r101 == 95) goto L57;
        if (r101 == 45) goto L57;
        if (r101 == 35) goto L57;
        if (this.f535076e == true) goto L54;
        a("unterminated entity ref");
    L54:
        if (r101 == (-1)) goto L70;
        h(r101);
        return;
    L70:
        return;
    L57:
        h(r101);
        goto L3
    L5:
        String r102 = new String(this.f535089r, r100, this.f535090s - r100);
        boolean r103 = true;
        this.f535090s = r100 - 1;
        if (this.H == true) goto L8;
    L10:
        int r104 = 0;
        if (r102.charAt(0) == '#') goto L13;
        String r105 = (String) this.f535077f.get(r102);
        if (r105 == null) goto L22;
        r103 = false;
    L22:
        this.G = r103;
        if (r103 == false) goto L28;
        if (this.H == true) goto L30;
        StringBuffer r106 = new StringBuffer("unresolved: &");
        r106.append(r102);
        r106.append(i.f25853b);
        a(r106.toString());
        return;
    L30:
        return;
    L28:
        if (r104 >= r105.length()) goto L69;
        h(r105.charAt(r104));
        r104 = r104 + 1;
        goto L28
    L69:
        return;
    L13:
        if (r102.charAt(1) != 'x') goto L15;
        int r107 = CastIntegerProtector.parseInt(r102.substring(2), 16);
    L16:
        h(r107);
        return;
    L15:
        r107 = CastIntegerProtector.parseInt(r102.substring(1));
        goto L16
    L8:
        if (this.f535091t != 6) goto L10;
        this.f535095x = r102;
        goto L10
    }

    public final void e(boolean r110) throws IOException, XmlPullParserException {
        if (r110 == true) goto L4;
        k();
    L4:
        this.f535095x = m();
        this.f535097z = 0;
    L5:
        n();
        int r100 = f(0);
        if (r110 == false) goto L12;
        if (r100 == 63) goto L9;
    L17:
        if (r100 == (-1)) goto L18;
        String r101 = m();
        if (r101.length() == 0) goto L22;
        int r102 = this.f535097z;
        this.f535097z = r102 + 1;
        int r103 = r102 << 2;
        String[] r104 = this.A;
        int r105 = r103 + 4;
        if (r104.length >= r105) goto L92;
        String[] r106 = new String[r105 + 16];
        System.arraycopy(r104, 0, r106, 0, r104.length);
        r104 = r106;
    L92:
        this.A = r104;
        int r107 = r103 + 1;
        r104[r103] = "";
        int r108 = r107 + 1;
        r104[r107] = null;
        int r109 = r108 + 1;
        r104[r108] = r101;
        n();
        if (f(0) != 61) goto L94;
        l(com.alipay.sdk.m.n.a.f25612h);
        n();
        int r111 = f(0);
        if (r111 != 39) goto L98;
    L100:
        k();
    L101:
        int r112 = this.f535090s;
        j(r111, true);
        this.A[r109] = new String(this.f535089r, r112, this.f535090s - r112);
        this.f535090s = r112;
        if (r111 == 32) goto L5;
        k();
        goto L5
    L98:
        if (r111 == 34) goto L100;
        a("attr value delimiter missing!");
        r111 = 32;
        goto L101
    L94:
        a("Attr.value missing f. ".concat(r101));
        this.A[r109] = "1";
        goto L5
    L22:
        a("attr name expected");
    L23:
        int r113 = this.f535078g;
        this.f535078g = r113 + 1;
        int r114 = r113 << 2;
        String[] r115 = this.f535079h;
        int r116 = r114 + 4;
        if (r115.length >= r116) goto L27;
        String[] r117 = new String[r116 + 16];
        System.arraycopy(r115, 0, r117, 0, r115.length);
        r115 = r117;
    L27:
        this.f535079h = r115;
        r115[r114 + 3] = this.f535095x;
        int r118 = this.f535078g;
        int[] r119 = this.f535081j;
        if (r118 < r119.length) goto L30;
        int[] r120 = new int[r118 + 4];
        System.arraycopy(r119, 0, r120, 0, r119.length);
        this.f535081j = r120;
    L30:
        int[] r121 = this.f535081j;
        int r122 = this.f535078g;
        r121[r122] = r121[r122 - 1];
        if (this.f535075d == false) goto L85;
        int r123 = 0;
        boolean r124 = false;
    L33:
        int r125 = this.f535097z << 2;
        if (r123 >= r125) goto L55;
        String r126 = this.A[r123 + 2];
        int r127 = r126.indexOf(58);
        if (r127 == (-1)) goto L39;
        String r128 = r126.substring(0, r127);
        String r129 = r126.substring(r127 + 1);
        r126 = r128;
    L42:
        if (r126.equals("xmlns") == true) goto L44;
        r124 = true;
    L54:
        r123 = r123 + 4;
        goto L33
    L44:
        int[] r130 = this.f535081j;
        int r131 = this.f535078g;
        int r132 = r130[r131];
        r130[r131] = r132 + 1;
        int r133 = r132 << 1;
        String[] r134 = this.f535080i;
        int r135 = r133 + 2;
        if (r134.length >= r135) goto L48;
        String[] r136 = new String[r135 + 16];
        System.arraycopy(r134, 0, r136, 0, r134.length);
        r134 = r136;
    L48:
        this.f535080i = r134;
        r134[r133] = r129;
        String[] r137 = this.A;
        int r138 = r123 + 3;
        r134[r133 + 1] = r137[r138];
        if (r129 != null) goto L51;
    L53:
        String[] r139 = this.A;
        int r140 = this.f535097z - 1;
        this.f535097z = r140;
        System.arraycopy(r139, r123 + 4, r139, r123, (r140 << 2) - r123);
        r123 = r123 - 4;
        goto L54
    L51:
        if (r137[r138].equals("") == false) goto L53;
        a("illegal empty namespace");
        goto L53
    L39:
        if (r126.equals("xmlns") == false) goto L54;
        r129 = null;
        goto L42
    L55:
        if (r124 == false) goto L74;
    L56:
        r125 = r125 - 4;
        if (r125 < 0) goto L74;
        int r141 = r125 + 2;
        String r142 = this.A[r141];
        int r143 = r142.indexOf(58);
        if (r143 == 0) goto L61;
    L65:
        if (r143 == (-1)) goto L56;
        String r144 = r142.substring(0, r143);
        String r145 = r142.substring(r143 + 1);
        String r146 = getNamespace(r144);
        if (r146 == null) goto L69;
    L73:
        String[] r147 = this.A;
        r147[r125] = r146;
        r147[r125 + 1] = r144;
        r147[r141] = r145;
        goto L56
    L69:
        if (this.f535076e == true) goto L73;
        StringBuffer r148 = new StringBuffer("Undefined Prefix: ");
        r148.append(r144);
        r148.append(" in ");
        r148.append(this);
        throw new RuntimeException(r148.toString());
    L61:
        if (this.f535076e == true) goto L65;
        StringBuffer r149 = new StringBuffer("illegal attribute name: ");
        r149.append(r142);
        r149.append(" at ");
        r149.append(this);
        throw new RuntimeException(r149.toString());
    L74:
        int r150 = this.f535095x.indexOf(58);
        if (r150 != 0) goto L77;
        StringBuffer r151 = new StringBuffer("illegal tag name: ");
        r151.append(this.f535095x);
        a(r151.toString());
    L77:
        if (r150 == (-1)) goto L79;
        this.f535094w = this.f535095x.substring(0, r150);
        this.f535095x = this.f535095x.substring(r150 + 1);
    L79:
        String r152 = getNamespace(this.f535094w);
        this.f535093v = r152;
        if (r152 == null) goto L82;
    L86:
        String[] r153 = this.f535079h;
        r153[r114] = this.f535093v;
        r153[r114 + 1] = this.f535094w;
        r153[r114 + 2] = this.f535095x;
        return;
    L82:
        if (this.f535094w == null) goto L84;
        StringBuffer r154 = new StringBuffer("undefined prefix: ");
        r154.append(this.f535094w);
        a(r154.toString());
    L84:
        this.f535093v = "";
        goto L86
    L85:
        this.f535093v = "";
        goto L86
    L18:
        a("Unexpected EOF");
        return;
    L9:
        k();
        l(Typography.greater);
        return;
    L12:
        if (r100 == 47) goto L13;
        if (r100 != 62) goto L17;
        if (r110 == true) goto L17;
        k();
        goto L23
    L13:
        this.f535096y = true;
        k();
        n();
        l(Typography.greater);
        goto L23
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final void require(int r100, String r101, String r102) throws XmlPullParserException, IOException {
        if (r100 != this.f535091t) goto L11;
        if (r101 != null) goto L6;
    L7:
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.equals(this.f535095x) == false) goto L11;
        return;
    L6:
        if (r101.equals(this.f535093v) == true) goto L7;
    L11:
        StringBuffer r103 = new StringBuffer("expected: ");
        r103.append(XmlPullParser.TYPES[r100]);
        r103.append(" {");
        r103.append(r101);
        r103.append(i.f25855d);
        r103.append(r102);
        b(r103.toString());
        throw null;
    }
}
