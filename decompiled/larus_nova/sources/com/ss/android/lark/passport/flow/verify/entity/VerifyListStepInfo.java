package com.ss.android.lark.passport.flow.verify.entity;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÁ\u0001\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0003\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003JÃ\u0001\u0010<\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0003\u0010\u0015\u001a\u00020\u0005HÆ\u0001J\u0013\u0010=\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010?HÖ\u0003J\t\u0010@\u001a\u00020AHÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001b¨\u0006C"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/entity/VerifyListStepInfo;", "Ljava/io/Serializable;", "defaultVerifyItem", "", "enableClientLoginMemory", "", "verifyFido", "Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;", "verifyMobileCode", "verifyEmailCode", "verifySpare", "verifyOtp", "verifyMo", "verifyPwd", "verifyQr", "verifyGoogle", "verifyApple", "verifySSO", "verifyDoubao", "authMethods", "Lcom/ss/android/lark/passport/flow/verify/entity/AuthMethodList;", "usePackageDomain", "<init>", "(Ljava/lang/String;ZLcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;Lcom/ss/android/lark/passport/flow/verify/entity/AuthMethodList;Z)V", "getDefaultVerifyItem", "()Ljava/lang/String;", "getEnableClientLoginMemory", "()Z", "getVerifyFido", "()Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;", "getVerifyMobileCode", "getVerifyEmailCode", "getVerifySpare", "getVerifyOtp", "getVerifyMo", "getVerifyPwd", "getVerifyQr", "getVerifyGoogle", "getVerifyApple", "getVerifySSO", "getVerifyDoubao", "getAuthMethods", "()Lcom/ss/android/lark/passport/flow/verify/entity/AuthMethodList;", "getUsePackageDomain", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "other", "", "hashCode", "", "toString", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VerifyListStepInfo implements Serializable {
    private final AuthMethodList authMethods;
    private final String defaultVerifyItem;
    private final boolean enableClientLoginMemory;
    private final boolean usePackageDomain;
    private final VerifyBean verifyApple;
    private final VerifyBean verifyDoubao;
    private final VerifyBean verifyEmailCode;
    private final VerifyBean verifyFido;
    private final VerifyBean verifyGoogle;
    private final VerifyBean verifyMo;
    private final VerifyBean verifyMobileCode;
    private final VerifyBean verifyOtp;
    private final VerifyBean verifyPwd;
    private final VerifyBean verifyQr;
    private final VerifyBean verifySSO;
    private final VerifyBean verifySpare;

    public static /* synthetic */ VerifyListStepInfo copy$default(VerifyListStepInfo r110, String r111, boolean r112, VerifyBean r210, VerifyBean r211, VerifyBean r212, VerifyBean r213, VerifyBean r214, VerifyBean r215, VerifyBean r216, VerifyBean r217, VerifyBean r218, VerifyBean r219, VerifyBean r310, VerifyBean r311, AuthMethodList r312, boolean r313, int r314, Object r315) {
        if ((r314 & 1) == 0) goto L5;
        String r100 = r110.defaultVerifyItem;
    L7:
        if ((r314 & 2) == 0) goto L9;
        boolean r101 = r110.enableClientLoginMemory;
    L11:
        if ((r314 & 4) == 0) goto L13;
        VerifyBean r102 = r110.verifyFido;
    L15:
        if ((r314 & 8) == 0) goto L17;
        VerifyBean r103 = r110.verifyMobileCode;
    L19:
        if ((r314 & 16) == 0) goto L21;
        VerifyBean r104 = r110.verifyEmailCode;
    L23:
        if ((r314 & 32) == 0) goto L25;
        VerifyBean r105 = r110.verifySpare;
    L27:
        if ((r314 & 64) == 0) goto L29;
        VerifyBean r106 = r110.verifyOtp;
    L31:
        if ((r314 & 128) == 0) goto L33;
        VerifyBean r107 = r110.verifyMo;
    L35:
        if ((r314 & 256) == 0) goto L37;
        VerifyBean r113 = r110.verifyPwd;
    L39:
        if ((r314 & 512) == 0) goto L41;
        VerifyBean r114 = r110.verifyQr;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        VerifyBean r115 = r110.verifyGoogle;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        VerifyBean r116 = r110.verifyApple;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        VerifyBean r117 = r110.verifySSO;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        VerifyBean r118 = r110.verifyDoubao;
    L58:
        VerifyBean r316 = r118;
        if ((r314 & 16384) == 0) goto L61;
        AuthMethodList r119 = r110.authMethods;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        boolean r108 = r110.usePackageDomain;
    L67:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r316, r119, r108);
    L65:
        r108 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L63
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.defaultVerifyItem;
    }

    public final VerifyBean component10() {
        return this.verifyQr;
    }

    public final VerifyBean component11() {
        return this.verifyGoogle;
    }

    public final VerifyBean component12() {
        return this.verifyApple;
    }

    public final VerifyBean component13() {
        return this.verifySSO;
    }

    public final VerifyBean component14() {
        return this.verifyDoubao;
    }

    public final AuthMethodList component15() {
        return this.authMethods;
    }

    public final boolean component16() {
        return this.usePackageDomain;
    }

    public final boolean component2() {
        return this.enableClientLoginMemory;
    }

    public final VerifyBean component3() {
        return this.verifyFido;
    }

    public final VerifyBean component4() {
        return this.verifyMobileCode;
    }

    public final VerifyBean component5() {
        return this.verifyEmailCode;
    }

    public final VerifyBean component6() {
        return this.verifySpare;
    }

    public final VerifyBean component7() {
        return this.verifyOtp;
    }

    public final VerifyBean component8() {
        return this.verifyMo;
    }

    public final VerifyBean component9() {
        return this.verifyPwd;
    }

    public final VerifyListStepInfo copy(@JSONField(name = "default_verify_item") String r210, @JSONField(name = "enable_client_login_method_memory") boolean r211, @JSONField(name = "verify_fido") VerifyBean r212, @JSONField(name = "verify_code_mobile") VerifyBean r213, @JSONField(name = "verify_code_email") VerifyBean r214, @JSONField(name = "verify_code_spare") VerifyBean r215, @JSONField(name = "verify_otp") VerifyBean r216, @JSONField(name = "verify_mo") VerifyBean r217, @JSONField(name = "verify_pwd") VerifyBean r218, @JSONField(name = "verify_qr") VerifyBean r219, @JSONField(name = "verify_google") VerifyBean r310, @JSONField(name = "verify_apple") VerifyBean r311, @JSONField(name = "verify_b_idp") VerifyBean r312, @JSONField(name = "verify_dou_bao") VerifyBean r313, @JSONField(name = "verify_authn_methods") AuthMethodList r314, @JSONField(name = "use_package_domain") boolean r315) {
        Intrinsics.checkNotNullParameter(r210, "defaultVerifyItem");
        return new VerifyListStepInfo(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VerifyListStepInfo) == true) goto L8;
        return false;
    L8:
        VerifyListStepInfo r101 = (VerifyListStepInfo) r100;
        if (Intrinsics.areEqual(this.defaultVerifyItem, r101.defaultVerifyItem) == true) goto L12;
        return false;
    L12:
        if (this.enableClientLoginMemory == r101.enableClientLoginMemory) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.verifyFido, r101.verifyFido) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.verifyMobileCode, r101.verifyMobileCode) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.verifyEmailCode, r101.verifyEmailCode) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.verifySpare, r101.verifySpare) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.verifyOtp, r101.verifyOtp) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.verifyMo, r101.verifyMo) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.verifyPwd, r101.verifyPwd) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.verifyQr, r101.verifyQr) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.verifyGoogle, r101.verifyGoogle) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.verifyApple, r101.verifyApple) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.verifySSO, r101.verifySSO) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.verifyDoubao, r101.verifyDoubao) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.authMethods, r101.authMethods) == true) goto L54;
        return false;
    L54:
        if (this.usePackageDomain == r101.usePackageDomain) goto L56;
        return false;
    L56:
        return true;
    }

    public int hashCode() {
        int r100 = this.defaultVerifyItem.hashCode() * 31;
        int r101 = 1231;
        if (this.enableClientLoginMemory == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        VerifyBean r104 = this.verifyFido;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r103 + r106) * 31;
        VerifyBean r108 = this.verifyMobileCode;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        VerifyBean r111 = this.verifyEmailCode;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        VerifyBean r114 = this.verifySpare;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        VerifyBean r117 = this.verifyOtp;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        VerifyBean r120 = this.verifyMo;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        VerifyBean r123 = this.verifyPwd;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        VerifyBean r126 = this.verifyQr;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        VerifyBean r129 = this.verifyGoogle;
        if (r129 != null) goto L41;
        int r130 = 0;
    L42:
        int r131 = (r128 + r130) * 31;
        VerifyBean r132 = this.verifyApple;
        if (r132 != null) goto L45;
        int r133 = 0;
    L46:
        int r134 = (r131 + r133) * 31;
        VerifyBean r135 = this.verifySSO;
        if (r135 != null) goto L49;
        int r136 = 0;
    L50:
        int r137 = (r134 + r136) * 31;
        VerifyBean r138 = this.verifyDoubao;
        if (r138 != null) goto L53;
        int r139 = 0;
    L54:
        int r140 = (r137 + r139) * 31;
        AuthMethodList r141 = this.authMethods;
        if (r141 == null) goto L58;
        r105 = r141.hashCode();
    L58:
        int r142 = (r140 + r105) * 31;
        if (this.usePackageDomain == true) goto L63;
        r101 = 1237;
    L63:
        return r142 + r101;
    L53:
        r139 = r138.hashCode();
        goto L54
    L49:
        r136 = r135.hashCode();
        goto L50
    L45:
        r133 = r132.hashCode();
        goto L46
    L41:
        r130 = r129.hashCode();
        goto L42
    L37:
        r127 = r126.hashCode();
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "VerifyListStepInfo(defaultVerifyItem=" + this.defaultVerifyItem + ", enableClientLoginMemory=" + this.enableClientLoginMemory + ", verifyFido=" + this.verifyFido + ", verifyMobileCode=" + this.verifyMobileCode + ", verifyEmailCode=" + this.verifyEmailCode + ", verifySpare=" + this.verifySpare + ", verifyOtp=" + this.verifyOtp + ", verifyMo=" + this.verifyMo + ", verifyPwd=" + this.verifyPwd + ", verifyQr=" + this.verifyQr + ", verifyGoogle=" + this.verifyGoogle + ", verifyApple=" + this.verifyApple + ", verifySSO=" + this.verifySSO + ", verifyDoubao=" + this.verifyDoubao + ", authMethods=" + this.authMethods + ", usePackageDomain=" + this.usePackageDomain + ')';
    }

    public final AuthMethodList getAuthMethods() {
        return this.authMethods;
    }

    public final String getDefaultVerifyItem() {
        return this.defaultVerifyItem;
    }

    public final boolean getEnableClientLoginMemory() {
        return this.enableClientLoginMemory;
    }

    public final boolean getUsePackageDomain() {
        return this.usePackageDomain;
    }

    public final VerifyBean getVerifyApple() {
        return this.verifyApple;
    }

    public final VerifyBean getVerifyDoubao() {
        return this.verifyDoubao;
    }

    public final VerifyBean getVerifyEmailCode() {
        return this.verifyEmailCode;
    }

    public final VerifyBean getVerifyFido() {
        return this.verifyFido;
    }

    public final VerifyBean getVerifyGoogle() {
        return this.verifyGoogle;
    }

    public final VerifyBean getVerifyMo() {
        return this.verifyMo;
    }

    public final VerifyBean getVerifyMobileCode() {
        return this.verifyMobileCode;
    }

    public final VerifyBean getVerifyOtp() {
        return this.verifyOtp;
    }

    public final VerifyBean getVerifyPwd() {
        return this.verifyPwd;
    }

    public final VerifyBean getVerifyQr() {
        return this.verifyQr;
    }

    public final VerifyBean getVerifySSO() {
        return this.verifySSO;
    }

    public final VerifyBean getVerifySpare() {
        return this.verifySpare;
    }

    public VerifyListStepInfo(@JSONField(name = "default_verify_item") String r100, @JSONField(name = "enable_client_login_method_memory") boolean r101, @JSONField(name = "verify_fido") VerifyBean r102, @JSONField(name = "verify_code_mobile") VerifyBean r103, @JSONField(name = "verify_code_email") VerifyBean r104, @JSONField(name = "verify_code_spare") VerifyBean r105, @JSONField(name = "verify_otp") VerifyBean r110, @JSONField(name = "verify_mo") VerifyBean r111, @JSONField(name = "verify_pwd") VerifyBean r112, @JSONField(name = "verify_qr") VerifyBean r113, @JSONField(name = "verify_google") VerifyBean r114, @JSONField(name = "verify_apple") VerifyBean r115, @JSONField(name = "verify_b_idp") VerifyBean r116, @JSONField(name = "verify_dou_bao") VerifyBean r117, @JSONField(name = "verify_authn_methods") AuthMethodList r118, @JSONField(name = "use_package_domain") boolean r119) {
        Intrinsics.checkNotNullParameter(r100, "defaultVerifyItem");
        this.defaultVerifyItem = r100;
        this.enableClientLoginMemory = r101;
        this.verifyFido = r102;
        this.verifyMobileCode = r103;
        this.verifyEmailCode = r104;
        this.verifySpare = r105;
        this.verifyOtp = r110;
        this.verifyMo = r111;
        this.verifyPwd = r112;
        this.verifyQr = r113;
        this.verifyGoogle = r114;
        this.verifyApple = r115;
        this.verifySSO = r116;
        this.verifyDoubao = r117;
        this.authMethods = r118;
        this.usePackageDomain = r119;
    }

    public /* synthetic */ VerifyListStepInfo(String r110, boolean r210, VerifyBean r211, VerifyBean r212, VerifyBean r213, VerifyBean r214, VerifyBean r215, VerifyBean r216, VerifyBean r217, VerifyBean r218, VerifyBean r219, VerifyBean r310, VerifyBean r311, VerifyBean r312, AuthMethodList r313, boolean r314, int r315, DefaultConstructorMarker r316) {
        if ((r315 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r315 & 2) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r315 & 32768) == 0) goto L13;
        boolean r111 = false;
    L14:
        this(r100, r101, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r111);
        return;
    L13:
        r111 = r314;
        goto L14
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
