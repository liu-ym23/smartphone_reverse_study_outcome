package com.ss.android.ugc.aweme.editSticker.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.draft.DraftTransMark;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u009d\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006¢\u0006\u0002\u0010\u0018J\t\u0010>\u001a\u00020\u000fHÖ\u0001J\u0019\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u000fHÖ\u0001R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001e\u0010\u0016\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001e\u0010\u0017\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001e\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR\u001e\u0010\u0010\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010)\"\u0004\b*\u0010+R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R&\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R \u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001e\"\u0004\b7\u0010 R\u001e\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001e\"\u0004\b9\u0010 R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001e\"\u0004\b;\u0010 R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00103\"\u0004\b=\u00105¨\u0006D"}, d2 = {"Lcom/ss/android/ugc/aweme/editSticker/model/CoverPublishModel;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "effectTextModel", "Lcom/ss/android/ugc/aweme/editSticker/model/EffectTextModel;", "videoCoverViewX", "", "videoCoverViewTransX", "videoCoverViewTransY", "videoCropCoverPath", "", "needExpandCompiledSize", "", "aiCoverStartTime", "aiCoverIndex", "", "isAiRecommendCover", "recTitleList", "", "Lcom/ss/android/ugc/aweme/editSticker/model/RecCoverTitleBean;", "saveTitleId", "imageCurrentIndex", "imageCoverViewTransX", "imageCoverViewTransY", "(Lcom/ss/android/ugc/aweme/editSticker/model/EffectTextModel;FFFLjava/lang/String;ZFIZLjava/util/List;Ljava/lang/String;IFF)V", "getAiCoverIndex", "()I", "setAiCoverIndex", "(I)V", "getAiCoverStartTime", "()F", "setAiCoverStartTime", "(F)V", "getEffectTextModel", "()Lcom/ss/android/ugc/aweme/editSticker/model/EffectTextModel;", "getImageCoverViewTransX", "setImageCoverViewTransX", "getImageCoverViewTransY", "setImageCoverViewTransY", "getImageCurrentIndex", "setImageCurrentIndex", "()Z", "setAiRecommendCover", "(Z)V", "getNeedExpandCompiledSize", "setNeedExpandCompiledSize", "getRecTitleList", "()Ljava/util/List;", "setRecTitleList", "(Ljava/util/List;)V", "getSaveTitleId", "()Ljava/lang/String;", "setSaveTitleId", "(Ljava/lang/String;)V", "getVideoCoverViewTransX", "setVideoCoverViewTransX", "getVideoCoverViewTransY", "setVideoCoverViewTransY", "getVideoCoverViewX", "setVideoCoverViewX", "getVideoCropCoverPath", "setVideoCropCoverPath", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class CoverPublishModel implements Parcelable, Serializable {
    public static final Parcelable.Creator<CoverPublishModel> CREATOR = null;

    @SerializedName("ai_cover_index")
    private int aiCoverIndex;

    @SerializedName("ai_cover_start_time")
    private float aiCoverStartTime;

    @SerializedName("effect_text_model")
    @DraftTransMark
    private final EffectTextModel effectTextModel;

    @SerializedName("image_cover_view_trans_x")
    private float imageCoverViewTransX;

    @SerializedName("image_cover_view_trans_y")
    private float imageCoverViewTransY;

    @SerializedName("image_current_index")
    private int imageCurrentIndex;

    @SerializedName("is_ai_recommend_cover")
    private boolean isAiRecommendCover;

    @SerializedName("need_expand_compiled_size")
    private boolean needExpandCompiledSize;

    @SerializedName("cover_recommend_title")
    private List<RecCoverTitleBean> recTitleList;

    @SerializedName("save_rec_title_id")
    private String saveTitleId;

    @SerializedName("video_cover_view_trans_x")
    private float videoCoverViewTransX;

    @SerializedName("video_cover_view_trans_y")
    private float videoCoverViewTransY;

    @SerializedName("video_cover_view_x")
    private float videoCoverViewX;

    @SerializedName("video_cover_crop_path")
    @DraftTransMark
    private String videoCropCoverPath;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static class Creator implements Parcelable.Creator<CoverPublishModel> {
        public Creator() {
        }

        @Override // android.os.Parcelable.Creator
        public final CoverPublishModel createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "in");
            EffectTextModel r100 = (EffectTextModel) r110.readParcelable(CoverPublishModel.class.getClassLoader());
            float r101 = r110.readFloat();
            float r102 = r110.readFloat();
            float r103 = r110.readFloat();
            String r104 = r110.readString();
            if (r110.readInt() == 0) goto L5;
            boolean r111 = true;
        L6:
            float r112 = r110.readFloat();
            int r113 = r110.readInt();
            if (r110.readInt() == 0) goto L9;
            boolean r114 = true;
        L11:
            if (r110.readInt() == 0) goto L16;
            int r105 = r110.readInt();
            ArrayList r106 = new ArrayList(r105);
        L13:
            if (r105 == 0) goto L15;
            r106.add(RecCoverTitleBean.CREATOR.createFromParcel(r110));
            r105 = r105 - 1;
            goto L13
        L15:
            ArrayList r115 = r106;
        L18:
            return new CoverPublishModel(r100, r101, r102, r103, r104, r111, r112, r113, r114, r115, r110.readString(), r110.readInt(), r110.readFloat(), r110.readFloat());
        L16:
            r115 = null;
            goto L18
        L9:
            r114 = false;
            goto L11
        L5:
            r111 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final CoverPublishModel[] newArray(int r100) {
            return new CoverPublishModel[r100];
        }
    }

    static {
        CREATOR = new Creator();
    }

    public CoverPublishModel() {
        this(null, 0.0f, 0.0f, 0.0f, null, false, 0.0f, 0, false, null, null, 0, 0.0f, 0.0f, 16383, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeParcelable(this.effectTextModel, r101);
        r100.writeFloat(this.videoCoverViewX);
        r100.writeFloat(this.videoCoverViewTransX);
        r100.writeFloat(this.videoCoverViewTransY);
        r100.writeString(this.videoCropCoverPath);
        r100.writeInt(this.needExpandCompiledSize ? 1 : 0);
        r100.writeFloat(this.aiCoverStartTime);
        r100.writeInt(this.aiCoverIndex);
        r100.writeInt(this.isAiRecommendCover ? 1 : 0);
        List<RecCoverTitleBean> r102 = this.recTitleList;
        if (r102 == null) goto L8;
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<RecCoverTitleBean> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        r103.next().writeToParcel(r100, 0);
    L9:
        r100.writeString(this.saveTitleId);
        r100.writeInt(this.imageCurrentIndex);
        r100.writeFloat(this.imageCoverViewTransX);
        r100.writeFloat(this.imageCoverViewTransY);
        return;
    L8:
        r100.writeInt(0);
        goto L9
    }

    public final int getAiCoverIndex() {
        return this.aiCoverIndex;
    }

    public final float getAiCoverStartTime() {
        return this.aiCoverStartTime;
    }

    public final EffectTextModel getEffectTextModel() {
        return this.effectTextModel;
    }

    public final float getImageCoverViewTransX() {
        return this.imageCoverViewTransX;
    }

    public final float getImageCoverViewTransY() {
        return this.imageCoverViewTransY;
    }

    public final int getImageCurrentIndex() {
        return this.imageCurrentIndex;
    }

    public final boolean getNeedExpandCompiledSize() {
        return this.needExpandCompiledSize;
    }

    public final List<RecCoverTitleBean> getRecTitleList() {
        return this.recTitleList;
    }

    public final String getSaveTitleId() {
        return this.saveTitleId;
    }

    public final float getVideoCoverViewTransX() {
        return this.videoCoverViewTransX;
    }

    public final float getVideoCoverViewTransY() {
        return this.videoCoverViewTransY;
    }

    public final float getVideoCoverViewX() {
        return this.videoCoverViewX;
    }

    public final String getVideoCropCoverPath() {
        return this.videoCropCoverPath;
    }

    public final boolean isAiRecommendCover() {
        return this.isAiRecommendCover;
    }

    public final void setAiCoverIndex(int r100) {
        this.aiCoverIndex = r100;
    }

    public final void setAiCoverStartTime(float r100) {
        this.aiCoverStartTime = r100;
    }

    public final void setAiRecommendCover(boolean r100) {
        this.isAiRecommendCover = r100;
    }

    public final void setImageCoverViewTransX(float r100) {
        this.imageCoverViewTransX = r100;
    }

    public final void setImageCoverViewTransY(float r100) {
        this.imageCoverViewTransY = r100;
    }

    public final void setImageCurrentIndex(int r100) {
        this.imageCurrentIndex = r100;
    }

    public final void setNeedExpandCompiledSize(boolean r100) {
        this.needExpandCompiledSize = r100;
    }

    public final void setRecTitleList(List<RecCoverTitleBean> r100) {
        this.recTitleList = r100;
    }

    public final void setSaveTitleId(String r100) {
        this.saveTitleId = r100;
    }

    public final void setVideoCoverViewTransX(float r100) {
        this.videoCoverViewTransX = r100;
    }

    public final void setVideoCoverViewTransY(float r100) {
        this.videoCoverViewTransY = r100;
    }

    public final void setVideoCoverViewX(float r100) {
        this.videoCoverViewX = r100;
    }

    public final void setVideoCropCoverPath(String r100) {
        this.videoCropCoverPath = r100;
    }

    public CoverPublishModel(EffectTextModel r100, float r101, float r102, float r103, String r104, boolean r105, float r106, int r107, boolean r110, List<RecCoverTitleBean> r111, String r112, int r113, float r114, float r115) {
        Intrinsics.checkNotNullParameter(r100, "effectTextModel");
        this.effectTextModel = r100;
        this.videoCoverViewX = r101;
        this.videoCoverViewTransX = r102;
        this.videoCoverViewTransY = r103;
        this.videoCropCoverPath = r104;
        this.needExpandCompiledSize = r105;
        this.aiCoverStartTime = r106;
        this.aiCoverIndex = r107;
        this.isAiRecommendCover = r110;
        this.recTitleList = r111;
        this.saveTitleId = r112;
        this.imageCurrentIndex = r113;
        this.imageCoverViewTransX = r114;
        this.imageCoverViewTransY = r115;
    }

    public /* synthetic */ CoverPublishModel(EffectTextModel r110, float r111, float r112, float r113, String r210, boolean r211, float r212, int r213, boolean r214, List r215, String r216, int r217, float r218, float r219, int r310, DefaultConstructorMarker r311) {
        if ((r310 & 1) == 0) goto L5;
        EffectTextModel r100 = new EffectTextModel(false, null, null, null, null, 31, null);
    L6:
        float r101 = -1.0f;
        if ((r310 & 2) == 0) goto L9;
        float r102 = -1.0f;
    L10:
        float r103 = 0.0f;
        if ((r310 & 4) == 0) goto L13;
        float r104 = 0.0f;
    L15:
        if ((r310 & 8) == 0) goto L17;
        float r105 = 0.0f;
    L18:
        String r106 = null;
        if ((r310 & 16) == 0) goto L21;
        String r107 = null;
    L22:
        int r114 = 0;
        if ((r310 & 32) == 0) goto L25;
        boolean r108 = false;
    L27:
        if ((r310 & 64) != 0) goto L31;
        r103 = r212;
    L31:
        if ((r310 & 128) == 0) goto L33;
        int r115 = -1;
    L35:
        if ((r310 & 256) == 0) goto L37;
        boolean r116 = false;
    L39:
        if ((r310 & 512) == 0) goto L41;
        List r117 = null;
    L43:
        if ((r310 & 1024) != 0) goto L47;
        r106 = r216;
    L47:
        if ((r310 & 2048) != 0) goto L51;
        r114 = r217;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        float r118 = -1.0f;
    L55:
        if ((r310 & 8192) != 0) goto L58;
        r101 = r219;
    L58:
        this(r100, r102, r104, r105, r107, r108, r103, r115, r116, r117, r106, r114, r118, r101);
        return;
    L53:
        r118 = r218;
        goto L55
    L41:
        r117 = r215;
        goto L43
    L37:
        r116 = r214;
        goto L39
    L33:
        r115 = r213;
        goto L35
    L25:
        r108 = r211;
        goto L27
    L21:
        r107 = r210;
        goto L22
    L17:
        r105 = r113;
        goto L18
    L13:
        r104 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L10
    L5:
        r100 = r110;
        goto L6
    }
}
