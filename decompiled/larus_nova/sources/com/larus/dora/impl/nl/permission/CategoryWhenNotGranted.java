package com.larus.dora.impl.nl.permission;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/nl/permission/CategoryWhenNotGranted;", "", "<init>", "(Ljava/lang/String;I)V", "NEXT", "LOOP", "INTERRUPT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CategoryWhenNotGranted extends Enum<CategoryWhenNotGranted> {
    public static final CategoryWhenNotGranted INTERRUPT = null;
    public static final CategoryWhenNotGranted LOOP = null;
    public static final CategoryWhenNotGranted NEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CategoryWhenNotGranted[] f336382a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f336383b = null;

    public static EnumEntries<CategoryWhenNotGranted> getEntries() {
        return f336383b;
    }

    static {
        CategoryWhenNotGranted r100 = new CategoryWhenNotGranted("NEXT", 0);
        NEXT = r100;
        CategoryWhenNotGranted r101 = new CategoryWhenNotGranted("LOOP", 1);
        LOOP = r101;
        CategoryWhenNotGranted r102 = new CategoryWhenNotGranted("INTERRUPT", 2);
        INTERRUPT = r102;
        CategoryWhenNotGranted[] r103 = {r100, r101, r102};
        f336382a = r103;
        f336383b = EnumEntriesKt.enumEntries(r103);
    }

    public static CategoryWhenNotGranted[] values() {
        return (CategoryWhenNotGranted[]) f336382a.clone();
    }

    public static CategoryWhenNotGranted valueOf(String r100) {
        return (CategoryWhenNotGranted) a.a(CategoryWhenNotGranted.class, r100);
    }

    public CategoryWhenNotGranted(String r100, int r101) {
        super(r100, r101);
    }
}
