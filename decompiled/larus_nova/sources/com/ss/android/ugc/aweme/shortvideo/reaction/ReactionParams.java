package com.ss.android.ugc.aweme.shortvideo.reaction;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class ReactionParams implements Serializable, Parcelable {
    public static final Parcelable.Creator<ReactionParams> CREATOR = null;

    @SerializedName("non_reacted_video")
    public boolean nonReacted;

    @SerializedName("reaction_from_id")
    public String reactionFromId;

    @SerializedName("reaction_origin_id")
    public String reactionOriginId;

    @SerializedName("reaction_view_id")
    public String reactionViewId;

    @SerializedName("video_height")
    public int videoHeight;

    @SerializedName("video_path")
    public String videoPath;

    @SerializedName("video_width")
    public int videoWidth;

    @SerializedName("wav_path")
    public String wavPath;

    @SerializedName("react_shape_list")
    public List<CopiedReactionWindowInfo> windowInfoList;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public boolean removeReactionWindowInfo() {
        if (this.windowInfoList.size() <= 0) goto L6;
        List<CopiedReactionWindowInfo> r100 = this.windowInfoList;
        ListProtector.remove(r100, r100.size() - 1);
        return true;
    L6:
        return false;
    }

    public ReactionParams() {
        this.windowInfoList = new ArrayList();
    }

    public ReactionParams(Parcel r100) {
        this.windowInfoList = new ArrayList();
        this.videoPath = r100.readString();
        this.wavPath = r100.readString();
        this.videoWidth = r100.readInt();
        this.videoHeight = r100.readInt();
        this.reactionViewId = r100.readString();
        this.reactionOriginId = r100.readString();
        this.reactionFromId = r100.readString();
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.nonReacted = r101;
        this.windowInfoList = r100.createTypedArrayList(CopiedReactionWindowInfo.CREATOR);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public void addReactionWindowInfo(CopiedReactionWindowInfo r100) {
        this.windowInfoList.add(r100);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.videoPath);
        r100.writeString(this.wavPath);
        r100.writeInt(this.videoWidth);
        r100.writeInt(this.videoHeight);
        r100.writeString(this.reactionViewId);
        r100.writeString(this.reactionOriginId);
        r100.writeString(this.reactionFromId);
        r100.writeByte(this.nonReacted ? 1 : 0);
        r100.writeTypedList(this.windowInfoList);
    }
}
