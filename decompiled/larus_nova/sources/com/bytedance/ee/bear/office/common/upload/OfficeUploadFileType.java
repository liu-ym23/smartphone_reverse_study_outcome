package com.bytedance.ee.bear.office.common.upload;

import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.larus.nova.R;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0013\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadFileType;", "", "iconResId", "", "<init>", "(Ljava/lang/String;II)V", "getIconResId", "()I", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "PPT", "SHEET", "IMAGE", "VIDEO", "PDF", "UNKNOWN", "Companion", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeUploadFileType extends Enum<OfficeUploadFileType> {
    public static final a Companion = null;
    public static final OfficeUploadFileType DOC = null;
    public static final OfficeUploadFileType IMAGE = null;
    public static final OfficeUploadFileType PDF = null;
    public static final OfficeUploadFileType PPT = null;
    public static final OfficeUploadFileType SHEET = null;
    public static final OfficeUploadFileType UNKNOWN = null;
    public static final OfficeUploadFileType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeUploadFileType[] f235268a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f235269b = null;
    private final int iconResId;

    public static final class a {
        public a() {
        }

        public static OfficeUploadFileType a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "fileName");
            String r101 = r100.toLowerCase(Locale.ROOT);
            if (StringsKt.endsWith$default(r101, ".doc", false, 2, null) == true) goto L44;
            if (StringsKt.endsWith$default(r101, ".docx", false, 2, null) == true) goto L44;
            if (StringsKt.endsWith$default(r101, ".ppt", false, 2, null) == true) goto L50;
            if (StringsKt.endsWith$default(r101, ".pptx", false, 2, null) == true) goto L50;
            if (StringsKt.endsWith$default(r101, ".xls", false, 2, null) == true) goto L49;
            if (StringsKt.endsWith$default(r101, ".xlsx", false, 2, null) == true) goto L49;
            if (StringsKt.endsWith$default(r101, RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT, false, 2, null) == true) goto L48;
            if (StringsKt.endsWith$default(r101, ".jpg", false, 2, null) == true) goto L48;
            if (StringsKt.endsWith$default(r101, ".jpeg", false, 2, null) == true) goto L48;
            if (StringsKt.endsWith$default(r101, EffectConstants.GIF_FILE_SUFFIX, false, 2, null) == true) goto L48;
            if (StringsKt.endsWith$default(r101, ".webp", false, 2, null) == true) goto L48;
            if (StringsKt.endsWith$default(r101, ".mp4", false, 2, null) == true) goto L47;
            if (StringsKt.endsWith$default(r101, ".mov", false, 2, null) == true) goto L47;
            if (StringsKt.endsWith$default(r101, ".avi", false, 2, null) == true) goto L47;
            if (StringsKt.endsWith$default(r101, ".pdf", false, 2, null) == false) goto L46;
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
        return f235269b;
    }

    static {
        OfficeUploadFileType r100 = new OfficeUploadFileType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 0, R.drawable.dbx_ic_filetype_write_ai_line);
        DOC = r100;
        OfficeUploadFileType r101 = new OfficeUploadFileType("PPT", 1, R.drawable.dbx_ic_filetype_pptx_line);
        PPT = r101;
        OfficeUploadFileType r102 = new OfficeUploadFileType("SHEET", 2, R.drawable.dbx_ic_filetype_xlsx_line);
        SHEET = r102;
        OfficeUploadFileType r103 = new OfficeUploadFileType("IMAGE", 3, R.drawable.dbx_ic_image);
        IMAGE = r103;
        OfficeUploadFileType r104 = new OfficeUploadFileType("VIDEO", 4, R.drawable.office_ic_upload_file_unknown);
        VIDEO = r104;
        OfficeUploadFileType r105 = new OfficeUploadFileType("PDF", 5, R.drawable.office_ic_upload_file_unknown);
        PDF = r105;
        OfficeUploadFileType r110 = new OfficeUploadFileType("UNKNOWN", 6, R.drawable.office_ic_upload_file_unknown);
        UNKNOWN = r110;
        OfficeUploadFileType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f235268a = r111;
        f235269b = EnumEntriesKt.enumEntries(r111);
        Companion = new a();
    }

    public static OfficeUploadFileType[] values() {
        return (OfficeUploadFileType[]) f235268a.clone();
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    public static OfficeUploadFileType valueOf(String r100) {
        return (OfficeUploadFileType) r27.a.a(OfficeUploadFileType.class, r100);
    }

    public OfficeUploadFileType(String r100, int r101, int r102) {
        super(r100, r101);
        this.iconResId = r102;
    }
}
