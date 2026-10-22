package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0004\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/PersonalContextInfo;", "Landroid/os/Parcelable;", "personalInfo", "", "isComplete", "", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getPersonalInfo", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/obric/aiagent/assistant/idl/bean/PersonalContextInfo;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PersonalContextInfo implements Parcelable {
    public static final Parcelable.Creator<PersonalContextInfo> CREATOR = null;
    private final Boolean isComplete;
    private final String personalInfo;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<PersonalContextInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PersonalContextInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            if (r100.readInt() != 0) goto L6;
            Boolean r102 = null;
        L11:
            return new PersonalContextInfo(r101, r102);
        L6:
            if (r100.readInt() == 0) goto L8;
            boolean r103 = true;
        L9:
            r102 = Boolean.valueOf(r103);
            goto L11
        L8:
            r103 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final PersonalContextInfo[] newArray(int r100) {
            return new PersonalContextInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PersonalContextInfo() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PersonalContextInfo copy$default(PersonalContextInfo r100, String r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.personalInfo;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.isComplete;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.personalInfo;
    }

    public final Boolean component2() {
        return this.isComplete;
    }

    public final PersonalContextInfo copy(String r100, Boolean r101) {
        return new PersonalContextInfo(r100, r101);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PersonalContextInfo) == true) goto L8;
        return false;
    L8:
        PersonalContextInfo r101 = (PersonalContextInfo) r100;
        if (Intrinsics.areEqual(this.personalInfo, r101.personalInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isComplete, r101.isComplete) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.personalInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.isComplete;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PersonalContextInfo(personalInfo=" + this.personalInfo + ", isComplete=" + this.isComplete + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5, types: [int] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.personalInfo);
        Boolean r102 = this.isComplete;
        if (r102 != null) goto L6;
        ?? r103 = 0;
    L5:
        r100.writeInt(r103);
        return;
    L6:
        r100.writeInt(1);
        r103 = r102.booleanValue();
        goto L5
    }

    public final String getPersonalInfo() {
        return this.personalInfo;
    }

    public final Boolean isComplete() {
        return this.isComplete;
    }

    public PersonalContextInfo(String r100, Boolean r101) {
        this.personalInfo = r100;
        this.isComplete = r101;
    }

    public /* synthetic */ PersonalContextInfo(String r100, Boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = Boolean.FALSE;
    L8:
        this(r100, r101);
    }
}
