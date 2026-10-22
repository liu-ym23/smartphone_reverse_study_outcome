package com.bytedance.ee.bear.list.more.more3;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.ObjBizType;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static BearUrl b(Document r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        BearUrl r1 = s45.p.a().Z(r9.p);
        Intrinsics.checkNotNullParameter(r9, "<this>");
        boolean r2 = true;
        if (NodeType.isShortcut(r9.M1) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        String r4 = null;
        if (r0 == true) goto L11;
    L13:
        BearUrl r3 = null;
    L15:
        if (d(r9, new sbb.e[]{sbb.e.n}) == true) goto L25;
        int r5 = oj5.d.b;
        if (oj5.d.a.a(r9.P) == null) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == false) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == true) goto L25;
    L27:
        if (r3 == null) goto L31;
        r1 = r3;
    L31:
        if (r9.getType() != 113) goto L43;
        r1.a = sbb.e.t.getType();
        String r10 = r9.d;
        if (r10 != null) goto L35;
    L52:
        return r1;
    L35:
        if (r10.length() > 0) goto L38;
        r2 = false;
    L38:
        if (r2 == false) goto L40;
        r4 = r10;
    L40:
        if (r4 == null) goto L52;
        r1.b = r4;
        goto L52
    L43:
        if (r9.getType() != 114) goto L52;
        String r8 = r9.d;
        if (r8 != null) goto L47;
    L50:
        if (r2 == true) goto L52;
        r1.a = sbb.e.u.getType();
        r1.b = r9.d;
        goto L52
    L47:
        if (r8.length() == 0) goto L50;
        r2 = false;
        goto L50
    L22:
        r7 = false;
        goto L23
    L19:
        r6 = false;
    L25:
        if (TextUtils.isEmpty(r9.G1) == true) goto L27;
        r3 = s45.p.a().Z(s45.p.a().Fd(r9.p, sbb.e.f(r9.y1), r9.G1, r1.d));
        r3.m = r9.p;
        goto L27
    L11:
        if (TextUtils.isEmpty(r9.p2) == true) goto L13;
        r1.m = s45.p.a().Fd(r9.p, sbb.e.n.getType(), r9.p2, null);
        r3 = r1;
        goto L15
    L5:
        if (r9.h2 != ObjBizType.WIKI.getType()) goto L7;
        r0 = true;
        goto L8
    }

    public static boolean c(Document r4, sbb.e... r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "types");
        if (r4.getType() != sbb.e.n.b) goto L5;
        int r6 = r4.y1;
    L6:
        int r0 = r5.length;
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L13;
        if (r5[r2].b == r6) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return true;
    L13:
        return false;
    L5:
        r6 = r4.getType();
        goto L6
    }

    public static boolean d(Document r5, sbb.e... r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "types");
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r6[r2].b == r5.getType()) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static oj5.b a(Document r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "document");
        oj5.b r5 = t0.k(r2, r3);
        if (r2.b() == false) goto L20;
        if (r4 == false) goto L20;
        String r6 = CommonMoreItemId.DELETE.getId();
        String[] r7 = r5.v;
        if (r7 == null) goto L11;
        Collection r8 = ArraysKt.toMutableSet(r7);
        if (r8 == null) goto L11;
    L12:
        Map<String, String> r0 = r5.w;
        if (r0 == null) goto L17;
        Map<String, String> r1 = MapsKt.toMutableMap(r0);
        if (r1 == null) goto L17;
    L18:
        Collection r9 = r8;
        r9.add(r6);
        r1.put(r6, t0.d());
        r5.v = (String[]) r9.toArray(new String[0]);
        r5.w = r1;
        Intrinsics.checkNotNull(r5);
        return r5;
    L17:
        r1 = new LinkedHashMap();
    L11:
        r8 = new LinkedHashSet();
    L20:
        Intrinsics.checkNotNull(r5);
        return r5;
    }

    @JvmStatic
    public static final void e(m r13, ce5.a r14, View r15) {
        Intrinsics.checkNotNullParameter(r13, "param");
        Intrinsics.checkNotNullParameter(r14, "userComponentAbility");
        SpaceMoreItemFactory r4 = new SpaceMoreItemFactory(r13, r14);
        Document r2 = r13.b;
        String r3 = r13.i;
        if (TextUtils.equals(r13.d, "lark_workspace_bitable_landing") == false) goto L6;
        BaseMoreProvider r16 = new SpaceBitableLandingMoreProvider(r2, r3, r4, r13.e);
    L5:
        BaseMoreProvider r9 = r16;
        tt5.a.b("SpaceMoreUt", "showMoreV3. ");
        if (ForsetiHelper.o() == false) goto L55;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).C(r13.a.getActivity(), r9, r13.a, r15, -1);
        return;
    L55:
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).J(r13.a.getActivity(), r9, r13.a);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r2, "<this>");
        boolean r1 = true;
        if (NodeType.isShortcut(r2.M1) == true) goto L9;
    L11:
        boolean r0 = false;
    L12:
        if (r0 == false) goto L14;
        r16 = new SpaceWikiShortcutMoreProvider(r2, r3, r4);
        goto L5
    L14:
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (NodeType.isShortcut(r2.M1) == false) goto L18;
        r16 = new SpaceDocShortcutMoreProvider(r2, r3, r4);
        goto L5
    L18:
        if (d(r2, new sbb.e[]{sbb.e.n}) == true) goto L51;
        int r17 = oj5.d.b;
        if (oj5.d.a.a(r2.P) == null) goto L22;
        boolean r18 = true;
    L23:
        if (r18 == false) goto L25;
        boolean r19 = true;
    L26:
        if (r19 == true) goto L51;
        sbb.e r5 = sbb.e.f;
        if (d(r2, new sbb.e[]{r5}) == false) goto L37;
        DocVersion.a r110 = DocVersion.Companion;
        int r6 = r2.L1;
        r110.getClass();
        if (r6 != 5) goto L33;
        boolean r111 = true;
    L34:
        if (r111 == true) goto L37;
        r16 = new V1SpaceFolderMoreProvider(r2, r3, r4);
        goto L5
    L33:
        r111 = false;
    L37:
        if (d(r2, new sbb.e[]{r5}) == false) goto L39;
        r16 = new SpaceFolderMoreProvider(r2, r3, r4);
        goto L5
    L39:
        int r112 = a.a;
        Intrinsics.checkNotNullParameter(r2, "document");
        if (idb.f.a().isEnable("apaas.miaoda.migrate_to_ccm") == false) goto L47;
        int r113 = r2.getType();
        int r7 = r2.y1;
        if (r7 <= 0) goto L45;
        r113 = r7;
    L45:
        if (sbb.g.b(r113) == false) goto L47;
    L48:
        if (r1 == false) goto L50;
        r16 = new l(r2, r3, r4);
        goto L5
    L50:
        r16 = new SpaceDocMoreProvider(r2, r3, r4);
    L47:
        r1 = false;
        goto L48
    L25:
        r19 = false;
        goto L26
    L22:
        r18 = false;
    L51:
        r16 = new SpaceWikiMoreProvider(r2, r3, r4, r13.d, r13.e);
        goto L5
    L9:
        if (r2.h2 != ObjBizType.WIKI.getType()) goto L11;
        r0 = true;
        goto L12
    }
}
