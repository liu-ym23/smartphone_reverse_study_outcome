package com.ss.android.lark.officesdk.permission.api;

import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&J6\u0010\t\u001a\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u001e\u0010\u000b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\r\u0012\u0004\u0012\u00020\n0\fH&¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/officesdk/permission/api/IPermissionRequester;", "Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKProtocol;", "hasPermission", "", "permission", "", "hasPermissions", ComplianceResult.JsonKey.PERMISSIONS, "", "requestPermissions", "", "onResult", "Lkotlin/Function1;", "", "permission-officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IPermissionRequester extends IOfficeSDKProtocol {
    boolean hasPermission(String r100);

    boolean hasPermissions(List<String> r100);

    void requestPermissions(List<String> r100, Function1<? super Map<String, Boolean>, Unit> r101);
}
