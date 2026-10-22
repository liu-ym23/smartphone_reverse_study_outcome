package com.bytedance.mira.pm.filters;

import android.content.ComponentName;
import android.content.IntentFilter;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageParser;
import android.content.pm.ResolveInfo;

/* JADX INFO: loaded from: classes21.dex */
public class ProviderResolverCompat extends ComponentResolver {
    @Override // com.bytedance.mira.pm.filters.ComponentResolver
    public ComponentInfo generateComponentInfo(ResolveInfo r100, PackageParser.IntentInfo r101) {
        return null;
    }

    @Override // com.bytedance.mira.pm.filters.IntentFilterResolver
    public boolean isPackageForFilter(String r100, IntentFilter r101) {
        return false;
    }

    public ProviderResolverCompat() {
    }

    @Override // com.bytedance.mira.pm.filters.ComponentResolver, com.bytedance.mira.pm.filters.IntentFilterResolver
    public /* bridge */ /* synthetic */ IntentFilter[] newArray(int r100) {
        return mo8517newArray(r100);
    }

    @Override // com.bytedance.mira.pm.filters.ComponentResolver
    public ComponentName newComponentName(PackageParser.Component r100) {
        if ((r100 instanceof PackageParser.Provider) == false) goto L7;
        PackageParser.Provider r101 = (PackageParser.Provider) r100;
        return new ComponentName(r101.info.packageName, r101.info.name);
    L7:
        return new ComponentName(r100.owner.packageName, r100.className);
    }

    @Override // com.bytedance.mira.pm.filters.ComponentResolver
    /* JADX INFO: renamed from: newArray */
    public PackageParser.IntentInfo[] mo8517newArray(int r100) {
        return new PackageParser.IntentInfo[r100];
    }
}
