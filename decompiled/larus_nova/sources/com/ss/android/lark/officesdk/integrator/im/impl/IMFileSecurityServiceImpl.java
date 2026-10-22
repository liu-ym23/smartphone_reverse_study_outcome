package com.ss.android.lark.officesdk.integrator.im.impl;

import android.content.Context;
import com.larus.nova.R;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.auditsdk.v2.receivecheck.ImFileAuthorityChecker;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.AuthorityParam;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.auditsdk.v2.utils.AuditUtilsV2;
import com.ss.android.lark.auditsdk.wrapper.AuditService;
import com.ss.android.lark.biz.officesdk.im.file.FlowFilePreviewData;
import com.ss.android.lark.biz.officesdk.im.file.OpenFeishuFileSecurityBlockReason;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.cleanresource.ResourceType;
import java.util.ArrayList;
import java.util.HashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class IMFileSecurityServiceImpl implements jza.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f433281b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f433282a;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f433283a = null;

        static {
            int[] r100 = new int[MessagePermissionUtil.ReceiveAuthorizationState.values().length];
            r100[MessagePermissionUtil.ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MessagePermissionUtil.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f433283a = r100;
        }
    }

    static {
    }

    @Inject
    public IMFileSecurityServiceImpl() {
        this.f433282a = LazyKt.lazy(IMFileSecurityServiceImpl$authorityChecker$2.INSTANCE);
    }

    @Override // jza.c
    public final void d(FlowFilePreviewData r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        AuditService r101 = owa.a.a();
        if (r101 == null) goto L19;
        String r102 = r100.f410588i.f501216a;
        String r103 = r100.f410585f;
        String r104 = "";
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        String r105 = r100.f410583d;
        if (r105 != null) goto L10;
        String r106 = "";
    L11:
        if (r105 == null) goto L13;
        String r107 = StringsKt.substringAfterLast(r105, '.', "");
    L14:
        if (r107 == null) goto L17;
        r104 = r107;
    L17:
        r101.c(r102, r103, r106, r104);
        return;
    L13:
        r107 = null;
        goto L14
    L10:
        r106 = r105;
        goto L11
    }

    public final void e(Message r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        ValidateIMFileResult r100 = r110.getValidateIMFileResult();
        Long r101 = null;
        if (r100 == null) goto L7;
        IMFileResult r102 = r100.getResultType();
    L8:
        if (r102 == null) goto L16;
        ValidateIMFileResult r103 = r110.getValidateIMFileResult();
        if (r103 == null) goto L12;
        IMFileResult r104 = r103.getResultType();
    L14:
        if (r104 == IMFileResult.UNKNOWN) goto L16;
        return;
    L12:
        r104 = null;
    L16:
        pmb.i r105 = nmb.a.a().getPassportDependency();
        String r106 = r105.getUserId();
        if (r106 == null) goto L21;
        Long r107 = StringsKt.toLongOrNull(r106);
        if (r107 == null) goto L21;
        long r108 = r107.longValue();
    L22:
        int r109 = AuthorityParam.f409659j;
        String r111 = r105.getTenantId();
        AuthorityParam.Companion.AuthScene r112 = AuthorityParam.Companion.AuthScene.IM_FILE_LOCAL_AUTHORITY_INTERCEPTOR;
        long r113 = AuthorityParam.Companion.a(r111, r112);
        AuthorityParam.a r114 = new AuthorityParam.a();
        r114.f409671a = r110.getId();
        r114.f409674d = Long.valueOf(AuthorityParam.Companion.a(r110.getFromId(), r112));
        String r115 = r110.getFromChatterTenantId();
        if (r115 == null) goto L25;
        r101 = Long.valueOf(AuthorityParam.Companion.a(r115, r112));
    L25:
        r114.f409673c = r101;
        r114.f409676f = r108;
        r114.f409675e = r113;
        AuthorityParam.AuthorityExtraParam r116 = new AuthorityParam.AuthorityExtraParam(r110.isPreMessage(), r110.isFromMe(), false, 4, null);
        Intrinsics.checkNotNullParameter(r116, "authorityExtraParam");
        r114.f409679i = r116;
        AuthorityParam r117 = r114.a();
        if (r110.getFromChatterTenantId() != null) goto L28;
        AuthorityParam.Companion.b(r112, "tenant id is null fo chatter not null");
    L28:
        ValidateIMFileResult r118 = (ValidateIMFileResult) ((HashMap) ((ImFileAuthorityChecker) this.f433282a.getValue()).b(MapsKt.mapOf(TuplesKt.to(r110.getId(), r117)), true)).get(r110.getId());
        if (r118 == null) goto L32;
        r110.setValidateIMFileResult(r118);
        return;
    L32:
        return;
    L21:
        r108 = 0;
        goto L22
    L7:
        r102 = null;
        goto L8
    }

    @Override // jza.c
    public final boolean b(Context r100, Message r101, Chat r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "message");
        e(r101);
        if (r101.getType() != Message.Type.FILE) goto L5;
        boolean r103 = true;
    L6:
        ResourceCleanScene r104 = null;
        if (r103 == false) goto L9;
        Message r105 = r101;
    L10:
        if (r105 == null) goto L12;
        FileContent r106 = (FileContent) r105.getContent();
    L14:
        if ((r106 instanceof FileContent) == true) goto L17;
        r106 = null;
    L17:
        if (r106 != null) goto L19;
    L21:
        boolean r107 = false;
    L22:
        if (r107 == false) goto L24;
    L62:
        ResourceType r108 = ResourceType.FILE;
        if (r106 == null) goto L65;
        r104 = r106.currentResourceScene();
    L65:
        acc.a.f(r100, new acc.d(r108, r104, acc.a.d(r101.getFromChatterTenantId())));
        return true;
    L24:
        if (r101.isCleaned() == true) goto L62;
        ValidateIMFileResult r109 = r101.getValidateIMFileResult();
        if (r109 == null) goto L29;
        ValidateResult r110 = r109.getValidateResult();
    L30:
        ValidateIMFileResult r111 = r101.getValidateIMFileResult();
        if (r111 == null) goto L33;
        IMFileResult r112 = r111.getResultType();
    L34:
        MessagePermissionUtil.ReceiveAuthorizationState r113 = MessagePermissionUtil.h(r112);
        if (MessagePermissionUtil.g(r113) == false) goto L45;
        int r114 = b.f433283a[r113.ordinal()];
        if (r114 != 1) goto L39;
        MessagePermissionUtil.m(r100);
    L43:
        owa.a.c().a(r110, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
        return true;
    L39:
        if (r114 != 2) goto L43;
        owa.a.c().d(r110, MessagePermissionUtil.a());
        goto L43
    L45:
        owa.a.c().a(r110, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
        ValidateResult r115 = MessagePermissionUtil.b();
        if (r102 == null) goto L49;
        boolean r116 = MessagePermissionUtil.c(r101, r102, r115);
    L57:
        if (r116 == true) goto L60;
        MessagePermissionUtil.n(r100, R.string.Lark_IM_UnableToPreviewFile_PopUpDesc, r115);
        owa.a.c().a(r115, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
        return true;
    L60:
        owa.a.c().a(r115, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
        return false;
    L49:
        if (MessagePermissionUtil.j(r101, null) == true) goto L51;
    L53:
        if (r115 != null) goto L55;
        ValidateResult r117 = MessagePermissionUtil.b();
    L56:
        r116 = MessagePermissionUtil.e(r117);
        goto L57
    L55:
        r117 = r115;
        goto L56
    L51:
        if (AuditUtilsV2.b() == true) goto L53;
        r116 = true;
        goto L57
    L33:
        r112 = null;
        goto L34
    L29:
        r110 = null;
        goto L30
    L19:
        if (r106.resourceIsCleaned() != true) goto L21;
        r107 = true;
        goto L22
    L12:
        r106 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    @Override // jza.c
    public final void c(final Context r110, final FlowFilePreviewData r111, final Function0<Unit> r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "previewData");
        Intrinsics.checkNotNullParameter(r112, "onAllowed");
        Function1<jza.e, Unit> r100 = new IMFileSecurityServiceImpl$checkPreviewAuthorization$1(r111, this, r110, r112);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "previewData");
        Intrinsics.checkNotNullParameter(r100, "callback");
        jza.a r113 = r111.f410588i;
        if (r113.f501221f == false) goto L6;
        jza.e r114 = new jza.e(OpenFeishuFileSecurityBlockReason.RESOURCE_CLEANED);
    L15:
        if (r114 == null) goto L17;
        r100.invoke(r114);
        return;
    L17:
        AuthorizationServiceV2 r115 = owa.a.c();
        ValidateResult r116 = r115.c(true);
        boolean r101 = r115.isAuthorizationPassed(r116);
        r115.a(r116, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
        if (r101 == true) goto L20;
        com.ss.android.lark.auditsdk.v2.d.a.a(r115, r110, r116, Integer.valueOf(R.string.Lark_IM_NoPermissionToPreviewOrView_Title), null, null, r115.e(), null, 440);
    L20:
        Intrinsics.checkNotNull(r115);
        boolean r117 = r115.isAuthorizationPassed(r116);
        if (r117 == false) goto L24;
        OpenFeishuFileSecurityBlockReason r118 = OpenFeishuFileSecurityBlockReason.UNKNOWN;
    L36:
        r100.invoke(new jza.e(r117, r118, null));
        return;
    L24:
        if (r116.getResult() != ResultType.ERROR) goto L27;
        r118 = OpenFeishuFileSecurityBlockReason.ERROR;
        goto L36
    L27:
        switch(h.f433299a[r116.getResultPolicy().ordinal()]) {
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            case 5: goto L31;
            case 6: goto L30;
            default: goto L29;
        };
    L30:
        r118 = OpenFeishuFileSecurityBlockReason.UNKNOWN;
        goto L36
    L31:
        r118 = OpenFeishuFileSecurityBlockReason.RISK_FILE;
        goto L36
    L32:
        r118 = OpenFeishuFileSecurityBlockReason.FILE_STRATEGY;
        goto L36
    L33:
        r118 = OpenFeishuFileSecurityBlockReason.DLP_SENSITIVE;
        goto L36
    L34:
        r118 = OpenFeishuFileSecurityBlockReason.DLP_DETECTING;
        goto L36
    L35:
        r118 = OpenFeishuFileSecurityBlockReason.NO_PERMISSION;
        goto L36
    L29:
        throw new NoWhenBranchMatchedException();
    L6:
        if (r113.f501222g == false) goto L8;
    L14:
        r114 = new jza.e(OpenFeishuFileSecurityBlockReason.RISK_FILE);
        goto L15
    L8:
        if (r113.f501223h == true) goto L14;
        if (r113.f501220e == true) goto L13;
        r114 = new jza.e(OpenFeishuFileSecurityBlockReason.NO_PERMISSION);
        goto L15
    L13:
        r114 = null;
        goto L15
    }

    @Override // jza.c
    public final FlowFilePreviewData a(String r210, String r211, String r212, String r213, Message r214, Chat r310) {
        Intrinsics.checkNotNullParameter(r210, "messageId");
        e(r214);
        if (r214 != null) goto L5;
    L13:
        FileContent r100 = null;
    L15:
        if ((r100 instanceof FileContent) == true) goto L18;
        r100 = null;
    L18:
        if (r100 == null) goto L20;
        ResourceCleanScene r101 = r100.currentResourceScene();
    L21:
        if (r213 != null) goto L25;
        if (r100 == null) goto L24;
        String r102 = r100.getKey();
    L26:
        FlowFilePreviewData.Source r110 = FlowFilePreviewData.Source.LOCAL;
        if (r310 == null) goto L30;
        String r111 = r310.getId();
        if (r111 == null) goto L30;
    L32:
        String r112 = r111;
    L34:
        if (r214 == null) goto L36;
        String r113 = r214.getFromId();
    L37:
        if (r214 == null) goto L39;
        String r114 = r214.getFromChatterTenantId();
    L40:
        if (r214 == null) goto L44;
        ValidateIMFileResult r115 = r214.getValidateIMFileResult();
        if (r115 == null) goto L44;
        IMFileResult r116 = r115.getResultType();
    L45:
        Integer r117 = Integer.valueOf(MessagePermissionUtil.h(r116).getValue());
        if (r310 == null) goto L49;
        boolean r103 = MessagePermissionUtil.c(r214, r310, null);
    L54:
        boolean r215 = r103;
        if (r100 != null) goto L57;
    L59:
        boolean r104 = false;
    L60:
        if (r104 == true) goto L69;
        if (r214 != null) goto L63;
    L65:
        boolean r105 = false;
    L66:
        if (r105 == true) goto L69;
        boolean r216 = false;
    L70:
        if (r101 != null) goto L72;
    L74:
        boolean r217 = false;
    L75:
        if (r102 == null) goto L85;
        if (r100 == null) goto L82;
        ArrayList<String> r106 = r100.getRiskObjectKeys();
        if (r106 == null) goto L82;
        if (r106.contains(r102) != true) goto L82;
        boolean r107 = true;
    L83:
        if (r107 != true) goto L85;
        boolean r218 = true;
    L87:
        return new FlowFilePreviewData(r210, r110, r211, r212, null, r213, null, null, new jza.a(r112, r113, r114, r117, r215, r216, r217, r218));
    L82:
        r107 = false;
    L85:
        r218 = false;
        goto L87
    L72:
        if (r101.isCSAMDelete() != true) goto L74;
        r217 = true;
        goto L75
    L63:
        if (r214.isCleaned() != true) goto L65;
        r105 = true;
    L69:
        r216 = true;
        goto L70
    L57:
        if (r100.resourceIsCleaned() != true) goto L59;
        r104 = true;
        goto L60
    L49:
        if (MessagePermissionUtil.j(r214, null) == true) goto L51;
    L53:
        r103 = MessagePermissionUtil.e(MessagePermissionUtil.b());
        goto L54
    L51:
        if (AuditUtilsV2.b() == true) goto L53;
        r103 = true;
    L44:
        r116 = null;
        goto L45
    L39:
        r114 = null;
        goto L40
    L36:
        r113 = null;
    L30:
        if (r214 == null) goto L33;
        r111 = r214.getChatId();
        goto L32
    L33:
        r112 = null;
        goto L34
    L24:
        r102 = null;
        goto L26
    L25:
        r102 = r213;
        goto L26
    L20:
        r101 = null;
        goto L21
    L5:
        if (r214.getType() != Message.Type.FILE) goto L7;
        boolean r108 = true;
    L8:
        if (r108 == false) goto L10;
        Message r109 = r214;
    L11:
        if (r109 == null) goto L13;
        r100 = (FileContent) r109.getContent();
        goto L15
    L10:
        r109 = null;
        goto L11
    L7:
        r108 = false;
        goto L8
    }
}
