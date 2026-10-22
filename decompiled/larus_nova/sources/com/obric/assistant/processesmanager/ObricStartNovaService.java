package com.obric.assistant.processesmanager;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.messenger.IObricIPC;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pfa.s;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/processesmanager/ObricStartNovaService;", "Landroid/app/Service;", "<init>", "()V", WidgetCostModule.TYPE_ON_CREATE, "", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", LiveCommonConstants.REASON_ON_DEDTROY, "onBind", "Landroid/os/IBinder;", "serverMessenger", "Landroid/os/Messenger;", "Companion", "ServerHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricStartNovaService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Messenger f391166a;

    public static final class a {
    }

    public final class b extends Handler {
        public b() {
            super((Looper) s.f529025b.getValue());
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            super.handleMessage(r100);
            if (r100.what != 1000) goto L12;
            String r101 = r100.getData().getString("RebindIPC");
            IObricIPC r102 = (IObricIPC) ServiceManager.get().getService(IObricIPC.class);
            if (r102 == null) goto L7;
            r102.b();
        L7:
            FLogger.f375446a.i("ObricStartNovaService", "handleMessage, MSG_REBIND_IPC: " + r101);
            Messenger r103 = r100.replyTo;
            Message r104 = Message.obtain(null, 2001);
            Bundle r105 = new Bundle();
            r105.putString("RebindIPCResult", "success");
            r104.setData(r105);
            r103.send(r104);     // Catch: RemoteException -> L10
            return;
        L10:
            e = move-exception;
            e.printStackTrace();
            return;
        L12:
            super.handleMessage(r100);
        }
    }

    static {
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        return 2;
    }

    @Override // android.app.Service
    public final void onCreate() {
        FLogger.f375446a.i("ObricStartNovaService", WidgetCostModule.TYPE_ON_CREATE);
        super.onCreate();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        FLogger.f375446a.i("ObricStartNovaService", "onDestroy: ");
        super.onDestroy();
    }

    public ObricStartNovaService() {
        this.f391166a = new Messenger(new b());
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        return this.f391166a.getBinder();
    }
}
