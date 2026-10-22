package rv3;

import com.bytedance.applet.aibridge.navi.AbsOpenNavigationMapIDL;
import com.bytedance.applet.aibridge.navi.OpenNavigationMapMethod;
import com.bytedance.applet.aibridge.navi.picker.NavigationMapAppLauncher;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class r implements Function1 {
    public final /* synthetic */ long a;
    public final /* synthetic */ OpenNavigationMapMethod b;
    public final /* synthetic */ f3.h c;
    public final /* synthetic */ OpenNavigationMapMethod.c d;
    public final /* synthetic */ e3.d e;
    public final /* synthetic */ AbsOpenNavigationMapIDL.a f;
    public final /* synthetic */ List g;
    public final /* synthetic */ sv3.a h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ NavigationMapAppLauncher.RouteMode j;
    public final /* synthetic */ List k;
    public final /* synthetic */ NavigationMapAppLauncher.BaiduDrivingPreference l;
    public final /* synthetic */ NavigationMapAppLauncher.BaiduTransitStrategy m;

    public /* synthetic */ r(long r1, OpenNavigationMapMethod r3, f3.h r4, OpenNavigationMapMethod.c r5, e3.d r6, AbsOpenNavigationMapIDL.a r7, List r8, sv3.a r9, boolean r10, NavigationMapAppLauncher.RouteMode r11, List r12, NavigationMapAppLauncher.BaiduDrivingPreference r13, NavigationMapAppLauncher.BaiduTransitStrategy r14) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = r14;
    }

    public final Object invoke(Object r34) {
        long r14 = this.a;
        OpenNavigationMapMethod r1 = this.b;
        f3.h<AbsOpenNavigationMapIDL.b> r7 = this.c;
        OpenNavigationMapMethod.c r13 = this.d;
        e3.d r2 = this.e;
        AbsOpenNavigationMapIDL.a r3 = this.f;
        List<sv3.e> r4 = this.g;
        sv3.a r6 = this.h;
        boolean r5 = this.i;
        NavigationMapAppLauncher.RouteMode r8 = this.j;
        List<sv3.m> r10 = this.k;
        NavigationMapAppLauncher.BaiduDrivingPreference r11 = this.l;
        NavigationMapAppLauncher.BaiduTransitStrategy r12 = this.m;
        sv3.a r9 = (sv3.a) r34;
        Gson r16 = OpenNavigationMapMethod.b;
        if (OpenNavigationMapMethod.a.a(r14) == true) goto L5;
        r1.getClass();
        OpenNavigationMapMethod.c(r7, r13);
        return Unit.INSTANCE;
    L5:
        r1.getClass();
        int r17 = tv3.b.a;
        NavigationMapAppLauncher.AppType[] r0 = NavigationMapAppLauncher.AppType.values();
        ArrayList r15 = new ArrayList();
        int r18 = r0.length;
        int r19 = 0;
    L6:
        boolean r110 = true;
        if (r19 >= r18) goto L15;
        int r111 = r18;
        NavigationMapAppLauncher.AppType r112 = r0[r19];
        NavigationMapAppLauncher.AppType[] r20 = r0;
        if (r112 != NavigationMapAppLauncher.AppType.DOUBAO) goto L12;
        r110 = false;
    L12:
        if (r110 == false) goto L14;
        r15.add(r112);
    L14:
        r19 = r19 + 1;
        r18 = r111;
        r0 = r20;
        goto L6
    L15:
        ArrayList r21 = new ArrayList();
        Iterator r113 = r15.iterator();
    L17:
        if (r113.hasNext() == false) goto L25;
        Object r114 = r113.next();
        Iterator r115 = r113;
        if (((NavigationMapAppLauncher.AppType) r114) == NavigationMapAppLauncher.AppType.APPLE) goto L21;
        boolean r116 = true;
    L22:
        if (r116 == false) goto L24;
        r21.add(r114);
    L24:
        r113 = r115;
        goto L17
    L21:
        r116 = false;
        goto L22
    L25:
        ArrayList r117 = new ArrayList();
        Iterator r22 = r21.iterator();
    L27:
        if (r22.hasNext() == false) goto L31;
        Object r118 = r22.next();
        NavigationMapAppLauncher.a.getClass();
        if (NavigationMapAppLauncher.h((NavigationMapAppLauncher.AppType) r118) == false) goto L27;
        r117.add(r118);
        goto L27
    L31:
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
        Iterator r119 = r117.iterator();
    L33:
        if (r119.hasNext() == false) goto L35;
        r23.add(((NavigationMapAppLauncher.AppType) r119.next()).getKey());
        goto L33
    L35:
        d3.a0 r24 = r2.getContainerContext();
        if (r24 == null) goto L38;
        String r25 = r24.getAppletId();
    L39:
        String r26 = UUID.randomUUID().toString();
        if (r9 == null) goto L45;
        StringBuilder r120 = new StringBuilder();
        NavigationMapAppLauncher.BaiduDrivingPreference r30 = r11;
        NavigationMapAppLauncher.BaiduTransitStrategy r31 = r12;
        r120.append(r9.a);
        r120.append(',');
        r120.append(r9.b);
        String r121 = r120.toString();
        if (r121 == null) goto L46;
        String r27 = r121;
    L47:
        StringBuilder r122 = new StringBuilder();
        r122.append(r6.a);
        r122.append(',');
        r122.append(r6.b);
        String r28 = r122.toString();
        String r123 = r3.getType();
        if (r123 != null) goto L50;
        String r29 = "";
    L51:
        if (r5 == false) goto L53;
        String r124 = "pop";
    L54:
        String r210 = r124;
        if (r25 != null) goto L57;
    L60:
        boolean r125 = true;
    L61:
        if (r125 == false) goto L64;
        r25 = null;
    L64:
        if (r25 != null) goto L66;
        r25 = "doubao";
    L66:
        String r211 = r25;
        String r32 = r3.getBackupApp();
        if (r32 != null) goto L69;
        String r212 = "";
    L70:
        int r33 = tv3.b.a;
        if (r4 == null) goto L87;
        ArrayList r126 = new ArrayList();
        Iterator<T> r35 = r4.iterator();
    L74:
        if (r35.hasNext() == false) goto L86;
        String r127 = ((sv3.e) r35.next()).a();
        if (r127 != null) goto L78;
    L83:
        r127 = null;
    L84:
        if (r127 == null) goto L74;
        r126.add(r127);
        goto L74
    L78:
        if (r127.length() <= 0) goto L80;
        boolean r128 = true;
    L81:
        if (r128 == false) goto L83;
    L80:
        r128 = false;
        goto L81
    L86:
        List r213 = r126;
    L88:
        int r36 = tv3.b.a;
        Intrinsics.checkNotNullParameter(r23, "installed");
        tv3.d r129 = new tv3.d(r26, r27, r28, r29, r210, r211, r212, r213, r23, r23);
        if (r5 == false) goto L92;
        r1.f(r3, r4, r8, r9, r6, r7, r129, null, r10, r30, r31, r13, r14);
    L124:
        return Unit.INSTANCE;
    L92:
        if (OpenNavigationMapMethod.a.a(r14) == true) goto L94;
        OpenNavigationMapMethod.c(r7, r13);
        goto L124
    L94:
        NavigationMapAppLauncher.AppType.a r37 = NavigationMapAppLauncher.AppType.Companion;
        String r38 = r3.getAppName();
        r37.getClass();
        NavigationMapAppLauncher.AppType r39 = NavigationMapAppLauncher.AppType.a.a(r38);
        if (r39 != null) goto L97;
        int r40 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.b("jsb_open_nav_map", "invalid appName: " + r3.getAppName());
        r13.a();
        f3.h.a.a(r7, "invalid_app_name", null, null, 14);
        goto L124
    L97:
        NavigationMapAppLauncher.a.getClass();
        if (NavigationMapAppLauncher.j(r39, r8) == true) goto L101;
        int r41 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.b("jsb_open_nav_map", "app does not support mode: " + r39 + ", mode=" + r8);
        r13.a();
        f3.h.a.a(r7, "app_mode_not_support", null, null, 14);
        goto L124
    L101:
        if (NavigationMapAppLauncher.g(r39) != NavigationMapAppLauncher.InstallState.NEED_INSTALL) goto L103;
        int r42 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("jsb_open_nav_map", "direct-launch hit NEED_INSTALL for " + r39 + ", falling back to dialog flow");
        r1.f(r3, r4, r8, r9, r6, r7, r129, r39.getKey(), r10, r30, r31, r13, r14);
        goto L124
    L103:
        int r43 = tv3.a.a;
        String r44 = r39.getKey();
        Intrinsics.checkNotNullParameter(r44, "selectionKey");
        if (Intrinsics.areEqual(r44, NavigationMapAppLauncher.AppType.DOUBAO.getKey()) == false) goto L106;
        r44 = "db_1GFLTGc";
    L106:
        tv3.a.c(r129, false, new tv3.c.b(r44));
        boolean r214 = !Intrinsics.areEqual(r3.getStartNaviDirectly(), Boolean.FALSE);
        String r215 = r39.getKey();
        String r216 = r3.getRouteMode();
        String r217 = r3.getDPoiId();
        String r218 = r3.getDPoiIdType();
        String r45 = r129.a;
        yv3.b r46 = r3.getTraceContext();
        if (r46 == null) goto L113;
        String r47 = r46.b();
        if (r47 == null) goto L113;
        if (StringsKt.isBlank(r47) == true) goto L113;
        String r219 = r47;
    L114:
        yv3.b r48 = r3.getTraceContext();
        if (r48 == null) goto L121;
        String r49 = r48.d();
        if (r49 == null) goto L121;
        if (StringsKt.isBlank(r49) == true) goto L121;
        String r220 = r49;
    L122:
        OpenNavigationMapMethod.e(r39, new OpenNavigationMapMethod.b(r8, r9, r6, r214, r215, r216, r217, r218, r45, r219, r220, r10, true, r30, r31), r7, r13, null);
    L121:
        r220 = null;
    L113:
        r219 = null;
        goto L114
    L87:
        r213 = CollectionsKt.emptyList();
        goto L88
    L69:
        r212 = r32;
        goto L70
    L57:
        if (r25.length() == 0) goto L60;
        r125 = false;
        goto L61
    L53:
        r124 = "direct";
        goto L54
    L50:
        r29 = r123;
    L46:
        r27 = "";
        goto L47
    L45:
        r30 = r11;
        r31 = r12;
        goto L46
    L38:
        r25 = null;
        goto L39
    }
}
