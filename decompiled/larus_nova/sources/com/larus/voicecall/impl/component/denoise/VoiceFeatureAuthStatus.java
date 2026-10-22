package com.larus.voicecall.impl.component.denoise;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/voicecall/impl/component/denoise/VoiceFeatureAuthStatus;", "", "value", "", SocialConstants.PARAM_APP_DESC, "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getValue", "()I", "getDesc", "()Ljava/lang/String;", "AUTHORIZED", "UNAUTHORIZED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceFeatureAuthStatus extends Enum<VoiceFeatureAuthStatus> {
    public static final VoiceFeatureAuthStatus AUTHORIZED = null;
    public static final VoiceFeatureAuthStatus UNAUTHORIZED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceFeatureAuthStatus[] f377377a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f377378b = null;
    private final String desc;
    private final int value;

    public static EnumEntries<VoiceFeatureAuthStatus> getEntries() {
        return f377378b;
    }

    static {
        VoiceFeatureAuthStatus r100 = new VoiceFeatureAuthStatus("AUTHORIZED", 0, 1, "AUTHORIZED");
        AUTHORIZED = r100;
        VoiceFeatureAuthStatus r101 = new VoiceFeatureAuthStatus("UNAUTHORIZED", 1, 2, "UNAUTHORIZED");
        UNAUTHORIZED = r101;
        VoiceFeatureAuthStatus[] r102 = {r100, r101};
        f377377a = r102;
        f377378b = EnumEntriesKt.enumEntries(r102);
    }

    public static VoiceFeatureAuthStatus[] values() {
        return (VoiceFeatureAuthStatus[]) f377377a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getValue() {
        return this.value;
    }

    public static VoiceFeatureAuthStatus valueOf(String r100) {
        return (VoiceFeatureAuthStatus) r27.a.a(VoiceFeatureAuthStatus.class, r100);
    }

    public VoiceFeatureAuthStatus(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.desc = r103;
    }
}
