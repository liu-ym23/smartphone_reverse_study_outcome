package com.bytedance.awemeopen.infra.base.player;

import com.google.gson.JsonElement;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<i> f198759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f198760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f198761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f198762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f198763e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f198764f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<? extends JsonElement> f198765g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f198766h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f198767i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f198768j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f198769k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f198770l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map<String, String> f198771m;

    public final String toString() {
        return "PlayRequest(playItems=" + this.f198759a + ", isUseSuperResolution=" + this.f198760b + ", startPlayPosition=" + this.f198761c + ", videoDuration=" + this.f198762d + ", playId='" + this.f198763e + "', isAudio=" + this.f198764f + ", videoThumbs=" + this.f198765g + ", urlExpireTime=" + this.f198766h + ", audioSystemStream=" + this.f198767i + ", volumeLoudMeta=" + this.f198768j + ", playbackSpeed=" + this.f198769k + ", resetRenderTarget=false, isMute=false, isLoop=" + this.f198770l + ')';
    }

    public j(List<i> r100) {
        this.f198759a = r100;
        this.f198760b = true;
        this.f198763e = hashCode() + "";
        this.f198767i = -1;
        this.f198769k = 1.0f;
        this.f198770l = true;
    }
}
