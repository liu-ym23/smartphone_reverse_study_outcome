package t24;

import com.bytedance.ai.api.navi.AppletNaviType;
import com.bytedance.awemeopen.apps.framework.utils.e;
import com.bytedance.awemeopen.apps.framework.utils.reporter.HostCommonParamProvider;
import com.bytedance.awemeopen.awemesdk.se.b;
import com.bytedance.awemeopen.infra.base.event.d;
import java.util.Map;
import org.json.JSONObject;
import r14.c;

/* JADX INFO: loaded from: classes44.dex */
public interface a extends k24.a, n24.a {

    /* JADX INFO: renamed from: t24.a$a, reason: collision with other inner class name */
    public static final class C7679a {
        public static /* synthetic */ void h(a r100, String r101, String r102, String r110, String r111, String r112) {
            r100.k3(r101, r102, r110, r111, r112, null);
        }

        public static /* synthetic */ JSONObject a(a r110, String r111, String r112, String r113, String r114, String r115, String r116, boolean r117, boolean r118) {
            return r110.Y2(r111, r112, r113, r114, r115, r116, r117, r118, null);
        }

        public static /* synthetic */ void f(a r210, String r211, String r212, String r213, String r214, b r215, String r216, boolean r217, JSONObject r218, int r219) {
            if ((r219 & 1024) == 0) goto L5;
            b r110 = null;
        L7:
            if ((131072 & r219) == 0) goto L9;
            boolean r111 = false;
        L11:
            if ((r219 & 262144) == 0) goto L13;
            JSONObject r112 = null;
        L14:
            r210.V1(r211, r212, "", "", r213, r214, "", false, false, "", r110, "", "", "", "", null, r216, r111, r112);
            return;
        L13:
            r112 = r218;
            goto L14
        L9:
            r111 = r217;
            goto L11
        L5:
            r110 = r215;
            goto L7
        }

        public static /* synthetic */ void e(a r110, String r111, String r112, String r113, String r210, String r211, String r212, boolean r213, boolean r214, boolean r215, String r216, String r217, JSONObject r218, int r219) {
            if ((r219 & 128) == 0) goto L5;
            boolean r114 = false;
        L7:
            if ((r219 & 512) == 0) goto L9;
            String r115 = "";
        L11:
            if ((r219 & 1024) == 0) goto L13;
            String r116 = "";
        L15:
            if ((r219 & 4096) == 0) goto L17;
            JSONObject r117 = null;
        L18:
            r110.k0(r111, r112, r113, r210, r211, r212, r213, r114, r215, r115, r116, null, r117);
            return;
        L17:
            r117 = r218;
            goto L18
        L13:
            r116 = r217;
            goto L15
        L9:
            r115 = r216;
            goto L11
        L5:
            r114 = r214;
            goto L7
        }

        public static /* synthetic */ void g(a r210, String r211, String r212, String r213, String r214, String r215, boolean r216, String r217, boolean r218, boolean r310, e r311, String r312, String r313, String r314, String r315, JSONObject r316, boolean r317, int r318) {
            if ((r318 & 256) == 0) goto L5;
            boolean r110 = false;
        L7:
            if ((r318 & 512) == 0) goto L9;
            e r111 = null;
        L11:
            if ((32768 & r318) == 0) goto L13;
            JSONObject r112 = null;
        L15:
            if ((r318 & 65536) == 0) goto L17;
            boolean r219 = false;
        L18:
            r210.Y1(r211, r212, r213, r214, r215, r216, r217, r218, r110, r111, r312, r313, r314, r315, null, r112, r219);
            return;
        L17:
            r219 = r317;
            goto L18
        L13:
            r112 = r316;
            goto L15
        L9:
            r111 = r311;
            goto L11
        L5:
            r110 = r310;
            goto L7
        }

        public static /* synthetic */ void b(a r210, String r211, String r212, String r213, String r214, int r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, int r318, boolean r319, Map r410, JSONObject r411, String r412, String r413, String r414, String r415, boolean r416, int r417) {
            if ((r417 & 256) == 0) goto L5;
            String r110 = "video";
        L7:
            if ((r417 & 1024) == 0) goto L9;
            String r111 = null;
        L11:
            if ((r417 & 8192) == 0) goto L13;
            String r112 = AppletNaviType.POI;
        L15:
            if ((r417 & 16384) == 0) goto L17;
            int r113 = 2;
        L19:
            if ((32768 & r417) == 0) goto L21;
            boolean r114 = false;
        L23:
            if ((131072 & r417) == 0) goto L25;
            JSONObject r115 = null;
        L27:
            if ((262144 & r417) == 0) goto L29;
            String r215 = "";
        L31:
            if ((524288 & r417) == 0) goto L33;
            String r216 = "";
        L35:
            if ((1048576 & r417) == 0) goto L37;
            String r217 = "";
        L39:
            if ((2097152 & r417) == 0) goto L41;
            String r218 = "";
        L43:
            if ((r417 & 4194304) == 0) goto L45;
            boolean r219 = false;
        L46:
            r210.J(r211, r212, r213, r214, r310, r311, r312, r110, r314, r111, r316, null, r112, r113, r114, r410, r115, r215, r216, r217, r218, r219);
            return;
        L45:
            r219 = r416;
            goto L46
        L41:
            r218 = r415;
            goto L43
        L37:
            r217 = r414;
            goto L39
        L33:
            r216 = r413;
            goto L35
        L29:
            r215 = r412;
            goto L31
        L25:
            r115 = r411;
            goto L27
        L21:
            r114 = r319;
            goto L23
        L17:
            r113 = r318;
            goto L19
        L13:
            r112 = r317;
            goto L15
        L9:
            r111 = r315;
            goto L11
        L5:
            r110 = r313;
            goto L7
        }

        public static /* synthetic */ void c(a r210, String r211, String r212, String r213, String r214, int r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, int r318, boolean r319, Map r410, JSONObject r411, String r412, String r413, String r414, String r415, boolean r416, int r417) {
            if ((r417 & 256) == 0) goto L5;
            String r110 = "video";
        L7:
            if ((r417 & 1024) == 0) goto L9;
            String r111 = null;
        L11:
            if ((r417 & 8192) == 0) goto L13;
            String r112 = AppletNaviType.POI;
        L15:
            if ((r417 & 16384) == 0) goto L17;
            int r113 = 2;
        L19:
            if ((131072 & r417) == 0) goto L21;
            JSONObject r114 = null;
        L23:
            if ((262144 & r417) == 0) goto L25;
            String r215 = "";
        L27:
            if ((524288 & r417) == 0) goto L29;
            String r216 = "";
        L31:
            if ((1048576 & r417) == 0) goto L33;
            String r217 = "";
        L35:
            if ((2097152 & r417) == 0) goto L37;
            String r218 = "";
        L39:
            if ((r417 & 4194304) == 0) goto L41;
            boolean r219 = false;
        L42:
            r210.N2(r211, r212, r213, r214, r310, r311, r312, r110, r314, r111, r316, null, r112, r113, r319, r410, r114, r215, r216, r217, r218, r219);
            return;
        L41:
            r219 = r416;
            goto L42
        L37:
            r218 = r415;
            goto L39
        L33:
            r217 = r414;
            goto L35
        L29:
            r216 = r413;
            goto L31
        L25:
            r215 = r412;
            goto L27
        L21:
            r114 = r411;
            goto L23
        L17:
            r113 = r318;
            goto L19
        L13:
            r112 = r317;
            goto L15
        L9:
            r111 = r315;
            goto L11
        L5:
            r110 = r313;
            goto L7
        }

        public static /* synthetic */ void d(a r210, String r211, String r212, String r213, String r214, int r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, int r318, boolean r319, Map r410, JSONObject r411, String r412, String r413, String r414, String r415, boolean r416, int r417) {
            if ((r417 & 256) == 0) goto L5;
            String r110 = "video";
        L7:
            if ((r417 & 1024) == 0) goto L9;
            String r111 = null;
        L11:
            if ((r417 & 8192) == 0) goto L13;
            String r112 = AppletNaviType.POI;
        L15:
            if ((r417 & 16384) == 0) goto L17;
            int r113 = 2;
        L19:
            if ((131072 & r417) == 0) goto L21;
            JSONObject r114 = null;
        L23:
            if ((262144 & r417) == 0) goto L25;
            String r215 = "";
        L27:
            if ((524288 & r417) == 0) goto L29;
            String r216 = "";
        L31:
            if ((1048576 & r417) == 0) goto L33;
            String r217 = "";
        L35:
            if ((2097152 & r417) == 0) goto L37;
            String r218 = "";
        L39:
            if ((r417 & 4194304) == 0) goto L41;
            boolean r219 = false;
        L42:
            r210.L1(r211, r212, r213, r214, r310, r311, r312, r110, r314, r111, r316, null, r112, r113, r319, r410, r114, r215, r216, r217, r218, r219);
            return;
        L41:
            r219 = r416;
            goto L42
        L37:
            r218 = r415;
            goto L39
        L33:
            r217 = r414;
            goto L35
        L29:
            r216 = r413;
            goto L31
        L25:
            r215 = r412;
            goto L27
        L21:
            r114 = r411;
            goto L23
        L17:
            r113 = r318;
            goto L19
        L13:
            r112 = r317;
            goto L15
        L9:
            r111 = r315;
            goto L11
        L5:
            r110 = r313;
            goto L7
        }

        public static /* synthetic */ void i(a r210, String r211, String r212, String r213, String r214, int r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, int r318, boolean r319, Map r410, JSONObject r411, String r412, String r413, String r414, String r415, boolean r416, int r417) {
            if ((r417 & 256) == 0) goto L5;
            String r110 = "video";
        L7:
            if ((r417 & 1024) == 0) goto L9;
            String r111 = null;
        L11:
            if ((r417 & 8192) == 0) goto L13;
            String r112 = AppletNaviType.POI;
        L15:
            if ((r417 & 16384) == 0) goto L17;
            int r113 = 2;
        L19:
            if ((131072 & r417) == 0) goto L21;
            JSONObject r114 = null;
        L23:
            if ((262144 & r417) == 0) goto L25;
            String r215 = "";
        L27:
            if ((524288 & r417) == 0) goto L29;
            String r216 = "";
        L31:
            if ((1048576 & r417) == 0) goto L33;
            String r217 = "";
        L35:
            if ((2097152 & r417) == 0) goto L37;
            String r218 = "";
        L39:
            if ((r417 & 4194304) == 0) goto L41;
            boolean r219 = false;
        L42:
            r210.a2(r211, r212, r213, r214, r310, r311, r312, r110, r314, r111, r316, null, r112, r113, r319, r410, r114, r215, r216, r217, r218, r219);
            return;
        L41:
            r219 = r416;
            goto L42
        L37:
            r218 = r415;
            goto L39
        L33:
            r217 = r414;
            goto L35
        L29:
            r216 = r413;
            goto L31
        L25:
            r215 = r412;
            goto L27
        L21:
            r114 = r411;
            goto L23
        L17:
            r113 = r318;
            goto L19
        L13:
            r112 = r317;
            goto L15
        L9:
            r111 = r315;
            goto L11
        L5:
            r110 = r313;
            goto L7
        }
    }

    void A0(String r100, String r101, String r102, String r103, long r104, d r105);

    void A1(String r100, String r101, String r102, String r103, int r104, String r105, String r106, int r107, String r108, boolean r110, boolean r111, d r112, JSONObject r113);

    void B0();

    void B2(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, String r107, String r108, boolean r110, String r111, float r112, float r113);

    void C(String r100, String r101, String r102, String r103, String r104, String r105, String r106, boolean r107, boolean r108, boolean r110, d r111, String r112, String r113, String r114, String r115, boolean r116, String r117, JSONObject r118);

    void C0(boolean r100);

    void C1(String r100, String r101);

    void D(String r100, Map r101, String r102, JSONObject r103);

    void D2(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, d r111, JSONObject r112, String r113, String r114);

    void E0(String r100, boolean r101, long r102, int r103, int r104);

    void E2(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, boolean r107, String r108, String r110, d r111, String r112, String r113, String r114, String r115, Integer r116, String r117, boolean r118, JSONObject r119, Map<String, String> r210);

    void F0(String r100, String r101, String r102, boolean r103, Integer r104, String r105, String r106);

    void F1(String r100, String r101, String r102, String r103, String r104, String r105, String r106, d r107, JSONObject r108);

    void G();

    void H0();

    void H1(d r100);

    void H2(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, String r107, String r108, d r110);

    void I2(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, long r107, int r110, String r111, int r112, d r113);

    void J(String r100, String r101, String r102, String r103, int r104, String r105, String r106, String r107, String r108, String r110, String r111, d r112, String r113, int r114, boolean r115, Map r116, JSONObject r117, String r118, String r119, String r210, String r211, boolean r212);

    void J2(long r100, int r101, String r102, String r103, String r104, d r105);

    void K0(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, String r107, boolean r108, boolean r110, String r111, boolean r112, d r113, String r114, String r115, String r116, String r117, String r118);

    void K1(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107);

    void K2(String r100, String r101, String r102, String r103, String r104, String r105);

    void L(String r100);

    void L1(String r100, String r101, String r102, String r103, int r104, String r105, String r106, String r107, String r108, String r110, String r111, d r112, String r113, int r114, boolean r115, Map r116, JSONObject r117, String r118, String r119, String r210, String r211, boolean r212);

    void L2(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, JSONObject r112);

    void M0(String r100, String r101, String r102, long r103, String r104, String r105, String r106, boolean r107, boolean r110, String r111, String r112, String r113, String r114, String r115, String r116);

    void M2(String r100, c r101, boolean r102);

    void N(String r100, String r101, String r102, String r103, String r104, String r105);

    void N0(String r100, String r101, String r102);

    void N1(String r100, String r101, String r102, String r103, String r104, String r105);

    void N2(String r100, String r101, String r102, String r103, int r104, String r105, String r106, String r107, String r108, String r110, String r111, d r112, String r113, int r114, boolean r115, Map r116, JSONObject r117, String r118, String r119, String r210, String r211, boolean r212);

    void O(String r100, String r101, String r102, String r103, d r104);

    void O1(String r100, String r101, String r102, String r103);

    void P(String r100, String r101, String r102, String r103);

    void P0(String r100, String r101, String r102, String r103, String r104, String r105);

    void Q2(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, boolean r107, e r108, String r110, String r111, String r112, boolean r113, String r114, JSONObject r115);

    void R(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, JSONObject r112);

    void R0(String r100, String r101, String r102, String r103, String r104, String r105);

    void R1(String r100, String r101, String r102, String r103, int r104, String r105, String r106, String r107, int r108, String r110, String r111, int r112, String r113, boolean r114, boolean r115, JSONObject r116);

    void S(String r100, String r101, String r102, String r103, String r104, float r105, float r106, e r107);

    void S1(String r100, String r101, String r102, String r103, String r104, String r105, String r106, boolean r107, e r108);

    void T0(String r100, String r101, String r102, String r103, String r104, String r105);

    void T1(String r100, String r101, String r102, String r103, int r104, String r105, String r106, int r107, String r108, boolean r110, boolean r111, boolean r112, JSONObject r113);

    void U(String r100, String r101, String r102, String r103, String r104, String r105, String r106, boolean r107, boolean r108, JSONObject r110);

    void U0(String r100, String r101, String r102, String r103, String r104, float r105, String r106, boolean r107, String r108, boolean r110, boolean r111, boolean r112, String r113, boolean r114, boolean r115, boolean r116, String r117, String r118, d r119, String r210, String r211, String r212, String r213, String r214, Integer r215, Map<String, String> r216, String r217, String r218, String r219, boolean r310, boolean r311, JSONObject r312, String r313);

    void U1(String r100, String r101, String r102, String r103, int r104, String r105, String r106, int r107, String r108, boolean r110, d r111, JSONObject r112);

    void V(String r100, String r101, String r102, String r103, int r104, String r105, String r106, String r107, String r108, String r110, String r111, d r112, String r113, int r114, boolean r115, Map r116, JSONObject r117, String r118, String r119, String r210, String r211, boolean r212, long r213);

    void V0(String r100, int r101);

    void V1(String r100, String r101, String r102, String r103, String r104, String r105, String r106, boolean r107, boolean r108, String r110, d r111, String r112, String r113, String r114, String r115, String r116, String r117, boolean r118, JSONObject r119);

    void W0(String r100, String r101, String r102, String r103, String r104, String r105, String r106, int r107, boolean r108, String r110, boolean r111, boolean r112, d r113, String r114, String r115, String r116, String r117, JSONObject r118, boolean r119);

    void W1(String r100, String r101, String r102, String r103, int r104, String r105, String r106, String r107, int r108, String r110, String r111, int r112, String r113, boolean r114, d r115, JSONObject r116);

    void X(boolean r100, String r101, String r102, String r103, String r104, String r105, String r106, boolean r107, boolean r108, boolean r110, d r111, String r112, String r113, String r114, String r115, boolean r116, String r117, JSONObject r118, String r119);

    void X0(String r100, String r101, String r102, boolean r103);

    void X1(String r100, String r101, String r102, String r103, String r104, String r105, String r106, boolean r107, long r108, long r110, boolean r111, Integer r112, d r113);

    void Y1(String r100, String r101, String r102, String r103, String r104, boolean r105, String r106, boolean r107, boolean r108, d r110, String r111, String r112, String r113, String r114, String r115, JSONObject r116, boolean r117);

    JSONObject Y2(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, boolean r107, d r108);

    void Z(String r100);

    void Z0(boolean r100, int r101, String r102, String r103, long r104, int r105, d r106);

    void Z1(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, boolean r108, boolean r110, String r111, String r112, String r113, double r114, int r115, e r116);

    void a0(String r100, boolean r101, d r102);

    void a2(String r100, String r101, String r102, String r103, int r104, String r105, String r106, String r107, String r108, String r110, String r111, d r112, String r113, int r114, boolean r115, Map r116, JSONObject r117, String r118, String r119, String r210, String r211, boolean r212);

    void a3(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, String r107, d r108, String r110, String r111, String r112, Integer r113);

    void b0(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, String r107, boolean r108, boolean r110, d r111, String r112, String r113, String r114, String r115, JSONObject r116, boolean r117, String r118);

    void b1();

    void b2(String r100, String r101);

    void b3(String r100, String r101, String r102, long r103, float r104, String r105, String r106, String r107, boolean r110, boolean r111, String r112, boolean r113, boolean r114, long r115, String r116, String r117, d r118, String r210, String r211, String r212, String r213, String r214, String r215, String r216, boolean r217, JSONObject r218, String r219);

    void c0(String r100, String r101, String r102, String r103, String r104, String r105, String r106, boolean r107, boolean r108, String r110, Integer r111, d r112);

    void d(String r100, String r101, String r102, String r103, String r104);

    void d0(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106);

    void d1(String r100, String r101, String r102, String r103, String r104);

    void d3(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, boolean r107, JSONObject r108, String r110);

    void e0(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, d r107);

    void e1(String r100, String r101);

    void e2(String r100, String r101, String r102, String r103, String r104, boolean r105, boolean r106, boolean r107, d r108, String r110, String r111, String r112, String r113, JSONObject r114, boolean r115, String r116);

    void e3(String r100, int r101, long r102, boolean r103, int r104, int r105, long r106, long r110, long r111, String r112, String r113, String r114, String r115, String r116, String r117, String r210, boolean r211, boolean r212, String r213, String r214, d r215, String r216);

    void f1(String r100, String r101, String r102, String r103, int r104, String r105, String r106, int r107, String r108, boolean r110, JSONObject r111);

    void f3(String r100, String r101, String r102, String r103, d r104);

    void g0(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107);

    void g1(String r100, String r101, String r102, String r103, String r104);

    boolean g3();

    String getEventValue();

    void h(String r100);

    void h1(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, boolean r107, JSONObject r108, e r110);

    void h2(String r100, String r101, String r102, String r103, String r104);

    void i2(String r100, String r101, String r102, String r103, String r104, String r105, String r106, boolean r107, int r108, boolean r110, double r111, float r112, long r113, Float r114, int r115, boolean r116, boolean r117, Integer r210, Integer r211, Integer r212, JSONObject r213, HostCommonParamProvider r214);

    void j2(String r100, String r101, String r102, String r103, String r104, boolean r105, boolean r106, boolean r107, String r108, String r110, d r111, String r112, String r113, String r114, String r115, String r116, String r117, boolean r118, JSONObject r119, String r210);

    boolean k();

    void k0(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, boolean r107, boolean r108, String r110, String r111, d r112, JSONObject r113);

    void k1(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, String r107, String r108, d r110);

    void k3(String r100, String r101, String r102, String r103, String r104, d r105);

    void l1(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, int r110, boolean r111, JSONObject r112);

    void l3(String r100, String r101, String r102, String r103, String r104, long r105, String r106, boolean r107);

    void m0(String r100, String r101, String r102, String r103, d r104, String r105, String r106, String r107, double r108, JSONObject r110);

    void n0(String r100, String r101, String r102, String r103, String r104);

    void n1(String r100, String r101, String r102, String r103, String r104, String r105);

    void n2(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, boolean r107, String r108, d r110, String r111, String r112, String r113, String r114, Integer r115, boolean r116, String r117, JSONObject r118, Map<String, String> r119);

    void n3(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106);

    void o(String r100, Map<String, String> r101);

    void o0(String r100, String r101, String r102, String r103, String r104, String r105);

    void p(String r100, String r101, String r102, String r103, int r104, String r105, String r106, String r107, String r108, String r110);

    void p1(String r100, boolean r101);

    void p2(JSONObject r100);

    void q0(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108);

    void q1(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, String r107, String r108, boolean r110, String r111);

    void q3(String r100, String r101, String r102, long r103, String r104, String r105, String r106, boolean r107, boolean r110, String r111, boolean r112, boolean r113, long r114, String r115, String r116, d r117, String r118, String r210, String r211, String r212, String r213, String r214, String r215, JSONObject r216);

    void r(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, int r111, int r112, String r113, JSONObject r114);

    void r1(String r100, String r101, String r102, String r103, String r104, JSONObject r105, e r106);

    void reportVideoCardClick(Map<String, String> r100);

    void reportVideoCardShow(Map<String, String> r100);

    void s2(boolean r100, long r101);

    void t(String r100, boolean r101, boolean r102, boolean r103, int r104, long r105, long r106, long r110, long r111, long r112, long r113, boolean r114, int r115);

    void t0(String r100, int r101, boolean r102, d r103);

    void t1(String r100);

    void u1(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, int r110, JSONObject r111);

    void u2(String r100, String r101, String r102, String r103, boolean r104, int r105);

    void u3(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, String r107, boolean r108, boolean r110, boolean r111, String r112, boolean r113, boolean r114, boolean r115, String r116, String r117, d r118, String r119, String r210, String r211, String r212, String r213, Map<String, String> r214, String r215, String r216, String r217, int r218, String r219, JSONObject r310);

    void v(String r100);

    void v0();

    void w1(String r100, String r101, String r102, String r103, d r104, String r105, String r106, String r107, double r108, JSONObject r110);

    void w3(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, boolean r107, boolean r108, d r110, float r111, float r112, String r113, String r114, String r115, String r116, JSONObject r117);

    void x(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, String r107, String r108, String r110, float r111, long r112, d r113);

    void x1(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, String r107, String r108, String r110, float r111, boolean r112, e r113);

    void x2(String r100, String r101, String r102, String r103, d r104);

    void y0(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, int r107, boolean r108, String r110, d r111);

    void y2(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, int r111, int r112, String r113, String r114, JSONObject r115);

    void z0(d r100);
}
