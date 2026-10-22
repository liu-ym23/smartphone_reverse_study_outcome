package kc6;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000bR\u001a\u0010\u0013\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkc6/x;", "", "Lcom/bytedance/android/livesdk/gift/model/h1;", PbRequest.SwitchType.GIFT, "Lcom/bytedance/android/livesdk/gift/model/h1;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/gift/model/h1;", "", "buffLevel", "I", "getBuffLevel", "()I", "", "defaultJumpScheme", "Ljava/lang/String;", "getDefaultJumpScheme", "()Ljava/lang/String;", "locationTabPosition", "getLocationTabPosition", "locationGiftPosition", "getLocationGiftPosition", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.kmp.dialog.LocationInfo")
public final class x {

    @SerializedName("default_buff_level")
    private final int buffLevel;

    @SerializedName("default_jump_scheme")
    private final String defaultJumpScheme;

    @SerializedName("default_location_gift")
    private final h1 gift;

    @SerializedName("location_gift_position")
    private final int locationGiftPosition;

    @SerializedName("location_tab_position")
    private final int locationTabPosition;

    public final h1 a() {
        return this.gift;
    }

    public x(h1 r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter("", "defaultJumpScheme");
        this.gift = r100;
        this.buffLevel = r101;
        this.defaultJumpScheme = "";
        this.locationTabPosition = r102;
        this.locationGiftPosition = r103;
    }
}
