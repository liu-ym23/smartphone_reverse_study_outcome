package com.bytedance.android.livesdk.livecommerce.event;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "Lcom/bytedance/android/livesdk/livecommerce/event/ECEventV3;", "enterFromMerge", "", "enterFrom", "invoke", "com/bytedance/android/livesdk/livecommerce/event/ECShowProductEvent$appendSourcePageIfAbsent$1$1"}, k = 3, mv = {1, 4, 3})
final class ECShowProductEvent$appendSourcePageIfAbsent$$inlined$let$lambda$1 extends Lambda implements Function2<String, String, ECEventV3> {
    final /* synthetic */ z1 this$0;

    public ECShowProductEvent$appendSourcePageIfAbsent$$inlined$let$lambda$1(z1 r1) {
        this.this$0 = r1;
        super(2);
    }

    public final ECEventV3 invoke(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r4, "enterFrom");
        z1 r0 = this.this$0;
        r0.c.c("source_page", r3 + "_temai_" + r4);
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((String) r1, (String) r2);
    }
}
