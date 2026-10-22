package hj3;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b*\u0010+R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\b8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\b8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010R\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010&\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lhj3/g;", "", "", "", "listkitPreloadTemplates", "Ljava/util/List;", "f", "()Ljava/util/List;", "", "listkitPreloadSingleCount", "I", "e", "()I", "searchbarSchema", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "loadMoreRangeSize", "g", "autoplayDetectionInterval", "a", "", "playerItemTypes", "Ljava/util/Map;", "i", "()Ljava/util/Map;", "bgSchema", "b", "listBgSchema", "d", "resourceChannel", "j", "", "doubleRawChannelVersion", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "", "playAreaRate", "Ljava/lang/Float;", "h", "()Ljava/lang/Float;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("autoplay_detection_interval")
    private final int autoplayDetectionInterval;

    @SerializedName("bg_schema")
    private final String bgSchema;

    @SerializedName("double_raw_channel_version")
    private final Long doubleRawChannelVersion;

    @SerializedName("list_bg_schema")
    private final String listBgSchema;

    @SerializedName("listkit_preload_single_count")
    private final int listkitPreloadSingleCount;

    @SerializedName("listkit_preload_templates")
    private final List<String> listkitPreloadTemplates;

    @SerializedName("load_more_range_size")
    private final int loadMoreRangeSize;

    @SerializedName("play_area_rate")
    private final Float playAreaRate;

    @SerializedName("player_item_types")
    private final Map<String, String> playerItemTypes;

    @SerializedName("resource_channel")
    private final String resourceChannel;

    @SerializedName("searchbar_schema")
    private final String searchbarSchema;

    public g() {
        this.autoplayDetectionInterval = 50;
    }

    public final int a() {
        return this.autoplayDetectionInterval;
    }

    public final String b() {
        return this.bgSchema;
    }

    public final Long c() {
        return this.doubleRawChannelVersion;
    }

    public final String d() {
        return this.listBgSchema;
    }

    public final int e() {
        return this.listkitPreloadSingleCount;
    }

    public final List<String> f() {
        return this.listkitPreloadTemplates;
    }

    public final int g() {
        return this.loadMoreRangeSize;
    }

    public final Float h() {
        return this.playAreaRate;
    }

    public final Map<String, String> i() {
        return this.playerItemTypes;
    }

    public final String j() {
        return this.resourceChannel;
    }

    public final String k() {
        return this.searchbarSchema;
    }
}
