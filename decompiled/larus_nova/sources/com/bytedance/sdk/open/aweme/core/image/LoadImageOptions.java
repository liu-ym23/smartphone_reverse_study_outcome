package com.bytedance.sdk.open.aweme.core.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import java.io.File;

/* JADX INFO: loaded from: classes22.dex */
public class LoadImageOptions {
    public static final int CORNER_ALL = 15;
    public static final int CORNER_BOTTOM_LEFT = 4;
    public static final int CORNER_BOTTOM_RIGHT = 8;
    public static final int CORNER_TOP_LEFT = 1;
    public static final int CORNER_TOP_RIGHT = 2;
    public float bitmapAngle;
    public BitmapLoadCallback bitmapLoadCallBack;
    public Bitmap.Config config;
    public int corners;
    public int drawableResId;
    public int errorResId;
    public File file;
    public boolean isCenterCrop;
    public boolean isCenterInside;
    public boolean isFitXY;
    public Drawable placeholder;
    public int placeholderResId;
    public boolean skipDiskCache;
    public boolean skipMemoryCache;
    public int targetHeight;
    public View targetView;
    public int targetWidth;
    public Uri uri;
    public String url;

    public LoadImageOptions(int r100) {
        this.config = Bitmap.Config.RGB_565;
        this.corners = 15;
        this.drawableResId = r100;
    }

    public LoadImageOptions(Uri r100) {
        this.config = Bitmap.Config.RGB_565;
        this.corners = 15;
        this.uri = r100;
    }

    public LoadImageOptions(File r100) {
        this.config = Bitmap.Config.RGB_565;
        this.corners = 15;
        this.file = r100;
    }

    public LoadImageOptions(String r100) {
        this.config = Bitmap.Config.RGB_565;
        this.corners = 15;
        this.url = r100;
    }

    public LoadImageOptions(String r100, View r101) {
        this.config = Bitmap.Config.RGB_565;
        this.corners = 15;
        this.url = r100;
        this.targetView = r101;
    }

    public LoadImageOptions angle(float r100) {
        this.bitmapAngle = r100;
        return this;
    }

    public LoadImageOptions bitmapLoadCallback(BitmapLoadCallback r100) {
        this.bitmapLoadCallBack = r100;
        return this;
    }

    public LoadImageOptions centerCrop() {
        this.isCenterCrop = true;
        return this;
    }

    public LoadImageOptions centerInside() {
        this.isCenterInside = true;
        return this;
    }

    public LoadImageOptions config(Bitmap.Config r100) {
        this.config = r100;
        return this;
    }

    public LoadImageOptions error(int r100) {
        this.errorResId = r100;
        return this;
    }

    public LoadImageOptions fitXY() {
        this.isFitXY = true;
        return this;
    }

    public LoadImageOptions into(View r100) {
        this.targetView = r100;
        return this;
    }

    public LoadImageOptions placeholder(int r100) {
        this.placeholderResId = r100;
        return this;
    }

    public LoadImageOptions placeholder(Drawable r100) {
        this.placeholder = r100;
        return this;
    }

    public LoadImageOptions resize(int r100, int r101) {
        this.targetWidth = r100;
        this.targetHeight = r101;
        return this;
    }

    public LoadImageOptions skipDiskCache(boolean r100) {
        this.skipDiskCache = r100;
        return this;
    }

    public LoadImageOptions skipMemoryCache(boolean r100) {
        this.skipMemoryCache = r100;
        return this;
    }
}
