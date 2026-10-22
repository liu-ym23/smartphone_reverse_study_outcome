package com.larus.voicecall.impl.component.denoise;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/voicecall/impl/component/denoise/DenoiseStatusRes;", "", "value", "", SocialConstants.PARAM_APP_DESC, "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getValue", "()I", "getDesc", "()Ljava/lang/String;", "UNKNOWN", "LEARNING", "FEATURE_ENABLED", "FEATURE_DISABLED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DenoiseStatusRes extends Enum<DenoiseStatusRes> {
    public static final DenoiseStatusRes FEATURE_DISABLED = null;
    public static final DenoiseStatusRes FEATURE_ENABLED = null;
    public static final DenoiseStatusRes LEARNING = null;
    public static final DenoiseStatusRes UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DenoiseStatusRes[] f377356a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f377357b = null;
    private final String desc;
    private final int value;

    public static EnumEntries<DenoiseStatusRes> getEntries() {
        return f377357b;
    }

    static {
        DenoiseStatusRes r100 = new DenoiseStatusRes("UNKNOWN", 0, 0, "unknown");
        UNKNOWN = r100;
        DenoiseStatusRes r101 = new DenoiseStatusRes("LEARNING", 1, 1, "study");
        LEARNING = r101;
        DenoiseStatusRes r102 = new DenoiseStatusRes("FEATURE_ENABLED", 2, 2, "on");
        FEATURE_ENABLED = r102;
        DenoiseStatusRes r103 = new DenoiseStatusRes("FEATURE_DISABLED", 3, 3, "off");
        FEATURE_DISABLED = r103;
        DenoiseStatusRes[] r104 = {r100, r101, r102, r103};
        f377356a = r104;
        f377357b = EnumEntriesKt.enumEntries(r104);
    }

    public static DenoiseStatusRes[] values() {
        return (DenoiseStatusRes[]) f377356a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getValue() {
        return this.value;
    }

    public static DenoiseStatusRes valueOf(String r100) {
        return (DenoiseStatusRes) r27.a.a(DenoiseStatusRes.class, r100);
    }

    public DenoiseStatusRes(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.desc = r103;
    }
}
