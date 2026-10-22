package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.platform.comapi.map.MapController;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rob.g;
import rob.i;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/SendResultActionItemViewHolder;", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/BaseActionItemViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "onBind", "", MapController.ITEM_LAYER_TAG, "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/MoreActionItem;", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendResultActionItemViewHolder extends BaseActionItemViewHolder {
    public SendResultActionItemViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.BaseActionItemViewHolder
    public final void T3(View r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        Object r102 = r101.a();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.SendTypeData");
        i r103 = (i) r102;
        AppCompatTextView r104 = (AppCompatTextView) r100.findViewById(R.id.tv_language);
        r104.setTextColor(UIUtils.getColor(r104.getContext(), R.color.text_title));
        r104.setTextSize(16.0f);
        r104.setText(r103.f538815b);
        View r105 = r100.findViewById(R.id.iv_chosen);
        if (r103.f538816c == false) goto L5;
        int r106 = 0;
    L6:
        r105.setVisibility(r106);
        return;
    L5:
        r106 = 8;
        goto L6
    }
}
