package com.bytedance.android.livesdk.livecommerce.messagev2.handler;

import com.bytedance.android.livesdk.livecommerce.model.ECV2DelayParam;
import com.bytedance.android.livesdk.livecommerce.model.Request;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import si2.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "path", "", "params", "", "invoke", "com/bytedance/android/livesdk/livecommerce/messagev2/handler/ProductRefreshMessageHandler$refreshProductByMessage$1$1"}, k = 3, mv = {1, 4, 3})
public final class ProductRefreshMessageHandler$refreshProductByMessage$$inlined$also$lambda$1 extends Lambda implements Function2<String, Map<String, ? extends String>, Unit> {
    final /* synthetic */ Function2 $callback$inlined;
    final /* synthetic */ e0 $message$inlined;
    final /* synthetic */ Request $request;
    final /* synthetic */ RoomContextController $roomContextController$inlined;
    final /* synthetic */ int $sceneType;
    final /* synthetic */ ProductRefreshMessageHandler this$0;

    public ProductRefreshMessageHandler$refreshProductByMessage$$inlined$also$lambda$1(Request r1, int r2, ProductRefreshMessageHandler r3, e0 r4, Function2 r5, RoomContextController r6) {
        this.$request = r1;
        this.$sceneType = r2;
        this.this$0 = r3;
        this.$message$inlined = r4;
        this.$callback$inlined = r5;
        this.$roomContextController$inlined = r6;
        super(2);
    }

    public final void invoke(final String r13, final Map<String, String> r14) {
        Intrinsics.checkNotNullParameter(r13, "path");
        Intrinsics.checkNotNullParameter(r14, "params");
        ECV2DelayParam r0 = this.$request.delayParam;
        long r1 = 0;
        if (r0 != null) goto L5;
    L8:
        if (r0 == null) goto L10;
        long r3 = r0.minDelayMs;
    L11:
        if (r0 == null) goto L13;
        r1 = r0.maxDelayMs;
    L13:
        long r9 = r1;
        long r7 = r3;
    L14:
        this.this$0.a.d(String.valueOf(this.$message$inlined.promotionId), r7, r9, new AnonymousClass1(this, r13, r14));
        return;
    L10:
        r3 = 0;
        goto L11
    L5:
        if (r0.delayStrategy != 0) goto L8;
        r7 = 0;
        r9 = 0;
        goto L14
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, (Map) r2);
        return Unit.INSTANCE;
    }
}
