package com.ss.android.ugc.bytex.pthread.base.proxy;

import java.util.Timer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/proxy/PthreadTimer;", "Ljava/util/Timer;", "()V", "isDaemon", "", "(Z)V", "name", "", "(Ljava/lang/String;)V", "(Ljava/lang/String;Z)V", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public class PthreadTimer extends Timer {
    public PthreadTimer() {
    }

    public PthreadTimer(String r100) {
        super(r100);
    }

    public PthreadTimer(String r100, boolean r101) {
        super(r100, r101);
    }

    public PthreadTimer(boolean r100) {
        super(r100);
    }
}
