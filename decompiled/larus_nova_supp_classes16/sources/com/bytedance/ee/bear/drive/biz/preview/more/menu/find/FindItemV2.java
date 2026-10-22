package com.bytedance.ee.bear.drive.biz.preview.more.menu.find;

import com.bytedance.ee.bear.drive.report.c;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import o75.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FindItemV2 extends BaseMoreItem implements ITextMoreItem {
    public static final String ID_DRIVE_FIND = "id_drive_findV2";
    private boolean mEnable;
    private a mFindCallback;
    private String mUnableTips;
    private boolean mVisible;

    public interface a {
    }

    public int getIcon() {
        return 2131254041;
    }

    public int getIconTint() {
        return 2131102418;
    }

    public String getId() {
        return ID_DRIVE_FIND;
    }

    public final /* synthetic */ MoreUiAction getMoreAction() {
        return ITextMoreItem.-CC.$default$getMoreAction(this);
    }

    public String getStateTips() {
        return "";
    }

    public boolean needShowBadge() {
        return false;
    }

    public void onDisableClick() {
    }

    public String getTitle() {
        return getString(2131887770);
    }

    public void onClick() {
        getHost().a();
        if (getMoreInfo() == null) goto L6;
        c r0 = b.a().Ke();
        oj5.c r1 = getMoreInfo();
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).c(new i(getHost().getHostFragment().getArguments(), r1.getToken(), r1.getType(), false, r1.b(), "find", "none", "", "", false, r0.j(), r1.H(), r1.isOwner(), r1.L()));
        return;
    }

    public String getUnableTips() {
        return this.mUnableTips;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public boolean isVisible() {
        return this.mVisible;
    }

    public FindItemV2(boolean r1, boolean r2, String r3, a r4) {
        this.mVisible = r1;
        this.mEnable = r2;
        this.mUnableTips = r3;
    }
}
