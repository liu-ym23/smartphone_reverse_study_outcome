package com.ttnetuploader.uploader.net.ttnet;

import com.bytedance.ttnet.utils.RetrofitUtils;

/* JADX INFO: loaded from: classes41.dex */
public class TTNetService {
    public TTNetService() {
    }

    public static IUploadRetrofitService getService(String r100) {
        return (IUploadRetrofitService) RetrofitUtils.getSsRetrofit(r100).create(IUploadRetrofitService.class);
    }
}
