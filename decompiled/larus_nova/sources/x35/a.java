package x35;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.statistics.ReportEventData;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements tb5.h<ReportEventData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f562349a;

    /* JADX INFO: renamed from: x35.a$a, reason: collision with other inner class name */
    public static final class C8190a {
    }

    static {
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
    }

    public a(com.bytedance.ee.bear.contract.d r100) {
        Intrinsics.checkNotNullParameter(r100, "analyticService");
        this.f562349a = r100;
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
        if (r102.noPrefix == false) goto L13;
        this.f562349a.n(r102.event_name, r102.data);
    L14:
        tt5.a.b("ReportEventHandler", r102.toString());
        return;
    L13:
        this.f562349a.v(r102.event_name, r102.data);
        goto L14
    L5:
        r103 = null;
        goto L7
    }
}
