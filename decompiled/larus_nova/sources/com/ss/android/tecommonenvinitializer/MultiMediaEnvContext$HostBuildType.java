package com.ss.android.tecommonenvinitializer;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/ss/android/tecommonenvinitializer/MultiMediaEnvContext$HostBuildType", "", "Lcom/ss/android/tecommonenvinitializer/MultiMediaEnvContext$HostBuildType;", "INTERNAL", "OFFICIAL", "tecommonenvinitializer_release"}, k = 1, mv = {1, 6, 0})
public final enum MultiMediaEnvContext$HostBuildType extends Enum<MultiMediaEnvContext$HostBuildType> {
    public static final MultiMediaEnvContext$HostBuildType INTERNAL = null;
    public static final MultiMediaEnvContext$HostBuildType OFFICIAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiMediaEnvContext$HostBuildType[] f449596a = null;

    public static MultiMediaEnvContext$HostBuildType valueOf(String r100) {
        return (MultiMediaEnvContext$HostBuildType) a.a(MultiMediaEnvContext$HostBuildType.class, r100);
    }

    public static MultiMediaEnvContext$HostBuildType[] values() {
        return (MultiMediaEnvContext$HostBuildType[]) f449596a.clone();
    }

    static {
        MultiMediaEnvContext$HostBuildType r100 = new MultiMediaEnvContext$HostBuildType("INTERNAL", 0);
        INTERNAL = r100;
        MultiMediaEnvContext$HostBuildType r101 = new MultiMediaEnvContext$HostBuildType("OFFICIAL", 1);
        OFFICIAL = r101;
        f449596a = new MultiMediaEnvContext$HostBuildType[]{r100, r101};
    }

    public MultiMediaEnvContext$HostBuildType(String r100, int r101) {
        super(r100, r101);
    }
}
