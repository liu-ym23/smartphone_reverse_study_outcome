package com.obric.capabilitykit.common.execution;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.obric.capabilitykit.common.intent.IntentResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001R&\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/obric/capabilitykit/common/execution/IntentExecutionRecord;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "d", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "getResult", "()Lcom/obric/capabilitykit/common/intent/IntentResult;", "setResult", "(Lcom/obric/capabilitykit/common/intent/IntentResult;)V", "result", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
public final class IntentExecutionRecord implements Parcelable {
    public static final Parcelable.Creator<IntentExecutionRecord> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f396174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f396175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f396176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IntentResult<?> f396177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f396178e;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<IntentExecutionRecord> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final IntentExecutionRecord createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r101 = r110.readString();
            String r102 = r110.readString();
            String r103 = r110.readString();
            IntentResult r104 = (IntentResult) r110.readParcelable(IntentExecutionRecord.class.getClassLoader());
            int r105 = 1;
            if (r110.readInt() == 0) goto L5;
            boolean r106 = true;
        L6:
            IntentExecutionRecord r107 = new IntentExecutionRecord(r101, r102, r103, r104, r106);
            int r108 = Math.min(r100, 0);
            ClassLoader r109 = a.class.getClassLoader();
        L7:
            if (r105 > r108) goto L9;
            r105 = r105 + 1;
        L9:
            if (r105 > r100) goto L11;
            joa.a.d(r110, r109);
            r105 = r105 + 1;
            goto L9
        L11:
            return r107;
        L5:
            r106 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final IntentExecutionRecord[] newArray(int r100) {
            return new IntentExecutionRecord[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public IntentExecutionRecord(String r100, String r101, String r102, IntentResult<?> r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "intentName");
        Intrinsics.checkNotNullParameter(r101, "implPackage");
        Intrinsics.checkNotNullParameter(r102, "implClassName");
        Intrinsics.checkNotNullParameter(r103, "result");
        this.f396174a = r100;
        this.f396175b = r101;
        this.f396176c = r102;
        this.f396177d = r103;
        this.f396178e = r104;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IntentExecutionRecord) == true) goto L8;
        return false;
    L8:
        IntentExecutionRecord r101 = (IntentExecutionRecord) r100;
        if (Intrinsics.areEqual(this.f396174a, r101.f396174a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f396175b, r101.f396175b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f396176c, r101.f396176c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f396177d, r101.f396177d) == true) goto L21;
        return false;
    L21:
        if (this.f396178e == r101.f396178e) goto L23;
        return false;
    L23:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final int hashCode() {
        int r100 = ((((((this.f396174a.hashCode() * 31) + this.f396175b.hashCode()) * 31) + this.f396176c.hashCode()) * 31) + this.f396177d.hashCode()) * 31;
        boolean r101 = this.f396178e;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return r100 + r102;
    }

    public final void setResult(IntentResult<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f396177d = r100;
    }

    public final String toString() {
        return "IntentExecutionRecord(intentName=" + this.f396174a + ", implPackage=" + this.f396175b + ", implClassName=" + this.f396176c + ", result=" + this.f396177d + ", requiresAuthorization=" + this.f396178e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.f396174a);
        r100.writeString(this.f396175b);
        r100.writeString(this.f396176c);
        r100.writeParcelable(this.f396177d, r101);
        r100.writeInt(this.f396178e ? 1 : 0);
    }
}
