package com.obric.assistant.settings.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0003J\u0013\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/settings/config/ModelSettingsItem;", "Landroid/os/Parcelable;", "id", "", "key", "", "name", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getKey", "()Ljava/lang/String;", "getName", "isCurrent", "", "component1", "component2", "component3", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ModelSettingsItem implements Parcelable {
    public static final Parcelable.Creator<ModelSettingsItem> CREATOR = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final int f392012id;

    @SerializedName("key")
    private final String key;

    @SerializedName("name")
    private final String name;

    public static final class a implements Parcelable.Creator<ModelSettingsItem> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ModelSettingsItem createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new ModelSettingsItem(r100.readInt(), r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final ModelSettingsItem[] newArray(int r100) {
            return new ModelSettingsItem[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ModelSettingsItem() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ ModelSettingsItem copy$default(ModelSettingsItem r100, int r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f392012id;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.key;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.name;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.f392012id;
    }

    public final String component2() {
        return this.key;
    }

    public final String component3() {
        return this.name;
    }

    public final ModelSettingsItem copy(int r100, String r101, String r102) {
        return new ModelSettingsItem(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ModelSettingsItem) == true) goto L8;
        return false;
    L8:
        ModelSettingsItem r101 = (ModelSettingsItem) r100;
        if (this.f392012id == r101.f392012id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.f392012id * 31;
        String r101 = this.key;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.name;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "ModelSettingsItem(id=" + this.f392012id + ", key=" + this.key + ", name=" + this.name + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.f392012id);
        r100.writeString(this.key);
        r100.writeString(this.name);
    }

    public final int getId() {
        return this.f392012id;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isCurrent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return Intrinsics.areEqual(this.key, r100);
    }

    public ModelSettingsItem(int r100, String r101, String r102) {
        this.f392012id = r100;
        this.key = r101;
        this.name = r102;
    }

    public /* synthetic */ ModelSettingsItem(int r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 1;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "seed";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "beta 版";
    L11:
        this(r100, r101, r102);
    }
}
