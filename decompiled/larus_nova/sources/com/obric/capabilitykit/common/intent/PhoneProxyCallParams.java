package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.autofill.HintConstants;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B_\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\rJ\u0010\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jh\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010,J\t\u0010-\u001a\u00020.HÖ\u0001J\u0013\u0010/\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020.HÖ\u0001J\b\u00103\u001a\u00020\u0004H\u0016J\u0012\u00104\u001a\u00020\u00012\b\u00105\u001a\u0004\u0018\u000101H\u0016J\t\u00106\u001a\u00020\u0007HÖ\u0001J\u0019\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020.HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016¨\u0006<"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhoneProxyCallParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "canInterruptCall", "", "option", "", "", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "name", "firstSentence", "targetPhoneNumber", "ext", "(Ljava/lang/Boolean;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCanInterruptCall", "()Ljava/lang/Boolean;", "setCanInterruptCall", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getExt", "()Ljava/lang/String;", "setExt", "(Ljava/lang/String;)V", "getFirstSentence", "setFirstSentence", "getName", "setName", "getOption", "()[Ljava/lang/String;", "setOption", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getPhoneNumber", "setPhoneNumber", "getTargetPhoneNumber", "setTargetPhoneNumber", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Boolean;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/PhoneProxyCallParams;", "describeContents", "", "equals", "other", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhoneProxyCallParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<PhoneProxyCallParams> CREATOR = null;
    private Boolean canInterruptCall;
    private String ext;
    private String firstSentence;
    private String name;
    private String[] option;
    private String phoneNumber;
    private String targetPhoneNumber;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<PhoneProxyCallParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PhoneProxyCallParams createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            int r111 = 1;
            if (r110.readInt() != 0) goto L7;
            Boolean r101 = null;
        L5:
            Boolean r102 = r101;
            PhoneProxyCallParams r103 = new PhoneProxyCallParams(r102, r110.createStringArray(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString());
            int r104 = Math.min(r100, 0);
            ClassLoader r105 = a.class.getClassLoader();
        L12:
            if (r111 > r104) goto L14;
            r111 = r111 + 1;
        L14:
            if (r111 > r100) goto L16;
            joa.a.d(r110, r105);
            r111 = r111 + 1;
            goto L14
        L16:
            return r103;
        L7:
            if (r110.readInt() == 0) goto L9;
            boolean r106 = true;
        L10:
            r101 = Boolean.valueOf(r106);
            goto L5
        L9:
            r106 = false;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public final PhoneProxyCallParams[] newArray(int r100) {
            return new PhoneProxyCallParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PhoneProxyCallParams() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ PhoneProxyCallParams copy$default(PhoneProxyCallParams r100, Boolean r101, String[] r102, String r103, String r104, String r110, String r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.canInterruptCall;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.option;
    L8:
        String[] r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.phoneNumber;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.name;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.firstSentence;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.targetPhoneNumber;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.ext;
    L23:
        Boolean r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final Boolean component1() {
        return this.canInterruptCall;
    }

    public final String[] component2() {
        return this.option;
    }

    public final String component3() {
        return this.phoneNumber;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.firstSentence;
    }

    public final String component6() {
        return this.targetPhoneNumber;
    }

    public final String component7() {
        return this.ext;
    }

    public final PhoneProxyCallParams copy(Boolean r110, String[] r111, String r112, String r113, String r114, String r115, String r116) {
        return new PhoneProxyCallParams(r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PhoneProxyCallParams) == true) goto L8;
        return false;
    L8:
        PhoneProxyCallParams r101 = (PhoneProxyCallParams) r100;
        if (Intrinsics.areEqual(this.canInterruptCall, r101.canInterruptCall) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.option, r101.option) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.phoneNumber, r101.phoneNumber) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.firstSentence, r101.firstSentence) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.targetPhoneNumber, r101.targetPhoneNumber) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        Boolean r100 = this.canInterruptCall;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String[] r104 = this.option;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.phoneNumber;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.name;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.firstSentence;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.targetPhoneNumber;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.ext;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
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
        r105 = Arrays.hashCode(r104);
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PhoneProxyCallParams(canInterruptCall=" + this.canInterruptCall + ", option=" + Arrays.toString(this.option) + ", phoneNumber=" + this.phoneNumber + ", name=" + this.name + ", firstSentence=" + this.firstSentence + ", targetPhoneNumber=" + this.targetPhoneNumber + ", ext=" + this.ext + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        ?? r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        Boolean r103 = this.canInterruptCall;
        if (r103 != null) goto L5;
    L4:
        r100.writeInt(r102);
        r100.writeStringArray(this.option);
        r100.writeString(this.phoneNumber);
        r100.writeString(this.name);
        r100.writeString(this.firstSentence);
        r100.writeString(this.targetPhoneNumber);
        r100.writeString(this.ext);
        return;
    L5:
        r100.writeInt(1);
        r102 = r103.booleanValue();
        goto L4
    }

    public boolean isParamsCompleted() {
        if (this.option != null) goto L5;
    L7:
        return false;
    L5:
        if (this.phoneNumber == null) goto L7;
        return true;
    }

    public final Boolean getCanInterruptCall() {
        return this.canInterruptCall;
    }

    public final String getExt() {
        return this.ext;
    }

    public final String getFirstSentence() {
        return this.firstSentence;
    }

    public final String getName() {
        return this.name;
    }

    public final String[] getOption() {
        return this.option;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getTargetPhoneNumber() {
        return this.targetPhoneNumber;
    }

    public IntentParams mergeParams(Object r110) {
        if ((r110 instanceof PhoneProxyCallParams) == true) goto L5;
        return this;
    L5:
        Boolean r100 = this.canInterruptCall;
        if (r100 != null) goto L8;
        r100 = ((PhoneProxyCallParams) r110).canInterruptCall;
    L8:
        Boolean r101 = r100;
        String[] r102 = this.option;
        if (r102 != null) goto L11;
        r102 = ((PhoneProxyCallParams) r110).option;
    L11:
        String[] r103 = r102;
        String r104 = this.phoneNumber;
        if (r104 != null) goto L14;
        r104 = ((PhoneProxyCallParams) r110).phoneNumber;
    L14:
        String r105 = r104;
        String r106 = this.name;
        if (r106 != null) goto L17;
        r106 = ((PhoneProxyCallParams) r110).name;
    L17:
        String r107 = r106;
        String r108 = this.firstSentence;
        if (r108 != null) goto L20;
        r108 = ((PhoneProxyCallParams) r110).firstSentence;
    L20:
        String r109 = r108;
        String r111 = this.targetPhoneNumber;
        if (r111 != null) goto L23;
        r111 = ((PhoneProxyCallParams) r110).targetPhoneNumber;
    L23:
        String r112 = r111;
        String r113 = this.ext;
        if (r113 != null) goto L26;
        String r114 = ((PhoneProxyCallParams) r110).ext;
    L28:
        return new PhoneProxyCallParams(r101, r103, r105, r107, r109, r112, r114);
    L26:
        r114 = r113;
        goto L28
    }

    public final void setCanInterruptCall(Boolean r100) {
        this.canInterruptCall = r100;
    }

    public final void setExt(String r100) {
        this.ext = r100;
    }

    public final void setFirstSentence(String r100) {
        this.firstSentence = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setOption(String[] r100) {
        this.option = r100;
    }

    public final void setPhoneNumber(String r100) {
        this.phoneNumber = r100;
    }

    public final void setTargetPhoneNumber(String r100) {
        this.targetPhoneNumber = r100;
    }

    public PhoneProxyCallParams(Boolean r100, String[] r101, String r102, String r103, String r104, String r105, String r106) {
        this.canInterruptCall = r100;
        this.option = r101;
        this.phoneNumber = r102;
        this.name = r103;
        this.firstSentence = r104;
        this.targetPhoneNumber = r105;
        this.ext = r106;
    }

    public /* synthetic */ PhoneProxyCallParams(Boolean r100, String[] r101, String r102, String r110, String r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        Boolean r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String[] r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        String r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
