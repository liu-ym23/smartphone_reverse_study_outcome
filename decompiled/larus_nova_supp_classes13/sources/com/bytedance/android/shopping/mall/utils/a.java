package com.bytedance.android.shopping.mall.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int e = 0;
    public final Lazy a;
    public List<String> b;
    public final Context c;
    public final String d;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.utils.a$a, reason: collision with other inner class name */
    public static final class C0113a {
    }

    static {
    }

    public final SharedPreferences a() {
        return (SharedPreferences) this.a.getValue();
    }

    public final void d() {
        StringBuilder r0 = new StringBuilder();
        List<String> r1 = this.b;
        if (r1 == null) goto L8;
        Iterator<T> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r0.append((String) r2.next());
        r0.append("|");
    L8:
        a().edit().putString("key_set", StringsKt.removeSuffix(r0, "|").toString()).apply();
    }

    public final void b() {
        String r3 = a().getString("key_set", null);
        ArrayList r0 = new ArrayList();
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L17;
        if (r3 == null) goto L17;
        List r2 = StringsKt.split$default(r3, new String[]{"|"}, false, 0, 6, null);
        if (r2 == null) goto L17;
        Iterator r4 = r2.iterator();
    L15:
        if (r4.hasNext() == false) goto L17;
        r0.add((String) r4.next());
    L17:
        Unit r5 = Unit.INSTANCE;
        this.b = r0;
        return;
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        r1 = false;
        goto L9
    }

    public a(Context r1) {
        this.c = r1;
        this.d = "login_control";
        this.a = LazyKt.lazy(new ECMallLocalStorage$sharedPreferences$2(this));
    }

    public final void delete(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        if (StringsKt.isBlank(r4) == false) goto L5;
        return;
    L5:
        b();
        SharedPreferences.Editor r0 = a().edit();
        List<String> r1 = this.b;
        if (r1 != null) goto L8;
    L13:
        r0.remove(r4 + "_timestamp").remove(r4).apply();
        return;
    L8:
        if (((ArrayList) r1).contains(r4) != true) goto L13;
        List<String> r2 = this.b;
        if (r2 == null) goto L12;
        ((ArrayList) r2).remove(r4);
    L12:
        d();
        goto L13
    }

    public final void c(String r6, Object r7) {
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r7, "value");
        if (StringsKt.isBlank(r6) == false) goto L5;
        return;
    L5:
        b();
        SharedPreferences.Editor r0 = a().edit();
        List<String> r1 = this.b;
        if (r1 != null) goto L8;
    L16:
        SharedPreferences.Editor r2 = r0.putLong(r6.concat("_timestamp"), System.currentTimeMillis());
        if ((r7 instanceof String) == false) goto L20;
        r2.putString(r6, (String) r7);
    L41:
        r2.apply();
        return;
    L20:
        if ((r7 instanceof Boolean) == false) goto L23;
        r2.putBoolean(r6, ((Boolean) r7).booleanValue());
        goto L41
    L23:
        if ((r7 instanceof Integer) == false) goto L26;
        r2.putInt(r6, ((Number) r7).intValue());
        goto L41
    L26:
        if ((r7 instanceof Float) == false) goto L29;
        r2.putFloat(r6, ((Number) r7).floatValue());
        goto L41
    L29:
        if ((r7 instanceof Long) == false) goto L32;
        r2.putLong(r6, ((Number) r7).longValue());
        goto L41
    L32:
        if ((r7 instanceof Set) == false) goto L41;
        if ((!((Collection) r7).isEmpty()) == false) goto L41;
        if ((CollectionsKt.first((Iterable) r7) instanceof String) == false) goto L41;
        if (r7 == null) goto L40;
        r2.putStringSet(r6, (Set) r7);
        goto L41
    L40:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
    L8:
        if (((ArrayList) r1).contains(r6) != true) goto L12;
        List<String> r3 = this.b;
        if (r3 == null) goto L12;
        ((ArrayList) r3).remove(r6);
    L12:
        List<String> r4 = this.b;
        if (r4 == null) goto L15;
        ListProtector.add(r4, 0, r6);
    L15:
        d();
        goto L16
    }
}
