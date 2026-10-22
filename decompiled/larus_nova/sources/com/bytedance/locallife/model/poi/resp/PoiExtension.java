package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.poi.model.HeadVideoStrict;
import com.ss.android.ugc.aweme.poi.model.PoiOverseasStruct;
import com.ss.android.ugc.aweme.poi.model.PoiPhoto;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes21.dex */
public class PoiExtension implements Serializable {

    @SerializedName("gallery_bottom_lynx_schema")
    @Nullable
    public String galleryBottomLynx;

    @SerializedName("gallery_header_lynx_schema")
    @Nullable
    public String galleryHeaderLynx;

    @SerializedName("has_upload_image_permission")
    public boolean hasUploadImagePermission;

    @SerializedName("video")
    @Nullable
    public HeadVideoStrict headVideo;

    @SerializedName("overseas")
    @Nullable
    public PoiOverseasStruct overseasStruct;

    @SerializedName("photo_info_string")
    @Nullable
    public List<String> photoInfoForLynx;

    @SerializedName("photos")
    @Nullable
    public List<PoiPhoto> photos;

    @SerializedName("photos_report_schema")
    @Nullable
    public String photosReportSchema;

    @SerializedName("pic_total_count")
    public int picTotalCount;

    public PoiExtension() {
    }
}
