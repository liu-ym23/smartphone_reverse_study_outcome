package hu4;

import com.bytedance.ee.bear.bitable.preload.bean.BitableOfflineResultModel;
import com.bytedance.ee.bear.bitable.preload.util.BitablePreloadBridgeUtil;
import io.reactivex.functions.Consumer;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f487250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f487251b;

    public g(m r100, i r101) {
        this.f487250a = r100;
        this.f487251b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        if (r101.booleanValue() == false) goto L5;
        m r102 = this.f487250a;
        int r103 = BitablePreloadBridgeUtil.f215016a;
        tt5.a.b("BitablePreloadBridgeUtil", "onJsSuccessCallback()...");
        BitablePreloadBridgeUtil.a(new BitableOfflineResultModel(true, "", ""), r102);
    L6:
        tt5.a.h(this.f487251b.f487255b, "save result: " + r101);
        return;
    L5:
        BitablePreloadBridgeUtil.b("save failed", "", this.f487250a);
        goto L6
    }
}
