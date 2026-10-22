package com.bytedance.mira.pm.filters;

import android.content.ComponentName;
import android.content.IntentFilter;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageParser;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.bytedance.mira.pm.ComponentInfoGenerator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ServiceResolver extends ComponentResolver<PackageParser.Service, PackageParser.ServiceIntentInfo> {
    public ServiceResolver() {
    }

    @Override // com.bytedance.mira.pm.filters.ComponentResolver, com.bytedance.mira.pm.filters.IntentFilterResolver
    public /* bridge */ /* synthetic */ IntentFilter[] newArray(int r100) {
        return m8519newArray(r100);
    }

    public ComponentName newComponentName(PackageParser.Service r100) {
        return new ComponentName(r100.info.packageName, r100.info.name);
    }

    @Override // com.bytedance.mira.pm.filters.ComponentResolver
    /* JADX INFO: renamed from: newArray */
    public /* bridge */ /* synthetic */ PackageParser.IntentInfo[] mo8517newArray(int r100) {
        return m8519newArray(r100);
    }

    @Override // com.bytedance.mira.pm.filters.ComponentResolver
    public /* bridge */ /* synthetic */ ComponentName newComponentName(PackageParser.Component r100) {
        return newComponentName((PackageParser.Service) r100);
    }

    /* JADX INFO: renamed from: newArray, reason: collision with other method in class */
    public PackageParser.ServiceIntentInfo[] m8519newArray(int r100) {
        return new PackageParser.ServiceIntentInfo[r100];
    }

    public boolean allowFilterResult(PackageParser.ServiceIntentInfo r100, List<ResolveInfo> r101) {
        int r102 = r101.size() - 1;
    L3:
        if (r102 < 0) goto L11;
        ServiceInfo r103 = ((ResolveInfo) ListProtector.get(r101, r102)).serviceInfo;
        if (r103.name != r100.service.info.name) goto L10;
        if (r103.packageName != r100.service.info.packageName) goto L10;
        return false;
    L10:
        r102 = r102 - 1;
        goto L3
    L11:
        return true;
    }

    public ComponentInfo generateComponentInfo(ResolveInfo r100, PackageParser.ServiceIntentInfo r101) {
        ServiceInfo r102 = ComponentInfoGenerator.generateServiceInfo(r101.service, 0);
        r100.serviceInfo = r102;
        return r102;
    }

    public boolean isPackageForFilter(String r100, PackageParser.ServiceIntentInfo r101) {
        return TextUtils.equals(r100, r101.service.info.packageName);
    }

    @Override // com.bytedance.mira.pm.filters.IntentFilterResolver
    public /* bridge */ /* synthetic */ boolean allowFilterResult(IntentFilter r100, List<ResolveInfo> r101) {
        return allowFilterResult((PackageParser.ServiceIntentInfo) r100, r101);
    }

    @Override // com.bytedance.mira.pm.filters.ComponentResolver
    public /* bridge */ /* synthetic */ ComponentInfo generateComponentInfo(ResolveInfo r100, PackageParser.IntentInfo r101) {
        return generateComponentInfo(r100, (PackageParser.ServiceIntentInfo) r101);
    }

    @Override // com.bytedance.mira.pm.filters.IntentFilterResolver
    public /* bridge */ /* synthetic */ boolean isPackageForFilter(String r100, IntentFilter r101) {
        return isPackageForFilter(r100, (PackageParser.ServiceIntentInfo) r101);
    }
}
