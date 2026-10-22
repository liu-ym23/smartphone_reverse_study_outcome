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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public final CpuInfo createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            HashMap r1 = null;
            if (r9.readInt() != 0) goto L5;
            Integer r0 = null;
        L7:
            if (r9.readInt() != 0) goto L9;
            Double r2 = null;
        L11:
            if (r9.readInt() != 0) goto L13;
            Double r3 = null;
        L15:
            if (r9.readInt() == 0) goto L22;
            int r4 = r9.readInt();
            HashMap r5 = new HashMap(r4);
            int r6 = 0;
        L18:
            if (r6 == r4) goto L20;
            r5.put(Integer.valueOf(r9.readInt()), ThreadExceptionItem.CREATOR.createFromParcel(r9));
            r6 = r6 + 1;
            goto L18
        L20:
            r1 = r5;
        L22:
            return new CpuInfo(r0, r2, r3, r1);
        L13:
            r3 = Double.valueOf(r9.readDouble());
            goto L15
        L9:
            r2 = Double.valueOf(r9.readDouble());
            goto L11
        L5:
            r0 = Integer.valueOf(r9.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final CpuInfo[] newArray(int r1) {
            return new CpuInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CpuInfo copy$default(CpuInfo r0, Integer r1, Double r2, Double r3, HashMap r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.pid;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.cpuRate;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.cpuSpeed;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.threadMap;
    L15:
        return r0.copy(r1, r2, r3, r4);
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

    public final CpuInfo copy(Integer r2, Double r3, Double r4, HashMap<Integer, ThreadExceptionItem> r5) {
        return new CpuInfo(r2, r3, r4, r5);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CpuInfo) == true) goto L8;
        return false;
    L8:
        CpuInfo r6 = (CpuInfo) r5;
        if (Intrinsics.areEqual(this.pid, r6.pid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cpuRate, r6.cpuRate) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cpuSpeed, r6.cpuSpeed) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.threadMap, r6.threadMap) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.pid;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Double r4 = this.cpuRate;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Double r7 = this.cpuSpeed;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        HashMap<Integer, ThreadExceptionItem> r10 = this.threadMap;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CpuInfo(pid=" + this.pid + ", cpuRate=" + this.cpuRate + ", cpuSpeed=" + this.cpuSpeed + ", threadMap=" + this.threadMap + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "dest");
        Integer r0 = this.pid;
        if (r0 != null) goto L5;
        r6.writeInt(0);
    L6:
        Double r1 = this.cpuRate;
        if (r1 != null) goto L9;
        r6.writeInt(0);
    L10:
        Double r2 = this.cpuSpeed;
        if (r2 != null) goto L13;
        r6.writeInt(0);
    L14:
        HashMap<Integer, ThreadExceptionItem> r3 = this.threadMap;
        if (r3 != null) goto L17;
        r6.writeInt(0);
        return;
    L17:
        r6.writeInt(1);
        r6.writeInt(r3.size());
        Iterator<Map.Entry<Integer, ThreadExceptionItem>> r4 = r3.entrySet().iterator();
    L19:
        if (r4.hasNext() == false) goto L23;
        Map.Entry<Integer, ThreadExceptionItem> r5 = r4.next();
        r6.writeInt(r5.getKey().intValue());
        r5.getValue().writeToParcel(r6, r7);
        goto L19
    L23:
        return;
    L13:
        r6.writeInt(1);
        r6.writeDouble(r2.doubleValue());
        goto L14
    L9:
        r6.writeInt(1);
        r6.writeDouble(r1.doubleValue());
        goto L10
    L5:
        r6.writeInt(1);
        r6.writeInt(r0.intValue());
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

    public final void setThreadMap(HashMap<Integer, ThreadExceptionItem> r1) {
        this.threadMap = r1;
    }

    public CpuInfo(Integer r1, Double r2, Double r3, HashMap<Integer, ThreadExceptionItem> r4) {
        this.pid = r1;
        this.cpuRate = r2;
        this.cpuSpeed = r3;
        this.threadMap = r4;
    }

    public /* synthetic */ CpuInfo(Integer r1, Double r2, Double r3, HashMap r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        this(r1, r2, r3, r4);
    }
}
