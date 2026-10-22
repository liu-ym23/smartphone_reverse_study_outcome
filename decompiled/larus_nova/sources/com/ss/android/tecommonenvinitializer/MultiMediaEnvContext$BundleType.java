package com.ss.android.tecommonenvinitializer;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/ss/android/tecommonenvinitializer/MultiMediaEnvContext$BundleType", "", "Lcom/ss/android/tecommonenvinitializer/MultiMediaEnvContext$BundleType;", "INTEGRATION", "PLUGIN", "tecommonenvinitializer_release"}, k = 1, mv = {1, 6, 0})
public final enum MultiMediaEnvContext$BundleType extends Enum<MultiMediaEnvContext$BundleType> {
    public static final MultiMediaEnvContext$BundleType INTEGRATION = null;
    public static final MultiMediaEnvContext$BundleType PLUGIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiMediaEnvContext$BundleType[] f449595a = null;

    public static MultiMediaEnvContext$BundleType valueOf(String r100) {
        return (MultiMediaEnvContext$BundleType) a.a(MultiMediaEnvContext$BundleType.class, r100);
    }

    public static MultiMediaEnvContext$BundleType[] values() {
        return (MultiMediaEnvContext$BundleType[]) f449595a.clone();
    }

    static {
        MultiMediaEnvContext$BundleType r100 = new MultiMediaEnvContext$BundleType("INTEGRATION", 0);
        INTEGRATION = r100;
        MultiMediaEnvContext$BundleType r101 = new MultiMediaEnvContext$BundleType("PLUGIN", 1);
        PLUGIN = r101;
        f449595a = new MultiMediaEnvContext$BundleType[]{r100, r101};
    }

    public MultiMediaEnvContext$BundleType(String r100, int r101) {
        super(r100, r101);
    }
}
