package com.bytedance.locallife.poi.poidetail.container.plugin.business;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Observer;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.bytedance.locallife.dito.data.t;
import com.bytedance.locallife.poi.poidetail.container.plugin.PoiDetailBizContainerPlugin;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/poi/poidetail/container/plugin/business/PoiBusinessPopupPlugin;", "Lcom/bytedance/locallife/poi/poidetail/container/plugin/PoiDetailBizContainerPlugin;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiBusinessPopupPlugin extends PoiDetailBizContainerPlugin {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ty6.a f263959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f263960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f263961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f263962g;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiBusinessPopupPlugin f263963a;

        public b(PoiBusinessPopupPlugin r100) {
            this.f263963a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            PoiBusinessPopupPlugin r102 = this.f263963a;
            if (r102.f263960e == false) goto L5;
            r102.f263961f.postDelayed(new g(r102), r102.f263962g);
            return;
        L5:
            r102.f263959d.b();
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiBusinessPopupPlugin f263964a;

        public c(PoiBusinessPopupPlugin r100) {
            this.f263964a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            PoiBusinessPopupPlugin r102 = this.f263964a;
            r102.f263960e = true;
            ty6.a r103 = r102.f263959d;
            r103.getClass();
            Intrinsics.checkNotNullParameter("scene", "key");
            Intrinsics.checkNotNullParameter("auto_modal_view", "value");
            r103.f547974f.put("scene", "auto_modal_view");
        }
    }

    static {
    }

    public PoiBusinessPopupPlugin() {
        this.f263959d = new ty6.a();
        this.f263961f = new Handler(Looper.getMainLooper());
        this.f263962g = AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME;
    }

    @Override // com.bytedance.locallife.poi.poidetail.container.plugin.PoiDetailBizContainerPlugin, com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin, com.bytedance.locallife.dito.core.AbsDitoPlugin
    public final void h() {
        super.h();
        g().f258041g.a0("poi_detail_fmp_complete", 1).observeForever(new b(this));
        g().f258041g.a0("auto_open_modal_view", 1).observeForever(new c(this));
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin
    public final void j(t r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        ty6.a r101 = this.f263959d;
        EventCenter.registerJsEventSubscriber("poi_detail_popup_register", r101.f547975g);
        vn6.b.b(r101);
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin
    public final void l(t r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        ty6.a r101 = this.f263959d;
        EventCenter.unregisterJsEventSubscriber("poi_detail_popup_register", r101.f547975g);
        vn6.b.c(r101);
        Iterator r102 = ((LinkedHashMap) r101.f547972d).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry r103 = (Map.Entry) r102.next();
        EventCenter.unregisterJsEventSubscriber((String) r103.getKey(), (JsEventSubscriber) r103.getValue());
        goto L4
    L6:
        Iterator r104 = ((LinkedHashMap) r101.f547973e).entrySet().iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        vn6.b.c(((Map.Entry) r104.next()).getValue());
        goto L8
    }
}
