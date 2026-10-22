package okio;

import com.byted.cast.common.Constants;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.internal.ZipFilesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"okio/Okio__JvmOkioKt", "okio/Okio__OkioKt", "okio/Okio__ZlibOkioKt"}, k = 4, mv = {1, 9, 0}, xi = 48)
public final class Okio {
    public static final Sink blackhole() {
        return new f();
    }

    public static final Sink appendingSink(File r100) throws FileNotFoundException {
        Logger r101 = y.f524114a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return sink(new PolarisFileOutputStreamWrapper(r100, true));
    }

    public static final l asResourceFileSystem(ClassLoader r100) {
        Logger r101 = y.f524114a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new okio.internal.f(r100, true);
    }

    public static final BufferedSink buffer(Sink r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new e0(r100);
    }

    public static final boolean isAndroidGetsocknameError(AssertionError r100) {
        Logger r101 = y.f524114a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getCause() == null) goto L11;
        String r102 = r100.getMessage();
        if (r102 == null) goto L7;
        boolean r103 = StringsKt.contains$default(r102, "getsockname failed", false, 2, null);
    L8:
        if (r103 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r103 = false;
        goto L8
    L11:
        return false;
    }

    public static final Sink sink(Socket r100) throws IOException {
        Logger r101 = y.f524114a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        i0 r102 = new i0(r100);
        a0 r103 = new a0(r100.getOutputStream(), r102);
        Intrinsics.checkNotNullParameter(r103, Constants.ROLE_SINK);
        return new d(r102, r103);
    }

    public static final Source source(Socket r100) throws IOException {
        Logger r101 = y.f524114a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        i0 r102 = new i0(r100);
        u r103 = new u(r100.getInputStream(), r102);
        Intrinsics.checkNotNullParameter(r103, "source");
        return new e(r102, r103);
    }

    public static final BufferedSource buffer(Source r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new f0(r100);
    }

    public static final Sink sink(OutputStream r100) {
        Logger r101 = y.f524114a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new a0(r100, new j0());
    }

    public static final Source source(File r100) throws FileNotFoundException {
        Logger r101 = y.f524114a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new u(new PolarisFileInputStreamWrapper(r100), j0.f524073d);
    }

    public static final Sink sink(File r100) throws FileNotFoundException {
        Logger r101 = y.f524114a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return sink$default(r100, false, 1, null);
    }

    public static final Source source(InputStream r100) {
        Logger r101 = y.f524114a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new u(r100, new j0());
    }

    public static final g cipherSink(Sink r100, Cipher r101) {
        Logger r102 = y.f524114a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "cipher");
        return new g(buffer(r100), r101);
    }

    public static final h cipherSource(Source r100, Cipher r101) {
        Logger r102 = y.f524114a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "cipher");
        return new h(buffer(r100), r101);
    }

    public static final r hashingSink(Sink r100, MessageDigest r101) {
        Logger r102 = y.f524114a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "digest");
        return new r(r100, r101);
    }

    public static final s hashingSource(Source r100, MessageDigest r101) {
        Logger r102 = y.f524114a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "digest");
        return new s(r100, r101);
    }

    public static final l openZip(l r100, b0 r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "zipPath");
        return ZipFilesKt.d(r101, r100);
    }

    public static final Sink sink(Path r100, OpenOption... r101) throws IOException {
        Logger r102 = y.f524114a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "options");
        return sink(Files.newOutputStream(r100, (OpenOption[]) Arrays.copyOf(r101, r101.length)));
    }

    public static final Source source(Path r100, OpenOption... r101) throws IOException {
        Logger r102 = y.f524114a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "options");
        return source(Files.newInputStream(r100, (OpenOption[]) Arrays.copyOf(r101, r101.length)));
    }

    public static final <T extends Closeable, R> R use(T r100, Function1<? super T, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        Throwable th10 = null;
        R r102 = r101.invoke(r100);     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        if (r100 != null) goto L23;
    L9:
        InlineMarker.finallyEnd(1);
    L18:
        if (th10 != null) goto L20;
        return r102;
    L20:
        throw th10;
    L23:
        r100.close();     // Catch: Throwable -> L8
    L8:
        th10 = th;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (r100 != null) goto L21;
    L17:
        InlineMarker.finallyEnd(1);
        th10 = th;
        r102 = null;
        goto L18
    L21:
        r100.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);
        goto L17
    }

    public static final r hashingSink(Sink r100, Mac r101) {
        Logger r102 = y.f524114a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "mac");
        return new r(r100, r101);
    }

    public static final s hashingSource(Source r100, Mac r101) {
        Logger r102 = y.f524114a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "mac");
        return new s(r100, r101);
    }

    public static final Sink sink(File r100, boolean r101) throws FileNotFoundException {
        Logger r102 = y.f524114a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return sink(new PolarisFileOutputStreamWrapper(r100, r101));
    }

    public static /* synthetic */ Sink sink$default(File r100, boolean r101, int r102, Object r103) throws FileNotFoundException {
        Logger r104 = y.f524114a;
        if ((r102 & 1) == 0) goto L6;
        r101 = false;
    L6:
        return sink(r100, r101);
    }
}
