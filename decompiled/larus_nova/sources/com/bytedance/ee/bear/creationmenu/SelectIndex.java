package com.bytedance.ee.bear.creationmenu;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SelectIndex[] f217279a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f217280b = null;
    private final int documentType;

    public static final class a {
        public a() {
        }

        public static SelectIndex a(int r100) {
            SelectIndex[] r101 = SelectIndex.values();
            if (r100 < 0) goto L8;
            if (r100 >= r101.length) goto L8;
            return r101[r100];
        L8:
            return SelectIndex.UNKNOWN;
        }
    }

    public static EnumEntries<SelectIndex> getEntries() {
        return f217280b;
    }

    static {
        SelectIndex r100 = new SelectIndex(PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, 0, 22);
        DOCX = r100;
        SelectIndex r101 = new SelectIndex(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 1, 2);
        DOC = r101;
        SelectIndex r102 = new SelectIndex("SHEET", 2, 3);
        SHEET = r102;
        SelectIndex r103 = new SelectIndex(PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE, 3, 11);
        MINDNOTE = r103;
        SelectIndex r104 = new SelectIndex("MEDIA", 4, 12);
        MEDIA = r104;
        SelectIndex r105 = new SelectIndex("FILE", 5, 12);
        FILE = r105;
        SelectIndex r110 = new SelectIndex("BITABLE", 6, 8);
        BITABLE = r110;
        SelectIndex r111 = new SelectIndex("SURVEY", 7, 8);
        SURVEY = r111;
        SelectIndex r112 = new SelectIndex("SLIDES", 8, 30);
        SLIDES = r112;
        SelectIndex r113 = new SelectIndex("UNKNOWN", 9, -1);
        UNKNOWN = r113;
        SelectIndex[] r106 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f217279a = r106;
        f217280b = EnumEntriesKt.enumEntries(r106);
        Companion = new a();
    }

    public static SelectIndex[] values() {
        return (SelectIndex[]) f217279a.clone();
    }

    public final int id() {
        return ordinal();
    }

    public final int getDocumentType() {
        return this.documentType;
    }

    public static SelectIndex valueOf(String r100) {
        return (SelectIndex) r27.a.a(SelectIndex.class, r100);
    }

    public SelectIndex(String r100, int r101, int r102) {
        super(r100, r101);
        this.documentType = r102;
    }
}
