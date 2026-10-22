package com.larus.im.internal.jni.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/model/OmniAVUnsupportedReason;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "NativeUnavailable", "PlatformUnsupported", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OmniAVUnsupportedReason extends Enum<OmniAVUnsupportedReason> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniAVUnsupportedReason[] $VALUES = null;
    public static final OmniAVUnsupportedReason NativeUnavailable = null;
    public static final OmniAVUnsupportedReason PlatformUnsupported = null;
    private final int code;

    private static final /* synthetic */ OmniAVUnsupportedReason[] $values() {
        return new OmniAVUnsupportedReason[]{NativeUnavailable, PlatformUnsupported};
    }

    public static EnumEntries<OmniAVUnsupportedReason> getEntries() {
        return $ENTRIES;
    }

    static {
        NativeUnavailable = new OmniAVUnsupportedReason("NativeUnavailable", 0, -1);
        PlatformUnsupported = new OmniAVUnsupportedReason("PlatformUnsupported", 1, -10001);
        OmniAVUnsupportedReason[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static OmniAVUnsupportedReason[] values() {
        return (OmniAVUnsupportedReason[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public static OmniAVUnsupportedReason valueOf(String r100) {
        return (OmniAVUnsupportedReason) a.a(OmniAVUnsupportedReason.class, r100);
    }

    private OmniAVUnsupportedReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
