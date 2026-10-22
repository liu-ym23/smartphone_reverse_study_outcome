package com.larus.xbridge.custom;

import android.app.Activity;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.larus.common.apphost.AppHost;
import com.larus.login.api.CommonDouYinLoginKV;
import com.larus.login.api.CommonDouYinLoginUtil;
import com.larus.login.api.DouYinBindStatus;
import com.larus.login.api.ILoginApi;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@XBridgeMethod(name = "app.douyinAuth")
public final class z0 extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "app.douyinAuth", params = {"extra_info", "guide_type", "go_market", "request_server", "track_info", "alert_config"})
    public final String f379810a;

    public static final class a {
    }

    public static final class b implements com.larus.login.api.b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z0 f379811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.xbridge.XBridgeMethod.Callback f379812b;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f379813a = null;

            static {
                int[] r100 = new int[DouYinBindStatus.values().length];
                r100[DouYinBindStatus.ALREADY_BOUND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r100[DouYinBindStatus.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r100[DouYinBindStatus.GO_ACCOUNT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r100[DouYinBindStatus.FAILURE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r100[DouYinBindStatus.CANCEL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r100[DouYinBindStatus.GO_MARKET.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                f379813a = r100;
            }
        }

        public b(z0 r100, com.bytedance.ies.xbridge.XBridgeMethod.Callback r101) {
            this.f379811a = r100;
            this.f379812b = r101;
        }

        @Override // com.larus.login.api.b0
        public final void a(DouYinBindStatus r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "status");
            switch(a.f379813a[r100.ordinal()]) {
                case 1: goto L16;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L11;
                case 5: goto L7;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            z0 r103 = this.f379811a;
            Integer r104 = Integer.valueOf(r101);
            com.bytedance.ies.xbridge.XBridgeMethod.Callback r105 = this.f379812b;
            r103.getClass();
            z0.e(r104, 3, r102, r105);
            return;
        L7:
            z0 r106 = this.f379811a;
            Integer r107 = Integer.valueOf(r101);
            if (r102 != null) goto L10;
            r102 = "cancel_auth";
        L10:
            com.bytedance.ies.xbridge.XBridgeMethod.Callback r108 = this.f379812b;
            r106.getClass();
            z0.e(r107, 2, r102, r108);
            return;
        L11:
            z0 r109 = this.f379811a;
            Integer r110 = Integer.valueOf(r101);
            com.bytedance.ies.xbridge.XBridgeMethod.Callback r111 = this.f379812b;
            r109.getClass();
            z0.e(r110, 1, r102, r111);
            return;
        L12:
            Lazy r112 = CommonDouYinLoginKV.f356938a;
            CommonDouYinLoginKV.d();
            z0 r113 = this.f379811a;
            Integer r114 = Integer.valueOf(r101);
            if (r102 != null) goto L15;
            r102 = "success";
        L15:
            com.bytedance.ies.xbridge.XBridgeMethod.Callback r115 = this.f379812b;
            r113.getClass();
            z0.e(r114, 0, r102, r115);
            return;
        L16:
            z0 r116 = this.f379811a;
            Integer r117 = Integer.valueOf(r101);
            if (r102 != null) goto L19;
            r102 = "success";
        L19:
            com.bytedance.ies.xbridge.XBridgeMethod.Callback r118 = this.f379812b;
            r116.getClass();
            z0.e(r117, 0, r102, r118);
            return;
        L5:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    public z0() {
        this.f379810a = "app.douyinAuth";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f379810a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r410, com.bytedance.ies.xbridge.XBridgeMethod.Callback r411, XBridgePlatformType r412) {
        Intrinsics.checkNotNullParameter(r410, "params");
        Intrinsics.checkNotNullParameter(r411, "callback");
        Intrinsics.checkNotNullParameter(r412, "type");
        int r100 = r410.getInt("guide_type");
        if (r410.getInt("go_market") != 1) goto L5;
        boolean r110 = true;
    L7:
        if (r410.getInt("request_server") != 1) goto L9;
        boolean r111 = true;
    L10:
        XReadableMap r101 = r410.getMap("extra_info");
        if (r101 == null) goto L36;
        Map<String, Object> r102 = r101.toMap();
        if (r102 == null) goto L36;
        Bundle r103 = new Bundle();
        Iterator<Map.Entry<String, Object>> r104 = r102.entrySet().iterator();
    L16:
        if (r104.hasNext() == false) goto L35;
        Map.Entry<String, Object> r105 = r104.next();
        String r106 = r105.getKey();
        Object r107 = r105.getValue();
        if ((r107 instanceof String) == true) goto L19;
        if ((r107 instanceof Integer) == true) goto L22;
        if ((r107 instanceof Boolean) == true) goto L25;
        if ((r107 instanceof Float) == true) goto L28;
        if ((r107 instanceof Double) == true) goto L31;
        if ((r107 instanceof Long) == false) goto L16;
        r103.putLong(r106, ((Number) r107).longValue());
        goto L16
    L31:
        r103.putDouble(r106, ((Number) r107).doubleValue());
        goto L16
    L28:
        r103.putFloat(r106, ((Number) r107).floatValue());
        goto L16
    L25:
        r103.putBoolean(r106, ((Boolean) r107).booleanValue());
        goto L16
    L22:
        r103.putInt(r106, ((Number) r107).intValue());
        goto L16
    L19:
        r103.putString(r106, (String) r107);
        goto L16
    L35:
        Bundle r112 = r103;
    L37:
        XReadableMap r108 = r410.getMap("track_info");
        if (r108 == null) goto L40;
        Map<String, Object> r109 = r108.toMap();
    L41:
        if (r109 == null) goto L44;
        Object r113 = r109.get("current_page");
        if (r113 == null) goto L44;
    L45:
        String r114 = r113.toString();
        if (r109 == null) goto L49;
        Object r115 = r109.get("source");
        if (r115 == null) goto L49;
    L50:
        String r116 = r115.toString();
        XReadableMap r117 = r410.getMap("alert_config");
        if (r117 == null) goto L53;
        Map<String, Object> r118 = r117.toMap();
    L54:
        Activity r119 = AppHost.f326268a.a().getCurrentActivity();
        if ((r119 instanceof FragmentActivity) == false) goto L57;
        FragmentActivity r120 = (FragmentActivity) r119;
    L58:
        if (r120 != null) goto L61;
        e(-999, 1, "current activity is null", r411);
        return;
    L61:
        CommonDouYinLoginUtil r121 = CommonDouYinLoginUtil.f356945a;
        b r122 = new b(this, r411);
        if (r118 == null) goto L66;
        Object r123 = r118.get("title");
        if (r123 == null) goto L66;
        String r124 = r123.toString();
    L67:
        if (r118 == null) goto L71;
        Object r125 = r118.get("message");
        if (r125 == null) goto L71;
        String r126 = r125.toString();
    L72:
        if (r118 == null) goto L76;
        Object r127 = r118.get("download_btn");
        if (r127 == null) goto L76;
        String r128 = r127.toString();
    L77:
        GuideType.Companion.getClass();
        GuideType[] r129 = GuideType.values();
        int r130 = r129.length;
        int r131 = 0;
    L78:
        if (r131 >= r130) goto L86;
        GuideType r132 = r129[r131];
        GuideType[] r413 = r129;
        if (r132.getValue() != r100) goto L82;
        boolean r133 = true;
    L83:
        if (r133 == true) goto L87;
        r131 = r131 + 1;
        r129 = r413;
    L87:
        if (r132 != null) goto L89;
        int r134 = -1;
    L91:
        if (r134 != 1) goto L93;
        Integer r310 = Integer.valueOf(R.drawable.larus_binder_douyin);
        if (r124 != null) goto L109;
        r124 = ContextCompat.getString(r120, R.string.larus_settings_bottomsheet_title_douyin_cn);
    L109:
        String r311 = r124;
        if (r126 != null) goto L112;
        r126 = ContextCompat.getString(r120, R.string.larus_settings_bottomsheet_desc_douyin_cn);
    L112:
        com.larus.login.api.i r135 = new com.larus.login.api.i(r310, null, r311, r126, ContextCompat.getString(r120, R.string.larus_settings_bottomsheet_btn_link_douyin_cn), ContextCompat.getString(r120, R.string.larus_settings_bottomsheet_btn_later_cn), false, null, null, false, 32706);
    L113:
        com.larus.login.api.k0 r136 = new com.larus.login.api.k0(r120, r114, r116, null, r110, r111, r122, null, r112, null, r135, 200, null, null, null, null, null, 127624);
        r121.getClass();
        CommonDouYinLoginUtil.s(r136);
        return;
    L93:
        if (r134 == 2) goto L95;
        r135 = null;
        goto L113
    L95:
        Integer r137 = Integer.valueOf(R.drawable.larus_binder_douyin);
        String r210 = ContextCompat.getString(r120, R.string.larus_gift_bottomsheet_title_link_douyin_cn);
        String r211 = ContextCompat.getString(r120, R.string.larus_gift_bottomsheet_desc_link_douyin_cn);
        ILoginApi r138 = (ILoginApi) ServiceManager.get().getService(ILoginApi.class);
        if (r138 == null) goto L100;
        boolean r139 = true;
        if (r138.I(r120) != true) goto L100;
    L101:
        if (r139 == true) goto L104;
        if (r128 != null) goto L105;
        r128 = ContextCompat.getString(r120, R.string.larus_gift_bottomsheet_btn_download_douyin_cn);
    L105:
        r135 = new com.larus.login.api.i(r137, null, r210, r211, r128, ContextCompat.getString(r120, R.string.larus_gift_bottomsheet_btn_notNow_cn), false, null, null, false, 32706);
        goto L113
    L104:
        r128 = ContextCompat.getString(r120, R.string.larus_gift_bottomsheet_btn_link_douyin_cn);
        Intrinsics.checkNotNull(r128);
    L100:
        r139 = false;
        goto L101
    L89:
        r134 = a1.f379689a[r132.ordinal()];
        goto L91
    L82:
        r133 = false;
        goto L83
    L86:
        r132 = null;
    L76:
        r128 = null;
    L71:
        r126 = null;
    L66:
        r124 = null;
        goto L67
    L57:
        r120 = null;
        goto L58
    L53:
        r118 = null;
    L49:
        r115 = r112.getString("enter_from", "douyin_auth_xbridge");
    L44:
        r113 = "xbridge";
        goto L45
    L40:
        r109 = null;
    L36:
        r112 = new Bundle();
        goto L37
    L9:
        r111 = false;
        goto L10
    L5:
        r110 = false;
        goto L7
    }

    public static void e(Integer r100, Integer r101, String r102, com.bytedance.ies.xbridge.XBridgeMethod.Callback r103) {
        Pair[] r104 = new Pair[3];
        if (r101 == null) goto L5;
        int r105 = r101.intValue();
    L6:
        r104[0] = TuplesKt.to("status", Integer.valueOf(r105));
        if (r100 == null) goto L9;
        int r106 = r100.intValue();
    L10:
        r104[1] = TuplesKt.to("code", Integer.valueOf(r106));
        if (r102 != null) goto L13;
        r102 = "";
    L13:
        r104[2] = TuplesKt.to("msg", r102);
        r103.invoke(MapsKt.mutableMapOf(r104));
        return;
    L9:
        r106 = -1;
        goto L10
    L5:
        r105 = 1;
        goto L6
    }
}
