package n58;

import android.media.AudioRecord;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.audio.audiov3.task.asr.AsrDataSourceState;
import java.io.BufferedInputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c implements h68.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f518042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f518043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BufferedInputStream f518044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f518045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f518046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f518047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AsrDataSourceState f518048g;

    public static final class a {
    }

    static {
    }

    @Override // h68.c
    public final h68.a release() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        BufferedInputStream r101 = this.f518044c;     // Catch: Throwable -> L8
        if (r101 == null) goto L6;
        r101.close();     // Catch: Throwable -> L8
    L6:
        this.f518044c = null;     // Catch: Throwable -> L8
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        this.f518048g = AsrDataSourceState.UNINITIALIZED;
        return new h68.a.b(null);
    L8:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // h68.c
    public final int b() {
        return AudioRecord.getMinBufferSize(16000, 16, 2);
    }

    @Override // h68.c
    public final h68.a prepare() {
        int r100 = c68.b.f22600a;
        c68.b.d("HookAsrDataSource", "[ASR][onPrepare]: fileDirPath=" + this.f518042a + ", fileName=" + this.f518043b);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        PolarisFileWrapper r102 = new PolarisFileWrapper(this.f518042a, this.f518043b);     // Catch: Throwable -> L9
        if (r102.exists() == true) goto L7;
        c68.b.b("HookAsrDataSource", "[ASR][onPrepare]: file not found");     // Catch: Throwable -> L9
        return new h68.a.C6106a(-1001, "file not found", null);
    L7:
        this.f518044c = new BufferedInputStream(new PolarisFileInputStreamWrapper(r102));     // Catch: Throwable -> L9
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L15;
        c68.b.c("HookAsrDataSource", "[ASR][onPrepare]: file open failed", r104);
        return new h68.a.C6106a(-1002, r104.getMessage(), null);
    L15:
        this.f518048g = AsrDataSourceState.INITIALIZED;
        return new h68.a.b(null);
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // h68.c
    public final h68.a stop() {
        this.f518048g = AsrDataSourceState.STOPPED;
        return new h68.a.b(null);
    }

    @Override // h68.c
    public final h68.a start() {
        this.f518045d = System.currentTimeMillis();
        this.f518048g = AsrDataSourceState.STARTED;
        return new h68.a.b(null);
    }

    @Override // h68.c
    public final AsrDataSourceState a() {
        return this.f518048g;
    }

    @Override // h68.c
    public final h68.a read(byte[] r110) {
        Intrinsics.checkNotNullParameter(r110, "buffer");
        int r100 = c68.b.f22600a;
        c68.b.d("HookAsrDataSource", "[ASR][read]: read(fileDirPath=" + this.f518042a + ", fileName=" + this.f518043b + ")...");
        BufferedInputStream r101 = this.f518044c;
        if (r101 == null) goto L5;
        int r111 = r101.read(r110);     // Catch: Throwable -> L18
        if (r111 == (-1)) goto L9;
    L11:
        if (r111 <= 0) goto L13;
        this.f518047f += (long) r111;     // Catch: Throwable -> L18
    L13:
        long r102 = ((((long) 1000) * this.f518047f) / ((long) 32000)) - (System.currentTimeMillis() - this.f518045d);     // Catch: Throwable -> L18
        if (r102 <= 0) goto L16;
        Thread.sleep(r102);     // Catch: Throwable -> L18
    L16:
        return new h68.a.b(Integer.valueOf(r111));
    L9:
        if (this.f518046e != 0) goto L11;
        this.f518046e = System.currentTimeMillis();     // Catch: Throwable -> L18
        c68.b.d("StartHookOnceService", "readDuration: " + (this.f518046e - this.f518045d) + "ms");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        return new h68.a.C6106a(-1004, th.getMessage(), null);
    L5:
        return new h68.a.C6106a(-1003, "input stream not found", null);
    }

    public c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "fileDirPath");
        Intrinsics.checkNotNullParameter(r101, "fileName");
        this.f518042a = r100;
        this.f518043b = r101;
        this.f518048g = AsrDataSourceState.UNINITIALIZED;
    }
}
