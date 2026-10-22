package com.larus.account.base.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/account/base/model/PhoneLoginAccountDiscoverySource;", "", "<init>", "(Ljava/lang/String;I)V", "VERIFICATION_CODE", "CARRIER_ONE_KEY", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PhoneLoginAccountDiscoverySource extends Enum<PhoneLoginAccountDiscoverySource> {
    public static final PhoneLoginAccountDiscoverySource CARRIER_ONE_KEY = null;
    public static final PhoneLoginAccountDiscoverySource VERIFICATION_CODE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PhoneLoginAccountDiscoverySource[] f286205a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f286206b = null;

    public static EnumEntries<PhoneLoginAccountDiscoverySource> getEntries() {
        return f286206b;
    }

    static {
        PhoneLoginAccountDiscoverySource r100 = new PhoneLoginAccountDiscoverySource("VERIFICATION_CODE", 0);
        VERIFICATION_CODE = r100;
        PhoneLoginAccountDiscoverySource r101 = new PhoneLoginAccountDiscoverySource("CARRIER_ONE_KEY", 1);
        CARRIER_ONE_KEY = r101;
        PhoneLoginAccountDiscoverySource[] r102 = {r100, r101};
        f286205a = r102;
        f286206b = EnumEntriesKt.enumEntries(r102);
    }

    public static PhoneLoginAccountDiscoverySource[] values() {
        return (PhoneLoginAccountDiscoverySource[]) f286205a.clone();
    }

    public static PhoneLoginAccountDiscoverySource valueOf(String r100) {
        return (PhoneLoginAccountDiscoverySource) a.a(PhoneLoginAccountDiscoverySource.class, r100);
    }

    public PhoneLoginAccountDiscoverySource(String r100, int r101) {
        super(r100, r101);
    }
}
