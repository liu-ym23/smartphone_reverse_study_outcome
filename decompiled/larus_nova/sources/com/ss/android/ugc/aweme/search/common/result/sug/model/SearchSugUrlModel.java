package com.ss.android.ugc.aweme.search.common.result.sug.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/sug/model/SearchSugUrlModel;", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "()V", "tagIconCenterY", "", "getTagIconCenterY", "()I", "tagIconLeft", "getTagIconLeft", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "useApiSize", "getUseApiSize", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchSugUrlModel extends UrlModel {
    public static final Companion Companion = null;
    public static final int USE_API_SIZE_FALSE = 0;
    public static final int USE_API_SIZE_TRUE = 1;

    @SerializedName("tag_icon_center_y")
    private final int tagIconCenterY;

    @SerializedName("tag_icon_left")
    private final Integer tagIconLeft;

    @SerializedName("use_api_size")
    private final int useApiSize;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/sug/model/SearchSugUrlModel$Companion;", "", "()V", "USE_API_SIZE_FALSE", "", "USE_API_SIZE_TRUE", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public SearchSugUrlModel() {
    }

    public final int getTagIconCenterY() {
        return this.tagIconCenterY;
    }

    public final Integer getTagIconLeft() {
        return this.tagIconLeft;
    }

    public final int getUseApiSize() {
        return this.useApiSize;
    }
}
