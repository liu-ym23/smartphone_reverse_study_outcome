package com.larus.im.internal.jni.media;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/im/internal/jni/media/OmniAudioFormatType;", "", "<init>", "(Ljava/lang/String;I)V", "PCM_FORMAT_INT16", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OmniAudioFormatType extends Enum<OmniAudioFormatType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniAudioFormatType[] $VALUES = null;
    public static final OmniAudioFormatType PCM_FORMAT_INT16 = null;

    private static final /* synthetic */ OmniAudioFormatType[] $values() {
        return new OmniAudioFormatType[]{PCM_FORMAT_INT16};
    }

    public static EnumEntries<OmniAudioFormatType> getEntries() {
        return $ENTRIES;
    }

    static {
        PCM_FORMAT_INT16 = new OmniAudioFormatType("PCM_FORMAT_INT16", 0);
        OmniAudioFormatType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static OmniAudioFormatType[] values() {
        return (OmniAudioFormatType[]) $VALUES.clone();
    }

    public static OmniAudioFormatType valueOf(String r100) {
        return (OmniAudioFormatType) a.a(OmniAudioFormatType.class, r100);
    }

    private OmniAudioFormatType(String r100, int r101) {
        super(r100, r101);
    }
}
