package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0087\b\u0018\u0000 12\u00020\u0001:\u00012B3\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0010\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b.\u0010/B=\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0010\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b.\u00100J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\tJ\"\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\t\u0010\u0011\u001a\u00020\u0010HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0010HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J?\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u00102\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u0004HÆ\u0001J\t\u0010\u001d\u001a\u00020\u0012HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003R\u001a\u0010\u0017\u001a\u00020\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b'\u0010(R\u001a\u0010\u0019\u001a\u00020\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010#\u001a\u0004\b)\u0010%R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010&\u001a\u0004\b*\u0010(R\u001a\u0010\u001b\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b,\u0010-¨\u00063"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskRecord;", "Lcom/obric/eventkit/eventstaskmanager/EventTaskRecord;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "writeSubClassExtensionFieldToParcel$eventstaskkit_release", "(Landroid/os/Parcel;)V", "writeSubClassExtensionFieldToParcel", "Ljava/lang/ClassLoader;", "currentClassLoader", "version", "onReadSubClassExtensionField", "describeContents", "", "component1", "", "component2", "component3", "component4", "component5", "id", DBDefinition.TASK_ID, "triggerTime", "sourceFrom", "result", "copy", "toString", "hashCode", "", "other", "", "equals", "J", "getId", "()J", "Ljava/lang/String;", "getTaskId", "()Ljava/lang/String;", "getTriggerTime", "getSourceFrom", "I", "getResult", "()I", "<init>", "(JLjava/lang/String;JLjava/lang/String;I)V", "(JLjava/lang/String;JLjava/lang/String;ILandroid/os/Parcel;)V", "Companion", "b", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class ShortcutTaskRecord extends EventTaskRecord {
    public static final Parcelable.Creator<ShortcutTaskRecord> CREATOR = null;
    public static final b Companion = null;
    private static final int FIELD_VERSION = 0;
    public static final int RESULT_SUCCESS = 0;
    public static final int RESULT_UNKNOWN_ERROR = 1;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f396878id;
    private final int result;
    private final String sourceFrom;
    private final String taskId;
    private final long triggerTime;

    public static final class a implements Parcelable.Creator<ShortcutTaskRecord> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShortcutTaskRecord createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            EventTaskRecord r101 = EventTaskRecord.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ShortcutTaskRecord");
            return (ShortcutTaskRecord) r101;
        }

        @Override // android.os.Parcelable.Creator
        public final ShortcutTaskRecord[] newArray(int r100) {
            return new ShortcutTaskRecord[r100];
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
        CREATOR = new a();
    }

    public ShortcutTaskRecord(long r110, String r111, long r112, String r113, int r114) {
        super(3, r110, r111, r112, r113, r114);
        this.f396878id = r110;
        this.taskId = r111;
        this.triggerTime = r112;
        this.sourceFrom = r113;
        this.result = r114;
    }

    public ShortcutTaskRecord(long r100, String r101, long r102, String r103, int r104, Parcel r105) {
        Intrinsics.checkNotNullParameter(r105, "parcel");
        this(r100, r101, r102, r103, r104);
        readExtensionFieldFromParcel$eventstaskkit_release(r105);
        readSubClassExtensionFieldFromParcel$eventstaskkit_release(r105, 0);
    }

    public static /* synthetic */ ShortcutTaskRecord copy$default(ShortcutTaskRecord r100, long r101, String r110, long r111, String r112, int r113, int r114, Object r115) {
        if ((r114 & 1) == 0) goto L5;
        long r102 = r100.getId();
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = r100.getTaskId();
    L11:
        if ((r114 & 4) == 0) goto L13;
        long r104 = r100.getTriggerTime();
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = r100.getSourceFrom();
    L19:
        if ((r114 & 16) == 0) goto L21;
        int r106 = r100.getResult();
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
        return getId();
    }

    public final String component2() {
        return getTaskId();
    }

    public final long component3() {
        return getTriggerTime();
    }

    public final String component4() {
        return getSourceFrom();
    }

    public final int component5() {
        return getResult();
    }

    public final ShortcutTaskRecord copy(long r110, String r111, long r112, String r113, int r114) {
        return new ShortcutTaskRecord(r110, r111, r112, r113, r114);
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ShortcutTaskRecord) == true) goto L8;
        return false;
    L8:
        ShortcutTaskRecord r101 = (ShortcutTaskRecord) r100;
        if (getId() == r101.getId()) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getTaskId(), r101.getTaskId()) == true) goto L15;
        return false;
    L15:
        if (getTriggerTime() == r101.getTriggerTime()) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(getSourceFrom(), r101.getSourceFrom()) == true) goto L21;
        return false;
    L21:
        if (getResult() == r101.getResult()) goto L23;
        return false;
    L23:
        return true;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord
    public long getId() {
        return this.f396878id;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord
    public int getResult() {
        return this.result;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord
    public String getSourceFrom() {
        return this.sourceFrom;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord
    public String getTaskId() {
        return this.taskId;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord
    public long getTriggerTime() {
        return this.triggerTime;
    }

    public int hashCode() {
        long r100 = getId();
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        int r102 = 0;
        if (getTaskId() != null) goto L5;
        int r103 = 0;
    L6:
        long r104 = getTriggerTime();
        int r105 = (((r101 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        if (getSourceFrom() == null) goto L11;
        r102 = getSourceFrom().hashCode();
    L11:
        return ((r105 + r102) * 31) + getResult();
    L5:
        r103 = getTaskId().hashCode();
        goto L6
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
    }

    public String toString() {
        return "ShortcutTaskRecord(id=" + getId() + ", taskId=" + getTaskId() + ", triggerTime=" + getTriggerTime() + ", sourceFrom=" + getSourceFrom() + ", result=" + getResult() + ')';
    }

    public final void writeSubClassExtensionFieldToParcel$eventstaskkit_release(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(0);
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskRecord, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        super.writeToParcel(r100, r101);
        writeExtensionFieldToParcel$eventstaskkit_release(r100);
        writeSubClassExtensionFieldToParcel$eventstaskkit_release(r100);
    }
}
