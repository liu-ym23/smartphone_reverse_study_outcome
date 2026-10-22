package com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.extension;

import android.net.Uri;
import com.bytedance.caijing.sdk.infra.base.api.alog.ALogService;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements com.bytedance.ies.bullet.service.webkit.c {
    public f() {
    }

    @Override // com.bytedance.ies.bullet.service.webkit.c
    public final com.bytedance.ies.bullet.service.webkit.a a(com.bytedance.ies.bullet.service.webkit.d r100, q26.j r101) {
        Intrinsics.checkNotNullParameter(r100, "service");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        BulletContext r102 = (BulletContext) r101.a(BulletContext.class);
        String r103 = null;
        if (r102 == null) goto L7;
        t36.d r104 = r102.f246437e;
        if (r104 == null) goto L7;
        Uri r105 = r104.getOriginUrl();
    L8:
        if (r105 == null) goto L11;
        r103 = UriProtector.getQueryParameter(r105, "loader_name");
    L11:
        if (Intrinsics.areEqual(r103, "forest") == false) goto L16;
        ve4.a.f554342a.getClass();
        ALogService r106 = (ALogService) ve4.a.a(ALogService.class);
        if (r106 == null) goto L21;
        r106.i("CJPayAnnieWebKitService", "use DefaultWebKitDelegate");
    L21:
        return new com.bytedance.ies.bullet.kit.web.impl.c(r100);
    L16:
        ve4.a.f554342a.getClass();
        ALogService r107 = (ALogService) ve4.a.a(ALogService.class);
        if (r107 == null) goto L20;
        r107.i("CJPayAnnieWebKitService", "use CJPayAnnieWebKitDelegate");
    L20:
        return new CJPayAnnieWebKitDelegate(r100);
    L7:
        r105 = null;
        goto L8
    }
}
