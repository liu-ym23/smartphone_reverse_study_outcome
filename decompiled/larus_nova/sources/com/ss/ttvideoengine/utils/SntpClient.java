package com.ss.ttvideoengine.utils;

import android.os.SystemClock;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes35.dex */
public class SntpClient {
    private static final int NTP_LEAP_NOSYNC = 3;
    private static final int NTP_MODE_BROADCAST = 5;
    private static final int NTP_MODE_CLIENT = 3;
    private static final int NTP_MODE_SERVER = 4;
    private static final int NTP_PACKET_SIZE = 48;
    private static final int NTP_PORT = 123;
    private static final int NTP_STRATUM_DEATH = 0;
    private static final int NTP_STRATUM_MAX = 15;
    private static final int NTP_VERSION = 3;
    private static final long OFFSET_1900_TO_1970 = 2208988800L;
    private static final int ORIGINATE_TIME_OFFSET = 24;
    private static final int RECEIVE_TIME_OFFSET = 32;
    private static final String TAG = "SntpClient";
    private static final int TRANSMIT_TIME_OFFSET = 40;
    private long mNtpTime;
    private long mNtpTimeReference;
    private long mRoundTripTime;

    public static class InvalidServerReplyException extends Exception {
        public InvalidServerReplyException(String r100) {
            super(r100);
        }
    }

    public SntpClient() {
    }

    public long getNtpTime() {
        return this.mNtpTime;
    }

    public long getNtpTimeReference() {
        return this.mNtpTimeReference;
    }

    public long getRoundTripTime() {
        return this.mRoundTripTime;
    }

    private long read32(byte[] r100, int r101) {
        int r102 = r100[r101];
        int r103 = r100[r101 + 1];
        int r104 = r100[r101 + 2];
        int r105 = r100[r101 + 3];
        if ((r102 & 128) != 128) goto L6;
        r102 = (r102 & 127) + 128;
    L6:
        if ((r103 & 128) != 128) goto L9;
        r103 = (r103 & 127) + 128;
    L9:
        if ((r104 & 128) != 128) goto L12;
        r104 = (r104 & 127) + 128;
    L12:
        if ((r105 & 128) != 128) goto L15;
        r105 = (r105 & 127) + 128;
    L15:
        return (((((long) r102) << 24) + (((long) r103) << 16)) + (((long) r104) << 8)) + ((long) r105);
    }

    private long readTimeStamp(byte[] r100, int r101) {
        long r102 = read32(r100, r101);
        long r103 = read32(r100, r101 + 4);
        if (r102 != 0) goto L8;
        if (r103 != 0) goto L8;
        return 0;
    L8:
        return ((r102 - OFFSET_1900_TO_1970) * 1000) + ((r103 * 1000) / 4294967296L);
    }

    public boolean requestTime(String r100, int r101) {
        return requestTime(InetAddress.getByName(r100), 123, r101);
    L5:
        e = move-exception;
        TTVideoEngineLog.d(e);
        return false;
    }

    private void writeTimeStamp(byte[] r110, int r111, long r112) {
        if (r112 != 0) goto L6;
        Arrays.fill(r110, r111, r111 + 8, (byte) 0);
        return;
    L6:
        long r100 = r112 / 1000;
        long r113 = r112 - (r100 * 1000);
        long r101 = r100 + OFFSET_1900_TO_1970;
        int r102 = r111 + 1;
        r110[r111] = (byte) (r101 >> 24);
        int r114 = r102 + 1;
        r110[r102] = (byte) (r101 >> 16);
        int r103 = r114 + 1;
        r110[r114] = (byte) (r101 >> 8);
        int r115 = r103 + 1;
        r110[r103] = (byte) (r101 >> 0);
        long r116 = (r113 * 4294967296L) / 1000;
        int r104 = r115 + 1;
        r110[r115] = (byte) (r116 >> 24);
        int r117 = r104 + 1;
        r110[r104] = (byte) (r116 >> 16);
        r110[r117] = (byte) (r116 >> 8);
        r110[r117 + 1] = (byte) (Math.random() * 255.0d);
    }

    public boolean requestTime(InetAddress r210, int r211, int r212) {
        DatagramSocket r100 = null;
        DatagramSocket r101 = new DatagramSocket();     // Catch: Throwable -> L20 Exception -> L22
        r101.setSoTimeout(r212);     // Catch: Throwable -> L14 Exception -> L17
        byte[] r102 = new byte[48];     // Catch: Throwable -> L14 Exception -> L17
        DatagramPacket r103 = new DatagramPacket(r102, 48, r210, r211);     // Catch: Throwable -> L14 Exception -> L17
        r102[0] = 27;     // Catch: Throwable -> L14 Exception -> L17
        long r104 = System.currentTimeMillis();     // Catch: Throwable -> L14 Exception -> L17
        long r105 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L14 Exception -> L17
        writeTimeStamp(r102, 40, r104);     // Catch: Throwable -> L14 Exception -> L17
        r101.send(r103);     // Catch: Throwable -> L14 Exception -> L17
        r101.receive(new DatagramPacket(r102, 48));     // Catch: Throwable -> L14 Exception -> L17
        long r110 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L14 Exception -> L17
        long r106 = r110 - r105;     // Catch: Throwable -> L14 Exception -> L17
        long r107 = r104 + r106;     // Catch: Throwable -> L14 Exception -> L17
        byte r108 = r102[0];     // Catch: Throwable -> L14 Exception -> L17
        byte r109 = (byte) ((r108 >> 6) & 3);     // Catch: Throwable -> L14 Exception -> L17
        byte r111 = (byte) (r108 & 7);     // Catch: Throwable -> L14 Exception -> L17
        int r112 = r102[1] & UByte.MAX_VALUE;     // Catch: Throwable -> L14 Exception -> L17
        long r113 = readTimeStamp(r102, 24);     // Catch: Throwable -> L14 Exception -> L17
        long r114 = readTimeStamp(r102, 32);     // Catch: Throwable -> L14 Exception -> L17
        DatagramSocket r115 = r101;
        long r116 = readTimeStamp(r102, 40);     // Catch: Throwable -> L10 Exception -> L12
        checkValidServerReply(r109, r111, r112, r116);     // Catch: Throwable -> L10 Exception -> L12
        long r117 = r106 - (r116 - r114);     // Catch: Throwable -> L10 Exception -> L12
        long r118 = ((r114 - r113) + (r116 - r107)) / 2;     // Catch: Throwable -> L10 Exception -> L12
        TTVideoEngineLog.d(TAG, "requestTime round trip: " + r117 + "ms, clock offset: " + r118 + "ms");     // Catch: Throwable -> L10 Exception -> L12
        this.mNtpTime = r107 + r118;     // Catch: Throwable -> L10 Exception -> L12
        this.mNtpTimeReference = r110;     // Catch: Throwable -> L10 Exception -> L12
        this.mRoundTripTime = r117;     // Catch: Throwable -> L10 Exception -> L12
        r115.close();
        return true;
    L12:
        e = e;
    L19:
        r100 = r115;
    L23:
        TTVideoEngineLog.d(e);     // Catch: Throwable -> L20
        if (r100 == null) goto L39;
        r100.close();
        return false;
    L39:
        return false;
    L10:
        th = th;
    L16:
        r100 = r115;
    L28:
        if (r100 == null) goto L30;
        r100.close();
    L30:
        throw th;
    L17:
        e = e;
        r115 = r101;
    L14:
        th = th;
        r115 = r101;
    L20:
        th = th;
    L22:
        e = e;
        goto L23
    }

    private static void checkValidServerReply(byte r100, byte r101, int r102, long r103) throws InvalidServerReplyException {
        if (r100 == 3) goto L22;
        if (r101 != 4) goto L7;
    L11:
        if (r102 == 0) goto L20;
        if (r102 > 15) goto L20;
        if (r103 == 0) goto L18;
        return;
    L18:
        throw new InvalidServerReplyException("zero transmitTime");
    L20:
        throw new InvalidServerReplyException("untrusted stratum: " + r102);
    L7:
        if (r101 == 5) goto L11;
        throw new InvalidServerReplyException("untrusted mode: " + r101);
    L22:
        throw new InvalidServerReplyException("unsynchronized server");
    }
}
