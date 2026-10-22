package com.bytedance.ee.bear.middleground.permission.export.permsdk.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/UiType;", "", "<init>", "(Ljava/lang/String;I)V", "HIDDEN", "DISABLED", "DEFAULT", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UiType extends Enum<UiType> {
    public static final UiType DEFAULT = null;
    public static final UiType DISABLED = null;
    public static final UiType HIDDEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UiType[] f233875a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f233876b = null;

    public static EnumEntries<UiType> getEntries() {
        return f233876b;
    }

    static {
        UiType r100 = new UiType("HIDDEN", 0);
        HIDDEN = r100;
        UiType r101 = new UiType("DISABLED", 1);
        DISABLED = r101;
        UiType r102 = new UiType("DEFAULT", 2);
        DEFAULT = r102;
        UiType[] r103 = {r100, r101, r102};
        f233875a = r103;
        f233876b = EnumEntriesKt.enumEntries(r103);
    }

    public static UiType[] values() {
        return (UiType[]) f233875a.clone();
    }

    public static UiType valueOf(String r100) {
        return (UiType) a.a(UiType.class, r100);
    }

    public UiType(String r100, int r101) {
        super(r100, r101);
    }
}
