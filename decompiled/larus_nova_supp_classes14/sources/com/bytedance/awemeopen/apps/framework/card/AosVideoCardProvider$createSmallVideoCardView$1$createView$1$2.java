package com.bytedance.awemeopen.apps.framework.card;

import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/bytedance/awemeopen/infra/base/image/AoImageView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AosVideoCardProvider$createSmallVideoCardView$1$createView$1$2 extends Lambda implements Function1<AoImageView, Unit> {
    public static final AosVideoCardProvider$createSmallVideoCardView$1$createView$1$2 INSTANCE = null;

    static {
        INSTANCE = new AosVideoCardProvider$createSmallVideoCardView$1$createView$1$2();
    }

    public AosVideoCardProvider$createSmallVideoCardView$1$createView$1$2() {
        super(1);
    }

    public final void invoke(AoImageView r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$add");
        r3.setId(2131363059);
        r3.setBackground(ContextCompat.getDrawable(r3.getContext(), 2131231394));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((AoImageView) r1);
        return Unit.INSTANCE;
    }
}
