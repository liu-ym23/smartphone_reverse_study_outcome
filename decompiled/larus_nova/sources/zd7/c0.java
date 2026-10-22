package zd7;

import android.app.Activity;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PermissionState;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class c0 implements OnPermissionCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f571327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ yd7.j.g f571328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<yd7.j.h> f571329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d0 f571330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ IBDXBridgeContext f571331e;

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback
    public final void onResult(boolean r110, Map<String, ? extends PermissionState> r111) {
        Intrinsics.checkNotNullParameter(r111, "result");
        if (r110 == false) goto L9;
        ae7.a r112 = ae7.a.f3109a;
        Activity r113 = this.f571327a;
        List<String> r100 = this.f571328b.getFilePaths();
        r112.getClass();
        ArrayList<String> r101 = ae7.a.b(r113, r100);
        if (r101.size() == this.f571328b.getFilePaths().size()) goto L8;
        CompletionBlock.DefaultImpls.onFailure$default(this.f571329c, 0, "get absolute file path failed, please check it", null, 4, null);
        return;
    L8:
        this.f571330d.a(this.f571331e, this.f571327a, r101, this.f571328b, this.f571329c);
        return;
    L9:
        CompletionBlock.DefaultImpls.onFailure$default(this.f571329c, 0, "request permission denied.", null, 4, null);
    }

    public c0(Activity r100, yd7.j.g r101, CompletionBlock<yd7.j.h> r102, d0 r103, IBDXBridgeContext r104) {
        this.f571327a = r100;
        this.f571328b = r101;
        this.f571329c = r102;
        this.f571330d = r103;
        this.f571331e = r104;
    }
}
