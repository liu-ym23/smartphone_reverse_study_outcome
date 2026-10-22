package ic8;

import android.util.LruCache;
import com.bytedance.ee.space.sync.PushRoute$EType;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.common.apphost.AppHost;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f489237a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f489238b = null;

    public static final class a implements IIMCallback<List<? extends String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f489239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CompletableDeferred<List<String>> f489240b;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return !y0.a();
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            Intrinsics.checkNotNullParameter(r100, "error");
            vc8.d r101 = vc8.d.f554129a;
            String r102 = this.f489239a;
            r101.getClass();
            vc8.d.b(r102);
            this.f489240b.complete(CollectionsKt.emptyList());
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(List<? extends String> r100) {
            List<? extends String> r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            vc8.d r102 = vc8.d.f554129a;
            String r103 = this.f489239a;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, "conversationId");
            Intrinsics.checkNotNullParameter(r101, "value");
            if (vc8.d.f554132d == false) goto L6;
            ((LruCache) vc8.d.f554130b.getValue()).put(r103, r101);
        L6:
            vc8.d.b(this.f489239a);
            this.f489240b.complete((List<String>) r101);
        }

        public a(String r100, CompletableDeferred<List<String>> r101) {
            this.f489239a = r100;
            this.f489240b = r101;
        }
    }

    public static final class b implements IIMCallback<List<? extends String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ wc9.e f489241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CompletableDeferred<List<String>> f489242b;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return !y0.a();
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            Intrinsics.checkNotNullParameter(r100, "error");
            vc8.d r101 = vc8.d.f554129a;
            String r102 = this.f489241a.f559198a;
            r101.getClass();
            vc8.d.b(r102);
            this.f489242b.complete(CollectionsKt.emptyList());
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(List<? extends String> r100) {
            List<? extends String> r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            vc8.d r102 = vc8.d.f554129a;
            wc9.e r103 = this.f489241a;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, "conversation");
            Intrinsics.checkNotNullParameter(r101, "value");
            if (vc8.d.f554132d == false) goto L12;
            Integer r104 = r103.f559207j;
            if (r104 == null) goto L12;
            if (r104.intValue() != 3) goto L12;
            ((LruCache) vc8.d.f554130b.getValue()).put(r103.f559198a, r101);
        L12:
            vc8.d.b(this.f489241a.f559198a);
            this.f489242b.complete((List<String>) r101);
        }

        public b(wc9.e r100, CompletableDeferred<List<String>> r101) {
            this.f489241a = r100;
            this.f489242b = r101;
        }
    }

    static {
        f489237a = LazyKt.lazy(new l());
        f489238b = LazyKt.lazy(new m());
    }

    public static final boolean A(wc9.e r100) {
        if (E(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (j(r100) == true) goto L8;
        return false;
    }

    public static final boolean B(wc9.e r100) {
        if (r100 == null) goto L6;
        Integer r101 = r100.f559219v;
        if (r101 == null) goto L6;
        return r101.equals(6);
    L6:
        return false;
    }

    public static final boolean C(wc9.e r100) {
        if (r100 == null) goto L10;
        String r101 = r100.f559215r;
        if (r101 == null) goto L10;
        return Intrinsics.areEqual(new JSONObject(r101).optString("share_from_review_status"), "3");
    L9:
        FLogger.f375446a.e("ConversationExt", "Call Conversation.isShareReviewBanned error, parse ext error, ext = ".concat(r101));
    L10:
        return false;
    }

    public static final boolean D(wc9.e r100) {
        if (r100 == null) goto L6;
        Integer r101 = r100.f559219v;
        if (r101 == null) goto L6;
        return r101.equals(3);
    L6:
        return false;
    }

    public static final boolean E(wc9.e r100) {
        if (AppHost.f326268a.isPlugin() == false) goto L5;
        return false;
    L5:
        if (r100 == null) goto L15;
        String r101 = r100.f559215r;
        if (r101 == null) goto L15;
        String r102 = new JSONObject(r101).optString("tenant_source");     // Catch: Exception -> L14
        if (Intrinsics.areEqual(r102, "toutiao") == false) goto L15;
        FLogger.f375446a.i("ConversationExt.isToutiaoConversation", "isToutiaoConversation" + r102 + ", conversationId = " + r100.f559198a);     // Catch: Exception -> L14
        return true;
    L14:
        FLogger.f375446a.e("ConversationExt", "Call isToutiaoConversation error, parse ext error, ext = ".concat(r101));
    L15:
        return false;
    }

    public static final String F(wc9.e r100) {
        if (r100 != null) goto L5;
        return "null";
    L5:
        StringBuilder r101 = new StringBuilder("Conversation(id=");
        r101.append(r100.f559198a);
        r101.append(",name=");
        String r102 = r100.f559200c;
        if (r102 == null) goto L8;
        String r103 = StringsKt.take(r102, 4);
    L9:
        r101.append(r103);
        r101.append(",status=");
        r101.append(r100.f559217t);
        r101.append(",type=");
        r101.append(r100.f559207j);
        r101.append(",botType=");
        r101.append(r100.f559219v);
        r101.append(",badge=");
        r101.append(r100.f559209l);
        r101.append('_');
        r101.append(r100.f559210m);
        r101.append(",pin=");
        r101.append(r100.f559202e);
        r101.append(",time=");
        r101.append(r100.f559201d);
        r101.append(",version=");
        r101.append(r100.f559218u);
        r101.append(')');
        return r101.toString();
    L8:
        r103 = null;
        goto L9
    }

    public static final String a(wc9.e r100) {
        Object r101 = null;
        if (r100 == null) goto L23;
        String r102 = r100.f559215r;
        if (r102 == null) goto L24;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        String r104 = new JSONObject(r102).optString("agent_task_param");     // Catch: Throwable -> L13
        if ((!StringsKt.isBlank(r104)) == true) goto L11;
        r104 = null;
    L11:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r105) == true) goto L20;
        r101 = r105;
    L20:
        return (String) r101;
    L13:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L24:
        return null;
    L23:
        return null;
    }

    @Deprecated(message = "使用 IChatUIBlockAbility.isBlocked(ChatUIBlockConfig.HIDE_INPUT_BAR) 配置化控制输入框显隐", replaceWith = @ReplaceWith(expression = "vContext.getAbility(IChatUIBlockAbility::class.java)?.isBlocked(ChatUIBlockConfig.HIDE_INPUT_BAR)", imports = {}))
    public static final boolean d(wc9.e r100) {
        if (r100 == null) goto L10;
        String r101 = r100.f559215r;
        if (r101 == null) goto L10;
        return Intrinsics.areEqual(new JSONObject(r101).optString("forbid_send_msg"), "true");
    L9:
        FLogger.f375446a.e("ConversationExt", "Call Conversation.forbidSendMsg error, parse ext error, ext = ".concat(r101));
    L10:
        return false;
    }

    public static final String e(wc9.e r100) {
        if (r100 == null) goto L16;
        String r101 = r100.f559216s;
        if (r101 == null) goto L16;
        JSONObject r102 = new JSONObject(r101).optJSONObject("route_info");     // Catch: Exception -> L15
        boolean r103 = false;
        if (r102 != null) goto L10;
    L12:
        if (r103 == false) goto L16;
        return r102.optString("route_data");
    L10:
        if (r102.optInt(PushRoute$EType.KEY_NAME) != 1) goto L12;
        r103 = true;
    L15:
        FLogger.f375446a.e("ConversationExt", "Call Conversation.getAppletSchema error, parse biz_model error, bizModel = ".concat(r101));
    L16:
        return null;
    }

    public static final String f(wc9.e r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        IAIChatControlTraceService.Companion r101 = IAIChatControlTraceService.f365889a;
        Integer r102 = r100.f559219v;
        BotInfoCache r103 = BotInfoCache.INSTANCE;
        return r101.g(r102, r103.getBotType(r100.f559198a), r103.isOwnBot(r100.f559198a));
    }

    public static final String h(wc9.e r100) {
        if (r100 == null) goto L10;
        String r101 = r100.f559216s;
        if (r101 == null) goto L10;
        return new JSONObject(r101).optString("jump_schema_url");
    L9:
        FLogger.f375446a.e("ConversationExt", "Call Conversation.getPcCellJumpUrl error, parse biz_model error, bizModel = ".concat(r101));
    L10:
        return null;
    }

    public static final String i(wc9.e r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Integer r101 = r100.f559207j;
        if (r101 != null) goto L6;
    L8:
        if (r101 == null) goto L14;
        if (r101.intValue() != 2) goto L14;
        return "group";
    L14:
        return f(r100);
    L6:
        if (r101.intValue() != 1) goto L8;
        return "real_people";
    }

    public static final boolean j(wc9.e r100) {
        if (AppHost.f326268a.isPlugin() == false) goto L5;
        return false;
    L5:
        if (r100 == null) goto L15;
        String r101 = r100.f559215r;
        if (r101 == null) goto L15;
        String r102 = new JSONObject(r101).optString("tenant_source");     // Catch: Exception -> L14
        if (Intrinsics.areEqual(r102, "aweme_business") == false) goto L15;
        FLogger.f375446a.i("ConversationExt.isAwemeBusinessConversation", "isAwemeBusinessConversation" + r102 + ", conversationId = " + r100.f559198a);     // Catch: Exception -> L14
        return true;
    L14:
        FLogger.f375446a.e("ConversationExt", "Call isAwemeBusinessConversation error, parse ext error, ext = ".concat(r101));
    L15:
        return false;
    }

    public static final boolean k(wc9.e r100) {
        if (r100 == null) goto L6;
        Integer r101 = r100.f559207j;
        if (r101 == null) goto L6;
        return r101.equals(2);
    L6:
        return false;
    }

    public static final boolean l(wc9.e r100) {
        if (((Boolean) f489237a.getValue()).booleanValue() == true) goto L5;
        return false;
    L5:
        if (r100 == null) goto L12;
        Integer r101 = r100.E;
        if (r101 == null) goto L12;
        if (r101.intValue() != 3) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == false) goto L17;
        return true;
    L17:
        return false;
    L12:
        r102 = false;
        goto L13
    }

    public static final boolean m(wc9.e r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.F != 2) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean n(wc9.e r100) {
        if (r100 == null) goto L18;
        String r101 = r100.f559215r;
        if (r101 == null) goto L22;
        String r102 = new JSONObject(r101).optString("agent_task_param");     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r102);     // Catch: Exception -> L14
        if (StringsKt.isBlank(r102) == true) goto L19;
        if (new JSONObject(r102).optInt("runtime_type") != 1) goto L20;
        return true;
    L20:
        return false;
    L19:
        return false;
    L14:
        FLogger.f375446a.e("ConversationExt", "Call Conversation.isCloudPcConversation error, parse ext error, ext = ".concat(r101));
        return false;
    L22:
        return false;
    L18:
        return false;
    }

    public static final boolean o(wc9.e r100) {
        if (r100 == null) goto L20;
        String r101 = r100.f559215r;
        if (r101 != null) goto L6;
        return false;
    L6:
        if ((!StringsKt.isBlank(r101)) == true) goto L9;
        r101 = null;
    L9:
        if (r101 == null) goto L25;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(Boolean.parseBoolean(new JSONObject(r101).optString("disable_fork"))));     // Catch: Throwable -> L13
    L15:
        Boolean r104 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r103) == false) goto L19;
        r103 = r104;
    L19:
        return ((Boolean) r103).booleanValue();
    L13:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L25:
        return false;
    L20:
        return false;
    }

    public static final boolean p(wc9.e r100) {
        if (E(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (j(r100) == true) goto L8;
        return false;
    }

    public static final boolean q(wc9.e r100) {
        if (w(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (m(r100) == true) goto L8;
        return false;
    }

    public static final boolean r(wc9.e r100) {
        if (r100 == null) goto L11;
        Integer r101 = r100.f559203f;
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.intValue() != 1) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    public static final boolean s(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return com.larus.im.j.f(r100);
    }

    public static final boolean t(wc9.e r100) {
        if (r100 == null) goto L18;
        String r101 = r100.f559215r;
        if (r101 == null) goto L22;
        String r102 = new JSONObject(r101).optString("agent_task_param");     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r102);     // Catch: Exception -> L14
        if (StringsKt.isBlank(r102) == true) goto L19;
        if (new JSONObject(r102).optInt("runtime_type") == 2) goto L21;
        return false;
    L21:
        return true;
    L19:
        return false;
    L14:
        FLogger.f375446a.e("ConversationExt", "Call Conversation.isLocalPcConversation error, parse ext error, ext = ".concat(r101));
        return false;
    L22:
        return false;
    L18:
        return false;
    }

    public static final boolean u(wc9.e r100) {
        if (r100 == null) goto L6;
        Integer r101 = r100.f559219v;
        if (r101 == null) goto L6;
        return r101.equals(1);
    L6:
        return false;
    }

    public static final boolean v(wc9.e r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.f559198a.length() <= 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L28;
        String r102 = r100.f559198a;
        wc9.e r103 = AuthModelDelegate.f297134b.y().getValue();
        if (r103 == null) goto L13;
        String r104 = r103.f559198a;
    L15:
        if (Intrinsics.areEqual(r102, r104) == false) goto L29;
        Integer r105 = r100.f559207j;
        if (r105 != null) goto L20;
        return false;
    L20:
        if (r105.intValue() != 3) goto L30;
        Integer r106 = r100.f559219v;
        if (r106 != null) goto L25;
        return false;
    L25:
        if (r106.intValue() != 1) goto L31;
        return true;
    L31:
        return false;
    L30:
        return false;
    L29:
        return false;
    L13:
        r104 = null;
        goto L15
    L28:
        return false;
    L8:
        r101 = false;
        goto L9
    }

    public static final boolean w(wc9.e r100) {
        if (((Boolean) f489238b.getValue()).booleanValue() == true) goto L5;
        return false;
    L5:
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r100.F != 1) goto L9;
        r101 = true;
        goto L10
    }

    public static final boolean y(wc9.e r100) {
        if (((Boolean) f489238b.getValue()).booleanValue() == true) goto L5;
        return false;
    L5:
        if (r100 == null) goto L8;
        String r101 = r100.f559215r;
        if (r101 == null) goto L8;
    L23:
    L21:
        FLogger.f375446a.e("ConversationExt", "Call Conversation.isPcCvs error, parse ext error, ext = ".concat(r101));
        return false;
    L10:
        if (D(r100) == true) goto L12;
        return false;
    L12:
        if (r100 != null) goto L14;
    L16:
        boolean r102 = false;
    L17:
        if (r102 == true) goto L20;
        if (Intrinsics.areEqual(new JSONObject(r101).optString("inner_platform"), "web") == true) goto L20;
        return false;
    L20:
        return true;
    L14:
        if (r100.G != 1) goto L16;
        r102 = true;
    L8:
        r101 = "";
        goto L23
    }

    public static final boolean z(wc9.e r100) {
        if (r100 == null) goto L9;
        Integer r101 = r100.f559202e;
        if (r101 == null) goto L9;
        if (r101.equals(1) != true) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
    L13:
        return true;
    L12:
        if (u(r100) == true) goto L13;
        return false;
    L9:
        r102 = false;
        goto L10
    }

    public static final Object b(String r100, Continuation<? super List<String>> r101) {
        boolean r102 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L11;
        vc8.d.f554129a.getClass();
        List r104 = vc8.d.a(r100);
        List r105 = r104;
        if (r105 != null) goto L15;
    L16:
        r102 = true;
    L17:
        if (r102 == true) goto L19;
        return r104;
    L19:
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        boolean r106 = vc8.d.f554132d;
        if (r106 == true) goto L22;
        Deferred r107 = null;
    L23:
        if (r107 != null) goto L25;
    L28:
        CompletableDeferred r108 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r108, "deferred");
        if (r106 == false) goto L32;
        ((LruCache) vc8.d.f554131c.getValue()).put(r100, r108);
    L32:
        com.larus.im.d.a().getBotIdsByConversationId(r100, new a(r100, r108));
        return r108.await(r101);
    L25:
        if (r107.isActive() == false) goto L28;
        return r107.await(r101);
    L22:
        r107 = (Deferred) ((LruCache) vc8.d.f554131c.getValue()).get(r100);
        goto L23
    L15:
        if (r105.isEmpty() == false) goto L17;
    L11:
        return CollectionsKt.emptyList();
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r103 = false;
        goto L9
    }

    public static final Object c(wc9.e r100, Continuation<? super List<String>> r101) {
        Integer r102 = r100.f559207j;
        if (r102 != null) goto L6;
    L7:
        Integer r103 = r100.f559207j;
        if (r103 != null) goto L11;
    L13:
        vc8.d r104 = vc8.d.f554129a;
        String r105 = r100.f559198a;
        r104.getClass();
        List r106 = vc8.d.a(r105);
        List r107 = r106;
        if (r107 != null) goto L16;
    L19:
        boolean r108 = true;
    L20:
        if (r108 == true) goto L22;
        return r106;
    L22:
        String r109 = r100.f559198a;
        Intrinsics.checkNotNullParameter(r109, "conversationId");
        boolean r110 = vc8.d.f554132d;
        if (r110 == true) goto L25;
        Deferred r111 = null;
    L26:
        if (r111 != null) goto L28;
    L31:
        CompletableDeferred r112 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        String r113 = r100.f559198a;
        Intrinsics.checkNotNullParameter(r113, "conversationId");
        Intrinsics.checkNotNullParameter(r112, "deferred");
        if (r110 == false) goto L35;
        ((LruCache) vc8.d.f554131c.getValue()).put(r113, r112);
    L35:
        com.larus.im.d.a().getBotIdsByConversationId(r100.f559198a, new b(r100, r112));
        return r112.await(r101);
    L28:
        if (r111.isActive() == false) goto L31;
        return r111.await(r101);
    L25:
        r111 = (Deferred) ((LruCache) vc8.d.f554131c.getValue()).get(r109);
        goto L26
    L16:
        if (r107.isEmpty() == true) goto L19;
        r108 = false;
        goto L20
    L11:
        if (r103.intValue() != 2) goto L13;
    L38:
        return CollectionsKt.emptyList();
    L6:
        if (r102.intValue() == 1) goto L38;
        goto L7
    }

    public static final String g(wc9.e r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "defaultName");
        String r102 = null;
        boolean r103 = false;
        if (r100 != null) goto L6;
    L24:
        if (r103 == true) goto L26;
    L28:
        if (r100 == null) goto L39;
        String r104 = r100.f559200c;
        if (r104 != null) goto L32;
        return r101;
    L32:
        if ((!StringsKt.isBlank(r104)) == false) goto L34;
        r102 = r104;
    L34:
        if (r102 != null) goto L37;
        return r101;
    L37:
        return r102;
    L39:
        return r101;
    L26:
        if (z2.f365865a.y3() == false) goto L28;
        String r105 = AppHost.f326268a.getApplication().getString(R.string.larus_mainchat_sidebar_chatTitle);
        Intrinsics.checkNotNull(r105);
        return r105;
    L6:
        if (u(r100) == true) goto L23;
        wc9.e r106 = AuthModelDelegate.f297134b.u().getValue();
        if (r106 == null) goto L11;
        String r107 = r106.f559198a;
    L12:
        if (r107 != null) goto L14;
    L19:
        boolean r108 = false;
    L20:
        if (r108 == false) goto L24;
        if (Intrinsics.areEqual(r100.f559198a, r107) == false) goto L24;
    L14:
        if (r107.length() <= 0) goto L16;
        boolean r109 = true;
    L17:
        if (r109 != true) goto L19;
        r108 = true;
        goto L20
    L16:
        r109 = false;
        goto L17
    L11:
        r107 = null;
    L23:
        r103 = true;
        goto L24
    }

    public static final boolean x(wc9.e r100, wc9.e r101, boolean r102) {
        if (n(r100) == n(r101)) goto L5;
    L10:
        return false;
    L5:
        if (t(r100) != t(r101)) goto L10;
        if (r102 == true) goto L8;
    L9:
        return true;
    L8:
        if (Intrinsics.areEqual(a(r100), a(r101)) == false) goto L10;
        goto L9
    }
}
