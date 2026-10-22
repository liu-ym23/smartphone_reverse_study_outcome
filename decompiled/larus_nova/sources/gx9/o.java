package gx9;

import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f483265a = 0;

    static {
    }

    public o() {
    }

    public static String a() {
        return IAIChatControlTraceService.f365889a.Hb();
    }

    public static String b() {
        return IAIChatControlTraceService.f365889a.Db();
    }

    public static String c() {
        return IAIChatControlTraceService.f365889a.Rb();
    }

    public static String d(long r100) {
        return IAIChatControlTraceService.f365889a.h(r100);
    }

    public static JSONObject h(Map r100) {
        JSONObject r101 = new JSONObject();
        if (r100 == null) goto L10;
        Iterator r102 = r100.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        String r105 = (String) r103.getValue();
        if (r105 == null) goto L6;
        r101.put(r104, r105);
    L10:
        return r101;
    }

    public static void i(long r100, String r101, Function1 r102) {
        com.larus.bmhome.chat.trace.a r103 = IAIChatControlTraceService.f365889a.gc(r100);
        if (r103 != null) goto L6;
        FLogger.f375446a.d("PromptControlTrace", r101.concat(" chatKey not found"));
        return;
    L6:
        r102.invoke(r103);
    }

    public static void g(final String r110, final String r111, final int r112, final int r113, final String r114, final long r115, final String r210, final String r211, final String r212, final String r213, final String r214) {
        Intrinsics.checkNotNullParameter(r110, "messageId");
        Intrinsics.checkNotNullParameter(r114, "suggestedType");
        i(r115, "onShowSuggestedPrompt", new k(r114, r110, r111, r115, r210, r112, r113, r213, r211, r212, r214));
    }

    public static void e(final String r310, final Long r311, Long r312, final String r313, final String r314, String r315, final long r316, String r410, String r411, String r412, String r413, Integer r414, String r415, String r416, String r417, String r418, Integer r419, String r510, String r511, String r512, String r513, String r514, String r515, String r516, String r517, String r518, String r519, Map r610, int r611) {
        if ((r611 & 4) == 0) goto L5;
        final Long r100 = null;
    L6:
        final String r110 = null;
        if ((r611 & 64) == 0) goto L9;
        final String r101 = null;
    L11:
        if ((r611 & 256) == 0) goto L13;
        final String r111 = null;
    L15:
        if ((r611 & 512) == 0) goto L17;
        final String r112 = null;
    L19:
        if ((r611 & 1024) == 0) goto L21;
        final String r113 = null;
    L23:
        if ((r611 & 2048) == 0) goto L25;
        final String r114 = null;
    L27:
        if ((r611 & 4096) == 0) goto L29;
        final Integer r115 = null;
    L31:
        if ((r611 & 8192) == 0) goto L33;
        final String r116 = null;
    L35:
        if ((r611 & 16384) == 0) goto L37;
        final String r117 = null;
    L39:
        if ((32768 & r611) == 0) goto L41;
        final String r118 = null;
    L43:
        if ((65536 & r611) == 0) goto L45;
        final String r119 = null;
    L47:
        if ((131072 & r611) == 0) goto L49;
        final Integer r210 = null;
    L51:
        if ((262144 & r611) == 0) goto L53;
        final String r211 = null;
    L55:
        if ((524288 & r611) == 0) goto L57;
        final String r212 = null;
    L59:
        if ((1048576 & r611) == 0) goto L61;
        final String r213 = null;
    L63:
        if ((2097152 & r611) == 0) goto L65;
        final String r214 = null;
    L67:
        if ((4194304 & r611) == 0) goto L69;
        final String r215 = null;
    L71:
        if ((8388608 & r611) == 0) goto L73;
        final String r216 = null;
    L75:
        if ((16777216 & r611) == 0) goto L77;
        final String r217 = null;
    L79:
        if ((33554432 & r611) == 0) goto L81;
        final String r218 = null;
    L83:
        if ((67108864 & r611) == 0) goto L85;
        final String r219 = null;
    L87:
        if ((134217728 & r611) == 0) goto L89;
        final String r317 = null;
    L91:
        if ((r611 & 268435456) == 0) goto L93;
        final Map r102 = null;
    L94:
        if (r310 != null) goto L97;
        return;
    L97:
        if (StringsKt.endsWith$default(r310, "onBoarding-msg", false, 2, null) == true) goto L102;
        i(r316, "onClickOnboardingCard", new g(r310, r316, r102, r311, r100, r101, r314, r313, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r213, r212, r214, r215, r216, r217, r218, r219, r317));
        return;
    L102:
        return;
    L93:
        r102 = r610;
        goto L94
    L89:
        r317 = r519;
        goto L91
    L85:
        r219 = r518;
        goto L87
    L81:
        r218 = r517;
        goto L83
    L77:
        r217 = r516;
        goto L79
    L73:
        r216 = r515;
        goto L75
    L69:
        r215 = r514;
        goto L71
    L65:
        r214 = r513;
        goto L67
    L61:
        r213 = r512;
        goto L63
    L57:
        r212 = r511;
        goto L59
    L53:
        r211 = r510;
        goto L55
    L49:
        r210 = r419;
        goto L51
    L45:
        r119 = r418;
        goto L47
    L41:
        r118 = r417;
        goto L43
    L37:
        r117 = r416;
        goto L39
    L33:
        r116 = r415;
        goto L35
    L29:
        r115 = r414;
        goto L31
    L25:
        r114 = r413;
        goto L27
    L21:
        r113 = r412;
        goto L23
    L17:
        r112 = r411;
        goto L19
    L13:
        r111 = r410;
        goto L15
    L9:
        r101 = r315;
        goto L11
    L5:
        r100 = r312;
        goto L6
    }

    public static void f(final String r310, final String r311, final String r312, final String r313, Long r314, Long r315, String r410, final long r411, String r412, String r413, String r414, String r415, Integer r416, String r417, String r418, String r510, String r511, Integer r512, String r513, String r514, String r515, String r516, String r517, String r518, int r519, String r610, String r611, String r612, Map r613, int r614) {
        if ((r614 & 16) == 0) goto L5;
        final Long r110 = null;
    L7:
        if ((r614 & 32) == 0) goto L9;
        final Long r111 = null;
    L11:
        if ((r614 & 64) == 0) goto L13;
        final String r100 = null;
    L15:
        if ((r614 & 256) == 0) goto L17;
        final String r112 = null;
    L19:
        if ((r614 & 512) == 0) goto L21;
        final String r113 = null;
    L23:
        if ((r614 & 1024) == 0) goto L25;
        final String r114 = null;
    L27:
        if ((r614 & 2048) == 0) goto L29;
        final String r115 = null;
    L31:
        if ((r614 & 4096) == 0) goto L33;
        final Integer r116 = null;
    L35:
        if ((r614 & 8192) == 0) goto L37;
        final String r210 = null;
    L39:
        if ((r614 & 16384) == 0) goto L41;
        final String r211 = null;
    L43:
        if ((32768 & r614) == 0) goto L45;
        final String r212 = null;
    L47:
        if ((65536 & r614) == 0) goto L49;
        final String r213 = null;
    L51:
        if ((131072 & r614) == 0) goto L53;
        final Integer r214 = null;
    L55:
        if ((262144 & r614) == 0) goto L57;
        final String r215 = null;
    L59:
        if ((524288 & r614) == 0) goto L61;
        final String r216 = null;
    L63:
        if ((1048576 & r614) == 0) goto L65;
        final String r217 = null;
    L67:
        if ((2097152 & r614) == 0) goto L69;
        final String r218 = null;
    L71:
        if ((4194304 & r614) == 0) goto L73;
        final String r219 = null;
    L75:
        if ((8388608 & r614) == 0) goto L77;
        final String r316 = null;
    L79:
        if ((16777216 & r614) == 0) goto L81;
        final int r317 = 0;
    L83:
        if ((33554432 & r614) == 0) goto L85;
        final String r318 = null;
    L87:
        if ((67108864 & r614) == 0) goto L89;
        final String r117 = null;
    L91:
        if ((134217728 & r614) == 0) goto L93;
        final String r319 = null;
    L95:
        if ((r614 & 268435456) == 0) goto L97;
        final Map r101 = null;
    L98:
        i(r411, "onShowSingleOnboardingQuestion", new j(r310, r311, r411, r101, r100, r313, r312, r117, r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, r213, r214, r215, r217, r216, r218, r219, r316, r317, r319, r318));
        return;
    L97:
        r101 = r613;
        goto L98
    L93:
        r319 = r612;
        goto L95
    L89:
        r117 = r611;
        goto L91
    L85:
        r318 = r610;
        goto L87
    L81:
        r317 = r519;
        goto L83
    L77:
        r316 = r518;
        goto L79
    L73:
        r219 = r517;
        goto L75
    L69:
        r218 = r516;
        goto L71
    L65:
        r217 = r515;
        goto L67
    L61:
        r216 = r514;
        goto L63
    L57:
        r215 = r513;
        goto L59
    L53:
        r214 = r512;
        goto L55
    L49:
        r213 = r511;
        goto L51
    L45:
        r212 = r510;
        goto L47
    L41:
        r211 = r418;
        goto L43
    L37:
        r210 = r417;
        goto L39
    L33:
        r116 = r416;
        goto L35
    L29:
        r115 = r415;
        goto L31
    L25:
        r114 = r414;
        goto L27
    L21:
        r113 = r413;
        goto L23
    L17:
        r112 = r412;
        goto L19
    L13:
        r100 = r410;
        goto L15
    L9:
        r111 = r315;
        goto L11
    L5:
        r110 = r314;
        goto L7
    }
}
