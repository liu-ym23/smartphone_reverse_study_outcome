package com.larksuite.component.card.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.log.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public class FalconApiCallResult implements Parcelable {
    public static final Parcelable.Creator<FalconApiCallResult> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f283942a;

    public class a implements Parcelable.Creator<FalconApiCallResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FalconApiCallResult createFromParcel(Parcel r100) {
            return new FalconApiCallResult(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final FalconApiCallResult[] newArray(int r100) {
            return new FalconApiCallResult[r100];
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f283943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f283944b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f283945c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public JSONObject f283946d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f283947e;

        public final FalconApiCallResult a() {
            JSONObject r100 = this.f283946d;
            if (r100 != null) goto L27;
            r100 = new JSONObject();
        L27:
        L23:
            e = move-exception;
            Log.e("ApiCallResult", "build", e);
        L26:
            return new FalconApiCallResult(r100);
        L7:
            if (r100.has("errMsg") == false) goto L15;
            Log.i("ApiCallResult", "has errMsg event:" + this.f283943a);     // Catch: Exception -> L23
            String r101 = JSONObjectProtectorUtils.getString(r100, "errMsg");     // Catch: Exception -> L23
            if (r101.contains(this.f283943a + ":" + this.f283944b) == false) goto L12;
            Log.i("ApiCallResult", "success buildErrMsg");     // Catch: Exception -> L23
            boolean r102 = true;
        L16:
            if (r102 == true) goto L19;
            Log.i("ApiCallResult", "append errMsg");     // Catch: Exception -> L23
            r100.put("errMsg", b(this.f283943a, this.f283944b, this.f283945c));     // Catch: Exception -> L23
        L19:
            if (this.f283947e == 0) goto L21;
            Log.i("ApiCallResult", "errCode:" + this.f283947e);     // Catch: Exception -> L23
            r100.put("errCode", this.f283947e);     // Catch: Exception -> L23
        L21:
            Log.i("ApiCallResult", "errMsg:" + r100.get("errMsg"));     // Catch: Exception -> L23
            goto L26
        L12:
            if (TextUtils.isEmpty(this.f283945c) == false) goto L14;
            this.f283945c = r101;     // Catch: Exception -> L23
            goto L15
        L14:
            this.f283945c += r101;     // Catch: Exception -> L23
        L15:
            r102 = false;
            goto L16
        }

        public final String toString() {
            Log.e("ApiCallResult", "pls do not use Builder toString");
            return a().f283942a;
        }

        public b(String r100, String r101) {
            this.f283943a = r100;
            this.f283944b = r101;
        }

        public static String b(String r100, String r101, String r102) {
            if (TextUtils.isEmpty(r102) == false) goto L7;
            return r100 + ":" + r101;
        L7:
            return r100 + ":" + r101 + " " + r102;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final String toString() {
        return this.f283942a;
    }

    public FalconApiCallResult(Parcel r100) {
        String r101 = r100.readString();
        if (r101 != null) goto L11;
        Log.d("ApiCallResult", "empty result");
        r101 = "";
    L11:
        new JSONObject(r101);     // Catch: JSONException -> L7
    L9:
        this.f283942a = r101;
        r101.contains(":fail");
        return;
    L7:
        e = move-exception;
        new JSONObject();
        Log.e("ApiCallResult", r101, e);
        goto L9
    }

    public FalconApiCallResult(JSONObject r100) {
        this.f283942a = r100.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f283942a);
    }
}
