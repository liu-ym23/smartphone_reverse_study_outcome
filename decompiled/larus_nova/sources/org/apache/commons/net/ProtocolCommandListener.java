package org.apache.commons.net;

import java.util.EventListener;

/* JADX INFO: loaded from: classes42.dex */
public interface ProtocolCommandListener extends EventListener {
    void protocolCommandSent(ProtocolCommandEvent r100);

    void protocolReplyReceived(ProtocolCommandEvent r100);
}
