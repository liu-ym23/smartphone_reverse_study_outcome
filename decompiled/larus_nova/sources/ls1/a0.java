package ls1;

import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\"\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011¨\u0006$"}, d2 = {"Lls1/a0;", "", "", "mode", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "smartPrefetchSize", "e", "setSmartPrefetchSize", "(I)V", "", "reverseSizeOnNetQuality", "Z", "c", "()Z", "setReverseSizeOnNetQuality", "(Z)V", "reverseSizeOnLoss", "b", "setReverseSizeOnLoss", "", "weightOfNetQuality", FaceService.girlLabel, ce.f26391f, "()F", "setWeightOfNetQuality", "(F)V", "weightOfLoss", "f", "setWeightOfLoss", "roomCheckOnLossEnable", "d", "setRoomCheckOnLossEnable", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a0 {

    @SerializedName("load_more_mode")
    private final int mode;

    @SerializedName("reverse_size_on_loss")
    private boolean reverseSizeOnLoss;

    @SerializedName("reverse_size_on_net_quality")
    private boolean reverseSizeOnNetQuality;

    @SerializedName("room_check_on_loss_enable")
    private boolean roomCheckOnLossEnable;

    @SerializedName("smart_prefetch_size")
    private int smartPrefetchSize;

    @SerializedName("loss_weight")
    private float weightOfLoss;

    @SerializedName("net_quality_weight")
    private float weightOfNetQuality;

    public final boolean h() {
        if (this.mode == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean i() {
        if (this.mode != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean j() {
        if (this.mode != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean k() {
        if (this.mode == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public a0() {
        this.smartPrefetchSize = 2;
        this.weightOfNetQuality = 0.6f;
        this.weightOfLoss = 0.4f;
    }

    public final int a() {
        return this.mode;
    }

    public final boolean b() {
        return this.reverseSizeOnLoss;
    }

    public final boolean c() {
        return this.reverseSizeOnNetQuality;
    }

    public final boolean d() {
        return this.roomCheckOnLossEnable;
    }

    public final int e() {
        return this.smartPrefetchSize;
    }

    public final float f() {
        return this.weightOfLoss;
    }

    public final float g() {
        return this.weightOfNetQuality;
    }
}
