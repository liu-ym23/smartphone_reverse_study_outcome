package com.bytedance.scene.ui.template;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.scene.group.GroupScene;
import com.bytedance.scene.navigation.NavigationScene;
import com.bytedance.scene.navigation.j;
import com.bytedance.scene.view.SlidePercentFrameLayout;
import la7.d;
import qa7.f;
import qa7.g;

/* JADX INFO: loaded from: classes19.dex */
public abstract class SwipeBackGroupScene extends GroupScene {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f268835u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public SlidePercentFrameLayout f268836v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f268837w;

    public class a extends d {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ View f268838l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f268839m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ SwipeBackGroupScene f268840n;

        public a(SwipeBackGroupScene r100, View r101, FrameLayout r102) {
            this.f268840n = r100;
            this.f268838l = r101;
            this.f268839m = r102;
        }
    }

    public class b implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f268841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SwipeBackGroupScene f268842b;

        @Override // com.bytedance.scene.navigation.j
        public final boolean onBackPressed() {
            d r100 = this.f268841a;
            if (r100.f508213c == false) goto L6;
            r100.b(0.0f);
            r100.f508213c = false;
            r100.a();
        L6:
            NavigationScene r101 = com.bytedance.scene.navigation.d.b(this.f268842b);
            f.a();
            r101.f268754s.h(this);
            return true;
        }

        public b(SwipeBackGroupScene r100, a r101) {
            this.f268842b = r100;
            this.f268841a = r101;
        }
    }

    public class c implements SlidePercentFrameLayout.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f268843a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f268844b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f268845c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f268846d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ SwipeBackGroupScene f268847e;

        public c(SwipeBackGroupScene r100, a r101, FrameLayout r102, View r103, b r104) {
            this.f268847e = r100;
            this.f268843a = r101;
            this.f268844b = r102;
            this.f268845c = r103;
            this.f268846d = r104;
        }
    }

    public abstract ViewGroup A0(LayoutInflater r100, ViewGroup r101, Bundle r102);

    @Override // com.bytedance.scene.Scene
    public final void a0() {
        this.f268595m = true;
        this.f268836v = null;
    }

    public SwipeBackGroupScene() {
        this.f268835u = -1728053248;
        this.f268837w = true;
    }

    @Override // com.bytedance.scene.group.GroupScene, com.bytedance.scene.Scene
    public final /* bridge */ /* synthetic */ View Z(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return t0(r100, r101, r102);
    }

    @Override // com.bytedance.scene.group.GroupScene
    public final ViewGroup t0(LayoutInflater r100, ViewGroup r110, Bundle r111) {
        this.f268836v = new SlidePercentFrameLayout(j0());
        View r101 = new View(j0());
        r101.setBackgroundColor(this.f268835u);
        r101.setVisibility(8);
        ViewGroup r102 = A0(r100, r110, r111);
        if (r102.getBackground() != null) goto L5;
        ViewCompat.setBackground(r102, g.b(j0()));
    L5:
        FrameLayout r112 = new FrameLayout(j0());
        r112.addView(r102);
        a r103 = new a(this, r101, r112);
        b r104 = new b(this, r103);
        this.f268836v.setCallback(new c(this, r103, r112, r101, r104));
        this.f268836v.addView(r101);
        this.f268836v.addView(r112);
        this.f268836v.setSwipeEnabled(this.f268837w);
        return this.f268836v;
    }
}
