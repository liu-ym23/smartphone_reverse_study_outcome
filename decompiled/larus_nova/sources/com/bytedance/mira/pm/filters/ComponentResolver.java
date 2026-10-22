package com.bytedance.mira.pm.filters;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageParser;
import android.content.pm.PackageParser.Component;
import android.content.pm.PackageParser.IntentInfo;
import android.content.pm.ResolveInfo;
import com.bytedance.mira.Mira;
import com.bytedance.mira.plugin.PluginManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ComponentResolver<CP extends PackageParser.Component<II>, II extends PackageParser.IntentInfo> extends IntentFilterResolver<II, ResolveInfo> {
    private static Comparator sComparator;
    public final HashMap<ComponentName, CP> mAllComponents;
    public final HashMap<ComponentName, CP> mCoupledComponents;
    private int mFlags;

    public abstract ComponentInfo generateComponentInfo(ResolveInfo r100, II r101);

    /* JADX INFO: renamed from: newArray */
    public abstract II[] mo8517newArray(int r100);

    public abstract ComponentName newComponentName(CP r100);

    static {
        sComparator = new AnonymousClass1();
    }

    public ComponentResolver() {
        this.mAllComponents = new HashMap();
        this.mCoupledComponents = new HashMap();
    }

    public final CP getComponent(ComponentName r100) {
        return this.mAllComponents.get(r100);
    }

    public final CP getCoupledComponent(ComponentName r100) {
        return this.mCoupledComponents.get(r100);
    }

    @Override // com.bytedance.mira.pm.filters.IntentFilterResolver
    public /* bridge */ /* synthetic */ IntentFilter[] newArray(int r100) {
        return mo8517newArray(r100);
    }

    public final void removeComponent(CP r100) {
        ComponentName r101 = newComponentName(r100);
        this.mAllComponents.remove(r101);
        if (PluginManager.getInstance().isPluginPackage(((PackageParser.Component) r100).owner.packageName) == false) goto L6;
        ComponentName r102 = new ComponentName(Mira.getAppContext().getPackageName(), r101.getClassName());
        this.mCoupledComponents.remove(r102);
    L6:
        if (((PackageParser.Component) r100).intents == null) goto L10;
        int r103 = ((PackageParser.Component) r100).intents.size();
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L12;
        removeFilter((IntentFilter) ListProtector.get(((PackageParser.Component) r100).intents, r104));
        r104 = r104 + 1;
        goto L8
    L12:
        return;
    }

    @Override // com.bytedance.mira.pm.filters.IntentFilterResolver
    public void sortResults(List<ResolveInfo> r100) {
        Collections.sort(r100, sComparator);
    }

    public final void addComponent(CP r100, String r101) {
        ComponentName r102 = newComponentName(r100);
        this.mAllComponents.put(r102, r100);
        if (PluginManager.getInstance().isPluginPackage(((PackageParser.Component) r100).owner.packageName) == false) goto L6;
        ComponentName r103 = new ComponentName(Mira.getAppContext().getPackageName(), r102.getClassName());
        this.mCoupledComponents.put(r103, r100);
    L6:
        if (((PackageParser.Component) r100).intents == null) goto L15;
        int r104 = ((PackageParser.Component) r100).intents.size();
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L20;
        PackageParser.IntentInfo r106 = (PackageParser.IntentInfo) ListProtector.get(((PackageParser.Component) r100).intents, r105);
        if (r106.getPriority() <= 0) goto L14;
        if ("activity".equals(r101) == false) goto L14;
        r106.setPriority(0);
    L14:
        addFilter(r106);
        r105 = r105 + 1;
        goto L8
    L20:
        return;
    }

    public ResolveInfo newResult(II r100, int r101, int r102) {
        ResolveInfo r103 = new ResolveInfo();
        ComponentInfo r104 = generateComponentInfo(r103, r100);
        if (r104 != null) goto L6;
        return null;
    L6:
        r103.resolvePackageName = r104.packageName;
        r103.icon = r104.icon;
        r103.labelRes = r104.labelRes;
        boolean r105 = false;
        r103.preferredOrder = 0;
        r103.specificIndex = 1;
        int r106 = this.mFlags;
        if ((r106 & 64) == 0) goto L10;
        r103.filter = r100;
    L10:
        if ((r106 & 65536) == 0) goto L12;
        r105 = r100.hasCategory("android.intent.category.DEFAULT");
    L12:
        r103.isDefault = r105;
        r103.priority = r100.getPriority();
        r103.match = r101;
        return r103;
    }

    public final List<ResolveInfo> queryIntent(Intent r100, String r101, int r102) {
        this.mFlags = r102;
        if ((r102 & 65536) == 0) goto L5;
        boolean r103 = true;
    L7:
        return super.queryIntent(r100, r101, r103, 0);
    L5:
        r103 = false;
        goto L7
    }

    @Override // com.bytedance.mira.pm.filters.IntentFilterResolver
    public /* bridge */ /* synthetic */ ResolveInfo newResult(IntentFilter r100, int r101, int r102) {
        return newResult((PackageParser.IntentInfo) r100, r101, r102);
    }

    public final List<ResolveInfo> queryIntent(Intent r100, String r101, boolean r102) {
        if (r102 == false) goto L5;
        int r103 = 65536;
    L6:
        this.mFlags = r103;
        return super.queryIntent(r100, r101, r102, 0);
    L5:
        r103 = 0;
        goto L6
    }

    public final List<ResolveInfo> queryIntentForPackage(Intent r100, String r101, List<CP> r110, int r111) {
        if (r110 != null) goto L5;
        return null;
    L5:
        this.mFlags = r111;
        int r102 = 0;
        if ((r111 & 65536) == 0) goto L8;
        boolean r103 = true;
    L9:
        int r112 = r110.size();
        ArrayList<F[]> r104 = new ArrayList(r112);
    L10:
        if (r102 >= r112) goto L18;
        ArrayList r105 = ((PackageParser.Component) ListProtector.get(r110, r102)).intents;
        if (r105 == null) goto L16;
        if (r105.size() <= 0) goto L16;
        PackageParser.IntentInfo[] r106 = mo8517newArray(r105.size());
        r105.toArray(r106);
        r104.add(r106);
    L16:
        r102 = r102 + 1;
        goto L10
    L18:
        return super.queryIntentFromList(r100, r101, r103, r104, 0);
    L8:
        r103 = false;
        goto L9
    }
}
