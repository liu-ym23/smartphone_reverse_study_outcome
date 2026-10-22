package v74;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f553471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f553472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Condition f553473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f553474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SharedPreferences f553475e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SharedPreferences.Editor f553476f;

    public a(Context r100) {
        this.f553471a = false;
        ReentrantLock r101 = new ReentrantLock();
        this.f553472b = r101;
        this.f553473c = r101.newCondition();
        this.f553474d = new HashMap();
        SharedPreferences r102 = y74.d.f566592a.b(new Object[]{r100});
        this.f553475e = r102;
        this.f553476f = r102.edit();
    }

    public final String a(String r100) {
        this.f553472b.lock();
        String r101 = (String) ((HashMap) this.f553474d).get(r100);     // Catch: Throwable -> L13
        String r102 = "";
        if (TextUtils.isEmpty(r101) == false) goto L9;
        r101 = this.f553475e.getString(r100, "");     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r101) == true) goto L9;
        ((HashMap) this.f553474d).put(r100, r101);     // Catch: Throwable -> L13
    L9:
        if (r101 == null) goto L11;
        r102 = r101;
    L11:
        this.f553472b.unlock();
        return r102;
    L13:
        th = move-exception;
        this.f553472b.unlock();
        throw th;
    }

    public final String b(String r100) {
        return this.f553475e.getString(r100, "");
    }
}
