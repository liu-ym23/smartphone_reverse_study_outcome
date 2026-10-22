package com.davemorrissey.labs.subscaleview;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes22.dex */
public final class ImageSource {
    static final String ASSET_SCHEME = "file:///android_asset/";
    static final String FILE_SCHEME = "file:///";
    private final Bitmap bitmap;
    private boolean cached;
    private final Integer resource;
    private int sHeight;
    private Rect sRegion;
    private int sWidth;
    private boolean tile;
    private final Uri uri;

    public ImageSource tilingDisabled() {
        return tiling(false);
    }

    public ImageSource tilingEnabled() {
        return tiling(true);
    }

    private void setInvariants() {
        Rect r100 = this.sRegion;
        if (r100 == null) goto L6;
        this.tile = true;
        this.sWidth = r100.width();
        this.sHeight = this.sRegion.height();
        return;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final Integer getResource() {
        return this.resource;
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final Rect getSRegion() {
        return this.sRegion;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final boolean getTile() {
        return this.tile;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final boolean isCached() {
        return this.cached;
    }

    private ImageSource(Uri r100) {
        String r101 = r100.toString();
        if (r101.startsWith(FILE_SCHEME) == true) goto L5;
    L7:
        this.bitmap = null;
        this.uri = r100;
        this.resource = null;
        this.tile = true;
        return;
    L5:
        if (new PolarisFileWrapper(r101.substring(7)).exists() == true) goto L7;
        r100 = UriProtector.parse(URLDecoder.decode(r101, "UTF-8"));     // Catch: UnsupportedEncodingException -> L9
        goto L7
    }

    public static ImageSource asset(String r100) {
        if (r100 == null) goto L6;
        return uri(ASSET_SCHEME.concat(r100));
    L6:
        throw new NullPointerException("Asset name must not be null");
    }

    public static ImageSource bitmap(Bitmap r100) {
        if (r100 == null) goto L6;
        return new ImageSource(r100, false);
    L6:
        throw new NullPointerException("Bitmap must not be null");
    }

    public static ImageSource cachedBitmap(Bitmap r100) {
        if (r100 == null) goto L6;
        return new ImageSource(r100, true);
    L6:
        throw new NullPointerException("Bitmap must not be null");
    }

    public static ImageSource resource(int r100) {
        return new ImageSource(r100);
    }

    public static ImageSource uri(String r100) {
        if (r100 == null) goto L12;
        if (r100.contains("://") == true) goto L10;
        if (r100.startsWith(HTTP.URL_DEFAULT) == false) goto L8;
        r100 = r100.substring(1);
    L8:
        r100 = FILE_SCHEME + r100;
    L10:
        return new ImageSource(UriProtector.parse(r100));
    L12:
        throw new NullPointerException("Uri must not be null");
    }

    public ImageSource region(Rect r100) {
        this.sRegion = r100;
        setInvariants();
        return this;
    }

    public ImageSource tiling(boolean r100) {
        this.tile = r100;
        return this;
    }

    private ImageSource(int r100) {
        this.bitmap = null;
        this.uri = null;
        this.resource = Integer.valueOf(r100);
        this.tile = true;
    }

    public static ImageSource uri(Uri r100) {
        if (r100 == null) goto L6;
        return new ImageSource(r100);
    L6:
        throw new NullPointerException("Uri must not be null");
    }

    private ImageSource(Bitmap r100, boolean r101) {
        this.bitmap = r100;
        this.uri = null;
        this.resource = null;
        this.tile = false;
        this.sWidth = r100.getWidth();
        this.sHeight = r100.getHeight();
        this.cached = r101;
    }

    public ImageSource dimensions(int r100, int r101) {
        if (this.bitmap != null) goto L5;
        this.sWidth = r100;
        this.sHeight = r101;
    L5:
        setInvariants();
        return this;
    }
}
