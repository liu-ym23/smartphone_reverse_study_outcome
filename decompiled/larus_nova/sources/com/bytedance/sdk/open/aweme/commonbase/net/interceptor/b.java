package com.bytedance.sdk.open.aweme.commonbase.net.interceptor;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.open.aweme.common.constants.OpenConstants;
import com.bytedance.sdk.open.aweme.core.net.OpenHostRequest;
import com.bytedance.sdk.open.aweme.core.net.OpenHostResponse;
import com.bytedance.sdk.open.aweme.init.DouYinSdkContext;

/* JADX INFO: loaded from: classes22.dex */
public class b implements OpenInterceptor {
    public b() {
    }

    @Override // com.bytedance.sdk.open.aweme.commonbase.net.interceptor.OpenInterceptor
    public OpenHostResponse intercept(OpenInterceptor.Chain r100) throws Exception {
        OpenHostRequest r101 = r100.request();
        OpenHostRequest.Builder r102 = new OpenHostRequest.Builder(r101);
        String r103 = r101.getUrl();
        if (DouYinSdkContext.inst().isBoe() == false) goto L14;
        if (TextUtils.isEmpty(r103) == true) goto L14;
        if (r103 == null) goto L14;
        if (r101.getUrl().startsWith(OpenConstants.OPEN_DOMAIN) == false) goto L11;
        r103 = r103.replaceFirst(OpenConstants.OPEN_DOMAIN, OpenConstants.BOE_OPEN_DOMAIN);
        goto L14
    L11:
        if (r101.getUrl().startsWith(OpenConstants.CLIENT_DOMAIN) == false) goto L14;
        r103 = r103.replaceFirst(OpenConstants.CLIENT_DOMAIN, OpenConstants.BOE_CLIENT_DOMAIN);
    L14:
        if (TextUtils.isEmpty(r103) == false) goto L19;
    L16:
        r102.url(r103);
        return r100.proceed(r102.build());
    L19:
        Uri.Builder r104 = UriProtector.parse(r103).buildUpon();     // Catch: Exception -> L18
        r104.appendQueryParameter("sdk_version", "5.21.1-rc.0");     // Catch: Exception -> L18
        r103 = r104.build().toString();     // Catch: Exception -> L18
        goto L16
    }
}
