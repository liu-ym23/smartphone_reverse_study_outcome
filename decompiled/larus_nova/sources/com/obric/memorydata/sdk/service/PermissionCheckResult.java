package com.obric.memorydata.sdk.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.obric.capabilitykit.common.UtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J#\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0011HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/sdk/service/PermissionCheckResult;", "Landroid/os/Parcelable;", "missedPermissions", "", "", "feedbackText", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getMissedPermissions", "()Ljava/util/List;", "getFeedbackText", "()Ljava/lang/String;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "describeContents", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PermissionCheckResult implements Parcelable {
    public static final a CREATOR = null;
    private final String feedbackText;
    private final List<String> missedPermissions;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<PermissionCheckResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PermissionCheckResult createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return (PermissionCheckResult) GsonProtectorUtils.fromJson(UtilsKt.a(), r100.readString(), PermissionCheckResult.class);
        }

        @Override // android.os.Parcelable.Creator
        public final PermissionCheckResult[] newArray(int r100) {
            return new PermissionCheckResult[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PermissionCheckResult copy$default(PermissionCheckResult r100, List r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.missedPermissions;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.feedbackText;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<String> component1() {
        return this.missedPermissions;
    }

    public final String component2() {
        return this.feedbackText;
    }

    public final PermissionCheckResult copy(List<String> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "missedPermissions");
        Intrinsics.checkNotNullParameter(r101, "feedbackText");
        return new PermissionCheckResult(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PermissionCheckResult) == true) goto L8;
        return false;
    L8:
        PermissionCheckResult r101 = (PermissionCheckResult) r100;
        if (Intrinsics.areEqual(this.missedPermissions, r101.missedPermissions) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.feedbackText, r101.feedbackText) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.missedPermissions.hashCode() * 31) + this.feedbackText.hashCode();
    }

    public String toString() {
        return "PermissionCheckResult(missedPermissions=" + this.missedPermissions + ", feedbackText=" + this.feedbackText + ')';
    }

    public final String getFeedbackText() {
        return this.feedbackText;
    }

    public final List<String> getMissedPermissions() {
        return this.missedPermissions;
    }

    public PermissionCheckResult(List<String> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "missedPermissions");
        Intrinsics.checkNotNullParameter(r101, "feedbackText");
        this.missedPermissions = r100;
        this.feedbackText = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(GsonProtectorUtils.toJson(UtilsKt.a(), this));
    }
}
