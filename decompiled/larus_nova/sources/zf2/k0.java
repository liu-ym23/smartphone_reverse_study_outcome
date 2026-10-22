package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f571727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveWrappedStreamIndex f571728c;

    public final String toString() {
        return "RemoteStreamKey{roomId='" + this.f571726a + "', userId='" + this.f571727b + "', streamIndex=" + this.f571728c + '}';
    }

    public k0(String r100, String r101, LiveWrappedStreamIndex r102) {
        Intrinsics.checkNotNullParameter(r100, "roomID");
        Intrinsics.checkNotNullParameter(r101, "userID");
        Intrinsics.checkNotNullParameter(r102, "streamIndex");
        this.f571726a = "";
        this.f571727b = "";
        this.f571728c = LiveWrappedStreamIndex.STREAM_INDEX_MAIN;
        this.f571726a = r100;
        this.f571727b = r101;
        this.f571728c = r102;
    }
}
