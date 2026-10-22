package com.larus.bmhome.chat.nestedmenu;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/nestedmenu/NestedMenuPopupStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "ALIGN_TOP", "DROP_DOWN", "AUTO_DROP_DOWN_OR_ALIGN_TOP", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NestedMenuPopupStrategy extends Enum<NestedMenuPopupStrategy> {
    public static final NestedMenuPopupStrategy ALIGN_TOP = null;
    public static final NestedMenuPopupStrategy AUTO_DROP_DOWN_OR_ALIGN_TOP = null;
    public static final NestedMenuPopupStrategy DROP_DOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NestedMenuPopupStrategy[] f308216a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f308217b = null;

    public static EnumEntries<NestedMenuPopupStrategy> getEntries() {
        return f308217b;
    }

    static {
        NestedMenuPopupStrategy r100 = new NestedMenuPopupStrategy("ALIGN_TOP", 0);
        ALIGN_TOP = r100;
        NestedMenuPopupStrategy r101 = new NestedMenuPopupStrategy("DROP_DOWN", 1);
        DROP_DOWN = r101;
        NestedMenuPopupStrategy r102 = new NestedMenuPopupStrategy("AUTO_DROP_DOWN_OR_ALIGN_TOP", 2);
        AUTO_DROP_DOWN_OR_ALIGN_TOP = r102;
        NestedMenuPopupStrategy[] r103 = {r100, r101, r102};
        f308216a = r103;
        f308217b = EnumEntriesKt.enumEntries(r103);
    }

    public static NestedMenuPopupStrategy[] values() {
        return (NestedMenuPopupStrategy[]) f308216a.clone();
    }

    public static NestedMenuPopupStrategy valueOf(String r100) {
        return (NestedMenuPopupStrategy) r27.a.a(NestedMenuPopupStrategy.class, r100);
    }

    public NestedMenuPopupStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
