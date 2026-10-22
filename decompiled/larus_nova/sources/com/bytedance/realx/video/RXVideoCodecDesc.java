package com.bytedance.realx.video;

/* JADX INFO: loaded from: classes21.dex */
public class RXVideoCodecDesc {
    public final RXVideoCodecProfile profile;
    public final RXVideoCodecStandard standard;

    public int GetProfileInt() {
        return this.profile.toInt();
    }

    public int GetStandardInt() {
        return this.standard.toInt();
    }

    public String getName() {
        return this.standard.mimeType();
    }

    public RXVideoCodecProfile getProfile() {
        return this.profile;
    }

    public RXVideoCodecStandard getStandard() {
        return this.standard;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100 != this) goto L9;
        return true;
    L9:
        if ((r100 instanceof RXVideoCodecDesc) == true) goto L11;
        return false;
    L11:
        RXVideoCodecDesc r101 = (RXVideoCodecDesc) r100;
        if (this.standard == r101.standard) goto L14;
        return false;
    L14:
        if (this.profile != r101.profile) goto L18;
        return true;
    L18:
        return false;
    }

    public RXVideoCodecDesc(int r100, int r101) {
        this.standard = RXVideoCodecStandard.fromValue(r100);
        this.profile = RXVideoCodecProfile.fromValue(r101);
    }

    public RXVideoCodecDesc(RXVideoCodecStandard r100, RXVideoCodecProfile r101) {
        this.standard = r100;
        this.profile = r101;
    }
}
