package kt6;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes21.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f506060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f506061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f506062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f506063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f506064e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f506065f;

    public l() {
    }

    public final boolean a() {
        if (this.f506060a != AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
    L13:
        return false;
    L8:
        if (this.f506061b != AudioStats.AUDIO_AMPLITUDE_NONE) goto L10;
        boolean r101 = true;
    L11:
        if (r101 == true) goto L13;
        return true;
    L10:
        r101 = false;
        goto L11
    L5:
        r100 = false;
        goto L6
    }

    public final String toString() {
        return "SaasLocationResult(latitude=" + this.f506060a + ", longitude=" + this.f506061b + ", city=" + this.f506062c + ", cityCode=" + this.f506063d + ", districtCode=" + this.f506064e + ", provinceCode=" + this.f506065f + ", logId=null)";
    }
}
