package com.bytedance.crash.upload;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f203383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f203384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f203385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f203386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, List<String>> f203387e;

    public final boolean a() {
        int r100 = this.f203383a;
        if (r100 != 207) goto L5;
    L7:
        return false;
    L5:
        if (r100 == 214) goto L7;
        return true;
    }

    public final String toString() {
        String r100 = "Response:mErrorCode=" + this.f203383a + ", mServerErrorCode=" + this.f203384b;
        if (this.f203385c != null) goto L5;
        return r100;
    L5:
        return r100 + ", mServerJson=" + this.f203385c.toString();
    }

    public k(Throwable r100) {
        this.f203383a = 207;
        r100.getMessage();
    }

    public final void b(JSONObject r100) {
        this.f203385c = r100;
        String r101 = "";
        if (this.f203387e == null) goto L14;
        new ArrayList();     // Catch: Throwable -> L22
        Iterator<Map.Entry<String, List<String>>> r102 = this.f203387e.entrySet().iterator();     // Catch: Throwable -> L22
    L8:
        if (r102.hasNext() == false) goto L14;
        Map.Entry<String, List<String>> r103 = r102.next();     // Catch: Throwable -> L22
        if ("Alog_quota".equalsIgnoreCase(r103.getKey()) == false) goto L8;
        List<String> r104 = r103.getValue();     // Catch: Throwable -> L22
        if (r104.size() <= 0) goto L8;
        r101 = (String) ListProtector.get(r104, 0);     // Catch: Throwable -> L22
    L14:
        this.f203385c.putOpt("Alog_quota", r101);     // Catch: Throwable -> L22
        String r105 = this.f203385c.optString("message");     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r105) == false) goto L17;
        return;
    L17:
        if (r105.equals("drop all data") == false) goto L19;
    L20:
        this.f203383a = 213;     // Catch: Throwable -> L22
        return;
    L19:
        if (r105.equals("drop data") == true) goto L20;
        return;
    }

    public k(int r100) {
        this.f203383a = r100;
    }
}
