package com.larus.office.base.service;

import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/larus/office/base/service/ISdkLifecycleV2;", "", "preInitDocSdk", "", "officeSDKUserApi", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKUserApi;", "initDocSdk", "postInitDocSdk", "destroyDocSdk", "lifecycleOrder", "", "lifecycleCategory", "", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ISdkLifecycleV2 {
    void destroyDocSdk();

    void initDocSdk(OfficeSDKUserApi r100);

    String lifecycleCategory();

    int lifecycleOrder();

    void postInitDocSdk(OfficeSDKUserApi r100);

    void preInitDocSdk(OfficeSDKUserApi r100);
}
