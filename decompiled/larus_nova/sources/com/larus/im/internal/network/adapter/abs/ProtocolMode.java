package com.larus.im.internal.network.adapter.abs;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/im/internal/network/adapter/abs/ProtocolMode;", "", "<init>", "(Ljava/lang/String;I)V", "JSON", "PROTO", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ProtocolMode extends Enum<ProtocolMode> {
    public static final ProtocolMode JSON = null;
    public static final ProtocolMode PROTO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProtocolMode[] f349020a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f349021b = null;

    public static EnumEntries<ProtocolMode> getEntries() {
        return f349021b;
    }

    static {
        ProtocolMode r100 = new ProtocolMode("JSON", 0);
        JSON = r100;
        ProtocolMode r101 = new ProtocolMode("PROTO", 1);
        PROTO = r101;
        ProtocolMode[] r102 = {r100, r101};
        f349020a = r102;
        f349021b = EnumEntriesKt.enumEntries(r102);
    }

    public static ProtocolMode[] values() {
        return (ProtocolMode[]) f349020a.clone();
    }

    public static ProtocolMode valueOf(String r100) {
        return (ProtocolMode) a.a(ProtocolMode.class, r100);
    }

    public ProtocolMode(String r100, int r101) {
        super(r100, r101);
    }
}
