package qsc;

import android.text.Spanned;
import android.widget.TextView;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import iw8.d;
import kotlin.jvm.internal.Intrinsics;
import lsc.p;
import uvc.b;
import wsc.f;

/* JADX INFO: loaded from: classes5.dex */
public final class a extends lsc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f534762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f534763b;

    /* JADX INFO: renamed from: qsc.a$a, reason: collision with other inner class name */
    public static final class C7389a {
        public static f[] a(CharSequence r100) {
            Intrinsics.checkNotNullParameter(r100, SRStrategy.MEDIAINFO_KEY_CACHE_SIZE);
            if (r100.length() <= 0) goto L5;
            boolean r101 = true;
        L7:
            if (r101 == true) goto L9;
            return null;
        L9:
            if ((r100 instanceof Spanned) == false) goto L11;
            Spanned r102 = (Spanned) r100;
        L12:
            if (r102 != null) goto L14;
            return null;
        L14:
            return (f[]) r102.getSpans(0, r100.length(), f.class);
        L11:
            r102 = null;
            goto L12
        L5:
            r101 = false;
            goto L7
        }
    }

    static {
    }

    @Override // lsc.a, lsc.j
    public final void G4(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        if (this.f534763b == true) goto L6;
        this.f534762a.f496240a.clear();
        return;
    }

    public a(d r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "drawablePool");
        this.f534762a = r100;
        this.f534763b = r101;
    }

    @Override // lsc.a, lsc.j
    public final void i(CharSequence r100, b r101) {
        Intrinsics.checkNotNullParameter(r101, "node");
        if (r100 == null) goto L9;
        f[] r102 = C7389a.a(r100);
        if (r102 == null) goto L11;
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L12;
        f r105 = r102[r104];
        d r106 = this.f534762a;
        wsc.a r107 = r105.f561138b;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "drawable");
        r106.f496240a.add(r107);
        r104 = r104 + 1;
        goto L7
    L12:
        return;
    L11:
        return;
    }

    @Override // lsc.a, lsc.j
    public final void l(TextView r100, b r101) {
        Intrinsics.checkNotNullParameter(r101, "node");
        if (r100 == null) goto L9;
        f[] r102 = C7389a.a(r100.getText());
        if (r102 == null) goto L11;
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L12;
        f r105 = r102[r104];
        d r106 = this.f534762a;
        wsc.a r107 = r105.f561138b;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "drawable");
        r106.f496240a.add(r107);
        r104 = r104 + 1;
        goto L7
    L12:
        return;
    L11:
        return;
    }

    @Override // lsc.a
    public final void m(b r100, p r101) {
        Intrinsics.checkNotNullParameter(r100, "node");
        Intrinsics.checkNotNullParameter(r101, "visitor");
        if (this.f534763b == false) goto L6;
        this.f534762a.f496240a.clear();
        return;
    }
}
