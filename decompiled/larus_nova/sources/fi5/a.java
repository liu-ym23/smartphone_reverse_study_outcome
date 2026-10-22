package fi5;

import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.lark.dependency.i0;
import com.ss.android.lark.security.compliance.api.model.filepolicy.AuthEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.CCMFileEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.CheckPriority;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityOperate;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.IMFileEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateConfig;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.security.compliance.api.model.filepolicy.m;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import sbb.e;
import yh5.f;
import yh5.k;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements gj5.b {

    /* JADX INFO: renamed from: fi5.a$a, reason: collision with other inner class name */
    public static final class C5912a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f477366a = null;

        static {
            int[] r100 = new int[ResultType.values().length];
            r100[ResultType.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[ResultType.DENY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[ResultType.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[ResultType.ALLOW.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[ResultType.NULL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f477366a = r100;
        }
    }

    public static final class c implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f477367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ gj5.a f477368b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<PolicyModel> f477369c;

        @Override // com.ss.android.lark.security.compliance.api.model.filepolicy.m
        public final void onResult(Map<String, ValidateResult> r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            if (r100.isEmpty() == false) goto L6;
            a r101 = this.f477367a;
            gj5.a r102 = this.f477368b;
            r101.getClass();
            a.h(r102);
            return;
        L6:
            ValidateResult r103 = r100.get(this.f477369c.element.getTaskId());
            if (r103 != null) goto L10;
            a r104 = this.f477367a;
            gj5.a r105 = this.f477368b;
            r104.getClass();
            a.h(r105);
            return;
        L10:
            tt5.a.h("SecurityComplianceProxyImpl", "asyncCheckSecurityPolicy result=" + r103.getResult() + ", source=" + r103.getResultPolicy());
            a r106 = this.f477367a;
            ResultType r107 = r103.getResult();
            r106.getClass();
            int r108 = b.f477366a[r107.ordinal()];
            boolean r109 = true;
            if (r108 != 1) goto L13;
        L18:
            a r110 = this.f477367a;
            FileAuthResultFrom r111 = r103.getResultPolicy();
            r110.getClass();
            if (r109 == false) goto L21;
        L23:
            r103.setResultPolicy(r111);
            gj5.c r112 = new gj5.c(r109, r103.getResultPolicy());
            r112.f481505c = r103;
            tt5.a.h("SecurityComplianceProxyImpl", "asyncCheckSecurityPolicy validResult= " + r112.f481503a + ",souce=" + r112.f481504b);
            this.f477368b.a(r112);
            return;
        L21:
            if (FileAuthResultFrom.COME_FROM_UNKNOWN != r111) goto L23;
            r111 = FileAuthResultFrom.COME_FROM_FILE_POLICY;
            goto L23
        L13:
            if (r108 != 2) goto L15;
        L17:
            r109 = false;
            goto L18
        L15:
            if (r108 == 3) goto L17;
            goto L17
        }

        public c(a r100, gj5.a r101, Ref.ObjectRef<PolicyModel> r102) {
            this.f477367a = r100;
            this.f477368b = r101;
            this.f477369c = r102;
        }
    }

    static {
    }

    public a() {
    }

    public static void h(gj5.a r100) {
        if (r100 == null) goto L5;
        r100.a(new gj5.c(true, FileAuthResultFrom.COME_FROM_UNKNOWN));
        return;
    }

    public static int m(int r100) {
        if (r100 != e.f541296g.f541317b) goto L6;
        return 6;
    L6:
        if (r100 != e.f541297h.f541317b) goto L9;
        return 7;
    L9:
        if (r100 != e.f541300k.f541317b) goto L12;
        return 9;
    L12:
        if (r100 != e.f541301l.f541317b) goto L15;
        return 10;
    L15:
        if (r100 != e.f541298i.f541317b) goto L18;
        return 8;
    L18:
        if (r100 != e.f541302m.f541317b) goto L20;
        return 11;
    L20:
        return 1;
    }

    public static int n(@EntityOperate String r100) {
        switch(r100.hashCode()) {
            case -2098180752: goto L52;
            case -2028760642: goto L48;
            case -1636733050: goto L44;
            case -1336101129: goto L41;
            case -1292653281: goto L38;
            case -1292216512: goto L34;
            case -1117921619: goto L31;
            case -1095964469: goto L27;
            case -1091037998: goto L23;
            case -732883758: goto L20;
            case -329632833: goto L16;
            case -62825703: goto L13;
            case -60434126: goto L10;
            case 403188806: goto L6;
            default: goto L55;
        };
    L55:
        return 0;
    L6:
        if (r100.equals("CCM_EXPORT") == false) goto L55;
        return 4;
    L10:
        if (r100.equals("IM_MSG_FILE_DOWNLOAD") == false) goto L55;
    L25:
        return 3;
    L13:
        if (r100.equals("CCM_FILE_DOWNLOAD") == true) goto L25;
    L16:
        if (r100.equals("CCM_MOVE_RECYCLE_BIN") == false) goto L55;
        return 12;
    L20:
        if (r100.equals("CCM_FILE_UPLOAD") == false) goto L55;
    L29:
        return 1;
    L23:
        if (r100.equals("CCM_ATTACHMENT_DOWNLOAD") == true) goto L25;
    L27:
        if (r100.equals("CCM_ATTACHMENT_UPLOAD") == true) goto L29;
    L31:
        if (r100.equals("CCM_CONTENT_COPY") == false) goto L55;
    L46:
        return 11;
    L34:
        if (r100.equals("IM_MSG_FILE_READ") == false) goto L55;
        return 8;
    L38:
        if (r100.equals("IM_MSG_FILE_COPY") == true) goto L46;
    L41:
        if (r100.equals("CCM_FILE_PREVIEW") == false) goto L55;
    L50:
        return 16;
    L44:
        if (r100.equals("CCM_CREATE_COPY") == true) goto L46;
    L48:
        if (r100.equals("IM_MSG_FILE_PREVIEW") == true) goto L50;
    L52:
        if (r100.equals("CCM_CONTENT_PREVIEW") == false) goto L55;
        return 17;
    }

    @Override // gj5.b
    public final void c(String r210, FileBizDomain r211, int r212, String r213) {
        Intrinsics.checkNotNullParameter(r210, "operate");
        Intrinsics.checkNotNullParameter(r211, "domain");
        if (r212 != 125) goto L5;
        boolean r100 = true;
    L7:
        if (r100 == false) goto L22;
        tt5.a.h("SecurityComplianceProxyImpl", "showSecurityDialog bypass conversation security, type=" + r212);
        return;
    L22:
        tt5.a.h("SecurityComplianceProxyImpl", "showSecurityDialog operate=" + r210 + ", domain=" + r211 + ", type=" + r212);     // Catch: Throwable -> L16
        ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a(l(this, r210, r211, r212, r213, null, "", "", -1, null, null, null, null, null, null, null, 65024));     // Catch: Throwable -> L14
        return;
    L14:
        th = th;
    L18:
        tt5.a.f("SecurityComplianceProxyImpl", th, false);
        return;
    L16:
        th = th;
        goto L18
    L5:
        r100 = false;
        goto L7
    }

    @Override // gj5.b
    public final gj5.c g(String r110, FileBizDomain r111, int r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "operate");
        Intrinsics.checkNotNullParameter(r111, "domain");
        return k(r110, r111, r112, r113, "", "", -1, false, null, null, null);
    }

    @Override // gj5.b
    public final void b(FileBizDomain r210, String r211, String r212, String r213, Integer r214, FileBizDomain r215) {
        Intrinsics.checkNotNullParameter("CCM_EXPORT", "operate");
        Intrinsics.checkNotNullParameter(r210, "domain");
        tt5.a.h("SecurityComplianceProxyImpl", "showSecurityDialog operate=CCM_EXPORT, domain=" + r210 + ", type=28");     // Catch: Throwable -> L9
        ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a(l(this, "CCM_EXPORT", r210, 28, r211, null, r212, r213, r214, r215, null, "MeetingMinutes", null, null, null, null, 61440));     // Catch: Throwable -> L7
        return;
    L7:
        th = th;
    L11:
        tt5.a.f("SecurityComplianceProxyImpl", th, false);
        return;
    L9:
        th = th;
        goto L11
    }

    @Override // gj5.b
    public final void d(String r110, FileBizDomain r111, int r112, String r113, Long r114, s55.c r115) {
        Intrinsics.checkNotNullParameter(r110, "operate");
        Intrinsics.checkNotNullParameter(r111, "domain");
        Intrinsics.checkNotNullParameter(r115, "callback");
        j(this, r110, r111, r112, r113, r114, "", "", CheckPriority.CacheFirst, r115);
    }

    @Override // gj5.b
    public final void a(String r100, FileBizDomain r101, int r102, String r103, Long r104, String r105, String r106, CheckPriority r107, gj5.a r110) {
        Intrinsics.checkNotNullParameter(r100, "operate");
        Intrinsics.checkNotNullParameter(r101, "domain");
        Intrinsics.checkNotNullParameter(r107, "checkPriority");
        Intrinsics.checkNotNullParameter(r110, "callback");
        j(this, r100, r101, r102, r103, r104, r105, r106, r107, r110);
    }

    public static /* synthetic */ void j(a r110, String r111, FileBizDomain r112, int r113, String r114, Long r210, String r211, String r212, CheckPriority r213, gj5.a r214) {
        r110.i(r111, r112, r113, r114, r210, r211, r212, false, r213, null, null, null, null, r214);
    }

    @Override // gj5.b
    public final gj5.c e(String r100, FileBizDomain r101, int r102, String r103, String r104, String r105, Integer r106, boolean r107, FileBizDomain r110, String r111, @EntityType String r112) {
        Intrinsics.checkNotNullParameter(r100, "operate");
        Intrinsics.checkNotNullParameter(r101, "domain");
        return k(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112);
    }

    public final gj5.c k(String r210, FileBizDomain r211, int r212, String r213, String r214, String r215, Integer r310, boolean r311, FileBizDomain r312, String r313, @EntityType String r314) {
        if (r212 != 125) goto L5;
        boolean r100 = true;
    L7:
        if (r100 == false) goto L55;
        tt5.a.h("SecurityComplianceProxyImpl", "checkSecurityPolicy bypass conversation security, type=" + r212);
        return new gj5.c(true, FileAuthResultFrom.COME_FROM_UNKNOWN);
    L55:
        tt5.a.h("SecurityComplianceProxyImpl", "checkSecurityPolicy operate=" + r210 + ", domain=" + r211 + ", type=" + r212);     // Catch: Throwable -> L49
        if (FileBizDomain.FileBizDomainUNKNOWN != r211) goto L13;
        boolean r101 = true;
    L14:
        if (r101 == false) goto L53;
        return new gj5.c(true, FileAuthResultFrom.COME_FROM_UNKNOWN);
    L53:
        PolicyModel r102 = l(this, r210, r211, r212, r213, null, r214, r215, r310, r312, r313, r314, null, null, null, null, 61440);     // Catch: Throwable -> L46
        int r103 = n(r210);     // Catch: Throwable -> L46
        int r104 = m(r212);     // Catch: Throwable -> L46
        int r105 = com.bytedance.ee.bear.middleground.permission.adminperm.a.a(r103, r104);     // Catch: Throwable -> L46
        if (r213 != null) goto L21;
        String r106 = "";
    L22:
        AuthEntity r107 = new AuthEntity(r105, r104, r106);     // Catch: Throwable -> L46
        ValidateConfig r108 = new ValidateConfig();     // Catch: Throwable -> L46
        boolean r109 = true;
        r108.setIgnoreSecurityOperate(true);     // Catch: Throwable -> L44
        r108.setIgnoreReportUserOperate(true);     // Catch: Throwable -> L44
        ValidateResult r110 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).b(r102, r107, r108);     // Catch: Throwable -> L44
        String r111 = "SecurityComplianceProxyImpl";
        tt5.a.h(r111, "checkSecurityPolicy result=" + r110.getResult() + ", source=" + r110.getResultPolicy());     // Catch: Throwable -> L42
        int r112 = b.f477366a[r110.getResult().ordinal()];     // Catch: Throwable -> L42
        if (r112 != 1) goto L29;
    L34:
        boolean r113 = true;
    L35:
        FileAuthResultFrom r114 = r110.getResultPolicy();     // Catch: Throwable -> L42
        if (r113 == false) goto L38;
    L40:
        r110.setResultPolicy(r114);     // Catch: Throwable -> L42
        gj5.c r115 = new gj5.c(r113, r110.getResultPolicy());     // Catch: Throwable -> L42
        r115.f481505c = r110;     // Catch: Throwable -> L42
        tt5.a.h(r111, "checkSecurityPolicy validResult= " + r115.f481503a + ",souce=" + r115.f481504b);     // Catch: Throwable -> L42
        return r115;
    L38:
        if (FileAuthResultFrom.COME_FROM_UNKNOWN != r114) goto L40;
        r114 = FileAuthResultFrom.COME_FROM_FILE_POLICY;     // Catch: Throwable -> L42
        goto L40
    L29:
        if (r112 != 2) goto L31;
    L33:
        r113 = false;
        goto L35
    L31:
        if (r112 == 3) goto L33;
    L42:
        th = th;
    L51:
        tt5.a.f(r111, th, false);
        return new gj5.c(r109, FileAuthResultFrom.COME_FROM_UNKNOWN);
    L44:
        th = th;
        r111 = "SecurityComplianceProxyImpl";
        goto L51
    L21:
        r106 = r213;
    L46:
        th = th;
        r111 = "SecurityComplianceProxyImpl";
    L48:
        r109 = true;
        goto L51
    L13:
        r101 = false;
    L49:
        th = th;
        r111 = "SecurityComplianceProxyImpl";
        goto L48
    L5:
        r100 = false;
        goto L7
    }

    @Override // gj5.b
    public final void f(@EntityOperate String r110, FileBizDomain r111, int r112, String r113, Long r210, String r211, String r212, CheckPriority r213, String r214, Long r215, Long r216, Long r217, k r218) {
        Intrinsics.checkNotNullParameter(r110, "operate");
        Intrinsics.checkNotNullParameter(r111, "domain");
        Intrinsics.checkNotNullParameter(r213, "checkPriority");
        Intrinsics.checkNotNullParameter(r218, "callback");
        i(r110, r111, r112, r113, r210, r211, r212, true, r213, r214, r215, r216, r217, r218);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [T, com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel] */
    public final void i(String r210, FileBizDomain r211, int r212, String r213, Long r214, String r215, String r216, boolean r310, CheckPriority r311, String r312, Long r313, Long r314, Long r315, gj5.a r316) {
        if (r212 != 125) goto L5;
        boolean r100 = true;
    L7:
        if (r100 == false) goto L45;
        tt5.a.h("SecurityComplianceProxyImpl", "asyncCheckSecurityPolicy bypass conversation security, type=" + r212);
        r316.a(new gj5.c(true, FileAuthResultFrom.COME_FROM_UNKNOWN));     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        tt5.a.d("SecurityComplianceProxyImpl", "asyncCheckSecurityPolicy bypass callback failed, errorType=".concat(th.getClass().getSimpleName()));
        return;
    L45:
        tt5.a.h("SecurityComplianceProxyImpl", "asyncCheckSecurityPolicy operate=" + r210 + ", domain=" + r211 + ", type=" + r212);     // Catch: Throwable -> L35
        if (FileBizDomain.FileBizDomainUNKNOWN != r211) goto L17;
        boolean r101 = true;
    L18:
        if (r101 == false) goto L21;
        h(r316);     // Catch: Throwable -> L35
        return;
    L21:
        Ref.ObjectRef r102 = new Ref.ObjectRef();     // Catch: Throwable -> L35
        String r217 = "SecurityComplianceProxyImpl";
        r102.element = l(this, r210, r211, r212, r213, r214, r215, r216, null, null, null, null, r312, r313, r314, r315, 3584);     // Catch: Throwable -> L33
        int r103 = n(r210);     // Catch: Throwable -> L33
        int r104 = m(r212);     // Catch: Throwable -> L33
        int r105 = com.bytedance.ee.bear.middleground.permission.adminperm.a.a(r103, r104);     // Catch: Throwable -> L33
        if (r213 != null) goto L26;
        String r106 = "";
    L27:
        AuthEntity r107 = new AuthEntity(r105, r104, r106);     // Catch: Throwable -> L33
        ValidateConfig r108 = new ValidateConfig();     // Catch: Throwable -> L33
        r108.setIgnoreSecurityOperate(true);     // Catch: Throwable -> L33
        r108.setIgnoreReportUserOperate(true);     // Catch: Throwable -> L33
        r108.setCheckPriority(r311);     // Catch: Throwable -> L33
        ((i0) org.koin.java.a.c(i0.class, null, null, 6)).d((PolicyModel) r102.element, r107, r108, new c(this, r316, r102));     // Catch: Throwable -> L31
        return;
    L31:
        th = th;
    L37:
        tt5.a.f(r217, th, false);
        h(r316);
        return;
    L26:
        r106 = r213;
    L33:
        th = th;
        goto L37
    L17:
        r101 = false;
    L35:
        th = th;
        r217 = "SecurityComplianceProxyImpl";
        goto L37
    L5:
        r100 = false;
        goto L7
    }

    public static PolicyModel l(a r210, String r211, FileBizDomain r212, int r213, String r214, Long r215, String r310, String r311, Integer r312, FileBizDomain r313, String r314, String r315, String r316, Long r317, Long r318, Long r319, int r410) {
        if ((r410 & 256) == 0) goto L5;
        Integer r100 = null;
    L7:
        if ((r410 & 512) == 0) goto L9;
        FileBizDomain r110 = null;
    L11:
        if ((r410 & 1024) == 0) goto L13;
        String r111 = null;
    L15:
        if ((r410 & 2048) == 0) goto L17;
        String r112 = null;
    L19:
        if ((r410 & 4096) == 0) goto L21;
        String r113 = null;
    L23:
        if ((r410 & 8192) == 0) goto L25;
        Long r114 = null;
    L27:
        if ((r410 & 16384) == 0) goto L29;
        Long r216 = null;
    L31:
        if ((r410 & 32768) == 0) goto L33;
        Long r101 = null;
    L34:
        r210.getClass();
        int r102 = f.f567580a;
        String r103 = f.a.g(r213);
        EntityDomain r104 = EntityDomain.EntityDomainCCM;
        AccountService$Account r105 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r105 == null) goto L37;
        String r106 = r105.tenantId;
    L38:
        if (r105 == null) goto L40;
        String r107 = r105.uid;
    L41:
        long r108 = 0;
        if (r106 == null) goto L46;
        Long r109 = StringsKt.toLongOrNull(r106);
        if (r109 == null) goto L46;
        long r217 = r109.longValue();
    L47:
        if (r107 == null) goto L52;
        Long r115 = StringsKt.toLongOrNull(r107);
        if (r115 == null) goto L52;
        r108 = r115.longValue();
    L52:
        if (r213 != 998) goto L54;
        PolicyEntity r218 = new IMFileEntity(r103, EntityDomain.EntityDomainIM, r211, r217, r108, r212, r101, r215, r113, r214, r114, r216, null, null, null, 28672, null);
    L67:
        switch(r211.hashCode()) {
            case -2098180752: goto L123;
            case -2028760642: goto L119;
            case -1636733050: goto L115;
            case -1336101129: goto L111;
            case -1292653281: goto L107;
            case -1292216512: goto L103;
            case -1117921619: goto L101;
            case -1095964469: goto L98;
            case -1091037998: goto L94;
            case -732883758: goto L90;
            case -329632833: goto L86;
            case -62825703: goto L82;
            case -60434126: goto L78;
            case 403188806: goto L74;
            case 1762321781: goto L70;
            default: goto L126;
        };
    L101:
        r211.equals("CCM_CONTENT_COPY");
    L126:
        String r116 = "PointKey_CCM_CONTENT_COPY";
    L128:
        return new PolicyModel(r116, r218, null, 4, null);
    L70:
        if (r211.equals("CCM_OPEN_EXTERNAL_ACCESS") == false) goto L126;
        r116 = "PointKey_CCM_OPEN_EXTERNAL_ACCESS";
        goto L128
    L74:
        if (r211.equals("CCM_EXPORT") == false) goto L126;
        r116 = "PointKey_CCM_EXPORT";
        goto L128
    L78:
        if (r211.equals("IM_MSG_FILE_DOWNLOAD") == false) goto L126;
        r116 = "PointKey_IM_MSG_FILE_DOWNLOAD";
        goto L128
    L82:
        if (r211.equals("CCM_FILE_DOWNLOAD") == false) goto L126;
        r116 = "PointKey_CCM_FILE_DOWNLOAD";
        goto L128
    L86:
        if (r211.equals("CCM_MOVE_RECYCLE_BIN") == false) goto L126;
        r116 = "PointKey_CCM_MOVE_RECYCLE_BIN";
        goto L128
    L90:
        if (r211.equals("CCM_FILE_UPLOAD") == false) goto L126;
        r116 = "PointKey_CCM_FILE_UPLOAD";
        goto L128
    L94:
        if (r211.equals("CCM_ATTACHMENT_DOWNLOAD") == false) goto L126;
        r116 = "PointKey_CCM_ATTACHMENT_DOWNLOAD";
        goto L128
    L98:
        if (r211.equals("CCM_ATTACHMENT_UPLOAD") == false) goto L126;
        r116 = "PointKey_CCM_FILE_ATTACHMENT_UPLOAD";
        goto L128
    L103:
        if (r211.equals("IM_MSG_FILE_READ") == false) goto L126;
        r116 = "PointKey_IM_MSG_FILE_READ";
        goto L128
    L107:
        if (r211.equals("IM_MSG_FILE_COPY") == false) goto L126;
        r116 = "PointKey_IM_MSG_FILE_COPY";
        goto L128
    L111:
        if (r211.equals("CCM_FILE_PREVIEW") == false) goto L126;
        r116 = "PointKey_CCM_FILE_PREVIEW";
        goto L128
    L115:
        if (r211.equals("CCM_CREATE_COPY") == false) goto L126;
        r116 = "PointKey_CCM_CREATE_COPY";
        goto L128
    L119:
        if (r211.equals("IM_MSG_FILE_PREVIEW") == false) goto L126;
        r116 = "PointKey_IM_MSG_FILE_PREVIEW";
        goto L128
    L123:
        if (r211.equals("CCM_CONTENT_PREVIEW") == false) goto L126;
        r116 = "PointKey_CCM_CONTENT_PREVIEW";
        goto L128
    L54:
        if (r310 == null) goto L56;
        Long r117 = StringsKt.toLongOrNull(r310);
    L57:
        if (r311 == null) goto L59;
        Long r118 = StringsKt.toLongOrNull(r311);
    L60:
        if (r100 != null) goto L62;
    L64:
        String r119 = null;
        int r120 = r213;
    L65:
        r218 = new CCMFileEntity(r103, r104, r211, r217, r108, r212, r214, r117, r118, r119, Integer.valueOf(r120), r110, r111, r112);
        goto L67
    L62:
        if (r100.intValue() == (-1)) goto L64;
        String r121 = f.a.g(r100.intValue());
        r120 = r100.intValue();
        r119 = r121;
        goto L65
    L59:
        r118 = null;
        goto L60
    L56:
        r117 = null;
    L46:
        r217 = 0;
        goto L47
    L40:
        r107 = null;
        goto L41
    L37:
        r106 = null;
        goto L38
    L33:
        r101 = r319;
        goto L34
    L29:
        r216 = r318;
        goto L31
    L25:
        r114 = r317;
        goto L27
    L21:
        r113 = r316;
        goto L23
    L17:
        r112 = r315;
        goto L19
    L13:
        r111 = r314;
        goto L15
    L9:
        r110 = r313;
        goto L11
    L5:
        r100 = r312;
        goto L7
    }
}
