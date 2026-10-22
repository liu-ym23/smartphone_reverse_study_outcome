package com.bytedance.flow_audio.api.foundation.record;

import com.ss.ttvideoengine.model.SubInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/flow_audio/api/foundation/record/FlowAsrAudioEncoding;", "", SubInfo.KEY_FORMAT, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getFormat", "()Ljava/lang/String;", "PCM", "OPUS", "Companion", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowAsrAudioEncoding extends Enum<FlowAsrAudioEncoding> {
    public static final a Companion = null;
    public static final FlowAsrAudioEncoding OPUS = null;
    public static final FlowAsrAudioEncoding PCM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowAsrAudioEncoding[] f243710a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243711b = null;
    private final String format;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<FlowAsrAudioEncoding> getEntries() {
        return f243711b;
    }

    static {
        FlowAsrAudioEncoding r100 = new FlowAsrAudioEncoding("PCM", 0, "pcm");
        PCM = r100;
        FlowAsrAudioEncoding r101 = new FlowAsrAudioEncoding("OPUS", 1, "opus");
        OPUS = r101;
        FlowAsrAudioEncoding[] r102 = {r100, r101};
        f243710a = r102;
        f243711b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static FlowAsrAudioEncoding[] values() {
        return (FlowAsrAudioEncoding[]) f243710a.clone();
    }

    public final String getFormat() {
        return this.format;
    }

    public static FlowAsrAudioEncoding valueOf(String r100) {
        return (FlowAsrAudioEncoding) r27.a.a(FlowAsrAudioEncoding.class, r100);
    }

    public FlowAsrAudioEncoding(String r100, int r101, String r102) {
        super(r100, r101);
        this.format = r102;
    }
}
