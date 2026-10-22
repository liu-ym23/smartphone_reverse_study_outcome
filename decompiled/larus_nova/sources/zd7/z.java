package zd7;

import android.app.Activity;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PermissionState;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class z implements OnPermissionCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f571472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IBDXBridgeContext f571473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f571474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ yd7.i.c f571475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<yd7.i.d> f571476e;

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback
    public final void onResult(boolean r110, Map<String, ? extends PermissionState> r111) {
        Intrinsics.checkNotNullParameter(r111, "result");
        if (r110 == false) goto L5;
        this.f571472a.b(this.f571473b, this.f571474c, this.f571475d, this.f571476e);
        return;
    L5:
        CompletionBlock.DefaultImpls.onFailure$default(this.f571476e, 0, "request permission denied", null, 4, null);
    }

    public z(a0 r100, IBDXBridgeContext r101, Activity r102, yd7.i.c r103, CompletionBlock<yd7.i.d> r104) {
        this.f571472a = r100;
        this.f571473b = r101;
        this.f571474c = r102;
        this.f571475d = r103;
        this.f571476e = r104;
    }
}
