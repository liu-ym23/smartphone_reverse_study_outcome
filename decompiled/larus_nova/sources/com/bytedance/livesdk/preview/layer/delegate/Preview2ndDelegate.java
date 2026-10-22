package com.bytedance.livesdk.preview.layer.delegate;

import com.bytedance.android.live.core.tetris.layer.core.delegate.ViewLayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/livesdk/preview/layer/delegate/Preview2ndDelegate;", "Lcom/bytedance/android/live/core/tetris/layer/core/delegate/ViewLayerDelegate;", "", "<init>", "()V", "livepreview-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Preview2ndDelegate extends ViewLayerDelegate<Object> {
    @Override // com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate
    public final void j(Element<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate
    public final void k(Element<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.delegate.ViewLayerDelegate
    public final void t() {
    }

    public Preview2ndDelegate() {
    }
}
