package com.ss.android.lark.officesdk.permission.impl;

import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.permission.api.IPermissionRequester;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements IPermissionRequester {
    public b() {
    }

    @Override // com.ss.android.lark.officesdk.permission.api.IPermissionRequester
    public final boolean hasPermission(String r100) {
        Intrinsics.checkNotNullParameter(r100, "permission");
        IPermissionRequester r101 = (IPermissionRequester) OfficeSDKManager.getHostGlobalService(IPermissionRequester.class);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.hasPermission(r100);
    }

    @Override // com.ss.android.lark.officesdk.permission.api.IPermissionRequester
    public final boolean hasPermissions(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        IPermissionRequester r101 = (IPermissionRequester) OfficeSDKManager.getHostGlobalService(IPermissionRequester.class);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.hasPermissions(r100);
    }

    @Override // com.ss.android.lark.officesdk.permission.api.IPermissionRequester
    public void requestPermissions(List<String> r100, Function1<? super Map<String, Boolean>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r101, "onResult");
        IPermissionRequester r102 = (IPermissionRequester) OfficeSDKManager.getHostGlobalService(IPermissionRequester.class);
        if (r102 == null) goto L5;
        r102.requestPermissions(r100, r101);
        return;
    L5:
        List<String> r103 = r100;
        LinkedHashMap r104 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r103, 10)), 16));
        Iterator<T> r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        Object r106 = r105.next();
        String r107 = (String) r106;
        r104.put(r106, Boolean.FALSE);
        goto L7
    L9:
        r101.invoke(r104);
    }
}
