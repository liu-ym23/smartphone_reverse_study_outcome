package com.bytedance.kmp.live.livelink.api.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0087\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/kmp/live/livelink/api/model/VideoShowMode;", "", "", "type", "I", "getType", "()I", "source", "getSource", "setSource", "(I)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "VIDEO", "AUDIO", "DIGIT_AVATAR", "multi-link-service-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum VideoShowMode extends Enum<VideoShowMode> {
    public static final VideoShowMode AUDIO = null;
    public static final a Companion = null;
    public static final VideoShowMode DIGIT_AVATAR = null;
    public static final VideoShowMode VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoShowMode[] f252202a = null;
    private int source;
    private final int type;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.kmp.live.livelink.api.model.VideoShowMode$a] */
    static {
        VideoShowMode r100 = new VideoShowMode("VIDEO", 0, 1, 0, 2, null);
        VIDEO = r100;
        VideoShowMode r101 = new VideoShowMode("AUDIO", 1, 2, 0, 2, null);
        AUDIO = r101;
        VideoShowMode r102 = new VideoShowMode("DIGIT_AVATAR", 2, 3, 0, 2, null);
        DIGIT_AVATAR = r102;
        f252202a = new VideoShowMode[]{r100, r101, r102};
        Companion = new a();
    }

    public VideoShowMode() {
        throw null;
    }

    public static VideoShowMode valueOf(String r100) {
        return (VideoShowMode) r27.a.a(VideoShowMode.class, r100);
    }

    public static VideoShowMode[] values() {
        return (VideoShowMode[]) f252202a.clone();
    }

    public final int getSource() {
        return this.source;
    }

    public final int getType() {
        return this.type;
    }

    public final void setSource(int r100) {
        this.source = r100;
    }

    public VideoShowMode(String r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = 0;
    L5:
        super(r100, r101);
        this.type = r102;
        this.source = r103;
    }
}
