package com.ss.android.lark.chameleon.bridge;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH&J(\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chameleon/bridge/IBridge;", "", "addBridgeMsgInterceptor", "", "interceptor", "Lcom/ss/android/lark/chameleon/bridge/BridgeMsgInterceptor;", "bindBridgeHandler", "handlerName", "", "handler", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "dispatchBridgeMsg", "data", "callBack", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "removeBridgeMsgInterceptor", "unbindBridgeHandler", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IBridge {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void dispatchBridgeMsg$default(IBridge r100, String r101, Object r102, CallBackFunction r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 2) == 0) goto L7;
            r102 = null;
        L7:
            if ((r104 & 4) == 0) goto L9;
            r103 = null;
        L9:
            r100.dispatchBridgeMsg(r101, r102, r103);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchBridgeMsg");
        }
    }

    void addBridgeMsgInterceptor(BridgeMsgInterceptor r100);

    void bindBridgeHandler(String r100, BridgeHandlerV2<?> r101);

    void dispatchBridgeMsg(String r100, Object r101, CallBackFunction r102);

    void removeBridgeMsgInterceptor(BridgeMsgInterceptor r100);

    void unbindBridgeHandler(String r100);
}
