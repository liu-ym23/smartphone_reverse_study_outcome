package pb0;

import com.bytedance.android.live.ktv.common.model.api.s;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.HashMap;

/* JADX INFO: loaded from: classes45.dex */
public interface a {

    /* JADX INFO: renamed from: pb0.a$a, reason: collision with other inner class name */
    public static final class C7174a {
        public static /* synthetic */ void b(a r100, String r101, String r110, String r111, String r112, String r113, int r114) {
            if ((r114 & 2) == 0) goto L5;
            String r102 = "";
        L7:
            if ((r114 & 4) == 0) goto L9;
            String r103 = "";
        L11:
            if ((r114 & 8) == 0) goto L13;
            r112 = null;
        L13:
            String r104 = r112;
            if ((r114 & 16) == 0) goto L16;
            r113 = "0";
        L16:
            r100.j(r101, r102, r103, r104, r113);
            return;
        L9:
            r103 = r111;
            goto L11
        L5:
            r102 = r110;
            goto L7
        }

        public static /* synthetic */ void a(a r210, String r211, String r212, String r213, String r214, String r215, String r216, long r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, Boolean r318, Boolean r410, MusicPanel r411, int r412) {
            if ((r412 & 8) == 0) goto L5;
            String r100 = "";
        L7:
            if ((r412 & 16) == 0) goto L9;
            String r101 = "";
        L11:
            if ((r412 & 32) == 0) goto L13;
            String r102 = "";
        L15:
            if ((r412 & 64) == 0) goto L17;
            long r110 = 0;
        L19:
            if ((r412 & 128) == 0) goto L21;
            String r111 = "";
        L23:
            if ((r412 & 256) == 0) goto L25;
            String r112 = "";
        L27:
            if ((r412 & 512) == 0) goto L29;
            String r113 = "";
        L31:
            if ((r412 & 1024) == 0) goto L33;
            String r114 = "";
        L35:
            if ((r412 & 4096) == 0) goto L37;
            String r115 = null;
        L39:
            if ((r412 & 8192) == 0) goto L41;
            String r116 = null;
        L43:
            if ((r412 & 16384) == 0) goto L45;
            String r117 = null;
        L47:
            if ((32768 & r412) == 0) goto L49;
            Boolean r217 = null;
        L51:
            if ((r412 & 65536) == 0) goto L53;
            Boolean r218 = null;
        L54:
            r210.o(r211, r212, r213, r100, r101, r102, r110, r111, r112, r113, r114, null, r115, r116, r117, r217, r218, r411);
            return;
        L53:
            r218 = r410;
            goto L54
        L49:
            r217 = r318;
            goto L51
        L45:
            r117 = r317;
            goto L47
        L41:
            r116 = r316;
            goto L43
        L37:
            r115 = r315;
            goto L39
        L33:
            r114 = r314;
            goto L35
        L29:
            r113 = r313;
            goto L31
        L25:
            r112 = r312;
            goto L27
        L21:
            r111 = r311;
            goto L23
        L17:
            r110 = r310;
            goto L19
        L13:
            r102 = r216;
            goto L15
        L9:
            r101 = r215;
            goto L11
        L5:
            r100 = r214;
            goto L7
        }
    }

    void a();

    void b(String r100, String r101, boolean r102, String r103, String r104, String r105, String r106, String r107, String r108);

    void c(String r100, String r101);

    void d(String r100, long r101, String r102, String r103, String r104, long r105, boolean r106, String r110, int r111, int r112, String r113, Boolean r114);

    void e(String r100, String r101, Boolean r102, Boolean r103, String r104, String r105, String r106, Boolean r107);

    void f(MusicPanel r100, String r101, String r102, String r103, long r104, String r105, boolean r106, String r107, String r110, HashMap<String, String> r111, String r112, String r113, Integer r114, String r115, String r116, Boolean r117);

    void g(String r100, Throwable r101);

    void h(String r100, String r101, boolean r102);

    void i(String r100, String r101, String r102, boolean r103, boolean r104);

    void j(String r100, String r101, String r102, String r103, String r104);

    void k(String r100, String r101);

    void l(String r100, String r101, String r102, String r103);

    void m(int r100, s r101);

    void n(String r100, String r101);

    void o(String r100, String r101, String r102, String r103, String r104, String r105, long r106, String r107, String r110, String r111, String r112, HashMap<String, String> r113, String r114, String r115, String r116, Boolean r117, Boolean r118, MusicPanel r119);

    void p(String r100, String r101, String r102, String r103);

    void q(String r100, String r101, String r102, String r103, String r104, String r105, String r106);

    void r(String r100, String r101, String r102, String r103);

    void s(int r100, s r101);

    void t(MusicPanel r100, String r101, String r102, HashMap<String, String> r103, String r104);

    void u(String r100);

    void v(String r100, String r101, String r102, long r103, String r104, String r105, Integer r106, String r107, String r110);

    void w(boolean r100);
}
