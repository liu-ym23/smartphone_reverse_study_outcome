package gx2;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.api.marketing.IMarketingRouterUtilsService;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.marketing.sdk.api.IMarketingServiceV2;
import com.bytedance.android.marketing.sdk.impl.MarketingServiceImplV2;
import com.bytedance.android.marketing.sdk.impl.data.ECMarketingDataCenter;
import com.bytedance.android.marketing.sdk.impl.data.SourceFrom;
import com.bytedance.android.marketing.sdk.impl.data.TrackData;
import com.bytedance.android.marketing.sdk.impl.data.h;
import com.bytedance.android.marketing.sdk.impl.utils.CommonUtils;
import com.bytedance.android.marketing.sdk.impl.utils.ECMarketingErrorType;
import com.bytedance.android.marketing.sdk.impl.utils.e;
import com.bytedance.android.marketing.sdk.impl.utils.f;
import com.bytedance.ies.bullet.service.router.d;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements bf.c {

    /* JADX INFO: renamed from: gx2.a$a, reason: collision with other inner class name */
    public static final class C6077a {
    }

    static {
    }

    public a() {
    }

    @Override // bf.c
    public final void a() {
    }

    @Override // bf.c
    public final String b() {
        return "ec/marketing";
    }

    @Override // bf.c
    public final boolean c(Context r110, Uri r210, boolean r211) {
        Context r100 = r110;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r210, "uri");
        String r101 = d.a(r210, "mega_object_id");
        String r102 = d.a(r210, "type");
        String r103 = d.a(r210, "top_level");
        String r104 = d.a(r210, "ec_marketing_load_hostview");
        String r105 = d.a(r210, "marketing_rit_tag");
        FrameLayout r106 = null;
        if ((r100 instanceof Activity) == true) goto L5;
        r100 = null;
    L5:
        Activity r107 = (Activity) r100;
        CommonUtils.f162812a.getClass();
        Activity r108 = CommonUtils.c();
        if (Intrinsics.areEqual(r104, "1") == false) goto L17;
        if (r107 != null) goto L9;
    L10:
        if (r107 != null) goto L12;
    L15:
        if (r107 == null) goto L17;
        int r109 = 1;
    L18:
        if (r101 != null) goto L20;
    L23:
        boolean r111 = true;
    L24:
        if (r111 == true) goto L121;
        if (r102 != null) goto L27;
    L30:
        boolean r112 = true;
    L31:
        if (r112 == true) goto L121;
        if (r102 == null) goto L127;
        int r113 = r102.hashCode();
        if (r113 == 3529469) goto L54;
        if (r113 == 94756344) goto L41;
        return false;
    L41:
        if (r102.equals("close") == false) goto L120;
        com.bytedance.android.marketing.sdk.impl.utils.b.i(r101, "router_close");
        Map<String, String> r114 = c.f483090a;
        Intrinsics.checkNotNullParameter(r101, "megaId");
        Map<String, String> r115 = c.f483090a;
        String r116 = (String) ((LinkedHashMap) r115).get(r101);
        if (r116 == null) goto L49;
        com.bytedance.android.marketing.sdk.api.c r117 = (com.bytedance.android.marketing.sdk.api.c) ((LinkedHashMap) ECMarketingDataCenter.f162720b).get(r116);
        if (r117 == null) goto L49;
        String r118 = r117.f162679j;
        String r119 = r117.f162680k;
        int r120 = com.bytedance.android.marketing.sdk.impl.utils.d.f162815a;
        com.bytedance.android.marketing.sdk.impl.utils.d.h(r101, "router_close", r118, r119);
        h r121 = (h) ((LinkedHashMap) ECMarketingDataCenter.f162719a).get(r116);
        if (r121 == null) goto L49;
        r121.h(r117.f162670a);
    L49:
        Intrinsics.checkNotNullParameter(r101, "megaId");
        r115.remove(r101);
        if (r115.isEmpty() == false) goto L52;
        ((LinkedHashMap) r115).clear();
    L52:
        return true;
    L120:
        return false;
    L54:
        if (r102.equals("show") == false) goto L126;
        com.bytedance.android.marketing.sdk.impl.utils.b.i(r101, "router_show");
        IMarketingRouterUtilsService r122 = (IMarketingRouterUtilsService) ServiceManager.get().getService(IMarketingRouterUtilsService.class);
        if (r122 == null) goto L58;
        JSONObject r123 = r122.getMegaObject(r101);
    L59:
        if (r123 != null) goto L62;
        int r124 = e.f162816a;
        e.e(r105, null, null, ECMarketingErrorType.ROUTER_SCHEMA_FORMAT_ERROR.getCode(), "router schema format error，megaObject is null", null, SourceFrom.ROUTER.getValue());
        return false;
    L62:
        String r125 = r123.optString("data");
        if (r125.length() <= 0) goto L65;
        boolean r126 = true;
    L66:
        if (r126 == true) goto L69;
        r125 = null;
    L69:
        String r127 = "";
        if (r125 != null) goto L78;
        JSONObject r128 = r123.optJSONObject("data");
        if (r128 == null) goto L74;
        r125 = r128.toString();
    L75:
        if (r125 != null) goto L78;
        r125 = "";
        goto L78
    L74:
        r125 = null;
    L78:
        if (r125.length() != 0) goto L80;
        boolean r129 = true;
    L81:
        if (r129 == false) goto L84;
        int r130 = e.f162816a;
        e.e(r105, null, null, ECMarketingErrorType.ROUTER_SCHEMA_FORMAT_ERROR.getCode(), "router schema format error，marketingData is empty", null, SourceFrom.ROUTER.getValue());
        return false;
    L84:
        JSONObject r131 = r123.optJSONObject("bizParams");
        if (r131 == null) goto L88;
        String r132 = r131.optString("page_name");
        if (r132 == null) goto L88;
    L89:
        if (r131 == null) goto L94;
        String r133 = r131.optString("enter_from");
        if (r133 == null) goto L94;
        r127 = r133;
    L94:
        int r134 = com.bytedance.android.marketing.sdk.impl.utils.d.f162815a;
        com.bytedance.android.marketing.sdk.impl.utils.d.h(r101, "router_show", r132, r127);
        com.bytedance.android.marketing.sdk.api.c r135 = new com.bytedance.android.marketing.sdk.api.c(null, null);
        r135.f162670a = r125;
        r135.d(r132);
        r135.c(r127);
        r135.f162683n = r109;
        r135.f162681l.put("ec_marketing_load_hostview", Integer.valueOf(r109));
        if (r107 == null) goto L97;
        r135.f162672c = new WeakReference(r107);
    L98:
        if (r131 == null) goto L101;
        r135.f162681l.putAll(f.b(r131));
    L101:
        if (Intrinsics.areEqual(r103, "1") == true) goto L103;
    L117:
        if (r106 == null) goto L119;
        Intrinsics.checkNotNullParameter(r106, KtvSubElement.CONTAINER);
        r135.f162671b = r106;
    L119:
        String r136 = IMarketingServiceV2.a.a(new MarketingServiceImplV2(), r135, 0, null, r105, null, null, SourceFrom.ROUTER.getValue(), 54);
        Map<String, String> r137 = c.f483090a;
        Intrinsics.checkNotNullParameter(r101, "megaId");
        Intrinsics.checkNotNullParameter(r136, "pageId");
        c.f483090a.put(r101, r136);
        goto L52
    L103:
        if ((r107 instanceof AppCompatActivity) == true) goto L105;
        r107 = null;
    L105:
        AppCompatActivity r138 = (AppCompatActivity) r107;
        if (r138 == null) goto L117;
        Fragment r139 = (Fragment) CollectionsKt.lastOrNull(r138.getSupportFragmentManager().getFragments());     // Catch: Exception -> L116
        if (r139 == null) goto L110;
        View r140 = r139.getView();     // Catch: Exception -> L116
    L112:
        if ((r140 instanceof FrameLayout) == true) goto L114;
        r140 = null;
    L114:
        r106 = (FrameLayout) r140;     // Catch: Exception -> L116
        goto L117
    L110:
        r140 = null;
        goto L112
    L97:
        r135.f162672c = null;
    L88:
        r132 = "";
        goto L89
    L80:
        r129 = false;
        goto L81
    L65:
        r126 = false;
        goto L66
    L58:
        r123 = null;
        goto L59
    L126:
        return false;
    L127:
        return false;
    L27:
        if (r102.length() == 0) goto L30;
        r112 = false;
    L121:
        int r141 = e.f162816a;
        e.e(r105, null, null, ECMarketingErrorType.ROUTER_SCHEMA_FORMAT_ERROR.getCode(), "router schema format error，megaObjectId or type is null", null, SourceFrom.ROUTER.getValue());
        return false;
    L20:
        if (r101.length() == 0) goto L23;
        r111 = false;
        goto L24
    L12:
        if (r107.isDestroyed() != true) goto L15;
    L13:
        com.bytedance.android.marketing.sdk.impl.utils.b.e("activity已经销毁, 不展示");
        int r142 = com.bytedance.android.marketing.sdk.impl.utils.d.f162815a;
        TrackData r143 = new TrackData();
        SourceFrom r144 = SourceFrom.ROUTER;
        com.bytedance.android.marketing.sdk.impl.utils.d.c(r143, "", 2, "", "", "container_destroyed", r144.getValue());
        int r145 = e.f162816a;
        e.e(r105, null, null, ECMarketingErrorType.ACTIVITY_DESTROYED_NO_DISPLAY.getCode(), "宿主容器已经销毁，不展示", null, r144.getValue());
        return false;
    L9:
        if (r107.isFinishing() == true) goto L13;
    L17:
        r107 = r108;
        r109 = 0;
        goto L18
    }
}
