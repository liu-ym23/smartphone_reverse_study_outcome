package r12;

import android.content.Context;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.platform.format.jsb.FormatSendGiftResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class e extends a<f, FormatSendGiftResultModel> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public e() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r210) {
        f r100 = (f) r110;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Integer r101 = r100.c();
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L6:
        if (r102 > 0) goto L8;
        finishWithFailure();
    L8:
        CompositeDisposable r103 = new CompositeDisposable();
        ca0.d r104 = (ca0.d) com.bytedance.android.live.revenue.core.util.f.a(ca0.d.class);
        Context r105 = r210.getContext();
        Integer r106 = r100.c();
        if (r106 == null) goto L11;
        int r107 = r106.intValue();
    L12:
        long r108 = r107;
        Integer r109 = r100.b();
        if (r109 == null) goto L15;
        int r111 = r109.intValue();
    L16:
        String r112 = r100.f();
        if (r112 != null) goto L19;
        String r113 = "";
    L20:
        Integer r114 = r100.d();
        if (r114 == null) goto L23;
        int r115 = r114.intValue();
    L24:
        String r116 = r100.e();
        if (r116 != null) goto L27;
        String r117 = "";
    L28:
        Integer r118 = r100.a();
        if (r118 == null) goto L31;
        int r119 = r118.intValue();
    L32:
        String r120 = r100.g();
        if (r120 != null) goto L48;
    L40:
        LinkedHashMap r121 = null;
    L41:
        Observable<p2> r122 = r104.n(r105, r108, r111, r113, r115, "", r117, r119, "not_show", r121);
        if (r122 == null) goto L51;
        Disposable r123 = r122.subscribe(new c(this), new d(this));
        if (r123 == null) goto L52;
        RxUtilKt.c(r123, r103);
        return;
    L52:
        return;
    L51:
        return;
    L48:
        JSONObject r124 = new JSONObject(r120);     // Catch: Exception -> L47
        r121 = new LinkedHashMap();     // Catch: Exception -> L47
        Iterator<String> r125 = r124.keys();     // Catch: Exception -> L47
    L37:
        if (r125.hasNext() == false) goto L41;
        String r126 = r125.next();     // Catch: Exception -> L47
        JSONObject r127 = r124;
        r121.put(r126, r124.get(r126).toString());     // Catch: Exception -> L47
        r124 = r127;
        goto L37
    L31:
        r119 = 0;
        goto L32
    L27:
        r117 = r116;
        goto L28
    L23:
        r115 = 0;
        goto L24
    L19:
        r113 = r112;
        goto L20
    L15:
        r111 = 1;
        goto L16
    L11:
        r107 = 0;
        goto L12
    L5:
        r102 = 0;
        goto L6
    }
}
