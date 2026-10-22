package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0010\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012R\u001b\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001b\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/RequestRestrictRule;", "Landroid/os/Parcelable;", "allowedHosts", "", "", "allowedPaths", "allowedUrlPrefixes", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAllowedHosts", "()Ljava/util/List;", "getAllowedPaths", "getAllowedUrlPrefixes", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RequestRestrictRule implements Parcelable {
    public static final Parcelable.Creator<RequestRestrictRule> CREATOR = null;
    private final List<String> allowedHosts;
    private final List<String> allowedPaths;
    private final List<String> allowedUrlPrefixes;

    public static final class a implements Parcelable.Creator<RequestRestrictRule> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RequestRestrictRule createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new RequestRestrictRule(r100.createStringArrayList(), r100.createStringArrayList(), r100.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        public final RequestRestrictRule[] newArray(int r100) {
            return new RequestRestrictRule[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public RequestRestrictRule() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RequestRestrictRule copy$default(RequestRestrictRule r100, List r101, List r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.allowedHosts;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.allowedPaths;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.allowedUrlPrefixes;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final List<String> component1() {
        return this.allowedHosts;
    }

    public final List<String> component2() {
        return this.allowedPaths;
    }

    public final List<String> component3() {
        return this.allowedUrlPrefixes;
    }

    public final RequestRestrictRule copy(List<String> r100, List<String> r101, List<String> r102) {
        return new RequestRestrictRule(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RequestRestrictRule) == true) goto L8;
        return false;
    L8:
        RequestRestrictRule r101 = (RequestRestrictRule) r100;
        if (Intrinsics.areEqual(this.allowedHosts, r101.allowedHosts) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.allowedPaths, r101.allowedPaths) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.allowedUrlPrefixes, r101.allowedUrlPrefixes) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<String> r100 = this.allowedHosts;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.allowedPaths;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.allowedUrlPrefixes;
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
        return "RequestRestrictRule(allowedHosts=" + this.allowedHosts + ", allowedPaths=" + this.allowedPaths + ", allowedUrlPrefixes=" + this.allowedUrlPrefixes + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeStringList(this.allowedHosts);
        r100.writeStringList(this.allowedPaths);
        r100.writeStringList(this.allowedUrlPrefixes);
    }

    public final List<String> getAllowedHosts() {
        return this.allowedHosts;
    }

    public final List<String> getAllowedPaths() {
        return this.allowedPaths;
    }

    public final List<String> getAllowedUrlPrefixes() {
        return this.allowedUrlPrefixes;
    }

    public RequestRestrictRule(List<String> r100, List<String> r101, List<String> r102) {
        this.allowedHosts = r100;
        this.allowedPaths = r101;
        this.allowedUrlPrefixes = r102;
    }

    public /* synthetic */ RequestRestrictRule(List r100, List r101, List r102, int r103, DefaultConstructorMarker r104) {
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
