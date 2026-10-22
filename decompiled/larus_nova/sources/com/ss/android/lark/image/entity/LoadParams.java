package com.ss.android.lark.image.entity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.Transformation;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public final class LoadParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f426328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f426329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f426330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f426331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView.ScaleType f426332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView.ScaleType f426333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<Transformation<Bitmap>> f426334g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DiskCacheStrategy f426335h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f426336i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f426337j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f426338k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ListenerParams f426339l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f426340m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f426341n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f426342o;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CropType {
        public static final String CROP_BOTTOM = "c2_";
        public static final String CROP_CENTER = "c5_";
        public static final String CROP_LEFT = "c3_";
        public static final String CROP_RIGHT = "c4_";
        public static final String CROP_SMART = "cs_";
        public static final String CROP_TOP = "c1_";
        public static final String NOTHING = "";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ImageFormat {
        public static final String IMAGE = "image";
        public static final String JPEG = "jpeg";
        public static final String PNG = "png";
        public static final String WEBP = "webp";
    }

    public LoadParams() {
        this.f426328a = -1;
        this.f426329b = -1;
        this.f426332e = ImageView.ScaleType.CENTER_CROP;
        this.f426333f = ImageView.ScaleType.CENTER;
        this.f426334g = new ArrayList();
        this.f426335h = DiskCacheStrategy.ALL;
        this.f426336i = false;
        this.f426337j = true;
        this.f426338k = false;
    }
}
