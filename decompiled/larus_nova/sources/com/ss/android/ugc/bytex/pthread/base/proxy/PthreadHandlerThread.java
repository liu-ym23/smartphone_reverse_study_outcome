package com.ss.android.ugc.bytex.pthread.base.proxy;

import android.os.HandlerThread;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/proxy/PthreadHandlerThread;", "Landroid/os/HandlerThread;", "name", "", "(Ljava/lang/String;)V", "priority", "", "(Ljava/lang/String;I)V", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public class PthreadHandlerThread extends HandlerThread {
    public PthreadHandlerThread(String r100) {
        super(r100);
    }

    public PthreadHandlerThread(String r100, int r101) {
        super(r100, r101);
    }
}
