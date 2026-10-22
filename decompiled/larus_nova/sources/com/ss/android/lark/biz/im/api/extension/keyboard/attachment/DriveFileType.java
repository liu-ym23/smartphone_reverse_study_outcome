package com.ss.android.lark.biz.im.api.extension.keyboard.attachment;

import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.dtf.face.ui.toyger.FaceShowElderlyFragment;
import com.obric.miniapp.alarm.AccountType;
import com.obric.sva.sdk.controller.Global;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\u0081\u0002\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/DriveFileType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FOLDER", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "TXT", "PPT", "PDF", "IMAGE", "VIDEO", "AUDIO", "XLS", "CODE", "ZIP", "CSV", "KEYNOTE", "PAGES", "NUMBERS", "AI_DOC", "AI_SLIDES", "AI_SHEET", AccountType.OTHERS, "Companion", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveFileType extends Enum<DriveFileType> {
    public static final DriveFileType AI_DOC = null;
    public static final DriveFileType AI_SHEET = null;
    public static final DriveFileType AI_SLIDES = null;
    public static final DriveFileType AUDIO = null;
    public static final DriveFileType CODE = null;
    public static final DriveFileType CSV = null;
    public static final a Companion = null;
    public static final DriveFileType DOC = null;
    public static final DriveFileType FOLDER = null;
    public static final DriveFileType IMAGE = null;
    public static final DriveFileType KEYNOTE = null;
    public static final DriveFileType NUMBERS = null;
    public static final DriveFileType OTHERS = null;
    public static final DriveFileType PAGES = null;
    public static final DriveFileType PDF = null;
    public static final DriveFileType PPT = null;
    public static final DriveFileType TXT = null;
    public static final DriveFileType VIDEO = null;
    public static final DriveFileType XLS = null;
    public static final DriveFileType ZIP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f410113a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f410114b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f410115c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<String> f410116d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<String> f410117e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<String> f410118f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<String> f410119g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List<String> f410120h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final List<String> f410121i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final List<String> f410122j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final List<String> f410123k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final List<String> f410124l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final List<String> f410125m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final List<String> f410126n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ DriveFileType[] f410127o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410128p = null;
    private final String value;

    public static EnumEntries<DriveFileType> getEntries() {
        return f410128p;
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [com.ss.android.lark.biz.im.api.extension.keyboard.attachment.DriveFileType$a] */
    static {
        DriveFileType r100 = new DriveFileType("FOLDER", 0, DocumentType.FOLDER_NAME);
        FOLDER = r100;
        DriveFileType r101 = new DriveFileType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 1, "doc");
        DOC = r101;
        DriveFileType r102 = new DriveFileType("TXT", 2, "txt");
        TXT = r102;
        DriveFileType r103 = new DriveFileType("PPT", 3, "ppt");
        PPT = r103;
        DriveFileType r104 = new DriveFileType("PDF", 4, ExportFileExtension.PDF);
        PDF = r104;
        DriveFileType r105 = new DriveFileType("IMAGE", 5, "image");
        IMAGE = r105;
        DriveFileType r110 = new DriveFileType("VIDEO", 6, "media");
        VIDEO = r110;
        DriveFileType r111 = new DriveFileType("AUDIO", 7, "audio");
        AUDIO = r111;
        DriveFileType r112 = new DriveFileType("XLS", 8, "xls");
        XLS = r112;
        DriveFileType r113 = new DriveFileType("CODE", 9, "code");
        CODE = r113;
        DriveFileType r106 = new DriveFileType("ZIP", 10, "zip");
        ZIP = r106;
        DriveFileType r107 = new DriveFileType("CSV", 11, "csv");
        CSV = r107;
        DriveFileType r108 = new DriveFileType("KEYNOTE", 12, "keynote");
        KEYNOTE = r108;
        DriveFileType r109 = new DriveFileType("PAGES", 13, "pages");
        PAGES = r109;
        DriveFileType r114 = new DriveFileType("NUMBERS", 14, "numbers");
        NUMBERS = r114;
        DriveFileType r115 = new DriveFileType("AI_DOC", 15, "ai_doc");
        AI_DOC = r115;
        DriveFileType r116 = new DriveFileType("AI_SLIDES", 16, "ai_slides");
        AI_SLIDES = r116;
        DriveFileType r117 = new DriveFileType("AI_SHEET", 17, "ai_sheet");
        AI_SHEET = r117;
        DriveFileType r118 = new DriveFileType(AccountType.OTHERS, 18, "others");
        OTHERS = r118;
        DriveFileType[] r119 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107, r108, r109, r114, r115, r116, r117, r118};
        f410127o = r119;
        f410128p = EnumEntriesKt.enumEntries(r119);
        Companion = new a();
        f410113a = CollectionsKt.listOf(new String[]{".doc", ".dot", ".wps", ".wpt", ".docx", ".dotx", ".docm", ".dotm"});
        f410114b = CollectionsKt.listOf(new String[]{Global.SUFFIX_TXT_FILE, ".rtf", ".log"});
        f410115c = CollectionsKt.listOf(new String[]{".ppt", ".pptx", ".pptm", ".ppsx", ".ppsm", ".pps", ".potx", ".potm", ".dpt", ".dps"});
        f410116d = CollectionsKt.listOf(".pdf");
        f410117e = CollectionsKt.listOf(new String[]{".jpg", ".jpeg", EffectConstants.GIF_FILE_SUFFIX, RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT, ".heic", ".heif", ".dng", ".bmp", ".tif", ".tiff", ".svg", ".webp", ".arw", ".nef", ".raw", ".avif", ".ico", ".cr2", ".crw", ".dcr", ".dcs", ".dwg", ".erf", ".kdc", ".mef", ".mos", ".mrw", ".nrw", ".orf", ".pef", ".ppm", ".r3d", ".raf", ".rw2", ".rwl", ".sr2", ".svgz", ".wbmp", ".x3f", ".3rf"});
        f410118f = CollectionsKt.listOf(new String[]{".mp4", ".mov", ".wmv", ".m4v", ".avi", ".mpg", ".mpeg", ".rm", ".rmvb", ".flv", ".mkv", ".ogv", ".asf", ".dv", ".f4v", ".m2t", ".mpe", ".mts", ".mxf", ".vob", ".webm", ".3gp", ".3gpp", ".3gpp2", ".mp4v", ".mpg4", ".mpegts", ".m4s"});
        f410119g = CollectionsKt.listOf(new String[]{FaceShowElderlyFragment.AUDIO_FORM, Global.SUFFIX_WAV_FILE, ".m4a", ".wma", ".amr", ".aac", ".au", ".flac", ".cda", ".oga", ".ogg", ".m4r", ".air", ".aiff"});
        f410120h = CollectionsKt.listOf(new String[]{".xls", ".xlt", ".et", ".xlsx", ".xltx", ".csv", ".xlsm", ".xltm", ".ett", ".xlsb", ".xlm"});
        f410121i = CollectionsKt.listOf(new String[]{".py", ".java", ".js", ".ts", ".c", ".cpp", ".h", ".hpp", ".cc", ".cxx", ".html", ".css", ".php", ".rb", ".pl", ".sh", ".bash", ".swift", ".kt", ".kts", ".ktm", ".go", ".dart", ".scala", ".cs", ".aspx", ".xaml", ".vue", ".proto", ".tsx", ".jsx", ".rs", InvRouter.FLOW_SUFFIX, ".yaml", ".yml", ".xml", ".properties", ".plist", ".md", ".markdown", ".bat", ".cmd", ".ps1", ".vbs", ".lua", ".wxml", ".wxss", ".m", ".for", ".f90", ".f95", ".f", ".xhtml", ".scss", ".thrift", ".patch", ".sql", ".htm", ".matlab", ".gradle", ".groovy", ".less", ".ejs", ".jsp", ".r", ".hs", ".conf", ".coffee", ".url", ".webloc", ".website", ".as", ".as3", ".asm", ".asp", ".cmake", ".diff", ".erb", ".erl", ".gvy", ".haml", ".hh", ".hxx", ".lst", ".make", ".ml", ".out", ".sass", ".script", ".scm", ".sml", ".vb", ".vi", ".vim", ".xsd", ".xsl", ".mdown", ".mkdn"});
        f410122j = CollectionsKt.listOf(new String[]{".zip", ".rar", ".tar", ".gz", ".tgz", ".lzma", ".7z", ".bz2", ".cab", ".zipx", ".jar", ".ace", ".arj", ".lzh", ".z", ".bz", ".cpio", ".iso", ".lha", ".lz", ".tbz", ".taz", ".tbz2", ".tlz", ".txz", ".tz", ".xar", ".xz"});
        f410123k = CollectionsKt.listOf(".csv");
        f410124l = CollectionsKt.listOf(new String[]{".key", ".keynote"});
        f410125m = CollectionsKt.listOf(".pages");
        f410126n = CollectionsKt.listOf(".numbers");
    }

    public static DriveFileType[] values() {
        return (DriveFileType[]) f410127o.clone();
    }

    public static final /* synthetic */ List access$getAUDIO_POSTFIX_LIST$cp() {
        return f410119g;
    }

    public static final /* synthetic */ List access$getCODE_POSTFIX_LIST$cp() {
        return f410121i;
    }

    public static final /* synthetic */ List access$getCSV_POSTFIX_LIST$cp() {
        return f410123k;
    }

    public static final /* synthetic */ List access$getDOC_POSTFIX_LIST$cp() {
        return f410113a;
    }

    public static final /* synthetic */ List access$getIMAGE_POSTFIX_LIST$cp() {
        return f410117e;
    }

    public static final /* synthetic */ List access$getKEYNOTE_POSTFIX_LIST$cp() {
        return f410124l;
    }

    public static final /* synthetic */ List access$getNUMBERS_POSTFIX_LIST$cp() {
        return f410126n;
    }

    public static final /* synthetic */ List access$getPAGES_POSTFIX_LIST$cp() {
        return f410125m;
    }

    public static final /* synthetic */ List access$getPDF_POSTFIX_LIST$cp() {
        return f410116d;
    }

    public static final /* synthetic */ List access$getPPT_POSTFIX_LIST$cp() {
        return f410115c;
    }

    public static final /* synthetic */ List access$getTXT_POSTFIX_LIST$cp() {
        return f410114b;
    }

    public static final /* synthetic */ List access$getVIDEO_POSTFIX_LIST$cp() {
        return f410118f;
    }

    public static final /* synthetic */ List access$getXLS_POSTFIX_LIST$cp() {
        return f410120h;
    }

    public static final /* synthetic */ List access$getZIP_POSTFIX_LIST$cp() {
        return f410122j;
    }

    public final String getValue() {
        return this.value;
    }

    public static DriveFileType valueOf(String r100) {
        return (DriveFileType) r27.a.a(DriveFileType.class, r100);
    }

    public DriveFileType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
