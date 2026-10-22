package com.larus.audio.asr;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.larus.asr.u2;
import com.larus.audio.audiov3.task.asr.AsrDataSourceState;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.ByteArrayOutputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class t0 implements h68.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f288473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h68.c f288474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f288475c;

    @Override // h68.c
    public final AsrDataSourceState a() {
        return this.f288474b.a();
    }

    @Override // h68.c
    public final int b() {
        return this.f288474b.b();
    }

    @Override // h68.c
    public final h68.a prepare() {
        return this.f288474b.prepare();
    }

    @Override // h68.c
    public final h68.a release() {
        h68.a r100 = this.f288474b.release();
        a r101 = (a) this.f288475c.getValue();
        Object r102 = r101.f288355d;
        monitor-enter(r102);
        int r103 = c68.b.f22600a;     // Catch: Throwable -> L26
        c68.b.d("AsrAudioFileStore", "[release][" + r101.f288353b + "][" + r101.f288352a + ']');     // Catch: Throwable -> L26
        boolean r104 = r101.a();     // Catch: Throwable -> L26
        Unit r105 = null;
        if (r101.f288354c != null) goto L7;
    L10:
        Boolean r106 = null;
    L11:
        monitor-exit(r102);
        if (r106 == null) goto L25;
        boolean r107 = r106.booleanValue();
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L19
        Function1<Boolean, Unit> r109 = r101.f288354c;     // Catch: Throwable -> L19
        if (r109 == null) goto L17;
        r109.invoke(Boolean.valueOf(r107));     // Catch: Throwable -> L19
        r105 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L17:
        Object r110 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L19
    L21:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 == null) goto L24;
        int r112 = c68.b.f22600a;
        c68.b.c("AsrAudioFileStore", "[" + r101.f288353b + "] notify audio file save result failed", r111);
    L24:
        Result.m9448boximpl(r110);
    L19:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L25:
        return r100;
    L7:
        if (r101.f288357f == true) goto L10;
        r101.f288357f = true;     // Catch: Throwable -> L26
        r106 = Boolean.valueOf(r104);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    @Override // h68.c
    public final h68.a start() {
        h68.a r100 = this.f288474b.start();
        if ((r100 instanceof h68.a.b) == false) goto L15;
        a r101 = (a) this.f288475c.getValue();
        Object r102 = r101.f288355d;
        monitor-enter(r102);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (r101.f288356e != null) goto L9;
        int r103 = c68.b.f22600a;     // Catch: Throwable -> L12
        c68.b.d("AsrAudioFileStore", "[prepareForStart][" + r101.f288353b + "][" + r101.f288352a + ']');     // Catch: Throwable -> L12
        r101.f288356e = new ByteArrayOutputStream();     // Catch: Throwable -> L12
    L9:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r102);
    L15:
        return r100;
    }

    @Override // h68.c
    public final h68.a stop() {
        return this.f288474b.stop();
    }

    @Override // h68.c
    public final h68.a read(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        h68.a r101 = this.f288474b.read(r100);
        if ((r101 instanceof h68.a.b) == false) goto L5;
        h68.a.b r102 = (h68.a.b) r101;
    L6:
        if (r102 == null) goto L29;
        Integer r103 = r102.f483926a;
        if (r103 == null) goto L29;
        int r104 = r103.intValue();
        if (r104 <= 0) goto L29;
        a r105 = (a) this.f288475c.getValue();
        r105.getClass();
        Intrinsics.checkNotNullParameter(r100, "data");
        Object r106 = r105.f288355d;
        monitor-enter(r106);
        ByteArrayOutputStream r107 = r105.f288356e;     // Catch: Throwable -> L26
        if (r107 != null) goto L30;
        monitor-exit(r106);
        goto L29
    L30:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L19
        r107.write(r100, 0, r104);     // Catch: Throwable -> L19
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L26
        if (r110 == null) goto L24;
        int r111 = c68.b.f22600a;     // Catch: Throwable -> L26
        c68.b.c("AsrAudioFileStore", "[writeFrame] [" + r105.f288353b + "] write retryable audio file failed path=" + r105.f288352a, r110);     // Catch: Throwable -> L26
    L24:
        monitor-exit(r106);
        goto L29
    L19:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L26
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L29:
        return r101;
    L5:
        r102 = null;
        goto L6
    }

    public t0(String r100, h68.c r101, final String r102, final u2 r103) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r102, "filePath");
        this.f288473a = r100;
        this.f288474b = r101;
        this.f288475c = LazyKt.lazy(new s0(r102, this, r103));
    }
}
