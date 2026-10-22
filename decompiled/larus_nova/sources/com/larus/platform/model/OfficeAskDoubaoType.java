package com.larus.platform.model;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/platform/model/OfficeAskDoubaoType;", "", "configValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getConfigValue", "()Ljava/lang/String;", "FILE", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "PPT", "SHEET", "BITABLE", PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE, "WIKI", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeAskDoubaoType extends Enum<OfficeAskDoubaoType> {

    @SerializedName(DocumentType.BITABLE_NAME)
    public static final OfficeAskDoubaoType BITABLE = null;

    @SerializedName("doc")
    public static final OfficeAskDoubaoType DOC = null;

    @SerializedName("file")
    public static final OfficeAskDoubaoType FILE = null;

    @SerializedName(DocumentType.MINDNOTE_NAME)
    public static final OfficeAskDoubaoType MINDNOTE = null;

    @SerializedName("ppt")
    public static final OfficeAskDoubaoType PPT = null;

    @SerializedName(DocumentType.SHEET_NAME)
    public static final OfficeAskDoubaoType SHEET = null;

    @SerializedName("wiki")
    public static final OfficeAskDoubaoType WIKI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeAskDoubaoType[] f365479a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365480b = null;
    private final String configValue;

    public static EnumEntries<OfficeAskDoubaoType> getEntries() {
        return f365480b;
    }

    static {
        OfficeAskDoubaoType r100 = new OfficeAskDoubaoType("FILE", 0, "file");
        FILE = r100;
        OfficeAskDoubaoType r101 = new OfficeAskDoubaoType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 1, "doc");
        DOC = r101;
        OfficeAskDoubaoType r102 = new OfficeAskDoubaoType("PPT", 2, "ppt");
        PPT = r102;
        OfficeAskDoubaoType r103 = new OfficeAskDoubaoType("SHEET", 3, DocumentType.SHEET_NAME);
        SHEET = r103;
        OfficeAskDoubaoType r104 = new OfficeAskDoubaoType("BITABLE", 4, DocumentType.BITABLE_NAME);
        BITABLE = r104;
        OfficeAskDoubaoType r105 = new OfficeAskDoubaoType(PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE, 5, DocumentType.MINDNOTE_NAME);
        MINDNOTE = r105;
        OfficeAskDoubaoType r110 = new OfficeAskDoubaoType("WIKI", 6, "wiki");
        WIKI = r110;
        OfficeAskDoubaoType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f365479a = r111;
        f365480b = EnumEntriesKt.enumEntries(r111);
    }

    public static OfficeAskDoubaoType[] values() {
        return (OfficeAskDoubaoType[]) f365479a.clone();
    }

    public final String getConfigValue() {
        return this.configValue;
    }

    public static OfficeAskDoubaoType valueOf(String r100) {
        return (OfficeAskDoubaoType) a.a(OfficeAskDoubaoType.class, r100);
    }

    public OfficeAskDoubaoType(String r100, int r101, String r102) {
        super(r100, r101);
        this.configValue = r102;
    }
}
