package com.larus.im.bean.message;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/im/bean/message/FileReviewState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "ACCESS", "NOT_COMPLIANT", "PROCESSING", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FileReviewState extends Enum<FileReviewState> {
    public static final FileReviewState ACCESS = null;
    public static final a Companion = null;
    public static final FileReviewState DEFAULT = null;
    public static final FileReviewState NOT_COMPLIANT = null;
    public static final FileReviewState PROCESSING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FileReviewState[] f346629a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346630b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<FileReviewState> getEntries() {
        return f346630b;
    }

    static {
        FileReviewState r100 = new FileReviewState("DEFAULT", 0, 0);
        DEFAULT = r100;
        FileReviewState r101 = new FileReviewState("ACCESS", 1, 1);
        ACCESS = r101;
        FileReviewState r102 = new FileReviewState("NOT_COMPLIANT", 2, 2);
        NOT_COMPLIANT = r102;
        FileReviewState r103 = new FileReviewState("PROCESSING", 3, 3);
        PROCESSING = r103;
        FileReviewState[] r104 = {r100, r101, r102, r103};
        f346629a = r104;
        f346630b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static FileReviewState[] values() {
        return (FileReviewState[]) f346629a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FileReviewState valueOf(String r100) {
        return (FileReviewState) r27.a.a(FileReviewState.class, r100);
    }

    public FileReviewState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
