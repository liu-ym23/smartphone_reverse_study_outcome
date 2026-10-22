package com.larus.uaigc.bean.createpage.component.mediacontainer;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationReferenceAttachmentState;", "", "<init>", "(Ljava/lang/String;I)V", "SELECTED", "COMPRESSING", "UPLOADING", "UPLOAD_SUCCESS", "UPLOAD_FAILED", "PARSE_FAILED", "INSPECT_FAILED", "EXPIRED", "UNKNOWN", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreationReferenceAttachmentState extends Enum<CreationReferenceAttachmentState> {
    public static final CreationReferenceAttachmentState COMPRESSING = null;
    public static final CreationReferenceAttachmentState EXPIRED = null;
    public static final CreationReferenceAttachmentState INSPECT_FAILED = null;
    public static final CreationReferenceAttachmentState PARSE_FAILED = null;
    public static final CreationReferenceAttachmentState SELECTED = null;
    public static final CreationReferenceAttachmentState UNKNOWN = null;
    public static final CreationReferenceAttachmentState UPLOADING = null;
    public static final CreationReferenceAttachmentState UPLOAD_FAILED = null;
    public static final CreationReferenceAttachmentState UPLOAD_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreationReferenceAttachmentState[] f370358a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f370359b = null;

    public static EnumEntries<CreationReferenceAttachmentState> getEntries() {
        return f370359b;
    }

    static {
        CreationReferenceAttachmentState r100 = new CreationReferenceAttachmentState("SELECTED", 0);
        SELECTED = r100;
        CreationReferenceAttachmentState r101 = new CreationReferenceAttachmentState("COMPRESSING", 1);
        COMPRESSING = r101;
        CreationReferenceAttachmentState r102 = new CreationReferenceAttachmentState("UPLOADING", 2);
        UPLOADING = r102;
        CreationReferenceAttachmentState r103 = new CreationReferenceAttachmentState("UPLOAD_SUCCESS", 3);
        UPLOAD_SUCCESS = r103;
        CreationReferenceAttachmentState r104 = new CreationReferenceAttachmentState("UPLOAD_FAILED", 4);
        UPLOAD_FAILED = r104;
        CreationReferenceAttachmentState r105 = new CreationReferenceAttachmentState("PARSE_FAILED", 5);
        PARSE_FAILED = r105;
        CreationReferenceAttachmentState r110 = new CreationReferenceAttachmentState("INSPECT_FAILED", 6);
        INSPECT_FAILED = r110;
        CreationReferenceAttachmentState r111 = new CreationReferenceAttachmentState("EXPIRED", 7);
        EXPIRED = r111;
        CreationReferenceAttachmentState r112 = new CreationReferenceAttachmentState("UNKNOWN", 8);
        UNKNOWN = r112;
        CreationReferenceAttachmentState[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f370358a = r113;
        f370359b = EnumEntriesKt.enumEntries(r113);
    }

    public static CreationReferenceAttachmentState[] values() {
        return (CreationReferenceAttachmentState[]) f370358a.clone();
    }

    public static CreationReferenceAttachmentState valueOf(String r100) {
        return (CreationReferenceAttachmentState) a.a(CreationReferenceAttachmentState.class, r100);
    }

    public CreationReferenceAttachmentState(String r100, int r101) {
        super(r100, r101);
    }
}
