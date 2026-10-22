package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0006H\u0016J\t\u0010 \u001a\u00020\u001aHÖ\u0001J\b\u0010!\u001a\u00020\u001cH\u0016J\u0012\u0010\"\u001a\u00020\u00012\b\u0010#\u001a\u0004\u0018\u00010\u001eH\u0016J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001aHÖ\u0001R&\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u0006*"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhoneCallParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", PickerReporterConstants.KEY.TARGET, "Lcom/obric/capabilitykit/common/intent/ContactTarget;", "type", "", "simSlot", "(Lcom/obric/capabilitykit/common/intent/ContactTarget;Ljava/lang/String;Ljava/lang/String;)V", "getSimSlot$annotations", "()V", "getSimSlot", "()Ljava/lang/String;", "setSimSlot", "(Ljava/lang/String;)V", "getTarget", "()Lcom/obric/capabilitykit/common/intent/ContactTarget;", "setTarget", "(Lcom/obric/capabilitykit/common/intent/ContactTarget;)V", "getType", "setType", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "getSubActionValue", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhoneCallParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<PhoneCallParams> CREATOR = null;
    String simSlot;
    private ContactTarget target;
    private String type;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<PhoneCallParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PhoneCallParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() != 0) goto L5;
            ContactTarget r102 = null;
        L6:
            PhoneCallParams r103 = new PhoneCallParams(r102, r100.readString(), null, 4, null);
            int r104 = Math.min(r101, 1);
            ClassLoader r105 = a.class.getClassLoader();
            int r106 = 1;
        L7:
            if (r106 > r104) goto L13;
            if (r106 != 1) goto L12;
            Object r107 = joa.a.c(r100, r105);
            if (r107 == null) goto L12;
            r103.simSlot = (String) r107;
        L12:
            r106 = r106 + 1;
        L13:
            if (r106 > r101) goto L15;
            joa.a.d(r100, r105);
            r106 = r106 + 1;
            goto L13
        L15:
            return r103;
        L5:
            r102 = ContactTarget.CREATOR.createFromParcel(r100);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final PhoneCallParams[] newArray(int r100) {
            return new PhoneCallParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PhoneCallParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PhoneCallParams copy$default(PhoneCallParams r100, ContactTarget r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.target;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.type;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.simSlot;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public static /* synthetic */ void getSimSlot$annotations() {
    }

    public final ContactTarget component1() {
        return this.target;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.simSlot;
    }

    public final PhoneCallParams copy(ContactTarget r100, String r101, String r102) {
        return new PhoneCallParams(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PhoneCallParams) == true) goto L8;
        return false;
    L8:
        PhoneCallParams r101 = (PhoneCallParams) r100;
        if (Intrinsics.areEqual(this.target, r101.target) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.simSlot, r101.simSlot) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        ContactTarget r100 = this.target;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.type;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.simSlot;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PhoneCallParams(target=" + this.target + ", type=" + this.type + ", simSlot=" + this.simSlot + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(1);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        ContactTarget r102 = this.target;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeString(this.type);
        r100.writeValue(this.simSlot);
        return;
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    public String getSubActionValue() {
        ContactTarget r100 = this.target;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    public boolean isParamsCompleted() {
        if (this.target == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getSimSlot() {
        return this.simSlot;
    }

    public final ContactTarget getTarget() {
        return this.target;
    }

    public final String getType() {
        return this.type;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof PhoneCallParams) == true) goto L5;
        return this;
    L5:
        ContactTarget r101 = this.target;
        if (r101 != null) goto L8;
        r101 = ((PhoneCallParams) r100).target;
    L8:
        String r102 = this.type;
        if (r102 != null) goto L11;
        r102 = ((PhoneCallParams) r100).type;
    L11:
        String r103 = this.simSlot;
        if (r103 != null) goto L15;
        r103 = ((PhoneCallParams) r100).simSlot;
    L15:
        return new PhoneCallParams(r101, r102, r103);
    }

    public final void setSimSlot(String r100) {
        this.simSlot = r100;
    }

    public final void setTarget(ContactTarget r100) {
        this.target = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }

    public PhoneCallParams(ContactTarget r100, String r101, String r102) {
        this.target = r100;
        this.type = r101;
        this.simSlot = r102;
    }

    public /* synthetic */ PhoneCallParams(ContactTarget r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
