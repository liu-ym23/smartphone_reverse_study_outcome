package w65;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f558425a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f558426b = null;

    static {
        new String[]{"tar.gz", "tar.bz2", "tar.lzma"};
        String[][] r100 = {new String[]{"3gp", "video/3gpp"}, new String[]{"apk", "application/vnd.android.package-archive"}, new String[]{"asf", "video/x-ms-asf"}, new String[]{"avi", MimeType.AVI}, new String[]{"bin", "application/octet-stream"}, new String[]{"bmp", "image/bmp"}, new String[]{"c", "text/plain"}, new String[]{"class", "application/octet-stream"}, new String[]{"conf", "text/plain"}, new String[]{"cpp", "text/plain"}, new String[]{"doc", MimeType.DOC}, new String[]{DocumentType.DOCX_NAME, MimeType.DOCX}, new String[]{"xls", MimeType.XLS}, new String[]{"xlsx", MimeType.XLSX}, new String[]{"exe", "application/octet-stream"}, new String[]{"gif", MimeType.GIF}, new String[]{"gtar", "application/x-gtar"}, new String[]{"gz", "application/x-gzip"}, new String[]{"h", "text/plain"}, new String[]{"htm", "text/html"}, new String[]{"html", "text/html"}, new String[]{"jar", "application/java-archive"}, new String[]{"java", "text/plain"}, new String[]{LoadParams.ImageFormat.JPEG, "image/jpeg"}, new String[]{"jpg", "image/jpeg"}, new String[]{GXTemplateKey.GAIAX_JS, "application/x-javascript"}, new String[]{"log", "text/plain"}, new String[]{"m3u", "audio/x-mpegurl"}, new String[]{"m4a", "audio/mp4a-latm"}, new String[]{"m4b", "audio/mp4a-latm"}, new String[]{"m4p", "audio/mp4a-latm"}, new String[]{"m4u", "video/vnd.mpegurl"}, new String[]{"m4v", "video/x-m4v"}, new String[]{"mov", MimeType.MOV}, new String[]{"mp2", "audio/x-mpeg"}, new String[]{TTVideoEngineInterface.FORMAT_TYPE_MP3, "audio/x-mpeg"}, new String[]{"mpg4", MimeType.MP4}, new String[]{"mpc", "application/vnd.mpohun.certificate"}, new String[]{"mpe", "video/mpeg"}, new String[]{"vob", "video/mpeg"}, new String[]{"mpg", "video/mpeg"}, new String[]{"mp4", MimeType.MP4}, new String[]{"mpga", MimeType.MP3}, new String[]{"mpeg", "video/mpeg"}, new String[]{"msg", "application/vnd.ms-outlook"}, new String[]{"ogg", "audio/ogg"}, new String[]{ExportFileExtension.PDF, MimeType.PDF}, new String[]{LoadParams.ImageFormat.PNG, "image/png"}, new String[]{"pps", MimeType.PPT}, new String[]{"ppt", MimeType.PPT}, new String[]{ExportFileExtension.PPTX, MimeType.PPTX}, new String[]{"prop", "text/plain"}, new String[]{"rc", "text/plain"}, new String[]{"rmvb", "audio/x-pn-realaudio"}, new String[]{"rtf", "application/rtf"}, new String[]{"sh", "text/plain"}, new String[]{"tar", "application/x-tar"}, new String[]{"tgz", "application/x-compressed"}, new String[]{"txt", "text/plain"}, new String[]{"wav", MimeType.WAVX}, new String[]{"wma", "audio/x-ms-wma"}, new String[]{"wmv", "audio/x-ms-wmv"}, new String[]{"wps", "application/vnd.ms-works"}, new String[]{"xml", "text/plain"}, new String[]{MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "application/x-compress"}, new String[]{"zip", "application/x-zip-compressed"}, new String[]{"rar", MimeType.RAR}, new String[]{"ai", "application/postscript"}, new String[]{"", "*/*"}};
        f558425a = new HashMap();
        f558426b = new HashMap();
        int r101 = 0;
    L3:
        if (r101 >= 69) goto L5;
        String[] r102 = r100[r101];
        ((HashMap) f558425a).put(r102[0], r102[1]);
        ((HashMap) f558426b).put(r102[1], r102[0]);
        r101 = r101 + 1;
        goto L3
    }
}
