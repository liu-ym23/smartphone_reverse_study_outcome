package com.bytedance.android.shopping.mall.feed;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFeedLocalStorage {
    public static final Lazy g = null;
    public final int a;
    public final Lazy b;
    public List<String> c;
    public final Context d;
    public final String e;
    public final Long f;

    public static final class a {
        public a() {
        }

        public static final String a(String r1) {
            Lazy r0 = ECMallFeedLocalStorage.g;
            return r1 + "_timestamp";
        }
    }

    public final SharedPreferences b() {
        return (SharedPreferences) this.b.getValue();
    }

    static {
        new a();
        g = LazyKt.lazy(ECMallFeedLocalStorage$Companion$mallSaasCacheDefaultTime$2.INSTANCE);
    }

    public final boolean a(long r14) {
        if (r14 <= 0) goto L40;
        long r3 = System.currentTimeMillis() - r14;
        long r7 = 60;
        long r5 = (((((long) ((Number) g.getValue()).intValue()) * 1000) * r7) * r7) * ((long) 24);
        Long r8 = this.f;
        List<ECMallFeedLocalStorageConfig.b> r9 = null;
        if (r8 == null) goto L16;
        if (r8.longValue() <= 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L13;
        r8 = null;
    L13:
        if (r8 == null) goto L16;
        r5 = r8.longValue();
        goto L16
    L9:
        r1 = false;
    L16:
        if (r3 > r5) goto L41;
        ECMallFeedLocalStorageConfig.a r2 = ECMallFeedLocalStorageConfig.b;
        String r4 = this.e;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "pageName");
        Map<String, List<ECMallFeedLocalStorageConfig.b>> r6 = ((ECMallFeedLocalStorageConfig) ECMallFeedLocalStorageConfig.a.getValue()).a();
        if (r6 == null) goto L32;
        List<ECMallFeedLocalStorageConfig.b> r10 = r6.get(r4);
        if (r10 == null) goto L32;
        if ((!r10.isEmpty()) == false) goto L24;
        r9 = r10;
    L24:
        if (r9 == null) goto L32;
        Iterator<ECMallFeedLocalStorageConfig.b> r11 = r9.iterator();
    L28:
        if (r11.hasNext() == false) goto L32;
        if (r11.next().a(r14) == false) goto L28;
        boolean r15 = true;
    L33:
        if (r15 == true) goto L42;
        return false;
    L42:
        return true;
    L32:
        r15 = false;
        goto L33
    L41:
        return true;
    L40:
        return true;
    }

    public final String c(String r6) {
        Intrinsics.checkNotNullParameter(r6, "key");
        if (StringsKt.isBlank(r6) == false) goto L6;
        return null;
    L6:
        if (a(b().getLong(a.a(r6), -1)) == false) goto L9;
        b().edit().remove(a.a(r6)).remove(r6).apply();
        return null;
    L9:
        String r7 = b().getString(r6, null);
        if (r7 != null) goto L12;
    L15:
        boolean r2 = true;
    L17:
        if ((true ^ r2) == true) goto L19;
        return null;
    L19:
        return r7;
    L12:
        if (StringsKt.isBlank(r7) == true) goto L15;
        r2 = false;
        goto L17
    }

    public ECMallFeedLocalStorage(Context r1, String r2, Integer r3, Long r4) {
        this.d = r1;
        this.e = r2;
        this.f = r4;
        if (r3 != null) goto L5;
    L13:
        int r5 = 3;
    L14:
        this.a = r5;
        this.b = LazyKt.lazy(new ECMallFeedLocalStorage$sharedPreferences$2(this));
        return;
    L5:
        if (r3.intValue() <= 0) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L13;
        r5 = r3.intValue();
        goto L14
    L7:
        r6 = false;
        goto L8
    }
}
