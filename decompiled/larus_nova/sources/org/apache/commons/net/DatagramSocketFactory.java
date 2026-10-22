package org.apache.commons.net;

import java.net.DatagramSocket;
import java.net.SocketException;

/* JADX INFO: loaded from: classes42.dex */
public interface DatagramSocketFactory {
    DatagramSocket createDatagramSocket() throws SocketException;
}
