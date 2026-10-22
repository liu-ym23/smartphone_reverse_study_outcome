package com.larus.bmhome.chat.markdown.code;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/markdown/code/CodeClickActionEnum;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CLICK_ACTION_COPY", "CLICK_ACTION_FULL_SCREEN", "CLICK_ACTION_PREVIEW", "CLICK_ACTION_SWITCH_TAB_GRAPH", "CLICK_ACTION_SWITCH_TAB_CODE", "CLICK_ACTION_DOWNLOAD_PICTURE", "CLICK_ACTION_DOWNLOAD_CODE", "CLICK_ACTION_OTHERS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CodeClickActionEnum extends Enum<CodeClickActionEnum> {
    public static final CodeClickActionEnum CLICK_ACTION_COPY = null;
    public static final CodeClickActionEnum CLICK_ACTION_DOWNLOAD_CODE = null;
    public static final CodeClickActionEnum CLICK_ACTION_DOWNLOAD_PICTURE = null;
    public static final CodeClickActionEnum CLICK_ACTION_FULL_SCREEN = null;
    public static final CodeClickActionEnum CLICK_ACTION_OTHERS = null;
    public static final CodeClickActionEnum CLICK_ACTION_PREVIEW = null;
    public static final CodeClickActionEnum CLICK_ACTION_SWITCH_TAB_CODE = null;
    public static final CodeClickActionEnum CLICK_ACTION_SWITCH_TAB_GRAPH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CodeClickActionEnum[] f306956a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f306957b = null;
    private final String value;

    public static EnumEntries<CodeClickActionEnum> getEntries() {
        return f306957b;
    }

    static {
        CodeClickActionEnum r100 = new CodeClickActionEnum("CLICK_ACTION_COPY", 0, "copy");
        CLICK_ACTION_COPY = r100;
        CodeClickActionEnum r101 = new CodeClickActionEnum("CLICK_ACTION_FULL_SCREEN", 1, "full_screen");
        CLICK_ACTION_FULL_SCREEN = r101;
        CodeClickActionEnum r102 = new CodeClickActionEnum("CLICK_ACTION_PREVIEW", 2, "preview");
        CLICK_ACTION_PREVIEW = r102;
        CodeClickActionEnum r103 = new CodeClickActionEnum("CLICK_ACTION_SWITCH_TAB_GRAPH", 3, "to_graph");
        CLICK_ACTION_SWITCH_TAB_GRAPH = r103;
        CodeClickActionEnum r104 = new CodeClickActionEnum("CLICK_ACTION_SWITCH_TAB_CODE", 4, "to_code");
        CLICK_ACTION_SWITCH_TAB_CODE = r104;
        CodeClickActionEnum r105 = new CodeClickActionEnum("CLICK_ACTION_DOWNLOAD_PICTURE", 5, "download_picture");
        CLICK_ACTION_DOWNLOAD_PICTURE = r105;
        CodeClickActionEnum r110 = new CodeClickActionEnum("CLICK_ACTION_DOWNLOAD_CODE", 6, "download_code");
        CLICK_ACTION_DOWNLOAD_CODE = r110;
        CodeClickActionEnum r111 = new CodeClickActionEnum("CLICK_ACTION_OTHERS", 7, "others");
        CLICK_ACTION_OTHERS = r111;
        CodeClickActionEnum[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f306956a = r112;
        f306957b = EnumEntriesKt.enumEntries(r112);
    }

    public static CodeClickActionEnum[] values() {
        return (CodeClickActionEnum[]) f306956a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static CodeClickActionEnum valueOf(String r100) {
        return (CodeClickActionEnum) r27.a.a(CodeClickActionEnum.class, r100);
    }

    public CodeClickActionEnum(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
