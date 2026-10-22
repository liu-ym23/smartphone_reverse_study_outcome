package com.larus.avlink.e;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/avlink/e/DoraImageEvent;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "TAKE_PHOTO_CMD_SEND", "IMAGE_TAKE_START", "IMAGE_TRANS_START", "IMAGE_TRANS_FINISH", "IMAGE_UPLOAD_START", "IMAGE_UPLOAD_FINISH", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraImageEvent extends Enum<DoraImageEvent> {
    public static final DoraImageEvent IMAGE_TAKE_START = null;
    public static final DoraImageEvent IMAGE_TRANS_FINISH = null;
    public static final DoraImageEvent IMAGE_TRANS_START = null;
    public static final DoraImageEvent IMAGE_UPLOAD_FINISH = null;
    public static final DoraImageEvent IMAGE_UPLOAD_START = null;
    public static final DoraImageEvent TAKE_PHOTO_CMD_SEND = null;
    public static final DoraImageEvent UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraImageEvent[] f291759a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291760b = null;

    public static EnumEntries<DoraImageEvent> getEntries() {
        return f291760b;
    }

    static {
        DoraImageEvent r100 = new DoraImageEvent("UNKNOWN", 0);
        UNKNOWN = r100;
        DoraImageEvent r101 = new DoraImageEvent("TAKE_PHOTO_CMD_SEND", 1);
        TAKE_PHOTO_CMD_SEND = r101;
        DoraImageEvent r102 = new DoraImageEvent("IMAGE_TAKE_START", 2);
        IMAGE_TAKE_START = r102;
        DoraImageEvent r103 = new DoraImageEvent("IMAGE_TRANS_START", 3);
        IMAGE_TRANS_START = r103;
        DoraImageEvent r104 = new DoraImageEvent("IMAGE_TRANS_FINISH", 4);
        IMAGE_TRANS_FINISH = r104;
        DoraImageEvent r105 = new DoraImageEvent("IMAGE_UPLOAD_START", 5);
        IMAGE_UPLOAD_START = r105;
        DoraImageEvent r110 = new DoraImageEvent("IMAGE_UPLOAD_FINISH", 6);
        IMAGE_UPLOAD_FINISH = r110;
        DoraImageEvent[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f291759a = r111;
        f291760b = EnumEntriesKt.enumEntries(r111);
    }

    public static DoraImageEvent[] values() {
        return (DoraImageEvent[]) f291759a.clone();
    }

    public static DoraImageEvent valueOf(String r100) {
        return (DoraImageEvent) r27.a.a(DoraImageEvent.class, r100);
    }

    public DoraImageEvent(String r100, int r101) {
        super(r100, r101);
    }
}
