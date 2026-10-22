package com.ss.android.ugc.aweme.discover.commodity.api.v3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/AiSearchGradientBackgroundConfig;", "Ljava/io/Serializable;", "()V", "colors", "", "", "getColors", "()Ljava/util/List;", "setColors", "(Ljava/util/List;)V", "locations", "", "getLocations", "setLocations", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AiSearchGradientBackgroundConfig implements Serializable {

    @SerializedName("colors")
    private List<String> colors;

    @SerializedName("locations")
    private List<Float> locations;

    public AiSearchGradientBackgroundConfig() {
    }

    public final List<String> getColors() {
        return this.colors;
    }

    public final List<Float> getLocations() {
        return this.locations;
    }

    public final void setColors(List<String> r100) {
        this.colors = r100;
    }

    public final void setLocations(List<Float> r100) {
        this.locations = r100;
    }
}
