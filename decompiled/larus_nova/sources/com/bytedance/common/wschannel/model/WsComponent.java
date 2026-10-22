package com.bytedance.common.wschannel.model;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public class WsComponent implements Parcelable {
    public static final Parcelable.Creator<WsComponent> CREATOR = null;
    List<WsApi> acceptApis;
    ComponentName componentName;

    public WsComponent() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.componentName, r101);
        r100.writeTypedList(this.acceptApis);
    }
}
