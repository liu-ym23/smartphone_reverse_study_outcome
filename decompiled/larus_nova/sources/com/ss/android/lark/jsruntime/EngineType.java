package com.ss.android.lark.jsruntime;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/jsruntime/EngineType;", "", "<init>", "(Ljava/lang/String;I)V", "VMSDK_QUICKJS", "VMSDK_V8", "AHA_V8", "jsruntime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EngineType extends Enum<EngineType> {
    public static final EngineType AHA_V8 = null;
    public static final EngineType VMSDK_QUICKJS = null;
    public static final EngineType VMSDK_V8 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EngineType[] f428154a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f428155b = null;

    public static EnumEntries<EngineType> getEntries() {
        return f428155b;
    }

    static {
        EngineType r100 = new EngineType("VMSDK_QUICKJS", 0);
        VMSDK_QUICKJS = r100;
        EngineType r101 = new EngineType("VMSDK_V8", 1);
        VMSDK_V8 = r101;
        EngineType r102 = new EngineType("AHA_V8", 2);
        AHA_V8 = r102;
        EngineType[] r103 = {r100, r101, r102};
        f428154a = r103;
        f428155b = EnumEntriesKt.enumEntries(r103);
    }

    public static EngineType[] values() {
        return (EngineType[]) f428154a.clone();
    }

    public static EngineType valueOf(String r100) {
        return (EngineType) a.a(EngineType.class, r100);
    }

    public EngineType(String r100, int r101) {
        super(r100, r101);
    }
}
