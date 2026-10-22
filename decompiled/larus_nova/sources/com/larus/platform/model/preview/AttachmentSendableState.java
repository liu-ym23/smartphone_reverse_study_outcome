package com.larus.platform.model.preview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/model/preview/AttachmentSendableState;", "", "<init>", "(Ljava/lang/String;I)V", "SENDABLE", "NEEDS_MATERIALIZE", "NOT_SENDABLE", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AttachmentSendableState extends Enum<AttachmentSendableState> {
    public static final AttachmentSendableState NEEDS_MATERIALIZE = null;
    public static final AttachmentSendableState NOT_SENDABLE = null;
    public static final AttachmentSendableState SENDABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AttachmentSendableState[] f365647a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365648b = null;

    public static EnumEntries<AttachmentSendableState> getEntries() {
        return f365648b;
    }

    static {
        AttachmentSendableState r100 = new AttachmentSendableState("SENDABLE", 0);
        SENDABLE = r100;
        AttachmentSendableState r101 = new AttachmentSendableState("NEEDS_MATERIALIZE", 1);
        NEEDS_MATERIALIZE = r101;
        AttachmentSendableState r102 = new AttachmentSendableState("NOT_SENDABLE", 2);
        NOT_SENDABLE = r102;
        AttachmentSendableState[] r103 = {r100, r101, r102};
        f365647a = r103;
        f365648b = EnumEntriesKt.enumEntries(r103);
    }

    public static AttachmentSendableState[] values() {
        return (AttachmentSendableState[]) f365647a.clone();
    }

    public static AttachmentSendableState valueOf(String r100) {
        return (AttachmentSendableState) a.a(AttachmentSendableState.class, r100);
    }

    public AttachmentSendableState(String r100, int r101) {
        super(r100, r101);
    }
}
