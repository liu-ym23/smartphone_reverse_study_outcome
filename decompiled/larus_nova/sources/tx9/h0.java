package tx9;

import com.ixigua.lib.track.TrackParams;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, i0> f547857a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f547858b = null;

    static {
        f547857a = new LinkedHashMap();
        f547858b = new Object();
    }

    public static final JSONObject e(Map<String, String> r100) {
        JSONObject r101 = new JSONObject();
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<String, String> r103 = r102.next();
        r101.put(r103.getKey(), r103.getValue());
        goto L4
    L6:
        return r101;
    }

    public static final JSONObject f(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        Object r102 = Result.m9449constructorimpl(new JSONObject(r100));     // Catch: Throwable -> L7
    L9:
        JSONObject r103 = new JSONObject();
        if (Result.m9455isFailureimpl(r102) == false) goto L13;
        r102 = r103;
    L13:
        return (JSONObject) r102;
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public static final Long g(Object r100) {
        if ((r100 instanceof Number) == false) goto L6;
        return Long.valueOf(((Number) r100).longValue());
    L6:
        if ((r100 instanceof String) == true) goto L11;
        return null;
    L11:
        return g(r100);
    }

    public static final void b(String r100, JSONObject r101) {
        by7.a r102 = new by7.a(r100);
        TrackParams r103 = new TrackParams().merge(r101);
        r102.f21463a.merge(r103);
        r102.b();
    }

    public static final void d(String r100, String r101, String r102, Long r103) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "sourceConversationId");
        Intrinsics.checkNotNullParameter(r102, "sourceMessageId");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L29;
        Object r104 = f547858b;
        monitor-enter(r104);
        Map<String, i0> r105 = f547857a;     // Catch: Throwable -> L23
        i0 r106 = (i0) ((LinkedHashMap) r105).get(r100);     // Catch: Throwable -> L23
        if (StringsKt.isBlank(r102) == false) goto L16;
        if (r106 == null) goto L13;
        r102 = r106.f547874b;     // Catch: Throwable -> L23
    L14:
        if (r102 != null) goto L16;
        r102 = "";
        goto L16
    L13:
        r102 = null;
    L16:
        if (r103 != null) goto L20;
        if (r106 == null) goto L19;
        r103 = r106.f547875c;     // Catch: Throwable -> L23
        goto L20
    L19:
        r103 = null;
    L20:
        r105.put(r100, new i0(r101, r102, r103));     // Catch: Throwable -> L23
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r104);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public static final void a(JSONObject r100, String r101, String r102, boolean r103, Map<String, String> r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        JSONObject r106 = f(r102);
        Object r107 = f547858b;
        monitor-enter(r107);
        i0 r108 = (i0) ((LinkedHashMap) f547857a).get(r101);     // Catch: Throwable -> L63
        monitor-exit(r107);
        boolean r109 = true;
        Object r110 = null;
        if (r108 == null) goto L10;
        String r111 = r108.f547873a;
        if (r111 == null) goto L10;
    L22:
        if (r108 == null) goto L30;
        String r112 = r108.f547874b;
        if (r112 == null) goto L30;
        if ((!StringsKt.isBlank(r112)) == true) goto L29;
        r112 = null;
    L29:
        if (r112 == null) goto L30;
    L40:
        r110 = r112;
    L41:
        if (r103 == false) goto L43;
    L52:
        r100.put("is_fork_conversation", r109);
        if (r105 == false) goto L68;
        if (r109 == true) goto L56;
        return;
    L56:
        if (r111 != null) goto L58;
        r111 = "";
    L58:
        r100.put("fork_from_conversation_id", r111);
        if (r110 != null) goto L61;
        r110 = "";
    L61:
        r100.put("fork_from_message_id", r110);
        return;
    L68:
        return;
    L43:
        if (r111 != null) goto L45;
    L48:
        boolean r113 = true;
    L49:
        if (r113 == false) goto L52;
        r109 = false;
        goto L52
    L45:
        if (StringsKt.isBlank(r111) == true) goto L48;
        r113 = false;
    L30:
        if (r104 == null) goto L36;
        r112 = r104.get("fork_from_message_id");
        if (r112 == null) goto L36;
        if ((!StringsKt.isBlank(r112)) == false) goto L36;
    L37:
        if (r112 != null) goto L40;
        r112 = r106.optString("fork_from_message_id");
        Intrinsics.checkNotNull(r112);
        if ((!StringsKt.isBlank(r112)) == false) goto L41;
    L36:
        r112 = null;
    L10:
        if (r104 == null) goto L16;
        r111 = r104.get("fork_from_conversation_id");
        if (r111 == null) goto L16;
        if ((!StringsKt.isBlank(r111)) == false) goto L16;
    L17:
        if (r111 != null) goto L22;
        r111 = r106.optString("fork_from_conversation_id");
        Intrinsics.checkNotNull(r111);
        if ((!StringsKt.isBlank(r111)) == true) goto L22;
        r111 = null;
    L16:
        r111 = null;
    L63:
        th = move-exception;
        throw th;
    }

    public static final void c(String r100, String r101, String r102, String r103, String r104, Long r105) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "sourceConversationId");
        Intrinsics.checkNotNullParameter(r102, "sourceMessageId");
        d(r100, r101, r102, r105);
        JSONObject r106 = new JSONObject();
        r106.put("current_page", "chat");
        r106.put("click_from", "fork");
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r106.put("mode_id", r103);
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        r106.put("model_item_key", r104);
        r106.put("fork_from_conversation_id", r101);
        r106.put("fork_from_message_id", r102);
        r106.put("conversation_id", r100);
        if (r105 == null) goto L11;
        r106.put("fork_index", r105.longValue());
    L11:
        b("create_new_chat", r106);
    }
}
