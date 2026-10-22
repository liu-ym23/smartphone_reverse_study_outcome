package oa7;

import android.view.MenuItem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.scene.Scene;
import com.bytedance.scene.group.GroupScene;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.larus.nova.R;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements BottomNavigationView.OnNavigationItemSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GroupScene f522568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LinkedHashMap f522569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f522570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List f522571d;

    @Override // com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
    public final boolean onNavigationItemSelected(MenuItem r100) {
        r100.setChecked(true);
        String r101 = "" + r100.getItemId();
        Scene r102 = this.f522568a.p0(r101);
        if (r102 != null) goto L6;
        r102 = (Scene) this.f522569b.get(Integer.valueOf(r100.getItemId()));
    L6:
        if (this.f522568a.r0(r102) == true) goto L9;
        this.f522568a.l0(this.f522570c, r102, r101);
    L11:
        int r103 = 0;
    L13:
        if (r103 >= this.f522571d.size()) goto L23;
        Scene r104 = this.f522568a.p0((String) ListProtector.get(this.f522571d, r103));
        if (r104 == null) goto L22;
        if (r104 == r102) goto L22;
        if (this.f522568a.r0(r104) == false) goto L22;
        if (this.f522568a.s0(r104) == false) goto L22;
        this.f522568a.q0(r104);
    L22:
        r103 = r103 + 1;
        goto L13
    L23:
        return true;
    L9:
        if (this.f522568a.s0(r102) == true) goto L11;
        this.f522568a.z0(r102);
        goto L11
    }

    public a(GroupScene r100, LinkedHashMap r101, List r102) {
        this.f522568a = r100;
        this.f522569b = r101;
        this.f522570c = R.id.scene_container;
        this.f522571d = r102;
    }
}
