package com.larus.office.base;

import androidx.fragment.app.Fragment;
import com.larus.feishu.office.im.api.FlowComponentAdaptService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class u implements eza.a {
    public u() {
    }

    @Override // eza.a
    public final void o(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        FlowComponentAdaptService r101 = (FlowComponentAdaptService) ServiceManager.get().getService(FlowComponentAdaptService.class);
        if (r101 == null) goto L6;
        r101.o(r100);
        return;
    }

    @Override // eza.a
    public final void p(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        FlowComponentAdaptService r101 = (FlowComponentAdaptService) ServiceManager.get().getService(FlowComponentAdaptService.class);
        if (r101 == null) goto L6;
        r101.p(r100);
        return;
    }
}
