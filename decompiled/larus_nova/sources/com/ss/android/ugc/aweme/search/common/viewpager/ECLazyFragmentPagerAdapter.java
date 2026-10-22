package com.ss.android.ugc.aweme.search.common.viewpager;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.search.common.base.lazy.AbECLazyPagerAdapter;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import java.util.Objects;

/* JADX INFO: loaded from: classes40.dex */
public abstract class ECLazyFragmentPagerAdapter extends AbECLazyPagerAdapter<Fragment> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FragmentManager f452552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FragmentTransaction f452553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f452554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Boolean f452555f;

    public interface Laziable {
    }

    public long getItemId(int r100) {
        return r100;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void startUpdate(ViewGroup r100) {
    }

    public ECLazyFragmentPagerAdapter(FragmentManager r100) {
        this.f452553d = null;
        this.f452554e = 0;
        this.f452555f = Boolean.FALSE;
        this.f452552c = r100;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void finishUpdate(ViewGroup r100) {
        FragmentTransaction r101 = this.f452553d;
        if (r101 == null) goto L6;
        r101.commitAllowingStateLoss();
        this.f452553d = null;
        this.f452552c.executePendingTransactions();
        return;
    }

    public static String i(int r100, long r101) {
        return "android:switcher:" + r100 + ":" + r101;
    }

    @Override // com.ss.android.ugc.aweme.search.common.base.lazy.AbECLazyPagerAdapter
    public final /* bridge */ /* synthetic */ Fragment f(ViewGroup r100, int r101) {
        return h(r100, r101);
    }

    public final Fragment h(ViewGroup r100, int r101) {
        Fragment r102 = (Fragment) this.f451488a.get(r101);
        if (r102 == null) goto L5;
        long r103 = getItemId(r101);
        String r104 = i(r100.getId(), r103);
        if (this.f452552c.findFragmentByTag(r104) == null) goto L9;
    L16:
        return r102;
    L9:
        if (this.f452553d != null) goto L11;
        this.f452553d = this.f452552c.beginTransaction();
    L11:
        r102.toString();
        FragmentTransaction r105 = this.f452553d;
        int r106 = r100.getId();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r105, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r104, r106) == true) goto L15;
        r105.add(r106, r102, r104);
    L15:
        this.f452553d.show(r102);
        this.f451488a.remove(r101);
        goto L16
    L5:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup r100, int r101) {
        if (this.f452553d != null) goto L5;
        this.f452553d = this.f452552c.beginTransaction();
    L5:
        String r102 = i(r100.getId(), getItemId(r101));
        Fragment r103 = this.f452552c.findFragmentByTag(r102);
        if (r103 == null) goto L8;
        r103.toString();
        this.f452553d.attach(r103);
    L8:
        if (r103 != null) goto L16;
        r103 = (Fragment) g(r101);
        if ((r103 instanceof Laziable) == false) goto L12;
        Objects.toString(r103);
        this.f451488a.put(r101, (T) r103);
        goto L16
    L12:
        Objects.toString(r103);
        FragmentTransaction r104 = this.f452553d;
        int r105 = r100.getId();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r104, r103, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r102, r105) == true) goto L16;
        r104.add(r105, r103, r102);
    L16:
        this.f452553d.show(r103);
        if (r103 == this.f451489b) goto L19;
        Logger.a("ECSwitchTabEvent", "instantiateItem " + r103.getClass().getSimpleName() + " setUserVisibleHint false");
        r103.toString();
        r103.setMenuVisibility(false);
        r103.setUserVisibleHint(false);
    L19:
        return r103;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        if (((Fragment) r101).getView() != r100) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup r100, int r101, Object r102) {
        if (this.f452553d != null) goto L5;
        this.f452553d = this.f452552c.beginTransaction();
    L5:
        long r103 = getItemId(r101);
        String r104 = i(r100.getId(), r103);
        if (this.f452552c.findFragmentByTag(r104) != null) goto L8;
        Fragment r105 = (Fragment) r102;
        Objects.toString(r105);
        this.f452553d.detach(r105);
    L9:
        this.f452553d.hide((Fragment) r102);
        return;
    L8:
        Objects.toString((Fragment) r102);
        this.f451488a.remove(r101);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [T, androidx.fragment.app.Fragment, java.lang.Object] */
    @Override // com.ss.android.ugc.aweme.search.common.base.lazy.AbECLazyPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup r100, int r101, Object r102) {
        if (this.f452554e != r101) goto L5;
    L8:
        this.f452554e = r101;
        if (this.f451488a.get(r101) == null) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        startUpdate(r100);
        h(r100, r101);
        finishUpdate(r100);
    L14:
        ?? r104 = (Fragment) r102;
        T r105 = this.f451489b;
        if (r104 != r105) goto L17;
        return;
    L17:
        if (r105 == 0) goto L19;
        Logger.a("ECSwitchTabEvent", "setPrimaryItem " + ((Fragment) this.f451489b).getClass().getSimpleName() + " setUserVisibleHint false");
        Objects.toString(r104);
        ((Fragment) this.f451489b).setMenuVisibility(false);
        ((Fragment) this.f451489b).setUserVisibleHint(false);
    L19:
        if (r104 == 0) goto L21;
        Logger.a("ECSwitchTabEvent", "setPrimaryItem " + r104.getClass().getSimpleName() + " setUserVisibleHint true");
        r104.toString();
        r104.setMenuVisibility(true);
        r104.setUserVisibleHint(true);
    L21:
        this.f451489b = r104;
        return;
    L11:
        r103 = false;
        goto L12
    L5:
        if (this.f452555f.booleanValue() == false) goto L8;
        this.f452555f = Boolean.FALSE;
    }
}
