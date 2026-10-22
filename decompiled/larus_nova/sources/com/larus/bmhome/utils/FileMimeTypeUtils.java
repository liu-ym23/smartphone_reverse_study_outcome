package com.larus.bmhome.utils;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.icon.CommonFileIconType;
import com.larus.nova.R;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class FileMimeTypeUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f314884a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, List<String>> f314885b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object[][] f314886c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<String> f314887d = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/utils/FileMimeTypeUtils$AudioMineTypeAbbr;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "MP3", "WAV", "M4A", "WMA", "ACC", "OGG", "AMR", "FLAC", "AIFF", "UNCLEAR", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        public static final /* synthetic */ AudioMineTypeAbbr[] f314888a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f314889b = null;
        private final String type;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<AudioMineTypeAbbr> getEntries() {
            return f314889b;
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
            f314888a = r106;
            f314889b = EnumEntriesKt.enumEntries(r106);
            Companion = new a();
        }

        public static AudioMineTypeAbbr[] values() {
            return (AudioMineTypeAbbr[]) f314888a.clone();
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

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/utils/FileMimeTypeUtils$TextMineTypeAbbr;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "TXT", "HTML", "PDF", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "CODE", PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, "XLS", "XLSX", "PPT", "PPTX", "CSV", "AI_DOC", "AI_SHEET", "AI_SLIDES", "BITABLE", "UNCLEAR", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TextMineTypeAbbr extends Enum<TextMineTypeAbbr> {
        public static final TextMineTypeAbbr AI_DOC = null;
        public static final TextMineTypeAbbr AI_SHEET = null;
        public static final TextMineTypeAbbr AI_SLIDES = null;
        public static final TextMineTypeAbbr BITABLE = null;
        public static final TextMineTypeAbbr CODE = null;
        public static final TextMineTypeAbbr CSV = null;
        public static final TextMineTypeAbbr DOC = null;
        public static final TextMineTypeAbbr DOCX = null;
        public static final TextMineTypeAbbr HTML = null;
        public static final TextMineTypeAbbr PDF = null;
        public static final TextMineTypeAbbr PPT = null;
        public static final TextMineTypeAbbr PPTX = null;
        public static final TextMineTypeAbbr TXT = null;
        public static final TextMineTypeAbbr UNCLEAR = null;
        public static final TextMineTypeAbbr XLS = null;
        public static final TextMineTypeAbbr XLSX = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TextMineTypeAbbr[] f314890a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f314891b = null;
        private final String type;

        public static EnumEntries<TextMineTypeAbbr> getEntries() {
            return f314891b;
        }

        static {
            TextMineTypeAbbr r100 = new TextMineTypeAbbr("TXT", 0, "TXT");
            TXT = r100;
            TextMineTypeAbbr r101 = new TextMineTypeAbbr("HTML", 1, "HTML");
            HTML = r101;
            TextMineTypeAbbr r102 = new TextMineTypeAbbr("PDF", 2, "PDF");
            PDF = r102;
            TextMineTypeAbbr r103 = new TextMineTypeAbbr(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 3, PreloadConfigModel.VERSION_CHECK_TYPE_DOC);
            DOC = r103;
            TextMineTypeAbbr r104 = new TextMineTypeAbbr("CODE", 4, "CODE");
            CODE = r104;
            TextMineTypeAbbr r105 = new TextMineTypeAbbr(PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, 5, PreloadConfigModel.VERSION_CHECK_TYPE_DOCX);
            DOCX = r105;
            TextMineTypeAbbr r110 = new TextMineTypeAbbr("XLS", 6, "XLS");
            XLS = r110;
            TextMineTypeAbbr r111 = new TextMineTypeAbbr("XLSX", 7, "XLSX");
            XLSX = r111;
            TextMineTypeAbbr r112 = new TextMineTypeAbbr("PPT", 8, "PPT");
            PPT = r112;
            TextMineTypeAbbr r113 = new TextMineTypeAbbr("PPTX", 9, "PPTX");
            PPTX = r113;
            TextMineTypeAbbr r114 = new TextMineTypeAbbr("CSV", 10, "CSV");
            CSV = r114;
            TextMineTypeAbbr r115 = new TextMineTypeAbbr("AI_DOC", 11, "文档");
            AI_DOC = r115;
            TextMineTypeAbbr r106 = new TextMineTypeAbbr("AI_SHEET", 12, "表格");
            AI_SHEET = r106;
            TextMineTypeAbbr r107 = new TextMineTypeAbbr("AI_SLIDES", 13, "幻灯片");
            AI_SLIDES = r107;
            TextMineTypeAbbr r108 = new TextMineTypeAbbr("BITABLE", 14, AppHost.f326268a.getApplication().getString(R.string.larus_Bitable_Doubao_Drive_Base_Option));
            BITABLE = r108;
            TextMineTypeAbbr r109 = new TextMineTypeAbbr("UNCLEAR", 15, AccountType.OTHERS);
            UNCLEAR = r109;
            TextMineTypeAbbr[] r116 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109};
            f314890a = r116;
            f314891b = EnumEntriesKt.enumEntries(r116);
        }

        public static TextMineTypeAbbr[] values() {
            return (TextMineTypeAbbr[]) f314890a.clone();
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

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f314892a = null;

        static {
            int[] r100 = new int[TextMineTypeAbbr.values().length];
            r100[TextMineTypeAbbr.TXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L55:
            r100[TextMineTypeAbbr.PDF.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L67:
            r100[TextMineTypeAbbr.DOC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L41:
            r100[TextMineTypeAbbr.DOCX.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L43:
            r100[TextMineTypeAbbr.XLS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L51:
            r100[TextMineTypeAbbr.XLSX.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L61:
            r100[TextMineTypeAbbr.PPT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L47:
            r100[TextMineTypeAbbr.PPTX.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L57:
            r100[TextMineTypeAbbr.CSV.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L59:
            r100[TextMineTypeAbbr.HTML.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L39:
            r100[TextMineTypeAbbr.CODE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L53:
            r100[TextMineTypeAbbr.AI_DOC.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L65:
            r100[TextMineTypeAbbr.AI_SHEET.ordinal()] = 13;     // Catch: NoSuchFieldError -> L33
        L37:
            r100[TextMineTypeAbbr.AI_SLIDES.ordinal()] = 14;     // Catch: NoSuchFieldError -> L34
        L45:
            r100[TextMineTypeAbbr.BITABLE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L35
        L63:
            r100[TextMineTypeAbbr.UNCLEAR.ordinal()] = 16;     // Catch: NoSuchFieldError -> L36
        L19:
            f314892a = r100;
        }
    }

    static {
        f314884a = new HashMap();
        String[][] r100 = {new String[]{"3gp", "video/3gpp"}, new String[]{"apk", "application/vnd.android.package-archive"}, new String[]{"asf", "video/x-ms-asf"}, new String[]{"avi", MimeType.AVI}, new String[]{"bin", "application/octet-stream"}, new String[]{"bmp", "image/bmp"}, new String[]{"c", "text/plain"}, new String[]{"class", "application/octet-stream"}, new String[]{"conf", "text/plain"}, new String[]{"cpp", "text/plain"}, new String[]{"csv", "text/comma-separated-values"}, new String[]{"doc", MimeType.DOC}, new String[]{"dot", MimeType.DOC}, new String[]{DocumentType.DOCX_NAME, MimeType.DOCX}, new String[]{"xls", MimeType.XLS}, new String[]{"xlsx", MimeType.XLSX}, new String[]{"exe", "application/octet-stream"}, new String[]{"gif", MimeType.GIF}, new String[]{"gtar", "application/x-gtar"}, new String[]{"gz", "application/x-gzip"}, new String[]{"h", "text/plain"}, new String[]{"htm", "text/html"}, new String[]{"html", "text/html"}, new String[]{"jar", "application/java-archive"}, new String[]{"java", "text/plain"}, new String[]{"json", "text/plain"}, new String[]{LoadParams.ImageFormat.JPEG, "image/jpeg"}, new String[]{"jpg", "image/jpeg"}, new String[]{GXTemplateKey.GAIAX_JS, "application/x-javascript"}, new String[]{"log", "text/plain"}, new String[]{"md", "text/plain"}, new String[]{"md", "text/markdown"}, new String[]{"m3u", "audio/x-mpegurl"}, new String[]{"m4a", "audio/mp4a-latm"}, new String[]{"m4b", "audio/mp4a-latm"}, new String[]{"m4p", "audio/mp4a-latm"}, new String[]{"m4u", "video/vnd.mpegurl"}, new String[]{"m4v", "video/x-m4v"}, new String[]{"mov", MimeType.MOV}, new String[]{"mp2", "audio/x-mpeg"}, new String[]{TTVideoEngineInterface.FORMAT_TYPE_MP3, "audio/x-mpeg"}, new String[]{"mpg4", MimeType.MP4}, new String[]{"mpc", "application/vnd.mpohun.certificate"}, new String[]{"mpe", "video/mpeg"}, new String[]{"vob", "video/mpeg"}, new String[]{"mpg", "video/mpeg"}, new String[]{"mp4", MimeType.MP4}, new String[]{"mpga", MimeType.MP3}, new String[]{"mpeg", "video/mpeg"}, new String[]{"msg", "application/vnd.ms-outlook"}, new String[]{"ogg", "audio/ogg"}, new String[]{ExportFileExtension.PDF, MimeType.PDF}, new String[]{LoadParams.ImageFormat.PNG, "image/png"}, new String[]{"pps", MimeType.PPT}, new String[]{"ppt", MimeType.PPT}, new String[]{ExportFileExtension.PPTX, MimeType.PPTX}, new String[]{"prop", "text/plain"}, new String[]{"rc", "text/plain"}, new String[]{"rmvb", "audio/x-pn-realaudio"}, new String[]{"rtf", "application/rtf"}, new String[]{"sh", "text/plain"}, new String[]{"tar", "application/x-tar"}, new String[]{"tgz", "application/x-compressed"}, new String[]{"txt", "text/plain"}, new String[]{"wav", MimeType.WAVX}, new String[]{"wma", "audio/x-ms-wma"}, new String[]{"wmv", "audio/x-ms-wmv"}, new String[]{"amr", "audio/amr"}, new String[]{"aac", "audio/x-aac"}, new String[]{"wps", "application/vnd.ms-works"}, new String[]{"xml", "text/xml"}, new String[]{MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "application/x-compress"}, new String[]{"zip", "application/x-zip-compressed"}, new String[]{"rar", MimeType.RAR}, new String[]{"ai", "application/postscript"}, new String[]{"", "*/*"}};
        f314885b = new HashMap();
        f314886c = new Object[][]{new Object[]{TTVideoEngineInterface.FORMAT_TYPE_MP3, CollectionsKt.listOf(MimeType.MP3)}};
        int r101 = 0;
    L3:
        if (r101 >= 76) goto L5;
        String[] r102 = r100[r101];
        f314884a.put(r102[0], r102[1]);
        r101 = r101 + 1;
        goto L3
    L5:
        Object[][] r103 = f314886c;
        int r104 = r103.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L8;
        Object[] r106 = r103[r105];
        HashMap<String, List<String>> r107 = f314885b;
        String r108 = r106[0].toString();
        Object r109 = r106[1];
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        r107.put(r108, (List) r109);
        r105 = r105 + 1;
        goto L6
    L8:
        f314887d = SetsKt.setOf(new String[]{"text/plain", MimeType.DOC, MimeType.DOCX, MimeType.XLS, MimeType.XLSX, "text/html", MimeType.PDF, MimeType.PPT, MimeType.PPTX, "application/rtf", "application/vnd.ms-works"});
    }

    public static AudioMineTypeAbbr a(String r100) {
        AudioMineTypeAbbr.a r101 = AudioMineTypeAbbr.Companion;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "type");
        AudioMineTypeAbbr[] r102 = AudioMineTypeAbbr.values();
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        AudioMineTypeAbbr r105 = r102[r104];
        if (StringsKt.equals(r105.getType(), r100, true) == true) goto L12;
        r104 = r104 + 1;
    L12:
        if (r105 == null) goto L14;
        return r105;
    L14:
        return AudioMineTypeAbbr.UNCLEAR;
    L11:
        r105 = null;
        goto L12
    }

    public static String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "extension");
        return f314884a.get(r100);
    }

    public static List d(List r100) {
        ArrayList r101 = new ArrayList();
        if (r100 == null) goto L12;
        ArrayList r102 = new ArrayList();
        Iterator r103 = r100.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        String r104 = c((String) r103.next());
        if (r104 == null) goto L6;
        r102.add(r104);
        goto L6
    L10:
        List r105 = CollectionsKt.distinct(r102);
        if (r105 == null) goto L12;
    L13:
        if (r100 == null) goto L27;
        ArrayList r106 = new ArrayList();
        Iterator r107 = r100.iterator();
    L16:
        if (r107.hasNext() == false) goto L27;
        String r108 = (String) r107.next();
        Intrinsics.checkNotNullParameter(r108, "extension");
        List<String> r109 = f314885b.get(r108);
        if (r109 == null) goto L24;
        Iterator<T> r110 = r109.iterator();
    L21:
        if (r110.hasNext() == false) goto L23;
        r101.add((String) r110.next());
        goto L21
    L23:
        Unit r111 = Unit.INSTANCE;
    L25:
        if (r111 == null) goto L16;
        r106.add(r111);
        goto L16
    L24:
        r111 = null;
    L27:
        r101.addAll(r105);
        return r101;
    L12:
        r105 = CollectionsKt.emptyList();
        goto L13
    }

    public static TextMineTypeAbbr e(String r100, String r101) {
        if (r100 != null) goto L4;
    L68:
        TextMineTypeAbbr r102 = TextMineTypeAbbr.UNCLEAR;
    L69:
        TextMineTypeAbbr r103 = TextMineTypeAbbr.UNCLEAR;
        if (r102 != r103) goto L80;
        if (r101 == null) goto L80;
        if (Intrinsics.areEqual(r101, "dot") == false) goto L77;
        return TextMineTypeAbbr.DOC;
    L77:
        if (Intrinsics.areEqual(r101, "log") == true) goto L79;
        return r103;
    L79:
        return TextMineTypeAbbr.TXT;
    L80:
        return r102;
    L4:
        switch(r100.hashCode()) {
            case -2135895576: goto L65;
            case -1418040159: goto L61;
            case -1248334925: goto L57;
            case -1218310520: goto L53;
            case -1082243251: goto L49;
            case -1073633483: goto L45;
            case -1071817359: goto L41;
            case -1050893613: goto L37;
            case -1004747228: goto L34;
            case -533161071: goto L30;
            case -366307023: goto L26;
            case -102775833: goto L22;
            case 817335912: goto L19;
            case 890891481: goto L15;
            case 904647503: goto L11;
            case 1993842850: goto L7;
            default: goto L68;
        };
    L7:
        if (r100.equals(MimeType.XLSX) == false) goto L68;
        r102 = TextMineTypeAbbr.XLSX;
        goto L69
    L11:
        if (r100.equals(MimeType.DOC) == false) goto L68;
        r102 = TextMineTypeAbbr.DOC;
        goto L69
    L15:
        if (r100.equals("ai_slides") == false) goto L68;
        r102 = TextMineTypeAbbr.AI_SLIDES;
        goto L69
    L19:
        if (r100.equals("text/plain") == false) goto L68;
        r102 = TextMineTypeAbbr.TXT;
        goto L69
    L22:
        if (r100.equals(DocumentType.BITABLE_NAME) == false) goto L68;
        r102 = TextMineTypeAbbr.BITABLE;
        goto L69
    L26:
        if (r100.equals(MimeType.XLS) == false) goto L68;
        r102 = TextMineTypeAbbr.XLS;
        goto L69
    L30:
        if (r100.equals("text/markdown") == false) goto L68;
        r102 = TextMineTypeAbbr.CODE;
        goto L69
    L34:
        if (r100.equals(MimeType.CSV) == false) goto L68;
    L67:
        r102 = TextMineTypeAbbr.CSV;
        goto L69
    L37:
        if (r100.equals(MimeType.DOCX) == false) goto L68;
        r102 = TextMineTypeAbbr.DOCX;
        goto L69
    L41:
        if (r100.equals(MimeType.PPT) == false) goto L68;
        r102 = TextMineTypeAbbr.PPT;
        goto L69
    L45:
        if (r100.equals(MimeType.PPTX) == false) goto L68;
        r102 = TextMineTypeAbbr.PPTX;
        goto L69
    L49:
        if (r100.equals("text/html") == false) goto L68;
        r102 = TextMineTypeAbbr.HTML;
        goto L69
    L53:
        if (r100.equals("ai_sheet") == false) goto L68;
        r102 = TextMineTypeAbbr.AI_SHEET;
        goto L69
    L57:
        if (r100.equals(MimeType.PDF) == false) goto L68;
        r102 = TextMineTypeAbbr.PDF;
        goto L69
    L61:
        if (r100.equals("ai_doc") == false) goto L68;
        r102 = TextMineTypeAbbr.AI_DOC;
        goto L69
    L65:
        if (r100.equals("text/comma-separated-values") == true) goto L67;
        goto L67
    }

    public static int b(String r100, String r101, boolean r102) {
        TextMineTypeAbbr r103 = e(r100, r101);
        switch(a.f314892a[r103.ordinal()]) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L16;
            case 9: goto L15;
            case 10: goto L14;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L11;
            case 14: goto L10;
            case 15: goto L7;
            case 16: goto L6;
            default: goto L5;
        };
    L6:
        CommonFileIconType r104 = CommonFileIconType.UNKNOWN;
    L21:
        h19.b.f483542a.getClass();
        return h19.b.a(r104);
    L7:
        if (r102 == false) goto L9;
        r104 = CommonFileIconType.BITABLE_APP;
        goto L21
    L9:
        r104 = CommonFileIconType.BITABLE;
        goto L21
    L10:
        r104 = CommonFileIconType.AI_SLIDES;
        goto L21
    L11:
        r104 = CommonFileIconType.AI_SHEET;
        goto L21
    L12:
        r104 = CommonFileIconType.AI_DOC;
        goto L21
    L13:
        r104 = CommonFileIconType.CODE;
        goto L21
    L14:
        r104 = CommonFileIconType.CODE;
        goto L21
    L15:
        r104 = CommonFileIconType.CSV;
        goto L21
    L16:
        r104 = CommonFileIconType.PPT;
        goto L21
    L17:
        r104 = CommonFileIconType.XLS;
        goto L21
    L18:
        r104 = CommonFileIconType.DOC;
        goto L21
    L19:
        r104 = CommonFileIconType.PDF;
        goto L21
    L20:
        r104 = CommonFileIconType.TXT;
        goto L21
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
