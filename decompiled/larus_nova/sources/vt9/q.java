package vt9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/larus/settings/provider/audio/AudioThemeConfig;", "", "bigVideoEnable", "", "ballBigVideoUrl", "", "ballBigVideoChannel", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getBigVideoEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBallBigVideoUrl", "()Ljava/lang/String;", "getBallBigVideoChannel", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/settings/provider/audio/AudioThemeConfig;", "equals", "other", "hashCode", "", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class q {

    @SerializedName("ball_big_video_channel")
    private final String ballBigVideoChannel;

    @SerializedName("ball_big_video_url")
    private final String ballBigVideoUrl;

    @SerializedName("big_video_enable")
    private final Boolean bigVideoEnable;

    public q() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.bigVideoEnable, r101.bigVideoEnable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ballBigVideoUrl, r101.ballBigVideoUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ballBigVideoChannel, r101.ballBigVideoChannel) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.bigVideoEnable;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.ballBigVideoUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.ballBigVideoChannel;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AudioThemeConfig(bigVideoEnable=" + this.bigVideoEnable + ", ballBigVideoUrl=" + this.ballBigVideoUrl + ", ballBigVideoChannel=" + this.ballBigVideoChannel + ')';
    }

    public final String a() {
        return this.ballBigVideoChannel;
    }

    public final String b() {
        return this.ballBigVideoUrl;
    }

    public final Boolean c() {
        return this.bigVideoEnable;
    }

    public /* synthetic */ q(int r100) {
        this(Boolean.FALSE, "", "");
    }

    public q(Boolean r100, String r101, String r102) {
        this.bigVideoEnable = r100;
        this.ballBigVideoUrl = r101;
        this.ballBigVideoChannel = r102;
    }
}
