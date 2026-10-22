package com.bytedance.ee.bear.bitable.context;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/context/BitableBlockType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNSPECIFIED", "TABLE", "DASHBOARD", "WORKFLOW", PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, "docs-bitable-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BitableBlockType extends Enum<BitableBlockType> {
    public static final BitableBlockType DASHBOARD = null;
    public static final BitableBlockType DOCX = null;
    public static final BitableBlockType TABLE = null;
    public static final BitableBlockType UNSPECIFIED = null;
    public static final BitableBlockType WORKFLOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BitableBlockType[] f210062a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f210063b = null;
    private final int value;

    public static EnumEntries<BitableBlockType> getEntries() {
        return f210063b;
    }

    static {
        BitableBlockType r100 = new BitableBlockType("UNSPECIFIED", 0, 0);
        UNSPECIFIED = r100;
        BitableBlockType r101 = new BitableBlockType("TABLE", 1, 1);
        TABLE = r101;
        BitableBlockType r102 = new BitableBlockType("DASHBOARD", 2, 2);
        DASHBOARD = r102;
        BitableBlockType r103 = new BitableBlockType("WORKFLOW", 3, 3);
        WORKFLOW = r103;
        BitableBlockType r104 = new BitableBlockType(PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, 4, 4);
        DOCX = r104;
        BitableBlockType[] r105 = {r100, r101, r102, r103, r104};
        f210062a = r105;
        f210063b = EnumEntriesKt.enumEntries(r105);
    }

    public static BitableBlockType[] values() {
        return (BitableBlockType[]) f210062a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static BitableBlockType valueOf(String r100) {
        return (BitableBlockType) a.a(BitableBlockType.class, r100);
    }

    public BitableBlockType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
