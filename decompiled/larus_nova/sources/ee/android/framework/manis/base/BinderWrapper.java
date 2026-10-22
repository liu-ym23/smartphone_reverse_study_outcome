package ee.android.framework.manis.base;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes41.dex */
public class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f472257a;

    public class a implements Parcelable.Creator<BinderWrapper> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BinderWrapper createFromParcel(Parcel r100) {
            return new BinderWrapper(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final BinderWrapper[] newArray(int r100) {
            return new BinderWrapper[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public BinderWrapper(Parcel r100) {
        this.f472257a = r100.readStrongBinder();
    }

    public BinderWrapper(IBinder r100) {
        this.f472257a = r100;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeStrongBinder(this.f472257a);
    }
}
