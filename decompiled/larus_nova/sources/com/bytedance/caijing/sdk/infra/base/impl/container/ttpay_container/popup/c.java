package com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.popup;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.view.TTPayTitleBar;
import com.bytedance.ies.bullet.ui.common.m;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m16.b f202545a;

    @Override // com.bytedance.ies.bullet.ui.common.m
    public final void a(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "defaultTitle");
    }

    @Override // com.bytedance.ies.bullet.ui.common.m
    public final void b(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "click");
    }

    @Override // com.bytedance.ies.bullet.ui.common.m
    public final void d() {
    }

    @Override // com.bytedance.ies.bullet.ui.common.m
    public final void setBackListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "click");
    }

    public c(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        this.f202545a = r100;
    }

    @Override // com.bytedance.ies.bullet.ui.common.m
    public final View c(Context r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        TTPayTitleBar r102 = new TTPayTitleBar(r100);
        r102.b(new TTPayTitleBar.a(true, r101, this.f202545a));
        return r102;
    }
}
