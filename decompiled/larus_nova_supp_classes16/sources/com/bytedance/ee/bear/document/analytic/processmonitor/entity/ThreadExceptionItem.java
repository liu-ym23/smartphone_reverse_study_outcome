package com.bytedance.ee.bear.document.analytic.processmonitor.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J2\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\bJ\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\bR\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/document/analytic/processmonitor/entity/ThreadExceptionItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "Landroid/os/Parcelable;", "threadCpuTime", "", "threadName", "", "threadId", "", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)V", "getThreadCpuTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getThreadName", "()Ljava/lang/String;", "getThreadId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/ee/bear/document/analytic/processmonitor/entity/ThreadExceptionItem;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThreadExceptionItem implements NonProguard, Parcelable {
    public static final Parcelable.Creator<ThreadExceptionItem> CREATOR = null;
    private final Long threadCpuTime;
    private final Integer threadId;
    private final String threadName;

    public static final class a implements Parcelable.Creator<ThreadExceptionItem> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ThreadExceptionItem createFromParcel(Parcel r6) {
            Intrinsics.checkNotNullParameter(r6, "parcel");
            Integer r2 = null;
            if (r6.readInt() != 0) goto L5;
            Long r1 = null;
        L6:
            String r3 = r6.readString();
            if (r6.readInt() == 0) goto L11;
            r2 = Integer.valueOf(r6.readInt());
        L11:
            return new ThreadExceptionItem(r1, r3, r2);
        L5:
            r1 = Long.valueOf(r6.readLong());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ThreadExceptionItem[] newArray(int r1) {
            return new ThreadExceptionItem[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ ThreadExceptionItem copy$default(ThreadExceptionItem r0, Long r1, String r2, Integer r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.threadCpuTime;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.threadName;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.threadId;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Long component1() {
        return this.threadCpuTime;
    }

    public final String component2() {
        return this.threadName;
    }

    public final Integer component3() {
        return this.threadId;
    }

    public final ThreadExceptionItem copy(Long r2, String r3, Integer r4) {
        return new ThreadExceptionItem(r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ThreadExceptionItem) == true) goto L8;
        return false;
    L8:
        ThreadExceptionItem r6 = (ThreadExceptionItem) r5;
        if (Intrinsics.areEqual(this.threadCpuTime, r6.threadCpuTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.threadName, r6.threadName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.threadId, r6.threadId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Long r0 = this.threadCpuTime;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.threadName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.threadId;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ThreadExceptionItem(threadCpuTime=" + this.threadCpuTime + ", threadName=" + this.threadName + ", threadId=" + this.threadId + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        Long r7 = this.threadCpuTime;
        if (r7 != null) goto L5;
        r5.writeInt(0);
    L6:
        r5.writeString(this.threadName);
        Integer r8 = this.threadId;
        if (r8 != null) goto L9;
        r5.writeInt(0);
        return;
    L9:
        r5.writeInt(1);
        r5.writeInt(r8.intValue());
        return;
    L5:
        r5.writeInt(1);
        r5.writeLong(r7.longValue());
        goto L6
    }

    public final Long getThreadCpuTime() {
        return this.threadCpuTime;
    }

    public final Integer getThreadId() {
        return this.threadId;
    }

    public final String getThreadName() {
        return this.threadName;
    }

    public ThreadExceptionItem(Long r1, String r2, Integer r3) {
        this.threadCpuTime = r1;
        this.threadName = r2;
        this.threadId = r3;
    }
}
