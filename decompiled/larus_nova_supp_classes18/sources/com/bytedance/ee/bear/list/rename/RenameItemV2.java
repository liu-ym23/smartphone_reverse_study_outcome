package com.bytedance.ee.bear.list.rename;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.m;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;
import lc5.f;
import lc5.n;
import oj5.b;
import oj5.c;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class RenameItemV2 extends BaseMoreItem implements ITextMoreItem {
    private static final String TAG = "RenameItemV2";
    private final AccountService.Account mAccount;
    private final Document mDocument;
    private final Fragment mFragment;
    private final boolean mIsNetworkAvailable;
    private final String mModule;
    private final String mSource;
    private ce5.a userComponentAbility;

    public class a implements com.bytedance.ee.bear.list.rename.a.InterfaceC0032a {
        public final /* synthetic */ RenameItemV2 a;

        public a(RenameItemV2 r1) {
            this.a = r1;
        }
    }

    public static /* synthetic */ boolean a(RenameItemV2 r0, int r1) {
        return r0.lambda$handleCopyPermission$1(r1);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return 2131254065;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public final /* synthetic */ MoreUiAction getMoreAction() {
        return ITextMoreItem.CC.$default$getMoreAction(this);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getStateTips() {
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean needShowBadge() {
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onDisableClick() {
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return CommonMoreItemId.RENAME.getId();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getUnableTips() {
        if (j.a.a.getNetworkState().a() == true) goto L7;
        return getString(2131887951);
    L7:
        if (this.mFragment.getContext() != null) goto L9;
        return "";
    L9:
        if (NodeType.isShortcut(this.mDocument.M1) == false) goto L11;
        Context r0 = this.mFragment.getContext();
        int r1 = 2131887530;
    L12:
        String r2 = r0.getString(r1);
        return xo5.a.c(this.mFragment.getContext(), 2131887777, ResourceData.KEY_TYPE, r2);
    L11:
        r0 = this.mFragment.getContext();
        r1 = 2131887757;
        goto L12
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean isEnable() {
        if (j.a.a.getNetworkState().a() == true) goto L5;
        return false;
    L5:
        c r0 = getMoreInfo();
        if ((r0 instanceof b) == false) goto L14;
        b r1 = (b) r0;
        if (r1.q == true) goto L10;
        ShareFolderUserPermission r2 = r1.t;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).B(r1, r2, "EDIT").booleanValue();
    L10:
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).v(r1, r1.u, "EDIT").booleanValue();
    L14:
        if ((r0 instanceof oj5.a) == false) goto L21;
        oj5.a r3 = (oj5.a) r0;
        if (r3.p == false) goto L20;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).v(r3, r3.s, "EDIT").booleanValue();
    L20:
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).v(r3, r3.i.a, "EDIT").booleanValue();
    L21:
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onClick() {
        if (t0.b(this.mFragment.getContext(), this.mDocument, "rename") == false) goto L5;
        return;
    L5:
        tt5.a.h(TAG, "onClick()...");
        if (this.mIsNetworkAvailable == true) goto L9;
        Toast.showFailureText(this.mFragment.getContext(), this.mFragment.getString(2131887951), 0);
        return;
    L9:
        final com.bytedance.ee.bear.list.rename.a r1 = new com.bytedance.ee.bear.list.rename.a(this.mFragment);
        final Document r3 = this.mDocument;
        final a r4 = new a(this);
        final ce5.a r5 = this.userComponentAbility;
        if (r1.a.get() != null) goto L12;
        tt5.a.d("RenameWrapper", "rename()...mHostRef.get() is null. ");
    L15:
        f.l(new n((d) org.koin.java.a.a(d.class), this.mAccount, "rename", this.mDocument, this.mModule, this.mSource));
        if (getMoreInfo() == null) goto L22;
        c r2 = getMoreInfo();
        com.bytedance.ee.bear.more.b r6 = (com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class);
        Bundle r7 = getHost().getHostFragment().getArguments();
        String r8 = r2.getToken();
        int r9 = r2.getType();
        boolean r10 = r2.isShareFolder();
        String r11 = r2.b();
        if (r2.getType() != e.n.b) goto L20;
        boolean r14 = true;
    L21:
        r6.c(new i(r7, r8, r9, r10, r11, "rename", "ccm_space_drive_rename_view", "", "", r14, false, r2.H(), r2.isOwner(), r2.L()));
        goto L22
    L20:
        r14 = false;
    L22:
        getHost().a();
        return;
    L12:
        if (r3 != null) goto L14;
        tt5.a.d("RenameWrapper", "rename()...document is null");
        goto L15
    L14:
        gp5.a r12 = (gp5.a) new gp5.a(r1.a.get().getContext()).title(2131887814);
        r12.e(r3.a);
        r12.f(2131887764);
        r12.a(2131887719);
        gp5.a.InterfaceC0236a r13 = new qd5.d(r1, r3, r5, r4);
        Intrinsics.checkNotNullParameter(r13, "value");
        r12.r = r13;
        r12.c();
        gp5.a.InterfaceC0236a r15 = new qd5.e(r4, r3);
        Intrinsics.checkNotNullParameter(r15, "value");
        r12.s = r15;
        Dialog r16 = r12.show();
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).s(r16);
        goto L15
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(2131887814);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        if (isItemInvisibleByBenefit() == false) goto L6;
        return false;
    L6:
        if (this.mDocument.getType() != e.f.b) goto L8;
    L9:
        return true;
    L8:
        if (NodeType.isShortcut(this.mDocument.M1) == true) goto L9;
        return false;
    }

    private void handleCopyPermission(gp5.a r2) {
        SpaceEditText r3 = r2.g();
        if (r3 != null) goto L5;
        return;
    L5:
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).b() == true) goto L10;
        r3.setInterceptor(new qd5.c(this));
        return;
    }

    private boolean lambda$handleCopyPermission$1(int r7) {
        c r2 = getMoreInfo();
        if (r2 != null) goto L5;
        return false;
    L5:
        if (this.mFragment.getContext() != null) goto L8;
        return false;
    L8:
        if (r7 != 16908321) goto L10;
    L11:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == false) goto L23;
        PermissionResponse r8 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).t(r2.getToken(), r2, BizDomain.FileBizDomainCCM, "CONTENT_COPY", r2.c().a);
        r8.getCallback().a(this.mFragment.getContext(), r8);
        if (r8.getAllow() == true) goto L19;
        if (((ph5.c) org.koin.java.a.a(ph5.c.class)).d(r8) == true) goto L19;
        Toast.showFailureText(this.mFragment.getContext(), 2131887613);
    L19:
        return !r8.getAllow();
    L23:
        return false;
    L10:
        if (r7 == 16908320) goto L11;
        return false;
    }

    private /* synthetic */ void lambda$onClick$0(gp5.a r1) {
        handleCopyPermission(r1);
    }

    private void reportMoreItemClick(String r14) {
        if (getMoreInfo() == null) goto L6;
        c r0 = getMoreInfo();
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).E(new m(getHost().getHostFragment().getArguments(), r0.getToken(), r0.getType(), r0.b(), r0 instanceof oj5.f, false, r14, r0.isOwner(), r0.L()));
        return;
    }

    public static /* synthetic */ void access$000(RenameItemV2 r0, String r1) {
        r0.reportMoreItemClick(r1);
    }

    public RenameItemV2(Fragment r1, Document r2, boolean r3, AccountService.Account r4, String r5, String r6, ce5.a r7) {
        this.mFragment = r1;
        this.mDocument = r2;
        this.mIsNetworkAvailable = r3;
        this.mAccount = r4;
        this.mSource = r5;
        this.mModule = r6;
        this.userComponentAbility = r7;
    }
}
