package u2c;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TabLayout f548533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewPager2 f548534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f548535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView.Adapter<?> f548536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f548537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f548538f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f548539g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public C7823a f548540h;

    /* JADX INFO: renamed from: u2c.a$a, reason: collision with other inner class name */
    public class C7823a extends RecyclerView.AdapterDataObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f548541a;

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onChanged() {
            this.f548541a.c();
        }

        public C7823a(a r100) {
            this.f548541a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r100, int r101) {
            this.f548541a.c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int r100, int r101) {
            this.f548541a.c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int r100, int r101) {
            this.f548541a.c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r100, int r101, Object r102) {
            this.f548541a.c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int r100, int r101, int r102) {
            this.f548541a.c();
        }
    }

    public interface b {
        void a(TabLayout.Tab r100, int r101);
    }

    public static class c extends ViewPager2.OnPageChangeCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<TabLayout> f548542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f548543b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f548544c;

        public c(TabLayout r100) {
            this.f548542a = new WeakReference(r100);
            this.f548544c = 0;
            this.f548543b = 0;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageScrollStateChanged(int r100) {
            this.f548543b = this.f548544c;
            this.f548544c = r100;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageSelected(int r110) {
            TabLayout r100 = this.f548542a.get();
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.getSelectedTabPosition() != r110) goto L7;
            return;
        L7:
            if (r110 >= r100.getTabCount()) goto L26;
            int r101 = this.f548544c;
            if (r101 == 0) goto L15;
            if (r101 == 2) goto L12;
        L14:
            boolean r102 = false;
        L16:
            TabLayout.Tab r111 = r100.getTabAt(r110);
            Method r103 = TabLayout.class.getDeclaredMethod("selectTab", new Class[]{TabLayout.Tab.class, Boolean.TYPE});     // Catch: Exception -> L19
            r103.setAccessible(true);     // Catch: Exception -> L19
            r103.invoke(r100, new Object[]{r111, Boolean.valueOf(r102)});     // Catch: Exception -> L19
            return;
        L19:
            e = move-exception;
            e.printStackTrace();
            return;
        L12:
            if (this.f548543b != 0) goto L14;
        L15:
            r102 = true;
            goto L16
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageScrolled(int r110, float r111, int r112) {
            TabLayout r113 = this.f548542a.get();
            if (r113 == null) goto L24;
            int r100 = this.f548544c;
            if (r100 == 2) goto L7;
        L10:
            boolean r101 = true;
        L11:
            if (r100 == 2) goto L13;
        L16:
            boolean r102 = true;
        L22:
            Class r103 = Boolean.TYPE;     // Catch: Exception -> L19
            Method r104 = TabLayout.class.getDeclaredMethod("setScrollPosition", new Class[]{Integer.TYPE, Float.TYPE, r103, r103});     // Catch: Exception -> L19
            r104.setAccessible(true);     // Catch: Exception -> L19
            r104.invoke(r113, new Object[]{Integer.valueOf(r110), Float.valueOf(r111), Boolean.valueOf(r101), Boolean.valueOf(r102)});     // Catch: Exception -> L19
            return;
        L19:
            e = move-exception;
            e.printStackTrace();
            return;
        L13:
            if (this.f548543b != 0) goto L16;
            r102 = false;
            goto L22
        L7:
            if (this.f548543b == 1) goto L10;
            r101 = false;
            goto L11
        }
    }

    public static class d implements TabLayout.BaseOnTabSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewPager2 f548545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f548546b;

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabReselected(TabLayout.Tab r100) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabUnselected(TabLayout.Tab r100) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabSelected(TabLayout.Tab r100) {
            this.f548545a.setCurrentItem(r100.getPosition(), this.f548546b);
        }

        public d(ViewPager2 r100, boolean r101) {
            this.f548545a = r100;
            this.f548546b = r101;
        }
    }

    public final void a() {
        if (this.f548537e == true) goto L11;
        RecyclerView.Adapter<?> r100 = this.f548534b.getAdapter();
        this.f548536d = r100;
        if (r100 == null) goto L9;
        this.f548537e = true;
        c r101 = new c(this.f548533a);
        this.f548538f = r101;
        this.f548534b.registerOnPageChangeCallback(r101);
        d r102 = new d(this.f548534b, true);
        this.f548539g = r102;
        this.f548533a.addOnTabSelectedListener(r102);
        C7823a r103 = new C7823a(this);
        this.f548540h = r103;
        this.f548536d.registerAdapterDataObserver(r103);
        c();
        this.f548533a.setScrollPosition(this.f548534b.getCurrentItem(), 0.0f, true);
        return;
    L9:
        throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
    L11:
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }

    public final void b() {
        RecyclerView.Adapter<?> r100 = this.f548536d;
        if (r100 == null) goto L5;
        r100.unregisterAdapterDataObserver(this.f548540h);
        this.f548540h = null;
    L5:
        this.f548533a.removeOnTabSelectedListener(this.f548539g);
        this.f548534b.unregisterOnPageChangeCallback(this.f548538f);
        this.f548539g = null;
        this.f548538f = null;
        this.f548536d = null;
        this.f548537e = false;
    }

    public final void c() {
        this.f548533a.removeAllTabs();
        RecyclerView.Adapter<?> r100 = this.f548536d;
        if (r100 == null) goto L19;
        int r101 = r100.getItemCount();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L7;
        TabLayout.Tab r103 = this.f548533a.newTab();
        this.f548535c.a(r103, r102);
        this.f548533a.addTab(r103, false);
        r102 = r102 + 1;
        goto L5
    L7:
        if (r101 <= 0) goto L20;
        int r104 = Math.min(this.f548534b.getCurrentItem(), this.f548533a.getTabCount() - 1);
        if (r104 == this.f548533a.getSelectedTabPosition()) goto L21;
        TabLayout r105 = this.f548533a;
        TabLayout.Tab r106 = r105.getTabAt(r104);
        Method r107 = TabLayout.class.getDeclaredMethod("selectTab", new Class[]{TabLayout.Tab.class});     // Catch: Exception -> L13
        r107.setAccessible(true);     // Catch: Exception -> L13
        r107.invoke(r105, new Object[]{r106});     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L21:
        return;
    L20:
        return;
    }

    public a(TabLayout r100, ViewPager2 r101, b r102) {
        this.f548533a = r100;
        this.f548534b = r101;
        this.f548535c = r102;
    }
}
