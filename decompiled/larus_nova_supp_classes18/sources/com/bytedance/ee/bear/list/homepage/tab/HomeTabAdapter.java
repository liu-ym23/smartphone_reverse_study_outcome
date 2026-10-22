package com.bytedance.ee.bear.list.homepage.tab;

import ad5.e;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class HomeTabAdapter extends FragmentPagerAdapter {
    public final Context a;
    public final List<e> b;
    public Fragment c;
    public final Bundle d;

    public final int getCount() {
        return this.b.size();
    }

    public final e f(int r3) {
        a.h("HomeTabAdapter", "getTabInfo()...position = " + r3);
        if (hu5.a.a(r3, this.b) == true) goto L5;
        return null;
    L5:
        return (e) ListProtector.get(this.b, r3);
    }

    public final Fragment getItem(int r3) {
        a.h("HomeTabAdapter", "getItem()...position = " + r3);
        if (hu5.a.a(r3, this.b) == true) goto L5;
        return null;
    L5:
        return Fragment.instantiate(this.a, ((e) ListProtector.get(this.b, r3)).c, this.d);
    }

    public final long getItemId(int r3) {
        return ((e) ListProtector.get(this.b, r3)).hashCode();
    }

    public final int getItemPosition(Object r2) {
        int r3 = this.b.indexOf(r2);
        if (r3 != (-1)) goto L6;
        return -2;
    L6:
        return r3;
    }

    public final CharSequence getPageTitle(int r3) {
        return this.a.getString(((e) ListProtector.get(this.b, r3)).b);
    }

    public final void setPrimaryItem(ViewGroup r2, int r3, Object r4) {
        if ((r4 instanceof Fragment) == false) goto L5;
        this.c = (Fragment) r4;
    L5:
        super.setPrimaryItem(r2, r3, r4);
    }

    public HomeTabAdapter(FragmentManager r1, Context r2, List<e> r3, Bundle r4) {
        super(r1);
        this.a = r2;
        this.b = r3;
        this.d = r4;
        a.h("HomeTabAdapter", "HomeTabAdapter()...mTabInfoList = " + r3);
    }
}
