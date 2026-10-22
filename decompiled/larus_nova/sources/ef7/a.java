package ef7;

import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<df7.a.c> f472522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f472523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ue7.d f472524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ df7.a.b f472525d;

    public final void b() {
        CompletionBlock<df7.a.c> r100 = this.f472522a;
        XBaseModel r101 = ne7.e.c(Reflection.getOrCreateKotlinClass(df7.a.c.class));
        ((df7.a.c) r101).setCode(1);
        CompletionBlock.DefaultImpls.onSuccess$default(r100, (XBaseResultModel) r101, null, 2, null);
        b r102 = this.f472523b;
        ue7.d r103 = this.f472524c;
        String r104 = this.f472525d.getSocketTaskID();
        r102.getClass();
        HashMap r105 = new HashMap();
        r105.put("status", PTYSocketStateCallback.CLOSED);
        if (r104 == null) goto L5;
        r105.put("socketTaskID", r104);
    L5:
        if (r103 == null) goto L8;
        r103.a("x.socketStatusChanged", r105);
        return;
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        CompletionBlock.DefaultImpls.onFailure$default(this.f472522a, 0, r100, null, 4, null);
    }

    public a(CompletionBlock<df7.a.c> r100, b r101, ue7.d r102, df7.a.b r103) {
        this.f472522a = r100;
        this.f472523b = r101;
        this.f472524c = r102;
        this.f472525d = r103;
    }
}
