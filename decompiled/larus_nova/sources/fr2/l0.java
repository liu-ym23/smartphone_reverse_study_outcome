package fr2;

import com.ss.ttm.player.MediaPlayer;

/* JADX INFO: loaded from: classes11.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f478511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f478512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f478513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f478514d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l0) == false) goto L14;
        l0 r101 = (l0) r100;
        if (this.f478511a == r101.f478511a) goto L8;
        return false;
    L8:
        if (this.f478512b == r101.f478512b) goto L10;
        return false;
    L10:
        if (this.f478513c == r101.f478513c) goto L12;
        return false;
    L12:
        if (this.f478514d == r101.f478514d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f478511a * 31) + this.f478512b) * 31) + this.f478513c) * 31) + this.f478514d;
    }

    public final String toString() {
        return "IVideoQualityParam(width=" + this.f478511a + ", height=" + this.f478512b + ", fps=" + this.f478513c + ", bitrate=" + this.f478514d + ")";
    }

    public l0() {
        this.f478511a = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME;
        this.f478512b = 480;
        this.f478513c = 15;
        this.f478514d = 500;
    }
}
