package com.bytedance.live.livelink.kmp.api.core.mixer;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/core/mixer/MixStreamType;", "", "", "toString", "", "value", "I", "getValue", "()I", "nameStr", "Ljava/lang/String;", UserProfileEvent.POSITION_NONE, "SERVER_MIX", "CLIENT_MIX", "RTC_CLIENT_MIX", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MixStreamType extends Enum<MixStreamType> {
    public static final MixStreamType CLIENT_MIX = null;
    public static final MixStreamType NONE = null;
    public static final MixStreamType RTC_CLIENT_MIX = null;
    public static final MixStreamType SERVER_MIX = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MixStreamType[] f255234a = null;
    private final String nameStr;
    private final int value;

    static {
        MixStreamType r100 = new MixStreamType(UserProfileEvent.POSITION_NONE, 0, 0, "none");
        NONE = r100;
        MixStreamType r101 = new MixStreamType("SERVER_MIX", 1, 1, BenefitStore.FROM_SERVER);
        SERVER_MIX = r101;
        MixStreamType r102 = new MixStreamType("CLIENT_MIX", 2, 2, "client");
        CLIENT_MIX = r102;
        MixStreamType r103 = new MixStreamType("RTC_CLIENT_MIX", 3, 3, "rtc_client");
        RTC_CLIENT_MIX = r103;
        f255234a = new MixStreamType[]{r100, r101, r102, r103};
    }

    public static MixStreamType valueOf(String r100) {
        return (MixStreamType) a.a(MixStreamType.class, r100);
    }

    public static MixStreamType[] values() {
        return (MixStreamType[]) f255234a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.nameStr;
    }

    public MixStreamType(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.nameStr = r103;
    }
}
