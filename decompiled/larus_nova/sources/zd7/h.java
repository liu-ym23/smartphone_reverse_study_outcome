package zd7;

import android.app.Activity;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PermissionState;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class h implements OnPermissionCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f571369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IBDXBridgeContext f571370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f571371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List<re7.d.a> f571372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ yd7.b.e f571373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<yd7.b.f> f571374f;

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback
    public final void onResult(boolean r110, Map<String, ? extends PermissionState> r111) {
        Intrinsics.checkNotNullParameter(r111, "result");
        if (r110 == false) goto L5;
        this.f571369a.a(this.f571370b, this.f571371c, this.f571372d, this.f571373e, this.f571374f);
        return;
    L5:
        CompletionBlock.DefaultImpls.onFailure$default(this.f571374f, 0, "request permission denied", null, 4, null);
    }

    public h(f r100, IBDXBridgeContext r101, Activity r102, List<re7.d.a> r103, yd7.b.e r104, CompletionBlock<yd7.b.f> r105) {
        this.f571369a = r100;
        this.f571370b = r101;
        this.f571371c = r102;
        this.f571372d = r103;
        this.f571373e = r104;
        this.f571374f = r105;
    }
}
