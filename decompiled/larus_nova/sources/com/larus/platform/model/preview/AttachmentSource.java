package com.larus.platform.model.preview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/platform/model/preview/AttachmentSource;", "", "<init>", "(Ljava/lang/String;I)V", "LOCAL_ALBUM", "CAMERA", "MESSAGE_REMOTE", "SEARCH", "PRIVATE_ALBUM", "CLOUD_DRIVE", "FILE", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AttachmentSource extends Enum<AttachmentSource> {
    public static final AttachmentSource CAMERA = null;
    public static final AttachmentSource CLOUD_DRIVE = null;
    public static final AttachmentSource FILE = null;
    public static final AttachmentSource LOCAL_ALBUM = null;
    public static final AttachmentSource MESSAGE_REMOTE = null;
    public static final AttachmentSource PRIVATE_ALBUM = null;
    public static final AttachmentSource SEARCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AttachmentSource[] f365649a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365650b = null;

    public static EnumEntries<AttachmentSource> getEntries() {
        return f365650b;
    }

    static {
        AttachmentSource r100 = new AttachmentSource("LOCAL_ALBUM", 0);
        LOCAL_ALBUM = r100;
        AttachmentSource r101 = new AttachmentSource("CAMERA", 1);
        CAMERA = r101;
        AttachmentSource r102 = new AttachmentSource("MESSAGE_REMOTE", 2);
        MESSAGE_REMOTE = r102;
        AttachmentSource r103 = new AttachmentSource("SEARCH", 3);
        SEARCH = r103;
        AttachmentSource r104 = new AttachmentSource("PRIVATE_ALBUM", 4);
        PRIVATE_ALBUM = r104;
        AttachmentSource r105 = new AttachmentSource("CLOUD_DRIVE", 5);
        CLOUD_DRIVE = r105;
        AttachmentSource r110 = new AttachmentSource("FILE", 6);
        FILE = r110;
        AttachmentSource[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f365649a = r111;
        f365650b = EnumEntriesKt.enumEntries(r111);
    }

    public static AttachmentSource[] values() {
        return (AttachmentSource[]) f365649a.clone();
    }

    public static AttachmentSource valueOf(String r100) {
        return (AttachmentSource) a.a(AttachmentSource.class, r100);
    }

    public AttachmentSource(String r100, int r101) {
        super(r100, r101);
    }
}
