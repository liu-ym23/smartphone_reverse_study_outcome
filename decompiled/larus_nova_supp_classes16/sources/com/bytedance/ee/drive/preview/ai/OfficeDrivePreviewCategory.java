package com.bytedance.ee.drive.preview.ai;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/drive/preview/ai/OfficeDrivePreviewCategory;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "PDF", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "SHEET", "SLIDES", "TEXT", "ARCHIVE", "UNKNOWN", "contentmanager-drive-export-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeDrivePreviewCategory extends Enum<OfficeDrivePreviewCategory> {
    public static final OfficeDrivePreviewCategory ARCHIVE = null;
    public static final OfficeDrivePreviewCategory DOC = null;
    public static final OfficeDrivePreviewCategory IMAGE = null;
    public static final OfficeDrivePreviewCategory PDF = null;
    public static final OfficeDrivePreviewCategory SHEET = null;
    public static final OfficeDrivePreviewCategory SLIDES = null;
    public static final OfficeDrivePreviewCategory TEXT = null;
    public static final OfficeDrivePreviewCategory UNKNOWN = null;
    public static final OfficeDrivePreviewCategory VIDEO = null;
    public static final /* synthetic */ OfficeDrivePreviewCategory[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeDrivePreviewCategory> getEntries() {
        return b;
    }

    static {
        OfficeDrivePreviewCategory r0 = new OfficeDrivePreviewCategory("IMAGE", 0);
        IMAGE = r0;
        OfficeDrivePreviewCategory r1 = new OfficeDrivePreviewCategory("VIDEO", 1);
        VIDEO = r1;
        OfficeDrivePreviewCategory r3 = new OfficeDrivePreviewCategory("PDF", 2);
        PDF = r3;
        OfficeDrivePreviewCategory r5 = new OfficeDrivePreviewCategory(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 3);
        DOC = r5;
        OfficeDrivePreviewCategory r7 = new OfficeDrivePreviewCategory("SHEET", 4);
        SHEET = r7;
        OfficeDrivePreviewCategory r9 = new OfficeDrivePreviewCategory("SLIDES", 5);
        SLIDES = r9;
        OfficeDrivePreviewCategory r11 = new OfficeDrivePreviewCategory("TEXT", 6);
        TEXT = r11;
        OfficeDrivePreviewCategory r13 = new OfficeDrivePreviewCategory("ARCHIVE", 7);
        ARCHIVE = r13;
        OfficeDrivePreviewCategory r16 = new OfficeDrivePreviewCategory("UNKNOWN", 8);
        UNKNOWN = r16;
        OfficeDrivePreviewCategory[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r16};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static OfficeDrivePreviewCategory[] values() {
        return (OfficeDrivePreviewCategory[]) a.clone();
    }

    public static OfficeDrivePreviewCategory valueOf(String r1) {
        return (OfficeDrivePreviewCategory) a.a(OfficeDrivePreviewCategory.class, r1);
    }

    public OfficeDrivePreviewCategory(String r1, int r2) {
        super(r1, r2);
    }
}
