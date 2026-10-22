package com.bytedance.ee.bear.middleground.permission;

import com.bytedance.ee.bear.middleground_permission_export.model.h;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements h {
    public ReadPermission a;
    public final Map<String, Function1<String, Unit>> b;

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.h
    public final void clear() {
        ((HashMap) this.b).clear();
        ReadPermission r0 = this.a;
        if (r0 == null) goto L6;
        r0.c();
        this.a = null;
        return;
    }

    public g() {
        this.b = new HashMap();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.h
    public final void c(String r2) {
        ((HashMap) this.b).remove(r2);
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.h
    public final void a(String r2, Function1<String, Unit> r3) {
        ((HashMap) this.b).put(r2, r3);
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.h
    public final void b(List<sbb.e> r6, List<String> r7) {
        if (this.a != null) goto L5;
        this.a = new ReadPermission("native", new WeakReference(new f(this)));
    L5:
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L7:
        if (r1 >= ((ArrayList) r6).size()) goto L9;
        String r2 = (String) ListProtector.get(r7, r1);
        r0.add(new ReadPermission.b((sbb.e) ListProtector.get(r6, r1), r2));
        r1 = r1 + 1;
        goto L7
    L9:
        this.a.b(r0);
    }
}
