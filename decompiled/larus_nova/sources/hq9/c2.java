package hq9;

import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.google.gson.annotations.SerializedName;
import com.larus.platform.model.EnterpriseConfig;
import com.obric.sva.sdk.controller.Global;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b4\b\u0086\b\u0018\u00002\u00020\u0001Bå\u0001\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0012\b\u0002\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u00101\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003J\t\u00105\u001a\u00020\nHÆ\u0003J\t\u00106\u001a\u00020\nHÆ\u0003J\t\u00107\u001a\u00020\rHÆ\u0003J\t\u00108\u001a\u00020\nHÆ\u0003J\u0013\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010:\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010;\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0013\u0010=\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010>\u001a\u00020\nHÆ\u0003J\t\u0010?\u001a\u00020\u0006HÆ\u0003J\t\u0010@\u001a\u00020\u0006HÆ\u0003J\t\u0010A\u001a\u00020\u0006HÆ\u0003Jç\u0001\u0010B\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\n2\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0012\b\u0002\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u0006HÆ\u0001J\u0013\u0010C\u001a\u00020\u00062\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020\nHÖ\u0001J\t\u0010F\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\u000e\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R \u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR \u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR \u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R \u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u0016\u0010\u0015\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u0016\u0010\u0016\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001eR\u0016\u0010\u0017\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR\u0016\u0010\u0018\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001e¨\u0006G"}, d2 = {"Lcom/larus/platform/model/LarkDriveConfig;", "", "aiAskSupportPostfix", "", "", "showChatBottomDrive", "", "enableSendingVideo", "showSettingPageDrive", "uploadListSize", "", "fileNameMaxLength", "picSendMaxSize", "", "fileListPageLength", "fileCanNotSupportPreview", "mediaSupportSaveToAlbum", "driveListFileType", "enterpriseSettings", "Lcom/larus/platform/model/EnterpriseConfig;", "filePickerAllowedTypes", "fileUploadUiStyle", "enableListMultiSelect", "galleryTransitionOpt", "useNewList", "<init>", "(Ljava/util/List;ZZZIIJILjava/util/List;Ljava/util/List;Ljava/util/List;Lcom/larus/platform/model/EnterpriseConfig;Ljava/util/List;IZZZ)V", "getAiAskSupportPostfix", "()Ljava/util/List;", "getShowChatBottomDrive", "()Z", "getEnableSendingVideo", "getShowSettingPageDrive", "getUploadListSize", "()I", "getFileNameMaxLength", "getPicSendMaxSize", "()J", "getFileListPageLength", "getFileCanNotSupportPreview", "getMediaSupportSaveToAlbum", "getDriveListFileType", "getEnterpriseSettings", "()Lcom/larus/platform/model/EnterpriseConfig;", "getFilePickerAllowedTypes", "getFileUploadUiStyle", "getEnableListMultiSelect", "getGalleryTransitionOpt", "getUseNewList", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c2 {

    @SerializedName("ai_ask_support_postfix")
    private final List<String> aiAskSupportPostfix;

    @SerializedName("drive_list_file_type")
    private final List<Integer> driveListFileType;

    @SerializedName("enable_list_multi_select")
    private final boolean enableListMultiSelect;

    @SerializedName("enable_sending_video")
    private final boolean enableSendingVideo;

    @SerializedName("enterprise_settings")
    private final EnterpriseConfig enterpriseSettings;

    @SerializedName("file_can_not_support_preview")
    private final List<String> fileCanNotSupportPreview;

    @SerializedName("file_list_page_length")
    private final int fileListPageLength;

    @SerializedName("file_name_max_length")
    private final int fileNameMaxLength;

    @SerializedName("file_picker_allowed_types")
    private final List<String> filePickerAllowedTypes;

    @SerializedName("file_upload_ui_style")
    private final int fileUploadUiStyle;

    @SerializedName("gallery_transition_opt")
    private final boolean galleryTransitionOpt;

    @SerializedName("media_support_save_to_album")
    private final List<String> mediaSupportSaveToAlbum;

    @SerializedName("pic_send_max_size")
    private final long picSendMaxSize;

    @SerializedName("show_chat_bottom_drive")
    private final boolean showChatBottomDrive;

    @SerializedName("show_setting_page_drive")
    private final boolean showSettingPageDrive;

    @SerializedName("upload_list_size")
    private final int uploadListSize;

    @SerializedName("use_new_list")
    private final boolean useNewList;

    public c2() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c2) == true) goto L8;
        return false;
    L8:
        c2 r101 = (c2) r100;
        if (Intrinsics.areEqual(this.aiAskSupportPostfix, r101.aiAskSupportPostfix) == true) goto L12;
        return false;
    L12:
        if (this.showChatBottomDrive == r101.showChatBottomDrive) goto L15;
        return false;
    L15:
        if (this.enableSendingVideo == r101.enableSendingVideo) goto L18;
        return false;
    L18:
        if (this.showSettingPageDrive == r101.showSettingPageDrive) goto L21;
        return false;
    L21:
        if (this.uploadListSize == r101.uploadListSize) goto L24;
        return false;
    L24:
        if (this.fileNameMaxLength == r101.fileNameMaxLength) goto L27;
        return false;
    L27:
        if (this.picSendMaxSize == r101.picSendMaxSize) goto L30;
        return false;
    L30:
        if (this.fileListPageLength == r101.fileListPageLength) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.fileCanNotSupportPreview, r101.fileCanNotSupportPreview) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.mediaSupportSaveToAlbum, r101.mediaSupportSaveToAlbum) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.driveListFileType, r101.driveListFileType) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.enterpriseSettings, r101.enterpriseSettings) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.filePickerAllowedTypes, r101.filePickerAllowedTypes) == true) goto L48;
        return false;
    L48:
        if (this.fileUploadUiStyle == r101.fileUploadUiStyle) goto L51;
        return false;
    L51:
        if (this.enableListMultiSelect == r101.enableListMultiSelect) goto L54;
        return false;
    L54:
        if (this.galleryTransitionOpt == r101.galleryTransitionOpt) goto L57;
        return false;
    L57:
        if (this.useNewList == r101.useNewList) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.aiAskSupportPostfix;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        int r104 = 1231;
        if (this.showChatBottomDrive == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.enableSendingVideo == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.showSettingPageDrive == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (((((r108 + r109) * 31) + this.uploadListSize) * 31) + this.fileNameMaxLength) * 31;
        long r111 = this.picSendMaxSize;
        int r112 = (((r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31) + this.fileListPageLength) * 31;
        List<String> r113 = this.fileCanNotSupportPreview;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.mediaSupportSaveToAlbum;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        List<Integer> r119 = this.driveListFileType;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        EnterpriseConfig r122 = this.enterpriseSettings;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        List<String> r125 = this.filePickerAllowedTypes;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        int r126 = (((r124 + r101) * 31) + this.fileUploadUiStyle) * 31;
        if (this.enableListMultiSelect == false) goto L41;
        int r127 = 1231;
    L42:
        int r128 = (r126 + r127) * 31;
        if (this.galleryTransitionOpt == false) goto L45;
        int r129 = 1231;
    L46:
        int r130 = (r128 + r129) * 31;
        if (this.useNewList == true) goto L51;
        r104 = 1237;
    L51:
        return r130 + r104;
    L45:
        r129 = 1237;
        goto L46
    L41:
        r127 = 1237;
        goto L42
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LarkDriveConfig(aiAskSupportPostfix=" + this.aiAskSupportPostfix + ", showChatBottomDrive=" + this.showChatBottomDrive + ", enableSendingVideo=" + this.enableSendingVideo + ", showSettingPageDrive=" + this.showSettingPageDrive + ", uploadListSize=" + this.uploadListSize + ", fileNameMaxLength=" + this.fileNameMaxLength + ", picSendMaxSize=" + this.picSendMaxSize + ", fileListPageLength=" + this.fileListPageLength + ", fileCanNotSupportPreview=" + this.fileCanNotSupportPreview + ", mediaSupportSaveToAlbum=" + this.mediaSupportSaveToAlbum + ", driveListFileType=" + this.driveListFileType + ", enterpriseSettings=" + this.enterpriseSettings + ", filePickerAllowedTypes=" + this.filePickerAllowedTypes + ", fileUploadUiStyle=" + this.fileUploadUiStyle + ", enableListMultiSelect=" + this.enableListMultiSelect + ", galleryTransitionOpt=" + this.galleryTransitionOpt + ", useNewList=" + this.useNewList + ')';
    }

    public final boolean a() {
        return this.enableListMultiSelect;
    }

    public final List<String> b() {
        return this.fileCanNotSupportPreview;
    }

    public final int c() {
        return this.fileListPageLength;
    }

    public final int d() {
        return this.fileNameMaxLength;
    }

    public final int e() {
        return this.fileUploadUiStyle;
    }

    public final boolean f() {
        return this.galleryTransitionOpt;
    }

    public final List<String> g() {
        return this.mediaSupportSaveToAlbum;
    }

    public final long h() {
        return this.picSendMaxSize;
    }

    public final boolean i() {
        return this.showSettingPageDrive;
    }

    public final int j() {
        return this.uploadListSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c2(Object r210) {
        List<String> r100 = CollectionsKt.listOf(new String[]{".pdf", ".docx", ".doc", ".xls", ".xlsx", ".csv", ".ppt", ".pptx", ".pps", ".dot", RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT, ".jpg", ".jpeg", Global.SUFFIX_TXT_FILE, ".md", ".log"});
        List<String> r101 = CollectionsKt.listOf(new String[]{".svg", ".ai", ".eps", ".psd", ".psb", ".arw", ".ar3", ".cr2", ".cr3", ".ar2", ".ts", ".ogg", ".webm", ".tif", ".tiff"});
        List<String> r102 = CollectionsKt.listOf(new String[]{".jpg", ".jpeg", RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT, ".heic", ".heif", EffectConstants.GIF_FILE_SUFFIX, ".bmp", ".tif", ".tiff", ".ico", ".dng", ".mp4", ".m4v", ".mp4v", ".mpg4", ".mov"});
        List<Integer> r103 = CollectionsKt.listOf(new Integer[]{0, 12, 22, 30, 3});
        EnterpriseConfig r104 = new EnterpriseConfig(null, 1, null == true ? 1 : 0);
        List<String> r105 = CollectionsKt.listOf(new String[]{"file", "doc", DocumentType.SHEET_NAME, "slides"});
        this.aiAskSupportPostfix = r100;
        this.showChatBottomDrive = true;
        this.enableSendingVideo = false;
        this.showSettingPageDrive = true;
        this.uploadListSize = 99;
        this.fileNameMaxLength = 256;
        this.picSendMaxSize = 52428800;
        this.fileListPageLength = 20;
        this.fileCanNotSupportPreview = r101;
        this.mediaSupportSaveToAlbum = r102;
        this.driveListFileType = r103;
        this.enterpriseSettings = r104;
        this.filePickerAllowedTypes = r105;
        this.fileUploadUiStyle = 0;
        this.enableListMultiSelect = false;
        this.galleryTransitionOpt = true;
        this.useNewList = true;
    }
}
