package ox9;

import com.ss.android.ugc.bytex.pthread.base.convergence.SuperThreadPool;

/* JADX INFO: loaded from: classes31.dex */
public final class a implements c {
    public a() {
    }

    @Override // ox9.c
    public final void a() {
        SuperThreadPool r100 = SuperThreadPool.INSTANCE;
        r100.setEnableType(0);
        r100.setEnableThreadToStringOpt(false);
        r100.setEnablePriority(false);
        r100.setEnableHandlerThreadReuse(false);
        r100.setEnableThreadGroupOpt(false);
        r100.setEnableBlockFetchTask(true);
        r100.setAllowAllCoreThreadTimeOut(false);
    }
}
