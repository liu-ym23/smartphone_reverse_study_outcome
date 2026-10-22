package com.ss.android.ugc.aweme.shortvideo;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B/\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001cH\u0016R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/ClientCherEffectParam;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "matrix", "", "", "duration", "", "segUseCher", "", "([Ljava/lang/String;[D[Z)V", "getDuration", "()[D", "setDuration", "([D)V", "getMatrix", "()[Ljava/lang/String;", "setMatrix", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getSegUseCher", "()[Z", "setSegUseCher", "([Z)V", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class ClientCherEffectParam implements Serializable, Parcelable {
    public static final CREATOR CREATOR = null;

    @SerializedName("duration")
    private double[] duration;

    @SerializedName("matrix")
    private String[] matrix;

    @SerializedName("segUseCher")
    private boolean[] segUseCher;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/ClientCherEffectParam$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/ss/android/ugc/aweme/shortvideo/ClientCherEffectParam;", "<init>", "()V", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
    public static final class CREATOR implements Parcelable.Creator<ClientCherEffectParam> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(int r100) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public final ClientCherEffectParam createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new ClientCherEffectParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ClientCherEffectParam[] newArray(int r100) {
            return new ClientCherEffectParam[r100];
        }
    }

    static {
        CREATOR = new CREATOR(0);
    }

    public ClientCherEffectParam() {
        this(null, null, null, 7, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final double[] getDuration() {
        return this.duration;
    }

    public final String[] getMatrix() {
        return this.matrix;
    }

    public final boolean[] getSegUseCher() {
        return this.segUseCher;
    }

    public ClientCherEffectParam(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this(r100.createStringArray(), r100.createDoubleArray(), r100.createBooleanArray());
    }

    public final void setDuration(double[] r100) {
        this.duration = r100;
    }

    public final void setMatrix(String[] r100) {
        this.matrix = r100;
    }

    public final void setSegUseCher(boolean[] r100) {
        this.segUseCher = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeStringArray(this.matrix);
        r100.writeDoubleArray(this.duration);
        r100.writeBooleanArray(this.segUseCher);
    }

    public ClientCherEffectParam(String[] r100, double[] r101, boolean[] r102) {
        this.matrix = r100;
        this.duration = r101;
        this.segUseCher = r102;
    }

    public /* synthetic */ ClientCherEffectParam(String[] r100, double[] r101, boolean[] r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
