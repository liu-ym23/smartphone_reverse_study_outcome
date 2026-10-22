package com.ss.android.lark.location.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.ss.android.lark.location_ui.picklocation.LocationView;
import com.ss.android.lark.location_ui.picklocation.l;
import com.ss.android.lark.location_ui.picklocation.m;

/* JADX INFO: loaded from: classes36.dex */
public interface IPickLocationMap extends i {

    public static final enum DarkMode extends Enum<DarkMode> {
        public static final DarkMode AUTO = null;
        public static final DarkMode DARK = null;
        public static final DarkMode LIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DarkMode[] f431192a = null;

        static {
            DarkMode r100 = new DarkMode("LIGHT", 0);
            LIGHT = r100;
            DarkMode r101 = new DarkMode("DARK", 1);
            DARK = r101;
            DarkMode r102 = new DarkMode("AUTO", 2);
            AUTO = r102;
            f431192a = new DarkMode[]{r100, r101, r102};
        }

        public static DarkMode[] values() {
            return (DarkMode[]) f431192a.clone();
        }

        public static DarkMode valueOf(String r100) {
            return (DarkMode) r27.a.a(DarkMode.class, r100);
        }

        public DarkMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
    }

    public interface b {
    }

    public interface c {
        void onMapScreenShot(Bitmap r100);
    }

    public interface d {
    }

    void a(double r100, double r101);

    void b();

    void c();

    void d();

    double e();

    void f(double r100, double r101, LocationView.b r102);

    void g();

    void getVendor();

    int getZoomLevel();

    View h(Context r100);

    void i();

    void j(DarkMode r100);

    void k();

    void m(m r100);

    void n(c r100);

    void o(l r100);

    double p();
}
