package tx9;

import android.os.SystemClock;
import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, c> f547891a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f547892a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f547893b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f547894c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f547895d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f547896e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f547892a, r101.f547892a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f547893b, r101.f547893b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f547894c, r101.f547894c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f547895d, r101.f547895d) == true) goto L21;
            return false;
        L21:
            if (this.f547896e == r101.f547896e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f547892a.hashCode() * 31;
            String r101 = this.f547893b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f547894c;
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            int r106 = (((r104 + r102) * 31) + this.f547895d.hashCode()) * 31;
            long r107 = this.f547896e;
            return r106 + ((int) (r107 ^ (r107 >>> 32)));
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "DirectSendTraceContext(localMessageId=" + this.f547892a + ", conversationId=" + this.f547893b + ", botId=" + this.f547894c + ", traceExt=" + this.f547895d + ", startTime=" + this.f547896e + ')';
        }

        public a(String r100, String r101, String r102, c r103, long r104) {
            Intrinsics.checkNotNullParameter(r100, "localMessageId");
            Intrinsics.checkNotNullParameter(r103, "traceExt");
            this.f547892a = r100;
            this.f547893b = r101;
            this.f547894c = r102;
            this.f547895d = r103;
            this.f547896e = r104;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f547897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f547898b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<String> f547899c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<String> f547900d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f547901e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f547897a, r101.f547897a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f547898b, r101.f547898b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f547899c, r101.f547899c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f547900d, r101.f547900d) == true) goto L21;
            return false;
        L21:
            if (this.f547901e == r101.f547901e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f547897a.hashCode() * 31;
            String r101 = this.f547898b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (((((r100 + r102) * 31) + this.f547899c.hashCode()) * 31) + this.f547900d.hashCode()) * 31;
            long r104 = this.f547901e;
            return r103 + ((int) (r104 ^ (r104 >>> 32)));
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "MessageTransferTraceContext(transferType=" + this.f547897a + ", conversationId=" + this.f547898b + ", messageIds=" + this.f547899c + ", targetConversationIds=" + this.f547900d + ", startTime=" + this.f547901e + ')';
        }

        public b(String r100, String r101, List<String> r102, List<String> r103, long r104) {
            Intrinsics.checkNotNullParameter(r100, "transferType");
            Intrinsics.checkNotNullParameter(r102, "messageIds");
            Intrinsics.checkNotNullParameter(r103, "targetConversationIds");
            this.f547897a = r100;
            this.f547898b = r101;
            this.f547899c = r102;
            this.f547900d = r103;
            this.f547901e = r104;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f547902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f547903b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f547904c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f547905d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f547906e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f547907f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f547908g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f547909h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f547910i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f547911j;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f547902a, r101.f547902a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f547903b, r101.f547903b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f547904c, r101.f547904c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f547905d, r101.f547905d) == true) goto L21;
            return false;
        L21:
            if (this.f547906e == r101.f547906e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f547907f, r101.f547907f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f547908g, r101.f547908g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f547909h, r101.f547909h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f547910i, r101.f547910i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f547911j, r101.f547911j) == true) goto L38;
            return false;
        L38:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((((((this.f547902a.hashCode() * 31) + this.f547903b.hashCode()) * 31) + this.f547904c.hashCode()) * 31) + this.f547905d.hashCode()) * 31) + this.f547906e) * 31) + this.f547907f.hashCode()) * 31;
            String r101 = this.f547908g;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f547909h;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f547910i;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            String r111 = this.f547911j;
            if (r111 == null) goto L19;
            r102 = r111.hashCode();
        L19:
            return r110 + r102;
        L13:
            r109 = r108.hashCode();
            goto L14
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "SendTraceExt(enterMethod=" + this.f547902a + ", scene=" + this.f547903b + ", currentPage=" + this.f547904c + ", chatType=" + this.f547905d + ", isLarkMsg=" + this.f547906e + ", forwardMessageIdList=" + this.f547907f + ", forwardChatId=" + this.f547908g + ", larkFirstScene=" + this.f547909h + ", larkSecondScene=" + this.f547910i + ", currentModule=" + this.f547911j + ')';
        }

        public final String a() {
            return this.f547905d;
        }

        public final String b() {
            return this.f547904c;
        }

        public final String c() {
            return this.f547902a;
        }

        public final String d() {
            return this.f547903b;
        }

        public /* synthetic */ c(String r110, int r111, String r112, String r113) {
            this(ShareChannel.MESSAGE_FORWARD, r110, r111, r112, r113, null, null, null);
        }

        public c(String r100, String r101, int r102, String r103, String r104, String r105, String r110, String r111) {
            Intrinsics.checkNotNullParameter(r100, "enterMethod");
            Intrinsics.checkNotNullParameter(ShareChannel.MESSAGE_FORWARD, "scene");
            Intrinsics.checkNotNullParameter("chat", "currentPage");
            Intrinsics.checkNotNullParameter(r101, "chatType");
            Intrinsics.checkNotNullParameter(r103, "forwardMessageIdList");
            this.f547902a = r100;
            this.f547903b = ShareChannel.MESSAGE_FORWARD;
            this.f547904c = "chat";
            this.f547905d = r101;
            this.f547906e = r102;
            this.f547907f = r103;
            this.f547908g = r104;
            this.f547909h = r105;
            this.f547910i = r110;
            this.f547911j = r111;
        }
    }

    public v0() {
    }

    static {
        f547891a = new ConcurrentHashMap();
    }

    public static JSONObject b(b r100) {
        JSONObject r101 = new JSONObject();
        r101.put("transfer_type", r100.f547897a);
        String r102 = r100.f547898b;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.put("conversation_id", r102);
        List<String> r103 = r100.f547899c;
        JSONArray r104 = new JSONArray();
        Iterator<T> r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        r104.put((String) r105.next());
        goto L7
    L9:
        r101.put(MusicAppletPage.KEY_MESSAGE_ID, r104);
        return r101;
    }

    public static void c(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((!StringsKt.isBlank(r100)) == true) goto L7;
        r100 = null;
    L7:
        if (r100 == null) goto L11;
        c r101 = f547891a.remove(r100);
        return;
    }

    public static String e(String r100) {
        if (Intrinsics.areEqual(r100, "group") == true) goto L7;
        Intrinsics.areEqual(r100, BridgePrivilege.PRIVATE);
        return BridgePrivilege.PRIVATE;
    L7:
        return "group";
    }

    public static void h(b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        by7.a r101 = new by7.a("flow_message_transfer_click");
        TrackParams r102 = new TrackParams().merge(b(r100));
        r101.f21463a.merge(r102);
        r101.b();
    }

    public static String k(String r100) {
        if (r100 != null) goto L4;
    L6:
        return null;
    L4:
        if ((!StringsKt.isBlank(r100)) == false) goto L6;
        return r100;
    }

    public static void a(JSONObject r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        if (r101 != null) goto L5;
        return;
    L5:
        r100.put("enter_method", r101.f547902a);
        r100.put("scene", r101.f547903b);
        r100.put("current_page", r101.f547904c);
        r100.put("is_lark_msg", r101.f547906e);
        r100.put("forward_message_id_list", r101.f547907f);
        Object r102 = r101.f547909h;
        if (r102 == null) goto L8;
        r100.put("lark_first_scene", r102);
    L8:
        Object r103 = r101.f547910i;
        if (r103 == null) goto L11;
        r100.put("lark_second_scene", r103);
    L11:
        Object r104 = r101.f547911j;
        if (r104 == null) goto L14;
        r100.put("current_module", r104);
    L14:
        String r105 = r101.f547908g;
        if (r105 != null) goto L17;
        return;
    L17:
        if ((!StringsKt.isBlank(r105)) == true) goto L20;
        r105 = null;
    L20:
        if (r105 == null) goto L24;
        r100.put("forward_chat_id", r105);
        return;
    }

    public static b d(String r100, String r101, List r102, List r110) {
        Intrinsics.checkNotNullParameter(r100, "transferType");
        Intrinsics.checkNotNullParameter(r102, "messageIds");
        Intrinsics.checkNotNullParameter(r110, "targetConversationIds");
        String r103 = "to_doubao";
        if (Intrinsics.areEqual(r100, "to_doubao") == false) goto L5;
    L4:
        r100 = r103;
    L8:
        String r104 = r100;
        ArrayList r105 = new ArrayList();
        Iterator r106 = r102.iterator();
    L10:
        if (r106.hasNext() == false) goto L14;
        Object r107 = r106.next();
        if ((!StringsKt.isBlank((String) r107)) == false) goto L10;
        r105.add(r107);
        goto L10
    L14:
        List r108 = CollectionsKt.distinct(r105);
        ArrayList r109 = new ArrayList();
        Iterator r111 = r110.iterator();
    L16:
        if (r111.hasNext() == false) goto L21;
        Object r112 = r111.next();
        if ((!StringsKt.isBlank((String) r112)) == false) goto L16;
        r109.add(r112);
        goto L16
    L21:
        return new b(r104, r101, r108, CollectionsKt.distinct(r109), SystemClock.elapsedRealtime());
    L5:
        r103 = "to_chat";
        if (Intrinsics.areEqual(r100, "to_chat") == false) goto L8;
        goto L8
    }

    public static void f(a r160, boolean r161, String r162, String r163) {
        Intrinsics.checkNotNullParameter(r160, PerfLog.PARAM_KEY_CONTEXT_ID);
        JSONObject r100 = new JSONObject();
        a(r100, r160.f547895d);
        if (r161 == false) goto L5;
        long r101 = 1;
    L6:
        long r210 = r101;
        if (r162 != null) goto L9;
    L13:
        String r102 = r160.f547892a;
    L14:
        String r110 = r102;
        String r103 = r160.f547893b;
        String r104 = r160.f547894c;
        long r111 = SystemClock.elapsedRealtime() - r160.f547896e;
        c r105 = r160.f547895d;
        String r106 = r105.f547903b;
        String r107 = r105.f547904c;
        String r108 = r105.f547905d;
        l3.d(r104, r108, null, null, r103, r107, Long.valueOf(r111), r108, null, null, null, r110, BrowserDependency.UrlClickType.CARD, null, null, null, null, null, null, null, r163, r106, null, null, null, null, Long.valueOf(r210), BrowserDependency.UrlClickType.CARD, null, null, null, null, null, null, null, null, null, r100, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r105.f547902a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1023360281, -1073742849, -1, -1, Integer.MAX_VALUE);
        return;
    L9:
        if ((!StringsKt.isBlank(r162)) == false) goto L11;
        r102 = r162;
    L12:
        if (r102 != null) goto L14;
    L11:
        r102 = null;
        goto L12
    L5:
        r101 = 0;
        goto L6
    }

    public static void g(String r100, Integer r101, Long r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        JSONObject r104 = new JSONObject();
        r104.put("from", "doubao_to_lark");
        r104.put("intercept_reason", r100);
        if (r101 == null) goto L11;
        r104.put("select_count", r101.intValue());
    L11:
        if (r102 == null) goto L13;
        r104.put("select_size", r102.longValue());
    L13:
        by7.a r105 = new by7.a("im_msg_merge_forward_limit_intercept");
        r105.f21463a.merge(new TrackParams().merge(r104));
        r105.b();
    }

    public static void i(b r110, boolean r111, List r112, String r113, String r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r112 == null) goto L13;
        ArrayList r100 = new ArrayList();
        Iterator r101 = r112.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        Object r102 = r101.next();
        if ((!StringsKt.isBlank((String) r102)) == false) goto L6;
        r100.add(r102);
        goto L6
    L10:
        List<String> r103 = CollectionsKt.distinct(r100);
        if (r103 == null) goto L13;
    L14:
        JSONObject r104 = b(r110);
        r104.put("status", !r111 ? 1 : 0);
        JSONArray r105 = new JSONArray();
        Iterator<T> r106 = r103.iterator();
    L16:
        if (r106.hasNext() == false) goto L18;
        r105.put((String) r106.next());
        goto L16
    L18:
        r104.put("target_conversation_id", r105);
        r104.put("duration", SystemClock.elapsedRealtime() - r110.f547901e);
        if (r111 == true) goto L40;
        Object r107 = null;
        if (r113 != null) goto L23;
    L28:
        if (r210 == null) goto L38;
        String r114 = StringsKt.replace$default(r210, '\n', ' ', false, 4, null);
        if (r114 == null) goto L38;
        String r108 = StringsKt.replace$default(r114, '\r', ' ', false, 4, null);
        if (r108 == null) goto L38;
        String r109 = StringsKt.take(r108, 200);
        if (r109 == null) goto L38;
        if ((!StringsKt.isBlank(r109)) == false) goto L38;
        r107 = r109;
    L38:
        if (r107 == null) goto L40;
        r104.put("error_msg", r107);
        goto L40
    L23:
        if ((!StringsKt.isBlank(r113)) == false) goto L25;
        Object r115 = r113;
    L26:
        if (r115 == null) goto L28;
        r104.put("error_code", r115);
        goto L28
    L25:
        r115 = null;
    L40:
        by7.a r116 = new by7.a("flow_message_transfer_result");
        r116.f21463a.merge(new TrackParams().merge(r104));
        r116.b();
        return;
    L13:
        r103 = r110.f547900d;
        goto L14
    }

    public static /* synthetic */ void j(b r100, boolean r101, List r102, String r103, String r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r105 & 8) == 0) goto L9;
        r103 = null;
    L9:
        if ((r105 & 16) == 0) goto L11;
        r104 = null;
    L11:
        i(r100, r101, r102, r103, r104);
    }
}
