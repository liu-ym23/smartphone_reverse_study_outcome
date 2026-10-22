package r43;

import com.bytedance.android.ec.model.api.LogPbData;
import com.google.gson.annotations.SerializedName;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lr43/d;", "Ln33/a;", "Lcom/bytedance/android/ec/model/api/LogPbData;", "logPb", "Lcom/bytedance/android/ec/model/api/LogPbData;", RXScreenCaptureService.KEY_INDEX, "()Lcom/bytedance/android/ec/model/api/LogPbData;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d extends n33.a {

    @SerializedName("log_pb")
    private final LogPbData logPb;

    public d() {
        this(0);
    }

    public final LogPbData i() {
        return this.logPb;
    }

    public d(int r100) {
        super(null, 3);
        this.logPb = null;
    }
}
