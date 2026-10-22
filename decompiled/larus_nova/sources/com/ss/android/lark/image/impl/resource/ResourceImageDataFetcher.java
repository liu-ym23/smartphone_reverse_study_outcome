package com.ss.android.lark.image.impl.resource;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.larksuite.framework.utils.d;
import com.ss.android.lark.log.Log;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;
import rkb.a;

/* JADX INFO: loaded from: classes36.dex */
public abstract class ResourceImageDataFetcher<Model> implements a<InputStream> {
    private InputStream mInputStream;
    private volatile boolean mIsCancelled;
    protected Model model;

    @Override // rkb.a
    public void cancel() {
        this.mIsCancelled = true;
    }

    @Override // rkb.a
    public void cleanup() {
        d.b(new Closeable[]{this.mInputStream});
    }

    public abstract String getLogTag();

    public abstract InputStream getResourceStream(Model r100) throws FileNotFoundException;

    @Override // rkb.a
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // rkb.a
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    public ResourceImageDataFetcher(Model r100) {
        this.model = r100;
    }

    @Override // rkb.a
    public void loadData(Priority r100, a.InterfaceC7498a<? super InputStream> r101) {
        loadDataWithRetry(r100, r101, 0);
    }

    private void loadDataWithRetry(Priority r110, a.InterfaceC7498a<? super InputStream> r111, int r112) {
        Log.i(getLogTag(), "loading image：" + this.model);
    L13:
        e = move-exception;
        handleError(r110, r111, e, r112);
        return;
    L4:
        if (this.mIsCancelled == false) goto L7;
        r111.onLoadFailed(new Exception("Request has been canceled：" + this.model));     // Catch: Exception -> L13
        return;
    L7:
        long r100 = System.currentTimeMillis();     // Catch: Exception -> L13
        this.mInputStream = getResourceStream(this.model);     // Catch: Exception -> L13
        long r101 = System.currentTimeMillis();     // Catch: Exception -> L13
        Log.i(getLogTag(), "loading image :" + this.model + " rust time cost:" + (r101 - r100) + " ms");     // Catch: Exception -> L13
        if (this.mInputStream != null) goto L11;
        Log.e(getLogTag(), "load image failed:" + this.model);     // Catch: Exception -> L13
        handleError(r110, r111, new Exception("load image failed:" + this.model), r112);     // Catch: Exception -> L13
        return;
    L11:
        Log.i(getLogTag(), "load image succeed：" + this.model);     // Catch: Exception -> L13
        r111.onDataReady(this.mInputStream);     // Catch: Exception -> L13
    }

    private void handleError(Priority r100, a.InterfaceC7498a<? super InputStream> r101, Exception r102, int r103) {
        if (r103 >= 1) goto L5;
        loadDataWithRetry(r100, r101, r103 + 1);
        return;
    L5:
        r101.onLoadFailed(r102);
    }
}
