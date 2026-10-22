package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.model.CategoryEffectModel;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.PanelInfoModel;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f458003a = 0;

    static {
    }

    public static void a(EffectConfig r100, String r101, PanelInfoModel r102) {
        CategoryEffectModel r103 = r102.getCategory_effects();
        if (r103 == null) goto L12;
        com.ss.ugc.effectplatform.util.h r104 = com.ss.ugc.effectplatform.util.h.f458037a;
        String r105 = r100.f457163i;
        List<Effect> r106 = r103.getCategory_effects();
        r104.getClass();
        com.ss.ugc.effectplatform.util.h.d(r105, r101, r106);
        com.ss.ugc.effectplatform.util.h.d(r100.f457163i, r101, r103.getCollection());
        com.ss.ugc.effectplatform.util.h.d(r100.f457163i, r101, r103.getBind_effects());
        if (r100.f457173s != 2) goto L13;
        com.ss.ugc.effectplatform.util.h.h(r102.getUrl_prefix(), r103.getCategory_effects());
        com.ss.ugc.effectplatform.util.h.h(r102.getUrl_prefix(), r103.getCollection());
        com.ss.ugc.effectplatform.util.h.h(r102.getUrl_prefix(), r103.getBind_effects());
        PanelInfoModel.Extra r107 = r102.getExtra();
        if (r107 == null) goto L14;
        String r108 = r107.getRec_id();
        if (r108 == null) goto L15;
        com.ss.ugc.effectplatform.util.h.f(r108, r103.getCategory_effects());
        com.ss.ugc.effectplatform.util.h.f(r108, r103.getCollection());
        com.ss.ugc.effectplatform.util.h.f(r108, r103.getBind_effects());
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }
}
