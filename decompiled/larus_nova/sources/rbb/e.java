package rbb;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.superresolution.SRStrategy;

/* JADX INFO: loaded from: classes35.dex */
public interface e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f537005a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f537006b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f537007c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f537008d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f537009e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f537010f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f537011g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f537012h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f537013i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String[] f537014j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f537015k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String[] f537016l = null;

    static {
        f537005a = new String[]{"jpg", LoadParams.ImageFormat.JPEG, LoadParams.ImageFormat.PNG, "bmp", "tif", "tiff", "svg", TemplateNodeType.RAW, "gif", "ico", "heic", "heif", "webp"};
        f537006b = new String[]{"mp4", "mov", "wmv", "m4v", "avi", "mpg", "mpeg", "rm", "rmvb", "flv", "mkv", "ogv", "ogg", "3gp", "asf", "webm", "vob", "ts"};
        f537007c = new String[]{TTVideoEngineInterface.FORMAT_TYPE_MP3, "wav", "m4a", "wma", "amr", "aac", SpeechEngineDefines.AU_ENGINE, "flac", "oga"};
        f537008d = new String[]{"txt", "rtf"};
        f537009e = new String[]{"c", "h", "m", "cpp", "swift", "html", GXTemplateKey.GAIAX_CSS, GXTemplateKey.GAIAX_JS, "java", "py", "php", "json", "xml", "rb", "go", SRStrategy.MEDIAINFO_KEY_CACHE_SIZE, "kt", "sql", "log", "htm", "matlab", "gradle", "groovy", "url"};
        f537010f = new String[]{"doc", DocumentType.DOCX_NAME, "dot", "dotx", "wps"};
        f537011g = new String[]{"xls", "xlsx", "xlsm", "xltx", "et"};
        f537012h = new String[]{"ppt", ExportFileExtension.PPTX, "pps", "ppsx", "pot", "potx"};
        f537013i = new String[]{"key", "keynote"};
        f537014j = new String[]{"zip", "rar", "tar", "gz", "tgz", "tarGz", "bz2", "tarBz2", "lzma", "tarLzma", "7z"};
        f537015k = new String[]{"md", "markdown"};
        f537016l = new String[]{"psd", "psb"};
    }
}
