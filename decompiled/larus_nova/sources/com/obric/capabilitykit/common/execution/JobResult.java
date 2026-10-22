package com.obric.capabilitykit.common.execution;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/obric/capabilitykit/common/execution/JobResult;", "Landroid/os/Parcelable;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
public final class JobResult implements Parcelable {
    public static final Parcelable.Creator<JobResult> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f396179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f396180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f396181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<IntentExecutionRecord> f396182d;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<JobResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final JobResult createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            long r101 = r110.readLong();
            int r102 = 1;
            if (r110.readInt() == 0) goto L5;
            boolean r103 = true;
        L6:
            String r104 = r110.readString();
            int r105 = r110.readInt();
            ArrayList r106 = new ArrayList(r105);
            int r107 = 0;
        L7:
            if (r107 == r105) goto L9;
            r106.add(IntentExecutionRecord.CREATOR.createFromParcel(r110));
            r107 = r107 + 1;
            goto L7
        L9:
            JobResult r108 = new JobResult(r101, r103, r104, r106);
            int r109 = Math.min(r100, 0);
            ClassLoader r111 = a.class.getClassLoader();
        L10:
            if (r102 > r109) goto L12;
            r102 = r102 + 1;
        L12:
            if (r102 > r100) goto L14;
            joa.a.d(r110, r111);
            r102 = r102 + 1;
            goto L12
        L14:
            return r108;
        L5:
            r103 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final JobResult[] newArray(int r100) {
            return new JobResult[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public JobResult(long r100, boolean r101, String r102, List<IntentExecutionRecord> r103) {
        Intrinsics.checkNotNullParameter(r102, "message");
        Intrinsics.checkNotNullParameter(r103, "execRecords");
        this.f396179a = r100;
        this.f396180b = r101;
        this.f396181c = r102;
        this.f396182d = r103;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof JobResult) == true) goto L8;
        return false;
    L8:
        JobResult r101 = (JobResult) r100;
        if (this.f396179a == r101.f396179a) goto L12;
        return false;
    L12:
        if (this.f396180b == r101.f396180b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f396181c, r101.f396181c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f396182d, r101.f396182d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    public final int hashCode() {
        long r100 = this.f396179a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        boolean r102 = this.f396180b;
        ?? r103 = r102;
        if (r102 == false) goto L6;
        r103 = 1;
    L6:
        return ((((r101 + r103) * 31) + this.f396181c.hashCode()) * 31) + this.f396182d.hashCode();
    }

    public final String toString() {
        return "JobResult(questionId=" + this.f396179a + ", hasError=" + this.f396180b + ", message=" + this.f396181c + ", execRecords=" + this.f396182d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeLong(this.f396179a);
        r100.writeInt(this.f396180b ? 1 : 0);
        r100.writeString(this.f396181c);
        List<IntentExecutionRecord> r102 = this.f396182d;
        r100.writeInt(r102.size());
        Iterator<IntentExecutionRecord> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().writeToParcel(r100, r101);
        goto L4
    }
}
