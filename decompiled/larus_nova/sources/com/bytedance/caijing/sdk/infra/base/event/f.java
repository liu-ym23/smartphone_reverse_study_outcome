package com.bytedance.caijing.sdk.infra.base.event;

import com.android.ttcjpaysdk.thirdparty.base.CJPayBaseConstant;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f202351a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, String> f202352b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<String, String> f202353c = null;

    static {
        f202351a = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("ecommerce_pay_desk", "电商"), TuplesKt.to("pre_standard_pay_desk", "前置"), TuplesKt.to("standard_pay_desk", "聚合"), TuplesKt.to("balance_recharge", "充值"), TuplesKt.to("balance_withdraw", "提现"), TuplesKt.to("bind_card", CJPayBaseConstant.CJ_PAY_TYPE_BIND_CARD), TuplesKt.to("outer_pay", "唤端")});
        f202352b = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("/gateway-bytepay/totp_proofread", "指纹校时"), TuplesKt.to("/gateway-bytepay/bytepay/pre_check/", "追光"), TuplesKt.to("/gateway-bytepay/bytepay/cashdesk/", "追光"), TuplesKt.to("/gateway-bytepay/bytepay/member_apply/", "会员"), TuplesKt.to("/gateway-bytepay/bytepay/member_product/", "会员"), TuplesKt.to("/gateway-cashier2/tp/cashier/", "聚合")});
        f202353c = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("PermissionHandlerActivity", "权限申请"), TuplesKt.to("CJPayChooseMediaCallBackActivity", "媒体选择"), TuplesKt.to("CJPayOCRIDCardActivity", "身份证OCR"), TuplesKt.to("CJPayOCRBankCardActivity", "银行卡OCR"), TuplesKt.to("CJPayOCRIdentityActivity", "扫描身份证"), TuplesKt.to("CJPayLargeAmountActivity", "大额支付"), TuplesKt.to("CJPayLynxStandardKeepActivity", "lynx挽留"), TuplesKt.to("CJPayLimitErrorActivity", "限流"), TuplesKt.to("SetPwdActivity", "设密页"), TuplesKt.to("CJPayNewCardActivity", "新卡支付"), TuplesKt.to("AllBankSelectActivity", "支持的银行"), TuplesKt.to("CJPayFrontCardListMethodActivity", ""), TuplesKt.to("CJPayBankCardActivity", "我的银行卡"), TuplesKt.to("CJPayBankCardDetailActivity", "银行卡详情"), TuplesKt.to("CJPayAllBankCardActivity", "全部银行卡"), TuplesKt.to("CJPayCardBinActivity", "卡bin"), TuplesKt.to("CJPayFourElementsSafeActivity", "四要素"), TuplesKt.to("CJPayIDSelectorActivity", "选择证件类型"), TuplesKt.to("CJPayIndependentMainActivity", "独立绑卡"), TuplesKt.to("SelectBankCardType2Activity", "选择卡类型样式2"), TuplesKt.to("TwoElementAuth3Activity", "新二要素"), TuplesKt.to("SmsFullPageActivity", "短信全屏页"), TuplesKt.to("UnionPayTwoElementsActivity", "云闪付二要素"), TuplesKt.to("UnionPayAuthActivity", "云闪付授权"), TuplesKt.to("UnionPayBindCardActivity", "云闪付绑卡列表"), TuplesKt.to("CJPayFaceLiveSignActivity", "活体签约"), TuplesKt.to("CJPayIncomeLynxOpenAccountActivity", "业务收入"), TuplesKt.to("PaymentMethodActivity", "六位密码切卡"), TuplesKt.to("CJPaySecurityLoadingActivity", "安全感loading"), TuplesKt.to("FastPayActivity", "极速支付"), TuplesKt.to("SuperPayVerifyActivity", "极速付加验"), TuplesKt.to("OuterPayDefaultActivity", "唤端错误兜底"), TuplesKt.to("OuterPayLoginContainerActivity", "O唤端登录"), TuplesKt.to("StepUpIFrameActivity", "外卡页")});
    }
}
