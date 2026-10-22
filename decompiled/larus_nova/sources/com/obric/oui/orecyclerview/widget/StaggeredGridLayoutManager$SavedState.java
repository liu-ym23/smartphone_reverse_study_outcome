package com.obric.oui.orecyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public class StaggeredGridLayoutManager$SavedState implements Parcelable {
    public static final Parcelable.Creator<StaggeredGridLayoutManager$SavedState> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f401755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f401756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f401757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f401758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f401759e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f401760f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> f401761g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f401762h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f401763i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f401764j;

    public class a implements Parcelable.Creator<StaggeredGridLayoutManager$SavedState> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final StaggeredGridLayoutManager$SavedState createFromParcel(Parcel r100) {
            return new StaggeredGridLayoutManager$SavedState(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final StaggeredGridLayoutManager$SavedState[] newArray(int r100) {
            return new StaggeredGridLayoutManager$SavedState[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public StaggeredGridLayoutManager$SavedState() {
    }

    public StaggeredGridLayoutManager$SavedState(Parcel r100) {
        this.f401755a = r100.readInt();
        this.f401756b = r100.readInt();
        int r101 = r100.readInt();
        this.f401757c = r101;
        if (r101 <= 0) goto L5;
        int[] r102 = new int[r101];
        this.f401758d = r102;
        r100.readIntArray(r102);
    L5:
        int r103 = r100.readInt();
        this.f401759e = r103;
        if (r103 <= 0) goto L8;
        int[] r104 = new int[r103];
        this.f401760f = r104;
        r100.readIntArray(r104);
    L8:
        boolean r105 = false;
        if (r100.readInt() != 1) goto L11;
        boolean r106 = true;
    L12:
        this.f401762h = r106;
        if (r100.readInt() != 1) goto L15;
        boolean r107 = true;
    L16:
        this.f401763i = r107;
        if (r100.readInt() != 1) goto L19;
        r105 = true;
    L19:
        this.f401764j = r105;
        this.f401761g = r100.readArrayList(StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem.class.getClassLoader());
        return;
    L15:
        r107 = false;
        goto L16
    L11:
        r106 = false;
        goto L12
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f401755a);
        r100.writeInt(this.f401756b);
        r100.writeInt(this.f401757c);
        if (this.f401757c <= 0) goto L5;
        r100.writeIntArray(this.f401758d);
    L5:
        r100.writeInt(this.f401759e);
        if (this.f401759e <= 0) goto L8;
        r100.writeIntArray(this.f401760f);
    L8:
        r100.writeInt(this.f401762h ? 1 : 0);
        r100.writeInt(this.f401763i ? 1 : 0);
        r100.writeInt(this.f401764j ? 1 : 0);
        r100.writeList(this.f401761g);
    }
}
