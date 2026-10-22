package com.ss.android.vesdk.clipparam;

/* JADX INFO: loaded from: classes40.dex */
public class VEAlgorithmPath {
    public static int BEATES_FILE_BEATS_A0 = 2;
    public static int BEATES_FILE_CUSTOM = 3;
    public static int BEATES_FILE_DEFAULT = 0;
    public static int BEATES_FILE_SERVER_C = 1;
    public static int INTMODE_ONSET = 0;
    public static int MODE_SUCCESSIVELY = 1;
    String downBeatsPath;
    String manMadePath;
    int mode;
    String noStrengthBeatsPath;
    String onlineBeatsPath;
    int type;
    String veBeatsPath;

    public String toString() {
        if (this.veBeatsPath == null) goto L5;
        String r100 = " veBeatsPath: " + this.veBeatsPath;
    L7:
        if (this.downBeatsPath == null) goto L10;
        r100 = r100 + " downBeatsPath: " + this.downBeatsPath;
    L10:
        if (this.noStrengthBeatsPath == null) goto L13;
        r100 = r100 + " noStrengthBeatsPath: " + this.noStrengthBeatsPath;
    L13:
        if (this.onlineBeatsPath == null) goto L16;
        r100 = r100 + " onlineBeatsPath: " + this.onlineBeatsPath;
    L16:
        if (this.manMadePath == null) goto L19;
        r100 = r100 + " manMadePath: " + this.manMadePath;
    L19:
        return (r100 + " mode: " + this.mode) + " type: " + this.type;
    L5:
        r100 = "";
        goto L7
    }

    public VEAlgorithmPath() {
        this.mode = INTMODE_ONSET;
        this.type = 0;
    }

    public String getDownBeatsPath() {
        return this.downBeatsPath;
    }

    public String getManMadePath() {
        return this.manMadePath;
    }

    public int getMode() {
        return this.mode;
    }

    public String getNoStrengthBeatsPath() {
        return this.noStrengthBeatsPath;
    }

    public String getOnlineBeatsPath() {
        return this.onlineBeatsPath;
    }

    public int getType() {
        return this.type;
    }

    public String getVeBeatsPath() {
        return this.veBeatsPath;
    }

    public void setDownBeatsPath(String r100) {
        this.downBeatsPath = r100;
    }

    public void setManMadePath(String r100) {
        this.manMadePath = r100;
    }

    public void setMode(int r100) {
        this.mode = r100;
    }

    public void setNoStrengthBeatsPath(String r100) {
        this.noStrengthBeatsPath = r100;
    }

    public void setOnlineBeatsPath(String r100) {
        this.onlineBeatsPath = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }

    public void setVeBeatsPath(String r100) {
        this.veBeatsPath = r100;
    }
}
