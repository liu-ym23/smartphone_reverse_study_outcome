package com.bytedance.ee.bear.document.analytic.processmonitor.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012&\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J)\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bHÆ\u0003J\\\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062(\b\u0002\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0004J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0004HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0004R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R:\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/document/analytic/processmonitor/entity/CpuInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "Landroid/os/Parcelable;", "pid", "", "cpuRate", "", "cpuSpeed", "threadMap", "Ljava/util/HashMap;", "Lcom/bytedance/ee/bear/document/analytic/processmonitor/entity/ThreadExceptionItem;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/HashMap;)V", "getPid", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCpuRate", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getCpuSpeed", "getThreadMap", "()Ljava/util/HashMap;", "setThreadMap", "(Ljava/util/HashMap;)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/HashMap;)Lcom/bytedance/ee/bear/document/analytic/processmonitor/entity/CpuInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CpuInfo implements NonProguard, Parcelable {
    public static final Parcelable.Creator<CpuInfo> CREATOR = null;
    private final Double cpuRate;
    private final Double cpuSpeed;
    private final Integer pid;
    private HashMap<Integer, ThreadExceptionItem> threadMap;

    public static final class a implements Parcelable.Creator<CpuInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CpuInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            HashMap r101 = null;
            if (r100.readInt() != 0) goto L5;
            Integer r102 = null;
        L7:
            if (r100.readInt() != 0) goto L9;
            Double r103 = null;
        L11:
            if (r100.readInt() != 0) goto L13;
            Double r104 = null;
        L15:
            if (r100.readInt() == 0) goto L22;
            int r105 = r100.readInt();
            HashMap r106 = new HashMap(r105);
            int r107 = 0;
        L18:
            if (r107 == r105) goto L20;
            r106.put(Integer.valueOf(r100.readInt()), ThreadExceptionItem.CREATOR.createFromParcel(r100));
            r107 = r107 + 1;
            goto L18
        L20:
            r101 = r106;
        L22:
            return new CpuInfo(r102, r103, r104, r101);
        L13:
            r104 = Double.valueOf(r100.readDouble());
            goto L15
        L9:
            r103 = Double.valueOf(r100.readDouble());
            goto L11
        L5:
            r102 = Integer.valueOf(r100.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final CpuInfo[] newArray(int r100) {
            return new CpuInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CpuInfo copy$default(CpuInfo r100, Integer r101, Double r102, Double r103, HashMap r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.pid;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.cpuRate;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.cpuSpeed;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.threadMap;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Integer component1() {
        return this.pid;
    }

    public final Double component2() {
        return this.cpuRate;
    }

    public final Double component3() {
        return this.cpuSpeed;
    }

    public final HashMap<Integer, ThreadExceptionItem> component4() {
        return this.threadMap;
    }

    public final CpuInfo copy(Integer r100, Double r101, Double r102, HashMap<Integer, ThreadExceptionItem> r103) {
        return new CpuInfo(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CpuInfo) == true) goto L8;
        return false;
    L8:
        CpuInfo r101 = (CpuInfo) r100;
        if (Intrinsics.areEqual(this.pid, r101.pid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cpuRate, r101.cpuRate) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cpuSpeed, r101.cpuSpeed) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.threadMap, r101.threadMap) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.pid;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Double r104 = this.cpuRate;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Double r107 = this.cpuSpeed;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        HashMap<Integer, ThreadExceptionItem> r110 = this.threadMap;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "CpuInfo(pid=" + this.pid + ", cpuRate=" + this.cpuRate + ", cpuSpeed=" + this.cpuSpeed + ", threadMap=" + this.threadMap + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Integer r102 = this.pid;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Double r103 = this.cpuRate;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        Double r104 = this.cpuSpeed;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        HashMap<Integer, ThreadExceptionItem> r105 = this.threadMap;
        if (r105 != null) goto L17;
        r100.writeInt(0);
        return;
    L17:
        r100.writeInt(1);
        r100.writeInt(r105.size());
        Iterator<Map.Entry<Integer, ThreadExceptionItem>> r106 = r105.entrySet().iterator();
    L19:
        if (r106.hasNext() == false) goto L23;
        Map.Entry<Integer, ThreadExceptionItem> r107 = r106.next();
        r100.writeInt(r107.getKey().intValue());
        r107.getValue().writeToParcel(r100, r101);
        goto L19
    L23:
        return;
    L13:
        r100.writeInt(1);
        r100.writeDouble(r104.doubleValue());
        goto L14
    L9:
        r100.writeInt(1);
        r100.writeDouble(r103.doubleValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.intValue());
        goto L6
    }

    public final Double getCpuRate() {
        return this.cpuRate;
    }

    public final Double getCpuSpeed() {
        return this.cpuSpeed;
    }

    public final Integer getPid() {
        return this.pid;
    }

    public final HashMap<Integer, ThreadExceptionItem> getThreadMap() {
        return this.threadMap;
    }

    public final void setThreadMap(HashMap<Integer, ThreadExceptionItem> r100) {
        this.threadMap = r100;
    }

    public CpuInfo(Integer r100, Double r101, Double r102, HashMap<Integer, ThreadExceptionItem> r103) {
        this.pid = r100;
        this.cpuRate = r101;
        this.cpuSpeed = r102;
        this.threadMap = r103;
    }

    public /* synthetic */ CpuInfo(Integer r100, Double r101, Double r102, HashMap r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        this(r100, r101, r102, r103);
    }
}
