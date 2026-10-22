package df6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bytedance.lighten.core.CacheChoice;
import com.bytedance.lighten.core.CircleOptions;
import com.bytedance.lighten.core.ImagePiplinePriority;
import com.bytedance.lighten.core.ImageRequestType;
import com.bytedance.lighten.core.ScaleType;

/* JADX INFO: loaded from: classes20.dex */
public final class t {
    public final ImageView A;
    public hf6.f B;
    public final hf6.g C;
    public final hf6.i D;
    public final ef6.a E;
    public final String F;
    public final v G;
    public final int H;
    public ImageRequestType I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f468249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f468250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f468251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f468252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f468253e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f468254f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f468255g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f468256h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f468257i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f468258j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f468259k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f468260l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f468261m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f468262n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f468263o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Drawable f468264p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ScaleType f468265q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f468266r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Bitmap.Config f468267s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ScaleType f468268t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final CircleOptions f468269u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b f468270v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ImagePiplinePriority f468271w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f468272x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final CacheChoice f468273y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final l f468274z;

    public Context getContext() {
        return this.f468250b;
    }

    public ImageRequestType getType() {
        return this.I;
    }

    public t(u r100) {
        this.I = ImageRequestType.DISPLAY;
        this.f468249a = r100.f468275a;
        this.f468250b = r100.getContext();
        this.f468251c = r100.f468278d;
        this.f468253e = true;
        this.f468254f = false;
        this.f468255g = r100.f468279e;
        this.f468256h = r100.f468280f;
        this.f468257i = false;
        this.f468258j = false;
        this.f468259k = r100.f468281g;
        this.f468260l = r100.f468282h;
        this.f468261m = -1.0f;
        this.f468262n = -1;
        this.f468263o = r100.f468283i;
        this.f468264p = r100.f468284j;
        this.f468265q = r100.f468285k;
        this.f468266r = r100.f468286l;
        this.f468267s = r100.f468287m;
        this.f468268t = r100.f468288n;
        this.f468269u = r100.f468289o;
        this.f468270v = r100.f468290p;
        this.f468271w = r100.f468291q;
        this.f468272x = r100.f468292r;
        this.f468273y = r100.f468293s;
        this.f468274z = r100.f468294t;
        this.A = r100.f468295u;
        this.B = r100.f468296v;
        this.C = r100.f468297w;
        this.D = r100.f468298x;
        this.E = r100.f468299y;
        this.f468252d = r100.f468300z;
        this.F = null;
        this.G = null;
        this.H = r100.A;
    }
}
