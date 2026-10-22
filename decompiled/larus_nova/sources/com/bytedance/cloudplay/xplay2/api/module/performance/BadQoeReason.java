package com.bytedance.cloudplay.xplay2.api.module.performance;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/cloudplay/xplay2/api/module/performance/BadQoeReason;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UNKNOWN", "NETWORK_BAD", "HARDWARE_INSUFFICIENT", "xplay2-api_release"}, k = 1, mv = {1, 8, 0})
public final enum BadQoeReason extends Enum<BadQoeReason> {
    public static final a Companion = null;
    public static final BadQoeReason HARDWARE_INSUFFICIENT = null;
    public static final BadQoeReason NETWORK_BAD = null;
    public static final BadQoeReason UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BadQoeReason[] f202798a = null;
    private final int value;

    public static BadQoeReason valueOf(String r100) {
        return (BadQoeReason) r27.a.a(BadQoeReason.class, r100);
    }

    public static BadQoeReason[] values() {
        return (BadQoeReason[]) f202798a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.cloudplay.xplay2.api.module.performance.BadQoeReason$a] */
    static {
        BadQoeReason r100 = new BadQoeReason("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        BadQoeReason r101 = new BadQoeReason("NETWORK_BAD", 1, 1);
        NETWORK_BAD = r101;
        BadQoeReason r102 = new BadQoeReason("HARDWARE_INSUFFICIENT", 2, 2);
        HARDWARE_INSUFFICIENT = r102;
        f202798a = new BadQoeReason[]{r100, r101, r102};
        Companion = new a();
    }

    public final int getValue() {
        return this.value;
    }

    public BadQoeReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
