package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0017\u0018\u0000 ,2\u00020\u0001:\u0001-B;\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010$\u001a\u00020\u001a\u0012\b\u0010&\u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010(\u001a\u00020\u0004¢\u0006\u0004\b*\u0010+J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\tJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016R\u0017\u0010\u0016\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010 \u001a\u0004\u0018\u00010\u001f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\u001eR\u001c\u0010&\u001a\u0004\u0018\u00010\u001f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#R\u001a\u0010(\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010\u0017\u001a\u0004\b)\u0010\u0019¨\u0006."}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/EventTaskRecord;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "writeExtensionFieldToParcel$eventstaskkit_release", "(Landroid/os/Parcel;)V", "writeExtensionFieldToParcel", "readExtensionFieldFromParcel$eventstaskkit_release", "readExtensionFieldFromParcel", "ourVersion", "readSubClassExtensionFieldFromParcel$eventstaskkit_release", "(Landroid/os/Parcel;I)V", "readSubClassExtensionFieldFromParcel", "Ljava/lang/ClassLoader;", "currentClassLoader", "version", "onReadSubClassExtensionField", "describeContents", "type", "I", "getType", "()I", "", "id", "J", "getId", "()J", "", DBDefinition.TASK_ID, "Ljava/lang/String;", "getTaskId", "()Ljava/lang/String;", "triggerTime", "getTriggerTime", "sourceFrom", "getSourceFrom", "result", "getResult", "<init>", "(IJLjava/lang/String;JLjava/lang/String;I)V", "Companion", "b", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public class EventTaskRecord implements Parcelable {
    public static final Parcelable.Creator<EventTaskRecord> CREATOR = null;
    public static final b Companion = null;
    private static final int FIELD_VERSION = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f396876id;
    private final int result;
    private final String sourceFrom;
    private final String taskId;
    private final long triggerTime;
    private final int type;

    public static final class a implements Parcelable.Creator<EventTaskRecord> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final EventTaskRecord createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            int r100 = r110.readInt();
            long r101 = r110.readLong();
            String r102 = r110.readString();
            long r103 = r110.readLong();
            String r104 = r110.readString();
            int r105 = r110.readInt();
            if (r100 == 2) goto L10;
            if (r100 != 3) goto L8;
            return new ShortcutTaskRecord(r101, r102, r103, r104, r105, r110);
        L8:
            throw new IllegalArgumentException("Unknown event task type: " + r100);
        L10:
            return new ConditionTaskRecordV2(r101, r102, r103, r104, r105, r110);
        }

        @Override // android.os.Parcelable.Creator
        public final EventTaskRecord[] newArray(int r100) {
            return new EventTaskRecord[r100];
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

    public EventTaskRecord(int r100, long r101, String r102, long r103, String r104, int r105) {
        this.type = r100;
        this.f396876id = r101;
        this.taskId = r102;
        this.triggerTime = r103;
        this.sourceFrom = r104;
        this.result = r105;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getId() {
        return this.f396876id;
    }

    public int getResult() {
        return this.result;
    }

    public String getSourceFrom() {
        return this.sourceFrom;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public long getTriggerTime() {
        return this.triggerTime;
    }

    public final int getType() {
        return this.type;
    }

    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
    }

    public final void readExtensionFieldFromParcel$eventstaskkit_release(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        int r101 = r100.readInt();
        ClassLoader r102 = EventTaskRecord.class.getClassLoader();
        if (r101 <= 0) goto L5;
        int r103 = 0;
    L6:
        int r104 = 1;
    L7:
        if (r104 > r103) goto L9;
        r104 = r104 + 1;
    L9:
        if (r104 > r101) goto L11;
        ParcelUtils.INSTANCE.skipValueSafely(r100, r102);
        r104 = r104 + 1;
        goto L9
    L11:
        return;
    L5:
        r103 = r101;
        goto L6
    }

    public final void readSubClassExtensionFieldFromParcel$eventstaskkit_release(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        int r102 = r100.readInt();
        if (r102 > r101) goto L6;
        r101 = r102;
    L6:
        ClassLoader r103 = EventTaskRecord.class.getClassLoader();
        int r104 = 1;
    L7:
        if (r104 > r101) goto L9;
        onReadSubClassExtensionField(r100, r103, r104);
        r104 = r104 + 1;
    L9:
        if (r104 > r102) goto L11;
        ParcelUtils.INSTANCE.skipValueSafely(r100, r103);
        r104 = r104 + 1;
        goto L9
    }

    public final void writeExtensionFieldToParcel$eventstaskkit_release(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.type);
        r100.writeLong(getId());
        r100.writeString(getTaskId());
        r100.writeLong(getTriggerTime());
        r100.writeString(getSourceFrom());
        r100.writeInt(getResult());
    }
}
