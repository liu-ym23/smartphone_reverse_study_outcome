package kia;

import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b+\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J]\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u00101\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\nHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001e\u0010\f\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013¨\u00065"}, d2 = {"Lcom/obric/audio/enroll/asr/AsrResponse;", "", "AsrState", "", "VadEnd", "", "AsrEnd", "endTime", "", "errorCode", "", "errorMessage", DyPayConstant.KEY_START_TIME, "text", "<init>", "(Ljava/lang/String;ZLjava/lang/String;FILjava/lang/String;FLjava/lang/String;)V", "getAsrState", "()Ljava/lang/String;", "setAsrState", "(Ljava/lang/String;)V", "getVadEnd", "()Z", "setVadEnd", "(Z)V", "getAsrEnd", "setAsrEnd", "getEndTime", "()F", "setEndTime", "(F)V", "getErrorCode", "()I", "setErrorCode", "(I)V", "getErrorMessage", "setErrorMessage", "getStartTime", "setStartTime", "getText", "setText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("AsrEnd")
    private String AsrEnd;

    @SerializedName("AsrState")
    private String AsrState;

    @SerializedName("VadEnd")
    private boolean VadEnd;

    @SerializedName("endTime")
    private float endTime;

    @SerializedName("errorCode")
    private int errorCode;

    @SerializedName("errorMessage")
    private String errorMessage;

    @SerializedName(DyPayConstant.KEY_START_TIME)
    private float startTime;

    @SerializedName("text")
    private String text;

    public a() {
        this(null, false, null, 0.0f, 0, null, 0.0f, null, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.AsrState, r101.AsrState) == true) goto L12;
        return false;
    L12:
        if (this.VadEnd == r101.VadEnd) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.AsrEnd, r101.AsrEnd) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.endTime, r101.endTime) == 0) goto L21;
        return false;
    L21:
        if (this.errorCode == r101.errorCode) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.errorMessage, r101.errorMessage) == true) goto L27;
        return false;
    L27:
        if (Float.compare(this.startTime, r101.startTime) == 0) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.AsrState;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        if (this.VadEnd == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        String r106 = this.AsrEnd;
        if (r106 == null) goto L15;
        r101 = r106.hashCode();
    L15:
        return ((((((((((r105 + r101) * 31) + Float.floatToIntBits(this.endTime)) * 31) + this.errorCode) * 31) + this.errorMessage.hashCode()) * 31) + Float.floatToIntBits(this.startTime)) * 31) + this.text.hashCode();
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AsrResponse(AsrState=" + this.AsrState + ", VadEnd=" + this.VadEnd + ", AsrEnd=" + this.AsrEnd + ", endTime=" + this.endTime + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", startTime=" + this.startTime + ", text=" + this.text + ')';
    }

    public final int a() {
        return this.errorCode;
    }

    public final String b() {
        return this.text;
    }

    public final boolean c() {
        return this.VadEnd;
    }

    public a(String r100, boolean r101, String r102, float r103, int r104, String r110, float r111, String r112, int r113) {
        if ((r113 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r113 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r113 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r113 & 8) == 0) goto L15;
        r103 = 0.0f;
    L15:
        if ((r113 & 16) == 0) goto L18;
        r104 = 0;
    L18:
        if ((r113 & 32) == 0) goto L21;
        r110 = "";
    L21:
        if ((r113 & 64) == 0) goto L24;
        r111 = 0.0f;
    L24:
        if ((r113 & 128) == 0) goto L26;
        r112 = "";
    L26:
        Intrinsics.checkNotNullParameter(r110, "errorMessage");
        Intrinsics.checkNotNullParameter(r112, "text");
        this.AsrState = r100;
        this.VadEnd = r101;
        this.AsrEnd = r102;
        this.endTime = r103;
        this.errorCode = r104;
        this.errorMessage = r110;
        this.startTime = r111;
        this.text = r112;
    }
}
