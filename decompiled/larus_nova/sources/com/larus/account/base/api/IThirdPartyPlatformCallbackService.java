package com.larus.account.base.api;

import android.content.Intent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/larus/account/base/api/IThirdPartyPlatformCallbackService;", "", "onReceiveResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", LiveCommonConstants.REASON_ON_DEDTROY, "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IThirdPartyPlatformCallbackService {
    void a(int r100, int r101, Intent r102);

    void onDestroy();
}
