package com.hihonor.honorid;

import android.os.Parcelable;
import com.hihonor.honorid.UseCase.RequestValues;

/* JADX INFO: loaded from: classes23.dex */
public abstract class UseCase<Q extends RequestValues> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Q f276524a;

    public static abstract class RequestValues implements Parcelable {
        public RequestValues() {
        }
    }

    public UseCase() {
    }
}
