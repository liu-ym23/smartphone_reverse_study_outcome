package l09;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/larus/common/baidunavi/impl/bean/MsgBeanResult;", "", "mmLocation", "Lcom/larus/common/baidunavi/impl/bean/MsgBeanLocation;", "mmDirection", "", "<init>", "(Lcom/larus/common/baidunavi/impl/bean/MsgBeanLocation;Ljava/lang/Double;)V", "getMmLocation", "()Lcom/larus/common/baidunavi/impl/bean/MsgBeanLocation;", "getMmDirection", "()Ljava/lang/Double;", "Ljava/lang/Double;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("mm_direction")
    private final Double mmDirection;

    @SerializedName("mm_location")
    private final a mmLocation;

    public c() {
        this.mmLocation = null;
        this.mmDirection = null;
    }
}
