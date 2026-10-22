package com.bytedance.ee.bear.drive.mimetype;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.larus.media.MediaScene;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final enum MimeTypeCategory extends Enum<MimeTypeCategory> {
    public static final MimeTypeCategory APP = null;
    public static final MimeTypeCategory AUDIO = null;
    public static final MimeTypeCategory BINARY = null;
    public static final MimeTypeCategory COMPRESS = null;
    public static final MimeTypeCategory DATABASE = null;
    public static final MimeTypeCategory DOCUMENT = null;
    public static final MimeTypeCategory EBOOK = null;
    public static final MimeTypeCategory EXEC = null;
    public static final MimeTypeCategory FONT = null;
    public static final MimeTypeCategory IMAGE = null;
    public static final MimeTypeCategory MAIL = null;
    public static final MimeTypeCategory NONE = null;
    public static final MimeTypeCategory SECURITY = null;
    public static final MimeTypeCategory SYSTEM = null;
    public static final MimeTypeCategory TEXT = null;
    public static final MimeTypeCategory VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MimeTypeCategory[] f224479a = null;

    static {
        MimeTypeCategory r100 = new MimeTypeCategory(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        MimeTypeCategory r101 = new MimeTypeCategory(MediaScene.SYSTEM, 1);
        SYSTEM = r101;
        MimeTypeCategory r102 = new MimeTypeCategory("APP", 2);
        APP = r102;
        MimeTypeCategory r103 = new MimeTypeCategory("BINARY", 3);
        BINARY = r103;
        MimeTypeCategory r104 = new MimeTypeCategory(CardAdapter.TEXT, 4);
        TEXT = r104;
        MimeTypeCategory r105 = new MimeTypeCategory("DOCUMENT", 5);
        DOCUMENT = r105;
        MimeTypeCategory r110 = new MimeTypeCategory("EBOOK", 6);
        EBOOK = r110;
        MimeTypeCategory r111 = new MimeTypeCategory("MAIL", 7);
        MAIL = r111;
        MimeTypeCategory r112 = new MimeTypeCategory("COMPRESS", 8);
        COMPRESS = r112;
        MimeTypeCategory r113 = new MimeTypeCategory("EXEC", 9);
        EXEC = r113;
        MimeTypeCategory r114 = new MimeTypeCategory("DATABASE", 10);
        DATABASE = r114;
        MimeTypeCategory r115 = new MimeTypeCategory("FONT", 11);
        FONT = r115;
        MimeTypeCategory r106 = new MimeTypeCategory("IMAGE", 12);
        IMAGE = r106;
        MimeTypeCategory r107 = new MimeTypeCategory("AUDIO", 13);
        AUDIO = r107;
        MimeTypeCategory r108 = new MimeTypeCategory("VIDEO", 14);
        VIDEO = r108;
        MimeTypeCategory r109 = new MimeTypeCategory("SECURITY", 15);
        SECURITY = r109;
        f224479a = new MimeTypeCategory[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109};
    }

    public static MimeTypeCategory[] values() {
        return (MimeTypeCategory[]) f224479a.clone();
    }

    public static MimeTypeCategory valueOf(String r100) {
        return (MimeTypeCategory) a.a(MimeTypeCategory.class, r100);
    }

    public MimeTypeCategory(String r100, int r101) {
        super(r100, r101);
    }
}
