package com.larus.profile.impl;

import com.google.android.material.tabs.TabLayout;
import com.larus.profile.api.bean.LandingTab;
import com.larus.profile.impl.creation.x3;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f366945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f366946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<e2> f366947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f366948d;

    public static final class a {
    }

    public interface b {
        void a(e2 r100, int r101);
    }

    static {
    }

    public w() {
        this.f366946b = -1;
        this.f366947c = new CopyOnWriteArrayList();
    }

    public final void a(e2 r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        FLogger.f375446a.i("ProfileDefaultTabSelector", "addTabChild = " + r100);
        this.f366947c.add(r100);
    }

    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Iterator<T> r101 = this.f366947c.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((e2) r102).f366568a, r100) == false) goto L4;
    L9:
        e2 r103 = (e2) r102;
        if (r103 == null) goto L12;
        boolean r104 = Intrinsics.areEqual(r103.f366570c, Boolean.FALSE);
    L14:
        return !r104;
    L12:
        r104 = false;
        goto L14
    L8:
        r102 = null;
        goto L9
    }

    public final boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Iterator<e2> r101 = this.f366947c.iterator();
    L3:
        Boolean r102 = null;
        if (r101.hasNext() == false) goto L8;
        e2 r103 = r101.next();
        if (Intrinsics.areEqual(r103.f366568a, r100) == false) goto L3;
    L9:
        e2 r104 = r103;
        if (r104 == null) goto L12;
        r102 = r104.f366570c;
    L12:
        if (r102 != null) goto L14;
        return true;
    L14:
        return false;
    L8:
        r103 = null;
        goto L9
    }

    public final void e(int r100) {
        FLogger.f375446a.i("ProfileDefaultTabSelector", "updateLandingIndex, index = " + r100);
        this.f366946b = r100;
    }

    public final void f(String r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.i("ProfileDefaultTabSelector", "updateTabChildState, " + r100 + " = isEmpty " + r110);
        Iterator<T> r101 = this.f366947c.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L12;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        e2 r105 = (e2) r103;
        if (Intrinsics.areEqual(r105.f366568a, r100) == false) goto L11;
        CopyOnWriteArrayList<e2> r106 = this.f366947c;
        Boolean r107 = Boolean.valueOf(r110);
        String r108 = r105.f366568a;
        LandingTab r109 = r105.f366569b;
        Intrinsics.checkNotNullParameter(r108, "fragmentTag");
        Intrinsics.checkNotNullParameter(r109, "landingTab");
        r106.set(r102, new e2(r108, r109, r107));
    L11:
        r102 = r104;
        goto L4
    }

    public final boolean d(TabLayout r100, boolean r110, boolean r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, "tabLayout");
        boolean r101 = false;
        if (this.f366948d == false) goto L7;
        FLogger.f375446a.i("ProfileDefaultTabSelector", "selectDefaultTab, already defaultSelected, ignore");
        return false;
    L7:
        if (r111 == false) goto L18;
        TabLayout.Tab r102 = r100.getTabAt(0);
        if (r102 == null) goto L11;
        r102.select();
    L11:
        this.f366948d = true;
        if (this.f366947c.size() <= 0) goto L17;
        b r103 = this.f366945a;
        if (r103 == null) goto L17;
        r103.a(this.f366947c.get(0), 0);
    L17:
        return this.f366948d;
    L18:
        if (r110 == true) goto L20;
    L44:
        int r113 = r100.getTabCount();
        int r114 = this.f366946b;
        if (r114 < 0) goto L48;
        if (r114 >= r113) goto L48;
        boolean r115 = true;
    L50:
        if (r115 == false) goto L59;
        TabLayout.Tab r104 = r100.getTabAt(r114);
        if (r104 == null) goto L54;
        r104.select();
    L54:
        FLogger.f375446a.i("ProfileDefaultTabSelector", "selectDefaultTab, tabCount = " + r113 + ", landingIndex = " + this.f366946b);
        this.f366948d = true;
        int r105 = this.f366947c.size();
        int r116 = this.f366946b;
        if (r105 <= r116) goto L111;
        b r106 = this.f366945a;
        if (r106 == null) goto L111;
        r106.a(this.f366947c.get(r116), this.f366946b);
    L111:
        if (r113 > 1) goto L116;
        if (this.f366948d == true) goto L116;
        this.f366948d = true;
    L116:
        return this.f366948d;
    L59:
        Iterator<e2> r117 = this.f366947c.iterator();
        int r118 = 0;
    L61:
        if (r117.hasNext() == false) goto L66;
        if (Intrinsics.areEqual(r117.next().f366570c, Boolean.FALSE) == true) goto L67;
        r118 = r118 + 1;
    L67:
        FLogger.f375446a.i("ProfileDefaultTabSelector", "selectDefaultTab, firstTabWithDataIndex = " + r118);
        if (r118 < 0) goto L94;
        int r107 = r118 + 1;
        if (this.f366947c.size() < r107) goto L79;
        Iterator r119 = CollectionsKt.take(this.f366947c, r107).iterator();
        boolean r108 = true;
    L73:
        if (r119.hasNext() == false) goto L80;
        if (((e2) r119.next()).f366570c == null) goto L77;
        boolean r109 = true;
    L78:
        r108 = r108 & r109;
        FLogger.f375446a.i("ProfileDefaultTabSelector", "selectDefaultTab, queryFinishedBefore = " + r108);
        goto L73
    L77:
        r109 = false;
    L80:
        if (r108 == false) goto L111;
        if (r118 < 0) goto L84;
        if (r118 >= r113) goto L84;
        r101 = true;
    L84:
        if (r101 == true) goto L86;
        if (r118 != 0) goto L111;
    L86:
        TabLayout.Tab r120 = r100.getTabAt(r118);
        if (r120 == null) goto L89;
        r120.select();
    L89:
        FLogger.f375446a.i("ProfileDefaultTabSelector", "selectDefaultTab, tabCount = " + r113 + ", firstTabWithDataIndex = " + r118);
        this.f366948d = true;
        if (this.f366947c.size() <= r118) goto L111;
        b r121 = this.f366945a;
        if (r121 == null) goto L111;
        r121.a(this.f366947c.get(r118), r118);
        goto L111
    L79:
        r108 = true;
        goto L80
    L94:
        Iterator<e2> r122 = this.f366947c.iterator();
        boolean r123 = true;
    L96:
        if (r122.hasNext() == false) goto L102;
        if (r122.next().f366570c == null) goto L100;
        boolean r124 = true;
    L101:
        r123 = r123 & r124;
        goto L96
    L100:
        r124 = false;
        goto L101
    L102:
        if (r123 == false) goto L111;
        FLogger.f375446a.i("ProfileDefaultTabSelector", "selectDefaultTab, all tab is empty");
        TabLayout.Tab r125 = r100.getTabAt(0);
        if (r125 == null) goto L106;
        r125.select();
    L106:
        this.f366948d = true;
        if (this.f366947c.size() <= 0) goto L111;
        b r126 = this.f366945a;
        if (r126 == null) goto L111;
        r126.a(this.f366947c.get(0), 0);
        goto L111
    L66:
        r118 = -1;
    L48:
        r115 = false;
        goto L50
    L20:
        if (com.larus.bmhome.utils.u.i() == false) goto L44;
        Iterator<e2> r127 = this.f366947c.iterator();
    L23:
        if (r127.hasNext() == false) goto L27;
        e2 r128 = r127.next();
        String r129 = r128.f366568a;
        int r130 = x3.f366399a;
        if (Intrinsics.areEqual(r129, x3.a(2)) == false) goto L23;
    L28:
        e2 r131 = r128;
        if (r131 == null) goto L31;
        boolean r132 = Intrinsics.areEqual(r131.f366570c, Boolean.FALSE);
    L32:
        if (r132 == false) goto L34;
        return false;
    L34:
        TabLayout.Tab r133 = r100.getTabAt(r112);
        if (r133 == null) goto L37;
        r133.select();
    L37:
        FLogger.f375446a.i("ProfileDefaultTabSelector", "selectDefaultTab, privatePosition = " + r112);
        this.f366948d = true;
        if (this.f366947c.size() <= r112) goto L43;
        b r134 = this.f366945a;
        if (r134 == null) goto L43;
        r134.a(this.f366947c.get(r112), r112);
    L43:
        return this.f366948d;
    L31:
        r132 = false;
        goto L32
    L27:
        r128 = null;
        goto L28
    }
}
