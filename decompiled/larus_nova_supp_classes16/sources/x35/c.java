package x35;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.statistics.ReportEventData;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements tb5.h<ReportEventData> {
    public final com.bytedance.ee.bear.contract.d a;

    public static final class a {
    }

    static {
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
    }

    public c(com.bytedance.ee.bear.contract.d r2) {
        Intrinsics.checkNotNullParameter(r2, "analyticService");
        this.a = r2;
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r6, m r7) {
        ReportEventData r8 = (ReportEventData) r6;
        if (r8 == null) goto L5;
        String r0 = r8.event_name;
    L7:
        if (TextUtils.isEmpty(r0) == false) goto L9;
        tt5.a.d("ReportEventHandler", "empty event name!");
        return;
    L9:
        if (r8 != null) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r8.event_name) == true) goto L16;
        if (StringsKt.startsWith$default(r8.event_name, "dev_performance_feed_open", false, 2, null) == false) goto L16;
        ((com.bytedance.ee.bear.middleground.feed.export.bean.h) org.koin.java.a.c(com.bytedance.ee.bear.middleground.feed.export.bean.h.class, null, null, 6)).d(r8.data);
        tt5.a.b("ReportEventHandler", r8.toString());
    L16:
        if (r8.noPrefix == false) goto L18;
        this.a.n(r8.event_name, r8.data);
    L19:
        tt5.a.b("ReportEventHandler", r8.toString());
        return;
    L18:
        this.a.v(r8.event_name, r8.data);
        goto L19
    L5:
        r0 = null;
        goto L7
    }
}
