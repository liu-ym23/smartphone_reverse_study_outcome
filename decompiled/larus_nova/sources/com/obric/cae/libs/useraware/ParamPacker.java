package com.obric.cae.libs.useraware;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes33.dex */
public class ParamPacker {
    public static final int TOTAL_LENGTH = 54;

    public ParamPacker() {
    }

    public static byte[] pack(HarMonitorParams r100) {
        if (r100 != null) goto L5;
    L16:
        return null;
    L5:
        if (ParamsValidator.validate(r100) == false) goto L16;
        ByteArrayOutputStream r101 = new ByteArrayOutputStream(54);
        DataOutputStream r102 = new DataOutputStream(r101);
        r102.writeInt(r100.stateVoteWindowSize);     // Catch: IOException -> L17
        r102.writeInt(r100.walkingContinuousThreshold);     // Catch: IOException -> L17
        r102.writeInt(r100.runningContinuousThreshold);     // Catch: IOException -> L17
        r102.writeInt(r100.accelOccurrenceThreshold);     // Catch: IOException -> L17
        r102.writeInt(r100.stationaryOccurrenceThreshold);     // Catch: IOException -> L17
        r102.writeInt(r100.accStateDurationThreshold);     // Catch: IOException -> L17
        r102.writeInt(r100.accStateMonitorWindow);     // Catch: IOException -> L17
        r102.writeInt(r100.accStateDurationThreshold2);     // Catch: IOException -> L17
        r102.writeInt(r100.runningStateDurationThreshold);     // Catch: IOException -> L17
        r102.writeInt(r100.runningStateMonitorWindow);     // Catch: IOException -> L17
        r102.writeInt(r100.runningStateDurationThreshold2);     // Catch: IOException -> L17
        byte[] r103 = r101.toByteArray();     // Catch: IOException -> L17
        if (r103.length == 52) goto L11;
        return null;
    L11:
        int r104 = Math.min(r103.length, 52);     // Catch: IOException -> L17
        int r105 = 0;
        int r106 = 0;
    L12:
        if (r105 >= r104) goto L14;
        r106 = r106 + (r103[r105] & UByte.MAX_VALUE);     // Catch: IOException -> L17
        r105 = r105 + 1;     // Catch: IOException -> L17
        goto L12
    L14:
        r102.writeShort((short) (65535 & r106));     // Catch: IOException -> L17
        return r101.toByteArray();
    }
}
