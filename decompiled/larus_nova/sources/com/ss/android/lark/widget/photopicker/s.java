package com.ss.android.lark.widget.photopicker;

import android.os.Bundle;
import com.larus.nova.R;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.camera_export.CameraSettings;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import java.util.ArrayList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class s {
    public static final /* synthetic */ int C = 0;
    public final boolean A;
    public final boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f447556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f447557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f447558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f447559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f447560e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f447561f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f447562g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f447563h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f447564i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f447565j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f447566k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f447567l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f447568m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f447569n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f447570o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f447571p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f447572q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f447573r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ArrayList<Photo> f447574s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Biz f447575t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Scene f447576u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f447577v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f447578w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f447579x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f447580y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f447581z;

    public static final class a {
        public boolean A;
        public boolean B;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f447582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f447583b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f447584c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f447585d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f447586e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f447587f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f447588g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f447589h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f447590i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f447591j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f447592k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f447593l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f447594m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f447595n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f447596o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f447597p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f447598q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public String f447599r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public ArrayList<Photo> f447600s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public Biz f447601t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public Scene f447602u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f447603v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f447604w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f447605x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f447606y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f447607z;

        public a() {
            this.f447584c = 9;
            this.f447585d = -1;
            this.f447590i = CameraSettings.getCameraVideoMaxDuration();
            this.f447592k = true;
            this.f447596o = true;
            this.f447597p = 4;
            this.f447599r = UIHelper.getString(R.string.Lark_Legacy_PickerConfirm);
            this.f447600s = new ArrayList();
        }
    }

    public static final class b {
        @JvmStatic
        public static s a(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "block");
            a r101 = new a();
            r100.invoke(r101);
            return new s(r101);
        }
    }

    static {
    }

    public s(a r100) {
        this.f447556a = r100.f447582a;
        this.f447557b = r100.f447583b;
        this.f447558c = r100.f447584c;
        this.f447559d = r100.f447585d;
        this.f447560e = r100.f447587f;
        this.f447561f = r100.f447586e;
        this.f447562g = r100.f447588g;
        this.f447563h = r100.f447589h;
        this.f447564i = r100.f447590i;
        this.f447565j = r100.f447591j;
        this.f447566k = r100.f447592k;
        this.f447567l = r100.f447593l;
        this.f447568m = r100.f447594m;
        this.f447569n = r100.f447595n;
        this.f447570o = r100.f447596o;
        this.f447571p = r100.f447597p;
        this.f447572q = r100.f447598q;
        this.f447573r = r100.f447599r;
        this.f447574s = r100.f447600s;
        this.f447575t = r100.f447601t;
        this.f447576u = r100.f447602u;
        this.f447577v = r100.f447603v;
        this.f447578w = r100.f447604w;
        this.f447579x = r100.f447605x;
        this.f447580y = r100.f447606y;
        this.f447581z = r100.f447607z;
        this.A = r100.A;
        this.B = r100.B;
    }

    @JvmStatic
    public static final s a(final Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        return b.a(new PickerParams$Companion$fromBundle$1(r100));
    }
}
