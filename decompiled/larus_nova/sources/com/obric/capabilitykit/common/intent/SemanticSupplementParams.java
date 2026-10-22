package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\u0012\u0010\u001b\u001a\u00020\u00012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006#"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SemanticSupplementParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "queryId", "", "type", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getQueryId", "()Ljava/lang/String;", "setQueryId", "(Ljava/lang/String;)V", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/SemanticSupplementParams;", "describeContents", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SemanticSupplementParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SemanticSupplementParams> CREATOR = null;
    private String queryId;
    private Integer type;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<SemanticSupplementParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SemanticSupplementParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r102 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            Integer r103 = null;
        L6:
            SemanticSupplementParams r104 = new SemanticSupplementParams(r102, r103);
            int r105 = Math.min(r101, 0);
            ClassLoader r106 = a.class.getClassLoader();
            int r107 = 1;
        L7:
            if (r107 > r105) goto L9;
            r107 = r107 + 1;
        L9:
            if (r107 > r101) goto L11;
            joa.a.d(r100, r106);
            r107 = r107 + 1;
            goto L9
        L11:
            return r104;
        L5:
            r103 = Integer.valueOf(r100.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final SemanticSupplementParams[] newArray(int r100) {
            return new SemanticSupplementParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SemanticSupplementParams() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SemanticSupplementParams copy$default(SemanticSupplementParams r100, String r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.queryId;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.type;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.queryId;
    }

    public final Integer component2() {
        return this.type;
    }

    public final SemanticSupplementParams copy(String r100, Integer r101) {
        return new SemanticSupplementParams(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SemanticSupplementParams) == true) goto L8;
        return false;
    L8:
        SemanticSupplementParams r101 = (SemanticSupplementParams) r100;
        if (Intrinsics.areEqual(this.queryId, r101.queryId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r100 = this.queryId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.type;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "SemanticSupplementParams(queryId=" + this.queryId + ", type=" + this.type + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.queryId);
        Integer r103 = this.type;
        if (r103 == null) goto L6;
        r100.writeInt(1);
        r102 = r103.intValue();
    L6:
        r100.writeInt(r102);
    }

    public final String getQueryId() {
        return this.queryId;
    }

    public final Integer getType() {
        return this.type;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof SemanticSupplementParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.queryId;
        if (r101 != null) goto L8;
        r101 = ((SemanticSupplementParams) r100).queryId;
    L8:
        Integer r102 = this.type;
        if (r102 != null) goto L12;
        r102 = ((SemanticSupplementParams) r100).type;
    L12:
        return new SemanticSupplementParams(r101, r102);
    }

    public final void setQueryId(String r100) {
        this.queryId = r100;
    }

    public final void setType(Integer r100) {
        this.type = r100;
    }

    public SemanticSupplementParams(String r100, Integer r101) {
        this.queryId = r100;
        this.type = r101;
    }

    public /* synthetic */ SemanticSupplementParams(String r100, Integer r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
