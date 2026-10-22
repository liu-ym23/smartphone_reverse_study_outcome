package com.bytedance.ee.bear.more.itemv2;

import android.net.Uri;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Metadata;
import oj5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/more/itemv2/ReportItemV2;", "Lcom/bytedance/ee/bear/more/moreprotocol/BaseMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/ITextMoreItem;", "<init>", "()V", "mRouteService", "Lcom/bytedance/ee/bear/route/RouteService;", "getMRouteService", "()Lcom/bytedance/ee/bear/route/RouteService;", "getId", "", "getTitle", "getIcon", "", "getIconTint", "getStateTips", "isVisible", "", "onDisableClick", "", SendEventContainerMethodParamModel.EventKinds.onClick, "getPathHost", "Landroid/net/Uri$Builder;", "Companion", "features-more_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReportItemV2 extends BaseMoreItem implements ITextMoreItem {
    public static final a Companion = null;
    private static final String DEFAULT_OFFICIAL_HOST = "www.feishu.cn";
    private static final String TAG = "ReportItemV2";
    private final h mRouteService;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return 2131256182;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return "report";
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
    public final /* synthetic */ String getUnableTips() {
        return ITextMoreItem.CC.$default$getUnableTips(this);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public final /* synthetic */ boolean isEnable() {
        return ITextMoreItem.CC.$default$isEnable(this);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public final /* synthetic */ boolean needShowBadge() {
        return ITextMoreItem.CC.$default$needShowBadge(this);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onDisableClick() {
    }

    private final Uri.Builder getPathHost() {
        boolean r0 = ((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.b.class, null, null, 6)).isFeishuBrand();
        if (c.a.a.h("ccm.platform.appeal_v2") == true) goto L8;
        if (r0 == false) goto L8;
        String r1 = ((s45.c) org.koin.java.a.c(s45.c.class, null, null, 6)).getString("official", DEFAULT_OFFICIAL_HOST);
        return new Uri.Builder().scheme("https").authority(r1).appendEncodedPath("report/");
    L8:
        return ((com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a.class, null, null, 6)).getReportHost();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        if (((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.b.class, null, null, 6)).isFeishuBrand() == false) goto L6;
        return c.a.a.i("spacekit.mobile.space_report_enable", true);
    L6:
        return c.a.a.i("lark.tns.doc_report", true);
    }

    public ReportItemV2() {
        this.mRouteService = (h) org.koin.java.a.c(h.class, null, null, 6);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(2131889730);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onClick() {
        oj5.c r0 = getMoreInfo();
        if (r0 == null) goto L28;
        JSONObject r1 = new JSONObject();
        String r2 = r0.getToken();
        int r3 = r0.getType();
        StringBuilder r4 = new StringBuilder("token is empty = ");
        if (r0.getToken().length() != 0) goto L7;
        boolean r5 = true;
    L8:
        r4.append(r5);
        tt5.a.h(TAG, r4.toString());
        r1.put(ResourceData.KEY_OBJ_TOKEN, r2);
        r1.put("obj_type", Integer.valueOf(r3));
        Uri.Builder r6 = getPathHost();
        r6.appendQueryParameter(ResourceData.KEY_TYPE, "docs").appendQueryParameter("params", r1.toJSONString());
        this.mRouteService.u5(r6.toString());
        oj5.c r7 = getMoreInfo();
        if (r7 == null) goto L14;
        String r8 = r7.getToken();
        if (r8 == null) goto L14;
        String r9 = r8;
    L15:
        if (r7 == null) goto L17;
        int r10 = r7.getType();
    L18:
        if (r7 == null) goto L23;
        String r11 = r7.b();
        if (r11 == null) goto L23;
        String r12 = r11;
    L25:
        if ((r7 instanceof oj5.a) == false) goto L28;
        boolean r15 = r7 instanceof f;
        oj5.a r13 = (oj5.a) r7;
        com.bytedance.ee.bear.more.c.c(new i(getHost().getHostFragment().getArguments(), r9, r10, r0.isShareFolder(), r12, "report_abuse", "none", "", "", r15, r13.k, r13.r, r13.isOwner(), r13.L()));
    L23:
        r12 = "null";
        goto L25
    L17:
        r10 = -1;
    L14:
        r9 = "null";
        goto L15
    L7:
        r5 = false;
    L28:
        getHost().a();
    }

    public final h getMRouteService() {
        return this.mRouteService;
    }
}
