package com.ss.android.lark.officesdk.api;

import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/api/IOfficeSDKHostSessionProvider;", "Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKProtocol;", "currentHostSession", "Lcom/ss/android/lark/officesdk/api/OfficeSDKHostSession;", "isCurrentHostSession", "", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IOfficeSDKHostSessionProvider extends IOfficeSDKProtocol {
    OfficeSDKHostSession currentHostSession();

    boolean isCurrentHostSession(OfficeSDKHostSession r100);
}
