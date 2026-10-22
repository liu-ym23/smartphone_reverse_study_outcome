package com.bytedance.ee.bear.office.common.upload;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0013\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadFileType;", "", "iconResId", "", "<init>", "(Ljava/lang/String;II)V", "getIconResId", "()I", "DOC", "PPT", "SHEET", "IMAGE", "VIDEO", "PDF", "UNKNOWN", "Companion", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeUploadFileType extends Enum<OfficeUploadFileType> {
    public static final a Companion = null;
    public static final OfficeUploadFileType DOC = null;
    public static final OfficeUploadFileType IMAGE = null;
    public static final OfficeUploadFileType PDF = null;
    public static final OfficeUploadFileType PPT = null;
    public static final OfficeUploadFileType SHEET = null;
    public static final OfficeUploadFileType UNKNOWN = null;
    public static final OfficeUploadFileType VIDEO = null;
    public static final /* synthetic */ OfficeUploadFileType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int iconResId;

    public static final class a {
        public a() {
        }

        public static OfficeUploadFileType a(String r4) {
            Intrinsics.checkNotNullParameter(r4, "fileName");
            String r5 = r4.toLowerCase(Locale.ROOT);
            if (StringsKt.endsWith$default(r5, ".doc", false, 2, null) == true) goto L44;
            if (StringsKt.endsWith$default(r5, ".docx", false, 2, null) == true) goto L44;
            if (StringsKt.endsWith$default(r5, ".ppt", false, 2, null) == true) goto L50;
            if (StringsKt.endsWith$default(r5, ".pptx", false, 2, null) == true) goto L50;
            if (StringsKt.endsWith$default(r5, ".xls", false, 2, null) == true) goto L49;
            if (StringsKt.endsWith$default(r5, ".xlsx", false, 2, null) == true) goto L49;
            if (StringsKt.endsWith$default(r5, ".png", false, 2, null) == true) goto L48;
            if (StringsKt.endsWith$default(r5, ".jpg", false, 2, null) == true) goto L48;
            if (StringsKt.endsWith$default(r5, ".jpeg", false, 2, null) == true) goto L48;
            if (StringsKt.endsWith$default(r5, ".gif", false, 2, null) == true) goto L48;
            if (StringsKt.endsWith$default(r5, ".webp", false, 2, null) == true) goto L48;
            if (StringsKt.endsWith$default(r5, ".mp4", false, 2, null) == true) goto L47;
            if (StringsKt.endsWith$default(r5, ".mov", false, 2, null) == true) goto L47;
            if (StringsKt.endsWith$default(r5, ".avi", false, 2, null) == true) goto L47;
            if (StringsKt.endsWith$default(r5, ".pdf", false, 2, null) == false) goto L46;
            return OfficeUploadFileType.PDF;
        L46:
            return OfficeUploadFileType.UNKNOWN;
        L47:
            return OfficeUploadFileType.VIDEO;
        L48:
            return OfficeUploadFileType.IMAGE;
        L49:
            return OfficeUploadFileType.SHEET;
        L50:
            return OfficeUploadFileType.PPT;
        L44:
            return OfficeUploadFileType.DOC;
        }
    }

    public static EnumEntries<OfficeUploadFileType> getEntries() {
        return b;
    }

    static {
        OfficeUploadFileType r0 = new OfficeUploadFileType("DOC", 0, 2131233748);
        DOC = r0;
        OfficeUploadFileType r1 = new OfficeUploadFileType("PPT", 1, 2131233747);
        PPT = r1;
        OfficeUploadFileType r3 = new OfficeUploadFileType("SHEET", 2, 2131233749);
        SHEET = r3;
        OfficeUploadFileType r5 = new OfficeUploadFileType("IMAGE", 3, 2131233754);
        IMAGE = r5;
        OfficeUploadFileType r7 = new OfficeUploadFileType("VIDEO", 4, 2131244689);
        VIDEO = r7;
        OfficeUploadFileType r9 = new OfficeUploadFileType("PDF", 5, 2131244689);
        PDF = r9;
        OfficeUploadFileType r12 = new OfficeUploadFileType("UNKNOWN", 6, 2131244689);
        UNKNOWN = r12;
        OfficeUploadFileType[] r11 = {r0, r1, r3, r5, r7, r9, r12};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
        Companion = new a();
    }

    public static OfficeUploadFileType[] values() {
        return (OfficeUploadFileType[]) a.clone();
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    public static OfficeUploadFileType valueOf(String r1) {
        return (OfficeUploadFileType) r27.a.a(OfficeUploadFileType.class, r1);
    }

    public OfficeUploadFileType(String r1, int r2, int r3) {
        super(r1, r2);
        this.iconResId = r3;
    }
}
