package com.ss.android.vesdk;

import java.util.Arrays;

/* JADX INFO: loaded from: classes40.dex */
public class VETimelineParams {
    public int[] aTrimIn;
    public int[] aTrimOut;
    private int[] audioFileIndex;
    public String[] audioFilePaths;
    public boolean[] enable;
    public ROTATE_DEGREE[] rotate;
    public double[] speed;
    public String[] transitions;
    public int[] vTrimIn;
    public int[] vTrimOut;
    public int[] videoFileIndex;
    public String[] videoFilePaths;

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        String[] r101 = this.videoFilePaths;     // Catch: Exception -> L56
        int r102 = 0;
        if (r101 != null) goto L6;
        int r103 = 0;
    L7:
        if (r102 >= r103) goto L55;
        int[] r104 = this.videoFileIndex;     // Catch: Exception -> L56
        if (r104 != null) goto L11;
    L13:
        String[] r105 = this.videoFilePaths;     // Catch: Exception -> L56
        if (r105 != null) goto L16;
    L18:
        int[] r106 = this.vTrimIn;     // Catch: Exception -> L56
        if (r106 != null) goto L21;
    L23:
        int[] r107 = this.vTrimOut;     // Catch: Exception -> L56
        if (r107 != null) goto L26;
    L28:
        int[] r108 = this.aTrimIn;     // Catch: Exception -> L56
        if (r108 != null) goto L31;
    L33:
        int[] r109 = this.aTrimOut;     // Catch: Exception -> L56
        if (r109 != null) goto L36;
    L38:
        double[] r110 = this.speed;     // Catch: Exception -> L56
        if (r110 != null) goto L41;
    L43:
        boolean[] r111 = this.enable;     // Catch: Exception -> L56
        if (r111 != null) goto L46;
    L48:
        ROTATE_DEGREE[] r112 = this.rotate;     // Catch: Exception -> L56
        if (r112 == null) goto L53;
        if (r112.length <= r102) goto L53;
        r100.append(" rotate: ");     // Catch: Exception -> L56
        r100.append(this.rotate[r102]);     // Catch: Exception -> L56
    L53:
        r102 = r102 + 1;
        goto L7
    L46:
        if (r111.length <= r102) goto L48;
        r100.append(" enable: ");     // Catch: Exception -> L56
        r100.append(this.enable[r102]);     // Catch: Exception -> L56
        goto L48
    L41:
        if (r110.length <= r102) goto L43;
        r100.append(" speed: ");     // Catch: Exception -> L56
        r100.append(this.speed[r102]);     // Catch: Exception -> L56
        goto L43
    L36:
        if (r109.length <= r102) goto L38;
        r100.append(" aTrimOut: ");     // Catch: Exception -> L56
        r100.append(this.aTrimOut[r102]);     // Catch: Exception -> L56
        goto L38
    L31:
        if (r108.length <= r102) goto L33;
        r100.append(" aTrimIn: ");     // Catch: Exception -> L56
        r100.append(this.aTrimIn[r102]);     // Catch: Exception -> L56
        goto L33
    L26:
        if (r107.length <= r102) goto L28;
        r100.append(" vTrimOut: ");     // Catch: Exception -> L56
        r100.append(this.vTrimOut[r102]);     // Catch: Exception -> L56
        goto L28
    L21:
        if (r106.length <= r102) goto L23;
        r100.append(" vTrimIn: ");     // Catch: Exception -> L56
        r100.append(this.vTrimIn[r102]);     // Catch: Exception -> L56
        goto L23
    L16:
        if (r105.length <= r102) goto L18;
        r100.append(" videoFilePath: ");     // Catch: Exception -> L56
        r100.append(this.videoFilePaths[r102]);     // Catch: Exception -> L56
        goto L18
    L11:
        if (r104.length <= r102) goto L13;
        r100.append(" videoFileIndex: ");     // Catch: Exception -> L56
        r100.append(this.videoFileIndex[r102]);     // Catch: Exception -> L56
        goto L13
    L55:
        return r100.toString();
    L6:
        r103 = r101.length;     // Catch: Exception -> L56
    L56:
        return "Exception";
    }

    public VETimelineParams(String[] r100) {
        int r101 = r100.length;
        this.videoFilePaths = (String[]) r100.clone();
        int[] r102 = new int[r101];
        this.vTrimIn = r102;
        int r103 = 0;
        Arrays.fill(r102, 0);
        int[] r104 = new int[r101];
        this.vTrimOut = r104;
        Arrays.fill(r104, -1);
        int[] r105 = new int[r101];
        this.aTrimIn = r105;
        Arrays.fill(r105, 0);
        int[] r106 = new int[r101];
        this.aTrimOut = r106;
        Arrays.fill(r106, -1);
        double[] r107 = new double[r101];
        this.speed = r107;
        Arrays.fill(r107, 1.0d);
        this.transitions = null;
        this.audioFilePaths = null;
        this.videoFileIndex = new int[r101];
        this.audioFileIndex = new int[r101];
        boolean[] r108 = new boolean[r101];
        this.enable = r108;
        Arrays.fill(r108, true);
        ROTATE_DEGREE[] r109 = new ROTATE_DEGREE[r101];
        this.rotate = r109;
        Arrays.fill(r109, ROTATE_DEGREE.ROTATE_NONE);
    L3:
        if (r103 >= r101) goto L5;
        this.videoFileIndex[r103] = r103;
        this.audioFileIndex[r103] = r103;
        r103 = r103 + 1;
        goto L3
    }
}
