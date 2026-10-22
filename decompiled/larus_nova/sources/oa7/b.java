package oa7;

import android.view.Menu;
import android.view.MenuItem;
import androidx.drawerlayout.widget.DrawerLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.scene.Scene;
import com.bytedance.scene.group.GroupScene;
import com.bytedance.scene.ui.template.NavigationViewScene;
import com.google.android.material.navigation.NavigationView;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements NavigationView.OnNavigationItemSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NavigationView.OnNavigationItemSelectedListener f522572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NavigationView f522573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LinkedHashMap f522574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DrawerLayout f522575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ GroupScene f522576e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f522577f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ List f522578g;

    @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
    public final boolean onNavigationItemSelected(MenuItem r100) {
        NavigationView.OnNavigationItemSelectedListener r101 = this.f522572a;
        if (r101 == null) goto L5;
        r101.onNavigationItemSelected(r100);
    L5:
        Menu r102 = this.f522573b.getMenu();
        Iterator r103 = this.f522574c.keySet().iterator();
    L6:
        int r104 = 0;
        if (r103.hasNext() == false) goto L12;
        MenuItem r105 = r102.findItem(((Integer) r103.next()).intValue());
        if (r105 == r100) goto L10;
        r105.setChecked(false);
        goto L6
    L10:
        r105.setChecked(true);
        goto L6
    L12:
        this.f522575d.closeDrawer(this.f522573b);
        String r106 = "" + r100.getItemId();
        Scene r107 = this.f522576e.p0(r106);
        if (r107 != null) goto L16;
        r107 = (Scene) this.f522574c.get(Integer.valueOf(r100.getItemId()));
    L16:
        if (this.f522576e.r0(r107) == true) goto L19;
        this.f522576e.l0(this.f522577f, r107, r106);
    L22:
        if (r104 >= this.f522578g.size()) goto L32;
        Scene r108 = this.f522576e.p0((String) ListProtector.get(this.f522578g, r104));
        if (r108 == null) goto L31;
        if (r108 == r107) goto L31;
        if (this.f522576e.r0(r108) == false) goto L31;
        if (this.f522576e.s0(r108) == false) goto L31;
        this.f522576e.q0(r108);
    L31:
        r104 = r104 + 1;
        goto L22
    L32:
        return true;
    L19:
        if (this.f522576e.s0(r107) == true) goto L22;
        this.f522576e.z0(r107);
        goto L22
    }

    public b(NavigationViewScene.a r100, NavigationView r101, LinkedHashMap r102, DrawerLayout r103, GroupScene r104, List r105) {
        this.f522572a = r100;
        this.f522573b = r101;
        this.f522574c = r102;
        this.f522575d = r103;
        this.f522576e = r104;
        this.f522577f = R.id.scene_container;
        this.f522578g = r105;
    }
}
