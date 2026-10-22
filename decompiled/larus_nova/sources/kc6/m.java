package kc6;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkc6/m;", "", "", "comboNum", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "", "token", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.kmp.dialog.GiftComboInfo")
public final class m {

    @SerializedName("combo_num")
    private final int comboNum;

    @SerializedName("token")
    private final String token;

    public final int a() {
        return this.comboNum;
    }

    public final String b() {
        return this.token;
    }

    public m(int r100, String r101) {
        this.comboNum = r100;
        this.token = r101;
    }
}
