package com.ss.android.common.app.permission.callback;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "", "requestCode", "", ComplianceResult.JsonKey.PERMISSIONS, "", "", "grantResults", "", AbsMethodDelegate.TAG_INVOKE, "(I[Ljava/lang/String;[I)V"}, k = 3, mv = {1, 1, 15})
final class ActivityPlusKt$requestActivityPermissions$1$1 extends Lambda implements Function3<Integer, String[], int[], Unit> {
    final /* synthetic */ a this$0;

    public ActivityPlusKt$requestActivityPermissions$1$1(a r100) {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100, String[] r101, int[] r102) {
        invoke(r100.intValue(), r101, r102);
        return Unit.INSTANCE;
    }

    public final void invoke(int r100, String[] r101, int[] r102) {
        throw null;
    }
}
