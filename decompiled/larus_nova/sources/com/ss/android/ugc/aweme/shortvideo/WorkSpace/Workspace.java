package com.ss.android.ugc.aweme.shortvideo.WorkSpace;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.ugc.tools.CukaieManifest;

/* JADX INFO: loaded from: classes40.dex */
public final class Workspace implements Parcelable {
    public static final Parcelable.Creator<Workspace> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WorkspaceImpl f454183a;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public Workspace(Parcel r100) {
        WorkspaceImpl r101 = (WorkspaceImpl) r100.readParcelable(CukaieManifest.a().getClassLoader());
        this.f454183a = r101;
        if ((r101 instanceof OutRefHolder) == false) goto L6;
        ((OutRefHolder) r101).a();
        return;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.f454183a, r101);
    }
}
