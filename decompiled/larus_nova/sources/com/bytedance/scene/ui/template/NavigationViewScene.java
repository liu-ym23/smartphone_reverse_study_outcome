package com.bytedance.scene.ui.template;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import com.bytedance.scene.Scene;
import com.bytedance.scene.group.GroupScene;
import com.bytedance.scene.navigation.d;
import com.bytedance.scene.navigation.j;
import com.google.android.material.navigation.NavigationView;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public abstract class NavigationViewScene extends GroupScene {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Toolbar f268829u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public NavigationView f268830v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public DrawerLayout f268831w;

    public class a implements NavigationView.OnNavigationItemSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NavigationViewScene f268832a;

        public a(NavigationViewScene r100) {
            this.f268832a = r100;
        }

        @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
        public final boolean onNavigationItemSelected(MenuItem r100) {
            this.f268832a.f268829u.setTitle(r100.getTitle());
            return false;
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NavigationViewScene f268833a;

        public b(NavigationViewScene r100) {
            this.f268833a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f268833a.f268831w.openDrawer(3);
        }
    }

    public class c implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NavigationViewScene f268834a;

        @Override // com.bytedance.scene.navigation.j
        public final boolean onBackPressed() {
            NavigationViewScene r100 = this.f268834a;
            if (r100.f268831w.isDrawerOpen(r100.f268830v) == false) goto L6;
            NavigationViewScene r101 = this.f268834a;
            r101.f268831w.closeDrawer(r101.f268830v);
            return true;
        L6:
            return false;
        }

        public c(NavigationViewScene r100) {
            this.f268834a = r100;
        }
    }

    public abstract int A0();

    public abstract LinkedHashMap<Integer, Scene> B0();

    public NavigationViewScene() {
    }

    @Override // com.bytedance.scene.Scene
    public final void T(Bundle r110) {
        super.T(r110);
        ActionBarDrawerToggle r111 = new ActionBarDrawerToggle(getActivity(), this.f268831w, this.f268829u, 0, 0);
        this.f268831w.addDrawerListener(r111);
        r111.syncState();
        this.f268830v.inflateMenu(A0());
        DrawerLayout r100 = this.f268831w;
        NavigationView r112 = this.f268830v;
        LinkedHashMap<Integer, Scene> r101 = B0();
        a r102 = new a(this);
        if (r101.size() == 0) goto L20;
        ArrayList r103 = new ArrayList();
        int r104 = r112.getMenu().size();
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L8;
        r103.add("" + r112.getMenu().getItem(r105).getItemId());
        r105 = r105 + 1;
        goto L6
    L8:
        r112.setNavigationItemSelectedListener(new oa7.b(r102, r112, r101, r100, this, r103));
        Map.Entry<Integer, Scene> r106 = r101.entrySet().iterator().next();
        String r107 = "" + r106.getKey();
        Scene r108 = p0(r107);
        if (r108 != null) goto L12;
        r108 = r106.getValue();
    L12:
        if (r0(r108) == true) goto L15;
        l0(R.id.scene_container, r108, r107);
    L17:
        MenuItem r113 = r112.getMenu().findItem(r106.getKey().intValue());
        r113.setChecked(true);
        r102.onNavigationItemSelected(r113);
        this.f268829u.setNavigationOnClickListener(new b(this));
        d.b(this).l0(this, new c(this));
        return;
    L15:
        if (s0(r108) == true) goto L17;
        z0(r108);
        goto L17
    L20:
        throw new IllegalArgumentException("children can't be empty");
    }

    @Override // com.bytedance.scene.Scene
    public final void g0(View r100, Bundle r101) {
        this.f268595m = true;
        this.f268829u = (Toolbar) Q(R.id.toolbar);
        this.f268830v = (NavigationView) Q(R.id.nav_view);
        this.f268831w = (DrawerLayout) Q(R.id.drawer_layout);
    }

    @Override // com.bytedance.scene.group.GroupScene, com.bytedance.scene.Scene
    public final /* bridge */ /* synthetic */ View Z(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return t0(r100, r101, r102);
    }

    @Override // com.bytedance.scene.group.GroupScene
    public final ViewGroup t0(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return (ViewGroup) r100.inflate(R.layout.scene_navigation_view_layout, r101, false);
    }
}
