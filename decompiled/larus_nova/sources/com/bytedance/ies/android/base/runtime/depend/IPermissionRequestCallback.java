package com.bytedance.ies.android.base.runtime.depend;

import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "已废弃", replaceWith = @ReplaceWith(expression = "com.bytedance.android.ad.sdk.api.permission.IAdPermissionDepend", imports = {}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/android/base/runtime/depend/IPermissionRequestCallback;", "", "onPermissionsGrant", "", ComplianceResult.JsonKey.PERMISSIONS, "", "", "([Ljava/lang/String;)V", "runtime-api_release"}, k = 1, mv = {1, 1, 16})
public interface IPermissionRequestCallback {
    void onPermissionsGrant(String[] r100);
}
