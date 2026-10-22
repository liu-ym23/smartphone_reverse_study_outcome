package com.larus.drive.biz.api.model;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.larus.common_ui.icon.CommonFileIconType;
import h19.b;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001%B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006&"}, d2 = {"Lcom/larus/drive/biz/api/model/DriveFileType;", "", "value", "", "iconType", "Lcom/larus/common_ui/icon/CommonFileIconType;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/larus/common_ui/icon/CommonFileIconType;)V", "getValue", "()Ljava/lang/String;", "FOLDER", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "TXT", "PPT", "PDF", "IMAGE", "VIDEO", "AUDIO", "XLS", "CODE", "MARKDOWN", "ZIP", "CSV", "KEYNOTE", "PAGES", "NUMBERS", "AI_DOC", "AI_SLIDES", "AI_SHEET", "BITABLE", "MIAODA", PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE, "UNKNOWN", "iconResId", "", "getIconResId", "()I", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveFileType extends Enum<DriveFileType> {
    public static final DriveFileType AI_DOC = null;
    public static final DriveFileType AI_SHEET = null;
    public static final DriveFileType AI_SLIDES = null;
    public static final DriveFileType AUDIO = null;
    public static final DriveFileType BITABLE = null;
    public static final DriveFileType CODE = null;
    public static final DriveFileType CSV = null;
    public static final a Companion = null;
    public static final DriveFileType DOC = null;
    public static final DriveFileType FOLDER = null;
    public static final DriveFileType IMAGE = null;
    public static final DriveFileType KEYNOTE = null;
    public static final DriveFileType MARKDOWN = null;
    public static final DriveFileType MIAODA = null;
    public static final DriveFileType MINDNOTE = null;
    public static final DriveFileType NUMBERS = null;
    public static final DriveFileType PAGES = null;
    public static final DriveFileType PDF = null;
    public static final DriveFileType PPT = null;
    public static final DriveFileType TXT = null;
    public static final DriveFileType UNKNOWN = null;
    public static final DriveFileType VIDEO = null;
    public static final DriveFileType XLS = null;
    public static final DriveFileType ZIP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DriveFileType[] f341020a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f341021b = null;
    private final CommonFileIconType iconType;
    private final String value;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.drive.biz.api.model.DriveFileType$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4297a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f341022a = null;

            static {
                int[] r100 = new int[CommonFileIconType.values().length];
                r100[CommonFileIconType.FOLDER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
            L85:
                r100[CommonFileIconType.DOC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
            L99:
                r100[CommonFileIconType.TXT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
            L61:
                r100[CommonFileIconType.PPT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
            L65:
                r100[CommonFileIconType.PDF.ordinal()] = 5;     // Catch: NoSuchFieldError -> L33
            L79:
                r100[CommonFileIconType.IMAGE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L34
            L93:
                r100[CommonFileIconType.VIDEO.ordinal()] = 7;     // Catch: NoSuchFieldError -> L35
            L71:
                r100[CommonFileIconType.AUDIO.ordinal()] = 8;     // Catch: NoSuchFieldError -> L36
            L87:
                r100[CommonFileIconType.XLS.ordinal()] = 9;     // Catch: NoSuchFieldError -> L37
            L89:
                r100[CommonFileIconType.CODE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L38
            L55:
                r100[CommonFileIconType.MARKDOWN.ordinal()] = 11;     // Catch: NoSuchFieldError -> L39
            L83:
                r100[CommonFileIconType.ZIP.ordinal()] = 12;     // Catch: NoSuchFieldError -> L40
            L97:
                r100[CommonFileIconType.CSV.ordinal()] = 13;     // Catch: NoSuchFieldError -> L41
            L53:
                r100[CommonFileIconType.KEYNOTE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L42
            L67:
                r100[CommonFileIconType.PAGES.ordinal()] = 15;     // Catch: NoSuchFieldError -> L43
            L95:
                r100[CommonFileIconType.NUMBERS.ordinal()] = 16;     // Catch: NoSuchFieldError -> L44
            L59:
                r100[CommonFileIconType.AI_DOC.ordinal()] = 17;     // Catch: NoSuchFieldError -> L45
            L63:
                r100[CommonFileIconType.AI_SLIDES.ordinal()] = 18;     // Catch: NoSuchFieldError -> L46
            L81:
                r100[CommonFileIconType.AI_SHEET.ordinal()] = 19;     // Catch: NoSuchFieldError -> L47
            L57:
                r100[CommonFileIconType.BITABLE.ordinal()] = 20;     // Catch: NoSuchFieldError -> L48
            L75:
                r100[CommonFileIconType.BITABLE_APP.ordinal()] = 21;     // Catch: NoSuchFieldError -> L49
            L77:
                r100[CommonFileIconType.MIAODA.ordinal()] = 22;     // Catch: NoSuchFieldError -> L50
            L91:
                r100[CommonFileIconType.MINDNOTE.ordinal()] = 23;     // Catch: NoSuchFieldError -> L51
            L69:
                r100[CommonFileIconType.UNKNOWN.ordinal()] = 24;     // Catch: NoSuchFieldError -> L52
            L27:
                f341022a = r100;
            }
        }

        public a() {
        }

        public static DriveFileType a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            Iterator<DriveFileType> r101 = DriveFileType.getEntries().iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            DriveFileType r102 = r101.next();
            if (Intrinsics.areEqual(r102.getValue(), r100) == false) goto L4;
        L10:
            return r102;
        L8:
            r102 = null;
            goto L10
        }

        public static DriveFileType b(String r100) {
            b.f483542a.getClass();
            CommonFileIconType r101 = b.c(r100);
            switch(C4297a.f341022a[r101.ordinal()]) {
                case 1: goto L30;
                case 2: goto L53;
                case 3: goto L52;
                case 4: goto L51;
                case 5: goto L50;
                case 6: goto L49;
                case 7: goto L48;
                case 8: goto L47;
                case 9: goto L46;
                case 10: goto L45;
                case 11: goto L44;
                case 12: goto L43;
                case 13: goto L42;
                case 14: goto L41;
                case 15: goto L40;
                case 16: goto L39;
                case 17: goto L38;
                case 18: goto L37;
                case 19: goto L36;
                case 20: goto L35;
                case 21: goto L34;
                case 22: goto L33;
                case 23: goto L32;
                case 24: goto L31;
                default: goto L5;
            };
        L5:
            throw new NoWhenBranchMatchedException();
        L31:
            return DriveFileType.UNKNOWN;
        L32:
            return DriveFileType.MINDNOTE;
        L33:
            return DriveFileType.MIAODA;
        L34:
            return DriveFileType.BITABLE;
        L35:
            return DriveFileType.BITABLE;
        L36:
            return DriveFileType.AI_SHEET;
        L37:
            return DriveFileType.AI_SLIDES;
        L38:
            return DriveFileType.AI_DOC;
        L39:
            return DriveFileType.NUMBERS;
        L40:
            return DriveFileType.PAGES;
        L41:
            return DriveFileType.KEYNOTE;
        L42:
            return DriveFileType.CSV;
        L43:
            return DriveFileType.ZIP;
        L44:
            return DriveFileType.MARKDOWN;
        L45:
            return DriveFileType.CODE;
        L46:
            return DriveFileType.XLS;
        L47:
            return DriveFileType.AUDIO;
        L48:
            return DriveFileType.VIDEO;
        L49:
            return DriveFileType.IMAGE;
        L50:
            return DriveFileType.PDF;
        L51:
            return DriveFileType.PPT;
        L52:
            return DriveFileType.TXT;
        L53:
            return DriveFileType.DOC;
        L30:
            return DriveFileType.FOLDER;
        }
    }

    public static EnumEntries<DriveFileType> getEntries() {
        return f341021b;
    }

    static {
        DriveFileType r100 = new DriveFileType("FOLDER", 0, DocumentType.FOLDER_NAME, CommonFileIconType.FOLDER);
        FOLDER = r100;
        DriveFileType r101 = new DriveFileType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 1, "doc", CommonFileIconType.DOC);
        DOC = r101;
        DriveFileType r102 = new DriveFileType("TXT", 2, "txt", CommonFileIconType.TXT);
        TXT = r102;
        DriveFileType r103 = new DriveFileType("PPT", 3, "ppt", CommonFileIconType.PPT);
        PPT = r103;
        DriveFileType r104 = new DriveFileType("PDF", 4, ExportFileExtension.PDF, CommonFileIconType.PDF);
        PDF = r104;
        DriveFileType r105 = new DriveFileType("IMAGE", 5, "image", CommonFileIconType.IMAGE);
        IMAGE = r105;
        DriveFileType r110 = new DriveFileType("VIDEO", 6, "media", CommonFileIconType.VIDEO);
        VIDEO = r110;
        DriveFileType r111 = new DriveFileType("AUDIO", 7, "audio", CommonFileIconType.AUDIO);
        AUDIO = r111;
        DriveFileType r112 = new DriveFileType("XLS", 8, "xls", CommonFileIconType.XLS);
        XLS = r112;
        DriveFileType r106 = new DriveFileType("CODE", 9, "code", CommonFileIconType.CODE);
        CODE = r106;
        DriveFileType r107 = new DriveFileType("MARKDOWN", 10, "markdown", CommonFileIconType.MARKDOWN);
        MARKDOWN = r107;
        DriveFileType r108 = new DriveFileType("ZIP", 11, "zip", CommonFileIconType.ZIP);
        ZIP = r108;
        DriveFileType r109 = new DriveFileType("CSV", 12, "csv", CommonFileIconType.CSV);
        CSV = r109;
        DriveFileType r113 = new DriveFileType("KEYNOTE", 13, "keynote", CommonFileIconType.KEYNOTE);
        KEYNOTE = r113;
        DriveFileType r114 = new DriveFileType("PAGES", 14, "pages", CommonFileIconType.PAGES);
        PAGES = r114;
        DriveFileType r115 = new DriveFileType("NUMBERS", 15, "numbers", CommonFileIconType.NUMBERS);
        NUMBERS = r115;
        DriveFileType r116 = new DriveFileType("AI_DOC", 16, "ai_doc", CommonFileIconType.AI_DOC);
        AI_DOC = r116;
        DriveFileType r117 = new DriveFileType("AI_SLIDES", 17, "ai_slides", CommonFileIconType.AI_SLIDES);
        AI_SLIDES = r117;
        DriveFileType r118 = new DriveFileType("AI_SHEET", 18, "ai_sheet", CommonFileIconType.AI_SHEET);
        AI_SHEET = r118;
        DriveFileType r119 = new DriveFileType("BITABLE", 19, DocumentType.BITABLE_NAME, CommonFileIconType.BITABLE);
        BITABLE = r119;
        DriveFileType r120 = new DriveFileType("MIAODA", 20, "miaoda", CommonFileIconType.MIAODA);
        MIAODA = r120;
        DriveFileType r121 = new DriveFileType(PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE, 21, DocumentType.MINDNOTE_NAME, CommonFileIconType.MINDNOTE);
        MINDNOTE = r121;
        DriveFileType r122 = new DriveFileType("UNKNOWN", 22, "unknown", CommonFileIconType.UNKNOWN);
        UNKNOWN = r122;
        DriveFileType[] r123 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r106, r107, r108, r109, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122};
        f341020a = r123;
        f341021b = EnumEntriesKt.enumEntries(r123);
        Companion = new a();
    }

    public static DriveFileType[] values() {
        return (DriveFileType[]) f341020a.clone();
    }

    public final int getIconResId() {
        b r100 = b.f483542a;
        CommonFileIconType r101 = this.iconType;
        r100.getClass();
        return b.a(r101);
    }

    public final String getValue() {
        return this.value;
    }

    public static DriveFileType valueOf(String r100) {
        return (DriveFileType) r27.a.a(DriveFileType.class, r100);
    }

    public DriveFileType(String r100, int r101, String r102, CommonFileIconType r103) {
        super(r100, r101);
        this.value = r102;
        this.iconType = r103;
    }
}
