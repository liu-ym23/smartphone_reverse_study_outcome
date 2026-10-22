package com.bytedance.applog.priority.original;

import android.content.ContentValues;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.bytedance.applog.priority.original.AppSession$newSession$success$1", f = "AppSession.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
final class AppSession$newSession$success$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $extraParams;
    final /* synthetic */ boolean $isForegroundSession;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ a $sessionLaunch;
    int label;
    final /* synthetic */ AppSession this$0;

    public AppSession$newSession$success$1(AppSession r1, a r2, String r3, boolean r4, String r5, Continuation<? super AppSession$newSession$success$1> r6) {
        this.this$0 = r1;
        this.$sessionLaunch = r2;
        this.$sessionId = r3;
        this.$isForegroundSession = r4;
        this.$extraParams = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new AppSession$newSession$success$1(this.this$0, this.$sessionLaunch, this.$sessionId, this.$isForegroundSession, this.$extraParams, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L12:
        if (((Boolean) r13).booleanValue() == true) goto L33;
        SessionDatabase r14 = this.this$0.a();
        final String r2 = this.$sessionId;
        final boolean r3 = this.$isForegroundSession;
        String r4 = this.$extraParams;
        long r5 = this.$sessionLaunch.d;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        ContentValues r9 = new ContentValues();     // Catch: Throwable -> L26
        r9.put(r14.f, r2);     // Catch: Throwable -> L26
        String r10 = r14.k;     // Catch: Throwable -> L26
        if (r3 == false) goto L17;
        int r11 = 1;
    L18:
        r9.put(r10, Integer.valueOf(r11));     // Catch: Throwable -> L26
        r9.put(r14.j, Long.valueOf(r5));     // Catch: Throwable -> L26
        if (r4 == null) goto L21;
        r9.put(r14.i, r4);     // Catch: Throwable -> L26
    L21:
        final long r6 = r14.b().getWritableDatabase().insert(r14.d, null, r9);     // Catch: Throwable -> L26
        if (r6 >= 0) goto L24;
        r14.a.b("SessionDatabase:insertLaunch", null, new SessionDatabase$insertLaunch$2(r6, r2, r3));     // Catch: Throwable -> L26
    L24:
        if (r6 < 0) goto L28;
        boolean r15 = true;
    L29:
        if (r15 == true) goto L33;
        com.bytedance.applog.log.a r16 = this.this$0.getContext().c;
        final String r7 = this.$sessionId;
        r16.b("AppSession:newSession", null, new AnonymousClass1(r7));
        return Boxing.boxBoolean(false);
    L28:
        r15 = false;
        goto L29
    L17:
        r11 = 0;
    L26:
        th = move-exception;
        r14.a.b("SessionDatabase:insertLaunch", th, new SessionDatabase$insertLaunch$3(r2, r3));
    L33:
        return Boxing.boxBoolean(true);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        AppSession r17 = this.this$0;
        a r8 = this.$sessionLaunch;
        this.label = 1;
        r13 = r17.d(r8, false);
        if (r13 != r0) goto L12;
        return r0;
    }
}
