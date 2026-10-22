package com.ss.android.downloadlib.addownload.interceptor;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/downloadlib/addownload/interceptor/TTDownloadInterceptorChain;", "Lcom/ss/android/downloadlib/addownload/interceptor/TTDownloadInterceptor$Chain;", "info", "Lcom/ss/android/downloadlib/addownload/interceptor/DownloadChainInfo;", "(Lcom/ss/android/downloadlib/addownload/interceptor/DownloadChainInfo;)V", "getInfo", "()Lcom/ss/android/downloadlib/addownload/interceptor/DownloadChainInfo;", "mInterceptors", "", "Lcom/ss/android/downloadlib/addownload/interceptor/TTDownloadInterceptor;", "nextIndex", "", "preIndex", "add", "interceptor", "proceed", "", "index", "download-impl_release"}, k = 1, mv = {1, 1, 16})
public final class TTDownloadInterceptorChain implements TTDownloadInterceptor.Chain {
    private final DownloadChainInfo info;
    private final List<TTDownloadInterceptor> mInterceptors;
    private int nextIndex;
    private int preIndex;

    @Override // com.ss.android.downloadlib.addownload.interceptor.TTDownloadInterceptor.Chain
    public DownloadChainInfo getInfo() {
        return this.info;
    }

    public TTDownloadInterceptorChain(DownloadChainInfo r100) {
        this.info = r100;
        this.preIndex = -1;
        this.mInterceptors = new ArrayList();
    }

    @Override // com.ss.android.downloadlib.addownload.interceptor.TTDownloadInterceptor.Chain
    public TTDownloadInterceptor.Chain add(TTDownloadInterceptor r100) {
        this.mInterceptors.add(r100);
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.interceptor.TTDownloadInterceptor.Chain
    public void proceed(int r100) {
        if (this.nextIndex < this.mInterceptors.size()) goto L5;
        return;
    L5:
        int r101 = this.preIndex;
        int r102 = this.nextIndex;
        if (r101 < r102) goto L8;
        return;
    L8:
        this.preIndex = r101 + 1;
        TTDownloadInterceptor r103 = (TTDownloadInterceptor) ListProtector.get(this.mInterceptors, r102);
        int r104 = this.nextIndex + 1;
        this.nextIndex = r104;
        r103.intercept(this, r104);
    }
}
