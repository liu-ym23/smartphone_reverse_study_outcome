package com.bytedance.bdp.serviceapi.hostimpl.hostmethod;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class BdpHostMethodResult implements Parcelable {
    public static final Parcelable.Creator<BdpHostMethodResult> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f201607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f201608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f201609c;

    public class a implements Parcelable.Creator<BdpHostMethodResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BdpHostMethodResult createFromParcel(Parcel r100) {
            return new BdpHostMethodResult(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final BdpHostMethodResult[] newArray(int r100) {
            return new BdpHostMethodResult[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public BdpHostMethodResult(Parcel r100) {
        this.f201607a = r100.readInt();
        this.f201608b = r100.readString();
        String r101 = r100.readString();
        JSONObject r102 = null;
        if (TextUtils.isEmpty(r101) == false) goto L10;
    L7:
        this.f201609c = r102;
        return;
    L10:
        r102 = new JSONObject(r101);     // Catch: JSONException -> L9
        goto L7
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f201607a);
        r100.writeString(this.f201608b);
        JSONObject r102 = this.f201609c;
        if (r102 == null) goto L5;
        String r103 = r102.toString();
    L6:
        r100.writeString(r103);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
