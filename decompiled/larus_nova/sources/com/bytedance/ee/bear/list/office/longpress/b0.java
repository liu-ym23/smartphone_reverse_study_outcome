package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DefaultDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.more.export.BizType;
import com.bytedance.ee.bear.more.office.OfficeLongPressDisabledDispatchReason;
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes18.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f228938a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, CompositeDisposable> f228939b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, CompositeDisposable> f228940c = null;

    public b0() {
    }

    static {
        f228938a = new b0();
        f228939b = new ConcurrentHashMap();
        f228940c = new ConcurrentHashMap();
    }

    public static Context a(com.bytedance.ee.bear.more.office.c r100) {
        FragmentActivity r101 = r100.getActivity();
        if (r101 != null) goto L11;
        Fragment r102 = r100.f234691e;
        if (r102 != null) goto L10;
        return null;
    L10:
        return r102.getContext();
    L11:
        return r101;
    }

    public static com.bytedance.ee.bear.more.office.d b(final com.bytedance.ee.bear.more.office.c r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Context r101 = a(r100);
        if (r101 == null) goto L5;
        oj5.c r102 = r100.f234693g;
        if (r100.f234696j == false) goto L11;
        h(r100.f234687a);
        return com.bytedance.ee.bear.more.office.d.e.f234703a;
    L11:
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == true) goto L15;
        h(r100.f234687a);
        return new com.bytedance.ee.bear.more.office.d.b(r101.getString(R.string.Doc_List_OperateFailedNoNet));
    L15:
        if (((a4) org.koin.java.a.c(a4.class, null, null, 6)).c(r102.getToken()) == false) goto L18;
        h(r100.f234687a);
        return new com.bytedance.ee.bear.more.office.d.b(r101.getString(R.string.CreationMobile_Error_Comment_NetworkError));
    L18:
        com.bytedance.ee.bear.more.office.a r103 = c(r100, null);
        if ((r103 instanceof com.bytedance.ee.bear.more.office.a.C3363a) == false) goto L23;
        h(r100.f234687a);
        return new com.bytedance.ee.bear.more.office.d.b(((com.bytedance.ee.bear.more.office.a.C3363a) r103).f234682a);
    L23:
        if (Intrinsics.areEqual(r103, com.bytedance.ee.bear.more.office.a.b.f234684a) == false) goto L27;
        h(r100.f234687a);
        return com.bytedance.ee.bear.more.office.d.e.f234703a;
    L27:
        if (e(r100.f234692f, r102) == false) goto L37;
        Pair r104 = j(r100, r102);
        String r105 = (String) r104.component1();
        String r106 = (String) r104.component2();
        Disposable r107 = ((com.bytedance.ee.bear.contract.route.parcelable.e) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.e.class, null, null, 6)).a(r100.f234691e, r101, r105, r106, r100.f234697k, new OfficeMoveToActionExecutor$openWikiMoveSelector$disposable$1(r100));
        ConcurrentHashMap<String, CompositeDisposable> r108 = f228939b;
        String r109 = r100.f234687a;
        CompositeDisposable r110 = r108.get(r109);
        if (r110 != null) goto L34;
        r110 = new CompositeDisposable();
        CompositeDisposable r111 = r108.putIfAbsent(r109, r110);
        if (r111 == null) goto L34;
        r110 = r111;
    L34:
        r110.add(r107);
        return com.bytedance.ee.bear.more.office.d.f.f234704a;
    L37:
        if (r100.f234692f.getType() != sbb.e.f541295f.f541317b) goto L39;
    L54:
        g(r100, r101, r102);
        h(r100.f234687a);
        return com.bytedance.ee.bear.more.office.d.C3364d.f234702a;
    L39:
        if (i(r100.f234692f).length() != 0) goto L41;
        boolean r112 = true;
    L42:
        if (r112 == false) goto L54;
        ConcurrentHashMap<String, CompositeDisposable> r113 = f228939b;
        String r114 = r100.f234687a;
        CompositeDisposable r115 = r113.get(r114);
        if (r115 != null) goto L49;
        r115 = new CompositeDisposable();
        CompositeDisposable r116 = r113.putIfAbsent(r114, r115);
        if (r116 == null) goto L49;
        r115 = r116;
    L49:
        CompositeDisposable r117 = r115;
        com.bytedance.ee.bear.d r118 = (com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6);
        Document r119 = r100.f234692f;
        String r120 = r119.f227873d;
        if (r120 != null) goto L52;
        r120 = "";
    L52:
        r117.add(r118.d(r120, r119.getType()).subscribe(new x(r100, r101, r102), new y(r101, r100)));
        return com.bytedance.ee.bear.more.office.d.f.f234704a;
    L41:
        r112 = false;
        goto L42
    L5:
        return new com.bytedance.ee.bear.more.office.d.b(com.bytedance.ee.bear.more.office.f.c());
    }

    public static boolean d(Document r100) {
        String r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(((com.bytedance.ee.bear.contract.h0) org.koin.java.a.c(com.bytedance.ee.bear.contract.h0.class, null, null, 6)).U5());     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        AccountService$Account r104 = (AccountService$Account) r103;
        if (r104 == null) goto L13;
        r101 = r104.tenantId;
    L13:
        String r105 = "";
        if (r101 != null) goto L16;
        r101 = "";
    L16:
        String r106 = r100.f227875f;
        if (r106 == null) goto L21;
        r105 = r106;
    L21:
        return TextUtils.equals(r101, r105);
    L5:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "actionId");
        CompositeDisposable r101 = f228939b.remove(r100);
        if (r101 == null) goto L5;
        r101.clear();
    L5:
        CompositeDisposable r102 = f228940c.remove(r100);
        if (r102 == null) goto L9;
        r102.clear();
        return;
    }

    public static String i(Document r100) {
        if (r100.getType() != sbb.e.f541295f.f541317b) goto L7;
        String r101 = r100.f227873d;
        if (r101 != null) goto L11;
    L9:
        return "";
    L11:
        return r101;
    L7:
        String r102 = r100.f227872c;
        if (r102 == null) goto L9;
        return r102;
    }

    public static com.bytedance.ee.bear.more.office.a c(final com.bytedance.ee.bear.more.office.c r110, final com.bytedance.ee.bear.more.office.b r111) {
        Intrinsics.checkNotNullParameter(r110, "request");
        Context r100 = a(r110);
        if (r100 != null) goto L164;
        com.bytedance.ee.bear.more.office.a.C3363a r112 = new com.bytedance.ee.bear.more.office.a.C3363a(com.bytedance.ee.bear.more.office.f.c(), null, 2);
        f(r110, r112, "missing_context");
        return r112;
    L164:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        Object r102 = Result.m9449constructorimpl(((com.bytedance.ee.bear.contract.h0) org.koin.java.a.c(com.bytedance.ee.bear.contract.h0.class, null, null, 6)).U5());     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r102) == false) goto L14;
        r102 = null;
    L14:
        AccountService$Account r103 = (AccountService$Account) r102;
        Document r104 = r110.f234692f;
        oj5.c r105 = r110.f234693g;
        if (r110.f234696j == false) goto L18;
        com.bytedance.ee.bear.more.office.a.b r113 = com.bytedance.ee.bear.more.office.a.b.f234684a;
        f(r110, r113, "restricted_wiki_home");
        return r113;
    L18:
        String[] r106 = t0.f229767a;
        boolean r107 = false;
        if (r104.f227889n == false) goto L24;
        if (r103 == null) goto L24;
        if (TextUtils.equals(r104.f227874e, r103.uid) == true) goto L24;
        boolean r108 = false;
    L25:
        if (r108 == true) goto L29;
        com.bytedance.ee.bear.more.office.a.b r114 = com.bytedance.ee.bear.more.office.a.b.f234684a;
        f(r110, r114, "document_utils_move_to_disabled");
        return r114;
    L29:
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == true) goto L33;
        com.bytedance.ee.bear.more.office.a.C3363a r115 = new com.bytedance.ee.bear.more.office.a.C3363a(r100.getString(R.string.Doc_List_OperateFailedNoNet), null, 2);
        f(r110, r115, "network_disconnected");
        return r115;
    L33:
        if (r104.getType() != sbb.e.f541295f.f541317b) goto L40;
        FolderVersion.a r109 = FolderVersion.Companion;
        Integer r116 = Integer.valueOf(r104.L1);
        r109.getClass();
        if (FolderVersion.a.c(r116) == true) goto L40;
        if (r104.Q1 == false) goto L40;
        com.bytedance.ee.bear.more.office.a.C3363a r117 = new com.bytedance.ee.bear.more.office.a.C3363a(r100.getString(R.string.Doc_List_MakeMoveForbidden, new Object[]{t0.n(r100, r104.getType())}), null, 2);
        f(r110, r117, "complaint_folder_move_forbidden");
        return r117;
    L40:
        boolean r118 = r105 instanceof oj5.a;
        if (r118 == false) goto L43;
        oj5.a r119 = (oj5.a) r105;
    L44:
        if (r119 == null) goto L48;
        oj5.d r120 = r119.H;
        if (r120 == null) goto L48;
        Integer r121 = r120.a();
    L49:
        if (r121 == null) goto L57;
        if (r121.intValue() == BizType.Space.getValue()) goto L57;
        if (r121.intValue() == BizType.Wiki.getValue()) goto L57;
        com.bytedance.ee.bear.more.office.a.C3363a r122 = new com.bytedance.ee.bear.more.office.a.C3363a(r100.getString(R.string.LarkCCM_CM_MoveDoc_Error_Toast), null, 2);
        f(r110, r122, "unsupported_biz_type_" + r121);
        return r122;
    L57:
        if (e(r104, r105) == false) goto L68;
        ConcurrentHashMap<String, CompositeDisposable> r123 = f228940c;
        if (r123.containsKey(r110.f234687a) == true) goto L65;
        Pair r124 = j(r110, r105);
        Disposable r125 = ((com.bytedance.ee.bear.contract.route.parcelable.e) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.e.class, null, null, 6)).b((String) r124.component1(), (String) r124.component2(), new OfficeMoveToActionExecutor$startWikiMovePrefetchIfNeeded$disposable$1(r110, r111));
        CompositeDisposable r126 = new CompositeDisposable();
        if (r123.putIfAbsent(r110.f234687a, r126) == null) goto L64;
        r125.dispose();
        goto L65
    L64:
        r126.add(r125);
    L65:
        com.bytedance.ee.bear.more.office.a.d r127 = com.bytedance.ee.bear.more.office.a.d.f234686a;
        f(r110, r127, "wiki_move_context");
        return r127;
    L68:
        if (r118 == false) goto L88;
        oj5.a r128 = (oj5.a) r105;
    L81:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        Object r130 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L83:
        Boolean r131 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r130) == false) goto L86;
        r130 = r131;
    L86:
        boolean r132 = ((Boolean) r130).booleanValue();
    L104:
        if (r132 == false) goto L106;
        com.bytedance.ee.bear.more.office.a r133 = com.bytedance.ee.bear.more.office.a.d.f234686a;
    L107:
        com.bytedance.ee.bear.more.office.a.d r134 = com.bytedance.ee.bear.more.office.a.d.f234686a;
        if (Intrinsics.areEqual(r133, r134) == true) goto L126;
        if (r118 == false) goto L118;
        if (((oj5.a) r105).f523545p == false) goto L114;
        String r135 = "shortcut_source_move_permission_denied";
    L124:
        f(r110, r133, r135);
        return r133;
    L114:
        if (d(r104) == true) goto L116;
        r135 = "cross_tenant_source_move_permission_denied";
        goto L124
    L116:
        r135 = "doc_source_move_permission_denied";
        goto L124
    L118:
        if ((r105 instanceof oj5.b) == true) goto L120;
        r135 = "source_move_permission_denied";
        goto L124
    L120:
        if (((oj5.b) r105).f523572q == false) goto L122;
        r135 = "shortcut_folder_source_move_permission_denied";
        goto L124
    L122:
        r135 = "folder_source_move_permission_denied";
        goto L124
    L126:
        int r136 = r110.f234692f.getType();
        sbb.e r137 = sbb.e.f541295f;
        if (r136 == r137.f541317b) goto L144;
        if (i(r110.f234692f).length() <= 0) goto L131;
        boolean r138 = true;
    L132:
        if (r138 == true) goto L144;
        ConcurrentHashMap<String, CompositeDisposable> r139 = f228940c;
        if (r139.containsKey(r110.f234687a) == true) goto L144;
        CompositeDisposable r140 = new CompositeDisposable();
        if (r139.putIfAbsent(r110.f234687a, r140) != null) goto L144;
        com.bytedance.ee.bear.d r141 = (com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6);
        Document r142 = r110.f234692f;
        String r143 = r142.f227873d;
        if (r143 != null) goto L142;
        r143 = "";
    L142:
        r140.add(r141.d(r143, r142.getType()).subscribe(new z(r110, r111), new a0(r110, r111)));
        goto L144
    L131:
        r138 = false;
    L144:
        if (r105.A() == null) goto L146;
        boolean r144 = true;
    L148:
        if (i(r104).length() <= 0) goto L150;
        boolean r145 = true;
    L151:
        if (r145 == false) goto L153;
    L154:
        r107 = true;
    L155:
        if (r144 == false) goto L158;
        if (r107 == false) goto L158;
        f(r110, r134, "all_move_checks_passed");
        return r134;
    L158:
        com.bytedance.ee.bear.more.office.a.C3363a r146 = new com.bytedance.ee.bear.more.office.a.C3363a(r100.getString(R.string.Doc_List_MoveFailedRetry), OfficeLongPressDisabledDispatchReason.PREFETCH_IN_PROGRESS_RETRY);
        f(r110, r146, "owner_type_or_node_token_not_ready(ownerTypeReady=" + r144 + ",nodeTokenReady=" + r107 + ')');
        return r146;
    L153:
        if (r104.getType() == r137.f541317b) goto L155;
    L150:
        r145 = false;
        goto L151
    L146:
        r144 = false;
        goto L148
    L106:
        r133 = new com.bytedance.ee.bear.more.office.a.C3363a(r100.getString(R.string.Doc_List_MoveFailedRetry), null, 2);
        goto L107
    L71:
        if (r128.f523545p == false) goto L73;
    L75:
        com.bytedance.ee.bear.more.b r147 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);     // Catch: Throwable -> L81
        if (r128.f523545p == false) goto L78;
        boolean r148 = Intrinsics.areEqual(r147.v(r128, r128.f523548s, "MOVE_THIS_NODE"), Boolean.TRUE);     // Catch: Throwable -> L81
    L79:
        r130 = Result.m9449constructorimpl(Boolean.valueOf(r148));     // Catch: Throwable -> L81
        goto L83
    L78:
        r148 = Intrinsics.areEqual(r147.v(r128, r128.f523538i.f234419a, "MOVE_THIS_NODE"), Boolean.TRUE);     // Catch: Throwable -> L81
        goto L79
    L73:
        if (d(r104) == false) goto L75;
        r148 = true;
        goto L79
    L88:
        if ((r105 instanceof oj5.b) == false) goto L102;
        oj5.b r149 = (oj5.b) r105;
        com.bytedance.ee.bear.more.b r150 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);     // Catch: Throwable -> L96
        if (r149.f523572q == false) goto L93;
        boolean r151 = Intrinsics.areEqual(r150.v(r149, r149.f523576u, "MOVE_THIS_NODE"), Boolean.TRUE);     // Catch: Throwable -> L96
    L94:
        Object r152 = Result.m9449constructorimpl(Boolean.valueOf(r151));     // Catch: Throwable -> L96
    L98:
        Boolean r153 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r152) == false) goto L101;
        r152 = r153;
    L101:
        r132 = ((Boolean) r152).booleanValue();
        goto L104
    L93:
        r151 = Intrinsics.areEqual(r150.B(r149, r149.f523575t, "MOVE_THIS_NODE"), Boolean.TRUE);     // Catch: Throwable -> L96
    L96:
        th = move-exception;
        Result.Companion r154 = Result.Companion;
        r152 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L98
    L102:
        r132 = true;
    L48:
        r121 = null;
        goto L49
    L43:
        r119 = null;
    L24:
        r108 = true;
    L9:
        th = move-exception;
        Result.Companion r155 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public static boolean e(Document r100, oj5.c r101) {
        Integer r102 = null;
        if ((r101 instanceof oj5.a) == false) goto L5;
        oj5.a r103 = (oj5.a) r101;
    L6:
        if (r103 == null) goto L11;
        oj5.d r104 = r103.H;
        if (r104 == null) goto L11;
        r102 = r104.a();
    L11:
        if (r100.getType() != sbb.e.f541303n.f541317b) goto L13;
    L21:
        return true;
    L13:
        if ((r101 instanceof oj5.f) == true) goto L21;
        int r105 = BizType.Wiki.getValue();
        if (r102 != null) goto L18;
    L20:
        return false;
    L18:
        if (r102.intValue() != r105) goto L20;
    L5:
        r103 = null;
        goto L6
    }

    public static Pair j(com.bytedance.ee.bear.more.office.c r100, oj5.c r101) {
        String r102 = null;
        if ((r101 instanceof oj5.a) == false) goto L5;
        oj5.a r103 = (oj5.a) r101;
    L6:
        if (r103 == null) goto L8;
        oj5.d r104 = r103.H;
    L10:
        if ((r101 instanceof oj5.f) == false) goto L12;
        oj5.f r105 = (oj5.f) r101;
    L13:
        if (r105 == null) goto L16;
        String r106 = r105.O;
        if (r106 == null) goto L16;
    L21:
        if (r104 == null) goto L24;
        r102 = r104.d();
    L24:
        return TuplesKt.to(r102, r106);
    L16:
        if (r104 == null) goto L18;
        r106 = r104.f523580a;
    L19:
        if (r106 != null) goto L21;
        r106 = r100.f234692f.f227873d;
        goto L21
    L18:
        r106 = null;
        goto L19
    L12:
        r105 = null;
        goto L13
    L8:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public static void f(com.bytedance.ee.bear.more.office.c r100, com.bytedance.ee.bear.more.office.a r101, String r102) {
        StringBuilder r103 = new StringBuilder("move-to availability decision. ");
        StringBuilder r104 = new StringBuilder("actionId=");
        r104.append(du5.b.k(r100.f234687a));
        r104.append(", token=");
        String r105 = r100.f234692f.f227873d;
        if (r105 != null) goto L5;
        r105 = "";
    L5:
        r104.append(du5.b.k(r105));
        r104.append(", type=");
        r104.append(r100.f234692f.getType());
        r104.append(", realType=");
        r104.append(r100.f234692f.f227908y1);
        r104.append(", nodeTokenReady=");
        if (i(r100.f234692f).length() <= 0) goto L8;
        boolean r106 = true;
    L9:
        r104.append(r106);
        r104.append(", moreInfo=");
        r104.append(r100.f234693g.getClass().getSimpleName());
        r104.append(", moreType=");
        r104.append(r100.f234693g.getType());
        r104.append(", moreRealType=");
        r104.append(r100.f234693g.i());
        r104.append(", isShortcut=");
        r104.append(r100.f234693g.E());
        r103.append(r104.toString());
        r103.append(", result=");
        if (Intrinsics.areEqual(r101, com.bytedance.ee.bear.more.office.a.d.f234686a) == false) goto L13;
        String r107 = "Visible";
    L21:
        r103.append(r107);
        r103.append(", reason=");
        r103.append(r102);
        tt5.a.h("OfficeMoveToActionExecutor", r103.toString());
        return;
    L13:
        if (Intrinsics.areEqual(r101, com.bytedance.ee.bear.more.office.a.b.f234684a) == false) goto L16;
        r107 = "Hidden";
        goto L21
    L16:
        if ((r101 instanceof com.bytedance.ee.bear.more.office.a.c) == false) goto L19;
        r107 = "Loading";
        goto L21
    L19:
        if ((r101 instanceof com.bytedance.ee.bear.more.office.a.C3363a) == false) goto L24;
        r107 = "Disabled(reason=" + ((com.bytedance.ee.bear.more.office.a.C3363a) r101).f234683b + ')';
        goto L21
    L24:
        throw new NoWhenBranchMatchedException();
    L8:
        r106 = false;
        goto L9
    }

    public static void g(com.bytedance.ee.bear.more.office.c r110, Context r111, oj5.c r112) {
        if ((r112 instanceof oj5.a) == false) goto L5;
        oj5.a r113 = (oj5.a) r112;
    L6:
        boolean r100 = false;
        if (r113 == null) goto L17;
        DocPermission r114 = r113.f523538i;
        if (r114 == null) goto L17;
        IDocPublicPermission r115 = r114.f234420b;
        if (r115 == null) goto L17;
        if ((r115 instanceof DefaultDocPublicPermission) == false) goto L16;
        boolean r116 = true;
    L18:
        Document r101 = r110.f234692f;
        SpaceSelectorBean r102 = new SpaceSelectorBean();
        String r103 = r101.f227873d;
        String r104 = "";
        if (r103 != null) goto L21;
        r103 = "";
    L21:
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f229386b = r103;
        f228938a.getClass();
        String r105 = i(r101);
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r102.f229388d = r105;
        int r106 = r101.getType();
        sbb.e r107 = sbb.e.f541295f;
        if (r106 != r107.f541317b) goto L28;
        String r108 = r101.f227873d;
        if (r108 == null) goto L27;
        r104 = r108;
    L27:
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r102.f229388d = r104;
        r102.f229396l = r101.P1;
    L28:
        r102.f229387c = r110.f234693g.x();
        r102.f229385a = r101.getType();
        FolderVersion.a r109 = FolderVersion.Companion;
        Integer r117 = Integer.valueOf(r101.L1);
        r109.getClass();
        r102.f229391g = FolderVersion.a.c(r117);
        r102.f229394j = NodeType.isShortcut(r101.M1);
        r102.f229393i = r110.f234693g.isOwner();
        r102.f229392h = r116;
        String r118 = r110.f234694h;
        Intrinsics.checkNotNullParameter(r118, "<set-?>");
        r102.f229398n = r118;
        String r119 = r110.f234695i;
        Intrinsics.checkNotNullParameter(r119, "<set-?>");
        r102.f229397m = r119;
        SelectorConfig r120 = new SelectorConfig();
        r120.c(SelectorType.SPACE_MOVE_TO);
        if (r102.f229391g == true) goto L31;
    L35:
        boolean r121 = false;
    L36:
        if (r121 == true) goto L38;
    L45:
        SelectorScope r122 = SelectorScope.SPACE_ONLY;
    L46:
        r120.a(r122);
        r120.b(r111.getString(R.string.Doc_Facade_MoveTo));
        r120.f229372d = true;
        r120.f229375g = 1024;
        boolean r123 = r102.f229391g;
        if (r123 == true) goto L49;
        r120.f229373e = true;
    L49:
        if (r123 == false) goto L51;
    L54:
        boolean r124 = true;
    L55:
        r120.f229377i = r124;
        if (r110.f234692f.getType() == r107.f541317b) goto L58;
        r100 = true;
    L58:
        r120.f229378j = r100;
        SelectorConfig.a r125 = SelectorConfig.CREATOR;
        WeakReference<td5.a> r126 = new WeakReference(new w(r110.f234692f, r102, r111));
        r125.getClass();
        SelectorConfig.f229368k = r126;
        td5.f r127 = new td5.f();
        r127.f545516a = 2;
        r127.f545520e = 1024;
        Fragment r128 = r110.f234691e;
        com.bytedance.ee.bear.contract.route.parcelable.f r129 = (com.bytedance.ee.bear.contract.route.parcelable.f) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.f.class, null, null, 6);
        if (r128 == null) goto L61;
        r129.a(r128, r120, r127, r102, null);
        return;
    L61:
        r129.c(r111, r120, r127, r102, null);
        return;
    L51:
        if (r110.f234692f.getType() == r107.f541317b) goto L54;
        r124 = false;
        goto L55
    L38:
        if (d(r110.f234692f) == false) goto L45;
        Document r130 = r110.f234692f;
        int r131 = r130.getType();
        int r132 = r130.f227908y1;
        if (r132 <= 0) goto L43;
        r131 = r132;
    L43:
        if (sbb.g.b(r131) == true) goto L45;
        r122 = SelectorScope.ALL;
        goto L46
    L31:
        if (r102.f229385a == r107.f541317b) goto L35;
        if (r102.f229394j == true) goto L35;
        r121 = true;
        goto L36
    L16:
        r116 = r115.externalAccess();
    L17:
        r116 = false;
        goto L18
    L5:
        r113 = null;
        goto L6
    }
}
