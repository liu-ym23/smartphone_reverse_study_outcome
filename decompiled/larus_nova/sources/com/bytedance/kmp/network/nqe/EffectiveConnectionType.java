package com.bytedance.kmp.network.nqe;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/kmp/network/nqe/EffectiveConnectionType;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "FAKE_NETWORK", "UNKNOWN", "OFFLINE", "SLOW_2G", "GOOD_2G", "TYPE_3G", "POOR_4G", "FAIR_4G", "GOOD_4G", "EXCELLENT_4G", "network_service_release"}, k = 1, mv = {1, 7, 0})
public final enum EffectiveConnectionType extends Enum<EffectiveConnectionType> {
    public static final a Companion = null;
    public static final EffectiveConnectionType EXCELLENT_4G = null;
    public static final EffectiveConnectionType FAIR_4G = null;
    public static final EffectiveConnectionType FAKE_NETWORK = null;
    public static final EffectiveConnectionType GOOD_2G = null;
    public static final EffectiveConnectionType GOOD_4G = null;
    public static final EffectiveConnectionType OFFLINE = null;
    public static final EffectiveConnectionType POOR_4G = null;
    public static final EffectiveConnectionType SLOW_2G = null;
    public static final EffectiveConnectionType TYPE_3G = null;
    public static final EffectiveConnectionType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EffectiveConnectionType[] f252535a = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EffectiveConnectionType valueOf(String r100) {
        return (EffectiveConnectionType) r27.a.a(EffectiveConnectionType.class, r100);
    }

    public static EffectiveConnectionType[] values() {
        return (EffectiveConnectionType[]) f252535a.clone();
    }

    static {
        EffectiveConnectionType r100 = new EffectiveConnectionType("FAKE_NETWORK", 0, -1);
        FAKE_NETWORK = r100;
        EffectiveConnectionType r101 = new EffectiveConnectionType("UNKNOWN", 1, 0);
        UNKNOWN = r101;
        EffectiveConnectionType r102 = new EffectiveConnectionType("OFFLINE", 2, 1);
        OFFLINE = r102;
        EffectiveConnectionType r103 = new EffectiveConnectionType("SLOW_2G", 3, 2);
        SLOW_2G = r103;
        EffectiveConnectionType r104 = new EffectiveConnectionType("GOOD_2G", 4, 3);
        GOOD_2G = r104;
        EffectiveConnectionType r105 = new EffectiveConnectionType("TYPE_3G", 5, 4);
        TYPE_3G = r105;
        EffectiveConnectionType r110 = new EffectiveConnectionType("POOR_4G", 6, 5);
        POOR_4G = r110;
        EffectiveConnectionType r111 = new EffectiveConnectionType("FAIR_4G", 7, 6);
        FAIR_4G = r111;
        EffectiveConnectionType r112 = new EffectiveConnectionType("GOOD_4G", 8, 7);
        GOOD_4G = r112;
        EffectiveConnectionType r113 = new EffectiveConnectionType("EXCELLENT_4G", 9, 8);
        EXCELLENT_4G = r113;
        f252535a = new EffectiveConnectionType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        Companion = new a();
    }

    public final int getValue() {
        return this.value;
    }

    public EffectiveConnectionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
