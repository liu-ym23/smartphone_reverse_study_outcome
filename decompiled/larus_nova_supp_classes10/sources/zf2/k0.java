package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k0 {
    public final String a;
    public final String b;
    public final LiveWrappedStreamIndex c;

    public final String toString() {
        return "RemoteStreamKey{roomId='" + this.a + "', userId='" + this.b + "', streamIndex=" + this.c + '}';
    }

    public k0(String r2, String r3, LiveWrappedStreamIndex r4) {
        Intrinsics.checkNotNullParameter(r2, "roomID");
        Intrinsics.checkNotNullParameter(r3, "userID");
        Intrinsics.checkNotNullParameter(r4, "streamIndex");
        this.a = "";
        this.b = "";
        this.c = LiveWrappedStreamIndex.STREAM_INDEX_MAIN;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
