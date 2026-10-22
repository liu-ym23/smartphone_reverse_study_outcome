package nta;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import ita.j;

/* JADX INFO: loaded from: classes6.dex */
public final class e extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f520543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedPreferences f520544c;

    public e(Context r100) {
        if (r100 == null) goto L7;
        this.f520543b = r100.getSharedPreferences(kta.b.a(), 0);
        this.f520544c = r100.getSharedPreferences(kta.b.f506097a, 0);
        return;
    L7:
        throw new IllegalArgumentException("context can't be null");
    }

    @Override // nta.c
    public final void a(String r100) {
        if (Logger.debug() == false) goto L6;
        j.g("SharePreferenceCacheHandler cacheString key = device_id value = " + r100, null);
    L6:
        if (TextUtils.isEmpty(r100) == true) goto L10;
        SharedPreferences.Editor r101 = e("device_id").edit();
        r101.putString("device_id", r100);
        r101.apply();
        return;
    }

    @Override // nta.c
    public final void b(String r100) {
        SharedPreferences r101 = e(r100);
        if (r101 != null) goto L5;
    L7:
        c(r100);
        super.b(r100);
        return;
    L5:
        if (r101.contains(r100) == false) goto L7;
        e(r100).edit().remove(r100).commit();
        goto L7
    }

    @Override // nta.c
    public final String c(String r100) {
        String r101 = e(r100).getString(r100, null);
        if (Logger.debug() == false) goto L5;
        j.g("SharePreferenceCacheHandler getCachedString key = " + r100 + " value = " + r101, null);
    L5:
        return r101;
    }

    public final SharedPreferences e(String r100) {
        if ("device_id".equals(r100) == false) goto L6;
        return this.f520544c;
    L6:
        return this.f520543b;
    }
}
