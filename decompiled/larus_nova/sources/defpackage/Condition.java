package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"LCondition;", "", "filterEndTime", "", "filterLadders", "", "", "filterStartTime", "strategyName", "(JLjava/util/List;JLjava/lang/String;)V", "getFilterEndTime", "()J", "getFilterLadders", "()Ljava/util/List;", "getFilterStartTime", "getStrategyName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "livefeature-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Condition {

    @SerializedName("FilterEndTime")
    private final long filterEndTime;

    @SerializedName("FilterLadders")
    private final List<String> filterLadders;

    @SerializedName("FilterStartTime")
    private final long filterStartTime;

    @SerializedName("StrategyName")
    private final String strategyName;

    public Condition() {
        this(0, null, 0, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Condition copy$default(Condition r100, long r101, List r110, long r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L5;
        r101 = r100.filterEndTime;
    L5:
        long r102 = r101;
        if ((r113 & 2) == 0) goto L8;
        r110 = r100.filterLadders;
    L8:
        List r103 = r110;
        if ((r113 & 4) == 0) goto L11;
        r111 = r100.filterStartTime;
    L11:
        long r104 = r111;
        if ((r113 & 8) == 0) goto L15;
        r112 = r100.strategyName;
    L15:
        return r100.copy(r102, r103, r104, r112);
    }

    public final long component1() {
        return this.filterEndTime;
    }

    public final List<String> component2() {
        return this.filterLadders;
    }

    public final long component3() {
        return this.filterStartTime;
    }

    public final String component4() {
        return this.strategyName;
    }

    public final Condition copy(long r100, List<String> r110, long r111, String r112) {
        return new Condition(r100, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Condition) == false) goto L14;
        Condition r101 = (Condition) r100;
        if (this.filterEndTime == r101.filterEndTime) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.filterLadders, r101.filterLadders) == true) goto L10;
        return false;
    L10:
        if (this.filterStartTime == r101.filterStartTime) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.strategyName, r101.strategyName) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        long r100 = this.filterEndTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        List<String> r102 = this.filterLadders;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        long r105 = this.filterStartTime;
        int r106 = (((r101 + r104) * 31) + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        String r107 = this.strategyName;
        if (r107 == null) goto L10;
        r103 = r107.hashCode();
    L10:
        return r106 + r103;
    L5:
        r104 = 0;
        goto L6
    }

    public String toString() {
        return "Condition(filterEndTime=" + this.filterEndTime + ", filterLadders=" + this.filterLadders + ", filterStartTime=" + this.filterStartTime + ", strategyName=" + this.strategyName + ")";
    }

    public final long getFilterEndTime() {
        return this.filterEndTime;
    }

    public final List<String> getFilterLadders() {
        return this.filterLadders;
    }

    public final long getFilterStartTime() {
        return this.filterStartTime;
    }

    public final String getStrategyName() {
        return this.strategyName;
    }

    public Condition(long r100, List<String> r101, long r102, String r103) {
        this.filterEndTime = r100;
        this.filterLadders = r101;
        this.filterStartTime = r102;
        this.strategyName = r103;
    }

    public /* synthetic */ Condition(long r100, List r101, long r102, String r110, int r111, DefaultConstructorMarker r112) {
        long r103 = -1;
        if ((r111 & 1) == 0) goto L5;
        long r104 = -1;
    L7:
        if ((r111 & 2) == 0) goto L9;
        r101 = new ArrayList();
    L9:
        List r113 = r101;
        if ((r111 & 4) != 0) goto L14;
        r103 = r102;
    L14:
        if ((r111 & 8) == 0) goto L16;
        r110 = "";
    L16:
        this(r104, r113, r103, r110);
        return;
    L5:
        r104 = r100;
        goto L7
    }
}
