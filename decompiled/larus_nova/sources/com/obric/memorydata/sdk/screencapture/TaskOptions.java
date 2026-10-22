package com.obric.memorydata.sdk.screencapture;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.obric.memorydata.sdk.screencapture.rule.ScreenshotOption;
import com.obric.memorydata.sdk.screencapture.rule.ViewTreeOption;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/TaskOptions;", "Landroid/os/Parcelable;", IHostShare.ShareType.SCREENSHOT, "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotOption;", "viewTree", "Lcom/obric/memorydata/sdk/screencapture/rule/ViewTreeOption;", "<init>", "(Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotOption;Lcom/obric/memorydata/sdk/screencapture/rule/ViewTreeOption;)V", "getScreenshot", "()Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotOption;", "getViewTree", "()Lcom/obric/memorydata/sdk/screencapture/rule/ViewTreeOption;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TaskOptions implements Parcelable {
    public static final Parcelable.Creator<TaskOptions> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScreenshotOption f397210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewTreeOption f397211b;

    public static final class a implements Parcelable.Creator<TaskOptions> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TaskOptions createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ViewTreeOption r101 = null;
            if (r100.readInt() != 0) goto L5;
            ScreenshotOption r102 = null;
        L6:
            ScreenshotOption r103 = r102;
            if (r100.readInt() == 0) goto L11;
            r101 = ViewTreeOption.CREATOR.createFromParcel(r100);
        L11:
            return new TaskOptions(r103, r101);
        L5:
            r102 = ScreenshotOption.CREATOR.createFromParcel(r100);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final TaskOptions[] newArray(int r100) {
            return new TaskOptions[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public TaskOptions() {
        this(null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TaskOptions) == true) goto L8;
        return false;
    L8:
        TaskOptions r101 = (TaskOptions) r100;
        if (Intrinsics.areEqual(this.f397210a, r101.f397210a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397211b, r101.f397211b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        ScreenshotOption r100 = this.f397210a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ViewTreeOption r104 = this.f397211b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "TaskOptions(screenshot=" + this.f397210a + ", viewTree=" + this.f397211b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        ScreenshotOption r102 = this.f397210a;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        ViewTreeOption r103 = this.f397211b;
        if (r103 != null) goto L9;
        r100.writeInt(0);
        return;
    L9:
        r100.writeInt(1);
        r103.writeToParcel(r100, r101);
        return;
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    public TaskOptions(ScreenshotOption r100, ViewTreeOption r101) {
        this.f397210a = r100;
        this.f397211b = r101;
    }
}
