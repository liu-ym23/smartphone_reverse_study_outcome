package com.larus.common_ui.icon;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, d2 = {"Lcom/larus/common_ui/icon/CommonFileIconType;", "", "<init>", "(Ljava/lang/String;I)V", "FOLDER", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "TXT", "PPT", "PDF", "IMAGE", "VIDEO", "AUDIO", "XLS", "CODE", "MARKDOWN", "ZIP", "CSV", "KEYNOTE", "PAGES", "NUMBERS", "AI_DOC", "AI_SLIDES", "AI_SHEET", "BITABLE", "BITABLE_APP", "MIAODA", PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE, "UNKNOWN", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CommonFileIconType extends Enum<CommonFileIconType> {
    public static final CommonFileIconType AI_DOC = null;
    public static final CommonFileIconType AI_SHEET = null;
    public static final CommonFileIconType AI_SLIDES = null;
    public static final CommonFileIconType AUDIO = null;
    public static final CommonFileIconType BITABLE = null;
    public static final CommonFileIconType BITABLE_APP = null;
    public static final CommonFileIconType CODE = null;
    public static final CommonFileIconType CSV = null;
    public static final CommonFileIconType DOC = null;
    public static final CommonFileIconType FOLDER = null;
    public static final CommonFileIconType IMAGE = null;
    public static final CommonFileIconType KEYNOTE = null;
    public static final CommonFileIconType MARKDOWN = null;
    public static final CommonFileIconType MIAODA = null;
    public static final CommonFileIconType MINDNOTE = null;
    public static final CommonFileIconType NUMBERS = null;
    public static final CommonFileIconType PAGES = null;
    public static final CommonFileIconType PDF = null;
    public static final CommonFileIconType PPT = null;
    public static final CommonFileIconType TXT = null;
    public static final CommonFileIconType UNKNOWN = null;
    public static final CommonFileIconType VIDEO = null;
    public static final CommonFileIconType XLS = null;
    public static final CommonFileIconType ZIP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommonFileIconType[] f327596a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f327597b = null;

    public static EnumEntries<CommonFileIconType> getEntries() {
        return f327597b;
    }

    static {
        CommonFileIconType r100 = new CommonFileIconType("FOLDER", 0);
        FOLDER = r100;
        CommonFileIconType r101 = new CommonFileIconType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 1);
        DOC = r101;
        CommonFileIconType r102 = new CommonFileIconType("TXT", 2);
        TXT = r102;
        CommonFileIconType r103 = new CommonFileIconType("PPT", 3);
        PPT = r103;
        CommonFileIconType r104 = new CommonFileIconType("PDF", 4);
        PDF = r104;
        CommonFileIconType r105 = new CommonFileIconType("IMAGE", 5);
        IMAGE = r105;
        CommonFileIconType r110 = new CommonFileIconType("VIDEO", 6);
        VIDEO = r110;
        CommonFileIconType r111 = new CommonFileIconType("AUDIO", 7);
        AUDIO = r111;
        CommonFileIconType r112 = new CommonFileIconType("XLS", 8);
        XLS = r112;
        CommonFileIconType r113 = new CommonFileIconType("CODE", 9);
        CODE = r113;
        CommonFileIconType r114 = new CommonFileIconType("MARKDOWN", 10);
        MARKDOWN = r114;
        CommonFileIconType r115 = new CommonFileIconType("ZIP", 11);
        ZIP = r115;
        CommonFileIconType r106 = new CommonFileIconType("CSV", 12);
        CSV = r106;
        CommonFileIconType r107 = new CommonFileIconType("KEYNOTE", 13);
        KEYNOTE = r107;
        CommonFileIconType r108 = new CommonFileIconType("PAGES", 14);
        PAGES = r108;
        CommonFileIconType r109 = new CommonFileIconType("NUMBERS", 15);
        NUMBERS = r109;
        CommonFileIconType r116 = new CommonFileIconType("AI_DOC", 16);
        AI_DOC = r116;
        CommonFileIconType r117 = new CommonFileIconType("AI_SLIDES", 17);
        AI_SLIDES = r117;
        CommonFileIconType r118 = new CommonFileIconType("AI_SHEET", 18);
        AI_SHEET = r118;
        CommonFileIconType r119 = new CommonFileIconType("BITABLE", 19);
        BITABLE = r119;
        CommonFileIconType r120 = new CommonFileIconType("BITABLE_APP", 20);
        BITABLE_APP = r120;
        CommonFileIconType r121 = new CommonFileIconType("MIAODA", 21);
        MIAODA = r121;
        CommonFileIconType r122 = new CommonFileIconType(PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE, 22);
        MINDNOTE = r122;
        CommonFileIconType r123 = new CommonFileIconType("UNKNOWN", 23);
        UNKNOWN = r123;
        CommonFileIconType[] r124 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123};
        f327596a = r124;
        f327597b = EnumEntriesKt.enumEntries(r124);
    }

    public static CommonFileIconType[] values() {
        return (CommonFileIconType[]) f327596a.clone();
    }

    public static CommonFileIconType valueOf(String r100) {
        return (CommonFileIconType) a.a(CommonFileIconType.class, r100);
    }

    public CommonFileIconType(String r100, int r101) {
        super(r100, r101);
    }
}
