package com.ss.android.ugc.aweme.discover.model.globaldoodle;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/FeedbackEntranceIconStruct;", "Ljava/io/Serializable;", "()V", "bottom", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/FeedbackEntranceIconBottomStruct;", "getBottom", "()Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/FeedbackEntranceIconBottomStruct;", "setBottom", "(Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/FeedbackEntranceIconBottomStruct;)V", "iconRadius", "", "getIconRadius", "()I", "setIconRadius", "(I)V", "image", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "getImage", "()Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "setImage", "(Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;)V", "imageDark", "getImageDark", "setImageDark", "startShowDelay", "", "getStartShowDelay", "()J", "setStartShowDelay", "(J)V", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class FeedbackEntranceIconStruct implements Serializable {

    @SerializedName("bottom")
    private FeedbackEntranceIconBottomStruct bottom;

    @SerializedName("icon_radius")
    private int iconRadius;

    @SerializedName("image")
    private UrlModel image;

    @SerializedName("image_dark")
    private UrlModel imageDark;

    @SerializedName("start_show_delay_ms")
    private long startShowDelay;

    public FeedbackEntranceIconStruct() {
        this.iconRadius = 18;
    }

    public final FeedbackEntranceIconBottomStruct getBottom() {
        return this.bottom;
    }

    public final int getIconRadius() {
        return this.iconRadius;
    }

    public final UrlModel getImage() {
        return this.image;
    }

    public final UrlModel getImageDark() {
        return this.imageDark;
    }

    public final long getStartShowDelay() {
        return this.startShowDelay;
    }

    public final void setBottom(FeedbackEntranceIconBottomStruct r100) {
        this.bottom = r100;
    }

    public final void setIconRadius(int r100) {
        this.iconRadius = r100;
    }

    public final void setImage(UrlModel r100) {
        this.image = r100;
    }

    public final void setImageDark(UrlModel r100) {
        this.imageDark = r100;
    }

    public final void setStartShowDelay(long r100) {
        this.startShowDelay = r100;
    }
}
