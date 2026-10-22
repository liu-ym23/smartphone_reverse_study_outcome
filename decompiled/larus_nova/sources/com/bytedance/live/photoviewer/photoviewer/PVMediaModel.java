package com.bytedance.live.photoviewer.photoviewer;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \b2\u00020\u0001:\u0001\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/live/photoviewer/photoviewer/PVMediaModel;", "Landroid/os/Parcelable;", "", "b", "I", "getType", "()I", "type", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "photoviewer_release"}, k = 1, mv = {1, 4, 0})
public final class PVMediaModel implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f255656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f255657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f255658c;

    public static final class a implements Parcelable.Creator<PVMediaModel> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PVMediaModel createFromParcel(Parcel r100) {
            return new PVMediaModel(r100.readString(), r100.readInt(), r100.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final PVMediaModel[] newArray(int r100) {
            return new PVMediaModel[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getType() {
        return this.f255657b;
    }

    public /* synthetic */ PVMediaModel(String r100, int r101) {
        this(r100, r101, 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f255656a);
        r100.writeInt(this.f255657b);
        r100.writeLong(this.f255658c);
    }

    public PVMediaModel(String r100, int r101, long r102) {
        this.f255656a = r100;
        this.f255657b = r101;
        this.f255658c = r102;
    }
}
