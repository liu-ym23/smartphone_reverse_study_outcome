package com.bytedance.locallife.live.dsl;

import com.alibaba.gaiax.api.GXRegisterCenterApi;
import com.alibaba.gaiax.template.GXTemplate;
import com.alibaba.gaiax.template.GXTemplateItem;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class GeckoBinarySource implements GXRegisterCenterApi.GXIExtensionTemplateSource {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<GeckoBinarySource> f259402d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, GXTemplate> f259403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f259404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f259405c;

    public static final class a {
        public static GeckoBinarySource a() {
            return GeckoBinarySource.f259402d.getValue();
        }
    }

    public interface b {
        void a(String r100, String r101, JSONObject r102);

        void b(String r100, String r101, JSONObject r102);
    }

    static {
        f259402d = LazyKt.lazy(GeckoBinarySource$Companion$instance$2.INSTANCE);
    }

    public GeckoBinarySource() {
        this.f259403a = new ConcurrentHashMap();
        this.f259404b = new ArrayList();
        this.f259405c = LazyKt.lazy(GeckoBinarySource$gxTemplateInfoSourceDelegate$2.INSTANCE);
    }

    @Override // com.alibaba.gaiax.api.GXRegisterCenterApi.GXIExtensionTemplateSource
    public final GXTemplate getTemplate(GXTemplateItem r100) {
        Intrinsics.checkNotNullParameter(r100, "gxTemplateItem");
        if (r100.getTemplateVersion().length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        r100.setTemplateVersion(h.c());
    L9:
        return this.f259403a.get(r100.getTemplateId() + r100.getTemplateVersion());
    L5:
        r101 = false;
        goto L6
    }
}
