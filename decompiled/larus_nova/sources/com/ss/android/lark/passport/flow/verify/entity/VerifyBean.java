package com.ss.android.lark.passport.flow.verify.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.passport.flow.core.security.RsaInfo;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B»\u0001\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\u001c\b\u0003\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\fHÆ\u0003J\u001d\u0010@\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0018HÆ\u0003JÂ\u0001\u0010A\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\f2\u001c\b\u0003\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0018HÆ\u0001¢\u0006\u0002\u0010BJ\u0013\u0010C\u001a\u00020\u00072\b\u0010D\u001a\u0004\u0018\u00010EHÖ\u0003J\t\u0010F\u001a\u00020GHÖ\u0001J\t\u0010H\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001cR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b.\u0010&R%\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0018¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u00101\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b1\u00102¨\u0006I"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;", "Ljava/io/Serializable;", "title", "", "subTitle", "flowType", "disabled", "", "disabledToastText", "inputBox", "Lcom/ss/android/lark/passport/flow/verify/entity/InputBean;", "nextButton", "Lcom/ss/android/lark/passport/flow/verify/entity/ButtonBean;", "retrieveButton", "switchButton", "Lcom/ss/android/lark/passport/flow/verify/entity/SwitchButton;", "rsaInfo", "Lcom/ss/android/lark/passport/flow/core/security/RsaInfo;", "regExp", "formatErrText", "sendMoButton", "moTextList", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/passport/flow/verify/entity/MoTextBean;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/ss/android/lark/passport/flow/verify/entity/InputBean;Lcom/ss/android/lark/passport/flow/verify/entity/ButtonBean;Lcom/ss/android/lark/passport/flow/verify/entity/ButtonBean;Lcom/ss/android/lark/passport/flow/verify/entity/SwitchButton;Lcom/ss/android/lark/passport/flow/core/security/RsaInfo;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/passport/flow/verify/entity/ButtonBean;Ljava/util/ArrayList;)V", "getTitle", "()Ljava/lang/String;", "getSubTitle", "getFlowType", "getDisabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDisabledToastText", "getInputBox", "()Lcom/ss/android/lark/passport/flow/verify/entity/InputBean;", "getNextButton", "()Lcom/ss/android/lark/passport/flow/verify/entity/ButtonBean;", "getRetrieveButton", "getSwitchButton", "()Lcom/ss/android/lark/passport/flow/verify/entity/SwitchButton;", "getRsaInfo", "()Lcom/ss/android/lark/passport/flow/core/security/RsaInfo;", "getRegExp", "getFormatErrText", "getSendMoButton", "getMoTextList", "()Ljava/util/ArrayList;", "isIntercepted", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/ss/android/lark/passport/flow/verify/entity/InputBean;Lcom/ss/android/lark/passport/flow/verify/entity/ButtonBean;Lcom/ss/android/lark/passport/flow/verify/entity/ButtonBean;Lcom/ss/android/lark/passport/flow/verify/entity/SwitchButton;Lcom/ss/android/lark/passport/flow/core/security/RsaInfo;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/passport/flow/verify/entity/ButtonBean;Ljava/util/ArrayList;)Lcom/ss/android/lark/passport/flow/verify/entity/VerifyBean;", "equals", "other", "", "hashCode", "", "toString", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VerifyBean implements Serializable {
    private final Boolean disabled;
    private final String disabledToastText;
    private final String flowType;
    private final String formatErrText;
    private final InputBean inputBox;
    private final ArrayList<MoTextBean> moTextList;
    private final ButtonBean nextButton;
    private final String regExp;
    private final ButtonBean retrieveButton;
    private final RsaInfo rsaInfo;
    private final ButtonBean sendMoButton;
    private final String subTitle;
    private final SwitchButton switchButton;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VerifyBean copy$default(VerifyBean r110, String r111, String r112, String r113, Boolean r114, String r210, InputBean r211, ButtonBean r212, ButtonBean r213, SwitchButton r214, RsaInfo r215, String r216, String r217, ButtonBean r218, ArrayList r219, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        String r100 = r110.title;
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r101 = r110.subTitle;
    L11:
        if ((r310 & 4) == 0) goto L13;
        String r102 = r110.flowType;
    L15:
        if ((r310 & 8) == 0) goto L17;
        Boolean r103 = r110.disabled;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r104 = r110.disabledToastText;
    L23:
        if ((r310 & 32) == 0) goto L25;
        InputBean r105 = r110.inputBox;
    L27:
        if ((r310 & 64) == 0) goto L29;
        ButtonBean r106 = r110.nextButton;
    L31:
        if ((r310 & 128) == 0) goto L33;
        ButtonBean r107 = r110.retrieveButton;
    L35:
        if ((r310 & 256) == 0) goto L37;
        SwitchButton r115 = r110.switchButton;
    L39:
        if ((r310 & 512) == 0) goto L41;
        RsaInfo r116 = r110.rsaInfo;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        String r117 = r110.regExp;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        String r118 = r110.formatErrText;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        ButtonBean r119 = r110.sendMoButton;
    L55:
        if ((r310 & 8192) == 0) goto L57;
        ArrayList r108 = r110.moTextList;
    L59:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r115, r116, r117, r118, r119, r108);
    L57:
        r108 = r219;
        goto L59
    L53:
        r119 = r218;
        goto L55
    L49:
        r118 = r217;
        goto L51
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r107 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.title;
    }

    public final RsaInfo component10() {
        return this.rsaInfo;
    }

    public final String component11() {
        return this.regExp;
    }

    public final String component12() {
        return this.formatErrText;
    }

    public final ButtonBean component13() {
        return this.sendMoButton;
    }

    public final ArrayList<MoTextBean> component14() {
        return this.moTextList;
    }

    public final String component2() {
        return this.subTitle;
    }

    public final String component3() {
        return this.flowType;
    }

    public final Boolean component4() {
        return this.disabled;
    }

    public final String component5() {
        return this.disabledToastText;
    }

    public final InputBean component6() {
        return this.inputBox;
    }

    public final ButtonBean component7() {
        return this.nextButton;
    }

    public final ButtonBean component8() {
        return this.retrieveButton;
    }

    public final SwitchButton component9() {
        return this.switchButton;
    }

    public final VerifyBean copy(@JSONField(name = "title") String r110, @JSONField(name = "subtitle") String r111, @JSONField(name = "flow_type") String r112, @JSONField(name = "disabled") Boolean r210, @JSONField(name = "disabled_toast_text") String r211, @JSONField(name = "input_box") InputBean r212, @JSONField(name = "next_button") ButtonBean r213, @JSONField(name = "retrieve_button") ButtonBean r214, @JSONField(name = "switch_button") SwitchButton r215, @JSONField(name = "rsa_info") RsaInfo r216, @JSONField(name = "reg_exp") String r217, @JSONField(name = "format_err_text") String r218, @JSONField(name = "send_mo_button") ButtonBean r219, @JSONField(name = "mo_text") ArrayList<MoTextBean> r310) {
        Intrinsics.checkNotNullParameter(r110, "title");
        Intrinsics.checkNotNullParameter(r111, "subTitle");
        Intrinsics.checkNotNullParameter(r112, "flowType");
        return new VerifyBean(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VerifyBean) == true) goto L8;
        return false;
    L8:
        VerifyBean r101 = (VerifyBean) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.subTitle, r101.subTitle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.flowType, r101.flowType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.disabled, r101.disabled) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.disabledToastText, r101.disabledToastText) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.inputBox, r101.inputBox) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.nextButton, r101.nextButton) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.retrieveButton, r101.retrieveButton) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.switchButton, r101.switchButton) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.rsaInfo, r101.rsaInfo) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.regExp, r101.regExp) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.formatErrText, r101.formatErrText) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.sendMoButton, r101.sendMoButton) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.moTextList, r101.moTextList) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.title.hashCode() * 31) + this.subTitle.hashCode()) * 31) + this.flowType.hashCode()) * 31;
        Boolean r101 = this.disabled;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.disabledToastText;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        InputBean r108 = this.inputBox;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        ButtonBean r111 = this.nextButton;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        ButtonBean r114 = this.retrieveButton;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        SwitchButton r117 = this.switchButton;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        RsaInfo r120 = this.rsaInfo;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        String r123 = this.regExp;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        String r126 = this.formatErrText;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        ButtonBean r129 = this.sendMoButton;
        if (r129 != null) goto L41;
        int r130 = 0;
    L42:
        int r131 = (r128 + r130) * 31;
        ArrayList<MoTextBean> r132 = this.moTextList;
        if (r132 == null) goto L47;
        r102 = r132.hashCode();
    L47:
        return r131 + r102;
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
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "VerifyBean(title=" + this.title + ", subTitle=" + this.subTitle + ", flowType=" + this.flowType + ", disabled=" + this.disabled + ", disabledToastText=" + this.disabledToastText + ", inputBox=" + this.inputBox + ", nextButton=" + this.nextButton + ", retrieveButton=" + this.retrieveButton + ", switchButton=" + this.switchButton + ", rsaInfo=" + this.rsaInfo + ", regExp=" + this.regExp + ", formatErrText=" + this.formatErrText + ", sendMoButton=" + this.sendMoButton + ", moTextList=" + this.moTextList + ')';
    }

    public final boolean isIntercepted() {
        return Intrinsics.areEqual(this.disabled, Boolean.TRUE);
    }

    public final Boolean getDisabled() {
        return this.disabled;
    }

    public final String getDisabledToastText() {
        return this.disabledToastText;
    }

    public final String getFlowType() {
        return this.flowType;
    }

    public final String getFormatErrText() {
        return this.formatErrText;
    }

    public final InputBean getInputBox() {
        return this.inputBox;
    }

    public final ArrayList<MoTextBean> getMoTextList() {
        return this.moTextList;
    }

    public final ButtonBean getNextButton() {
        return this.nextButton;
    }

    public final String getRegExp() {
        return this.regExp;
    }

    public final ButtonBean getRetrieveButton() {
        return this.retrieveButton;
    }

    public final RsaInfo getRsaInfo() {
        return this.rsaInfo;
    }

    public final ButtonBean getSendMoButton() {
        return this.sendMoButton;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final SwitchButton getSwitchButton() {
        return this.switchButton;
    }

    public final String getTitle() {
        return this.title;
    }

    public VerifyBean(@JSONField(name = "title") String r100, @JSONField(name = "subtitle") String r101, @JSONField(name = "flow_type") String r102, @JSONField(name = "disabled") Boolean r103, @JSONField(name = "disabled_toast_text") String r104, @JSONField(name = "input_box") InputBean r105, @JSONField(name = "next_button") ButtonBean r106, @JSONField(name = "retrieve_button") ButtonBean r107, @JSONField(name = "switch_button") SwitchButton r110, @JSONField(name = "rsa_info") RsaInfo r111, @JSONField(name = "reg_exp") String r112, @JSONField(name = "format_err_text") String r113, @JSONField(name = "send_mo_button") ButtonBean r114, @JSONField(name = "mo_text") ArrayList<MoTextBean> r115) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "subTitle");
        Intrinsics.checkNotNullParameter(r102, "flowType");
        this.title = r100;
        this.subTitle = r101;
        this.flowType = r102;
        this.disabled = r103;
        this.disabledToastText = r104;
        this.inputBox = r105;
        this.nextButton = r106;
        this.retrieveButton = r107;
        this.switchButton = r110;
        this.rsaInfo = r111;
        this.regExp = r112;
        this.formatErrText = r113;
        this.sendMoButton = r114;
        this.moTextList = r115;
    }

    public /* synthetic */ VerifyBean(String r110, String r210, String r211, Boolean r212, String r213, InputBean r214, ButtonBean r215, ButtonBean r216, SwitchButton r217, RsaInfo r218, String r219, String r310, ButtonBean r311, ArrayList r312, int r313, DefaultConstructorMarker r314) {
        if ((r313 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r313 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r313 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r313 & 8) == 0) goto L17;
        Boolean r103 = null;
    L19:
        if ((r313 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r313 & 1024) == 0) goto L25;
        String r111 = "";
    L27:
        if ((r313 & 2048) == 0) goto L29;
        String r112 = "";
    L31:
        if ((r313 & 8192) == 0) goto L33;
        ArrayList r113 = new ArrayList();
    L34:
        this(r100, r101, r102, r103, r104, r214, r215, r216, r217, r218, r111, r112, r311, r113);
        return;
    L33:
        r113 = r312;
        goto L34
    L29:
        r112 = r310;
        goto L31
    L25:
        r111 = r219;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
