package com.ss.android.lark.passport.flow.verify.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/entity/SwitchButton;", "Ljava/io/Serializable;", "text", "", ReportConstant.COMMON_ACTION_TYPE, "", "<init>", "(Ljava/lang/String;I)V", "getText", "()Ljava/lang/String;", "getActionType", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SwitchButton implements Serializable {
    private final int actionType;
    private final String text;

    /* JADX WARN: Multi-variable type inference failed */
    public SwitchButton() {
        String r100 = null;
        this(r100, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SwitchButton copy$default(SwitchButton r100, String r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.actionType;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.actionType;
    }

    public final SwitchButton copy(@JSONField(name = "text") String r100, @JSONField(name = "action_type") int r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        return new SwitchButton(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SwitchButton) == true) goto L8;
        return false;
    L8:
        SwitchButton r101 = (SwitchButton) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (this.actionType == r101.actionType) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.actionType;
    }

    public String toString() {
        return "SwitchButton(text=" + this.text + ", actionType=" + this.actionType + ')';
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final String getText() {
        return this.text;
    }

    public SwitchButton(@JSONField(name = "text") String r100, @JSONField(name = "action_type") int r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.text = r100;
        this.actionType = r101;
    }

    public /* synthetic */ SwitchButton(String r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
