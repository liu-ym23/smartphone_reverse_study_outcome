package x20;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes45.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock f562171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a.b f562172b;

    public c(CompletionBlock r100, a.b r101) {
        this.f562171a = r100;
        this.f562172b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.ss.ugc.live.sdk.msg.network.g r101 = (com.ss.ugc.live.sdk.msg.network.g) r100;
        CompletionBlock r102 = this.f562171a;
        XBaseModel r103 = ne7.e.c(Reflection.getOrCreateKotlinClass(a.c.class));
        a.c r104 = (a.c) r103;
        r104.setServiceID(this.f562172b.getServiceID());
        r104.setPayload(new String(r101.f458314d, Charsets.UTF_8));
        r104.setStatusCode(Integer.valueOf(r101.f458311a));
        r104.setStatusMsg(r101.f458312b);
        Unit r105 = Unit.INSTANCE;
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) r103, null, 2, null);
    }
}
