package com.larus.platform.api.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003JJ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0013\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001eHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006)"}, d2 = {"Lcom/larus/platform/api/creation/TabItemInfo;", "Landroid/os/Parcelable;", "id", "", "starlingKey", "name", "supportTextReplace", "", "displayExtra", "Lcom/larus/platform/api/creation/DisplayExtra;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/platform/api/creation/DisplayExtra;)V", "getId", "()Ljava/lang/String;", "getStarlingKey", "getName", "getSupportTextReplace", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDisplayExtra", "()Lcom/larus/platform/api/creation/DisplayExtra;", "getTrackerTabType", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/platform/api/creation/DisplayExtra;)Lcom/larus/platform/api/creation/TabItemInfo;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabItemInfo implements Parcelable {
    public static final Parcelable.Creator<TabItemInfo> CREATOR = null;

    @SerializedName("display_extra")
    private final DisplayExtra displayExtra;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f364955id;

    @SerializedName("name")
    private final String name;

    @SerializedName("starling_key")
    private final String starlingKey;

    @SerializedName("support_text_replace")
    private final Boolean supportTextReplace;

    public static final class a implements Parcelable.Creator<TabItemInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TabItemInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            String r102 = r100.readString();
            String r103 = r100.readString();
            DisplayExtra r104 = null;
            if (r100.readInt() != 0) goto L6;
            Boolean r105 = null;
        L11:
            if (r100.readInt() == 0) goto L15;
            r104 = DisplayExtra.CREATOR.createFromParcel(r100);
        L15:
            return new TabItemInfo(r101, r102, r103, r105, r104);
        L6:
            if (r100.readInt() == 0) goto L8;
            boolean r106 = true;
        L9:
            r105 = Boolean.valueOf(r106);
            goto L11
        L8:
            r106 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final TabItemInfo[] newArray(int r100) {
            return new TabItemInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public TabItemInfo() {
        this(null, null, null, null, 31);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TabItemInfo) == true) goto L8;
        return false;
    L8:
        TabItemInfo r101 = (TabItemInfo) r100;
        if (Intrinsics.areEqual(this.f364955id, r101.f364955id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.starlingKey, r101.starlingKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.supportTextReplace, r101.supportTextReplace) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.displayExtra, r101.displayExtra) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f364955id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.starlingKey;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.name;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.supportTextReplace;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        DisplayExtra r113 = this.displayExtra;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "TabItemInfo(id=" + this.f364955id + ", starlingKey=" + this.starlingKey + ", name=" + this.name + ", supportTextReplace=" + this.supportTextReplace + ", displayExtra=" + this.displayExtra + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f364955id);
        r100.writeString(this.starlingKey);
        r100.writeString(this.name);
        Boolean r102 = this.supportTextReplace;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        DisplayExtra r103 = this.displayExtra;
        if (r103 != null) goto L9;
        r100.writeInt(0);
        return;
    L9:
        r100.writeInt(1);
        r103.writeToParcel(r100, r101);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.booleanValue() ? 1 : 0);
        goto L6
    }

    public final DisplayExtra a() {
        return this.displayExtra;
    }

    public final String b() {
        return this.starlingKey;
    }

    public final Boolean c() {
        return this.supportTextReplace;
    }

    public final String getId() {
        return this.f364955id;
    }

    public final String getName() {
        return this.name;
    }

    public /* synthetic */ TabItemInfo(String r100, String r110, String r111, Boolean r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r113 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r113 & 8) == 0) goto L17;
        Boolean r104 = null;
    L18:
        this(r101, r102, r103, r104, null);
        return;
    L17:
        r104 = r112;
        goto L18
    L13:
        r103 = r111;
        goto L15
    L9:
        r102 = r110;
        goto L11
    L5:
        r101 = r100;
        goto L7
    }

    public TabItemInfo(String r100, String r101, String r102, Boolean r103, DisplayExtra r104) {
        this.f364955id = r100;
        this.starlingKey = r101;
        this.name = r102;
        this.supportTextReplace = r103;
        this.displayExtra = r104;
    }
}
