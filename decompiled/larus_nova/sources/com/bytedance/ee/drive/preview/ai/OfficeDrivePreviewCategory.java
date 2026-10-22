package com.bytedance.ee.drive.preview.ai;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/drive/preview/ai/OfficeDrivePreviewCategory;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "PDF", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "SHEET", "SLIDES", CardAdapter.TEXT, "ARCHIVE", "UNKNOWN", "contentmanager-drive-export-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeDrivePreviewCategory[] f242686a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f242687b = null;

    public static EnumEntries<OfficeDrivePreviewCategory> getEntries() {
        return f242687b;
    }

    static {
        OfficeDrivePreviewCategory r100 = new OfficeDrivePreviewCategory("IMAGE", 0);
        IMAGE = r100;
        OfficeDrivePreviewCategory r101 = new OfficeDrivePreviewCategory("VIDEO", 1);
        VIDEO = r101;
        OfficeDrivePreviewCategory r102 = new OfficeDrivePreviewCategory("PDF", 2);
        PDF = r102;
        OfficeDrivePreviewCategory r103 = new OfficeDrivePreviewCategory(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 3);
        DOC = r103;
        OfficeDrivePreviewCategory r104 = new OfficeDrivePreviewCategory("SHEET", 4);
        SHEET = r104;
        OfficeDrivePreviewCategory r105 = new OfficeDrivePreviewCategory("SLIDES", 5);
        SLIDES = r105;
        OfficeDrivePreviewCategory r110 = new OfficeDrivePreviewCategory(CardAdapter.TEXT, 6);
        TEXT = r110;
        OfficeDrivePreviewCategory r111 = new OfficeDrivePreviewCategory("ARCHIVE", 7);
        ARCHIVE = r111;
        OfficeDrivePreviewCategory r112 = new OfficeDrivePreviewCategory("UNKNOWN", 8);
        UNKNOWN = r112;
        OfficeDrivePreviewCategory[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f242686a = r113;
        f242687b = EnumEntriesKt.enumEntries(r113);
    }

    public static OfficeDrivePreviewCategory[] values() {
        return (OfficeDrivePreviewCategory[]) f242686a.clone();
    }

    public static OfficeDrivePreviewCategory valueOf(String r100) {
        return (OfficeDrivePreviewCategory) a.a(OfficeDrivePreviewCategory.class, r100);
    }

    public OfficeDrivePreviewCategory(String r100, int r101) {
        super(r100, r101);
    }
}
