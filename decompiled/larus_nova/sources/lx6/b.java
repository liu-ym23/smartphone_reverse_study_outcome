package lx6;

import android.text.TextUtils;
import com.bytedance.locallife.dito.core.v;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements v.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f511223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f511224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f511225c;

    @Override // com.bytedance.locallife.dito.core.v.c
    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put("poiId", this.f511223a);     // Catch: Exception -> L5
        r100.put("spuId", this.f511224b);     // Catch: Exception -> L5
        r100.put("bizCode", this.f511225c);     // Catch: Exception -> L5
    L4:
        return r100;
    }

    public final int hashCode() {
        int r100 = ((this.f511223a.hashCode() * 31) + this.f511224b.hashCode()) * 31;
        String r101 = this.f511225c;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "poiId:" + this.f511223a + " spuId:" + this.f511224b + " bizCode:" + this.f511225c;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == false) goto L17;
        b r101 = (b) r100;
        if (TextUtils.equals(this.f511223a, r101.f511223a) == true) goto L10;
    L14:
        return false;
    L10:
        if (TextUtils.equals(this.f511224b, r101.f511224b) == false) goto L14;
        if (TextUtils.equals(this.f511225c, r101.f511225c) == false) goto L14;
        return true;
    L17:
        return super.equals(r100);
    }

    public b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "poiId");
        Intrinsics.checkNotNullParameter(r101, "spuId");
        this.f511223a = r100;
        this.f511224b = r101;
        this.f511225c = r102;
    }
}
