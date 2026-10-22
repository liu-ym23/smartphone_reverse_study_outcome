package com.bytedance.ee.bear.office.list;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j<T, U, R> implements BiFunction {
    public final /* synthetic */ OfficeListPageMenuCapabilityRegistry.a a;
    public final /* synthetic */ OfficeSpaceTab b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Fragment d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ i f;

    public j(OfficeListPageMenuCapabilityRegistry.a r1, OfficeSpaceTab r2, String r3, LifeCycleFragment r4, boolean r5, i r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object r3, Object r4) {
        List r5 = (List) r4;
        Intrinsics.checkNotNullParameter((OfficeListPageMenuCapabilityRegistry.a) r3, "<unused var>");
        if (r5 != null) goto L5;
        r5 = new ArrayList();
    L5:
        i r6 = this.f;
        final Fragment r0 = this.d;
        CollectionsKt.removeAll(r5, new OfficeListPageMenuCapabilityRegistry$register$1$next$1$1(r0));
        r5.add(r6);
        StringBuilder r7 = new StringBuilder("register page menu capability, runtime=");
        OfficeListPageMenuCapabilityRegistry r1 = OfficeListPageMenuCapabilityRegistry.a;
        String r2 = this.a.a;
        r1.getClass();
        r7.append(OfficeListPageMenuCapabilityRegistry.g(r2));
        r7.append(", tab=");
        r7.append(this.b);
        r7.append(", module=");
        r7.append(this.c);
        r7.append(", owner=");
        r7.append(OfficeListPageMenuCapabilityRegistry.f(this.d));
        r7.append(", canMultiSelect=");
        r7.append(this.e);
        r7.append(", size=");
        r7.append(r5.size());
        tt5.a.h("OfficeListPageMenuCapabilityRegistry", r7.toString());
        if ((!r5.isEmpty()) == true) goto L10;
        return null;
    L10:
        return r5;
    }
}
