package com.larus.voicecall.impl.degrade.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005HÆ\u0003J\u0017\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003J_\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00052\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0001J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u001eHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R$\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006*"}, d2 = {"Lcom/larus/voicecall/impl/degrade/bean/DowngradeConfig;", "Landroid/os/Parcelable;", "scene", "", "enableExemption", "", "timeLimit", "Lcom/larus/voicecall/impl/degrade/bean/TimeConfig;", "entrances", "Lcom/larus/voicecall/impl/degrade/bean/Entrance;", "extra", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/larus/voicecall/impl/degrade/bean/TimeConfig;Ljava/util/List;Ljava/util/Map;)V", "getScene", "()Ljava/lang/String;", "getEnableExemption", "()Ljava/util/List;", "getTimeLimit", "()Lcom/larus/voicecall/impl/degrade/bean/TimeConfig;", "getEntrances", "getExtra", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DowngradeConfig implements Parcelable {
    public static final Parcelable.Creator<DowngradeConfig> CREATOR = null;

    @SerializedName("enable_exemption")
    private final List<String> enableExemption;

    @SerializedName("entrances")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<Entrance> entrances;

    @SerializedName("extra")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final Map<String, String> extra;

    @SerializedName("scene")
    private final String scene;

    @SerializedName("time_limit")
    private final TimeConfig timeLimit;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<DowngradeConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DowngradeConfig createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            ArrayList<String> r101 = r110.createStringArrayList();
            LinkedHashMap r102 = null;
            if (r110.readInt() != 0) goto L5;
            TimeConfig r103 = null;
        L6:
            TimeConfig r104 = r103;
            int r105 = 0;
            if (r110.readInt() != 0) goto L9;
            ArrayList r106 = null;
        L13:
            if (r110.readInt() == 0) goto L19;
            int r107 = r110.readInt();
            r102 = new LinkedHashMap(r107);
        L16:
            if (r105 == r107) goto L19;
            r102.put(r110.readString(), r110.readString());
            r105 = r105 + 1;
        L19:
            return new DowngradeConfig(r100, r101, r104, r106, r102);
        L9:
            int r108 = r110.readInt();
            r106 = new ArrayList(r108);
            int r109 = 0;
        L10:
            if (r109 == r108) goto L13;
            r106.add(Entrance.CREATOR.createFromParcel(r110));
            r109 = r109 + 1;
            goto L10
        L5:
            r103 = TimeConfig.CREATOR.createFromParcel(r110);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final DowngradeConfig[] newArray(int r100) {
            return new DowngradeConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public DowngradeConfig() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DowngradeConfig copy$default(DowngradeConfig r100, String r101, List r102, TimeConfig r103, List r104, Map r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.scene;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.enableExemption;
    L8:
        List r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.timeLimit;
    L11:
        TimeConfig r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.entrances;
    L14:
        List r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.extra;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.scene;
    }

    public final List<String> component2() {
        return this.enableExemption;
    }

    public final TimeConfig component3() {
        return this.timeLimit;
    }

    public final List<Entrance> component4() {
        return this.entrances;
    }

    public final Map<String, String> component5() {
        return this.extra;
    }

    public final DowngradeConfig copy(String r100, List<String> r101, TimeConfig r110, List<Entrance> r111, Map<String, String> r112) {
        return new DowngradeConfig(r100, r101, r110, r111, r112);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DowngradeConfig) == true) goto L8;
        return false;
    L8:
        DowngradeConfig r101 = (DowngradeConfig) r100;
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enableExemption, r101.enableExemption) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.timeLimit, r101.timeLimit) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.entrances, r101.entrances) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.scene;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.enableExemption;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        TimeConfig r107 = this.timeLimit;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<Entrance> r110 = this.entrances;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, String> r113 = this.extra;
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

    public String toString() {
        return "DowngradeConfig(scene=" + this.scene + ", enableExemption=" + this.enableExemption + ", timeLimit=" + this.timeLimit + ", entrances=" + this.entrances + ", extra=" + this.extra + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.scene);
        r100.writeStringList(this.enableExemption);
        TimeConfig r102 = this.timeLimit;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        List<Entrance> r103 = this.entrances;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L13:
        Map<String, String> r104 = this.extra;
        if (r104 != null) goto L16;
        r100.writeInt(0);
        return;
    L16:
        r100.writeInt(1);
        r100.writeInt(r104.size());
        Iterator<Map.Entry<String, String>> r105 = r104.entrySet().iterator();
    L18:
        if (r105.hasNext() == false) goto L23;
        Map.Entry<String, String> r106 = r105.next();
        r100.writeString(r106.getKey());
        r100.writeString(r106.getValue());
        goto L18
    L23:
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.size());
        Iterator<Entrance> r107 = r103.iterator();
    L11:
        if (r107.hasNext() == false) goto L13;
        r107.next().writeToParcel(r100, r101);
        goto L11
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    public final List<String> getEnableExemption() {
        return this.enableExemption;
    }

    public final List<Entrance> getEntrances() {
        return this.entrances;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final String getScene() {
        return this.scene;
    }

    public final TimeConfig getTimeLimit() {
        return this.timeLimit;
    }

    public DowngradeConfig(String r100, List<String> r101, TimeConfig r102, List<Entrance> r103, Map<String, String> r104) {
        this.scene = r100;
        this.enableExemption = r101;
        this.timeLimit = r102;
        this.entrances = r103;
        this.extra = r104;
    }

    public /* synthetic */ DowngradeConfig(String r100, List r101, TimeConfig r102, List r103, Map r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        List r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        TimeConfig r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        List r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Map r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
