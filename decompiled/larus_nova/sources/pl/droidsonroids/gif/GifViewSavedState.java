package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: loaded from: classes41.dex */
class GifViewSavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<GifViewSavedState> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[][] f529705a;

    public class a implements Parcelable.Creator<GifViewSavedState> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GifViewSavedState createFromParcel(Parcel r100) {
            return new GifViewSavedState(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final GifViewSavedState[] newArray(int r100) {
            return new GifViewSavedState[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public GifViewSavedState(Parcel r100) {
        super(r100);
        this.f529705a = new long[r100.readInt()][];
        int r101 = 0;
    L3:
        long[][] r102 = this.f529705a;
        if (r101 >= r102.length) goto L6;
        r102[r101] = r100.createLongArray();
        r101 = r101 + 1;
        goto L3
    }

    public GifViewSavedState(Parcelable r100, Drawable... r101) {
        super(r100);
        this.f529705a = new long[r101.length][];
        int r102 = 0;
    L4:
        if (r102 >= r101.length) goto L10;
        Drawable r103 = r101[r102];
        if ((r103 instanceof d) == false) goto L8;
        this.f529705a[r102] = ((d) r103).f529714g.l();
    L9:
        r102 = r102 + 1;
        goto L4
    L8:
        this.f529705a[r102] = null;
        goto L9
    }

    public final void a(Drawable r100, int r101) {
        long[] r102 = this.f529705a[r101];
        if (r102 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof d) == false) goto L9;
        d r103 = (d) r100;
        r103.d(r103.f529714g.w(r102, r103.f529713f));
        return;
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeInt(this.f529705a.length);
        long[][] r102 = this.f529705a;
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r100.writeLongArray(r102[r104]);
        r104 = r104 + 1;
        goto L3
    }

    public GifViewSavedState(Parcelable r100, long[] r101) {
        super(r100);
        this.f529705a = new long[][]{r101};
    }
}
