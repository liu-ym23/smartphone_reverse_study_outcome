package com.larus.chat.gallery.impl.preview.data;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/chat/gallery/impl/preview/data/SourceType;", "", "<init>", "(Ljava/lang/String;I)V", "USER_SEND", "BOT_RESP", "CREATION_CARD", "CREATION_RECORD", FlowDoraWifiScene.ALBUM, "ATTACHMENT", "CAMERA_RESULT", "CLOUD_DRIVE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SourceType extends Enum<SourceType> {
    public static final SourceType ALBUM = null;
    public static final SourceType ATTACHMENT = null;
    public static final SourceType BOT_RESP = null;
    public static final SourceType CAMERA_RESULT = null;
    public static final SourceType CLOUD_DRIVE = null;
    public static final SourceType CREATION_CARD = null;
    public static final SourceType CREATION_RECORD = null;
    public static final SourceType USER_SEND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SourceType[] f324232a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f324233b = null;

    public static EnumEntries<SourceType> getEntries() {
        return f324233b;
    }

    static {
        SourceType r100 = new SourceType("USER_SEND", 0);
        USER_SEND = r100;
        SourceType r101 = new SourceType("BOT_RESP", 1);
        BOT_RESP = r101;
        SourceType r102 = new SourceType("CREATION_CARD", 2);
        CREATION_CARD = r102;
        SourceType r103 = new SourceType("CREATION_RECORD", 3);
        CREATION_RECORD = r103;
        SourceType r104 = new SourceType(FlowDoraWifiScene.ALBUM, 4);
        ALBUM = r104;
        SourceType r105 = new SourceType("ATTACHMENT", 5);
        ATTACHMENT = r105;
        SourceType r110 = new SourceType("CAMERA_RESULT", 6);
        CAMERA_RESULT = r110;
        SourceType r111 = new SourceType("CLOUD_DRIVE", 7);
        CLOUD_DRIVE = r111;
        SourceType[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f324232a = r112;
        f324233b = EnumEntriesKt.enumEntries(r112);
    }

    public static SourceType[] values() {
        return (SourceType[]) f324232a.clone();
    }

    public static SourceType valueOf(String r100) {
        return (SourceType) a.a(SourceType.class, r100);
    }

    public SourceType(String r100, int r101) {
        super(r100, r101);
    }
}
