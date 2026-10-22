package com.bytedance.ee.bear.list.office.longpress;

import android.app.Application;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DefaultDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g0 {
    public static final g0 a = null;
    public static final ConcurrentHashMap<String, CompositeDisposable> b = null;
    public static final ConcurrentHashMap<String, CompositeDisposable> c = null;
    public static final ConcurrentHashMap.KeySetView<String, Boolean> d = null;

    public static final class a {
        public final String a;
        public final int b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "SecretTokenArgs(token=" + this.a + ", type=" + this.b + ", wikiToken=" + this.c + ')';
        }

        public final int getType() {
            return this.b;
        }

        public a(String r2, int r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r4, WikiFolderPushPlugin.WIKI_TOKEN);
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ oj5.a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FragmentActivity c;
        public final /* synthetic */ Fragment d;
        public final /* synthetic */ a e;

        public b(oj5.a r1, String r2, FragmentActivity r3, Fragment r4, a r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r5) {
            DocPermission r6 = (DocPermission) r5;
            oj5.a r0 = this.a;
            Intrinsics.checkNotNull(r6);
            r0.getClass();
            Intrinsics.checkNotNullParameter(r6, "docPermission");
            r0.i = r6;
            boolean r7 = g0.a(g0.a, this.b, this.c, this.d);
            tt5.a.h("OfficeSecretSettingActionExecutor", "fetch doc permission success. actionId=" + this.b + ", type=" + this.e.getType() + ", actionAlive=" + r7);
            if (r7 == false) goto L5;
            g0.g(this.b, this.c, this.d, this.e, this.a);
            return;
        L5:
            tt5.a.h("OfficeSecretSettingActionExecutor", "skip continue because action is not alive after permission. actionId=" + this.b);
            g0.p(this.b);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ FragmentActivity b;
        public final /* synthetic */ Fragment c;

        public c(String r1, FragmentActivity r2, Fragment r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            tt5.a.e("OfficeSecretSettingActionExecutor", "fetch doc permission failed.", (Throwable) r4, false);
            if (g0.a(g0.a, this.a, this.b, this.c) == false) goto L5;
            Toast.showFailureText(this.b, 2131887384);
        L5:
            g0.p(this.a);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ oj5.a b;
        public final /* synthetic */ com.bytedance.ee.bear.more.office.b c;
        public final /* synthetic */ com.bytedance.ee.bear.more.office.c d;
        public final /* synthetic */ a e;

        public d(String r1, oj5.a r2, com.bytedance.ee.bear.more.office.b r3, com.bytedance.ee.bear.more.office.c r4, a r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r7) {
            DocMetaInfo r8 = (DocMetaInfo) r7;
            if (g0.c.containsKey(this.a) == false) goto L8;
            oj5.a r0 = this.b;
            Intrinsics.checkNotNull(r8);
            r0.getClass();
            Intrinsics.checkNotNullParameter(r8, "docMetaInfo");
            r0.g = r8;
            com.bytedance.ee.bear.more.office.b r1 = this.c;
            if (r1 == null) goto L7;
            com.bytedance.ee.bear.more.office.c r2 = this.d;
            String r3 = r2.a;
            OfficeLongPressLarkAction r4 = r2.b;
            String r5 = r2.c;
            g0.a.getClass();
            r1.a(r3, r4, r5, g0.j(r2, null));
        L7:
            tt5.a.h("OfficeSecretSettingActionExecutor", "prefetch secret meta success. actionId=" + this.a + ", type=" + this.e.getType() + ", visibleSecList=" + r8.isVisibleSecList());
        L8:
            g0 r9 = g0.a;
            String r6 = this.a;
            r9.getClass();
            g0.e(r6);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ com.bytedance.ee.bear.more.office.b b;
        public final /* synthetic */ com.bytedance.ee.bear.more.office.c c;

        public e(String r1, com.bytedance.ee.bear.more.office.b r2, com.bytedance.ee.bear.more.office.c r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r8) {
            tt5.a.e("OfficeSecretSettingActionExecutor", "prefetch secret meta failed. actionId=" + this.a, (Throwable) r8, false);
            com.bytedance.ee.bear.more.office.b r9 = this.b;
            if (r9 == null) goto L10;
            com.bytedance.ee.bear.more.office.c r0 = this.c;
            String r1 = r0.a;
            OfficeLongPressLarkAction r2 = r0.b;
            String r3 = r0.c;
            g0.a.getClass();
            Context r4 = g0.f(r0);
            if (r4 == null) goto L8;
            String r5 = r4.getString(2131887802);
            if (r5 == null) goto L8;
        L9:
            r9.a(r1, r2, r3, new com.bytedance.ee.bear.more.office.a.C0116a(r5, null, 2));
        L8:
            r5 = com.bytedance.ee.bear.more.office.f.a();
        L10:
            g0 r10 = g0.a;
            String r6 = this.a;
            r10.getClass();
            g0.e(r6);
        }
    }

    public g0() {
    }

    static {
        a = new g0();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = ConcurrentHashMap.newKeySet();
    }

    public static void d(String r1) {
        CompositeDisposable r2 = b.remove(r1);
        if (r2 == null) goto L6;
        r2.clear();
        return;
    }

    public static void e(String r1) {
        CompositeDisposable r2 = c.remove(r1);
        if (r2 == null) goto L6;
        r2.clear();
        return;
    }

    public static Context f(com.bytedance.ee.bear.more.office.c r1) {
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

    public static com.bytedance.ee.bear.more.office.d h(com.bytedance.ee.bear.more.office.c r6) {
        Intrinsics.checkNotNullParameter(r6, "request");
        FragmentActivity r0 = r6.getActivity();
        if (r0 == null) goto L5;
        oj5.c r1 = r6.g;
        if ((r1 instanceof oj5.a) == false) goto L9;
        oj5.a r2 = (oj5.a) r1;
    L10:
        if (r2 != null) goto L14;
        return com.bytedance.ee.bear.more.office.d.e.a;
    L14:
        if (m(r2) == false) goto L16;
        a r3 = q(r2);
        ConcurrentHashMap<String, CompositeDisposable> r4 = b;
        String r5 = r6.a;
        if (r4.get(r5) != null) goto L20;
        r4.putIfAbsent(r5, new CompositeDisposable());
    L20:
        String r7 = r6.a;
        d.add(r7);
        Toast.showLoading(r0, r0.getString(2131887769));
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L27
        if ((r2.i.a instanceof DefaultDocUserPermission) == false) goto L24;
        i(r6.a, r0, r6.e, r3, r2);     // Catch: Throwable -> L27
    L25:
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L32;
        g0 r11 = a;
        String r12 = r6.a;
        r11.getClass();
        p(r12);
        throw r10;
    L32:
        return com.bytedance.ee.bear.more.office.d.C0117d.a;
    L24:
        g(r6.a, r0, r6.e, r3, r2);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L16:
        return com.bytedance.ee.bear.more.office.d.e.a;
    L9:
        r2 = null;
        goto L10
    L5:
        return new com.bytedance.ee.bear.more.office.d.b(com.bytedance.ee.bear.more.office.f.c());
    }

    public static void k(String r1) {
        if (d.remove(r1) == false) goto L6;
        Toast.cancelLoading();
        return;
    }

    public static boolean l(DocMetaInfo r1) {
        if (r1.isGetSecSuccess() == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.isVisibleSecList() == true) goto L7;
        return true;
    }

    public static boolean m(oj5.a r5) {
        if (r5.getType() != sbb.e.n.b) goto L5;
        boolean r0 = fj5.a.b(r5.i());
    L6:
        DocMetaInfo r6 = r5.g;
        if (r6.getGetSecLabelCode() != (-1)) goto L9;
    L14:
        boolean r7 = true;
    L15:
        if (r0 == false) goto L18;
        if (r7 == false) goto L18;
        return true;
    L18:
        return false;
    L9:
        if (l(r6) == true) goto L14;
        if (r6.isVisibleSecList() == true) goto L14;
        r7 = false;
        goto L15
    L5:
        r0 = fj5.a.c(r5.getType(), r5.j.isDocV2());
        goto L6
    }

    public static void p(String r1) {
        Intrinsics.checkNotNullParameter(r1, "actionId");
        d(r1);
        e(r1);
        k(r1);
    }

    public static a q(oj5.a r5) {
        String r0 = r5.c;
        int r1 = r5.getType();
        boolean r3 = false;
        if (r1 != sbb.e.n.b) goto L11;
        if (r5.o.length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L11;
        r0 = r5.o;
        r1 = r5.i();
        String r6 = r5.c;
    L19:
        return new a(r0, r1, r6);
    L7:
        r2 = false;
    L11:
        if ((r5 instanceof oj5.f) == false) goto L17;
        oj5.f r7 = (oj5.f) r5;
        if (r7.O.length() <= 0) goto L15;
        r3 = true;
    L15:
        if (r3 == false) goto L17;
        r6 = r7.O;
    L17:
        r6 = r0;
        goto L19
    }

    public static String r(oj5.a r2) {
        if (r2.getType() != sbb.e.n.b) goto L5;
        boolean r0 = fj5.a.b(r2.i());
    L6:
        DocMetaInfo r3 = r2.g;
        if (r0 == true) goto L10;
        return "secret_type_not_enabled";
    L10:
        if (r3.getGetSecLabelCode() != (-1)) goto L12;
    L16:
        return "secret_type_or_meta_invisible";
    L12:
        if (l(r3) == true) goto L16;
        if (r3.isVisibleSecList() == true) goto L16;
        return "secret_meta_invisible";
    L5:
        r0 = fj5.a.c(r2.getType(), r2.j.isDocV2());
        goto L6
    }

    public static boolean s(oj5.a r1) {
        DocMetaInfo r2 = r1.g;
        if (r2.isGetSecDetailFail() == false) goto L5;
    L8:
        return true;
    L5:
        if (l(r2) == true) goto L8;
        return false;
    }

    public static boolean b(oj5.c r7, a r8) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L6;
        return r7.c().a.canModifySecretLevel();
    L6:
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).t(r8.a, r7, BizDomain.FileBizDomainCCM, "SECRET_MODIFY", r7.c().a).getAllow();
    }

    public static boolean c(oj5.c r7, a r8) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L6;
        return r7.c().a.canVisitSecretLevel();
    L6:
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).t(r8.a, r7, BizDomain.FileBizDomainCCM, "SECRET_LEVEL_VISIBLE", r7.c().a).getAllow();
    }

    public static com.bytedance.ee.bear.more.office.a j(com.bytedance.ee.bear.more.office.c r10, com.bytedance.ee.bear.office.list.adapter.p r11) {
        Intrinsics.checkNotNullParameter(r10, "request");
        oj5.c r0 = r10.g;
        if ((r0 instanceof oj5.a) == false) goto L5;
        oj5.a r1 = (oj5.a) r0;
    L6:
        if (r1 != null) goto L10;
        com.bytedance.ee.bear.more.office.a.b r12 = com.bytedance.ee.bear.more.office.a.b.a;
        n(r10, r12, "moreInfo_not_DocMoreInfo");
        return r12;
    L10:
        if (r10.f.getType() != sbb.e.f.b) goto L14;
        com.bytedance.ee.bear.more.office.a.b r13 = com.bytedance.ee.bear.more.office.a.b.a;
        n(r10, r13, "folder_not_supported");
        return r13;
    L14:
        if (m(r1) == true) goto L17;
        com.bytedance.ee.bear.more.office.a.b r14 = com.bytedance.ee.bear.more.office.a.b.a;
        n(r10, r14, r(r1));
        return r14;
    L17:
        boolean r3 = true;
        if ((r1.i.a instanceof DefaultDocUserPermission) == false) goto L20;
    L23:
        boolean r2 = true;
    L25:
        if ((r1.i.a instanceof DefaultDocUserPermission) == false) goto L27;
    L29:
        ConcurrentHashMap<String, CompositeDisposable> r5 = c;
        if (r5.containsKey(r10.a) == true) goto L40;
        a r6 = q(r1);
        CompositeDisposable r7 = new CompositeDisposable();
        if (r5.putIfAbsent(r10.a, r7) != null) goto L40;
        if ((r1.i.a instanceof DefaultDocUserPermission) == false) goto L38;
        r7.add(((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r6.a, r6.getType()).subscribe(new k0(r10, r1, r6, r11), new l0(r10, r11)));
        goto L40
    L38:
        o(r10, r6, r1, r11);
    L40:
        if (r2 == false) goto L49;
        Context r4 = f(r10);
        if (r4 == null) goto L45;
        String r8 = r4.getString(2131892995);
        if (r8 == null) goto L45;
    L46:
        com.bytedance.ee.bear.more.office.a.C0116a r9 = new com.bytedance.ee.bear.more.office.a.C0116a(r8, null, 2);
        n(r10, r9, "secret_permission_or_meta_prefetching(permission=" + (r1.i.a instanceof DefaultDocUserPermission) + ",meta=" + s(r1) + ')');
        return r9;
    L45:
        r8 = com.bytedance.ee.bear.more.office.f.a();
        goto L46
    L49:
        if (m(r1) == true) goto L51;
        com.bytedance.ee.bear.more.office.a r15 = com.bytedance.ee.bear.more.office.a.b.a;
    L82:
        if (m(r1) == true) goto L84;
        String r16 = r(r1);
    L90:
        n(r10, r15, r16);
        return r15;
    L84:
        a r17 = q(r1);
        boolean r18 = c(r1, r17);
        boolean r19 = b(r1, r17);
        if (r18 == true) goto L87;
        r16 = "secret_visit_permission_denied";
        goto L90
    L87:
        if (r19 == true) goto L89;
        r16 = "secret_modify_permission_denied";
        goto L90
    L89:
        r16 = "secret_visit_and_modify_allowed";
        goto L90
    L51:
        a r20 = q(r1);
        boolean r21 = c(r1, r20);
        boolean r22 = b(r1, r20);
        if (r21 == false) goto L92;
        if (r22 == false) goto L92;
        r15 = com.bytedance.ee.bear.more.office.a.d.a;
    L92:
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L63
        Application r24 = eu5.b.a;     // Catch: Throwable -> L63
        if (r24 == null) goto L60;
        String r25 = r24.getString(2131889895);     // Catch: Throwable -> L63
    L61:
        Object r26 = Result.constructor-impl(r25);     // Catch: Throwable -> L63
    L66:
        if (Result.isFailure-impl(r26) == false) goto L68;
        r26 = null;
    L68:
        String r27 = (String) r26;
        if (r27 != null) goto L71;
    L74:
        if (r3 == false) goto L77;
        r26 = null;
    L77:
        String r28 = (String) r26;
        if (r28 != null) goto L80;
        r28 = com.bytedance.ee.bear.more.office.f.c();
    L80:
        r15 = new com.bytedance.ee.bear.more.office.a.C0116a(r28, null, 2);
        goto L82
    L71:
        if (StringsKt.isBlank(r27) == true) goto L74;
        r3 = false;
        goto L74
    L60:
        r25 = null;
    L63:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L66
    L27:
        if (s(r1) == true) goto L29;
    L20:
        if (s(r1) == true) goto L23;
        r2 = false;
        goto L25
    L5:
        r1 = null;
        goto L6
    }

    public static void n(com.bytedance.ee.bear.more.office.c r3, com.bytedance.ee.bear.more.office.a r4, String r5) {
        StringBuilder r0 = new StringBuilder("secret-setting availability decision. ");
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
        r1.append(", moreInfo=");
        r1.append(r3.g.getClass().getSimpleName());
        r1.append(", moreType=");
        r1.append(r3.g.getType());
        r1.append(", moreRealType=");
        r1.append(r3.g.i());
        r0.append(r1.toString());
        r0.append(", result=");
        if (Intrinsics.areEqual(r4, com.bytedance.ee.bear.more.office.a.d.a) == false) goto L9;
        String r6 = "Visible";
    L17:
        r0.append(r6);
        r0.append(", reason=");
        r0.append(r5);
        tt5.a.h("OfficeSecretSettingActionExecutor", r0.toString());
        return;
    L9:
        if (Intrinsics.areEqual(r4, com.bytedance.ee.bear.more.office.a.b.a) == false) goto L12;
        r6 = "Hidden";
        goto L17
    L12:
        if ((r4 instanceof com.bytedance.ee.bear.more.office.a.c) == false) goto L15;
        r6 = "Loading";
        goto L17
    L15:
        if ((r4 instanceof com.bytedance.ee.bear.more.office.a.C0116a) == false) goto L20;
        r6 = "Disabled(reason=" + ((com.bytedance.ee.bear.more.office.a.C0116a) r4).b + ')';
        goto L17
    L20:
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean a(g0 r0, String r1, FragmentActivity r2, Fragment r3) {
        r0.getClass();
        if (b.containsKey(r1) == true) goto L5;
        return false;
    L5:
        if (com.bytedance.ee.util.ui.b.a(r2) == true) goto L7;
        return false;
    L7:
        if (r3 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == true) goto L17;
        return true;
    L17:
        return false;
    L9:
        if (r3.isAdded() == true) goto L11;
        r4 = true;
        goto L12
    }

    public static void o(com.bytedance.ee.bear.more.office.c r10, a r11, oj5.a r12, com.bytedance.ee.bear.more.office.b r13) {
        String r6 = r10.a;
        CompositeDisposable r7 = c.get(r6);
        if (r7 != null) goto L5;
        return;
    L5:
        r7.add(((a4) org.koin.java.a.c(a4.class, null, null, 6)).b(r11.a, r11.getType()).subscribe(new d(r6, r12, r13, r10, r11), new e(r6, r13, r10)));
    }

    public static void g(String r11, FragmentActivity r12, Fragment r13, a r14, oj5.a r15) {
        boolean r0 = c(r15, r14);
        boolean r1 = b(r15, r14);
        tt5.a.h("OfficeSecretSettingActionExecutor", "continue after permission. actionId=" + r11 + ", type=" + r14.getType() + ", canVisit=" + r0 + ", canModify=" + r1);
        if (r0 == true) goto L6;
        k(r11);
        Toast.showFailureText(r12, 2131889895);
        tt5.a.h("OfficeSecretSettingActionExecutor", "show secret blocked because visit permission denied. actionId=" + r11);
        d(r11);
        return;
    L6:
        if (r1 == true) goto L9;
        k(r11);
        Toast.showFailureText(r12, 2131889895);
        tt5.a.h("OfficeSecretSettingActionExecutor", "show secret blocked by modify permission. actionId=" + r11);
        d(r11);
        return;
    L9:
        DocMetaInfo r9 = r15.g;
        if (r9.isGetSecDetailFail() == false) goto L12;
    L15:
        ConcurrentHashMap<String, CompositeDisposable> r2 = b;
        CompositeDisposable r3 = r2.get(r11);
        if (r3 != null) goto L21;
        r3 = new CompositeDisposable();
        CompositeDisposable r4 = r2.putIfAbsent(r11, r3);
        if (r4 == null) goto L21;
        r3 = r4;
    L21:
        r3.add(((a4) org.koin.java.a.c(a4.class, null, null, 6)).b(r14.a, r14.getType()).subscribe(new h0(r11, r12, r13, r14, r15), new i0(r11, r12, r13)));
        return;
    L12:
        if (l(r9) == true) goto L15;
        com.bytedance.ee.util.ui.j.f(new j0(r11, r12, r13, r14, r9, r15));
    }

    public static void i(String r9, FragmentActivity r10, Fragment r11, a r12, oj5.a r13) {
        ConcurrentHashMap<String, CompositeDisposable> r0 = b;
        CompositeDisposable r1 = r0.get(r9);
        if (r1 != null) goto L8;
        r1 = new CompositeDisposable();
        CompositeDisposable r2 = r0.putIfAbsent(r9, r1);
        if (r2 == null) goto L8;
        r1 = r2;
    L8:
        r1.add(((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r12.a, r12.getType()).subscribe(new b(r13, r9, r10, r11, r12), new c(r9, r10, r11)));
    }
}
