package com.larus.chat.gallery.api;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/chat/gallery/api/PreviewScene;", "", "<init>", "(Ljava/lang/String;I)V", "MESSAGE", "SEARCH_IMAGE", "CREATION_CARD", "CREATION_RECORD", FlowDoraWifiScene.ALBUM, "ATTACHMENT_PANEL", "CAMERA_RESULT", "CLOUD_DRIVE", "PRIVATE_ALBUM", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PreviewScene extends Enum<PreviewScene> {
    public static final PreviewScene ALBUM = null;
    public static final PreviewScene ATTACHMENT_PANEL = null;
    public static final PreviewScene CAMERA_RESULT = null;
    public static final PreviewScene CLOUD_DRIVE = null;
    public static final PreviewScene CREATION_CARD = null;
    public static final PreviewScene CREATION_RECORD = null;
    public static final PreviewScene MESSAGE = null;
    public static final PreviewScene PRIVATE_ALBUM = null;
    public static final PreviewScene SEARCH_IMAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreviewScene[] f324112a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f324113b = null;

    public static EnumEntries<PreviewScene> getEntries() {
        return f324113b;
    }

    static {
        PreviewScene r100 = new PreviewScene("MESSAGE", 0);
        MESSAGE = r100;
        PreviewScene r101 = new PreviewScene("SEARCH_IMAGE", 1);
        SEARCH_IMAGE = r101;
        PreviewScene r102 = new PreviewScene("CREATION_CARD", 2);
        CREATION_CARD = r102;
        PreviewScene r103 = new PreviewScene("CREATION_RECORD", 3);
        CREATION_RECORD = r103;
        PreviewScene r104 = new PreviewScene(FlowDoraWifiScene.ALBUM, 4);
        ALBUM = r104;
        PreviewScene r105 = new PreviewScene("ATTACHMENT_PANEL", 5);
        ATTACHMENT_PANEL = r105;
        PreviewScene r110 = new PreviewScene("CAMERA_RESULT", 6);
        CAMERA_RESULT = r110;
        PreviewScene r111 = new PreviewScene("CLOUD_DRIVE", 7);
        CLOUD_DRIVE = r111;
        PreviewScene r112 = new PreviewScene("PRIVATE_ALBUM", 8);
        PRIVATE_ALBUM = r112;
        PreviewScene[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f324112a = r113;
        f324113b = EnumEntriesKt.enumEntries(r113);
    }

    public static PreviewScene[] values() {
        return (PreviewScene[]) f324112a.clone();
    }

    public static PreviewScene valueOf(String r100) {
        return (PreviewScene) r27.a.a(PreviewScene.class, r100);
    }

    public PreviewScene(String r100, int r101) {
        super(r100, r101);
    }
}
