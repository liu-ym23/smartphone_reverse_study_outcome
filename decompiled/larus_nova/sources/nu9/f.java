package nu9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/larus/settings/provider/dora/DoraDataSavingConfig;", "", "<init>", "()V", "showEntrance", "", "getShowEntrance", "()Ljava/lang/Integer;", "setShowEntrance", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "defValue", "getDefValue", "setDefValue", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    @SerializedName("def_value")
    private Integer defValue;

    @SerializedName("show_entrance")
    private Integer showEntrance;

    public f() {
    }

    public final Integer a() {
        return this.defValue;
    }

    public final Integer b() {
        return this.showEntrance;
    }

    public final void c(Integer r100) {
        this.defValue = r100;
    }

    public final void d(Integer r100) {
        this.showEntrance = r100;
    }
}
