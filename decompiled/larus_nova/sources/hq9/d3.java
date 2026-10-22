package hq9;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B{\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/larus/platform/model/MainBotSloMonitorConfig;", "", "monitorItemBlackList", "", "", "lynxTimeoutDuration", "", "imageTimeoutDuration", "videoTimeoutDuration", "potentialFormulaRegex", "potentialTableRegex", "potentialBoldRegex", "potentialExtraLength", "", "originTextCheckList", "Lcom/larus/platform/model/OriginTextCheckItem;", "<init>", "(Ljava/util/List;JJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;)V", "getMonitorItemBlackList", "()Ljava/util/List;", "getLynxTimeoutDuration", "()J", "getImageTimeoutDuration", "getVideoTimeoutDuration", "getPotentialFormulaRegex", "()Ljava/lang/String;", "getPotentialTableRegex", "getPotentialBoldRegex", "getPotentialExtraLength", "()I", "getOriginTextCheckList", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d3 {

    @SerializedName("image_timeout_duration")
    private final long imageTimeoutDuration;

    @SerializedName("lynx_timeout_duration")
    private final long lynxTimeoutDuration;

    @SerializedName("monitor_item_black_list")
    private final List<String> monitorItemBlackList;

    @SerializedName("origin_text_check_list")
    private final List<s3> originTextCheckList;

    @SerializedName("potential_bold_regex")
    private final String potentialBoldRegex;

    @SerializedName("potential_extra_length")
    private final int potentialExtraLength;

    @SerializedName("potential_formula_regex")
    private final String potentialFormulaRegex;

    @SerializedName("potential_table_regex")
    private final String potentialTableRegex;

    @SerializedName("video_timeout_duration")
    private final long videoTimeoutDuration;

    public d3() {
        this(null);
    }

    public final long a() {
        return this.imageTimeoutDuration;
    }

    public final long b() {
        return this.lynxTimeoutDuration;
    }

    public final List<String> c() {
        return this.monitorItemBlackList;
    }

    public final List<s3> d() {
        return this.originTextCheckList;
    }

    public final String e() {
        return this.potentialBoldRegex;
    }

    public final int f() {
        return this.potentialExtraLength;
    }

    public final String g() {
        return this.potentialFormulaRegex;
    }

    public final String h() {
        return this.potentialTableRegex;
    }

    public final long i() {
        return this.videoTimeoutDuration;
    }

    public d3(Object r100) {
        List<String> r101 = CollectionsKt.emptyList();
        List<s3> r102 = CollectionsKt.emptyList();
        this.monitorItemBlackList = r101;
        this.lynxTimeoutDuration = 1000;
        this.imageTimeoutDuration = 10000;
        this.videoTimeoutDuration = 10000;
        this.potentialFormulaRegex = null;
        this.potentialTableRegex = null;
        this.potentialBoldRegex = null;
        this.potentialExtraLength = 20;
        this.originTextCheckList = r102;
    }
}
