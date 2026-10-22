package com.larus.im.service.audio.vlm;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/im/service/audio/vlm/EncodedVideoFrameType;", "", "<init>", "(Ljava/lang/String;I)V", "KEY", "DELTA", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EncodedVideoFrameType extends Enum<EncodedVideoFrameType> {
    public static final EncodedVideoFrameType DELTA = null;
    public static final EncodedVideoFrameType KEY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EncodedVideoFrameType[] f350801a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350802b = null;

    public static EnumEntries<EncodedVideoFrameType> getEntries() {
        return f350802b;
    }

    static {
        EncodedVideoFrameType r100 = new EncodedVideoFrameType("KEY", 0);
        KEY = r100;
        EncodedVideoFrameType r101 = new EncodedVideoFrameType("DELTA", 1);
        DELTA = r101;
        EncodedVideoFrameType[] r102 = {r100, r101};
        f350801a = r102;
        f350802b = EnumEntriesKt.enumEntries(r102);
    }

    public static EncodedVideoFrameType[] values() {
        return (EncodedVideoFrameType[]) f350801a.clone();
    }

    public static EncodedVideoFrameType valueOf(String r100) {
        return (EncodedVideoFrameType) a.a(EncodedVideoFrameType.class, r100);
    }

    public EncodedVideoFrameType(String r100, int r101) {
        super(r100, r101);
    }
}
