package com.bytedance.locallife.poi.poidetail.container.plugin.business;

import com.bytedance.locallife.biz.screenshot.ScreenShotHelper;
import com.bytedance.locallife.dito.data.t;
import com.bytedance.locallife.poi.poidetail.container.plugin.PoiDetailBizContainerPlugin;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.screenshot.OnScreenShotListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/locallife/poi/poidetail/container/plugin/business/PoiBusinessMobScreenshotPlugin;", "Lcom/bytedance/locallife/poi/poidetail/container/plugin/PoiDetailBizContainerPlugin;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiBusinessMobScreenshotPlugin extends PoiDetailBizContainerPlugin {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<String> f263951f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f263952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f263953e;

    public static final class a {
    }

    public static final class b implements OnScreenShotListener {
        public b(PoiBusinessMobScreenshotPlugin r100) {
        }
    }

    @Override // com.bytedance.locallife.dito.core.AbsDitoPlugin, com.bytedance.locallife.dito.core.d0
    public final String getName() {
        return "poi_screenshot_plugin";
    }

    static {
        f263951f = new ArrayList();
    }

    public PoiBusinessMobScreenshotPlugin() {
        Intrinsics.checkNotNullParameter("poi_detail_new", "enterFrom");
        this.f263952d = "poi_detail_new";
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin
    public final void j(t r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        if (this.f263953e != null) goto L6;
        this.f263953e = new b(this);
        return;
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin
    public final void n(t r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        b r101 = this.f263953e;
        if (r101 == null) goto L5;
        ScreenShotHelper.b(r101);
    L5:
        CollectionsKt.removeLastOrNull(f263951f);
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin
    public final void o(t r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        List<String> r101 = f263951f;
        ArrayList r102 = (ArrayList) r101;
        r102.add(this.f263952d);
        b r103 = this.f263953e;
        if (r103 == null) goto L6;
        ScreenShotHelper.a(r103);
        return;
    }
}
