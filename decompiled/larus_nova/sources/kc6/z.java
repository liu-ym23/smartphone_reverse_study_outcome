package kc6;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkc6/z;", "", "Lcom/bytedance/android/live/profit/privilege/model/paygrade/a;", "payGrade", "Lcom/bytedance/android/live/profit/privilege/model/paygrade/a;", "getPayGrade", "()Lcom/bytedance/android/live/profit/privilege/model/paygrade/a;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.kmp.dialog.PayGradeInfo")
public final class z {

    @SerializedName("pay_grade")
    private final com.bytedance.android.live.profit.privilege.model.paygrade.a payGrade;
}
