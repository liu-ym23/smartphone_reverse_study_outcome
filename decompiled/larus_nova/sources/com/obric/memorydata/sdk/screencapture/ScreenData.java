package com.obric.memorydata.sdk.screencapture;

import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.livehostapi.business.IHostShare;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003JI\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001J\u0006\u0010(\u001a\u00020)J\u0013\u0010*\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020)HÖ\u0001J\t\u0010.\u001a\u00020\u0007HÖ\u0001J\u0016\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020)R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u00064"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/ScreenData;", "Landroid/os/Parcelable;", IHostShare.ShareType.SCREENSHOT, "Landroid/graphics/Bitmap;", "hardwareBuffer", "Landroid/hardware/HardwareBuffer;", "heifScreenshotPath", "", "isVertical", "", "viewTree", "", "Lcom/obric/memorydata/sdk/screencapture/ViewTreeNode;", "<init>", "(Landroid/graphics/Bitmap;Landroid/hardware/HardwareBuffer;Ljava/lang/String;ZLjava/util/List;)V", "getScreenshot", "()Landroid/graphics/Bitmap;", "setScreenshot", "(Landroid/graphics/Bitmap;)V", "getHardwareBuffer", "()Landroid/hardware/HardwareBuffer;", "setHardwareBuffer", "(Landroid/hardware/HardwareBuffer;)V", "getHeifScreenshotPath", "()Ljava/lang/String;", "setHeifScreenshotPath", "(Ljava/lang/String;)V", "()Z", "setVertical", "(Z)V", "getViewTree", "()Ljava/util/List;", "setViewTree", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenData implements Parcelable {
    public static final Parcelable.Creator<ScreenData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f397202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HardwareBuffer f397203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f397204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f397205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<ViewTreeNode> f397206e;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<ScreenData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ScreenData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Bitmap r101 = (Bitmap) r100.readParcelable(ScreenData.class.getClassLoader());
            HardwareBuffer r102 = (HardwareBuffer) r100.readParcelable(ScreenData.class.getClassLoader());
            String r103 = r100.readString();
            int r104 = 0;
            if (r100.readInt() == 0) goto L5;
            boolean r105 = true;
        L7:
            if (r100.readInt() != 0) goto L9;
            ArrayList r106 = null;
        L13:
            return new ScreenData(r101, r102, r103, r105, r106);
        L9:
            int r107 = r100.readInt();
            r106 = new ArrayList(r107);
        L10:
            if (r104 == r107) goto L13;
            r106.add(ViewTreeNode.CREATOR.createFromParcel(r100));
            r104 = r104 + 1;
            goto L10
        L5:
            r105 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ScreenData[] newArray(int r100) {
            return new ScreenData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ScreenData() {
        this(null, null, null, false, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ScreenData) == true) goto L8;
        return false;
    L8:
        ScreenData r101 = (ScreenData) r100;
        if (Intrinsics.areEqual(this.f397202a, r101.f397202a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397203b, r101.f397203b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397204c, r101.f397204c) == true) goto L18;
        return false;
    L18:
        if (this.f397205d == r101.f397205d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f397206e, r101.f397206e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Bitmap r100 = this.f397202a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        HardwareBuffer r104 = this.f397203b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f397204c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f397205d == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        List<ViewTreeNode> r112 = this.f397206e;
        if (r112 == null) goto L23;
        r101 = r112.hashCode();
    L23:
        return r111 + r101;
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ScreenData(screenshot=" + this.f397202a + ", hardwareBuffer=" + this.f397203b + ", heifScreenshotPath=" + this.f397204c + ", isVertical=" + this.f397205d + ", viewTree=" + this.f397206e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeParcelable(this.f397202a, r101);
        r100.writeParcelable(this.f397203b, r101);
        r100.writeString(this.f397204c);
        r100.writeInt(this.f397205d ? 1 : 0);
        List<ViewTreeNode> r102 = this.f397206e;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<ViewTreeNode> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        r103.next().writeToParcel(r100, r101);
        goto L7
    }

    public ScreenData(Bitmap r100, HardwareBuffer r101, String r102, boolean r103, List<ViewTreeNode> r104) {
        this.f397202a = r100;
        this.f397203b = r101;
        this.f397204c = r102;
        this.f397205d = r103;
        this.f397206e = r104;
    }
}
