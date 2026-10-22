package com.obric.assistant.obric_action.handler;

import android.app.Activity;
import android.content.Context;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.oauto.IOAutoApi;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import com.obric.assistant.utils.k;
import com.ss.android.lark.utils.statistics.PerfLog;
import gd9.i;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u0004\u0018\u00010\u0015*\u00020\u0019H\u0002R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/obric_action/handler/OpenCreateShortcutHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/OpenCreateShortcutHandler$Params;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/OpenCreateShortcutHandler$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveTaskModelJson", "", "messageId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "taskModelJson", "Lcom/larus/im/bean/message/Message;", "Companion", "Params", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenCreateShortcutHandler implements IObricActionHandler<b, Unit> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f390447b = 0;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/obric_action/handler/OpenCreateShortcutHandler$Params;", "", "query", "", "messageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "getMessageId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("messageId")
        private final String messageId;

        @SerializedName("query")
        private final String query;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.query, r101.query) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.query;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.messageId;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Params(query=" + this.query + ", messageId=" + this.messageId + ')';
        }

        public b() {
            this.query = null;
            this.messageId = null;
        }

        public final String a() {
            return this.messageId;
        }

        public final String b() {
            return this.query;
        }
    }

    static {
    }

    public OpenCreateShortcutHandler() {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r100 = d.g.f390429a;
        return d.g.f390430b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<b> b() {
        return b.class;
    }

    public static String g(Message r100) {
        Map<String, String> r101 = r100.getExt();
        if (r101 == null) goto L12;
        String r102 = r101.get("o_complex_task_model");
        if (r102 == null) goto L12;
        if (r102.length() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        return r102;
    L9:
        r103 = false;
    L12:
        return null;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final b a(Context r100, String r101) {
        return (b) IObricActionHandler.b.a(this, r100, r101);
    }

    public final Object f(String r100, Continuation<? super String> r110) {
        if ((r110 instanceof OpenCreateShortcutHandler$resolveTaskModelJson$1) == false) goto L7;
        OpenCreateShortcutHandler$resolveTaskModelJson$1 r101 = (OpenCreateShortcutHandler$resolveTaskModelJson$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        boolean r105 = true;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L17;
        if (r104 != 2) goto L16;
        OpenCreateShortcutHandler r106 = (OpenCreateShortcutHandler) r101.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L63
    L57:
        Message r112 = (Message) r111;     // Catch: Throwable -> L63
        if (r112 == null) goto L60;
        r106.getClass();     // Catch: Throwable -> L63
        String r107 = g(r112);     // Catch: Throwable -> L63
    L61:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L63
    L65:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r108);
        if (r113 == null) goto L69;
        FLogger.f375446a.w("OpenCreateShortcutHandler", "resolveTaskModelJson failed. " + r113.getMessage(), r113);
    L69:
        if (Result.m9455isFailureimpl(r108) == false) goto L72;
        return null;
    L72:
        return r108;
    L60:
        r107 = null;
        goto L61
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r106 = (OpenCreateShortcutHandler) r101.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L63
    L25:
        Message r114 = (Message) r111;     // Catch: Throwable -> L63
        if (r114 == null) goto L31;
        r106.getClass();     // Catch: Throwable -> L63
        String r109 = g(r114);     // Catch: Throwable -> L63
        if (r109 == null) goto L31;
        return r109;
    L31:
        if (r114 == null) goto L40;
        String r115 = k.a(r114);     // Catch: Throwable -> L63
        if (r115.length() <= 0) goto L35;
        boolean r116 = true;
    L36:
        if (r116 == true) goto L39;
        r115 = null;
    L39:
        if (r115 == null) goto L40;
    L54:
        IChatRepoService r117 = zh8.a.f572196a;     // Catch: Throwable -> L63
        r101.L$0 = r106;     // Catch: Throwable -> L63
        r101.label = 2;     // Catch: Throwable -> L63
        r111 = r117.E1(r115, r101);     // Catch: Throwable -> L63
        if (r111 != r103) goto L57;
        return r103;
    L35:
        r116 = false;
    L40:
        if (r114 == null) goto L51;
        String r118 = r114.getReplyId();     // Catch: Throwable -> L63
        if (r118 == null) goto L51;
        if (r118.length() > 0) goto L47;
        r105 = false;
    L47:
        if (r105 == true) goto L50;
        r118 = null;
    L50:
        r115 = r118;
    L52:
        if (r115 != null) goto L54;
        return null;
    L51:
        r115 = null;
        goto L52
    L20:
        ResultKt.throwOnFailure(r111);
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L63
        IChatRepoService r120 = zh8.a.f572196a;     // Catch: Throwable -> L63
        r101.L$0 = this;     // Catch: Throwable -> L63
        r101.label = 1;     // Catch: Throwable -> L63
        r111 = r120.E1(r100, r101);     // Catch: Throwable -> L63
        if (r111 != r103) goto L24;
        return r103;
    L24:
        r106 = this;
    L63:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r101 = new OpenCreateShortcutHandler$resolveTaskModelJson$1(this, r110);
        goto L8
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final /* bridge */ /* synthetic */ Object d(Context r100, b r101, Continuation<? super h<? extends Unit>> r102) {
        return e(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v25, types: [com.obric.assistant.obric_action.handler.a] */
    public final Object e(Context r110, b r210, Continuation<? super h<Unit>> r211) {
        if ((r211 instanceof OpenCreateShortcutHandler$execute$1) == false) goto L7;
        OpenCreateShortcutHandler$execute$1 r100 = (OpenCreateShortcutHandler$execute$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = false;
        if (r104 == 0) goto L16;
        if (r104 != 1) goto L15;
        String r106 = (String) r100.L$2;
        String r107 = (String) r100.L$1;
        Context r108 = (Context) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L64
        String r111 = r106;
        Context r109 = r108;
        String r112 = r107;
    L46:
        String r113 = (String) r102;     // Catch: Throwable -> L64
        FLogger r114 = FLogger.f375446a;     // Catch: Throwable -> L64
        StringBuilder r115 = new StringBuilder("openCreateShortcutPage, hasTaskModel: ");     // Catch: Throwable -> L64
        if (r113 != null) goto L49;
    L50:
        r105 = true;
    L51:
        r115.append(!r105);     // Catch: Throwable -> L64
        r114.i("OpenCreateShortcutHandler", r115.toString());     // Catch: Throwable -> L64
        IOAutoApi r116 = com.obric.assistant.oauto.b.a();     // Catch: Throwable -> L64
        if (r116 != 0) goto L55;
        r114.w("OpenCreateShortcutHandler", "openCreateShortcutPage failed, OAutoApi is null");     // Catch: Throwable -> L64
        h r117 = h.a.a(h.f390443d, "OAutoApi is null", 2);     // Catch: Throwable -> L64
    L62:
        Object r118 = Result.m9449constructorimpl(r117);     // Catch: Throwable -> L64
    L66:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);
        if (r119 == null) goto L69;
        FLogger.f375446a.w("OpenCreateShortcutHandler", "openCreateShortcutPage failed. " + r119.getMessage(), r119);
    L69:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r118);
        if (r120 != null) goto L73;
        return r118;
    L73:
        return h.a.a(h.f390443d, r120.getMessage(), 2);
    L55:
        if ((r109 instanceof Activity) == false) goto L57;
        final Activity r121 = (Activity) r109;     // Catch: Throwable -> L64
    L58:
        if (r121 == null) goto L60;
        r116.d(r121, r112, r111, r113, new com.obric.assistant.obric_action.handler.a(r121));     // Catch: Throwable -> L64
    L61:
        r117 = h.a.c(h.f390443d, null, "openCreateShortcutPage susscess", 1);     // Catch: Throwable -> L64
        goto L62
    L60:
        r114.i("OpenCreateShortcutHandler", "openCreateShortcutPage: context is not Activity, jump without result");     // Catch: Throwable -> L64
        r116.a(r109, r112, r111, r113);     // Catch: Throwable -> L64
        goto L61
    L57:
        r121 = null;
        goto L58
    L49:
        if (r113.length() != 0) goto L51;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r102);
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L64
        if (r210 == null) goto L20;
        String r123 = r210.b();     // Catch: Throwable -> L64
    L21:
        if (r210 == null) goto L23;
        String r124 = r210.a();     // Catch: Throwable -> L64
    L24:
        if (r124 != null) goto L26;
        r124 = "";
    L26:
        FLogger r125 = FLogger.f375446a;     // Catch: Throwable -> L64
        StringBuilder r126 = new StringBuilder("openCreateShortcutPage, query isNullOrEmpty: ");     // Catch: Throwable -> L64
        if (r123 != null) goto L29;
    L32:
        boolean r127 = true;
    L33:
        r126.append(r127);     // Catch: Throwable -> L64
        r126.append(", messageId: ");     // Catch: Throwable -> L64
        r126.append(r124);     // Catch: Throwable -> L64
        r125.i("OpenCreateShortcutHandler", r126.toString());     // Catch: Throwable -> L64
        if (r110.getResources().getConfiguration().orientation != 2) goto L37;
        r125.i("OpenCreateShortcutHandler", "openCreateShortcutPage failed, landscape is not supported");     // Catch: Throwable -> L64
        s r128 = s.f544207a;     // Catch: Throwable -> L64
        i r129 = com.larus.im.b.f346407a;     // Catch: Throwable -> L64
        Intrinsics.checkNotNull(r129);     // Catch: Throwable -> L64
        r128.g(r129.getApplication(), R.string.obric_rotate_screen_and_retry, false);     // Catch: Throwable -> L64
        r117 = h.a.a(h.f390443d, "landscape is not supported", 2);     // Catch: Throwable -> L64
        goto L62
    L37:
        if (r124.length() != 0) goto L39;
        boolean r130 = true;
    L40:
        if (r130 == false) goto L42;
        r117 = h.a.a(h.f390443d, "messageId is empty", 2);     // Catch: Throwable -> L64
        goto L62
    L42:
        r109 = r110;
        r100.L$0 = r109;     // Catch: Throwable -> L64
        r100.L$1 = r123;     // Catch: Throwable -> L64
        r100.L$2 = r124;     // Catch: Throwable -> L64
        r100.label = 1;     // Catch: Throwable -> L64
        Object r131 = f(r124, r100);     // Catch: Throwable -> L64
        if (r131 != r103) goto L45;
        return r103;
    L45:
        r112 = r123;
        r102 = r131;
        r111 = r124;
        goto L46
    L39:
        r130 = false;
        goto L40
    L29:
        if (r123.length() == 0) goto L32;
        r127 = false;
        goto L33
    L23:
        r124 = null;
        goto L24
    L20:
        r123 = null;
    L64:
        th = move-exception;
        Result.Companion r132 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new OpenCreateShortcutHandler$execute$1(this, r211);
        goto L8
    }
}
