package cvc;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.collection.SieveCacheKt;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import kotlin.UByte;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;

/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f465513a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f465514b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ResponseBody f465515c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final RequestBody f465516d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ByteString f465517e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ByteString f465518f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ByteString f465519g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ByteString f465520h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ByteString f465521i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Charset f465522j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Charset f465523k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Charset f465524l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Charset f465525m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Charset f465526n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Charset f465527o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final TimeZone f465528p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f465529q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Method f465530r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Pattern f465531s = null;

    public static class a implements Comparator<String> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(String r100, String r101) {
            return r100.compareTo(r101);
        }
    }

    static {
        byte[] r100 = new byte[0];
        f465513a = r100;
        f465514b = new String[0];
        Method r101 = null;
        f465515c = ResponseBody.create(null, r100);
        f465516d = RequestBody.create(null, r100);
        f465517e = ByteString.decodeHex("efbbbf");
        f465518f = ByteString.decodeHex("feff");
        f465519g = ByteString.decodeHex("fffe");
        f465520h = ByteString.decodeHex("0000ffff");
        f465521i = ByteString.decodeHex("ffff0000");
        f465522j = Charset.forName("UTF-8");
        f465523k = Charset.forName("ISO-8859-1");
        f465524l = Charset.forName("UTF-16BE");
        f465525m = Charset.forName("UTF-16LE");
        f465526n = Charset.forName("UTF-32BE");
        f465527o = Charset.forName("UTF-32LE");
        f465528p = TimeZone.getTimeZone("GMT");
        f465529q = new a();
        r101 = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});     // Catch: Exception -> L6
    L4:
        f465530r = r101;
        f465531s = PatternProtector.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static int g(char r100) {
        if (r100 >= '0') goto L5;
    L8:
        char r101 = 'a';
        if (r100 >= 'a') goto L11;
    L14:
        r101 = 'A';
        if (r100 >= 'A') goto L17;
        return -1;
    L17:
        if (r100 <= 'F') goto L13;
        return -1;
    L13:
        return (r100 - r101) + 10;
    L11:
        if (r100 > 'f') goto L14;
    L5:
        if (r100 > '9') goto L8;
        return r100 - '0';
    }

    public static String c(String r100) {
        int r101 = -1;
        boolean r102 = true;
        int r103 = 0;
        if (r100.contains(":") == true) goto L5;
        String r104 = IDN.toASCII(r100).toLowerCase(Locale.US);     // Catch: IllegalArgumentException -> L64
        if (r104.isEmpty() == false) goto L48;
        return null;
    L48:
        int r105 = 0;
    L50:
        if (r105 >= r104.length()) goto L60;
        char r106 = r104.charAt(r105);     // Catch: IllegalArgumentException -> L64
        if (r106 <= 31) goto L61;
        if (r106 >= 127) goto L61;
        if (" #%/:?@[\\]".indexOf(r106) != (-1)) goto L61;
        r105 = r105 + 1;
    L61:
        if (r102 == false) goto L63;
        return null;
    L63:
        return r104;
    L60:
        r102 = false;
    L64:
        return null;
    L5:
        if (r100.startsWith("[") == true) goto L7;
    L9:
        InetAddress r107 = h(r100, 0, r100.length());
    L10:
        if (r107 != null) goto L12;
        return null;
    L12:
        byte[] r108 = r107.getAddress();
        if (r108.length != 16) goto L44;
        int r109 = 0;
        int r110 = 0;
    L16:
        if (r109 >= r108.length) goto L30;
        int r111 = r109;
    L18:
        if (r111 >= 16) goto L24;
        if (r108[r111] != 0) goto L24;
        if (r108[r111 + 1] != 0) goto L24;
        r111 = r111 + 2;
    L24:
        int r112 = r111 - r109;
        if (r112 <= r110) goto L29;
        if (r112 < 4) goto L29;
        r101 = r109;
        r110 = r112;
    L29:
        r109 = r111 + 2;
        goto L16
    L30:
        Buffer r113 = new Buffer();
    L32:
        if (r103 >= r108.length) goto L42;
        if (r103 == r101) goto L35;
        if (r103 <= 0) goto L40;
        r113.writeByte(58);
    L40:
        r113.writeHexadecimalUnsignedLong(((r108[r103] & UByte.MAX_VALUE) << 8) | (r108[r103 + 1] & UByte.MAX_VALUE));
        r103 = r103 + 2;
        goto L32
    L35:
        r113.writeByte(58);
        r103 = r103 + r110;
        if (r103 != 16) goto L32;
        r113.writeByte(58);
        goto L32
    L42:
        return r113.readUtf8();
    L44:
        throw new AssertionError("Invalid IPv6 address: '" + r100 + "'");
    L7:
        if (r100.endsWith("]") == false) goto L9;
        r107 = h(r100, 1, r100.length() - 1);
        goto L10
    }

    public static void e(Closeable r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        r100.close();     // Catch: RuntimeException -> L5 Exception -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }

    public static void f(Socket r100) {
        if (r100 != null) goto L17;
        return;
    L17:
        r100.close();     // Catch: RuntimeException -> L5 AssertionError -> L10 Exception -> L16
        goto L21
    L19:
        return;
    L10:
        e = move-exception;
        if (q(e) == true) goto L20;
        throw e;
    L20:
        return;
    L5:
        e = move-exception;
        if ("bio == null".equals(e.getMessage()) == false) goto L9;
        return;
    L9:
        throw e;
    }

    public static <T> List<T> n(List<T> r100) {
        return Collections.unmodifiableList(new ArrayList(r100));
    }

    public static <T> List<T> o(T... r100) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) r100.clone()));
    }

    public static boolean q(AssertionError r100) {
        if (r100.getCause() != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.getMessage() == null) goto L9;
        if (r100.getMessage().contains("getsockname failed") == false) goto L9;
        return true;
    }

    public static Headers v(List<gvc.a> r100) {
        Headers.Builder r101 = new Headers.Builder();
        Iterator r102 = ((ArrayList) r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        gvc.a r103 = (gvc.a) r102.next();
        OkHttpClient.a r104 = cvc.a.f465511a;
        String r105 = r103.f482850a.utf8();
        String r106 = r103.f482851b.utf8();
        r104.getClass();
        r101.addLenient(r105, r106);
        goto L4
    L7:
        return r101.build();
    }

    public static boolean x(String r100) {
        return f465531s.matcher(r100).matches();
    L4:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static AssertionError a(String r100, Exception r101) {
        AssertionError r102 = new AssertionError(r100);
        r102.initCause(r101);     // Catch: IllegalStateException -> L5
    L4:
        return r102;
    }

    public static Charset b(BufferedSource r100, Charset r101) throws IOException {
        ByteString r102 = f465517e;
        if (r100.rangeEquals(0, r102) == false) goto L6;
        r100.skip(r102.size());
        return f465522j;
    L6:
        ByteString r103 = f465518f;
        if (r100.rangeEquals(0, r103) == false) goto L10;
        r100.skip(r103.size());
        return f465524l;
    L10:
        ByteString r104 = f465519g;
        if (r100.rangeEquals(0, r104) == false) goto L14;
        r100.skip(r104.size());
        return f465525m;
    L14:
        ByteString r105 = f465520h;
        if (r100.rangeEquals(0, r105) == false) goto L18;
        r100.skip(r105.size());
        return f465526n;
    L18:
        ByteString r106 = f465521i;
        if (r100.rangeEquals(0, r106) == false) goto L22;
        r100.skip(r106.size());
        return f465527o;
    L22:
        return r101;
    }

    public static boolean k(Object r100, Object r101) {
        if (r100 == r101) goto L8;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.equals(r101) == false) goto L7;
    L8:
        return true;
    }

    public static String l(String r100, Object... r101) {
        return String.format(Locale.US, r100, r101);
    }

    public static String m(HttpUrl r100, boolean r101) {
        if (r100.host().contains(":") == false) goto L5;
        String r102 = "[" + r100.host() + "]";
    L6:
        if (r101 == true) goto L10;
        if (r100.port() != HttpUrl.defaultPort(r100.scheme())) goto L10;
        return r102;
    L10:
        return r102 + ":" + r100.port();
    L5:
        r102 = r100.host();
        goto L6
    }

    public static int d(String r100, long r101, TimeUnit r102) {
        if (r101 < 0) goto L20;
        if (r102 == null) goto L18;
        long r103 = r102.toMillis(r101);
        if (r103 > SieveCacheKt.NodeLinkMask) goto L16;
        if (r103 != 0) goto L14;
        if (r101 <= 0) goto L14;
        throw new IllegalArgumentException(r100.concat(" too small."));
    L14:
        return (int) r103;
    L16:
        throw new IllegalArgumentException(r100.concat(" too large."));
    L18:
        throw new NullPointerException("unit == null");
    L20:
        throw new IllegalArgumentException(r100.concat(" < 0"));
    }

    @Nullable
    public static InetAddress h(String r110, int r111, int r112) {
        int r100 = 16;
        byte[] r101 = new byte[16];
        int r102 = 0;
        int r103 = -1;
        int r104 = r111;
        int r105 = 0;
        int r106 = -1;
        int r107 = -1;
    L4:
        if (r104 >= r112) goto L72;
        if (r105 == r100) goto L6;
        int r113 = r104 + 2;
        if (r113 <= r112) goto L10;
    L17:
        if (r105 != 0) goto L19;
    L58:
        r107 = r104;
    L59:
        r104 = r107;
        int r108 = 0;
    L60:
        if (r104 >= r112) goto L65;
        int r109 = g(r110.charAt(r104));
        if (r109 == (-1)) goto L65;
        r108 = (r108 << 4) + r109;
        r104 = r104 + 1;
    L65:
        int r114 = r104 - r107;
        if (r114 == 0) goto L70;
        if (r114 > 4) goto L70;
        int r115 = r105 + 1;
        r101[r105] = (byte) ((r108 >>> 8) & 255);
        r105 = r115 + 1;
        r101[r115] = (byte) (r108 & 255);
        r100 = 16;
        r102 = 0;
        r103 = -1;
    L70:
        return null;
    L19:
        if (r110.regionMatches(r104, ":", r102, 1) == false) goto L22;
        r104 = r104 + 1;
        goto L58
    L22:
        if (r110.regionMatches(r104, ".", r102, 1) == false) goto L57;
        int r116 = r105 - 2;
        int r117 = r116;
    L24:
        if (r107 >= r112) goto L51;
        if (r117 == r100) goto L52;
        if (r117 != r116) goto L29;
    L32:
        int r118 = r107;
        int r119 = 0;
    L33:
        if (r118 >= r112) goto L47;
        char r120 = r110.charAt(r118);
        if (r120 < '0') goto L47;
        if (r120 > '9') goto L47;
        if (r119 != 0) goto L42;
        if (r107 != r118) goto L52;
    L42:
        r119 = ((r119 * 10) + r120) - 48;
        if (r119 > 255) goto L52;
        r118 = r118 + 1;
    L47:
        if ((r118 - r107) == 0) goto L52;
        r101[r117] = (byte) r119;
        r117 = r117 + 1;
        r107 = r118;
        r100 = 16;
        goto L24
    L29:
        if (r110.charAt(r107) != '.') goto L52;
        r107 = r107 + 1;
    L52:
        boolean r121 = false;
    L54:
        if (r121 == true) goto L56;
        return null;
    L56:
        r105 = r105 + 2;
        goto L72
    L51:
        if (r117 != (r116 + 4)) goto L52;
        r121 = true;
        goto L54
    L57:
        return null;
    L10:
        if (r110.regionMatches(r104, "::", r102, 2) == false) goto L17;
        if (r106 != r103) goto L12;
        r105 = r105 + 2;
        r106 = r105;
        if (r113 == r112) goto L72;
        r107 = r113;
        goto L59
    L12:
        return null;
    L6:
        return null;
    L72:
        if (r105 != 16) goto L74;
    L81:
        return InetAddress.getByAddress(r101);
    L80:
        throw new AssertionError();
    L74:
        if (r106 != (-1)) goto L76;
        return null;
    L76:
        int r122 = r105 - r106;
        System.arraycopy(r101, r106, r101, 16 - r122, r122);
        Arrays.fill(r101, r106, (16 - r105) + r106, (byte) 0);
        goto L81
    }

    public static String[] p(Comparator<? super String> r100, String[] r101, String[] r110) {
        ArrayList r102 = new ArrayList();
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L12;
        String r105 = r101[r104];
        int r106 = r110.length;
        int r107 = 0;
    L5:
        if (r107 >= r106) goto L10;
        if (r100.compare(r105, r110[r107]) == 0) goto L8;
        r107 = r107 + 1;
        goto L5
    L8:
        r102.add(r105);
    L10:
        r104 = r104 + 1;
        goto L3
    L12:
        return (String[]) r102.toArray(new String[r102.size()]);
    }

    public static boolean r(Comparator<String> r100, String[] r101, String[] r102) {
        if (r101 == null) goto L20;
        if (r102 == null) goto L20;
        if (r101.length == 0) goto L20;
        if (r102.length == 0) goto L20;
        int r103 = r101.length;
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L20;
        String r105 = r101[r104];
        int r106 = r102.length;
        int r107 = 0;
    L13:
        if (r107 >= r106) goto L19;
        if (r100.compare(r105, r102[r107]) == 0) goto L16;
        r107 = r107 + 1;
        goto L13
    L16:
        return true;
    L19:
        r104 = r104 + 1;
    L20:
        return false;
    }

    public static boolean s(Source r110, int r111, TimeUnit r112) throws IOException {
        long r100 = System.nanoTime();
        if (r110.timeout().f() == false) goto L5;
        long r101 = r110.timeout().d() - r100;
    L6:
        r110.timeout().e(Math.min(r101, r112.toNanos(r111)) + r100);
        Buffer r113 = new Buffer();     // Catch: Throwable -> L18 InterruptedIOException -> L24
    L9:
        if (r110.read(r113, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == (-1)) goto L13;
        r113.clear();     // Catch: Throwable -> L18 InterruptedIOException -> L24
        goto L25
    L13:
        if (r101 != Long.MAX_VALUE) goto L15;
        r110.timeout().b();
        return true;
    L15:
        r110.timeout().e(r100 + r101);
        return true;
    L18:
        th = move-exception;
        if (r101 != Long.MAX_VALUE) goto L22;
        r110.timeout().b();
    L23:
        throw th;
    L22:
        r110.timeout().e(r100 + r101);
    L25:
        if (r101 != Long.MAX_VALUE) goto L27;
        r110.timeout().b();
        return false;
    L27:
        r110.timeout().e(r100 + r101);
        return false;
    L5:
        r101 = Long.MAX_VALUE;
        goto L6
    }

    public static int t(String r100, int r101, int r102) {
    L2:
        if (r101 >= r102) goto L15;
        char r103 = r100.charAt(r101);
        if (r103 == '\t') goto L14;
        if (r103 == '\n') goto L14;
        if (r103 == '\f') goto L14;
        if (r103 == '\r') goto L14;
        if (r103 == ' ') goto L14;
        return r101;
    L14:
        r101 = r101 + 1;
        goto L2
    L15:
        return r102;
    }

    public static int u(String r100, int r101, int r102) {
        int r103 = r102 - 1;
    L3:
        if (r103 < r101) goto L17;
        char r104 = r100.charAt(r103);
        if (r104 == '\t') goto L16;
        if (r104 == '\n') goto L16;
        if (r104 == '\f') goto L16;
        if (r104 == '\r') goto L16;
        if (r104 == ' ') goto L16;
        return r103 + 1;
    L16:
        r103 = r103 - 1;
        goto L3
    L17:
        return r101;
    }

    public static String w(String r100, int r101, int r102) {
        int r103 = t(r100, r101, r102);
        return r100.substring(r103, u(r100, r103, r102));
    }

    public static int i(String r100, int r101, int r102, char r103) {
    L2:
        if (r101 >= r102) goto L7;
        if (r100.charAt(r101) == r103) goto L5;
        r101 = r101 + 1;
        goto L2
    L5:
        return r101;
    L7:
        return r102;
    }

    public static int j(String r100, int r101, int r102, String r103) {
    L2:
        if (r101 >= r102) goto L7;
        if (r103.indexOf(r100.charAt(r101)) != (-1)) goto L5;
        r101 = r101 + 1;
        goto L2
    L5:
        return r101;
    L7:
        return r102;
    }
}
