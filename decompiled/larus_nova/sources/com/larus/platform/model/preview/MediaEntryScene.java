package com.larus.platform.model.preview;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/platform/model/preview/MediaEntryScene;", "", "<init>", "(Ljava/lang/String;I)V", FlowDoraWifiScene.ALBUM, "ATTACHMENT_PANEL", "CAMERA_RESULT", "MESSAGE", "SEARCH", "PRIVATE_ALBUM", "CLOUD_DRIVE", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MediaEntryScene extends Enum<MediaEntryScene> {
    public static final MediaEntryScene ALBUM = null;
    public static final MediaEntryScene ATTACHMENT_PANEL = null;
    public static final MediaEntryScene CAMERA_RESULT = null;
    public static final MediaEntryScene CLOUD_DRIVE = null;
    public static final MediaEntryScene MESSAGE = null;
    public static final MediaEntryScene PRIVATE_ALBUM = null;
    public static final MediaEntryScene SEARCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MediaEntryScene[] f365655a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365656b = null;

    public static EnumEntries<MediaEntryScene> getEntries() {
        return f365656b;
    }

    static {
        MediaEntryScene r100 = new MediaEntryScene(FlowDoraWifiScene.ALBUM, 0);
        ALBUM = r100;
        MediaEntryScene r101 = new MediaEntryScene("ATTACHMENT_PANEL", 1);
        ATTACHMENT_PANEL = r101;
        MediaEntryScene r102 = new MediaEntryScene("CAMERA_RESULT", 2);
        CAMERA_RESULT = r102;
        MediaEntryScene r103 = new MediaEntryScene("MESSAGE", 3);
        MESSAGE = r103;
        MediaEntryScene r104 = new MediaEntryScene("SEARCH", 4);
        SEARCH = r104;
        MediaEntryScene r105 = new MediaEntryScene("PRIVATE_ALBUM", 5);
        PRIVATE_ALBUM = r105;
        MediaEntryScene r110 = new MediaEntryScene("CLOUD_DRIVE", 6);
        CLOUD_DRIVE = r110;
        MediaEntryScene[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f365655a = r111;
        f365656b = EnumEntriesKt.enumEntries(r111);
    }

    public static MediaEntryScene[] values() {
        return (MediaEntryScene[]) f365655a.clone();
    }

    public static MediaEntryScene valueOf(String r100) {
        return (MediaEntryScene) a.a(MediaEntryScene.class, r100);
    }

    public MediaEntryScene(String r100, int r101) {
        super(r100, r101);
    }
}
