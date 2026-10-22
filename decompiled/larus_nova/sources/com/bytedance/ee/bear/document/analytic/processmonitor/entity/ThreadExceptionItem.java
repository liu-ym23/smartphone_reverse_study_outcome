package com.bytedance.ee.bear.document.analytic.processmonitor.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
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
        public final ThreadExceptionItem createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Integer r101 = null;
            if (r100.readInt() != 0) goto L5;
            Long r102 = null;
        L6:
            String r103 = r100.readString();
            if (r100.readInt() == 0) goto L11;
            r101 = Integer.valueOf(r100.readInt());
        L11:
            return new ThreadExceptionItem(r102, r103, r101);
        L5:
            r102 = Long.valueOf(r100.readLong());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ThreadExceptionItem[] newArray(int r100) {
            return new ThreadExceptionItem[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ ThreadExceptionItem copy$default(ThreadExceptionItem r100, Long r101, String r102, Integer r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.threadCpuTime;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.threadName;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.threadId;
    L12:
        return r100.copy(r101, r102, r103);
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

    public final ThreadExceptionItem copy(Long r100, String r101, Integer r102) {
        return new ThreadExceptionItem(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ThreadExceptionItem) == true) goto L8;
        return false;
    L8:
        ThreadExceptionItem r101 = (ThreadExceptionItem) r100;
        if (Intrinsics.areEqual(this.threadCpuTime, r101.threadCpuTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.threadName, r101.threadName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.threadId, r101.threadId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Long r100 = this.threadCpuTime;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.threadName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.threadId;
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
        return "ThreadExceptionItem(threadCpuTime=" + this.threadCpuTime + ", threadName=" + this.threadName + ", threadId=" + this.threadId + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Long r102 = this.threadCpuTime;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeString(this.threadName);
        Integer r103 = this.threadId;
        if (r103 != null) goto L9;
        r100.writeInt(0);
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        return;
    L5:
        r100.writeInt(1);
        r100.writeLong(r102.longValue());
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

    public ThreadExceptionItem(Long r100, String r101, Integer r102) {
        this.threadCpuTime = r100;
        this.threadName = r101;
        this.threadId = r102;
    }
}
