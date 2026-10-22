package ec5;

import android.content.Context;
import android.text.TextUtils;
import android.util.Size;
import android.widget.ImageView;
import com.bumptech.glide.request.RequestListener;
import sbb.e;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f472093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f472094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f472095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RequestListener f472096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f472097e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f472098f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f472099g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f472100h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f472101i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f472102j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Size f472103k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f472104l;

    /* JADX INFO: renamed from: ec5.a$a, reason: collision with other inner class name */
    public static class C5766a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f472105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f472106b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f472107c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RequestListener f472108d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ImageView f472109e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f472110f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f472111g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f472112h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f472113i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f472114j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Size f472115k;

        public C5766a() {
            this.f472114j = "chat";
        }
    }

    public final int a() {
        int r100 = this.f472095c;
        if (r100 == 1) goto L18;
        if (r100 == 2) goto L23;
        if (r100 == 3) goto L22;
        if (r100 == 4) goto L21;
        if (r100 == 5) goto L20;
        return e.f541296g.f541317b;
    L20:
        return e.f541301l.f541317b;
    L21:
        return e.f541300k.f541317b;
    L22:
        return e.f541298i.f541317b;
    L23:
        return e.f541297h.f541317b;
    L18:
        return e.f541296g.f541317b;
    }

    public Context getContext() {
        return this.f472093a;
    }

    public int getType() {
        return this.f472095c;
    }

    public a(C5766a r100) {
        this.f472104l = "";
        this.f472093a = r100.f472105a;
        this.f472094b = r100.f472106b;
        this.f472095c = r100.f472107c;
        this.f472096d = r100.f472108d;
        this.f472097e = r100.f472109e;
        this.f472098f = r100.f472110f;
        this.f472099g = r100.f472111g;
        this.f472100h = r100.f472112h;
        this.f472101i = r100.f472113i;
        if (TextUtils.isEmpty(r100.f472114j) == false) goto L5;
        String r101 = "chat";
    L6:
        this.f472102j = r101;
        this.f472103k = r100.f472115k;
        this.f472104l = null;
        return;
    L5:
        r101 = r100.f472114j;
        goto L6
    }
}
