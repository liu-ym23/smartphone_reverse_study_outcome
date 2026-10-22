package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0016J\t\u0010\u001b\u001a\u00020\u0015HÖ\u0001J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\u0012\u0010\u001d\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0015HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006%"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemInAppSearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "searchIntent", "", "query", "quResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getQuResult", "()Ljava/lang/String;", "setQuResult", "(Ljava/lang/String;)V", "getQuery", "setQuery", "getSearchIntent", "setSearchIntent", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "getSubActionValue", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemInAppSearchParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemInAppSearchParams> CREATOR = null;
    private String quResult;
    private String query;
    private String searchIntent;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<SystemInAppSearchParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SystemInAppSearchParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            SystemInAppSearchParams r102 = new SystemInAppSearchParams(r100.readString(), r100.readString(), r100.readString());
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
        public final SystemInAppSearchParams[] newArray(int r100) {
            return new SystemInAppSearchParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public SystemInAppSearchParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ SystemInAppSearchParams copy$default(SystemInAppSearchParams r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.searchIntent;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.query;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.quResult;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.searchIntent;
    }

    public final String component2() {
        return this.query;
    }

    public final String component3() {
        return this.quResult;
    }

    public final SystemInAppSearchParams copy(String r100, String r101, String r102) {
        return new SystemInAppSearchParams(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SystemInAppSearchParams) == true) goto L8;
        return false;
    L8:
        SystemInAppSearchParams r101 = (SystemInAppSearchParams) r100;
        if (Intrinsics.areEqual(this.searchIntent, r101.searchIntent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.query, r101.query) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.quResult, r101.quResult) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.searchIntent;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.query;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.quResult;
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
        return "SystemInAppSearchParams(searchIntent=" + this.searchIntent + ", query=" + this.query + ", quResult=" + this.quResult + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.searchIntent);
        r100.writeString(this.query);
        r100.writeString(this.quResult);
    }

    public String getSubActionValue() {
        String r100 = this.searchIntent;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100;
    }

    public boolean isParamsCompleted() {
        if (this.searchIntent != null) goto L5;
    L9:
        return false;
    L5:
        if (this.query == null) goto L9;
        if (this.quResult == null) goto L9;
        return true;
    }

    public final String getQuResult() {
        return this.quResult;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getSearchIntent() {
        return this.searchIntent;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof SystemInAppSearchParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.searchIntent;
        if (r101 != null) goto L8;
        r101 = ((SystemInAppSearchParams) r100).searchIntent;
    L8:
        String r102 = this.query;
        if (r102 != null) goto L11;
        r102 = ((SystemInAppSearchParams) r100).query;
    L11:
        String r103 = this.quResult;
        if (r103 != null) goto L15;
        r103 = ((SystemInAppSearchParams) r100).quResult;
    L15:
        return new SystemInAppSearchParams(r101, r102, r103);
    }

    public final void setQuResult(String r100) {
        this.quResult = r100;
    }

    public final void setQuery(String r100) {
        this.query = r100;
    }

    public final void setSearchIntent(String r100) {
        this.searchIntent = r100;
    }

    public SystemInAppSearchParams(String r100, String r101, String r102) {
        this.searchIntent = r100;
        this.query = r101;
        this.quResult = r102;
    }

    public /* synthetic */ SystemInAppSearchParams(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
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
