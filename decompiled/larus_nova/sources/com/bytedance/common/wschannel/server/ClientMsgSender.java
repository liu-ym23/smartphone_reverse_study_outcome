package com.bytedance.common.wschannel.server;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.SocketHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.client.AbsWsClientService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes15.dex */
public class ClientMsgSender {
    private final ISender mSender;
    private final Class<? extends AbsWsClientService> mTargetServiceClass;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.server.ClientMsgSender$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class DefaultSender implements ISender {
        private final Context mContext;
        final /* synthetic */ ClientMsgSender this$0;

        @Override // com.bytedance.common.wschannel.server.ClientMsgSender.ISender
        public void tryResendMsg() {
        }

        @Override // com.bytedance.common.wschannel.server.ClientMsgSender.ISender
        public void sendMsg(Intent r100) {
            r100.setComponent(new ComponentName(this.mContext, ClientMsgSender.access$000(this.this$0)));     // Catch: Throwable -> L4
            this.mContext.startService(r100);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }

        public DefaultSender(ClientMsgSender r100, Context r101) {
            this.this$0 = r100;
            this.mContext = r101;
        }
    }

    public interface ISender {
        void sendMsg(Intent r100);

        void tryResendMsg();
    }

    public class OSender implements ISender {
        private final Runnable mBindServiceTimeoutRunnable;
        private boolean mBinding;
        private final Context mContext;
        private final Runnable mDisconnectRunnable;
        private final Object mLock;
        final AtomicInteger mMsgCount;
        private final LinkedBlockingDeque<Intent> mServiceHolderQueue;
        private Messenger service;
        private ServiceConnection serviceConnection;
        final /* synthetic */ ClientMsgSender this$0;

        public class MessengerServiceConnection implements ServiceConnection {
            final /* synthetic */ OSender this$1;

            private MessengerServiceConnection(OSender r100) {
                this.this$1 = r100;
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName r100) {
                if (Logger.debug() == false) goto L5;
                Logger.d("WsChannelSdk", "onServiceDisconnected name = " + r100.toString());
            L5:
                Object r101 = OSender.access$100(this.this$1);
                monitor-enter(r101);
                if (r100 != null) goto L10;
                monitor-exit(r101);     // Catch: Throwable -> L13
                return;
            L10:
                Logger.d("WsChannelSdk", "onServiceDisconnected set service = null");     // Catch: Throwable -> L13
                OSender.access$502(this.this$1, null);     // Catch: Throwable -> L13
                OSender.access$302(this.this$1, null);     // Catch: Throwable -> L13
                Logger.d("WsChannelSdk", "onServiceDisconnected, set Unbind = false");     // Catch: Throwable -> L13
                OSender.access$202(this.this$1, false);     // Catch: Throwable -> L13
                OSender.access$700(this.this$1);     // Catch: Throwable -> L13
                OSender.access$800(this.this$1);     // Catch: Throwable -> L13
                monitor-exit(r101);     // Catch: Throwable -> L13
                return;
            L13:
                th = move-exception;
                throw th;
            }

            public /* synthetic */ MessengerServiceConnection(OSender r100, AnonymousClass1 r101) {
                this(r100);
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName r100, IBinder r101) {
                if (Logger.debug() == false) goto L5;
                Logger.d("WsChannelSdk", "onServiceConnected name = " + r100.toString());
            L5:
                Object r102 = OSender.access$100(this.this$1);
                monitor-enter(r102);
                OSender.access$800(this.this$1);     // Catch: Throwable -> L20
                if (r100 == null) goto L18;
                if (r101 == null) goto L18;
                OSender.access$502(this.this$1, new Messenger(r101));     // Catch: Throwable -> L13
                Logger.d("WsChannelSdk", "onServiceConnected set service");     // Catch: Throwable -> L13
                OSender.access$900(this.this$1);     // Catch: Throwable -> L13
            L15:
                Logger.d("WsChannelSdk", "onServiceConnected, set Unbind = false");     // Catch: Throwable -> L20
                OSender.access$202(this.this$1, false);     // Catch: Throwable -> L20
                monitor-exit(r102);     // Catch: Throwable -> L20
                return;
            L13:
                th = move-exception;
                th.printStackTrace();     // Catch: Throwable -> L20
            L18:
                monitor-exit(r102);     // Catch: Throwable -> L20
                return;
            L20:
                th = move-exception;
                throw th;
            }
        }

        private synchronized void sendTimeout() {
            monitor-enter(this);
            removeTimeout();     // Catch: Throwable -> L6
            SocketHandler.inst().getHandler().postDelayed(this.mDisconnectRunnable, TimeUnit.SECONDS.toMillis(10));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        private void onServiceConnected() {
        L17:
        L14:
            th = move-exception;
            th.printStackTrace();
            return;
        L3:
            if (this.mServiceHolderQueue.peek() == null) goto L12;
            Intent r100 = this.mServiceHolderQueue.poll();     // Catch: Throwable -> L14
            if (r100 == null) goto L6;
            send(r100);     // Catch: Throwable -> L9 DeadObjectException -> L11
        L11:
            Logger.d("WsChannelSdk", "onServiceConnected DeadObjectException");     // Catch: Throwable -> L14
            this.service = null;     // Catch: Throwable -> L14
            this.mServiceHolderQueue.offerFirst(r100);     // Catch: Throwable -> L14
        L9:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L14
            goto L17
        L6:
            return;
        L12:
            sendTimeout();     // Catch: Throwable -> L14
        }

        @Override // com.bytedance.common.wschannel.server.ClientMsgSender.ISender
        public void tryResendMsg() {
            if (this.mServiceHolderQueue.size() > 0) goto L5;
            return;
        L5:
            if (this.service != null) goto L21;
            Logger.d("WsChannelSdk", "tryResendMsg try reconnect");
            Object r100 = this.mLock;
            monitor-enter(r100);
        L15:
            th = move-exception;
            throw th;
        L9:
            if (this.mServiceHolderQueue.size() > 0) goto L11;
        L13:
            monitor-exit(r100);     // Catch: Throwable -> L15
            return;
        L11:
            if (this.service != null) goto L13;
            doBindService();     // Catch: Throwable -> L15
            goto L13
        }

        private void doBindService() {
            if (Logger.debug() == false) goto L14;
            Logger.d("WsChannelSdk", "doBindService");
        L14:
            this.mContext.startService(new Intent(this.mContext, ClientMsgSender.access$000(this.this$0)));     // Catch: Throwable -> L11
        L12:
            this.serviceConnection = new MessengerServiceConnection(this, null);     // Catch: Throwable -> L8
            this.mContext.bindService(new Intent(this.mContext, ClientMsgSender.access$000(this.this$0)), this.serviceConnection, 1);     // Catch: Throwable -> L8
            sendBindServiceTimeout();     // Catch: Throwable -> L8
            this.mBinding = true;     // Catch: Throwable -> L8
            Logger.d("WsChannelSdk", "doBindService, set mBinding = true");     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            removeSendBindServiceTimeout();
            this.mBinding = false;
            Logger.d("WsChannelSdk", "doBindService error, set Unbind = false");
            th.printStackTrace();
        }

        private void removeSendBindServiceTimeout() {
            SocketHandler.inst().getHandler().removeCallbacks(this.mBindServiceTimeoutRunnable);
        }

        private void removeTimeout() {
            SocketHandler.inst().getHandler().removeCallbacks(this.mDisconnectRunnable);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        private void sendBindServiceTimeout() {
            removeSendBindServiceTimeout();
            SocketHandler.inst().getHandler().postDelayed(this.mBindServiceTimeoutRunnable, TimeUnit.SECONDS.toMillis(7));
        }

        public static /* synthetic */ Object access$100(OSender r100) {
            return r100.mLock;
        }

        public static /* synthetic */ boolean access$200(OSender r100) {
            return r100.mBinding;
        }

        public static /* synthetic */ ServiceConnection access$300(OSender r100) {
            return r100.serviceConnection;
        }

        public static /* synthetic */ Context access$400(OSender r100) {
            return r100.mContext;
        }

        public static /* synthetic */ void access$700(OSender r100) {
            r100.removeTimeout();
        }

        public static /* synthetic */ void access$800(OSender r100) {
            r100.removeSendBindServiceTimeout();
        }

        public static /* synthetic */ void access$900(OSender r100) {
            r100.onServiceConnected();
        }

        private void send(Intent r100) throws RemoteException {
            if (r100 != null) goto L5;
            return;
        L5:
            if (Logger.debug() == false) goto L7;
            Logger.d("WsChannelSdk", "sendMsg msg = " + r100);
        L7:
            Messenger r101 = this.service;
            Message r102 = new Message();
            r102.what = WsConstants.MSG_INTENT;
            r102.getData().putParcelable(WsConstants.DATA_INTENT, r100);
            if (r101 != null) goto L10;
            return;
        L10:
            r101.send(r102);
        }

        @Override // com.bytedance.common.wschannel.server.ClientMsgSender.ISender
        public void sendMsg(Intent r100) {
            if (r100 != null) goto L5;
            return;
        L5:
            if (Logger.debug() == false) goto L7;
            r100.putExtra(WsConstants.MSG_COUNT, this.mMsgCount.addAndGet(1));
        L7:
            Object r101 = this.mLock;
            monitor-enter(r101);
            removeTimeout();     // Catch: Throwable -> L19
            this.mServiceHolderQueue.offer(r100);     // Catch: Throwable -> L19
            if (this.service == null) goto L12;
            onServiceConnected();     // Catch: Throwable -> L19
        L17:
            monitor-exit(r101);     // Catch: Throwable -> L19
            return;
        L12:
            if (this.mBinding == false) goto L15;
            monitor-exit(r101);     // Catch: Throwable -> L19
            return;
        L15:
            doBindService();     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;
        }

        public OSender(ClientMsgSender r100, Context r101) {
            this.this$0 = r100;
            this.mServiceHolderQueue = new LinkedBlockingDeque();
            this.mBinding = false;
            this.mLock = new Object();
            this.mBindServiceTimeoutRunnable = new AnonymousClass1(this);
            this.mDisconnectRunnable = new AnonymousClass2(this);
            this.mMsgCount = new AtomicInteger(0);
            this.mContext = r101;
        }

        public static /* synthetic */ boolean access$202(OSender r100, boolean r101) {
            r100.mBinding = r101;
            return r101;
        }

        public static /* synthetic */ ServiceConnection access$302(OSender r100, ServiceConnection r101) {
            r100.serviceConnection = r101;
            return r101;
        }

        public static /* synthetic */ Messenger access$502(OSender r100, Messenger r101) {
            r100.service = r101;
            return r101;
        }
    }

    public void tryResendMsg() {
        this.mSender.tryResendMsg();
    }

    public static /* synthetic */ Class access$000(ClientMsgSender r100) {
        return r100.mTargetServiceClass;
    }

    public void sendMsg(Intent r100) {
        this.mSender.sendMsg(r100);
    }

    public ClientMsgSender(Context r100, Class<? extends AbsWsClientService> r101) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
    L7:
        this.mSender = new DefaultSender(this, r100);
    L8:
        this.mTargetServiceClass = r101;
        return;
    L5:
        if (r100.getApplicationInfo().targetSdkVersion < 26) goto L7;
        this.mSender = new OSender(this, r100);
        goto L8
    }
}
