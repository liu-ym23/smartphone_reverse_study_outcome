package com.larus.bmhome.chat.layout.item;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/CompositeBoxType;", "", "<init>", "(Ljava/lang/String;I)V", "CompositeTopBox", "CompositeMiddleBox", "CompositeBottomBox", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CompositeBoxType extends Enum<CompositeBoxType> {
    public static final CompositeBoxType CompositeBottomBox = null;
    public static final CompositeBoxType CompositeMiddleBox = null;
    public static final CompositeBoxType CompositeTopBox = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CompositeBoxType[] f304090a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f304091b = null;

    public static EnumEntries<CompositeBoxType> getEntries() {
        return f304091b;
    }

    static {
        CompositeBoxType r100 = new CompositeBoxType("CompositeTopBox", 0);
        CompositeTopBox = r100;
        CompositeBoxType r101 = new CompositeBoxType("CompositeMiddleBox", 1);
        CompositeMiddleBox = r101;
        CompositeBoxType r102 = new CompositeBoxType("CompositeBottomBox", 2);
        CompositeBottomBox = r102;
        CompositeBoxType[] r103 = {r100, r101, r102};
        f304090a = r103;
        f304091b = EnumEntriesKt.enumEntries(r103);
    }

    public static CompositeBoxType[] values() {
        return (CompositeBoxType[]) f304090a.clone();
    }

    public static CompositeBoxType valueOf(String r100) {
        return (CompositeBoxType) r27.a.a(CompositeBoxType.class, r100);
    }

    public CompositeBoxType(String r100, int r101) {
        super(r100, r101);
    }
}
