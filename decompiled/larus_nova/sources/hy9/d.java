package hy9;

import com.larus.im.bean.message.Message;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public interface d {

    public static final class a {
        public static /* synthetic */ void b(d r210, String r211, String r212, String r213, String r214, String r215, String r310, String r311, String r312, String r313, String r314, Boolean r315, String r316, String r317, String r318, String r319, String r410, String r411, String r412, int r413) {
            JSONObject r100 = null;
            if ((r413 & 1) == 0) goto L5;
            String r101 = null;
        L7:
            if ((r413 & 2) == 0) goto L9;
            String r102 = null;
        L11:
            if ((r413 & 4) == 0) goto L13;
            String r103 = null;
        L15:
            if ((r413 & 8) == 0) goto L17;
            String r104 = null;
        L19:
            if ((r413 & 16) == 0) goto L21;
            String r105 = null;
        L23:
            if ((r413 & 32) == 0) goto L25;
            String r106 = null;
        L27:
            if ((r413 & 64) == 0) goto L29;
            String r110 = null;
        L31:
            if ((r413 & 128) == 0) goto L33;
            String r111 = null;
        L35:
            if ((r413 & 256) == 0) goto L37;
            String r112 = null;
        L39:
            if ((r413 & 512) == 0) goto L41;
            String r113 = null;
        L43:
            if ((r413 & 1024) == 0) goto L45;
            Boolean r114 = null;
        L47:
            if ((r413 & 2048) == 0) goto L49;
            String r115 = null;
        L51:
            if ((r413 & 4096) == 0) goto L53;
            String r116 = "no_tab";
        L55:
            if ((r413 & 8192) == 0) goto L57;
            String r117 = null;
        L59:
            if ((r413 & 16384) == 0) goto L61;
            String r118 = null;
        L63:
            if ((32768 & r413) == 0) goto L65;
            String r119 = null;
        L67:
            if ((65536 & r413) == 0) goto L69;
            String r216 = null;
        L71:
            if ((131072 & r413) == 0) goto L73;
            String r217 = null;
        L75:
            if ((r413 & 262144) == 0) goto L77;
            r100 = new JSONObject();
        L77:
            r210.g(r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r216, r217, r100, null);
            return;
        L73:
            r217 = r412;
            goto L75
        L69:
            r216 = r411;
            goto L71
        L65:
            r119 = r410;
            goto L67
        L61:
            r118 = r319;
            goto L63
        L57:
            r117 = r318;
            goto L59
        L53:
            r116 = r317;
            goto L55
        L49:
            r115 = r316;
            goto L51
        L45:
            r114 = r315;
            goto L47
        L41:
            r113 = r314;
            goto L43
        L37:
            r112 = r313;
            goto L39
        L33:
            r111 = r312;
            goto L35
        L29:
            r110 = r311;
            goto L31
        L25:
            r106 = r310;
            goto L27
        L21:
            r105 = r215;
            goto L23
        L17:
            r104 = r214;
            goto L19
        L13:
            r103 = r213;
            goto L15
        L9:
            r102 = r212;
            goto L11
        L5:
            r101 = r211;
            goto L7
        }

        public static /* synthetic */ void a(d r210, String r211, String r212, String r213, String r310, String r311, String r312, String r313, String r314, String r315, String r316, Boolean r317, String r318, String r319, String r410, String r411, String r412, String r413, String r414, String r415, String r416, JSONObject r417, int r418) {
            if ((r418 & 1) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r418 & 2) == 0) goto L9;
            String r101 = null;
        L11:
            if ((r418 & 4) == 0) goto L13;
            String r102 = null;
        L15:
            if ((r418 & 8) == 0) goto L17;
            String r103 = null;
        L19:
            if ((r418 & 16) == 0) goto L21;
            String r104 = null;
        L23:
            if ((r418 & 32) == 0) goto L25;
            String r105 = null;
        L27:
            if ((r418 & 64) == 0) goto L29;
            String r110 = null;
        L31:
            if ((r418 & 128) == 0) goto L33;
            String r111 = null;
        L35:
            if ((r418 & 256) == 0) goto L37;
            String r112 = null;
        L39:
            if ((r418 & 512) == 0) goto L41;
            String r113 = null;
        L43:
            if ((r418 & 1024) == 0) goto L45;
            Boolean r114 = null;
        L47:
            if ((r418 & 2048) == 0) goto L49;
            String r115 = null;
        L51:
            if ((r418 & 4096) == 0) goto L53;
            String r116 = null;
        L55:
            if ((r418 & 8192) == 0) goto L57;
            String r117 = null;
        L59:
            if ((r418 & 16384) == 0) goto L61;
            String r118 = null;
        L63:
            if ((32768 & r418) == 0) goto L65;
            String r119 = null;
        L67:
            if ((65536 & r418) == 0) goto L69;
            String r214 = "no_tab";
        L71:
            if ((131072 & r418) == 0) goto L73;
            String r215 = null;
        L75:
            if ((262144 & r418) == 0) goto L77;
            String r216 = null;
        L79:
            if ((524288 & r418) == 0) goto L81;
            String r217 = null;
        L83:
            if ((r418 & 1048576) == 0) goto L85;
            JSONObject r218 = new JSONObject();
        L86:
            r210.i(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r214, r215, r216, r217, r218, null);
            return;
        L85:
            r218 = r417;
            goto L86
        L81:
            r217 = r416;
            goto L83
        L77:
            r216 = r415;
            goto L79
        L73:
            r215 = r414;
            goto L75
        L69:
            r214 = r413;
            goto L71
        L65:
            r119 = r412;
            goto L67
        L61:
            r118 = r411;
            goto L63
        L57:
            r117 = r410;
            goto L59
        L53:
            r116 = r319;
            goto L55
        L49:
            r115 = r318;
            goto L51
        L45:
            r114 = r317;
            goto L47
        L41:
            r113 = r316;
            goto L43
        L37:
            r112 = r315;
            goto L39
        L33:
            r111 = r314;
            goto L35
        L29:
            r110 = r313;
            goto L31
        L25:
            r105 = r312;
            goto L27
        L21:
            r104 = r311;
            goto L23
        L17:
            r103 = r310;
            goto L19
        L13:
            r102 = r213;
            goto L15
        L9:
            r101 = r212;
            goto L11
        L5:
            r100 = r211;
            goto L7
        }
    }

    void a(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108);

    ky9.a b();

    void c(String r100);

    void d(int r100, String r101, String r102, String r103, String r104);

    ky9.b e();

    void f(String r100, String r101, String r102, String r103, String r104);

    void g(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, Boolean r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, JSONObject r119, by7.e r210);

    void h(String r100, Integer r101, String r102, String r103, String r104, String r105, String r106, String r107, JSONObject r108, by7.e r110, String r111);

    void i(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, Boolean r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, String r119, String r210, JSONObject r211, by7.e r212);

    void j(Message r100, String r101);

    void k(String r100, String r101, String r102, String r103);
}
