package com.ss.android.ugc.bytex.pthread.base.convergence.handler;

import android.os.HandlerThread;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandlerThreadPool;", "", "obtain", "Landroid/os/HandlerThread;", "level", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/BusyLevel;", "name", "", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public interface IHandlerThreadPool {
    HandlerThread obtain(BusyLevel r100, String r101);
}
