package com.bytedance.android.livesdk.livecommerce.userinfo.title.persenter;

import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Landroid/graphics/PointF;", "width", "", "height", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECUserInfoNicknamePresenter$updateNickColor$1 extends Lambda implements Function2<Integer, Integer, Pair<? extends PointF, ? extends PointF>> {
    public static final ECUserInfoNicknamePresenter$updateNickColor$1 INSTANCE = null;

    static {
        INSTANCE = new ECUserInfoNicknamePresenter$updateNickColor$1();
    }

    public ECUserInfoNicknamePresenter$updateNickColor$1() {
        super(2);
    }

    public final Pair<PointF, PointF> invoke(int r7, int r8) {
        float r0 = r7;
        float r1 = 0.8947f * r0;
        return TuplesKt.to(new PointF(r1, (float) ((Math.tan(Math.toRadians(32.2d)) * ((double) r7)) - ((double) r1))), new PointF(r0, r8));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), ((Number) r2).intValue());
    }
}
