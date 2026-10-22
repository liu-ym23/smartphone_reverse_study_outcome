package z93;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\u00020\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u001d¨\u0006$"}, d2 = {"Lz93/e;", "", "", "", "openPage", "Ljava/util/List;", "getOpenPage", "()Ljava/util/List;", "", "preloadTiming", "I", "getPreloadTiming", "()I", "blackCard", "getBlackCard", "whiteCard", "getWhiteCard", "blockOS", "getBlockOS", "forceUseCard", "getForceUseCard", "", "forcePreloadCardCountLimit", "Ljava/util/Map;", "getForcePreloadCardCountLimit", "()Ljava/util/Map;", "maxAllowPreloadNum", "Ljava/lang/Integer;", "getMaxAllowPreloadNum", "()Ljava/lang/Integer;", "", "isRunMainThread", "Z", "()Z", "globalPropsByInitData", "getGlobalPropsByInitData", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class e {

    @SerializedName("preload_black_card")
    private final List<Integer> blackCard;

    @SerializedName("preload_block_os")
    private final List<String> blockOS;

    @SerializedName("force_preload_card_count_limit")
    private final Map<String, Integer> forcePreloadCardCountLimit;

    @SerializedName("force_preload_card")
    private final List<Integer> forceUseCard;

    @SerializedName("set_global_props_by_init_data")
    private final Integer globalPropsByInitData;

    @SerializedName("is_main_thread")
    private final boolean isRunMainThread;

    @SerializedName("max_allow_preload_num")
    private final Integer maxAllowPreloadNum;

    @SerializedName("preload_page")
    private final List<String> openPage;

    @SerializedName("preload_timing")
    private final int preloadTiming;

    @SerializedName("preload_white_card")
    private final List<Integer> whiteCard;

    public e() {
        this(null, 0, null, null, null, null, null, null, 1023);
    }

    public e(List r4, int r5, List r6, List r7, List r8, List r9, Map r10, Integer r11, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r6 = null;
    L12:
        if ((r12 & 8) == 0) goto L15;
        r7 = null;
    L15:
        if ((r12 & 16) == 0) goto L18;
        r8 = null;
    L18:
        if ((r12 & 32) == 0) goto L21;
        r9 = null;
    L21:
        if ((r12 & 64) == 0) goto L24;
        r10 = null;
    L24:
        if ((r12 & 128) == 0) goto L26;
        r11 = null;
    L26:
        this.openPage = r4;
        this.preloadTiming = r5;
        this.blackCard = r6;
        this.whiteCard = r7;
        this.blockOS = r8;
        this.forceUseCard = r9;
        this.forcePreloadCardCountLimit = r10;
        this.maxAllowPreloadNum = r11;
        this.isRunMainThread = false;
        this.globalPropsByInitData = null;
    }
}
