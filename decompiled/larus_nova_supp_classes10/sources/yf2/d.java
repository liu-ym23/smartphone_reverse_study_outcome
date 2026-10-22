package yf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRoomProfile;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d {
    public final LiveWrappedRoomProfile a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    public final String toString() {
        return "RTCRoomConfig{profile=" + this.a + ", isPublishAudio=" + this.b + ", isPublishVideo=" + this.c + ", isAutoSubscribeAudio=" + this.d + ", isAutoSubscribeVideo=" + this.e + '}';
    }

    public d(LiveWrappedRoomProfile r2, boolean r3, boolean r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "channelProfile");
        this.a = LiveWrappedRoomProfile.COMMUNICATION;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
