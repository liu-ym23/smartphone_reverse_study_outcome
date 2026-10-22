package com.bytedance.common.wschannel;

import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes3.dex */
final class MainProcessMsg extends WsChannelMsg {
    private final MsgSendListener mListener;
    private final WsChannelMsg origin;

    public MsgSendListener getListener() {
        return this.mListener;
    }

    public WsChannelMsg getOrigin() {
        return this.origin;
    }

    public MainProcessMsg(WsChannelMsg r100, MsgSendListener r101) {
        super(r100);
        this.origin = r100;
        this.mListener = r101;
    }
}
