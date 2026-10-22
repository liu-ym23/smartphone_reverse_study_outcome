package com.bytedance.bmf_mods.downloader.custom;

import com.bytedance.ttnet.utils.RetrofitUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/bmf_mods/downloader/custom/FileDownloadRequester;", "", "()V", "create", "Lcom/bytedance/bmf_mods/downloader/custom/IDownloadRequester;", "host", "", "bmf_mods_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FileDownloadRequester {
    public static final FileDownloadRequester INSTANCE = null;

    static {
        INSTANCE = new FileDownloadRequester();
    }

    private FileDownloadRequester() {
    }

    public final IDownloadRequester create(String r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        return (IDownloadRequester) RetrofitUtils.getSsRetrofit(r100).create(IDownloadRequester.class);
    }
}
