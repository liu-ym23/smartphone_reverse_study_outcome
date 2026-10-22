package com.bytedance.ee.bear.office.list.adapter;

import com.bytedance.ee.bear.list.t3;
import com.bytedance.ee.bear.office.export.space.OfficeListConfig;
import com.bytedance.ee.bear.office.export.space.OfficeListDisplayMode;
import com.ss.android.lark.diskmanage.Biz;
import com.ss.android.lark.storage.LarkKVStorage;
import dd5.s1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f {
    public static final /* synthetic */ int b = 0;
    public final Function0<String> a;

    public static final class a {
        public static void a(OfficeListConfig r5) {
            Intrinsics.checkNotNullParameter(r5, "listConfig");
            com.ss.android.lark.storage.a r0 = new com.ss.android.lark.storage.a(Biz.DOCS.getValue());
            boolean r1 = true;
            com.ss.android.lark.storage.kv.repo.a r2 = LarkKVStorage.h(r0, true);
            if (r2.contains("is_grid") == false) goto L6;
            r1 = r2.getBoolean("is_grid", false);
        L9:
            t3.a = r1;
            return;
        L6:
            if (r5.getDisplayMode() == OfficeListDisplayMode.GRID) goto L9;
            r1 = false;
            goto L9
        }
    }

    static {
    }

    public f(Function0<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "moduleProvider");
        this.a = r2;
    }

    public final void a(boolean r5) {
        if (t3.a != r5) goto L5;
        return;
    L5:
        t3.a = r5;
        s1.a.a.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), r5, (String) this.a.invoke());
    }
}
