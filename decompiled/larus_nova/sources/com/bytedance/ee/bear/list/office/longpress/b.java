package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import com.larus.nova.R;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f228926a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, CompositeDisposable> f228927b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, CompositeDisposable> f228928c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, WikNodePerm> f228929d = null;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.list.office.longpress.b$a$a, reason: collision with other inner class name */
        public static final class C3273a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f228930a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C3273a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f228930a, ((C3273a) r100).f228930a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f228930a.hashCode();
            }

            public final String toString() {
                return "Disabled(tips=" + this.f228930a + ')';
            }

            public C3273a(String r100) {
                Intrinsics.checkNotNullParameter(r100, "tips");
                this.f228930a = r100;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.list.office.longpress.b$a$b, reason: collision with other inner class name */
        public static final class C3274b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C3274b f228931a = null;

            static {
                f228931a = new C3274b();
            }

            public C3274b() {
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f228932a = null;

            static {
                f228932a = new c();
            }

            public c() {
            }
        }

        public static final class d extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f228933a = null;

            static {
                f228933a = new d();
            }

            public d() {
            }
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.list.office.longpress.b$b, reason: collision with other inner class name */
    public static final class C3275b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f228934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f228935b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C3275b) == true) goto L8;
            return false;
        L8:
            C3275b r101 = (C3275b) r100;
            if (Intrinsics.areEqual(this.f228934a, r101.f228934a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f228935b, r101.f228935b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f228934a.hashCode() * 31) + this.f228935b.hashCode();
        }

        public final String toString() {
            return "WikiPermissionArgs(spaceId=" + this.f228934a + ", wikiToken=" + this.f228935b + ')';
        }

        public C3275b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "spaceId");
            Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.WIKI_TOKEN);
            this.f228934a = r100;
            this.f228935b = r101;
        }
    }

    public static final class c<T extends Result> implements NetService.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f228936a = null;

        static {
            f228936a = new c();
        }

        public c() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<WikNodePerm> parse(String r100) {
            Result<WikNodePerm> r101 = new Result();
            if (r100 != null) goto L5;
            String r102 = "";
        L6:
            JSONObject r103 = new JSONObject(r102).optJSONObject("data");
            if (r100 != null) goto L9;
            r100 = "";
        L9:
            r101.code = new JSONObject(r100).optInt("code");
            WikNodePerm r104 = new WikNodePerm();
            boolean r105 = false;
            if (r103 == null) goto L12;
            boolean r106 = r103.optBoolean("can_add_shortcut");
        L13:
            r104.can_add_shortcut = r106;
            if (r103 == null) goto L16;
            r105 = r103.optBoolean("origin_can_add_shortcut");
        L16:
            r104.origin_can_add_shortcut = r105;
            r101.data = r104;
            return r101;
        L12:
            r106 = false;
            goto L13
        L5:
            r102 = r100;
            goto L6
        }
    }

    public static final class d<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T, R> f228937a = null;

        static {
            f228937a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Result r101 = (Result) r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            WikNodePerm r102 = (WikNodePerm) r101.data;
            if (r101.code != 0) goto L7;
            if (r102 == null) goto L7;
            return r102;
        L7:
            throw new IllegalStateException("fetch wiki shortcut permission failed. code=" + r101.code);
        }
    }

    public b() {
    }

    static {
        f228926a = new b();
        f228927b = new ConcurrentHashMap();
        f228928c = new ConcurrentHashMap();
        f228929d = new ConcurrentHashMap();
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

    public static com.bytedance.ee.bear.more.office.d b(com.bytedance.ee.bear.more.office.c r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        a r101 = g(r100, false, null);
        if (Intrinsics.areEqual(r101, a.c.f228932a) == false) goto L6;
        return com.bytedance.ee.bear.more.office.d.e.f234703a;
    L6:
        if (Intrinsics.areEqual(r101, a.C3274b.f228931a) == false) goto L9;
        return f(r100);
    L9:
        if (Intrinsics.areEqual(r101, a.d.f228933a) == false) goto L22;
        Context r102 = a(r100);
        if (r102 != null) goto L13;
        r102 = eu5.b.f474075a;
    L13:
        C3275b r103 = h(r100.f234693g);
        if (r103 != null) goto L16;
        Toast.showFailureText(r102, com.bytedance.ee.bear.more.office.f.c());
    L29:
        return com.bytedance.ee.bear.more.office.d.f.f234704a;
    L16:
        CompositeDisposable r104 = new CompositeDisposable();
        if (f228928c.putIfAbsent(r100.f234687a, r104) != null) goto L29;
        Toast.showLoading(r102, r102.getString(R.string.Doc_Facade_Loading));
        r104.add(c(r103).subscribe(new com.bytedance.ee.bear.list.office.longpress.d(r100, r102), new e(r100, r102)));
        goto L29
    L22:
        if ((r101 instanceof a.C3273a) == false) goto L26;
        return new com.bytedance.ee.bear.more.office.d.b(((a.C3273a) r101).f228930a);
    L26:
        throw new NoWhenBranchMatchedException();
    }

    public static Flowable c(C3275b r100) {
        NetService.f r101 = new NetService.f("/space/api/wiki/v2/perm/node/");
        r101.f216906c = 2;
        r101.b(DocViewModel.EXTRA_SPACE_ID, r100.f228934a);
        r101.b("wiki_token", r100.f228935b);
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(c.f228936a).a(r101).map(d.f228937a);
    }

    public static com.bytedance.ee.bear.more.office.d f(com.bytedance.ee.bear.more.office.c r110) {
        Context r100 = a(r110);
        if (r100 == null) goto L5;
        oj5.c r101 = r110.f234693g;
        boolean r102 = oj5.e.a(r101);
        if (r102 == true) goto L9;
    L12:
        WikiSelectorBean r111 = null;
    L13:
        SpaceSelectorBean r112 = new SpaceSelectorBean();
        r112.f229385a = r101.getType();
        r112.a(r101.getToken());
        r112.f229393i = r101.isOwner();
        SelectorConfig r103 = new SelectorConfig();
        if (r102 == false) goto L16;
        SelectorType r104 = SelectorType.WIKI_SHORTCUT_TO;
    L17:
        r103.c(r104);
        r103.a(SelectorScope.ALL);
        r103.b(r100.getString(R.string.LarkCCM_Workspace_Menu_AddShortcutTo));
        r103.f229375g = 3025;
        r103.f229372d = true;
        r103.f229377i = ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).B();
        FolderVersion.a r105 = FolderVersion.Companion;
        Integer r106 = Integer.valueOf(r101.C());
        r105.getClass();
        if (FolderVersion.a.c(r106) == true) goto L20;
        r103.f229373e = true;
    L20:
        SelectorConfig.a r107 = SelectorConfig.CREATOR;
        WeakReference<td5.a> r108 = new WeakReference(new com.bytedance.ee.bear.list.office.longpress.c(r100));
        r107.getClass();
        SelectorConfig.f229368k = r108;
        td5.f r109 = new td5.f();
        r109.f545516a = 3;
        r109.f545520e = 3025;
        r109.f545521f = Boolean.valueOf(r101.m());
        r109.f545523h = true;
        FragmentActivity r113 = r110.getActivity();
        if (r113 == null) goto L23;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).setActivity(r113);
    L23:
        r110.f234697k.invoke();
        Fragment r114 = r110.f234691e;
        com.bytedance.ee.bear.contract.route.parcelable.f r115 = (com.bytedance.ee.bear.contract.route.parcelable.f) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.f.class, null, null, 6);
        if (r114 == null) goto L26;
        r115.a(r114, r103, r109, r112, r111);
    L28:
        return com.bytedance.ee.bear.more.office.d.C3364d.f234702a;
    L26:
        r115.c(r100, r103, r109, r112, r111);
        goto L28
    L16:
        r104 = SelectorType.SPACE_ADD_SHORTCUT;
        goto L17
    L9:
        if ((r101 instanceof oj5.f) == false) goto L12;
        WikiSelectorBean r116 = new WikiSelectorBean();
        oj5.f r117 = (oj5.f) r101;
        r116.f241136i = r117.f523532c;
        r116.f241137j = r117.getType();
        r116.f241131d = r117.O;
        r116.f241139l = r117.f523545p;
        r116.f241128a = "";
        r116.f241142o = r117.isOwner();
        r111 = r116;
        goto L13
    L5:
        return new com.bytedance.ee.bear.more.office.d.b(com.bytedance.ee.bear.more.office.f.c());
    }

    public static C3275b h(oj5.c r100) {
        if ((r100 instanceof oj5.f) == false) goto L5;
        oj5.f r101 = (oj5.f) r100;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        oj5.d r102 = r101.H;
        if (r102 == null) goto L11;
        String r103 = r102.d();
    L12:
        if (r103 != null) goto L14;
        r103 = "";
    L14:
        String r104 = r101.O;
        if (StringsKt.isBlank(r103) == false) goto L17;
    L21:
        StringBuilder r105 = new StringBuilder("missing wiki shortcut permission args. hasSpaceId=");
        r105.append(!StringsKt.isBlank(r103));
        r105.append(", hasWikiToken=");
        r105.append(!StringsKt.isBlank(r104));
        tt5.a.h("OfficeAddShortcutAction", r105.toString());
        return null;
    L17:
        if (StringsKt.isBlank(r104) == true) goto L21;
        return new C3275b(r103, r104);
    L11:
        r103 = null;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    public static com.bytedance.ee.bear.more.office.a d(com.bytedance.ee.bear.more.office.c r100, com.bytedance.ee.bear.office.list.adapter.p r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        a r102 = g(r100, true, r101);
        if (Intrinsics.areEqual(r102, a.C3274b.f228931a) == false) goto L6;
        return com.bytedance.ee.bear.more.office.a.d.f234686a;
    L6:
        if (Intrinsics.areEqual(r102, a.c.f228932a) == false) goto L9;
        return com.bytedance.ee.bear.more.office.a.b.f234684a;
    L9:
        if (Intrinsics.areEqual(r102, a.d.f228933a) == false) goto L12;
        return new com.bytedance.ee.bear.more.office.a.c(com.bytedance.ee.bear.more.office.f.b());
    L12:
        if ((r102 instanceof a.C3273a) == false) goto L16;
        return new com.bytedance.ee.bear.more.office.a.C3363a(((a.C3273a) r102).f228930a, null, 2);
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public static void e(com.bytedance.ee.bear.more.office.c r100, a r101, String r102) {
        StringBuilder r103 = new StringBuilder("add-shortcut availability decision. ");
        StringBuilder r104 = new StringBuilder("actionId=");
        r104.append(du5.b.k(r100.f234687a));
        r104.append(", token=");
        oj5.c r105 = r100.f234693g;
        String r106 = null;
        if ((r105 instanceof oj5.a) == false) goto L5;
        oj5.a r107 = (oj5.a) r105;
    L6:
        if (r107 == null) goto L8;
        r106 = r107.f523532c;
    L8:
        String r108 = "";
        if (r106 != null) goto L12;
        r106 = "";
    L12:
        if (r106.length() != 0) goto L14;
        boolean r109 = true;
    L15:
        if (r109 == false) goto L21;
        String r110 = r100.f234692f.f227873d;
        if (r110 == null) goto L20;
        r108 = r110;
    L20:
        r106 = r108;
    L21:
        r104.append(du5.b.k(r106));
        r104.append(", type=");
        r104.append(r100.f234693g.getType());
        r104.append(", realType=");
        r104.append(r100.f234693g.i());
        r104.append(", moreInfo=");
        r104.append(r100.f234693g.getClass().getSimpleName());
        r104.append(", isShortcut=");
        r104.append(r100.f234693g.E());
        r103.append(r104.toString());
        r103.append(", decision=");
        if (Intrinsics.areEqual(r101, a.C3274b.f228931a) == false) goto L25;
        String r111 = "Enabled";
    L33:
        r103.append(r111);
        r103.append(", reason=");
        r103.append(r102);
        tt5.a.h("OfficeAddShortcutAction", r103.toString());
        return;
    L25:
        if (Intrinsics.areEqual(r101, a.c.f228932a) == false) goto L28;
        r111 = "Hidden";
        goto L33
    L28:
        if (Intrinsics.areEqual(r101, a.d.f228933a) == false) goto L31;
        r111 = "WikiPermissionLoading";
        goto L33
    L31:
        if ((r101 instanceof a.C3273a) == false) goto L36;
        r111 = "Disabled";
        goto L33
    L36:
        throw new NoWhenBranchMatchedException();
    L14:
        r109 = false;
        goto L15
    L5:
        r107 = null;
        goto L6
    }

    public static a g(com.bytedance.ee.bear.more.office.c r110, boolean r111, com.bytedance.ee.bear.office.list.adapter.p r112) {
        Context r100 = a(r110);
        if (r100 != null) goto L6;
        a.C3273a r113 = new a.C3273a(com.bytedance.ee.bear.more.office.f.c());
        e(r110, r113, "missing_context");
        return r113;
    L6:
        oj5.c r101 = r110.f234693g;
        Integer r102 = r101.A();
        boolean r103 = true;
        oj5.a r104 = null;
        if (r102 == null) goto L19;
        int r105 = r102.intValue();
        if (r101.getType() == sbb.e.f541295f.f541317b) goto L19;
        FolderVersion.a r106 = FolderVersion.Companion;
        Integer r107 = Integer.valueOf(r105);
        r106.getClass();
        if (FolderVersion.a.c(r107) == false) goto L19;
        if (com.bytedance.ee.bear.more.q.b(r101) == true) goto L19;
        if (((ww4.a) org.koin.java.a.c(ww4.a.class, null, null, 6)).a().d().f217118a == false) goto L19;
        if (r101.w() == true) goto L19;
        boolean r108 = true;
    L20:
        if (r108 == true) goto L42;
        a.c r114 = a.c.f228932a;
        Integer r115 = r101.A();
        if (r115 != null) goto L25;
        String r116 = "owner_type_missing";
    L40:
        e(r110, r114, r116);
        return r114;
    L25:
        if (r101.getType() != sbb.e.f541295f.f541317b) goto L27;
        r116 = "folder_not_supported";
        goto L40
    L27:
        FolderVersion.Companion.getClass();
        if (FolderVersion.a.c(r115) == true) goto L31;
        r116 = "not_share_folder_v2";
        goto L40
    L31:
        if (com.bytedance.ee.bear.more.q.b(r101) == false) goto L34;
        r116 = "phoenix_not_supported";
        goto L40
    L34:
        if (((ww4.a) org.koin.java.a.c(ww4.a.class, null, null, 6)).a().d().f217118a == true) goto L37;
        r116 = "lean_mode_folder_disabled";
        goto L40
    L37:
        if (r101.w() == false) goto L39;
        r116 = "origin_deleted";
        goto L40
    L39:
        r116 = "visibility_unknown";
        goto L40
    L42:
        com.bytedance.ee.bear.contract.j r109 = com.bytedance.ee.bear.contract.j.a.f217090a;
        if (r109.getNetworkState().a() == true) goto L47;
        a.C3273a r117 = new a.C3273a(r100.getString(R.string.Doc_List_OperateFailedNoNet));
        e(r110, r117, "network_disconnected");
        return r117;
    L47:
        if ((r101 instanceof oj5.f) == true) goto L89;
        boolean r118 = r101 instanceof oj5.a;
        if (r118 == false) goto L51;
        oj5.a r119 = (oj5.a) r101;
    L52:
        if (r119 != null) goto L54;
    L56:
        boolean r120 = false;
    L57:
        if (r120 == true) goto L59;
    L64:
        boolean r121 = r109.getNetworkState().a();
    L65:
        if (r121 == false) goto L67;
        a.C3274b r122 = a.C3274b.f228931a;
        e(r110, r122, "space_shortcut_checks_passed");
        return r122;
    L67:
        a.C3273a r123 = new a.C3273a(r100.getString(R.string.Doc_Facade_OperateFailedNoPermission));
        if (r118 == false) goto L70;
        r104 = (oj5.a) r101;
    L70:
        if (r104 != null) goto L72;
    L74:
        boolean r124 = false;
    L75:
        if (r124 == true) goto L77;
    L79:
        if (r104 != null) goto L81;
    L83:
        r103 = false;
    L84:
        if (r103 == false) goto L86;
        String r125 = "shortcut_operation_view_denied";
    L87:
        e(r110, r123, r125);
        return r123;
    L86:
        r125 = "space_shortcut_disabled";
        goto L87
    L81:
        if (r104.f523545p != true) goto L83;
    L77:
        if (r104.f523546q == false) goto L79;
        r125 = "shortcut_origin_deleted";
        goto L87
    L72:
        if (r104.f523545p != true) goto L74;
        r124 = true;
        goto L75
    L59:
        if (r119.f523546q == false) goto L62;
    L63:
        r121 = false;
        goto L65
    L62:
        if (Intrinsics.areEqual(((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).v(r119, r119.f523538i.f234419a, "VIEW"), Boolean.TRUE) == true) goto L64;
    L54:
        if (r119.f523545p != true) goto L56;
        r120 = true;
        goto L57
    L51:
        r119 = null;
        goto L52
    L89:
        WikNodePerm r126 = f228929d.get(r110.f234687a);
        if (r126 != null) goto L92;
        C3275b r127 = h(r101);
        if (r127 != null) goto L105;
        a.C3273a r128 = new a.C3273a(r100.getString(R.string.Doc_Facade_OperateFailedNoPermission));
        e(r110, r128, "wiki_permission_args_missing");
        return r128;
    L105:
        if (r111 == false) goto L110;
        CompositeDisposable r129 = new CompositeDisposable();
        if (f228927b.putIfAbsent(r110.f234687a, r129) != null) goto L110;
        r129.add(c(r127).subscribe(new f(r110, r112), new g(r110, r112)));
    L110:
        a.d r130 = a.d.f228933a;
        e(r110, r130, "wiki_permission_prefetching");
        return r130;
    L92:
        if (r126.getOriginCanShortcut(r101.E()) == false) goto L94;
        a r131 = a.C3274b.f228931a;
    L96:
        if (r126.getOriginCanShortcut(r101.E()) == false) goto L98;
        String r132 = "wiki_permission_allow";
    L99:
        e(r110, r131, r132);
        return r131;
    L98:
        r132 = "wiki_permission_denied";
        goto L99
    L94:
        r131 = new a.C3273a(r100.getString(R.string.Doc_Facade_OperateFailedNoPermission));
    L19:
        r108 = false;
        goto L20
    }
}
