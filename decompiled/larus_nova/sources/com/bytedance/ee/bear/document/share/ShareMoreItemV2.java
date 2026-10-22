package com.bytedance.ee.bear.document.share;

import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.k;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ee.bear.more.b;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem;
import com.bytedance.ee.bear.more.protocol3.panel.y;
import com.larus.nova.R;
import java.util.Objects;
import oj5.c;
import oj5.f;
import s35.d;

/* JADX INFO: loaded from: classes16.dex */
public class ShareMoreItemV2 extends BaseMoreItem implements IGridMoreItem {
    private static final String SHARE_ID = "shareV2";
    private static final String TAG = "ShareItemV2";
    private DocumentPluginHost pluginHost;

    public static /* synthetic */ void a(SharePlugin r100) {
        lambda$startShare$0(r100);
    }

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

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        return true;
    }

    private void startShare() {
        this.pluginHost.findPluginToDo(SharePlugin.class, new d());
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public void onClick() {
        tt5.a.h(TAG, SendEventContainerMethodParamModel.EventKinds.onClick);
        startShare();
        if ((getMoreInfo() instanceof oj5.a) == false) goto L5;
        oj5.a r100 = (oj5.a) getMoreInfo();
        ((b) org.koin.java.a.a(b.class)).c(new i(getHost().getHostFragment().getArguments(), r100.f523532c, r100.getType(), false, r100.b(), "share", "ccm_permission_share_view", "", "", r100 instanceof f, r100.f523540k, r100.f523547r, r100.isOwner(), r100.L()));
        int r101 = r100.getType();
        ((k) org.koin.java.a.a(k.class)).q(r101, "share_version", "none", null, null, null);
    L5:
        getHost().a();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        c r100 = getMoreInfo();
        if (r100 == null) goto L11;
        if (r100.m() == true) goto L11;
        if (this.pluginHost.a().isEditionDoc() == false) goto L11;
        return getString(R.string.LarkCCM_Docx_VersionMgmt_ShareVersion_Button_Mob);
    L11:
        return getString(R.string.Doc_More_Share);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public String getUnableTips() {
        if (y.a() == true) goto L5;
        return "";
    L5:
        if (j.a.f217090a.getNetworkState().a() == false) goto L7;
        return "";
    L7:
        return getString(R.string.Doc_List_OperateFailedNoNet);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean isEnable() {
        if (y.a() == true) goto L6;
        y.c(TAG, getId());
        return true;
    L6:
        boolean r100 = j.a.f217090a.getNetworkState().a();
        String r101 = getId();
        if (r100 == false) goto L9;
        String r102 = "";
    L10:
        y.b(TAG, r101, true, r100, r102, "network");
        return r100;
    L9:
        r102 = "network";
        goto L10
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean needShowBadge() {
        if (getMoreInfo() != null) goto L6;
        return false;
    L6:
        if (shouldShowBadgeByBusiness() == true) goto L9;
        return false;
    L9:
        return ((b) org.koin.java.a.a(b.class)).l("shareV2");
    }

    public ShareMoreItemV2(DocumentPluginHost r100) {
        this.pluginHost = r100;
    }

    private static /* synthetic */ void lambda$startShare$0(final SharePlugin r100) {
        Objects.requireNonNull(r100);
        com.bytedance.ee.util.ui.j.d(new s35.c(r100), 300);
        ((b) org.koin.java.a.a(b.class)).b("shareV2");
    }
}
