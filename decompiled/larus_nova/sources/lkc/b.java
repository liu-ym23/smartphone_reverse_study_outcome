package lkc;

import com.alipay.sdk.m.p.e;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.crypto.utils.CryptoConst;
import com.ss.android.lark.log.Log;
import ikc.f;
import java.io.File;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class b extends FileOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<String, Unit> f509651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f509652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f509653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Cipher f509654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SecretKey f509655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IvParameterSpec f509656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f509657g;

    public static final class a {
    }

    static {
    }

    public final boolean a() {
        if (this.f509653c == false) goto L5;
    L14:
        return true;
    L5:
        if (this.f509654d == null) goto L14;
        if (this.f509655e == null) goto L14;
        if (this.f509656f == null) goto L14;
        if (this.f509657g <= 0) goto L14;
        return false;
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f509651a.invoke(this.f509652b);     // Catch: Exception -> L4
        super.close();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        c(e, "EncryptClose");
        b("close", e);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        super.flush();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        c(e, "EncryptFlush");
        b("flush", e);
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream
    public final void write(int r100) {
        if (a() == false) goto L18;
        super.write(new byte[]{(byte) r100}, 0, 1);
        return;
    L18:
        byte[] r101 = {(byte) r100};     // Catch: Exception -> L15
        long r102 = getChannel().position() - this.f509657g;     // Catch: Exception -> L15
        int r103 = com.ss.lark.android.encryption.utils.a.f456826a;     // Catch: Exception -> L15
        com.ss.lark.android.encryption.utils.a.a(this.f509654d, this.f509655e, this.f509656f, r102);     // Catch: Exception -> L15
        Cipher r104 = this.f509654d;     // Catch: Exception -> L15
        if (r104 == null) goto L9;
        byte[] r105 = r104.doFinal(r101, 0, 1);     // Catch: Exception -> L15
    L10:
        if (r105 == null) goto L12;
        int r106 = r105.length;     // Catch: Exception -> L15
    L13:
        super.write(r105, 0, r106);     // Catch: Exception -> L15
        return;
    L12:
        r106 = 0;
        goto L13
    L9:
        r105 = null;
    L15:
        e = move-exception;
        c(e, "EncryptWrite");
        b("write", e);
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream
    public final void write(byte[] r100) {
        if (a() == false) goto L9;
        if (r100 == null) goto L6;
        int r101 = r100.length;
    L7:
        super.write(r100, 0, r101);
        return;
    L6:
        r101 = 0;
        goto L7
    L9:
        r100.getClass();
        long r102 = getChannel().position() - this.f509657g;     // Catch: Exception -> L19
        int r103 = com.ss.lark.android.encryption.utils.a.f456826a;     // Catch: Exception -> L19
        com.ss.lark.android.encryption.utils.a.a(this.f509654d, this.f509655e, this.f509656f, r102);     // Catch: Exception -> L19
        Cipher r104 = this.f509654d;     // Catch: Exception -> L19
        if (r104 == null) goto L13;
        byte[] r105 = r104.doFinal(r100, 0, r100.length);     // Catch: Exception -> L19
    L14:
        if (r105 == null) goto L16;
        int r106 = r105.length;     // Catch: Exception -> L19
    L17:
        super.write(r105, 0, r106);     // Catch: Exception -> L19
        return;
    L16:
        r106 = 0;
        goto L17
    L13:
        r105 = null;
    L19:
        e = move-exception;
        c(e, "EncryptWrite");
        b("write", e);
    }

    public static void b(String r100, Exception r101) {
        ikc.a.a(f.f490295a.f490293b, "scs_file_stream_encryption", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("scene", "IO"), TuplesKt.to(e.f25671s, r100), TuplesKt.to(LBSLightLocationTraceLogger.ENCRYPT, Boolean.TRUE), TuplesKt.to("error_code", -101), TuplesKt.to("error_msg", r101)}), null, 0, 28);
    }

    public final void c(Exception r100, String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L5
        r102.put("tag", "stream_exception");     // Catch: Exception -> L5
        r102.put("scene", r101);     // Catch: Exception -> L5
        r102.put("msg", r100.getMessage());     // Catch: Exception -> L5
        f.f490295a.f490294c.sendEvent("disk_file_cipher_error");     // Catch: Exception -> L5
        Log.e("StreamCipherOutputStream", "file path:" + this.f509652b + ", error message:" + r100.getMessage());     // Catch: Exception -> L5
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(File r100, kkc.a r101, Function1<? super String, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "file");
        Intrinsics.checkNotNullParameter(r102, "onRelease");
        super(r100, true);
        this.f509651a = r102;
        this.f509652b = "";
        this.f509653c = true;
        this.f509652b = r100.getPath();
        if (r101 == null) goto L19;
    L12:
        e = move-exception;
        c(e, "EncryptOpen");
        b("openFile", e);
        return;
    L6:
        if (r101.f503831a == false) goto L10;
        this.f509653c = false;     // Catch: Exception -> L12
        this.f509654d = Cipher.getInstance("AES/CTR/NoPadding");     // Catch: Exception -> L12
        this.f509655e = new SecretKeySpec(r101.f503832b, CryptoConst.ALGORITHM_AES);     // Catch: Exception -> L12
        this.f509656f = new IvParameterSpec(r101.f503833c);     // Catch: Exception -> L12
        long r103 = r101.f503834d;     // Catch: Exception -> L12
        this.f509657g = r103;     // Catch: Exception -> L12
        if (r103 <= 0) goto L15;
        getChannel().position(this.f509657g);     // Catch: Exception -> L12
    L15:
        return;
    L10:
        this.f509653c = true;     // Catch: Exception -> L12
        goto L15
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream
    public final void write(byte[] r100, int r101, int r102) {
        if (a() == false) goto L6;
        super.write(r100, r101, r102);
        return;
    L6:
        r100.getClass();
        byte[] r103 = new byte[r102];     // Catch: Exception -> L16
        System.arraycopy(r100, r101, r103, 0, r102);     // Catch: Exception -> L16
        long r104 = getChannel().position() - this.f509657g;     // Catch: Exception -> L16
        int r105 = com.ss.lark.android.encryption.utils.a.f456826a;     // Catch: Exception -> L16
        com.ss.lark.android.encryption.utils.a.a(this.f509654d, this.f509655e, this.f509656f, r104);     // Catch: Exception -> L16
        Cipher r106 = this.f509654d;     // Catch: Exception -> L16
        if (r106 == null) goto L10;
        byte[] r107 = r106.doFinal(r103, 0, r102);     // Catch: Exception -> L16
    L11:
        if (r107 == null) goto L13;
        int r108 = r107.length;     // Catch: Exception -> L16
    L14:
        super.write(r107, 0, r108);     // Catch: Exception -> L16
        return;
    L13:
        r108 = 0;
        goto L14
    L10:
        r107 = null;
    L16:
        e = move-exception;
        c(e, "EncryptWrite");
        b("write", e);
    }
}
