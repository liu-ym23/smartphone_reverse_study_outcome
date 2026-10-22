package com.larksuite.framework.apiplugin.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.log.Log;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import j18.k;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public class LKBasePluginResult implements Parcelable {
    public static final Parcelable.Creator<LKBasePluginResult> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final LKBasePluginResult f285519f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f285520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f285521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f285522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f285523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<b.a> f285524e;

    public class a implements Parcelable.Creator<LKBasePluginResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LKBasePluginResult createFromParcel(Parcel r100) {
            return new LKBasePluginResult(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final LKBasePluginResult[] newArray(int r100) {
            return new LKBasePluginResult[r100];
        }
    }

    public static abstract class b<T extends b<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public JSONObject f285525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public k f285526b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f285527c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List<a> f285528d;

        public static class a<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @JSONField(name = "key")
            public String f285529a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @JSONField(serialize = false)
            public T f285530b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @JSONField(name = TTVideoEngineInterface.PLAY_API_KEY_BASE64)
            public String f285531c;
        }

        public b() {
            this.f285527c = Integer.MIN_VALUE;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
        f285519f = new LKBasePluginResult(false, null, null, Integer.MIN_VALUE, null);
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("LKBasePluginResult{mResult=");
        JSONObject r101 = this.f285521b;
        if (r101 == null) goto L5;
        String r102 = r101.toString();
    L6:
        r100.append(r102);
        r100.append(", mErrorCode=");
        r100.append(this.f285523d);
        r100.append('}');
        return r100.toString();
    L5:
        r102 = "";
        goto L6
    }

    public LKBasePluginResult(Parcel r100) {
        boolean r101 = false;
        this.f285520a = false;
        this.f285523d = Integer.MIN_VALUE;
        if (r100.readByte() == 0) goto L5;
        r101 = true;
    L5:
        this.f285520a = r101;
        this.f285523d = r100.readInt();
        String r102 = r100.readString();
        if (TextUtils.isEmpty(r102) == true) goto L14;
        this.f285521b = new JSONObject(r102);     // Catch: JSONException -> L9
        return;
    L9:
        e = move-exception;
        Log.e("LKBasePluginResult", "JSONException", e);
        this.f285521b = new JSONObject();
        return;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeByte(this.f285520a ? 1 : 0);
        r100.writeInt(this.f285523d);
        JSONObject r102 = this.f285521b;
        if (r102 == null) goto L5;
        String r103 = r102.toString();
    L6:
        r100.writeString(r103);
        return;
    L5:
        r103 = "";
        goto L6
    }

    public LKBasePluginResult(boolean r100, JSONObject r101, k r102, int r103, List<b.a> r104) {
        this.f285520a = false;
        this.f285523d = Integer.MIN_VALUE;
        this.f285520a = r100;
        this.f285521b = r101;
        this.f285523d = r103;
        this.f285522c = r102;
        this.f285524e = r104;
    }
}
