package com.bytedance.ee.bear.more.itemv2;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.lynx.api.CCMLynxPageRouter;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.io.Serializable;
import java.util.HashMap;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class RetentionItemV2 extends BaseMoreItem implements ITextMoreItem {
    private static final String TAG = "RetentionItemV2";

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return 2131255254;
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
    public String getUnableTips() {
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean isEnable() {
        return true;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean needShowBadge() {
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onDisableClick() {
    }

    private boolean getRetentionLabelBenefits() {
        boolean r0 = ((BenefitManagerAPI) org.koin.java.a.a(BenefitManagerAPI.class)).n1().hasBenefit("admin_security_retention");
        tt5.a.h(TAG, "hasRetentionLabelBenefit = " + r0);
        return r0;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return CommonMoreItemId.RETENTION_LABEL.getId();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        boolean r0 = c.a.a.g("suite.admin.vault.retention_new");
        boolean r1 = getRetentionLabelBenefits();
        tt5.a.h(TAG, "isVisible(), fg = " + r0 + ", hasBenefit = " + r1);
        if (r0 == true) goto L7;
        if (r1 == true) goto L7;
        tt5.a.h(TAG, "fg and hasBenefit is false, return");
        return false;
    L7:
        oj5.c r2 = getMoreInfo();
        if ((r2 instanceof oj5.a) == true) goto L10;
        tt5.a.h(TAG, "moreInfo is not DocMoreInfo, return false");
        return false;
    L10:
        if (((oj5.a) r2).k == false) goto L14;
        tt5.a.h(TAG, "isAtVC is true, return false");
        return false;
    L14:
        if (r2.getType() != e.g.b) goto L16;
    L29:
        tt5.a.h(TAG, "isVisible(), canSetRetentionLabel = " + r2.v());
        return r2.v();
    L16:
        if (r2.getType() == e.h.b) goto L29;
        if (r2.getType() == e.i.b) goto L29;
        if (r2.getType() == e.k.b) goto L29;
        if (r2.getType() == e.m.b) goto L29;
        if (r2.getType() == e.l.b) goto L29;
        if (r2.getType() == e.o.b) goto L29;
        tt5.a.h(TAG, "type is not support, return false, type = " + r2.getType());
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(2131887217);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onClick() {
        oj5.c r0 = getMoreInfo();
        tt5.a.b(TAG, "onItemClick: moreInfo = " + r0);
        if ((r0 instanceof oj5.a) == false) goto L18;
        HashMap<String, Serializable> r1 = new HashMap();
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).aa().getClass();
        r1.put("host", bi5.a.b());
        r1.put(ResourceData.KEY_TOKEN, r0.getToken());
        r1.put(ResourceData.KEY_TYPE, Integer.valueOf(r0.getType()));
        addReportParameters((oj5.a) r0, r1);
        if (getHost() != null) goto L7;
    L11:
        tt5.a.d(TAG, "context is null");
    L12:
        com.bytedance.ee.bear.more.b r2 = (com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class);
        Bundle r6 = getHost().getHostFragment().getArguments();
        String r7 = r0.getToken();
        int r8 = r0.getType();
        String r10 = r0.b();
        if (r0.getType() != e.n.b) goto L15;
        boolean r15 = true;
    L16:
        r2.c(new i(r6, r7, r8, false, r10, "retention", "ccm_space_retention_setting_view", "", "", r15, false, r0.H(), r0.isOwner(), r0.L()));
        getHost().a();
        return;
    L15:
        r15 = false;
        goto L16
    L7:
        if (getHost().getHostFragment() == null) goto L11;
        if (getHost().getHostFragment().getContext() == null) goto L11;
        ((CCMLynxPageRouter) org.koin.java.a.a(CCMLynxPageRouter.class)).a(getHost().getHostFragment().getContext(), r1);
        goto L12
    }

    public RetentionItemV2() {
    }

    private HashMap<String, Serializable> addReportParameters(oj5.a r9, HashMap<String, Serializable> r10) {
        Bundle r0 = getHost().getHostFragment().getArguments();
        if (r0 == null) goto L16;
        String r1 = r0.getString("module", "");
        String r4 = r0.getString("sub_module", "");
        String r6 = r0.getString("container_id", "");
        String r2 = r0.getString("container_type", "");
        if (TextUtils.isEmpty(r6) == true) goto L8;
        r10.put("container_id", du5.b.g(r6));
    L8:
        if (TextUtils.isEmpty(r2) == true) goto L11;
        r10.put("container_type", r2);
    L11:
        if (TextUtils.isEmpty(r1) == true) goto L14;
        r10.put("_module", r1);
    L14:
        if (TextUtils.isEmpty(r4) == true) goto L16;
        r10.put("sub_module", r4);
    L16:
        r10.put("file_id", du5.b.g(r9.c));
        r10.put("file_type", e.f(r9.getType()));
        if (TextUtils.isEmpty(r9.b()) == true) goto L19;
        r10.put("sub_file_type", r9.b());
    L19:
        return r10;
    }
}
