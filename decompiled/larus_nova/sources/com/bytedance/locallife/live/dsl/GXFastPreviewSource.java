package com.bytedance.locallife.live.dsl;

import com.alibaba.gaiax.api.GXRegisterCenterApi;
import com.alibaba.gaiax.template.GXTemplate;
import com.alibaba.gaiax.template.GXTemplateItem;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class GXFastPreviewSource implements GXRegisterCenterApi.GXIExtensionTemplateSource, it6.g.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy<GXFastPreviewSource> f259395f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final it6.g f259396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, GXTemplate> f259397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<it6.g.a> f259398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f259399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f259400e;

    public static final class a {
        public static GXFastPreviewSource a() {
            return GXFastPreviewSource.f259395f.getValue();
        }
    }

    public static final class b implements at6.c {
        @Override // at6.c
        public final void OZ() {
            Intrinsics.checkNotNullParameter(null, "event");
        }

        public b() {
        }

        @Override // at6.c
        public final void Pd(String r100, JSONObject r101) {
            at6.c.a.a(r100, r101);
        }
    }

    static {
        f259395f = LazyKt.lazy(GXFastPreviewSource$Companion$instance$2.INSTANCE);
    }

    public GXFastPreviewSource() {
        this.f259396a = LiveLifeSaaSUtil.g();
        this.f259397b = new LinkedHashMap();
        this.f259398c = new ArrayList();
        this.f259399d = LazyKt.lazy(GXFastPreviewSource$gxTemplateInfoSourceDelegate$2.INSTANCE);
        this.f259400e = new b();
    }

    public final void a(it6.g.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) this.f259398c).add(r100);
    }

    @Override // com.alibaba.gaiax.api.GXRegisterCenterApi.GXIExtensionTemplateSource
    public final GXTemplate getTemplate(GXTemplateItem r100) {
        Intrinsics.checkNotNullParameter(r100, "gxTemplateItem");
        Map<String, GXTemplate> r101 = this.f259397b;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        return (GXTemplate) r102.get(r100.getTemplateId());
    }
}
