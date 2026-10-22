package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0001+B3\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b'\u0010(B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b'\u0010)J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010\r\u001a\u00020\tHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J?\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0016\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003R\u0017\u0010\u0010\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\"\u0010\u001eR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b#\u0010!R\u0017\u0010\u0014\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b%\u0010&¨\u0006,"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ConditionTaskRecord;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "", "component1", "", "component2", "component3", "component4", "component5", "id", DBDefinition.TASK_ID, "triggerTime", "sourceFrom", "result", "copy", "toString", "hashCode", "", "other", "", "equals", "J", "getId", "()J", "Ljava/lang/String;", "getTaskId", "()Ljava/lang/String;", "getTriggerTime", "getSourceFrom", "I", "getResult", "()I", "<init>", "(JLjava/lang/String;JLjava/lang/String;I)V", "(Landroid/os/Parcel;)V", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class ConditionTaskRecord implements Parcelable {
    public static final a CREATOR = null;
    public static final int RESULT_NO_LOCATION_PERMISSION = 2;
    public static final int RESULT_SKIPPED = 3;
    public static final int RESULT_SUCCESS = 0;
    public static final int RESULT_UNKNOWN_ERROR = 1;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f396871id;
    private final int result;
    private final String sourceFrom;
    private final String taskId;
    private final long triggerTime;

    public static final class a implements Parcelable.Creator<ConditionTaskRecord> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ConditionTaskRecord createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ConditionTaskRecord r102 = new ConditionTaskRecord(r100);
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
        public final ConditionTaskRecord[] newArray(int r100) {
            return new ConditionTaskRecord[r100];
        }
    }

    public ConditionTaskRecord(long r100, String r101, long r102, String r103, int r104) {
        this.f396871id = r100;
        this.taskId = r101;
        this.triggerTime = r102;
        this.sourceFrom = r103;
        this.result = r104;
    }

    public ConditionTaskRecord(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        this(r110.readLong(), TimerTaskKt.a(r110), r110.readLong(), TimerTaskKt.a(r110), r110.readInt());
    }

    public static /* synthetic */ ConditionTaskRecord copy$default(ConditionTaskRecord r100, long r101, String r110, long r111, String r112, int r113, int r114, Object r115) {
        if ((r114 & 1) == 0) goto L5;
        long r102 = r100.f396871id;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = r100.taskId;
    L11:
        if ((r114 & 4) == 0) goto L13;
        long r104 = r100.triggerTime;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = r100.sourceFrom;
    L19:
        if ((r114 & 16) == 0) goto L21;
        int r106 = r100.result;
    L23:
        return r100.copy(r102, r103, r104, r105, r106);
    L21:
        r106 = r113;
        goto L23
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }

    public final long component1() {
        return this.f396871id;
    }

    public final String component2() {
        return this.taskId;
    }

    public final long component3() {
        return this.triggerTime;
    }

    public final String component4() {
        return this.sourceFrom;
    }

    public final int component5() {
        return this.result;
    }

    public final ConditionTaskRecord copy(long r110, String r111, long r112, String r113, int r114) {
        return new ConditionTaskRecord(r110, r111, r112, r113, r114);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ConditionTaskRecord) == true) goto L8;
        return false;
    L8:
        ConditionTaskRecord r101 = (ConditionTaskRecord) r100;
        if (this.f396871id == r101.f396871id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L15;
        return false;
    L15:
        if (this.triggerTime == r101.triggerTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.sourceFrom, r101.sourceFrom) == true) goto L21;
        return false;
    L21:
        if (this.result == r101.result) goto L23;
        return false;
    L23:
        return true;
    }

    public final long getId() {
        return this.f396871id;
    }

    public final int getResult() {
        return this.result;
    }

    public final String getSourceFrom() {
        return this.sourceFrom;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final long getTriggerTime() {
        return this.triggerTime;
    }

    public int hashCode() {
        long r100 = this.f396871id;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.taskId;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        long r105 = this.triggerTime;
        int r106 = (((r101 + r104) * 31) + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        String r107 = this.sourceFrom;
        if (r107 == null) goto L11;
        r103 = r107.hashCode();
    L11:
        return ((r106 + r103) * 31) + this.result;
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "ConditionTaskRecord(id=" + this.f396871id + ", taskId=" + this.taskId + ", triggerTime=" + this.triggerTime + ", sourceFrom=" + this.sourceFrom + ", result=" + this.result + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeLong(this.f396871id);
        r100.writeString(this.taskId);
        r100.writeLong(this.triggerTime);
        r100.writeString(this.sourceFrom);
        r100.writeInt(this.result);
    }

    static {
        CREATOR = new a();
    }
}
