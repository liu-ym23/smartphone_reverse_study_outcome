package com.obric.sva.sdk.ui;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\nJ\u0016\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0013J.\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0001R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/sva/sdk/ui/ObricVoiceIntensityCalculator;", "", "<init>", "()V", "mDownThreshold", "", "mUpThreshold", "TAG", "", "convertByteArrayToIntArray", "", "audioData", "", "convertIntArrayToLogScale", "", "intArray", "getAverageDb", "array", "getAverageInt", "", "calculateVoiceIntensity", HTTP.CONTENT_RANGE_BYTES, "sizeInBytes", "dBMapToLinear", "db", "minDb", "maxDb", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "printArray", "", "data", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricVoiceIntensityCalculator {
    public static final ObricVoiceIntensityCalculator INSTANCE = null;
    private static final String TAG = null;
    public static float mDownThreshold;
    public static float mUpThreshold;

    private ObricVoiceIntensityCalculator() {
    }

    public final int dBMapToLinear(float r100, float r101, float r102, int r103, int r104) {
        return (int) (r103 + ((r104 - r103) * ((r100 - r101) / (r102 - r101))));
    }

    static {
        INSTANCE = new ObricVoiceIntensityCalculator();
        mDownThreshold = -70.0f;
        mUpThreshold = -25.0f;
        TAG = "ObricVoiceIntensityCalculator";
    }

    public final int[] convertByteArrayToIntArray(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "audioData");
        int[] r101 = new int[r100.length / 2];
        int r102 = 0;
        int r103 = ProgressionUtilKt.getProgressionLastElement(0, r100.length - 1, 2);
        if (r103 < 0) goto L8;
        int r104 = 0;
    L5:
        int r105 = r104 + 1;
        r101[r104] = (r100[r102] & UByte.MAX_VALUE) | (r100[r102 + 1] << 8);
        if (r102 == r103) goto L8;
        r102 = r102 + 2;
        r104 = r105;
    L8:
        return r101;
    }

    public final float[] convertIntArrayToLogScale(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "intArray");
        float[] r101 = new float[r100.length];
        float r102 = ((float) Math.log10(Math.abs(3.0517578E-5f))) * 20.0f;
        int r103 = r100.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        float r105 = ((float) Math.log10(Math.abs(r100[r104] / 32768.0f))) * 20.0f;
        r101[r104] = r105;
        if (r105 >= r102) goto L7;
        r101[r104] = r102;
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        return r101;
    }

    public final float getAverageDb(float[] r100) {
        Intrinsics.checkNotNullParameter(r100, "array");
        int r101 = 0;
        if (r100.length != 0) goto L5;
        boolean r102 = true;
    L6:
        float r103 = 0.0f;
        if (r102 == false) goto L9;
        return 0.0f;
    L9:
        int r104 = r100.length;
    L10:
        if (r101 >= r104) goto L13;
        r103 = r103 + r100[r101];
        r101 = r101 + 1;
        goto L10
    L13:
        return r103 / r100.length;
    L5:
        r102 = false;
        goto L6
    }

    public final int getAverageInt(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "array");
        int r101 = 0;
        if (r100.length != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return 0;
    L8:
        int r103 = r100.length;
        int r104 = 0;
    L9:
        if (r101 >= r103) goto L12;
        r104 = r104 + r100[r101];
        r101 = r101 + 1;
        goto L9
    L12:
        return r104 / r100.length;
    L5:
        r102 = false;
        goto L6
    }

    public final void printArray(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        int r101 = 0;
        if ((r100 instanceof int[]) == false) goto L8;
        int[] r102 = (int[]) r100;
        int r103 = r102.length;
    L5:
        if (r101 >= r103) goto L15;
        String.valueOf(r102[r101]);
        r101 = r101 + 1;
        goto L5
    L15:
        return;
    L8:
        if ((r100 instanceof float[]) == false) goto L12;
        float[] r104 = (float[]) r100;
        int r105 = r104.length;
    L10:
        if (r101 >= r105) goto L16;
        String.valueOf(r104[r101]);
        r101 = r101 + 1;
        goto L10
    L16:
        return;
    }

    public final float calculateVoiceIntensity(byte[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        float r102 = getAverageDb(convertIntArrayToLogScale(convertByteArrayToIntArray(r100)));
        float r103 = mDownThreshold;
        if (r102 >= r103) goto L5;
        r102 = r103;
    L5:
        float r104 = mUpThreshold;
        if (r102 > r104) goto L8;
        return r102;
    L8:
        return r104;
    }
}
