package com.bytedance.ee.bear.list.more.itemv2;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.h;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.s4;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.lark.android.encryption.CipherManager;
import lc5.f;
import lc5.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OpenFileItemV2 extends BaseMoreItem implements ITextMoreItem {
    private static final String ID_OPEN_EXTERNAL = "open_externalV2";
    private PermissionResponse cacheResp;
    private AccountService.Account mAccount;
    private Context mContext;
    private Document mDocument;
    private boolean mIsNetworkAvailable;
    private String mModule;
    private String mSource;

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return 2131254993;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return ID_OPEN_EXTERNAL;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getStateTips() {
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getUnableTips() {
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean needShowBadge() {
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public MoreUiAction getMoreAction() {
        MoreUiAction.MoreAction r0 = MoreUiAction.MoreAction.UNEAABLE_TIPS;
        oj5.c r1 = getMoreInfo();
        if (r1 == null) goto L5;
        PermissionResponse r3 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).f(r1, "DOWNLOAD");
        this.cacheResp = r3;
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        boolean r4 = jg5.e.a.a.g();
        if (getAdminResult(r1).a == true) goto L11;
        if (r4 == true) goto L11;
        return new MoreUiAction(r0, "");
    L11:
        if (r4 == false) goto L17;
        if (((ph5.c) org.koin.java.a.a(ph5.c.class)).d(r3) == false) goto L17;
        return new MoreUiAction(MoreUiAction.MoreAction.PERM_PLATFORM_ACTION, "");
    L17:
        if (matchPerceiveControl(r1) == false) goto L23;
        if (r1.isSecretFileView() == true) goto L23;
        return new MoreUiAction(r0, getString(2131887246));
    L23:
        if (r1.isSecretFileExport() == true) goto L30;
        if (r1.isSecretFileView() == true) goto L30;
        return new MoreUiAction(r0, getString(2131887701));
    L30:
        return new MoreUiAction(r0, getString(2131889704));
    L5:
        return new MoreUiAction(r0, getString(2131887701));
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onClick() {
        PermissionResponse r1 = this.cacheResp;
        if (r1 != null) goto L5;
    L7:
        com.bytedance.ee.bear.middleground_permission_export.model.c r2 = (com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.c.class);
        String r4 = this.mDocument.d;
        Boolean r5 = Boolean.FALSE;
        if (CipherManager.d() == 1) goto L10;
        boolean r3 = true;
    L11:
        r2.m(null, r4, r5, null, Boolean.valueOf(r3));
        ((zk5.a) org.koin.java.a.a(zk5.a.class)).a(sbb.e.l.b, this.mDocument.d, OperationName.OPERATION_OPEN_WITH_THIRD_APP);
        boolean r6 = new ce5.a().d.isEnable("ccm.workspace.space_adapt_pad");
        if (CipherManager.d() != 1) goto L14;
        tt5.a.h(ID_OPEN_EXTERNAL, "open external in list, file CIPHER_ON is true");
        Context r7 = this.mContext;
        Toast.showText(r7, r7.getString(2131887299), 1);
        CipherManager.h();
    L18:
        oj5.c r8 = getMoreInfo();
        if (r8 == null) goto L25;
        com.bytedance.ee.bear.more.b r9 = (com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class);
        Bundle r11 = getHost().getHostFragment().getArguments();
        String r12 = r8.getToken();
        int r13 = r8.getType();
        String r15 = r8.b();
        if (r8.getType() != sbb.e.n.b) goto L23;
        boolean r20 = true;
    L24:
        r9.c(new i(r11, r12, r13, false, r15, "open_in_other_apps", "none", "", "", r20, false, r8.H(), r8.isOwner(), r8.L()));
        goto L25
    L23:
        r20 = false;
    L25:
        getHost().a();
        return;
    L14:
        Context r10 = this.mContext;
        Document r14 = this.mDocument;
        boolean r16 = this.mIsNetworkAvailable;
        AccountService.Account r17 = this.mAccount;
        String r18 = this.mSource;
        String r19 = this.mModule;
        s4 r21 = new s4(r10, r14, r16, r17, r18, r19);
        String[] r110 = t0.a;
        if (r16 == true) goto L17;
        Toast.showFailureText(r21.getContext(), r21.getContext().getString(2131887802), 0);
        goto L18
    L17:
        String r22 = r14.p;
        ((h) org.koin.java.a.a(h.class)).W(r10, r22, r6);
        f.l(new n((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r17, OperationName.OPERATION_OPEN_WITH_THIRD_APP, r14, r19, r18));
        goto L18
    L10:
        r3 = false;
        goto L11
    L5:
        if (this.mContext == null) goto L7;
        r1.getCallback().a(this.mContext, this.cacheResp);
        goto L7
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(2131887801);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean isEnable() {
        if ((getMoreInfo() instanceof oj5.a) == false) goto L14;
        oj5.a r0 = (oj5.a) getMoreInfo();
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        boolean r1 = jg5.e.a.a.g();
        PermissionResponse r2 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).f(r0, "DOWNLOAD");
        if (r1 == false) goto L7;
        boolean r3 = ((ph5.c) org.koin.java.a.a(ph5.c.class)).e(r2);
    L9:
        if (j.a.a.getNetworkState().a() == false) goto L14;
        if (r3 == false) goto L14;
        if (t0.t(this.mDocument, getMoreInfo()) == false) goto L14;
        return true;
    L7:
        r3 = getAdminResult(r0).a;
    L14:
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        if ((getMoreInfo() instanceof oj5.a) == false) goto L14;
        oj5.a r0 = (oj5.a) getMoreInfo();
        if (this.mDocument.getType() == sbb.e.l.b) goto L7;
        return false;
    L7:
        if (((ya5.b) org.koin.java.a.a(ya5.b.class)).a() == true) goto L9;
        return false;
    L9:
        if (r0.p == true) goto L11;
    L12:
        return true;
    L11:
        if (r0.q == false) goto L12;
        return false;
    L14:
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onDisableClick() {
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L5;
        return;
    L5:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == true) goto L8;
    L11:
        FileAuthResultFrom r1 = getAdminResult(r0).b;
        if (r1 != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L15;
        ((gj5.b) org.koin.java.a.a(gj5.b.class)).c("CCM_FILE_DOWNLOAD", FileBizDomain.FileBizDomainCCM, r0.i(), r0.getToken());
        return;
    L15:
        if (r1 != FileAuthResultFrom.COME_FROM_AUTHZ) goto L19;
        Toast.showFailureText(this.mContext, 2131887246);
        return;
    L19:
        return;
    L8:
        if (this.mContext == null) goto L11;
        PermissionResponse r2 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).f(r0, "DOWNLOAD");
        r2.getCallback().a(this.mContext, r2);
    }

    private gj5.c getAdminResult(oj5.c r5) {
        return ((gj5.b) org.koin.java.a.a(gj5.b.class)).g("CCM_FILE_DOWNLOAD", FileBizDomain.FileBizDomainCCM, r5.i(), r5.getToken());
    }

    private boolean matchPerceiveControl(oj5.c r4) {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == false) goto L7;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).o(r4, "PERCEIVE_CONTROL", r4.c().a).getAllow();
    L7:
        return r4.c().a.matchPerceiveControl();
    }

    public OpenFileItemV2(Context r2, Document r3, boolean r4, AccountService.Account r5, String r6, String r7) {
        this.cacheResp = null;
        this.mContext = r2;
        this.mDocument = r3;
        this.mIsNetworkAvailable = r4;
        this.mAccount = r5;
        this.mSource = r6;
        this.mModule = r7;
    }
}
