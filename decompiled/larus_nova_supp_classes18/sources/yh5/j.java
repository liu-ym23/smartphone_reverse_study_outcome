package yh5;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.DenySource;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.DenyType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.ImPermEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UiStyle;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UiType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UniBaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.ee.bear.middleground.permission.permsdkimpl.model.CacParamEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.CheckPriority;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements yh5.c, ph5.f {
    public final c a;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[DenyType.values().length];
            r0[DenyType.DLP_DETECTING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L30:
            r0[DenyType.DLP_SENSATIVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L38:
            r0[DenyType.TT_BLOCK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L8:
            a = r0;
            int[] r1 = new int[FileAuthResultFrom.values().length];
            r1[FileAuthResultFrom.COME_FROM_AUTHZ.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L32:
            r1[FileAuthResultFrom.COME_FROM_FILE_POLICY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L40:
            r1[FileAuthResultFrom.COME_FROM_UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L26:
            r1[FileAuthResultFrom.COME_FROM_TT_BLOCK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L34:
            r1[FileAuthResultFrom.COME_FROM_DLP_CONTENT_DETECTING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L28:
            r1[FileAuthResultFrom.COME_FROM_DLP_CONTENT_SENSITIVE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L15:
            b = r1;
        }
    }

    public static final class c implements ph5.e {
        public final /* synthetic */ j a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[DenyType.values().length];
                r0[DenyType.FILE_STRATEGY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r0[DenyType.ADMIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r0[DenyType.TT_BLOCK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r0[DenyType.DLP_SENSATIVE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r0[DenyType.DLP_DETECTING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                a = r0;
            }
        }

        public c(j r1) {
            this.a = r1;
        }

        @Override // ph5.e
        public final void a(Context r4, PermissionResponse r5) {
            Intrinsics.checkNotNullParameter(r4, "context");
            Intrinsics.checkNotNullParameter(r5, "response");
            int r0 = f.a;
            f.a.f(r5);
            StringBuilder r1 = new StringBuilder("handleUIAction click ");
            r1.append(r5.getOperation());
            r1.append(", cache=");
            if (r5.getSecSdkResult() == null) goto L5;
            boolean r2 = true;
        L6:
            r1.append(r2);
            r1.append(", allow=");
            r1.append(r5.getAllow());
            tt5.a.h("SecurityCheckService", r1.toString());
            ValidateResult r3 = r5.getSecSdkResult();
            if (r3 == null) goto L10;
            r3.reportUserOperate();
        L10:
            if (r5.getAllow() == false) goto L12;
        L45:
            this.a.getClass();
            tt5.a.h("CacCheckService-PermissionSDK", "handleUIAction " + r5.getAllow() + ", " + r5.getDenySource());
            return;
        L12:
            if (r5.getDenySource() == null) goto L45;
            DenySource r6 = r5.getDenySource();
            if (r6 == null) goto L17;
            DenyType r7 = r6.getDenyType();
        L18:
            if (r7 != null) goto L20;
            int r8 = -1;
        L21:
            if (r8 != 1) goto L23;
            ValidateResult r9 = r5.getSecSdkResult();
            if (r9 == null) goto L49;
            r9.handleAction();
            return;
        L49:
            return;
        L23:
            if (r8 != 2) goto L25;
            Application r10 = eu5.b.a;
            Toast.showFailureText(r4, 2131887246);
            return;
        L25:
            if (r8 != 3) goto L27;
        L31:
            UiStyle r11 = r5.getUiStyle();
            if (r11 == null) goto L35;
            String r12 = r11.getToastMsg();
            if (r12 == null) goto L35;
        L37:
            if (TextUtils.isEmpty(r12) == false) goto L39;
            return;
        L39:
            Application r13 = eu5.b.a;
            Toast.showFailureText(r4, r12);
            return;
        L35:
            r12 = "";
            goto L37
        L27:
            if (r8 == 4) goto L31;
            if (r8 == 5) goto L31;
            return;
        L20:
            r8 = a.a[r7.ordinal()];
            goto L21
        L17:
            r7 = null;
            goto L18
        L5:
            r2 = false;
            goto L6
        }
    }

    static {
    }

    @Override // ph5.f
    public final String getIdentify() {
        return "CacCheckService";
    }

    public final PermissionResponse d() {
        PermissionResponse r0 = new PermissionResponse(yh5.b.a(), true, this.a);
        r0.setServiceIdentifyKey("CacCheckService");
        return r0;
    }

    public j() {
        this.a = new c(this);
    }

    public static CacParamEntity e(PermissionRequest r20) {
        tt5.a.h("CacCheckService-PermissionSDK", "paramInit " + r20);
        HashMap<String, Integer> r0 = qh5.a.a;
        if (qh5.a.a(r20.getSceneKey(), r20.getOperation(), 8) == true) goto L6;
        tt5.a.h("CacCheckService-PermissionSDK", "paramInit pass " + r20.getSceneKey());
        return new CacParamEntity(false);
    L6:
        String r5 = r20.getBaseEntity().getToken();
        sbb.e r1 = r20.getBaseEntity().getType();
        if (r1 == null) goto L9;
        int r2 = r1.b;
    L10:
        int r6 = f.a;
        BizDomain r7 = r20.getBaseEntity().getDomain();
        if (r7 != null) goto L13;
        r7 = BizDomain.FileBizDomainCCM;
    L13:
        FileBizDomain r8 = f.a.a(r7);
        String r9 = r20.getOperation();
        switch(r9.hashCode()) {
            case -2084521848: goto L38;
            case -1116803173: goto L35;
            case 2537853: goto L32;
            case 248587118: goto L29;
            case 841989170: goto L26;
            case 1609350180: goto L23;
            case 1688439000: goto L20;
            case 2059143092: goto L17;
            default: goto L41;
        };
    L41:
        boolean r10 = false;
    L42:
        String r11 = r20.getOperation();
        switch(r11.hashCode()) {
            case -2084521848: goto L97;
            case -1785265663: goto L90;
            case -1116803173: goto L83;
            case 2537853: goto L80;
            case 2634405: goto L70;
            case 82263197: goto L65;
            case 248587118: goto L61;
            case 841989170: goto L58;
            case 1609350180: goto L54;
            case 1688439000: goto L50;
            case 2059143092: goto L46;
            default: goto L135;
        };
    L46:
        if (r11.equals("EXPORT") == false) goto L135;
        String r3 = "CCM_EXPORT";
    L68:
        String r12 = r3;
        if ((r20.getBaseEntity() instanceof ImPermEntity) == false) goto L108;
        BaseEntity r4 = r20.getBaseEntity();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.export.permsdk.model.ImPermEntity");
        Long r13 = ((ImPermEntity) r4).getSenderTenantId();
        if (r13 == null) goto L108;
        long r14 = r13.longValue();
    L109:
        ImPermEntity r19 = null;
        if (r10 == false) goto L119;
        tt5.a.h("CacCheckService-PermissionSDK", "handled token1=" + du5.b.g(r5) + ", op=" + r12 + ",domain=" + r8 + ", type=" + r2);
        if ((r20.getBaseEntity() instanceof UniBaseEntity) == false) goto L118;
        BaseEntity r15 = r20.getBaseEntity();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UniBaseEntity");
        UniBaseEntity r16 = (UniBaseEntity) r15;
        Integer r17 = Integer.valueOf(r2);
        Long r18 = Long.valueOf(r14);
        String r110 = r16.getOwnerUserId();
        String r111 = r16.getCreatorTenantId();
        sbb.e r21 = r16.getTokenEntityType();
        if (r21 == null) goto L116;
        Integer r112 = Integer.valueOf(r21.b);
    L117:
        CacParamEntity r22 = new CacParamEntity(r5, r17, r12, r8, r18, r110, r111, r112, true, r16.getScopedFileBizDomain(), r16.getScopedEntityOperate(), r16.getScopedEntityType());
    L127:
        BaseEntity r23 = r20.getBaseEntity();
        if ((r23 instanceof ImPermEntity) == false) goto L130;
        r19 = (ImPermEntity) r23;
    L130:
        if (r19 == null) goto L133;
        r22.setMsgId(r19.getMsgId());
        r22.setChatID(r19.getChatID());
        r22.setChatType(r19.getChatType());
        r22.setSenderUserId(r19.getSenderUserId());
    L133:
        return r22;
    L116:
        r112 = null;
        goto L117
    L118:
        r22 = new CacParamEntity(r5, Integer.valueOf(r2), r12, r8, Long.valueOf(r14), null, null, null, true, null, null, null, 3584, null);
        goto L127
    L119:
        tt5.a.h("CacCheckService-PermissionSDK", "handled token2=" + du5.b.g(r5) + ", op=" + r12 + ",domain=" + r8 + ", type=" + r2);
        if ((r20.getBaseEntity() instanceof UniBaseEntity) == false) goto L126;
        BaseEntity r24 = r20.getBaseEntity();
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UniBaseEntity");
        UniBaseEntity r25 = (UniBaseEntity) r24;
        Integer r26 = Integer.valueOf(r2);
        Long r27 = Long.valueOf(r14);
        String r113 = r25.getOwnerUserId();
        String r114 = r25.getCreatorTenantId();
        sbb.e r28 = r25.getTokenEntityType();
        if (r28 == null) goto L124;
        Integer r115 = Integer.valueOf(r28.b);
    L125:
        r22 = new CacParamEntity(r5, r26, r12, r8, r27, r113, r114, r115, false, r25.getScopedFileBizDomain(), r25.getScopedEntityOperate(), r25.getScopedEntityType());
        goto L127
    L124:
        r115 = null;
        goto L125
    L126:
        r22 = new CacParamEntity(r5, Integer.valueOf(r2), r12, r8, Long.valueOf(r14), "", "", -1, false, null, null, null, 3584, null);
    L108:
        r14 = 0;
        goto L109
    L50:
        if (r11.equals("CREATE_COPY") == false) goto L135;
        r3 = "CCM_CREATE_COPY";
        goto L68
    L54:
        if (r11.equals("ATTACHMENT_DOWNLOAD") == false) goto L135;
        r3 = "CCM_ATTACHMENT_DOWNLOAD";
        goto L68
    L58:
        if (r11.equals("OTHER_APP") == false) goto L135;
    L100:
        if (BizDomain.FileBizDomainIM != r20.getBaseEntity().getDomain()) goto L102;
        r3 = "IM_MSG_FILE_DOWNLOAD";
        goto L68
    L102:
        r3 = "CCM_FILE_DOWNLOAD";
        goto L68
    L61:
        if (r11.equals("FILE_EXTERNAL_SHARE") == false) goto L135;
        r3 = "CCM_OPEN_EXTERNAL_ACCESS";
        goto L68
    L65:
        if (r11.equals("ATTACHMENT_UPLOAD") == false) goto L135;
        r3 = "CCM_ATTACHMENT_UPLOAD";
        goto L68
    L70:
        if (r11.equals("VIEW") == false) goto L135;
        sbb.e r29 = r20.getBaseEntity().getType();
        if (Intrinsics.areEqual(sbb.e.x, r29) == false) goto L75;
    L78:
        r3 = "CCM_FILE_PREVIEW";
        goto L68
    L75:
        if (Intrinsics.areEqual(sbb.e.l, r29) == true) goto L78;
        r3 = "CCM_CONTENT_PREVIEW";
        goto L68
    L80:
        if (r11.equals("SAVE") == true) goto L100;
    L83:
        if (r11.equals("CONTENT_COPY") == false) goto L135;
        if (BizDomain.FileBizDomainIM != r20.getBaseEntity().getDomain()) goto L88;
        r3 = "IM_MSG_FILE_COPY";
        goto L68
    L88:
        r3 = "CCM_CONTENT_COPY";
        goto L68
    L90:
        if (r11.equals("UPLOAD") == false) goto L135;
        if (BizDomain.FileBizDomainIM != r20.getBaseEntity().getDomain()) goto L95;
        r3 = "IM_MSG_FILE_UPLOAD";
        goto L68
    L95:
        r3 = "CCM_FILE_UPLOAD";
        goto L68
    L97:
        if (r11.equals("DOWNLOAD") == true) goto L100;
    L135:
        return new CacParamEntity(false);
    L17:
        if (r9.equals("EXPORT") == false) goto L41;
    L40:
        r10 = true;
        goto L42
    L20:
        if (r9.equals("CREATE_COPY") == true) goto L40;
    L23:
        if (r9.equals("ATTACHMENT_DOWNLOAD") == true) goto L40;
    L26:
        if (r9.equals("OTHER_APP") == true) goto L40;
    L29:
        if (r9.equals("FILE_EXTERNAL_SHARE") == false) goto L41;
    L32:
        if (r9.equals("SAVE") == true) goto L40;
    L35:
        if (r9.equals("CONTENT_COPY") == true) goto L40;
    L38:
        if (r9.equals("DOWNLOAD") == true) goto L40;
    L9:
        r2 = -1;
        goto L10
    }

    public static DenySource c(boolean r1, FileAuthResultFrom r2) {
        if (r1 == false) goto L6;
        return yh5.b.a();
    L6:
        switch(b.b[r2.ordinal()]) {
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            default: goto L7;
        };
    L7:
        tt5.a.k("CacCheckService-PermissionSDK", "getDenySource error type");
        return new DenySource(DenyType.ADMIN, UiType.DISABLED);
    L10:
        return new DenySource(DenyType.DLP_SENSATIVE, UiType.DEFAULT);
    L12:
        return new DenySource(DenyType.DLP_DETECTING, UiType.DEFAULT);
    L14:
        return new DenySource(DenyType.TT_BLOCK, UiType.DEFAULT);
    L16:
        return new DenySource(DenyType.FILE_STRATEGY, UiType.DISABLED);
    L18:
        return new DenySource(DenyType.FILE_STRATEGY, UiType.DISABLED);
    L20:
        return new DenySource(DenyType.ADMIN, UiType.DISABLED);
    }

    @Override // yh5.c
    public final void a(PermissionRequest r19, i r20) {
        Intrinsics.checkNotNullParameter(r19, "request");
        Intrinsics.checkNotNullParameter(r20, "callback");
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        CacParamEntity r3 = e(r19);
        r2.element = r3;
        if (r3.getShouldCheck() == true) goto L6;
        r20.a(d());
        return;
    L6:
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).f(((CacParamEntity) r2.element).getOperation(), ((CacParamEntity) r2.element).getDomain(), ((CacParamEntity) r2.element).getType(), ((CacParamEntity) r2.element).getToken(), Long.valueOf(((CacParamEntity) r2.element).getSenderTenantId()), ((CacParamEntity) r2.element).getOwnerUserId(), ((CacParamEntity) r2.element).getCreatorTenantId(), CheckPriority.CacheFirst, ((CacParamEntity) r2.element).getMsgId(), ((CacParamEntity) r2.element).getChatID(), ((CacParamEntity) r2.element).getChatType(), ((CacParamEntity) r2.element).getSenderUserId(), new k(this, r20, r19, r2));
    }

    @Override // yh5.c
    public final PermissionResponse b(PermissionRequest r18, UserPermissionEntity r19) {
        Intrinsics.checkNotNullParameter(r18, "request");
        CacParamEntity r1 = e(r18);
        if (r1.getShouldCheck() == false) goto L5;
        int r2 = f.a;
        if (f.a.d(r18, r19) == false) goto L10;
        tt5.a.h("SecurityCheckService", "Escaped operation" + r18.getOperation());
        return d();
    L10:
        UiStyle r3 = null;
        gj5.c r4 = ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).e(r1.getOperation(), r1.getDomain(), r1.getType(), r1.getToken(), r1.getOwnerUserId(), r1.getCreatorTenantId(), r1.getTokenEntityType(), r1.isAdd(), r1.getScopedFileBizDomain(), r1.getScopedEntityOperate(), r1.getScopedEntityType());
        DenySource r5 = c(r4.a, r4.b);
        PermissionResponse r6 = new PermissionResponse(r5, r4.a, this.a);
        String r7 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2().tenantId;
        if (TextUtils.isEmpty(r1.getCreatorTenantId()) == false) goto L13;
    L15:
        boolean r8 = false;
    L16:
        int r9 = b.a[r5.getDenyType().ordinal()];
        String r10 = "";
        if (r9 != 1) goto L19;
        if (r8 == false) goto L38;
        int r11 = 900099002;
    L39:
        String r12 = r1.getToken();
        String r13 = r1.getOperation();
        if (r12 == null) goto L43;
        r10 = r12;
    L43:
        UiStyle r14 = new UiStyle(f.a.b(r10, r13, r11));
    L44:
        r3 = r14;
    L45:
        r6.setUiStyle(r3);
        r6.setSdkCacheEntity(r1);
        r6.setSecSdkResult(r4.c);
        r6.setOperation(r1.getOperation());
        r6.setCacheReqRequest(r18);
        r6.setServiceIdentifyKey("CacCheckService");
        return r6;
    L38:
        r11 = 900099001;
        goto L39
    L19:
        if (r9 != 2) goto L21;
        if (r8 == false) goto L30;
        int r15 = 900099004;
    L31:
        String r16 = r1.getToken();
        String r17 = r1.getOperation();
        if (r16 == null) goto L35;
        r10 = r16;
    L35:
        r14 = new UiStyle(f.a.b(r10, r17, r15));
        goto L44
    L30:
        r15 = 900099003;
        goto L31
    L21:
        if (r9 != 3) goto L45;
        String r20 = r1.getToken();
        String r21 = r1.getOperation();
        if (r20 == null) goto L27;
        r10 = r20;
    L27:
        r14 = new UiStyle(f.a.b(r10, r21, -900099004));
        goto L44
    L13:
        if (TextUtils.isEmpty(r7) == true) goto L15;
        r8 = !TextUtils.equals(r1.getCreatorTenantId(), r7);
        goto L16
    L5:
        return d();
    }
}
