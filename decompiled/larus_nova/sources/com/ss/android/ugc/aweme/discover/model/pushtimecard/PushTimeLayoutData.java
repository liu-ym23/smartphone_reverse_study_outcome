package com.ss.android.ugc.aweme.discover.model.pushtimecard;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000f\u0010\nR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0011\u0010\nR\u001a\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0015\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/pushtimecard/PushTimeLayoutData;", "Ljava/io/Serializable;", "()V", "alignmentMode", "", "getAlignmentMode", "()Ljava/lang/String;", "bottomMargin", "", "getBottomMargin", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "height", "getHeight", "leftMargin", "getLeftMargin", "rightMargin", "getRightMargin", "topMargin", "getTopMargin", "width", "getWidth", "trade-search-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public class PushTimeLayoutData implements Serializable {

    @SerializedName("alignment_mode")
    private final String alignmentMode;

    @SerializedName("bottom_margin")
    private final Integer bottomMargin;

    @SerializedName("height")
    private final Integer height;

    @SerializedName("left_margin")
    private final Integer leftMargin;

    @SerializedName("right_margin")
    private final Integer rightMargin;

    @SerializedName("top_margin")
    private final Integer topMargin;

    @SerializedName("width")
    private final Integer width;

    public PushTimeLayoutData() {
    }

    public final String getAlignmentMode() {
        return this.alignmentMode;
    }

    public final Integer getBottomMargin() {
        return this.bottomMargin;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Integer getLeftMargin() {
        return this.leftMargin;
    }

    public final Integer getRightMargin() {
        return this.rightMargin;
    }

    public final Integer getTopMargin() {
        return this.topMargin;
    }

    public final Integer getWidth() {
        return this.width;
    }
}
