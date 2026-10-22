package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.ss.android.lark.diskmanage.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/bridge/StartChooseRepeatParam;", "Lcom/ss/android/lark/diskmanage/NonProguard;", "rrule", "", "timestamp", "", "<init>", "(Ljava/lang/String;J)V", "getRrule", "()Ljava/lang/String;", "getTimestamp", "()J", "toString", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StartChooseRepeatParam implements NonProguard {
    private final String rrule;
    private final long timestamp;

    public static /* synthetic */ StartChooseRepeatParam copy$default(StartChooseRepeatParam r100, String r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.rrule;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.timestamp;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.rrule;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final StartChooseRepeatParam copy(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "rrule");
        return new StartChooseRepeatParam(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof StartChooseRepeatParam) == true) goto L8;
        return false;
    L8:
        StartChooseRepeatParam r101 = (StartChooseRepeatParam) r100;
        if (Intrinsics.areEqual(this.rrule, r101.rrule) == true) goto L12;
        return false;
    L12:
        if (this.timestamp == r101.timestamp) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.rrule.hashCode() * 31;
        long r101 = this.timestamp;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public String toString() {
        return "StartChooseRepeatParam(rrule='" + this.rrule + "', timestamp=" + this.timestamp + ')';
    }

    public final String getRrule() {
        return this.rrule;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public StartChooseRepeatParam(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "rrule");
        this.rrule = r100;
        this.timestamp = r101;
    }
}
