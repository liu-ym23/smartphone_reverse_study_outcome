package kq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/larus/platform/model/album/WatermarkRemovalConfig;", "", "showEntry", "", "showSwitchDocument", "showSwitchCreation", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getShowEntry", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getShowSwitchDocument", "getShowSwitchCreation", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class u {

    @SerializedName("show_entry")
    private final Boolean showEntry;

    @SerializedName("show_switch_creation")
    private final Boolean showSwitchCreation;

    @SerializedName("show_switch_office")
    private final Boolean showSwitchDocument;

    public u() {
        this(0);
    }

    public final Boolean a() {
        return this.showEntry;
    }

    public final Boolean b() {
        return this.showSwitchCreation;
    }

    public final Boolean c() {
        return this.showSwitchDocument;
    }

    public u(int r100) {
        Boolean r101 = Boolean.TRUE;
        this.showEntry = r101;
        this.showSwitchDocument = r101;
        this.showSwitchCreation = r101;
    }
}
