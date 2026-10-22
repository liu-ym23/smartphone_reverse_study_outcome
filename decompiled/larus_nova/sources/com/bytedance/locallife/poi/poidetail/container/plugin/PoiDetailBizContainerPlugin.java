package com.bytedance.locallife.poi.poidetail.container.plugin;

import androidx.lifecycle.Observer;
import com.bytedance.locallife.dito.data.l;
import com.bytedance.locallife.dito.data.v;
import com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin;
import com.bytedance.locallife.model.poi.resp.PoiDetail;
import com.ss.android.ugc.aweme.poi.bean.PoiDetailNewPageParams;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/poi/poidetail/container/plugin/PoiDetailBizContainerPlugin;", "Lcom/bytedance/locallife/dito/plugin/AbsDitoLifeCyclePlugin;", "<init>", "()V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public class PoiDetailBizContainerPlugin extends AbsDitoLifeCyclePlugin {

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiDetailBizContainerPlugin f263879a;

        public a(PoiDetailBizContainerPlugin r100) {
            this.f263879a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            v r101 = (v) r100;
            if (r101.f258263a == false) goto L6;
            this.f263879a.y(r101);
            return;
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiDetailBizContainerPlugin f263880a;

        public b(PoiDetailBizContainerPlugin r100) {
            this.f263880a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            v r101 = (v) r100;
            if (r101.f258263a == false) goto L6;
            this.f263880a.getClass();
            Intrinsics.checkNotNullParameter(r101, "data");
            return;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiDetailBizContainerPlugin f263881a;

        public c(PoiDetailBizContainerPlugin r100) {
            this.f263881a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            l r101 = (l) r100;
            if (Intrinsics.areEqual(r101.getType(), "DATA_REFRESH") == false) goto L6;
            this.f263881a.z(r101);
            return;
        L6:
            if (Intrinsics.areEqual(r101.getType(), "DATA_UPDATE") == false) goto L9;
            this.f263881a.A(r101);
            return;
        L9:
            if (Intrinsics.areEqual(r101.getType(), "REQUEST_COMPLETE") == false) goto L14;
            this.f263881a.x(r101);
            return;
        }
    }

    public void A(l r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    public void x(l r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    public void y(v r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    public void z(l r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin, com.bytedance.locallife.dito.core.AbsDitoPlugin
    public void h() {
        super.h();
        e().x().observeForever(new a(this));
        e().y().observeForever(new b(this));
        g().f258041g.H().observeForever(new c(this));
    }

    public final wy6.a s() {
        Object r100 = g().A.get("ability_provider");
        if ((r100 instanceof wy6.a) == true) goto L7;
        return null;
    L7:
        return (wy6.a) r100;
    }

    public final PoiDetailNewPageParams t() {
        Object r100 = g().A.get("PoiDetailNewPageParams");
        if ((r100 instanceof PoiDetailNewPageParams) == true) goto L7;
        return null;
    L7:
        return (PoiDetailNewPageParams) r100;
    }

    public final PoiBundle v() {
        Object r100 = g().A.get("poi_bundle");
        if ((r100 instanceof PoiBundle) == true) goto L7;
        return null;
    L7:
        return (PoiBundle) r100;
    }

    public final PoiDetail w() {
        Object r100 = g().A.get("poi_detail");
        if ((r100 instanceof PoiDetail) == true) goto L7;
        return null;
    L7:
        return (PoiDetail) r100;
    }

    public PoiDetailBizContainerPlugin() {
    }
}
