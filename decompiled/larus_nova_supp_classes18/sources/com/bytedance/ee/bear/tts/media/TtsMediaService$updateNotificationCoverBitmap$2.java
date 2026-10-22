package com.bytedance.ee.bear.tts.media;

import android.graphics.Bitmap;
import com.ss.android.lark.docs.icon.entity.IconShape;
import io.reactivex.android.schedulers.AndroidSchedulers;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.tts.media.TtsMediaService$updateNotificationCoverBitmap$2", f = "TtsMediaService.kt", i = {0}, l = {718, 402}, m = "invokeSuspend", n = {"disposable"}, s = {"L$0"})
public final class TtsMediaService$updateNotificationCoverBitmap$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $docIconInfo;
    final /* synthetic */ String $docToken;
    final /* synthetic */ int $docType;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ TtsMediaService this$0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.media.TtsMediaService$updateNotificationCoverBitmap$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.tts.media.TtsMediaService$updateNotificationCoverBitmap$2$2", f = "TtsMediaService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ TtsMediaService this$0;

        public AnonymousClass2(TtsMediaService r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            tt5.a.k("TtsMediaService", "updateNotificationCoverBitmap, finished.");
            TtsMediaService r3 = this.this$0;
            int r0 = TtsMediaService.l;
            r3.f();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a<T> implements Consumer {
        public final /* synthetic */ kotlinx.coroutines.i<Bitmap> a;

        public a(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Bitmap r3 = (Bitmap) r2;
            if (this.a.isActive() == false) goto L6;
            this.a.resumeWith(Result.constructor-impl(r3));
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ kotlinx.coroutines.i<Bitmap> a;

        public b(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            if (this.a.isActive() == false) goto L6;
            this.a.resumeWith(Result.constructor-impl(null));
            return;
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ kotlinx.coroutines.i<Bitmap> a;

        public c(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final void run() {
            if (this.a.isActive() == false) goto L6;
            this.a.resumeWith(Result.constructor-impl(null));
            return;
        }
    }

    public TtsMediaService$updateNotificationCoverBitmap$2(TtsMediaService r1, String r2, int r3, String r4, Continuation<? super TtsMediaService$updateNotificationCoverBitmap$2> r5) {
        this.this$0 = r1;
        this.$docToken = r2;
        this.$docType = r3;
        this.$docIconInfo = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new TtsMediaService$updateNotificationCoverBitmap$2(this.this$0, this.$docToken, this.$docType, this.$docIconInfo, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L23:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        TtsMediaService r2 = (TtsMediaService) this.L$3;
        String r3 = (String) this.L$2;
        String r4 = (String) this.L$1;
        Ref.ObjectRef r5 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r12);
    L16:
        r2.j = (Bitmap) r12;
        Disposable r13 = (Disposable) r5.element;
        if (r13 == null) goto L19;
        r13.dispose();
    L19:
        MainCoroutineDispatcher r14 = Dispatchers.getMain();
        AnonymousClass2 r6 = new AnonymousClass2(this.this$0, null);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 2;
        if (BuildersKt.withContext(r14, r6, this) != r0) goto L23;
        return r0;
    L10:
        ResultKt.throwOnFailure(r12);
        final Ref.ObjectRef r15 = new Ref.ObjectRef();
        r2 = this.this$0;
        String r7 = this.$docToken;
        int r8 = this.$docType;
        String r9 = this.$docIconInfo;
        this.L$0 = r15;
        this.L$1 = r7;
        this.L$2 = r9;
        this.L$3 = r2;
        this.I$0 = r8;
        this.label = 1;
        kotlinx.coroutines.j r10 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r10.C();
        r15.element = mbb.c.a(r7, r8, r9, IconShape.SQUARE, null).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new a(r10), new b(r10), new c(r10));
        r10.i(new TtsMediaService$updateNotificationCoverBitmap$2$1$4(r15));
        Object r11 = r10.B();
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        DebugProbesKt.probeCoroutineSuspended(this);
    L13:
        if (r11 != r0) goto L15;
        return r0;
    L15:
        r5 = r15;
        r12 = r11;
        goto L16
    }
}
