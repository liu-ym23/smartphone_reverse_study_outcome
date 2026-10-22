package com.bytedance.ee.bear.tts.impl.model;

import android.os.SystemClock;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.tts.tone.TtsToneListBean;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ee/bear/tts/tone/TtsToneListBean;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.model.TtsToneModel$reload$2", f = "TtsToneModel.kt", i = {0, 0}, l = {149}, m = "invokeSuspend", n = {"disposable", "beginTimeMs"}, s = {"L$0", "J$0"})
public final class TtsToneModel$reload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TtsToneListBean>, Object> {
    final /* synthetic */ String $languageCode;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ TtsToneModel this$0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ i<TtsToneListBean> a;

        public a(j r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            TtsToneModel.TtsToneListResult r4 = (TtsToneModel.TtsToneListResult) r3;
            if (this.a.isActive() == false) goto L6;
            tt5.a.h("TtsToneModel", "reloadToneList-RX_next, get respond success");
            i<TtsToneListBean> r0 = this.a;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(((com.bytedance.ee.bear.contract.Result) r4).data));
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ i<TtsToneListBean> a;

        public b(j r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            if (this.a.isActive() == false) goto L6;
            tt5.a.e("TtsToneModel", "reloadToneList-RX_error, get respond failed:", r5, false);
            this.a.resumeWith(Result.constructor-impl(null));
            return;
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ i<TtsToneListBean> a;

        public c(j r1) {
            this.a = r1;
        }

        public final void run() {
            if (this.a.isActive() == false) goto L6;
            tt5.a.h("TtsToneModel", "reloadToneList-RX_complete");
            this.a.resumeWith(Result.constructor-impl(null));
            return;
        }
    }

    public TtsToneModel$reload$2(String r1, TtsToneModel r2, Continuation<? super TtsToneModel$reload$2> r3) {
        this.$languageCode = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new TtsToneModel$reload$2(this.$languageCode, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super TtsToneListBean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        long r2 = this.J$0;
        TtsToneModel r4 = (TtsToneModel) this.L$3;
        String r5 = (String) this.L$2;
        TtsToneModel r6 = (TtsToneModel) this.L$1;
        Ref.ObjectRef r7 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r14);
    L14:
        r4.c = (TtsToneListBean) r14;
        Disposable r15 = (Disposable) r7.element;
        if (r15 == null) goto L17;
        r15.dispose();
    L17:
        tt5.a.h("TtsToneModel", "reloadToneList, result: " + this.this$0.c);
        TtsToneModel r16 = this.this$0;
        r16.d = true;
        r16.e = SystemClock.elapsedRealtime() - r2;
        return this.this$0.c;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        tt5.a.h("TtsToneModel", "reloadToneList, languageCode: " + this.$languageCode);
        long r8 = SystemClock.elapsedRealtime();
        final Ref.ObjectRef r17 = new Ref.ObjectRef();
        TtsToneModel r3 = this.this$0;
        String r9 = this.$languageCode;
        this.L$0 = r17;
        this.L$1 = r3;
        this.L$2 = r9;
        this.L$3 = r3;
        this.J$0 = r8;
        this.label = 1;
        j r10 = new j(IntrinsicsKt.intercepted(this), 1);
        r10.C();
        NetService.f r11 = new NetService.f("/api/aiextension/tts/speakers");
        ((NetService.e) r11).c = 2;
        r11.b(ResourceData.KEY_OBJ_TOKEN, r3.a);
        r11.b("obj_type", String.valueOf(r3.b));
        r11.b("content_lang", r9);
        r17.element = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new TtsToneModel.b()).a(r11).subscribe(new a(r10), new b(r10), new c(r10));
        r10.i(new TtsToneModel$reload$2$1$4(r17));
        Object r12 = r10.B();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(this);
    L11:
        if (r12 != r0) goto L13;
        return r0;
    L13:
        r7 = r17;
        r4 = r3;
        r2 = r8;
        r14 = r12;
        goto L14
    }
}
