package com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/core/infoarch/basemain/controller/OfficeBaseMainScrollContentType;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN_WEB", "NATIVE_VIEW", "LINKED_DOCX", "FORM", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeBaseMainScrollContentType extends Enum<OfficeBaseMainScrollContentType> {
    public static final OfficeBaseMainScrollContentType FORM = null;
    public static final OfficeBaseMainScrollContentType LINKED_DOCX = null;
    public static final OfficeBaseMainScrollContentType MAIN_WEB = null;
    public static final OfficeBaseMainScrollContentType NATIVE_VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeBaseMainScrollContentType[] f210387a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f210388b = null;

    public static EnumEntries<OfficeBaseMainScrollContentType> getEntries() {
        return f210388b;
    }

    static {
        OfficeBaseMainScrollContentType r100 = new OfficeBaseMainScrollContentType("MAIN_WEB", 0);
        MAIN_WEB = r100;
        OfficeBaseMainScrollContentType r101 = new OfficeBaseMainScrollContentType("NATIVE_VIEW", 1);
        NATIVE_VIEW = r101;
        OfficeBaseMainScrollContentType r102 = new OfficeBaseMainScrollContentType("LINKED_DOCX", 2);
        LINKED_DOCX = r102;
        OfficeBaseMainScrollContentType r103 = new OfficeBaseMainScrollContentType("FORM", 3);
        FORM = r103;
        OfficeBaseMainScrollContentType[] r104 = {r100, r101, r102, r103};
        f210387a = r104;
        f210388b = EnumEntriesKt.enumEntries(r104);
    }

    public static OfficeBaseMainScrollContentType[] values() {
        return (OfficeBaseMainScrollContentType[]) f210387a.clone();
    }

    public static OfficeBaseMainScrollContentType valueOf(String r100) {
        return (OfficeBaseMainScrollContentType) r27.a.a(OfficeBaseMainScrollContentType.class, r100);
    }

    public OfficeBaseMainScrollContentType(String r100, int r101) {
        super(r100, r101);
    }
}
