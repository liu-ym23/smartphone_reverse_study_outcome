package x35;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.statistics.ReportEventData;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements tb5.h<ReportEventData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f562350a;

    public static final class a {
    }

    static {
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
    }

    public c(com.bytedance.ee.bear.contract.d r100) {
        Intrinsics.checkNotNullParameter(r100, "analyticService");
        this.f562350a = r100;
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r100, m r101) {
        ReportEventData r102 = (ReportEventData) r100;
        if (r102 == null) goto L5;
        String r103 = r102.event_name;
    L7:
        if (TextUtils.isEmpty(r103) == false) goto L9;
        tt5.a.d("ReportEventHandler", "empty event name!");
        return;
    L9:
        if (r102 != null) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r102.event_name) == true) goto L16;
        if (StringsKt.startsWith$default(r102.event_name, "dev_performance_feed_open", false, 2, null) == false) goto L16;
        ((com.bytedance.ee.bear.middleground.feed.export.bean.h) org.koin.java.a.c(com.bytedance.ee.bear.middleground.feed.export.bean.h.class, null, null, 6)).d(r102.data);
        tt5.a.b("ReportEventHandler", r102.toString());
    L16:
        if (r102.noPrefix == false) goto L18;
        this.f562350a.n(r102.event_name, r102.data);
    L19:
        tt5.a.b("ReportEventHandler", r102.toString());
        return;
    L18:
        this.f562350a.v(r102.event_name, r102.data);
        goto L19
    L5:
        r103 = null;
        goto L7
    }
}
