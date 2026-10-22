package com.obric.assistant.obric_action.handler.omni_task;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import va8.a0;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013Jb\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010\u0019H\u0082@¢\u0006\u0002\u0010 R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006#"}, d2 = {"Lcom/obric/assistant/obric_action/handler/omni_task/OmniTaskFeedbackHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/omni_task/OmniTaskFeedbackHandler$Params;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/omni_task/OmniTaskFeedbackHandler$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showOmniTaskFeedbackDialog", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "msgIdList", "", "", "omniTaskId", "botId", "feedbackMsgId", "feedbackSource", "feedbackBizType", "searchTool", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Params", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniTaskFeedbackHandler implements IObricActionHandler<b, Unit> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<b> f390485b;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003JY\u0010\u001a\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006!"}, d2 = {"Lcom/obric/assistant/obric_action/handler/omni_task/OmniTaskFeedbackHandler$Params;", "", "messageIdList", "", "", "omniTaskId", "feedbackMsgId", "feedbackSource", "feedbackBizType", "searchTool", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMessageIdList", "()Ljava/util/List;", "getOmniTaskId", "()Ljava/lang/String;", "getFeedbackMsgId", "getFeedbackSource", "getFeedbackBizType", "getSearchTool", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("feedbackBizType")
        private final String feedbackBizType;

        @SerializedName("feedback_msg_id")
        private final String feedbackMsgId;

        @SerializedName("source")
        private final String feedbackSource;

        @SerializedName("messageIdList")
        private final List<String> messageIdList;

        @SerializedName("omniTaskId")
        private final String omniTaskId;

        @SerializedName("searchTool")
        private final String searchTool;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.messageIdList, r101.messageIdList) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.omniTaskId, r101.omniTaskId) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.feedbackMsgId, r101.feedbackMsgId) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.feedbackSource, r101.feedbackSource) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.feedbackBizType, r101.feedbackBizType) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.searchTool, r101.searchTool) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            List<String> r100 = this.messageIdList;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.omniTaskId;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.feedbackMsgId;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.feedbackSource;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.feedbackBizType;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.searchTool;
            if (r116 == null) goto L27;
            r101 = r116.hashCode();
        L27:
            return r115 + r101;
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
            return "Params(messageIdList=" + this.messageIdList + ", omniTaskId=" + this.omniTaskId + ", feedbackMsgId=" + this.feedbackMsgId + ", feedbackSource=" + this.feedbackSource + ", feedbackBizType=" + this.feedbackBizType + ", searchTool=" + this.searchTool + ')';
        }

        public b() {
            this.messageIdList = null;
            this.omniTaskId = null;
            this.feedbackMsgId = null;
            this.feedbackSource = null;
            this.feedbackBizType = null;
            this.searchTool = null;
        }

        public final String a() {
            return this.feedbackBizType;
        }

        public final String b() {
            return this.feedbackMsgId;
        }

        public final String c() {
            return this.feedbackSource;
        }

        public final List<String> d() {
            return this.messageIdList;
        }

        public final String e() {
            return this.omniTaskId;
        }

        public final String f() {
            return this.searchTool;
        }
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r100 = d.g.f390429a;
        return d.g.f390429a;
    }

    public OmniTaskFeedbackHandler() {
        this.f390485b = b.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<b> b() {
        return this.f390485b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final b a(Context r100, String r101) {
        return (b) IObricActionHandler.b.a(this, r100, r101);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final /* bridge */ /* synthetic */ Object d(Context r100, b r101, Continuation<? super h<? extends Unit>> r102) {
        return e(r100, r101, r102);
    }

    public final Object e(Context r110, b r111, Continuation<? super h<Unit>> r112) {
        if ((r112 instanceof OmniTaskFeedbackHandler$execute$1) == false) goto L7;
        OmniTaskFeedbackHandler$execute$1 r100 = (OmniTaskFeedbackHandler$execute$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        OmniTaskFeedbackHandler$execute$1 r113 = r100;
        Object r102 = r113.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r113.label;
        boolean r114 = true;
        String r115 = "";
        if (r104 == 0) goto L15;
        if (r104 != 1) goto L14;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L55
        Object r105 = r102;
        String r106 = "OmniTaskFeedbackHandler";
    L50:
        h r107 = (h) r105;     // Catch: Throwable -> L53
    L51:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L53
    L58:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L61;
        FLogger.f375446a.w(r106, "showFeedbackDialog failed. " + r109.getMessage(), r109);
    L61:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r108);
        if (r116 == null) goto L79;
        h.a r117 = h.f390443d;
        String r118 = r116.getMessage();
        if (r118 == null) goto L69;
        r115 = r118;
    L69:
        if (r115.length() == 0) goto L72;
        r114 = false;
    L72:
        if (r114 == false) goto L75;
        r115 = "show feedback dialog failed";
    L75:
        return h.a.a(r117, r115, 2);
    L79:
        return r108;
    L53:
        th = th;
    L57:
        Result.Companion r119 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L58
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r102);
        if (r111 == null) goto L18;
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L55
        List<String> r121 = r111.d();     // Catch: Throwable -> L55
        if (r121 != null) goto L22;
        r121 = CollectionsKt.emptyList();     // Catch: Throwable -> L55
    L22:
        List r122 = CollectionsKt.filterNotNull(r121);     // Catch: Throwable -> L55
        if (r122.isEmpty() == false) goto L25;
        FLogger.f375446a.w("OmniTaskFeedbackHandler", "no msg list");     // Catch: Throwable -> L55
        r107 = h.a.a(h.f390443d, "messageIdList is empty", 2);     // Catch: Throwable -> L55
    L38:
        r106 = "OmniTaskFeedbackHandler";
        goto L51
    L25:
        String r123 = r111.e();     // Catch: Throwable -> L55
        if (r123 != null) goto L28;
        String r124 = "";
    L29:
        String r125 = null;
        if ((r110 instanceof Activity) == false) goto L32;
        Activity r126 = (Activity) r110;     // Catch: Throwable -> L55
    L33:
        if (r126 != null) goto L36;
        FLogger.f375446a.w("OmniTaskFeedbackHandler", "not top activity");     // Catch: Throwable -> L55
        r107 = h.a.a(h.f390443d, "context is not activity", 2);     // Catch: Throwable -> L55
        goto L38
    L36:
        if ((r126 instanceof FragmentActivity) == true) goto L39;
        FLogger.f375446a.w("OmniTaskFeedbackHandler", "top activity is not FragmentActivity");     // Catch: Throwable -> L55
        r107 = h.a.a(h.f390443d, "activity is not fragment activity", 2);     // Catch: Throwable -> L55
        goto L38
    L39:
        a0 r127 = (a0) s1a.a.h((FragmentActivity) r126).getAbility(a0.class);     // Catch: Throwable -> L55
        if (r127 == null) goto L42;
        r125 = r127.getBotId();     // Catch: Throwable -> L55
    L42:
        if (r125 != null) goto L44;
        String r128 = "";
    L45:
        FragmentManager r129 = ((FragmentActivity) r126).getSupportFragmentManager();     // Catch: Throwable -> L55
        String r130 = r111.b();     // Catch: Throwable -> L55
        String r131 = r111.c();     // Catch: Throwable -> L55
        String r132 = r111.a();     // Catch: Throwable -> L55
        String r133 = r111.f();     // Catch: Throwable -> L55
        r113.label = 1;     // Catch: Throwable -> L55
        r106 = "OmniTaskFeedbackHandler";
        r105 = f(r129, r122, r124, r128, r130, r131, r132, r133, r113);     // Catch: Throwable -> L53
        if (r105 != r103) goto L50;
        return r103;
    L44:
        r128 = r125;
        goto L45
    L32:
        r126 = null;
        goto L33
    L28:
        r124 = r123;
        goto L29
    L18:
        return h.a.a(h.f390443d, "params is null", 2);
    L55:
        th = th;
        r106 = "OmniTaskFeedbackHandler";
    L7:
        r100 = new OmniTaskFeedbackHandler$execute$1(this, r112);
        goto L8
    }

    public static Object f(FragmentManager r110, List r111, String r112, String r113, String r114, String r115, String r116, String r117, Continuation r210) {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("showOmniTaskFeedbackDialog, msgIdList: ");
        r101.append(r111);
        r101.append(", omniTaskId: ");
        r101.append(r112);
        r101.append(", botId: ");
        r101.append(r113);
        r101.append(", feedbackMsgId: ");
        String r102 = "";
        if (r114 != null) goto L5;
        String r103 = "";
    L6:
        r101.append(r103);
        r101.append(", feedbackSource: ");
        if (r115 != null) goto L9;
        String r104 = "";
    L10:
        r101.append(r104);
        r101.append(", feedbackBizType: ");
        if (r116 != null) goto L13;
        String r105 = "";
    L14:
        r101.append(r105);
        r101.append(", searchTool: ");
        if (r117 == null) goto L18;
        r102 = r117;
    L18:
        r101.append(r102);
        r100.i("OmniTaskFeedbackHandler", r101.toString());
        return BuildersKt.withContext(Dispatchers.getMain(), new OmniTaskFeedbackHandler$showOmniTaskFeedbackDialog$2(r111, r110, r112, r114, r115, r116, r117, null), r210);
    L13:
        r105 = r116;
        goto L14
    L9:
        r104 = r115;
        goto L10
    L5:
        r103 = r114;
        goto L6
    }
}
