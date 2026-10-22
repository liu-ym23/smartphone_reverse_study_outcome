package com.ss.android.ugc.tools.view.widget.textimageview;

import android.widget.ImageView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/ImageView;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 1})
final class EffectResourceStickerView$downloadImgCenterOpt$2 extends Lambda implements Function0<ImageView> {
    final /* synthetic */ EffectResourceStickerView this$0;

    public EffectResourceStickerView$downloadImgCenterOpt$2(EffectResourceStickerView r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ImageView invoke() {
        ImageView r100 = (ImageView) this.this$0.findViewById(R.id.iv_loading_center);
        if (r100 == null) goto L5;
        r100.setImageResource(0);
        return r100;
    L5:
        return null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ImageView invoke() {
        return invoke();
    }
}
