package fx0;

import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.x2;

/* JADX INFO: loaded from: classes47.dex */
public final class l extends com.bytedance.ies.web.jsbridge2.f<a, Object> {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0014"}, d2 = {"Lfx0/l$a;", "", "", "previousGiftId", "J", "c", "()J", "previousGiftMoney", "d", "previousPayMoney", "f", "moneyDiff", "b", "", "previousGiftType", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "availableDiamond", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        @SerializedName(DyVerifyReqConstants.Value.DIAMOND)
        private final long availableDiamond;

        @SerializedName("money_diff")
        private final long moneyDiff;

        @SerializedName("previous_gift_id")
        private final long previousGiftId;

        @SerializedName("previous_gift_money")
        private final long previousGiftMoney;

        @SerializedName("previous_gift_type")
        private final String previousGiftType;

        @SerializedName("previous_pay_money")
        private final long previousPayMoney;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L18;
            a r101 = (a) r100;
            if (this.previousGiftId == r101.previousGiftId) goto L8;
            return false;
        L8:
            if (this.previousGiftMoney == r101.previousGiftMoney) goto L10;
            return false;
        L10:
            if (this.previousPayMoney == r101.previousPayMoney) goto L12;
            return false;
        L12:
            if (this.moneyDiff == r101.moneyDiff) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.previousGiftType, r101.previousGiftType) == true) goto L16;
            return false;
        L16:
            if (this.availableDiamond == r101.availableDiamond) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            long r100 = this.previousGiftId;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.previousGiftMoney;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = this.previousPayMoney;
            int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
            long r106 = this.moneyDiff;
            int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
            String r108 = this.previousGiftType;
            if (r108 == null) goto L5;
            int r109 = r108.hashCode();
        L6:
            long r110 = this.availableDiamond;
            return ((r107 + r109) * 31) + ((int) (r110 ^ (r110 >>> 32)));
        L5:
            r109 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(previousGiftId=" + this.previousGiftId + ", previousGiftMoney=" + this.previousGiftMoney + ", previousPayMoney=" + this.previousPayMoney + ", moneyDiff=" + this.moneyDiff + ", previousGiftType=" + this.previousGiftType + ", availableDiamond=" + this.availableDiamond + ")";
        }

        public a() {
            Intrinsics.checkNotNullParameter("", "previousGiftType");
            this.previousGiftId = 0;
            this.previousGiftMoney = 0;
            this.previousPayMoney = 0;
            this.moneyDiff = 0;
            this.previousGiftType = "";
            this.availableDiamond = 0;
        }

        public final long a() {
            return this.availableDiamond;
        }

        public final long b() {
            return this.moneyDiff;
        }

        public final long c() {
            return this.previousGiftId;
        }

        public final long d() {
            return this.previousGiftMoney;
        }

        public final String e() {
            return this.previousGiftType;
        }

        public final long f() {
            return this.previousPayMoney;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public l() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(a r110, CallContext r111) {
        a r100 = r110;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        x2 r101 = new x2("", "", r100.c(), r100.d(), r100.f(), r100.b(), r100.e(), r100.a(), true);
        xs2.b.a().post(new HorizontalPlayEvent(1, HorizontalPlayEvent.SOURCE_FOR_LIVE_RECHARGE, r101));
        finishWithSuccess();
    }
}
