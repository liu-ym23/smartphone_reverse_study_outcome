package com.ss.android.socialbase.downloader.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes38.dex */
public final class DownloadWatchDog implements Handler.Callback {
    private static final int MSG_SCHEDULE_WATCH = 0;
    private volatile Handler handler;

    public static class Holder {
        private static final Looper LOOPER = null;

        private Holder() {
        }

        static {
            PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("DownloadWatchDog");
            ThreadMethodProxy.start(r100);
            LOOPER = r100.getLooper();
        }

        public static /* synthetic */ Looper access$000() {
            return LOOPER;
        }
    }

    public interface IWatcher {
        long onScheduleWatch();
    }

    public void release() {
        Handler r100 = this.handler;
        if (r100 != null) goto L5;
        return;
    L5:
        this.handler = null;
        r100.removeCallbacksAndMessages(null);
    }

    public DownloadWatchDog() {
        this.handler = new Handler(Holder.access$000(), this);
    }

    public static Looper getThreadLooper() {
        return Holder.access$000();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r100) {
        if (r100.what != 0) goto L16;
        IWatcher r101 = (IWatcher) r100.obj;     // Catch: Throwable -> L9
        long r102 = r101.onScheduleWatch();     // Catch: Throwable -> L9
        if (r102 <= 0) goto L15;
        addWatcher(r101, r102);     // Catch: Throwable -> L9
        return true;
    L15:
        return true;
    L9:
        th = move-exception;
        th.printStackTrace();
        return true;
    L16:
        return true;
    }

    public void removeWatcher(IWatcher r100) {
        Handler r101 = this.handler;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.removeMessages(0, r100);
    }

    public void addWatcher(IWatcher r100, long r101) {
        Handler r102 = this.handler;
        if (r102 != null) goto L5;
        return;
    L5:
        Message r103 = Message.obtain();
        r103.what = 0;
        r103.obj = r100;
        r102.sendMessageDelayed(r103, r101);
    }
}
