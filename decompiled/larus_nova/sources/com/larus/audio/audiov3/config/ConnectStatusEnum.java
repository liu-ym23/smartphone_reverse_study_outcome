package com.larus.audio.audiov3.config;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/audio/audiov3/config/ConnectStatusEnum;", "", "<init>", "(Ljava/lang/String;I)V", "ENABLE", "DISABLE", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ConnectStatusEnum extends Enum<ConnectStatusEnum> {
    public static final ConnectStatusEnum DISABLE = null;
    public static final ConnectStatusEnum ENABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConnectStatusEnum[] f288510a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288511b = null;

    public static EnumEntries<ConnectStatusEnum> getEntries() {
        return f288511b;
    }

    static {
        ConnectStatusEnum r100 = new ConnectStatusEnum("ENABLE", 0);
        ENABLE = r100;
        ConnectStatusEnum r101 = new ConnectStatusEnum("DISABLE", 1);
        DISABLE = r101;
        ConnectStatusEnum[] r102 = {r100, r101};
        f288510a = r102;
        f288511b = EnumEntriesKt.enumEntries(r102);
    }

    public static ConnectStatusEnum[] values() {
        return (ConnectStatusEnum[]) f288510a.clone();
    }

    public static ConnectStatusEnum valueOf(String r100) {
        return (ConnectStatusEnum) a.a(ConnectStatusEnum.class, r100);
    }

    public ConnectStatusEnum(String r100, int r101) {
        super(r100, r101);
    }
}
