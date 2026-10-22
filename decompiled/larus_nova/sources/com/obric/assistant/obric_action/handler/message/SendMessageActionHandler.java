package com.obric.assistant.obric_action.handler.message;

import android.content.Context;
import android.util.LruCache;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wc9.e;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/obric_action/handler/message/SendMessageActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/message/SendMessageActionHandler$Params;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/message/SendMessageActionHandler$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasSuccessfullySent", "", "oActionUUID", "", "recordSuccessfulOActionUUID", "Companion", "Params", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendMessageActionHandler implements IObricActionHandler<b, Unit> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LruCache<String, Boolean> f390483c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<b> f390484b;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\u001e\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0019J~\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R(\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006*"}, d2 = {"Lcom/obric/assistant/obric_action/handler/message/SendMessageActionHandler$Params;", "", "content", "", "cvsId", "scene", "ext", "", "sendFuncChannel", "traceId", "oActionUUID", "preventDuplicateSend", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getContent", "()Ljava/lang/String;", "getCvsId", "getScene", "getExt", "()Ljava/util/Map;", "getSendFuncChannel", "getTraceId", "getOActionUUID", "getPreventDuplicateSend", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/obric/assistant/obric_action/handler/message/SendMessageActionHandler$Params;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("content")
        private final String content;

        @SerializedName("cvsId")
        private final String cvsId;

        @SerializedName("ext")
        private final Map<String, String> ext;

        @SerializedName("oActionUUID")
        private final String oActionUUID;

        @SerializedName("preventDuplicateSend")
        private final Boolean preventDuplicateSend;

        @SerializedName("scene")
        private final String scene;

        @SerializedName("sendFuncChannel")
        private final String sendFuncChannel;

        @SerializedName("traceId")
        private final String traceId;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.content, r101.content) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.cvsId, r101.cvsId) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.sendFuncChannel, r101.sendFuncChannel) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.traceId, r101.traceId) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.oActionUUID, r101.oActionUUID) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.preventDuplicateSend, r101.preventDuplicateSend) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            String r100 = this.content;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.cvsId;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.scene;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            Map<String, String> r110 = this.ext;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.sendFuncChannel;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.traceId;
            if (r116 != null) goto L25;
            int r117 = 0;
        L26:
            int r118 = (r115 + r117) * 31;
            String r119 = this.oActionUUID;
            if (r119 != null) goto L29;
            int r120 = 0;
        L30:
            int r121 = (r118 + r120) * 31;
            Boolean r122 = this.preventDuplicateSend;
            if (r122 == null) goto L35;
            r101 = r122.hashCode();
        L35:
            return r121 + r101;
        L29:
            r120 = r119.hashCode();
            goto L30
        L25:
            r117 = r116.hashCode();
            goto L26
        L21:
            r114 = r113.hashCode();
            goto L22
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Params(content=" + this.content + ", cvsId=" + this.cvsId + ", scene=" + this.scene + ", ext=" + this.ext + ", sendFuncChannel=" + this.sendFuncChannel + ", traceId=" + this.traceId + ", oActionUUID=" + this.oActionUUID + ", preventDuplicateSend=" + this.preventDuplicateSend + ')';
        }

        public b() {
            this.content = null;
            this.cvsId = null;
            this.scene = null;
            this.ext = null;
            this.sendFuncChannel = null;
            this.traceId = null;
            this.oActionUUID = null;
            this.preventDuplicateSend = null;
        }

        public final String a() {
            return this.content;
        }

        public final String b() {
            return this.cvsId;
        }

        public final Map<String, String> c() {
            return this.ext;
        }

        public final String d() {
            return this.oActionUUID;
        }

        public final Boolean e() {
            return this.preventDuplicateSend;
        }

        public final String f() {
            return this.scene;
        }

        public final String g() {
            return this.sendFuncChannel;
        }

        public final String h() {
            return this.traceId;
        }
    }

    static {
        f390483c = new LruCache(10);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r100 = d.f.f390427a;
        return d.f.f390427a;
    }

    public SendMessageActionHandler() {
        this.f390484b = b.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<b> b() {
        return this.f390484b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final b a(Context r100, String r101) {
        return (b) IObricActionHandler.b.a(this, r100, r101);
    }

    public final Object e(b r310, Continuation r311) {
        b r100 = r310;
        if ((r311 instanceof SendMessageActionHandler$execute$1) == false) goto L7;
        SendMessageActionHandler$execute$1 r101 = (SendMessageActionHandler$execute$1) r311;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        String r110 = "";
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        String r106 = (String) r101.L$1;
        b r107 = (b) r101.L$0;
        ResultKt.throwOnFailure(r103);
        String r108 = r106;
        r100 = r107;
        Object r109 = r103;
    L41:
        e r111 = (e) r109;
        if (r111 == null) goto L44;
        String r112 = r111.f559198a;
    L45:
        if (r112 != null) goto L47;
        String r113 = "";
    L48:
        FLogger.f375446a.i("SendMessageActionHandler", "get main conversation id = ".concat(r113));
    L49:
        String r114 = r108;
        String r115 = r113;
        if (r115.length() != 0) goto L52;
        boolean r116 = true;
    L53:
        if (r116 == false) goto L56;
        FLogger.f375446a.w("SendMessageActionHandler", "handle send message failed. cvsId is empty.");
        return h.a.a(h.f390443d, "cvsId is empty", 2);
    L56:
        boolean r117 = Intrinsics.areEqual(r100.e(), Boxing.boxBoolean(true));
        String r118 = r100.d();
        if (r118 != null) goto L59;
        r118 = "";
    L59:
        if (r117 == true) goto L61;
    L64:
        if (r117 == true) goto L66;
    L69:
        String r119 = r100.h();
        if (r119 != null) goto L73;
        r119 = "";
    L73:
        if (r119.length() != 0) goto L75;
        boolean r120 = true;
    L76:
        if (r120 == false) goto L78;
        r119 = UUID.randomUUID().toString();
    L78:
        String r121 = r119;
        String r122 = r100.f();
        if (r122 != null) goto L82;
        r122 = "";
    L82:
        if (r122.length() != 0) goto L84;
        boolean r123 = true;
    L86:
        if (r123 == false) goto L88;
        String r124 = "obric_send_msg_intent_handler";
    L89:
        String r125 = r100.g();
        if (r125 == null) goto L94;
        r110 = r125;
    L94:
        if (r110.length() != 0) goto L96;
        boolean r126 = true;
    L97:
        if (r126 == false) goto L99;
        String r210 = "obric_send_msg_intent_handler";
    L100:
        h.a r127 = h.f390443d;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L112
        u1 r129 = RepoDispatcherDelegate.f307737b.e().u1();     // Catch: Throwable -> L112
        LinkedHashMap r130 = new LinkedHashMap();     // Catch: Throwable -> L112
        Map<String, String> r131 = r100.c();     // Catch: Throwable -> L112
        if (r131 == null) goto L110;
        Iterator<Map.Entry<String, String>> r132 = r131.entrySet().iterator();     // Catch: Throwable -> L112
    L105:
        if (r132.hasNext() == false) goto L110;
        Map.Entry<String, String> r133 = r132.next();     // Catch: Throwable -> L112
        String r134 = r133.getKey();     // Catch: Throwable -> L112
        String r135 = r133.getValue();     // Catch: Throwable -> L112
        if (r134 == null) goto L105;
        if (r135 == null) goto L105;
        r130.put(r134, r135);     // Catch: Throwable -> L112
    L110:
        Unit r136 = Unit.INSTANCE;     // Catch: Throwable -> L112
        u1.a.f(r129, r114, r115, r124, r130, new com.obric.assistant.obric_action.handler.message.a(), null, r121, false, new ReferenceInfo(null, null, null, 0, null, null, null, null, 255, null), r210, null, null, null, false, 31040);     // Catch: Throwable -> L112
        Object r137 = Result.m9449constructorimpl(Boxing.boxBoolean(true));     // Catch: Throwable -> L112
    L114:
        Throwable r138 = Result.m9452exceptionOrNullimpl(r137);
        if (r138 == null) goto L118;
        FLogger.f375446a.w("SendMessageActionHandler", "handle send message failed. " + r138.getMessage(), r138);
    L118:
        if (Result.m9456isSuccessimpl(r137) == false) goto L124;
        ((Boolean) r137).booleanValue();
        FLogger.f375446a.i("SendMessageActionHandler", "handle send message success.");
        if (r117 == false) goto L124;
        if ((!StringsKt.isBlank(r118)) == false) goto L124;
        f390483c.put(r118, Boolean.TRUE);
    L124:
        Boolean r139 = Boxing.boxBoolean(false);
        if (Result.m9455isFailureimpl(r137) == false) goto L128;
        r137 = r139;
    L128:
        return r127.b(((Boolean) r137).booleanValue());
    L112:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L114
    L99:
        r210 = r110;
        goto L100
    L96:
        r126 = false;
        goto L97
    L88:
        r124 = r122;
        goto L89
    L84:
        r123 = false;
        goto L86
    L75:
        r120 = false;
        goto L76
    L66:
        if (Intrinsics.areEqual(f390483c.get(r118), Boolean.TRUE) == false) goto L69;
        FLogger.f375446a.w("SendMessageActionHandler", "handle send message failed. duplicate send prevented for oActionUUID.");
        return h.a.a(h.f390443d, "duplicate send prevented for oActionUUID", 2);
    L61:
        if (StringsKt.isBlank(r118) == false) goto L64;
        FLogger.f375446a.w("SendMessageActionHandler", "handle send message failed. oActionUUID is empty while preventing duplicate send.");
        return h.a.a(h.f390443d, "oActionUUID is empty when preventDuplicateSend is true", 2);
    L52:
        r116 = false;
        goto L53
    L47:
        r113 = r112;
    L44:
        r112 = null;
        goto L45
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        if (r100 == null) goto L17;
        r108 = r310.a();
        if (r108 != null) goto L22;
        r108 = "";
    L22:
        if (r108.length() != 0) goto L24;
        boolean r141 = true;
    L25:
        if (r141 == false) goto L28;
        FLogger.f375446a.w("SendMessageActionHandler", "handle send message failed. content is empty.");
        return h.a.a(h.f390443d, "content is empty", 2);
    L28:
        r113 = r310.b();
        if (r113 != null) goto L32;
        r113 = "";
    L32:
        if (r113.length() != 0) goto L34;
        boolean r142 = true;
    L35:
        if (r142 == false) goto L49;
        IObricChatService r143 = (IObricChatService) ServiceManager.get().getService(IObricChatService.class);
        if (r143 == null) goto L44;
        r101.L$0 = r100;
        r101.L$1 = r108;
        r101.label = 1;
        r109 = r143.d(r101);
        if (r109 != r104) goto L41;
        return r104;
    L34:
        r142 = false;
        goto L35
    L24:
        r141 = false;
        goto L25
    L17:
        return h.a.a(h.f390443d, "params is null", 2);
    L7:
        r101 = new SendMessageActionHandler$execute$1(this, r311);
        goto L8
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final /* bridge */ /* synthetic */ Object d(Context r100, b r101, Continuation<? super h<? extends Unit>> r102) {
        return e(r101, r102);
    }
}
