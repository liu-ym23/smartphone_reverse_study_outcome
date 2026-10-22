package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.ss.android.lark.diskmanage.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/bridge/NativeStatisticsInfo;", "Lcom/ss/android/lark/diskmanage/NonProguard;", "openTimestamp", "", "<init>", "(J)V", "getOpenTimestamp", "()J", "toString", "", "component1", "copy", "equals", "", "other", "", "hashCode", "", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativeStatisticsInfo implements NonProguard {
    private final long openTimestamp;

    public static /* synthetic */ NativeStatisticsInfo copy$default(NativeStatisticsInfo r100, long r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.openTimestamp;
    L6:
        return r100.copy(r101);
    }

    public final long component1() {
        return this.openTimestamp;
    }

    public final NativeStatisticsInfo copy(long r100) {
        return new NativeStatisticsInfo(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NativeStatisticsInfo) == true) goto L9;
        return false;
    L9:
        if (this.openTimestamp == ((NativeStatisticsInfo) r100).openTimestamp) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        long r100 = this.openTimestamp;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public String toString() {
        return "NativeStatisticsInfo(openTimestamp='" + this.openTimestamp + "')";
    }

    public final long getOpenTimestamp() {
        return this.openTimestamp;
    }

    public NativeStatisticsInfo(long r100) {
        this.openTimestamp = r100;
    }
}
