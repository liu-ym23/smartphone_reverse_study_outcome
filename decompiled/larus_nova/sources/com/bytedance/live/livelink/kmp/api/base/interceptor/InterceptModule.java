package com.bytedance.live.livelink.kmp.api.base.interceptor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/base/interceptor/InterceptModule;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "INVALID", "ROOM_MANAGER", "SEI_MANAGER", "VIDEO_MANAGER", "STREAM_MIX", "CLIENT_STREAM_MIX", "SERVER_STREAM_MIX", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum InterceptModule extends Enum<InterceptModule> {
    public static final InterceptModule CLIENT_STREAM_MIX = null;
    public static final InterceptModule INVALID = null;
    public static final InterceptModule ROOM_MANAGER = null;
    public static final InterceptModule SEI_MANAGER = null;
    public static final InterceptModule SERVER_STREAM_MIX = null;
    public static final InterceptModule STREAM_MIX = null;
    public static final InterceptModule VIDEO_MANAGER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InterceptModule[] f255221a = null;
    private final String value;

    static {
        InterceptModule r100 = new InterceptModule("INVALID", 0, "invalid");
        INVALID = r100;
        InterceptModule r101 = new InterceptModule("ROOM_MANAGER", 1, "room_manager");
        ROOM_MANAGER = r101;
        InterceptModule r102 = new InterceptModule("SEI_MANAGER", 2, "sei_manager");
        SEI_MANAGER = r102;
        InterceptModule r103 = new InterceptModule("VIDEO_MANAGER", 3, "video_manager");
        VIDEO_MANAGER = r103;
        InterceptModule r104 = new InterceptModule("STREAM_MIX", 4, "stream_mix");
        STREAM_MIX = r104;
        InterceptModule r105 = new InterceptModule("CLIENT_STREAM_MIX", 5, "client_stream_mix");
        CLIENT_STREAM_MIX = r105;
        InterceptModule r106 = new InterceptModule("SERVER_STREAM_MIX", 6, "server_stream_mix");
        SERVER_STREAM_MIX = r106;
        f255221a = new InterceptModule[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static InterceptModule valueOf(String r100) {
        return (InterceptModule) a.a(InterceptModule.class, r100);
    }

    public static InterceptModule[] values() {
        return (InterceptModule[]) f255221a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public InterceptModule(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
