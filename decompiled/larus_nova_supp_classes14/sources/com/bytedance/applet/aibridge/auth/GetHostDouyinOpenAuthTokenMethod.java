package com.bytedance.applet.aibridge.auth;

import android.webkit.CookieManager;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.google.gson.annotations.SerializedName;
import com.ixigua.lib.track.TrackParams;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.platform.api.ISdkDouyinAuth;
import com.larus.platform.api.e5;
import com.larus.platform.api.f2;
import com.larus.platform.api.f5;
import com.larus.platform.service.i0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import f3.h;
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
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J6\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¨\u0006\u0014"}, d2 = {"Lcom/bytedance/applet/aibridge/auth/GetHostDouyinOpenAuthTokenMethod;", "Lcom/bytedance/applet/aibridge/auth/AbsGetHostDouyinOpenAuthTokenMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/auth/AbsGetHostDouyinOpenAuthTokenMethodIDL$GetHostDouyinOpenAuthTokenParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/auth/AbsGetHostDouyinOpenAuthTokenMethodIDL$GetHostDouyinOpenAuthTokenResultModel;", "handleCallback", "oId", "", "scopes", "accessToken", "Companion", "GetAwemeOpenIdResult", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetHostDouyinOpenAuthTokenMethod extends AbsGetHostDouyinOpenAuthTokenMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/applet/aibridge/auth/GetHostDouyinOpenAuthTokenMethod$GetAwemeOpenIdResult;", "", "openId", "", "accessToken", "scopes", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getOpenId", "()Ljava/lang/String;", "setOpenId", "(Ljava/lang/String;)V", "getAccessToken", "setAccessToken", "getScopes", "setScopes", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("access_token")
        private String accessToken;

        @SerializedName("open_id")
        private String openId;

        @SerializedName("scopes")
        private String scopes;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.openId, r6.openId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.accessToken, r6.accessToken) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.scopes, r6.scopes) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r0 = this.openId;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.accessToken;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.scopes;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "GetAwemeOpenIdResult(openId=" + this.openId + ", accessToken=" + this.accessToken + ", scopes=" + this.scopes + ')';
        }

        public b() {
            this.openId = null;
            this.accessToken = null;
            this.scopes = null;
        }

        public final String a() {
            return this.accessToken;
        }

        public final String b() {
            return this.openId;
        }

        public final String c() {
            return this.scopes;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.applet.aibridge.auth.GetHostDouyinOpenAuthTokenMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.applet.aibridge.auth.GetHostDouyinOpenAuthTokenMethod$handle$1", f = "GetHostDouyinOpenAuthTokenMethod.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ h<AbsGetHostDouyinOpenAuthTokenMethodIDL.b> $callback;
        final /* synthetic */ AbsGetHostDouyinOpenAuthTokenMethodIDL.a $params;
        int label;
        final /* synthetic */ GetHostDouyinOpenAuthTokenMethod this$0;

        /* JADX INFO: renamed from: com.bytedance.applet.aibridge.auth.GetHostDouyinOpenAuthTokenMethod$handle$1$a */
        public static final class a implements e5 {
            public final /* synthetic */ GetHostDouyinOpenAuthTokenMethod a;
            public final /* synthetic */ AbsGetHostDouyinOpenAuthTokenMethodIDL.a b;
            public final /* synthetic */ Ref.ObjectRef<String> c;
            public final /* synthetic */ Ref.ObjectRef<String> d;
            public final /* synthetic */ h<AbsGetHostDouyinOpenAuthTokenMethodIDL.b> e;

            public final void a(f5 r13) {
                Intrinsics.checkNotNullParameter(r13, "result");
                String r5 = r13.a;
                if (r5 != null) goto L5;
            L8:
                boolean r0 = true;
            L9:
                if (r0 == false) goto L11;
                GetHostDouyinOpenAuthTokenMethod.b(this.a, this.b, (String) this.c.element, (String) this.d.element, "", this.e);
                return;
            L11:
                GetHostDouyinOpenAuthTokenMethod r1 = this.a;
                AbsGetHostDouyinOpenAuthTokenMethodIDL.a r2 = this.b;
                String r3 = r13.b;
                if (r3 != null) goto L14;
                r3 = "";
            L14:
                String r14 = r13.c;
                if (r14 != null) goto L17;
                String r4 = "";
            L18:
                String r6 = r3;
                GetHostDouyinOpenAuthTokenMethod.b(r1, r2, r6, r4, r5, this.e);
                return;
            L17:
                r4 = r14;
                goto L18
            L5:
                if (StringsKt.isBlank(r5) == true) goto L8;
                r0 = false;
                goto L9
            }

            public a(GetHostDouyinOpenAuthTokenMethod r1, AbsGetHostDouyinOpenAuthTokenMethodIDL.a r2, Ref.ObjectRef<String> r3, Ref.ObjectRef<String> r4, h<AbsGetHostDouyinOpenAuthTokenMethodIDL.b> r5) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
            }
        }

        public AnonymousClass1(GetHostDouyinOpenAuthTokenMethod r1, AbsGetHostDouyinOpenAuthTokenMethodIDL.a r2, h<AbsGetHostDouyinOpenAuthTokenMethodIDL.b> r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$params = r2;
            this.$callback = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$params, this.$callback, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
        L11:
            y r15 = (com.larus.network.http.a) r14;
            Ref.ObjectRef r3 = new Ref.ObjectRef();
            String r2 = "";
            r3.element = "";
            Ref.ObjectRef r4 = new Ref.ObjectRef();
            r4.element = "";
            Ref.ObjectRef r5 = new Ref.ObjectRef();
            r5.element = "";
            if ((r15 instanceof y) == false) goto L27;
            b r16 = (b) ((com.larus.network.http.a) r15).b;
            if (r16 == null) goto L27;
            String r6 = r16.b();
            if (r6 != null) goto L18;
            r6 = "";
        L18:
            r3.element = r6;
            String r7 = r16.c();
            if (r7 != null) goto L21;
            r7 = "";
        L21:
            r4.element = r7;
            String r17 = r16.a();
            if (r17 == null) goto L25;
            r2 = r17;
        L25:
            r5.element = r2;
        L27:
            if (f2.a.enableActRefreshProtect() == true) goto L29;
        L35:
            GetHostDouyinOpenAuthTokenMethod.b(this.this$0, this.$params, (String) r3.element, (String) r4.element, (String) r5.element, this.$callback);
            return Unit.INSTANCE;
        L29:
            if (StringsKt.isBlank((CharSequence) r5.element) == false) goto L35;
            ISdkDouyinAuth r18 = i0.a();
            if (r18 == null) goto L34;
            Boxing.boxBoolean(ISdkDouyinAuth.a.a(r18, new a(this.this$0, this.$params, r3, r4, this.$callback), 5));
        L34:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            JSONObject r8 = new JSONObject();
            this.label = 1;
            r14 = HttpExtKt.k("Basic", b.class, "/alice/user/get_aweme_open_id", r8, null, null, false, null, null, null, this, 1008);
            if (r14 != r0) goto L11;
            return r0;
        }
    }

    static {
    }

    public GetHostDouyinOpenAuthTokenMethod() {
    }

    public final void handle(e3.d r7, ParamModel r8, h r9) {
        AbsGetHostDouyinOpenAuthTokenMethodIDL.a r10 = (AbsGetHostDouyinOpenAuthTokenMethodIDL.a) r8;
        Intrinsics.checkNotNullParameter(r7, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r9, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(this, r10, r9, null), 3, null);
    }

    public static final void b(GetHostDouyinOpenAuthTokenMethod r9, AbsGetHostDouyinOpenAuthTokenMethodIDL.a r10, final String r11, final String r12, final String r13, final h r14) {
        r9.getClass();
        final int r6 = !StringsKt.isBlank(r13) ? 1 : 0;
        String r15 = String.valueOf(r6);
        Intrinsics.checkNotNullParameter(r15, "isSuccess");
        JSONObject r1 = new JSONObject();
        r1.put("is_success", r15);     // Catch: JSONException -> L5
    L7:
        TrackParams r16 = new TrackParams().merge(r1);
        by7.a r2 = new by7.a("applet_get_dy_act_result");
        r2.a.merge(r16);
        r2.b();
        final JSONObject r3 = r10.getSetCookieConfig();
        if (r3 != null) goto L10;
    L15:
        Intrinsics.checkNotNullParameter(AbsGetHostDouyinOpenAuthTokenMethodIDL.b.class, "<this>");
        AbsGetHostDouyinOpenAuthTokenMethodIDL.b r17 = k3.c.a(AbsGetHostDouyinOpenAuthTokenMethodIDL.b.class);
        AbsGetHostDouyinOpenAuthTokenMethodIDL.b r18 = r17;
        r18.setAccessToken("");
        r18.setAccessTokenStatus(Integer.valueOf(r6));
        r18.setScopes(r12);
        r18.setOpenId(r11);
        if (r10.getSetCookieConfig() != null) goto L18;
        Integer r19 = null;
    L19:
        r18.setSetCookieResult(r19);
        r14.b(r17, "");
        return;
    L18:
        r19 = 0;
        goto L19
    L10:
        if (r3.has("url") == false) goto L15;
        if (r3.has("cookiePostfix") == false) goto L15;
        final CookieManager r4 = CookieManager.getInstance();
        r4.setAcceptCookie(true);
        t0.a(new com.bytedance.applet.aibridge.auth.b(r3, r13, r4, r14, r6, r12, r11));
        return;
    L5:
        e = move-exception;
        FLogger.a.e("DouyinAuthEventHelper", "error in DouyinAuthEventHelper mobAppletGetDyActResult " + e.getLocalizedMessage());
        goto L7
    }
}
