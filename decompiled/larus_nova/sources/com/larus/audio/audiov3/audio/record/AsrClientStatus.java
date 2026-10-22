package com.larus.audio.audiov3.audio.record;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/audio/audiov3/audio/record/AsrClientStatus;", "", "<init>", "(Ljava/lang/String;I)V", "STATE_IDLE", "STATE_TOUCH", "STATE_CANCEL", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AsrClientStatus extends Enum<AsrClientStatus> {
    public static final AsrClientStatus STATE_CANCEL = null;
    public static final AsrClientStatus STATE_IDLE = null;
    public static final AsrClientStatus STATE_TOUCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AsrClientStatus[] f288502a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288503b = null;

    public static EnumEntries<AsrClientStatus> getEntries() {
        return f288503b;
    }

    static {
        AsrClientStatus r100 = new AsrClientStatus("STATE_IDLE", 0);
        STATE_IDLE = r100;
        AsrClientStatus r101 = new AsrClientStatus("STATE_TOUCH", 1);
        STATE_TOUCH = r101;
        AsrClientStatus r102 = new AsrClientStatus("STATE_CANCEL", 2);
        STATE_CANCEL = r102;
        AsrClientStatus[] r103 = {r100, r101, r102};
        f288502a = r103;
        f288503b = EnumEntriesKt.enumEntries(r103);
    }

    public static AsrClientStatus[] values() {
        return (AsrClientStatus[]) f288502a.clone();
    }

    public static AsrClientStatus valueOf(String r100) {
        return (AsrClientStatus) a.a(AsrClientStatus.class, r100);
    }

    public AsrClientStatus(String r100, int r101) {
        super(r100, r101);
    }
}
