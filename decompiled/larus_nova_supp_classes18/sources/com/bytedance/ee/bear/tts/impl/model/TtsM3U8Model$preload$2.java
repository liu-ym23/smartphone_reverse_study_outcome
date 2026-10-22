package com.bytedance.ee.bear.tts.impl.model;

import ax4.f;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.tts.TtsLoadScene;
import com.bytedance.ee.bear.tts.m3u8.TtsM3U8Bean;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import qo5.a;
import qo5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.model.TtsM3U8Model$preload$2", f = "TtsM3U8Model.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TtsM3U8Model$preload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
    final /* synthetic */ a $params;
    final /* synthetic */ TtsLoadScene $scene;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TtsM3U8Model this$0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.impl.model.TtsM3U8Model$preload$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.model.TtsM3U8Model$preload$2$1", f = "TtsM3U8Model.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Disposable> $disposable;
        final /* synthetic */ NetService.f<SimpleRequestResult> $preloadRequest;
        int label;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.impl.model.TtsM3U8Model$preload$2$1$a */
        public static final class a<T> implements Consumer {
            public static final a<T> a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final void accept(Object r2) {
                SimpleRequestResult r3 = (SimpleRequestResult) r2;
                tt5.a.h("TtsM3U8Model", "preload-RX_next");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.impl.model.TtsM3U8Model$preload$2$1$b */
        public static final class b<T> implements Consumer {
            public static final b<T> a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final void accept(Object r4) {
                tt5.a.e("TtsM3U8Model", "preload-RX_error:", (Throwable) r4, false);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.impl.model.TtsM3U8Model$preload$2$1$c */
        public static final class c implements Action {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }

            public final void run() {
                tt5.a.h("TtsM3U8Model", "preload-RX_complete");
            }
        }

        public AnonymousClass1(Ref.ObjectRef<Disposable> r1, NetService.f<SimpleRequestResult> r2, Continuation<? super AnonymousClass1> r3) {
            this.$disposable = r1;
            this.$preloadRequest = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$disposable, this.$preloadRequest, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            Ref.ObjectRef<Disposable> r6 = this.$disposable;
            r6.element = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new f()).a(this.$preloadRequest).subscribe(a.a, b.a, c.a);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public TtsM3U8Model$preload$2(a r1, TtsLoadScene r2, TtsM3U8Model r3, Continuation<? super TtsM3U8Model$preload$2> r4) {
        this.$params = r1;
        this.$scene = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        TtsM3U8Model$preload$2 r0 = new TtsM3U8Model$preload$2(this.$params, this.$scene, this.this$0, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Job> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L42;
        ResultKt.throwOnFailure(r15);
        CoroutineScope r0 = (CoroutineScope) this.L$0;
        a r16 = this.$params;
        boolean r1 = false;
        if (r16 == null) goto L17;
        Long r17 = Boxing.boxLong(r16.b);
        if (r17.longValue() <= 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == true) goto L13;
        r17 = null;
    L13:
        if (r17 == null) goto L17;
        b r18 = this.this$0.a(r17.longValue());
        if (r18 == null) goto L17;
        String r19 = r18.a;
    L18:
        NetService.f r7 = new NetService.f("/space/api/aiextension/tts/trigger");
        TtsM3U8Model r8 = this.this$0;
        TtsLoadScene r9 = this.$scene;
        a r10 = this.$params;
        ((NetService.e) r7).c = 1;
        JSONObject r11 = new JSONObject();
        r11.putOpt(ResourceData.KEY_OBJ_TOKEN, r8.a);
        r11.putOpt("obj_type", Boxing.boxInt(r8.b));
        r11.putOpt("scene", Boxing.boxInt(r9.getServerScene()));
        if (r10 == null) goto L21;
        String r12 = r10.a;
    L22:
        r11.putOpt("speaker_id", r12);
        if (r10 == null) goto L33;
        Long r13 = Boxing.boxLong(r10.b);
        if (r13.longValue() <= 0) goto L27;
        r1 = true;
    L27:
        if (r1 == true) goto L30;
        r13 = null;
    L30:
        if (r13 == null) goto L33;
        long r2 = r13.longValue();
        r11.putOpt("begin_block_id", r19);
        r11.putOpt("begin_duration", Boxing.boxLong(r2 / ((long) CCMLynxCardView.ViewType.BANNER)));
    L33:
        if (r9 != TtsLoadScene.SWITCH_TONE) goto L39;
        TtsM3U8Bean r3 = r8.c;
        if (r3 == null) goto L37;
        Integer r4 = Boxing.boxInt(r3.revisionId);
    L38:
        r11.putOpt("revision_id", r4);
        goto L39
    L37:
        r4 = null;
    L39:
        ((NetService.e) r7).j = r11.toString();
        tt5.a.h("TtsM3U8Model", "preload, scene: " + this.$scene + ", params: " + this.$params + ", requestSegmentId: " + du5.b.i(r19));
        final Ref.ObjectRef r110 = new Ref.ObjectRef();
        Job r5 = BuildersKt.launch$default(r0, null, null, new AnonymousClass1(r110, r7, null), 3, null);
        r5.invokeOnCompletion(new TtsM3U8Model$preload$2$2$1(r110));
        return r5;
    L21:
        r12 = null;
        goto L22
    L9:
        r6 = false;
    L17:
        r19 = null;
        goto L18
    L42:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
