package ve8;

import android.net.Uri;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f554418a = 0;

    static {
    }

    public static Map a(Uri r110) {
        Intrinsics.checkNotNullParameter(r110, "uri");
        LinkedHashMap r100 = new LinkedHashMap();
        String r101 = UriProtector.getQueryParameter(r110, IFlowAppIntentIDL.PARAM_APPLET_ID);
        if (r101 == null) goto L5;
        r100.put(IFlowAppIntentIDL.PARAM_APPLET_ID, r101);
    L5:
        String r102 = UriProtector.getQueryParameter(r110, "pageId");
        if (r102 == null) goto L8;
        r100.put("pageId", r102);
    L8:
        String r103 = UriProtector.getQueryParameter(r110, "pageData");
        if (r103 != null) goto L79;
    L27:
        String r104 = UriProtector.getQueryParameter(r110, "pageType");
        if (r104 == null) goto L30;
        r100.put("pageType", r104);
    L30:
        String r105 = UriProtector.getQueryParameter(r110, "pageSettings");
        if (r105 != null) goto L75;
    L41:
        String r106 = UriProtector.getQueryParameter(r110, "conversationId");
        if (r106 == null) goto L44;
        r100.put("conversationId", r106);
    L44:
        LinkedHashMap r107 = new LinkedHashMap();
        String r108 = UriProtector.getQueryParameter(r110, "botId");
        if (r108 == null) goto L47;
        r107.put("botId", r108);
    L47:
        String r109 = UriProtector.getQueryParameter(r110, "messageId");
        if (r109 == null) goto L50;
        r107.put(RemoteMessageConst.MSGID, r109);
    L50:
        String r111 = UriProtector.getQueryParameter(r110, "conversationId");
        if (r111 == null) goto L53;
        r107.put("conversationId", r111);
    L53:
        String r112 = UriProtector.getQueryParameter(r110, "replyFor");
        if (r112 == null) goto L56;
        r107.put("replyFor", r112);
    L56:
        String r113 = UriProtector.getQueryParameter(r110, "bot_state");
        if (r113 == null) goto L59;
        r107.put("bot_state", r113);
    L59:
        String r114 = UriProtector.getQueryParameter(r110, "fpa_common_param");
        if (r114 == null) goto L62;
        r107.put("fpa_common_param", r114);
    L62:
        String r115 = UriProtector.getQueryParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r115 != null) goto L77;
    L73:
        r100.put(PerfLog.PARAM_KEY_CONTEXT_ID, r107);
        return r100;
    L77:
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L70
        JSONObject r117 = new JSONObject(r115);     // Catch: Throwable -> L70
        Iterator<String> r118 = r117.keys();     // Catch: Throwable -> L70
    L66:
        if (r118.hasNext() == false) goto L68;
        String r119 = r118.next();     // Catch: Throwable -> L70
        r107.put(r119, JSONObjectProtectorUtils.getString(r117, r119));     // Catch: Throwable -> L70
        goto L66
    L68:
        Object r120 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L70
    L72:
        Result.m9448boximpl(r120);
    L70:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L72
    L75:
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L38
        LinkedHashMap r123 = new LinkedHashMap();     // Catch: Throwable -> L38
        JSONObject r124 = new JSONObject(r105);     // Catch: Throwable -> L38
        Iterator<String> r125 = r124.keys();     // Catch: Throwable -> L38
    L34:
        if (r125.hasNext() == false) goto L36;
        String r126 = r125.next();     // Catch: Throwable -> L38
        r123.put(r126, JSONObjectProtectorUtils.getString(r124, r126));     // Catch: Throwable -> L38
        goto L34
    L36:
        r100.put("pageSettings", r123);     // Catch: Throwable -> L38
        Object r127 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L38
    L40:
        Result.m9448boximpl(r127);
    L38:
        th = move-exception;
        Result.Companion r128 = Result.Companion;
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L40
    L79:
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L21
        JSONObject r130 = new JSONObject(r103);     // Catch: Throwable -> L21
        String r131 = UriProtector.getQueryParameter(r110, "botId");     // Catch: Throwable -> L21
        if (r131 == null) goto L13;
        r130.put("botId", r131);     // Catch: Throwable -> L21
    L13:
        String r132 = UriProtector.getQueryParameter(r110, "conversationId");     // Catch: Throwable -> L21
        if (r132 == null) goto L16;
        r130.put("conversationId", r132);     // Catch: Throwable -> L21
    L16:
        String r133 = UriProtector.getQueryParameter(r110, "messageId");     // Catch: Throwable -> L21
        if (r133 == null) goto L19;
        r130.put("messageId", r133);     // Catch: Throwable -> L21
    L19:
        r100.put("pageData", r130.toString());     // Catch: Throwable -> L21
        Object r134 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r135 = Result.m9452exceptionOrNullimpl(r134);
        if (r135 == null) goto L26;
        r100.put("pageData", r135);
    L26:
        Result.m9448boximpl(r134);
    L21:
        th = move-exception;
        Result.Companion r136 = Result.Companion;
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    }
}
