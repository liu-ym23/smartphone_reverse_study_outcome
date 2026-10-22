package com.ss.android.lark.integrator.im.impl.preview;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.larus.feishu.office.im.impl.docpreview.MessageDocPreviewServiceImpl$getPreviewEntities$1;
import com.larus.home.impl.sdk.office.FlowOfficeUrlPreviewHostService;
import com.ss.android.lark.chat.preview.service.impl.UrlPreviewService;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalScope;
import com.ss.android.lark.utils.statistics.PerfLog;
import dagger.Lazy;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@OfficeSDKGlobalScope
public final class b implements sza.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy<UrlPreviewService> f428007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy<com.ss.android.lark.chat.preview.service.d> f428008b;

    @Inject
    public b(Lazy<UrlPreviewService> r100, Lazy<com.ss.android.lark.chat.preview.service.d> r101) {
        Intrinsics.checkNotNullParameter(r100, "lazyUrlPreviewService");
        Intrinsics.checkNotNullParameter(r101, "lazyUrlPreviewPush");
        this.f428007a = r100;
        this.f428008b = r101;
    }

    @Override // sza.c
    public final void a(List r100, SyncDataStrategy r101, MessageDocPreviewServiceImpl$getPreviewEntities$1 r102) {
        Intrinsics.checkNotNullParameter(r100, "previewIds");
        Intrinsics.checkNotNullParameter(r101, "syncDataStrategy");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f428007a.get().getClass();
        UrlPreviewService.c(r100, r101, r102);
    }

    @Override // sza.c
    public final OfficeUrlPreviewPageServiceImpl b(Context r100, LifecycleOwner r110, kc9.a r111, FlowOfficeUrlPreviewHostService.b r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r111, "renderConfigProvider");
        return new OfficeUrlPreviewPageServiceImpl(r110, new OfficeUrlPreviewSessionImpl(this.f428007a.get(), this.f428008b.get(), r111, r112, r110, r100));
    }
}
