package com.bytedance.livesdk.preview;

import android.widget.FrameLayout;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.live.core.tetris.layer.core.element.ElementBuilderMap;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "rootView", "Landroid/widget/FrameLayout;", "layerToId", "", "Lcom/bytedance/android/live/core/tetris/layer/initialization/LayerIndex;", "", "descriptorList", "Lcom/bytedance/android/live/core/tetris/layer/core/descriptor/LayerDescriptorList;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class AbsPreviewDelegateViewHolder$initialize$3 extends Lambda implements Function3<FrameLayout, Map<LayerIndex, Integer>, LayerDescriptorList, Unit> {
    final /* synthetic */ a this$0;

    public AbsPreviewDelegateViewHolder$initialize$3(a r100) {
        this.this$0 = r100;
        super(3);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FrameLayout r100, Map<LayerIndex, Integer> r101, LayerDescriptorList r102) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r102, "descriptorList");
        this.this$0.getClass();
        new ElementBuilderMap();
        new n70.b();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(FrameLayout r100, Map<LayerIndex, Integer> r101, LayerDescriptorList r102) {
        invoke2(r100, r101, r102);
        return Unit.INSTANCE;
    }
}
