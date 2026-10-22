package vp0;

import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.f;
import com.bytedance.live.datacontext.n;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes46.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f556545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f556546b;

    public a(Function1 r100, Function0 r101) {
        this.f556545a = r100;
        this.f556546b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        f r101 = (f) ((e) r100).data;
        int r102 = qo0.a.f534145a;
        qo0.a.c("AnchorPrivateMsgContextService", "request /webcast/microapp/private_msg_tab/get/ success, data = " + r101);
        if (r101.b() != 0) goto L12;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r103 = AnchorMiniAppDataContext.a.a();
        if (r103 == null) goto L9;
        n<lo0.b> r104 = r103.getPrivateMsgTabInfo();
        if (r104 == null) goto L9;
        r104.setValue(new lo0.b(r101.d(), r101.e(), r101.c(), r101.a()));
    L9:
        Function1 r105 = this.f556545a;
        if (r105 == null) goto L16;
        Unit r106 = (Unit) r105.invoke(r101);
        return;
    L16:
        return;
    L12:
        Function0 r107 = this.f556546b;
        if (r107 == null) goto L18;
        Unit r108 = (Unit) r107.invoke();
        return;
    }
}
