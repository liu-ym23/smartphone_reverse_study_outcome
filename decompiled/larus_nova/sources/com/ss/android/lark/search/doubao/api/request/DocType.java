package com.ss.android.lark.search.doubao.api.request;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/search/doubao/api/request/DocType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "SHEET", "BITABLE", PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE, "FILE", "SLIDE", "WIKI", PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, "FOLDER", "CATALOG", "SLIDES", "SHORTCUT", "DOCX_SYNCED_BLOCK", "Companion", "search-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DocType extends Enum<DocType> {
    public static final DocType BITABLE = null;
    public static final DocType CATALOG = null;
    public static final a Companion = null;
    public static final DocType DOC = null;
    public static final DocType DOCX = null;
    public static final DocType DOCX_SYNCED_BLOCK = null;
    public static final DocType FILE = null;
    public static final DocType FOLDER = null;
    public static final DocType MINDNOTE = null;
    public static final DocType SHEET = null;
    public static final DocType SHORTCUT = null;
    public static final DocType SLIDE = null;
    public static final DocType SLIDES = null;
    public static final DocType UNKNOWN = null;
    public static final DocType WIKI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DocType[] f439944a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f439945b = null;
    private final int value;

    public static EnumEntries<DocType> getEntries() {
        return f439945b;
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [com.ss.android.lark.search.doubao.api.request.DocType$a] */
    static {
        DocType r100 = new DocType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        DocType r101 = new DocType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 1, 1);
        DOC = r101;
        DocType r102 = new DocType("SHEET", 2, 2);
        SHEET = r102;
        DocType r103 = new DocType("BITABLE", 3, 3);
        BITABLE = r103;
        DocType r104 = new DocType(PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE, 4, 4);
        MINDNOTE = r104;
        DocType r105 = new DocType("FILE", 5, 5);
        FILE = r105;
        DocType r110 = new DocType("SLIDE", 6, 6);
        SLIDE = r110;
        DocType r111 = new DocType("WIKI", 7, 7);
        WIKI = r111;
        DocType r112 = new DocType(PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, 8, 8);
        DOCX = r112;
        DocType r113 = new DocType("FOLDER", 9, 9);
        FOLDER = r113;
        DocType r114 = new DocType("CATALOG", 10, 10);
        CATALOG = r114;
        DocType r115 = new DocType("SLIDES", 11, 11);
        SLIDES = r115;
        DocType r106 = new DocType("SHORTCUT", 12, 12);
        SHORTCUT = r106;
        DocType r107 = new DocType("DOCX_SYNCED_BLOCK", 13, 13);
        DOCX_SYNCED_BLOCK = r107;
        DocType[] r108 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107};
        f439944a = r108;
        f439945b = EnumEntriesKt.enumEntries(r108);
        Companion = new a();
    }

    public static DocType[] values() {
        return (DocType[]) f439944a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DocType valueOf(String r100) {
        return (DocType) r27.a.a(DocType.class, r100);
    }

    public DocType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
