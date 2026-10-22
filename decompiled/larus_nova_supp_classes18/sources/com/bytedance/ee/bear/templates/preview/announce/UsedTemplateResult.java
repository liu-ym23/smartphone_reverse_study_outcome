package com.bytedance.ee.bear.templates.preview.announce;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0007HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0011\u001a\u00020\u0007J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/announce/UsedTemplateResult;", "Landroid/os/Parcelable;", "Lcom/bytedance/ee/util/io/NonProguard;", "Lcom/bytedance/ee/bear/contract/Result;", "ObjToken", "", "NewRev", "", "<init>", "(Ljava/lang/String;I)V", "getObjToken", "()Ljava/lang/String;", "getNewRev", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UsedTemplateResult extends Result<UsedTemplateResult> implements Parcelable, NonProguard {
    public static final Parcelable.Creator<UsedTemplateResult> CREATOR = null;
    private final int NewRev;
    private final String ObjToken;

    public static final class a implements Parcelable.Creator<UsedTemplateResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UsedTemplateResult createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            return new UsedTemplateResult(r3.readString(), r3.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final UsedTemplateResult[] newArray(int r1) {
            return new UsedTemplateResult[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ UsedTemplateResult copy$default(UsedTemplateResult r0, String r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.ObjToken;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.NewRev;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.ObjToken;
    }

    public final int component2() {
        return this.NewRev;
    }

    public final UsedTemplateResult copy(String r2, int r3) {
        return new UsedTemplateResult(r2, r3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UsedTemplateResult) == true) goto L8;
        return false;
    L8:
        UsedTemplateResult r6 = (UsedTemplateResult) r5;
        if (Intrinsics.areEqual(this.ObjToken, r6.ObjToken) == true) goto L12;
        return false;
    L12:
        if (this.NewRev == r6.NewRev) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.ObjToken;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + this.NewRev;
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "UsedTemplateResult(ObjToken=" + this.ObjToken + ", NewRev=" + this.NewRev + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.ObjToken);
        r1.writeInt(this.NewRev);
    }

    public final int getNewRev() {
        return this.NewRev;
    }

    public final String getObjToken() {
        return this.ObjToken;
    }

    public UsedTemplateResult(String r1, int r2) {
        this.ObjToken = r1;
        this.NewRev = r2;
    }
}
