package vu6;

import android.app.Activity;
import com.bytedance.locallife.hybrid.xbridge.depend.runtime3.BDXHostStyleUIDependImpl;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ActionSheetBuilder;
import com.bytedance.sdk.xbridge.cn.runtime.depend.DialogBuilder;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PageTitleBar;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ShowActionSheetListener;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ToastBuilder;
import kotlin.KotlinNothingValueException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements IHostStyleUIDepend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IHostStyleUIDepend f557361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IHostStyleUIDepend f557362b;

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final Boolean hideLoading(IBDXBridgeContext r100) {
        return this.f557361a.hideLoading(r100);
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final Boolean showDialog(DialogBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "dialogBuilder");
        return this.f557361a.showDialog(r100);
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final Boolean showLoading(IBDXBridgeContext r100) {
        return this.f557361a.showLoading(r100);
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final Boolean showToast(ToastBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "toastBuilder");
        return this.f557361a.showToast(r100);
    }

    public e(IHostStyleUIDepend r100, BDXHostStyleUIDependImpl r101) {
        Intrinsics.checkNotNullParameter(r100, "originDepend");
        Intrinsics.checkNotNullParameter(r101, "defaultDepend");
        this.f557361a = r100;
        this.f557362b = r101;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final Boolean showActionSheet(ActionSheetBuilder r100, ShowActionSheetListener r101) {
        Intrinsics.checkNotNullParameter(r100, "actionSheetBuilder");
        Intrinsics.checkNotNullParameter(r101, "showActionSheetListener");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        if (Intrinsics.areEqual(this.f557361a.showActionSheet(r100, r101), Boolean.FALSE) == false) goto L8;
        return this.f557362b.showActionSheet(r100, r101);
    L8:
        return Boolean.TRUE;
    L9:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        if (Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th))) == null) goto L15;
        return Boolean.FALSE;
    L15:
        throw new KotlinNothingValueException();
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final Boolean showLoading(hd7.a r100, IBDXBridgeContext r101) {
        Intrinsics.checkNotNullParameter(null, "showLoadingParams");
        return this.f557361a.showLoading(null, r101);
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final void setPageNaviStyle(IBDXBridgeContext r100, Activity r101, PageTitleBar r102) {
        this.f557361a.setPageNaviStyle(r100, r101, r102);
    }
}
