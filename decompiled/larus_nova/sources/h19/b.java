package h19;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.larus.common_ui.icon.CommonFileIconType;
import com.larus.common_ui.icon.ICommonFileIconProvider;
import com.larus.nova.R;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.util.Locale;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f483542a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f483543b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f483544c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<String> f483545d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<String> f483546e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<String> f483547f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set<String> f483548g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Set<String> f483549h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Set<String> f483550i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Set<String> f483551j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Set<String> f483552k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Set<String> f483553l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Set<String> f483554m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Set<String> f483555n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Set<String> f483556o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Set<String> f483557p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Set<String> f483558q = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f483559a = null;

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
            f483559a = r100;
        }
    }

    public b() {
    }

    static {
        f483542a = new b();
        f483543b = LazyKt.lazy(new h19.a());
        f483544c = SetsKt.setOf(new String[]{"doc", "dot", "wps", "wpt", DocumentType.DOCX_NAME, "dotx", "docm", "dotm"});
        f483545d = SetsKt.setOf(new String[]{"txt", "rtf", "log"});
        f483546e = SetsKt.setOf(new String[]{"ppt", ExportFileExtension.PPTX, "pptm", "ppsx", "ppsm", "pps", "potx", "potm", "dpt", "dps"});
        f483547f = SetsKt.setOf(ExportFileExtension.PDF);
        f483548g = SetsKt.setOf(new String[]{"jpg", LoadParams.ImageFormat.JPEG, "gif", LoadParams.ImageFormat.PNG, "heic", "heif", "dng", "bmp", "tif", "tiff", "svg", "webp", "arw", "nef", TemplateNodeType.RAW, "avif", "ico", "cr2", "crw", "dcr", "dcs", "dwg", "erf", "kdc", "mef", "mos", "mrw", "nrw", "orf", "pef", "ppm", "r3d", "raf", "rw2", "rwl", "sr2", "svgz", "wbmp", "x3f", "3rf"});
        f483549h = SetsKt.setOf(new String[]{"mp4", "mov", "wmv", "m4v", "avi", "mpg", "mpeg", "rm", "rmvb", "flv", "mkv", "ogv", "asf", "dv", "f4v", "m2t", "mpe", "mts", "mxf", "vob", "webm", "3gp", "3gpp", "3gpp2", "mp4v", "mpg4", "mpegts", "m4s"});
        f483550i = SetsKt.setOf(new String[]{TTVideoEngineInterface.FORMAT_TYPE_MP3, "wav", "m4a", "wma", "amr", "aac", SpeechEngineDefines.AU_ENGINE, "flac", "cda", "oga", "ogg", "m4r", "air", "aiff"});
        f483551j = SetsKt.setOf(new String[]{"xls", "xlt", "et", "xlsx", "xltx", "xlsm", "xltm", "ett", "xlsb", "xlm"});
        f483552k = SetsKt.setOf(new String[]{"md", "markdown", "mdown", "mkdn"});
        f483553l = SetsKt.setOf(new String[]{"py", "java", GXTemplateKey.GAIAX_JS, "ts", "c", "cpp", "h", "hpp", "cc", "cxx", "html", GXTemplateKey.GAIAX_CSS, "php", "rb", "pl", "sh", "bash", "swift", "kt", "kts", "ktm", "go", "dart", "scala", SRStrategy.MEDIAINFO_KEY_CACHE_SIZE, "aspx", "xaml", "vue", "proto", "tsx", "jsx", "rs", "json", "yaml", "yml", "xml", "properties", "plist", "bat", "cmd", "ps1", "vbs", "lua", "wxml", "wxss", "m", SlcElement.KEY_FOR, "f90", "f95", "f", "xhtml", "scss", "thrift", "patch", "sql", "htm", "matlab", "gradle", "groovy", "less", "ejs", "jsp", "r", "hs", "conf", "coffee", "url", "webloc", "website", "as", "as3", "asm", "asp", "cmake", "diff", "erb", "erl", "gvy", "haml", "hh", "hxx", "lst", "make", "ml", Argument.OUT, "sass", "script", "scm", "sml", "vb", "vi", "vim", "xsd", "xsl"});
        f483554m = SetsKt.setOf(new String[]{"zip", "rar", "tar", "gz", "tgz", "lzma", "7z", "bz2", "cab", "zipx", "jar", "ace", "arj", "lzh", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "bz", "cpio", "iso", "lha", "lz", "tbz", "taz", "tbz2", "tlz", "txz", "tz", "xar", "xz"});
        f483555n = SetsKt.setOf("csv");
        f483556o = SetsKt.setOf(new String[]{"key", "keynote"});
        f483557p = SetsKt.setOf("pages");
        f483558q = SetsKt.setOf("numbers");
    }

    public static int a(CommonFileIconType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        ICommonFileIconProvider r103 = (ICommonFileIconProvider) f483543b.getValue();     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        Integer r104 = r103.b(r100);     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r105) == true) goto L15;
        r101 = r105;
    L15:
        Integer r106 = (Integer) r101;
        if (r106 == null) goto L19;
        return r106.intValue();
    L19:
        switch(a.f483559a[r100.ordinal()]) {
            case 1: goto L44;
            case 2: goto L43;
            case 3: goto L42;
            case 4: goto L41;
            case 5: goto L40;
            case 6: goto L39;
            case 7: goto L38;
            case 8: goto L37;
            case 9: goto L36;
            case 10: goto L35;
            case 11: goto L34;
            case 12: goto L33;
            case 13: goto L32;
            case 14: goto L31;
            case 15: goto L30;
            case 16: goto L29;
            case 17: goto L28;
            case 18: goto L41;
            case 19: goto L27;
            case 20: goto L26;
            case 21: goto L25;
            case 22: goto L24;
            case 23: goto L23;
            case 24: goto L22;
            default: goto L21;
        };
    L22:
        return R.drawable.larus_ud_icon_file_unknow_colorful;
    L23:
        return R.drawable.larus_ud_icon_file_mindnote_colorful;
    L24:
        return R.drawable.larus_ud_icon_file_miaoda_colorful;
    L25:
        return R.drawable.larus_ud_icon_file_base_appmode_v2_colorful;
    L26:
        return R.drawable.larus_ud_icon_file_base_colorful;
    L27:
        return R.drawable.larus_ud_icon_wiki_sheet_colorful;
    L28:
        return R.drawable.larus_ud_icon_file_docx_colorful;
    L29:
        return R.drawable.larus_ud_icon_file_numbers_colorful;
    L30:
        return R.drawable.larus_ud_icon_file_pages_colorful;
    L31:
        return R.drawable.larus_ud_icon_file_keynote_colorful;
    L32:
        return R.drawable.larus_ud_icon_file_csv_colorful;
    L33:
        return R.drawable.larus_ud_icon_file_zip_colorful;
    L34:
        return R.drawable.larus_ud_icon_file_md_colorful;
    L35:
        return R.drawable.larus_ud_icon_file_code_colorful;
    L36:
        return R.drawable.larus_ud_icon_file_excel_colorful;
    L37:
        return R.drawable.larus_ud_icon_file_audio_colorful;
    L38:
        return R.drawable.larus_ud_icon_file_video_colorful;
    L39:
        return R.drawable.larus_ud_icon_file_image_colorful;
    L40:
        return R.drawable.larus_ud_icon_file_pdf_colorful;
    L41:
        return R.drawable.larus_ud_icon_file_ppt_colorful;
    L42:
        return R.drawable.larus_ud_icon_file_text_colorful;
    L43:
        return R.drawable.larus_ud_icon_file_word_colorful;
    L44:
        return R.drawable.larus_ud_icon_file_folder_colorful;
    L21:
        throw new NoWhenBranchMatchedException();
    L6:
        r104 = null;
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public static Integer b(CommonFileIconType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        ICommonFileIconProvider r103 = (ICommonFileIconProvider) f483543b.getValue();     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        Integer r104 = r103.a(r100);     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r105) == true) goto L16;
        r101 = r105;
    L16:
        return (Integer) r101;
    L6:
        r104 = null;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public static CommonFileIconType c(String r100) {
        String r101 = "";
        if (r100 == null) goto L5;
        String r102 = StringsKt.substringAfterLast(r100, '.', "");
    L6:
        if (r102 == null) goto L10;
        r101 = r102;
    L10:
        return d(r101);
    L5:
        r102 = null;
        goto L6
    }

    public static CommonFileIconType d(String r100) {
        if (r100 == null) goto L8;
        String r101 = StringsKt.trim(r100).toString();
        if (r101 == null) goto L8;
        String r102 = StringsKt.removePrefix(r101, ".");
        if (r102 == null) goto L8;
        String r103 = r102.toLowerCase(Locale.ROOT);
    L9:
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        if (f483544c.contains(r103) == false) goto L15;
        return CommonFileIconType.DOC;
    L15:
        if (f483545d.contains(r103) == false) goto L18;
        return CommonFileIconType.TXT;
    L18:
        if (f483546e.contains(r103) == false) goto L21;
        return CommonFileIconType.PPT;
    L21:
        if (f483547f.contains(r103) == false) goto L24;
        return CommonFileIconType.PDF;
    L24:
        if (f483555n.contains(r103) == false) goto L27;
        return CommonFileIconType.CSV;
    L27:
        if (f483548g.contains(r103) == false) goto L30;
        return CommonFileIconType.IMAGE;
    L30:
        if (f483549h.contains(r103) == false) goto L33;
        return CommonFileIconType.VIDEO;
    L33:
        if (f483550i.contains(r103) == false) goto L36;
        return CommonFileIconType.AUDIO;
    L36:
        if (f483551j.contains(r103) == false) goto L39;
        return CommonFileIconType.XLS;
    L39:
        if (f483552k.contains(r103) == false) goto L42;
        return CommonFileIconType.MARKDOWN;
    L42:
        if (f483553l.contains(r103) == false) goto L45;
        return CommonFileIconType.CODE;
    L45:
        if (f483554m.contains(r103) == false) goto L48;
        return CommonFileIconType.ZIP;
    L48:
        if (f483556o.contains(r103) == false) goto L51;
        return CommonFileIconType.KEYNOTE;
    L51:
        if (f483557p.contains(r103) == false) goto L54;
        return CommonFileIconType.PAGES;
    L54:
        if (f483558q.contains(r103) == false) goto L57;
        return CommonFileIconType.NUMBERS;
    L57:
        return CommonFileIconType.UNKNOWN;
    L8:
        r103 = null;
        goto L9
    }
}
