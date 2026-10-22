package com.bytedance.ee.bear.document.bitable;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.p;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class TimeZoneItemV2 extends BaseMoreItem implements ITextMoreItem {
    public static final String FUN_NAME_GET_BASE_TIME_ZONE = "lark.biz.bitable.getBaseTimeZone";
    public static final String ID_TIME_ZONE = "item_time_zoneV2";
    public static final String KEY_IS_AT_VC = "is_at_vc";
    public static final String KEY_IS_WIKI = "is_wiki";
    public static final String KEY_TOKEN = "token";
    public static final String KEY_TYPE = "type";
    private static final String TAG = "TimeZoneItemV2";
    public static final String TIME_ZONE = "timeZone";
    public static final String TIME_ZONE_ABBR = "timeZoneAbbr";
    private String mBaseTimeZone;
    private final PluginHost pluginHost;

    public static class TimeZoneParam implements NonProguard {
        private String baseId;

        private TimeZoneParam() {
        }

        public String toString() {
            return "TimeZoneParam{baseId='" + this.baseId + "'}";
        }

        public String getBaseId() {
            return this.baseId;
        }

        public /* synthetic */ TimeZoneParam(a r1) {
            this();
        }

        public void setBaseId(String r1) {
            this.baseId = r1;
        }
    }

    public static /* synthetic */ class a {
    }

    public static /* synthetic */ void a(TimeZoneItemV2 r0, String r1) {
        r0.lambda$getBaseTimeZone$0(r1);
    }

    public int getIcon() {
        return 2131256008;
    }

    public int getIconTint() {
        return 2131102418;
    }

    public String getId() {
        return ID_TIME_ZONE;
    }

    public final /* synthetic */ MoreUiAction getMoreAction() {
        return ITextMoreItem.-CC.$default$getMoreAction(this);
    }

    public String getStateTips() {
        return "";
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

    public void onDisableClick() {
    }

    public void onRelease() {
        this.mBaseTimeZone = null;
        tt5.a.b(TAG, "onRelease");
    }

    public boolean isVisible() {
        if (((Boolean) com.bytedance.ee.bear.appsetting.c.a.a.d("ccm.bitable.time_zone", Boolean.FALSE)).booleanValue() == true) goto L5;
        return false;
    L5:
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L8;
        return false;
    L8:
        IDocUserPermission r8 = r0.c().a;
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == false) goto L22;
        com.bytedance.ee.bear.more.b r2 = (com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class);
        String r3 = r0.getToken();
        BizDomain r10 = BizDomain.FileBizDomainCCM;
        if (r2.t(r3, r0, r10, "PERCEIVE_CONTROL", r8).getAllow() == false) goto L14;
        return false;
    L14:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).t(r0.getToken(), r0, r10, "FULL_ACCESS", r8).getAllow() == true) goto L18;
        if (r0.isOwner() == true) goto L18;
        return false;
    L18:
        if (r0.getType() != sbb.e.i.b) goto L33;
        return true;
    L33:
        return false;
    L22:
        if (r0.c().a.matchPerceiveControl() == false) goto L25;
        return false;
    L25:
        if (r0.c().a.isFullAccess() == true) goto L29;
        if (r0.isOwner() == true) goto L29;
        return false;
    L29:
        if (r0.getType() != sbb.e.i.b) goto L35;
        return true;
    L35:
        return false;
    }

    public void onClick() {
        String r2 = "";
        if (this.mBaseTimeZone != null) goto L5;
        tt5.a.d(TAG, "onClick return; base time zone error!");
        this.mBaseTimeZone = "";
    L5:
        oj5.a r1 = getMoreInfo();
        if (r1 != null) goto L9;
        return;
    L9:
        if ((getMoreInfo() instanceof oj5.a) == false) goto L11;
        org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        com.bytedance.ee.bear.contract.d r4 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        r4.c(TAG);
        r4.h(TAG);
        r4.j(TAG, "token", r1.getToken());
        r4.j(TAG, "type", String.valueOf(r1.getType()));
        boolean r5 = r1 instanceof oj5.f;
        r4.j(TAG, "is_wiki", String.valueOf(r5));
        oj5.a r6 = r1;
        r4.j(TAG, "is_at_vc", String.valueOf(r6.k));
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).c(new i(getHost().getHostFragment().getArguments(), r1.getToken(), r1.getType(), r1.isShareFolder(), r1.b(), "doc_time_zone", "ccm_bitable_time_zone_setting_view", "", "", r5, r6.k, r1.H(), r1.isOwner(), r1.L()));
    L11:
        Bundle r3 = new Bundle();
        r3.putString(TIME_ZONE, this.mBaseTimeZone);
        if (TextUtils.isEmpty(this.mBaseTimeZone) == true) goto L14;
        r2 = zu5.b.b(TimeZone.getTimeZone(this.mBaseTimeZone));
    L14:
        r3.putString(TIME_ZONE_ABBR, r2);
        p r7 = (p) this.pluginHost.getHostAbilityOrNull(p.class);
        if (r7 == null) goto L17;
        r7.showTimeZonePanel(this.pluginHost.getContext(), (ViewGroup) this.pluginHost.getUIContainer().findView(2131382479), r3);
    L17:
        getHost().a();
    }

    public String getTitle() {
        return getString(2131886899);
    }

    public TimeZoneItemV2(PluginHost r2) {
        this.pluginHost = r2;
        if ((r2 instanceof DocumentPluginHost) == false) goto L6;
        DocumentPluginHost r3 = (DocumentPluginHost) r2;
        String r0 = r3.getDocumentMetadata().getToken();
        getBaseTimeZone(r3.getWeb(), r0);
        return;
    }

    private /* synthetic */ void lambda$getBaseTimeZone$0(String r3) {
        this.mBaseTimeZone = JSONObjectProtectorUtils.getString(new JSONObject(r3), TIME_ZONE);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        this.mBaseTimeZone = null;
        tt5.a.d(TAG, "getBaseTimeZone onReceiveValue error!!" + e);
    }

    private void getBaseTimeZone(k r3, String r4) {
        if (r3 == null) goto L5;
        TimeZoneParam r0 = new TimeZoneParam(null);
        r0.setBaseId(r4);
        r3.k(FUN_NAME_GET_BASE_TIME_ZONE, r0, new h(this));
        return;
    }
}
