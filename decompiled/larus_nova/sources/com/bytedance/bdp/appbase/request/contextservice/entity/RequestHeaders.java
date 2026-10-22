package com.bytedance.bdp.appbase.request.contextservice.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class RequestHeaders implements Parcelable {
    public static final Parcelable.Creator<RequestHeaders> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f200957a;

    public class a implements Parcelable.Creator<RequestHeaders> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RequestHeaders createFromParcel(Parcel r100) {
            return new RequestHeaders(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final RequestHeaders[] newArray(int r100) {
            return new RequestHeaders[r100];
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f200958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f200959b;

        public b(String r100, String r101) {
            this.f200958a = r100;
            this.f200959b = r101;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final JSONObject toJson() {
        int r100 = this.f200957a.size();
        JSONObject r101 = new JSONObject();
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L10;
        b r103 = (b) ListProtector.get(this.f200957a, r102);
        r101.put(r103.f200958a, r103.f200959b);     // Catch: JSONException -> L7
    L9:
        r102 = r102 + 1;
    L7:
        e = move-exception;
        g94.b.b("SandboxJsonObject", new Object[]{e});
        goto L9
    L10:
        return r101;
    }

    public final String toString() {
        return "{header: " + toJson() + '}';
    }

    public RequestHeaders() {
        this.f200957a = new ArrayList();
        a(new e94.b("").f471488a);
    }

    public RequestHeaders(Parcel r100) {
        this.f200957a = new ArrayList();
        a(new e94.b(r100.readString()).f471488a);
    }

    public final void a(JSONObject r100) {
        if (r100 == null) goto L10;
        Iterator<String> r101 = r100.keys();
    L5:
        if (r101.hasNext() == false) goto L16;
        String r102 = r101.next();
        if (r102 == null) goto L5;
        this.f200957a.add(new b(r102, r100.optString(r102)));
        goto L5
    L16:
        return;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(toJson().toString());
    }
}
