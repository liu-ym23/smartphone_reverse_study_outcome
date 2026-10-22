package gj2;

import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import jf.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import w83.c;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f481500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<g> f481501b;

    public a(il.a r100, d r101, Function0<g> r102, ILivePromotionCardContainerHandler r103) {
        Intrinsics.checkNotNullParameter(r100, "ecEventHistoryMap");
        Intrinsics.checkNotNullParameter(r101, "jumpDispatcher");
        Intrinsics.checkNotNullParameter(r102, "getPromotionParams");
        Intrinsics.checkNotNullParameter(r103, "containerHandler");
        this.f481500a = r101;
        this.f481501b = r102;
    }
}
