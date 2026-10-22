package com.ss.android.lark.intent.export.entity.output;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/CalendarParticipant;", "Landroid/os/Parcelable;", "id", "", "type", "Lcom/ss/android/lark/intent/export/entity/output/ParticipantType;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/intent/export/entity/output/ParticipantType;)V", "getId", "()Ljava/lang/String;", "getType", "()Lcom/ss/android/lark/intent/export/entity/output/ParticipantType;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CalendarParticipant implements Parcelable {
    public static final Parcelable.Creator<CalendarParticipant> CREATOR = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f428144id;
    private final ParticipantType type;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CalendarParticipant> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CalendarParticipant createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new CalendarParticipant(r100.readString(), ParticipantType.valueOf(r100.readString()));
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CalendarParticipant createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CalendarParticipant[] newArray(int r100) {
            return new CalendarParticipant[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CalendarParticipant[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public static /* synthetic */ CalendarParticipant copy$default(CalendarParticipant r100, String r101, ParticipantType r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f428144id;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.type;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.f428144id;
    }

    public final ParticipantType component2() {
        return this.type;
    }

    public final CalendarParticipant copy(String r100, ParticipantType r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "type");
        return new CalendarParticipant(r100, r101);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CalendarParticipant) == true) goto L8;
        return false;
    L8:
        CalendarParticipant r101 = (CalendarParticipant) r100;
        if (Intrinsics.areEqual(this.f428144id, r101.f428144id) == true) goto L12;
        return false;
    L12:
        if (this.type == r101.type) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f428144id.hashCode() * 31) + this.type.hashCode();
    }

    public String toString() {
        return "CalendarParticipant(id=" + this.f428144id + ", type=" + this.type + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f428144id);
        r100.writeString(this.type.name());
    }

    public final String getId() {
        return this.f428144id;
    }

    public final ParticipantType getType() {
        return this.type;
    }

    public CalendarParticipant(String r100, ParticipantType r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f428144id = r100;
        this.type = r101;
    }
}
