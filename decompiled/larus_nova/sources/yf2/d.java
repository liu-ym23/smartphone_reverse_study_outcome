package yf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRoomProfile;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveWrappedRoomProfile f567430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f567431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f567432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f567433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f567434e;

    public final String toString() {
        return "RTCRoomConfig{profile=" + this.f567430a + ", isPublishAudio=" + this.f567431b + ", isPublishVideo=" + this.f567432c + ", isAutoSubscribeAudio=" + this.f567433d + ", isAutoSubscribeVideo=" + this.f567434e + '}';
    }

    public d(LiveWrappedRoomProfile r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "channelProfile");
        this.f567430a = LiveWrappedRoomProfile.COMMUNICATION;
        this.f567430a = r100;
        this.f567431b = r101;
        this.f567432c = r102;
        this.f567433d = r103;
        this.f567434e = r104;
    }
}
