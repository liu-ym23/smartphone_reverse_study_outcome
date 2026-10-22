package com.larus.bmhome.social.userchat.model;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.im.bean.message.Message;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.AccountService;
import com.larus.platform.spi.IAIChatConversationService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes26.dex */
public final class LocalSubConvHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LocalSubConvHelper f314106a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, x> f314107b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MutexImpl f314108c = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/social/userchat/model/LocalSubConvHelper$UploadMsgBean;", "", "localMsgId", "", "sourceMsgId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getLocalMsgId", "()Ljava/lang/String;", "getSourceMsgId", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("local_msg_id")
        private final String localMsgId;

        @SerializedName("from_msg_id")
        private final String sourceMsgId;

        public a() {
            this("", "");
        }

        public a(String r100, String r101) {
            this.localMsgId = r100;
            this.sourceMsgId = r101;
        }
    }

    public LocalSubConvHelper() {
    }

    static {
        f314106a = new LocalSubConvHelper();
        f314107b = new LinkedHashMap();
        f314108c = kotlinx.coroutines.sync.b.a();
    }

    public static String b(String r100) {
        if (StringsKt.isBlank(r100) == false) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(AccountService.f365697a.getSecUserId(), r100) == false) goto L30;
        com.larus.bmhome.auth.h0 r101 = AuthModelDelegate.f297134b.v();
        if (r101 != null) goto L10;
        return null;
    L10:
        if (Intrinsics.areEqual(r101.h(), r100) == true) goto L13;
        r101 = null;
    L13:
        if (r101 == null) goto L27;
        String r102 = r101.b();
        if (r102 == null) goto L28;
        boolean r103 = true;
        if ((!StringsKt.isBlank(r102)) == true) goto L19;
    L21:
        r103 = false;
    L22:
        if (r103 == true) goto L24;
        return null;
    L24:
        return r102;
    L19:
        if (Intrinsics.areEqual(r102, "0") == true) goto L21;
    L28:
        return null;
    L27:
        return null;
    L30:
        return null;
    }

    public static Map d(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
        x r102 = (x) ((LinkedHashMap) f314107b).get(r100);
        if (r102 == null) goto L16;
        Map<String, String> r103 = r102.f314178b;
        if (r103 == null) goto L16;
        return r103;
    L16:
        return MapsKt.emptyMap();
    L10:
        return MapsKt.emptyMap();
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static String g(wc9.e r100) {
        boolean r101 = false;
        if (r100 == null) goto L10;
        Integer r102 = r100.f559207j;
        if (r102 == null) goto L10;
        if (r102.intValue() != 1) goto L10;
        boolean r103 = true;
    L12:
        if (r103 == true) goto L66;
        if (r100 == null) goto L20;
        Integer r104 = r100.f559207j;
        if (r104 == null) goto L20;
        if (r104.intValue() != 2) goto L20;
        boolean r105 = true;
    L21:
        if (r105 == true) goto L72;
        if (r100 == null) goto L30;
        Integer r106 = r100.f559219v;
        if (r106 == null) goto L30;
        if (r106.intValue() != 1) goto L30;
        boolean r107 = true;
    L31:
        if (r107 == true) goto L40;
        if (r100 == null) goto L39;
        Integer r108 = r100.f559219v;
        if (r108 == null) goto L39;
        if (r108.intValue() != 3) goto L39;
        r101 = true;
    L39:
        if (r101 == true) goto L40;
    L43:
        if (r100 == null) goto L67;
        String r109 = r100.f559198a;
        if (r109 != null) goto L47;
        return null;
    L47:
        if ((!StringsKt.isBlank(r109)) == true) goto L50;
        r109 = null;
    L50:
        if (r109 == null) goto L73;
        String r110 = BotInfoCache.INSTANCE.getBotId(r109);
        if ((!StringsKt.isBlank(r110)) == true) goto L56;
        r110 = null;
    L56:
        if (r110 == null) goto L59;
        return r110;
    L59:
        if (com.larus.im.j.f(r109) == false) goto L69;
        String r111 = com.larus.im.j.b(r109);
        if (r111 != null) goto L63;
        return null;
    L63:
        if ((!StringsKt.isBlank(r111)) == true) goto L65;
        return null;
    L65:
        return r111;
    L69:
        return null;
    L73:
        return null;
    L67:
        return null;
    L40:
        String r112 = b(AccountService.f365697a.getSecUserId());
        if (r112 == null) goto L43;
        return r112;
    L30:
        r107 = false;
        goto L31
    L72:
        return null;
    L20:
        r105 = false;
        goto L21
    L66:
        return null;
    L10:
        r103 = false;
        goto L12
    }

    public static boolean i(String r100) {
        if (com.larus.platform.exp.o.a() == true) goto L6;
        return false;
    L6:
        if (r100 != null) goto L8;
    L11:
        boolean r101 = true;
    L12:
        if (r101 == false) goto L14;
        return true;
    L14:
        AuthModelDelegate r102 = AuthModelDelegate.f297134b;
        wc9.e r103 = r102.y().getValue();
        String r104 = null;
        if (r103 == null) goto L17;
        String r105 = r103.f559198a;
    L19:
        if (Intrinsics.areEqual(r100, r105) == true) goto L29;
        wc9.e r106 = r102.u().getValue();
        if (r106 == null) goto L24;
        r104 = r106.f559198a;
    L24:
        if (Intrinsics.areEqual(r100, r104) == true) goto L29;
        if (com.larus.im.j.g(r100) == true) goto L29;
        if (e(r100, b(AccountService.f365697a.getSecUserId())) == true) goto L29;
        return false;
    L29:
        return true;
    L17:
        r105 = null;
        goto L19
    L8:
        if (StringsKt.isBlank(r100) == true) goto L11;
        r101 = false;
        goto L12
    }

    public static boolean e(String r100, String r101) {
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return false;
    L12:
        if (com.larus.im.j.f(r100) == true) goto L14;
    L16:
        return false;
    L14:
        if (Intrinsics.areEqual(com.larus.im.j.b(r100), r101) == false) goto L16;
        return true;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static boolean h(String r100, wc9.e r101) {
        if (com.larus.im.j.f(r100) == true) goto L5;
        return false;
    L5:
        if (com.larus.platform.exp.o.a() == true) goto L8;
        return false;
    L8:
        if (r101 == null) goto L15;
        Integer r102 = r101.f559219v;
        if (r102 == null) goto L15;
        if (r102.intValue() != 1) goto L15;
        boolean r103 = true;
    L16:
        if (r103 == true) goto L28;
        if (r101 == null) goto L24;
        Integer r104 = r101.f559219v;
        if (r104 == null) goto L24;
        if (r104.intValue() != 3) goto L24;
        boolean r105 = true;
    L25:
        if (r105 == true) goto L28;
        if (i(r100) == true) goto L28;
        return false;
    L24:
        r105 = false;
    L28:
        return true;
    L15:
        r103 = false;
        goto L16
    }

    public final Object a(String r100, Continuation<? super String> r101) {
        if ((r101 instanceof LocalSubConvHelper$awaitCurrentAccountMainBotId$1) == false) goto L7;
        LocalSubConvHelper$awaitCurrentAccountMainBotId$1 r102 = (LocalSubConvHelper$awaitCurrentAccountMainBotId$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
    L28:
        return r104;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        c1<com.larus.bmhome.auth.h0> r107 = (c1) r102.L$1;
        String r108 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
        c1<com.larus.bmhome.auth.h0> r109 = r107;
        r100 = r108;
    L25:
        LocalSubConvHelper$awaitCurrentAccountMainBotId$4 r110 = new LocalSubConvHelper$awaitCurrentAccountMainBotId$4(r100, r109, null);
        r102.L$0 = null;
        r102.L$1 = null;
        r102.label = 2;
        r104 = TimeoutKt.c(10000, r110, r102);
        if (r104 != r105) goto L28;
        return r105;
    L16:
        ResultKt.throwOnFailure(r104);
        if (StringsKt.isBlank(r100) == false) goto L19;
        return null;
    L19:
        String r111 = b(r100);
        if (r111 == null) goto L22;
        return r111;
    L22:
        r109 = AuthModelDelegate.f297134b.a().getValue();
        MainCoroutineDispatcher r112 = Dispatchers.getMain().getImmediate();
        LocalSubConvHelper$awaitCurrentAccountMainBotId$3 r113 = new LocalSubConvHelper$awaitCurrentAccountMainBotId$3(r100, r109, null);
        r102.L$0 = r100;
        r102.L$1 = r109;
        r102.label = 1;
        if (BuildersKt.withContext(r112, r113, r102) != r105) goto L25;
        return r105;
    L7:
        r102 = new LocalSubConvHelper$awaitCurrentAccountMainBotId$1(this, r101);
        goto L8
    }

    public final Object f(wc9.e r100, Continuation<? super String> r101) {
        if ((r101 instanceof LocalSubConvHelper$resolveBotId$1) == false) goto L7;
        LocalSubConvHelper$resolveBotId$1 r102 = (LocalSubConvHelper$resolveBotId$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
    L32:
        List r107 = (List) r104;
        if (r107 != null) goto L41;
        return null;
    L41:
        return (String) CollectionsKt.firstOrNull(r107);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
    L22:
        List r108 = (List) r104;
        if (r108 != null) goto L25;
        return null;
    L25:
        return (String) CollectionsKt.firstOrNull(r108);
    L16:
        ResultKt.throwOnFailure(r104);
        if (com.larus.platform.exp.o.a() == true) goto L26;
        if (r100 == null) goto L37;
        r102.label = 1;
        r104 = ic8.n.c(r100, r102);
        if (r104 != r105) goto L22;
        return r105;
    L37:
        return null;
    L26:
        String r109 = g(r100);
        if (r109 != null) goto L36;
        if (r100 == null) goto L39;
        r102.label = 2;
        r104 = ic8.n.c(r100, r102);
        if (r104 != r105) goto L32;
        return r105;
    L39:
        return null;
    L36:
        return r109;
    L7:
        r102 = new LocalSubConvHelper$resolveBotId$1(this, r101);
        goto L8
    }

    public static void j(String r100, List r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "convId");
        Intrinsics.checkNotNullParameter(r110, "list");
        LinkedHashMap r101 = new LinkedHashMap();
        if (r111 == false) goto L18;
        Iterator r112 = r110.iterator();
    L6:
        if (r112.hasNext() == false) goto L13;
        Object r102 = r112.next();
        if (com.larus.bmhome.chat.bean.d.x((Message) r102).getSkillCardCnt() <= 0) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L6;
    L15:
        if (((Message) r102) == null) goto L17;
        r101.put("sub_conv_firstmet_type", "2");
        goto L18
    L17:
        r101.put("sub_conv_firstmet_type", "1");
        goto L18
    L10:
        r103 = false;
        goto L11
    L13:
        r102 = null;
    L18:
        Gson r113 = HttpExtKt.f360123f;
        ArrayList r104 = new ArrayList();
        Iterator r105 = r110.iterator();
    L20:
        if (r105.hasNext() == false) goto L27;
        Object r106 = r105.next();
        if (((Message) r106).getContentType() == 2) goto L24;
        boolean r107 = true;
    L25:
        if (r107 == false) goto L20;
        r104.add(r106);
        goto L20
    L24:
        r107 = false;
        goto L25
    L27:
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r109 = r104.iterator();
    L29:
        if (r109.hasNext() == false) goto L37;
        Message r114 = (Message) r109.next();
        String r115 = com.larus.bmhome.chat.bean.d.x(r114).getSourceMessageId();
        String r116 = r114.getLocalMessageId();
        if (r115.length() != 0) goto L33;
        boolean r117 = true;
    L34:
        if (r117 == false) goto L36;
        r115 = null;
    L36:
        r108.add(new a(r116, r115));
        goto L29
    L33:
        r117 = false;
        goto L34
    L37:
        r101.put("sub_conv_source_message", GsonProtectorUtils.toJson(r113, r108));
        f314107b.put(r100, new x(r100, r110, r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.larus.bmhome.social.userchat.model.LocalSubConvHelper] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v6, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v6 */
    public final Object c(String r110, wc9.e r111, Continuation<? super wc9.e> r112) {
        if ((r112 instanceof LocalSubConvHelper$findOrCreateMainBotSubConversation$1) == false) goto L7;
        LocalSubConvHelper$findOrCreateMainBotSubConversation$1 r100 = (LocalSubConvHelper$findOrCreateMainBotSubConversation$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = false;
        if (r103 == 0) goto L24;
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L22;
        if (r103 == 3) goto L19;
        if (r103 != 4) goto L18;
        kotlinx.coroutines.sync.a r114 = (kotlinx.coroutines.sync.a) r100.L$1;
        String r115 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L66
        r110 = r114;
        ?? r116 = r115;
    L65:
        wc9.e r117 = (wc9.e) r113;     // Catch: Throwable -> L66
        ?? r105 = r116;
    L69:
        if (com.larus.platform.exp.o.a() == false) goto L73;
        if (Intrinsics.areEqual(AccountService.f365697a.getSecUserId(), r105) == false) goto L73;
        r104 = true;
    L73:
        if (r104 == true) goto L76;
    L75:
        r117 = null;
    L76:
        r110.unlock(null);
        return r117;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r118 = (kotlinx.coroutines.sync.a) r100.L$3;
        String r119 = (String) r100.L$2;
        wc9.e r106 = (wc9.e) r100.L$1;
        String r107 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L66
        r105 = r107;
        r110 = r118;
    L45:
        r117 = (wc9.e) r113;     // Catch: Throwable -> L66
        if (r117 == null) goto L56;
        Integer r108 = r117.f559219v;     // Catch: Throwable -> L66
        if (r108 != null) goto L51;
    L53:
        boolean r109 = false;
    L54:
        if (r109 == false) goto L56;
    L57:
        if (r117 != null) goto L69;
        IAIChatConversationService.Companion r120 = IAIChatConversationService.f365892a;     // Catch: Throwable -> L66
        if (r106 != null) goto L61;
        r106 = AuthModelDelegate.f297134b.u().getValue();     // Catch: Throwable -> L66
    L61:
        List r121 = CollectionsKt.emptyList();     // Catch: Throwable -> L66
        r100.L$0 = r105;     // Catch: Throwable -> L66
        r100.L$1 = r110;     // Catch: Throwable -> L66
        r100.L$2 = null;     // Catch: Throwable -> L66
        r100.L$3 = null;     // Catch: Throwable -> L66
        r100.label = 4;     // Catch: Throwable -> L66
        r113 = r120.a(r119, r106, r121, r100);     // Catch: Throwable -> L66
        if (r113 != r102) goto L64;
        return r102;
    L64:
        r116 = r105;
        r110 = r110;
        goto L65
    L51:
        if (r108.intValue() != 3) goto L53;
        r109 = true;
    L56:
        r117 = null;
        goto L57
    L22:
        kotlinx.coroutines.sync.a r122 = (kotlinx.coroutines.sync.a) r100.L$3;
        r119 = (String) r100.L$2;
        r106 = (wc9.e) r100.L$1;
        String r123 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);
        ?? r124 = r123;
        r110 = r122;
    L38:
        if (com.larus.platform.exp.o.a() == false) goto L75;
        if (Intrinsics.areEqual(AccountService.f365697a.getSecUserId(), r124) == false) goto L75;
        IConversationRepoService r125 = zh8.a.f572197b;     // Catch: Throwable -> L66
        r100.L$0 = r124;     // Catch: Throwable -> L66
        r100.L$1 = r106;     // Catch: Throwable -> L66
        r100.L$2 = r119;     // Catch: Throwable -> L66
        r100.L$3 = r110;     // Catch: Throwable -> L66
        r100.label = 3;     // Catch: Throwable -> L66
        r113 = r125.m(r119, r100);     // Catch: Throwable -> L66
        r105 = r124;
        r110 = r110;
        if (r113 != r102) goto L45;
        return r102;
    L23:
        r111 = (wc9.e) r100.L$1;
        String r126 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);
        ?? r127 = r126;
    L30:
        String r128 = (String) r113;
        if (r128 != null) goto L33;
        return null;
    L33:
        MutexImpl r129 = f314108c;
        r100.L$0 = r127;
        r100.L$1 = r111;
        r100.L$2 = r128;
        r100.L$3 = r129;
        r100.label = 2;
        if (r129.a(null, r100) != r102) goto L36;
        return r102;
    L36:
        r124 = r127;
        r110 = r129;
        r106 = r111;
        r119 = r128;
        goto L38
    L24:
        ResultKt.throwOnFailure(r113);
        if (com.larus.platform.exp.o.a() == true) goto L27;
        return null;
    L27:
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.label = 1;
        r113 = a(r110, r100);
        r127 = r110;
        if (r113 != r102) goto L30;
        return r102;
    L66:
        th = move-exception;
        r110.unlock(null);
        throw th;
    L7:
        r100 = new LocalSubConvHelper$findOrCreateMainBotSubConversation$1(this, r112);
        goto L8
    }
}
