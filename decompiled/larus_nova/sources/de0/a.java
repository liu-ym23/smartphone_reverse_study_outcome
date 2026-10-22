package de0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.fifa.core.IChannelLinkService$ICurrentUserLinkStatus$AudioCaptureState;
import com.bytedance.android.live.fifa.core.IChannelLinkService$ICurrentUserLinkStatus$AudioPublishState;
import com.bytedance.android.live.fifa.core.IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole;
import com.bytedance.android.live.fifa.core.IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f468040i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBaseUser f468041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f468042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole f468043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IChannelLinkService$ICurrentUserLinkStatus$AudioCaptureState f468044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IChannelLinkService$ICurrentUserLinkStatus$AudioPublishState f468045e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f468046f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f468047g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel f468048h;

    /* JADX INFO: renamed from: de0.a$a, reason: collision with other inner class name */
    public static final class C5659a {
    }

    static {
    }

    public final int hashCode() {
        return (((((((((((((this.f468041a.getIdString().hashCode() * 31) + this.f468042b.hashCode()) * 31) + this.f468043c.hashCode()) * 31) + this.f468044d.hashCode()) * 31) + this.f468045e.hashCode()) * 31) + this.f468046f) * 31) + this.f468047g) * 31) + this.f468048h.hashCode();
    }

    public final String toString() {
        return "ChannelCurrentUserLinkStatus(user=" + this.f468041a + ", rtcUserId=" + this.f468042b + ", rtcUserRole=" + this.f468043c + ", localAudioCaptureState=" + this.f468044d + ", localAudioPublishState=" + this.f468045e + ", linkStatus=" + this.f468046f + ", silenceStatus=" + this.f468047g + ", volumeLevel=" + this.f468048h + ")";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(a.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L39;
        a r102 = (a) r100;
        if ((!Intrinsics.areEqual(this.f468041a.getIdString(), r102.f468041a.getIdString())) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.f468042b, r102.f468042b)) == false) goto L20;
        return false;
    L20:
        if (this.f468043c == r102.f468043c) goto L23;
        return false;
    L23:
        if (this.f468044d == r102.f468044d) goto L26;
        return false;
    L26:
        if (this.f468045e == r102.f468045e) goto L29;
        return false;
    L29:
        if (this.f468046f == r102.f468046f) goto L32;
        return false;
    L32:
        if (this.f468047g == r102.f468047g) goto L35;
        return false;
    L35:
        if (this.f468048h == r102.f468048h) goto L37;
        return false;
    L37:
        return true;
    L39:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.channel.model.ChannelCurrentUserLinkStatus");
    L8:
        r101 = null;
        goto L10
    }

    public a(IBaseUser r100, IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole r101, IChannelLinkService$ICurrentUserLinkStatus$AudioCaptureState r102, IChannelLinkService$ICurrentUserLinkStatus$AudioPublishState r103, IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel r104) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter("", "rtcUserId");
        Intrinsics.checkNotNullParameter(r101, "rtcUserRole");
        Intrinsics.checkNotNullParameter(r102, "localAudioCaptureState");
        Intrinsics.checkNotNullParameter(r103, "localAudioPublishState");
        Intrinsics.checkNotNullParameter(r104, "volumeLevel");
        this.f468041a = r100;
        this.f468042b = "";
        this.f468043c = r101;
        this.f468044d = r102;
        this.f468045e = r103;
        this.f468046f = 0;
        this.f468047g = -1;
        this.f468048h = r104;
    }
}
