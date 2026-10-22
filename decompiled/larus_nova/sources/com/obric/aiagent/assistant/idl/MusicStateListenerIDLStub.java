package com.obric.aiagent.assistant.idl;

import android.os.Bundle;
import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0019\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001¨\u0006\f"}, d2 = {"Lcom/obric/aiagent/assistant/idl/MusicStateListenerIDLStub;", "Lcom/obric/aiagent/assistant/idl/IMusicStateListenerIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IMusicStateListenerIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "onMusicStateChanged", "", "state", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class MusicStateListenerIDLStub extends IMusicStateListenerIDL.Stub {
    private final /* synthetic */ IMusicStateListenerIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IMusicStateListenerIDL
    public void onMusicStateChanged(Bundle r100) {
        this.$$delegate_0.onMusicStateChanged(r100);
    }

    public MusicStateListenerIDLStub() {
        IMusicStateListenerIDL r100 = (IMusicStateListenerIDLSPI) ServiceManager.get().getService(IMusicStateListenerIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IMusicStateListenerIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IMusicStateListenerIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
