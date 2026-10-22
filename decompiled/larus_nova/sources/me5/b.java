package me5;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.network.ResponseJsonResult;
import com.bytedance.ies.xbridge.utils.j;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f513480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j66.a.InterfaceC6395a f513481b;

    public b(a r100, j66.a.b r101) {
        this.f513480a = r100;
        this.f513481b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ResponseJsonResult r101 = (ResponseJsonResult) r100;
        a r102 = this.f513480a;
        Intrinsics.checkNotNull(r101);
        j66.a.InterfaceC6395a r103 = this.f513481b;
        r102.getClass();
        String r104 = r101.msg;
        tt5.a.h("ccm-lynx: CCMNetRequestMethod", "callbackRequestSuccess msg: " + r104);
        k66.b r105 = new k66.b();
        r105.f501966a = 200;
        int r106 = j.f249563a;
        r105.f501967b = j.b(r101.getResponseJson());
        Intrinsics.checkNotNull(r104);
        r103.a(r105, r104);
    }
}
