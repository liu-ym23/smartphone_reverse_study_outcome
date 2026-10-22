package com.ss.android.lark.utils;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.dtf.face.ui.toyger.FaceShowElderlyFragment;
import com.larus.nova.R;
import com.obric.sva.sdk.controller.Global;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.lark.videosend.tools.VideoTools;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes38.dex */
public final enum FileType extends Enum<FileType> {
    public static final FileType TYPE_AE = null;
    public static final FileType TYPE_AI = null;
    public static final FileType TYPE_APK = null;
    public static final FileType TYPE_AUDIO = null;
    public static final FileType TYPE_CODE = null;
    public static final FileType TYPE_CSV = null;
    public static final FileType TYPE_DOC = null;
    public static final FileType TYPE_EML = null;
    public static final FileType TYPE_FOLDER = null;
    public static final FileType TYPE_ICS = null;
    public static final FileType TYPE_IMG = null;
    public static final FileType TYPE_IPA = null;
    public static final FileType TYPE_KEYNOTE = null;
    public static final FileType TYPE_MD = null;
    public static final FileType TYPE_MSG = null;
    public static final FileType TYPE_NUMBERS = null;
    public static final FileType TYPE_PAGES = null;
    public static final FileType TYPE_PDF = null;
    public static final FileType TYPE_PPT = null;
    public static final FileType TYPE_PSD = null;
    public static final FileType TYPE_SKETCH = null;
    public static final FileType TYPE_SLIDE = null;
    public static final FileType TYPE_TXT = null;
    public static final FileType TYPE_UNKNOWN = null;
    public static final FileType TYPE_VCF = null;
    public static final FileType TYPE_VIDEO = null;
    public static final FileType TYPE_XLS = null;
    public static final FileType TYPE_ZIP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FileType[] f444662a = null;
    private String[] mimeArray;
    private int[] resIdArray;
    private Set<String> suffixSet;

    static {
        FileType r100 = new FileType("TYPE_PDF", 0, new String[0], new String[]{".pdf"}, new int[]{R.drawable.icon_file_pdf_v2, R.drawable.ud_icon_file_pdf_colorful, R.drawable.icon_file_pdf_v2, R.drawable.icon_file_pdf_rectangle});
        TYPE_PDF = r100;
        FileType r101 = new FileType("TYPE_PPT", 1, new String[]{"ms-powerpoint", "presentationml"}, new String[]{".ppt", ".pptx", ".pps", ".ppsx", ".pot", ".potx"}, new int[]{R.drawable.icon_file_ppt_v2, R.drawable.ud_icon_file_ppt_colorful, R.drawable.icon_file_ppt_v2, R.drawable.icon_file_ppt_rectangle});
        TYPE_PPT = r101;
        FileType r102 = new FileType("TYPE_DOC", 2, new String[]{"rtf", "msword", "wordprocessingml", "ms-works"}, new String[]{".doc", ".docx", ".dot", ".dotx", ".wps"}, new int[]{R.drawable.icon_file_doc_v2, R.drawable.ud_icon_file_word_colorful, R.drawable.icon_file_doc_v2, R.drawable.icon_file_doc_rectangle});
        TYPE_DOC = r102;
        FileType r103 = new FileType("TYPE_CSV", 3, new String[]{MimeType.CSV, "application/csv"}, new String[]{".csv"}, new int[]{R.drawable.ud_icon_file_round_csv_colorful, R.drawable.ud_icon_file_csv_colorful, R.drawable.ud_icon_file_round_csv_colorful, R.drawable.ud_icon_file_csv_colorful});
        TYPE_CSV = r103;
        FileType r104 = new FileType("TYPE_XLS", 4, new String[]{"ms-excel", "spreadsheetml"}, new String[]{".xls", ".xlsx", ".xlsm", ".et"}, new int[]{R.drawable.icon_file_xls_v2, R.drawable.ud_icon_file_excel_colorful, R.drawable.icon_file_xls_v2, R.drawable.icon_file_xls_rectangle});
        TYPE_XLS = r104;
        FileType r105 = new FileType("TYPE_ZIP", 5, new String[]{"zip", "rar", VideoTools.ERROR_TYPE_COMPRESS, "tar"}, new String[]{".zip", ".rar", ".7z", ".tar", ".tar.gz", ".tar.xz", ".tar.bz2"}, new int[]{R.drawable.icon_file_zip_v2, R.drawable.ud_icon_file_zip_colorful, R.drawable.icon_file_zip_v2, R.drawable.icon_file_zip_rectangle});
        TYPE_ZIP = r105;
        FileType r106 = new FileType("TYPE_PSD", 6, new String[]{"vnd.adobe.photoshop"}, new String[]{".psd"}, new int[]{R.drawable.icon_file_psd_v2, R.drawable.ud_icon_file_ps_colorful, R.drawable.icon_file_psd_v2, R.drawable.icon_file_psd_rectangle});
        TYPE_PSD = r106;
        FileType r107 = new FileType("TYPE_IMG", 7, new String[]{"image", LoadParams.ImageFormat.JPEG, LoadParams.ImageFormat.PNG}, new String[]{".jpg", ".jpeg", RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT, ".bmp", EffectConstants.GIF_FILE_SUFFIX, ".tif", ".tiff", ".svg", ".raw"}, new int[]{R.drawable.icon_file_picture_v2, R.drawable.ud_icon_file_image_colorful, R.drawable.icon_file_picture_v2, R.drawable.icon_file_picture_rectangle});
        TYPE_IMG = r107;
        FileType r110 = new FileType("TYPE_VIDEO", 8, new String[]{"video"}, new String[]{".mp4", ".mov", ".wmv", ".m4v", ".avi", ".mpg", ".mpeg", ".rm", ".rmvb", ".flv", ".mkv", ".ogv"}, new int[]{R.drawable.icon_file_video_v2, R.drawable.ud_icon_file_video_colorful, R.drawable.icon_file_video_v2, R.drawable.icon_file_video_rectangle});
        TYPE_VIDEO = r110;
        FileType r111 = new FileType("TYPE_AUDIO", 9, new String[]{"audio"}, new String[]{FaceShowElderlyFragment.AUDIO_FORM, Global.SUFFIX_WAV_FILE, ".m4a", ".wma", ".amr", ".aac", ".au", ".flac", ".oga", ".ogg", ".mpga"}, new int[]{R.drawable.icon_file_audio_v2, R.drawable.ud_icon_file_audio_colorful, R.drawable.icon_file_audio_v2, R.drawable.icon_file_audio_rectangle});
        TYPE_AUDIO = r111;
        FileType r112 = new FileType("TYPE_TXT", 10, new String[]{"text/plain"}, new String[]{Global.SUFFIX_TXT_FILE, ".rtf"}, new int[]{R.drawable.icon_file_txt_v2, R.drawable.ud_icon_file_text_colorful, R.drawable.icon_file_txt_v2, R.drawable.icon_file_txt_rectangle});
        TYPE_TXT = r112;
        FileType r108 = new FileType("TYPE_MD", 11, new String[0], new String[]{".md", ".markdown", ".mdown", ".mkdn"}, new int[]{R.drawable.ud_icon_file_md_colorful, R.drawable.ud_icon_file_md_colorful, R.drawable.ud_icon_file_md_colorful, R.drawable.ud_icon_file_md_colorful});
        TYPE_MD = r108;
        FileType r109 = new FileType("TYPE_APK", 12, new String[]{"application/vnd.android.package-archive"}, new String[]{".apk"}, new int[]{R.drawable.icon_file_apk_v2, R.drawable.ud_icon_file_android_colorful, R.drawable.icon_file_apk_v2, R.drawable.icon_file_apk_rectangle});
        TYPE_APK = r109;
        FileType r113 = new FileType("TYPE_AI", 13, new String[]{"postscript"}, new String[]{".ai"}, new int[]{R.drawable.icon_file_ai_v2, R.drawable.ud_icon_file_ai_colorful, R.drawable.icon_file_ai_v2, R.drawable.icon_file_ai_rectangle});
        TYPE_AI = r113;
        FileType r114 = new FileType("TYPE_SKETCH", 14, new String[0], new String[]{".sketch"}, new int[]{R.drawable.icon_file_sketch_v2, R.drawable.ud_icon_file_sketch_colorful, R.drawable.icon_file_sketch_v2, R.drawable.icon_file_sketch_rectangle});
        TYPE_SKETCH = r114;
        FileType r115 = new FileType("TYPE_AE", 15, new String[0], new String[]{".aep"}, new int[]{R.drawable.icon_file_ae_v2, R.drawable.ud_icon_file_ae_colorful, R.drawable.icon_file_ae_v2, R.drawable.icon_file_ae_rectangle});
        TYPE_AE = r115;
        FileType r116 = new FileType("TYPE_KEYNOTE", 16, new String[0], new String[]{".key"}, new int[]{R.drawable.icon_file_keynote_v2, R.drawable.ud_icon_file_keynote_colorful, R.drawable.icon_file_keynote_v2, R.drawable.icon_file_keynote_rectangle});
        TYPE_KEYNOTE = r116;
        FileType r117 = new FileType("TYPE_NUMBERS", 17, new String[0], new String[]{".numbers"}, new int[]{R.drawable.ud_icon_file_round_numbers_colorful, R.drawable.ud_icon_file_numbers_colorful, R.drawable.ud_icon_file_round_numbers_colorful, R.drawable.ud_icon_file_numbers_colorful});
        TYPE_NUMBERS = r117;
        FileType r118 = new FileType("TYPE_PAGES", 18, new String[0], new String[]{".pages"}, new int[]{R.drawable.ud_icon_file_round_pages_colorful, R.drawable.ud_icon_file_pages_colorful, R.drawable.ud_icon_file_round_pages_colorful, R.drawable.ud_icon_file_pages_colorful});
        TYPE_PAGES = r118;
        FileType r119 = new FileType("TYPE_EML", 19, new String[0], new String[]{".eml"}, new int[]{R.drawable.ud_icon_file_eml_colorful, R.drawable.ud_icon_file_eml_colorful, R.drawable.ud_icon_file_eml_colorful, R.drawable.ud_icon_file_eml_colorful});
        TYPE_EML = r119;
        FileType r120 = new FileType("TYPE_MSG", 20, new String[0], new String[]{".msg"}, new int[]{R.drawable.ud_icon_file_round_msg_colorful, R.drawable.ud_icon_file_msg_colorful, R.drawable.ud_icon_file_round_msg_colorful, R.drawable.ud_icon_file_msg_colorful});
        TYPE_MSG = r120;
        FileType r121 = new FileType("TYPE_UNKNOWN", 21, new String[0], new String[0], new int[]{R.drawable.icon_file_default_v2, R.drawable.ud_icon_file_unknow_colorful, R.drawable.icon_file_default_v2, R.drawable.icon_file_default_rectangle});
        TYPE_UNKNOWN = r121;
        FileType r122 = new FileType("TYPE_ICS", 22, new String[0], new String[]{".ics"}, new int[]{R.drawable.ud_icon_file_calendar_colorful, R.drawable.ud_icon_file_calendar_colorful, R.drawable.ud_icon_file_calendar_colorful, R.drawable.ud_icon_file_calendar_colorful});
        TYPE_ICS = r122;
        FileType r123 = new FileType("TYPE_CODE", 23, new String[0], new String[]{".java", ".kt", ".kts", ".js", ".ts", ".py", ".sh", ".c", ".cc", ".cpp", ".h", ".go", ".rs", InvRouter.FLOW_SUFFIX, ".xml", ".gradle", ".properties", ".php", ".css", ".html"}, new int[]{R.drawable.ud_icon_file_code_colorful, R.drawable.ud_icon_file_code_colorful, R.drawable.ud_icon_file_code_colorful, R.drawable.ud_icon_file_code_colorful});
        TYPE_CODE = r123;
        FileType r124 = new FileType("TYPE_IPA", 24, new String[0], new String[]{".ipa"}, new int[]{R.drawable.ud_icon_file_ios_colorful, R.drawable.ud_icon_file_ios_colorful, R.drawable.ud_icon_file_ios_colorful, R.drawable.ud_icon_file_ios_colorful});
        TYPE_IPA = r124;
        FileType r125 = new FileType("TYPE_SLIDE", 25, new String[0], new String[]{".slide"}, new int[]{R.drawable.ud_icon_wiki_slides_colorful, R.drawable.ud_icon_wiki_slides_colorful, R.drawable.ud_icon_wiki_slides_colorful, R.drawable.ud_icon_wiki_slides_colorful});
        TYPE_SLIDE = r125;
        FileType r126 = new FileType("TYPE_VCF", 26, new String[0], new String[]{".vcf"}, new int[]{R.drawable.ud_icon_file_vcf_colorful, R.drawable.ud_icon_file_vcf_colorful, R.drawable.ud_icon_file_vcf_colorful, R.drawable.ud_icon_file_vcf_colorful});
        TYPE_VCF = r126;
        FileType r127 = new FileType("TYPE_FOLDER", 27, new String[0], new String[0], new int[]{R.drawable.icon_folder_avatar, R.drawable.ud_icon_file_folder_colorful});
        TYPE_FOLDER = r127;
        f444662a = new FileType[]{r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r108, r109, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127};
    }

    public static FileType[] values() {
        return (FileType[]) f444662a.clone();
    }

    public int getDocFileResId() {
        int[] r100 = this.resIdArray;
        if (r100 != null) goto L5;
    L7:
        int r101 = R.drawable.icon_file_default_v2;
    L9:
        return kac.a.b(r101);
    L5:
        if (r100.length <= 2) goto L7;
        r101 = r100[2];
        goto L9
    }

    public static FileType getFileTypeByMime(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        String r101 = r100.toLowerCase();
        FileType[] r102 = values();
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L13;
        FileType r105 = r102[r104];
        if (r105.isMimeMatch(r101) == true) goto L10;
        r104 = r104 + 1;
        goto L7
    L10:
        return r105;
    L13:
        return TYPE_UNKNOWN;
    L5:
        return TYPE_UNKNOWN;
    }

    public static FileType getFileTypeBySuffix(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        String r101 = r100.toLowerCase();
        FileType[] r102 = values();
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L13;
        FileType r105 = r102[r104];
        if (r105.isSuffixMatch(r101) == true) goto L10;
        r104 = r104 + 1;
        goto L7
    L10:
        return r105;
    L13:
        return TYPE_UNKNOWN;
    L5:
        return TYPE_UNKNOWN;
    }

    public static Boolean isVideoOrAudio(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        String r101 = r100.toLowerCase();
        if (TYPE_VIDEO.isMimeMatch(r101) == false) goto L9;
    L12:
        boolean r102 = true;
    L14:
        return Boolean.valueOf(r102);
    L9:
        if (TYPE_AUDIO.isMimeMatch(r101) == true) goto L12;
        r102 = false;
        goto L14
    L5:
        return Boolean.FALSE;
    }

    public static Boolean isVideoOrAudioBySuffix(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        String r101 = r100.toLowerCase();
        if (TYPE_VIDEO.isSuffixMatch(r101) == false) goto L9;
    L12:
        boolean r102 = true;
    L14:
        return Boolean.valueOf(r102);
    L9:
        if (TYPE_AUDIO.isSuffixMatch(r101) == true) goto L12;
        r102 = false;
        goto L14
    L5:
        return Boolean.FALSE;
    }

    public static FileType valueOf(String r100) {
        return (FileType) r27.a.a(FileType.class, r100);
    }

    public int getResId(int r100) {
        int[] r101 = this.resIdArray;
        if (r101 == null) goto L8;
        if (r101.length <= r100) goto L8;
        int r102 = r101[r100];
    L20:
        return kac.a.b(r102);
    L8:
        if (r100 != 0) goto L10;
    L18:
        r102 = R.drawable.icon_file_default_v2;
        goto L20
    L10:
        if (r100 != 1) goto L12;
        r102 = R.drawable.ud_icon_file_unknow_colorful;
        goto L20
    L12:
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        r102 = R.drawable.icon_file_message_default_v2;
        goto L20
    L16:
        r102 = R.drawable.icon_file_default_rectangle;
        goto L20
    }

    public boolean isMimeMatch(String r100) {
        String[] r101 = this.mimeArray;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (r100.contains(r101[r103]) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public boolean isSuffixMatch(String r100) {
        return this.suffixSet.contains(r100);
    }

    public int getResId(boolean r100) {
        int[] r101 = this.resIdArray;
        if (r101 != null) goto L5;
    L7:
        if (r100 == true) goto L9;
        int r102 = R.drawable.icon_file_default_v2;
    L11:
        return kac.a.b(r102);
    L9:
        r102 = R.drawable.icon_file_message_default_v2;
        goto L11
    L5:
        if (r101.length <= 1) goto L7;
        r102 = r101[r100 ? 1 : 0];
        goto L11
    }

    public FileType(String r100, int r101, String[] r102, String[] r103, int[] r104) {
        super(r100, r101);
        this.mimeArray = r102;
        this.suffixSet = new HashSet(Arrays.asList(r103));
        this.resIdArray = r104;
    }
}
