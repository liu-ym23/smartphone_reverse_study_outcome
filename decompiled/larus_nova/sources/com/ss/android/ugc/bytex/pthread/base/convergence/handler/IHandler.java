package com.ss.android.ugc.bytex.pthread.base.convergence.handler;

import android.os.Looper;
import android.os.Message;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H&J\b\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0001H&J \u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H&J*\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H&J\"\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H&J\"\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0018\u001a\u00020\u0016H'J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0016H&J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H&J\u0012\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0018\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0016H&J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u000bH\u0016J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u000bH&J\u0018\u0010#\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0018\u0010$\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0016H&¨\u0006%"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandler;", "", "getLooper", "Landroid/os/Looper;", "hasMessages", "", "what", "", "object", "isCurrentThread", "obtainMessage", "Landroid/os/Message;", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "arg1", "arg2", UGCMonitor.TYPE_POST, "r", "Ljava/lang/Runnable;", "postAtFrontOfQueue", "postAtTime", "token", "uptimeMillis", "", "postDelayed", "delayMillis", "removeCallbacks", "", "removeCallbacksAndMessages", "removeMessages", "sendEmptyMessage", "sendEmptyMessageAtTime", "sendEmptyMessageDelayed", "sendMessage", "msg", "sendMessageAtFrontOfQueue", "sendMessageAtTime", "sendMessageDelayed", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public interface IHandler {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 13})
    public static final class DefaultImpls {
        public static boolean sendMessage(IHandler r100, Message r101) {
            return r100.sendMessageDelayed(r101, 0);
        }
    }

    Looper getLooper();

    boolean hasMessages(int r100);

    boolean hasMessages(int r100, Object r101);

    boolean isCurrentThread();

    Message obtainMessage();

    Message obtainMessage(int r100);

    Message obtainMessage(int r100, int r101, int r102);

    Message obtainMessage(int r100, int r101, int r102, Object r103);

    Message obtainMessage(int r100, Object r101);

    boolean post(Runnable r100);

    boolean postAtFrontOfQueue(Runnable r100);

    boolean postAtTime(Runnable r100, long r101);

    boolean postAtTime(Runnable r100, Object r101, long r102);

    boolean postDelayed(Runnable r100, long r101);

    boolean postDelayed(Runnable r100, Object r101, long r102);

    void removeCallbacks(Runnable r100);

    void removeCallbacks(Runnable r100, Object r101);

    void removeCallbacksAndMessages(Object r100);

    void removeMessages(int r100);

    void removeMessages(int r100, Object r101);

    boolean sendEmptyMessage(int r100);

    boolean sendEmptyMessageAtTime(int r100, long r101);

    boolean sendEmptyMessageDelayed(int r100, long r101);

    boolean sendMessage(Message r100);

    boolean sendMessageAtFrontOfQueue(Message r100);

    boolean sendMessageAtTime(Message r100, long r101);

    boolean sendMessageDelayed(Message r100, long r101);
}
