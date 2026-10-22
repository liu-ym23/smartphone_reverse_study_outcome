package okhttp3.internal.publicsuffix;

import com.miui.easygo.constant.EasyGoConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import cvc.c;
import hvc.g;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.UByte;
import okio.BufferedSource;
import okio.Okio;
import okio.q;

/* JADX INFO: loaded from: classes6.dex */
public final class PublicSuffixDatabase {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f523911e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f523912f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f523913g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final PublicSuffixDatabase f523914h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f523915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CountDownLatch f523916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f523917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f523918d;

    static {
        f523911e = new byte[]{42};
        f523912f = new String[0];
        f523913g = new String[]{"*"};
        f523914h = new PublicSuffixDatabase();
    }

    public final void c() throws IOException {
        InputStream r100 = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (r100 != null) goto L5;
        return;
    L5:
        BufferedSource r101 = Okio.buffer(new q(Okio.source(r100)));
        byte[] r102 = new byte[r101.readInt()];     // Catch: Throwable -> L16
        r101.readFully(r102);     // Catch: Throwable -> L16
        byte[] r103 = new byte[r101.readInt()];     // Catch: Throwable -> L16
        r101.readFully(r103);     // Catch: Throwable -> L16
        c.e(r101);
        monitor-enter(this);
        this.f523917c = r102;     // Catch: Throwable -> L13
        this.f523918d = r103;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        this.f523916b.countDown();
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        c.e(r101);
        throw th;
    }

    public PublicSuffixDatabase() {
        this.f523915a = new AtomicBoolean(false);
        this.f523916b = new CountDownLatch(1);
    }

    public final String b(String r110) {
        if (r110 == null) goto L95;
        String[] r100 = IDN.toUnicode(r110).split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (this.f523915a.get() == false) goto L6;
    L99:
        this.f523916b.await();     // Catch: InterruptedException -> L24
    L25:
        monitor-enter(this);
    L91:
        th = move-exception;
        throw th;
    L27:
        if (this.f523917c == null) goto L90;
        monitor-exit(this);     // Catch: Throwable -> L91
        int r101 = r100.length;
        byte[][] r102 = new byte[r101][];
        int r103 = 0;
    L31:
        if (r103 >= r100.length) goto L33;
        r102[r103] = r100[r103].getBytes(c.f465522j);
        r103 = r103 + 1;
        goto L31
    L33:
        int r104 = 0;
    L35:
        if (r104 >= r101) goto L40;
        String r105 = a(this.f523917c, r102, r104);
        if (r105 != null) goto L41;
        r104 = r104 + 1;
    L41:
        if (r101 <= 1) goto L49;
        byte[][] r106 = (byte[][]) r102.clone();
        int r107 = 0;
    L44:
        if (r107 >= (r106.length - 1)) goto L49;
        r106[r107] = f523911e;
        String r108 = a(this.f523917c, r106, r107);
        if (r108 != null) goto L50;
        r107 = r107 + 1;
    L50:
        if (r108 == null) goto L58;
        int r109 = 0;
    L53:
        if (r109 >= (r101 - 1)) goto L58;
        String r111 = a(this.f523918d, r102, r109);
        if (r111 != null) goto L59;
        r109 = r109 + 1;
    L59:
        if (r111 == null) goto L61;
        String[] r112 = "!".concat(r111).split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
    L75:
        if (r100.length != r112.length) goto L80;
        if (r112[0].charAt(0) == '!') goto L80;
        return null;
    L80:
        if (r112[0].charAt(0) != '!') goto L82;
        int r113 = r100.length;
        int r114 = r112.length;
    L83:
        int r115 = r113 - r114;
        StringBuilder r116 = new StringBuilder();
        String[] r117 = r110.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
    L85:
        if (r115 >= r117.length) goto L87;
        r116.append(r117[r115]);
        r116.append('.');
        r115 = r115 + 1;
        goto L85
    L87:
        r116.deleteCharAt(r116.length() - 1);
        return r116.toString();
    L82:
        r113 = r100.length;
        r114 = r112.length + 1;
        goto L83
    L61:
        if (r105 != null) goto L64;
        if (r108 != null) goto L64;
        r112 = f523913g;
    L64:
        if (r105 == null) goto L66;
        r112 = r105.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
    L67:
        if (r108 == null) goto L69;
        String[] r118 = r108.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
    L71:
        if (r112.length > r118.length) goto L75;
        r112 = r118;
        goto L75
    L69:
        r118 = f523912f;
        goto L71
    L66:
        r112 = f523912f;
    L58:
        r111 = null;
    L49:
        r108 = null;
        goto L50
    L40:
        r105 = null;
        goto L41
    L90:
        throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");     // Catch: Throwable -> L91
    L24:
        ThreadMethodProxy.currentThread().interrupt();
        goto L25
    L6:
        if (this.f523915a.compareAndSet(false, true) == false) goto L99;
        boolean r119 = false;
    L97:
        c();     // Catch: Throwable -> L11 IOException -> L13 InterruptedIOException -> L17
    L9:
        if (r119 == false) goto L25;
    L16:
        ThreadMethodProxy.currentThread().interrupt();
    L11:
        th = move-exception;
        if (r119 == false) goto L21;
        ThreadMethodProxy.currentThread().interrupt();
    L21:
        throw th;
    L17:
        Thread.interrupted();     // Catch: Throwable -> L11
        r119 = true;
    L13:
        e = move-exception;
        g.f487396a.m(5, "Failed to read public suffix list", e);     // Catch: Throwable -> L11
        if (r119 == false) goto L25;
    L95:
        throw new NullPointerException("domain == null");
    }

    public static String a(byte[] r110, byte[][] r111, int r112) {
        int r100 = r110.length;
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L43;
        int r102 = (r101 + r100) / 2;
    L6:
        if (r102 <= (-1)) goto L10;
        if (r110[r102] == 10) goto L10;
        r102 = r102 - 1;
    L10:
        int r103 = r102 + 1;
        int r104 = 1;
    L11:
        int r113 = r103 + r104;
        if (r110[r113] == 10) goto L14;
        r104 = r104 + 1;
        goto L11
    L14:
        int r105 = r113 - r103;
        int r114 = r112;
        boolean r106 = false;
        int r115 = 0;
        int r116 = 0;
    L15:
        if (r106 == false) goto L17;
        int r107 = 46;
        boolean r117 = false;
    L18:
        int r108 = r107 - (r110[r103 + r116] & UByte.MAX_VALUE);
        if (r108 != 0) goto L28;
        r116 = r116 + 1;
        r115 = r115 + 1;
        if (r116 == r105) goto L28;
        if (r111[r114].length == r115) goto L27;
        r106 = r117;
        goto L15
    L27:
        if (r114 == (r111.length - 1)) goto L28;
        r114 = r114 + 1;
        r106 = true;
        r115 = -1;
    L28:
        if (r108 < 0) goto L37;
        if (r108 > 0) goto L39;
        int r109 = r105 - r116;
        int r118 = r111[r114].length - r115;
    L33:
        r114 = r114 + 1;
        if (r114 >= r111.length) goto L36;
        r118 = r118 + r111[r114].length;
        goto L33
    L36:
        if (r118 < r109) goto L37;
        if (r118 > r109) goto L39;
        return new String(r110, r103, r105, c.f465522j);
    L39:
        r101 = r113 + 1;
    L37:
        r100 = r103 - 1;
        goto L3
    L17:
        r117 = r106;
        r107 = r111[r114][r115] & UByte.MAX_VALUE;
        goto L18
    L43:
        return null;
    }
}
