package com.obric.capabilitykit.entity.memory;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/MemoryServiceStatus;", "", "", "code", "I", "getCode", "()I", "AVAILABLE", "UNAVAILABLE", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
public final enum MemoryServiceStatus extends Enum<MemoryServiceStatus> {
    public static final MemoryServiceStatus AVAILABLE = null;
    public static final MemoryServiceStatus UNAVAILABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MemoryServiceStatus[] f396252a = null;
    private final int code;

    static {
        MemoryServiceStatus r100 = new MemoryServiceStatus("AVAILABLE", 0, 0);
        AVAILABLE = r100;
        MemoryServiceStatus r101 = new MemoryServiceStatus("UNAVAILABLE", 1, 1);
        UNAVAILABLE = r101;
        f396252a = new MemoryServiceStatus[]{r100, r101};
    }

    public MemoryServiceStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }

    public static MemoryServiceStatus valueOf(String r100) {
        return (MemoryServiceStatus) a.a(MemoryServiceStatus.class, r100);
    }

    public static MemoryServiceStatus[] values() {
        return (MemoryServiceStatus[]) f396252a.clone();
    }

    public final int getCode() {
        return this.code;
    }
}
