package com.larus.audio.call.mgr;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/audio/call/mgr/ReducerPosition;", "", "<init>", "(Ljava/lang/String;I)V", "APPEND", "PREPEND", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReducerPosition extends Enum<ReducerPosition> {
    public static final ReducerPosition APPEND = null;
    public static final ReducerPosition PREPEND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReducerPosition[] f289193a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f289194b = null;

    public static EnumEntries<ReducerPosition> getEntries() {
        return f289194b;
    }

    static {
        ReducerPosition r100 = new ReducerPosition("APPEND", 0);
        APPEND = r100;
        ReducerPosition r101 = new ReducerPosition("PREPEND", 1);
        PREPEND = r101;
        ReducerPosition[] r102 = {r100, r101};
        f289193a = r102;
        f289194b = EnumEntriesKt.enumEntries(r102);
    }

    public static ReducerPosition[] values() {
        return (ReducerPosition[]) f289193a.clone();
    }

    public static ReducerPosition valueOf(String r100) {
        return (ReducerPosition) r27.a.a(ReducerPosition.class, r100);
    }

    public ReducerPosition(String r100, int r101) {
        super(r100, r101);
    }
}
