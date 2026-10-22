package yw6;

import com.google.gson.annotations.SerializedName;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lyw6/l;", "Lyw6/x;", "", "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "category", "getCategory", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class l extends x {

    @SerializedName("category")
    private final String category;

    @SerializedName(ReportCardMonitorPlugin.EVENT_NAME)
    private final String eventName;

    public l() {
        super("event", 6);
        this.eventName = null;
        this.category = null;
    }
}
