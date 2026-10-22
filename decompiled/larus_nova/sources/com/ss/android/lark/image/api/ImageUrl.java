package com.ss.android.lark.image.api;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public class ImageUrl implements Key {
    private static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
    private volatile byte[] cacheKeyBytes;
    private Map<String, String> headers;
    private String safeStringUrl;
    private URL safeUrl;
    private final String stringUrl;
    private final URL url;

    private byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes != null) goto L6;
        this.cacheKeyBytes = getCacheKey().getBytes(Key.CHARSET);
    L6:
        return this.cacheKeyBytes;
    }

    private String getSafeStringUrl() {
        if (TextUtils.isEmpty(this.safeStringUrl) == false) goto L9;
        String r100 = this.stringUrl;
        if (TextUtils.isEmpty(r100) == false) goto L7;
        r100 = this.url.toString();
    L7:
        this.safeStringUrl = Uri.encode(r100, ALLOWED_URI_CHARS);
    L9:
        return this.safeStringUrl;
    }

    private URL getSafeUrl() throws MalformedURLException {
        if (this.safeUrl != null) goto L6;
        this.safeUrl = new URL(getSafeStringUrl());
    L6:
        return this.safeUrl;
    }

    public String getCacheKey() {
        String r100 = this.stringUrl;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return this.url.toString();
    }

    public String toString() {
        return getCacheKey() + '\n' + this.headers.toString();
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (getCacheKey().hashCode() * 31) + this.headers.hashCode();
    }

    public String toStringUrl() {
        return getSafeStringUrl();
    }

    public URL toURL() throws MalformedURLException {
        return getSafeUrl();
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public ImageUrl(String r100) {
        this(r100, new HashMap());
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if ((r100 instanceof ImageUrl) == false) goto L10;
        ImageUrl r101 = (ImageUrl) r100;
        if (getCacheKey().equals(r101.getCacheKey()) == true) goto L7;
        return false;
    L7:
        if (this.headers.equals(r101.headers) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        r100.update(getCacheKeyBytes());
    }

    public ImageUrl(URL r100) {
        this(r100, new HashMap());
    }

    public ImageUrl(String r100, Map<String, String> r101) {
        this.headers = new HashMap();
        if (TextUtils.isEmpty(r100) == true) goto L10;
        if (r101 == null) goto L8;
        this.stringUrl = r100;
        this.url = null;
        this.headers = r101;
        return;
    L8:
        throw new IllegalArgumentException("Headers must not be null");
    L10:
        throw new IllegalArgumentException("String url must not be empty or null: " + r100);
    }

    public ImageUrl(URL r100, Map<String, String> r101) {
        this.headers = new HashMap();
        if (r100 == null) goto L10;
        if (r101 == null) goto L8;
        this.url = r100;
        this.stringUrl = null;
        this.headers = r101;
        return;
    L8:
        throw new IllegalArgumentException("Headers must not be null");
    L10:
        throw new IllegalArgumentException("URL must not be null!");
    }
}
