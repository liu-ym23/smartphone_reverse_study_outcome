package com.bytedance.ee.bear.office.list;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class j<T, U, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeListPageMenuCapabilityRegistry.a f235911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OfficeSpaceTab f235912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f235913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Fragment f235914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f235915e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ i f235916f;

    public j(OfficeListPageMenuCapabilityRegistry.a r100, OfficeSpaceTab r101, String r102, LifeCycleFragment r103, boolean r104, i r105) {
        this.f235911a = r100;
        this.f235912b = r101;
        this.f235913c = r102;
        this.f235914d = r103;
        this.f235915e = r104;
        this.f235916f = r105;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object r100, Object r101) {
        List r102 = (List) r101;
        Intrinsics.checkNotNullParameter((OfficeListPageMenuCapabilityRegistry.a) r100, "<unused var>");
        if (r102 != null) goto L5;
        r102 = new ArrayList();
    L5:
        i r103 = this.f235916f;
        final Fragment r104 = this.f235914d;
        CollectionsKt.removeAll(r102, new OfficeListPageMenuCapabilityRegistry$register$1$next$1$1(r104));
        r102.add(r103);
        StringBuilder r105 = new StringBuilder("register page menu capability, runtime=");
        OfficeListPageMenuCapabilityRegistry r106 = OfficeListPageMenuCapabilityRegistry.f235547a;
        String r107 = this.f235911a.f235550a;
        r106.getClass();
        r105.append(OfficeListPageMenuCapabilityRegistry.g(r107));
        r105.append(", tab=");
        r105.append(this.f235912b);
        r105.append(", module=");
        r105.append(this.f235913c);
        r105.append(", owner=");
        r105.append(OfficeListPageMenuCapabilityRegistry.f(this.f235914d));
        r105.append(", canMultiSelect=");
        r105.append(this.f235915e);
        r105.append(", size=");
        r105.append(r102.size());
        tt5.a.h("OfficeListPageMenuCapabilityRegistry", r105.toString());
        if ((!r102.isEmpty()) == true) goto L10;
        return null;
    L10:
        return r102;
    }
}
