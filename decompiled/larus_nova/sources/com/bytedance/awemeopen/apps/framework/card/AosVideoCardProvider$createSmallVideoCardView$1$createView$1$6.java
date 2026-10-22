package com.bytedance.awemeopen.apps.framework.card;

import android.widget.ImageView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/widget/ImageView;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AosVideoCardProvider$createSmallVideoCardView$1$createView$1$6 extends Lambda implements Function1<ImageView, Unit> {
    public static final AosVideoCardProvider$createSmallVideoCardView$1$createView$1$6 INSTANCE = null;

    static {
        INSTANCE = new AosVideoCardProvider$createSmallVideoCardView$1$createView$1$6();
    }

    public AosVideoCardProvider$createSmallVideoCardView$1$createView$1$6() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$add");
        r100.setId(R.id.aos_card_video_play_icon);
        r100.setImageResource(R.drawable.aos_middle_video_card_play_icon);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ImageView r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
