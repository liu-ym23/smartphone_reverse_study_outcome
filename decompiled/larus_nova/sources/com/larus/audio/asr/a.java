package com.larus.audio.asr;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.business.debug.base.audio.module.ASRModule;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.ByteArrayOutputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f288352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f288353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Boolean, Unit> f288354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f288355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ByteArrayOutputStream f288356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f288357f;

    /* JADX INFO: renamed from: com.larus.audio.asr.a$a, reason: collision with other inner class name */
    public static final class C3955a {
    }

    static {
    }

    public final boolean a() {
        ByteArrayOutputStream r100 = this.f288356e;
        if (r100 != null) goto L44;
        return false;
    L44:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        String r102 = b68.b.h(b68.b.f17861a, this.f288352a, r100);     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r102, "result");     // Catch: Throwable -> L8
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(Intrinsics.areEqual(r102, "SUCCESS")));     // Catch: Throwable -> L8
    L10:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);     // Catch: Throwable -> L34
        if (r104 == null) goto L14;
        int r105 = c68.b.f22600a;     // Catch: Throwable -> L34
        c68.b.c("AsrAudioFileStore", "[" + this.f288353b + "] close retryable audio file failed path=" + this.f288352a, r104);     // Catch: Throwable -> L34
    L14:
        Boolean r106 = Boolean.FALSE;     // Catch: Throwable -> L34
        if (Result.m9455isFailureimpl(r103) == false) goto L17;
        r103 = r106;
    L17:
        boolean r107 = ((Boolean) r103).booleanValue();     // Catch: Throwable -> L34
        m58.q r108 = m58.h.f512133d;     // Catch: Throwable -> L26
        if (r108 == null) goto L23;
        ASRModule r109 = r108.c();     // Catch: Throwable -> L26
        if (r109 == null) goto L23;
        r109.r(this.f288353b, r100.toByteArray(), new y58.a(null, this.f288353b, null, null, null, false, false, null, null, 0, 0, null, 0, 0, false, 0, 0, null, null, null, null, 0, null, 268435453));     // Catch: Throwable -> L26
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L24:
        Object r111 = Result.m9449constructorimpl(r110);     // Catch: Throwable -> L26
    L28:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);     // Catch: Throwable -> L34
        if (r112 == null) goto L31;
        int r113 = c68.b.f22600a;     // Catch: Throwable -> L34
        c68.b.c("AsrAudioFileStore", "[" + this.f288353b + "] dump debug audio file failed", r112);     // Catch: Throwable -> L34
    L31:
        r100.reset();     // Catch: Throwable -> L34
        CloseableKt.closeFinally(r100, null);
        this.f288356e = null;
        int r114 = c68.b.f22600a;
        c68.b.d("AsrAudioFileStore", "[" + this.f288353b + "] retryable audio file save result=" + r107 + " path=" + this.f288352a);
        return r107;
    L23:
        r110 = null;
    L26:
        th = move-exception;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L34
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L34
        goto L28
    L8:
        th = move-exception;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L34
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        CloseableKt.closeFinally(r100, th);
        throw th;
    }

    public final void b() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.f288352a);
        String r101 = "[" + this.f288353b + "] delete failed retryable audio file";
        if (r100.exists() == true) goto L33;
    L21:
        ByteArrayOutputStream r102 = this.f288356e;
        if (r102 != null) goto L35;
        return;
    L35:
        r102.reset();     // Catch: Throwable -> L25
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r102, null);
        return;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);
        throw th;
    L33:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L14
        if (r100.delete() == false) goto L8;
    L11:
        boolean r105 = true;
    L12:
        Object r106 = Result.m9449constructorimpl(Boolean.valueOf(r105));     // Catch: Throwable -> L14
    L16:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L20;
        int r108 = c68.b.f22600a;
        c68.b.c("AsrAudioFileStore", r101 + " failed path=" + r100.getPath(), r107);
        r106 = Boolean.FALSE;
    L20:
        ((Boolean) r106).booleanValue();
        goto L21
    L8:
        if (r100.exists() == false) goto L11;
        int r109 = c68.b.f22600a;     // Catch: Throwable -> L14
        c68.b.b("AsrAudioFileStore", r101 + " failed path=" + r100.getPath());     // Catch: Throwable -> L14
        r105 = false;
    L14:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public final void delete() {
        Object r100 = this.f288355d;
        monitor-enter(r100);
        int r101 = c68.b.f22600a;     // Catch: Throwable -> L7
        c68.b.d("AsrAudioFileStore", "[delete][" + this.f288353b + "][" + this.f288352a + ']');     // Catch: Throwable -> L7
        b();     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, String r101, Function1<? super Boolean, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        this.f288352a = r100;
        this.f288353b = r101;
        this.f288354c = r102;
        this.f288355d = new Object();
    }
}
