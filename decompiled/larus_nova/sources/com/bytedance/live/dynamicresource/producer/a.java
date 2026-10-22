package com.bytedance.live.dynamicresource.producer;

import com.bytedance.live.dynamicresource.client.ResourceClientContext;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes19.dex */
public interface a<EntranceModel, LayoutConfig, RouterKey> {
    void a(RouterKey r100, ResourceClientContext<EntranceModel, LayoutConfig, RouterKey> r101, LayoutConfig r102);

    Disposable b(RouterKey r100, ResourceClientContext<EntranceModel, LayoutConfig, RouterKey> r101, Function1<? super LayoutConfig, Unit> r102, Function1<? super Throwable, Unit> r103);

    LayoutConfig c(RouterKey r100, ResourceClientContext<EntranceModel, LayoutConfig, RouterKey> r101);
}
