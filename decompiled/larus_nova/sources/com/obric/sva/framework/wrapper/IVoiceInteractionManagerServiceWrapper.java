package com.obric.sva.framework.wrapper;

import android.os.Bundle;
import android.os.RemoteException;
import com.android.internal.app.IVoiceInteractionManagerService;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes34.dex */
public class IVoiceInteractionManagerServiceWrapper {
    private IVoiceInteractionManagerService service;

    @JvmStatic
    public static Class<?> getWrapperClazz() {
        return IVoiceInteractionManagerService.class;
    }

    public IVoiceInteractionManagerServiceWrapper(IVoiceInteractionManagerService r100) {
        this.service = r100;
    }

    public void setDisabled(boolean r100) throws RemoteException {
        this.service.setDisabled(r100);
    }

    public void setUiHints(Bundle r100) throws RemoteException {
        this.service.setUiHints(r100);
    }

    public void showSession(Bundle r100, int r101, String r102) throws RemoteException {
        this.service.showSession(r100, r101, r102);
    }
}
