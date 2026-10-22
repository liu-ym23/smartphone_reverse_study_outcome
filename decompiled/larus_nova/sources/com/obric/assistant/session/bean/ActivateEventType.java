package com.obric.assistant.session.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/assistant/session/bean/ActivateEventType;", "", "<init>", "(Ljava/lang/String;I)V", "SinglePress", "DoublePress", "LongPress", "Other", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActivateEventType extends Enum<ActivateEventType> {
    public static final ActivateEventType DoublePress = null;
    public static final ActivateEventType LongPress = null;
    public static final ActivateEventType Other = null;
    public static final ActivateEventType SinglePress = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActivateEventType[] f391491a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f391492b = null;

    public static EnumEntries<ActivateEventType> getEntries() {
        return f391492b;
    }

    static {
        ActivateEventType r100 = new ActivateEventType("SinglePress", 0);
        SinglePress = r100;
        ActivateEventType r101 = new ActivateEventType("DoublePress", 1);
        DoublePress = r101;
        ActivateEventType r102 = new ActivateEventType("LongPress", 2);
        LongPress = r102;
        ActivateEventType r103 = new ActivateEventType("Other", 3);
        Other = r103;
        ActivateEventType[] r104 = {r100, r101, r102, r103};
        f391491a = r104;
        f391492b = EnumEntriesKt.enumEntries(r104);
    }

    public static ActivateEventType[] values() {
        return (ActivateEventType[]) f391491a.clone();
    }

    public static ActivateEventType valueOf(String r100) {
        return (ActivateEventType) a.a(ActivateEventType.class, r100);
    }

    public ActivateEventType(String r100, int r101) {
        super(r100, r101);
    }
}
