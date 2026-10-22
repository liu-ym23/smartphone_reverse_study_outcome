package com.bytedance.ee.bear.office.list.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEventSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceItem;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceLongPressAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.office.list.menuconfig.OfficeLongPressMenuConfigComposer;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes18.dex */
public final class OfficeLongPressActionContextFactory {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f235675h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<String> f235676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Fragment> f235677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ce5.a f235678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<com.bytedance.ee.bear.more.office.e> f235679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f235680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.ee.bear.list.recent.i f235681f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f235682g;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a0 f235683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c0 f235684b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<b0> f235685c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<b0> f235686d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<com.bytedance.ee.bear.office.list.menuconfig.a> f235687e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f235683a, r101.f235683a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f235684b, r101.f235684b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f235685c, r101.f235685c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f235686d, r101.f235686d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f235687e, r101.f235687e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((this.f235683a.hashCode() * 31) + this.f235684b.hashCode()) * 31) + this.f235685c.hashCode()) * 31) + this.f235686d.hashCode()) * 31;
            List<com.bytedance.ee.bear.office.list.menuconfig.a> r101 = this.f235687e;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Result(menuContext=" + this.f235683a + ", menuRules=" + this.f235684b + ", mainSpecs=" + this.f235685c + ", moreSpecs=" + this.f235686d + ", configuredItems=" + this.f235687e + ')';
        }

        public b(a0 r100, c0 r101, List<b0> r102, List<b0> r103, List<com.bytedance.ee.bear.office.list.menuconfig.a> r104) {
            Intrinsics.checkNotNullParameter(r100, "menuContext");
            Intrinsics.checkNotNullParameter(r101, "menuRules");
            Intrinsics.checkNotNullParameter(r102, "mainSpecs");
            Intrinsics.checkNotNullParameter(r103, "moreSpecs");
            this.f235683a = r100;
            this.f235684b = r101;
            this.f235685c = r102;
            this.f235686d = r103;
            this.f235687e = r104;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f235688a = null;

        static {
            int[] r100 = new int[OfficeLongPressLarkAction.values().length];
            r100[OfficeLongPressLarkAction.MOVE_TO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[OfficeLongPressLarkAction.ADD_SHORTCUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[OfficeLongPressLarkAction.SECRET_SETTING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[OfficeLongPressLarkAction.DOWNLOAD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[OfficeLongPressLarkAction.EXPORT_AS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[OfficeLongPressLarkAction.RENAME.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[OfficeLongPressLarkAction.MAKE_COPY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f235688a = r100;
        }
    }

    static {
    }

    public static String c(oj5.c r100) {
        String r101 = null;
        if ((r100 instanceof oj5.a) == false) goto L5;
        oj5.a r102 = (oj5.a) r100;
    L6:
        if (r102 == null) goto L12;
        DocPermission r103 = r102.f523538i;
        if (r103 == null) goto L12;
        IDocUserPermission r104 = r103.f234419a;
        if (r104 == null) goto L12;
        r101 = r104.getClass().getSimpleName();
    L12:
        StringBuilder r105 = new StringBuilder("moreInfo=");
        r105.append(r100.getClass().getSimpleName());
        r105.append(", moreToken=");
        String r106 = r100.getToken();
        if (r106 != null) goto L15;
        r106 = "";
    L15:
        r105.append(du5.b.k(r106));
        r105.append(", moreType=");
        r105.append(r100.getType());
        r105.append(", realType=");
        r105.append(r100.i());
        r105.append(", isShortcut=");
        r105.append(r100.E());
        r105.append(", originDeleted=");
        r105.append(r100.w());
        r105.append(", userPerm=");
        r105.append(r101);
        return r105.toString();
    L5:
        r102 = null;
        goto L6
    }

    public static String d(z r100) {
        if (Intrinsics.areEqual(r100, z.d.f235884a) == false) goto L6;
        return "Visible";
    L6:
        if (Intrinsics.areEqual(r100, z.b.f235882a) == false) goto L9;
        return "Hidden";
    L9:
        if ((r100 instanceof z.c) == false) goto L12;
        return "Loading";
    L12:
        if ((r100 instanceof z.a) == false) goto L16;
        return "Disabled(reason=" + ((z.a) r100).f235881b + ')';
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public static String f(Document r100) {
        String r101 = r100.f227873d;
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        return du5.b.k(r101);
    }

    public static z g(com.bytedance.ee.bear.more.office.a r100) {
        if (Intrinsics.areEqual(r100, com.bytedance.ee.bear.more.office.a.d.f234686a) == false) goto L6;
        return z.d.f235884a;
    L6:
        if (Intrinsics.areEqual(r100, com.bytedance.ee.bear.more.office.a.b.f234684a) == false) goto L9;
        return z.b.f235882a;
    L9:
        if ((r100 instanceof com.bytedance.ee.bear.more.office.a.c) == false) goto L13;
        z r101 = new z.c(((com.bytedance.ee.bear.more.office.a.c) r100).f234685a);
    L19:
        return r101;
    L13:
        if ((r100 instanceof com.bytedance.ee.bear.more.office.a.C3363a) == false) goto L17;
        com.bytedance.ee.bear.more.office.a.C3363a r102 = (com.bytedance.ee.bear.more.office.a.C3363a) r100;
        r101 = new z.a(r102.f234682a, r102.f234683b);
        goto L19
    L17:
        throw new NoWhenBranchMatchedException();
    }

    public static OfficeLongPressMenuAction h(OfficeLongPressLarkAction r100) {
        switch(c.f235688a[r100.ordinal()]) {
            case 1: goto L13;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L14:
        return OfficeLongPressMenuAction.MAKE_COPY;
    L15:
        return OfficeLongPressMenuAction.RENAME;
    L16:
        return OfficeLongPressMenuAction.EXPORT_AS;
    L17:
        return OfficeLongPressMenuAction.DOWNLOAD;
    L18:
        return OfficeLongPressMenuAction.SECRET_SETTING;
    L19:
        return OfficeLongPressMenuAction.ADD_SHORTCUT;
    L13:
        return OfficeLongPressMenuAction.MOVE_TO;
    }

    public static final String a(oj5.c r100, Document r101, String r102) {
        return r102 + ':' + r100.getToken() + ':' + r100.getType() + ':' + r101.f227872c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeLongPressActionContextFactory(Function0<String> r100, Function0<? extends Fragment> r101, ce5.a r102, Function0<? extends com.bytedance.ee.bear.more.office.e> r103, f r104, com.bytedance.ee.bear.list.recent.i r105) {
        Intrinsics.checkNotNullParameter(r100, "moduleProvider");
        Intrinsics.checkNotNullParameter(r101, "ownerFragmentProvider");
        Intrinsics.checkNotNullParameter(r102, "userComponentAbility");
        Intrinsics.checkNotNullParameter(r103, "serviceProvider");
        Intrinsics.checkNotNullParameter(r105, "recentMenuHelper");
        this.f235676a = r100;
        this.f235677b = r101;
        this.f235678c = r102;
        this.f235679d = r103;
        this.f235680e = r104;
        this.f235681f = r105;
        this.f235682g = new Handler(Looper.getMainLooper());
    }

    public final z e(OfficeLongPressLarkAction r210, String r211, String r212, Document r213, boolean r214, OfficeSpaceEventSource r215, com.bytedance.ee.bear.more.office.e r216, FragmentActivity r217, Fragment r218, oj5.c r310, p r311) {
        if (r213.b() == false) goto L11;
        if (r210 != OfficeLongPressLarkAction.MOVE_TO) goto L7;
    L8:
        tt5.a.h("OfficeLongPressActionContextFactory", "resolve action availability. action=" + r210 + ", isAIArtifactFolder=true, result=Disabled");
        return new z.a(t0.d(), null);
    L7:
        if (r210 == OfficeLongPressLarkAction.RENAME) goto L8;
    L11:
        if (r210 != OfficeLongPressLarkAction.MOVE_TO) goto L16;
        if (r214 == false) goto L16;
        tt5.a.h("OfficeLongPressActionContextFactory", "resolve action availability. action=" + r210 + ", actionId=" + du5.b.k(r211) + ", result=Hidden, reason=restricted_wiki_home");
        return z.b.f235882a;
    L16:
        switch(c.f235688a[r210.ordinal()]) {
            case 1: goto L19;
            case 2: goto L19;
            case 3: goto L19;
            case 4: goto L19;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L19;
            default: goto L18;
        };
    L19:
        com.bytedance.ee.bear.more.office.c r100 = new com.bytedance.ee.bear.more.office.c(r211, r210, r212, r217, r218, r213, r310, this.f235676a.invoke(), r215.toString(), t0.u(r213, this.f235678c));
        if (r216 == null) goto L25;
        com.bytedance.ee.bear.more.office.a r101 = r216.c(r100, r311);
        if (r101 == null) goto L25;
        z r102 = g(r101);
        if (r102 == null) goto L25;
    L26:
        StringBuilder r103 = new StringBuilder("resolve action availability. action=");
        r103.append(r210);
        r103.append(", actionId=");
        r103.append(du5.b.k(r211));
        r103.append(", result=");
        r103.append(d(r102));
        r103.append(", reason=");
        if (r216 != null) goto L29;
        String r104 = "missing_service";
    L30:
        r103.append(r104);
        r103.append(", token=");
        r103.append(f(r213));
        r103.append(", ");
        r103.append(c(r310));
        tt5.a.h("OfficeLongPressActionContextFactory", r103.toString());
        return r102;
    L29:
        r104 = "executor_result";
    L25:
        r102 = new z.a(com.bytedance.ee.bear.more.office.f.c(), null);
        goto L26
    L18:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v2, types: [T, com.bytedance.ee.bear.office.list.adapter.v] */
    public final b b(Context r510, OfficeSpaceTab r511, Document r512, OfficeSpaceItem r513, OfficeSpaceEventSource r514, com.bytedance.ee.bear.office.export.space.h r515, boolean r516, boolean r517, Function0<Boolean> r518, boolean r519, DocPermission r610, x r611) {
        Intrinsics.checkNotNullParameter(r510, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r511, "tab");
        Intrinsics.checkNotNullParameter(r512, "document");
        Intrinsics.checkNotNullParameter(r513, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r514, "source");
        Intrinsics.checkNotNullParameter(r518, "isNetworkConnected");
        Fragment r100 = this.f235677b.invoke();
        int r101 = OfficeListSortFilterScene.f235658e;
        OfficeListSortFilterScene r102 = OfficeListSortFilterScene.a.c(r511, this.f235676a.invoke(), r100);
        if ((r515 instanceof com.bytedance.ee.bear.office.export.space.j) == false) goto L5;
        com.bytedance.ee.bear.office.export.space.j r110 = (com.bytedance.ee.bear.office.export.space.j) r515;
    L7:
        if (r102 != null) goto L9;
    L17:
        String r103 = null;
    L19:
        if (r512.getType() != sbb.e.f541295f.f541317b) goto L21;
        oj5.c r104 = t0.k(r512, r103);
    L22:
        oj5.c r105 = r104;
        if (r512.M1 != 0) goto L25;
    L31:
        boolean r106 = r105 instanceof oj5.b;
        if (r106 == false) goto L40;
        oj5.b r107 = (oj5.b) r105;
        if (r107.f523572q == false) goto L40;
        if (r512.f227902v2 == 0) goto L38;
        boolean r108 = true;
    L39:
        r107.f523573r = r108;
        goto L40
    L38:
        r108 = false;
    L40:
        if (r610 != null) goto L42;
    L44:
        if (r106 == false) goto L46;
        oj5.b r109 = (oj5.b) r105;
    L48:
        if (r109 != null) goto L50;
        boolean r111 = r106;
    L57:
        StringBuilder r112 = new StringBuilder("create long press context. token=");
        r112.append(f(r512));
        r112.append(", tab=");
        r112.append(r511);
        r112.append(", source=");
        r112.append(r514);
        r112.append(", type=");
        r112.append(r512.getType());
        r112.append(", realType=");
        r112.append(r512.f227908y1);
        r112.append(", nodeType=");
        r112.append(r512.M1);
        r112.append(", preloadedDocPermission=");
        if (r610 == null) goto L60;
        boolean r113 = true;
    L61:
        r112.append(r113);
        r112.append(", ");
        r112.append(c(r105));
        tt5.a.h("OfficeLongPressActionContextFactory", r112.toString());
        final Ref.ObjectRef r114 = new Ref.ObjectRef();
        final com.bytedance.ee.bear.more.office.e r115 = this.f235679d.invoke();
        final Function0<Unit> r116 = new OfficeLongPressActionContextFactory$create$actionSession$1(r114);
        String r117 = r512.f227873d + '_' + System.currentTimeMillis();
        OfficeLongPressLarkAction r118 = OfficeLongPressLarkAction.MOVE_TO;
        OfficeLongPressLarkAction r119 = OfficeLongPressLarkAction.ADD_SHORTCUT;
        OfficeLongPressLarkAction r120 = OfficeLongPressLarkAction.SECRET_SETTING;
        OfficeLongPressLarkAction r121 = OfficeLongPressLarkAction.DOWNLOAD;
        OfficeLongPressLarkAction r122 = OfficeLongPressLarkAction.EXPORT_AS;
        OfficeLongPressLarkAction r123 = OfficeLongPressLarkAction.RENAME;
        OfficeLongPressLarkAction r124 = OfficeLongPressLarkAction.MAKE_COPY;
        Map r125 = MapsKt.mapOf(new Pair[]{TuplesKt.to(r118, r117 + "_move_to"), TuplesKt.to(r119, r117 + "_add_shortcut"), TuplesKt.to(r120, r117 + "_secret_setting"), TuplesKt.to(r121, r117 + "_download"), TuplesKt.to(r122, r117 + "_export_as"), TuplesKt.to(r123, r117 + "_rename"), TuplesKt.to(r124, r117 + "_make_copy")});
        Map r126 = MapsKt.mapOf(new Pair[]{TuplesKt.to(r118, a(r105, r512, "move_to")), TuplesKt.to(r119, a(r105, r512, "add_shortcut")), TuplesKt.to(r120, a(r105, r512, "secret")), TuplesKt.to(r121, a(r105, r512, "download")), TuplesKt.to(r122, a(r105, r512, "export_as")), TuplesKt.to(r123, a(r105, r512, "rename")), TuplesKt.to(r124, a(r105, r512, "make_copy"))});
        if (r100 == null) goto L64;
        FragmentActivity r127 = r100.getActivity();
    L66:
        if ((r127 instanceof FragmentActivity) == false) goto L68;
        FragmentActivity r210 = r127;
    L69:
        if (r100 == null) goto L74;
        Fragment r128 = r100.getParentFragment();
        if (r128 == null) goto L74;
        Fragment r211 = r128;
    L75:
        final Ref.ObjectRef r129 = new Ref.ObjectRef();
        p r130 = new p(new OfficeLongPressActionContextFactory$buildLarkActionSession$callback$1(r129), this, r611);
        boolean r212 = t0.u(r512, this.f235678c);
        LinkedHashMap r131 = new LinkedHashMap();
        OfficeSpaceLongPressAction r310 = OfficeSpaceLongPressAction.ASK_DOUBAO;
        FragmentActivity r132 = r210;
        Fragment r133 = r211;
        r131.put(r118, e(r118, (String) MapsKt.getValue(r125, r118), (String) r126.get(r118), r512, r212, r514, r115, r132, r133, r105, r130));
        r131.put(r119, e(r119, (String) MapsKt.getValue(r125, r119), (String) r126.get(r119), r512, r212, r514, r115, r132, r133, r105, r130));
        r131.put(r120, e(r120, (String) MapsKt.getValue(r125, r120), (String) r126.get(r120), r512, r212, r514, r115, r132, r133, r105, r130));
        r131.put(r121, e(r121, (String) MapsKt.getValue(r125, r121), (String) r126.get(r121), r512, r212, r514, r115, r132, r133, r105, r130));
        r131.put(r122, e(r122, (String) MapsKt.getValue(r125, r122), (String) r126.get(r122), r512, r212, r514, r115, r132, r133, r105, r130));
        r131.put(r123, e(r123, (String) MapsKt.getValue(r125, r123), (String) r126.get(r123), r512, r212, r514, r115, r132, r133, r105, r130));
        r131.put(r124, e(r124, (String) MapsKt.getValue(r125, r124), (String) r126.get(r124), r512, r212, r514, r115, r132, r133, r105, r130));
        ?? r134 = new v(r117, r131, r126, r125, new OfficeLongPressActionContextFactory$buildLarkActionSession$2(r116, r115));
        r129.element = r134;
        if (r111 == false) goto L78;
        oj5.b r135 = (oj5.b) r105;
    L79:
        if (r135 != null) goto L82;
    L83:
        Document r136 = r512;
    L99:
        T r137 = 0;
        OfficeLongPressActionContextFactory r138 = this;
    L102:
        r114.element = r137;
        com.bytedance.ee.bear.office.list.adapter.b r139 = com.bytedance.ee.bear.office.list.adapter.b.f235722a;
        Integer r140 = Integer.valueOf(r136.f227908y1);
        if (r140.intValue() <= 0) goto L105;
        boolean r141 = true;
    L106:
        if (r141 == true) goto L109;
        r140 = null;
    L109:
        if (r140 == null) goto L111;
        int r142 = r140.intValue();
    L112:
        Integer r143 = Integer.valueOf(r142);
        r139.getClass();
        if (Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE) == false) goto L115;
        com.bytedance.ee.bear.office.list.adapter.a r144 = new com.bytedance.ee.bear.office.list.adapter.a(r143);
    L116:
        OfficeSpaceTab r145 = OfficeSpaceTab.RECENT;
        if (r511 != r145) goto L129;
        com.bytedance.ee.bear.list.recent.i r146 = r138.f235681f;
        r146.getClass();
        Intrinsics.checkNotNullParameter(r136, MapController.ITEM_LAYER_TAG);
        if (AppInfoUtils.f().booleanValue() == false) goto L125;
        if (r146.a(r136) == false) goto L123;
        int r147 = R.string.LarkCCM_Doubao_Drive_Delete_Button;
    L128:
        Integer r213 = Integer.valueOf(r147);
    L130:
        if (r511 == r145) goto L132;
    L135:
        boolean r214 = true;
    L136:
        a0 r148 = new a0(r513, r512, r105, r517, r144, r518, r514, r511, r519, r102, r213, r214, t0.u(r136, r138.f235678c), r134);
        c0 r149 = new c0(r510, r138.f235680e, r516);
        List<b0> r150 = r149.c(r148);
        ArrayList r151 = new ArrayList();
        Iterator r152 = ((ArrayList) r150).iterator();
    L138:
        if (r152.hasNext() == false) goto L145;
        Object r153 = r152.next();
        if (((b0) r153).f235727e == OfficeLongPressMenuItemState.HIDDEN) goto L142;
        boolean r154 = true;
    L143:
        if (r154 == false) goto L138;
        r151.add(r153);
        goto L138
    L142:
        r154 = false;
        goto L143
    L145:
        List<b0> r155 = r149.d(r148);
        ArrayList r156 = new ArrayList();
        Iterator r157 = ((ArrayList) r155).iterator();
    L147:
        if (r157.hasNext() == false) goto L154;
        Object r158 = r157.next();
        if (((b0) r158).f235727e == OfficeLongPressMenuItemState.HIDDEN) goto L151;
        boolean r159 = true;
    L152:
        if (r159 == false) goto L147;
        r156.add(r158);
        goto L147
    L151:
        r159 = false;
        goto L152
    L154:
        int r160 = OfficeLongPressMenuConfigComposer.f235925a;
        com.bytedance.ee.bear.widgets.menuconfig.c r161 = com.bytedance.ee.bear.widgets.menuconfig.c.f240244a;
        return new b(r148, r149, r151, r156, OfficeLongPressMenuConfigComposer.a(com.bytedance.ee.bear.widgets.menuconfig.c.f240245b, r151, r156));
    L132:
        if (r138.f235681f.a(r136) == true) goto L135;
        r214 = false;
        goto L136
    L123:
        r147 = R.string.LarkCCM_Doubao_Drive_Remove_Button;
        goto L128
    L125:
        if (r146.a(r136) == false) goto L127;
        r147 = R.string.Doc_Facade_Delete;
        goto L128
    L127:
        r147 = R.string.Doc_More_Remove;
        goto L128
    L129:
        r213 = null;
        goto L130
    L115:
        r144 = null;
        goto L116
    L111:
        r142 = r512.getType();
        goto L112
    L105:
        r141 = false;
        goto L106
    L82:
        if (r135.f523575t != null) goto L83;
        r136 = r512;
        int r162 = r136.L1;
        FolderVersion.Companion.getClass();
        if (r162 == 0) goto L99;
        if (FolderVersion.a.c(Integer.valueOf(r136.L1)) == false) goto L90;
        String r163 = r136.f227873d;
    L91:
        if (r163 != null) goto L93;
    L96:
        boolean r164 = true;
    L97:
        if (r164 == false) goto L101;
        tt5.a.k("OfficeLongPressActionContextFactory", "skip folder permission preload because request param is empty. token=" + f(r512));
        goto L99
    L101:
        r138 = this;
        r137 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().f(r163, new FolderVersion(r136.L1, r136.T, r136.P1), r136.f227889n).subscribe(new r(r138, r135, r512, r513, r100, r514, r515, r110, r115, r134, r611), new s(r138, r136));
        goto L102
    L93:
        if (r163.length() == 0) goto L96;
        r164 = false;
        goto L97
    L90:
        r163 = r136.f227888m;
        goto L91
    L78:
        r135 = null;
    L74:
        r211 = r100;
        goto L75
    L68:
        r210 = null;
        goto L69
    L64:
        r127 = null;
        goto L66
    L60:
        r113 = false;
        goto L61
    L50:
        r111 = r106;
        if (r109.f523575t != null) goto L57;
        int r165 = r512.L1;
        FolderVersion.Companion.getClass();
        if (r165 != 0) goto L57;
        r109.f523575t = new ShareFolderUserPermission(2, null, null, false, null, 30, null);
        tt5.a.h("OfficeLongPressActionContextFactory", "fill old personal folder permission. token=" + f(r512));
        goto L57
    L46:
        r109 = null;
        goto L48
    L42:
        if ((r105 instanceof oj5.a) == false) goto L44;
        Intrinsics.checkNotNullParameter(r610, "docPermission");
        ((oj5.a) r105).f523538i = r610;
        goto L44
    L25:
        if ((r105 instanceof oj5.a) == false) goto L31;
        oj5.a r166 = (oj5.a) r105;
        if (r512.f227902v2 == 0) goto L29;
        boolean r167 = true;
    L30:
        r166.f523546q = r167;
        goto L31
    L29:
        r167 = false;
        goto L30
    L21:
        r104 = t0.h(r512, r103, null);
        goto L22
    L9:
        if (r102.f235659a != OfficeListSortFilterScene.Kind.SUB_FOLDER) goto L11;
        boolean r168 = true;
    L12:
        if (r168 == false) goto L14;
        OfficeListSortFilterScene r169 = r102;
    L15:
        if (r169 == null) goto L17;
        r103 = r169.f235660b;
        goto L19
    L14:
        r169 = null;
        goto L15
    L11:
        r168 = false;
        goto L12
    L5:
        r110 = null;
        goto L7
    }
}
