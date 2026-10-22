package com.bytedance.mira.pm;

import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public class ReceiverInfo implements Parcelable {
    public static final Parcelable.Creator<ReceiverInfo> CREATOR = null;
    public boolean exported;
    public List<IntentFilter> intentFilters;
    public String name;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public ReceiverInfo(Parcel r100) {
        this.name = "";
        this.intentFilters = new ArrayList();
        boolean r101 = false;
        this.exported = false;
        this.name = r100.readString();
        r100.readList(this.intentFilters, IntentFilter.class.getClassLoader());
        if (r100.readInt() != 1) goto L5;
        r101 = true;
    L5:
        this.exported = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.name);
        r100.writeList(this.intentFilters);
        r100.writeInt(this.exported ? 1 : 0);
    }

    public ReceiverInfo(String r100, List<IntentFilter> r101, boolean r102) {
        this.name = "";
        this.intentFilters = new ArrayList();
        this.exported = false;
        if (TextUtils.isEmpty(r100) == true) goto L5;
        this.name = r100;
    L5:
        if (r101 != null) goto L7;
    L9:
        this.exported = r102;
        return;
    L7:
        if (r101.size() <= 0) goto L9;
        this.intentFilters = r101;
        goto L9
    }
}
