package com.larus.larkfeed.impl.voice.service.record;

import android.os.SystemClock;
import com.larus.audio.IFlowAsrClientService;
import com.ss.android.lark.voiceinput.api.data.model.VoiceRecordFailureReason;
import com.ss.android.lark.voiceinput.api.data.model.record.VoiceRecordState;
import com.ss.android.lark.voiceinput.impl.service.record.VoiceRecordStateMachine;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes30.dex */
public final class FlowVoiceRecord implements com.ss.android.lark.voiceinput.impl.service.record.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f355666l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wac.a f355667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xac.a f355668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.larkfeed.impl.voice.service.record.a f355669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final VoiceRecordStateMachine f355670d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b1 f355671e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile FlowVoiceSession f355672f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableSharedFlow<yac.a> f355673g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a1 f355674h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile com.ss.android.lark.voiceinput.impl.service.record.b f355675i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f355676j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f355677k;

    public static final class a {
        public static Object a(String r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "message");
            Result.Companion r102 = Result.Companion;
            return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException(r100, r101)));
        }
    }

    static {
    }

    @Override // bbc.a
    public final void onCreate() {
        VoiceRecordStateMachine r100 = this.f355670d;
        VoiceRecordState r101 = VoiceRecordState.Idle;
        String r102 = this.f355676j;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "newState");
        jbc.a<abc.c> r103 = r100.f445123a;
        abc.c r104 = new abc.c(r102, r101);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "nextValue");
        r103.f498065b.setValue(r104);
    }

    @Override // bbc.a
    public final void onDestroy() {
        FlowVoiceSession r100 = this.f355672f;
        if (r100 == null) goto L5;
        Result.m9448boximpl(r100.e());
    L5:
        this.f355672f = null;
        VoiceRecordStateMachine.b(this.f355670d, VoiceRecordState.Destroy);
        this.f355675i = null;
        this.f355676j = null;
        this.f355677k = -1;
    }

    @Override // com.ss.android.lark.voiceinput.impl.service.record.a
    public final d1<yac.a> getEvents() {
        return this.f355674h;
    }

    @Override // com.ss.android.lark.voiceinput.impl.service.record.a
    public final i1<abc.c> getState() {
        return this.f355671e;
    }

    @Override // com.ss.android.lark.voiceinput.impl.service.record.a
    public final Object b(Continuation<? super Result<Unit>> r110) {
        if ((r110 instanceof FlowVoiceRecord$start$1) == false) goto L7;
        FlowVoiceRecord$start$1 r100 = (FlowVoiceRecord$start$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r111);
        ((Result) r111).m9458unboximpl();
    L54:
        this.f355672f = null;
        this.f355677k = -1;
        return a.a("Voice record state changed before start completed", null);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Object r104 = r100.L$0;
        ResultKt.throwOnFailure(r111);
        ((Result) r111).m9458unboximpl();
    L47:
        this.f355672f = null;
        VoiceRecordStateMachine.f(this.f355670d, VoiceRecordState.Failed);
        return r104;
    L16:
        ResultKt.throwOnFailure(r111);
        FlowVoiceSession r112 = this.f355672f;
        if (r112 != null) goto L21;
        return a.a("Voice record is not prepared", null);
    L21:
        if (this.f355670d.a(VoiceRecordState.Recording) == false) goto L23;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L26
        Object r106 = Result.m9449constructorimpl(Result.m9448boximpl(r112.g()));     // Catch: Throwable -> L26
    L28:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L35;
        String r108 = r107.getMessage();
        if (r108 != null) goto L34;
        r108 = "Failed to start voice data source";
    L34:
        r106 = Result.m9448boximpl(a.a(r108, r107));
    L35:
        Object r109 = ((Result) r106).m9458unboximpl();
        if (Result.m9455isFailureimpl(r109) == false) goto L49;
        Throwable r113 = Result.m9452exceptionOrNullimpl(r109);
        if (r113 == null) goto L43;
        String r114 = this.f355676j;
        if (r114 != null) goto L42;
        r114 = "";
    L42:
        f(r114, r113);
    L43:
        r100.L$0 = r109;
        r100.label = 1;
        if (r112.c(r100) != r102) goto L46;
        return r102;
    L46:
        r104 = r109;
        goto L47
    L49:
        this.f355677k = SystemClock.elapsedRealtime();
        if (VoiceRecordStateMachine.f(this.f355670d, VoiceRecordState.Recording) == true) goto L56;
        r100.label = 2;
        if (r112.c(r100) != r102) goto L54;
        return r102;
    L56:
        Job r115 = BuildersKt.launch$default(r112.f355685g, null, CoroutineStart.LAZY, new FlowVoiceSession$readLoop$1(r112, null), 1, null);
        r112.f355686h = r115;
        r112.f355687i.set(true);
        r115.start();
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L26:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    L23:
        return a.a("Voice record cannot start from " + this.f355670d.c(), null);
    L7:
        r100 = new FlowVoiceRecord$start$1(this, r110);
        goto L8
    }

    @Override // com.ss.android.lark.voiceinput.impl.service.record.a
    public final Object c(Continuation<? super Result<Unit>> r100) {
        if ((r100 instanceof FlowVoiceRecord$cancel$1) == false) goto L7;
        FlowVoiceRecord$cancel$1 r101 = (FlowVoiceRecord$cancel$1) r100;
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
        return ((Result) r103).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        r101.label = 1;
        Object r106 = g(r101);
        if (r106 != r104) goto L18;
        return r104;
    L18:
        return r106;
    L7:
        r101 = new FlowVoiceRecord$cancel$1(this, r100);
        goto L8
    }

    public final Object g(Continuation<? super Result<Unit>> r100) {
        if ((r100 instanceof FlowVoiceRecord$performCancel$1) == false) goto L7;
        FlowVoiceRecord$performCancel$1 r101 = (FlowVoiceRecord$performCancel$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        VoiceRecordState r106 = (VoiceRecordState) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Object r107 = ((Result) r103).m9458unboximpl();
    L28:
        if (Result.m9455isFailureimpl(r107) == false) goto L31;
        VoiceRecordStateMachine.f(this.f355670d, VoiceRecordState.Failed);
        return r107;
    L31:
        if (r106 == VoiceRecordState.Failed) goto L36;
        VoiceRecordStateMachine.f(this.f355670d, VoiceRecordState.Canceled);
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L36:
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        VoiceRecordState r108 = this.f355670d.c();
        if (this.f355670d.a(VoiceRecordState.Canceled) == false) goto L17;
    L20:
        FlowVoiceSession r109 = this.f355672f;
        this.f355672f = null;
        this.f355676j = null;
        this.f355677k = -1;
        if (r109 == null) goto L25;
        r101.L$0 = r108;
        r101.label = 1;
        Object r110 = r109.c(r101);
        if (r110 != r104) goto L26;
        return r104;
    L26:
        Object r111 = r110;
        r106 = r108;
        r107 = r111;
        goto L28
    L25:
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(Unit.INSTANCE);
        goto L26
    L17:
        if (r108 == VoiceRecordState.Failed) goto L20;
        return a.a("Voice record cannot cancel from " + this.f355670d.c(), null);
    L7:
        r101 = new FlowVoiceRecord$performCancel$1(this, r100);
        goto L8
    }

    @Override // com.ss.android.lark.voiceinput.impl.service.record.a
    public final void n(com.ss.android.lark.voiceinput.impl.service.c r100) {
        this.f355675i = r100;
    }

    @Override // com.ss.android.lark.voiceinput.impl.service.record.a
    public final Object p(Continuation<? super Result<Unit>> r100) {
        if ((r100 instanceof FlowVoiceRecord$stop$1) == false) goto L7;
        FlowVoiceRecord$stop$1 r101 = (FlowVoiceRecord$stop$1) r100;
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
        return ((Result) r103).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        FlowVoiceSession r106 = this.f355672f;
        if (r106 == null) goto L17;
        r101.label = 1;
        Object r107 = k(r106, r101);
        if (r107 != r104) goto L22;
        return r104;
    L22:
        return r107;
    L17:
        return a.a("Voice record is not recording", null);
    L7:
        r101 = new FlowVoiceRecord$stop$1(this, r100);
        goto L8
    }

    public FlowVoiceRecord(wac.a r100, xac.a r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "voiceContext");
        this.f355667a = r100;
        this.f355668b = r101;
        this.f355669c = new com.larus.larkfeed.impl.voice.service.record.a();
        VoiceRecordStateMachine r102 = new VoiceRecordStateMachine();
        this.f355670d = r102;
        this.f355671e = r102.f445124b;
        MutableSharedFlow<yac.a> r103 = SharedFlowKt.MutableSharedFlow$default(0, 4, null, 5, null);
        this.f355673g = r103;
        this.f355674h = e.a(r103);
        this.f355677k = -1;
    }

    public final Object d(FlowVoiceSession r100, Continuation<? super Result<Unit>> r101) {
        if ((r101 instanceof FlowVoiceRecord$closeSession$1) == false) goto L7;
        FlowVoiceRecord$closeSession$1 r102 = (FlowVoiceRecord$closeSession$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L15;
        if (r106 != 1) goto L14;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L24
        Object r107 = ((Result) r104).m9458unboximpl();     // Catch: Throwable -> L24
    L22:
        Object r108 = Result.m9449constructorimpl(Result.m9448boximpl(r107));     // Catch: Throwable -> L24
    L26:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L34;
        String r110 = r109.getMessage();
        if (r110 != null) goto L32;
        r110 = "Failed to close voice record session";
    L32:
        r108 = Result.m9448boximpl(a.a(r110, r109));
    L34:
        return ((Result) r108).m9458unboximpl();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L24
        if (this.f355670d.c() != VoiceRecordState.Recording) goto L21;
        r102.label = 1;     // Catch: Throwable -> L24
        r107 = r100.c(r102);     // Catch: Throwable -> L24
        if (r107 != r105) goto L22;
        return r105;
    L21:
        r107 = r100.e();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r102 = new FlowVoiceRecord$closeSession$1(this, r101);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.larkfeed.impl.voice.service.record.b] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.larkfeed.impl.voice.service.record.c] */
    @Override // com.ss.android.lark.voiceinput.impl.service.record.a
    public final Object e(final abc.b r100, Continuation<? super Result<Unit>> r101) {
        if ((r101 instanceof FlowVoiceRecord$prepare$1) == false) goto L7;
        FlowVoiceRecord$prepare$1 r102 = (FlowVoiceRecord$prepare$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (abc.b) r102.L$0;
        ResultKt.throwOnFailure(r104);
        Object r107 = ((Result) r104).m9458unboximpl();
    L28:
        if (Result.m9455isFailureimpl(r107) == false) goto L31;
        this.f355670d.e(VoiceRecordState.Failed, r100.f2524a);
        return r107;
    L31:
        this.f355672f = null;
        this.f355676j = null;
        if (this.f355670d.e(VoiceRecordState.Preparing, r100.f2524a) == true) goto L80;
        return a.a("Voice record state changed before prepare", null);
    L80:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L38
        IFlowAsrClientService.f288298a.getClass();     // Catch: Throwable -> L38
        IFlowAsrClientService r109 = IFlowAsrClientService.a.a();     // Catch: Throwable -> L38
        String r110 = r100.f2524a;     // Catch: Throwable -> L38
        com.larus.larkfeed.impl.voice.service.record.a r111 = this.f355669c;     // Catch: Throwable -> L38
        xac.a r112 = this.f355668b;     // Catch: Throwable -> L38
        r111.getClass();     // Catch: Throwable -> L38
        Object r113 = Result.m9449constructorimpl(r109.k(r110, com.larus.larkfeed.impl.voice.service.record.a.a(r112, r100)));     // Catch: Throwable -> L38
    L40:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
        if (r114 != null) goto L74;
        h68.c r115 = (h68.c) r113;
        h68.a r116 = r115.prepare();     // Catch: Throwable -> L64
        if ((r116 instanceof h68.a.b) == false) goto L56;
        FlowVoiceSession.a r117 = FlowVoiceSession.f355678l;     // Catch: Throwable -> L64
        String r118 = r100.f2525b;     // Catch: Throwable -> L64
        ?? r119 = new b(this, r100);     // Catch: Throwable -> L64
        ?? r120 = new c(this, r100);     // Catch: Throwable -> L64
        r117.getClass();     // Catch: Throwable -> L64
        Object r121 = FlowVoiceSession.a.a(r115, r118, r119, r120);     // Catch: Throwable -> L64
        Throwable r122 = Result.m9452exceptionOrNullimpl(r121);     // Catch: Throwable -> L64
        if (r122 != null) goto L51;
        FlowVoiceSession r123 = (FlowVoiceSession) r121;     // Catch: Throwable -> L64
        if (VoiceRecordStateMachine.f(this.f355670d, VoiceRecordState.Prepared) == true) goto L50;
        r123.e();     // Catch: Throwable -> L64
        VoiceRecordStateMachine.b(this.f355670d, VoiceRecordState.Failed);     // Catch: Throwable -> L64
        Object r124 = a.a("Voice record state changed before prepare completed", null);     // Catch: Throwable -> L64
    L61:
        Object r125 = Result.m9449constructorimpl(Result.m9448boximpl(r124));     // Catch: Throwable -> L64
    L66:
        Throwable r126 = Result.m9452exceptionOrNullimpl(r125);
        if (r126 == null) goto L83;
        r115.release();
        VoiceRecordStateMachine.f(this.f355670d, VoiceRecordState.Failed);
        String r127 = r126.getMessage();
        if (r127 != null) goto L72;
        r127 = "Failed to prepare voice record";
    L72:
        r125 = Result.m9448boximpl(a.a(r127, r126));
    L83:
        return ((Result) r125).m9458unboximpl();
    L50:
        this.f355672f = r123;     // Catch: Throwable -> L64
        this.f355676j = r100.f2524a;     // Catch: Throwable -> L64
        r124 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L64
        goto L61
    L51:
        r115.release();     // Catch: Throwable -> L64
        VoiceRecordStateMachine.f(this.f355670d, VoiceRecordState.Failed);     // Catch: Throwable -> L64
        String r128 = r122.getMessage();     // Catch: Throwable -> L64
        if (r128 != null) goto L82;
        r128 = "Failed to create voice record session";
    L82:
        return a.a(r128, r122);
    L56:
        if ((r116 instanceof h68.a.C6106a) == false) goto L63;
        r115.release();     // Catch: Throwable -> L64
        VoiceRecordStateMachine.f(this.f355670d, VoiceRecordState.Failed);     // Catch: Throwable -> L64
        String r129 = ((h68.a.C6106a) r116).f483924b;     // Catch: Throwable -> L64
        if (r129 != null) goto L60;
        r129 = "Failed to prepare voice record: " + ((h68.a.C6106a) r116).f483923a;     // Catch: Throwable -> L64
    L60:
        r124 = a.a(r129, ((h68.a.C6106a) r116).f483925c);     // Catch: Throwable -> L64
        goto L61
    L63:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L66
    L74:
        VoiceRecordStateMachine.f(this.f355670d, VoiceRecordState.Failed);
        String r131 = r114.getMessage();
        if (r131 != null) goto L78;
        r131 = "Failed to create voice data source";
    L78:
        return a.a(r131, r114);
    L38:
        th = move-exception;
        Result.Companion r132 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L40
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (StringsKt.isBlank(r100.f2524a) == false) goto L19;
        return a.a("Voice record task id is empty", null);
    L19:
        if (this.f355670d.a(VoiceRecordState.Preparing) == false) goto L21;
        this.f355677k = -1;
        FlowVoiceSession r133 = this.f355672f;
        if (r133 == null) goto L31;
        r102.L$0 = r100;
        r102.label = 1;
        r107 = d(r133, r102);
        if (r107 != r105) goto L28;
        return r105;
    L21:
        return a.a("Voice record cannot be prepared from " + this.f355670d.c(), null);
    L7:
        r102 = new FlowVoiceRecord$prepare$1(this, r101);
        goto L8
    }

    public final void f(String r100, Throwable r101) {
        if (StringsKt.isBlank(r100) == true) goto L23;
        int r102 = 0;
    L5:
        Integer r103 = null;
        if (r102 >= 16) goto L13;
        if (r101 == null) goto L13;
        if ((r101 instanceof FlowVoiceDataSourceException) == true) goto L11;
        r101 = r101.getCause();
        r102 = r102 + 1;
        goto L5
    L11:
        r103 = Integer.valueOf(((FlowVoiceDataSourceException) r101).getErrorCode());
    L13:
        if (r103 != null) goto L16;
        return;
    L16:
        if (r103.intValue() != (-2001)) goto L25;
        this.f355673g.tryEmit(new yac.a.c(r100, VoiceRecordFailureReason.MICROPHONE_INTERRUPTED));
        return;
    L25:
        return;
    }

    public final Object j(FlowVoiceSession r110, Continuation<? super Result<Unit>> r111) {
        if ((r111 instanceof FlowVoiceRecord$performStopSession$1) == false) goto L7;
        FlowVoiceRecord$performStopSession$1 r100 = (FlowVoiceRecord$performStopSession$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        ResultKt.throwOnFailure(r102);
    L68:
        Result.Companion r105 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r112 = r100.J$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L18
        Object r106 = ((Result) r102).m9458unboximpl();     // Catch: Throwable -> L18
    L39:
        Object r107 = Result.m9449constructorimpl(Result.m9448boximpl(r106));     // Catch: Throwable -> L18
    L42:
        long r113 = r112;
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L49;
        String r109 = r108.getMessage();
        if (r109 != null) goto L48;
        r109 = "Failed to stop voice record";
    L48:
        r107 = Result.m9448boximpl(a.a(r109, r108));
    L49:
        Object r114 = ((Result) r107).m9458unboximpl();
        this.f355677k = -1;
        if (Result.m9455isFailureimpl(r114) == false) goto L53;
        VoiceRecordStateMachine.f(this.f355670d, VoiceRecordState.Failed);
        return r114;
    L53:
        if (VoiceRecordStateMachine.f(this.f355670d, VoiceRecordState.Stopped) == false) goto L73;
        r100.label = 2;
        long r115 = this.f355667a.f558918h;
        if (r113 >= r115) goto L65;
        Object r116 = this.f355673g.emit(new yac.a.e(this.f355676j, r113, r115), r100);
        if (r116 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L62;
        r116 = Unit.INSTANCE;
    L62:
        if (r116 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L66;
        r116 = Unit.INSTANCE;
    L66:
        if (r116 != r103) goto L68;
        return r103;
    L65:
        r116 = Unit.INSTANCE;
        goto L66
    L73:
        return a.a("Voice record state changed before stop completed", null);
    L20:
        ResultKt.throwOnFailure(r102);
        if (this.f355672f == r110) goto L24;
        Result.Companion r117 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L24:
        VoiceRecordState r118 = this.f355670d.c();
        VoiceRecordState r119 = VoiceRecordState.Stopped;
        if (r118 != r119) goto L29;
        Result.Companion r120 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L29:
        if (this.f355670d.a(r119) == false) goto L31;
        long r121 = this.f355677k;
        if (r121 != (-1)) goto L35;
        r112 = 0;
    L36:
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L18
        r100.J$0 = r112;     // Catch: Throwable -> L18
        r100.label = 1;     // Catch: Throwable -> L18
        r106 = r110.h(r100);     // Catch: Throwable -> L18
        if (r106 != r103) goto L39;
        return r103;
    L35:
        r112 = RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - r121, 0);
        goto L36
    L31:
        return a.a("Voice record cannot stop from " + this.f355670d.c(), null);
    L18:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new FlowVoiceRecord$performStopSession$1(this, r111);
        goto L8
    }

    public final Object k(FlowVoiceSession r100, Continuation<? super Result<Unit>> r101) {
        if ((r101 instanceof FlowVoiceRecord$stopSession$1) == false) goto L7;
        FlowVoiceRecord$stopSession$1 r102 = (FlowVoiceRecord$stopSession$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
        return ((Result) r104).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r102.label = 1;
        Object r107 = j(r100, r102);
        if (r107 != r105) goto L18;
        return r105;
    L18:
        return r107;
    L7:
        r102 = new FlowVoiceRecord$stopSession$1(this, r101);
        goto L8
    }
}
