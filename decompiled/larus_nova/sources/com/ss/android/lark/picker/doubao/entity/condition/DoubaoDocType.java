package com.ss.android.lark.picker.doubao.entity.condition;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/picker/doubao/entity/condition/DoubaoDocType;", "", "<init>", "(Ljava/lang/String;I)V", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "FOLDER", "WIKI", "BITABLE", PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE, PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, "FILE", "SLIDES", "SHEET", "picker-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoubaoDocType extends Enum<DoubaoDocType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DoubaoDocType[] $VALUES = null;
    public static final DoubaoDocType BITABLE = null;
    public static final DoubaoDocType DOC = null;
    public static final DoubaoDocType DOCX = null;
    public static final DoubaoDocType FILE = null;
    public static final DoubaoDocType FOLDER = null;
    public static final DoubaoDocType MINDNOTE = null;
    public static final DoubaoDocType SHEET = null;
    public static final DoubaoDocType SLIDES = null;
    public static final DoubaoDocType WIKI = null;

    private static final /* synthetic */ DoubaoDocType[] $values() {
        return new DoubaoDocType[]{DOC, FOLDER, WIKI, BITABLE, MINDNOTE, DOCX, FILE, SLIDES, SHEET};
    }

    public static EnumEntries<DoubaoDocType> getEntries() {
        return $ENTRIES;
    }

    static {
        DOC = new DoubaoDocType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 0);
        FOLDER = new DoubaoDocType("FOLDER", 1);
        WIKI = new DoubaoDocType("WIKI", 2);
        BITABLE = new DoubaoDocType("BITABLE", 3);
        MINDNOTE = new DoubaoDocType(PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE, 4);
        DOCX = new DoubaoDocType(PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, 5);
        FILE = new DoubaoDocType("FILE", 6);
        SLIDES = new DoubaoDocType("SLIDES", 7);
        SHEET = new DoubaoDocType("SHEET", 8);
        DoubaoDocType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static DoubaoDocType[] values() {
        return (DoubaoDocType[]) $VALUES.clone();
    }

    public static DoubaoDocType valueOf(String r100) {
        return (DoubaoDocType) a.a(DoubaoDocType.class, r100);
    }

    private DoubaoDocType(String r100, int r101) {
        super(r100, r101);
    }
}
