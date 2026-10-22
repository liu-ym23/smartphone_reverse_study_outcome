package com.obric.aiagent.messenger.stub;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import com.larus.common.apphost.AppHost;
import com.obric.aiagent.assistant.idl.IFlowAppStateIDLSPI;
import com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL;
import com.obric.assistant.chat.IObricChatService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/aiagent/messenger/stub/AppStateIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowAppStateIDLSPI;", "<init>", "()V", "appStateCallbacks", "Landroid/os/RemoteCallbackList;", "Lcom/obric/aiagent/assistant/idl/IFlowOnAppStateChangedListenerIDL;", "isAppBackground", "", "isAppPaused", "getCurrentActivity", "", "registerAppStateListener", "", "listener", "unregisterAppStateListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppStateIDLStub implements IFlowAppStateIDLSPI {
    private final RemoteCallbackList<IFlowOnAppStateChangedListenerIDL> appStateCallbacks;

    public static final class a implements f09.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppStateIDLStub f384804a;

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
            com.obric.aiagent.ipc.utils.d.a(AppStateIDLStub.access$getAppStateCallbacks$p(this.f384804a), new com.obric.aiagent.messenger.stub.a());
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            com.obric.aiagent.ipc.utils.d.a(AppStateIDLStub.access$getAppStateCallbacks$p(this.f384804a), new com.obric.aiagent.messenger.stub.b());
        }

        @Override // f09.a.b
        public final void onAppForeground() {
            com.obric.aiagent.ipc.utils.d.a(AppStateIDLStub.access$getAppStateCallbacks$p(this.f384804a), new c());
        }

        public a(AppStateIDLStub r100) {
            this.f384804a = r100;
        }
    }

    public static final class b implements com.obric.assistant.chat.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppStateIDLStub f384805a;

        @Override // com.obric.assistant.chat.a
        public final void a() {
            com.obric.aiagent.ipc.utils.d.a(AppStateIDLStub.access$getAppStateCallbacks$p(this.f384805a), new d());
        }

        public b(AppStateIDLStub r100) {
            this.f384805a = r100;
        }

        @Override // com.obric.assistant.chat.a
        public final void b(final boolean r100) {
            com.obric.aiagent.ipc.utils.d.a(AppStateIDLStub.access$getAppStateCallbacks$p(this.f384805a), new e(r100));
        }
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDLSPI, android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public String getCurrentActivity() {
        Activity r100 = AppHost.f326268a.a().getCurrentActivity();
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getClass().getName();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public boolean isAppBackground() {
        return AppHost.f326268a.a().isAppBackground();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public boolean isAppPaused() {
        return AppHost.f326268a.a().isAppPaused();
    }

    public AppStateIDLStub() {
        this.appStateCallbacks = new RemoteCallbackList();
        AppHost.f326268a.a().j(new a(this));
        IObricChatService.f386556a.getClass();
        IObricChatService r100 = IObricChatService.a.a();
        if (r100 == null) goto L6;
        r100.i(new b(this));
        return;
    }

    public static final /* synthetic */ RemoteCallbackList access$getAppStateCallbacks$p(AppStateIDLStub r100) {
        return r100.appStateCallbacks;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public void registerAppStateListener(IFlowOnAppStateChangedListenerIDL r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.appStateCallbacks.register(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public void unregisterAppStateListener(IFlowOnAppStateChangedListenerIDL r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.appStateCallbacks.unregister(r100);
    }
}
