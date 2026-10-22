package com.bytedance.ee.bear.list.more.itemv2;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.list.f;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DeleteItemV2 extends BaseMoreItem implements IGridMoreItem {
    public static final int INVALID_RES = Integer.MAX_VALUE;
    private final f.a mDelegate;
    private int mDeleteIconRes;
    private final int mDeleteRes;
    protected final Document mDocument;
    private final boolean mIsDeleteSource;

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean needShowBadge() {
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return CommonMoreItemId.DELETE.getId();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(this.mDeleteRes);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public String getUnableTips() {
        if (j.a.a.getNetworkState().a() == true) goto L7;
        return getString(2131887951);
    L7:
        return getString(2131887803);
    }

    public boolean isEnable() {
        return j.a.a.getNetworkState().a();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        if (this.mDeleteRes == Integer.MAX_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public void onClick() {
        Context r1 = getHost().getHostFragment().getContext();
        if (this.mIsDeleteSource == true) goto L5;
    L7:
        f.a r2 = this.mDelegate;
        if (r2 == null) goto L10;
        r2.y7(this.mDocument);
    L10:
        oj5.c r3 = getMoreInfo();
        if ((r3 instanceof oj5.b) == false) goto L14;
        oj5.b r4 = (oj5.b) r3;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).c(new i(getHost().getHostFragment().getArguments(), r3.getToken(), r3.getType(), FolderVersion.isShareFolder(r4.o.getOwnerType(), r4.p), r3.b(), "delete", "ccm_space_delete_view", "", "", false, false, r3.H(), r3.isOwner(), r3.L()));
    L20:
        getHost().a();
        return;
    L14:
        if ((r3 instanceof oj5.a) == false) goto L20;
        com.bytedance.ee.bear.more.b r5 = (com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class);
        Bundle r6 = getHost().getHostFragment().getArguments();
        String r7 = r3.getToken();
        int r8 = r3.getType();
        String r9 = r3.b();
        if (r3.getType() != sbb.e.n.b) goto L18;
        boolean r13 = true;
    L19:
        r5.c(new i(r6, r7, r8, false, r9, "delete", "ccm_space_delete_view", "", "", r13, false, r3.H(), r3.isOwner(), r3.L()));
        goto L20
    L18:
        r13 = false;
        goto L19
    L5:
        if (t0.b(r1, this.mDocument, "delete_source") == false) goto L7;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return this.mDeleteIconRes;
    }

    public DeleteItemV2(Document r2, int r3, boolean r4, f.a r5) {
        this.mDeleteIconRes = 2131254201;
        this.mDocument = r2;
        this.mDeleteRes = r3;
        this.mIsDeleteSource = r4;
        this.mDelegate = r5;
    }

    public DeleteItemV2(Document r1, int r2, int r3, boolean r4, f.a r5) {
        this.mDocument = r1;
        this.mDeleteRes = r2;
        this.mIsDeleteSource = r4;
        this.mDelegate = r5;
        this.mDeleteIconRes = r3;
    }
}
