package com.larus.voicecall.impl.degrade.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0017R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006$"}, d2 = {"Lcom/larus/voicecall/impl/degrade/bean/BackupDegradeConfig;", "Landroid/os/Parcelable;", "downgradeConfigs", "", "Lcom/larus/voicecall/impl/degrade/bean/DowngradeConfig;", DyPayConstant.KEY_START_TIME, "", "endTime", "<init>", "(Ljava/util/List;JJ)V", "getDowngradeConfigs", "()Ljava/util/List;", "getStartTime", "()J", "setStartTime", "(J)V", "getEndTime", "setEndTime", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BackupDegradeConfig implements Parcelable {
    public static final Parcelable.Creator<BackupDegradeConfig> CREATOR = null;

    @SerializedName("downgrade_configs")
    private final List<DowngradeConfig> downgradeConfigs;

    @SerializedName("effective_end_time")
    private long endTime;

    @SerializedName("effective_start_time")
    private long startTime;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<BackupDegradeConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BackupDegradeConfig createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            if (r110.readInt() != 0) goto L5;
            ArrayList r100 = null;
        L14:
            return new BackupDegradeConfig(r100, r110.readLong(), r110.readLong());
        L5:
            int r101 = r110.readInt();
            ArrayList r102 = new ArrayList(r101);
            int r103 = 0;
        L6:
            if (r103 == r101) goto L12;
            if (r110.readInt() != 0) goto L10;
            DowngradeConfig r104 = null;
        L11:
            r102.add(r104);
            r103 = r103 + 1;
            goto L6
        L10:
            r104 = DowngradeConfig.CREATOR.createFromParcel(r110);
            goto L11
        L12:
            r100 = r102;
            goto L14
        }

        @Override // android.os.Parcelable.Creator
        public final BackupDegradeConfig[] newArray(int r100) {
            return new BackupDegradeConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public BackupDegradeConfig() {
        this(null, 0, 0, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BackupDegradeConfig copy$default(BackupDegradeConfig r100, List r101, long r102, long r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.downgradeConfigs;
    L6:
        if ((r104 & 2) == 0) goto L8;
        r102 = r100.startTime;
    L8:
        long r106 = r102;
        if ((r104 & 4) == 0) goto L11;
        r103 = r100.endTime;
    L11:
        List r107 = r101;
        return r100.copy(r107, r106, r103);
    }

    public final List<DowngradeConfig> component1() {
        return this.downgradeConfigs;
    }

    public final long component2() {
        return this.startTime;
    }

    public final long component3() {
        return this.endTime;
    }

    public final BackupDegradeConfig copy(List<DowngradeConfig> r100, long r101, long r110) {
        return new BackupDegradeConfig(r100, r101, r110);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BackupDegradeConfig) == true) goto L8;
        return false;
    L8:
        BackupDegradeConfig r101 = (BackupDegradeConfig) r100;
        if (Intrinsics.areEqual(this.downgradeConfigs, r101.downgradeConfigs) == true) goto L12;
        return false;
    L12:
        if (this.startTime == r101.startTime) goto L15;
        return false;
    L15:
        if (this.endTime == r101.endTime) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<DowngradeConfig> r100 = this.downgradeConfigs;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        long r102 = this.startTime;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.endTime;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "BackupDegradeConfig(downgradeConfigs=" + this.downgradeConfigs + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        List<DowngradeConfig> r102 = this.downgradeConfigs;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L12:
        r100.writeLong(this.startTime);
        r100.writeLong(this.endTime);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<DowngradeConfig> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L12;
        DowngradeConfig r104 = r103.next();
        if (r104 == null) goto L10;
        r100.writeInt(1);
        r104.writeToParcel(r100, r101);
        goto L7
    L10:
        r100.writeInt(0);
        goto L7
    }

    public final List<DowngradeConfig> getDowngradeConfigs() {
        return this.downgradeConfigs;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final void setEndTime(long r100) {
        this.endTime = r100;
    }

    public final void setStartTime(long r100) {
        this.startTime = r100;
    }

    public BackupDegradeConfig(List<DowngradeConfig> r100, long r101, long r102) {
        this.downgradeConfigs = r100;
        this.startTime = r101;
        this.endTime = r102;
    }

    public /* synthetic */ BackupDegradeConfig(List r100, long r101, long r102, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r110 & 2) == 0) goto L8;
        long r103 = -1;
    L10:
        if ((r110 & 4) == 0) goto L12;
        long r112 = -1;
    L13:
        this(r100, r103, r112);
        return;
    L12:
        r112 = r102;
        goto L13
    L8:
        r103 = r101;
        goto L10
    }
}
