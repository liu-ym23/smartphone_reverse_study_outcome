package ec5;

import android.content.Context;
import android.text.TextUtils;
import android.util.Size;
import android.widget.ImageView;
import com.bumptech.glide.request.RequestListener;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final Context a;
    public final String b;
    public final int c;
    public final RequestListener d;
    public final ImageView e;
    public final String f;
    public final String g;
    public final String h;
    public final int i;
    public final String j;
    public final Size k;
    public final String l;

    /* JADX INFO: renamed from: ec5.a$a, reason: collision with other inner class name */
    public static class C0220a {
        public Context a;
        public String b;
        public int c;
        public RequestListener d;
        public ImageView e;
        public String f;
        public String g;
        public String h;
        public int i;
        public String j;
        public Size k;

        public C0220a() {
            this.j = "chat";
        }
    }

    public final int a() {
        int r0 = this.c;
        if (r0 == 1) goto L18;
        if (r0 == 2) goto L23;
        if (r0 == 3) goto L22;
        if (r0 == 4) goto L21;
        if (r0 == 5) goto L20;
        return e.g.b;
    L20:
        return e.l.b;
    L21:
        return e.k.b;
    L22:
        return e.i.b;
    L23:
        return e.h.b;
    L18:
        return e.g.b;
    }

    public Context getContext() {
        return this.a;
    }

    public int getType() {
        return this.c;
    }

    public a(C0220a r2) {
        this.l = "";
        this.a = r2.a;
        this.b = r2.b;
        this.c = r2.c;
        this.d = r2.d;
        this.e = r2.e;
        this.f = r2.f;
        this.g = r2.g;
        this.h = r2.h;
        this.i = r2.i;
        if (TextUtils.isEmpty(r2.j) == false) goto L5;
        String r0 = "chat";
    L6:
        this.j = r0;
        this.k = r2.k;
        this.l = null;
        return;
    L5:
        r0 = r2.j;
        goto L6
    }
}
