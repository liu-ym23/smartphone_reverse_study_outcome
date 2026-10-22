package com.bytedance.ee.bear.tts.impl;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.tts.TtsLoadScene;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.bear.tts.m3u8.TtsM3U8Bean;
import com.bytedance.ee.bear.tts.tone.TtsToneBean;
import com.bytedance.ee.bear.tts.tone.TtsToneListBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ee/bear/tts/TtsResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.TtsViewModel$prepareModel$2", f = "TtsViewModel.kt", i = {0, 0, 0, 1, 2}, l = {561, 579, 588}, m = "invokeSuspend", n = {"$this$withContext", "loadMetaJob", "loadPermissionJob", "$this$withContext", "$this$withContext"}, s = {"L$0", "L$1", "L$2", "L$0", "L$0"})
final class TtsViewModel$prepareModel$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TtsResult>, Object> {
    final /* synthetic */ TtsLoadScene $scene;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ TtsViewModel this$0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.impl.TtsViewModel$prepareModel$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.TtsViewModel$prepareModel$2$1", f = "TtsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ TtsViewModel this$0;

        public AnonymousClass1(TtsViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r3);
            TtsViewModel r4 = this.this$0;
            r4.j.setValue(TtsViewModel.x(r4));
            TtsViewModel r5 = this.this$0;
            MutableLiveData<TtsToneBean> r0 = r5.r;
            TtsM3U8Bean r6 = r5.u.c;
            TtsM3U8Bean r1 = null;
            if (r6 == null) goto L7;
            TtsToneBean r7 = r6.toneBean;
        L8:
            r0.setValue(r7);
            TtsViewModel r8 = this.this$0;
            to5.a r2 = r8.t;
            TtsM3U8Bean r9 = r8.u.c;
            if (r9 == null) goto L11;
            r1 = r9.clone();
        L11:
            r2.d = r1;
            return Unit.INSTANCE;
        L7:
            r7 = null;
            goto L8
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.impl.TtsViewModel$prepareModel$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.TtsViewModel$prepareModel$2$2", f = "TtsViewModel.kt", i = {}, l = {602, 608}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $mainLanguageCode;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TtsViewModel this$0;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.impl.TtsViewModel$prepareModel$2$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.TtsViewModel$prepareModel$2$2$1", f = "TtsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ TtsViewModel this$0;

            public AnonymousClass1(TtsViewModel r1, Continuation<? super AnonymousClass1> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass1(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L13;
                ResultKt.throwOnFailure(r3);
                TtsViewModel r4 = this.this$0;
                MutableLiveData<List<TtsToneBean>> r0 = r4.q;
                TtsToneListBean r5 = r4.y.c;
                if (r5 == null) goto L9;
                ArrayList<TtsToneBean> r6 = r5.getToneList();
                if (r6 == null) goto L9;
                ArrayList r1 = new ArrayList(r6);
            L10:
                r0.setValue(r1);
                return Unit.INSTANCE;
            L9:
                r1 = new ArrayList();
                goto L10
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass2(TtsViewModel r1, String r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$mainLanguageCode = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, this.$mainLanguageCode, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L11;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r13);
        L30:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r13);     // Catch: Exception -> L17
        L15:
            tt5.a.h("TtsViewModel", this.this$0.d + " prepareModel, load toneModel finished.");     // Catch: Exception -> L17
        L19:
            TtsViewModel r14 = this.this$0;
            to5.a r2 = r14.D;
            if (r14.y.c == null) goto L22;
            tt5.a.h("TtsToneModel", "getAccessResult, success");
            TtsResult r15 = TtsResult.d;
        L26:
            long r4 = this.this$0.y.e;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r15, "result");
            r2.h = "request_timbre";
            r2.l = r4;
            MainCoroutineDispatcher r16 = Dispatchers.getMain();
            AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
            this.label = 2;
            if (BuildersKt.withContext(r16, r3, this) != r0) goto L30;
            return r0;
        L22:
            if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == false) goto L24;
            tt5.a.k("TtsToneModel", "getAccessResult, network connected but toneListBean is null.");
            r15 = new TtsResult(TtsResult.ModelCode.TONE_LIST_INVALID);
            goto L26
        L24:
            tt5.a.k("TtsToneModel", "getAccessResult, network not connected.");
            r15 = new TtsResult(TtsResult.AccessCode.NETWORK_ERROR);
            goto L26
        L11:
            ResultKt.throwOnFailure(r13);
            Deferred r17 = BuildersKt.async$default((CoroutineScope) this.L$0, null, null, new TtsViewModel$prepareModel$2$2$loadToneJob$1(this.this$0, this.$mainLanguageCode, null), 3, null);
            tt5.a.h("TtsViewModel", this.this$0.d + " prepareModel, loadToneJob: " + r17);
            this.label = 1;     // Catch: Exception -> L17
            if (r17.await(this) != r0) goto L15;
            return r0;
        L17:
            e = move-exception;
            tt5.a.e("TtsViewModel", this.this$0.d + " prepareModel, await toneModel error:", e, false);
            goto L19
        }
    }

    public TtsViewModel$prepareModel$2(TtsViewModel r1, TtsLoadScene r2, Continuation<? super TtsViewModel$prepareModel$2> r3) {
        this.this$0 = r1;
        this.$scene = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        TtsViewModel$prepareModel$2 r0 = new TtsViewModel$prepareModel$2(this.this$0, this.$scene, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super TtsResult> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r9v14, types: [kotlinx.coroutines.CoroutineScope] */
    public final Object invokeSuspend(Object r24) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        ?? r4 = 2;
        TtsResult r7 = null;
        if (r0 == 0) goto L21;
        if (r0 == 1) goto L16;
        if (r0 == 2) goto L11;
        if (r0 != 3) goto L10;
        CoroutineScope r1 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r24);
        ?? r3 = r1;
    L8:
        ?? r9 = r3;
        TtsViewModel r5 = this.this$0;
        TtsM3U8Bean r6 = r5.u.c;
        if (r6 == null) goto L60;
        String r8 = r6.mainLanguageCode;
        if (r8 == null) goto L60;
    L78:
        tt5.a.h("TtsViewModel", this.this$0.d + " prepareModel, launch for loadToneJob sub-coroutine: " + BuildersKt.launch$default(r9, null, null, new AnonymousClass2(r5, r8, null), 3, null));     // Catch: Exception -> L64
    L66:
        TtsResult r10 = this.this$0.l("TtsViewModel-prepareModel");
        if (r10.a() == true) goto L69;
        r7 = r10;
    L69:
        if (r7 == null) goto L73;
        tt5.a.h("TtsViewModel", this.this$0.d + " prepareModel, checkAccess failed: " + r7);
        return r7;
    L73:
        return TtsResult.d;
    L64:
        e = move-exception;
        tt5.a.e("TtsViewModel", this.this$0.d + " prepareModel, launch for loadToneJob sub-coroutine error:", e, false);
    L60:
        r8 = "not_lang";
        goto L78
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r24);     // Catch: Exception -> L14
        r4 = r11;
    L36:
        tt5.a.h("TtsViewModel", this.this$0.d + " prepareModel, awaitAll(meta, permission, m3u8) finished.");     // Catch: Exception -> L14
        ?? r12 = r4;
    L39:
        ?? r13 = r12;
        TtsViewModel r14 = this.this$0;
        to5.a r15 = r14.D;
        TtsResult r16 = r14.u.b();
        long r17 = this.this$0.u.e;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, "result");
        r15.h = "request_m3u8";
        r15.c(new to5.i(r17));
        TtsViewModel.y(this.this$0);
        TtsViewModel r18 = this.this$0;
        so5.a r19 = r18.x.d;
        if (r19 == null) goto L53;
        TtsM3U8Bean r20 = r18.u.c;
        if (r20 == null) goto L52;
        TtsToneBean r110 = r20.toneBean;
        if (r110 == null) goto L46;
        String r111 = r110.getToneId();
    L47:
        r19.l = r111;
        TtsToneBean r21 = r20.toneBean;
        if (r21 == null) goto L50;
        String r22 = r21.getToneName();
    L51:
        r19.m = r22;
        r19.i = r18.u.c();
        goto L53
    L50:
        r22 = null;
        goto L51
    L46:
        r111 = null;
        goto L47
    L52:
        tt5.a.k("TtsViewModel", r18.d + " updatePlaybackFromM3U8, m3u8Bean is null.");
    L53:
        MainCoroutineDispatcher r23 = Dispatchers.getMain();
        AnonymousClass1 r25 = new AnonymousClass1(this.this$0, null);
        this.L$0 = r13;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 3;
        r3 = r13;
        if (BuildersKt.withContext(r23, r25, this) != r2) goto L8;
        return r2;
    L16:
        Deferred r26 = (Deferred) this.L$2;
        Deferred r112 = (Deferred) this.L$1;
        CoroutineScope r113 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r24);     // Catch: Exception -> L19
    L26:
        tt5.a.h("TtsViewModel", this.this$0.d + " prepareModel, await playbackJob finished.");     // Catch: Exception -> L19
        CoroutineScope r27 = r113;
    L32:
        Deferred r28 = BuildersKt.async$default(r27, null, null, new TtsViewModel$prepareModel$2$loadM3U8Job$1(this.this$0, this.$scene, null), 3, null);
        tt5.a.h("TtsViewModel", this.this$0.d + " prepareModel, loadM3U8Job: " + r28);
        Deferred[] r114 = {r112, r26, r28};     // Catch: Exception -> L14
        this.L$0 = r27;     // Catch: Exception -> L14
        this.L$1 = null;     // Catch: Exception -> L14
        this.L$2 = null;     // Catch: Exception -> L14
        this.label = 2;     // Catch: Exception -> L14
        r4 = r27;
        if (AwaitKt.b(r114, this) != r2) goto L36;
        return r2;
    L19:
        e = e;
        Deferred r115 = r112;
        CoroutineScope r116 = r113;
    L31:
        tt5.a.e("TtsViewModel", this.this$0.d + " prepareModel, await playbackJob error:", e, false);
        r112 = r115;
        r27 = r116;
        goto L32
    L21:
        ResultKt.throwOnFailure(r24);
        r116 = (CoroutineScope) this.L$0;
        tt5.a.h("TtsViewModel", this.this$0.d + " prepareModels, start.");
        Deferred r29 = BuildersKt.async$default(r116, null, null, new TtsViewModel$prepareModel$2$loadPlaybackJob$1(this.this$0, null), 3, null);
        tt5.a.h("TtsViewModel", this.this$0.d + " prepareModel, loadPlaybackJob: " + r29);
        Deferred r117 = BuildersKt.async$default(r116, null, null, new TtsViewModel$prepareModel$2$loadMetaJob$1(this.this$0, null), 3, null);
        tt5.a.h("TtsViewModel", this.this$0.d + " prepareModel, loadMetaJob: " + r117);
        r26 = BuildersKt.async$default(r116, null, null, new TtsViewModel$prepareModel$2$loadPermissionJob$1(this.this$0, null), 3, null);
        tt5.a.h("TtsViewModel", this.this$0.d + " prepareModel, loadPermissionJob: " + r26);
        this.L$0 = r116;     // Catch: Exception -> L29
        this.L$1 = r117;     // Catch: Exception -> L29
        this.L$2 = r26;     // Catch: Exception -> L29
        this.label = 1;     // Catch: Exception -> L29
        if (r29.await(this) != r2) goto L25;
        return r2;
    L25:
        r112 = r117;
        r113 = r116;
    L29:
        e = e;
        r115 = r117;
    L14:
        e = move-exception;
        tt5.a.e("TtsViewModel", this.this$0.d + " prepareModel, awaitAll error:", e, false);
        r12 = r4;
        goto L39
    }
}
