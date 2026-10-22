package com.larus.platform.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J2\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0003J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0003R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006)"}, d2 = {"Lcom/larus/platform/model/UserConfigItem;", "Landroid/os/Parcelable;", "key", "", "value", "", "version", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)V", "getKey", "()Ljava/lang/Integer;", "setKey", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "getVersion", "()Ljava/lang/Long;", "setVersion", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)Lcom/larus/platform/model/UserConfigItem;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserConfigItem implements Parcelable {
    public static final Parcelable.Creator<UserConfigItem> CREATOR = null;

    @SerializedName("object")
    private Integer key;

    @SerializedName("value")
    private String value;

    @SerializedName("version")
    private Long version;

    public static final class a implements Parcelable.Creator<UserConfigItem> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserConfigItem createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Long r101 = null;
            if (r100.readInt() != 0) goto L5;
            Integer r102 = null;
        L6:
            String r103 = r100.readString();
            if (r100.readInt() == 0) goto L11;
            r101 = Long.valueOf(r100.readLong());
        L11:
            return new UserConfigItem(r102, r103, r101);
        L5:
            r102 = Integer.valueOf(r100.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final UserConfigItem[] newArray(int r100) {
            return new UserConfigItem[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public UserConfigItem() {
        this(0, "", 0L);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UserConfigItem) == true) goto L8;
        return false;
    L8:
        UserConfigItem r101 = (UserConfigItem) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.value, r101.value) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.key;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.value;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.version;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "UserConfigItem(key=" + this.key + ", value=" + this.value + ", version=" + this.version + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Integer r102 = this.key;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeString(this.value);
        Long r103 = this.version;
        if (r103 != null) goto L9;
        r100.writeInt(0);
        return;
    L9:
        r100.writeInt(1);
        r100.writeLong(r103.longValue());
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.intValue());
        goto L6
    }

    public final Integer b() {
        return this.key;
    }

    public final String c() {
        return this.value;
    }

    public final Long d() {
        return this.version;
    }

    public static UserConfigItem a(UserConfigItem r100) {
        Integer r101 = r100.key;
        String r102 = r100.value;
        Long r103 = r100.version;
        r100.getClass();
        return new UserConfigItem(r101, r102, r103);
    }

    public final void e(String r100) {
        this.value = r100;
    }

    public final void g(Long r100) {
        this.version = r100;
    }

    public UserConfigItem(Integer r100, String r101, Long r102) {
        this.key = r100;
        this.value = r101;
        this.version = r102;
    }
}
