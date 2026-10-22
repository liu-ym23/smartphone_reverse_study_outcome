package org.apache.commons.net.ntp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import org.apache.commons.net.DatagramSocketClient;

/* JADX INFO: loaded from: classes42.dex */
public final class NTPUDPClient extends DatagramSocketClient {
    private int _version;

    public NTPUDPClient() {
        this._version = 3;
    }

    public TimeInfo getTime(InetAddress r100) throws IOException {
        return getTime(r100, 123);
    }

    public TimeInfo getTime(InetAddress r100, int r101) throws IOException {
        if (isOpen() == true) goto L5;
        open();
    L5:
        NtpV3Impl r102 = new NtpV3Impl();
        r102.setMode(3);
        r102.setVersion(this._version);
        DatagramPacket r103 = r102.getDatagramPacket();
        r103.setAddress(r100);
        r103.setPort(r101);
        NtpV3Impl r104 = new NtpV3Impl();
        DatagramPacket r105 = r104.getDatagramPacket();
        r102.setTransmitTime(TimeStamp.getCurrentTime());
        this._socket_.send(r103);
        this._socket_.receive(r105);
        return new TimeInfo(r104, System.currentTimeMillis(), false);
    }
}
