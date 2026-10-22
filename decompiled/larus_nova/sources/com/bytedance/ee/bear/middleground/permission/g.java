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

/* JADX INFO: loaded from: classes18.dex */
public final class g implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReadPermission f233887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Function1<String, Unit>> f233888b;

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.h
    public final void clear() {
        ((HashMap) this.f233888b).clear();
        ReadPermission r100 = this.f233887a;
        if (r100 == null) goto L6;
        r100.c();
        this.f233887a = null;
        return;
    }

    public g() {
        this.f233888b = new HashMap();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.h
    public final void c(String r100) {
        ((HashMap) this.f233888b).remove(r100);
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.h
    public final void a(String r100, Function1<String, Unit> r101) {
        ((HashMap) this.f233888b).put(r100, r101);
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.h
    public final void b(List<sbb.e> r100, List<String> r101) {
        if (this.f233887a != null) goto L5;
        this.f233887a = new ReadPermission("native", new WeakReference(new f(this)));
    L5:
        ArrayList r102 = new ArrayList();
        int r103 = 0;
    L7:
        if (r103 >= ((ArrayList) r100).size()) goto L9;
        String r104 = (String) ListProtector.get(r101, r103);
        r102.add(new ReadPermission.b((sbb.e) ListProtector.get(r100, r103), r104));
        r103 = r103 + 1;
        goto L7
    L9:
        this.f233887a.b(r102);
    }
}
