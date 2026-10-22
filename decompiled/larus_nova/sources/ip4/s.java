package ip4;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.larus.nova.R;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f495297a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f495298b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f495299c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a[] f495300d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a[] f495301e = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[] f495302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f495303b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f495304c;

        public a(String[] r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "typeList");
            this.f495302a = r100;
            this.f495303b = r101;
            this.f495304c = r102;
        }
    }

    static {
        a r100 = new a(new String[]{"bmp", "gif", "ico", LoadParams.ImageFormat.JPEG, "jpg", LoadParams.ImageFormat.PNG, TemplateNodeType.RAW, "svg", "tif", "tiff", "webp", "sketch", "heic", "heif", "3fr", "arw", "cr2", "crw", "dcr", "dcs", "dng", "dwg", "erf", "kdc", "mef", "mos", "mrw", "nef", "nrw", "orf", "pef", "ppm", "r3d", "raf", "rw2", "rwl", "sr2", "svgz", "wbmp", "x3f", "ai", "psd", "psb"}, R.drawable.ud_icon_file_image_colorful, R.color.ud_Y100);
        f495297a = r100;
        a r101 = new a(new String[]{"3gp", "3gpp", "3gpp2", "asf", "avi", "dv", "f4v", "flv", "m2t", "m4v", "mkv", "mov", "mp4", "mpe", "mpeg", "mpg", "mts", "mxf", "ogv", "rm", "rmvb", "vob", "webm", "wmv", "ts"}, R.drawable.ud_icon_file_video_colorful, R.color.ud_B100);
        f495298b = r101;
        a r102 = new a(new String[]{"aac", "amr", SpeechEngineDefines.AU_ENGINE, "cda", "flac", "m4a", TTVideoEngineInterface.FORMAT_TYPE_MP3, "oga", "ogg", "wav", "wma", "m4r", "air", "aiff"}, R.drawable.ud_icon_file_audio_colorful, R.color.ud_G100);
        a r103 = new a(new String[]{"rtf", "txt"}, R.drawable.ud_icon_file_text_colorful, R.color.ud_B100);
        a r104 = new a(new String[]{DocumentType.DOCX_NAME, "doc", "dotx", "dot", "dotm", "wps"}, R.drawable.ud_icon_file_word_colorful, R.color.ud_B100);
        a r105 = new a(new String[]{"xlsx", "xls", "xlsm", "xlm", "xlsb", "csv", "et"}, R.drawable.ud_icon_file_excel_colorful, R.color.ud_G100);
        a r106 = new a(new String[]{ExportFileExtension.PPTX, "ppt", "pps", "ppsx", "potx", "pot", "pptm", "potm", "ppsm"}, R.drawable.ud_icon_file_ppt_colorful, R.color.ud_O100);
        a r107 = new a(new String[]{"7z", "rar", "tar", "gz", "zip", "bz2", "cab", "zipx", "jar", "ace", "arj", "lzh", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "bz", "cpio", "iso", "lha", "lz", "lzma", "tbz", "taz", "tbz2", "tgz", "tlz", "txz", "tz", "xar", "xz"}, R.drawable.ud_icon_file_zip_colorful, R.color.ud_B100);
        a r110 = new a(new String[]{"c", "h", "m", "cpp", "swift", "html", "htm", GXTemplateKey.GAIAX_CSS, GXTemplateKey.GAIAX_JS, "java", "py", "php", "xml", "go", "rb", SRStrategy.MEDIAINFO_KEY_CACHE_SIZE, "sh", "bash", "sql", "scss", "less", "tsx", "jsx", "log", "ejs", "jsp", "kt", "vue", "r", "scala", "pl", "hs", "lua", "dart", "conf", "coffee", "rs", "json", "url", "webloc", "website", "as", "as3", "asm", "aspx", "asp", "bat", "cc", "cmake", "cxx", "diff", "erb", "erl", "groovy", "gvy", "haml", "hh", "hpp", "hxx", "lst", "make", "ml", "mm", Argument.OUT, "patch", "plist", "properties", "sass", "script", "scm", "sml", "vb", "vi", "vim", "xhtml", "xsd", "xsl", "yaml", "yml", "md", "markdown", "mdown", "mkdn"}, R.drawable.ud_icon_file_code_colorful, R.color.ud_B100);
        a r111 = new a(new String[]{ExportFileExtension.PDF}, R.drawable.ud_icon_file_pdf_colorful, R.color.ud_R100);
        a r112 = new a(new String[]{"ae"}, R.drawable.ud_icon_file_ae_colorful, R.color.ud_V100);
        a r108 = new a(new String[]{"ai"}, R.drawable.ud_icon_file_ai_colorful, R.color.ud_O100);
        a r113 = new a(new String[]{"psd"}, R.drawable.ud_icon_file_ps_colorful, R.color.ud_B100);
        a r114 = new a(new String[]{"apk"}, R.drawable.ud_icon_file_android_colorful, R.color.ud_G100);
        a r109 = new a(new String[]{"key"}, R.drawable.ud_icon_file_keynote_colorful, R.color.ud_B100);
        a r115 = new a(new String[]{"sketch"}, R.drawable.ud_icon_file_sketch_colorful, R.color.ud_I100);
        f495299c = new a(new String[0], R.drawable.ud_icon_file_unknow_colorful, R.color.attachment_box_unknown_file_type_bg);
        f495300d = new a[]{r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r108, r113, r114, r109, r115};
        f495301e = new a[]{r100, r101, r104, r105, r106, r111, r112, r108, r113, r115};
    }

    @JvmStatic
    public static final boolean a(String r100) {
        if (r100 == null) goto L4;
        return false;
    L4:
        if (eu5.c.d() == true) goto L7;
        return true;
    L7:
        throw new Throwable("filename is null");
    }

    @JvmStatic
    public static final a b(String r100) {
        if (a(r100) == true) goto L5;
        String r101 = FileUtils.s(r100);
        a[] r102 = f495300d;
        ArrayList r103 = new ArrayList(r102.length);
        int r104 = r102.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L13;
        a r106 = r102[r105];
        String[] r107 = r106.f495302a;
        Intrinsics.checkNotNull(r101);
        if (ArraysKt.contains(r107, r101.toLowerCase()) == true) goto L10;
        r103.add(Unit.INSTANCE);
        r105 = r105 + 1;
        goto L7
    L10:
        return r106;
    L13:
        return f495299c;
    L5:
        return f495299c;
    }

    @JvmStatic
    public static final boolean c(String r100) {
        if (a(r100) == false) goto L6;
        return false;
    L6:
        String r101 = FileUtils.s(r100);
        String[] r102 = f495297a.f495302a;
        Intrinsics.checkNotNull(r101);
        return ArraysKt.contains(r102, r101.toLowerCase());
    }

    @JvmStatic
    public static final boolean d(String r100) {
        if (a(r100) == false) goto L6;
        return false;
    L6:
        String r101 = FileUtils.s(r100);
        String[] r102 = f495298b.f495302a;
        Intrinsics.checkNotNull(r101);
        return ArraysKt.contains(r102, r101.toLowerCase());
    }
}
