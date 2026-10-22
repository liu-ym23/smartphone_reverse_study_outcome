package com.ss.android.lark.image.uploader.utils;

import android.text.TextUtils;
import com.ss.android.lark.utils.ImageUtils;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes36.dex */
public final class ImageInfo {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final HashMap<String, ImageUtils.ImageType> f426420j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f426421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f426422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f426423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f426424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f426425e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f426426f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f426427g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageUtils.ImageType f426428h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f426429i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f426430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f426431b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f426432c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f426433d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f426434e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f426435f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f426436g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f426437h;

        public a() {
        }
    }

    static {
        f426420j = new AnonymousClass1();
    }

    public final String toString() {
        Locale r100 = Locale.getDefault();
        Object[] r101 = new Object[7];
        boolean r102 = false;
        r101[0] = Integer.valueOf(this.f426421a);
        r101[1] = Integer.valueOf(this.f426422b);
        r101[2] = Long.valueOf(this.f426423c);
        int r103 = this.f426424d;
        if (r103 >= 0) goto L5;
    L7:
        r101[3] = Boolean.valueOf(r102);
        r101[4] = this.f426425e;
        r101[5] = Integer.valueOf(this.f426426f);
        r101[6] = Boolean.valueOf(this.f426427g);
        return String.format(r100, "w:%d, h:%d, size:%d, compressed:%s, mimeType:%s, exifOrientation:%d, hasExif:%s", r101);
    L5:
        if (r103 >= 95) goto L7;
        r102 = true;
        goto L7
    }

    public ImageInfo(a r100) {
        this.f426421a = r100.f426430a;
        this.f426422b = r100.f426431b;
        this.f426423c = r100.f426432c;
        int r101 = r100.f426433d;
        if (r101 > 0) goto L5;
        r101 = 100;
    L5:
        this.f426424d = r101;
        String r102 = r100.f426434e;
        this.f426425e = r102;
        this.f426426f = r100.f426435f;
        this.f426427g = r100.f426436g;
        if (TextUtils.isEmpty(r102) == true) goto L10;
        HashMap<String, ImageUtils.ImageType> r103 = f426420j;
        if (r103.containsKey(r102) == false) goto L10;
        ImageUtils.ImageType r104 = r103.get(r102);
    L11:
        this.f426428h = r104;
        this.f426429i = r100.f426437h;
        return;
    L10:
        r104 = ImageUtils.ImageType.TYPE_UNKNOWN;
        goto L11
    }

    public static a a(ImageInfo r100) {
        a r101 = new a();
        r101.f426430a = r100.f426421a;
        r101.f426431b = r100.f426422b;
        r101.f426434e = r100.f426425e;
        r101.f426432c = r100.f426423c;
        r101.f426433d = r100.f426424d;
        r101.f426435f = r100.f426426f;
        r101.f426436g = r100.f426427g;
        r101.f426437h = r100.f426429i;
        return r101;
    }
}
