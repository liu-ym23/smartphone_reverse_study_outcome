package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ,\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\u0012\u0010\u001d\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001aH\u0016J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0016HÖ\u0001R$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemShowEntitiesParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "message", "", "entities", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "getEntities", "()[Ljava/lang/String;", "setEntities", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/SystemShowEntitiesParams;", "describeContents", "", "equals", "", "other", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemShowEntitiesParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemShowEntitiesParams> CREATOR = null;
    private String[] entities;
    private String message;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<SystemShowEntitiesParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SystemShowEntitiesParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            SystemShowEntitiesParams r102 = new SystemShowEntitiesParams(r100.readString(), r100.createStringArray());
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
        public final SystemShowEntitiesParams[] newArray(int r100) {
            return new SystemShowEntitiesParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemShowEntitiesParams() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemShowEntitiesParams copy$default(SystemShowEntitiesParams r100, String r101, String[] r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.message;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.entities;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.message;
    }

    public final String[] component2() {
        return this.entities;
    }

    public final SystemShowEntitiesParams copy(String r100, String[] r101) {
        return new SystemShowEntitiesParams(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SystemShowEntitiesParams) == true) goto L8;
        return false;
    L8:
        SystemShowEntitiesParams r101 = (SystemShowEntitiesParams) r100;
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entities, r101.entities) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r100 = this.message;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String[] r104 = this.entities;
        if (r104 == null) goto L11;
        r101 = Arrays.hashCode(r104);
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "SystemShowEntitiesParams(message=" + this.message + ", entities=" + Arrays.toString(this.entities) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.message);
        r100.writeStringArray(this.entities);
    }

    public boolean isParamsCompleted() {
        if (this.message == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String[] getEntities() {
        return this.entities;
    }

    public final String getMessage() {
        return this.message;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof SystemShowEntitiesParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.message;
        if (r101 != null) goto L8;
        r101 = ((SystemShowEntitiesParams) r100).message;
    L8:
        String[] r102 = this.entities;
        if (r102 != null) goto L12;
        r102 = ((SystemShowEntitiesParams) r100).entities;
    L12:
        return new SystemShowEntitiesParams(r101, r102);
    }

    public final void setEntities(String[] r100) {
        this.entities = r100;
    }

    public final void setMessage(String r100) {
        this.message = r100;
    }

    public SystemShowEntitiesParams(String r100, String[] r101) {
        this.message = r100;
        this.entities = r101;
    }

    public /* synthetic */ SystemShowEntitiesParams(String r100, String[] r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
