package uu6;

import android.app.Activity;
import com.bytedance.ies.xbridge.base.runtime.depend.ActionSheetBuilder;
import com.bytedance.ies.xbridge.base.runtime.depend.DialogBuilder;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.PageTitleBar;
import com.bytedance.ies.xbridge.base.runtime.depend.ShowActionSheetListener;
import com.bytedance.ies.xbridge.base.runtime.depend.ToastBuilder;
import com.bytedance.locallife.hybrid.xbridge.depend.runtime2.XHostStyleUIDependImpl;
import kotlin.KotlinNothingValueException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import s56.f;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements IHostStyleUIDepend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IHostStyleUIDepend f551770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IHostStyleUIDepend f551771b;

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend
    public final Boolean hideLoading(g66.c r100) {
        return this.f551770a.hideLoading(r100);
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend
    public final Boolean showDialog(DialogBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "dialogBuilder");
        return this.f551770a.showDialog(r100);
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend
    public final Boolean showLoading(g66.c r100) {
        return this.f551770a.showLoading(r100);
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend
    public final Boolean showToast(ToastBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "toastBuilder");
        return this.f551770a.showToast(r100);
    }

    public e(IHostStyleUIDepend r100, XHostStyleUIDependImpl r101) {
        Intrinsics.checkNotNullParameter(r100, "originDepend");
        Intrinsics.checkNotNullParameter(r101, "defaultDepend");
        this.f551770a = r100;
        this.f551771b = r101;
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend
    public final Boolean showActionSheet(ActionSheetBuilder r100, ShowActionSheetListener r101) {
        Intrinsics.checkNotNullParameter(r100, "actionSheetBuilder");
        Intrinsics.checkNotNullParameter(r101, "showActionSheetListener");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        if (Intrinsics.areEqual(this.f551770a.showActionSheet(r100, r101), Boolean.FALSE) == false) goto L8;
        return this.f551771b.showActionSheet(r100, r101);
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

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend
    public final Boolean showLoading(f r100, g66.c r101) {
        Intrinsics.checkNotNullParameter(null, "showLoadingParams");
        return this.f551770a.showLoading(null, r101);
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend
    public final void setPageNaviStyle(g66.c r100, Activity r101, PageTitleBar r102) {
        this.f551770a.setPageNaviStyle(r100, r101, r102);
    }
}
