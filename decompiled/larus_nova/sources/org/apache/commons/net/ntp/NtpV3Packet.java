package org.apache.commons.net.ntp;

import java.net.DatagramPacket;

/* JADX INFO: loaded from: classes42.dex */
public interface NtpV3Packet {
    DatagramPacket getDatagramPacket();

    TimeStamp getOriginateTimeStamp();

    TimeStamp getReceiveTimeStamp();

    TimeStamp getTransmitTimeStamp();

    String getType();

    void setMode(int r100);

    void setTransmitTime(TimeStamp r100);

    void setVersion(int r100);
}
