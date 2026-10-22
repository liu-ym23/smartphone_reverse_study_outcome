package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\u0012\u0010 \u001a\u00020\u00012\b\u0010!\u001a\u0004\u0018\u00010\u001dH\u0016J\t\u0010\"\u001a\u00020\u0004HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0019HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006("}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemStopActionParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "questionId", "", "intentName", "actionId", "reason", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActionId", "()Ljava/lang/String;", "setActionId", "(Ljava/lang/String;)V", "getIntentName", "setIntentName", "getQuestionId", "setQuestionId", "getReason", "setReason", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemStopActionParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemStopActionParams> CREATOR = null;
    private String actionId;
    private String intentName;
    private String questionId;
    private String reason;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<SystemStopActionParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SystemStopActionParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            SystemStopActionParams r102 = new SystemStopActionParams(r100.readString(), r100.readString(), r100.readString(), r100.readString());
            int r103 = Math.min(r101, 0);
            ClassLoader r104 = a.class.getClassLoader();
            int r105 = 1;
        L3:
            if (r105 > r103) goto L5;
            r105 = r105 + 1;
        L5:
            if (r105 > r101) goto L7;
            joa.a.d(r100, r104);
            r105 = r105 + 1;
            goto L5
        L7:
            return r102;
        }

        @Override // android.os.Parcelable.Creator
        public final SystemStopActionParams[] newArray(int r100) {
            return new SystemStopActionParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public SystemStopActionParams() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SystemStopActionParams copy$default(SystemStopActionParams r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.questionId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.intentName;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.actionId;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.reason;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.questionId;
    }

    public final String component2() {
        return this.intentName;
    }

    public final String component3() {
        return this.actionId;
    }

    public final String component4() {
        return this.reason;
    }

    public final SystemStopActionParams copy(String r100, String r101, String r102, String r103) {
        return new SystemStopActionParams(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SystemStopActionParams) == true) goto L8;
        return false;
    L8:
        SystemStopActionParams r101 = (SystemStopActionParams) r100;
        if (Intrinsics.areEqual(this.questionId, r101.questionId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.intentName, r101.intentName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.actionId, r101.actionId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.reason, r101.reason) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r100 = this.questionId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.intentName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.actionId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.reason;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "SystemStopActionParams(questionId=" + this.questionId + ", intentName=" + this.intentName + ", actionId=" + this.actionId + ", reason=" + this.reason + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.questionId);
        r100.writeString(this.intentName);
        r100.writeString(this.actionId);
        r100.writeString(this.reason);
    }

    public boolean isParamsCompleted() {
        if (this.reason == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getActionId() {
        return this.actionId;
    }

    public final String getIntentName() {
        return this.intentName;
    }

    public final String getQuestionId() {
        return this.questionId;
    }

    public final String getReason() {
        return this.reason;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof SystemStopActionParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.questionId;
        if (r101 != null) goto L8;
        r101 = ((SystemStopActionParams) r100).questionId;
    L8:
        String r102 = this.intentName;
        if (r102 != null) goto L11;
        r102 = ((SystemStopActionParams) r100).intentName;
    L11:
        String r103 = this.actionId;
        if (r103 != null) goto L14;
        r103 = ((SystemStopActionParams) r100).actionId;
    L14:
        String r104 = this.reason;
        if (r104 != null) goto L18;
        r104 = ((SystemStopActionParams) r100).reason;
    L18:
        return new SystemStopActionParams(r101, r102, r103, r104);
    }

    public final void setActionId(String r100) {
        this.actionId = r100;
    }

    public final void setIntentName(String r100) {
        this.intentName = r100;
    }

    public final void setQuestionId(String r100) {
        this.questionId = r100;
    }

    public final void setReason(String r100) {
        this.reason = r100;
    }

    public SystemStopActionParams(String r100, String r101, String r102, String r103) {
        this.questionId = r100;
        this.intentName = r101;
        this.actionId = r102;
        this.reason = r103;
    }

    public /* synthetic */ SystemStopActionParams(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
