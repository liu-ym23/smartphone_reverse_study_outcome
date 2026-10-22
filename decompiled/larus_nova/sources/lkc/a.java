package lkc;

import com.alipay.sdk.m.p.e;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.crypto.utils.CryptoConst;
import com.ss.android.lark.log.Log;
import ikc.f;
import java.io.File;
import java.io.FileInputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class a extends FileInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<String, Unit> f509644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f509645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f509646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Cipher f509647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SecretKey f509648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IvParameterSpec f509649f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f509650g;

    /* JADX INFO: renamed from: lkc.a$a, reason: collision with other inner class name */
    public static final class C6705a {
    }

    static {
    }

    public final boolean a() {
        if (this.f509646c == false) goto L5;
    L14:
        return true;
    L5:
        if (this.f509647d == null) goto L14;
        if (this.f509648e == null) goto L14;
        if (this.f509649f == null) goto L14;
        if (this.f509650g <= 0) goto L14;
        return false;
    }

    @Override // java.io.FileInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f509644a.invoke(this.f509645b);     // Catch: Exception -> L4
        super.close();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        c(e, "DecryptClose");
        b("close", e);
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public final int available() {
        return super.available();
    L4:
        e = move-exception;
        c(e, "DecryptAvailable");
        b("available", e);
        return 0;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        if (a() == true) goto L5;
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L9
        r100.put("tag", "stream");     // Catch: Exception -> L9
        r100.put("scene", "markSupported");     // Catch: Exception -> L9
        f.f490295a.f490294c.sendEvent("disk_file_cipher_error");     // Catch: Exception -> L9
        return false;
    L12:
        return false;
    L5:
        return super.markSupported();
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public final int read() {
        if (a() == true) goto L5;
        int r100 = -1;
        byte[] r101 = new byte[1];     // Catch: Exception -> L12
        r100 = read(r101);     // Catch: Exception -> L12
        if (r100 <= 0) goto L14;
        return r101[0] & UByte.MAX_VALUE;
    L14:
        return r100;
    L12:
        e = move-exception;
        c(e, "DecryptRead");
        b("read", e);
        goto L14
    L5:
        return super.read();
    }

    @Override // java.io.InputStream
    public final void reset() {
        if (a() == false) goto L9;
        super.reset();
        return;
    L9:
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L8
        r100.put("tag", "stream");     // Catch: Exception -> L8
        r100.put("scene", BasicTestActionHandler.TEST_ACTION_RESET);     // Catch: Exception -> L8
        f.f490295a.f490294c.sendEvent("disk_file_cipher_error");     // Catch: Exception -> L8
        return;
    }

    @Override // java.io.InputStream
    public final void mark(int r100) {
        if (a() == false) goto L9;
        super.mark(r100);
        return;
    L9:
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L8
        r101.put("tag", "stream");     // Catch: Exception -> L8
        r101.put("scene", "mark");     // Catch: Exception -> L8
        f.f490295a.f490294c.sendEvent("disk_file_cipher_error");     // Catch: Exception -> L8
        return;
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public final int read(byte[] r100) {
        if (a() == false) goto L30;
        if (r100 == null) goto L6;
        int r101 = r100.length;
    L8:
        return super.read(r100, 0, r101);
    L6:
        r101 = 0;
        goto L8
    L30:
        long r102 = getChannel().position() - this.f509650g;     // Catch: Exception -> L27
        int r103 = com.ss.lark.android.encryption.utils.a.f456826a;     // Catch: Exception -> L27
        com.ss.lark.android.encryption.utils.a.a(this.f509647d, this.f509648e, this.f509649f, r102);     // Catch: Exception -> L27
        if (r100 == null) goto L12;
        int r104 = r100.length;     // Catch: Exception -> L27
    L13:
        int r105 = super.read(r100, 0, r104);     // Catch: Exception -> L27
        if (r105 >= 1) goto L16;
        return r105;
    L16:
        Cipher r106 = this.f509647d;     // Catch: Exception -> L27
        if (r106 == null) goto L19;
        byte[] r107 = r106.doFinal(r100, 0, r105);     // Catch: Exception -> L27
    L20:
        if (r107 == null) goto L22;
        int r108 = r107.length;     // Catch: Exception -> L27
    L23:
        System.arraycopy(r107, 0, r100, 0, r108);     // Catch: Exception -> L27
        if (r107 == null) goto L32;
        return r107.length;
    L32:
        return 0;
    L22:
        r108 = 0;
        goto L23
    L19:
        r107 = null;
        goto L20
    L12:
        r104 = 0;
    L27:
        e = move-exception;
        c(e, "DecryptRead");
        b("read", e);
        return -1;
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public final long skip(long r110) {
        if (a() == false) goto L7;
        return super.skip(r110);
    L7:
        if (r110 < 0) goto L16;
    L11:
        return super.skip(r110);
    L13:
        e = move-exception;
        c(e, "DecryptSkip");
        b("skip", e);
        return 0;
    L16:
        long r100 = getChannel().position();     // Catch: Exception -> L13
        long r101 = r100 + r110;     // Catch: Exception -> L13
        long r102 = this.f509650g;     // Catch: Exception -> L13
        if (r101 >= r102) goto L11;
        r110 = r102 - r100;     // Catch: Exception -> L13
        goto L11
    }

    public static void b(String r100, Exception r101) {
        ikc.a.a(f.f490295a.f490293b, "scs_file_stream_encryption", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("scene", "IO"), TuplesKt.to(e.f25671s, r100), TuplesKt.to(LBSLightLocationTraceLogger.ENCRYPT, Boolean.FALSE), TuplesKt.to("error_code", -101), TuplesKt.to("error_msg", r101)}), null, 0, 28);
    }

    public final void c(Exception r100, String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L5
        r102.put("tag", "stream_exception");     // Catch: Exception -> L5
        r102.put("scene", r101);     // Catch: Exception -> L5
        r102.put("msg", r100.getMessage());     // Catch: Exception -> L5
        f.f490295a.f490294c.sendEvent("disk_file_cipher_error");     // Catch: Exception -> L5
        Log.e("StreamCipherInputStream", "file path:" + this.f509645b + ", error message:" + r100.getMessage());     // Catch: Exception -> L5
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(File r100, kkc.a r101, Function1<? super String, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "file");
        Intrinsics.checkNotNullParameter(r102, "onRelease");
        super(r100);
        this.f509644a = r102;
        this.f509645b = "";
        this.f509646c = true;
        this.f509645b = r100.getPath();
        if (r101 == null) goto L19;
    L12:
        e = move-exception;
        c(e, "DecryptOpen");
        b("openFile", e);
        return;
    L6:
        if (r101.f503831a == false) goto L10;
        this.f509646c = false;     // Catch: Exception -> L12
        this.f509647d = Cipher.getInstance("AES/CTR/NoPadding");     // Catch: Exception -> L12
        this.f509648e = new SecretKeySpec(r101.f503832b, CryptoConst.ALGORITHM_AES);     // Catch: Exception -> L12
        this.f509649f = new IvParameterSpec(r101.f503833c);     // Catch: Exception -> L12
        long r103 = r101.f503834d;     // Catch: Exception -> L12
        this.f509650g = r103;     // Catch: Exception -> L12
        if (r103 <= 0) goto L15;
        getChannel().position(this.f509650g);     // Catch: Exception -> L12
    L15:
        return;
    L10:
        this.f509646c = true;     // Catch: Exception -> L12
        goto L15
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public final int read(byte[] r100, int r101, int r102) {
        if (a() == true) goto L5;
        r100.getClass();
        int r103 = -1;
        byte[] r104 = new byte[r102];     // Catch: Exception -> L11
        r103 = read(r104);     // Catch: Exception -> L11
        if (r103 <= 0) goto L13;
        System.arraycopy(r104, 0, r100, r101, r103);     // Catch: Exception -> L11
        return r103;
    L13:
        return r103;
    L11:
        e = move-exception;
        c(e, "DecryptRead");
        b("read", e);
        goto L13
    L5:
        return super.read(r100, r101, r102);
    }
}
