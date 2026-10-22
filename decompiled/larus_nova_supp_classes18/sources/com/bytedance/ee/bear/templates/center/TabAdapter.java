package com.bytedance.ee.bear.templates.center;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.bytedance.ee.bear.templates.center.list.business.BusinessTemplateListFragment;
import com.bytedance.ee.bear.templates.center.list.custom.CustomTemplateListFragment;
import com.bytedance.ee.bear.templates.center.list.system.SystemTemplateListFragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/templates/center/TabAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "activity", "Landroidx/fragment/app/FragmentActivity;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tabList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/templates/center/Tab2;", "Lkotlin/collections/ArrayList;", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroidx/fragment/app/FragmentManager;Ljava/util/ArrayList;)V", "map", "", "Landroidx/fragment/app/Fragment;", "getItem", "position", "", "getCount", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabAdapter extends FragmentPagerAdapter {
    public final ArrayList<Tab2> a;
    public final Map<Tab2, Fragment> b;

    public final int getCount() {
        return this.a.size();
    }

    public final Fragment getItem(int r2) {
        Tab2 r3 = (Tab2) ListProtector.get(this.a, r2);
        Fragment r4 = this.b.get(r3);
        if (r4 == null) goto L5;
        return r4;
    L5:
        return (Fragment) MapsKt.getValue(this.b, Tab2.SYSTEM);
    }

    public TabAdapter(FragmentActivity r4, FragmentManager r5, ArrayList<Tab2> r6) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, "fragmentManager");
        Intrinsics.checkNotNullParameter(r6, "tabList");
        super(r5);
        this.a = r6;
        Tab2 r7 = Tab2.SYSTEM;
        int r0 = SystemTemplateListFragment.e;
        Intrinsics.checkNotNullParameter(r4, "context");
        Tab2 r8 = Tab2.CUSTOM;
        int r1 = CustomTemplateListFragment.e;
        Intrinsics.checkNotNullParameter(r4, "context");
        Tab2 r9 = Tab2.BUSNISS;
        int r2 = BusinessTemplateListFragment.e;
        Intrinsics.checkNotNullParameter(r4, "context");
        this.b = MapsKt.mapOf(new Pair[]{TuplesKt.to(r7, Fragment.instantiate(r4, SystemTemplateListFragment.class.getName(), new Bundle())), TuplesKt.to(r8, Fragment.instantiate(r4, CustomTemplateListFragment.class.getName(), new Bundle())), TuplesKt.to(r9, Fragment.instantiate(r4, BusinessTemplateListFragment.class.getName(), new Bundle()))});
    }
}
