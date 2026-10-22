package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Be\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001eJn\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u00103J\t\u00104\u001a\u000205HÖ\u0001J\u0013\u00106\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\n\u00109\u001a\u0004\u0018\u00010\u0004H\u0016J\t\u0010:\u001a\u000205HÖ\u0001J\u0012\u0010;\u001a\u00020\u00012\b\u0010<\u001a\u0004\u0018\u000108H\u0016J\t\u0010=\u001a\u00020\u0004HÖ\u0001J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u000205HÖ\u0001R&\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R&\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R&\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R(\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010!\u0012\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R&\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010\u0013R&\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010\u000f\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010\u0013¨\u0006C"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemAutoActionParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "instruction", "", DBDefinition.TASK_ID, "taskScenario", "sourceFrom", "assistantHistory", "executionMode", "meta", "requestAuth", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAssistantHistory$annotations", "()V", "getAssistantHistory", "()Ljava/lang/String;", "setAssistantHistory", "(Ljava/lang/String;)V", "getExecutionMode$annotations", "getExecutionMode", "setExecutionMode", "getInstruction", "setInstruction", "getMeta$annotations", "getMeta", "setMeta", "getRequestAuth$annotations", "getRequestAuth", "()Ljava/lang/Boolean;", "setRequestAuth", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getSourceFrom$annotations", "getSourceFrom", "setSourceFrom", "getTaskId", "setTaskId", "getTaskScenario$annotations", "getTaskScenario", "setTaskScenario", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/SystemAutoActionParams;", "describeContents", "", "equals", "other", "", "getSubActionValue", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemAutoActionParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemAutoActionParams> CREATOR = null;
    String assistantHistory;
    String executionMode;
    private String instruction;
    String meta;
    Boolean requestAuth;
    String sourceFrom;
    private String taskId;
    String taskScenario;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<SystemAutoActionParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SystemAutoActionParams createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            SystemAutoActionParams r101 = new SystemAutoActionParams(r110.readString(), r110.readString(), null, null, null, null, null, null, 252, null);
            int r102 = Math.min(r100, 6);
            ClassLoader r103 = a.class.getClassLoader();
            int r104 = 1;
        L3:
            if (r104 > r102) goto L33;
            if (r104 != 1) goto L9;
            Object r105 = joa.a.c(r110, r103);
            if (r105 == null) goto L32;
            r101.taskScenario = (String) r105;
        L32:
            r104 = r104 + 1;
            goto L3
        L9:
            if (r104 != 2) goto L14;
            Object r106 = joa.a.c(r110, r103);
            if (r106 == null) goto L32;
            r101.sourceFrom = (String) r106;
            goto L32
        L14:
            if (r104 != 3) goto L19;
            Object r107 = joa.a.c(r110, r103);
            if (r107 == null) goto L32;
            r101.assistantHistory = (String) r107;
            goto L32
        L19:
            if (r104 != 4) goto L24;
            Object r108 = joa.a.c(r110, r103);
            if (r108 == null) goto L32;
            r101.executionMode = (String) r108;
            goto L32
        L24:
            if (r104 != 5) goto L28;
            Object r109 = joa.a.c(r110, r103);
            if (r109 == null) goto L32;
            r101.meta = (String) r109;
            goto L32
        L28:
            if (r104 != 6) goto L32;
            Object r111 = joa.a.c(r110, r103);
            if (r111 == null) goto L32;
            r101.requestAuth = (Boolean) r111;
        L33:
            if (r104 > r100) goto L35;
            joa.a.d(r110, r103);
            r104 = r104 + 1;
            goto L33
        L35:
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final SystemAutoActionParams[] newArray(int r100) {
            return new SystemAutoActionParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public SystemAutoActionParams() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ SystemAutoActionParams copy$default(SystemAutoActionParams r100, String r110, String r111, String r112, String r113, String r114, String r115, String r116, Boolean r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.instruction;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.taskId;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.taskScenario;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.sourceFrom;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.assistantHistory;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.executionMode;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.meta;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Boolean r108 = r100.requestAuth;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public static /* synthetic */ void getAssistantHistory$annotations() {
    }

    public static /* synthetic */ void getExecutionMode$annotations() {
    }

    public static /* synthetic */ void getMeta$annotations() {
    }

    public static /* synthetic */ void getRequestAuth$annotations() {
    }

    public static /* synthetic */ void getSourceFrom$annotations() {
    }

    public static /* synthetic */ void getTaskScenario$annotations() {
    }

    public final String component1() {
        return this.instruction;
    }

    public final String component2() {
        return this.taskId;
    }

    public final String component3() {
        return this.taskScenario;
    }

    public final String component4() {
        return this.sourceFrom;
    }

    public final String component5() {
        return this.assistantHistory;
    }

    public final String component6() {
        return this.executionMode;
    }

    public final String component7() {
        return this.meta;
    }

    public final Boolean component8() {
        return this.requestAuth;
    }

    public final SystemAutoActionParams copy(String r110, String r111, String r112, String r113, String r114, String r115, String r116, Boolean r117) {
        return new SystemAutoActionParams(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SystemAutoActionParams) == true) goto L8;
        return false;
    L8:
        SystemAutoActionParams r101 = (SystemAutoActionParams) r100;
        if (Intrinsics.areEqual(this.instruction, r101.instruction) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.taskScenario, r101.taskScenario) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.sourceFrom, r101.sourceFrom) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.assistantHistory, r101.assistantHistory) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.executionMode, r101.executionMode) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.meta, r101.meta) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.requestAuth, r101.requestAuth) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r100 = this.instruction;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.taskId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.taskScenario;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.sourceFrom;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.assistantHistory;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.executionMode;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.meta;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.requestAuth;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "SystemAutoActionParams(instruction=" + this.instruction + ", taskId=" + this.taskId + ", taskScenario=" + this.taskScenario + ", sourceFrom=" + this.sourceFrom + ", assistantHistory=" + this.assistantHistory + ", executionMode=" + this.executionMode + ", meta=" + this.meta + ", requestAuth=" + this.requestAuth + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(6);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.instruction);
        r100.writeString(this.taskId);
        r100.writeValue(this.taskScenario);
        r100.writeValue(this.sourceFrom);
        r100.writeValue(this.assistantHistory);
        r100.writeValue(this.executionMode);
        r100.writeValue(this.meta);
        r100.writeValue(this.requestAuth);
    }

    public String getSubActionValue() {
        Boolean r100 = this.requestAuth;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    public final String getAssistantHistory() {
        return this.assistantHistory;
    }

    public final String getExecutionMode() {
        return this.executionMode;
    }

    public final String getInstruction() {
        return this.instruction;
    }

    public final String getMeta() {
        return this.meta;
    }

    public final Boolean getRequestAuth() {
        return this.requestAuth;
    }

    public final String getSourceFrom() {
        return this.sourceFrom;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTaskScenario() {
        return this.taskScenario;
    }

    public IntentParams mergeParams(Object r110) {
        if ((r110 instanceof SystemAutoActionParams) == true) goto L5;
        return this;
    L5:
        String r100 = this.instruction;
        if (r100 != null) goto L8;
        r100 = ((SystemAutoActionParams) r110).instruction;
    L8:
        String r101 = r100;
        String r102 = this.taskId;
        if (r102 != null) goto L11;
        r102 = ((SystemAutoActionParams) r110).taskId;
    L11:
        String r103 = r102;
        String r104 = this.taskScenario;
        if (r104 != null) goto L14;
        r104 = ((SystemAutoActionParams) r110).taskScenario;
    L14:
        String r105 = r104;
        String r106 = this.sourceFrom;
        if (r106 != null) goto L17;
        r106 = ((SystemAutoActionParams) r110).sourceFrom;
    L17:
        String r107 = r106;
        String r108 = this.assistantHistory;
        if (r108 != null) goto L20;
        r108 = ((SystemAutoActionParams) r110).assistantHistory;
    L20:
        String r109 = r108;
        String r111 = this.executionMode;
        if (r111 != null) goto L23;
        r111 = ((SystemAutoActionParams) r110).executionMode;
    L23:
        String r112 = r111;
        String r113 = this.meta;
        if (r113 != null) goto L26;
        r113 = ((SystemAutoActionParams) r110).meta;
    L26:
        String r114 = r113;
        Boolean r115 = this.requestAuth;
        if (r115 != null) goto L29;
        Boolean r116 = ((SystemAutoActionParams) r110).requestAuth;
    L31:
        return new SystemAutoActionParams(r101, r103, r105, r107, r109, r112, r114, r116);
    L29:
        r116 = r115;
        goto L31
    }

    public final void setAssistantHistory(String r100) {
        this.assistantHistory = r100;
    }

    public final void setExecutionMode(String r100) {
        this.executionMode = r100;
    }

    public final void setInstruction(String r100) {
        this.instruction = r100;
    }

    public final void setMeta(String r100) {
        this.meta = r100;
    }

    public final void setRequestAuth(Boolean r100) {
        this.requestAuth = r100;
    }

    public final void setSourceFrom(String r100) {
        this.sourceFrom = r100;
    }

    public final void setTaskId(String r100) {
        this.taskId = r100;
    }

    public final void setTaskScenario(String r100) {
        this.taskScenario = r100;
    }

    public SystemAutoActionParams(String r100, String r101, String r102, String r103, String r104, String r105, String r106, Boolean r107) {
        this.instruction = r100;
        this.taskId = r101;
        this.taskScenario = r102;
        this.sourceFrom = r103;
        this.assistantHistory = r104;
        this.executionMode = r105;
        this.meta = r106;
        this.requestAuth = r107;
    }

    public /* synthetic */ SystemAutoActionParams(String r110, String r111, String r112, String r113, String r114, String r115, String r116, Boolean r117, int r118, DefaultConstructorMarker r119) {
        Boolean r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
