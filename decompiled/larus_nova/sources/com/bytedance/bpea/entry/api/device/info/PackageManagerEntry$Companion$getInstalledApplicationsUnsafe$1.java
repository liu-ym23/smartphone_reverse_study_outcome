package com.bytedance.bpea.entry.api.device.info;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a$\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroid/content/pm/ApplicationInfo;", "kotlin.jvm.PlatformType", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class PackageManagerEntry$Companion$getInstalledApplicationsUnsafe$1 extends Lambda implements Function0<List<ApplicationInfo>> {
    final /* synthetic */ int $flags;
    final /* synthetic */ PackageManager $this_getInstalledApplicationsUnsafe;

    public PackageManagerEntry$Companion$getInstalledApplicationsUnsafe$1(PackageManager r100, int r101) {
        this.$this_getInstalledApplicationsUnsafe = r100;
        this.$flags = r101;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<ApplicationInfo> invoke2() {
        PackageManager r100 = this.$this_getInstalledApplicationsUnsafe;
        int r101 = this.$flags;
        f06.c r110 = new f06.c();
        Object[] r111 = {Integer.valueOf(r101)};
        f06.b r112 = new f06.b();
        f06.d r113 = r110.b(101304, "android/content/pm/PackageManager", "getInstalledApplications", r100, r111, "java.util.List", r112);
        if (r113.f474982a == false) goto L5;
        r110.a(101304, "android/content/pm/PackageManager", "getInstalledApplications", r100, r111, null, r112, false);
        return (List) r113.f474983b;
    L5:
        List<ApplicationInfo> r102 = r100.getInstalledApplications(r101);
        r110.a(101304, "android/content/pm/PackageManager", "getInstalledApplications", r100, r111, r102, r112, true);
        return r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<ApplicationInfo> invoke() {
        return invoke2();
    }
}
