package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0087\b\u0018\u0000 22\u00020\u0001:\u00013B9\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0016\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b/\u00100B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b/\u00101J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J\t\u0010\r\u001a\u00020\fHÆ\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0010\u001a\u00020\nHÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003JN\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u001a\u001a\u00020\nHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003R\u0017\u0010\u0012\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0013\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u0014\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b'\u0010(R$\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010)\u001a\u0004\b*\u0010\u000f\"\u0004\b+\u0010,R\u0017\u0010\u0016\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b-\u0010%R\u0017\u0010\u0017\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010 \u001a\u0004\b.\u0010\"¨\u00064"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/TimerTaskRecord;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "component1", "", "component2", "", "component3", "component4", "()Ljava/lang/Long;", "component5", "component6", "id", DBDefinition.TASK_ID, "triggerTime", "realActionTime", "sourceFrom", "taskStatus", "copy", "(ILjava/lang/String;JLjava/lang/Long;Ljava/lang/String;I)Lcom/obric/eventkit/eventstaskmanager/TimerTaskRecord;", "toString", "hashCode", "", "other", "", "equals", "I", "getId", "()I", "Ljava/lang/String;", "getTaskId", "()Ljava/lang/String;", "J", "getTriggerTime", "()J", "Ljava/lang/Long;", "getRealActionTime", "setRealActionTime", "(Ljava/lang/Long;)V", "getSourceFrom", "getTaskStatus", "<init>", "(ILjava/lang/String;JLjava/lang/Long;Ljava/lang/String;I)V", "(Landroid/os/Parcel;)V", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class TimerTaskRecord implements Parcelable {
    public static final a CREATOR = null;
    private static final int INVALID_INT_VALUE = -1;
    private static final long INVALID_LONG_VALUE = -1;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f396881id;
    private Long realActionTime;
    private final String sourceFrom;
    private final String taskId;
    private final int taskStatus;
    private final long triggerTime;

    public static final class a implements Parcelable.Creator<TimerTaskRecord> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TimerTaskRecord createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new TimerTaskRecord(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final TimerTaskRecord[] newArray(int r100) {
            return new TimerTaskRecord[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public TimerTaskRecord(int r100, String r101, long r102, Long r103, String r104, int r105) {
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r104, "sourceFrom");
        this.f396881id = r100;
        this.taskId = r101;
        this.triggerTime = r102;
        this.realActionTime = r103;
        this.sourceFrom = r104;
        this.taskStatus = r105;
    }

    public TimerTaskRecord(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        this(r110.readInt(), String.valueOf(r110.readInt()), r110.readLong(), Long.valueOf(r110.readLong()), TimerTaskKt.a(r110), r110.readInt());
        Long r111 = this.realActionTime;
        if (r111 != null) goto L6;
        return;
    L6:
        if (r111.longValue() != (-1)) goto L9;
        this.realActionTime = null;
        return;
    }

    public static /* synthetic */ TimerTaskRecord copy$default(TimerTaskRecord r100, int r101, String r102, long r103, Long r110, String r111, int r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.f396881id;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.taskId;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.triggerTime;
    L11:
        long r104 = r103;
        if ((r113 & 8) == 0) goto L14;
        r110 = r100.realActionTime;
    L14:
        Long r105 = r110;
        if ((r113 & 16) == 0) goto L17;
        r111 = r100.sourceFrom;
    L17:
        String r106 = r111;
        if ((r113 & 32) == 0) goto L20;
        r112 = r100.taskStatus;
    L20:
        int r107 = r101;
        return r100.copy(r107, r115, r104, r105, r106, r112);
    }

    public final int component1() {
        return this.f396881id;
    }

    public final String component2() {
        return this.taskId;
    }

    public final long component3() {
        return this.triggerTime;
    }

    public final Long component4() {
        return this.realActionTime;
    }

    public final String component5() {
        return this.sourceFrom;
    }

    public final int component6() {
        return this.taskStatus;
    }

    public final TimerTaskRecord copy(int r110, String r111, long r112, Long r113, String r114, int r115) {
        Intrinsics.checkNotNullParameter(r111, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r114, "sourceFrom");
        return new TimerTaskRecord(r110, r111, r112, r113, r114, r115);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TimerTaskRecord) == true) goto L8;
        return false;
    L8:
        TimerTaskRecord r101 = (TimerTaskRecord) r100;
        if (this.f396881id == r101.f396881id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L15;
        return false;
    L15:
        if (this.triggerTime == r101.triggerTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.realActionTime, r101.realActionTime) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sourceFrom, r101.sourceFrom) == true) goto L24;
        return false;
    L24:
        if (this.taskStatus == r101.taskStatus) goto L26;
        return false;
    L26:
        return true;
    }

    public final int getId() {
        return this.f396881id;
    }

    public final Long getRealActionTime() {
        return this.realActionTime;
    }

    public final String getSourceFrom() {
        return this.sourceFrom;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final int getTaskStatus() {
        return this.taskStatus;
    }

    public final long getTriggerTime() {
        return this.triggerTime;
    }

    public int hashCode() {
        int r100 = ((this.f396881id * 31) + this.taskId.hashCode()) * 31;
        long r101 = this.triggerTime;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        Long r103 = this.realActionTime;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return ((((r102 + r104) * 31) + this.sourceFrom.hashCode()) * 31) + this.taskStatus;
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final void setRealActionTime(Long r100) {
        this.realActionTime = r100;
    }

    public String toString() {
        return "TimerTaskRecord(id=" + this.f396881id + ", taskId=" + this.taskId + ", triggerTime=" + this.triggerTime + ", realActionTime=" + this.realActionTime + ", sourceFrom=" + this.sourceFrom + ", taskStatus=" + this.taskStatus + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.f396881id);
        Integer r102 = StringsKt.toIntOrNull(this.taskId);
        if (r102 == null) goto L5;
        int r103 = r102.intValue();
    L6:
        r100.writeInt(r103);
        r100.writeLong(this.triggerTime);
        Long r104 = this.realActionTime;
        if (r104 == null) goto L9;
        long r105 = r104.longValue();
    L10:
        r100.writeLong(r105);
        r100.writeString(this.sourceFrom);
        r100.writeInt(this.taskStatus);
        return;
    L9:
        r105 = -1;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }
}
