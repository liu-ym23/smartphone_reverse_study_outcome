package com.bytedance.ee.bear.templates.search;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import com.bytedance.ee.bear.templates.center.Tab2;
import com.bytedance.ee.bear.templates.search.business.SearchBusinessFragment;
import com.bytedance.ee.bear.templates.search.custom.SearchCustomFragment;
import com.bytedance.ee.bear.templates.search.system.SearchSystemFragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/templates/search/TemplateSearchVPAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "tabList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/templates/center/Tab2;", "Lkotlin/collections/ArrayList;", "<init>", "(Landroidx/fragment/app/Fragment;Ljava/util/ArrayList;)V", "map", "", "getItem", "position", "", "getCount", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateSearchVPAdapter extends FragmentPagerAdapter {
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

    public TemplateSearchVPAdapter(Fragment r6, ArrayList<Tab2> r7) {
        Intrinsics.checkNotNullParameter(r6, "fragment");
        Intrinsics.checkNotNullParameter(r7, "tabList");
        super(r6.getChildFragmentManager());
        this.a = r7;
        Tab2 r0 = Tab2.SYSTEM;
        int r1 = SearchSystemFragment.f;
        FragmentActivity r2 = r6.getActivity();
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNullParameter(r2, "context");
        Tab2 r3 = Tab2.CUSTOM;
        int r4 = SearchCustomFragment.f;
        FragmentActivity r5 = r6.getActivity();
        Intrinsics.checkNotNull(r5);
        Intrinsics.checkNotNullParameter(r5, "context");
        Tab2 r8 = Tab2.BUSNISS;
        int r9 = SearchBusinessFragment.f;
        FragmentActivity r10 = r6.getActivity();
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNullParameter(r10, "context");
        this.b = MapsKt.mapOf(new Pair[]{TuplesKt.to(r0, Fragment.instantiate(r2, SearchSystemFragment.class.getName(), new Bundle())), TuplesKt.to(r3, Fragment.instantiate(r5, SearchCustomFragment.class.getName(), new Bundle())), TuplesKt.to(r8, Fragment.instantiate(r10, SearchBusinessFragment.class.getName(), new Bundle()))});
    }
}
