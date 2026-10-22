package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010#J\u0086\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u00102J\u0006\u00103\u001a\u00020\rJ\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\rHÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001J\u0016\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0010\"\u0004\b\u0012\u0010\u0013R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0013R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0013R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0013R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0013R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0013R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0013R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0013R\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006?"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/IntentDebugReport;", "Landroid/os/Parcelable;", "isAppIntent", "", "intentDomain", "intentName", "intentParameters", "firstIntentResult", "engineResultCode", "engineErrorMsg", WiseOpenHianalyticsData.UNION_COSTTIME, "actionResult", "resultCode", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "()Ljava/lang/String;", "getIntentDomain", "setIntentDomain", "(Ljava/lang/String;)V", "getIntentName", "setIntentName", "getIntentParameters", "setIntentParameters", "getFirstIntentResult", "setFirstIntentResult", "getEngineResultCode", "setEngineResultCode", "getEngineErrorMsg", "setEngineErrorMsg", "getCostTime", "setCostTime", "getActionResult", "setActionResult", "getResultCode", "()Ljava/lang/Integer;", "setResultCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/aiagent/assistant/idl/bean/IntentDebugReport;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IntentDebugReport implements Parcelable {
    public static final Parcelable.Creator<IntentDebugReport> CREATOR = null;

    @SerializedName("ACTION_RESULT")
    private String actionResult;

    @SerializedName("COST_TIME")
    private String costTime;

    @SerializedName("ENGINE_ERROR_MSG")
    private String engineErrorMsg;

    @SerializedName("ENGINE_RESULT_CODE")
    private String engineResultCode;

    @SerializedName("PC_SEARCH_RESULT")
    private String firstIntentResult;

    @SerializedName("DOMAIN")
    private String intentDomain;

    @SerializedName("INTENT_NAME")
    private String intentName;

    @SerializedName("INTENT_PARAMETERS")
    private String intentParameters;

    @SerializedName("IS_APP_INTENT")
    private final String isAppIntent;

    @SerializedName("RESULT_CODE")
    private Integer resultCode;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<IntentDebugReport> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final IntentDebugReport createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            String r101 = r110.readString();
            String r102 = r110.readString();
            String r103 = r110.readString();
            String r104 = r110.readString();
            String r105 = r110.readString();
            String r106 = r110.readString();
            String r107 = r110.readString();
            String r111 = r110.readString();
            if (r110.readInt() != 0) goto L5;
            Integer r112 = null;
        L7:
            return new IntentDebugReport(r100, r101, r102, r103, r104, r105, r106, r107, r111, r112);
        L5:
            r112 = Integer.valueOf(r110.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final IntentDebugReport[] newArray(int r100) {
            return new IntentDebugReport[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IntentDebugReport) == true) goto L8;
        return false;
    L8:
        IntentDebugReport r101 = (IntentDebugReport) r100;
        if (Intrinsics.areEqual(this.isAppIntent, r101.isAppIntent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.intentDomain, r101.intentDomain) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.intentName, r101.intentName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.intentParameters, r101.intentParameters) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.firstIntentResult, r101.firstIntentResult) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.engineResultCode, r101.engineResultCode) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.engineErrorMsg, r101.engineErrorMsg) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.costTime, r101.costTime) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.actionResult, r101.actionResult) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.resultCode, r101.resultCode) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r100 = this.isAppIntent;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.intentDomain;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.intentName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.intentParameters;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.firstIntentResult;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.engineResultCode;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.engineErrorMsg;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.costTime;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.actionResult;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.resultCode;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
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

    public final String toString() {
        return "IntentDebugReport(isAppIntent=" + this.isAppIntent + ", intentDomain=" + this.intentDomain + ", intentName=" + this.intentName + ", intentParameters=" + this.intentParameters + ", firstIntentResult=" + this.firstIntentResult + ", engineResultCode=" + this.engineResultCode + ", engineErrorMsg=" + this.engineErrorMsg + ", costTime=" + this.costTime + ", actionResult=" + this.actionResult + ", resultCode=" + this.resultCode + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.isAppIntent);
        r100.writeString(this.intentDomain);
        r100.writeString(this.intentName);
        r100.writeString(this.intentParameters);
        r100.writeString(this.firstIntentResult);
        r100.writeString(this.engineResultCode);
        r100.writeString(this.engineErrorMsg);
        r100.writeString(this.costTime);
        r100.writeString(this.actionResult);
        Integer r102 = this.resultCode;
        if (r102 != null) goto L5;
        int r103 = 0;
    L6:
        r100.writeInt(r103);
        return;
    L5:
        r100.writeInt(1);
        r103 = r102.intValue();
        goto L6
    }

    public IntentDebugReport() {
        this("", "", "", "", "", "", "", "", "", 0);
    }

    public final String a() {
        return this.actionResult;
    }

    public final String b() {
        return this.costTime;
    }

    public final String c() {
        return this.engineResultCode;
    }

    public final String d() {
        return this.firstIntentResult;
    }

    public final String e() {
        return this.intentDomain;
    }

    public final String g() {
        return this.intentName;
    }

    public final String h() {
        return this.intentParameters;
    }

    public final Integer i() {
        return this.resultCode;
    }

    public final String j() {
        return this.isAppIntent;
    }

    public IntentDebugReport(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, Integer r110) {
        this.isAppIntent = r100;
        this.intentDomain = r101;
        this.intentName = r102;
        this.intentParameters = r103;
        this.firstIntentResult = r104;
        this.engineResultCode = r105;
        this.engineErrorMsg = r106;
        this.costTime = r107;
        this.actionResult = r108;
        this.resultCode = r110;
    }
}
