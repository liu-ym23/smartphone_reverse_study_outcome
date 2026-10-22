package com.larksuite.component.universe_design.checkbox.compose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/universe_design/checkbox/compose/UDCheckBoxSize;", "", "<init>", "(Ljava/lang/String;I)V", "Normal", "Small", "universe-ui-checkbox_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UDCheckBoxSize extends Enum<UDCheckBoxSize> {
    public static final UDCheckBoxSize Normal = null;
    public static final UDCheckBoxSize Small = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UDCheckBoxSize[] f284658a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f284659b = null;

    public static EnumEntries<UDCheckBoxSize> getEntries() {
        return f284659b;
    }

    static {
        UDCheckBoxSize r100 = new UDCheckBoxSize("Normal", 0);
        Normal = r100;
        UDCheckBoxSize r101 = new UDCheckBoxSize("Small", 1);
        Small = r101;
        UDCheckBoxSize[] r102 = {r100, r101};
        f284658a = r102;
        f284659b = EnumEntriesKt.enumEntries(r102);
    }

    public static UDCheckBoxSize[] values() {
        return (UDCheckBoxSize[]) f284658a.clone();
    }

    public static UDCheckBoxSize valueOf(String r100) {
        return (UDCheckBoxSize) r27.a.a(UDCheckBoxSize.class, r100);
    }

    public UDCheckBoxSize(String r100, int r101) {
        super(r100, r101);
    }
}
