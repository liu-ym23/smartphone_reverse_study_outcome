package com.bytedance.scene.ui.template;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.scene.Scene;
import com.bytedance.scene.group.GroupScene;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import oa7.a;
import qa7.d;

/* JADX INFO: loaded from: classes19.dex */
public abstract class BottomNavigationViewScene extends GroupScene {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public BottomNavigationView f268828u;

    public abstract int A0();

    public abstract LinkedHashMap<Integer, Scene> B0();

    public BottomNavigationViewScene() {
    }

    @Override // com.bytedance.scene.Scene
    public final void T(Bundle r100) {
        super.T(r100);
        this.f268828u.inflateMenu(A0());
        BottomNavigationView r101 = this.f268828u;
        LinkedHashMap<Integer, Scene> r102 = B0();
        if (r102.size() == 0) goto L20;
        ArrayList r103 = new ArrayList();
        int r104 = r101.getMenu().size();
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L8;
        r103.add("" + r101.getMenu().getItem(r105).getItemId());
        r105 = r105 + 1;
        goto L6
    L8:
        r101.setOnNavigationItemSelectedListener(new a(this, r102, r103));
        Map.Entry<Integer, Scene> r106 = r102.entrySet().iterator().next();
        String r107 = "" + r106.getKey();
        Scene r108 = p0(r107);
        if (r108 != null) goto L12;
        r108 = r106.getValue();
    L12:
        if (r0(r108) == true) goto L15;
        l0(R.id.scene_container, r108, r107);
    L17:
        r101.getMenu().findItem(r106.getKey().intValue()).setChecked(true);
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
        this.f268828u = (BottomNavigationView) Q(R.id.bottom_navigation);
        Q(R.id.scene_container).setOnApplyWindowInsetsListener(new d());
    }

    @Override // com.bytedance.scene.group.GroupScene, com.bytedance.scene.Scene
    public final /* bridge */ /* synthetic */ View Z(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return t0(r100, r101, r102);
    }

    @Override // com.bytedance.scene.group.GroupScene
    public final ViewGroup t0(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return (ViewGroup) r100.inflate(R.layout.scene_bottom_navigation_view_layout, r101, false);
    }
}
