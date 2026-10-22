package com.larus.business.multitask_management.impl.component;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/business/multitask_management/impl/component/SectionCardStyle;", "", "<init>", "(Ljava/lang/String;I)V", "SMALL", "LARGE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SectionCardStyle extends Enum<SectionCardStyle> {
    public static final SectionCardStyle LARGE = null;
    public static final SectionCardStyle SMALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SectionCardStyle[] f320803a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f320804b = null;

    public static EnumEntries<SectionCardStyle> getEntries() {
        return f320804b;
    }

    static {
        SectionCardStyle r100 = new SectionCardStyle("SMALL", 0);
        SMALL = r100;
        SectionCardStyle r101 = new SectionCardStyle("LARGE", 1);
        LARGE = r101;
        SectionCardStyle[] r102 = {r100, r101};
        f320803a = r102;
        f320804b = EnumEntriesKt.enumEntries(r102);
    }

    public static SectionCardStyle[] values() {
        return (SectionCardStyle[]) f320803a.clone();
    }

    public static SectionCardStyle valueOf(String r100) {
        return (SectionCardStyle) r27.a.a(SectionCardStyle.class, r100);
    }

    public SectionCardStyle(String r100, int r101) {
        super(r100, r101);
    }
}
