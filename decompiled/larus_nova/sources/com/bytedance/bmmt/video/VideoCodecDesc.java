package com.bytedance.bmmt.video;

/* JADX INFO: loaded from: classes8.dex */
public class VideoCodecDesc {
    public final BmmtVideoCodecProfile profile;
    public final BmmtVideoCodecStandard standard;

    public int GetProfileInt() {
        return this.profile.toInt();
    }

    public int GetStandardInt() {
        return this.standard.toInt();
    }

    public String getName() {
        return this.standard.mimeType();
    }

    public BmmtVideoCodecProfile getProfile() {
        return this.profile;
    }

    public BmmtVideoCodecStandard getStandard() {
        return this.standard;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100 != this) goto L9;
        return true;
    L9:
        if ((r100 instanceof VideoCodecDesc) == true) goto L11;
        return false;
    L11:
        VideoCodecDesc r101 = (VideoCodecDesc) r100;
        if (this.standard == r101.standard) goto L14;
        return false;
    L14:
        if (this.profile != r101.profile) goto L18;
        return true;
    L18:
        return false;
    }

    public VideoCodecDesc(int r100, int r101) {
        this.standard = BmmtVideoCodecStandard.fromValue(r100);
        this.profile = BmmtVideoCodecProfile.fromValue(r101);
    }

    public VideoCodecDesc(BmmtVideoCodecStandard r100, BmmtVideoCodecProfile r101) {
        this.standard = r100;
        this.profile = r101;
    }
}
