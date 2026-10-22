package com.ss.android.lark.profile.dto;

import android.os.Parcel;
import android.os.Parcelable;
import com.larksuite.framework.callback.Entity.ErrorResult;

/* JADX INFO: loaded from: classes37.dex */
public class ErrorResultWrapper implements Parcelable {
    public static final Parcelable.Creator<ErrorResultWrapper> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ErrorResult f438831a;

    public class a implements Parcelable.Creator<ErrorResultWrapper> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ErrorResultWrapper createFromParcel(Parcel r100) {
            return new ErrorResultWrapper(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ErrorResultWrapper[] newArray(int r100) {
            return new ErrorResultWrapper[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ErrorResultWrapper(Parcel r100) {
        this.f438831a = (ErrorResult) r100.readSerializable();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeSerializable(this.f438831a);
    }
}
