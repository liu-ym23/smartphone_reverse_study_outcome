package com.bytedance.locallife.pdp.action;

import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.dito.provider.e;
import com.bytedance.locallife.host.photo.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ww6.i;

/* JADX INFO: loaded from: classes21.dex */
public final class GoodsDetailBizContainerActionProvider implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DitoViewModel f260869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f260870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, fq6.a> f260871c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.locallife.dito.provider.e
    public final Map<String, fq6.a> a() {
        return this.f260871c;
    }

    public GoodsDetailBizContainerActionProvider(DitoViewModel r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "ditoViewModel");
        Intrinsics.checkNotNullParameter(r101, "bizContext");
        this.f260869a = r100;
        this.f260870b = r101;
        LinkedHashMap r102 = new LinkedHashMap();
        final du6.a r103 = HostServiceUtilsKt.i0();
        final b r104 = HostServiceUtilsKt.W();
        r102.put("openShortImagePreview", new GoodsDetailBizContainerActionProvider$actionMap$1$1(this, r104));
        r102.put("openLongImagePreview", new GoodsDetailBizContainerActionProvider$actionMap$1$2(this, r104));
        r102.put(com.bytedance.android.ec.core.event.a.KEY_TRACKER, new GoodsDetailBizContainerActionProvider$actionMap$1$3(this));
        r102.put("openImagePreview", new GoodsDetailBizContainerActionProvider$actionMap$1$4(this, r104));
        r102.put("openPoiFeed", new GoodsDetailBizContainerActionProvider$actionMap$1$5(this));
        r102.put("openPreviewImageDetailPage", new GoodsDetailBizContainerActionProvider$actionMap$1$6(this, r103));
        r102.put("openFoodBigImagePage", new GoodsDetailBizContainerActionProvider$actionMap$1$7(this, r103, r104));
        r102.put("jsBroadcast", new GoodsDetailBizContainerActionProvider$actionMap$1$8(this));
        r102.put("openSchema", new GoodsDetailBizContainerActionProvider$actionMap$1$9(this));
        this.f260871c = r102;
    }
}
