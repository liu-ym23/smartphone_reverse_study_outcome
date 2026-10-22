package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.platform.comapi.map.MapController;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rob.g;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/ItemDivider;", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/BaseActionItemViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "onBind", "", MapController.ITEM_LAYER_TAG, "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/MoreActionItem;", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemDivider extends BaseActionItemViewHolder {
    public ItemDivider(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.BaseActionItemViewHolder
    public final void T3(View r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        View r102 = r100.findViewById(R.id.line_divider);
        Intrinsics.checkNotNull(r102);
        r102.setVisibility(0);
        AppCompatTextView r103 = (AppCompatTextView) r100.findViewById(R.id.tv_language);
        Intrinsics.checkNotNull(r103);
        r103.setVisibility(8);
        AppCompatImageView r104 = (AppCompatImageView) r100.findViewById(R.id.iv_chosen);
        Intrinsics.checkNotNull(r104);
        r104.setVisibility(8);
        ViewGroup.LayoutParams r105 = r100.getLayoutParams();
        r105.height = UIUtils.dp2px(r100.getContext(), 16.0f);
    }
}
