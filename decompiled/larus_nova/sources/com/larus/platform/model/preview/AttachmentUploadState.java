package com.larus.platform.model.preview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/platform/model/preview/AttachmentUploadState;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_UPLOADED", "UPLOADING", "UPLOADED", "SEND_PIPELINE_OWNED", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AttachmentUploadState extends Enum<AttachmentUploadState> {
    public static final AttachmentUploadState NOT_UPLOADED = null;
    public static final AttachmentUploadState SEND_PIPELINE_OWNED = null;
    public static final AttachmentUploadState UPLOADED = null;
    public static final AttachmentUploadState UPLOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AttachmentUploadState[] f365651a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365652b = null;

    public static EnumEntries<AttachmentUploadState> getEntries() {
        return f365652b;
    }

    static {
        AttachmentUploadState r100 = new AttachmentUploadState("NOT_UPLOADED", 0);
        NOT_UPLOADED = r100;
        AttachmentUploadState r101 = new AttachmentUploadState("UPLOADING", 1);
        UPLOADING = r101;
        AttachmentUploadState r102 = new AttachmentUploadState("UPLOADED", 2);
        UPLOADED = r102;
        AttachmentUploadState r103 = new AttachmentUploadState("SEND_PIPELINE_OWNED", 3);
        SEND_PIPELINE_OWNED = r103;
        AttachmentUploadState[] r104 = {r100, r101, r102, r103};
        f365651a = r104;
        f365652b = EnumEntriesKt.enumEntries(r104);
    }

    public static AttachmentUploadState[] values() {
        return (AttachmentUploadState[]) f365651a.clone();
    }

    public static AttachmentUploadState valueOf(String r100) {
        return (AttachmentUploadState) a.a(AttachmentUploadState.class, r100);
    }

    public AttachmentUploadState(String r100, int r101) {
        super(r100, r101);
    }
}
