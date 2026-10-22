package com.bytedance.livesdk.preview.layer;

import com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.livesdk.preview.layer.delegate.Preview1stDelegate;
import com.bytedance.livesdk.preview.layer.delegate.Preview2ndDelegate;
import com.bytedance.livesdk.preview.layer.delegate.Preview3rdDelegate;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import i70.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\b\u001a&\u0012\u0004\u0012\u00020\u0001\u0012\u001c\u0012\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0006\b\u0001\u0012\u00020\u00050\u00030\u00020\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/bytedance/android/live/core/tetris/layer/initialization/LayerIndex;", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/layer/core/delegate/LayerDelegate;", "Li70/a;", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class PreviewLayerDelegateConfig$delegateMap$2 extends Lambda implements Function0<Map<LayerIndex, ? extends Class<? extends LayerDelegate<? extends a, Object>>>> {
    public static final PreviewLayerDelegateConfig$delegateMap$2 INSTANCE = null;

    static {
        INSTANCE = new PreviewLayerDelegateConfig$delegateMap$2();
    }

    public PreviewLayerDelegateConfig$delegateMap$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<LayerIndex, ? extends Class<? extends LayerDelegate<? extends a, Object>>> invoke2() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(LayerIndex.INDEX_1, Preview1stDelegate.class), TuplesKt.to(LayerIndex.INDEX_2, Preview2ndDelegate.class), TuplesKt.to(LayerIndex.INDEX_3, Preview3rdDelegate.class)});
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<LayerIndex, ? extends Class<? extends LayerDelegate<? extends a, Object>>> invoke() {
        return invoke2();
    }
}
