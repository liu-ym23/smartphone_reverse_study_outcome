package com.larus.im.internal.jni.observer;

import com.larus.im.internal.jni.bean.OmniDispatchCommandResponse;
import com.larus.im.internal.jni.bean.OmniIMError;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/larus/im/internal/jni/observer/OmniDispatchCommandObserver;", "Lcom/larus/im/internal/jni/observer/Observer;", "onReceiveDispatchCommand", "", "response", "Lcom/larus/im/internal/jni/bean/OmniDispatchCommandResponse;", "onSendDispatchCommandFailed", "targetDeviceId", "", "commandId", "error", "Lcom/larus/im/internal/jni/bean/OmniIMError;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OmniDispatchCommandObserver extends Observer {
    void onReceiveDispatchCommand(OmniDispatchCommandResponse r100);

    void onSendDispatchCommandFailed(String r100, String r101, OmniIMError r102);
}
