package org.apache.commons.net;

import java.net.DatagramSocket;
import java.net.SocketException;

/* JADX INFO: loaded from: classes42.dex */
public class DefaultDatagramSocketFactory implements DatagramSocketFactory {
    public DefaultDatagramSocketFactory() {
    }

    @Override // org.apache.commons.net.DatagramSocketFactory
    public DatagramSocket createDatagramSocket() throws SocketException {
        return new DatagramSocket();
    }
}
