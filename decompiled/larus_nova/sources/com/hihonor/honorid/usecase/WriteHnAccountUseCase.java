package com.hihonor.honorid.usecase;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.hihonor.honorid.UseCase;
import com.hihonor.honorid.core.data.HonorAccount;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes23.dex */
public final class WriteHnAccountUseCase extends UseCase<RequestValues> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f276631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<HonorAccount> f276632c;

    public static final class RequestValues extends UseCase.RequestValues {
        public static final Parcelable.Creator<RequestValues> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f276633a;

        public class a implements Parcelable.Creator<RequestValues> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final RequestValues createFromParcel(Parcel r100) {
                return new RequestValues(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final RequestValues[] newArray(int r100) {
                return new RequestValues[r100];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        public RequestValues(Parcel r100) {
            this.f276633a = r100.readString();
        }

        public RequestValues(String r100) {
            this.f276633a = r100;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeString(this.f276633a);
        }
    }

    public WriteHnAccountUseCase(Context r100, ArrayList r101) {
        this.f276631b = r100;
        this.f276632c = r101;
    }
}
