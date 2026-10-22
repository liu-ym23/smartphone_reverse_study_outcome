package com.larus.bmhome.chat.ab;

import com.larus.media.MediaScene;
import com.larus.network.http.ServiceType;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/chat/ab/InputMultilineScene;", "", "sceneKey", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getSceneKey", "()Ljava/lang/String;", "MAIN_CHAT", "IM_CHAT", "COT_DETAIL", "ALBUM_QUICK_INPUT", "CAMERA_PREVIEW", "GALLERY_PREVIEW", "DRIVE_PREVIEW", "OFFICE_DOC", "FLOAT_CHAT", "APPLET", "SKILL_PANEL", "CREATION", "MUSIC", "NOTE", "CANVAS", "MINI_ARTIFACT", MediaScene.LIVE_TUTOR, "VENUE", ServiceType.OBRIC, "ECOMMERCE", "CHAT_JOB", "DOC_MEDIA_SELECT", "OUTER_CHAT", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InputMultilineScene extends Enum<InputMultilineScene> {
    public static final InputMultilineScene ALBUM_QUICK_INPUT = null;
    public static final InputMultilineScene APPLET = null;
    public static final InputMultilineScene CAMERA_PREVIEW = null;
    public static final InputMultilineScene CANVAS = null;
    public static final InputMultilineScene CHAT_JOB = null;
    public static final InputMultilineScene COT_DETAIL = null;
    public static final InputMultilineScene CREATION = null;
    public static final InputMultilineScene DOC_MEDIA_SELECT = null;
    public static final InputMultilineScene DRIVE_PREVIEW = null;
    public static final InputMultilineScene ECOMMERCE = null;
    public static final InputMultilineScene FLOAT_CHAT = null;
    public static final InputMultilineScene GALLERY_PREVIEW = null;
    public static final InputMultilineScene IM_CHAT = null;
    public static final InputMultilineScene LIVE_TUTOR = null;
    public static final InputMultilineScene MAIN_CHAT = null;
    public static final InputMultilineScene MINI_ARTIFACT = null;
    public static final InputMultilineScene MUSIC = null;
    public static final InputMultilineScene NOTE = null;
    public static final InputMultilineScene OBRIC = null;
    public static final InputMultilineScene OFFICE_DOC = null;
    public static final InputMultilineScene OUTER_CHAT = null;
    public static final InputMultilineScene SKILL_PANEL = null;
    public static final InputMultilineScene VENUE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InputMultilineScene[] f296988a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f296989b = null;
    private final String sceneKey;

    public static EnumEntries<InputMultilineScene> getEntries() {
        return f296989b;
    }

    static {
        InputMultilineScene r100 = new InputMultilineScene("MAIN_CHAT", 0, "main_chat");
        MAIN_CHAT = r100;
        InputMultilineScene r101 = new InputMultilineScene("IM_CHAT", 1, "im_chat");
        IM_CHAT = r101;
        InputMultilineScene r102 = new InputMultilineScene("COT_DETAIL", 2, "cot_detail");
        COT_DETAIL = r102;
        InputMultilineScene r103 = new InputMultilineScene("ALBUM_QUICK_INPUT", 3, "album_quick_input");
        ALBUM_QUICK_INPUT = r103;
        InputMultilineScene r104 = new InputMultilineScene("CAMERA_PREVIEW", 4, EventConstant.MSSecEvent.CAMERA_PREVIEW);
        CAMERA_PREVIEW = r104;
        InputMultilineScene r105 = new InputMultilineScene("GALLERY_PREVIEW", 5, "gallery_preview");
        GALLERY_PREVIEW = r105;
        InputMultilineScene r110 = new InputMultilineScene("DRIVE_PREVIEW", 6, "drive_preview");
        DRIVE_PREVIEW = r110;
        InputMultilineScene r111 = new InputMultilineScene("OFFICE_DOC", 7, "office_doc");
        OFFICE_DOC = r111;
        InputMultilineScene r112 = new InputMultilineScene("FLOAT_CHAT", 8, "float_chat");
        FLOAT_CHAT = r112;
        InputMultilineScene r113 = new InputMultilineScene("APPLET", 9, "applet");
        APPLET = r113;
        InputMultilineScene r114 = new InputMultilineScene("SKILL_PANEL", 10, "skill_panel");
        SKILL_PANEL = r114;
        InputMultilineScene r106 = new InputMultilineScene("CREATION", 11, "creation");
        CREATION = r106;
        InputMultilineScene r107 = new InputMultilineScene("MUSIC", 12, "music");
        MUSIC = r107;
        InputMultilineScene r108 = new InputMultilineScene("NOTE", 13, "note");
        NOTE = r108;
        InputMultilineScene r109 = new InputMultilineScene("CANVAS", 14, "canvas");
        CANVAS = r109;
        InputMultilineScene r115 = new InputMultilineScene("MINI_ARTIFACT", 15, "mini_artifact");
        MINI_ARTIFACT = r115;
        InputMultilineScene r116 = new InputMultilineScene(MediaScene.LIVE_TUTOR, 16, "live_tutor");
        LIVE_TUTOR = r116;
        InputMultilineScene r117 = new InputMultilineScene("VENUE", 17, "venue");
        VENUE = r117;
        InputMultilineScene r118 = new InputMultilineScene(ServiceType.OBRIC, 18, "obric");
        OBRIC = r118;
        InputMultilineScene r119 = new InputMultilineScene("ECOMMERCE", 19, "ecommerce");
        ECOMMERCE = r119;
        InputMultilineScene r120 = new InputMultilineScene("CHAT_JOB", 20, "chat_job");
        CHAT_JOB = r120;
        InputMultilineScene r121 = new InputMultilineScene("DOC_MEDIA_SELECT", 21, "doc_media_select");
        DOC_MEDIA_SELECT = r121;
        InputMultilineScene r122 = new InputMultilineScene("OUTER_CHAT", 22, "outer_chat");
        OUTER_CHAT = r122;
        InputMultilineScene[] r123 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122};
        f296988a = r123;
        f296989b = EnumEntriesKt.enumEntries(r123);
    }

    public static InputMultilineScene[] values() {
        return (InputMultilineScene[]) f296988a.clone();
    }

    public final String getSceneKey() {
        return this.sceneKey;
    }

    public static InputMultilineScene valueOf(String r100) {
        return (InputMultilineScene) a.a(InputMultilineScene.class, r100);
    }

    public InputMultilineScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.sceneKey = r102;
    }
}
