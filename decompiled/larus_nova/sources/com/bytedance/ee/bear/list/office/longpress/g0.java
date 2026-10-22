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
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g0 f228976a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, CompositeDisposable> f228977b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, CompositeDisposable> f228978c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap.KeySetView<String, Boolean> f228979d = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f228980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f228981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f228982c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f228980a, r101.f228980a) == true) goto L12;
            return false;
        L12:
            if (this.f228981b == r101.f228981b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f228982c, r101.f228982c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f228980a.hashCode() * 31) + this.f228981b) * 31) + this.f228982c.hashCode();
        }

        public final String toString() {
            return "SecretTokenArgs(token=" + this.f228980a + ", type=" + this.f228981b + ", wikiToken=" + this.f228982c + ')';
        }

        public final int getType() {
            return this.f228981b;
        }

        public a(String r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "token");
            Intrinsics.checkNotNullParameter(r102, WikiFolderPushPlugin.WIKI_TOKEN);
            this.f228980a = r100;
            this.f228981b = r101;
            this.f228982c = r102;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ oj5.a f228983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f228984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f228985c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Fragment f228986d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ a f228987e;

        public b(oj5.a r100, String r101, FragmentActivity r102, Fragment r103, a r104) {
            this.f228983a = r100;
            this.f228984b = r101;
            this.f228985c = r102;
            this.f228986d = r103;
            this.f228987e = r104;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            DocPermission r101 = (DocPermission) r100;
            oj5.a r102 = this.f228983a;
            Intrinsics.checkNotNull(r101);
            r102.getClass();
            Intrinsics.checkNotNullParameter(r101, "docPermission");
            r102.f523538i = r101;
            boolean r103 = g0.a(g0.f228976a, this.f228984b, this.f228985c, this.f228986d);
            tt5.a.h("OfficeSecretSettingActionExecutor", "fetch doc permission success. actionId=" + this.f228984b + ", type=" + this.f228987e.getType() + ", actionAlive=" + r103);
            if (r103 == false) goto L5;
            g0.g(this.f228984b, this.f228985c, this.f228986d, this.f228987e, this.f228983a);
            return;
        L5:
            tt5.a.h("OfficeSecretSettingActionExecutor", "skip continue because action is not alive after permission. actionId=" + this.f228984b);
            g0.p(this.f228984b);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f228988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f228989b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Fragment f228990c;

        public c(String r100, FragmentActivity r101, Fragment r102) {
            this.f228988a = r100;
            this.f228989b = r101;
            this.f228990c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.e("OfficeSecretSettingActionExecutor", "fetch doc permission failed.", (Throwable) r100, false);
            if (g0.a(g0.f228976a, this.f228988a, this.f228989b, this.f228990c) == false) goto L5;
            Toast.showFailureText(this.f228989b, R.string.CreationMobile_SecureLabel_GetInfoFailed_Toast);
        L5:
            g0.p(this.f228988a);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f228991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ oj5.a f228992b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.more.office.b f228993c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.more.office.c f228994d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ a f228995e;

        public d(String r100, oj5.a r101, com.bytedance.ee.bear.more.office.b r102, com.bytedance.ee.bear.more.office.c r103, a r104) {
            this.f228991a = r100;
            this.f228992b = r101;
            this.f228993c = r102;
            this.f228994d = r103;
            this.f228995e = r104;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            DocMetaInfo r101 = (DocMetaInfo) r100;
            if (g0.f228978c.containsKey(this.f228991a) == false) goto L8;
            oj5.a r102 = this.f228992b;
            Intrinsics.checkNotNull(r101);
            r102.getClass();
            Intrinsics.checkNotNullParameter(r101, "docMetaInfo");
            r102.f523536g = r101;
            com.bytedance.ee.bear.more.office.b r103 = this.f228993c;
            if (r103 == null) goto L7;
            com.bytedance.ee.bear.more.office.c r104 = this.f228994d;
            String r105 = r104.f234687a;
            OfficeLongPressLarkAction r106 = r104.f234688b;
            String r107 = r104.f234689c;
            g0.f228976a.getClass();
            r103.a(r105, r106, r107, g0.j(r104, null));
        L7:
            tt5.a.h("OfficeSecretSettingActionExecutor", "prefetch secret meta success. actionId=" + this.f228991a + ", type=" + this.f228995e.getType() + ", visibleSecList=" + r101.isVisibleSecList());
        L8:
            g0 r108 = g0.f228976a;
            String r109 = this.f228991a;
            r108.getClass();
            g0.e(r109);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f228996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.more.office.b f228997b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.more.office.c f228998c;

        public e(String r100, com.bytedance.ee.bear.more.office.b r101, com.bytedance.ee.bear.more.office.c r102) {
            this.f228996a = r100;
            this.f228997b = r101;
            this.f228998c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.e("OfficeSecretSettingActionExecutor", "prefetch secret meta failed. actionId=" + this.f228996a, (Throwable) r100, false);
            com.bytedance.ee.bear.more.office.b r101 = this.f228997b;
            if (r101 == null) goto L10;
            com.bytedance.ee.bear.more.office.c r102 = this.f228998c;
            String r103 = r102.f234687a;
            OfficeLongPressLarkAction r104 = r102.f234688b;
            String r105 = r102.f234689c;
            g0.f228976a.getClass();
            Context r106 = g0.f(r102);
            if (r106 == null) goto L8;
            String r107 = r106.getString(R.string.Doc_Facade_OperateFailed);
            if (r107 == null) goto L8;
        L9:
            r101.a(r103, r104, r105, new com.bytedance.ee.bear.more.office.a.C3363a(r107, null, 2));
        L8:
            r107 = com.bytedance.ee.bear.more.office.f.a();
        L10:
            g0 r108 = g0.f228976a;
            String r109 = this.f228996a;
            r108.getClass();
            g0.e(r109);
        }
    }

    public g0() {
    }

    static {
        f228976a = new g0();
        f228977b = new ConcurrentHashMap();
        f228978c = new ConcurrentHashMap();
        f228979d = ConcurrentHashMap.newKeySet();
    }

    public static void d(String r100) {
        CompositeDisposable r101 = f228977b.remove(r100);
        if (r101 == null) goto L6;
        r101.clear();
        return;
    }

    public static void e(String r100) {
        CompositeDisposable r101 = f228978c.remove(r100);
        if (r101 == null) goto L6;
        r101.clear();
        return;
    }

    public static Context f(com.bytedance.ee.bear.more.office.c r100) {
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

    public static com.bytedance.ee.bear.more.office.d h(com.bytedance.ee.bear.more.office.c r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        FragmentActivity r101 = r100.getActivity();
        if (r101 == null) goto L5;
        oj5.c r102 = r100.f234693g;
        if ((r102 instanceof oj5.a) == false) goto L9;
        oj5.a r103 = (oj5.a) r102;
    L10:
        if (r103 != null) goto L14;
        return com.bytedance.ee.bear.more.office.d.e.f234703a;
    L14:
        if (m(r103) == false) goto L16;
        a r104 = q(r103);
        ConcurrentHashMap<String, CompositeDisposable> r105 = f228977b;
        String r106 = r100.f234687a;
        if (r105.get(r106) != null) goto L20;
        r105.putIfAbsent(r106, new CompositeDisposable());
    L20:
        String r107 = r100.f234687a;
        f228979d.add(r107);
        Toast.showLoading(r101, r101.getString(R.string.Doc_Facade_Loading));
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L27
        if ((r103.f523538i.f234419a instanceof DefaultDocUserPermission) == false) goto L24;
        i(r100.f234687a, r101, r100.f234691e, r104, r103);     // Catch: Throwable -> L27
    L25:
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L32;
        g0 r111 = f228976a;
        String r112 = r100.f234687a;
        r111.getClass();
        p(r112);
        throw r110;
    L32:
        return com.bytedance.ee.bear.more.office.d.C3364d.f234702a;
    L24:
        g(r100.f234687a, r101, r100.f234691e, r104, r103);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    L16:
        return com.bytedance.ee.bear.more.office.d.e.f234703a;
    L9:
        r103 = null;
        goto L10
    L5:
        return new com.bytedance.ee.bear.more.office.d.b(com.bytedance.ee.bear.more.office.f.c());
    }

    public static void k(String r100) {
        if (f228979d.remove(r100) == false) goto L6;
        Toast.cancelLoading();
        return;
    }

    public static boolean l(DocMetaInfo r100) {
        if (r100.isGetSecSuccess() == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.isVisibleSecList() == true) goto L7;
        return true;
    }

    public static boolean m(oj5.a r100) {
        if (r100.getType() != sbb.e.f541303n.f541317b) goto L5;
        boolean r101 = fj5.a.b(r100.i());
    L6:
        DocMetaInfo r102 = r100.f523536g;
        if (r102.getGetSecLabelCode() != (-1)) goto L9;
    L14:
        boolean r103 = true;
    L15:
        if (r101 == false) goto L18;
        if (r103 == false) goto L18;
        return true;
    L18:
        return false;
    L9:
        if (l(r102) == true) goto L14;
        if (r102.isVisibleSecList() == true) goto L14;
        r103 = false;
        goto L15
    L5:
        r101 = fj5.a.c(r100.getType(), r100.f523539j.isDocV2());
        goto L6
    }

    public static void p(String r100) {
        Intrinsics.checkNotNullParameter(r100, "actionId");
        d(r100);
        e(r100);
        k(r100);
    }

    public static a q(oj5.a r100) {
        String r101 = r100.f523532c;
        int r102 = r100.getType();
        boolean r103 = false;
        if (r102 != sbb.e.f541303n.f541317b) goto L11;
        if (r100.f523544o.length() <= 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L11;
        r101 = r100.f523544o;
        r102 = r100.i();
        String r105 = r100.f523532c;
    L19:
        return new a(r101, r102, r105);
    L7:
        r104 = false;
    L11:
        if ((r100 instanceof oj5.f) == false) goto L17;
        oj5.f r106 = (oj5.f) r100;
        if (r106.O.length() <= 0) goto L15;
        r103 = true;
    L15:
        if (r103 == false) goto L17;
        r105 = r106.O;
    L17:
        r105 = r101;
        goto L19
    }

    public static String r(oj5.a r100) {
        if (r100.getType() != sbb.e.f541303n.f541317b) goto L5;
        boolean r101 = fj5.a.b(r100.i());
    L6:
        DocMetaInfo r102 = r100.f523536g;
        if (r101 == true) goto L10;
        return "secret_type_not_enabled";
    L10:
        if (r102.getGetSecLabelCode() != (-1)) goto L12;
    L16:
        return "secret_type_or_meta_invisible";
    L12:
        if (l(r102) == true) goto L16;
        if (r102.isVisibleSecList() == true) goto L16;
        return "secret_meta_invisible";
    L5:
        r101 = fj5.a.c(r100.getType(), r100.f523539j.isDocV2());
        goto L6
    }

    public static boolean s(oj5.a r100) {
        DocMetaInfo r101 = r100.f523536g;
        if (r101.isGetSecDetailFail() == false) goto L5;
    L8:
        return true;
    L5:
        if (l(r101) == true) goto L8;
        return false;
    }

    public static boolean b(oj5.c r100, a r101) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.f499003a.g() == false) goto L6;
        return r100.c().f234419a.canModifySecretLevel();
    L6:
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).t(r101.f228980a, r100, BizDomain.FileBizDomainCCM, "SECRET_MODIFY", r100.c().f234419a).getAllow();
    }

    public static boolean c(oj5.c r100, a r101) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.f499003a.g() == false) goto L6;
        return r100.c().f234419a.canVisitSecretLevel();
    L6:
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).t(r101.f228980a, r100, BizDomain.FileBizDomainCCM, "SECRET_LEVEL_VISIBLE", r100.c().f234419a).getAllow();
    }

    public static com.bytedance.ee.bear.more.office.a j(com.bytedance.ee.bear.more.office.c r110, com.bytedance.ee.bear.office.list.adapter.p r111) {
        Intrinsics.checkNotNullParameter(r110, "request");
        oj5.c r100 = r110.f234693g;
        if ((r100 instanceof oj5.a) == false) goto L5;
        oj5.a r101 = (oj5.a) r100;
    L6:
        if (r101 != null) goto L10;
        com.bytedance.ee.bear.more.office.a.b r112 = com.bytedance.ee.bear.more.office.a.b.f234684a;
        n(r110, r112, "moreInfo_not_DocMoreInfo");
        return r112;
    L10:
        if (r110.f234692f.getType() != sbb.e.f541295f.f541317b) goto L14;
        com.bytedance.ee.bear.more.office.a.b r113 = com.bytedance.ee.bear.more.office.a.b.f234684a;
        n(r110, r113, "folder_not_supported");
        return r113;
    L14:
        if (m(r101) == true) goto L17;
        com.bytedance.ee.bear.more.office.a.b r114 = com.bytedance.ee.bear.more.office.a.b.f234684a;
        n(r110, r114, r(r101));
        return r114;
    L17:
        boolean r102 = true;
        if ((r101.f523538i.f234419a instanceof DefaultDocUserPermission) == false) goto L20;
    L23:
        boolean r103 = true;
    L25:
        if ((r101.f523538i.f234419a instanceof DefaultDocUserPermission) == false) goto L27;
    L29:
        ConcurrentHashMap<String, CompositeDisposable> r104 = f228978c;
        if (r104.containsKey(r110.f234687a) == true) goto L40;
        a r105 = q(r101);
        CompositeDisposable r106 = new CompositeDisposable();
        if (r104.putIfAbsent(r110.f234687a, r106) != null) goto L40;
        if ((r101.f523538i.f234419a instanceof DefaultDocUserPermission) == false) goto L38;
        r106.add(((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r105.f228980a, r105.getType()).subscribe(new k0(r110, r101, r105, r111), new l0(r110, r111)));
        goto L40
    L38:
        o(r110, r105, r101, r111);
    L40:
        if (r103 == false) goto L49;
        Context r107 = f(r110);
        if (r107 == null) goto L45;
        String r108 = r107.getString(R.string.Settings_ChangeName_GeneralError);
        if (r108 == null) goto L45;
    L46:
        com.bytedance.ee.bear.more.office.a.C3363a r109 = new com.bytedance.ee.bear.more.office.a.C3363a(r108, null, 2);
        n(r110, r109, "secret_permission_or_meta_prefetching(permission=" + (r101.f523538i.f234419a instanceof DefaultDocUserPermission) + ",meta=" + s(r101) + ')');
        return r109;
    L45:
        r108 = com.bytedance.ee.bear.more.office.f.a();
        goto L46
    L49:
        if (m(r101) == true) goto L51;
        com.bytedance.ee.bear.more.office.a r115 = com.bytedance.ee.bear.more.office.a.b.f234684a;
    L82:
        if (m(r101) == true) goto L84;
        String r116 = r(r101);
    L90:
        n(r110, r115, r116);
        return r115;
    L84:
        a r117 = q(r101);
        boolean r118 = c(r101, r117);
        boolean r119 = b(r101, r117);
        if (r118 == true) goto L87;
        r116 = "secret_visit_permission_denied";
        goto L90
    L87:
        if (r119 == true) goto L89;
        r116 = "secret_modify_permission_denied";
        goto L90
    L89:
        r116 = "secret_visit_and_modify_allowed";
        goto L90
    L51:
        a r120 = q(r101);
        boolean r121 = c(r101, r120);
        boolean r122 = b(r101, r120);
        if (r121 == false) goto L92;
        if (r122 == false) goto L92;
        r115 = com.bytedance.ee.bear.more.office.a.d.f234686a;
    L92:
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L63
        Application r124 = eu5.b.f474075a;     // Catch: Throwable -> L63
        if (r124 == null) goto L60;
        String r125 = r124.getString(R.string.LarkCCM_Workspace_SecLevII_SubmitFailed_NoPermission_Toast);     // Catch: Throwable -> L63
    L61:
        Object r126 = Result.m9449constructorimpl(r125);     // Catch: Throwable -> L63
    L66:
        if (Result.m9455isFailureimpl(r126) == false) goto L68;
        r126 = null;
    L68:
        String r127 = (String) r126;
        if (r127 != null) goto L71;
    L74:
        if (r102 == false) goto L77;
        r126 = null;
    L77:
        String r128 = (String) r126;
        if (r128 != null) goto L80;
        r128 = com.bytedance.ee.bear.more.office.f.c();
    L80:
        r115 = new com.bytedance.ee.bear.more.office.a.C3363a(r128, null, 2);
        goto L82
    L71:
        if (StringsKt.isBlank(r127) == true) goto L74;
        r102 = false;
        goto L74
    L60:
        r125 = null;
    L63:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L66
    L27:
        if (s(r101) == true) goto L29;
    L20:
        if (s(r101) == true) goto L23;
        r103 = false;
        goto L25
    L5:
        r101 = null;
        goto L6
    }

    public static void n(com.bytedance.ee.bear.more.office.c r100, com.bytedance.ee.bear.more.office.a r101, String r102) {
        StringBuilder r103 = new StringBuilder("secret-setting availability decision. ");
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
        r104.append(", moreInfo=");
        r104.append(r100.f234693g.getClass().getSimpleName());
        r104.append(", moreType=");
        r104.append(r100.f234693g.getType());
        r104.append(", moreRealType=");
        r104.append(r100.f234693g.i());
        r103.append(r104.toString());
        r103.append(", result=");
        if (Intrinsics.areEqual(r101, com.bytedance.ee.bear.more.office.a.d.f234686a) == false) goto L9;
        String r106 = "Visible";
    L17:
        r103.append(r106);
        r103.append(", reason=");
        r103.append(r102);
        tt5.a.h("OfficeSecretSettingActionExecutor", r103.toString());
        return;
    L9:
        if (Intrinsics.areEqual(r101, com.bytedance.ee.bear.more.office.a.b.f234684a) == false) goto L12;
        r106 = "Hidden";
        goto L17
    L12:
        if ((r101 instanceof com.bytedance.ee.bear.more.office.a.c) == false) goto L15;
        r106 = "Loading";
        goto L17
    L15:
        if ((r101 instanceof com.bytedance.ee.bear.more.office.a.C3363a) == false) goto L20;
        r106 = "Disabled(reason=" + ((com.bytedance.ee.bear.more.office.a.C3363a) r101).f234683b + ')';
        goto L17
    L20:
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean a(g0 r100, String r101, FragmentActivity r102, Fragment r103) {
        r100.getClass();
        if (f228977b.containsKey(r101) == true) goto L5;
        return false;
    L5:
        if (com.bytedance.ee.util.ui.b.a(r102) == true) goto L7;
        return false;
    L7:
        if (r103 != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == true) goto L17;
        return true;
    L17:
        return false;
    L9:
        if (r103.isAdded() == true) goto L11;
        r104 = true;
        goto L12
    }

    public static void o(com.bytedance.ee.bear.more.office.c r110, a r111, oj5.a r112, com.bytedance.ee.bear.more.office.b r113) {
        String r100 = r110.f234687a;
        CompositeDisposable r101 = f228978c.get(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        r101.add(((a4) org.koin.java.a.c(a4.class, null, null, 6)).b(r111.f228980a, r111.getType()).subscribe(new d(r100, r112, r113, r110, r111), new e(r100, r113, r110)));
    }

    public static void g(String r110, FragmentActivity r111, Fragment r112, a r113, oj5.a r114) {
        boolean r100 = c(r114, r113);
        boolean r101 = b(r114, r113);
        tt5.a.h("OfficeSecretSettingActionExecutor", "continue after permission. actionId=" + r110 + ", type=" + r113.getType() + ", canVisit=" + r100 + ", canModify=" + r101);
        if (r100 == true) goto L6;
        k(r110);
        Toast.showFailureText(r111, R.string.LarkCCM_Workspace_SecLevII_SubmitFailed_NoPermission_Toast);
        tt5.a.h("OfficeSecretSettingActionExecutor", "show secret blocked because visit permission denied. actionId=" + r110);
        d(r110);
        return;
    L6:
        if (r101 == true) goto L9;
        k(r110);
        Toast.showFailureText(r111, R.string.LarkCCM_Workspace_SecLevII_SubmitFailed_NoPermission_Toast);
        tt5.a.h("OfficeSecretSettingActionExecutor", "show secret blocked by modify permission. actionId=" + r110);
        d(r110);
        return;
    L9:
        DocMetaInfo r102 = r114.f523536g;
        if (r102.isGetSecDetailFail() == false) goto L12;
    L15:
        ConcurrentHashMap<String, CompositeDisposable> r103 = f228977b;
        CompositeDisposable r104 = r103.get(r110);
        if (r104 != null) goto L21;
        r104 = new CompositeDisposable();
        CompositeDisposable r105 = r103.putIfAbsent(r110, r104);
        if (r105 == null) goto L21;
        r104 = r105;
    L21:
        r104.add(((a4) org.koin.java.a.c(a4.class, null, null, 6)).b(r113.f228980a, r113.getType()).subscribe(new h0(r110, r111, r112, r113, r114), new i0(r110, r111, r112)));
        return;
    L12:
        if (l(r102) == true) goto L15;
        com.bytedance.ee.util.ui.j.f(new j0(r110, r111, r112, r113, r102, r114));
    }

    public static void i(String r100, FragmentActivity r110, Fragment r111, a r112, oj5.a r113) {
        ConcurrentHashMap<String, CompositeDisposable> r101 = f228977b;
        CompositeDisposable r102 = r101.get(r100);
        if (r102 != null) goto L8;
        r102 = new CompositeDisposable();
        CompositeDisposable r103 = r101.putIfAbsent(r100, r102);
        if (r103 == null) goto L8;
        r102 = r103;
    L8:
        r102.add(((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r112.f228980a, r112.getType()).subscribe(new b(r113, r100, r110, r111, r112), new c(r100, r110, r111)));
    }
}
