package oq9;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \r2\u00020\u0001:\u0001\rB+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/larus/platform/model/camera/AppImageUploadConfig;", "", "maxCameraShortSize", "", "maxCompressShortSize", GearStrategyConsts.EV_QUALITY, "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getMaxCameraShortSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxCompressShortSize", "getQuality", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f524900a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f524901b = null;

    @SerializedName("max_camera_short_size")
    private final Integer maxCameraShortSize;

    @SerializedName("max_compress_short_size")
    private final Integer maxCompressShortSize;

    @SerializedName(GearStrategyConsts.EV_QUALITY)
    private final Integer quality;

    public static final class a {
    }

    public b() {
        this(0);
    }

    static {
        f524900a = new b(1080, 1080, 95);
        f524901b = new b(1440, 1440, 95);
    }

    public final Integer a() {
        return this.maxCameraShortSize;
    }

    public final Integer b() {
        return this.maxCompressShortSize;
    }

    public final Integer c() {
        return this.quality;
    }

    public /* synthetic */ b(int r100) {
        this(1440, 1080, 95);
    }

    public b(Integer r100, Integer r101, Integer r102) {
        this.maxCameraShortSize = r100;
        this.maxCompressShortSize = r101;
        this.quality = r102;
    }
}
