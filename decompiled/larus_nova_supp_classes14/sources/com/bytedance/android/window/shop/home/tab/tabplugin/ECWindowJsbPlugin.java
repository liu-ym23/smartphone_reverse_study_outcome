package com.bytedance.android.window.shop.home.tab.tabplugin;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class ECWindowJsbPlugin implements e {
    public final Lazy a;

    public static final class a {
    }

    static {
    }

    public abstract List<c> c();

    public void e() {
    }

    public void f() {
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.e
    public void a() {
        Iterator r0 = ((List) this.a.getValue()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        c r1 = (c) r0.next();
        ECLiveHybridUtil.m(r1.b, r1.a);
        goto L4
    L6:
        e();
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.e
    public void b() {
        Iterator r0 = ((List) this.a.getValue()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        c r1 = (c) r0.next();
        ECLiveHybridUtil.p(r1.b, r1.a);
        goto L4
    L6:
        f();
    }

    public ECWindowJsbPlugin() {
        this.a = LazyKt.lazy(new ECWindowJsbPlugin$actionRegistries$2(this));
    }

    public static boolean g(JSONObject r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "jsonObject");
        Intrinsics.checkNotNullParameter(r3, "secAuthorId");
        return d(r2, "sec_author_id", r3, true);
    }

    public static boolean d(JSONObject r1, String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "jsonObject");
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "expected");
        String r5 = r1.optString(r2, "");
        if (r4 == false) goto L9;
        if (Intrinsics.areEqual(r5, "") == false) goto L9;
        return true;
    L9:
        return Intrinsics.areEqual(r5, r3);
    }
}
