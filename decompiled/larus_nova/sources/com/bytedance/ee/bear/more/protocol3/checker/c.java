package com.bytedance.ee.bear.more.protocol3.checker;

import android.text.TextUtils;
import com.bytedance.ee.bear.more.protocol3.j;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f234790e;

    @Override // com.bytedance.ee.bear.more.protocol3.j
    public final boolean e() {
        return false;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.j, com.bytedance.ee.bear.more.protocol3.a
    public final String b() {
        oj5.c r100 = d();
        if (r100 == null) goto L9;
        Map<String, String> r101 = r100.M();
        if (r101 == null) goto L9;
        String r102 = r101.get(this.f234790e);
        if (r102 == null) goto L9;
        return r102;
    L9:
        return super.b();
    }

    @Override // com.bytedance.ee.bear.more.protocol3.j, com.bytedance.ee.bear.more.protocol3.a
    public final boolean isEnable() {
        oj5.c r100 = d();
        if (r100 != null) goto L7;
        return false;
    L7:
        return !f(r100.B());
    }

    @Override // com.bytedance.ee.bear.more.protocol3.j, com.bytedance.ee.bear.more.protocol3.m
    public final boolean isVisible() {
        oj5.c r100 = d();
        if (r100 != null) goto L7;
        return false;
    L7:
        return !f(r100.O());
    }

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f234790e = r100;
    }

    public final boolean f(String[] r100) {
        if (r100 != null) goto L5;
    L18:
        return false;
    L5:
        if (r100.length != 0) goto L7;
        boolean r101 = true;
    L9:
        if ((!r101) == false) goto L18;
        if (TextUtils.isEmpty(this.f234790e) == true) goto L18;
        Iterator r102 = ArrayIteratorKt.iterator(r100);
    L14:
        if (r102.hasNext() == false) goto L18;
        if (TextUtils.equals(this.f234790e, (String) r102.next()) == false) goto L14;
        return true;
    L7:
        r101 = false;
        goto L9
    }
}
