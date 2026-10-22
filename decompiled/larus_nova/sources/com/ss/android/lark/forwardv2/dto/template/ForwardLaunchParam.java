package com.ss.android.lark.forwardv2.dto.template;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes36.dex */
public class ForwardLaunchParam implements Parcelable {
    public static final Parcelable.Creator<ForwardLaunchParam> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f424848a;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LaunchMode {
        public static final int POP_OVER = 0;
        public static final int WINDOW = 1;
    }

    public class a implements Parcelable.Creator<ForwardLaunchParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardLaunchParam createFromParcel(Parcel r100) {
            return new ForwardLaunchParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardLaunchParam[] newArray(int r100) {
            return new ForwardLaunchParam[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ForwardLaunchParam() {
    }

    public ForwardLaunchParam(Parcel r100) {
        this.f424848a = r100.readInt();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f424848a);
    }
}
