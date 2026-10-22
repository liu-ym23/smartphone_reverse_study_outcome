package ko8;

import androidx.collection.LruCache;
import com.larus.bmhome.chat.api.SelectionRangeType;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotSourceType;
import com.larus.im.bean.conversation.BotConversationType;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatControlTraceService;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wc9.e;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<String, e> f504531a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f504532b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f504533c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f504534d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f504535e = 0;

    public a() {
    }

    static {
        IAIChatControlTraceService.Companion r100 = IAIChatControlTraceService.f365889a;
        f504531a = r100.ac();
        f504532b = r100.Hb();
        f504533c = r100.Rb();
        f504534d = r100.Db();
        f504535e = r100.gb();
    }

    public static long g() {
        return IAIChatControlTraceService.f365889a.Na();
    }

    public static String c(Message r100) {
        return IAIChatControlTraceService.f365889a.tb(r100);
    }

    public static String d(Message r100) {
        return IAIChatControlTraceService.f365889a.Kb(r100);
    }

    public static String e(long r100) {
        return IAIChatControlTraceService.f365889a.h(r100);
    }

    public static String h(long r100) {
        return IAIChatControlTraceService.f365889a.bb(r100);
    }

    public static JSONObject i(Message r100, JSONObject r101) {
        return IAIChatControlTraceService.f365889a.Ua(r100, r101);
    }

    public static void k(String r100, String r101) {
        IAIChatControlTraceService.f365889a.sb(r100, r101);
    }

    public static String f(@BotConversationType Integer r100, @BotSourceType Integer r101, boolean r102) {
        return IAIChatControlTraceService.f365889a.g(r100, r101, r102);
    }

    public static void a(String r110, String r111, Integer r112, String r113, String r114, String r115, int r116) {
        if ((r116 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r116 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r116 & 4) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r116 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r116 & 64) == 0) goto L21;
        String r117 = null;
    L23:
        if ((r116 & 128) == 0) goto L25;
        String r118 = null;
    L26:
        IAIChatControlTraceService.f365889a.ec(r100, r101, r102, r103, null, null, r117, r118);
        return;
    L25:
        r118 = r115;
        goto L26
    L21:
        r117 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public static void l(List r100, Message r110, BotModel r111, by7.e r112, String r113, String r114, JSONObject r115) {
        Intrinsics.checkNotNullParameter(r100, "menuItems");
        Intrinsics.checkNotNullParameter(r110, "message");
        Intrinsics.checkNotNullParameter(r114, "triggerFrom");
        Intrinsics.checkNotNullParameter(r115, "extraParams");
        IAIChatControlTraceService.f365889a.jc(r100, r110, r111, r112, r113, r114, r115);
    }

    public static void j(String r110, Message r111, by7.e r112, long r113, List r210, CustomMarkdownTextView r211, String r212, SelectionRangeType r213, String r214, int r215) {
        if ((r215 & 64) == 0) goto L5;
        String r114 = "";
    L7:
        if ((r215 & 128) == 0) goto L9;
        SelectionRangeType r115 = null;
    L11:
        if ((r215 & 256) == 0) goto L13;
        String r116 = null;
    L14:
        Intrinsics.checkNotNullParameter(r110, "clickFrom");
        Intrinsics.checkNotNullParameter(r111, "msg");
        Intrinsics.checkNotNullParameter(r210, "markdownContentList");
        IAIChatControlTraceService.a.d(IAIChatControlTraceService.f365889a, r110, r111, r112, r113, r210, r211, r114, r115, r116, null, 512);
        return;
    L13:
        r116 = r214;
        goto L14
    L9:
        r115 = r213;
        goto L11
    L5:
        r114 = r212;
        goto L7
    }

    public static void b(String r110, String r111, long r112, String r210, Integer r211, String r212, String r213, String r214, String r215, by7.e r216, String r217, int r218) {
        if ((r218 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r218 & 16) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r218 & 32) == 0) goto L13;
        String r113 = null;
    L15:
        if ((r218 & 64) == 0) goto L17;
        String r114 = null;
    L19:
        if ((r218 & 128) == 0) goto L21;
        String r115 = null;
    L23:
        if ((r218 & 256) == 0) goto L25;
        String r116 = null;
    L27:
        if ((r218 & 512) == 0) goto L29;
        by7.e r117 = null;
    L31:
        if ((r218 & 1024) == 0) goto L33;
        String r118 = null;
    L34:
        Intrinsics.checkNotNullParameter(r110, "exportActionId");
        Intrinsics.checkNotNullParameter(r111, "clickFrom");
        IAIChatControlTraceService.f365889a.Da(r110, r111, r112, r100, r101, r113, r114, r115, r116, r117, r118);
        return;
    L33:
        r118 = r217;
        goto L34
    L29:
        r117 = r216;
        goto L31
    L25:
        r116 = r215;
        goto L27
    L21:
        r115 = r214;
        goto L23
    L17:
        r114 = r213;
        goto L19
    L13:
        r113 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public static void m(String r310, String r311, boolean r312, String r313, boolean r314, boolean r410, boolean r411, boolean r412, String r413, String r414, String r415, String r416, String r417, String r418, String r419, String r510, String r511, Boolean r512, Boolean r513, String r514, String r515, String r516, String r517, String r518, String r519, String r610, String r611, Long r612, String r613, String r614, String r615, int r616) {
        if ((r616 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r616 & 2) == 0) goto L9;
        String r101 = "chat";
    L11:
        if ((r616 & 8) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r616 & 256) == 0) goto L17;
        String r110 = null;
    L19:
        if ((r616 & 512) == 0) goto L21;
        String r111 = null;
    L23:
        if ((r616 & 1024) == 0) goto L25;
        String r112 = null;
    L27:
        if ((r616 & 2048) == 0) goto L29;
        String r113 = null;
    L31:
        if ((r616 & 4096) == 0) goto L33;
        String r114 = null;
    L35:
        if ((r616 & 8192) == 0) goto L37;
        String r115 = null;
    L39:
        if ((r616 & 16384) == 0) goto L41;
        String r116 = null;
    L43:
        if ((32768 & r616) == 0) goto L45;
        String r117 = null;
    L47:
        if ((65536 & r616) == 0) goto L49;
        String r210 = "-1";
    L51:
        if ((131072 & r616) == 0) goto L53;
        Boolean r211 = Boolean.FALSE;
    L55:
        if ((262144 & r616) == 0) goto L57;
        Boolean r212 = Boolean.FALSE;
    L59:
        if ((524288 & r616) == 0) goto L61;
        String r213 = null;
    L63:
        if ((1048576 & r616) == 0) goto L65;
        String r214 = null;
    L67:
        if ((2097152 & r616) == 0) goto L69;
        String r215 = null;
    L71:
        if ((4194304 & r616) == 0) goto L73;
        String r216 = null;
    L75:
        if ((8388608 & r616) == 0) goto L77;
        String r217 = null;
    L79:
        if ((16777216 & r616) == 0) goto L81;
        String r218 = null;
    L83:
        if ((33554432 & r616) == 0) goto L85;
        String r219 = null;
    L87:
        if ((67108864 & r616) == 0) goto L89;
        String r315 = null;
    L91:
        if ((134217728 & r616) == 0) goto L93;
        Long r316 = null;
    L95:
        if ((268435456 & r616) == 0) goto L97;
        String r317 = null;
    L99:
        if ((536870912 & r616) == 0) goto L101;
        String r318 = null;
    L103:
        if ((r616 & 1073741824) == 0) goto L105;
        String r319 = null;
    L106:
        Intrinsics.checkNotNullParameter(r101, "currentPage");
        IAIChatControlTraceService.f365889a.Tb(r100, r101, r312, r102, r314, r410, r411, r412, r110, r111, r112, r113, r114, r115, r116, r117, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r315, r316, r317, r318, r319);
        return;
    L105:
        r319 = r615;
        goto L106
    L101:
        r318 = r614;
        goto L103
    L97:
        r317 = r613;
        goto L99
    L93:
        r316 = r612;
        goto L95
    L89:
        r315 = r611;
        goto L91
    L85:
        r219 = r610;
        goto L87
    L81:
        r218 = r519;
        goto L83
    L77:
        r217 = r518;
        goto L79
    L73:
        r216 = r517;
        goto L75
    L69:
        r215 = r516;
        goto L71
    L65:
        r214 = r515;
        goto L67
    L61:
        r213 = r514;
        goto L63
    L57:
        r212 = r513;
        goto L59
    L53:
        r211 = r512;
        goto L55
    L49:
        r210 = r511;
        goto L51
    L45:
        r117 = r510;
        goto L47
    L41:
        r116 = r419;
        goto L43
    L37:
        r115 = r418;
        goto L39
    L33:
        r114 = r417;
        goto L35
    L29:
        r113 = r416;
        goto L31
    L25:
        r112 = r415;
        goto L27
    L21:
        r111 = r414;
        goto L23
    L17:
        r110 = r413;
        goto L19
    L13:
        r102 = r313;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
