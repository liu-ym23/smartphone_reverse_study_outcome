package zd7;

import android.app.Activity;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PermissionState;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class f0 implements OnPermissionCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f571354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ yd7.k.f f571355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<yd7.k.g> f571356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g0 f571357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ IBDXBridgeContext f571358e;

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback
    public final void onResult(boolean r110, Map<String, ? extends PermissionState> r111) {
        Intrinsics.checkNotNullParameter(r111, "result");
        if (r110 == false) goto L9;
        ae7.a r112 = ae7.a.f3109a;
        Activity r113 = this.f571354a;
        String r100 = this.f571355b.getFilePath();
        r112.getClass();
        String r101 = ae7.a.a(r113, r100);
        if (r101 != null) goto L8;
        CompletionBlock.DefaultImpls.onFailure$default(this.f571356c, 0, "get file absolute path failed, please check it", null, 4, null);
        return;
    L8:
        this.f571357d.a(this.f571358e, this.f571354a, r101, this.f571355b, this.f571356c);
        return;
    L9:
        CompletionBlock.DefaultImpls.onFailure$default(this.f571356c, 0, "request permission denied", null, 4, null);
    }

    public f0(Activity r100, yd7.k.f r101, CompletionBlock<yd7.k.g> r102, g0 r103, IBDXBridgeContext r104) {
        this.f571354a = r100;
        this.f571355b = r101;
        this.f571356c = r102;
        this.f571357d = r103;
        this.f571358e = r104;
    }
}
