package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J3\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u0003J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006'"}, d2 = {"Lcom/larus/bmhome/auth/SubConvFirstMet;", "Landroid/os/Parcelable;", "type", "", "prologue", "", "skillCards", "", "Lcom/larus/bmhome/auth/OnboardingActionCardItemData;", "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "getType", "()I", "setType", "(I)V", "getPrologue", "()Ljava/lang/String;", "setPrologue", "(Ljava/lang/String;)V", "getSkillCards", "()Ljava/util/List;", "setSkillCards", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubConvFirstMet implements Parcelable {
    public static final Parcelable.Creator<SubConvFirstMet> CREATOR = null;

    @SerializedName("prologue")
    private String prologue;

    @SerializedName("skill_cards")
    private List<OnboardingActionCardItemData> skillCards;

    @SerializedName("type")
    private int type;

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a implements Parcelable.Creator<SubConvFirstMet> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SubConvFirstMet createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r101 = r100.readInt();
            String r102 = r100.readString();
            ArrayList r103 = null;
            if (r100.readInt() == 0) goto L14;
            int r104 = r100.readInt();
            ArrayList r105 = new ArrayList(r104);
            int r106 = 0;
        L6:
            if (r106 == r104) goto L12;
            if (r100.readInt() != 0) goto L10;
            OnboardingActionCardItemData r107 = null;
        L11:
            r105.add(r107);
            r106 = r106 + 1;
            goto L6
        L10:
            r107 = OnboardingActionCardItemData.CREATOR.createFromParcel(r100);
            goto L11
        L12:
            r103 = r105;
        L14:
            return new SubConvFirstMet(r101, r102, r103);
        }

        @Override // android.os.Parcelable.Creator
        public final SubConvFirstMet[] newArray(int r100) {
            return new SubConvFirstMet[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public SubConvFirstMet() {
        this(0, "", null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SubConvFirstMet) == true) goto L8;
        return false;
    L8:
        SubConvFirstMet r101 = (SubConvFirstMet) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.prologue, r101.prologue) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.skillCards, r101.skillCards) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.type * 31;
        String r101 = this.prologue;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        List<OnboardingActionCardItemData> r105 = this.skillCards;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "SubConvFirstMet(type=" + this.type + ", prologue=" + this.prologue + ", skillCards=" + this.skillCards + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.type);
        r100.writeString(this.prologue);
        List<OnboardingActionCardItemData> r102 = this.skillCards;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<OnboardingActionCardItemData> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L19;
        OnboardingActionCardItemData r104 = r103.next();
        if (r104 == null) goto L10;
        r100.writeInt(1);
        r104.writeToParcel(r100, r101);
        goto L7
    L10:
        r100.writeInt(0);
        goto L7
    }

    public final String a() {
        return this.prologue;
    }

    public final List<OnboardingActionCardItemData> b() {
        return this.skillCards;
    }

    public final int getType() {
        return this.type;
    }

    public SubConvFirstMet(int r100, String r101, List<OnboardingActionCardItemData> r102) {
        this.type = r100;
        this.prologue = r101;
        this.skillCards = r102;
    }
}
