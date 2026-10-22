package com.obric.assistant.spi.audio;

import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/spi/audio/CallType;", "", "<init>", "(Ljava/lang/String;I)V", ServiceType.AUDIO, "Video", "ScreenShare", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CallType extends Enum<CallType> {
    public static final CallType Audio = null;
    public static final CallType ScreenShare = null;
    public static final CallType Video = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CallType[] f392828a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f392829b = null;

    public static EnumEntries<CallType> getEntries() {
        return f392829b;
    }

    static {
        CallType r100 = new CallType(ServiceType.AUDIO, 0);
        Audio = r100;
        CallType r101 = new CallType("Video", 1);
        Video = r101;
        CallType r102 = new CallType("ScreenShare", 2);
        ScreenShare = r102;
        CallType[] r103 = {r100, r101, r102};
        f392828a = r103;
        f392829b = EnumEntriesKt.enumEntries(r103);
    }

    public static CallType[] values() {
        return (CallType[]) f392828a.clone();
    }

    public static CallType valueOf(String r100) {
        return (CallType) r27.a.a(CallType.class, r100);
    }

    public CallType(String r100, int r101) {
        super(r100, r101);
    }
}
