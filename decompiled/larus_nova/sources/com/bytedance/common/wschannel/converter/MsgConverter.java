package com.bytedance.common.wschannel.converter;

import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface MsgConverter {
    WsChannelMsg decode(byte[] r100) throws IOException;

    byte[] encode(WsChannelMsg r100);
}
