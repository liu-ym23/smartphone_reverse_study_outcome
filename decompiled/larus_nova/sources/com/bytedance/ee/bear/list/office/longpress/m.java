package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DefaultDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.more.office.OfficeLongPressDisabledDispatchReason;
import com.larus.nova.R;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f229044a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, CompositeDisposable> f229045b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, CompositeDisposable> f229046c = null;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.list.office.longpress.m$a$a, reason: collision with other inner class name */
        public static final class C3278a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f229047a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final PermissionResponse f229048b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C3278a) == true) goto L8;
                return false;
            L8:
                C3278a r101 = (C3278a) r100;
                if (Intrinsics.areEqual(this.f229047a, r101.f229047a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f229048b, r101.f229048b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r100 = this.f229047a.hashCode() * 31;
                PermissionResponse r101 = this.f229048b;
                if (r101 != null) goto L5;
                int r102 = 0;
            L7:
                return r100 + r102;
            L5:
                r102 = r101.hashCode();
                goto L7
            }

            public final String toString() {
                return "DisabledToast(tips=" + this.f229047a + ", permissionResponseForDisabledClick=" + this.f229048b + ')';
            }

            public C3278a(String r100, PermissionResponse r101) {
                Intrinsics.checkNotNullParameter(r100, "tips");
                this.f229047a = r100;
                this.f229048b = r101;
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f229049a = null;

            static {
                f229049a = new b();
            }

            public b() {
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f229050a = null;

            static {
                f229050a = new c();
            }

            public c() {
            }
        }

        public static final class d extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final PermissionResponse f229051a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof d) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f229051a, ((d) r100).f229051a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f229051a.hashCode();
            }

            public final String toString() {
                return "PermissionPlatformAction(response=" + this.f229051a + ')';
            }

            public d(PermissionResponse r100) {
                Intrinsics.checkNotNullParameter(r100, "response");
                this.f229051a = r100;
            }
        }

        public static final class e extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f229052a = null;

            static {
                f229052a = new e();
            }

            public e() {
            }
        }

        public static final class f extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final gj5.c f229053a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof f) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f229053a, ((f) r100).f229053a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f229053a.hashCode();
            }

            public final String toString() {
                return "SecurityPolicyDialog(result=" + this.f229053a + ')';
            }

            public f(gj5.c r100) {
                Intrinsics.checkNotNullParameter(r100, "result");
                this.f229053a = r100;
            }
        }

        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f229054a = null;

        static {
            int[] r100 = new int[FileAuthResultFrom.values().length];
            r100[FileAuthResultFrom.COME_FROM_FILE_POLICY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f229054a = r100;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.more.office.c f229055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ oj5.a f229056b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f229057c;

        public c(com.bytedance.ee.bear.more.office.c r100, oj5.a r101, FragmentActivity r102) {
            this.f229055a = r100;
            this.f229056b = r101;
            this.f229057c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            DocPermission r101 = (DocPermission) r100;
            tt5.a.h("OfficeExportAsActionExecutor", "fetch export permission success. actionId=" + this.f229055a.f234687a + ", type=" + this.f229056b.getType());
            oj5.a r102 = this.f229056b;
            Intrinsics.checkNotNull(r101);
            r102.getClass();
            Intrinsics.checkNotNullParameter(r101, "docPermission");
            r102.f523538i = r101;
            Toast.cancelLoading();
            m r103 = m.f229044a;
            FragmentActivity r104 = this.f229057c;
            com.bytedance.ee.bear.more.office.d r105 = m.c(this.f229055a);
            if (Intrinsics.areEqual(r105, com.bytedance.ee.bear.more.office.d.C3364d.f234702a) == false) goto L5;
        L19:
            m.g(this.f229055a.f234687a);
            return;
        L5:
            if (Intrinsics.areEqual(r105, com.bytedance.ee.bear.more.office.d.a.f234698a) == true) goto L19;
            if (Intrinsics.areEqual(r105, com.bytedance.ee.bear.more.office.d.f.f234704a) == true) goto L19;
            if (Intrinsics.areEqual(r105, com.bytedance.ee.bear.more.office.d.e.f234703a) == false) goto L12;
            Toast.showFailureText(r104, com.bytedance.ee.bear.more.office.f.c());
            goto L19
        L12:
            if ((r105 instanceof com.bytedance.ee.bear.more.office.d.b) == false) goto L15;
            Toast.showFailureText(r104, ((com.bytedance.ee.bear.more.office.d.b) r105).f234699a);
            goto L19
        L15:
            if ((r105 instanceof com.bytedance.ee.bear.more.office.d.c) == false) goto L18;
            Toast.showFailureText(r104, ((com.bytedance.ee.bear.more.office.d.c) r105).f234700a);
            goto L19
        L18:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.more.office.c f229058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f229059b;

        public d(com.bytedance.ee.bear.more.office.c r100, FragmentActivity r101) {
            this.f229058a = r100;
            this.f229059b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.e("OfficeExportAsActionExecutor", "fetch export permission failed. actionId=" + this.f229058a.f234687a, (Throwable) r100, false);
            Toast.cancelLoading();
            Toast.showFailureText(this.f229059b, R.string.Doc_Facade_OperateFailed);
            m r101 = m.f229044a;
            m.g(this.f229058a.f234687a);
        }
    }

    public m() {
    }

    static {
        f229044a = new m();
        f229045b = new ConcurrentHashMap();
        f229046c = new ConcurrentHashMap();
    }

    public static Context b(com.bytedance.ee.bear.more.office.c r100) {
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

    public static com.bytedance.ee.bear.more.office.d c(com.bytedance.ee.bear.more.office.c r210) {
        a r100 = i(r210, false);
        if (Intrinsics.areEqual(r100, a.c.f229050a) == false) goto L5;
        g(r210.f234687a);
        return com.bytedance.ee.bear.more.office.d.e.f234703a;
    L5:
        String r101 = "";
        if (Intrinsics.areEqual(r100, a.b.f229049a) == false) goto L23;
        FragmentActivity r102 = r210.getActivity();
        if (r102 == null) goto L53;
        oj5.c r103 = r210.f234693g;
        com.bytedance.ee.bear.more.b r104 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);
        Bundle r105 = Bundle.EMPTY;
        String r106 = r103.getToken();
        if (r106 != null) goto L13;
        String r110 = "";
    L14:
        r104.c(new com.bytedance.ee.bear.more.i(r105, r110, r103.getType(), false, r103.b(), "export_as", "ccm_space_export_as_view", "", "", false, r103.m(), r103.H(), r103.isOwner(), r103.L()));
        com.bytedance.ee.bear.d r107 = (com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6);
        int r108 = r103.getType();
        int r109 = r103.i();
        String r111 = r103.getToken();
        String r112 = r103.getToken();
        if (r112 != null) goto L17;
        String r113 = "";
    L19:
        if (r107.h(r102, new com.bytedance.ee.bear.d.a(r108, r109, r111, r113, r103.getTitle(), r103.t(), r103.a(), r103.d(), r103.m(), r103.h(), r103.s(), r103.N(), r103.c().f234419a), new n(r210)) == false) goto L21;
        h(r210, "ccm_space_export_as_view", null);
        g(r210.f234687a);
        return com.bytedance.ee.bear.more.office.d.C3364d.f234702a;
    L21:
        g(r210.f234687a);
        return new com.bytedance.ee.bear.more.office.d.c(0);
    L17:
        r113 = r112;
        goto L19
    L13:
        r110 = r106;
        goto L14
    L53:
        return new com.bytedance.ee.bear.more.office.d.b(com.bytedance.ee.bear.more.office.f.c());
    L23:
        if (Intrinsics.areEqual(r100, a.e.f229052a) == false) goto L26;
        d(r210);
        return com.bytedance.ee.bear.more.office.d.f.f234704a;
    L26:
        if ((r100 instanceof a.C3278a) == false) goto L37;
        a.C3278a r114 = (a.C3278a) r100;
        PermissionResponse r115 = r114.f229048b;
        if (r115 == null) goto L35;
        ph5.e r116 = r115.getCallback();
        if (r116 == null) goto L35;
        Context r117 = b(r210);
        if (r117 != null) goto L34;
        r117 = eu5.b.f474075a;
    L34:
        r116.a(r117, r114.f229048b);
    L35:
        g(r210.f234687a);
        return new com.bytedance.ee.bear.more.office.d.b(r114.f229047a);
    L37:
        if ((r100 instanceof a.d) == false) goto L43;
        a.d r118 = (a.d) r100;
        ph5.e r119 = r118.f229051a.getCallback();
        Context r120 = b(r210);
        if (r120 != null) goto L41;
        r120 = eu5.b.f474075a;
    L41:
        r119.a(r120, r118.f229051a);
        g(r210.f234687a);
        return com.bytedance.ee.bear.more.office.d.a.f234698a;
    L43:
        if ((r100 instanceof a.f) == false) goto L51;
        oj5.c r121 = r210.f234693g;
        gj5.b r122 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
        FileBizDomain r123 = FileBizDomain.FileBizDomainCCM;
        int r124 = r121.getType();
        String r125 = r121.getToken();
        if (r125 == null) goto L48;
        r101 = r125;
    L48:
        r122.c("CCM_EXPORT", r123, r124, r101);
        g(r210.f234687a);
        return com.bytedance.ee.bear.more.office.d.a.f234698a;
    L51:
        throw new NoWhenBranchMatchedException();
    }

    public static void d(com.bytedance.ee.bear.more.office.c r100) {
        FragmentActivity r101 = r100.getActivity();
        if (r101 != null) goto L5;
        return;
    L5:
        oj5.c r102 = r100.f234693g;
        if ((r102 instanceof oj5.a) == false) goto L8;
        oj5.a r103 = (oj5.a) r102;
    L9:
        if (r103 != null) goto L11;
        return;
    L11:
        ConcurrentHashMap<String, CompositeDisposable> r104 = f229045b;
        String r105 = r100.f234687a;
        CompositeDisposable r106 = r104.get(r105);
        if (r106 != null) goto L17;
        r106 = new CompositeDisposable();
        CompositeDisposable r107 = r104.putIfAbsent(r105, r106);
        if (r107 == null) goto L17;
        r106 = r107;
    L17:
        Toast.showLoading(r101, r101.getString(R.string.Doc_Facade_Loading));
        r106.add(((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r103.f523532c, r103.getType()).subscribe(new c(r100, r103, r101), new d(r100, r101)));
        return;
    L8:
        r103 = null;
        goto L9
    }

    public static void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "actionId");
        CompositeDisposable r101 = f229045b.remove(r100);
        if (r101 == null) goto L5;
        r101.clear();
    L5:
        CompositeDisposable r102 = f229046c.remove(r100);
        if (r102 == null) goto L9;
        r102.clear();
        return;
    }

    public static com.bytedance.ee.bear.more.office.a e(com.bytedance.ee.bear.more.office.c r100, com.bytedance.ee.bear.office.list.adapter.p r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Context r102 = b(r100);
        if (r102 != null) goto L5;
        r102 = eu5.b.f474075a;
    L5:
        boolean r103 = true;
        a r104 = i(r100, true);
        if (Intrinsics.areEqual(r104, a.c.f229050a) == false) goto L9;
        com.bytedance.ee.bear.more.office.a r105 = com.bytedance.ee.bear.more.office.a.b.f234684a;
    L27:
        oj5.c r106 = r100.f234693g;
        if ((r106 instanceof oj5.a) == false) goto L30;
        oj5.a r107 = (oj5.a) r106;
    L31:
        if (r107 != null) goto L34;
    L47:
        return r105;
    L34:
        if ((r107.f523538i.f234419a instanceof DefaultDocUserPermission) == true) goto L36;
    L38:
        r103 = false;
    L39:
        if (r103 == false) goto L47;
        ConcurrentHashMap<String, CompositeDisposable> r108 = f229046c;
        if (r108.containsKey(r100.f234687a) == true) goto L47;
        CompositeDisposable r109 = new CompositeDisposable();
        if (r108.putIfAbsent(r100.f234687a, r109) != null) goto L47;
        r109.add(((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r107.f523532c, r107.getType()).subscribe(new o(r100, r107, r101), new p(r100, r101)));
        goto L47
    L36:
        if (q.a(r107) == false) goto L38;
    L30:
        r107 = null;
        goto L31
    L9:
        if (Intrinsics.areEqual(r104, a.b.f229049a) == false) goto L12;
        r105 = com.bytedance.ee.bear.more.office.a.d.f234686a;
        goto L27
    L12:
        if (Intrinsics.areEqual(r104, a.e.f229052a) == false) goto L15;
        r105 = new com.bytedance.ee.bear.more.office.a.C3363a(r102.getString(R.string.Settings_ChangeName_GeneralError), OfficeLongPressDisabledDispatchReason.PREFETCH_IN_PROGRESS_RETRY);
        goto L27
    L15:
        if ((r104 instanceof a.d) == false) goto L18;
        r105 = new com.bytedance.ee.bear.more.office.a.C3363a(null, OfficeLongPressDisabledDispatchReason.PERMISSION_PLATFORM_ACTION, 1);
        goto L27
    L18:
        if ((r104 instanceof a.f) == false) goto L21;
        r105 = new com.bytedance.ee.bear.more.office.a.C3363a(null, OfficeLongPressDisabledDispatchReason.SECURITY_POLICY_DIALOG, 1);
        goto L27
    L21:
        if ((r104 instanceof a.C3278a) == false) goto L49;
        a.C3278a r110 = (a.C3278a) r104;
        String r111 = r110.f229047a;
        if (r110.f229048b == null) goto L25;
        OfficeLongPressDisabledDispatchReason r112 = OfficeLongPressDisabledDispatchReason.PERMISSION_PLATFORM_ACTION;
    L26:
        r105 = new com.bytedance.ee.bear.more.office.a.C3363a(r111, r112);
        goto L27
    L25:
        r112 = null;
        goto L26
    L49:
        throw new NoWhenBranchMatchedException();
    }

    public static a i(com.bytedance.ee.bear.more.office.c r110, boolean r111) {
        Context r100 = b(r110);
        if (r100 != null) goto L6;
        a.C3278a r112 = new a.C3278a(com.bytedance.ee.bear.more.office.f.c(), null);
        f(r110, r112, "missing_context");
        return r112;
    L6:
        oj5.c r101 = r110.f234693g;
        if ((r101 instanceof oj5.a) == false) goto L9;
        oj5.a r102 = (oj5.a) r101;
    L10:
        if (r102 != null) goto L14;
        a.c r113 = a.c.f229050a;
        f(r110, r113, "moreInfo_not_DocMoreInfo");
        return r113;
    L14:
        if (q.a(r102) == true) goto L16;
    L94:
        a.c r114 = a.c.f229050a;
        f(r110, r114, "unsupported_export_type_or_wiki_container");
        return r114;
    L16:
        if (r102.getType() == 16) goto L94;
        if (r102.f523545p == true) goto L21;
    L24:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r103 = jg5.e.a.f499003a.g();
        if (r111 == true) goto L27;
    L34:
        boolean r115 = false;
    L35:
        if (r103 == false) goto L38;
        if (r115 == true) goto L38;
        PermissionResponse r104 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).t(r102.f523532c, r102, BizDomain.FileBizDomainCCM, "EXPORT", r102.f523538i.f234419a);
    L39:
        if (r104 == null) goto L45;
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.e(r104) == true) goto L45;
        a.c r116 = a.c.f229050a;
        f(r110, r116, "permission_platform_ui_invisible");
        return r116;
    L45:
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == true) goto L48;
        a.C3278a r117 = new a.C3278a(r100.getString(R.string.Doc_List_OperateFailedNoNet), null);
        f(r110, r117, "network_disconnected");
        return r117;
    L48:
        gj5.b r105 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
        FileBizDomain r106 = FileBizDomain.FileBizDomainCCM;
        int r107 = r102.getType();
        String r108 = r102.f523532c;
        if (r108 != null) goto L51;
        r108 = "";
    L51:
        gj5.c r109 = r105.g("CCM_EXPORT", r106, r107, r108);
        if (r109.f481503a == true) goto L59;
        if (b.f229054a[r109.f481504b.ordinal()] != 1) goto L56;
        a.f r118 = new a.f(r109);
        f(r110, r118, "security_policy_blocked");
        return r118;
    L56:
        a.C3278a r119 = new a.C3278a(r100.getString(R.string.CreationMobile_ECM_AdminDisableToast), null);
        f(r110, r119, "admin_blocked");
        return r119;
    L59:
        if (r102.isSecretFileExport() == false) goto L61;
    L92:
        a.C3278a r120 = new a.C3278a(r100.getString(R.string.LarkCCM_Perms_ThirdParty_UnableToExport_Toast), null);
        f(r110, r120, "secret_file_export_or_view_blocked");
        return r120;
    L61:
        if (r102.isSecretFileView() == true) goto L92;
        if (r115 == false) goto L67;
        a.e r121 = a.e.f229052a;
        f(r110, r121, "placeholder_doc_permission_wait_real_permission");
        return r121;
    L67:
        if (r104 == null) goto L83;
        if (((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).e(r104) == false) goto L73;
        a.b r122 = a.b.f229049a;
        f(r110, r122, "permission_platform_ui_enabled");
        return r122;
    L73:
        if (((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).d(r104) == false) goto L77;
        a.d r123 = new a.d(r104);
        f(r110, r123, "permission_platform_ui_action");
        return r123;
    L77:
        if (r102.f523545p == false) goto L79;
        String r124 = r100.getString(R.string.LarkCCM_Workspace_Menu_NoOriginalDocumentPermToDownload_Tooltip);
        Intrinsics.checkNotNull(r124);
    L80:
        a.C3278a r125 = new a.C3278a(r124, r104);
        f(r110, r125, "permission_platform_ui_disabled");
        return r125;
    L79:
        r124 = r100.getString(R.string.Doc_Document_ExportNoPermission);
        Intrinsics.checkNotNull(r124);
        goto L80
    L83:
        if (r102.p() == false) goto L85;
        a.b r126 = a.b.f229049a;
        f(r110, r126, "all_export_checks_passed");
        return r126;
    L85:
        if (r102.f523545p == false) goto L87;
        String r127 = r100.getString(R.string.LarkCCM_Workspace_Menu_NoOriginalDocumentPermToDownload_Tooltip);
        Intrinsics.checkNotNull(r127);
    L88:
        a.C3278a r128 = new a.C3278a(r127, null);
        f(r110, r128, "user_permission_cannot_export");
        return r128;
    L87:
        r127 = r100.getString(R.string.Doc_Document_ExportNoPermission);
        Intrinsics.checkNotNull(r127);
    L38:
        r104 = null;
        goto L39
    L27:
        if ((r102.f523538i.f234419a instanceof DefaultDocUserPermission) == true) goto L29;
    L31:
        boolean r129 = false;
    L32:
        if (r129 == false) goto L34;
        r115 = true;
        goto L35
    L29:
        if (q.a(r102) == false) goto L31;
        r129 = true;
        goto L32
    L21:
        if (r102.f523546q == false) goto L24;
        a.c r130 = a.c.f229050a;
        f(r110, r130, "shortcut_origin_deleted");
        return r130;
    L9:
        r102 = null;
        goto L10
    }

    public static void f(com.bytedance.ee.bear.more.office.c r100, a r101, String r102) {
        StringBuilder r103 = new StringBuilder("export-as permission decision. ");
        StringBuilder r104 = new StringBuilder("actionId=");
        r104.append(du5.b.k(r100.f234687a));
        r104.append(", token=");
        oj5.c r105 = r100.f234693g;
        String r106 = null;
        if ((r105 instanceof oj5.a) == false) goto L5;
        oj5.a r107 = (oj5.a) r105;
    L6:
        if (r107 == null) goto L8;
        String r108 = r107.f523532c;
    L9:
        String r109 = "";
        if (r108 != null) goto L13;
        r108 = "";
    L13:
        if (r108.length() != 0) goto L15;
        boolean r110 = true;
    L16:
        if (r110 == false) goto L22;
        String r111 = r100.f234692f.f227873d;
        if (r111 == null) goto L21;
        r109 = r111;
    L21:
        r108 = r109;
    L22:
        r104.append(du5.b.k(r108));
        r104.append(", type=");
        r104.append(r100.f234693g.getType());
        r104.append(", realType=");
        r104.append(r100.f234693g.i());
        r104.append(", moreInfo=");
        r104.append(r100.f234693g.getClass().getSimpleName());
        r104.append(", isShortcut=");
        r104.append(r100.f234693g.E());
        r104.append(", userPerm=");
        IDocUserPermission r112 = r100.f234693g.c().f234419a;
        if (r112 == null) goto L25;
        r106 = r112.getClass().getSimpleName();
    L25:
        r104.append(r106);
        r103.append(r104.toString());
        r103.append(", decision=");
        if (Intrinsics.areEqual(r101, a.c.f229050a) == false) goto L29;
        String r113 = "Hidden";
    L43:
        r103.append(r113);
        r103.append(", reason=");
        r103.append(r102);
        tt5.a.h("OfficeExportAsActionExecutor", r103.toString());
        return;
    L29:
        if (Intrinsics.areEqual(r101, a.b.f229049a) == false) goto L32;
        r113 = "Enabled";
        goto L43
    L32:
        if (Intrinsics.areEqual(r101, a.e.f229052a) == false) goto L35;
        r113 = "Prefetching";
        goto L43
    L35:
        if ((r101 instanceof a.C3278a) == false) goto L38;
        r113 = "DisabledToast";
        goto L43
    L38:
        if ((r101 instanceof a.d) == false) goto L41;
        r113 = "PermissionPlatformAction";
        goto L43
    L41:
        if ((r101 instanceof a.f) == false) goto L46;
        r113 = "SecurityPolicyDialog";
        goto L43
    L46:
        throw new NoWhenBranchMatchedException();
    L15:
        r110 = false;
        goto L16
    L8:
        r108 = null;
        goto L9
    L5:
        r107 = null;
        goto L6
    }

    public static void h(com.bytedance.ee.bear.more.office.c r110, String r111, Map r112) {
        oj5.c r100 = r110.f234693g;
        com.bytedance.ee.bear.more.b r101 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);
        Bundle r102 = Bundle.EMPTY;
        String r103 = r100.getToken();
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r101.I(new com.bytedance.ee.bear.more.l(r111, r102, r103, r100.getType(), r100.b(), false, r100.m(), r100.isOwner(), false, r100.L(), r112));
    }

    public static final void a(com.bytedance.ee.bear.more.office.c r110, String r111, String r210, Map r211) {
        oj5.c r100 = r110.f234693g;
        com.bytedance.ee.bear.more.b r101 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);
        Bundle r102 = Bundle.EMPTY;
        String r103 = r100.getToken();
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r101.E(new com.bytedance.ee.bear.more.m(r111, r102, r103, r100.getType(), r100.b(), false, r100.m(), r210, "none", "", r100.isOwner(), false, r100.L(), r211));
    }
}
