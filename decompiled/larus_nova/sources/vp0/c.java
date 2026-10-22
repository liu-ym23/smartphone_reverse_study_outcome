package vp0;

import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.n;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes46.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f556548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f556549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f556550c;

    public c(boolean r100, Function0 r101, Function0 r102) {
        this.f556548a = r100;
        this.f556549b = r101;
        this.f556550c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        n r101 = (n) ((e) r100).data;
        int r102 = qo0.a.f534145a;
        qo0.a.c("AnchorPrivateMsgContextService", "request /webcast/microapp/private_msg_tab/update/ success, data = " + r101);
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r103 = AnchorMiniAppDataContext.a.a();
        lo0.b r104 = null;
        if (r103 == null) goto L7;
        com.bytedance.live.datacontext.n<lo0.b> r105 = r103.getPrivateMsgTabInfo();
        if (r105 == null) goto L7;
        lo0.b r106 = r105.getValue();
    L9:
        if (r101.a() != 0) goto L18;
        AnchorMiniAppDataContext r107 = AnchorMiniAppDataContext.a.a();
        if (r107 == null) goto L17;
        com.bytedance.live.datacontext.n<lo0.b> r108 = r107.getPrivateMsgTabInfo();
        if (r108 == null) goto L17;
        if (r106 == null) goto L16;
        r104 = new lo0.b(r106.f510083a, this.f556548a, r106.f510085c, r106.f510086d);
    L16:
        r108.setValue(r104);
    L17:
        this.f556549b.invoke();
        return;
    L18:
        this.f556550c.invoke();
        return;
    L7:
        r106 = null;
        goto L9
    }
}
