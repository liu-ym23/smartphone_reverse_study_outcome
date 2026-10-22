package com.bytedance.ee.bear.document.ai.citation;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
    public static final /* synthetic */ DocCitationRefType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int colorFilter;
    private final String iconResName;
    private final int resId;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<DocCitationRefType> getEntries() {
        return b;
    }

    static {
        DocCitationRefType r9 = new DocCitationRefType("UNKNOWN", 0, 0, "LinkCopyOutlined", kac.a.b(2131254649), 0, 8, null);
        UNKNOWN = r9;
        int r17 = 0;
        int r18 = 8;
        DefaultConstructorMarker r19 = null;
        DocCitationRefType r0 = new DocCitationRefType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 1, 1, "FileLinkDocxOutlined", kac.a.b(2131254436), r17, r18, r19);
        DOC = r0;
        DocCitationRefType r8 = new DocCitationRefType("MESSAGE", 2, 2, "ChatOutlined", 2131254087, 2131101111);
        MESSAGE = r8;
        DocCitationRefType r1 = new DocCitationRefType("LINGO", 3, 3, "TeampediaOutlined", 2131255977, r17, r18, r19);
        LINGO = r1;
        int r32 = 0;
        int r33 = 8;
        DefaultConstructorMarker r34 = null;
        DocCitationRefType r2 = new DocCitationRefType("HELPDESK", 4, 4, "HelpdeskOutlined", 2131254863, r32, r33, r34);
        HELPDESK = r2;
        DocCitationRefType r6 = new DocCitationRefType("OUTLINK", 5, 5, "LinkCopyOutlined", kac.a.b(2131254649), r17, r18, r19);
        OUTLINK = r6;
        DocCitationRefType r7 = new DocCitationRefType("MINUTES", 6, 6, "MinutesLogoFilled", 2131255935, r32, r33, r34);
        MINUTES = r7;
        DocCitationRefType r26 = new DocCitationRefType("UPLOADFILE", 7, 7, "LinkCopyOutlined", kac.a.b(2131254649), r17, r18, r19);
        UPLOADFILE = r26;
        DocCitationRefType r36 = new DocCitationRefType("GOOGLEDRIVE", 8, 8, "LinkCopyOutlined", kac.a.b(2131254649), 0, 8, null);
        GOOGLEDRIVE = r36;
        DocCitationRefType r27 = new DocCitationRefType("SLACKMSG", 9, 9, "LinkCopyOutlined", kac.a.b(2131254649), 0, 8, null);
        SLACKMSG = r27;
        DocCitationRefType r20 = new DocCitationRefType("MINOPAGE", 10, 10, "LinkCopyOutlined", kac.a.b(2131254649), 0, 8, null);
        MINOPAGE = r20;
        DocCitationRefType r3 = new DocCitationRefType("COMMENT", 11, 11, "AddCommentOutlined", 2131253537, 2131101111);
        COMMENT = r3;
        int r16 = 0;
        int r110 = 8;
        DefaultConstructorMarker r111 = null;
        DocCitationRefType r4 = new DocCitationRefType("BASE", 12, 12, "FileLinkBitableOutlined", kac.a.b(2131254400), r16, r110, r111);
        BASE = r4;
        int r43 = 0;
        int r44 = 8;
        DefaultConstructorMarker r46 = null;
        DocCitationRefType r5 = new DocCitationRefType("SHEET", 13, 13, "FileLinkSheetOutlined", kac.a.b(2131254696), r43, r44, r46);
        SHEET = r5;
        DocCitationRefType r112 = new DocCitationRefType("EXCEL", 14, 14, "FileLinkExcelOutlined", kac.a.b(2131254443), r16, r110, r111);
        EXCEL = r112;
        DocCitationRefType r10 = new DocCitationRefType("MAIL", 15, 15, "MailOutlined", 2131255931, r43, r44, r46);
        MAIL = r10;
        DocCitationRefType[] r11 = {r9, r0, r8, r1, r2, r6, r7, r26, r36, r27, r20, r3, r4, r5, r112, r10};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
        Companion = new a();
    }

    public static DocCitationRefType[] values() {
        return (DocCitationRefType[]) a.clone();
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

    public static DocCitationRefType valueOf(String r1) {
        return (DocCitationRefType) r27.a.a(DocCitationRefType.class, r1);
    }

    public DocCitationRefType(String r1, int r2, int r3, String r4, int r5, int r6) {
        super(r1, r2);
        this.value = r3;
        this.iconResName = r4;
        this.resId = r5;
        this.colorFilter = r6;
    }

    public /* synthetic */ DocCitationRefType(String r8, int r9, int r10, String r11, int r12, int r13, int r14, DefaultConstructorMarker r16) {
        if ((r14 & 8) == 0) goto L5;
        int r6 = -1;
    L6:
        this(r8, r9, r10, r11, r12, r6);
        return;
    L5:
        r6 = r13;
        goto L6
    }
}
