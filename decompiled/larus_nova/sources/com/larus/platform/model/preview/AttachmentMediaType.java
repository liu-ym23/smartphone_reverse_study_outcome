package com.larus.platform.model.preview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/model/preview/AttachmentMediaType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "FILE", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AttachmentMediaType extends Enum<AttachmentMediaType> {
    public static final AttachmentMediaType FILE = null;
    public static final AttachmentMediaType IMAGE = null;
    public static final AttachmentMediaType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AttachmentMediaType[] f365645a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365646b = null;

    public static EnumEntries<AttachmentMediaType> getEntries() {
        return f365646b;
    }

    static {
        AttachmentMediaType r100 = new AttachmentMediaType("IMAGE", 0);
        IMAGE = r100;
        AttachmentMediaType r101 = new AttachmentMediaType("VIDEO", 1);
        VIDEO = r101;
        AttachmentMediaType r102 = new AttachmentMediaType("FILE", 2);
        FILE = r102;
        AttachmentMediaType[] r103 = {r100, r101, r102};
        f365645a = r103;
        f365646b = EnumEntriesKt.enumEntries(r103);
    }

    public static AttachmentMediaType[] values() {
        return (AttachmentMediaType[]) f365645a.clone();
    }

    public static AttachmentMediaType valueOf(String r100) {
        return (AttachmentMediaType) a.a(AttachmentMediaType.class, r100);
    }

    public AttachmentMediaType(String r100, int r101) {
        super(r100, r101);
    }
}
