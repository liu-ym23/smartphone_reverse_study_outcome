package com.ss.android.lark.officesdk.api.api;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKCapacity;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.cast.discovery.mdns.nsdhelper.NsdHelper;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J'\u0010\u0004\u001a\u0004\u0018\u0001H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\bH&¢\u0006\u0002\u0010\tJ-\u0010\n\u001a\u00020\u000b\"\b\b\u0000\u0010\u0005*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2\u0006\u0010\u000e\u001a\u0002H\u0005H&¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/officesdk/api/api/OfficeSDKUserApi;", "", "getUserId", "", "getService", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKCapacity;", "serviceClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKCapacity;", "setHostService", "", "Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKProtocol;", NsdHelper.serviceTypeKey, "service", "(Ljava/lang/Class;Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKProtocol;)V", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OfficeSDKUserApi {
    <T extends IOfficeSDKCapacity> T getService(Class<T> r100);

    String getUserId();

    <T extends IOfficeSDKProtocol> void setHostService(Class<T> r100, T r101);
}
