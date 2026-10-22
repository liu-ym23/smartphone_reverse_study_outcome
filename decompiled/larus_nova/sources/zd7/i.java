package zd7;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IChooseMediaResultCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
public final class i implements IChooseMediaResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<yd7.c.f> f571375a;

    public i(CompletionBlock<yd7.c.f> r100) {
        this.f571375a = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IChooseMediaResultCallback
    public final void onFailure(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        CompletionBlock.DefaultImpls.onFailure$default(this.f571375a, r100, r101, null, 4, null);
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IChooseMediaResultCallback
    public final void onSuccess(re7.d r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r101, "msg");
        ArrayList r102 = new ArrayList();
        List<re7.d.a> r103 = r100.f537444a;
        if (r103 == null) goto L8;
        Iterator<T> r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        re7.d.a r105 = (re7.d.a) r104.next();
        XBaseModel r106 = ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.c.InterfaceC8330c.class));
        yd7.c.InterfaceC8330c r107 = (yd7.c.InterfaceC8330c) r106;
        r107.setPath(r105.f537445a);
        r107.setTempFilePath(r105.f537445a);
        r107.setSize(Long.valueOf(r105.f537446b));
        r107.setMediaType(r105.f537447c);
        r107.setBase64Data(r105.f537448d);
        r107.setMimeType("image/jpeg");
        r102.add(r106);
    L8:
        CompletionBlock<yd7.c.f> r108 = this.f571375a;
        XBaseModel r109 = ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.c.f.class));
        ((yd7.c.f) r109).setTempFiles(r102);
        CompletionBlock.DefaultImpls.onSuccess$default(r108, (XBaseResultModel) r109, null, 2, null);
    }
}
