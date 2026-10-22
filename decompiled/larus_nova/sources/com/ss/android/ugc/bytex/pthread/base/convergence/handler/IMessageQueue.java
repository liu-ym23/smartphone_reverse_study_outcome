package com.ss.android.ugc.bytex.pthread.base.convergence.handler;

import android.os.Handler;
import android.os.Message;
import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H&J\b\u0010\r\u001a\u00020\u0007H&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010H&J\u001c\u0010\u0011\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H&J&\u0010\u0012\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\f\u001a\u0004\u0018\u00010\u0001H&J$\u0010\u0012\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u0015"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IMessageQueue;", "", "enqueueMessage", "", "msg", "Landroid/os/Message;", "hasMessages", "", "h", "Landroid/os/Handler;", "what", "", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "isEmpty", "pollMessage", "keepAliveTime", "", "removeCallbacksAndMessages", "removeMessages", "r", "Ljava/lang/Runnable;", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public interface IMessageQueue {
    void enqueueMessage(Message r100);

    boolean hasMessages(Handler r100, int r101, Object r102);

    boolean isEmpty();

    Message pollMessage(long r100);

    void removeCallbacksAndMessages(Handler r100, Object r101);

    void removeMessages(Handler r100, int r101, Object r102);

    void removeMessages(Handler r100, Runnable r101, Object r102);
}
