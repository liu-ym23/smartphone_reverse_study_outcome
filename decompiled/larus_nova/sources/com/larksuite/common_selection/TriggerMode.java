package com.larksuite.common_selection;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/common_selection/TriggerMode;", "", "<init>", "(Ljava/lang/String;I)V", "LongPress", "DoubleTap", "common-selection_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TriggerMode extends Enum<TriggerMode> {
    public static final TriggerMode DoubleTap = null;
    public static final TriggerMode LongPress = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TriggerMode[] f282863a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f282864b = null;

    public static EnumEntries<TriggerMode> getEntries() {
        return f282864b;
    }

    static {
        TriggerMode r100 = new TriggerMode("LongPress", 0);
        LongPress = r100;
        TriggerMode r101 = new TriggerMode("DoubleTap", 1);
        DoubleTap = r101;
        TriggerMode[] r102 = {r100, r101};
        f282863a = r102;
        f282864b = EnumEntriesKt.enumEntries(r102);
    }

    public static TriggerMode[] values() {
        return (TriggerMode[]) f282863a.clone();
    }

    public static TriggerMode valueOf(String r100) {
        return (TriggerMode) r27.a.a(TriggerMode.class, r100);
    }

    public TriggerMode(String r100, int r101) {
        super(r100, r101);
    }
}
