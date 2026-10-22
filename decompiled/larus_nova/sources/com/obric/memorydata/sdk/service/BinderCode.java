package com.obric.memorydata.sdk.service;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/sdk/service/BinderCode;", "", "<init>", "(Ljava/lang/String;I)V", "REALTIME_CONTEXT", "MEMORY", "ASSISTANT_STATE", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum BinderCode extends Enum<BinderCode> {
    public static final BinderCode ASSISTANT_STATE = null;
    public static final a Companion = null;
    public static final BinderCode MEMORY = null;
    public static final BinderCode REALTIME_CONTEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BinderCode[] f397295a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f397296b = null;

    public static EnumEntries<BinderCode> getEntries() {
        return f397296b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.memorydata.sdk.service.BinderCode$a] */
    static {
        BinderCode r100 = new BinderCode("REALTIME_CONTEXT", 0);
        REALTIME_CONTEXT = r100;
        BinderCode r101 = new BinderCode("MEMORY", 1);
        MEMORY = r101;
        BinderCode r102 = new BinderCode("ASSISTANT_STATE", 2);
        ASSISTANT_STATE = r102;
        BinderCode[] r103 = {r100, r101, r102};
        f397295a = r103;
        f397296b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static BinderCode[] values() {
        return (BinderCode[]) f397295a.clone();
    }

    public static BinderCode valueOf(String r100) {
        return (BinderCode) r27.a.a(BinderCode.class, r100);
    }

    public BinderCode(String r100, int r101) {
        super(r100, r101);
    }
}
