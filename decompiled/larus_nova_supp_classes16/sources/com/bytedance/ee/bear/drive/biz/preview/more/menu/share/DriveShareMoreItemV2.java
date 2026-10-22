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
import oj5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DriveShareMoreItemV2 extends BaseMoreItem implements IGridMoreItem {
    private static final String SHARE_ID = "shareV2";
    private static final String TAG = "DriveShareMoreItemV2";
    private final DriveViewModel mDriveViewModel;
    DriveMGPermissionVM mPermissionVM;
    DrivePluginHost pluginHost;

    public int getIcon() {
        return 2131255656;
    }

    public int getIconTint() {
        return 2131102418;
    }

    public String getId() {
        return SHARE_ID;
    }

    public String getUnableTips() {
        return "";
    }

    public boolean isEnable() {
        return true;
    }

    public boolean needShowBadge() {
        return false;
    }

    public void onClick() {
        tt5.a.b(TAG, "onItemClick: moreInfo = " + getMoreInfo());
        FragmentActivity r1 = getHost().getHostFragment().getActivity();
        if (r1 != null) goto L6;
        return;
    L6:
        if ((getMoreInfo() instanceof oj5.a) == false) goto L8;
        oj5.a r2 = getMoreInfo();
        ((b) org.koin.java.a.a(b.class)).c(new i(getHost().getHostFragment().getArguments(), r2.c, r2.getType(), false, r2.b(), "share", "ccm_permission_share_view", "", "", r2 instanceof f, r2.k, r2.r, r2.isOwner(), r2.L()));
    L8:
        a.a(r1, this.mDriveViewModel, (u55.b) this.mPermissionVM.livePerm().getValue());
        getHost().a();
    }

    public String getTitle() {
        return getString(2131888032);
    }

    public boolean isVisible() {
        if (getMoreInfo() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public DriveShareMoreItemV2(DrivePluginHost r3) {
        this.mDriveViewModel = r3.c;
        this.mPermissionVM = (DriveMGPermissionVM) q.c(r3, DriveMGPermissionVM.class, null);
        this.pluginHost = r3;
    }
}
