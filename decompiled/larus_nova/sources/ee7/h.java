package ee7;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
public final class h implements com.bytedance.sdk.xbridge.cn.runtime.depend.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<c.InterfaceC5774c> f472306a;

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.h
    public final void a() {
        CompletionBlock<c.InterfaceC5774c> r100 = this.f472306a;
        XBaseModel r101 = ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC5774c.class));
        ((c.InterfaceC5774c) r101).setStatusCode(0);
        r100.onSuccess((XBaseResultModel) r101, "skipUpdate for local version is already up-to-date");
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.h
    public final void b() {
        CompletionBlock<c.InterfaceC5774c> r100 = this.f472306a;
        XBaseModel r101 = ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC5774c.class));
        ((c.InterfaceC5774c) r101).setStatusCode(2);
        r100.onSuccess((XBaseResultModel) r101, "abortUpdate for requested channel is not in lazy channels or doesn't exist with host accesskey");
    }

    public h(CompletionBlock<c.InterfaceC5774c> r100) {
        this.f472306a = r100;
    }
}
