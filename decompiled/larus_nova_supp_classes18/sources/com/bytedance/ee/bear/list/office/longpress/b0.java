package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DefaultDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.more.export.BizType;
import com.bytedance.ee.bear.more.office.OfficeLongPressDisabledDispatchReason;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b0 {
    public static final b0 a = null;
    public static final ConcurrentHashMap<String, CompositeDisposable> b = null;
    public static final ConcurrentHashMap<String, CompositeDisposable> c = null;

    public b0() {
    }

    static {
        a = new b0();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
    }

    public static Context a(com.bytedance.ee.bear.more.office.c r1) {
        FragmentActivity r0 = r1.getActivity();
        if (r0 != null) goto L11;
        Fragment r2 = r1.e;
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.getContext();
    L11:
        return r0;
    }

    public static com.bytedance.ee.bear.more.office.d b(final com.bytedance.ee.bear.more.office.c r8) {
        Intrinsics.checkNotNullParameter(r8, "request");
        Context r3 = a(r8);
        if (r3 == null) goto L5;
        oj5.c r0 = r8.g;
        if (r8.j == false) goto L11;
        h(r8.a);
        return com.bytedance.ee.bear.more.office.d.e.a;
    L11:
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L15;
        h(r8.a);
        return new com.bytedance.ee.bear.more.office.d.b(r3.getString(2131887951));
    L15:
        if (((a4) org.koin.java.a.c(a4.class, null, null, 6)).c(r0.getToken()) == false) goto L18;
        h(r8.a);
        return new com.bytedance.ee.bear.more.office.d.b(r3.getString(2131887323));
    L18:
        com.bytedance.ee.bear.more.office.a r1 = c(r8, null);
        if ((r1 instanceof com.bytedance.ee.bear.more.office.a.C0116a) == false) goto L23;
        h(r8.a);
        return new com.bytedance.ee.bear.more.office.d.b(((com.bytedance.ee.bear.more.office.a.C0116a) r1).a);
    L23:
        if (Intrinsics.areEqual(r1, com.bytedance.ee.bear.more.office.a.b.a) == false) goto L27;
        h(r8.a);
        return com.bytedance.ee.bear.more.office.d.e.a;
    L27:
        if (e(r8.f, r0) == false) goto L37;
        Pair r2 = j(r8, r0);
        String r5 = (String) r2.component1();
        String r4 = (String) r2.component2();
        Disposable r6 = ((com.bytedance.ee.bear.contract.route.parcelable.e) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.e.class, null, null, 6)).a(r8.e, r3, r5, r4, r8.k, new OfficeMoveToActionExecutor$openWikiMoveSelector$disposable$1(r8));
        ConcurrentHashMap<String, CompositeDisposable> r7 = b;
        String r9 = r8.a;
        CompositeDisposable r10 = r7.get(r9);
        if (r10 != null) goto L34;
        r10 = new CompositeDisposable();
        CompositeDisposable r11 = r7.putIfAbsent(r9, r10);
        if (r11 == null) goto L34;
        r10 = r11;
    L34:
        r10.add(r6);
        return com.bytedance.ee.bear.more.office.d.f.a;
    L37:
        if (r8.f.getType() != sbb.e.f.b) goto L39;
    L54:
        g(r8, r3, r0);
        h(r8.a);
        return com.bytedance.ee.bear.more.office.d.C0117d.a;
    L39:
        if (i(r8.f).length() != 0) goto L41;
        boolean r12 = true;
    L42:
        if (r12 == false) goto L54;
        ConcurrentHashMap<String, CompositeDisposable> r13 = b;
        String r14 = r8.a;
        CompositeDisposable r15 = r13.get(r14);
        if (r15 != null) goto L49;
        r15 = new CompositeDisposable();
        CompositeDisposable r16 = r13.putIfAbsent(r14, r15);
        if (r16 == null) goto L49;
        r15 = r16;
    L49:
        CompositeDisposable r17 = r15;
        com.bytedance.ee.bear.d r18 = (com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6);
        Document r19 = r8.f;
        String r20 = r19.d;
        if (r20 != null) goto L52;
        r20 = "";
    L52:
        r17.add(r18.d(r20, r19.getType()).subscribe(new x(r8, r3, r0), new y(r3, r8)));
        return com.bytedance.ee.bear.more.office.d.f.a;
    L41:
        r12 = false;
        goto L42
    L5:
        return new com.bytedance.ee.bear.more.office.d.b(com.bytedance.ee.bear.more.office.f.c());
    }

    public static boolean d(Document r3) {
        String r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(((com.bytedance.ee.bear.contract.h0) org.koin.java.a.c(com.bytedance.ee.bear.contract.h0.class, null, null, 6)).U5());     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r2) == false) goto L10;
        r2 = null;
    L10:
        AccountService.Account r4 = (AccountService.Account) r2;
        if (r4 == null) goto L13;
        r0 = r4.tenantId;
    L13:
        String r5 = "";
        if (r0 != null) goto L16;
        r0 = "";
    L16:
        String r6 = r3.f;
        if (r6 == null) goto L21;
        r5 = r6;
    L21:
        return TextUtils.equals(r0, r5);
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static void h(String r1) {
        Intrinsics.checkNotNullParameter(r1, "actionId");
        CompositeDisposable r0 = b.remove(r1);
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        CompositeDisposable r2 = c.remove(r1);
        if (r2 == null) goto L9;
        r2.clear();
        return;
    }

    public static String i(Document r2) {
        if (r2.getType() != sbb.e.f.b) goto L7;
        String r3 = r2.d;
        if (r3 != null) goto L11;
    L9:
        return "";
    L11:
        return r3;
    L7:
        String r4 = r2.c;
        if (r4 == null) goto L9;
        return r4;
    }

    public static com.bytedance.ee.bear.more.office.a c(final com.bytedance.ee.bear.more.office.c r13, final com.bytedance.ee.bear.more.office.b r14) {
        Intrinsics.checkNotNullParameter(r13, "request");
        Context r0 = a(r13);
        if (r0 != null) goto L164;
        com.bytedance.ee.bear.more.office.a.C0116a r15 = new com.bytedance.ee.bear.more.office.a.C0116a(com.bytedance.ee.bear.more.office.f.c(), null, 2);
        f(r13, r15, "missing_context");
        return r15;
    L164:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L9
        Object r5 = Result.constructor-impl(((com.bytedance.ee.bear.contract.h0) org.koin.java.a.c(com.bytedance.ee.bear.contract.h0.class, null, null, 6)).U5());     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r5) == false) goto L14;
        r5 = null;
    L14:
        AccountService.Account r6 = (AccountService.Account) r5;
        Document r7 = r13.f;
        oj5.c r8 = r13.g;
        if (r13.j == false) goto L18;
        com.bytedance.ee.bear.more.office.a.b r16 = com.bytedance.ee.bear.more.office.a.b.a;
        f(r13, r16, "restricted_wiki_home");
        return r16;
    L18:
        String[] r9 = t0.a;
        boolean r10 = false;
        if (r7.n == false) goto L24;
        if (r6 == null) goto L24;
        if (TextUtils.equals(r7.e, r6.uid) == true) goto L24;
        boolean r11 = false;
    L25:
        if (r11 == true) goto L29;
        com.bytedance.ee.bear.more.office.a.b r17 = com.bytedance.ee.bear.more.office.a.b.a;
        f(r13, r17, "document_utils_move_to_disabled");
        return r17;
    L29:
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L33;
        com.bytedance.ee.bear.more.office.a.C0116a r18 = new com.bytedance.ee.bear.more.office.a.C0116a(r0.getString(2131887951), null, 2);
        f(r13, r18, "network_disconnected");
        return r18;
    L33:
        if (r7.getType() != sbb.e.f.b) goto L40;
        FolderVersion.a r12 = FolderVersion.Companion;
        Integer r19 = Integer.valueOf(r7.L1);
        r12.getClass();
        if (FolderVersion.a.c(r19) == true) goto L40;
        if (r7.Q1 == false) goto L40;
        com.bytedance.ee.bear.more.office.a.C0116a r110 = new com.bytedance.ee.bear.more.office.a.C0116a(r0.getString(2131887930, new Object[]{t0.n(r0, r7.getType())}), null, 2);
        f(r13, r110, "complaint_folder_move_forbidden");
        return r110;
    L40:
        boolean r20 = r8 instanceof oj5.a;
        if (r20 == false) goto L43;
        oj5.a r21 = (oj5.a) r8;
    L44:
        if (r21 == null) goto L48;
        oj5.d r22 = r21.H;
        if (r22 == null) goto L48;
        Integer r23 = r22.a();
    L49:
        if (r23 == null) goto L57;
        if (r23.intValue() == BizType.Space.getValue()) goto L57;
        if (r23.intValue() == BizType.Wiki.getValue()) goto L57;
        com.bytedance.ee.bear.more.office.a.C0116a r111 = new com.bytedance.ee.bear.more.office.a.C0116a(r0.getString(2131888787), null, 2);
        f(r13, r111, "unsupported_biz_type_" + r23);
        return r111;
    L57:
        if (e(r7, r8) == false) goto L68;
        ConcurrentHashMap<String, CompositeDisposable> r1 = c;
        if (r1.containsKey(r13.a) == true) goto L65;
        Pair r2 = j(r13, r8);
        Disposable r112 = ((com.bytedance.ee.bear.contract.route.parcelable.e) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.e.class, null, null, 6)).b((String) r2.component1(), (String) r2.component2(), new OfficeMoveToActionExecutor$startWikiMovePrefetchIfNeeded$disposable$1(r13, r14));
        CompositeDisposable r3 = new CompositeDisposable();
        if (r1.putIfAbsent(r13.a, r3) == null) goto L64;
        r112.dispose();
        goto L65
    L64:
        r3.add(r112);
    L65:
        com.bytedance.ee.bear.more.office.a.d r113 = com.bytedance.ee.bear.more.office.a.d.a;
        f(r13, r113, "wiki_move_context");
        return r113;
    L68:
        if (r20 == false) goto L88;
        oj5.a r114 = (oj5.a) r8;
    L81:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        Object r24 = Result.constructor-impl(ResultKt.createFailure(th));
    L83:
        Boolean r116 = Boolean.FALSE;
        if (Result.isFailure-impl(r24) == false) goto L86;
        r24 = r116;
    L86:
        boolean r25 = ((Boolean) r24).booleanValue();
    L104:
        if (r25 == false) goto L106;
        com.bytedance.ee.bear.more.office.a r26 = com.bytedance.ee.bear.more.office.a.d.a;
    L107:
        com.bytedance.ee.bear.more.office.a.d r27 = com.bytedance.ee.bear.more.office.a.d.a;
        if (Intrinsics.areEqual(r26, r27) == true) goto L126;
        if (r20 == false) goto L118;
        if (((oj5.a) r8).p == false) goto L114;
        String r117 = "shortcut_source_move_permission_denied";
    L124:
        f(r13, r26, r117);
        return r26;
    L114:
        if (d(r7) == true) goto L116;
        r117 = "cross_tenant_source_move_permission_denied";
        goto L124
    L116:
        r117 = "doc_source_move_permission_denied";
        goto L124
    L118:
        if ((r8 instanceof oj5.b) == true) goto L120;
        r117 = "source_move_permission_denied";
        goto L124
    L120:
        if (((oj5.b) r8).q == false) goto L122;
        r117 = "shortcut_folder_source_move_permission_denied";
        goto L124
    L122:
        r117 = "folder_source_move_permission_denied";
        goto L124
    L126:
        int r28 = r13.f.getType();
        sbb.e r29 = sbb.e.f;
        if (r28 == r29.b) goto L144;
        if (i(r13.f).length() <= 0) goto L131;
        boolean r30 = true;
    L132:
        if (r30 == true) goto L144;
        ConcurrentHashMap<String, CompositeDisposable> r31 = c;
        if (r31.containsKey(r13.a) == true) goto L144;
        CompositeDisposable r118 = new CompositeDisposable();
        if (r31.putIfAbsent(r13.a, r118) != null) goto L144;
        com.bytedance.ee.bear.d r32 = (com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6);
        Document r33 = r13.f;
        String r34 = r33.d;
        if (r34 != null) goto L142;
        r34 = "";
    L142:
        r118.add(r32.d(r34, r33.getType()).subscribe(new z(r13, r14), new a0(r13, r14)));
        goto L144
    L131:
        r30 = false;
    L144:
        if (r8.A() == null) goto L146;
        boolean r119 = true;
    L148:
        if (i(r7).length() <= 0) goto L150;
        boolean r35 = true;
    L151:
        if (r35 == false) goto L153;
    L154:
        r10 = true;
    L155:
        if (r119 == false) goto L158;
        if (r10 == false) goto L158;
        f(r13, r27, "all_move_checks_passed");
        return r27;
    L158:
        com.bytedance.ee.bear.more.office.a.C0116a r36 = new com.bytedance.ee.bear.more.office.a.C0116a(r0.getString(2131887932), OfficeLongPressDisabledDispatchReason.PREFETCH_IN_PROGRESS_RETRY);
        f(r13, r36, "owner_type_or_node_token_not_ready(ownerTypeReady=" + r119 + ",nodeTokenReady=" + r10 + ')');
        return r36;
    L153:
        if (r7.getType() == r29.b) goto L155;
    L150:
        r35 = false;
        goto L151
    L146:
        r119 = false;
        goto L148
    L106:
        r26 = new com.bytedance.ee.bear.more.office.a.C0116a(r0.getString(2131887932), null, 2);
        goto L107
    L71:
        if (r114.p == false) goto L73;
    L75:
        com.bytedance.ee.bear.more.b r120 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);     // Catch: Throwable -> L81
        if (r114.p == false) goto L78;
        boolean r37 = Intrinsics.areEqual(r120.v(r114, r114.s, "MOVE_THIS_NODE"), Boolean.TRUE);     // Catch: Throwable -> L81
    L79:
        r24 = Result.constructor-impl(Boolean.valueOf(r37));     // Catch: Throwable -> L81
        goto L83
    L78:
        r37 = Intrinsics.areEqual(r120.v(r114, r114.i.a, "MOVE_THIS_NODE"), Boolean.TRUE);     // Catch: Throwable -> L81
        goto L79
    L73:
        if (d(r7) == false) goto L75;
        r37 = true;
        goto L79
    L88:
        if ((r8 instanceof oj5.b) == false) goto L102;
        oj5.b r121 = (oj5.b) r8;
        com.bytedance.ee.bear.more.b r122 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);     // Catch: Throwable -> L96
        if (r121.q == false) goto L93;
        boolean r38 = Intrinsics.areEqual(r122.v(r121, r121.u, "MOVE_THIS_NODE"), Boolean.TRUE);     // Catch: Throwable -> L96
    L94:
        Object r39 = Result.constructor-impl(Boolean.valueOf(r38));     // Catch: Throwable -> L96
    L98:
        Boolean r123 = Boolean.FALSE;
        if (Result.isFailure-impl(r39) == false) goto L101;
        r39 = r123;
    L101:
        r25 = ((Boolean) r39).booleanValue();
        goto L104
    L93:
        r38 = Intrinsics.areEqual(r122.B(r121, r121.t, "MOVE_THIS_NODE"), Boolean.TRUE);     // Catch: Throwable -> L96
    L96:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r39 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L98
    L102:
        r25 = true;
    L48:
        r23 = null;
        goto L49
    L43:
        r21 = null;
    L24:
        r11 = true;
    L9:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public static boolean e(Document r2, oj5.c r3) {
        Integer r1 = null;
        if ((r3 instanceof oj5.a) == false) goto L5;
        oj5.a r0 = (oj5.a) r3;
    L6:
        if (r0 == null) goto L11;
        oj5.d r4 = r0.H;
        if (r4 == null) goto L11;
        r1 = r4.a();
    L11:
        if (r2.getType() != sbb.e.n.b) goto L13;
    L21:
        return true;
    L13:
        if ((r3 instanceof oj5.f) == true) goto L21;
        int r5 = BizType.Wiki.getValue();
        if (r1 != null) goto L18;
    L20:
        return false;
    L18:
        if (r1.intValue() != r5) goto L20;
    L5:
        r0 = null;
        goto L6
    }

    public static Pair j(com.bytedance.ee.bear.more.office.c r3, oj5.c r4) {
        String r1 = null;
        if ((r4 instanceof oj5.a) == false) goto L5;
        oj5.a r0 = (oj5.a) r4;
    L6:
        if (r0 == null) goto L8;
        oj5.d r2 = r0.H;
    L10:
        if ((r4 instanceof oj5.f) == false) goto L12;
        oj5.f r5 = (oj5.f) r4;
    L13:
        if (r5 == null) goto L16;
        String r6 = r5.O;
        if (r6 == null) goto L16;
    L21:
        if (r2 == null) goto L24;
        r1 = r2.d();
    L24:
        return TuplesKt.to(r1, r6);
    L16:
        if (r2 == null) goto L18;
        r6 = r2.a;
    L19:
        if (r6 != null) goto L21;
        r6 = r3.f.d;
        goto L21
    L18:
        r6 = null;
        goto L19
    L12:
        r5 = null;
        goto L13
    L8:
        r2 = null;
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    public static void f(com.bytedance.ee.bear.more.office.c r3, com.bytedance.ee.bear.more.office.a r4, String r5) {
        StringBuilder r0 = new StringBuilder("move-to availability decision. ");
        StringBuilder r1 = new StringBuilder("actionId=");
        r1.append(du5.b.k(r3.a));
        r1.append(", token=");
        String r2 = r3.f.d;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r1.append(du5.b.k(r2));
        r1.append(", type=");
        r1.append(r3.f.getType());
        r1.append(", realType=");
        r1.append(r3.f.y1);
        r1.append(", nodeTokenReady=");
        if (i(r3.f).length() <= 0) goto L8;
        boolean r6 = true;
    L9:
        r1.append(r6);
        r1.append(", moreInfo=");
        r1.append(r3.g.getClass().getSimpleName());
        r1.append(", moreType=");
        r1.append(r3.g.getType());
        r1.append(", moreRealType=");
        r1.append(r3.g.i());
        r1.append(", isShortcut=");
        r1.append(r3.g.E());
        r0.append(r1.toString());
        r0.append(", result=");
        if (Intrinsics.areEqual(r4, com.bytedance.ee.bear.more.office.a.d.a) == false) goto L13;
        String r7 = "Visible";
    L21:
        r0.append(r7);
        r0.append(", reason=");
        r0.append(r5);
        tt5.a.h("OfficeMoveToActionExecutor", r0.toString());
        return;
    L13:
        if (Intrinsics.areEqual(r4, com.bytedance.ee.bear.more.office.a.b.a) == false) goto L16;
        r7 = "Hidden";
        goto L21
    L16:
        if ((r4 instanceof com.bytedance.ee.bear.more.office.a.c) == false) goto L19;
        r7 = "Loading";
        goto L21
    L19:
        if ((r4 instanceof com.bytedance.ee.bear.more.office.a.C0116a) == false) goto L24;
        r7 = "Disabled(reason=" + ((com.bytedance.ee.bear.more.office.a.C0116a) r4).b + ')';
        goto L21
    L24:
        throw new NoWhenBranchMatchedException();
    L8:
        r6 = false;
        goto L9
    }

    public static void g(com.bytedance.ee.bear.more.office.c r10, Context r11, oj5.c r12) {
        if ((r12 instanceof oj5.a) == false) goto L5;
        oj5.a r13 = (oj5.a) r12;
    L6:
        boolean r0 = false;
        if (r13 == null) goto L17;
        DocPermission r14 = r13.i;
        if (r14 == null) goto L17;
        IDocPublicPermission r15 = r14.b;
        if (r15 == null) goto L17;
        if ((r15 instanceof DefaultDocPublicPermission) == false) goto L16;
        boolean r16 = true;
    L18:
        Document r3 = r10.f;
        SpaceSelectorBean r8 = new SpaceSelectorBean();
        String r4 = r3.d;
        String r5 = "";
        if (r4 != null) goto L21;
        r4 = "";
    L21:
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r8.b = r4;
        a.getClass();
        String r6 = i(r3);
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r8.d = r6;
        int r7 = r3.getType();
        sbb.e r9 = sbb.e.f;
        if (r7 != r9.b) goto L28;
        String r17 = r3.d;
        if (r17 == null) goto L27;
        r5 = r17;
    L27:
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r8.d = r5;
        r8.l = r3.P1;
    L28:
        r8.c = r10.g.x();
        r8.a = r3.getType();
        FolderVersion.a r18 = FolderVersion.Companion;
        Integer r19 = Integer.valueOf(r3.L1);
        r18.getClass();
        r8.g = FolderVersion.a.c(r19);
        r8.j = NodeType.isShortcut(r3.M1);
        r8.i = r10.g.isOwner();
        r8.h = r16;
        String r110 = r10.h;
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r8.n = r110;
        String r111 = r10.i;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r8.m = r111;
        SelectorConfig r20 = new SelectorConfig();
        r20.c(SelectorType.SPACE_MOVE_TO);
        if (r8.g == true) goto L31;
    L35:
        boolean r112 = false;
    L36:
        if (r112 == true) goto L38;
    L45:
        SelectorScope r113 = SelectorScope.SPACE_ONLY;
    L46:
        r20.a(r113);
        r20.b(r11.getString(2131887781));
        r20.d = true;
        r20.g = DocUserPermission.USER_PERM_FULL_ACCESS;
        boolean r21 = r8.g;
        if (r21 == true) goto L49;
        r20.e = true;
    L49:
        if (r21 == false) goto L51;
    L54:
        boolean r22 = true;
    L55:
        r20.i = r22;
        if (r10.f.getType() == r9.b) goto L58;
        r0 = true;
    L58:
        r20.j = r0;
        SelectorConfig.a r1 = SelectorConfig.CREATOR;
        WeakReference<td5.a> r2 = new WeakReference(new w(r10.f, r8, r11));
        r1.getClass();
        SelectorConfig.k = r2;
        td5.f r23 = new td5.f();
        r23.a = 2;
        r23.e = Integer.valueOf(DocUserPermission.USER_PERM_FULL_ACCESS);
        Fragment r24 = r10.e;
        com.bytedance.ee.bear.contract.route.parcelable.f r25 = (com.bytedance.ee.bear.contract.route.parcelable.f) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.f.class, null, null, 6);
        if (r24 == null) goto L61;
        r25.a(r24, r20, r23, r8, null);
        return;
    L61:
        r25.c(r11, r20, r23, r8, null);
        return;
    L51:
        if (r10.f.getType() == r9.b) goto L54;
        r22 = false;
        goto L55
    L38:
        if (d(r10.f) == false) goto L45;
        Document r114 = r10.f;
        int r26 = r114.getType();
        int r115 = r114.y1;
        if (r115 <= 0) goto L43;
        r26 = r115;
    L43:
        if (sbb.g.b(r26) == true) goto L45;
        r113 = SelectorScope.ALL;
        goto L46
    L31:
        if (r8.a == r9.b) goto L35;
        if (r8.j == true) goto L35;
        r112 = true;
        goto L36
    L16:
        r16 = r15.externalAccess();
    L17:
        r16 = false;
        goto L18
    L5:
        r13 = null;
        goto L6
    }
}
