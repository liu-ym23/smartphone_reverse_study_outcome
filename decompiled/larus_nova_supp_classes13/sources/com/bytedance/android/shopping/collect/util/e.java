package com.bytedance.android.shopping.collect.util;

import com.bytedance.android.shopping.collect.container.CollectYataViewModel;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public static final /* synthetic */ int e = 0;
    public boolean a;
    public boolean b;
    public final CollectYataViewModel c;
    public final Function0<AndroidYaTaInstance> d;

    public static final class a {
        public static boolean a(AndroidYaTaInstance r2) {
            Object r0 = null;
            if (r2 == null) goto L5;
            Object r3 = r2.i("has_more");
        L7:
            if ((r3 instanceof Boolean) == false) goto L10;
            r0 = r3;
        L10:
            Boolean r1 = (Boolean) r0;
            if (r1 != null) goto L15;
            return false;
        L15:
            return r1.booleanValue();
        L5:
            r3 = null;
            goto L7
        }
    }

    static {
    }

    public e(CollectYataViewModel r2, Function0<AndroidYaTaInstance> r3) {
        Intrinsics.checkNotNullParameter(r2, "collectYataViewModel");
        this.c = r2;
        this.d = r3;
        this.b = true;
    }
}
