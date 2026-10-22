package com.bytedance.android.livesdk.livecommerce.iron.ui;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "content", "", "invoke", "com/bytedance/android/livesdk/livecommerce/iron/ui/ECPromotionListHintBannerView$registerMissionCallback$1$1"}, k = 3, mv = {1, 4, 3})
final class ECPromotionListHintBannerView$registerMissionCallback$$inlined$let$lambda$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ String $originText$inlined;
    final /* synthetic */ int $replaceIndex$inlined;
    final /* synthetic */ ECPromotionListHintBannerView this$0;

    public ECPromotionListHintBannerView$registerMissionCallback$$inlined$let$lambda$1(ECPromotionListHintBannerView r1, int r2, String r3) {
        this.this$0 = r1;
        this.$replaceIndex$inlined = r2;
        this.$originText$inlined = r3;
        super(1);
    }

    public final void invoke(String r4) {
        Intrinsics.checkNotNullParameter(r4, "content");
        ECPromotionList.p r0 = this.this$0.b;     // Catch: Exception -> L13
        if (r0 == null) goto L18;
        List<com.bytedance.android.ec.model.live.b> r1 = r0.leftContent;     // Catch: Exception -> L13
        if (r1 == null) goto L19;
        int r2 = this.$replaceIndex$inlined;     // Catch: Exception -> L13
        if (r2 > (-1)) goto L10;
        return;
    L10:
        if (r2 >= r1.size()) goto L21;
        ((com.bytedance.android.ec.model.live.b) ListProtector.get(r1, this.$replaceIndex$inlined)).v(r4);     // Catch: Exception -> L13
        this.this$0.f.b(r1, true);     // Catch: Exception -> L13
        return;
    L21:
        return;
    L19:
        return;
    L18:
        return;
    L13:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
