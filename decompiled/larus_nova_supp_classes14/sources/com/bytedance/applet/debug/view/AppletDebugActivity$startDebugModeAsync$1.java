package com.bytedance.applet.debug.view;

import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.debug.view.AppletDebugActivity$startDebugModeAsync$1", f = "AppletDebugActivity.kt", i = {}, l = {297}, m = "invokeSuspend", n = {}, s = {})
final class AppletDebugActivity$startDebugModeAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $debugInfo;
    final /* synthetic */ String $debugToken;
    final /* synthetic */ boolean $isLegacy;
    int label;
    final /* synthetic */ AppletDebugActivity this$0;

    /* JADX INFO: renamed from: com.bytedance.applet.debug.view.AppletDebugActivity$startDebugModeAsync$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.applet.debug.view.AppletDebugActivity$startDebugModeAsync$1$1", f = "AppletDebugActivity.kt", i = {}, l = {314}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $debugInfo;
        final /* synthetic */ String $debugToken;
        final /* synthetic */ boolean $isLegacy;
        int label;
        final /* synthetic */ AppletDebugActivity this$0;

        public AnonymousClass1(String r1, boolean r2, String r3, AppletDebugActivity r4, Continuation<? super AnonymousClass1> r5) {
            this.$debugInfo = r1;
            this.$isLegacy = r2;
            this.$debugToken = r3;
            this.this$0 = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$debugInfo, this.$isLegacy, this.$debugToken, this.this$0, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r19v0, types: [com.bytedance.applet.debug.view.i] */
        public final Object invokeSuspend(Object r22) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r22);     // Catch: NumberFormatException -> L27 JSONException -> L29
        L34:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r22);
            final JSONObject r8 = new JSONObject(this.$debugInfo);     // Catch: NumberFormatException -> L27 JSONException -> L29
            final String r10 = r8.optString("app_key");     // Catch: NumberFormatException -> L27 JSONException -> L29
            if (this.$isLegacy == false) goto L13;
            long r3 = CastLongProtector.parseLong(r8.optString("artifact_version_code"));     // Catch: NumberFormatException -> L27 JSONException -> L29
        L14:
            long r14 = r3;
            if (this.$isLegacy == false) goto L18;
            String r2 = null;
        L17:
            final String r16 = r2;
            String r17 = com.larus.platform.service.o.a.getDeviceId();     // Catch: NumberFormatException -> L27 JSONException -> L29
            Function0 r4 = com.larus.platform.service.q.a.f().a;     // Catch: NumberFormatException -> L27 JSONException -> L29
            if (r4 == null) goto L23;
            String r5 = (String) r4.invoke();     // Catch: NumberFormatException -> L27 JSONException -> L29
            if (r5 == null) goto L23;
        L24:
            String r18 = r5;
            IAISDKDebugService.Companion r6 = IAISDKDebugService.a;     // Catch: NumberFormatException -> L27 JSONException -> L29
            Intrinsics.checkNotNull(r10);     // Catch: NumberFormatException -> L27 JSONException -> L29
            String r9 = this.$debugToken;     // Catch: NumberFormatException -> L27 JSONException -> L29
            final AppletDebugActivity r7 = this.this$0;     // Catch: NumberFormatException -> L27 JSONException -> L29
            final boolean r11 = this.$isLegacy;     // Catch: NumberFormatException -> L27 JSONException -> L29
            final String r12 = this.$debugInfo;     // Catch: NumberFormatException -> L27 JSONException -> L29
            ?? r19 = new i(r7, r10, r11, r12, r8, r16);     // Catch: NumberFormatException -> L27 JSONException -> L29
            this.label = 1;     // Catch: NumberFormatException -> L27 JSONException -> L29
            if (r6.r(r10, r14, r16, r17, r9, r18, r19, this) != r0) goto L34;
            return r0;
        L23:
            r5 = "";
            goto L24
        L18:
            r2 = r8.optString("app_version_tag");     // Catch: NumberFormatException -> L27 JSONException -> L29
            goto L17
        L13:
            r3 = 0;
        L27:
            e = move-exception;
            com.bytedance.ai.utils.g.a.e("AppletDebugActivity", "Failed to parse versionCode: " + e.getMessage());
            AppletDebugActivity r13 = this.this$0;
            int r15 = AppletDebugActivity.l;
            r13.Q1(2131894337);
        L29:
            e = move-exception;
            com.bytedance.ai.utils.g.a.e("AppletDebugActivity", "Failed to parse debugInfo: " + e.getMessage() + ", debugInfo: " + this.$debugInfo);
            AppletDebugActivity r20 = this.this$0;
            int r21 = AppletDebugActivity.l;
            r20.Q1(2131894337);
            goto L34
        }
    }

    public AppletDebugActivity$startDebugModeAsync$1(AppletDebugActivity r1, String r2, boolean r3, String r4, Continuation<? super AppletDebugActivity$startDebugModeAsync$1> r5) {
        this.this$0 = r1;
        this.$debugInfo = r2;
        this.$isLegacy = r3;
        this.$debugToken = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AppletDebugActivity$startDebugModeAsync$1(this.this$0, this.$debugInfo, this.$isLegacy, this.$debugToken, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AppletDebugActivity r11 = this.this$0;
        int r2 = AppletDebugActivity.l;
        r11.S1(true);
        CoroutineDispatcher r12 = Dispatchers.getIO();
        AnonymousClass1 r3 = new AnonymousClass1(this.$debugInfo, this.$isLegacy, this.$debugToken, this.this$0, null);
        this.label = 1;
        if (BuildersKt.withContext(r12, r3, this) != r0) goto L12;
        return r0;
    }
}
