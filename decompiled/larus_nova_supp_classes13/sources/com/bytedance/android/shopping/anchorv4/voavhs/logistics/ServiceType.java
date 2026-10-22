package com.bytedance.android.shopping.anchorv4.voavhs.logistics;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/ServiceType;", "", "", "value", "I", "getValue", "()I", "GUARANTEE", "ACTIVITY", "LOGISTICS", "CHOOSE_PANEL", "SPEC_INFO", "CAR_MODEL", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ServiceType extends Enum<ServiceType> {
    public static final ServiceType ACTIVITY = null;
    public static final ServiceType CAR_MODEL = null;
    public static final ServiceType CHOOSE_PANEL = null;
    public static final ServiceType GUARANTEE = null;
    public static final ServiceType LOGISTICS = null;
    public static final ServiceType SPEC_INFO = null;
    public static final /* synthetic */ ServiceType[] a = null;
    private final int value;

    static {
        ServiceType r1 = new ServiceType("GUARANTEE", 0, 0);
        GUARANTEE = r1;
        ServiceType r2 = new ServiceType("ACTIVITY", 1, 1);
        ACTIVITY = r2;
        ServiceType r3 = new ServiceType("LOGISTICS", 2, 2);
        LOGISTICS = r3;
        ServiceType r4 = new ServiceType("CHOOSE_PANEL", 3, 3);
        CHOOSE_PANEL = r4;
        ServiceType r5 = new ServiceType("SPEC_INFO", 4, 4);
        SPEC_INFO = r5;
        ServiceType r6 = new ServiceType("CAR_MODEL", 5, 5);
        CAR_MODEL = r6;
        a = new ServiceType[]{r1, r2, r3, r4, r5, r6};
    }

    public static ServiceType valueOf(String r1) {
        return (ServiceType) r27.a.a(ServiceType.class, r1);
    }

    public static ServiceType[] values() {
        return (ServiceType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ServiceType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
