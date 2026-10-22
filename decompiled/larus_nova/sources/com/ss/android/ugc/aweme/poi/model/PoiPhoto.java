package com.ss.android.ugc.aweme.poi.model;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ies.modulize.rule.AllowImpl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes40.dex */
public class PoiPhoto implements Serializable {
    public static final int MEDIA_TYPE_PHOTO = 0;
    public static final int MEDIA_TYPE_VIDEO = 1;

    @SerializedName("highlight")
    public PhotoHighlight highlight;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_REPLAY_LOG_PARAMS)
    public String logParams;

    @SerializedName(a.KEY_MEDIA_TYPE)
    public int mediaType;

    @SerializedName("pic_large")
    public PoiImageUrlModel picLarge;

    @SerializedName("pic_main_color")
    public String picMainColor;

    @SerializedName("pic_medium")
    public PoiImageUrlModel picMedium;

    @SerializedName("pic_quality_confidence")
    public Float picQualityScore;

    @SerializedName("pic_score")
    public Float picScore;

    @SerializedName("pic_source")
    public String picSource;

    @SerializedName("source")
    public int picSourceInt;

    @SerializedName("tab_id")
    public String tabId;

    @SerializedName(a.KEY_TAB_NAME)
    public String tabName;

    @SerializedName("title")
    public String title;

    @SerializedName("uploader_id")
    public String uploaderId;

    @SerializedName("uploader_info")
    public PoiImageUploaderStruct uploaderInfo;

    @SerializedName("uploader_nick_name")
    public String uploaderName;

    @SerializedName("video_cover_url")
    public String videoCoverUrl;

    @SerializedName("video_duration")
    public Float videoDuration;

    @SerializedName("video_height")
    public int videoHeight;

    @SerializedName("video_id")
    public String videoId;

    @SerializedName("video_url")
    public String videoUrl;

    @SerializedName("video_width")
    public int videoWidth;

    public PoiPhoto() {
    }

    @AllowImpl
    public String getLarge() {
        return (String) ListProtector.get(this.picLarge.getUrlList(), 0);
    }

    @AllowImpl
    public String getMedium() {
        return (String) ListProtector.get(this.picMedium.getUrlList(), 0);
    }

    @AllowImpl
    public PoiImageUrlModel getPicMedium() {
        return this.picMedium;
    }

    public Float getPicQualityScore() {
        return this.picQualityScore;
    }

    public String getTabId() {
        return this.tabId;
    }

    public String getTabName() {
        return this.tabName;
    }

    public String getUploaderId() {
        return this.uploaderId;
    }
}
