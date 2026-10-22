package com.bytedance.ee.bear.list.office.longpress;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static final b a = null;
    public static final ConcurrentHashMap<String, CompositeDisposable> b = null;
    public static final ConcurrentHashMap<String, CompositeDisposable> c = null;
    public static final ConcurrentHashMap<String, WikNodePerm> d = null;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.list.office.longpress.b$a$a, reason: collision with other inner class name */
        public static final class C0026a extends a {
            public final String a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0026a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0026a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Disabled(tips=" + this.a + ')';
            }

            public C0026a(String r2) {
                Intrinsics.checkNotNullParameter(r2, "tips");
                this.a = r2;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.list.office.longpress.b$a$b, reason: collision with other inner class name */
        public static final class C0027b extends a {
            public static final C0027b a = null;

            static {
                a = new C0027b();
            }

            public C0027b() {
            }
        }

        public static final class c extends a {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        public static final class d extends a {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
            }
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.list.office.longpress.b$b, reason: collision with other inner class name */
    public static final class C0028b {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0028b) == true) goto L8;
            return false;
        L8:
            C0028b r6 = (C0028b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "WikiPermissionArgs(spaceId=" + this.a + ", wikiToken=" + this.b + ')';
        }

        public C0028b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "spaceId");
            Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.WIKI_TOKEN);
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c<T extends Result> implements NetService.c {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Result<WikNodePerm> parse(String r5) {
            Result<WikNodePerm> r0 = new Result();
            if (r5 != null) goto L5;
            String r3 = "";
        L6:
            JSONObject r1 = new JSONObject(r3).optJSONObject(WikiFolderPushPlugin.DATA);
            if (r5 != null) goto L9;
            r5 = "";
        L9:
            r0.code = new JSONObject(r5).optInt("code");
            WikNodePerm r6 = new WikNodePerm();
            boolean r2 = false;
            if (r1 == null) goto L12;
            boolean r4 = r1.optBoolean("can_add_shortcut");
        L13:
            r6.can_add_shortcut = r4;
            if (r1 == null) goto L16;
            r2 = r1.optBoolean("origin_can_add_shortcut");
        L16:
            r6.origin_can_add_shortcut = r2;
            r0.data = r6;
            return r0;
        L12:
            r4 = false;
            goto L13
        L5:
            r3 = r5;
            goto L6
        }
    }

    public static final class d<T, R> implements Function {
        public static final d<T, R> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final Object apply(Object r4) {
            Result r5 = (Result) r4;
            Intrinsics.checkNotNullParameter(r5, "result");
            WikNodePerm r0 = r5.data;
            if (r5.code != 0) goto L7;
            if (r0 == null) goto L7;
            return r0;
        L7:
            throw new IllegalStateException("fetch wiki shortcut permission failed. code=" + r5.code);
        }
    }

    public b() {
    }

    static {
        a = new b();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
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

    public static com.bytedance.ee.bear.more.office.d b(com.bytedance.ee.bear.more.office.c r5) {
        Intrinsics.checkNotNullParameter(r5, "request");
        a r0 = g(r5, false, null);
        if (Intrinsics.areEqual(r0, a.c.a) == false) goto L6;
        return com.bytedance.ee.bear.more.office.d.e.a;
    L6:
        if (Intrinsics.areEqual(r0, a.C0027b.a) == false) goto L9;
        return f(r5);
    L9:
        if (Intrinsics.areEqual(r0, a.d.a) == false) goto L22;
        Context r1 = a(r5);
        if (r1 != null) goto L13;
        r1 = eu5.b.a;
    L13:
        C0028b r2 = h(r5.g);
        if (r2 != null) goto L16;
        Toast.showFailureText(r1, com.bytedance.ee.bear.more.office.f.c());
    L29:
        return com.bytedance.ee.bear.more.office.d.f.a;
    L16:
        CompositeDisposable r3 = new CompositeDisposable();
        if (c.putIfAbsent(r5.a, r3) != null) goto L29;
        Toast.showLoading(r1, r1.getString(2131887769));
        r3.add(c(r2).subscribe(new com.bytedance.ee.bear.list.office.longpress.d(r5, r1), new e(r5, r1)));
        goto L29
    L22:
        if ((r0 instanceof a.C0026a) == false) goto L26;
        return new com.bytedance.ee.bear.more.office.d.b(((a.C0026a) r0).a);
    L26:
        throw new NoWhenBranchMatchedException();
    }

    public static Flowable c(C0028b r3) {
        NetService.f r0 = new NetService.f("/space/api/wiki/v2/perm/node/");
        ((NetService.e) r0).c = 2;
        r0.b("space_id", r3.a);
        r0.b("wiki_token", r3.b);
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(c.a).a(r0).map(d.a);
    }

    public static com.bytedance.ee.bear.more.office.d f(com.bytedance.ee.bear.more.office.c r12) {
        Context r1 = a(r12);
        if (r1 == null) goto L5;
        oj5.c r0 = r12.g;
        boolean r2 = oj5.e.a(r0);
        if (r2 == true) goto L9;
    L12:
        WikiSelectorBean r11 = null;
    L13:
        SpaceSelectorBean r10 = new SpaceSelectorBean();
        r10.a = r0.getType();
        r10.a(r0.getToken());
        r10.i = r0.isOwner();
        SelectorConfig r8 = new SelectorConfig();
        if (r2 == false) goto L16;
        SelectorType r3 = SelectorType.WIKI_SHORTCUT_TO;
    L17:
        r8.c(r3);
        r8.a(SelectorScope.ALL);
        r8.b(r1.getString(2131889880));
        r8.g = 3025;
        r8.d = true;
        r8.i = ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).B();
        FolderVersion.a r5 = FolderVersion.Companion;
        Integer r7 = Integer.valueOf(r0.C());
        r5.getClass();
        if (FolderVersion.a.c(r7) == true) goto L20;
        r8.e = true;
    L20:
        SelectorConfig.a r6 = SelectorConfig.CREATOR;
        WeakReference<td5.a> r9 = new WeakReference(new com.bytedance.ee.bear.list.office.longpress.c(r1));
        r6.getClass();
        SelectorConfig.k = r9;
        td5.f r13 = new td5.f();
        r13.a = 3;
        r13.e = 3025;
        r13.f = Boolean.valueOf(r0.m());
        r13.h = true;
        Activity r4 = r12.getActivity();
        if (r4 == null) goto L23;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).setActivity(r4);
    L23:
        r12.k.invoke();
        Fragment r14 = r12.e;
        com.bytedance.ee.bear.contract.route.parcelable.f r15 = (com.bytedance.ee.bear.contract.route.parcelable.f) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.f.class, null, null, 6);
        if (r14 == null) goto L26;
        r15.a(r14, r8, r13, r10, r11);
    L28:
        return com.bytedance.ee.bear.more.office.d.C0117d.a;
    L26:
        r15.c(r1, r8, r13, r10, r11);
        goto L28
    L16:
        r3 = SelectorType.SPACE_ADD_SHORTCUT;
        goto L17
    L9:
        if ((r0 instanceof oj5.f) == false) goto L12;
        WikiSelectorBean r16 = new WikiSelectorBean();
        oj5.f r17 = (oj5.f) r0;
        r16.i = r17.c;
        r16.j = r17.getType();
        r16.d = r17.O;
        r16.l = r17.p;
        r16.a = "";
        r16.o = r17.isOwner();
        r11 = r16;
        goto L13
    L5:
        return new com.bytedance.ee.bear.more.office.d.b(com.bytedance.ee.bear.more.office.f.c());
    }

    public static C0028b h(oj5.c r4) {
        if ((r4 instanceof oj5.f) == false) goto L5;
        oj5.f r5 = (oj5.f) r4;
    L6:
        if (r5 != null) goto L8;
        return null;
    L8:
        oj5.d r0 = r5.H;
        if (r0 == null) goto L11;
        String r1 = r0.d();
    L12:
        if (r1 != null) goto L14;
        r1 = "";
    L14:
        String r6 = r5.O;
        if (StringsKt.isBlank(r1) == false) goto L17;
    L21:
        StringBuilder r2 = new StringBuilder("missing wiki shortcut permission args. hasSpaceId=");
        r2.append(!StringsKt.isBlank(r1));
        r2.append(", hasWikiToken=");
        r2.append(!StringsKt.isBlank(r6));
        tt5.a.h("OfficeAddShortcutAction", r2.toString());
        return null;
    L17:
        if (StringsKt.isBlank(r6) == true) goto L21;
        return new C0028b(r1, r6);
    L11:
        r1 = null;
        goto L12
    L5:
        r5 = null;
        goto L6
    }

    public static com.bytedance.ee.bear.more.office.a d(com.bytedance.ee.bear.more.office.c r2, com.bytedance.ee.bear.office.list.adapter.p r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        a r4 = g(r2, true, r3);
        if (Intrinsics.areEqual(r4, a.C0027b.a) == false) goto L6;
        return com.bytedance.ee.bear.more.office.a.d.a;
    L6:
        if (Intrinsics.areEqual(r4, a.c.a) == false) goto L9;
        return com.bytedance.ee.bear.more.office.a.b.a;
    L9:
        if (Intrinsics.areEqual(r4, a.d.a) == false) goto L12;
        return new com.bytedance.ee.bear.more.office.a.c(com.bytedance.ee.bear.more.office.f.b());
    L12:
        if ((r4 instanceof a.C0026a) == false) goto L16;
        return new com.bytedance.ee.bear.more.office.a.C0116a(((a.C0026a) r4).a, null, 2);
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public static void e(com.bytedance.ee.bear.more.office.c r5, a r6, String r7) {
        StringBuilder r0 = new StringBuilder("add-shortcut availability decision. ");
        StringBuilder r1 = new StringBuilder("actionId=");
        r1.append(du5.b.k(r5.a));
        r1.append(", token=");
        oj5.c r2 = r5.g;
        String r4 = null;
        if ((r2 instanceof oj5.a) == false) goto L5;
        oj5.a r3 = (oj5.a) r2;
    L6:
        if (r3 == null) goto L8;
        r4 = r3.c;
    L8:
        String r8 = "";
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        if (r4.length() != 0) goto L14;
        boolean r9 = true;
    L15:
        if (r9 == false) goto L21;
        String r10 = r5.f.d;
        if (r10 == null) goto L20;
        r8 = r10;
    L20:
        r4 = r8;
    L21:
        r1.append(du5.b.k(r4));
        r1.append(", type=");
        r1.append(r5.g.getType());
        r1.append(", realType=");
        r1.append(r5.g.i());
        r1.append(", moreInfo=");
        r1.append(r5.g.getClass().getSimpleName());
        r1.append(", isShortcut=");
        r1.append(r5.g.E());
        r0.append(r1.toString());
        r0.append(", decision=");
        if (Intrinsics.areEqual(r6, a.C0027b.a) == false) goto L25;
        String r11 = "Enabled";
    L33:
        r0.append(r11);
        r0.append(", reason=");
        r0.append(r7);
        tt5.a.h("OfficeAddShortcutAction", r0.toString());
        return;
    L25:
        if (Intrinsics.areEqual(r6, a.c.a) == false) goto L28;
        r11 = "Hidden";
        goto L33
    L28:
        if (Intrinsics.areEqual(r6, a.d.a) == false) goto L31;
        r11 = "WikiPermissionLoading";
        goto L33
    L31:
        if ((r6 instanceof a.C0026a) == false) goto L36;
        r11 = "Disabled";
        goto L33
    L36:
        throw new NoWhenBranchMatchedException();
    L14:
        r9 = false;
        goto L15
    L5:
        r3 = null;
        goto L6
    }

    public static a g(com.bytedance.ee.bear.more.office.c r10, boolean r11, com.bytedance.ee.bear.office.list.adapter.p r12) {
        Context r0 = a(r10);
        if (r0 != null) goto L6;
        a.C0026a r13 = new a.C0026a(com.bytedance.ee.bear.more.office.f.c());
        e(r10, r13, "missing_context");
        return r13;
    L6:
        oj5.c r1 = r10.g;
        Integer r2 = r1.A();
        boolean r3 = true;
        oj5.a r6 = null;
        if (r2 == null) goto L19;
        int r4 = r2.intValue();
        if (r1.getType() == sbb.e.f.b) goto L19;
        FolderVersion.a r7 = FolderVersion.Companion;
        Integer r5 = Integer.valueOf(r4);
        r7.getClass();
        if (FolderVersion.a.c(r5) == false) goto L19;
        if (com.bytedance.ee.bear.more.q.b(r1) == true) goto L19;
        if (((ww4.a) org.koin.java.a.c(ww4.a.class, null, null, 6)).a().d().a == false) goto L19;
        if (r1.w() == true) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == true) goto L42;
        a.c r14 = a.c.a;
        Integer r15 = r1.A();
        if (r15 != null) goto L25;
        String r16 = "owner_type_missing";
    L40:
        e(r10, r14, r16);
        return r14;
    L25:
        if (r1.getType() != sbb.e.f.b) goto L27;
        r16 = "folder_not_supported";
        goto L40
    L27:
        FolderVersion.Companion.getClass();
        if (FolderVersion.a.c(r15) == true) goto L31;
        r16 = "not_share_folder_v2";
        goto L40
    L31:
        if (com.bytedance.ee.bear.more.q.b(r1) == false) goto L34;
        r16 = "phoenix_not_supported";
        goto L40
    L34:
        if (((ww4.a) org.koin.java.a.c(ww4.a.class, null, null, 6)).a().d().a == true) goto L37;
        r16 = "lean_mode_folder_disabled";
        goto L40
    L37:
        if (r1.w() == false) goto L39;
        r16 = "origin_deleted";
        goto L40
    L39:
        r16 = "visibility_unknown";
        goto L40
    L42:
        com.bytedance.ee.bear.contract.j r9 = com.bytedance.ee.bear.contract.j.a.a;
        if (r9.getNetworkState().a() == true) goto L47;
        a.C0026a r17 = new a.C0026a(r0.getString(2131887951));
        e(r10, r17, "network_disconnected");
        return r17;
    L47:
        if ((r1 instanceof oj5.f) == true) goto L89;
        boolean r18 = r1 instanceof oj5.a;
        if (r18 == false) goto L51;
        oj5.a r19 = (oj5.a) r1;
    L52:
        if (r19 != null) goto L54;
    L56:
        boolean r20 = false;
    L57:
        if (r20 == true) goto L59;
    L64:
        boolean r110 = r9.getNetworkState().a();
    L65:
        if (r110 == false) goto L67;
        a.C0027b r111 = a.C0027b.a;
        e(r10, r111, "space_shortcut_checks_passed");
        return r111;
    L67:
        a.C0026a r112 = new a.C0026a(r0.getString(2131887803));
        if (r18 == false) goto L70;
        r6 = (oj5.a) r1;
    L70:
        if (r6 != null) goto L72;
    L74:
        boolean r113 = false;
    L75:
        if (r113 == true) goto L77;
    L79:
        if (r6 != null) goto L81;
    L83:
        r3 = false;
    L84:
        if (r3 == false) goto L86;
        String r114 = "shortcut_operation_view_denied";
    L87:
        e(r10, r112, r114);
        return r112;
    L86:
        r114 = "space_shortcut_disabled";
        goto L87
    L81:
        if (r6.p != true) goto L83;
    L77:
        if (r6.q == false) goto L79;
        r114 = "shortcut_origin_deleted";
        goto L87
    L72:
        if (r6.p != true) goto L74;
        r113 = true;
        goto L75
    L59:
        if (r19.q == false) goto L62;
    L63:
        r110 = false;
        goto L65
    L62:
        if (Intrinsics.areEqual(((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).v(r19, r19.i.a, "VIEW"), Boolean.TRUE) == true) goto L64;
    L54:
        if (r19.p != true) goto L56;
        r20 = true;
        goto L57
    L51:
        r19 = null;
        goto L52
    L89:
        WikNodePerm r21 = d.get(r10.a);
        if (r21 != null) goto L92;
        C0028b r22 = h(r1);
        if (r22 != null) goto L105;
        a.C0026a r115 = new a.C0026a(r0.getString(2131887803));
        e(r10, r115, "wiki_permission_args_missing");
        return r115;
    L105:
        if (r11 == false) goto L110;
        CompositeDisposable r116 = new CompositeDisposable();
        if (b.putIfAbsent(r10.a, r116) != null) goto L110;
        r116.add(c(r22).subscribe(new f(r10, r12), new g(r10, r12)));
    L110:
        a.d r117 = a.d.a;
        e(r10, r117, "wiki_permission_prefetching");
        return r117;
    L92:
        if (r21.getOriginCanShortcut(r1.E()) == false) goto L94;
        a r118 = a.C0027b.a;
    L96:
        if (r21.getOriginCanShortcut(r1.E()) == false) goto L98;
        String r119 = "wiki_permission_allow";
    L99:
        e(r10, r118, r119);
        return r118;
    L98:
        r119 = "wiki_permission_denied";
        goto L99
    L94:
        r118 = new a.C0026a(r0.getString(2131887803));
    L19:
        r8 = false;
        goto L20
    }
}
