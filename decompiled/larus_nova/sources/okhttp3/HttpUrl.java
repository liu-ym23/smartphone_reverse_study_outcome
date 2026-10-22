package okhttp3;

import android.text.TextUtils;
import com.alibaba.gaiax.render.view.basic.GXImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.bduploader.UploadKeys;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import kotlin.UByte;
import kotlin.text.Typography;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okhttp3.ttnet.TTConfigManager;
import okio.Buffer;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes5.dex */
public final class HttpUrl {
    static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    static final String FRAGMENT_ENCODE_SET = "";
    static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    private static final char[] HEX_DIGITS = null;
    static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    static final String QUERY_ENCODE_SET = " \"'<>#";
    static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";

    @Nullable
    private final String fragment;
    final String host;
    private final String password;
    private final List<String> pathSegments;
    final int port;

    @Nullable
    private final List<String> queryNamesAndValues;
    final String scheme;
    private final String url;
    private final String username;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public String f523776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f523777b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f523778c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public String f523779d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f523780e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<String> f523781f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public List<String> f523782g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public String f523783h;

        public final HttpUrl b() {
            if (this.f523776a == null) goto L11;
            if (this.f523779d == null) goto L9;
            return new HttpUrl(this);
        L9:
            throw new IllegalStateException("host == null");
        L11:
            throw new IllegalStateException("scheme == null");
        }

        public final String toString() {
            StringBuilder r100 = new StringBuilder();
            String r101 = this.f523776a;
            if (r101 == null) goto L5;
            r100.append(r101);
            r100.append("://");
        L7:
            if (this.f523777b.isEmpty() == true) goto L9;
        L10:
            r100.append(this.f523777b);
            if (this.f523778c.isEmpty() == true) goto L13;
            r100.append(':');
            r100.append(this.f523778c);
        L13:
            r100.append('@');
        L14:
            String r102 = this.f523779d;
            if (r102 != null) goto L17;
        L20:
            int r103 = this.f523780e;
            if (r103 == (-1)) goto L23;
        L24:
            if (r103 != (-1)) goto L27;
            r103 = HttpUrl.defaultPort(this.f523776a);
        L27:
            String r104 = this.f523776a;
            if (r104 != null) goto L30;
        L31:
            r100.append(':');
            r100.append(r103);
        L32:
            HttpUrl.pathSegmentsToString(r100, this.f523781f);
            if (this.f523782g == null) goto L36;
            r100.append('?');
            HttpUrl.namesAndValuesToQueryString(r100, this.f523782g);
        L36:
            if (this.f523783h == null) goto L39;
            r100.append('#');
            r100.append(this.f523783h);
        L39:
            return r100.toString();
        L30:
            if (r103 == HttpUrl.defaultPort(r104)) goto L32;
        L23:
            if (this.f523776a == null) goto L32;
        L17:
            if (r102.indexOf(58) == (-1)) goto L19;
            r100.append('[');
            r100.append(this.f523779d);
            r100.append(']');
            goto L20
        L19:
            r100.append(this.f523779d);
            goto L20
        L9:
            if (this.f523778c.isEmpty() == true) goto L14;
        L5:
            r100.append("//");
            goto L7
        }

        public a() {
            this.f523777b = "";
            this.f523778c = "";
            this.f523780e = -1;
            ArrayList r100 = new ArrayList();
            this.f523781f = r100;
            r100.add("");
        }

        public final void c(String r100) {
            if (r100 == null) goto L10;
            String r101 = cvc.c.c(HttpUrl.percentDecode(r100, 0, r100.length(), false));
            if (r101 == null) goto L8;
            this.f523779d = r101;
            return;
        L8:
            throw new IllegalArgumentException("unexpected host: ".concat(r100));
        L10:
            throw new NullPointerException("host == null");
        }

        public final void g(String r100) {
            if (r100 == null) goto L13;
            if (r100.equalsIgnoreCase("http") == false) goto L7;
            this.f523776a = "http";
            return;
        L7:
            if (r100.equalsIgnoreCase("https") == false) goto L11;
            this.f523776a = "https";
            return;
        L11:
            throw new IllegalArgumentException("unexpected scheme: ".concat(r100));
        L13:
            throw new NullPointerException("scheme == null");
        }

        public a query(@Nullable String r100) {
            if (r100 == null) goto L4;
            List<String> r101 = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(r100, HttpUrl.QUERY_ENCODE_SET, false, false, true, true));
        L5:
            this.f523782g = r101;
            return this;
        L4:
            r101 = null;
            goto L5
        }

        public final void a(String r100, @Nullable String r101) {
            if (r100 == null) goto L13;
            if (this.f523782g != null) goto L6;
            this.f523782g = new ArrayList();
        L6:
            this.f523782g.add(HttpUrl.canonicalize(r100, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true));
            List<String> r102 = this.f523782g;
            if (r101 == null) goto L9;
            String r103 = HttpUrl.canonicalize(r101, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true);
        L10:
            r102.add(r103);
            return;
        L9:
            r103 = null;
            goto L10
        L13:
            throw new NullPointerException("name == null");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void d(@Nullable HttpUrl r210, String r211) {
            int r100 = cvc.c.t(r211, 0, r211.length());
            int r110 = cvc.c.u(r211, r100, r211.length());
            byte r111 = -1;
            if ((r110 - r100) < 2) goto L33;
            char r101 = r211.charAt(r100);
            char r102 = Matrix.MATRIX_TYPE_ZERO;
            if (r101 < 'a') goto L8;
            if (r101 > 'z') goto L8;
        L11:
            int r103 = r100;
        L12:
            r103 = r103 + 1;
            if (r103 >= r110) goto L33;
            char r104 = r211.charAt(r103);
            if (r104 < 'a') goto L17;
            if (r104 > 'z') goto L17;
        L32:
            r102 = Matrix.MATRIX_TYPE_ZERO;
        L17:
            if (r104 < 'A') goto L20;
            if (r104 <= r102) goto L32;
        L20:
            if (r104 < '0') goto L24;
            if (r104 <= '9') goto L32;
        L24:
            if (r104 == '+') goto L32;
            if (r104 == '-') goto L32;
            if (r104 == '.') goto L32;
            if (r104 != ':') goto L33;
            int r105 = r103;
        L34:
            if (r105 == (-1)) goto L43;
            int r112 = r105;
            if (r211.regionMatches(true, r100, GXImageView.NET_HTTPS_PREFIX, 0, 6) == false) goto L39;
            this.f523776a = "https";
            r100 = r100 + 6;
        L45:
            int r106 = r100;
            int r107 = 0;
        L46:
            byte r113 = 92;
            byte r108 = 47;
            if (r106 >= r110) goto L52;
            char r109 = r211.charAt(r106);
            if (r109 == '\\') goto L51;
            if (r109 != '/') goto L52;
        L51:
            r107 = r107 + 1;
            r106 = r106 + 1;
        L52:
            if (r107 >= 2) goto L55;
        L64:
            boolean r114 = false;
        L65:
            byte r115 = 63;
            byte r116 = 35;
            if (r114 == true) goto L80;
            if (r210 == null) goto L80;
            if (r210.scheme.equals(this.f523776a) == false) goto L80;
            this.f523777b = r210.encodedUsername();
            this.f523778c = r210.encodedPassword();
            this.f523779d = r210.host;
            this.f523780e = r210.port;
            ((ArrayList) this.f523781f).clear();
            ((ArrayList) this.f523781f).addAll(r210.encodedPathSegments());
            if (r100 != r110) goto L74;
        L75:
            String r117 = r210.encodedQuery();
            if (r117 == null) goto L78;
            List<String> r118 = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(r117, HttpUrl.QUERY_ENCODE_SET, true, false, true, true));
        L79:
            this.f523782g = r118;
        L142:
            int r119 = cvc.c.j(r211, r100, r110, "?#");
            f(r211, r100, r119);
            if (r119 < r110) goto L145;
        L147:
            char r120 = '#';
        L148:
            if (r119 < r110) goto L150;
            return;
        L150:
            if (r211.charAt(r119) != r120) goto L186;
            this.f523783h = HttpUrl.canonicalize(r211, 1 + r119, r110, "", true, false, false, false, null);
            return;
        L186:
            return;
        L145:
            if (r211.charAt(r119) != '?') goto L147;
            r120 = '#';
            int r121 = cvc.c.i(r211, r119, r110, '#');
            this.f523782g = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(r211, r119 + 1, r121, HttpUrl.QUERY_ENCODE_SET, true, false, true, true, null));
            r119 = r121;
            goto L148
        L78:
            r118 = null;
            goto L79
        L74:
            if (r211.charAt(r100) != '#') goto L142;
        L80:
            int r122 = r100 + r107;
            boolean r123 = false;
            boolean r124 = false;
        L81:
            int r125 = cvc.c.j(r211, r122, r110, "@/\\?#");
            if (r125 == r110) goto L84;
            byte r126 = r211.charAt(r125);
        L85:
            if (r126 == r111) goto L105;
            if (r126 == r116) goto L105;
            if (r126 == r108) goto L105;
            if (r126 == r113) goto L105;
            if (r126 == r115) goto L105;
            if (r126 == 64) goto L94;
        L104:
            r116 = 35;
            r108 = 47;
            r115 = 63;
            r111 = -1;
            r113 = 92;
            goto L81
        L94:
            if (r123 == true) goto L102;
            int r127 = cvc.c.i(r211, r122, r125, ':');
            int r128 = r125;
            String r129 = HttpUrl.canonicalize(r211, r122, r127, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
            if (r124 == false) goto L98;
            r129 = this.f523777b + "%40" + r129;
        L98:
            this.f523777b = r129;
            if (r127 == r128) goto L101;
            this.f523778c = HttpUrl.canonicalize(r211, r127 + 1, r128, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
            r123 = true;
        L101:
            r124 = true;
        L103:
            r122 = r128 + 1;
            goto L104
        L102:
            r128 = r125;
            this.f523778c += "%40" + HttpUrl.canonicalize(r211, r122, r128, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
        L105:
            int r130 = r122;
        L106:
            if (r130 >= r125) goto L119;
            char r131 = r211.charAt(r130);
            if (r131 == ':') goto L118;
            if (r131 == '[') goto L112;
            int r132 = 1;
        L117:
            r130 = r130 + r132;
            goto L106
        L112:
            r132 = 1;
        L113:
            r130 = r130 + 1;
            if (r130 >= r125) goto L117;
            if (r211.charAt(r130) != ']') goto L113;
        L118:
            int r133 = r130;
        L120:
            int r134 = r133 + 1;
            if (r134 >= r125) goto L138;
            this.f523779d = cvc.c.c(HttpUrl.percentDecode(r211, r122, r133, false));
            int r212 = r122;
            int r135 = CastIntegerProtector.parseInt(HttpUrl.canonicalize(r211, r134, r125, "", false, false, false, true, null));     // Catch: NumberFormatException -> L157
            if (r135 <= 0) goto L132;
            if (r135 > 65535) goto L132;
        L133:
            this.f523780e = r135;
            if (r135 == (-1)) goto L137;
            r122 = r212;
        L140:
            if (this.f523779d == null) goto L154;
            r100 = r125;
            goto L142
        L154:
            throw new IllegalArgumentException("Invalid URL host: \"" + r211.substring(r122, r133) + Typography.quote);
        L137:
            throw new IllegalArgumentException("Invalid URL port: \"" + r211.substring(r134, r125) + Typography.quote);
        L132:
            r135 = -1;
            goto L133
        L138:
            this.f523779d = cvc.c.c(HttpUrl.percentDecode(r211, r122, r133, false));
            this.f523780e = HttpUrl.defaultPort(this.f523776a);
            goto L140
        L119:
            r133 = r125;
            goto L120
        L84:
            r126 = -1;
            goto L85
        L55:
            if (TTConfigManager.isIgnoreSlashEnabled() == true) goto L58;
        L63:
            r114 = true;
            goto L65
        L58:
            if (TextUtils.isEmpty(r211) == true) goto L64;
            if (r211.startsWith("https://") == true) goto L63;
            if (r211.startsWith("http://") == false) goto L64;
        L39:
            if (r211.regionMatches(true, r100, GXImageView.NET_HTTP_PREFIX, 0, 5) == false) goto L42;
            this.f523776a = "http";
            r100 = r100 + 5;
            goto L45
        L42:
            throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + r211.substring(0, r112) + "'");
        L43:
            if (r210 == null) goto L156;
            this.f523776a = r210.scheme;
            goto L45
        L156:
            throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
        L8:
            if (r101 < 'A') goto L33;
            if (r101 <= 'Z') goto L11;
        L33:
            r105 = -1;
            goto L34
        }

        public final void f(String r110, int r111, int r112) {
            if (r111 != r112) goto L4;
            return;
        L4:
            char r100 = r110.charAt(r111);
            if (r100 != '/') goto L7;
        L10:
            ((ArrayList) this.f523781f).clear();
            ((ArrayList) this.f523781f).add("");
            r111 = r111 + 1;
        L11:
            int r101 = r111;
            if (r101 >= r112) goto L20;
            r111 = cvc.c.j(r110, r101, r112, "/\\");
            if (r111 >= r112) goto L16;
            boolean r102 = true;
        L17:
            e(r110, r101, r111, r102, true);
            if (r102 == false) goto L11;
            r111 = r111 + 1;
            goto L11
        L16:
            r102 = false;
            goto L17
        L20:
            return;
        L7:
            if (r100 == '\\') goto L10;
            List<String> r103 = this.f523781f;
            ListProtector.set(r103, ((ArrayList) r103).size() - 1, "");
            goto L11
        }

        public final void e(String r110, int r111, int r112, boolean r113, boolean r114) {
            String r115 = HttpUrl.canonicalize(r110, r111, r112, HttpUrl.PATH_SEGMENT_ENCODE_SET, r114, false, false, true, null);
            boolean r116 = false;
            if (r115.equals(".") == false) goto L5;
        L8:
            boolean r117 = true;
        L9:
            if (r117 == false) goto L12;
            return;
        L12:
            if (r115.equals(DownloadConstants.VULNERABILITY_PATH) == false) goto L14;
        L19:
            r116 = true;
        L21:
            if (r116 == false) goto L29;
            List<String> r118 = this.f523781f;
            if (((String) ListProtector.remove(r118, ((ArrayList) r118).size() - 1)).isEmpty() == true) goto L25;
        L27:
            ((ArrayList) this.f523781f).add("");
            return;
        L25:
            if (((ArrayList) this.f523781f).isEmpty() == true) goto L27;
            List<String> r119 = this.f523781f;
            ListProtector.set(r119, ((ArrayList) r119).size() - 1, "");
            return;
        L29:
            List<String> r120 = this.f523781f;
            if (((String) ListProtector.get(r120, ((ArrayList) r120).size() - 1)).isEmpty() == false) goto L32;
            List<String> r121 = this.f523781f;
            ListProtector.set(r121, ((ArrayList) r121).size() - 1, r115);
        L33:
            if (r113 == false) goto L37;
            ((ArrayList) this.f523781f).add("");
            return;
        L37:
            return;
        L32:
            ((ArrayList) this.f523781f).add(r115);
            goto L33
        L14:
            if (r115.equalsIgnoreCase("%2e.") == true) goto L19;
            if (r115.equalsIgnoreCase(".%2e") == true) goto L19;
            if (r115.equalsIgnoreCase("%2e%2e") == false) goto L21;
        L5:
            if (r115.equalsIgnoreCase("%2e") == true) goto L8;
            r117 = false;
            goto L9
        }
    }

    static {
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    @Nullable
    public String encodedFragment() {
        if (this.fragment != null) goto L6;
        return null;
    L6:
        int r100 = this.url.indexOf(35) + 1;
        return this.url.substring(r100);
    }

    public String encodedPassword() {
        if (this.password.isEmpty() == false) goto L6;
        return "";
    L6:
        int r100 = this.url.indexOf(58, this.scheme.length() + 3) + 1;
        int r101 = this.url.indexOf(64);
        return this.url.substring(r100, r101);
    }

    public String encodedPath() {
        int r100 = this.url.indexOf(47, this.scheme.length() + 3);
        String r101 = this.url;
        int r102 = cvc.c.j(r101, r100, r101.length(), "?#");
        return this.url.substring(r100, r102);
    }

    public List<String> encodedPathSegments() {
        int r100 = this.url.indexOf(47, this.scheme.length() + 3);
        String r101 = this.url;
        int r102 = cvc.c.j(r101, r100, r101.length(), "?#");
        ArrayList r103 = new ArrayList();
    L3:
        if (r100 >= r102) goto L5;
        int r104 = r100 + 1;
        int r105 = cvc.c.i(this.url, r104, r102, '/');
        r103.add(this.url.substring(r104, r105));
        r100 = r105;
        goto L3
    L5:
        return r103;
    }

    @Nullable
    public String encodedQuery() {
        if (this.queryNamesAndValues != null) goto L6;
        return null;
    L6:
        int r100 = this.url.indexOf(63) + 1;
        String r101 = this.url;
        int r102 = cvc.c.i(r101, r100, r101.length(), '#');
        return this.url.substring(r100, r102);
    }

    public String encodedUsername() {
        if (this.username.isEmpty() == false) goto L6;
        return "";
    L6:
        int r100 = this.scheme.length() + 3;
        String r101 = this.url;
        int r102 = cvc.c.j(r101, r100, r101.length(), ":@");
        return this.url.substring(r100, r102);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public boolean isHttps() {
        return this.scheme.equals("https");
    }

    public a newBuilder() {
        a r100 = new a();
        r100.f523776a = this.scheme;
        r100.f523777b = encodedUsername();
        r100.f523778c = encodedPassword();
        r100.f523779d = this.host;
        if (this.port == defaultPort(this.scheme)) goto L5;
        int r101 = this.port;
    L6:
        r100.f523780e = r101;
        ((ArrayList) r100.f523781f).clear();
        List<String> r102 = r100.f523781f;
        ArrayList r103 = (ArrayList) r102;
        r103.addAll(encodedPathSegments());
        String r104 = encodedQuery();
        if (r104 == null) goto L9;
        List<String> r105 = queryStringToNamesAndValues(canonicalize(r104, QUERY_ENCODE_SET, true, false, true, true));
    L10:
        r100.f523782g = r105;
        r100.f523783h = encodedFragment();
        return r100;
    L9:
        r105 = null;
        goto L10
    L5:
        r101 = -1;
        goto L6
    }

    public int pathSize() {
        return this.pathSegments.size();
    }

    @Nullable
    public String query() {
        if (this.queryNamesAndValues != null) goto L6;
        return null;
    L6:
        StringBuilder r100 = new StringBuilder();
        namesAndValuesToQueryString(r100, this.queryNamesAndValues);
        return r100.toString();
    }

    public Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) goto L5;
        LinkedHashSet r100 = new LinkedHashSet();
        int r101 = this.queryNamesAndValues.size();
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L10;
        r100.add(ListProtector.get(this.queryNamesAndValues, r102));
        r102 = r102 + 2;
        goto L7
    L10:
        return Collections.unmodifiableSet(r100);
    L5:
        return Collections.emptySet();
    }

    public int querySize() {
        List<String> r100 = this.queryNamesAndValues;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size() / 2;
    }

    public String redact() {
        a r100 = newBuilder("/...");
        r100.getClass();
        r100.f523777b = canonicalize("", " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        r100.f523778c = canonicalize("", " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        return r100.b().toString();
    }

    @Nullable
    public String topPrivateDomain() {
        if (cvc.c.x(this.host) == false) goto L7;
        return null;
    L7:
        return PublicSuffixDatabase.f523914h.b(this.host);
    }

    public URL url() {
        return new URL(this.url);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public URI uri() {
        a r100 = newBuilder();
        int r101 = ((ArrayList) r100.f523781f).size();
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        String r104 = (String) ListProtector.get(r100.f523781f, r103);
        ListProtector.set(r100.f523781f, r103, canonicalize(r104, PATH_SEGMENT_ENCODE_SET_URI, true, true, false, true));
        r103 = r103 + 1;
        goto L3
    L5:
        List<String> r105 = r100.f523782g;
        if (r105 == null) goto L13;
        int r106 = r105.size();
    L8:
        if (r102 >= r106) goto L13;
        String r107 = (String) ListProtector.get(r100.f523782g, r102);
        if (r107 == null) goto L12;
        ListProtector.set(r100.f523782g, r102, canonicalize(r107, QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, true));
    L12:
        r102 = r102 + 1;
    L13:
        String r108 = r100.f523783h;
        if (r108 == null) goto L16;
        r100.f523783h = canonicalize(r108, FRAGMENT_ENCODE_SET_URI, true, true, false, false);
    L16:
        String r109 = r100.toString();
        return new URI(r109);
    L19:
        e = move-exception;
        return URI.create(r109.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L23:
        throw new RuntimeException(e);
    }

    @Nullable
    public String fragment() {
        return this.fragment;
    }

    public String host() {
        return this.host;
    }

    public String password() {
        return this.password;
    }

    public List<String> pathSegments() {
        return this.pathSegments;
    }

    public int port() {
        return this.port;
    }

    public String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public String username() {
        return this.username;
    }

    public HttpUrl(a r100) {
        this.scheme = r100.f523776a;
        this.username = percentDecode(r100.f523777b, false);
        this.password = percentDecode(r100.f523778c, false);
        this.host = r100.f523779d;
        int r101 = r100.f523780e;
        if (r101 != (-1)) goto L6;
        r101 = defaultPort(r100.f523776a);
    L6:
        this.port = r101;
        this.pathSegments = percentDecode(r100.f523781f, false);
        List<String> r102 = r100.f523782g;
        String r103 = null;
        if (r102 == null) goto L9;
        List<String> r104 = percentDecode(r102, true);
    L10:
        this.queryNamesAndValues = r104;
        String r105 = r100.f523783h;
        if (r105 == null) goto L13;
        r103 = percentDecode(r105, false);
    L13:
        this.fragment = r103;
        this.url = r100.toString();
        return;
    L9:
        r104 = null;
        goto L10
    }

    public static int defaultPort(String r100) {
        if (r100.equals("http") == false) goto L7;
        return 80;
    L7:
        if (r100.equals("https") == false) goto L10;
        return UploadKeys.KeyIsGetVideoMeta;
    L10:
        return -1;
    }

    public static HttpUrl get(String r100) {
        a r101 = new a();
        r101.d(null, r100);
        return r101.b();
    }

    @Nullable
    public static HttpUrl parse(String r100) {
        return get(r100);
    L4:
        return null;
    }

    public static List<String> queryStringToNamesAndValues(String r100) {
        ArrayList r101 = new ArrayList();
        int r102 = 0;
    L4:
        if (r102 > r100.length()) goto L15;
        int r103 = r100.indexOf(38, r102);
        if (r103 != (-1)) goto L8;
        r103 = r100.length();
    L8:
        int r104 = r100.indexOf(61, r102);
        if (r104 == (-1)) goto L13;
        if (r104 > r103) goto L13;
        r101.add(r100.substring(r102, r104));
        r101.add(r100.substring(r104 + 1, r103));
    L14:
        r102 = r103 + 1;
    L13:
        r101.add(r100.substring(r102, r103));
        r101.add(null);
        goto L14
    L15:
        return r101;
    }

    public boolean equals(@Nullable Object r100) {
        if ((r100 instanceof HttpUrl) == true) goto L5;
    L7:
        return false;
    L5:
        if (((HttpUrl) r100).url.equals(this.url) == false) goto L7;
        return true;
    }

    @Nullable
    public a newBuilder(String r100) {
        a r101 = new a();     // Catch: IllegalArgumentException -> L4
        r101.d(this, r100);     // Catch: IllegalArgumentException -> L4
        return r101;
    L4:
        return null;
    }

    @Nullable
    public String queryParameter(String r100) {
        List<String> r101 = this.queryNamesAndValues;
        if (r101 != null) goto L5;
        return null;
    L5:
        int r102 = r101.size();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L12;
        if (r100.equals(ListProtector.get(this.queryNamesAndValues, r103)) == true) goto L10;
        r103 = r103 + 2;
        goto L6
    L10:
        return (String) ListProtector.get(this.queryNamesAndValues, r103 + 1);
    L12:
        return null;
    }

    public String queryParameterName(int r100) {
        List<String> r101 = this.queryNamesAndValues;
        if (r101 == null) goto L7;
        return (String) ListProtector.get(r101, r100 * 2);
    L7:
        throw new IndexOutOfBoundsException();
    }

    public String queryParameterValue(int r100) {
        List<String> r101 = this.queryNamesAndValues;
        if (r101 == null) goto L7;
        return (String) ListProtector.get(r101, (r100 * 2) + 1);
    L7:
        throw new IndexOutOfBoundsException();
    }

    public List<String> queryParameterValues(String r100) {
        if (this.queryNamesAndValues == null) goto L5;
        ArrayList r101 = new ArrayList();
        int r102 = this.queryNamesAndValues.size();
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L13;
        if (r100.equals(ListProtector.get(this.queryNamesAndValues, r103)) == false) goto L11;
        r101.add(ListProtector.get(this.queryNamesAndValues, r103 + 1));
    L11:
        r103 = r103 + 2;
        goto L7
    L13:
        return Collections.unmodifiableList(r101);
    L5:
        return Collections.emptyList();
    }

    @Nullable
    public HttpUrl resolve(String r100) {
        a r101 = newBuilder(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.b();
    }

    @Nullable
    public static HttpUrl get(URI r100) {
        return parse(r100.toString());
    }

    @Nullable
    public static HttpUrl get(URL r100) {
        return parse(r100.toString());
    }

    public static void namesAndValuesToQueryString(StringBuilder r100, List<String> r101) {
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        String r104 = (String) ListProtector.get(r101, r103);
        String r105 = (String) ListProtector.get(r101, r103 + 1);
        if (r103 <= 0) goto L7;
        r100.append(Typography.amp);
    L7:
        r100.append(r104);
        if (r105 == null) goto L10;
        r100.append(com.alipay.sdk.m.n.a.f25612h);
        r100.append(r105);
    L10:
        r103 = r103 + 2;
        goto L3
    }

    public static void pathSegmentsToString(StringBuilder r100, List<String> r101) {
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100.append('/');
        r100.append((String) ListProtector.get(r101, r103));
        r103 = r103 + 1;
        goto L3
    }

    private List<String> percentDecode(List<String> r100, boolean r101) {
        int r102 = r100.size();
        ArrayList r103 = new ArrayList(r102);
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L10;
        String r105 = (String) ListProtector.get(r100, r104);
        if (r105 == null) goto L7;
        String r106 = percentDecode(r105, r101);
    L8:
        r103.add(r106);
        r104 = r104 + 1;
        goto L3
    L7:
        r106 = null;
        goto L8
    L10:
        return Collections.unmodifiableList(r103);
    }

    public static String percentDecode(String r100, boolean r101) {
        return percentDecode(r100, 0, r100.length(), r101);
    }

    public static boolean percentEncoded(String r100, int r101, int r102) {
        int r103 = r101 + 2;
        if (r103 < r102) goto L5;
    L11:
        return false;
    L5:
        if (r100.charAt(r101) != '%') goto L11;
        if (cvc.c.g(r100.charAt(r101 + 1)) == (-1)) goto L11;
        if (cvc.c.g(r100.charAt(r103)) == (-1)) goto L11;
        return true;
    }

    public static String percentDecode(String r100, int r101, int r102, boolean r103) {
        int r104 = r101;
    L3:
        if (r104 >= r102) goto L14;
        char r105 = r100.charAt(r104);
        if (r105 == '%') goto L11;
        if (r105 != '+') goto L10;
        if (r103 == true) goto L11;
    L10:
        r104 = r104 + 1;
    L11:
        Buffer r106 = new Buffer();
        r106.writeUtf8(r100, r101, r104);
        percentDecode(r106, r100, r104, r102, r103);
        return r106.readUtf8();
    L14:
        return r100.substring(r101, r102);
    }

    public static void percentDecode(Buffer r100, String r101, int r102, int r103, boolean r104) {
    L2:
        if (r102 >= r103) goto L17;
        int r105 = r101.codePointAt(r102);
        if (r105 != 37) goto L12;
        int r106 = r102 + 2;
        if (r106 >= r103) goto L12;
        int r107 = cvc.c.g(r101.charAt(r102 + 1));
        int r108 = cvc.c.g(r101.charAt(r106));
        if (r107 == (-1)) goto L15;
        if (r108 == (-1)) goto L15;
        r100.writeByte((r107 << 4) + r108);
        r102 = r106;
    L16:
        r102 = r102 + Character.charCount(r105);
    L15:
        r100.writeUtf8CodePoint(r105);
    L12:
        if (r105 != 43) goto L15;
        if (r104 == false) goto L15;
        r100.writeByte(32);
        goto L16
    }

    public static String canonicalize(String r100, String r110, boolean r111, boolean r112, boolean r113, boolean r114) {
        return canonicalize(r100, 0, r100.length(), r110, r111, r112, r113, r114, null);
    }

    public static String canonicalize(String r100, String r110, boolean r111, boolean r112, boolean r113, boolean r114, Charset r115) {
        return canonicalize(r100, 0, r100.length(), r110, r111, r112, r113, r114, r115);
    }

    public static String canonicalize(String r110, int r111, int r112, String r113, boolean r114, boolean r115, boolean r116, boolean r117, Charset r118) {
        int r100 = r111;
    L3:
        if (r100 >= r112) goto L28;
        int r101 = r110.codePointAt(r100);
        if (r101 < 32) goto L25;
        if (r101 == 127) goto L25;
        if (r101 < 128) goto L12;
        if (r117 == true) goto L25;
    L12:
        if (r113.indexOf(r101) != (-1)) goto L25;
        if (r101 != 37) goto L20;
        if (r114 == false) goto L25;
        if (r115 == false) goto L20;
        if (percentEncoded(r110, r100, r112) == false) goto L25;
    L20:
        if (r101 != 43) goto L23;
        if (r116 == true) goto L25;
    L23:
        r100 = r100 + Character.charCount(r101);
    L25:
        Buffer r119 = new Buffer();
        r119.writeUtf8(r110, r111, r100);
        canonicalize(r119, r110, r100, r112, r113, r114, r115, r116, r117, r118);
        return r119.readUtf8();
    L28:
        return r110.substring(r111, r112);
    }

    public static void canonicalize(Buffer r100, String r101, int r102, int r103, String r110, boolean r111, boolean r112, boolean r113, boolean r114, Charset r115) {
        Buffer r104 = null;
    L3:
        if (r102 >= r103) goto L50;
        int r105 = r101.codePointAt(r102);
        if (r111 == false) goto L16;
        if (r105 == 9) goto L49;
        if (r105 == 10) goto L49;
        if (r105 == 12) goto L49;
        if (r105 != 13) goto L16;
    L49:
        r102 = r102 + Character.charCount(r105);
    L16:
        if (r105 != 43) goto L23;
        if (r113 == false) goto L23;
        if (r111 == false) goto L20;
        String r106 = Marker.ANY_NON_NULL_MARKER;
    L21:
        r100.writeUtf8(r106);
        goto L49
    L20:
        r106 = "%2B";
    L23:
        if (r105 >= 32) goto L25;
    L38:
        if (r104 != null) goto L40;
        r104 = new Buffer();
    L40:
        if (r115 != null) goto L42;
    L45:
        r104.writeUtf8CodePoint(r105);
    L47:
        if (r104.exhausted() == true) goto L49;
        int r107 = r104.readByte() & UByte.MAX_VALUE;
        r100.writeByte(37);
        char[] r108 = HEX_DIGITS;
        r100.writeByte(r108[(r107 >> 4) & 15]);
        r100.writeByte(r108[r107 & 15]);
        goto L47
    L42:
        if (r115.equals(cvc.c.f465522j) == true) goto L45;
        r104.writeString(r101, r102, Character.charCount(r105) + r102, r115);
        goto L47
    L25:
        if (r105 == 127) goto L38;
        if (r105 < 128) goto L30;
        if (r114 == true) goto L38;
    L30:
        if (r110.indexOf(r105) != (-1)) goto L38;
        if (r105 != 37) goto L37;
        if (r111 == false) goto L38;
        if (r112 == false) goto L37;
        if (percentEncoded(r101, r102, r103) == false) goto L38;
    L37:
        r100.writeUtf8CodePoint(r105);
        goto L49
    }
}
