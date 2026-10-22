package com.bytedance.ee.bear.creationmenu;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0012\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/creationmenu/SelectIndex;", "", "documentType", "", "<init>", "(Ljava/lang/String;II)V", "getDocumentType", "()I", PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "SHEET", PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE, "MEDIA", "FILE", "BITABLE", "SURVEY", "SLIDES", "UNKNOWN", "id", "Companion", "contentmanager-content-widget_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SelectIndex extends Enum<SelectIndex> {
    public static final SelectIndex BITABLE = null;
    public static final a Companion = null;
    public static final SelectIndex DOC = null;
    public static final SelectIndex DOCX = null;
    public static final SelectIndex FILE = null;
    public static final SelectIndex MEDIA = null;
    public static final SelectIndex MINDNOTE = null;
    public static final SelectIndex SHEET = null;
    public static final SelectIndex SLIDES = null;
    public static final SelectIndex SURVEY = null;
    public static final SelectIndex UNKNOWN = null;
    public static final /* synthetic */ SelectIndex[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int documentType;

    public static EnumEntries<SelectIndex> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.bytedance.ee.bear.creationmenu.SelectIndex$a] */
    static {
        SelectIndex r0 = new SelectIndex(PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, 0, 22);
        DOCX = r0;
        SelectIndex r1 = new SelectIndex(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 1, 2);
        DOC = r1;
        SelectIndex r3 = new SelectIndex("SHEET", 2, 3);
        SHEET = r3;
        SelectIndex r6 = new SelectIndex(PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE, 3, 11);
        MINDNOTE = r6;
        SelectIndex r8 = new SelectIndex("MEDIA", 4, 12);
        MEDIA = r8;
        SelectIndex r9 = new SelectIndex("FILE", 5, 12);
        FILE = r9;
        SelectIndex r11 = new SelectIndex("BITABLE", 6, 8);
        BITABLE = r11;
        SelectIndex r12 = new SelectIndex("SURVEY", 7, 8);
        SURVEY = r12;
        SelectIndex r14 = new SelectIndex("SLIDES", 8, 30);
        SLIDES = r14;
        SelectIndex r10 = new SelectIndex("UNKNOWN", 9, -1);
        UNKNOWN = r10;
        SelectIndex[] r7 = {r0, r1, r3, r6, r8, r9, r11, r12, r14, r10};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static SelectIndex[] values() {
        return (SelectIndex[]) a.clone();
    }

    public final int id() {
        return ordinal();
    }

    public final int getDocumentType() {
        return this.documentType;
    }

    public static SelectIndex valueOf(String r1) {
        return (SelectIndex) r27.a.a(SelectIndex.class, r1);
    }

    public SelectIndex(String r1, int r2, int r3) {
        super(r1, r2);
        this.documentType = r3;
    }
}
