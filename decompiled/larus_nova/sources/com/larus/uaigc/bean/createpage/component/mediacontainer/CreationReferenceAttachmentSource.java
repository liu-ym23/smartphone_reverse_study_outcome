package com.larus.uaigc.bean.createpage.component.mediacontainer;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationReferenceAttachmentSource;", "", "<init>", "(Ljava/lang/String;I)V", "MANUAL", "DO_SAME", "UNKNOWN", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreationReferenceAttachmentSource extends Enum<CreationReferenceAttachmentSource> {
    public static final CreationReferenceAttachmentSource DO_SAME = null;
    public static final CreationReferenceAttachmentSource MANUAL = null;
    public static final CreationReferenceAttachmentSource UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreationReferenceAttachmentSource[] f370356a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f370357b = null;

    public static EnumEntries<CreationReferenceAttachmentSource> getEntries() {
        return f370357b;
    }

    static {
        CreationReferenceAttachmentSource r100 = new CreationReferenceAttachmentSource("MANUAL", 0);
        MANUAL = r100;
        CreationReferenceAttachmentSource r101 = new CreationReferenceAttachmentSource("DO_SAME", 1);
        DO_SAME = r101;
        CreationReferenceAttachmentSource r102 = new CreationReferenceAttachmentSource("UNKNOWN", 2);
        UNKNOWN = r102;
        CreationReferenceAttachmentSource[] r103 = {r100, r101, r102};
        f370356a = r103;
        f370357b = EnumEntriesKt.enumEntries(r103);
    }

    public static CreationReferenceAttachmentSource[] values() {
        return (CreationReferenceAttachmentSource[]) f370356a.clone();
    }

    public static CreationReferenceAttachmentSource valueOf(String r100) {
        return (CreationReferenceAttachmentSource) a.a(CreationReferenceAttachmentSource.class, r100);
    }

    public CreationReferenceAttachmentSource(String r100, int r101) {
        super(r100, r101);
    }
}
