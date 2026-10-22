package ee7;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<a.c> f472302a;

    public d(CompletionBlock<a.c> r100) {
        this.f472302a = r100;
    }

    public final void a(com.bytedance.sdk.xbridge.cn.runtime.depend.c r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        CompletionBlock<a.c> r101 = this.f472302a;
        XBaseModel r102 = ne7.e.c(Reflection.getOrCreateKotlinClass(a.c.class));
        a.c r103 = (a.c) r102;
        r103.setNeedUpdate(Boolean.valueOf(r100.f270136a));
        Long r104 = r100.f270137b;
        if (r104 == null) goto L5;
        r103.setTotalSize(Long.valueOf(r104.longValue()));
    L5:
        String r105 = r100.f270138c;
        if (r105 == null) goto L8;
        r103.setVersion(r105);
    L8:
        CompletionBlock.DefaultImpls.onSuccess$default(r101, (XBaseResultModel) r102, null, 2, null);
    }
}
