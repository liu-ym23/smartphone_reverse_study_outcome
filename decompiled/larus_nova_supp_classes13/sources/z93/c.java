package z93;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0014"}, d2 = {"Lz93/c;", "Lz93/e;", "", "defaultVMCount", "I", "getDefaultVMCount", "()I", "", "enablePreDecodeFromCache", "Z", "getEnablePreDecodeFromCache", "()Z", "", "Lz93/a;", "customCardsTemplates", "Ljava/util/List;", "getCustomCardsTemplates", "()Ljava/util/List;", "waitingCachedData", "getWaitingCachedData", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c extends e {

    @SerializedName("custom_cards_templates")
    private final List<a> customCardsTemplates;

    @SerializedName("default_vm_count")
    private final int defaultVMCount;

    @SerializedName("enable_pre_decode_from_cache")
    private final boolean enablePreDecodeFromCache;

    @SerializedName("waiting_cached_data")
    private final boolean waitingCachedData;

    public c() {
        super(null, 0, null, null, null, null, null, null, 768);
        this.defaultVMCount = 1;
        this.enablePreDecodeFromCache = false;
        this.customCardsTemplates = null;
        this.waitingCachedData = true;
    }
}
