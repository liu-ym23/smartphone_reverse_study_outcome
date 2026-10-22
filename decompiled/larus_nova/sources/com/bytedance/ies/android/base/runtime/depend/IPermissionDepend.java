package com.bytedance.ies.android.base.runtime.depend;

import android.app.Activity;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "已废弃", replaceWith = @ReplaceWith(expression = "com.bytedance.android.ad.sdk.api.permission.IAdPermissionDepend", imports = {}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/android/base/runtime/depend/IPermissionDepend;", "", "requestPermission", "", "activity", "Landroid/app/Activity;", "requestListener", "Lcom/bytedance/ies/android/base/runtime/depend/IPermissionRequestCallback;", ComplianceResult.JsonKey.PERMISSIONS, "", "", "(Landroid/app/Activity;Lcom/bytedance/ies/android/base/runtime/depend/IPermissionRequestCallback;[Ljava/lang/String;)Z", "runtime-api_release"}, k = 1, mv = {1, 1, 16})
public interface IPermissionDepend {
    boolean requestPermission(Activity r100, IPermissionRequestCallback r101, String... r102);
}
