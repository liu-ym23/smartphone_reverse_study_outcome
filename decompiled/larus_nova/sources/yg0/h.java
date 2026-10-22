package yg0;

import android.content.Context;
import android.util.Log;
import androidx.camera.video.AudioStats;
import androidx.core.util.Preconditions;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.k;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.n;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.t;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.livesdk.config.h30;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ln0.a f567472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List<Integer> f567473b;

    public h() {
    }

    static {
        zg0.a r100 = new zg0.a();
        int r101 = ln0.b.a.f509972g;
        Context r102 = s1.getContext();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        ln0.b.a r103 = new ln0.b.a(r102);
        Intrinsics.checkNotNullParameter("/dynamicconfigv2/multilink/", "geckoAccessKey");
        r103.f509974b = "/dynamicconfigv2/multilink/";
        Intrinsics.checkNotNullParameter("dynamicconfigv2/multilink/", "assetsAccessKey");
        r103.f509973a = "dynamicconfigv2/multilink/";
        pn0.b r104 = new pn0.b(vm2.d.M0().f(), vm2.d.M0().d(), vm2.d.M0().a(), vm2.d.M0().b(), vm2.d.M0().e());
        Intrinsics.checkNotNullParameter(r104, "setting");
        r103.f509975c = r104;
        b r105 = new b(r100);
        Intrinsics.checkNotNullParameter(r105, "geckoResProvider");
        r103.f509976d = r105;
        c r106 = new c();
        Intrinsics.checkNotNullParameter(r106, "monitorProvider");
        r103.f509977e = r106;
        ln0.b r107 = new ln0.b(r103);
        int r108 = ln0.a.f509964c;
        Intrinsics.checkNotNullParameter(r107, "layoutCoreConfig");
        f567472a = new ln0.a(r107);
    }

    public static Pair c(zj0.c r100) {
        if ((r100 instanceof zj0.c.C8467c) == true) goto L5;
        zj0.c r101 = null;
    L6:
        zj0.c.C8467c r102 = (zj0.c.C8467c) r101;
        if (r102 == null) goto L9;
        int r103 = r102.f572384b;
        int r104 = r102.f572385c;
    L11:
        if ((r100 instanceof zj0.c.b) == true) goto L13;
        zj0.c r105 = null;
    L14:
        zj0.c.b r106 = (zj0.c.b) r105;
        if (r106 == null) goto L18;
        r103 = r106.f572382b;
        r104 = r106.f572383c;
    L18:
        if ((r100 instanceof zj0.c.a) == true) goto L20;
        zj0.c r107 = null;
    L21:
        zj0.c.a r108 = (zj0.c.a) r107;
        if (r108 == null) goto L25;
        r103 = r108.f572379b;
        r104 = r108.f572380c;
    L25:
        if ((r100 instanceof zj0.c.e) == true) goto L27;
        zj0.c r109 = null;
    L28:
        zj0.c.e r110 = (zj0.c.e) r109;
        if (r110 == null) goto L34;
        r103 = r110.f572388b.getSubScene();
        r104 = r110.f572388b.getUiLayout();
        if (r104 > 0) goto L34;
        r104 = e(r110.f572388b.getVersion());
    L34:
        if ((r100 instanceof zj0.c.d) == true) goto L36;
        zj0.c r111 = null;
    L37:
        zj0.c.d r112 = (zj0.c.d) r111;
        if (r112 == null) goto L41;
        r103 = r112.f572386b;
        r104 = r112.f572387c;
    L41:
        if ((r100 instanceof zj0.c.f) == true) goto L43;
        r100 = null;
    L43:
        zj0.c.f r113 = (zj0.c.f) r100;
        if (r113 == null) goto L47;
        r103 = r113.f572390b;
        r104 = r113.f572391c;
    L47:
        return new Pair(Integer.valueOf(r103), Integer.valueOf(r104));
    L36:
        r111 = r100;
        goto L37
    L27:
        r109 = r100;
        goto L28
    L20:
        r107 = r100;
        goto L21
    L13:
        r105 = r100;
        goto L14
    L9:
        r103 = 0;
        r104 = 0;
        goto L11
    L5:
        r101 = r100;
        goto L6
    }

    public static int d(int r100) {
        if (r100 != 21) goto L5;
    L50:
        return 3;
    L5:
        if (r100 == 22) goto L50;
        if (r100 != 51) goto L9;
        return 17;
    L9:
        if (r100 == 61) goto L46;
        if (r100 != 65) goto L13;
        return 37;
    L13:
        if (r100 != 67) goto L15;
        return 39;
    L15:
        if (r100 != 113) goto L17;
    L42:
        return 30;
    L17:
        if (r100 == 1000) goto L50;
        if (r100 != 102) goto L21;
    L41:
        return 11;
    L21:
        if (r100 == 103) goto L41;
        switch(r100) {
            case 1: goto L33;
            case 2: goto L41;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L30;
            case 6: goto L29;
            case 7: goto L28;
            case 8: goto L27;
            default: goto L23;
        };
    L23:
        switch(r100) {
            case 11: goto L37;
            case 12: goto L52;
            case 13: goto L36;
            case 14: goto L35;
            case 15: goto L42;
            case 16: goto L34;
            default: goto L24;
        };
    L24:
        switch(r100) {
            case 26: goto L50;
            case 27: goto L50;
            case 28: goto L50;
            case 29: goto L50;
            case 30: goto L50;
            default: goto L25;
        };
    L25:
        switch(r100) {
            case 56: goto L40;
            case 57: goto L39;
            case 58: goto L38;
            default: goto L48;
        };
    L38:
        return 33;
    L39:
        return 32;
    L40:
        return 31;
    L48:
        return 0;
    L34:
        return 35;
    L35:
        return 24;
    L36:
        return 23;
    L37:
        return 20;
    L52:
        return 21;
    L27:
        return 8;
    L28:
        return 15;
    L29:
        return 12;
    L30:
        return 9;
    L31:
        return 16;
    L32:
        return 13;
    L33:
        return 10;
    L46:
        if (KtvSettingHelper.w() == false) goto L48;
        goto L48
    }

    public static int e(int r100) {
        if (r100 != 15) goto L5;
        return 7;
    L5:
        if (r100 != 16) goto L7;
        return 4;
    L7:
        if (r100 != 20) goto L9;
        return 11;
    L9:
        if (r100 != 21) goto L11;
        return 12;
    L11:
        if (r100 != 23) goto L13;
        return 13;
    L13:
        if (r100 != 24) goto L15;
        return 14;
    L15:
        if (r100 != 30) goto L17;
        return 15;
    L17:
        if (r100 != 35) goto L19;
        return 16;
    L19:
        if (r100 == 37) goto L31;
        switch(r100) {
            case 8: goto L29;
            case 9: goto L28;
            case 10: goto L27;
            case 11: goto L26;
            case 12: goto L25;
            case 13: goto L24;
            default: goto L22;
        };
    L24:
        return 3;
    L25:
        return 6;
    L26:
        return 2;
    L27:
        return 1;
    L28:
        return 5;
    L29:
        return 8;
    L22:
        if (aj0.b.b(Integer.valueOf(r100)) == false) goto L30;
        return 51;
    L30:
        return 0;
    L31:
        return 65;
    }

    public static boolean i(int r100) {
        if (((List) vm2.e.W.getValue(null, vm2.e.f556037a[47])).contains(String.valueOf(r100)) == true) goto L6;
        return false;
    L6:
        return true;
    }

    public static boolean j(int r100, int r101) {
        if (r101 > 0) goto L5;
        r101 = e(r100);
    L5:
        return i(r101);
    }

    public static pn0.f a(m r100, Triple r110, Pair r111) {
        Intrinsics.checkNotNullParameter(r100, "layoutConfig");
        Intrinsics.checkNotNullParameter(r110, "absContainerWHAndReason");
        Intrinsics.checkNotNullParameter(r111, "livePlayerVideoSize");
        int r101 = ah0.a.f3406a;
        Intrinsics.checkNotNullParameter(r100, "layoutConfig");
        LayoutConfigModel r102 = new LayoutConfigModel();
        r102.z(r100.j());
        r102.F(r100.getUiLayout());
        r102.v(r100.f());
        r102.w(r100.g());
        r102.D(r100.n());
        r102.C(r100.m());
        r102.B(r100.l());
        r102.r();
        m.a r103 = r100.c();
        if (r103 == null) goto L5;
        int r104 = r103.e();
    L6:
        r102.y(r104);
        m.a r105 = r100.c();
        if (r105 == null) goto L9;
        int r106 = r105.b();
    L10:
        r102.s(r106);
        r102.E(new LayoutConfigModel.g());
        LayoutConfigModel.g r107 = r102.p();
        int r108 = 0;
        if (r107 == null) goto L29;
        m.f r109 = r100.t();
        if (r109 == null) goto L15;
        int r112 = r109.c();
    L16:
        r107.g(r112);
        m.f r113 = r100.t();
        if (r113 == null) goto L19;
        int r114 = r113.e();
    L20:
        r107.i(r114);
        m.f r115 = r100.t();
        if (r115 == null) goto L23;
        int r116 = r115.d();
    L24:
        r107.h(r116);
        m.f r117 = r100.t();
        if (r117 == null) goto L27;
        int r118 = r117.b();
    L28:
        r107.f(r118);
        goto L29
    L27:
        r118 = 0;
        goto L28
    L23:
        r116 = 0;
        goto L24
    L19:
        r114 = 0;
        goto L20
    L15:
        r112 = 0;
    L29:
        r102.t(new LayoutConfigModel.b());
        LayoutConfigModel.b r119 = r102.e();
        if (r119 == null) goto L45;
        m.a r120 = r100.c();
        if (r120 == null) goto L34;
        int r121 = r120.f();
    L35:
        r119.g(r121);
        m.a r122 = r100.c();
        if (r122 == null) goto L38;
        int r123 = r122.d();
    L39:
        r119.f(r123);
        m.a r124 = r100.c();
        if (r124 == null) goto L43;
        String r125 = r124.c();
        if (r125 == null) goto L43;
    L44:
        r119.e(r125);
    L43:
        r125 = "#322542";
        goto L44
    L38:
        r123 = 0;
        goto L39
    L34:
        r121 = 0;
    L45:
        r102.u(new LayoutConfigModel.d());
        LayoutConfigModel.d r126 = r102.f();
        if (r126 == null) goto L62;
        m.c r127 = r100.d();
        double r128 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r127 == null) goto L50;
        double r129 = r127.d();
    L51:
        r126.h(r129);
        m.c r130 = r100.d();
        if (r130 == null) goto L54;
        r128 = r130.e();
    L54:
        r126.i(r128);
        m.c r131 = r100.d();
        if (r131 == null) goto L57;
        int r132 = r131.c();
    L58:
        r126.g(r132);
        m.c r133 = r100.d();
        if (r133 == null) goto L61;
        r108 = r133.b();
    L61:
        r126.f(r108);
        goto L62
    L57:
        r132 = 0;
        goto L58
    L50:
        r129 = 0.0d;
    L62:
        List<m.d> r134 = r100.h();
        ArrayList r135 = null;
        if (r134 == null) goto L68;
        List<m.d> r136 = r134;
        ArrayList r137 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r136, 10));
        Iterator<T> r138 = r136.iterator();
    L66:
        if (r138.hasNext() == false) goto L69;
        m.d r139 = (m.d) r138.next();
        LayoutConfigModel.e r140 = new LayoutConfigModel.e();
        r140.m(r139.g());
        r140.i(r139.c());
        r140.k(r139.e());
        r140.l(r139.f());
        r140.j(r139.d());
        r140.h(r139.b());
        r137.add(r140);
    L69:
        r102.x(r137);
        List<m.e> r141 = r100.k();
        if (r141 == null) goto L75;
        List<m.e> r142 = r141;
        r135 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r142, 10));
        Iterator<T> r143 = r142.iterator();
    L73:
        if (r143.hasNext() == false) goto L75;
        m.e r144 = (m.e) r143.next();
        LayoutConfigModel.f r145 = new LayoutConfigModel.f();
        r145.m(r144.g());
        r145.i(r144.c());
        r145.k(r144.e());
        r145.l(r144.f());
        r145.j(r144.d());
        r145.h(r144.b());
        r135.add(r145);
    L75:
        r102.A(r135);
        return b(r102, r110, r111);
    L68:
        r137 = null;
        goto L69
    L9:
        r106 = 8;
        goto L10
    L5:
        r104 = 1;
        goto L6
    }

    public static pn0.f b(LayoutConfigModel r210, Triple r211, Pair r212) {
        if (((Number) r211.getFirst()).intValue() != 0) goto L5;
    L6:
        ((Number) r211.getFirst()).intValue();
        ((Number) r211.getSecond()).intValue();
        Log.getStackTraceString(new Exception());
    L7:
        LayoutConfigModel.b r100 = r210.e();
        if (r100 != null) goto L10;
    L16:
        boolean r101 = false;
    L17:
        boolean r102 = Intrinsics.areEqual(vm2.e.k().get(String.valueOf(((Number) r212.getSecond()).intValue())), String.valueOf(((Number) r212.getFirst()).intValue()));
        if (r101 == false) goto L23;
        if (r102 == false) goto L23;
        if (vm2.d.P0() == false) goto L23;
        boolean r103 = true;
    L24:
        ln0.a r104 = f567472a;
        if (r104 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("newLayoutConfigManager");
    L27:
        Triple r105 = new Triple(Boolean.valueOf(r103), r212.getFirst(), r212.getSecond());
        if (r210.q() != 30) goto L30;
        boolean r106 = true;
    L31:
        mn0.a r110 = new mn0.a(r105, r106);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r211, "absContainerWHAndReason");
        Intrinsics.checkNotNullParameter(r210, "layoutConfig");
        Intrinsics.checkNotNullParameter(r110, "configParams");
        mn0.b r107 = new mn0.b(r211, r210.b(), r210.j(), r210.d(), (LayoutConfigModel.g) Preconditions.checkNotNull(r210.p()), (LayoutConfigModel.b) Preconditions.checkNotNull(r210.e()), (LayoutConfigModel.d) Preconditions.checkNotNull(r210.f()), (List) Preconditions.checkNotNull(r210.i()), r104.f509966b.f509971e, r110);
        Pair r108 = new Pair(r107.f514514a.getFirst(), r107.f514514a.getSecond());
        r107.f514522i.a("DefaultLayoutConfigCalculatorV2", "call calculate, adjustBase = " + r107.f514515b + ", scale = " + r107.f514516c + ", align = " + r107.f514517d + ", absContainerWHAndReason[" + r107.f514514a + ']', false);
        if (r107.f514515b != 0) goto L55;
        mn0.b.c r109 = r107.e(r107.c(r108), r107.f514518e);
        float r111 = r107.f514520g.c() / r107.f514520g.b();
        int r112 = r107.f514516c;
        if (r112 == 0) goto L41;
        if (r112 == 1) goto L40;
        if (r112 != 2) goto L39;
        mn0.b.d r113 = mn0.b.a(r109, r111);
    L42:
        mn0.b.C6834b r114 = r107.d(r113, r109);
        r107.f514522i.a("DefaultLayoutConfigCalculatorV2", "call calculateContent, \n传入参数：absContainerWHAndReason[" + ((Number) r108.getFirst()).intValue() + ", " + ((Number) r108.getSecond()).intValue() + ", " + r107.f514514a.getThird() + "], configParams=" + r107.f514523j + ", uiMarginParams[" + r107.f514518e.c() + ", " + r107.f514518e.e() + ", " + r107.f514518e.d() + ", " + r107.f514518e.b() + "], \n过程参数：virUIContainer = " + r109 + ", contentRadioWH = " + r111 + ", contentVirSize[" + r113.f514528a + ", " + r113.f514529b + "], \n结果参数：contentVirPosition = " + r114 + ", contentVirSize = " + r113, false);
        mn0.b.c r115 = new mn0.b.c(r114, r113);
        mn0.b.d r116 = r115.f514527b;
        int r117 = r116.f514528a;
        int r118 = r116.f514529b;
        mn0.b.C6834b r119 = r115.f514526a;
        int r120 = r119.f514524a;
        int r121 = r119.f514525b;
        float r122 = ((float) r107.f514520g.c()) / ((float) r107.f514519f.d());
        float r123 = (float) 0;
        if (r122 <= r123) goto L45;
        r117 = (int) (r115.f514527b.f514528a / r122);
    L45:
        float r124 = r107.f514520g.b() / r107.f514519f.c();
        if (r124 <= r123) goto L48;
        r118 = (int) (r115.f514527b.f514529b / r124);
    L48:
        float r125 = ((float) r107.f514520g.d()) / r107.f514519f.d();
        if (r125 <= r123) goto L51;
        r120 = r115.f514526a.f514524a - ((int) (r117 * r125));
    L51:
        String r126 = "DefaultLayoutConfigCalculatorV2";
        float r127 = ((float) r107.f514520g.e()) / r107.f514519f.c();
        if (r127 <= r123) goto L54;
        r121 = r115.f514526a.f514525b - ((int) (r118 * r127));
    L54:
        r107.f514522i.a(r126, "mapCanvasWithContent canvasResult[" + r120 + ", " + r121 + ", " + r117 + ", " + r118 + "], ratio[" + r125 + ", " + r127 + ", " + r122 + ", " + r124 + ']', false);
        mn0.b.c r128 = new mn0.b.c(new mn0.b.C6834b(r120, r121), new mn0.b.d(r117, r118));
    L79:
        mn0.b.C6834b r129 = r128.f514526a;
        int r130 = r129.f514524a;
        int r131 = r129.f514525b;
        mn0.b.d r132 = r128.f514527b;
        pn0.f.a r133 = new pn0.f.a(r130, r131, r132.f514528a, r132.f514529b);
        mn0.b.C6834b r134 = r115.f514526a;
        int r135 = r134.f514524a;
        int r136 = r134.f514525b;
        mn0.b.d r137 = r115.f514527b;
        pn0.f.b r138 = new pn0.f.b(r135, r136, r137.f514528a, r137.f514529b);
        List<LayoutConfigModel.e> r139 = r107.f514521h;
        ArrayList r140 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r139, 10));
        Iterator<T> r141 = r139.iterator();
    L81:
        if (r141.hasNext() == false) goto L111;
        LayoutConfigModel.e r142 = (LayoutConfigModel.e) r141.next();
        mn0.b.C6834b r143 = r115.f514526a;
        int r144 = r143.f514524a;
        if (r144 < 0) goto L86;
        r144 = 0;
    L86:
        int r145 = r143.f514525b;
        if (r145 < 0) goto L90;
        r145 = 0;
    L90:
        float r146 = ((float) r142.e()) / r107.f514520g.c();
        float r147 = 0;
        if (r146 <= r147) goto L93;
        r144 = r144 + ((int) (r146 * r115.f514527b.f514528a));
    L93:
        float r148 = ((float) r142.f()) / r107.f514520g.b();
        if (r148 <= r147) goto L96;
        r145 = r145 + ((int) (r148 * r115.f514527b.f514529b));
    L96:
        float r149 = ((float) r142.d()) / r107.f514520g.c();
        if (r149 <= r147) goto L102;
        int r150 = (int) (r149 * r115.f514527b.f514528a);
        if (r144 >= 0) goto L101;
        int r213 = r144 + r150;
        int r151 = 0;
    L103:
        float r152 = ((float) r142.b()) / r107.f514520g.b();
        if (r152 <= r147) goto L109;
        int r153 = (int) (r152 * r115.f514527b.f514529b);
        if (r145 >= 0) goto L108;
        int r214 = r145 + r153;
        int r215 = 0;
    L110:
        r140.add(new pn0.f.c(r142.c(), r142.g(), r151, r215, r213, r214));
        goto L81
    L108:
        r215 = r145;
        r214 = r153;
        goto L110
    L109:
        r215 = r145;
        r214 = 0;
        goto L110
    L101:
        r151 = r144;
        r213 = r150;
        goto L103
    L102:
        r151 = r144;
        r213 = 0;
        goto L103
    L111:
        r107.f514522i.a(r126, "call calculate, seatItemResultList = " + r140, false);
        pn0.f r154 = new pn0.f(r107.f514514a, r133, r138, r140);
        boolean r155 = r107.f514523j.f514512b.getFirst().booleanValue();
        int r156 = r107.f514523j.f514512b.getSecond().intValue();
        int r157 = r107.f514523j.f514512b.getThird().intValue();
        if (r155 == false) goto L125;
        if (r156 == 0) goto L125;
        if (r157 == 0) goto L125;
        float r158 = r156;
        float r159 = r157;
        if ((r158 / r159) == (r107.f514519f.d() / r107.f514519f.c())) goto L125;
        float r160 = (r159 / r158) / (r107.f514519f.c() / r107.f514519f.d());
        r107.f514522i.a(r126, "call adjustForLivePlayerVideoSize, videoSize[" + r156 + ", " + r157 + "], configCanvasSize[" + r107.f514519f.d() + ", " + r107.f514519f.c() + "], radio = " + r160, false);
        nn0.a r161 = r107.f514522i;
        StringBuilder r162 = new StringBuilder("modify before, result = ");
        r162.append(r154);
        r161.a(r126, r162.toString(), true);
        pn0.f.b r163 = r154.f529923c;
        r163.f529930b = (int) (((float) r163.f529930b) * r160);
        r163.f529932d = (int) (((float) r163.f529932d) * r160);
        pn0.f.a r164 = r154.f529922b;
        r164.f529926b = (int) (((float) r164.f529926b) * r160);
        r164.f529928d = (int) (((float) r164.f529928d) * r160);
        Iterator<T> r165 = r154.f529924d.iterator();
    L121:
        if (r165.hasNext() == false) goto L123;
        pn0.f.c r166 = (pn0.f.c) r165.next();
        r166.f529936d = (int) (r166.f529936d * r160);
        r166.f529938f = (int) (r166.f529938f * r160);
        goto L121
    L123:
        r107.f514522i.a(r126, "modify after, result = " + r154, true);
    L125:
        if (r107.f514523j.f514513c == true) goto L127;
        pn0.f r167 = r154;
    L136:
        int r168 = n.f75850a;
        int r169 = n.a(r210.q()) * 2;
        List<pn0.f.c> r170 = r167.f529924d;
        ArrayList r171 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r170, 10));
        Iterator<T> r172 = r170.iterator();
    L138:
        if (r172.hasNext() == false) goto L140;
        pn0.f.c r173 = (pn0.f.c) r172.next();
        r173.f529937e -= r169;
        r173.f529938f -= r169;
        r171.add(Unit.INSTANCE);
        goto L138
    L140:
        return r167;
    L127:
        int r174 = r154.f529923c.f529932d;
        int r175 = r107.e(r107.c(r108), r107.f514518e).f514527b.f514529b;
        float r176 = r175 / r174;
        r107.f514522i.a(r126, "adjustForScaleFitHeightFull, currentContentHeight=" + r174 + ", targetContentHeight=" + r175 + ", radio=" + r176, true);
        nn0.a r177 = r107.f514522i;
        StringBuilder r178 = new StringBuilder("modify before, result = ");
        r178.append(r154);
        r177.a(r126, r178.toString(), true);
        r154.f529923c.f529932d = r175;
        Iterator r179 = CollectionsKt.reversed(CollectionsKt.withIndex(r154.f529924d)).iterator();
    L129:
        if (r179.hasNext() == false) goto L135;
        IndexedValue r180 = (IndexedValue) r179.next();
        int r181 = r180.component1();
        pn0.f.c r182 = (pn0.f.c) r180.component2();
        float r183 = r182.f529937e;
        float r184 = r182.f529938f;
        float r185 = r182.f529935c;
        float r186 = r182.f529936d;
        if (r181 == 0) goto L134;
        int r187 = (int) (r183 * r176);
        int r188 = (int) (r184 * r176);
        int r189 = (int) (r185 - (r187 - r183));
        int r190 = (int) (r186 * r176);
        r182.f529937e = r187;
        r182.f529938f = r188;
        r182.f529935c = r189;
        r182.f529936d = r190;
        r107.f514522i.a(r126, "modify region#" + r181 + ", before [" + r185 + ", " + r186 + ", " + r183 + ", " + r184 + "], after [" + r189 + ", " + r190 + ", " + r187 + ", " + r188 + ']', true);
    L134:
        r179 = r179;
        r176 = r176;
        r154 = r154;
        goto L129
    L135:
        nn0.a r191 = r107.f514522i;
        StringBuilder r192 = new StringBuilder("modify after, result = ");
        r167 = r154;
        r192.append(r167);
        r191.a(r126, r192.toString(), true);
        goto L136
    L39:
        throw new Exception("invalid scale = " + r107.f514516c);
    L40:
        r113 = mn0.b.b(r109, r111);
        goto L42
    L41:
        mn0.b.d r193 = r109.f514527b;
        r113 = new mn0.b.d(r193.f514528a, r193.f514529b);
        goto L42
    L55:
        r126 = "DefaultLayoutConfigCalculatorV2";
        mn0.b.c r194 = r107.e(r107.c(r108), r107.f514518e);
        float r195 = r107.f514519f.d() / r107.f514519f.c();
        int r196 = r107.f514516c;
        if (r196 != 0) goto L58;
        mn0.b.d r197 = r194.f514527b;
        mn0.b.d r198 = new mn0.b.d(r197.f514528a, r197.f514529b);
    L66:
        mn0.b.c r199 = new mn0.b.c(r107.d(r198, r194), r198);
        mn0.b.d r200 = r199.f514527b;
        int r201 = r200.f514528a;
        int r202 = r200.f514529b;
        mn0.b.C6834b r203 = r199.f514526a;
        int r204 = r203.f514524a;
        int r205 = r203.f514525b;
        float r206 = r107.f514520g.c() / r107.f514519f.d();
        float r1100 = 0;
        if (r206 <= r1100) goto L69;
        r201 = (int) (r199.f514527b.f514528a * r206);
    L69:
        float r207 = r107.f514520g.b() / r107.f514519f.c();
        if (r207 <= r1100) goto L72;
        r202 = (int) (r199.f514527b.f514529b * r207);
    L72:
        float r208 = ((float) r107.f514520g.d()) / r107.f514519f.d();
        if (r208 <= r1100) goto L75;
        r204 = (int) (r199.f514527b.f514528a * r208);
    L75:
        float r209 = ((float) r107.f514520g.e()) / r107.f514519f.c();
        if (r209 <= r1100) goto L78;
        r205 = (int) (r199.f514527b.f514529b * r209);
    L78:
        mn0.b.c r216 = new mn0.b.c(new mn0.b.C6834b(r204, r205), new mn0.b.d(r201, r202));
        r128 = r199;
        r115 = r216;
        goto L79
    L58:
        if (r196 != 1) goto L60;
        r198 = mn0.b.b(r194, r195);
        goto L66
    L60:
        if (r196 != 2) goto L63;
        r198 = mn0.b.a(r194, r195);
        goto L66
    L63:
        throw new Exception("invalid scale = " + r107.f514516c);
    L30:
        r106 = false;
    L23:
        r103 = false;
        goto L24
    L10:
        if (r100.d() != 360) goto L16;
        LayoutConfigModel.b r217 = r210.e();
        if (r217 == null) goto L16;
        if (r217.c() != 640) goto L16;
        r101 = true;
        goto L17
    L5:
        if (((Number) r211.getSecond()).intValue() != 0) goto L7;
        goto L6
    }

    public static int h(boolean r100, int r101, int r102) {
        int r103 = c1.f78742a;
        if (c1.a(Integer.valueOf(r101), Integer.valueOf(r102)) == false) goto L10;
        if (r100 == false) goto L7;
    L9:
        return 1;
    L7:
        if (e5.n() == false) goto L9;
        return 2;
    L10:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v2 */
    public static void k(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r110, com.bytedance.android.live.liveinteract.plantform.commonwindow.g r111, List r112) {
        Intrinsics.checkNotNullParameter(r110, "request");
        Intrinsics.checkNotNullParameter(r111, "listener");
        if (r110.f75657h.getFirst().intValue() != 0) goto L5;
    L6:
        ALogger.e("LayoutConfigGeckoRes", "loadLayoutConfigV2: absContainerWH invalid, absContainerWH = [" + r110.f75657h.getFirst().intValue() + ", " + r110.f75657h.getSecond().intValue() + "], reason = " + r110.f75657h.getThird());
    L7:
        boolean r100 = hd0.c.f().h();
        List<Integer> r101 = r110.a();
        if (r112 == null) goto L10;
        f567473b = r112;
    L10:
        List<Integer> r102 = f567473b;
        if (r102 == null) goto L21;
        ?? r113 = new ArrayList();
        Iterator r103 = r102.iterator();
    L14:
        if (r103.hasNext() == false) goto L22;
        Object r114 = r103.next();
        if (((Number) r114).intValue() != 8) goto L18;
        boolean r115 = true;
    L19:
        if (r115 == false) goto L14;
        r113.add(r114);
        goto L14
    L18:
        r115 = false;
    L22:
        if (r101 == null) goto L32;
        ?? r104 = new ArrayList();
        Iterator r105 = r101.iterator();
    L25:
        if (r105.hasNext() == false) goto L33;
        Object r116 = r105.next();
        if (((Number) r116).intValue() == 8) goto L29;
        boolean r117 = true;
    L30:
        if (r117 == false) goto L25;
        r104.add(r116);
        goto L25
    L29:
        r117 = false;
    L33:
        List<Integer> r106 = CollectionsKt.sortedWith(CollectionsKt.plus((Collection) r113, (Iterable) r104), new e());
        ALogger.i("LayoutConfigGeckoRes", "loadLayoutConfigV2, serverUiFeatureList: " + r110.a() + ", seiUiFeatureList: " + r112 + ", mergeUiFeatureList: " + r106 + ", isOnline: " + r100);
        if (vm2.d.S0() == false) goto L37;
        if (r100 == true) goto L37;
    L38:
        if (r106 != null) goto L40;
        List<Integer> r107 = CollectionsKt.emptyList();
    L41:
        Boolean r108 = h30.f120339a.getValue();
        int r109 = r110.f75650a;
        if (r109 != 2) goto L46;
        pn0.d r118 = new pn0.c(r109, r110.f75654e, r110.f75651b, r110.f75653d, r110.f75655f, r110.f75656g, r108.booleanValue(), r107, r110.f75659j, r110.f75660k, 128);
    L44:
        pn0.d r119 = r118;
        long r120 = System.currentTimeMillis();
        ln0.a r121 = f567472a;
        if (r121 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("newLayoutConfigManager");
    L52:
        r121.a(r119, new d(r107, r110, r111, r120));
        return;
    L46:
        if ((r110 instanceof t) == false) goto L48;
        r118 = new pn0.d(r109, r110.f75651b, r110.f75653d, ((t) r110).f75872l, r110.f75655f, null, r108.booleanValue(), r107, r110.f75659j, r110.f75660k, 64);
        goto L44
    L48:
        r118 = new pn0.d(r109, r110.f75651b, r110.f75653d, null, r110.f75655f, null, r108.booleanValue(), r107, r110.f75659j, r110.f75660k, 64);
        goto L44
    L40:
        r107 = r106;
    L37:
        r106 = r110.a();
        goto L38
    L32:
        r104 = CollectionsKt.emptyList();
        goto L33
    L21:
        r113 = CollectionsKt.emptyList();
        goto L22
    L5:
        if (r110.f75657h.getSecond().intValue() != 0) goto L7;
        goto L6
    }

    public static void f(int r110, k r210, boolean r211, pn0.i r212, Triple r213, Pair r214, ClientUIInfo r215, Long r216, DataCenter r217) {
        Intrinsics.checkNotNullParameter(r210, "listener");
        Intrinsics.checkNotNullParameter(r213, "adjustWHAndReason");
        Intrinsics.checkNotNullParameter(r214, "livePlayerVideoSize");
        Boolean r100 = h30.f120339a.getValue();
        ln0.a r101 = f567472a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("newLayoutConfigManager");
    L5:
        boolean r111 = r100.booleanValue();
        if (r215 == null) goto L8;
        List<Integer> r102 = r215.getUiFeatureList();
    L9:
        r101.a(new pn0.c(2, r110, 0, r211, false, r212, r111, r102, r216, r217, 180), new a(r213, r214, r215, r210));
        return;
    L8:
        r102 = null;
        goto L9
    }

    public static /* synthetic */ void g(int r110, k r111, boolean r112, pn0.i r113, Triple r114, Pair r115, ClientUIInfo r116, DataCenter r117, int r118) {
        if ((r118 & 4) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r118 & 8) == 0) goto L9;
        pn0.i r101 = null;
    L11:
        if ((r118 & 64) == 0) goto L13;
        ClientUIInfo r102 = null;
    L14:
        f(r110, r111, r100, r101, r114, r115, r102, null, r117);
        return;
    L13:
        r102 = r116;
        goto L14
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
