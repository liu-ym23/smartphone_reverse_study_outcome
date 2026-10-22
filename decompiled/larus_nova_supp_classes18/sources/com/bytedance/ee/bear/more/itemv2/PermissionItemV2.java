package com.bytedance.ee.bear.more.itemv2;

import android.content.Context;
import android.os.Bundle;
import by4.d;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$DataSource;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.bear.more.protocol3.panel.y;
import com.bytedance.ee.bear.more.view3.MoreFragmentV3;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.HashMap;
import jg5.e;
import jg5.k;
import kotlin.jvm.internal.Intrinsics;
import oj5.c;
import oj5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class PermissionItemV2 extends BaseMoreItem implements ITextMoreItem {
    private static final String KEY_LEADER_PERM_URL = "leaderPermUrl";
    private static final String TAG = "PermissionItemV2";
    private d userKVStorage;

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return 2131255650;
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
        return CommonMoreItemId.PERMISSION.getId();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(2131889204);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getUnableTips() {
        if (y.a() == true) goto L5;
        return "";
    L5:
        if (j.a.a.getNetworkState().a() == false) goto L7;
        return "";
    L7:
        return getString(2131887951);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
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
        y.b(TAG, r2, true, r0, r4, DocFeed$Value$DataSource.NETWORK);
        return r0;
    L9:
        r4 = DocFeed$Value$DataSource.NETWORK;
        goto L10
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        c r0 = getMoreInfo();
        if (r0 != null) goto L6;
        tt5.a.k(TAG, "isVisible(), more info == null");
        return false;
    L6:
        boolean r3 = r0.isOwner();
        tt5.a.h(TAG, "isOwner:" + r3);
        if (r3 == false) goto L9;
    L10:
        return true;
    L9:
        if (canManagePermMeta(r0) == true) goto L10;
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onClick() {
        c r0 = getMoreInfo();
        tt5.a.b(TAG, "onItemClick: docInfoData = " + r0);
        com.bytedance.ee.bear.more.c.b(r0, "public_permission_setting");
        if ((r0 instanceof oj5.a) == false) goto L28;
        oj5.a r1 = (oj5.a) r0;
        IDocPublicPermission r3 = r1.i.b;
        String r5 = r0.getUrl();
        int r6 = r0.getType();
        String r7 = r0.getToken();
        boolean r15 = r0 instanceof f;
        DocMetaInfo r9 = r1.g;
        DocPermission r10 = r1.i;
        DocVersion r11 = r1.j;
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_URL);
        Intrinsics.checkNotNullParameter(r7, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r9, "docMetaInfo");
        Intrinsics.checkNotNullParameter(r10, "docPermission");
        Intrinsics.checkNotNullParameter(r11, "version");
        new DocPermSetInfo(r5, r6, r7, r15, r9, r10, r11, true, true, true, DocUserPermission.USER_PERM_FULL_ACCESS);
        sj5.b r4 = getHost();
        if (r4 != null) goto L8;
        tt5.a.d(TAG, "onClick()...host is null");
        return;
    L8:
        MoreFragmentV3 r8 = r4.getHostFragment();
        if (r8 != null) goto L12;
        tt5.a.d(TAG, "onClick()...fragment is null");
        return;
    L12:
        com.bytedance.ee.bear.more.c.c(new i(r8.getArguments(), r0.getToken(), r0.getType(), r0.isShareFolder(), r0.b(), "permission_settings", "ccm_permission_set_view", "", "", r15, ((oj5.a) r0).k, r0.H(), r0.isOwner(), r0.L()));
        String r13 = r1.i.a.getReportJson();
        String r14 = r1.i.b.getReportJson();
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).j0();
        k.a.a.e(r0.getToken(), r0.getType(), r0.b(), r15, r13, r14, r1.k, "", "");
        tt5.a.h(TAG, "docPublicPermRefactor = " + r3);
        new HashMap();
        Context r2 = r8.getContext();
        if (r2 != null) goto L16;
        tt5.a.d(TAG, "onClick()...context is null");
        return;
    L16:
        Bundle r12 = r8.getArguments();
        if (r12 == null) goto L19;
        String r16 = r12.getString("module", "");
        String r17 = r12.getString("sub_module", "");
        String r18 = r16;
    L20:
        d r19 = this.userKVStorage;
        if (r19 == null) goto L23;
        boolean r21 = r19.b("account").getBoolean("key_has_leader", true);
    L24:
        uj5.b r20 = new uj5.b(r1.c, r1.getType(), r1.j.isDocV2(), r15, r1.a(), r1.k, r1.b(), r18, r17, r1.i.a.getReportJson(), r1.i.b.getReportJson(), r1.isOwner(), r21, r1.b);
        h0 r22 = (h0) org.koin.java.a.a(h0.class);
        int r23 = uj5.a.a;
        uj5.a.C0316a.a(r2, r20, r22, r8, true);
        if (ForsetiHelper.s(r8) == true) goto L29;
        r4.a();
        return;
    L29:
        return;
    L23:
        r21 = true;
        goto L24
    L19:
        r18 = "";
        r17 = r18;
        goto L20
    }

    public PermissionItemV2(d r1) {
        this.userKVStorage = r1;
    }

    private boolean canManagePermMeta(c r8) {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (e.a.a.g() == false) goto L7;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).t(r8.getToken(), r8, BizDomain.FileBizDomainCCM, "MANAGE_PERMISSION_META", getUserPerm(r8)).getAllow();
    L7:
        return r8.Q();
    }

    private Object getUserPerm(c r2) {
        if ((r2 instanceof oj5.a) == false) goto L7;
        return r2.c().a;
    L7:
        if ((r2 instanceof oj5.b) == true) goto L9;
        return null;
    L9:
        return ((oj5.b) r2).t;
    }
}
