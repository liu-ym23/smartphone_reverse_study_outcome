package is6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0016\u001a\u00020\u00158\u0006X\u0087D¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lis6/a;", "", "", "expandHotspotWidth", "I", "getExpandHotspotWidth", "()I", "expandHotspotHeight", "getExpandHotspotHeight", "expandWidth", "getExpandWidth", "expandHeight", "getExpandHeight", "foldHotspotWidth", "getFoldHotspotWidth", "foldHotspotHeight", "getFoldHotspotHeight", "foldWidth", "getFoldWidth", "foldHeight", "getFoldHeight", "", "canClose", "Z", "getCanClose", "()Z", "<init>", "()V", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("can_close")
    private final boolean canClose;

    @SerializedName("expand_height")
    private final int expandHeight;

    @SerializedName("expand_hotspot_height")
    private final int expandHotspotHeight;

    @SerializedName("expand_hotspot_width")
    private final int expandHotspotWidth;

    @SerializedName("expand_width")
    private final int expandWidth;

    @SerializedName("fold_height")
    private final int foldHeight;

    @SerializedName("fold_hotspot_height")
    private final int foldHotspotHeight;

    @SerializedName("fold_hotspot_width")
    private final int foldHotspotWidth;

    @SerializedName("fold_width")
    private final int foldWidth;

    public a() {
        this.expandHotspotWidth = 76;
        this.expandHotspotHeight = 76;
        this.expandWidth = 76;
        this.expandHeight = 76;
        this.foldHotspotWidth = 26;
        this.foldHotspotHeight = 101;
        this.foldWidth = 26;
        this.foldHeight = 101;
        this.canClose = true;
    }
}
