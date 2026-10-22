package com.larus.larkfeed.impl.voice.service.record;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.officesdk.utils.di.j;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes30.dex */
public final class FlowVoiceSession {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f355678l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h68.c f355679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f355680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FileOutputStream f355681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<abc.a, Unit> f355682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<FlowVoiceSession, Throwable, Unit> f355683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompletableJob f355684f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CoroutineScope f355685g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Job f355686h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f355687i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f355688j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicBoolean f355689k;

    public static final class a {
        public a() {
        }

        public static PolarisFileOutputStreamWrapper b(String r100) {
            String r101 = null;
            if (StringsKt.isBlank(r100) == false) goto L5;
            return null;
        L5:
            PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
            File r103 = r102.getParentFile();
            if (r103 != null) goto L8;
        L13:
            boolean r104 = true;
        L14:
            if (r104 == true) goto L21;
            StringBuilder r105 = new StringBuilder("failed to create voice record directory: ");
            if (r103 == null) goto L18;
            r101 = r103.getAbsolutePath();
        L18:
            r105.append(r101);
            throw new IllegalStateException(r105.toString().toString());
        L21:
            return new PolarisFileOutputStreamWrapper(r102, false);
        L8:
            if (r103.exists() == true) goto L13;
            if (r103.mkdirs() == true) goto L13;
            r104 = false;
            goto L14
        }

        public static Object a(h68.c r100, String r110, b r111, c r112) {
            Intrinsics.checkNotNullParameter(r100, "source");
            Intrinsics.checkNotNullParameter(r110, "filePath");
            Intrinsics.checkNotNullParameter(r111, "onAudioFrame");
            Intrinsics.checkNotNullParameter(r112, "onFatalError");
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
            int r102 = r100.b();     // Catch: Throwable -> L11
            if (r102 <= 0) goto L6;
            boolean r103 = true;
        L7:
            if (r103 == false) goto L10;
            return Result.m9449constructorimpl(new FlowVoiceSession(r100, new byte[r102], b(r110), r111, r112));
        L10:
            throw new IllegalArgumentException(("invalid read buffer size: " + r102).toString());     // Catch: Throwable -> L11
        L6:
            r103 = false;
        L11:
            th = move-exception;
            Result.Companion r113 = Result.Companion;
            return Result.m9449constructorimpl(ResultKt.createFailure(th));
        }
    }

    static {
        f355678l = new a();
    }

    public final Throwable d() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        FileOutputStream r101 = this.f355681c;     // Catch: Throwable -> L8
        if (r101 == null) goto L5;
        r101.close();     // Catch: Throwable -> L8
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Object r103 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L8
    L11:
        return Result.m9452exceptionOrNullimpl(r103);
    L5:
        r102 = null;
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final Object e() {
        this.f355687i.set(false);
        Job.DefaultImpls.cancel$default(this.f355684f, null, 1, null);
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        Object r101 = Result.m9449constructorimpl(Result.m9448boximpl(i(this.f355679a.release(), "release")));     // Catch: Throwable -> L5
    L7:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L14;
        String r103 = r102.getMessage();
        if (r103 != null) goto L13;
        r103 = "Failed to release voice data source";
    L13:
        r101 = Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException(r103, r102))));
    L14:
        Object r104 = ((Result) r101).m9458unboximpl();
        Throwable r105 = d();
        if (Result.m9455isFailureimpl(r104) == true) goto L24;
        if (r105 == null) goto L20;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("Failed to close voice record file", r105)));
    L20:
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L24:
        return r104;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final Object g() {
        this.f355688j.set(true);
        this.f355689k.set(false);
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        Object r101 = Result.m9449constructorimpl(Result.m9448boximpl(i(this.f355679a.start(), "start")));     // Catch: Throwable -> L5
    L7:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L14;
        String r103 = r102.getMessage();
        if (r103 != null) goto L13;
        r103 = "Failed to start voice data source";
    L13:
        r101 = Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException(r103, r102))));
    L14:
        Object r104 = ((Result) r101).m9458unboximpl();
        if (Result.m9455isFailureimpl(r104) == false) goto L17;
        d();
    L17:
        return r104;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final Object b(FlowVoiceSession r100) {
    L3:
        if (r100.f355687i.get() == false) goto L30;
        h68.a r101 = r100.f355679a.read(r100.f355680b);
        if ((r101 instanceof h68.a.C6106a) == true) goto L7;
        if ((r101 instanceof h68.a.b) == false) goto L29;
        Integer r102 = ((h68.a.b) r101).f483926a;
        if (r102 == null) goto L15;
        int r103 = r102.intValue();
    L16:
        int r104 = RangesKt.coerceIn(r103, 0, r100.f355680b.length);
        if (r104 != 0) goto L19;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);
    L24:
        if (Result.m9455isFailureimpl(r106) == false) goto L3;
        if (r100.f355687i.get() == false) goto L3;
        return r106;
    L19:
        FileOutputStream r107 = r100.f355681c;
        if (r107 == null) goto L22;
        r107.write(r100.f355680b, 0, r104);
    L22:
        r106 = r100.f(Arrays.copyOf(r100.f355680b, r104), false);
        goto L24
    L15:
        r103 = 0;
        goto L16
    L29:
        throw new NoWhenBranchMatchedException();
    L7:
        if (r100.f355687i.get() == true) goto L41;
        Result.Companion r108 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L41:
        return i(r101, "read");
    L30:
        Result.Companion r109 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    }

    public final Object c(Continuation<? super Result<Unit>> r100) {
        if ((r100 instanceof FlowVoiceSession$cancel$1) == false) goto L7;
        FlowVoiceSession$cancel$1 r101 = (FlowVoiceSession$cancel$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
        Object r106 = ((Result) r103).m9458unboximpl();
    L17:
        Object r107 = e();
        Job.DefaultImpls.cancel$default(this.f355684f, null, 1, null);
        if (Result.m9455isFailureimpl(r106) == false) goto L21;
        return r106;
    L21:
        if (Result.m9455isFailureimpl(r107) == false) goto L24;
        return r107;
    L24:
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        this.f355688j.set(false);
        r101.label = 1;
        r106 = h(r101);
        if (r106 != r104) goto L17;
        return r104;
    L7:
        r101 = new FlowVoiceSession$cancel$1(this, r100);
        goto L8
    }

    public final Object h(Continuation<? super Result<Unit>> r100) {
        if ((r100 instanceof FlowVoiceSession$stop$1) == false) goto L7;
        FlowVoiceSession$stop$1 r101 = (FlowVoiceSession$stop$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        Object r106 = r101.L$0;
        ResultKt.throwOnFailure(r103);
    L33:
        return r106;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        this.f355687i.set(false);
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L17
        Object r108 = Result.m9449constructorimpl(Result.m9448boximpl(i(this.f355679a.stop(), "stop")));     // Catch: Throwable -> L17
    L19:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L26;
        String r110 = r109.getMessage();
        if (r110 != null) goto L25;
        r110 = "Failed to stop voice data source";
    L25:
        r108 = Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException(r110, r109))));
    L26:
        Object r111 = ((Result) r108).m9458unboximpl();
        Job r112 = this.f355686h;
        if (r112 == null) goto L36;
        r101.L$0 = r111;
        r101.label = 1;
        if (r112.join(r101) != r104) goto L31;
        return r104;
    L31:
        r106 = r111;
        goto L33
    L36:
        return r111;
    L17:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r101 = new FlowVoiceSession$stop$1(this, r100);
        goto L8
    }

    public static final void a(FlowVoiceSession r100, Throwable r101) {
        r100.getClass();
        if (r101 != null) goto L5;
        r101 = new IllegalStateException("Voice data source failed");
    L5:
        j.c("FlowVoiceSession", "【VoiceApp】failed to read voice data source", r101);
        if (r100.f355689k.compareAndSet(false, true) == false) goto L19;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        r100.f355683e.invoke(r100, r101);     // Catch: Throwable -> L10
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L18;
        j.c("FlowVoiceSession", "【VoiceApp】failed to report voice data source error", r104);
        return;
    L18:
        return;
    L10:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public static Object i(h68.a r100, String r101) {
        if ((r100 instanceof h68.a.b) == false) goto L6;
        Result.Companion r102 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L6:
        if ((r100 instanceof h68.a.C6106a) == false) goto L13;
        Result.Companion r103 = Result.Companion;
        h68.a.C6106a r104 = (h68.a.C6106a) r100;
        int r105 = r104.f483923a;
        String r106 = r104.f483924b;
        if (r106 != null) goto L11;
        r106 = "Failed to " + r101 + " voice data source: " + r104.f483923a;
    L11:
        return Result.m9449constructorimpl(ResultKt.createFailure(new FlowVoiceDataSourceException(r101, r105, r106, r104.f483925c)));
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final Object f(byte[] r100, boolean r101) {
        abc.a r102 = new abc.a(r100, r100.length, System.currentTimeMillis(), r101);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        this.f355682d.invoke(r102);     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(Result.m9448boximpl(Result.m9449constructorimpl(Unit.INSTANCE)));     // Catch: Throwable -> L5
    L7:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L15;
        String r106 = r105.getMessage();
        if (r106 != null) goto L13;
        r106 = "Failed to process audio frame";
    L13:
        r104 = Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException(r106, r105))));
    L15:
        return ((Result) r104).m9458unboximpl();
    L5:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public FlowVoiceSession(h68.c r100, byte[] r101, PolarisFileOutputStreamWrapper r102, b r103, c r104) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "buffer");
        Intrinsics.checkNotNullParameter(r103, "onAudioFrame");
        Intrinsics.checkNotNullParameter(r104, "onFatalError");
        this.f355679a = r100;
        this.f355680b = r101;
        this.f355681c = r102;
        this.f355682d = r103;
        this.f355683e = r104;
        CompletableJob r105 = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.f355684f = r105;
        this.f355685g = CoroutineScopeKt.CoroutineScope(r105.plus(Dispatchers.getIO()));
        this.f355687i = new AtomicBoolean(false);
        this.f355688j = new AtomicBoolean(true);
        this.f355689k = new AtomicBoolean(false);
    }
}
