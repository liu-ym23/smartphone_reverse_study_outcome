package zd7;

import android.app.Activity;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PermissionState;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class n implements OnPermissionCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f571402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IBDXBridgeContext f571403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f571404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ yd7.e.b f571405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<yd7.e.c> f571406e;

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback
    public final void onResult(boolean r110, Map<String, ? extends PermissionState> r111) {
        Intrinsics.checkNotNullParameter(r111, "result");
        if (r110 == false) goto L5;
        this.f571402a.a(this.f571403b, this.f571404c, this.f571405d, this.f571406e);
        return;
    L5:
        CompletionBlock.DefaultImpls.onFailure$default(this.f571406e, 0, "request permission denied", null, 4, null);
    }

    public n(m r100, IBDXBridgeContext r101, Activity r102, yd7.e.b r103, CompletionBlock<yd7.e.c> r104) {
        this.f571402a = r100;
        this.f571403b = r101;
        this.f571404c = r102;
        this.f571405d = r103;
        this.f571406e = r104;
    }
}
