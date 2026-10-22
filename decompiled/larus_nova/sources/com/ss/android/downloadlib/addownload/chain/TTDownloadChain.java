package com.ss.android.downloadlib.addownload.chain;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.download.api.ITTDownloadIntercept;
import com.ss.android.downloadlib.utils.TTDownloaderLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/downloadlib/addownload/chain/TTDownloadChain;", "Lcom/ss/android/download/api/ITTDownloadIntercept$Chain;", "info", "Lcom/ss/android/download/api/ITTDownloadIntercept$ChainInfo;", "appContext", "Landroid/content/Context;", "(Lcom/ss/android/download/api/ITTDownloadIntercept$ChainInfo;Landroid/content/Context;)V", "getAppContext", "()Landroid/content/Context;", "getInfo", "()Lcom/ss/android/download/api/ITTDownloadIntercept$ChainInfo;", "nextProcessorIndex", "", "preProcessorIndex", "processors", "", "Lcom/ss/android/download/api/ITTDownloadIntercept;", "addIntercept", "processor", "proceed", "", "nextIndex", "processorTag", "", "download-impl_release"}, k = 1, mv = {1, 1, 16})
public final class TTDownloadChain implements ITTDownloadIntercept.Chain {
    private final Context appContext;
    private final ITTDownloadIntercept.ChainInfo info;
    private int nextProcessorIndex;
    private int preProcessorIndex;
    private final List<ITTDownloadIntercept> processors;

    @Override // com.ss.android.download.api.ITTDownloadIntercept.Chain
    public Context getAppContext() {
        return this.appContext;
    }

    @Override // com.ss.android.download.api.ITTDownloadIntercept.Chain
    public ITTDownloadIntercept.ChainInfo getInfo() {
        return this.info;
    }

    @Override // com.ss.android.download.api.ITTDownloadIntercept.Chain
    public ITTDownloadIntercept.Chain addIntercept(ITTDownloadIntercept r100) {
        this.processors.add(r100);
        return this;
    }

    @Override // com.ss.android.download.api.ITTDownloadIntercept.Chain
    public void proceed(int r100) {
        if (this.nextProcessorIndex < this.processors.size()) goto L6;
        TTDownloaderLogger.INSTANCE.innerLogD("TTDownloadChain", "proceed", "callProcessorIndex >= processors.size");
        return;
    L6:
        int r101 = this.preProcessorIndex;
        int r102 = this.nextProcessorIndex;
        if (r101 < r102) goto L10;
        TTDownloaderLogger.INSTANCE.innerLogD("TTDownloadChain", "proceed", "preProcessorIndex >= nextProcessorIndex");
        return;
    L10:
        this.preProcessorIndex = r101 + 1;
        ITTDownloadIntercept r103 = (ITTDownloadIntercept) ListProtector.get(this.processors, r102);
        int r104 = this.nextProcessorIndex + 1;
        this.nextProcessorIndex = r104;
        r103.doProcess(this, r104);
    }

    @Override // com.ss.android.download.api.ITTDownloadIntercept.Chain
    public void proceed(String r100) {
        int r101 = this.processors.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        if (Intrinsics.areEqual(((ITTDownloadIntercept) ListProtector.get(this.processors, r102)).getTag(), r100) == true) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        this.nextProcessorIndex = r102;
        proceed(r102);
        return;
    }

    public TTDownloadChain(ITTDownloadIntercept.ChainInfo r100, Context r101) {
        this.info = r100;
        this.appContext = r101;
        this.processors = new ArrayList();
        this.preProcessorIndex = -1;
    }
}
