package com.larus.uaigc.bean.createpage.component.mediacontainer;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationReferenceAttachmentType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "AUDIO", "UNKNOWN", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreationReferenceAttachmentType extends Enum<CreationReferenceAttachmentType> {
    public static final CreationReferenceAttachmentType AUDIO = null;
    public static final CreationReferenceAttachmentType IMAGE = null;
    public static final CreationReferenceAttachmentType UNKNOWN = null;
    public static final CreationReferenceAttachmentType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreationReferenceAttachmentType[] f370360a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f370361b = null;

    public static EnumEntries<CreationReferenceAttachmentType> getEntries() {
        return f370361b;
    }

    static {
        CreationReferenceAttachmentType r100 = new CreationReferenceAttachmentType("IMAGE", 0);
        IMAGE = r100;
        CreationReferenceAttachmentType r101 = new CreationReferenceAttachmentType("VIDEO", 1);
        VIDEO = r101;
        CreationReferenceAttachmentType r102 = new CreationReferenceAttachmentType("AUDIO", 2);
        AUDIO = r102;
        CreationReferenceAttachmentType r103 = new CreationReferenceAttachmentType("UNKNOWN", 3);
        UNKNOWN = r103;
        CreationReferenceAttachmentType[] r104 = {r100, r101, r102, r103};
        f370360a = r104;
        f370361b = EnumEntriesKt.enumEntries(r104);
    }

    public static CreationReferenceAttachmentType[] values() {
        return (CreationReferenceAttachmentType[]) f370360a.clone();
    }

    public static CreationReferenceAttachmentType valueOf(String r100) {
        return (CreationReferenceAttachmentType) a.a(CreationReferenceAttachmentType.class, r100);
    }

    public CreationReferenceAttachmentType(String r100, int r101) {
        super(r100, r101);
    }
}
