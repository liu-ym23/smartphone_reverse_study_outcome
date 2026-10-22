package x35;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.statistics.ReportEventData;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements tb5.h<ReportEventData> {
    public final com.bytedance.ee.bear.contract.d a;

    /* JADX INFO: renamed from: x35.a$a, reason: collision with other inner class name */
    public static final class C0322a {
    }

    static {
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
    }

    public a(com.bytedance.ee.bear.contract.d r2) {
        Intrinsics.checkNotNullParameter(r2, "analyticService");
        this.a = r2;
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r4, m r5) {
        ReportEventData r6 = (ReportEventData) r4;
        if (r6 == null) goto L5;
        String r7 = r6.event_name;
    L7:
        if (TextUtils.isEmpty(r7) == false) goto L9;
        tt5.a.d("ReportEventHandler", "empty event name!");
        return;
    L9:
        if (r6 != null) goto L11;
        return;
    L11:
        if (r6.noPrefix == false) goto L13;
        this.a.n(r6.event_name, r6.data);
    L14:
        tt5.a.b("ReportEventHandler", r6.toString());
        return;
    L13:
        this.a.v(r6.event_name, r6.data);
        goto L14
    L5:
        r7 = null;
        goto L7
    }
}
