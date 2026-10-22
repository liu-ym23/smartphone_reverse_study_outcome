package com.bytedance.ee.bear.more.protocol3.checker;

import android.text.TextUtils;
import com.bytedance.ee.bear.more.protocol3.j;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends j {
    public final String e;

    @Override // com.bytedance.ee.bear.more.protocol3.j
    public final boolean e() {
        return false;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.j, com.bytedance.ee.bear.more.protocol3.a
    public final String b() {
        oj5.c r0 = d();
        if (r0 == null) goto L9;
        Map<String, String> r1 = r0.M();
        if (r1 == null) goto L9;
        String r2 = r1.get(this.e);
        if (r2 == null) goto L9;
        return r2;
    L9:
        return super.b();
    }

    @Override // com.bytedance.ee.bear.more.protocol3.j, com.bytedance.ee.bear.more.protocol3.a
    public final boolean isEnable() {
        oj5.c r0 = d();
        if (r0 != null) goto L7;
        return false;
    L7:
        return !f(r0.B());
    }

    @Override // com.bytedance.ee.bear.more.protocol3.j, com.bytedance.ee.bear.more.protocol3.m
    public final boolean isVisible() {
        oj5.c r0 = d();
        if (r0 != null) goto L7;
        return false;
    L7:
        return !f(r0.O());
    }

    public c(String r2) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_ID);
        this.e = r2;
    }

    public final boolean f(String[] r5) {
        if (r5 != null) goto L5;
    L18:
        return false;
    L5:
        if (r5.length != 0) goto L7;
        boolean r1 = true;
    L9:
        if ((!r1) == false) goto L18;
        if (TextUtils.isEmpty(this.e) == true) goto L18;
        Iterator r6 = ArrayIteratorKt.iterator(r5);
    L14:
        if (r6.hasNext() == false) goto L18;
        if (TextUtils.equals(this.e, (String) r6.next()) == false) goto L14;
        return true;
    L7:
        r1 = false;
        goto L9
    }
}
