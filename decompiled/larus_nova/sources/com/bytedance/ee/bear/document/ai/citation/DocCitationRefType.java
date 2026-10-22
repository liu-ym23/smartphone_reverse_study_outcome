package com.bytedance.ee.bear.document.ai.citation;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\u0081\u0002\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001 B+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/citation/DocCitationRefType;", "", "value", "", "iconResName", "", "resId", "colorFilter", "<init>", "(Ljava/lang/String;IILjava/lang/String;II)V", "getValue", "()I", "getIconResName", "()Ljava/lang/String;", "getResId", "getColorFilter", "UNKNOWN", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "MESSAGE", "LINGO", "HELPDESK", "OUTLINK", "MINUTES", "UPLOADFILE", "GOOGLEDRIVE", "SLACKMSG", "MINOPAGE", "COMMENT", "BASE", "SHEET", "EXCEL", "MAIL", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DocCitationRefType extends Enum<DocCitationRefType> {
    public static final DocCitationRefType BASE = null;
    public static final DocCitationRefType COMMENT = null;
    public static final a Companion = null;
    public static final DocCitationRefType DOC = null;
    public static final DocCitationRefType EXCEL = null;
    public static final DocCitationRefType GOOGLEDRIVE = null;
    public static final DocCitationRefType HELPDESK = null;
    public static final DocCitationRefType LINGO = null;
    public static final DocCitationRefType MAIL = null;
    public static final DocCitationRefType MESSAGE = null;
    public static final DocCitationRefType MINOPAGE = null;
    public static final DocCitationRefType MINUTES = null;
    public static final DocCitationRefType OUTLINK = null;
    public static final DocCitationRefType SHEET = null;
    public static final DocCitationRefType SLACKMSG = null;
    public static final DocCitationRefType UNKNOWN = null;
    public static final DocCitationRefType UPLOADFILE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DocCitationRefType[] f218751a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f218752b = null;
    private final int colorFilter;
    private final String iconResName;
    private final int resId;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<DocCitationRefType> getEntries() {
        return f218752b;
    }

    static {
        DocCitationRefType r100 = new DocCitationRefType("UNKNOWN", 0, 0, "LinkCopyOutlined", kac.a.b(R.drawable.ud_icon_file_round_link_blue_colorful), 0, 8, null);
        UNKNOWN = r100;
        int r110 = 0;
        int r111 = 8;
        DefaultConstructorMarker r112 = null;
        DocCitationRefType r101 = new DocCitationRefType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 1, 1, "FileLinkDocxOutlined", kac.a.b(R.drawable.ud_icon_file_docx_colorful), r110, r111, r112);
        DOC = r101;
        DocCitationRefType r102 = new DocCitationRefType("MESSAGE", 2, 2, "ChatOutlined", R.drawable.ud_icon_chat_filled, R.color.colorful_blue);
        MESSAGE = r102;
        DocCitationRefType r103 = new DocCitationRefType("LINGO", 3, 3, "TeampediaOutlined", R.drawable.ud_icon_teampedia_colorful, r110, r111, r112);
        LINGO = r103;
        int r310 = 0;
        int r311 = 8;
        DefaultConstructorMarker r312 = null;
        DocCitationRefType r104 = new DocCitationRefType("HELPDESK", 4, 4, "HelpdeskOutlined", R.drawable.ud_icon_helpdesk_colorful, r310, r311, r312);
        HELPDESK = r104;
        DocCitationRefType r105 = new DocCitationRefType("OUTLINK", 5, 5, "LinkCopyOutlined", kac.a.b(R.drawable.ud_icon_file_round_link_blue_colorful), r110, r111, r112);
        OUTLINK = r105;
        DocCitationRefType r106 = new DocCitationRefType("MINUTES", 6, 6, "MinutesLogoFilled", R.drawable.ud_icon_tab_minutes_logo_colorful, r310, r311, r312);
        MINUTES = r106;
        DocCitationRefType r210 = new DocCitationRefType("UPLOADFILE", 7, 7, "LinkCopyOutlined", kac.a.b(R.drawable.ud_icon_file_round_link_blue_colorful), r110, r111, r112);
        UPLOADFILE = r210;
        DocCitationRefType r313 = new DocCitationRefType("GOOGLEDRIVE", 8, 8, "LinkCopyOutlined", kac.a.b(R.drawable.ud_icon_file_round_link_blue_colorful), 0, 8, null);
        GOOGLEDRIVE = r313;
        DocCitationRefType r211 = new DocCitationRefType("SLACKMSG", 9, 9, "LinkCopyOutlined", kac.a.b(R.drawable.ud_icon_file_round_link_blue_colorful), 0, 8, null);
        SLACKMSG = r211;
        DocCitationRefType r212 = new DocCitationRefType("MINOPAGE", 10, 10, "LinkCopyOutlined", kac.a.b(R.drawable.ud_icon_file_round_link_blue_colorful), 0, 8, null);
        MINOPAGE = r212;
        DocCitationRefType r107 = new DocCitationRefType("COMMENT", 11, 11, "AddCommentOutlined", R.drawable.ud_icon_add_comment_filled, R.color.colorful_blue);
        COMMENT = r107;
        int r113 = 0;
        int r114 = 8;
        DefaultConstructorMarker r115 = null;
        DocCitationRefType r108 = new DocCitationRefType("BASE", 12, 12, "FileLinkBitableOutlined", kac.a.b(R.drawable.ud_icon_file_bitable_colorful), r113, r114, r115);
        BASE = r108;
        int r410 = 0;
        int r411 = 8;
        DefaultConstructorMarker r412 = null;
        DocCitationRefType r109 = new DocCitationRefType("SHEET", 13, 13, "FileLinkSheetOutlined", kac.a.b(R.drawable.ud_icon_file_sheet_colorful), r410, r411, r412);
        SHEET = r109;
        DocCitationRefType r116 = new DocCitationRefType("EXCEL", 14, 14, "FileLinkExcelOutlined", kac.a.b(R.drawable.ud_icon_file_excel_colorful), r113, r114, r115);
        EXCEL = r116;
        DocCitationRefType r117 = new DocCitationRefType("MAIL", 15, 15, "MailOutlined", R.drawable.ud_icon_tab_mail_colorful, r410, r411, r412);
        MAIL = r117;
        DocCitationRefType[] r118 = {r100, r101, r102, r103, r104, r105, r106, r210, r313, r211, r212, r107, r108, r109, r116, r117};
        f218751a = r118;
        f218752b = EnumEntriesKt.enumEntries(r118);
        Companion = new a();
    }

    public static DocCitationRefType[] values() {
        return (DocCitationRefType[]) f218751a.clone();
    }

    public final int getColorFilter() {
        return this.colorFilter;
    }

    public final String getIconResName() {
        return this.iconResName;
    }

    public final int getResId() {
        return this.resId;
    }

    public final int getValue() {
        return this.value;
    }

    public static DocCitationRefType valueOf(String r100) {
        return (DocCitationRefType) r27.a.a(DocCitationRefType.class, r100);
    }

    public DocCitationRefType(String r100, int r101, int r102, String r103, int r104, int r105) {
        super(r100, r101);
        this.value = r102;
        this.iconResName = r103;
        this.resId = r104;
        this.colorFilter = r105;
    }

    public /* synthetic */ DocCitationRefType(String r100, int r101, int r110, String r111, int r112, int r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 8) == 0) goto L5;
        int r102 = -1;
    L6:
        this(r100, r101, r110, r111, r112, r102);
        return;
    L5:
        r102 = r113;
        goto L6
    }
}
