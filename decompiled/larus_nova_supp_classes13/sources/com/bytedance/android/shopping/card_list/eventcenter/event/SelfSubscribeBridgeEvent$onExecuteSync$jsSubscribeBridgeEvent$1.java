package com.bytedance.android.shopping.card_list.eventcenter.event;

import com.bytedance.android.shopping.card_list.monitor.error.CardListRunCatchExtKt;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SelfSubscribeBridgeEvent$onExecuteSync$jsSubscribeBridgeEvent$1 implements ti.j {
    public final /* synthetic */ SelfSubscribeBridgeEvent a;
    public final /* synthetic */ String b;
    public final /* synthetic */ com.bytedance.kmp.ec.yata.event.common.e c;
    public final /* synthetic */ String d;

    public final void a(final JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        final AndroidYaTaInstance r0 = (AndroidYaTaInstance) this.a.c.e.c.invoke();
        CardListRunCatchExtKt.a(this.a.a, String.valueOf(this.b), new SelfSubscribeBridgeEvent$onExecuteSync$jsSubscribeBridgeEvent$1$onReceiveJsEvent$$inlined$let$lambda$1(r0, this, r5));
    }

    public SelfSubscribeBridgeEvent$onExecuteSync$jsSubscribeBridgeEvent$1(SelfSubscribeBridgeEvent r1, String r2, com.bytedance.kmp.ec.yata.event.core.a r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
