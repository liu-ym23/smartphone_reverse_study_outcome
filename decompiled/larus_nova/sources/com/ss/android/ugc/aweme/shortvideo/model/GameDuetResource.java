package com.ss.android.ugc.aweme.shortvideo.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.ugc.effectmanager.effect.model.Effect;

/* JADX INFO: loaded from: classes40.dex */
public class GameDuetResource implements Parcelable {
    public static final Parcelable.Creator<GameDuetResource> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f454189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Effect f454190b;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public GameDuetResource(Parcel r100) {
        this.f454189a = r100.readInt();
        this.f454190b = (Effect) r100.readParcelable(Effect.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f454189a);
        r100.writeParcelable(this.f454190b, r101);
    }
}
