package com.bytedance.flow_audio.api.business.tts.config;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/flow_audio/api/business/tts/config/FlowAudioTtsStreamType;", "", "<init>", "(Ljava/lang/String;I)V", GXAnimation.STATE_START, "APPEND", GXAnimation.STATE_END, "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowAudioTtsStreamType extends Enum<FlowAudioTtsStreamType> {
    public static final FlowAudioTtsStreamType APPEND = null;
    public static final FlowAudioTtsStreamType END = null;
    public static final FlowAudioTtsStreamType START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowAudioTtsStreamType[] f243687a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243688b = null;

    public static EnumEntries<FlowAudioTtsStreamType> getEntries() {
        return f243688b;
    }

    static {
        FlowAudioTtsStreamType r100 = new FlowAudioTtsStreamType(GXAnimation.STATE_START, 0);
        START = r100;
        FlowAudioTtsStreamType r101 = new FlowAudioTtsStreamType("APPEND", 1);
        APPEND = r101;
        FlowAudioTtsStreamType r102 = new FlowAudioTtsStreamType(GXAnimation.STATE_END, 2);
        END = r102;
        FlowAudioTtsStreamType[] r103 = {r100, r101, r102};
        f243687a = r103;
        f243688b = EnumEntriesKt.enumEntries(r103);
    }

    public static FlowAudioTtsStreamType[] values() {
        return (FlowAudioTtsStreamType[]) f243687a.clone();
    }

    public static FlowAudioTtsStreamType valueOf(String r100) {
        return (FlowAudioTtsStreamType) a.a(FlowAudioTtsStreamType.class, r100);
    }

    public FlowAudioTtsStreamType(String r100, int r101) {
        super(r100, r101);
    }
}
