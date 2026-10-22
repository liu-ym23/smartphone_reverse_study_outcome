package df6;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.lighten.core.CacheChoice;
import com.bytedance.lighten.core.CircleOptions;
import com.bytedance.lighten.core.ImagePiplinePriority;
import com.bytedance.lighten.core.ImageRequestType;
import com.bytedance.lighten.core.ScaleType;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Collections;

/* JADX INFO: loaded from: classes20.dex */
public final class u {
    public static final u B = null;
    public final int A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Uri f468275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f468276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f468277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f468278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f468279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f468280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f468281g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f468282h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f468283i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f468284j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ScaleType f468285k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f468286l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Bitmap.Config f468287m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ScaleType f468288n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CircleOptions f468289o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f468290p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ImagePiplinePriority f468291q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f468292r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CacheChoice f468293s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public l f468294t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ImageView f468295u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public hf6.f f468296v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public hf6.g f468297w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public hf6.i f468298x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ef6.a f468299y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f468300z;

    static {
        u r100 = new u(new ef6.a(Collections.emptyList()));
        r100.f468275a = UriProtector.parse("");
        B = r100;
    }

    public final t a() {
        if (this.f468276b == null) goto L11;
        if (this.f468299y != null) goto L11;
        if (this.f468275a != null) goto L11;
        s r100 = s.f468248a;
        q.a().getClass();
    L11:
        if (this.f468275a != null) goto L17;
        ef6.a r101 = this.f468299y;
        if (r101 != null) goto L15;
    L16:
        boolean r102 = true;
    L19:
        if (r102 == false) goto L22;
        return null;
    L22:
        if (this.f468287m != null) goto L25;
        s r103 = s.f468248a;
        q.a().getClass();
        this.f468287m = null;
    L25:
        if (this.f468279e != (-1)) goto L27;
        s r104 = s.f468248a;
        this.f468279e = q.a().f468232b;
    L27:
        u r105 = B;
        if (this != r105) goto L31;
        this.f468277c = s.f468248a.getContext().getApplicationContext();
    L31:
        if (this.f468277c != null) goto L52;
        Object r106 = this.f468294t;
        if ((r106 instanceof View) == false) goto L41;
        Context r107 = ((View) r106).getContext();
        this.f468277c = r107;
        if ((r107 instanceof Activity) == true) goto L52;
        if ((r107 instanceof ContextWrapper) == false) goto L50;
        this.f468277c = ((ContextWrapper) r107).getBaseContext();
    L50:
        if (this.f468277c != null) goto L52;
        this.f468277c = s.f468248a.getContext();
        goto L52
    L41:
        ImageView r108 = this.f468295u;
        if (r108 == null) goto L50;
        Context r109 = r108.getContext();
        this.f468277c = r109;
        if ((r109 instanceof Activity) == true) goto L52;
        if ((r109 instanceof ContextWrapper) == false) goto L50;
        this.f468277c = ((ContextWrapper) r109).getBaseContext();
    L52:
        s r110 = s.f468248a;
        q.a().getClass();
        if (this.f468291q != null) goto L56;
        q.a().getClass();
    L56:
        if (this.f468291q != null) goto L59;
        this.f468291q = ImagePiplinePriority.MEDIUM;
    L59:
        if (q.a().f468241k == false) goto L65;
        t r111 = new t(this);
        if (this != r105) goto L63;
        this.f468295u = null;
        this.f468294t = null;
        this.f468298x = null;
        this.f468296v = null;
        this.f468297w = null;
    L63:
        return r111;
    L65:
        return new t(this);
    L15:
        if (r101.a() == true) goto L16;
    L17:
        r102 = false;
        goto L19
    }

    public final void c() {
        if (this.f468294t == null) goto L5;
    L9:
        t r100 = a();
        if (q.f468229c == false) goto L16;
        if (r100 == null) goto L17;
        r100.I = ImageRequestType.DISPLAY;
        q.f468227a.display(r100);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        if (this.f468295u != null) goto L9;
        throw new IllegalArgumentException("Lighten:needs SmartImageView to display, use with(view)");
    }

    public Context getContext() {
        return this.f468277c;
    }

    public u(String r100) {
        this.f468278d = false;
        this.f468279e = -1;
        this.f468280f = false;
        this.f468281g = -1;
        this.f468282h = -1;
        this.f468283i = -1;
        this.f468286l = -1;
        this.f468289o = null;
        this.f468293s = CacheChoice.DEFAULT;
        int r101 = a.f468212a;
        this.f468300z = -1;
        this.A = -1;
        this.f468275a = UriProtector.parse(r100);
    }

    public final void b(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.f468292r = r100;
        return;
    }

    public final void d(hf6.f r100) {
        if (this.f468294t == null) goto L5;
    L9:
        this.f468296v = r100;
        t r101 = a();
        if (q.f468229c == false) goto L16;
        if (r101 == null) goto L17;
        r101.I = ImageRequestType.DISPLAY;
        q.f468227a.display(r101);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        if (this.f468295u != null) goto L9;
        throw new IllegalArgumentException("Lighten:needs SmartImageView to display, use with(view)");
    }

    public final void e(hf6.e r100) {
        this.f468298x = r100;
        t r101 = a();
        if (q.f468229c == false) goto L9;
        if (r101 == null) goto L10;
        r101.I = ImageRequestType.LOAD_BITMAP;
        q.f468227a.loadBitmap(r101);
        return;
    L10:
        return;
    }

    public u(Uri r100) {
        this.f468278d = false;
        this.f468279e = -1;
        this.f468280f = false;
        this.f468281g = -1;
        this.f468282h = -1;
        this.f468283i = -1;
        this.f468286l = -1;
        this.f468289o = null;
        this.f468293s = CacheChoice.DEFAULT;
        int r101 = a.f468212a;
        this.f468300z = -1;
        this.A = -1;
        this.f468275a = r100;
    }

    public u(ef6.a r100) {
        this.f468278d = false;
        this.f468279e = -1;
        this.f468280f = false;
        this.f468281g = -1;
        this.f468282h = -1;
        this.f468283i = -1;
        this.f468286l = -1;
        this.f468289o = null;
        this.f468293s = CacheChoice.DEFAULT;
        int r101 = a.f468212a;
        this.f468300z = -1;
        this.A = -1;
        this.f468299y = r100;
    }

    public u(Object r100) {
        this.f468278d = false;
        this.f468279e = -1;
        this.f468280f = false;
        this.f468281g = -1;
        this.f468282h = -1;
        this.f468283i = -1;
        this.f468286l = -1;
        this.f468289o = null;
        this.f468293s = CacheChoice.DEFAULT;
        int r101 = a.f468212a;
        this.f468300z = -1;
        this.A = -1;
        this.f468276b = r100;
    }
}
