package com.bytedance.bdp.appbase.base.event;

import com.bytedance.bdp.bdpbase.ipc.annotation.Event;
import com.bytedance.bdp.bdpbase.ipc.annotation.NotDispatched;
import com.bytedance.bdp.bdpbase.ipc.annotation.RemoteInterface;
import com.bytedance.bdp.bdpbase.ipc.r;

/* JADX INFO: loaded from: classes11.dex */
@RemoteInterface(implementClass = CallHostEventImpl.class)
public interface f extends r {
    @Event
    @NotDispatched
    void sendEventV3Sync(String r100, String r101);
}
