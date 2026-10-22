package com.ss.android.lark.passport.flow.verify.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/entity/ButtonBean;", "Ljava/io/Serializable;", "text", "", ReportConstant.COMMON_ACTION_TYPE, "", TeaEventTrack.ACTION_DRAMA_NEXT, "Lcom/ss/android/lark/passport/flow/core/router/FlowStep;", "<init>", "(Ljava/lang/String;ILcom/ss/android/lark/passport/flow/core/router/FlowStep;)V", "getText", "()Ljava/lang/String;", "getActionType", "()I", "getNext", "()Lcom/ss/android/lark/passport/flow/core/router/FlowStep;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ButtonBean implements Serializable {
    private final int actionType;
    private final FlowStep next;
    private final String text;

    public static /* synthetic */ ButtonBean copy$default(ButtonBean r100, String r101, int r102, FlowStep r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.actionType;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.next;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.actionType;
    }

    public final FlowStep component3() {
        return this.next;
    }

    public final ButtonBean copy(@JSONField(name = "text") String r100, @JSONField(name = "action_type") int r101, @JSONField(name = TeaEventTrack.ACTION_DRAMA_NEXT) FlowStep r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        return new ButtonBean(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ButtonBean) == true) goto L8;
        return false;
    L8:
        ButtonBean r101 = (ButtonBean) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (this.actionType == r101.actionType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.next, r101.next) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.text.hashCode() * 31) + this.actionType) * 31;
        FlowStep r101 = this.next;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "ButtonBean(text=" + this.text + ", actionType=" + this.actionType + ", next=" + this.next + ')';
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final FlowStep getNext() {
        return this.next;
    }

    public final String getText() {
        return this.text;
    }

    public ButtonBean(@JSONField(name = "text") String r100, @JSONField(name = "action_type") int r101, @JSONField(name = TeaEventTrack.ACTION_DRAMA_NEXT) FlowStep r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.text = r100;
        this.actionType = r101;
        this.next = r102;
    }

    public /* synthetic */ ButtonBean(String r100, int r101, FlowStep r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101, r102);
    }
}
