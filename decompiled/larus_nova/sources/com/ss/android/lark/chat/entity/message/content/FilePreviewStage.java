package com.ss.android.lark.chat.entity.message.content;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/FilePreviewStage;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "UnknownStage", "Normal", "Encrypted", "NotSupportedType", "NotSupportedSize", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FilePreviewStage extends Enum<FilePreviewStage> {
    public static final a Companion = null;
    public static final FilePreviewStage Encrypted = null;
    public static final FilePreviewStage Normal = null;
    public static final FilePreviewStage NotSupportedSize = null;
    public static final FilePreviewStage NotSupportedType = null;
    public static final FilePreviewStage UnknownStage = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FilePreviewStage[] f415335a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415336b = null;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<FilePreviewStage> getEntries() {
        return f415336b;
    }

    static {
        FilePreviewStage r100 = new FilePreviewStage("UnknownStage", 0);
        UnknownStage = r100;
        FilePreviewStage r101 = new FilePreviewStage("Normal", 1);
        Normal = r101;
        FilePreviewStage r102 = new FilePreviewStage("Encrypted", 2);
        Encrypted = r102;
        FilePreviewStage r103 = new FilePreviewStage("NotSupportedType", 3);
        NotSupportedType = r103;
        FilePreviewStage r104 = new FilePreviewStage("NotSupportedSize", 4);
        NotSupportedSize = r104;
        FilePreviewStage[] r105 = {r100, r101, r102, r103, r104};
        f415335a = r105;
        f415336b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static FilePreviewStage[] values() {
        return (FilePreviewStage[]) f415335a.clone();
    }

    @JvmStatic
    public static final FilePreviewStage fromValue(int r100) {
        Companion.getClass();
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L19;
        if (r100 == 3) goto L18;
        if (r100 == 4) goto L17;
        return UnknownStage;
    L17:
        return NotSupportedSize;
    L18:
        return NotSupportedType;
    L19:
        return Encrypted;
    L15:
        return Normal;
    }

    public static FilePreviewStage valueOf(String r100) {
        return (FilePreviewStage) r27.a.a(FilePreviewStage.class, r100);
    }

    public FilePreviewStage(String r100, int r101) {
        super(r100, r101);
    }
}
