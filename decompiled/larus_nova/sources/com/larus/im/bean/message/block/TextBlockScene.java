package com.larus.im.bean.message.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/im/bean/message/block/TextBlockScene;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "TEXT_BLOCK_DEFAULT", "TEXT_BLOCK_LONG_FILE_PARSE_LIMIT_TIPS", "TEXT_BLOCK_AIDOC", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TextBlockScene extends Enum<TextBlockScene> {
    public static final TextBlockScene TEXT_BLOCK_AIDOC = null;
    public static final TextBlockScene TEXT_BLOCK_DEFAULT = null;
    public static final TextBlockScene TEXT_BLOCK_LONG_FILE_PARSE_LIMIT_TIPS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TextBlockScene[] f347078a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f347079b = null;
    private final int type;

    public static EnumEntries<TextBlockScene> getEntries() {
        return f347079b;
    }

    static {
        TextBlockScene r100 = new TextBlockScene("TEXT_BLOCK_DEFAULT", 0, 0);
        TEXT_BLOCK_DEFAULT = r100;
        TextBlockScene r101 = new TextBlockScene("TEXT_BLOCK_LONG_FILE_PARSE_LIMIT_TIPS", 1, 1);
        TEXT_BLOCK_LONG_FILE_PARSE_LIMIT_TIPS = r101;
        TextBlockScene r102 = new TextBlockScene("TEXT_BLOCK_AIDOC", 2, 2);
        TEXT_BLOCK_AIDOC = r102;
        TextBlockScene[] r103 = {r100, r101, r102};
        f347078a = r103;
        f347079b = EnumEntriesKt.enumEntries(r103);
    }

    public static TextBlockScene[] values() {
        return (TextBlockScene[]) f347078a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static TextBlockScene valueOf(String r100) {
        return (TextBlockScene) a.a(TextBlockScene.class, r100);
    }

    public TextBlockScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
