package com.bytedance.locallife.live.anchor;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.locallife.live.viewmodel.LiveLocalLifeViewModel;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import nv6.r0;
import nv6.z;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f259134b;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.locallife.live.anchor.c
    public final <T> T a() {
        LiveLocalLifeViewModel.Companion r100 = LiveLocalLifeViewModel.Companion;
        String r101 = this.f259134b;
        r100.getClass();
        LiveLocalLifeViewModel r102 = LiveLocalLifeViewModel.Companion.a(r101);
        if (r102 == null) goto L78;
        LifeAnchorDynamicIconManager r103 = r102.getLifeAnchorDynamicIconManager();
        if (r103 == null) goto L78;
        jv6.h r104 = com.bytedance.locallife.live.settings.c.f();
        if (r104 == null) goto L9;
        int r105 = r104.c();
    L10:
        if (r105 != 1) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == true) goto L18;
        int r107 = LifeAnchorDynamicIconManager.f259093h;
        long r108 = System.currentTimeMillis() / ((long) 1000);
        LiveLifeSaaSUtil.t().d("LifeAnchorDynamicIconManager", "getDynamicIcon => " + r108 + ", currRoomReqDynamicIconCount => " + r103.f259098e);
        if (r103.f259098e != 0) goto L19;
        r103.f259098e = 1;
        goto L18
    L19:
        k r109 = r103.f259096c;
        Iterator r110 = ((ArrayList) r103.f259095b).iterator();
        UrlModel r111 = null;
    L21:
        if (r110.hasNext() == false) goto L74;
        z r112 = (z) r110.next();
        String r113 = r112.a();
        r0 r114 = r112.c();
        if (r113 == null) goto L71;
        if (r114 == null) goto L71;
        if (r109 == null) goto L32;
        Map<String, j> r115 = r109.f259155a;
        if (r115 == null) goto L32;
        j r116 = r115.get(r113);
        if (r116 != null) goto L31;
        r116 = new j(r113, 30);
        r116.f(r103.a(r114));
        r115.put(r113, r116);
    L31:
        j r117 = r116;
    L33:
        if (r117 == null) goto L71;
        if (r117.b() >= r108) goto L38;
        r117.f(r103.a(r114));
        r117.h(0);
        r117.g(0);
        r117.e(0);
    L38:
        if (r117.d() >= r114.c()) goto L71;
        if (r117.a() >= r108) goto L71;
        LiveLifeSaaSUtil.t().d("LifeAnchorDynamicIconManager", "maybe atmosphereKey => " + r113 + ", {" + r103.f259097d + ", " + r113 + '}');
        if (TextUtils.equals(r103.f259097d, r113) == true) goto L69;
        String r118 = r103.f259097d;
        if (r118 != null) goto L46;
    L49:
        boolean r119 = true;
    L50:
        if (r119 == true) goto L56;
        j r120 = r109.f259155a.get(r103.f259097d);
        if (r120 == null) goto L56;
        if (r120.c() <= r120.d()) goto L56;
        r120.h(r120.c());
    L56:
        r103.f259097d = r113;
        r103.f259099f = r112;
        r117.g(r117.d() + 1);
        LinkedHashMap r121 = new LinkedHashMap();
        String r122 = r112.a();
        if (r122 != null) goto L59;
        r122 = "";
    L59:
        r121.put("coupon_notice_type", r122);
        Map<String, String> r123 = r112.d();
        if (r123 == null) goto L62;
        r121.putAll(r123);
    L62:
        int r124 = qv6.e.f534905a;
        qv6.e.a("resource_entrance_show", r121, false, r103.f259094a);
        Map<String, String> r125 = r112.d();
        if (r125 == null) goto L67;
        List<String> r126 = null;
        String r127 = com.bytedance.locallife.live.util.h.c(LiveLifeSaaSUtil.r(), r125, null, 6);
        if (r127 == null) goto L68;
        r121.put("marketing_resource_extra_info", r127);
    L68:
        qv6.e.a("live_life_icon_notice_show", r121, false, r103.f259094a);
        LiveLifeSaaSUtil.t().d("LifeAnchorDynamicIconManager", "currAtmosphereType => " + r103.f259097d + ", totalPlayedTimes => " + r117.d());
    L70:
        r111 = r112.b();
    L72:
        if (r111 == null) goto L21;
    L75:
        r103.f259096c = r109;
        LifeAnchorDynamicIconManager.b(r109);
        if (r111 == null) goto L79;
        List<String> r128 = r111.getUrlList();
    L80:
        List<String> r129 = r128;
        if (r129 != null) goto L83;
    L86:
        boolean r130 = true;
    L87:
        if (r130 == true) goto L97;
        T r131 = (T) f.b(r128);
        if (r131 != null) goto L91;
        r131 = (T) r126;
    L91:
        if (r131 != null) goto L111;
        List<String> r132 = this.f259150a;
        if (r132 == null) goto L103;
        ImageRequest[] r133 = f.b(r132);
        if (r133 == null) goto L103;
    L102:
        Object r134 = r133;
    L105:
        return (T) r134;
    L103:
        r134 = r126;
        goto L105
    L111:
        return r131;
    L97:
        List<String> r135 = this.f259150a;
        if (r135 == null) goto L103;
        r133 = f.b(r135);
        if (r133 != null) goto L102;
    L83:
        if (r129.isEmpty() == true) goto L86;
        r130 = false;
    L79:
        r128 = r126;
        goto L80
    L67:
        r126 = null;
        goto L68
    L46:
        if (r118.length() == 0) goto L49;
        r119 = false;
        goto L50
    L69:
        r126 = null;
    L32:
        r117 = null;
    L71:
        r126 = null;
        goto L72
    L74:
        r126 = null;
    L18:
        r128 = null;
        r126 = null;
        goto L80
    L12:
        r106 = false;
        goto L13
    L9:
        r105 = 1;
    L78:
        r126 = null;
        goto L79
    }

    public b(List<String> r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        super(r100);
        this.f259134b = r101;
    }
}
