package com.bytedance.applet.debug.view;

import android.net.Uri;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.applet.debug.AppletDebugManager;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.debug.view.AppletDebugActivity$startGetDebugSchemaAsync$1", f = "AppletDebugActivity.kt", i = {}, l = {268}, m = "invokeSuspend", n = {}, s = {})
final class AppletDebugActivity$startGetDebugSchemaAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $shortToken;
    int label;
    final /* synthetic */ AppletDebugActivity this$0;

    /* JADX INFO: renamed from: com.bytedance.applet.debug.view.AppletDebugActivity$startGetDebugSchemaAsync$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.applet.debug.view.AppletDebugActivity$startGetDebugSchemaAsync$1$1", f = "AppletDebugActivity.kt", i = {0}, l = {269}, m = "invokeSuspend", n = {"$this$withContext"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $shortToken;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AppletDebugActivity this$0;

        public AnonymousClass1(String r1, AppletDebugActivity r2, Continuation<? super AnonymousClass1> r3) {
            this.$shortToken = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$shortToken, this.this$0, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r18) {
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = this.label;
            if (r3 == 0) goto L8;
            if (r3 != 1) goto L7;
            CoroutineScope r4 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r18);
            Object r5 = r18;
        L11:
            String r6 = (String) r5;
            if (r6 == null) goto L20;
            AppletDebugActivity r10 = this.this$0;
            Uri r7 = UriProtector.parse(r6);     // Catch: Exception -> L19
            boolean r8 = AppletDebugManager.a;     // Catch: Exception -> L19
            AppletDebugManager.a r9 = AppletDebugManager.a(r7);     // Catch: Exception -> L19
            if (r9 == null) goto L17;
            String r11 = r9.a;     // Catch: Exception -> L19
            String r12 = r9.b;     // Catch: Exception -> L19
            int r1 = AppletDebugActivity.l;     // Catch: Exception -> L19
            r10.getClass();     // Catch: Exception -> L19
            r10.i = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r10), null, null, new AppletDebugActivity$startDebugModeAsync$1(r10, r11, false, r12, null), 3, null);     // Catch: Exception -> L19
        L23:
        L22:
            return Unit.INSTANCE;
        L17:
            com.bytedance.ai.utils.g.a.e("AppletDebugActivity", "invalid debug schema: ".concat(r6));     // Catch: Exception -> L19
            int r13 = AppletDebugActivity.l;     // Catch: Exception -> L19
            r10.Q1(2131894332);     // Catch: Exception -> L19
        L19:
            com.bytedance.ai.utils.g.a.e("AppletDebugActivity", "failed to parse debug schema: ".concat(r6));
            int r14 = AppletDebugActivity.l;
            r10.Q1(2131894331);
            goto L22
        L20:
            AppletDebugActivity r15 = this.this$0;
            com.bytedance.ai.utils.g.a.e("AppletDebugActivity", "failed to get debug schema");
            int r16 = AppletDebugActivity.l;
            r15.Q1(2131894329);
            goto L22
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r18);
            CoroutineScope r17 = (CoroutineScope) this.L$0;
            IAISDKDebugService.Companion r19 = IAISDKDebugService.a;
            String r20 = this.$shortToken;
            this.L$0 = r17;
            this.label = 1;
            r5 = r19.B(r20, this);
            if (r5 != r2) goto L11;
            return r2;
        }
    }

    public AppletDebugActivity$startGetDebugSchemaAsync$1(AppletDebugActivity r1, String r2, Continuation<? super AppletDebugActivity$startGetDebugSchemaAsync$1> r3) {
        this.this$0 = r1;
        this.$shortToken = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AppletDebugActivity$startGetDebugSchemaAsync$1(this.this$0, this.$shortToken, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        AppletDebugActivity r8 = this.this$0;
        int r2 = AppletDebugActivity.l;
        r8.S1(true);
        CoroutineDispatcher r9 = Dispatchers.getIO();
        AnonymousClass1 r3 = new AnonymousClass1(this.$shortToken, this.this$0, null);
        this.label = 1;
        if (BuildersKt.withContext(r9, r3, this) != r0) goto L12;
        return r0;
    }
}
