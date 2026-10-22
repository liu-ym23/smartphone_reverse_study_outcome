package s30;

import com.bytedance.android.live.schema.api.WebcastRedirectReportInfo;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class d<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f540438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebcastRedirectReportInfo f540439b;

    public d(b r100, WebcastRedirectReportInfo r101) {
        this.f540438a = r100;
        this.f540439b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<com.bytedance.android.live.browser.schema.core.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        Object r101 = ((IMiddleWareHostContext) k.n(IMiddleWareHostContext.class)).getUgSettingsByKey(0, "data.common_info.extra.sjb_schema");
        if ((r101 instanceof JSONObject) == true) goto L5;
        r101 = null;
    L5:
        JSONObject r102 = (JSONObject) r101;
        if (r102 == null) goto L12;
        com.bytedance.android.live.browser.schema.core.d r103 = new com.bytedance.android.live.browser.schema.core.d(r102, null);
        if (r103.a() <= 0) goto L10;
        long r104 = r103.a();
    L11:
        this.f540439b.a("ugsettings_source", "1");
        com.bytedance.android.live.schema.api.utils.a.a("UGSettingsInterceptor", "hit by sync");
        int r105 = com.bytedance.android.live.browser.schema.core.c.f64200d;
        com.bytedance.android.live.browser.schema.core.c r106 = com.bytedance.android.live.browser.schema.core.c.b.a(r103, this.f540438a.f540425c, r104, TimeUnit.SECONDS);
        this.f540438a.f540423a = r106;
        Unit r107 = Unit.INSTANCE;
        r100.onNext(r106);
        goto L12
    L10:
        r104 = 180;
    L12:
        r100.onComplete();
    }
}
