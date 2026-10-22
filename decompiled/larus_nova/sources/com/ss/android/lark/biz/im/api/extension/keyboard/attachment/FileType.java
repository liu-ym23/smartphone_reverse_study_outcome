package com.ss.android.lark.biz.im.api.extension.keyboard.attachment;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/FileType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FileTypeUnknown", "FileTypeFile", "FileTypeOCRImage", "FileTypeAudio", "FileTypeVideo", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FileType extends Enum<FileType> {
    public static final FileType FileTypeAudio = null;
    public static final FileType FileTypeFile = null;

    @Deprecated(message = "aborted")
    public static final FileType FileTypeOCRImage = null;
    public static final FileType FileTypeUnknown = null;
    public static final FileType FileTypeVideo = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FileType[] f410133a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410134b = null;
    private final int value;

    public static EnumEntries<FileType> getEntries() {
        return f410134b;
    }

    static {
        FileType r100 = new FileType("FileTypeUnknown", 0, 0);
        FileTypeUnknown = r100;
        FileType r101 = new FileType("FileTypeFile", 1, 1);
        FileTypeFile = r101;
        FileType r102 = new FileType("FileTypeOCRImage", 2, 2);
        FileTypeOCRImage = r102;
        FileType r103 = new FileType("FileTypeAudio", 3, 3);
        FileTypeAudio = r103;
        FileType r104 = new FileType("FileTypeVideo", 4, 4);
        FileTypeVideo = r104;
        FileType[] r105 = {r100, r101, r102, r103, r104};
        f410133a = r105;
        f410134b = EnumEntriesKt.enumEntries(r105);
    }

    public static FileType[] values() {
        return (FileType[]) f410133a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FileType valueOf(String r100) {
        return (FileType) a.a(FileType.class, r100);
    }

    public FileType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
