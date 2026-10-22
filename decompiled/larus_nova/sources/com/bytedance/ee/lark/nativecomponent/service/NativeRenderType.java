package com.bytedance.ee.lark.nativecomponent.service;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/lark/nativecomponent/service/NativeRenderType;", "", "<init>", "(Ljava/lang/String;I)V", "OVERLAY", "SANDWICH", "SANDWICH_EMBED", "EMBED", "native-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NativeRenderType extends Enum<NativeRenderType> {
    public static final NativeRenderType EMBED = null;
    public static final NativeRenderType OVERLAY = null;
    public static final NativeRenderType SANDWICH = null;
    public static final NativeRenderType SANDWICH_EMBED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NativeRenderType[] f242836a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f242837b = null;

    public static EnumEntries<NativeRenderType> getEntries() {
        return f242837b;
    }

    static {
        NativeRenderType r100 = new NativeRenderType("OVERLAY", 0);
        OVERLAY = r100;
        NativeRenderType r101 = new NativeRenderType("SANDWICH", 1);
        SANDWICH = r101;
        NativeRenderType r102 = new NativeRenderType("SANDWICH_EMBED", 2);
        SANDWICH_EMBED = r102;
        NativeRenderType r103 = new NativeRenderType("EMBED", 3);
        EMBED = r103;
        NativeRenderType[] r104 = {r100, r101, r102, r103};
        f242836a = r104;
        f242837b = EnumEntriesKt.enumEntries(r104);
    }

    public static NativeRenderType[] values() {
        return (NativeRenderType[]) f242836a.clone();
    }

    public static NativeRenderType valueOf(String r100) {
        return (NativeRenderType) a.a(NativeRenderType.class, r100);
    }

    public NativeRenderType(String r100, int r101) {
        super(r100, r101);
    }
}
