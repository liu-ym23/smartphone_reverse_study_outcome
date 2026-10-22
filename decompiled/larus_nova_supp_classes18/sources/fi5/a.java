package fi5;

import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.lark.dependency.i0;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.ss.android.lark.security.compliance.api.model.filepolicy.AuthEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.CCMFileEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.CheckPriority;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityOperate;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.IMFileEntity;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements gj5.b {

    /* JADX INFO: renamed from: fi5.a$a, reason: collision with other inner class name */
    public static final class C0231a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ResultType.values().length];
            r0[ResultType.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[ResultType.DENY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[ResultType.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[ResultType.ALLOW.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[ResultType.NULL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static final class c implements m {
        public final /* synthetic */ a a;
        public final /* synthetic */ gj5.a b;
        public final /* synthetic */ Ref.ObjectRef<PolicyModel> c;

        public final void onResult(Map<String, ValidateResult> r5) {
            Intrinsics.checkNotNullParameter(r5, "result");
            if (r5.isEmpty() == false) goto L6;
            a r6 = this.a;
            gj5.a r0 = this.b;
            r6.getClass();
            a.h(r0);
            return;
        L6:
            ValidateResult r7 = r5.get(((PolicyModel) this.c.element).getTaskId());
            if (r7 != null) goto L10;
            a r8 = this.a;
            gj5.a r1 = this.b;
            r8.getClass();
            a.h(r1);
            return;
        L10:
            tt5.a.h("SecurityComplianceProxyImpl", "asyncCheckSecurityPolicy result=" + r7.getResult() + ", source=" + r7.getResultPolicy());
            a r2 = this.a;
            ResultType r3 = r7.getResult();
            r2.getClass();
            int r4 = b.a[r3.ordinal()];
            boolean r9 = true;
            if (r4 != 1) goto L13;
        L18:
            a r10 = this.a;
            FileAuthResultFrom r11 = r7.getResultPolicy();
            r10.getClass();
            if (r9 == false) goto L21;
        L23:
            r7.setResultPolicy(r11);
            gj5.c r12 = new gj5.c(r9, r7.getResultPolicy());
            r12.c = r7;
            tt5.a.h("SecurityComplianceProxyImpl", "asyncCheckSecurityPolicy validResult= " + r12.a + ",souce=" + r12.b);
            this.b.a(r12);
            return;
        L21:
            if (FileAuthResultFrom.COME_FROM_UNKNOWN != r11) goto L23;
            r11 = FileAuthResultFrom.COME_FROM_FILE_POLICY;
            goto L23
        L13:
            if (r4 != 2) goto L15;
        L17:
            r9 = false;
            goto L18
        L15:
            if (r4 == 3) goto L17;
            goto L17
        }

        public c(a r1, gj5.a r2, Ref.ObjectRef<PolicyModel> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public a() {
    }

    public static void h(gj5.a r3) {
        if (r3 == null) goto L5;
        r3.a(new gj5.c(true, FileAuthResultFrom.COME_FROM_UNKNOWN));
        return;
    }

    public static int m(int r1) {
        if (r1 != e.g.b) goto L6;
        return 6;
    L6:
        if (r1 != e.h.b) goto L9;
        return 7;
    L9:
        if (r1 != e.k.b) goto L12;
        return 9;
    L12:
        if (r1 != e.l.b) goto L15;
        return 10;
    L15:
        if (r1 != e.i.b) goto L18;
        return 8;
    L18:
        if (r1 != e.m.b) goto L20;
        return 11;
    L20:
        return 1;
    }

    public static int n(@EntityOperate String r1) {
        switch(r1.hashCode()) {
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
        if (r1.equals("CCM_EXPORT") == false) goto L55;
        return 4;
    L10:
        if (r1.equals("IM_MSG_FILE_DOWNLOAD") == false) goto L55;
    L25:
        return 3;
    L13:
        if (r1.equals("CCM_FILE_DOWNLOAD") == true) goto L25;
    L16:
        if (r1.equals("CCM_MOVE_RECYCLE_BIN") == false) goto L55;
        return 12;
    L20:
        if (r1.equals("CCM_FILE_UPLOAD") == false) goto L55;
    L29:
        return 1;
    L23:
        if (r1.equals("CCM_ATTACHMENT_DOWNLOAD") == true) goto L25;
    L27:
        if (r1.equals("CCM_ATTACHMENT_UPLOAD") == true) goto L29;
    L31:
        if (r1.equals("CCM_CONTENT_COPY") == false) goto L55;
    L46:
        return 11;
    L34:
        if (r1.equals("IM_MSG_FILE_READ") == false) goto L55;
        return 8;
    L38:
        if (r1.equals("IM_MSG_FILE_COPY") == true) goto L46;
    L41:
        if (r1.equals("CCM_FILE_PREVIEW") == false) goto L55;
    L50:
        return 16;
    L44:
        if (r1.equals("CCM_CREATE_COPY") == true) goto L46;
    L48:
        if (r1.equals("IM_MSG_FILE_PREVIEW") == true) goto L50;
    L52:
        if (r1.equals("CCM_CONTENT_PREVIEW") == false) goto L55;
        return 17;
    }

    @Override // gj5.b
    public final void c(String r22, FileBizDomain r23, int r24, String r25) {
        Intrinsics.checkNotNullParameter(r22, "operate");
        Intrinsics.checkNotNullParameter(r23, "domain");
        if (r24 != 125) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L22;
        tt5.a.h("SecurityComplianceProxyImpl", "showSecurityDialog bypass conversation security, type=" + r24);
        return;
    L22:
        tt5.a.h("SecurityComplianceProxyImpl", "showSecurityDialog operate=" + r22 + ", domain=" + r23 + ", type=" + r24);     // Catch: Throwable -> L16
        ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a(l(this, r22, r23, r24, r25, null, "", "", -1, null, null, null, null, null, null, null, 65024));     // Catch: Throwable -> L14
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
        r2 = false;
        goto L7
    }

    @Override // gj5.b
    public final gj5.c g(String r14, FileBizDomain r15, int r16, String r17) {
        Intrinsics.checkNotNullParameter(r14, "operate");
        Intrinsics.checkNotNullParameter(r15, "domain");
        return k(r14, r15, r16, r17, "", "", -1, false, null, null, null);
    }

    @Override // gj5.b
    public final void b(FileBizDomain r21, String r22, String r23, String r24, Integer r25, FileBizDomain r26) {
        Intrinsics.checkNotNullParameter("CCM_EXPORT", "operate");
        Intrinsics.checkNotNullParameter(r21, "domain");
        tt5.a.h("SecurityComplianceProxyImpl", "showSecurityDialog operate=CCM_EXPORT, domain=" + r21 + ", type=28");     // Catch: Throwable -> L9
        ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a(l(this, "CCM_EXPORT", r21, 28, r22, null, r23, r24, r25, r26, null, "MeetingMinutes", null, null, null, null, 61440));     // Catch: Throwable -> L7
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
    public final void d(String r12, FileBizDomain r13, int r14, String r15, Long r16, s55.c r17) {
        Intrinsics.checkNotNullParameter(r12, "operate");
        Intrinsics.checkNotNullParameter(r13, "domain");
        Intrinsics.checkNotNullParameter(r17, "callback");
        j(this, r12, r13, r14, r15, r16, "", "", CheckPriority.CacheFirst, r17);
    }

    @Override // gj5.b
    public final void a(String r2, FileBizDomain r3, int r4, String r5, Long r6, String r7, String r8, CheckPriority r9, gj5.a r10) {
        Intrinsics.checkNotNullParameter(r2, "operate");
        Intrinsics.checkNotNullParameter(r3, "domain");
        Intrinsics.checkNotNullParameter(r9, "checkPriority");
        Intrinsics.checkNotNullParameter(r10, "callback");
        j(this, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ void j(a r15, String r16, FileBizDomain r17, int r18, String r19, Long r20, String r21, String r22, CheckPriority r23, gj5.a r24) {
        r15.i(r16, r17, r18, r19, r20, r21, r22, false, r23, null, null, null, null, r24);
    }

    @Override // gj5.b
    public final gj5.c e(String r2, FileBizDomain r3, int r4, String r5, String r6, String r7, Integer r8, boolean r9, FileBizDomain r10, String r11, @EntityType String r12) {
        Intrinsics.checkNotNullParameter(r2, "operate");
        Intrinsics.checkNotNullParameter(r3, "domain");
        return k(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public final gj5.c k(String r24, FileBizDomain r25, int r26, String r27, String r28, String r29, Integer r30, boolean r31, FileBizDomain r32, String r33, @EntityType String r34) {
        if (r26 != 125) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L55;
        tt5.a.h("SecurityComplianceProxyImpl", "checkSecurityPolicy bypass conversation security, type=" + r26);
        return new gj5.c(true, FileAuthResultFrom.COME_FROM_UNKNOWN);
    L55:
        tt5.a.h("SecurityComplianceProxyImpl", "checkSecurityPolicy operate=" + r24 + ", domain=" + r25 + ", type=" + r26);     // Catch: Throwable -> L49
        if (FileBizDomain.FileBizDomainUNKNOWN != r25) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == false) goto L53;
        return new gj5.c(true, FileAuthResultFrom.COME_FROM_UNKNOWN);
    L53:
        PolicyModel r3 = l(this, r24, r25, r26, r27, null, r28, r29, r30, r32, r33, r34, null, null, null, null, 61440);     // Catch: Throwable -> L46
        int r4 = n(r24);     // Catch: Throwable -> L46
        int r5 = m(r26);     // Catch: Throwable -> L46
        int r6 = com.bytedance.ee.bear.middleground.permission.adminperm.a.a(r4, r5);     // Catch: Throwable -> L46
        if (r27 != null) goto L21;
        String r7 = "";
    L22:
        AuthEntity r8 = new AuthEntity(r6, r5, r7);     // Catch: Throwable -> L46
        ValidateConfig r9 = new ValidateConfig();     // Catch: Throwable -> L46
        boolean r10 = true;
        r9.setIgnoreSecurityOperate(true);     // Catch: Throwable -> L44
        r9.setIgnoreReportUserOperate(true);     // Catch: Throwable -> L44
        ValidateResult r11 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).b(r3, r8, r9);     // Catch: Throwable -> L44
        String r12 = "SecurityComplianceProxyImpl";
        tt5.a.h(r12, "checkSecurityPolicy result=" + r11.getResult() + ", source=" + r11.getResultPolicy());     // Catch: Throwable -> L42
        int r0 = b.a[r11.getResult().ordinal()];     // Catch: Throwable -> L42
        if (r0 != 1) goto L29;
    L34:
        boolean r13 = true;
    L35:
        FileAuthResultFrom r14 = r11.getResultPolicy();     // Catch: Throwable -> L42
        if (r13 == false) goto L38;
    L40:
        r11.setResultPolicy(r14);     // Catch: Throwable -> L42
        gj5.c r15 = new gj5.c(r13, r11.getResultPolicy());     // Catch: Throwable -> L42
        r15.c = r11;     // Catch: Throwable -> L42
        tt5.a.h(r12, "checkSecurityPolicy validResult= " + r15.a + ",souce=" + r15.b);     // Catch: Throwable -> L42
        return r15;
    L38:
        if (FileAuthResultFrom.COME_FROM_UNKNOWN != r14) goto L40;
        r14 = FileAuthResultFrom.COME_FROM_FILE_POLICY;     // Catch: Throwable -> L42
        goto L40
    L29:
        if (r0 != 2) goto L31;
    L33:
        r13 = false;
        goto L35
    L31:
        if (r0 == 3) goto L33;
    L42:
        th = th;
    L51:
        tt5.a.f(r12, th, false);
        return new gj5.c(r10, FileAuthResultFrom.COME_FROM_UNKNOWN);
    L44:
        th = th;
        r12 = "SecurityComplianceProxyImpl";
        goto L51
    L21:
        r7 = r27;
    L46:
        th = th;
        r12 = "SecurityComplianceProxyImpl";
    L48:
        r10 = true;
        goto L51
    L13:
        r1 = false;
    L49:
        th = th;
        r12 = "SecurityComplianceProxyImpl";
        goto L48
    L5:
        r2 = false;
        goto L7
    }

    @Override // gj5.b
    public final void f(@EntityOperate String r16, FileBizDomain r17, int r18, String r19, Long r20, String r21, String r22, CheckPriority r23, String r24, Long r25, Long r26, Long r27, k r28) {
        Intrinsics.checkNotNullParameter(r16, "operate");
        Intrinsics.checkNotNullParameter(r17, "domain");
        Intrinsics.checkNotNullParameter(r23, "checkPriority");
        Intrinsics.checkNotNullParameter(r28, "callback");
        i(r16, r17, r18, r19, r20, r21, r22, true, r23, r24, r25, r26, r27, r28);
    }

    public final void i(String r23, FileBizDomain r24, int r25, String r26, Long r27, String r28, String r29, boolean r30, CheckPriority r31, String r32, Long r33, Long r34, Long r35, gj5.a r36) {
        if (r25 != 125) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L45;
        tt5.a.h("SecurityComplianceProxyImpl", "asyncCheckSecurityPolicy bypass conversation security, type=" + r25);
        r36.a(new gj5.c(true, FileAuthResultFrom.COME_FROM_UNKNOWN));     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        tt5.a.d("SecurityComplianceProxyImpl", "asyncCheckSecurityPolicy bypass callback failed, errorType=".concat(th.getClass().getSimpleName()));
        return;
    L45:
        tt5.a.h("SecurityComplianceProxyImpl", "asyncCheckSecurityPolicy operate=" + r23 + ", domain=" + r24 + ", type=" + r25);     // Catch: Throwable -> L35
        if (FileBizDomain.FileBizDomainUNKNOWN != r24) goto L17;
        boolean r1 = true;
    L18:
        if (r1 == false) goto L21;
        h(r36);     // Catch: Throwable -> L35
        return;
    L21:
        Ref.ObjectRef r9 = new Ref.ObjectRef();     // Catch: Throwable -> L35
        String r21 = "SecurityComplianceProxyImpl";
        r9.element = l(this, r23, r24, r25, r26, r27, r28, r29, null, null, null, null, r32, r33, r34, r35, 3584);     // Catch: Throwable -> L33
        int r3 = n(r23);     // Catch: Throwable -> L33
        int r4 = m(r25);     // Catch: Throwable -> L33
        int r5 = com.bytedance.ee.bear.middleground.permission.adminperm.a.a(r3, r4);     // Catch: Throwable -> L33
        if (r26 != null) goto L26;
        String r6 = "";
    L27:
        AuthEntity r7 = new AuthEntity(r5, r4, r6);     // Catch: Throwable -> L33
        ValidateConfig r8 = new ValidateConfig();     // Catch: Throwable -> L33
        r8.setIgnoreSecurityOperate(true);     // Catch: Throwable -> L33
        r8.setIgnoreReportUserOperate(true);     // Catch: Throwable -> L33
        r8.setCheckPriority(r31);     // Catch: Throwable -> L33
        ((i0) org.koin.java.a.c(i0.class, null, null, 6)).d((PolicyModel) r9.element, r7, r8, new c(this, r36, r9));     // Catch: Throwable -> L31
        return;
    L31:
        th = th;
    L37:
        tt5.a.f(r21, th, false);
        h(r36);
        return;
    L26:
        r6 = r26;
    L33:
        th = th;
        goto L37
    L17:
        r1 = false;
    L35:
        th = th;
        r21 = "SecurityComplianceProxyImpl";
        goto L37
    L5:
        r2 = false;
        goto L7
    }

    public static PolicyModel l(a r24, String r25, FileBizDomain r26, int r27, String r28, Long r29, String r30, String r31, Integer r32, FileBizDomain r33, String r34, String r35, String r36, Long r37, Long r38, Long r39, int r40) {
        if ((r40 & 256) == 0) goto L5;
        Integer r1 = null;
    L7:
        if ((r40 & 512) == 0) goto L9;
        FileBizDomain r15 = null;
    L11:
        if ((r40 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L13;
        String r16 = null;
    L15:
        if ((r40 & DocUserPermission.USER_PREVIEW) == 0) goto L17;
        String r17 = null;
    L19:
        if ((r40 & DocUserPermission.USER_PERCEIVE) == 0) goto L21;
        String r11 = null;
    L23:
        if ((r40 & 8192) == 0) goto L25;
        Long r13 = null;
    L27:
        if ((r40 & 16384) == 0) goto L29;
        Long r20 = null;
    L31:
        if ((r40 & 32768) == 0) goto L33;
        Long r9 = null;
    L34:
        r24.getClass();
        int r0 = f.a;
        String r3 = f.a.g(r27);
        EntityDomain r4 = EntityDomain.EntityDomainCCM;
        AccountService.Account r2 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r2 == null) goto L37;
        String r5 = r2.tenantId;
    L38:
        if (r2 == null) goto L40;
        String r6 = r2.uid;
    L41:
        long r7 = 0;
        if (r5 == null) goto L46;
        Long r8 = StringsKt.toLongOrNull(r5);
        if (r8 == null) goto L46;
        long r21 = r8.longValue();
    L47:
        if (r6 == null) goto L52;
        Long r10 = StringsKt.toLongOrNull(r6);
        if (r10 == null) goto L52;
        r7 = r10.longValue();
    L52:
        if (r27 != 998) goto L54;
        IMFileEntity r23 = new IMFileEntity(r3, EntityDomain.EntityDomainIM, r25, r21, r7, r26, r9, r29, r11, r28, r13, r20, null, null, null, 28672, null);
    L67:
        switch(r25.hashCode()) {
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
        r25.equals("CCM_CONTENT_COPY");
    L126:
        String r12 = "PointKey_CCM_CONTENT_COPY";
    L128:
        return new PolicyModel(r12, r23, null, 4, null);
    L70:
        if (r25.equals("CCM_OPEN_EXTERNAL_ACCESS") == false) goto L126;
        r12 = "PointKey_CCM_OPEN_EXTERNAL_ACCESS";
        goto L128
    L74:
        if (r25.equals("CCM_EXPORT") == false) goto L126;
        r12 = "PointKey_CCM_EXPORT";
        goto L128
    L78:
        if (r25.equals("IM_MSG_FILE_DOWNLOAD") == false) goto L126;
        r12 = "PointKey_IM_MSG_FILE_DOWNLOAD";
        goto L128
    L82:
        if (r25.equals("CCM_FILE_DOWNLOAD") == false) goto L126;
        r12 = "PointKey_CCM_FILE_DOWNLOAD";
        goto L128
    L86:
        if (r25.equals("CCM_MOVE_RECYCLE_BIN") == false) goto L126;
        r12 = "PointKey_CCM_MOVE_RECYCLE_BIN";
        goto L128
    L90:
        if (r25.equals("CCM_FILE_UPLOAD") == false) goto L126;
        r12 = "PointKey_CCM_FILE_UPLOAD";
        goto L128
    L94:
        if (r25.equals("CCM_ATTACHMENT_DOWNLOAD") == false) goto L126;
        r12 = "PointKey_CCM_ATTACHMENT_DOWNLOAD";
        goto L128
    L98:
        if (r25.equals("CCM_ATTACHMENT_UPLOAD") == false) goto L126;
        r12 = "PointKey_CCM_FILE_ATTACHMENT_UPLOAD";
        goto L128
    L103:
        if (r25.equals("IM_MSG_FILE_READ") == false) goto L126;
        r12 = "PointKey_IM_MSG_FILE_READ";
        goto L128
    L107:
        if (r25.equals("IM_MSG_FILE_COPY") == false) goto L126;
        r12 = "PointKey_IM_MSG_FILE_COPY";
        goto L128
    L111:
        if (r25.equals("CCM_FILE_PREVIEW") == false) goto L126;
        r12 = "PointKey_CCM_FILE_PREVIEW";
        goto L128
    L115:
        if (r25.equals("CCM_CREATE_COPY") == false) goto L126;
        r12 = "PointKey_CCM_CREATE_COPY";
        goto L128
    L119:
        if (r25.equals("IM_MSG_FILE_PREVIEW") == false) goto L126;
        r12 = "PointKey_IM_MSG_FILE_PREVIEW";
        goto L128
    L123:
        if (r25.equals("CCM_CONTENT_PREVIEW") == false) goto L126;
        r12 = "PointKey_CCM_CONTENT_PREVIEW";
        goto L128
    L54:
        if (r30 == null) goto L56;
        Long r14 = StringsKt.toLongOrNull(r30);
    L57:
        if (r31 == null) goto L59;
        Long r18 = StringsKt.toLongOrNull(r31);
    L60:
        if (r1 != null) goto L62;
    L64:
        String r19 = null;
        int r22 = r27;
    L65:
        r23 = new CCMFileEntity(r3, r4, r25, r21, r7, r26, r28, r14, r18, r19, Integer.valueOf(r22), r15, r16, r17);
        goto L67
    L62:
        if (r1.intValue() == (-1)) goto L64;
        String r41 = f.a.g(r1.intValue());
        r22 = r1.intValue();
        r19 = r41;
        goto L65
    L59:
        r18 = null;
        goto L60
    L56:
        r14 = null;
    L46:
        r21 = 0;
        goto L47
    L40:
        r6 = null;
        goto L41
    L37:
        r5 = null;
        goto L38
    L33:
        r9 = r39;
        goto L34
    L29:
        r20 = r38;
        goto L31
    L25:
        r13 = r37;
        goto L27
    L21:
        r11 = r36;
        goto L23
    L17:
        r17 = r35;
        goto L19
    L13:
        r16 = r34;
        goto L15
    L9:
        r15 = r33;
        goto L11
    L5:
        r1 = r32;
        goto L7
    }
}
