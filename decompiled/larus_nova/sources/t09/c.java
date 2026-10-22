package t09;

import com.bytedance.common.utility.concurrent.TTExecutors;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements xo7.c {
    public c() {
    }

    @Override // xo7.c
    public final void execute(Runnable r100) {
        TTExecutors.getNormalExecutor().submit(r100);
    }
}
