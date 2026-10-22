package pub.devrel.easypermissions;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes41.dex */
public class AppSettingsDialog implements Parcelable {
    public static final Parcelable.Creator<AppSettingsDialog> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f530762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f530763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f530764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f530765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f530766e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f530767f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f530768g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f530769h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Context f530770i;

    public static class a implements Parcelable.Creator<AppSettingsDialog> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AppSettingsDialog createFromParcel(Parcel r100) {
            return new AppSettingsDialog(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final AppSettingsDialog[] newArray(int r100) {
            return new AppSettingsDialog[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public AppSettingsDialog(Parcel r100) {
        this.f530762a = r100.readInt();
        this.f530763b = r100.readString();
        this.f530764c = r100.readString();
        this.f530765d = r100.readString();
        this.f530766e = r100.readString();
        this.f530767f = r100.readInt();
        this.f530768g = r100.readInt();
    }

    public final void a(Object r100) {
        this.f530769h = r100;
        if ((r100 instanceof Activity) == false) goto L6;
        this.f530770i = (Activity) r100;
        return;
    L6:
        if ((r100 instanceof Fragment) == false) goto L10;
        this.f530770i = ((Fragment) r100).getContext();
        return;
    L10:
        throw new IllegalStateException("Unknown object: " + r100);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f530762a);
        r100.writeString(this.f530763b);
        r100.writeString(this.f530764c);
        r100.writeString(this.f530765d);
        r100.writeString(this.f530766e);
        r100.writeInt(this.f530767f);
        r100.writeInt(this.f530768g);
    }

    public AppSettingsDialog(Object r100, String r101, String r102, String r103, String r104, int r105) {
        a(r100);
        this.f530762a = -1;
        this.f530763b = r101;
        this.f530764c = r102;
        this.f530765d = r103;
        this.f530766e = r104;
        this.f530767f = r105;
        this.f530768g = 0;
    }
}
