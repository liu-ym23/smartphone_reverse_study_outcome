package com.larus.search.impl;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class FileMimeTypeUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f367396a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, List<String>> f367397b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object[][] f367398c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<String> f367399d = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/larus/search/impl/FileMimeTypeUtils$AudioMineTypeAbbr;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "MP3", "WAV", "M4A", "WMA", "ACC", "OGG", "AMR", "FLAC", "AIFF", "UNCLEAR", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AudioMineTypeAbbr extends Enum<AudioMineTypeAbbr> {
        public static final AudioMineTypeAbbr ACC = null;
        public static final AudioMineTypeAbbr AIFF = null;
        public static final AudioMineTypeAbbr AMR = null;
        public static final a Companion = null;
        public static final AudioMineTypeAbbr FLAC = null;
        public static final AudioMineTypeAbbr M4A = null;
        public static final AudioMineTypeAbbr MP3 = null;
        public static final AudioMineTypeAbbr OGG = null;
        public static final AudioMineTypeAbbr UNCLEAR = null;
        public static final AudioMineTypeAbbr WAV = null;
        public static final AudioMineTypeAbbr WMA = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AudioMineTypeAbbr[] f367400a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f367401b = null;
        private final String type;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<AudioMineTypeAbbr> getEntries() {
            return f367401b;
        }

        static {
            AudioMineTypeAbbr r100 = new AudioMineTypeAbbr("MP3", 0, "MP3");
            MP3 = r100;
            AudioMineTypeAbbr r101 = new AudioMineTypeAbbr("WAV", 1, "WAV");
            WAV = r101;
            AudioMineTypeAbbr r102 = new AudioMineTypeAbbr("M4A", 2, "M4A");
            M4A = r102;
            AudioMineTypeAbbr r103 = new AudioMineTypeAbbr("WMA", 3, "WMA");
            WMA = r103;
            AudioMineTypeAbbr r104 = new AudioMineTypeAbbr("ACC", 4, "AAC");
            ACC = r104;
            AudioMineTypeAbbr r105 = new AudioMineTypeAbbr("OGG", 5, "OGG");
            OGG = r105;
            AudioMineTypeAbbr r110 = new AudioMineTypeAbbr("AMR", 6, "AMR");
            AMR = r110;
            AudioMineTypeAbbr r111 = new AudioMineTypeAbbr("FLAC", 7, "FLAC");
            FLAC = r111;
            AudioMineTypeAbbr r112 = new AudioMineTypeAbbr("AIFF", 8, "AIFF");
            AIFF = r112;
            AudioMineTypeAbbr r113 = new AudioMineTypeAbbr("UNCLEAR", 9, "UNKNOWN");
            UNCLEAR = r113;
            AudioMineTypeAbbr[] r106 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
            f367400a = r106;
            f367401b = EnumEntriesKt.enumEntries(r106);
            Companion = new a();
        }

        public static AudioMineTypeAbbr[] values() {
            return (AudioMineTypeAbbr[]) f367400a.clone();
        }

        public final String getType() {
            return this.type;
        }

        public static AudioMineTypeAbbr valueOf(String r100) {
            return (AudioMineTypeAbbr) r27.a.a(AudioMineTypeAbbr.class, r100);
        }

        public AudioMineTypeAbbr(String r100, int r101, String r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/search/impl/FileMimeTypeUtils$TextMineTypeAbbr;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "TXT", "PDF", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, "XLS", "XLSX", "PPT", "PPTX", "CSV", "UNCLEAR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TextMineTypeAbbr extends Enum<TextMineTypeAbbr> {
        public static final TextMineTypeAbbr CSV = null;
        public static final TextMineTypeAbbr DOC = null;
        public static final TextMineTypeAbbr DOCX = null;
        public static final TextMineTypeAbbr PDF = null;
        public static final TextMineTypeAbbr PPT = null;
        public static final TextMineTypeAbbr PPTX = null;
        public static final TextMineTypeAbbr TXT = null;
        public static final TextMineTypeAbbr UNCLEAR = null;
        public static final TextMineTypeAbbr XLS = null;
        public static final TextMineTypeAbbr XLSX = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TextMineTypeAbbr[] f367402a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f367403b = null;
        private final String type;

        public static EnumEntries<TextMineTypeAbbr> getEntries() {
            return f367403b;
        }

        static {
            TextMineTypeAbbr r100 = new TextMineTypeAbbr("TXT", 0, "TXT");
            TXT = r100;
            TextMineTypeAbbr r101 = new TextMineTypeAbbr("PDF", 1, "PDF");
            PDF = r101;
            TextMineTypeAbbr r102 = new TextMineTypeAbbr(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 2, PreloadConfigModel.VERSION_CHECK_TYPE_DOC);
            DOC = r102;
            TextMineTypeAbbr r103 = new TextMineTypeAbbr(PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, 3, PreloadConfigModel.VERSION_CHECK_TYPE_DOCX);
            DOCX = r103;
            TextMineTypeAbbr r104 = new TextMineTypeAbbr("XLS", 4, "XLS");
            XLS = r104;
            TextMineTypeAbbr r105 = new TextMineTypeAbbr("XLSX", 5, "XLSX");
            XLSX = r105;
            TextMineTypeAbbr r110 = new TextMineTypeAbbr("PPT", 6, "PPT");
            PPT = r110;
            TextMineTypeAbbr r111 = new TextMineTypeAbbr("PPTX", 7, "PPTX");
            PPTX = r111;
            TextMineTypeAbbr r112 = new TextMineTypeAbbr("CSV", 8, "CSV");
            CSV = r112;
            TextMineTypeAbbr r113 = new TextMineTypeAbbr("UNCLEAR", 9, "UNKNOWN");
            UNCLEAR = r113;
            TextMineTypeAbbr[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
            f367402a = r114;
            f367403b = EnumEntriesKt.enumEntries(r114);
        }

        public static TextMineTypeAbbr[] values() {
            return (TextMineTypeAbbr[]) f367402a.clone();
        }

        public final String getType() {
            return this.type;
        }

        public static TextMineTypeAbbr valueOf(String r100) {
            return (TextMineTypeAbbr) r27.a.a(TextMineTypeAbbr.class, r100);
        }

        public TextMineTypeAbbr(String r100, int r101, String r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    static {
        f367396a = new HashMap();
        String[][] r100 = {new String[]{"3gp", "video/3gpp"}, new String[]{"apk", "application/vnd.android.package-archive"}, new String[]{"asf", "video/x-ms-asf"}, new String[]{"avi", MimeType.AVI}, new String[]{"bin", "application/octet-stream"}, new String[]{"bmp", "image/bmp"}, new String[]{"c", "text/plain"}, new String[]{"class", "application/octet-stream"}, new String[]{"conf", "text/plain"}, new String[]{"cpp", "text/plain"}, new String[]{"csv", "text/comma-separated-values"}, new String[]{"doc", MimeType.DOC}, new String[]{DocumentType.DOCX_NAME, MimeType.DOCX}, new String[]{"xls", MimeType.XLS}, new String[]{"xlsx", MimeType.XLSX}, new String[]{"exe", "application/octet-stream"}, new String[]{"gif", MimeType.GIF}, new String[]{"gtar", "application/x-gtar"}, new String[]{"gz", "application/x-gzip"}, new String[]{"h", "text/plain"}, new String[]{"htm", "text/html"}, new String[]{"html", "text/html"}, new String[]{"jar", "application/java-archive"}, new String[]{"java", "text/plain"}, new String[]{LoadParams.ImageFormat.JPEG, "image/jpeg"}, new String[]{"jpg", "image/jpeg"}, new String[]{GXTemplateKey.GAIAX_JS, "application/x-javascript"}, new String[]{"log", "text/plain"}, new String[]{"m3u", "audio/x-mpegurl"}, new String[]{"m4a", "audio/mp4a-latm"}, new String[]{"m4b", "audio/mp4a-latm"}, new String[]{"m4p", "audio/mp4a-latm"}, new String[]{"m4u", "video/vnd.mpegurl"}, new String[]{"m4v", "video/x-m4v"}, new String[]{"mov", MimeType.MOV}, new String[]{"mp2", "audio/x-mpeg"}, new String[]{TTVideoEngineInterface.FORMAT_TYPE_MP3, "audio/x-mpeg"}, new String[]{"mpg4", MimeType.MP4}, new String[]{"mpc", "application/vnd.mpohun.certificate"}, new String[]{"mpe", "video/mpeg"}, new String[]{"vob", "video/mpeg"}, new String[]{"mpg", "video/mpeg"}, new String[]{"mp4", MimeType.MP4}, new String[]{"mpga", MimeType.MP3}, new String[]{"mpeg", "video/mpeg"}, new String[]{"msg", "application/vnd.ms-outlook"}, new String[]{"ogg", "audio/ogg"}, new String[]{ExportFileExtension.PDF, MimeType.PDF}, new String[]{LoadParams.ImageFormat.PNG, "image/png"}, new String[]{"pps", MimeType.PPT}, new String[]{"ppt", MimeType.PPT}, new String[]{ExportFileExtension.PPTX, MimeType.PPTX}, new String[]{"prop", "text/plain"}, new String[]{"rc", "text/plain"}, new String[]{"rmvb", "audio/x-pn-realaudio"}, new String[]{"rtf", "application/rtf"}, new String[]{"sh", "text/plain"}, new String[]{"tar", "application/x-tar"}, new String[]{"tgz", "application/x-compressed"}, new String[]{"txt", "text/plain"}, new String[]{"wav", MimeType.WAVX}, new String[]{"wma", "audio/x-ms-wma"}, new String[]{"wmv", "audio/x-ms-wmv"}, new String[]{"amr", "audio/amr"}, new String[]{"aac", "audio/x-aac"}, new String[]{"wps", "application/vnd.ms-works"}, new String[]{"xml", "text/xml"}, new String[]{MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "application/x-compress"}, new String[]{"zip", "application/x-zip-compressed"}, new String[]{"rar", MimeType.RAR}, new String[]{"ai", "application/postscript"}, new String[]{"", "*/*"}};
        f367397b = new HashMap();
        f367398c = new Object[][]{new Object[]{TTVideoEngineInterface.FORMAT_TYPE_MP3, CollectionsKt.listOf(MimeType.MP3)}};
        int r101 = 0;
    L3:
        if (r101 >= 72) goto L5;
        String[] r102 = r100[r101];
        f367396a.put(r102[0], r102[1]);
        r101 = r101 + 1;
        goto L3
    L5:
        Object[][] r103 = f367398c;
        int r104 = r103.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L8;
        Object[] r106 = r103[r105];
        HashMap<String, List<String>> r107 = f367397b;
        String r108 = r106[0].toString();
        Object r109 = r106[1];
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        r107.put(r108, (List) r109);
        r105 = r105 + 1;
        goto L6
    L8:
        f367399d = SetsKt.setOf(new String[]{"text/plain", MimeType.DOC, MimeType.DOCX, MimeType.XLS, MimeType.XLSX, "text/html", MimeType.PDF, MimeType.PPT, MimeType.PPTX, "application/rtf", "application/vnd.ms-works"});
    }

    public static List a(List r100) {
        ArrayList r101 = new ArrayList();
        if (r100 == null) goto L12;
        ArrayList r102 = new ArrayList();
        Iterator r103 = r100.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        String r104 = (String) r103.next();
        Intrinsics.checkNotNullParameter(r104, "extension");
        String r105 = f367396a.get(r104);
        if (r105 == null) goto L6;
        r102.add(r105);
        goto L6
    L10:
        List r106 = CollectionsKt.distinct(r102);
        if (r106 == null) goto L12;
    L13:
        if (r100 == null) goto L27;
        ArrayList r107 = new ArrayList();
        Iterator r108 = r100.iterator();
    L16:
        if (r108.hasNext() == false) goto L27;
        String r109 = (String) r108.next();
        Intrinsics.checkNotNullParameter(r109, "extension");
        List<String> r110 = f367397b.get(r109);
        if (r110 == null) goto L24;
        Iterator<T> r111 = r110.iterator();
    L21:
        if (r111.hasNext() == false) goto L23;
        r101.add((String) r111.next());
        goto L21
    L23:
        Unit r112 = Unit.INSTANCE;
    L25:
        if (r112 == null) goto L16;
        r107.add(r112);
        goto L16
    L24:
        r112 = null;
    L27:
        r101.addAll(r106);
        return r101;
    L12:
        r106 = CollectionsKt.emptyList();
        goto L13
    }
}
