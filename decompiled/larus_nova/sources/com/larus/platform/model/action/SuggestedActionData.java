package com.larus.platform.model.action;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BÇ\u0002\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\u0010(\u001a\u0004\u0018\u00010)J\u0013\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010,\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010-\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00101\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00102\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00103\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00105\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00106\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00107\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00108\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003JÉ\u0002\u0010:\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020?HÖ\u0001J\t\u0010@\u001a\u00020AHÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R \u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R \u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R \u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R \u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R \u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R \u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R \u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017¨\u0006B"}, d2 = {"Lcom/larus/platform/model/action/SuggestedActionData;", "", "aiPPTSingleImage", "", "Lcom/larus/platform/model/action/SuggestedAction;", "attachmentAreaMultiFile", "attachmentAreaMultiImg", "attachmentAreaSingleFile", "attachmentAreaSingleImg", "previewArea", "homeworkCorrectionCamera", "eduAlbum", "eduSolveQuestionCamera", "referenceAction", "docAiEditAction", "ecomPageAttachmentAreaMultiImage", "ecomPageAttachmentAreaSingleImage", "attachmentAreaAudio", "attachmentAreaAudioFile", "attachmentAreaAudioSheet", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAiPPTSingleImage", "()Ljava/util/List;", "getAttachmentAreaMultiFile", "getAttachmentAreaMultiImg", "getAttachmentAreaSingleFile", "getAttachmentAreaSingleImg", "getPreviewArea", "getHomeworkCorrectionCamera", "getEduAlbum", "getEduSolveQuestionCamera", "getReferenceAction", "getDocAiEditAction", "getEcomPageAttachmentAreaMultiImage", "getEcomPageAttachmentAreaSingleImage", "getAttachmentAreaAudio", "getAttachmentAreaAudioFile", "getAttachmentAreaAudioSheet", MonitorConstants.CONNECT_TYPE_GET, "scene", "Lcom/larus/platform/model/action/SuggestedActionScene;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SuggestedActionData {

    @SerializedName("ai_ppt_single_img")
    private final List<SuggestedAction> aiPPTSingleImage;

    @SerializedName("attachment_area_audio")
    private final List<SuggestedAction> attachmentAreaAudio;

    @SerializedName("attachment_area_audio_file")
    private final List<SuggestedAction> attachmentAreaAudioFile;

    @SerializedName("attachment_area_audio_sheet")
    private final List<SuggestedAction> attachmentAreaAudioSheet;

    @SerializedName("attachment_area_multi_file")
    private final List<SuggestedAction> attachmentAreaMultiFile;

    @SerializedName("attachment_area_multi_img")
    private final List<SuggestedAction> attachmentAreaMultiImg;

    @SerializedName("attachment_area_single_file")
    private final List<SuggestedAction> attachmentAreaSingleFile;

    @SerializedName("attachment_area_single_img")
    private final List<SuggestedAction> attachmentAreaSingleImg;

    @SerializedName("doc_ai_edit")
    private final List<SuggestedAction> docAiEditAction;

    @SerializedName("ecom_page_attachment_area_multi_image")
    private final List<SuggestedAction> ecomPageAttachmentAreaMultiImage;

    @SerializedName("ecom_page_attachment_area_single_image")
    private final List<SuggestedAction> ecomPageAttachmentAreaSingleImage;

    @SerializedName("edu_album")
    private final List<SuggestedAction> eduAlbum;

    @SerializedName("edu_solve_question_camera")
    private final List<SuggestedAction> eduSolveQuestionCamera;

    @SerializedName("homework_correction_camera")
    private final List<SuggestedAction> homeworkCorrectionCamera;

    @SerializedName("preview_area")
    private final List<SuggestedAction> previewArea;

    @SerializedName("reference_action")
    private final List<SuggestedAction> referenceAction;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f365500a = null;

        static {
            int[] r100 = new int[SuggestedActionScene.values().length];
            r100[SuggestedActionScene.AttachmentAreaSingleImg.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L55:
            r100[SuggestedActionScene.AttachmentAreaSingleFile.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L67:
            r100[SuggestedActionScene.AttachmentAreaMultiImg.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L41:
            r100[SuggestedActionScene.AttachmentAreaMultiFile.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L43:
            r100[SuggestedActionScene.AttachmentAreaAudio.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L51:
            r100[SuggestedActionScene.AttachmentAreaAudioFile.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L61:
            r100[SuggestedActionScene.AttachmentAreaAudioSheet.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L47:
            r100[SuggestedActionScene.PreviewArea.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L57:
            r100[SuggestedActionScene.ReferenceAction.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L59:
            r100[SuggestedActionScene.DocAiEditReferenceAction.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L39:
            r100[SuggestedActionScene.HomeworkCorrectionCamera.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L53:
            r100[SuggestedActionScene.PPTGenerationSingleImg.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L65:
            r100[SuggestedActionScene.EcomPageAttachmentAreaSingleImage.ordinal()] = 13;     // Catch: NoSuchFieldError -> L33
        L37:
            r100[SuggestedActionScene.EcomPageAttachmentAreaMultiImage.ordinal()] = 14;     // Catch: NoSuchFieldError -> L34
        L45:
            r100[SuggestedActionScene.EduAlbum.ordinal()] = 15;     // Catch: NoSuchFieldError -> L35
        L63:
            r100[SuggestedActionScene.EduSolveQuestionCamera.ordinal()] = 16;     // Catch: NoSuchFieldError -> L36
        L19:
            f365500a = r100;
        }
    }

    public SuggestedActionData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SuggestedActionData copy$default(SuggestedActionData r110, List r111, List r112, List r210, List r211, List r212, List r213, List r214, List r215, List r216, List r217, List r218, List r219, List r310, List r311, List r312, List r313, int r314, Object r315) {
        if ((r314 & 1) == 0) goto L5;
        List r100 = r110.aiPPTSingleImage;
    L7:
        if ((r314 & 2) == 0) goto L9;
        List r101 = r110.attachmentAreaMultiFile;
    L11:
        if ((r314 & 4) == 0) goto L13;
        List r102 = r110.attachmentAreaMultiImg;
    L15:
        if ((r314 & 8) == 0) goto L17;
        List r103 = r110.attachmentAreaSingleFile;
    L19:
        if ((r314 & 16) == 0) goto L21;
        List r104 = r110.attachmentAreaSingleImg;
    L23:
        if ((r314 & 32) == 0) goto L25;
        List r105 = r110.previewArea;
    L27:
        if ((r314 & 64) == 0) goto L29;
        List r106 = r110.homeworkCorrectionCamera;
    L31:
        if ((r314 & 128) == 0) goto L33;
        List r107 = r110.eduAlbum;
    L35:
        if ((r314 & 256) == 0) goto L37;
        List r113 = r110.eduSolveQuestionCamera;
    L39:
        if ((r314 & 512) == 0) goto L41;
        List r114 = r110.referenceAction;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        List r115 = r110.docAiEditAction;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        List r116 = r110.ecomPageAttachmentAreaMultiImage;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        List r117 = r110.ecomPageAttachmentAreaSingleImage;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        List r118 = r110.attachmentAreaAudio;
    L58:
        List r316 = r118;
        if ((r314 & 16384) == 0) goto L61;
        List r119 = r110.attachmentAreaAudioFile;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        List r108 = r110.attachmentAreaAudioSheet;
    L67:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r316, r119, r108);
    L65:
        r108 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L63
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final List<SuggestedAction> component1() {
        return this.aiPPTSingleImage;
    }

    public final List<SuggestedAction> component10() {
        return this.referenceAction;
    }

    public final List<SuggestedAction> component11() {
        return this.docAiEditAction;
    }

    public final List<SuggestedAction> component12() {
        return this.ecomPageAttachmentAreaMultiImage;
    }

    public final List<SuggestedAction> component13() {
        return this.ecomPageAttachmentAreaSingleImage;
    }

    public final List<SuggestedAction> component14() {
        return this.attachmentAreaAudio;
    }

    public final List<SuggestedAction> component15() {
        return this.attachmentAreaAudioFile;
    }

    public final List<SuggestedAction> component16() {
        return this.attachmentAreaAudioSheet;
    }

    public final List<SuggestedAction> component2() {
        return this.attachmentAreaMultiFile;
    }

    public final List<SuggestedAction> component3() {
        return this.attachmentAreaMultiImg;
    }

    public final List<SuggestedAction> component4() {
        return this.attachmentAreaSingleFile;
    }

    public final List<SuggestedAction> component5() {
        return this.attachmentAreaSingleImg;
    }

    public final List<SuggestedAction> component6() {
        return this.previewArea;
    }

    public final List<SuggestedAction> component7() {
        return this.homeworkCorrectionCamera;
    }

    public final List<SuggestedAction> component8() {
        return this.eduAlbum;
    }

    public final List<SuggestedAction> component9() {
        return this.eduSolveQuestionCamera;
    }

    public final SuggestedActionData copy(List<SuggestedAction> r110, List<SuggestedAction> r210, List<SuggestedAction> r211, List<SuggestedAction> r212, List<SuggestedAction> r213, List<SuggestedAction> r214, List<SuggestedAction> r215, List<SuggestedAction> r216, List<SuggestedAction> r217, List<SuggestedAction> r218, List<SuggestedAction> r219, List<SuggestedAction> r310, List<SuggestedAction> r311, List<SuggestedAction> r312, List<SuggestedAction> r313, List<SuggestedAction> r314) {
        return new SuggestedActionData(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SuggestedActionData) == true) goto L8;
        return false;
    L8:
        SuggestedActionData r101 = (SuggestedActionData) r100;
        if (Intrinsics.areEqual(this.aiPPTSingleImage, r101.aiPPTSingleImage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.attachmentAreaMultiFile, r101.attachmentAreaMultiFile) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.attachmentAreaMultiImg, r101.attachmentAreaMultiImg) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.attachmentAreaSingleFile, r101.attachmentAreaSingleFile) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.attachmentAreaSingleImg, r101.attachmentAreaSingleImg) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.previewArea, r101.previewArea) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.homeworkCorrectionCamera, r101.homeworkCorrectionCamera) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.eduAlbum, r101.eduAlbum) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.eduSolveQuestionCamera, r101.eduSolveQuestionCamera) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.referenceAction, r101.referenceAction) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.docAiEditAction, r101.docAiEditAction) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.ecomPageAttachmentAreaMultiImage, r101.ecomPageAttachmentAreaMultiImage) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.ecomPageAttachmentAreaSingleImage, r101.ecomPageAttachmentAreaSingleImage) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.attachmentAreaAudio, r101.attachmentAreaAudio) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.attachmentAreaAudioFile, r101.attachmentAreaAudioFile) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.attachmentAreaAudioSheet, r101.attachmentAreaAudioSheet) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public int hashCode() {
        List<SuggestedAction> r100 = this.aiPPTSingleImage;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<SuggestedAction> r104 = this.attachmentAreaMultiFile;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<SuggestedAction> r107 = this.attachmentAreaMultiImg;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<SuggestedAction> r110 = this.attachmentAreaSingleFile;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<SuggestedAction> r113 = this.attachmentAreaSingleImg;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<SuggestedAction> r116 = this.previewArea;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        List<SuggestedAction> r119 = this.homeworkCorrectionCamera;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        List<SuggestedAction> r122 = this.eduAlbum;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        List<SuggestedAction> r125 = this.eduSolveQuestionCamera;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        List<SuggestedAction> r128 = this.referenceAction;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        List<SuggestedAction> r131 = this.docAiEditAction;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        List<SuggestedAction> r134 = this.ecomPageAttachmentAreaMultiImage;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        List<SuggestedAction> r137 = this.ecomPageAttachmentAreaSingleImage;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        List<SuggestedAction> r140 = this.attachmentAreaAudio;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        List<SuggestedAction> r143 = this.attachmentAreaAudioFile;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        List<SuggestedAction> r146 = this.attachmentAreaAudioSheet;
        if (r146 == null) goto L67;
        r101 = r146.hashCode();
    L67:
        return r145 + r101;
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
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
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "SuggestedActionData(aiPPTSingleImage=" + this.aiPPTSingleImage + ", attachmentAreaMultiFile=" + this.attachmentAreaMultiFile + ", attachmentAreaMultiImg=" + this.attachmentAreaMultiImg + ", attachmentAreaSingleFile=" + this.attachmentAreaSingleFile + ", attachmentAreaSingleImg=" + this.attachmentAreaSingleImg + ", previewArea=" + this.previewArea + ", homeworkCorrectionCamera=" + this.homeworkCorrectionCamera + ", eduAlbum=" + this.eduAlbum + ", eduSolveQuestionCamera=" + this.eduSolveQuestionCamera + ", referenceAction=" + this.referenceAction + ", docAiEditAction=" + this.docAiEditAction + ", ecomPageAttachmentAreaMultiImage=" + this.ecomPageAttachmentAreaMultiImage + ", ecomPageAttachmentAreaSingleImage=" + this.ecomPageAttachmentAreaSingleImage + ", attachmentAreaAudio=" + this.attachmentAreaAudio + ", attachmentAreaAudioFile=" + this.attachmentAreaAudioFile + ", attachmentAreaAudioSheet=" + this.attachmentAreaAudioSheet + ')';
    }

    public final List<SuggestedAction> getAiPPTSingleImage() {
        return this.aiPPTSingleImage;
    }

    public final List<SuggestedAction> getAttachmentAreaAudio() {
        return this.attachmentAreaAudio;
    }

    public final List<SuggestedAction> getAttachmentAreaAudioFile() {
        return this.attachmentAreaAudioFile;
    }

    public final List<SuggestedAction> getAttachmentAreaAudioSheet() {
        return this.attachmentAreaAudioSheet;
    }

    public final List<SuggestedAction> getAttachmentAreaMultiFile() {
        return this.attachmentAreaMultiFile;
    }

    public final List<SuggestedAction> getAttachmentAreaMultiImg() {
        return this.attachmentAreaMultiImg;
    }

    public final List<SuggestedAction> getAttachmentAreaSingleFile() {
        return this.attachmentAreaSingleFile;
    }

    public final List<SuggestedAction> getAttachmentAreaSingleImg() {
        return this.attachmentAreaSingleImg;
    }

    public final List<SuggestedAction> getDocAiEditAction() {
        return this.docAiEditAction;
    }

    public final List<SuggestedAction> getEcomPageAttachmentAreaMultiImage() {
        return this.ecomPageAttachmentAreaMultiImage;
    }

    public final List<SuggestedAction> getEcomPageAttachmentAreaSingleImage() {
        return this.ecomPageAttachmentAreaSingleImage;
    }

    public final List<SuggestedAction> getEduAlbum() {
        return this.eduAlbum;
    }

    public final List<SuggestedAction> getEduSolveQuestionCamera() {
        return this.eduSolveQuestionCamera;
    }

    public final List<SuggestedAction> getHomeworkCorrectionCamera() {
        return this.homeworkCorrectionCamera;
    }

    public final List<SuggestedAction> getPreviewArea() {
        return this.previewArea;
    }

    public final List<SuggestedAction> getReferenceAction() {
        return this.referenceAction;
    }

    public final List<SuggestedAction> get(SuggestedActionScene r100) {
        if (r100 != null) goto L4;
        int r101 = -1;
    L5:
        switch(r101) {
            case 1: goto L23;
            case 2: goto L39;
            case 3: goto L38;
            case 4: goto L37;
            case 5: goto L36;
            case 6: goto L35;
            case 7: goto L34;
            case 8: goto L33;
            case 9: goto L32;
            case 10: goto L31;
            case 11: goto L30;
            case 12: goto L29;
            case 13: goto L28;
            case 14: goto L27;
            case 15: goto L26;
            case 16: goto L25;
            default: goto L6;
        };
    L6:
        return null;
    L25:
        return this.eduSolveQuestionCamera;
    L26:
        return this.eduAlbum;
    L27:
        return this.ecomPageAttachmentAreaMultiImage;
    L28:
        return this.ecomPageAttachmentAreaSingleImage;
    L29:
        return this.aiPPTSingleImage;
    L30:
        return this.homeworkCorrectionCamera;
    L31:
        return this.docAiEditAction;
    L32:
        return this.referenceAction;
    L33:
        return this.previewArea;
    L34:
        return this.attachmentAreaAudioSheet;
    L35:
        return this.attachmentAreaAudioFile;
    L36:
        return this.attachmentAreaAudio;
    L37:
        return this.attachmentAreaMultiFile;
    L38:
        return this.attachmentAreaMultiImg;
    L39:
        return this.attachmentAreaSingleFile;
    L23:
        return this.attachmentAreaSingleImg;
    L4:
        r101 = a.f365500a[r100.ordinal()];
        goto L5
    }

    public SuggestedActionData(List<SuggestedAction> r100, List<SuggestedAction> r101, List<SuggestedAction> r102, List<SuggestedAction> r103, List<SuggestedAction> r104, List<SuggestedAction> r105, List<SuggestedAction> r106, List<SuggestedAction> r110, List<SuggestedAction> r111, List<SuggestedAction> r112, List<SuggestedAction> r113, List<SuggestedAction> r114, List<SuggestedAction> r115, List<SuggestedAction> r116, List<SuggestedAction> r117, List<SuggestedAction> r118) {
        this.aiPPTSingleImage = r100;
        this.attachmentAreaMultiFile = r101;
        this.attachmentAreaMultiImg = r102;
        this.attachmentAreaSingleFile = r103;
        this.attachmentAreaSingleImg = r104;
        this.previewArea = r105;
        this.homeworkCorrectionCamera = r106;
        this.eduAlbum = r110;
        this.eduSolveQuestionCamera = r111;
        this.referenceAction = r112;
        this.docAiEditAction = r113;
        this.ecomPageAttachmentAreaMultiImage = r114;
        this.ecomPageAttachmentAreaSingleImage = r115;
        this.attachmentAreaAudio = r116;
        this.attachmentAreaAudioFile = r117;
        this.attachmentAreaAudioSheet = r118;
    }

    public /* synthetic */ SuggestedActionData(List r110, List r111, List r210, List r211, List r212, List r213, List r214, List r215, List r216, List r217, List r218, List r219, List r310, List r311, List r312, List r313, int r314, DefaultConstructorMarker r315) {
        if ((r314 & 1) == 0) goto L5;
        List r100 = null;
    L7:
        if ((r314 & 2) == 0) goto L9;
        List r101 = null;
    L11:
        if ((r314 & 4) == 0) goto L13;
        List r102 = null;
    L15:
        if ((r314 & 8) == 0) goto L17;
        List r103 = null;
    L19:
        if ((r314 & 16) == 0) goto L21;
        List r104 = null;
    L23:
        if ((r314 & 32) == 0) goto L25;
        List r105 = null;
    L27:
        if ((r314 & 64) == 0) goto L29;
        List r106 = null;
    L31:
        if ((r314 & 128) == 0) goto L33;
        List r107 = null;
    L35:
        if ((r314 & 256) == 0) goto L37;
        List r112 = null;
    L39:
        if ((r314 & 512) == 0) goto L41;
        List r113 = null;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        List r114 = null;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        List r115 = null;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        List r116 = null;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        List r117 = null;
    L59:
        if ((r314 & 16384) == 0) goto L61;
        List r108 = null;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        List r109 = null;
    L66:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r112, r113, r114, r115, r116, r117, r108, r109);
        return;
    L65:
        r109 = r313;
        goto L66
    L61:
        r108 = r312;
        goto L63
    L57:
        r117 = r311;
        goto L59
    L53:
        r116 = r310;
        goto L55
    L49:
        r115 = r219;
        goto L51
    L45:
        r114 = r218;
        goto L47
    L41:
        r113 = r217;
        goto L43
    L37:
        r112 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
