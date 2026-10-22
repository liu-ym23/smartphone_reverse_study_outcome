package com.larus.common_ui.view;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.larus.nova.R;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u0012"}, d2 = {"Lcom/larus/common_ui/view/FileExportType;", "", "<init>", "(Ljava/lang/String;I)V", "unknown", EffectConfiguration.KEY_SEARCH_WORD, ExportFileExtension.PDF, "txt", ExportFileExtension.PPTX, "excel", "iconRes", "", "nameRes", "toH5Type", "getExtension", "", "toFileTypeStr", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FileExportType extends Enum<FileExportType> {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FileExportType[] f328233a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f328234b = null;
    public static final FileExportType excel = null;
    public static final FileExportType pdf = null;
    public static final FileExportType pptx = null;
    public static final FileExportType txt = null;
    public static final FileExportType unknown = null;
    public static final FileExportType word = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f328235a = null;

        static {
            int[] r100 = new int[FileExportType.values().length];
            r100[FileExportType.word.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[FileExportType.pdf.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[FileExportType.txt.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[FileExportType.pptx.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[FileExportType.excel.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[FileExportType.unknown.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f328235a = r100;
        }
    }

    public static EnumEntries<FileExportType> getEntries() {
        return f328234b;
    }

    static {
        FileExportType r100 = new FileExportType("unknown", 0);
        unknown = r100;
        FileExportType r101 = new FileExportType(EffectConfiguration.KEY_SEARCH_WORD, 1);
        word = r101;
        FileExportType r102 = new FileExportType(ExportFileExtension.PDF, 2);
        pdf = r102;
        FileExportType r103 = new FileExportType("txt", 3);
        txt = r103;
        FileExportType r104 = new FileExportType(ExportFileExtension.PPTX, 4);
        pptx = r104;
        FileExportType r105 = new FileExportType("excel", 5);
        excel = r105;
        FileExportType[] r110 = {r100, r101, r102, r103, r104, r105};
        f328233a = r110;
        f328234b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static FileExportType[] values() {
        return (FileExportType[]) f328233a.clone();
    }

    public final String getExtension() {
        switch(b.f328235a[ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        return "unknown";
    L7:
        return "excel";
    L8:
        return ExportFileExtension.PPTX;
    L9:
        return "txt";
    L10:
        return ExportFileExtension.PDF;
    L11:
        return DocumentType.DOCX_NAME;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final int iconRes() {
        switch(b.f328235a[ordinal()]) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L11;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L11;
            default: goto L5;
        };
    L6:
        return R.drawable.larus_icon_file_export_type_excel;
    L7:
        return R.drawable.larus_icon_file_export_type_pptx;
    L8:
        return R.drawable.larus_icon_file_export_type_pdf;
    L9:
        return R.drawable.larus_icon_file_export_type_word;
    L11:
        return R.drawable.larus_icon_file_export_type_txt;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final int nameRes() {
        switch(b.f328235a[ordinal()]) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L11;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L11;
            default: goto L5;
        };
    L6:
        return R.string.larus_LarkCCM_DoubaoSheets_DownloadAExcel_Option;
    L7:
        return R.string.larus_slides_download_format_PPTX_file;
    L8:
        return R.string.larus_exportFile_sheet_pdf;
    L9:
        return R.string.larus_exportFile_sheet_word;
    L11:
        return R.string.larus_exportFile_sheet_txt;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final String toFileTypeStr() {
        switch(b.f328235a[ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        return "";
    L7:
        return "excel";
    L8:
        return ExportFileExtension.PPTX;
    L9:
        return "txt";
    L10:
        return ExportFileExtension.PDF;
    L11:
        return EffectConfiguration.KEY_SEARCH_WORD;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final int toH5Type() {
        switch(b.f328235a[ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        return -1;
    L7:
        return 4;
    L8:
        return 3;
    L9:
        return 0;
    L10:
        return 2;
    L11:
        return 1;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public static FileExportType valueOf(String r100) {
        return (FileExportType) r27.a.a(FileExportType.class, r100);
    }

    public FileExportType(String r100, int r101) {
        super(r100, r101);
    }
}
