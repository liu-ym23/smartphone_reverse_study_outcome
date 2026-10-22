package zd7;

import android.app.Activity;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PermissionState;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class x implements OnPermissionCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f571460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IBDXBridgeContext f571461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f571462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a.b f571463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<a.c> f571464e;

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback
    public final void onResult(boolean r110, Map<String, ? extends PermissionState> r111) {
        Intrinsics.checkNotNullParameter(r111, "result");
        if (r110 == false) goto L5;
        this.f571460a.a(this.f571461b, this.f571462c, this.f571463d, this.f571464e);
        return;
    L5:
        CompletionBlock.DefaultImpls.onFailure$default(this.f571464e, 0, "request permission denied", null, 4, null);
    }

    public x(y r100, IBDXBridgeContext r101, Activity r102, a.b r103, CompletionBlock<a.c> r104) {
        this.f571460a = r100;
        this.f571461b = r101;
        this.f571462c = r102;
        this.f571463d = r103;
        this.f571464e = r104;
    }
}
