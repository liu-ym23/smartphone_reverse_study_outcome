package com.ss.android.lark.filedetail.impl.folder.manage.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/entity/FileType;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "UNKNOWN", "FILE", "IMAGE", "STICKER", "AUDIO", "MEDIA", "LARK_LOG", "AVATAR", "THIRD_PARTY", "FOLDER", "Companion", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FileType extends Enum<FileType> {
    public static final FileType AUDIO = null;
    public static final FileType AVATAR = null;
    public static final a Companion = null;
    public static final FileType FILE = null;
    public static final FileType FOLDER = null;
    public static final FileType IMAGE = null;
    public static final FileType LARK_LOG = null;
    public static final FileType MEDIA = null;
    public static final FileType STICKER = null;
    public static final FileType THIRD_PARTY = null;
    public static final FileType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FileType[] f421684a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f421685b = null;
    private final int number;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<FileType> getEntries() {
        return f421685b;
    }

    static {
        FileType r100 = new FileType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        FileType r101 = new FileType("FILE", 1, 1);
        FILE = r101;
        FileType r102 = new FileType("IMAGE", 2, 2);
        IMAGE = r102;
        FileType r103 = new FileType("STICKER", 3, 3);
        STICKER = r103;
        FileType r104 = new FileType("AUDIO", 4, 4);
        AUDIO = r104;
        FileType r105 = new FileType("MEDIA", 5, 5);
        MEDIA = r105;
        FileType r110 = new FileType("LARK_LOG", 6, 6);
        LARK_LOG = r110;
        FileType r111 = new FileType("AVATAR", 7, 7);
        AVATAR = r111;
        FileType r112 = new FileType("THIRD_PARTY", 8, 8);
        THIRD_PARTY = r112;
        FileType r113 = new FileType("FOLDER", 9, 9);
        FOLDER = r113;
        FileType[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f421684a = r114;
        f421685b = EnumEntriesKt.enumEntries(r114);
        Companion = new a();
    }

    public static FileType[] values() {
        return (FileType[]) f421684a.clone();
    }

    public final int getNumber() {
        return this.number;
    }

    public static FileType valueOf(String r100) {
        return (FileType) r27.a.a(FileType.class, r100);
    }

    public FileType(String r100, int r101, int r102) {
        super(r100, r101);
        this.number = r102;
    }
}
