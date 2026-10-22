package com.bytedance.awemeopen.apps.framework.card;

import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/bytedance/awemeopen/infra/base/image/AoImageView;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AosVideoCardProvider$createSmallVideoCardView$1$createView$1$2 extends Lambda implements Function1<AoImageView, Unit> {
    public static final AosVideoCardProvider$createSmallVideoCardView$1$createView$1$2 INSTANCE = null;

    static {
        INSTANCE = new AosVideoCardProvider$createSmallVideoCardView$1$createView$1$2();
    }

    public AosVideoCardProvider$createSmallVideoCardView$1$createView$1$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AoImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$add");
        r100.setId(R.id.aos_card_small_video_cover_border);
        r100.setBackground(ContextCompat.getDrawable(r100.getContext(), R.drawable.aos_card_shape_border_light));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AoImageView r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
