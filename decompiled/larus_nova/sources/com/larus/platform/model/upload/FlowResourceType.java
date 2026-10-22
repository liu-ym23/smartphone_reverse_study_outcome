package com.larus.platform.model.upload;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0010"}, d2 = {"Lcom/larus/platform/model/upload/FlowResourceType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", SpeechEngineDefines.RECORDER_TYPE_FILE, "Image", ServiceType.AUDIO, "Video", "URL", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowResourceType extends Enum<FlowResourceType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ FlowResourceType[] $VALUES = null;
    public static final FlowResourceType Audio = null;
    public static final FlowResourceType File = null;
    public static final FlowResourceType Image = null;
    public static final FlowResourceType URL = null;
    public static final FlowResourceType Unknown = null;
    public static final FlowResourceType Video = null;
    private final int value;

    private static final /* synthetic */ FlowResourceType[] $values() {
        return new FlowResourceType[]{Unknown, File, Image, Audio, Video, URL};
    }

    public static EnumEntries<FlowResourceType> getEntries() {
        return $ENTRIES;
    }

    static {
        Unknown = new FlowResourceType("Unknown", 0, 0);
        File = new FlowResourceType(SpeechEngineDefines.RECORDER_TYPE_FILE, 1, 1);
        Image = new FlowResourceType("Image", 2, 2);
        Audio = new FlowResourceType(ServiceType.AUDIO, 3, 3);
        Video = new FlowResourceType("Video", 4, 4);
        URL = new FlowResourceType("URL", 5, 5);
        FlowResourceType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static FlowResourceType[] values() {
        return (FlowResourceType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return super.toString() + '(' + this.value + ')';
    }

    public final int getValue() {
        return this.value;
    }

    public static FlowResourceType valueOf(String r100) {
        return (FlowResourceType) a.a(FlowResourceType.class, r100);
    }

    private FlowResourceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
