package dj2;

import com.bytedance.android.ec.model.playback.ECReplayVideo;
import com.bytedance.android.ec.model.playback.ExplainPlaybackVideoInfo;
import com.bytedance.android.ec.model.playback.ExplainReplaySubTitle;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExplainPlaybackVideoInfo f468903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECReplayVideo f468904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f468905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<ExplainReplaySubTitle> f468906d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L14;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f468903a, r101.f468903a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f468904b, r101.f468904b) == true) goto L10;
        return false;
    L10:
        if (this.f468905c == r101.f468905c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f468906d, r101.f468906d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        ExplainPlaybackVideoInfo r100 = this.f468903a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECReplayVideo r104 = this.f468904b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f468905c) * 31;
        List<ExplainReplaySubTitle> r107 = this.f468906d;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "VideoInfoEntity(videoInfo=" + this.f468903a + ", videoInfoV2=" + this.f468904b + ", replayVideoStartTime=" + this.f468905c + ", subTitle=" + this.f468906d + ")";
    }

    public k(ExplainPlaybackVideoInfo r100, ECReplayVideo r101, int r102, List<ExplainReplaySubTitle> r103) {
        this.f468903a = r100;
        this.f468904b = r101;
        this.f468905c = r102;
        this.f468906d = r103;
    }
}
