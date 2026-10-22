package com.larus.audio.call.play.abs;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/audio/call/play/abs/TtsPlayEndType;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "TIMEOUT", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TtsPlayEndType extends Enum<TtsPlayEndType> {
    public static final TtsPlayEndType NORMAL = null;
    public static final TtsPlayEndType TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TtsPlayEndType[] f289293a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f289294b = null;

    public static EnumEntries<TtsPlayEndType> getEntries() {
        return f289294b;
    }

    static {
        TtsPlayEndType r100 = new TtsPlayEndType(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        TtsPlayEndType r101 = new TtsPlayEndType("TIMEOUT", 1);
        TIMEOUT = r101;
        TtsPlayEndType[] r102 = {r100, r101};
        f289293a = r102;
        f289294b = EnumEntriesKt.enumEntries(r102);
    }

    public static TtsPlayEndType[] values() {
        return (TtsPlayEndType[]) f289293a.clone();
    }

    public static TtsPlayEndType valueOf(String r100) {
        return (TtsPlayEndType) a.a(TtsPlayEndType.class, r100);
    }

    public TtsPlayEndType(String r100, int r101) {
        super(r100, r101);
    }
}
