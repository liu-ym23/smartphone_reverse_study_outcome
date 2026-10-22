package com.ss.android.downloadlib.addownload.interceptor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/ss/android/downloadlib/addownload/interceptor/AppDownloadInterceptor;", "Lcom/ss/android/downloadlib/addownload/interceptor/TTDownloadInterceptor;", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "intercept", "", "chain", "Lcom/ss/android/downloadlib/addownload/interceptor/TTDownloadInterceptor$Chain;", "index", "", "download-impl_release"}, k = 1, mv = {1, 1, 16})
public final class AppDownloadInterceptor implements TTDownloadInterceptor {
    public AppDownloadInterceptor() {
    }

    @Override // com.ss.android.downloadlib.addownload.interceptor.TTDownloadInterceptor
    public String getTag() {
        return "AppDownloadInterceptor";
    }

    @Override // com.ss.android.downloadlib.addownload.interceptor.TTDownloadInterceptor
    public void intercept(TTDownloadInterceptor.Chain r100, int r101) {
        r100.getInfo().getDownloadHandler().handleDownloadNoIntercept(r100.getInfo().getClickType());
    }
}
