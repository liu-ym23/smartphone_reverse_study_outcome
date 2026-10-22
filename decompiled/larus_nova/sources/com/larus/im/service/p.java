package com.larus.im.service;

import com.larus.im.callback.IIMCallback;
import com.larus.im.internal.jni.bean.OmniDispatchCommandAcceptedResponse;
import com.larus.im.internal.jni.bean.OmniDispatchCommandRequest;
import com.larus.im.internal.jni.bean.OmniDispatchCommandResponse;

/* JADX INFO: loaded from: classes4.dex */
public interface p {
    void addBizProcessor(a r100);

    void addProcessor(c r100);

    void registerDispatchCommandListener(a0 r100);

    void removeProcessor(c r100);

    void sendBizCmd(vc9.a r100, IIMCallback<String> r101);

    void sendDispatchCommand(OmniDispatchCommandRequest r100, IIMCallback<OmniDispatchCommandResponse> r101);

    void sendDispatchCommandForAcceptance(OmniDispatchCommandRequest r100, IIMCallback<OmniDispatchCommandAcceptedResponse> r101);

    void shutDown(String r100, boolean r101);

    void unregisterDispatchCommandListener(a0 r100);
}
