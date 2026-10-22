package com.larus.voicecall.impl.degrade.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/larus/voicecall/impl/degrade/bean/Entrance;", "Landroid/os/Parcelable;", "name", "", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Lcom/larus/voicecall/impl/degrade/bean/Strategy;", "effectBots", "", "<init>", "(Ljava/lang/String;Lcom/larus/voicecall/impl/degrade/bean/Strategy;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getStrategy", "()Lcom/larus/voicecall/impl/degrade/bean/Strategy;", "getEffectBots", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Entrance implements Parcelable {
    public static final Parcelable.Creator<Entrance> CREATOR = null;

    @SerializedName("effect_bots")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> effectBots;

    @SerializedName("name")
    private final String name;

    @SerializedName(BdpAppEventConstant.PARAMS_STRATEGY_NAME)
    private final Strategy strategy;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<Entrance> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Entrance createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            Strategy r102 = null;
        L7:
            return new Entrance(r101, r102, r100.createStringArrayList());
        L5:
            r102 = Strategy.CREATOR.createFromParcel(r100);
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final Entrance[] newArray(int r100) {
            return new Entrance[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public Entrance() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Entrance copy$default(Entrance r100, String r101, Strategy r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.name;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.strategy;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.effectBots;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.name;
    }

    public final Strategy component2() {
        return this.strategy;
    }

    public final List<String> component3() {
        return this.effectBots;
    }

    public final Entrance copy(String r100, Strategy r101, List<String> r102) {
        return new Entrance(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Entrance) == true) goto L8;
        return false;
    L8:
        Entrance r101 = (Entrance) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.strategy, r101.strategy) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.effectBots, r101.effectBots) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Strategy r104 = this.strategy;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.effectBots;
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

    public String toString() {
        return "Entrance(name=" + this.name + ", strategy=" + this.strategy + ", effectBots=" + this.effectBots + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.name);
        Strategy r102 = this.strategy;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeStringList(this.effectBots);
        return;
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    public final List<String> getEffectBots() {
        return this.effectBots;
    }

    public final String getName() {
        return this.name;
    }

    public final Strategy getStrategy() {
        return this.strategy;
    }

    public Entrance(String r100, Strategy r101, List<String> r102) {
        this.name = r100;
        this.strategy = r101;
        this.effectBots = r102;
    }

    public /* synthetic */ Entrance(String r100, Strategy r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
