package com.ss.android.lark.api.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \u00102\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/api/bean/ForsetiMode;", "Landroid/os/Parcelable;", "", "<init>", "(Ljava/lang/String;I)V", "Compact", "Regular", "Stack", "Unknown", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "describeContents", "CREATOR", "forseti-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ForsetiMode extends Enum<ForsetiMode> implements Parcelable {
    public static final a CREATOR = null;
    public static final ForsetiMode Compact = null;
    public static final ForsetiMode Regular = null;
    public static final ForsetiMode Stack = null;
    public static final ForsetiMode Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ForsetiMode[] f408646a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f408647b = null;

    public static final class a implements Parcelable.Creator<ForsetiMode> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForsetiMode createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return ForsetiMode.values()[r100.readInt()];
        }

        @Override // android.os.Parcelable.Creator
        public final ForsetiMode[] newArray(int r100) {
            return new ForsetiMode[r100];
        }
    }

    public static EnumEntries<ForsetiMode> getEntries() {
        return f408647b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        ForsetiMode r100 = new ForsetiMode("Compact", 0);
        Compact = r100;
        ForsetiMode r101 = new ForsetiMode("Regular", 1);
        Regular = r101;
        ForsetiMode r102 = new ForsetiMode("Stack", 2);
        Stack = r102;
        ForsetiMode r103 = new ForsetiMode("Unknown", 3);
        Unknown = r103;
        ForsetiMode[] r104 = {r100, r101, r102, r103};
        f408646a = r104;
        f408647b = EnumEntriesKt.enumEntries(r104);
        CREATOR = new a();
    }

    public static ForsetiMode[] values() {
        return (ForsetiMode[]) f408646a.clone();
    }

    public static ForsetiMode valueOf(String r100) {
        return (ForsetiMode) r27.a.a(ForsetiMode.class, r100);
    }

    public ForsetiMode(String r100, int r101) {
        super(r100, r101);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(ordinal());
    }
}
