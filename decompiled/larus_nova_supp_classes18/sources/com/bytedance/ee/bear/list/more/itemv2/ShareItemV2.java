package com.bytedance.ee.bear.list.more.itemv2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.contract.p0;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ShareItemV2 extends BaseMoreItem implements IGridMoreItem {
    public static final String SHARE_ID = "shareV2";
    private AccountService.Account mAccount;
    private FragmentActivity mActivity;
    private Document mDocument;
    private boolean mIsGrid;
    private String mModule;
    private String mSubModule;
    private Fragment sourceFragment;

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return 2131255656;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return SHARE_ID;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean needShowBadge() {
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public String getUnableTips() {
        if (j.a.a.getNetworkState().a() == false) goto L5;
        return "";
    L5:
        return getString(2131887951);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean isEnable() {
        if (j.a.a.getNetworkState().a() == true) goto L6;
        return false;
    L6:
        if (this.mDocument.Q1 == false) goto L9;
        return false;
    L9:
        if ((getMoreInfo() instanceof oj5.a) == false) goto L19;
        oj5.a r0 = (oj5.a) getMoreInfo();
        if (r0.p == false) goto L19;
        if (r0.q == false) goto L16;
        return false;
    L16:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).v(r0, r0.i.a, "VIEW").booleanValue() == true) goto L19;
        return false;
    L19:
        if ((getMoreInfo() instanceof oj5.b) == false) goto L28;
        oj5.b r1 = (oj5.b) getMoreInfo();
        if (r1.q == true) goto L23;
        return true;
    L23:
        if (r1.r == false) goto L26;
        return false;
    L26:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).B(r1, r1.t, "VIEW").booleanValue() == true) goto L31;
        return false;
    L31:
        return true;
    L28:
        return true;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public void onClick() {
        if (t0.b(this.mActivity, this.mDocument, "share") == false) goto L5;
        return;
    L5:
        getHost().a();
        t0.y(new p0(this.mActivity, this.mDocument, this.mAccount, this.mModule, this.mSubModule, t0.o(this.mIsGrid), this.sourceFragment));
        oj5.c r1 = getMoreInfo();
        if ((r1 instanceof oj5.b) == false) goto L12;
        oj5.b r2 = (oj5.b) r1;
        com.bytedance.ee.bear.more.b r5 = (com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class);
        Bundle r7 = getHost().getHostFragment().getArguments();
        String r8 = r1.getToken();
        int r9 = r1.getType();
        boolean r10 = FolderVersion.isShareFolder(r2.o.getOwnerType(), r2.p);
        String r11 = r1.b();
        if (r1.getType() != sbb.e.n.b) goto L10;
        boolean r16 = true;
    L11:
        r5.c(new i(r7, r8, r9, r10, r11, "share", "ccm_permission_share_view", "", "", r16, false, r1.H(), r1.isOwner(), r1.L()));
        return;
    L10:
        r16 = false;
        goto L11
    L12:
        if (r1 == null) goto L20;
        com.bytedance.ee.bear.more.b r3 = (com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class);
        Bundle r18 = getHost().getHostFragment().getArguments();
        String r19 = r1.getToken();
        int r20 = r1.getType();
        String r22 = r1.b();
        if (r1.getType() != sbb.e.n.b) goto L16;
        boolean r27 = true;
    L17:
        r3.c(new i(r18, r19, r20, false, r22, "share", "ccm_permission_share_view", "", "", r27, false, r1.H(), r1.isOwner(), r1.L()));
        return;
    L16:
        r27 = false;
        goto L17
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(2131887974);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        return this.mIsGrid;
    }

    public ShareItemV2(FragmentActivity r1, Document r2, AccountService.Account r3, boolean r4, String r5, String r6, Fragment r7) {
        this.mActivity = r1;
        this.mDocument = r2;
        this.mAccount = r3;
        this.mIsGrid = r4;
        this.mModule = r5;
        this.mSubModule = r6;
        this.sourceFragment = r7;
    }
}
