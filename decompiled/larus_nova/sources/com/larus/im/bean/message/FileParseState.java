package com.larus.im.bean.message;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/im/bean/message/FileParseState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "SUCCESS", "FAILED", "PROCESSING", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FileParseState extends Enum<FileParseState> {
    public static final a Companion = null;
    public static final FileParseState DEFAULT = null;
    public static final FileParseState FAILED = null;
    public static final FileParseState PROCESSING = null;
    public static final FileParseState SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FileParseState[] f346627a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346628b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<FileParseState> getEntries() {
        return f346628b;
    }

    static {
        FileParseState r100 = new FileParseState("DEFAULT", 0, 0);
        DEFAULT = r100;
        FileParseState r101 = new FileParseState("SUCCESS", 1, 1);
        SUCCESS = r101;
        FileParseState r102 = new FileParseState("FAILED", 2, 2);
        FAILED = r102;
        FileParseState r103 = new FileParseState("PROCESSING", 3, 3);
        PROCESSING = r103;
        FileParseState[] r104 = {r100, r101, r102, r103};
        f346627a = r104;
        f346628b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static FileParseState[] values() {
        return (FileParseState[]) f346627a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FileParseState valueOf(String r100) {
        return (FileParseState) r27.a.a(FileParseState.class, r100);
    }

    public FileParseState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
