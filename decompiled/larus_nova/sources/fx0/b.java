package fx0;

import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.exchange.trace.ExchangeTraceGiftSource;
import com.bytedance.android.live.recharge.model.ExchangeType;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
@XBridgeMethod(biz = "webcast", name = "showIncomeExchangeDialog")
public final class b extends com.bytedance.ies.web.jsbridge2.f<C5959b, c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f479053b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f479054a;

    public static final class a {
    }

    /* JADX INFO: renamed from: fx0.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lfx0/b$b;", "", "", DyVerifyReqConstants.Value.DIAMOND, "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "setDiamond", "(Ljava/lang/Long;)V", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "topImage", "b", "setTopImage", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class C5959b {

        @SerializedName(DyVerifyReqConstants.Value.DIAMOND)
        private Long diamond;

        @SerializedName("topImage")
        private String topImage;

        @SerializedName("type")
        private String type;

        public C5959b() {
        }

        public final Long a() {
            return this.diamond;
        }

        public final String b() {
            return this.topImage;
        }

        public final String getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lfx0/b$c;", "", "", "result", "Ljava/lang/String;", "getResult", "()Ljava/lang/String;", "setResult", "(Ljava/lang/String;)V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class c {

        @SerializedName("result")
        private String result;

        public final void setResult(String r100) {
            this.result = r100;
        }

        public c(int r100, Throwable r101) {
            if ((r101 instanceof ApiServerException) == false) goto L5;
            String r102 = String.valueOf(((ApiServerException) r101).getErrorCode());
        L6:
            this.result = r102;
            return;
        L5:
            r102 = String.valueOf(r100);
            goto L6
        }
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        Disposable r100 = this.f479054a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L11;
        Disposable r101 = this.f479054a;
        if (r101 == null) goto L12;
        r101.dispose();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onDestroy() {
        super.onDestroy();
        Disposable r100 = this.f479054a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L11;
        Disposable r101 = this.f479054a;
        if (r101 == null) goto L12;
        r101.dispose();
        return;
    L12:
        return;
    }

    public b() {
    }

    /* JADX WARN: Type inference failed for: r9v22, types: [T, com.bytedance.android.live.recharge.exchange.trace.ExchangeTraceGiftSource] */
    /* JADX WARN: Type inference failed for: r9v24, types: [T, com.bytedance.android.live.recharge.exchange.trace.ExchangeTraceGiftSource] */
    /* JADX WARN: Type inference failed for: r9v26, types: [T, com.bytedance.android.live.recharge.exchange.trace.ExchangeTraceGiftSource] */
    /* JADX WARN: Type inference failed for: r9v28, types: [T, com.bytedance.android.live.recharge.exchange.trace.ExchangeTraceGiftSource] */
    /* JADX WARN: Type inference failed for: r9v30, types: [T, com.bytedance.android.live.recharge.exchange.trace.ExchangeTraceGiftSource] */
    /* JADX WARN: Type inference failed for: r9v8, types: [T, com.bytedance.android.live.recharge.exchange.trace.ExchangeTraceGiftSource] */
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(C5959b r100, CallContext r110) {
        C5959b r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r102 = r101.b();
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L14;
        py.k r104 = (py.k) vh7.f.c(py.k.class);
        ArrayList r105 = new ArrayList();
        String r106 = r101.b();
        if (r106 == null) goto L13;
        r105.add(r106);
    L13:
        Unit r107 = Unit.INSTANCE;
        r104.setUrls(r105);
    L15:
        py.k r108 = r104;
        Ref.ObjectRef r109 = new Ref.ObjectRef();
        ?? r111 = ExchangeTraceGiftSource.EXCHANGE_SOURCE_OTHER;
        r109.element = r111;
        String r112 = r101.getType();
        if (r112 != null) goto L19;
    L36:
        r109.element = r111;
        ExchangeType r113 = ExchangeType.EXCHANGE_TYPE_GIFT;
    L37:
        ExchangeType r114 = r113;
        ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().sync("exchange");
        this.f479054a = ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().observeWallet().compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this, r101, r109, r110, r114, r108), new e(this));
        return;
    L19:
        switch(r112.hashCode()) {
            case 49: goto L34;
            case 50: goto L31;
            case 51: goto L28;
            case 52: goto L25;
            case 53: goto L22;
            default: goto L36;
        };
    L22:
        if (r112.equals("5") == false) goto L36;
        r109.element = ExchangeTraceGiftSource.EXCHANGE_SOURCE_LOTTERY_FANS_CLUB;
        r113 = ExchangeType.EXCHANGE_TYPE_LOTTERY_JOIN_FANS;
        goto L37
    L25:
        if (r112.equals("4") == false) goto L36;
        r109.element = ExchangeTraceGiftSource.EXCHANGE_SOURCE_FANS_CLUB_SEND_GIFT;
        r113 = ExchangeType.EXCHANGE_TYPE_FANS_SEND_GIFT;
        goto L37
    L28:
        if (r112.equals("3") == false) goto L36;
        r109.element = ExchangeTraceGiftSource.EXCHANGE_SOURCE_LOTTERY;
        r113 = ExchangeType.EXCHANGE_TYPE_LOTTERY;
        goto L37
    L31:
        if (r112.equals("2") == false) goto L36;
        r109.element = ExchangeTraceGiftSource.EXCHANGE_SOURCE_RED_PACKET;
        r113 = ExchangeType.EXCHANGE_TYPE_RED_PACKET;
        goto L37
    L34:
        if (r112.equals("1") == false) goto L36;
        r109.element = ExchangeTraceGiftSource.EXCHANGE_SOURCE_FANS_CLUB;
        r113 = ExchangeType.EXCHANGE_TYPE_FANS;
        goto L37
    L14:
        r104 = null;
        goto L15
    L5:
        if (StringsKt.isBlank(r102) == true) goto L8;
        r103 = false;
        goto L9
    }
}
