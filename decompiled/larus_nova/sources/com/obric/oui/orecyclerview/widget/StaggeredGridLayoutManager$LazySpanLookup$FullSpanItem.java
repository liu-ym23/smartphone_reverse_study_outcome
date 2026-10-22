package com.obric.oui.orecyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes34.dex */
class StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem implements Parcelable {
    public static final Parcelable.Creator<StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f401751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f401752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f401753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f401754d;

    public class a implements Parcelable.Creator<StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem createFromParcel(Parcel r100) {
            return new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem[] newArray(int r100) {
            return new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.f401751a + ", mGapDir=" + this.f401752b + ", mHasUnwantedGapAfter=" + this.f401754d + ", mGapPerSpan=" + Arrays.toString(this.f401753c) + '}';
    }

    public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem() {
    }

    public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem(Parcel r100) {
        this.f401751a = r100.readInt();
        this.f401752b = r100.readInt();
        boolean r101 = true;
        if (r100.readInt() == 1) goto L6;
        r101 = false;
    L6:
        this.f401754d = r101;
        int r102 = r100.readInt();
        if (r102 <= 0) goto L10;
        int[] r103 = new int[r102];
        this.f401753c = r103;
        r100.readIntArray(r103);
        return;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f401751a);
        r100.writeInt(this.f401752b);
        r100.writeInt(this.f401754d ? 1 : 0);
        int[] r102 = this.f401753c;
        if (r102 != null) goto L5;
    L7:
        r100.writeInt(0);
        return;
    L5:
        if (r102.length <= 0) goto L7;
        r100.writeInt(r102.length);
        r100.writeIntArray(this.f401753c);
    }
}
