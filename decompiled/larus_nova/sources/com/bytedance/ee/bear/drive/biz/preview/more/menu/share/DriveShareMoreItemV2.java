package com.bytedance.ee.bear.drive.biz.preview.more.menu.share;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.more.b;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem;
import com.larus.nova.R;
import oj5.f;

/* JADX INFO: loaded from: classes16.dex */
public class DriveShareMoreItemV2 extends BaseMoreItem implements IGridMoreItem {
    private static final String SHARE_ID = "shareV2";
    private static final String TAG = "DriveShareMoreItemV2";
    private final DriveViewModel mDriveViewModel;
    DriveMGPermissionVM mPermissionVM;
    DrivePluginHost pluginHost;

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return R.drawable.ud_icon_share_outlined;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return R.color.icon_n1;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return "shareV2";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public String getUnableTips() {
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean isEnable() {
        return true;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean needShowBadge() {
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public void onClick() {
        tt5.a.b(TAG, "onItemClick: moreInfo = " + getMoreInfo());
        FragmentActivity r100 = getHost().getHostFragment().getActivity();
        if (r100 != null) goto L6;
        return;
    L6:
        if ((getMoreInfo() instanceof oj5.a) == false) goto L8;
        oj5.a r101 = (oj5.a) getMoreInfo();
        ((b) org.koin.java.a.a(b.class)).c(new i(getHost().getHostFragment().getArguments(), r101.f523532c, r101.getType(), false, r101.b(), "share", "ccm_permission_share_view", "", "", r101 instanceof f, r101.f523540k, r101.f523547r, r101.isOwner(), r101.L()));
    L8:
        a.a(r100, this.mDriveViewModel, this.mPermissionVM.livePerm().getValue());
        getHost().a();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(R.string.Doc_More_Share);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        if (getMoreInfo() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public DriveShareMoreItemV2(DrivePluginHost r100) {
        this.mDriveViewModel = r100.f224125c;
        this.mPermissionVM = (DriveMGPermissionVM) q.c(r100, DriveMGPermissionVM.class, null);
        this.pluginHost = r100;
    }
}
