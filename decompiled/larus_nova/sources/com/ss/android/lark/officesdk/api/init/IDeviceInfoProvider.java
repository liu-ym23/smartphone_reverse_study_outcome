package com.ss.android.lark.officesdk.api.init;

import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/officesdk/api/init/IDeviceInfoProvider;", "Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKProtocol;", "getDeviceId", "", "getInstallId", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDeviceInfoProvider extends IOfficeSDKProtocol {
    String getDeviceId();

    String getInstallId();
}
