package com.bytedance.android.shopping.mall.feed;

import android.content.SharedPreferences;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r0<V> implements Callable {
    public final /* synthetic */ ECMallFeedComponent.d a;
    public final /* synthetic */ String b;
    public final /* synthetic */ HomePageDTO c;

    public r0(ECMallFeedComponent.d r1, String r2, HomePageDTO r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.util.concurrent.Callable
    public final Unit call() {
        ECMallFeedComponent r0 = this.a.a;
        Lazy r1 = ECMallFeedComponent.p0;
        ECMallFeedLocalStorage r2 = (ECMallFeedLocalStorage) r0.I.getValue();
        if (r2 == null) goto L66;
        String r3 = this.b;
        String r4 = GsonProtectorUtils.toJson(new Gson(), this.c);
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        if (StringsKt.isBlank(r3) == true) goto L56;
        String r6 = r2.b().getString("key_set", null);
        ArrayList r5 = new ArrayList();
        if (r6 != null) goto L10;
    L13:
        boolean r7 = true;
    L15:
        if (r7 == true) goto L23;
        if (r6 == null) goto L23;
        List r8 = StringsKt.split$default(r6, new String[]{"|"}, false, 0, 6, null);
        if (r8 == null) goto L23;
        Iterator r9 = r8.iterator();
    L21:
        if (r9.hasNext() == false) goto L23;
        r5.add((String) r9.next());
    L23:
        Unit r10 = Unit.INSTANCE;
        r2.c = r5;
        SharedPreferences.Editor r11 = r2.b().edit();
        List<String> r12 = r2.c;
        if (r12 != null) goto L26;
    L54:
        Lazy r13 = ECMallFeedLocalStorage.g;
        r11.putLong(ECMallFeedLocalStorage.a.a(r3), System.currentTimeMillis()).putString(r3, r4).apply();
        goto L56
    L26:
        if (((ArrayList) r12).contains(r3) != true) goto L30;
        List<String> r14 = r2.c;
        if (r14 == null) goto L44;
        ((ArrayList) r14).remove(r3);
    L44:
        List<String> r15 = r2.c;
        if (r15 == null) goto L47;
        ListProtector.add(r15, 0, r3);
    L47:
        StringBuilder r16 = new StringBuilder();
        List<String> r17 = r2.c;
        if (r17 == null) goto L53;
        Iterator r18 = ((ArrayList) r17).iterator();
    L51:
        if (r18.hasNext() == false) goto L53;
        r16.append((String) r18.next());
        r16.append("|");
    L53:
        r2.b().edit().putString("key_set", StringsKt.removeSuffix(r16, "|").toString()).apply();
    L30:
        List<String> r19 = r2.c;
        if (r19 == null) goto L33;
        int r20 = ((ArrayList) r19).size();
    L35:
        if (r20 < r2.a) goto L44;
        List<String> r21 = r2.c;
        if (r21 == null) goto L39;
        String r22 = (String) CollectionsKt.lastOrNull(r21);
    L40:
        if (r22 == null) goto L30;
        r11.remove(ECMallFeedLocalStorage.a.a(r22)).remove(r22);
        List<String> r23 = r2.c;
        if (r23 == null) goto L30;
        ((ArrayList) r23).remove(r22);
        goto L30
    L39:
        r22 = null;
        goto L40
    L33:
        r20 = -1;
        goto L35
    L10:
        if (StringsKt.isBlank(r6) == true) goto L13;
        r7 = false;
    L56:
        return Unit.INSTANCE;
    L66:
        return null;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
