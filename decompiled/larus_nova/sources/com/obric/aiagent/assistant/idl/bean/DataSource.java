package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006!"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/DataSource;", "Landroid/os/Parcelable;", "domainName", "", "intentName", "sourceIntent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDomainName", "()Ljava/lang/String;", "setDomainName", "(Ljava/lang/String;)V", "getIntentName", "setIntentName", "getSourceIntent", "setSourceIntent", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DataSource implements Parcelable {
    public static final Parcelable.Creator<DataSource> CREATOR = null;
    private String domainName;
    private String intentName;
    private String sourceIntent;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<DataSource> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DataSource createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new DataSource(r100.readString(), r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final DataSource[] newArray(int r100) {
            return new DataSource[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ DataSource copy$default(DataSource r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.domainName;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.intentName;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.sourceIntent;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.domainName;
    }

    public final String component2() {
        return this.intentName;
    }

    public final String component3() {
        return this.sourceIntent;
    }

    public final DataSource copy(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "domainName");
        Intrinsics.checkNotNullParameter(r101, "intentName");
        return new DataSource(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DataSource) == true) goto L8;
        return false;
    L8:
        DataSource r101 = (DataSource) r100;
        if (Intrinsics.areEqual(this.domainName, r101.domainName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.intentName, r101.intentName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sourceIntent, r101.sourceIntent) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.domainName.hashCode() * 31) + this.intentName.hashCode()) * 31;
        String r101 = this.sourceIntent;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "DataSource(domainName=" + this.domainName + ", intentName=" + this.intentName + ", sourceIntent=" + this.sourceIntent + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.domainName);
        r100.writeString(this.intentName);
        r100.writeString(this.sourceIntent);
    }

    public final String getDomainName() {
        return this.domainName;
    }

    public final String getIntentName() {
        return this.intentName;
    }

    public final String getSourceIntent() {
        return this.sourceIntent;
    }

    public final void setDomainName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.domainName = r100;
    }

    public final void setIntentName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.intentName = r100;
    }

    public final void setSourceIntent(String r100) {
        this.sourceIntent = r100;
    }

    public DataSource(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "domainName");
        Intrinsics.checkNotNullParameter(r101, "intentName");
        this.domainName = r100;
        this.intentName = r101;
        this.sourceIntent = r102;
    }

    public /* synthetic */ DataSource(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
