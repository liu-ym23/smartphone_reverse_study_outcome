package com.larus.dora.api;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/api/LightEffectBrightness;", "", "protocolValue", "", "<init>", "(Ljava/lang/String;II)V", "getProtocolValue", "()I", "LOW", EffectConstants.NORMAL, "HIGH", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LightEffectBrightness extends Enum<LightEffectBrightness> {
    public static final LightEffectBrightness HIGH = null;
    public static final LightEffectBrightness LOW = null;
    public static final LightEffectBrightness NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LightEffectBrightness[] f331728a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f331729b = null;
    private final int protocolValue;

    public static EnumEntries<LightEffectBrightness> getEntries() {
        return f331729b;
    }

    static {
        LightEffectBrightness r100 = new LightEffectBrightness("LOW", 0, 1);
        LOW = r100;
        LightEffectBrightness r101 = new LightEffectBrightness(EffectConstants.NORMAL, 1, 2);
        NORMAL = r101;
        LightEffectBrightness r102 = new LightEffectBrightness("HIGH", 2, 3);
        HIGH = r102;
        LightEffectBrightness[] r103 = {r100, r101, r102};
        f331728a = r103;
        f331729b = EnumEntriesKt.enumEntries(r103);
    }

    public static LightEffectBrightness[] values() {
        return (LightEffectBrightness[]) f331728a.clone();
    }

    public final int getProtocolValue() {
        return this.protocolValue;
    }

    public static LightEffectBrightness valueOf(String r100) {
        return (LightEffectBrightness) a.a(LightEffectBrightness.class, r100);
    }

    public LightEffectBrightness(String r100, int r101, int r102) {
        super(r100, r101);
        this.protocolValue = r102;
    }
}
