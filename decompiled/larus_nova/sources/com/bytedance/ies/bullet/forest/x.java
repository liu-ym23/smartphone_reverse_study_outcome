package com.bytedance.ies.bullet.forest;

import android.net.Uri;
import com.bytedance.forest.model.ResourceFrom2;
import com.bytedance.forest.postprocessor.ProcessableData;
import com.bytedance.ies.argus.api.ArgusLynxDelegate;
import com.bytedance.ies.argus.api.ArgusResourceType;
import com.bytedance.ies.argus.api.params.LoadTemplateParams;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class x {
    public static final void a(ProcessableData r210, byte[] r211) {
        ArgusResourceType r100 = ArgusResourceType.LYNX_MAIN_TEMPLATE;
        String r101 = r210.f244432c;
        boolean r110 = false;
        if (StringsKt.startsWith$default(r101, "https://", false, 2, null) == false) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L12;
        r101 = null;
    L12:
        ResourceFrom2 r103 = r210.f244440k;
        ResourceFrom2 r104 = ResourceFrom2.CDN;
        if (r103 == r104) goto L21;
        ResourceFrom2 r105 = r210.f244439j;
        if (r105 == r104) goto L21;
        ResourceFrom2 r106 = ResourceFrom2.CDN_CACHE;
        if (r103 == r106) goto L21;
        if (r105 == r106) goto L21;
        boolean r107 = false;
    L22:
        if (r107 == false) goto L24;
        String r108 = r101;
    L25:
        Uri r111 = r210.f244431b;
        String r109 = r210.f244430a;
        long r112 = r210.f244434e;
        LoadTemplateParams r113 = new LoadTemplateParams(LoadTemplateParams.TemplateType.TemplateBundle, new com.bytedance.ies.argus.api.params.j(r109, r108, r210.f244435f, r210.f244436g, "Forest_TemplateBundle", Long.valueOf(r112), r100, null, null, null, r210.f244437h, r111, null, 10000), "Forest_TemplateBundle", r211, null, null);
        int r114 = ArgusLynxDelegate.f245627d;
        Intrinsics.checkNotNullParameter(r113, "params");
        com.bytedance.ies.argus.aspect.c r115 = com.bytedance.ies.argus.aspect.c.f245800a;
        Intrinsics.checkNotNullParameter(r113, "params");
        String r116 = r113.f245672f;
        if (r116 != null) goto L28;
    L29:
        r110 = true;
    L30:
        if (r110 == true) goto L37;
        ConcurrentHashMap<String, LoadTemplateParams> r117 = com.bytedance.ies.argus.aspect.c.f245801b;
        if (r117.size() <= 30) goto L35;
        r117.clear();
    L35:
        r117.put(r116, r113);
        return;
    L37:
        return;
    L28:
        if (r116.length() != 0) goto L30;
    L24:
        r108 = null;
    L21:
        r107 = true;
        goto L22
    L5:
        if (StringsKt.startsWith$default(r101, "http://", false, 2, null) == true) goto L8;
        r102 = false;
        goto L9
    }
}
