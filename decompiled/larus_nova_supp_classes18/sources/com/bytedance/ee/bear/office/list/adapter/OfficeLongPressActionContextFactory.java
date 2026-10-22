package com.bytedance.ee.bear.office.list.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
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
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.util.info.AppInfoUtils;
import io.reactivex.disposables.Disposable;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeLongPressActionContextFactory {
    public static final /* synthetic */ int h = 0;
    public final Function0<String> a;
    public final Function0<Fragment> b;
    public final ce5.a c;
    public final Function0<com.bytedance.ee.bear.more.office.e> d;
    public final f e;
    public final com.bytedance.ee.bear.list.recent.i f;
    public final Handler g;

    public static final class a {
    }

    public static final class b {
        public final a0 a;
        public final c0 b;
        public final List<b0> c;
        public final List<b0> d;
        public final List<com.bytedance.ee.bear.office.list.menuconfig.a> e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            List<com.bytedance.ee.bear.office.list.menuconfig.a> r1 = this.e;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "Result(menuContext=" + this.a + ", menuRules=" + this.b + ", mainSpecs=" + this.c + ", moreSpecs=" + this.d + ", configuredItems=" + this.e + ')';
        }

        public b(a0 r2, c0 r3, List<b0> r4, List<b0> r5, List<com.bytedance.ee.bear.office.list.menuconfig.a> r6) {
            Intrinsics.checkNotNullParameter(r2, "menuContext");
            Intrinsics.checkNotNullParameter(r3, "menuRules");
            Intrinsics.checkNotNullParameter(r4, "mainSpecs");
            Intrinsics.checkNotNullParameter(r5, "moreSpecs");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeLongPressLarkAction.values().length];
            r0[OfficeLongPressLarkAction.MOVE_TO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[OfficeLongPressLarkAction.ADD_SHORTCUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[OfficeLongPressLarkAction.SECRET_SETTING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[OfficeLongPressLarkAction.DOWNLOAD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[OfficeLongPressLarkAction.EXPORT_AS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[OfficeLongPressLarkAction.RENAME.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[OfficeLongPressLarkAction.MAKE_COPY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    static {
    }

    public static String c(oj5.c r3) {
        String r1 = null;
        if ((r3 instanceof oj5.a) == false) goto L5;
        oj5.a r0 = (oj5.a) r3;
    L6:
        if (r0 == null) goto L12;
        DocPermission r2 = r0.i;
        if (r2 == null) goto L12;
        IDocUserPermission r4 = r2.a;
        if (r4 == null) goto L12;
        r1 = r4.getClass().getSimpleName();
    L12:
        StringBuilder r5 = new StringBuilder("moreInfo=");
        r5.append(r3.getClass().getSimpleName());
        r5.append(", moreToken=");
        String r6 = r3.getToken();
        if (r6 != null) goto L15;
        r6 = "";
    L15:
        r5.append(du5.b.k(r6));
        r5.append(", moreType=");
        r5.append(r3.getType());
        r5.append(", realType=");
        r5.append(r3.i());
        r5.append(", isShortcut=");
        r5.append(r3.E());
        r5.append(", originDeleted=");
        r5.append(r3.w());
        r5.append(", userPerm=");
        r5.append(r1);
        return r5.toString();
    L5:
        r0 = null;
        goto L6
    }

    public static String d(z r2) {
        if (Intrinsics.areEqual(r2, z.d.a) == false) goto L6;
        return "Visible";
    L6:
        if (Intrinsics.areEqual(r2, z.b.a) == false) goto L9;
        return "Hidden";
    L9:
        if ((r2 instanceof z.c) == false) goto L12;
        return "Loading";
    L12:
        if ((r2 instanceof z.a) == false) goto L16;
        return "Disabled(reason=" + ((z.a) r2).b + ')';
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public static String f(Document r0) {
        String r1 = r0.d;
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        return du5.b.k(r1);
    }

    public static z g(com.bytedance.ee.bear.more.office.a r2) {
        if (Intrinsics.areEqual(r2, com.bytedance.ee.bear.more.office.a.d.a) == false) goto L6;
        return z.d.a;
    L6:
        if (Intrinsics.areEqual(r2, com.bytedance.ee.bear.more.office.a.b.a) == false) goto L9;
        return z.b.a;
    L9:
        if ((r2 instanceof com.bytedance.ee.bear.more.office.a.c) == false) goto L13;
        z r0 = new z.c(((com.bytedance.ee.bear.more.office.a.c) r2).a);
    L19:
        return r0;
    L13:
        if ((r2 instanceof com.bytedance.ee.bear.more.office.a.C0116a) == false) goto L17;
        com.bytedance.ee.bear.more.office.a.C0116a r3 = (com.bytedance.ee.bear.more.office.a.C0116a) r2;
        r0 = new z.a(r3.a, r3.b);
        goto L19
    L17:
        throw new NoWhenBranchMatchedException();
    }

    public static OfficeLongPressMenuAction h(OfficeLongPressLarkAction r1) {
        switch(c.a[r1.ordinal()]) {
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

    public static final String a(oj5.c r2, Document r3, String r4) {
        return r4 + ':' + r2.getToken() + ':' + r2.getType() + ':' + r3.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeLongPressActionContextFactory(Function0<String> r2, Function0<? extends Fragment> r3, ce5.a r4, Function0<? extends com.bytedance.ee.bear.more.office.e> r5, f r6, com.bytedance.ee.bear.list.recent.i r7) {
        Intrinsics.checkNotNullParameter(r2, "moduleProvider");
        Intrinsics.checkNotNullParameter(r3, "ownerFragmentProvider");
        Intrinsics.checkNotNullParameter(r4, "userComponentAbility");
        Intrinsics.checkNotNullParameter(r5, "serviceProvider");
        Intrinsics.checkNotNullParameter(r7, "recentMenuHelper");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = new Handler(Looper.getMainLooper());
    }

    public final z e(OfficeLongPressLarkAction r21, String r22, String r23, Document r24, boolean r25, OfficeSpaceEventSource r26, com.bytedance.ee.bear.more.office.e r27, FragmentActivity r28, Fragment r29, oj5.c r30, p r31) {
        if (r24.b() == false) goto L11;
        if (r21 != OfficeLongPressLarkAction.MOVE_TO) goto L7;
    L8:
        tt5.a.h("OfficeLongPressActionContextFactory", "resolve action availability. action=" + r21 + ", isAIArtifactFolder=true, result=Disabled");
        return new z.a(t0.d(), null);
    L7:
        if (r21 == OfficeLongPressLarkAction.RENAME) goto L8;
    L11:
        if (r21 != OfficeLongPressLarkAction.MOVE_TO) goto L16;
        if (r25 == false) goto L16;
        tt5.a.h("OfficeLongPressActionContextFactory", "resolve action availability. action=" + r21 + ", actionId=" + du5.b.k(r22) + ", result=Hidden, reason=restricted_wiki_home");
        return z.b.a;
    L16:
        switch(c.a[r21.ordinal()]) {
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
        com.bytedance.ee.bear.more.office.c r9 = new com.bytedance.ee.bear.more.office.c(r22, r21, r23, r28, r29, r24, r30, (String) this.a.invoke(), r26.toString(), t0.u(r24, this.c));
        if (r27 == null) goto L25;
        com.bytedance.ee.bear.more.office.a r1 = r27.c(r9, r31);
        if (r1 == null) goto L25;
        z r2 = g(r1);
        if (r2 == null) goto L25;
    L26:
        StringBuilder r3 = new StringBuilder("resolve action availability. action=");
        r3.append(r21);
        r3.append(", actionId=");
        r3.append(du5.b.k(r22));
        r3.append(", result=");
        r3.append(d(r2));
        r3.append(", reason=");
        if (r27 != null) goto L29;
        String r0 = "missing_service";
    L30:
        r3.append(r0);
        r3.append(", token=");
        r3.append(f(r24));
        r3.append(", ");
        r3.append(c(r30));
        tt5.a.h("OfficeLongPressActionContextFactory", r3.toString());
        return r2;
    L29:
        r0 = "executor_result";
    L25:
        r2 = new z.a(com.bytedance.ee.bear.more.office.f.c(), null);
        goto L26
    L18:
        throw new NoWhenBranchMatchedException();
    }

    public final b b(Context r50, OfficeSpaceTab r51, Document r52, OfficeSpaceItem r53, OfficeSpaceEventSource r54, com.bytedance.ee.bear.office.export.space.h r55, boolean r56, boolean r57, Function0<Boolean> r58, boolean r59, DocPermission r60, x r61) {
        Intrinsics.checkNotNullParameter(r50, "context");
        Intrinsics.checkNotNullParameter(r51, "tab");
        Intrinsics.checkNotNullParameter(r52, "document");
        Intrinsics.checkNotNullParameter(r53, "item");
        Intrinsics.checkNotNullParameter(r54, "source");
        Intrinsics.checkNotNullParameter(r58, "isNetworkConnected");
        Fragment r6 = (Fragment) this.b.invoke();
        int r1 = OfficeListSortFilterScene.e;
        OfficeListSortFilterScene r5 = OfficeListSortFilterScene.a.c(r51, (String) this.a.invoke(), r6);
        if ((r55 instanceof com.bytedance.ee.bear.office.export.space.j) == false) goto L5;
        com.bytedance.ee.bear.office.export.space.j r16 = (com.bytedance.ee.bear.office.export.space.j) r55;
    L7:
        if (r5 != null) goto L9;
    L17:
        String r2 = null;
    L19:
        if (r52.getType() != sbb.e.f.b) goto L21;
        oj5.c r3 = t0.k(r52, r2);
    L22:
        oj5.c r4 = r3;
        if (r52.M1 != 0) goto L25;
    L31:
        boolean r7 = r4 instanceof oj5.b;
        if (r7 == false) goto L40;
        oj5.b r8 = (oj5.b) r4;
        if (r8.q == false) goto L40;
        if (r52.v2 == 0) goto L38;
        boolean r9 = true;
    L39:
        r8.r = r9;
        goto L40
    L38:
        r9 = false;
    L40:
        if (r60 != null) goto L42;
    L44:
        if (r7 == false) goto L46;
        oj5.b r10 = (oj5.b) r4;
    L48:
        if (r10 != null) goto L50;
        boolean r18 = r7;
    L57:
        StringBuilder r11 = new StringBuilder("create long press context. token=");
        r11.append(f(r52));
        r11.append(", tab=");
        r11.append(r51);
        r11.append(", source=");
        r11.append(r54);
        r11.append(", type=");
        r11.append(r52.getType());
        r11.append(", realType=");
        r11.append(r52.y1);
        r11.append(", nodeType=");
        r11.append(r52.M1);
        r11.append(", preloadedDocPermission=");
        if (r60 == null) goto L60;
        boolean r0 = true;
    L61:
        r11.append(r0);
        r11.append(", ");
        r11.append(c(r4));
        tt5.a.h("OfficeLongPressActionContextFactory", r11.toString());
        final Ref.ObjectRef r12 = new Ref.ObjectRef();
        final com.bytedance.ee.bear.more.office.e r13 = (com.bytedance.ee.bear.more.office.e) this.d.invoke();
        final Function0<Unit> r14 = new OfficeLongPressActionContextFactory$create$actionSession$1(r12);
        String r15 = r52.d + '_' + System.currentTimeMillis();
        OfficeLongPressLarkAction r17 = OfficeLongPressLarkAction.MOVE_TO;
        OfficeLongPressLarkAction r19 = OfficeLongPressLarkAction.ADD_SHORTCUT;
        OfficeLongPressLarkAction r20 = OfficeLongPressLarkAction.SECRET_SETTING;
        OfficeLongPressLarkAction r21 = OfficeLongPressLarkAction.DOWNLOAD;
        OfficeLongPressLarkAction r22 = OfficeLongPressLarkAction.EXPORT_AS;
        OfficeLongPressLarkAction r23 = OfficeLongPressLarkAction.RENAME;
        OfficeLongPressLarkAction r110 = OfficeLongPressLarkAction.MAKE_COPY;
        Map r24 = MapsKt.mapOf(new Pair[]{TuplesKt.to(r17, r15 + "_move_to"), TuplesKt.to(r19, r15 + "_add_shortcut"), TuplesKt.to(r20, r15 + "_secret_setting"), TuplesKt.to(r21, r15 + "_download"), TuplesKt.to(r22, r15 + "_export_as"), TuplesKt.to(r23, r15 + "_rename"), TuplesKt.to(r110, r15 + "_make_copy")});
        Map r111 = MapsKt.mapOf(new Pair[]{TuplesKt.to(r17, a(r4, r52, "move_to")), TuplesKt.to(r19, a(r4, r52, "add_shortcut")), TuplesKt.to(r20, a(r4, r52, "secret")), TuplesKt.to(r21, a(r4, r52, OperationName.OPERATION_DOWNLOAD)), TuplesKt.to(r22, a(r4, r52, "export_as")), TuplesKt.to(r23, a(r4, r52, "rename")), TuplesKt.to(r110, a(r4, r52, "make_copy"))});
        if (r6 == null) goto L64;
        FragmentActivity r25 = r6.getActivity();
    L66:
        if ((r25 instanceof FragmentActivity) == false) goto L68;
        FragmentActivity r26 = r25;
    L69:
        if (r6 == null) goto L74;
        Fragment r27 = r6.getParentFragment();
        if (r27 == null) goto L74;
        Fragment r28 = r27;
    L75:
        final Ref.ObjectRef r29 = new Ref.ObjectRef();
        p r112 = new p(new OfficeLongPressActionContextFactory$buildLarkActionSession$callback$1(r29), this, r61);
        boolean r210 = t0.u(r52, this.c);
        LinkedHashMap r30 = new LinkedHashMap();
        OfficeSpaceLongPressAction r32 = OfficeSpaceLongPressAction.ASK_DOUBAO;
        FragmentActivity r31 = r26;
        Fragment r33 = r28;
        r30.put(r17, e(r17, (String) MapsKt.getValue(r24, r17), (String) r111.get(r17), r52, r210, r54, r13, r31, r33, r4, r112));
        r30.put(r19, e(r19, (String) MapsKt.getValue(r24, r19), (String) r111.get(r19), r52, r210, r54, r13, r31, r33, r4, r112));
        r30.put(r20, e(r20, (String) MapsKt.getValue(r24, r20), (String) r111.get(r20), r52, r210, r54, r13, r31, r33, r4, r112));
        r30.put(r21, e(r21, (String) MapsKt.getValue(r24, r21), (String) r111.get(r21), r52, r210, r54, r13, r31, r33, r4, r112));
        r30.put(r22, e(r22, (String) MapsKt.getValue(r24, r22), (String) r111.get(r22), r52, r210, r54, r13, r31, r33, r4, r112));
        r30.put(r23, e(r23, (String) MapsKt.getValue(r24, r23), (String) r111.get(r23), r52, r210, r54, r13, r31, r33, r4, r112));
        r30.put(r110, e(r110, (String) MapsKt.getValue(r24, r110), (String) r111.get(r110), r52, r210, r54, r13, r31, r33, r4, r112));
        v r113 = new v(r15, r30, r111, r24, new OfficeLongPressActionContextFactory$buildLarkActionSession$2(r14, r13));
        r29.element = r113;
        if (r18 == false) goto L78;
        oj5.b r34 = (oj5.b) r4;
    L79:
        if (r34 != null) goto L82;
    L83:
        Document r114 = r52;
    L99:
        Disposable r35 = null;
        OfficeLongPressActionContextFactory r36 = this;
    L102:
        r12.element = r35;
        com.bytedance.ee.bear.office.list.adapter.b r37 = com.bytedance.ee.bear.office.list.adapter.b.a;
        Integer r38 = Integer.valueOf(r114.y1);
        if (r38.intValue() <= 0) goto L105;
        boolean r39 = true;
    L106:
        if (r39 == true) goto L109;
        r38 = null;
    L109:
        if (r38 == null) goto L111;
        int r40 = r38.intValue();
    L112:
        Integer r41 = Integer.valueOf(r40);
        r37.getClass();
        if (Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE) == false) goto L115;
        com.bytedance.ee.bear.office.list.adapter.a r115 = new com.bytedance.ee.bear.office.list.adapter.a(r41);
    L116:
        OfficeSpaceTab r42 = OfficeSpaceTab.RECENT;
        if (r51 != r42) goto L129;
        com.bytedance.ee.bear.list.recent.i r43 = r36.f;
        r43.getClass();
        Intrinsics.checkNotNullParameter(r114, "item");
        if (AppInfoUtils.f().booleanValue() == false) goto L125;
        if (r43.a(r114) == false) goto L123;
        int r44 = 2131889421;
    L128:
        Integer r211 = Integer.valueOf(r44);
    L130:
        if (r51 == r42) goto L132;
    L135:
        boolean r212 = true;
    L136:
        a0 r45 = new a0(r53, r52, r4, r57, r115, r58, r54, r51, r59, r5, r211, r212, t0.u(r114, r36.c), r113);
        c0 r46 = new c0(r50, r36.e, r56);
        List<b0> r47 = r46.c(r45);
        ArrayList r48 = new ArrayList();
        Iterator r49 = ((ArrayList) r47).iterator();
    L138:
        if (r49.hasNext() == false) goto L145;
        Object r62 = r49.next();
        if (((b0) r62).e == OfficeLongPressMenuItemState.HIDDEN) goto L142;
        boolean r63 = true;
    L143:
        if (r63 == false) goto L138;
        r48.add(r62);
        goto L138
    L142:
        r63 = false;
        goto L143
    L145:
        List<b0> r64 = r46.d(r45);
        ArrayList r65 = new ArrayList();
        Iterator r66 = ((ArrayList) r64).iterator();
    L147:
        if (r66.hasNext() == false) goto L154;
        Object r67 = r66.next();
        if (((b0) r67).e == OfficeLongPressMenuItemState.HIDDEN) goto L151;
        boolean r68 = true;
    L152:
        if (r68 == false) goto L147;
        r65.add(r67);
        goto L147
    L151:
        r68 = false;
        goto L152
    L154:
        int r69 = OfficeLongPressMenuConfigComposer.a;
        com.bytedance.ee.bear.widgets.menuconfig.c r70 = com.bytedance.ee.bear.widgets.menuconfig.c.a;
        return new b(r45, r46, r48, r65, OfficeLongPressMenuConfigComposer.a(com.bytedance.ee.bear.widgets.menuconfig.c.b, r48, r65));
    L132:
        if (r36.f.a(r114) == true) goto L135;
        r212 = false;
        goto L136
    L123:
        r44 = 2131889446;
        goto L128
    L125:
        if (r43.a(r114) == false) goto L127;
        r44 = 2131887736;
        goto L128
    L127:
        r44 = 2131888026;
        goto L128
    L129:
        r211 = null;
        goto L130
    L115:
        r115 = null;
        goto L116
    L111:
        r40 = r52.getType();
        goto L112
    L105:
        r39 = false;
        goto L106
    L82:
        if (r34.t != null) goto L83;
        r114 = r52;
        int r71 = r114.L1;
        FolderVersion.Companion.getClass();
        if (r71 == 0) goto L99;
        if (FolderVersion.a.c(Integer.valueOf(r114.L1)) == false) goto L90;
        String r72 = r114.d;
    L91:
        if (r72 != null) goto L93;
    L96:
        boolean r73 = true;
    L97:
        if (r73 == false) goto L101;
        tt5.a.k("OfficeLongPressActionContextFactory", "skip folder permission preload because request param is empty. token=" + f(r52));
        goto L99
    L101:
        r36 = this;
        r35 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().f(r72, new FolderVersion(r114.L1, r114.T, r114.P1), r114.n).subscribe(new r(r36, r34, r52, r53, r6, r54, r55, r16, r13, r113, r61), new s(r36, r114));
        goto L102
    L93:
        if (r72.length() == 0) goto L96;
        r73 = false;
        goto L97
    L90:
        r72 = r114.m;
        goto L91
    L78:
        r34 = null;
    L74:
        r28 = r6;
        goto L75
    L68:
        r26 = null;
        goto L69
    L64:
        r25 = null;
        goto L66
    L60:
        r0 = false;
        goto L61
    L50:
        r18 = r7;
        if (r10.t != null) goto L57;
        int r74 = r52.L1;
        FolderVersion.Companion.getClass();
        if (r74 != 0) goto L57;
        r10.t = new ShareFolderUserPermission(2, null, null, false, null, 30, null);
        tt5.a.h("OfficeLongPressActionContextFactory", "fill old personal folder permission. token=" + f(r52));
        goto L57
    L46:
        r10 = null;
        goto L48
    L42:
        if ((r4 instanceof oj5.a) == false) goto L44;
        Intrinsics.checkNotNullParameter(r60, "docPermission");
        ((oj5.a) r4).i = r60;
        goto L44
    L25:
        if ((r4 instanceof oj5.a) == false) goto L31;
        oj5.a r75 = (oj5.a) r4;
        if (r52.v2 == 0) goto L29;
        boolean r76 = true;
    L30:
        r75.q = r76;
        goto L31
    L29:
        r76 = false;
        goto L30
    L21:
        r3 = t0.h(r52, r2, null);
        goto L22
    L9:
        if (r5.a != OfficeListSortFilterScene.Kind.SUB_FOLDER) goto L11;
        boolean r77 = true;
    L12:
        if (r77 == false) goto L14;
        OfficeListSortFilterScene r78 = r5;
    L15:
        if (r78 == null) goto L17;
        r2 = r78.b;
        goto L19
    L14:
        r78 = null;
        goto L15
    L11:
        r77 = false;
        goto L12
    L5:
        r16 = null;
        goto L7
    }
}
