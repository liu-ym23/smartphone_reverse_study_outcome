package com.larus.uaigc.bean.createpage.component.mediacontainer;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationReferenceAttachmentViolation;", "", "<init>", "(Ljava/lang/String;I)V", "UNSUPPORTED_TYPE", "METADATA_UNAVAILABLE", "TYPE_COUNT", "MIXED_COUNT", "SINGLE_DURATION", "TOTAL_DURATION", "FILE_SIZE", "RESOLUTION", "RATIO", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreationReferenceAttachmentViolation extends Enum<CreationReferenceAttachmentViolation> {
    public static final CreationReferenceAttachmentViolation FILE_SIZE = null;
    public static final CreationReferenceAttachmentViolation METADATA_UNAVAILABLE = null;
    public static final CreationReferenceAttachmentViolation MIXED_COUNT = null;
    public static final CreationReferenceAttachmentViolation RATIO = null;
    public static final CreationReferenceAttachmentViolation RESOLUTION = null;
    public static final CreationReferenceAttachmentViolation SINGLE_DURATION = null;
    public static final CreationReferenceAttachmentViolation TOTAL_DURATION = null;
    public static final CreationReferenceAttachmentViolation TYPE_COUNT = null;
    public static final CreationReferenceAttachmentViolation UNSUPPORTED_TYPE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreationReferenceAttachmentViolation[] f370362a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f370363b = null;

    public static EnumEntries<CreationReferenceAttachmentViolation> getEntries() {
        return f370363b;
    }

    static {
        CreationReferenceAttachmentViolation r100 = new CreationReferenceAttachmentViolation("UNSUPPORTED_TYPE", 0);
        UNSUPPORTED_TYPE = r100;
        CreationReferenceAttachmentViolation r101 = new CreationReferenceAttachmentViolation("METADATA_UNAVAILABLE", 1);
        METADATA_UNAVAILABLE = r101;
        CreationReferenceAttachmentViolation r102 = new CreationReferenceAttachmentViolation("TYPE_COUNT", 2);
        TYPE_COUNT = r102;
        CreationReferenceAttachmentViolation r103 = new CreationReferenceAttachmentViolation("MIXED_COUNT", 3);
        MIXED_COUNT = r103;
        CreationReferenceAttachmentViolation r104 = new CreationReferenceAttachmentViolation("SINGLE_DURATION", 4);
        SINGLE_DURATION = r104;
        CreationReferenceAttachmentViolation r105 = new CreationReferenceAttachmentViolation("TOTAL_DURATION", 5);
        TOTAL_DURATION = r105;
        CreationReferenceAttachmentViolation r110 = new CreationReferenceAttachmentViolation("FILE_SIZE", 6);
        FILE_SIZE = r110;
        CreationReferenceAttachmentViolation r111 = new CreationReferenceAttachmentViolation("RESOLUTION", 7);
        RESOLUTION = r111;
        CreationReferenceAttachmentViolation r112 = new CreationReferenceAttachmentViolation("RATIO", 8);
        RATIO = r112;
        CreationReferenceAttachmentViolation[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f370362a = r113;
        f370363b = EnumEntriesKt.enumEntries(r113);
    }

    public static CreationReferenceAttachmentViolation[] values() {
        return (CreationReferenceAttachmentViolation[]) f370362a.clone();
    }

    public static CreationReferenceAttachmentViolation valueOf(String r100) {
        return (CreationReferenceAttachmentViolation) a.a(CreationReferenceAttachmentViolation.class, r100);
    }

    public CreationReferenceAttachmentViolation(String r100, int r101) {
        super(r100, r101);
    }
}
