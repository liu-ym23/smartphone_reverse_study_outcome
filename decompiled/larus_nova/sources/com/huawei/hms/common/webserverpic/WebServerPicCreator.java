package com.huawei.hms.common.webserverpic;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes23.dex */
public final class WebServerPicCreator implements Parcelable.Creator<WebServerPic> {
    public WebServerPicCreator() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public WebServerPic createFromParcel(Parcel r100) {
        return new WebServerPic((Uri) r100.readParcelable(Uri.class.getClassLoader()), r100.readInt(), r100.readInt());
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ WebServerPic[] newArray(int r100) {
        return newArray(r100);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ WebServerPic createFromParcel(Parcel r100) {
        return createFromParcel(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public WebServerPic[] newArray(int r100) {
        return new WebServerPic[r100];
    }
}
