package com.bytedance.ee.bear.document.share;

import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.k;
import com.bytedance.ee.bear.more.b;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem;
import com.bytedance.ee.bear.more.protocol3.panel.y;
import java.util.Objects;
import oj5.c;
import oj5.f;
import s35.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ShareMoreItemV2 extends BaseMoreItem implements IGridMoreItem {
    private static final String SHARE_ID = "shareV2";
    private static final String TAG = "ShareItemV2";
    private DocumentPluginHost pluginHost;

    public static /* synthetic */ void a(SharePlugin r0) {
        lambda$startShare$0(r0);
    }

    public int getIcon() {
        return 2131255656;
    }

    public int getIconTint() {
        return 2131102418;
    }

    public String getId() {
        return SHARE_ID;
    }

    public boolean isVisible() {
        return true;
    }

    private void startShare() {
        this.pluginHost.findPluginToDo(SharePlugin.class, new d());
    }

    public void onClick() {
        tt5.a.h(TAG, "onClick");
        startShare();
        if ((getMoreInfo() instanceof oj5.a) == false) goto L5;
        oj5.a r0 = getMoreInfo();
        ((b) org.koin.java.a.a(b.class)).c(new i(getHost().getHostFragment().getArguments(), r0.c, r0.getType(), false, r0.b(), "share", "ccm_permission_share_view", "", "", r0 instanceof f, r0.k, r0.r, r0.isOwner(), r0.L()));
        int r4 = r0.getType();
        ((k) org.koin.java.a.a(k.class)).q(r4, "share_version", "none", null, null, null);
    L5:
        getHost().a();
    }

    public String getTitle() {
        c r0 = getMoreInfo();
        if (r0 == null) goto L11;
        if (r0.m() == true) goto L11;
        if (this.pluginHost.a().isEditionDoc() == false) goto L11;
        return getString(2131889372);
    L11:
        return getString(2131888032);
    }

    public String getUnableTips() {
        if (y.a() == true) goto L5;
        return "";
    L5:
        if (j.a.a.getNetworkState().a() == false) goto L7;
        return "";
    L7:
        return getString(2131887951);
    }

    public boolean isEnable() {
        if (y.a() == true) goto L6;
        y.c(TAG, getId());
        return true;
    L6:
        boolean r0 = j.a.a.getNetworkState().a();
        String r2 = getId();
        if (r0 == false) goto L9;
        String r4 = "";
    L10:
        y.b(TAG, r2, true, r0, r4, "network");
        return r0;
    L9:
        r4 = "network";
        goto L10
    }

    public boolean needShowBadge() {
        if (getMoreInfo() != null) goto L6;
        return false;
    L6:
        if (shouldShowBadgeByBusiness() == true) goto L9;
        return false;
    L9:
        return ((b) org.koin.java.a.a(b.class)).l(SHARE_ID);
    }

    public ShareMoreItemV2(DocumentPluginHost r1) {
        this.pluginHost = r1;
    }

    private static /* synthetic */ void lambda$startShare$0(final SharePlugin r3) {
        Objects.requireNonNull(r3);
        com.bytedance.ee.util.ui.j.d(new s35.c(r3), 300);
        ((b) org.koin.java.a.a(b.class)).b(SHARE_ID);
    }
}
