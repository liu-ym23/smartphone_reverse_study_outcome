package com.ss.android.ugc.aweme.editSticker.model;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.entity.app.ExtraEntity;
import com.ss.android.ugc.aweme.creative.CreativePath;
import com.ss.android.ugc.aweme.creative.CreativeSuppressCheck;
import com.ss.android.ugc.aweme.creative.PublicPath;
import com.ss.android.ugc.aweme.draft.DraftTransMark;
import com.ss.texturerender.TextureRenderKeys;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class StickerItemModel implements Parcelable, Serializable, Cloneable {
    public static final Parcelable.Creator<StickerItemModel> CREATOR = null;
    public static final String EXTRA_MAGNIFIER = "MagnifierSticker";
    public static final String EXTRA_SUBTITLE = "subtitle";
    public static final String EXTRA_SUBTITLE_RULE = "subtitle_rule";
    public static final int TYPE_ANIM_TIMESTAMP = 14;
    public static final int TYPE_CANVAS_EMBEDDED_STICKER = 1000;
    public static final int TYPE_CONVERSATION_STICKER = 28;
    public static final int TYPE_DAILY = 12;
    public static final int TYPE_IMAGE = 11;
    public static final int TYPE_INTERACT_COMMENT = 4;
    public static final int TYPE_INTERACT_COMMENT_STICKER_NEW = 22;
    public static final int TYPE_INTERACT_DONATION = 7;
    public static final int TYPE_INTERACT_GROOT = 18;
    public static final int TYPE_INTERACT_HASHTAG = 9;
    public static final int TYPE_INTERACT_LOCATION = 24;
    public static final int TYPE_INTERACT_MENTION = 8;
    public static final int TYPE_INTERACT_NATURE = 26;
    public static final int TYPE_INTERACT_QA = 19;
    public static final int TYPE_INTERACT_VIDEO_REPLY = 21;
    public static final int TYPE_INTEREST = 1;
    public static final int TYPE_KTV_AUTHOR = 15;
    public static final int TYPE_KTV_LYRIC = 17;
    public static final int TYPE_KTV_TITLE = 16;
    public static final int TYPE_LOCAL_HASH_TAG = 13;
    public static final int TYPE_LYRIC = 3;
    public static final int TYPE_MUSIC_SHARE_TO_STORY = 27;
    public static final int TYPE_NATIVE_INTEREST = -1;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_NOW_SMALL_WINDOW = 25;
    public static final int TYPE_PAINT = 6;
    public static final int TYPE_SEARCH_EFFECT = 10;
    public static final int TYPE_SUBTITLE = 5;
    public static final int TYPE_TEXT = 2;
    public static final int TYPE_TEXT_IMAGE = 20;
    public static final int TYPE_TEXT_TEMPLATE = 23;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient boolean f450801a;

    @SerializedName("is_editorpro_adjust_text_color")
    public String adjustTextColorInEditorPro;

    @SerializedName("is_editorpro_adjust_text_font")
    public String adjustTextFontInEditorPro;

    @SerializedName("is_editorpro_adjust_text_paragraph")
    public String adjustTextParagraph;

    @SerializedName("is_editorpro_adjust_text_position")
    public String adjustTextPositionInEditorPro;

    @SerializedName("is_editorpro_adjust_text_style")
    public String adjustTextStyleInEditorPro;

    @SerializedName("challenge_id_loki")
    public String challengeIdLoki;

    @SerializedName("current_offsetX")
    public float currentOffsetX;

    @SerializedName("current_offsetY")
    public float currentOffsetY;

    @SerializedName("cutout")
    public boolean cutout;

    @SerializedName("deletable")
    public boolean deletable;

    @CreativeSuppressCheck
    private DrawRect drawRect;

    @SerializedName("editorpro_tts_tone_id")
    public String editorProTTSID;

    @SerializedName("enable_pan")
    public boolean enablePan;

    @SerializedName("enable_rotate")
    public boolean enableRotate;

    @SerializedName("enable_scale")
    public boolean enableScale;

    @SerializedName("end_time")
    public int endTime;

    @SerializedName("extra")
    public String extra;

    @SerializedName(ExtraEntity.KEY_EXTRA_2)
    public String extra2;

    @SerializedName(ExtraEntity.KEY_EXTRA_3)
    public String extra3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SerializedName("h")
    public float f450802h;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @CreativeSuppressCheck
    private int f450803id;

    @SerializedName("in_duration")
    public int inDuration;

    @SerializedName("in_path")
    @DraftTransMark
    public String inPath;

    @SerializedName("in_sticker_id")
    public String inStickerId;

    @SerializedName("init_height")
    public float initHeight;

    @SerializedName("init_width")
    public float initWidth;

    @SerializedName("is_add_veeditor_success")
    public boolean isAddVEEditorSuccess;

    @SerializedName("isAnimate")
    public boolean isAnimate;

    @SerializedName("is_animation_loop")
    public boolean isAnimationLoop;

    @SerializedName("is_dynamic")
    public boolean isDynamicSticker;

    @SerializedName("is_editorpro_caption")
    public String isEditorProCaption;

    @SerializedName("is_editorpro_copy_text")
    public String isEditorProCopyText;

    @SerializedName("is_editorpro_tts")
    public String isEditorProTTS;

    @SerializedName("is_editorpro_text")
    public String isEditorProText;

    @SerializedName("is_editorpro_trim_text_length")
    public String isEditorProTrimLength;

    @SerializedName("is_enable_interaction")
    public boolean isEnableInteraction;

    @CreativeSuppressCheck
    public boolean isImageStickerLayer;

    @SerializedName("is_pin")
    public boolean isPin;

    @SerializedName("layer_weight")
    public int layerWeight;
    public transient String lyricSrtPath;

    @SerializedName("lyric_color")
    public int mLyricColor;

    @SerializedName("lyric_fontId")
    public String mLyricFontId;

    @SerializedName("lyric_fontPath")
    public String mLyricFontPath;

    @SerializedName("lyric_in_point")
    public int mLyricInPoint;

    @SerializedName("lyric_info")
    public String mLyricInfo;

    @SerializedName("lyric_music_loop")
    public boolean mLyricMusicLoop;

    @SerializedName("lyric_out_point")
    public int mLyricOutPoint;

    @SerializedName("lyric_start_time")
    public int mLyricStartTime;

    @SerializedName(TextureRenderKeys.KEY_IS_VR_MAX_SCALE)
    public float maxScale;

    @SerializedName(TextureRenderKeys.KEY_IS_VR_MIN_SCALE)
    public float minScale;

    @SerializedName("normalized_height")
    public float normalizedHeight;

    @SerializedName("normalized_width")
    public float normalizedWidth;

    @CreativeSuppressCheck
    private int originalEndTime;

    @CreativeSuppressCheck
    private int originalStartTime;

    @SerializedName("out_duration")
    public int outDuration;

    @SerializedName("out_path")
    @DraftTransMark
    public String outPath;

    @SerializedName("path")
    @CreativePath
    @DraftTransMark
    @PublicPath
    public String path;

    @SerializedName("pin_algorithm_file")
    @CreativePath
    public String pinAlgorithmFile;

    @SerializedName("provider_effect")
    public String providerEffect;

    @SerializedName(MapBundleKey.OfflineMapKey.OFFLINE_RATION)
    public float ratio;

    @SerializedName("angle")
    public float rotateAngle;

    @SerializedName("scale")
    public float scale;

    @SerializedName(ILoadStallMonitor.START_TIME)
    public int startTime;

    @SerializedName("stickerDrawScale")
    public float stickerDrawScale;

    @SerializedName("sticker_id")
    public String stickerId;

    @SerializedName("mob_params")
    public StickerMobParams stickerMobParams;

    @SerializedName("tab_id")
    public String tabId;

    @CreativeSuppressCheck
    public int type;

    @SerializedName("ui_end_time")
    public int uiEndTime;

    @SerializedName("ui_start_time")
    public int uiStartTime;

    @SerializedName(ST.UUID_DEVICE)
    public String uuid;
    public transient int viewHash;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @SerializedName("w")
    public float f450804w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    public float f450805x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    public float f450806y;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public StickerItemModel dumpClonedData() {
        StickerItemModel r100 = new StickerItemModel(this.stickerId, this.path, this.extra, this.layerWeight, this.isAnimate, this.startTime, this.endTime, this.type);
        r100.f450803id = this.f450803id;
        r100.scale = this.scale;
        r100.maxScale = this.maxScale;
        r100.minScale = this.minScale;
        r100.rotateAngle = this.rotateAngle;
        r100.initHeight = this.initHeight;
        r100.initWidth = this.initWidth;
        r100.currentOffsetX = this.currentOffsetX;
        r100.currentOffsetY = this.currentOffsetY;
        r100.isAnimate = this.isAnimate;
        r100.isImageStickerLayer = this.isImageStickerLayer;
        r100.pinAlgorithmFile = this.pinAlgorithmFile;
        r100.isPin = this.isPin;
        r100.f450805x = this.f450805x;
        r100.f450806y = this.f450806y;
        r100.f450804w = this.f450804w;
        r100.f450802h = this.f450802h;
        r100.isAnimationLoop = this.isAnimationLoop;
        r100.inStickerId = this.inStickerId;
        r100.inPath = this.inPath;
        r100.inDuration = this.inDuration;
        r100.outPath = this.outPath;
        r100.outDuration = this.outDuration;
        r100.ratio = this.ratio;
        r100.stickerMobParams = this.stickerMobParams;
        r100.adjustTextStyleInEditorPro = this.adjustTextStyleInEditorPro;
        r100.adjustTextParagraph = this.adjustTextParagraph;
        r100.adjustTextFontInEditorPro = this.adjustTextFontInEditorPro;
        r100.adjustTextColorInEditorPro = this.adjustTextColorInEditorPro;
        r100.adjustTextPositionInEditorPro = this.adjustTextPositionInEditorPro;
        r100.isEditorProTrimLength = this.isEditorProTrimLength;
        r100.isEditorProText = this.isEditorProText;
        r100.isEditorProCopyText = this.isEditorProCopyText;
        r100.isEditorProTTS = this.isEditorProTTS;
        r100.editorProTTSID = this.editorProTTSID;
        r100.isEditorProCaption = this.isEditorProCaption;
        r100.isDynamicSticker = this.isDynamicSticker;
        r100.drawRect = this.drawRect;
        r100.providerEffect = this.providerEffect;
        return r100;
    }

    public RectF getDrawRect() {
        DrawRect r100 = this.drawRect;
        if (r100 != null) goto L6;
        return null;
    L6:
        DrawRect.Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "$this$toRectF");
        return new RectF(r100.getLeft(), r100.getTop(), r100.getRight(), r100.getBottom());
    }

    public boolean isAnimTimestampSticker() {
        if (this.type != 14) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isImageSticker() {
        int r100 = this.type;
        if (r100 != 11) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 25) goto L8;
        return false;
    }

    public boolean isLocalHashTagSticker() {
        if (this.type != 13) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLyric() {
        int r100 = this.type;
        if (r100 != 3) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 17) goto L8;
        return false;
    }

    public boolean isMagnifier() {
        return EXTRA_MAGNIFIER.equals(this.extra);
    }

    public boolean isMusicShareToStorySticker() {
        if (this.type != 27) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNormalInfoSticker() {
        if (this.type != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNormalTextSticker() {
        if (this.type != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNowSmallWindowSticker() {
        if (this.type != 25) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isTextSticker() {
        int r100 = this.type;
        if (r100 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 20) goto L8;
        return false;
    }

    public boolean isTextTemplateSticker() {
        if (this.type != 23) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "StickerItemModel{id=" + getId() + ", stickerId='" + this.stickerId + "', path='" + this.path + "', extra='" + this.extra + "', scale=" + this.scale + ", rotateAngle=" + this.rotateAngle + ", layerWeight=" + this.layerWeight + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", initWidth=" + this.initWidth + ", initHeight=" + this.initHeight + ", currentOffsetX=" + this.currentOffsetX + ", currentOffsetY=" + this.currentOffsetY + ", normalizedWidth=" + this.normalizedWidth + ", normalizedHeight=" + this.normalizedHeight + '}';
    }

    public StickerItemModel() {
        this.scale = 1.0f;
        this.maxScale = 0.0f;
        this.minScale = 0.0f;
        this.stickerDrawScale = 1.0f;
        this.rotateAngle = 0.0f;
        this.currentOffsetX = 0.5f;
        this.currentOffsetY = 0.5f;
        this.mLyricColor = -1;
        this.mLyricInPoint = 0;
        this.mLyricStartTime = 0;
        this.mLyricOutPoint = 0;
        this.mLyricMusicLoop = true;
        this.challengeIdLoki = null;
        this.tabId = "";
        this.f450805x = 0.0f;
        this.f450806y = 0.0f;
        this.f450804w = 1.0f;
        this.f450802h = 1.0f;
        this.ratio = 1.0f;
        this.cutout = false;
        this.deletable = true;
        this.isEnableInteraction = true;
        this.normalizedWidth = -1.0f;
        this.normalizedHeight = -1.0f;
        this.isAddVEEditorSuccess = false;
        this.adjustTextStyleInEditorPro = "0";
        this.adjustTextParagraph = "0";
        this.adjustTextFontInEditorPro = "0";
        this.adjustTextColorInEditorPro = "0";
        this.adjustTextPositionInEditorPro = "0";
        this.isEditorProTrimLength = "0";
        this.isEditorProText = "0";
        this.isEditorProCopyText = "0";
        this.isEditorProTTS = "0";
        this.editorProTTSID = "";
        this.isEditorProCaption = "0";
        this.isDynamicSticker = false;
        this.providerEffect = "";
        this.enableRotate = true;
        this.enableScale = true;
        this.enablePan = true;
        this.drawRect = new DrawRect(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public StickerItemModel clone() {
        return (StickerItemModel) super.clone();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public int hashCode() {
        int r100 = getId() * 31;
        String r101 = this.stickerId;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.path;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.extra;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        return r107 + r102;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public boolean isSubtitle() {
        if ("subtitle".equals(this.extra) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.type == 5) goto L8;
        return false;
    }

    public boolean isSubtitleRule() {
        return EXTRA_SUBTITLE_RULE.equals(this.extra);
    }

    public int getId() {
        return this.f450803id;
    }

    public int getOriginalEndTime() {
        return this.originalEndTime;
    }

    public int getOriginalStartTime() {
        return this.originalStartTime;
    }

    public String getPinAlgorithmFile() {
        return this.pinAlgorithmFile;
    }

    public String getText() {
        return this.path;
    }

    public boolean isFromSearch() {
        return this.f450801a;
    }

    public boolean isPin() {
        return this.isPin;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8702clone() throws CloneNotSupportedException {
        return clone();
    }

    public StickerItemModel(Parcel r100) {
        this.scale = 1.0f;
        this.maxScale = 0.0f;
        this.minScale = 0.0f;
        this.stickerDrawScale = 1.0f;
        this.rotateAngle = 0.0f;
        this.currentOffsetX = 0.5f;
        this.currentOffsetY = 0.5f;
        this.mLyricColor = -1;
        boolean r101 = false;
        this.mLyricInPoint = 0;
        this.mLyricStartTime = 0;
        this.mLyricOutPoint = 0;
        this.mLyricMusicLoop = true;
        this.challengeIdLoki = null;
        this.tabId = "";
        this.f450805x = 0.0f;
        this.f450806y = 0.0f;
        this.f450804w = 1.0f;
        this.f450802h = 1.0f;
        this.ratio = 1.0f;
        this.cutout = false;
        this.deletable = true;
        this.isEnableInteraction = true;
        this.normalizedWidth = -1.0f;
        this.normalizedHeight = -1.0f;
        this.isAddVEEditorSuccess = false;
        this.adjustTextStyleInEditorPro = "0";
        this.adjustTextParagraph = "0";
        this.adjustTextFontInEditorPro = "0";
        this.adjustTextColorInEditorPro = "0";
        this.adjustTextPositionInEditorPro = "0";
        this.isEditorProTrimLength = "0";
        this.isEditorProText = "0";
        this.isEditorProCopyText = "0";
        this.isEditorProTTS = "0";
        this.editorProTTSID = "";
        this.isEditorProCaption = "0";
        this.isDynamicSticker = false;
        this.providerEffect = "";
        this.enableRotate = true;
        this.enableScale = true;
        this.enablePan = true;
        this.drawRect = new DrawRect(0.0f, 0.0f, 0.0f, 0.0f);
        this.stickerId = r100.readString();
        this.path = r100.readString();
        this.extra = r100.readString();
        this.extra2 = r100.readString();
        this.extra3 = r100.readString();
        this.scale = r100.readFloat();
        this.stickerDrawScale = r100.readFloat();
        this.rotateAngle = r100.readFloat();
        this.layerWeight = r100.readInt();
        this.startTime = r100.readInt();
        this.endTime = r100.readInt();
        this.uiStartTime = r100.readInt();
        this.uiEndTime = r100.readInt();
        this.initWidth = r100.readFloat();
        this.initHeight = r100.readFloat();
        this.currentOffsetX = r100.readFloat();
        this.currentOffsetY = r100.readFloat();
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.isAnimate = r102;
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.isImageStickerLayer = r103;
        this.type = r100.readInt();
        this.pinAlgorithmFile = r100.readString();
        if (r100.readByte() == 0) goto L13;
        boolean r104 = true;
    L14:
        this.isPin = r104;
        this.mLyricInfo = r100.readString();
        this.mLyricFontPath = r100.readString();
        this.mLyricFontId = r100.readString();
        this.mLyricColor = r100.readInt();
        this.mLyricInPoint = r100.readInt();
        this.mLyricStartTime = r100.readInt();
        this.mLyricOutPoint = r100.readInt();
        this.tabId = r100.readString();
        this.f450805x = r100.readFloat();
        this.f450806y = r100.readFloat();
        this.f450804w = r100.readFloat();
        this.f450802h = r100.readFloat();
        if (r100.readByte() == 0) goto L17;
        boolean r105 = true;
    L18:
        this.cutout = r105;
        if (r100.readByte() == 0) goto L21;
        boolean r106 = true;
    L22:
        this.deletable = r106;
        if (r100.readByte() == 0) goto L25;
        boolean r107 = true;
    L26:
        this.isEnableInteraction = r107;
        if (r100.readByte() == 0) goto L29;
        boolean r108 = true;
    L30:
        this.mLyricMusicLoop = r108;
        if (r100.readByte() == 0) goto L33;
        boolean r109 = true;
    L34:
        this.isAnimationLoop = r109;
        this.inStickerId = r100.readString();
        this.inPath = r100.readString();
        this.inDuration = r100.readInt();
        this.outPath = r100.readString();
        this.outDuration = r100.readInt();
        this.normalizedWidth = r100.readFloat();
        this.normalizedHeight = r100.readFloat();
        if (r100.readByte() == 0) goto L37;
        boolean r110 = true;
    L38:
        this.isAddVEEditorSuccess = r110;
        this.uuid = r100.readString();
        this.maxScale = r100.readFloat();
        this.minScale = r100.readFloat();
        this.ratio = r100.readFloat();
        this.stickerMobParams = (StickerMobParams) r100.readParcelable(getClass().getClassLoader());
        this.adjustTextStyleInEditorPro = r100.readString();
        this.adjustTextParagraph = r100.readString();
        this.adjustTextFontInEditorPro = r100.readString();
        this.adjustTextColorInEditorPro = r100.readString();
        this.adjustTextPositionInEditorPro = r100.readString();
        this.isEditorProTrimLength = r100.readString();
        this.isEditorProText = r100.readString();
        this.isEditorProCopyText = r100.readString();
        this.isEditorProTTS = r100.readString();
        this.editorProTTSID = r100.readString();
        this.isEditorProCaption = r100.readString();
        if (r100.readByte() == 0) goto L41;
        r101 = true;
    L41:
        this.isDynamicSticker = r101;
        this.drawRect = (DrawRect) r100.readParcelable(DrawRect.class.getClassLoader());
        this.providerEffect = r100.readString();
        return;
    L37:
        r110 = false;
        goto L38
    L33:
        r109 = false;
        goto L34
    L29:
        r108 = false;
        goto L30
    L25:
        r107 = false;
        goto L26
    L21:
        r106 = false;
        goto L22
    L17:
        r105 = false;
        goto L18
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof StickerItemModel) == true) goto L8;
        return false;
    L8:
        StickerItemModel r101 = (StickerItemModel) r100;
        if (TextUtils.isEmpty(this.uuid) == true) goto L16;
        if (getId() == 0) goto L16;
        if (TextUtils.equals(this.uuid, r101.uuid) == true) goto L18;
        return false;
    L18:
        String r102 = this.path;
        if (r102 != null) goto L21;
    L23:
        String r103 = this.stickerId;
        if (r103 != null) goto L26;
    L28:
        String r104 = this.extra;
        String r105 = r101.extra;
        if (r104 != null) goto L35;
        if (r105 == null) goto L36;
        return false;
    L36:
        return true;
    L35:
        return r104.equals(r105);
    L26:
        if (r103.equals(r101.stickerId) == true) goto L28;
        return false;
    L21:
        if (r102.equals(r101.path) == true) goto L23;
        return false;
    L16:
        if (getId() == r101.getId()) goto L18;
        return false;
    }

    public void setDrawRect(RectF r100) {
        DrawRect.Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "$this$toDrawRect");
        float r101 = r100.left;
        float r102 = r100.right;
        this.drawRect = new DrawRect(r101, r100.bottom, r102, r100.top);
    }

    public void setFromSearch(boolean r100) {
        this.f450801a = r100;
    }

    public void setId(int r100) {
        this.f450803id = r100;
    }

    public void setOriginalEndTime(int r100) {
        this.originalEndTime = r100;
    }

    public void setOriginalStartTime(int r100) {
        this.originalStartTime = r100;
    }

    public void setPin(boolean r100) {
        this.isPin = r100;
    }

    public void setPinAlgorithmFile(String r100) {
        this.pinAlgorithmFile = r100;
    }

    public void updateLayerWeight(int r100) {
        this.layerWeight = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.stickerId);
        r100.writeString(this.path);
        r100.writeString(this.extra);
        r100.writeString(this.extra2);
        r100.writeString(this.extra3);
        r100.writeFloat(this.scale);
        r100.writeFloat(this.stickerDrawScale);
        r100.writeFloat(this.rotateAngle);
        r100.writeInt(this.layerWeight);
        r100.writeInt(this.startTime);
        r100.writeInt(this.endTime);
        r100.writeInt(this.uiStartTime);
        r100.writeInt(this.uiEndTime);
        r100.writeFloat(this.initWidth);
        r100.writeFloat(this.initHeight);
        r100.writeFloat(this.currentOffsetX);
        r100.writeFloat(this.currentOffsetY);
        r100.writeByte(this.isAnimate ? 1 : 0);
        r100.writeByte(this.isImageStickerLayer ? 1 : 0);
        r100.writeInt(this.type);
        r100.writeString(this.pinAlgorithmFile);
        r100.writeByte(this.isPin ? 1 : 0);
        r100.writeString(this.mLyricInfo);
        r100.writeString(this.mLyricFontPath);
        r100.writeString(this.mLyricFontId);
        r100.writeInt(this.mLyricColor);
        r100.writeInt(this.mLyricInPoint);
        r100.writeInt(this.mLyricStartTime);
        r100.writeInt(this.mLyricOutPoint);
        r100.writeString(this.tabId);
        r100.writeFloat(this.f450805x);
        r100.writeFloat(this.f450806y);
        r100.writeFloat(this.f450804w);
        r100.writeFloat(this.f450802h);
        r100.writeByte(this.cutout ? 1 : 0);
        r100.writeByte(this.deletable ? 1 : 0);
        r100.writeByte(this.isEnableInteraction ? 1 : 0);
        r100.writeByte(this.mLyricMusicLoop ? 1 : 0);
        r100.writeByte(this.isAnimationLoop ? 1 : 0);
        r100.writeString(this.inStickerId);
        r100.writeString(this.inPath);
        r100.writeInt(this.inDuration);
        r100.writeString(this.outPath);
        r100.writeInt(this.outDuration);
        r100.writeFloat(this.normalizedWidth);
        r100.writeFloat(this.normalizedHeight);
        r100.writeByte(this.isAddVEEditorSuccess ? 1 : 0);
        r100.writeString(this.uuid);
        r100.writeFloat(this.maxScale);
        r100.writeFloat(this.minScale);
        r100.writeFloat(this.ratio);
        r100.writeParcelable(this.stickerMobParams, r101);
        r100.writeString(this.adjustTextStyleInEditorPro);
        r100.writeString(this.adjustTextParagraph);
        r100.writeString(this.adjustTextFontInEditorPro);
        r100.writeString(this.adjustTextColorInEditorPro);
        r100.writeString(this.adjustTextPositionInEditorPro);
        r100.writeString(this.isEditorProTrimLength);
        r100.writeString(this.isEditorProText);
        r100.writeString(this.isEditorProCopyText);
        r100.writeString(this.isEditorProTTS);
        r100.writeString(this.editorProTTSID);
        r100.writeString(this.isEditorProCaption);
        r100.writeByte(this.isDynamicSticker ? 1 : 0);
        r100.writeParcelable(this.drawRect, r101);
        r100.writeString(this.providerEffect);
    }

    public StickerItemModel(String r100, String r101, String r102, int r103, boolean r110, int r111, int r112, int r113) {
        this.scale = 1.0f;
        this.maxScale = 0.0f;
        this.minScale = 0.0f;
        this.stickerDrawScale = 1.0f;
        this.rotateAngle = 0.0f;
        this.currentOffsetX = 0.5f;
        this.currentOffsetY = 0.5f;
        this.mLyricColor = -1;
        this.mLyricInPoint = 0;
        this.mLyricStartTime = 0;
        this.mLyricOutPoint = 0;
        this.mLyricMusicLoop = true;
        this.challengeIdLoki = null;
        this.tabId = "";
        this.f450805x = 0.0f;
        this.f450806y = 0.0f;
        this.f450804w = 1.0f;
        this.f450802h = 1.0f;
        this.ratio = 1.0f;
        this.cutout = false;
        this.deletable = true;
        this.isEnableInteraction = true;
        this.normalizedWidth = -1.0f;
        this.normalizedHeight = -1.0f;
        this.isAddVEEditorSuccess = false;
        this.adjustTextStyleInEditorPro = "0";
        this.adjustTextParagraph = "0";
        this.adjustTextFontInEditorPro = "0";
        this.adjustTextColorInEditorPro = "0";
        this.adjustTextPositionInEditorPro = "0";
        this.isEditorProTrimLength = "0";
        this.isEditorProText = "0";
        this.isEditorProCopyText = "0";
        this.isEditorProTTS = "0";
        this.editorProTTSID = "";
        this.isEditorProCaption = "0";
        this.isDynamicSticker = false;
        this.providerEffect = "";
        this.enableRotate = true;
        this.enableScale = true;
        this.enablePan = true;
        this.drawRect = new DrawRect(0.0f, 0.0f, 0.0f, 0.0f);
        this.stickerId = r100;
        this.path = r101;
        this.extra = r102;
        this.layerWeight = r103;
        this.isAnimate = r110;
        this.startTime = r111;
        this.endTime = r112;
        this.type = r113;
    }
}
