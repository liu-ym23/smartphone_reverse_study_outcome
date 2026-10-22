package x20;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes45.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock f562173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a.b f562174b;

    public d(CompletionBlock r100, a.b r101) {
        this.f562173a = r100;
        this.f562174b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        CompletionBlock r101 = this.f562173a;
        XBaseModel r102 = ne7.e.b(a.c.class);
        a.c r103 = (a.c) r102;
        r103.setServiceID(this.f562174b.getServiceID());
        r103.setStatusMsg(((Throwable) r100).getMessage());
        Unit r104 = Unit.INSTANCE;
        r101.onFailure(1, "sendRequestForResponse error", (XBaseResultModel) r102);
    }
}
