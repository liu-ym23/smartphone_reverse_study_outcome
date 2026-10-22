package com.ss.android.lark.passport.flow.verify.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003JD\u0010\u001c\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0006HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0011\u0010\u0015\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/entity/AuthMethod;", "Ljava/io/Serializable;", "text", "", SocialConstants.PARAM_APP_DESC, ReportConstant.COMMON_ACTION_TYPE, "", "disabled", "", "disabledToastText", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "getDesc", "getActionType", "()I", "getDisabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDisabledToastText", "isIntercepted", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;Ljava/lang/String;)Lcom/ss/android/lark/passport/flow/verify/entity/AuthMethod;", "equals", "other", "", "hashCode", "toString", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthMethod implements Serializable {
    private final int actionType;
    private final String desc;
    private final Boolean disabled;
    private final String disabledToastText;
    private final String text;

    public AuthMethod() {
        this(null, null, 0, null, null, 31, null);
    }

    public static /* synthetic */ AuthMethod copy$default(AuthMethod r100, String r101, String r102, int r103, Boolean r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.desc;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.actionType;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.disabled;
    L14:
        Boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.disabledToastText;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.desc;
    }

    public final int component3() {
        return this.actionType;
    }

    public final Boolean component4() {
        return this.disabled;
    }

    public final String component5() {
        return this.disabledToastText;
    }

    public final AuthMethod copy(@JSONField(name = "text") String r100, @JSONField(name = SocialConstants.PARAM_APP_DESC) String r101, @JSONField(name = "action_type") int r110, @JSONField(name = "disabled") Boolean r111, @JSONField(name = "disabled_toast_text") String r112) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
        return new AuthMethod(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AuthMethod) == true) goto L8;
        return false;
    L8:
        AuthMethod r101 = (AuthMethod) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L15;
        return false;
    L15:
        if (this.actionType == r101.actionType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.disabled, r101.disabled) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.disabledToastText, r101.disabledToastText) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.text.hashCode() * 31) + this.desc.hashCode()) * 31) + this.actionType) * 31;
        Boolean r101 = this.disabled;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.disabledToastText;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "AuthMethod(text=" + this.text + ", desc=" + this.desc + ", actionType=" + this.actionType + ", disabled=" + this.disabled + ", disabledToastText=" + this.disabledToastText + ')';
    }

    public final boolean isIntercepted() {
        return Intrinsics.areEqual(this.disabled, Boolean.TRUE);
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final Boolean getDisabled() {
        return this.disabled;
    }

    public final String getDisabledToastText() {
        return this.disabledToastText;
    }

    public final String getText() {
        return this.text;
    }

    public AuthMethod(@JSONField(name = "text") String r100, @JSONField(name = SocialConstants.PARAM_APP_DESC) String r101, @JSONField(name = "action_type") int r102, @JSONField(name = "disabled") Boolean r103, @JSONField(name = "disabled_toast_text") String r104) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
        this.text = r100;
        this.desc = r101;
        this.actionType = r102;
        this.disabled = r103;
        this.disabledToastText = r104;
    }

    public /* synthetic */ AuthMethod(String r100, String r101, int r102, Boolean r103, String r104, int r105, DefaultConstructorMarker r110) {
        String r106 = "";
        if ((r105 & 1) == 0) goto L5;
        String r111 = "";
    L7:
        if ((r105 & 2) != 0) goto L11;
        r106 = r101;
    L11:
        if ((r105 & 4) == 0) goto L13;
        int r107 = 0;
    L15:
        if ((r105 & 8) == 0) goto L17;
        Boolean r108 = null;
    L19:
        if ((r105 & 16) == 0) goto L21;
        String r109 = null;
    L22:
        this(r111, r106, r107, r108, r109);
        return;
    L21:
        r109 = r104;
        goto L22
    L17:
        r108 = r103;
        goto L19
    L13:
        r107 = r102;
        goto L15
    L5:
        r111 = r100;
        goto L7
    }
}
