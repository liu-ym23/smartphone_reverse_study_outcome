package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.common.api.FirewallError;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "Landroid/os/Parcelable;", "enable", "", "minTriggerInterval", "", "(Ljava/lang/Boolean;Ljava/lang/Long;)V", "getEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMinTriggerInterval", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Long;)Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TriggerControlPolicy implements Parcelable {
    public static final Parcelable.Creator<TriggerControlPolicy> CREATOR = null;
    private final Boolean enable;
    private final Long minTriggerInterval;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<TriggerControlPolicy> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TriggerControlPolicy createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r102 = 1;
            Long r103 = null;
            if (r100.readInt() != 0) goto L6;
            Boolean r104 = null;
        L11:
            if (r100.readInt() == 0) goto L14;
            r103 = Long.valueOf(r100.readLong());
        L14:
            TriggerControlPolicy r105 = new TriggerControlPolicy(r104, r103);
            int r106 = Math.min(r101, 0);
            ClassLoader r107 = a.class.getClassLoader();
        L15:
            if (r102 > r106) goto L17;
            r102 = r102 + 1;
        L17:
            if (r102 > r101) goto L19;
            joa.a.d(r100, r107);
            r102 = r102 + 1;
            goto L17
        L19:
            return r105;
        L6:
            if (r100.readInt() == 0) goto L8;
            boolean r108 = true;
        L9:
            r104 = Boolean.valueOf(r108);
            goto L11
        L8:
            r108 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final TriggerControlPolicy[] newArray(int r100) {
            return new TriggerControlPolicy[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TriggerControlPolicy() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public TriggerControlPolicy(Boolean r100, Long r101) {
        this.enable = r100;
        this.minTriggerInterval = r101;
    }

    public /* synthetic */ TriggerControlPolicy(Boolean r100, Long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = Long.valueOf(FirewallError.FIREWALL_OK);
    L8:
        this(r100, r101);
    }

    public static /* synthetic */ TriggerControlPolicy copy$default(TriggerControlPolicy r100, Boolean r101, Long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.minTriggerInterval;
    L9:
        return r100.copy(r101, r102);
    }

    public final Boolean component1() {
        return this.enable;
    }

    public final Long component2() {
        return this.minTriggerInterval;
    }

    public final TriggerControlPolicy copy(Boolean r100, Long r101) {
        return new TriggerControlPolicy(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TriggerControlPolicy) == true) goto L8;
        return false;
    L8:
        TriggerControlPolicy r101 = (TriggerControlPolicy) r100;
        if (Intrinsics.areEqual(this.enable, r101.enable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.minTriggerInterval, r101.minTriggerInterval) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    public final Long getMinTriggerInterval() {
        return this.minTriggerInterval;
    }

    public int hashCode() {
        Boolean r100 = this.enable;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.minTriggerInterval;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "TriggerControlPolicy(enable=" + this.enable + ", minTriggerInterval=" + this.minTriggerInterval + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        Boolean r102 = this.enable;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Long r103 = this.minTriggerInterval;
        if (r103 != null) goto L9;
        r100.writeInt(0);
        return;
    L9:
        r100.writeInt(1);
        r100.writeLong(r103.longValue());
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.booleanValue() ? 1 : 0);
        goto L6
    }
}
