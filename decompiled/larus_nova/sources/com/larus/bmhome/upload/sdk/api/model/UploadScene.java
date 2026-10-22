package com.larus.bmhome.upload.sdk.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/upload/sdk/api/model/UploadScene;", "", "<init>", "(Ljava/lang/String;I)V", "CHAT_DIRECT_IMAGE", "CHAT_ATTACHMENT_IMAGE", "CHAT_ATTACHMENT_VIDEO", "CHAT_IMAGE_VLM", "CHAT_IMAGE_OCR", "CHAT_IMAGE_EDU", "CHAT_FILE_UPLOAD", "CREATION_USER_VIDEO", "SPRING_MAIN_VENUE", "UNKNOWN", "O_SERVER", "O_MOBILE_TMP", "O_ASSISTANT_FEEDBACK", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UploadScene extends Enum<UploadScene> {
    public static final UploadScene CHAT_ATTACHMENT_IMAGE = null;
    public static final UploadScene CHAT_ATTACHMENT_VIDEO = null;
    public static final UploadScene CHAT_DIRECT_IMAGE = null;
    public static final UploadScene CHAT_FILE_UPLOAD = null;
    public static final UploadScene CHAT_IMAGE_EDU = null;
    public static final UploadScene CHAT_IMAGE_OCR = null;
    public static final UploadScene CHAT_IMAGE_VLM = null;
    public static final UploadScene CREATION_USER_VIDEO = null;
    public static final UploadScene O_ASSISTANT_FEEDBACK = null;
    public static final UploadScene O_MOBILE_TMP = null;
    public static final UploadScene O_SERVER = null;
    public static final UploadScene SPRING_MAIN_VENUE = null;
    public static final UploadScene UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UploadScene[] f314826a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f314827b = null;

    public static EnumEntries<UploadScene> getEntries() {
        return f314827b;
    }

    static {
        UploadScene r100 = new UploadScene("CHAT_DIRECT_IMAGE", 0);
        CHAT_DIRECT_IMAGE = r100;
        UploadScene r101 = new UploadScene("CHAT_ATTACHMENT_IMAGE", 1);
        CHAT_ATTACHMENT_IMAGE = r101;
        UploadScene r102 = new UploadScene("CHAT_ATTACHMENT_VIDEO", 2);
        CHAT_ATTACHMENT_VIDEO = r102;
        UploadScene r103 = new UploadScene("CHAT_IMAGE_VLM", 3);
        CHAT_IMAGE_VLM = r103;
        UploadScene r104 = new UploadScene("CHAT_IMAGE_OCR", 4);
        CHAT_IMAGE_OCR = r104;
        UploadScene r105 = new UploadScene("CHAT_IMAGE_EDU", 5);
        CHAT_IMAGE_EDU = r105;
        UploadScene r110 = new UploadScene("CHAT_FILE_UPLOAD", 6);
        CHAT_FILE_UPLOAD = r110;
        UploadScene r111 = new UploadScene("CREATION_USER_VIDEO", 7);
        CREATION_USER_VIDEO = r111;
        UploadScene r112 = new UploadScene("SPRING_MAIN_VENUE", 8);
        SPRING_MAIN_VENUE = r112;
        UploadScene r113 = new UploadScene("UNKNOWN", 9);
        UNKNOWN = r113;
        UploadScene r114 = new UploadScene("O_SERVER", 10);
        O_SERVER = r114;
        UploadScene r115 = new UploadScene("O_MOBILE_TMP", 11);
        O_MOBILE_TMP = r115;
        UploadScene r106 = new UploadScene("O_ASSISTANT_FEEDBACK", 12);
        O_ASSISTANT_FEEDBACK = r106;
        UploadScene[] r107 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
        f314826a = r107;
        f314827b = EnumEntriesKt.enumEntries(r107);
    }

    public static UploadScene[] values() {
        return (UploadScene[]) f314826a.clone();
    }

    public static UploadScene valueOf(String r100) {
        return (UploadScene) a.a(UploadScene.class, r100);
    }

    public UploadScene(String r100, int r101) {
        super(r100, r101);
    }
}
