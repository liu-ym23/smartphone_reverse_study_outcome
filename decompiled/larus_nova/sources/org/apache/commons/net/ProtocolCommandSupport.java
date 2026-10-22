package org.apache.commons.net;

import java.io.Serializable;
import java.util.EventListener;
import java.util.Iterator;
import org.apache.commons.net.util.ListenerList;

/* JADX INFO: loaded from: classes42.dex */
public class ProtocolCommandSupport implements Serializable {
    private static final long serialVersionUID = -8017692739988399978L;
    private final ListenerList __listeners;
    private final Object __source;

    public int getListenerCount() {
        return this.__listeners.getListenerCount();
    }

    public ProtocolCommandSupport(Object r100) {
        this.__listeners = new ListenerList();
        this.__source = r100;
    }

    public void addProtocolCommandListener(ProtocolCommandListener r100) {
        this.__listeners.addListener(r100);
    }

    public void removeProtocolCommandListener(ProtocolCommandListener r100) {
        this.__listeners.removeListener(r100);
    }

    public void fireCommandSent(String r100, String r101) {
        ProtocolCommandEvent r102 = new ProtocolCommandEvent(this.__source, r100, r101);
        Iterator<EventListener> r103 = this.__listeners.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((ProtocolCommandListener) r103.next()).protocolCommandSent(r102);
        goto L4
    }

    public void fireReplyReceived(int r100, String r101) {
        ProtocolCommandEvent r102 = new ProtocolCommandEvent(this.__source, r100, r101);
        Iterator<EventListener> r103 = this.__listeners.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((ProtocolCommandListener) r103.next()).protocolReplyReceived(r102);
        goto L4
    }
}
