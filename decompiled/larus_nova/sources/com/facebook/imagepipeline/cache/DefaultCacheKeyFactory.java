package com.facebook.imagepipeline.cache;

import android.net.Uri;
import android.util.Pair;
import android.view.View;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultCacheKeyFactory implements CacheKeyFactory {
    private static DefaultCacheKeyFactory sInstance;
    private Set<String> cacheKeepHostAllowSet;
    private String[] cacheKeepHostAllowlist;
    private boolean cacheKeyOnlyPath;
    private boolean cacheKeyUseSet;
    private Set<String> cacheNoHostAllowSet;
    private String[] cacheNoHostAllowlist;
    private boolean ignoreHttpScheme;
    private boolean ignoreRotationOptions;
    private boolean useUriWithoutHost;
    private boolean useUriWithoutHostBlackList;

    public Uri getCacheKeySourceUri(Uri r100) {
        return r100;
    }

    private void generateCacheSet() {
        String[] r100 = this.cacheNoHostAllowlist;
        if (r100 != null) goto L5;
    L7:
        String[] r101 = this.cacheKeepHostAllowlist;
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.length <= 0) goto L14;
        this.cacheKeepHostAllowSet = new HashSet(Arrays.asList(this.cacheKeepHostAllowlist));
        this.cacheKeepHostAllowlist = null;
        return;
    L14:
        return;
    L5:
        if (r100.length <= 0) goto L7;
        this.cacheNoHostAllowSet = new HashSet(Arrays.asList(this.cacheNoHostAllowlist));
        this.cacheNoHostAllowlist = null;
        goto L7
    }

    public static synchronized DefaultCacheKeyFactory getInstance() {
        monitor-enter(DefaultCacheKeyFactory.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new DefaultCacheKeyFactory();     // Catch: Throwable -> L10
    L7:
        DefaultCacheKeyFactory r100 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(DefaultCacheKeyFactory.class);
        return r100;
    }

    private boolean isKeepHostCollectionEmpty() {
        return isHostCollectionEmpty(this.cacheKeepHostAllowlist, this.cacheKeepHostAllowSet);
    }

    private boolean isNoHostCollectionEmpty() {
        return isHostCollectionEmpty(this.cacheNoHostAllowlist, this.cacheNoHostAllowSet);
    }

    public DefaultCacheKeyFactory() {
        this.useUriWithoutHost = false;
        this.useUriWithoutHostBlackList = false;
        this.cacheKeyOnlyPath = false;
        this.ignoreRotationOptions = false;
        this.ignoreHttpScheme = false;
        this.cacheNoHostAllowlist = null;
        this.cacheNoHostAllowSet = null;
        this.cacheKeepHostAllowlist = null;
        this.cacheKeepHostAllowSet = null;
        this.cacheKeyUseSet = false;
    }

    private Uri getCacheKeySourceUri(ImageRequest r100) {
        Uri r101 = r100.getCacheKeyUri();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return r100.getSourceUri();
    }

    private String getUriCacheKey(Uri r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if ("http".equals(r100.getScheme()) == true) goto L12;
        if ("https".equals(r100.getScheme()) == true) goto L12;
        return r100.toString();
    L12:
        if (this.useUriWithoutHostBlackList == false) goto L27;
        if (isKeepHostCollectionEmpty() == true) goto L16;
        String r101 = r100.getHost();
        if (r101 == null) goto L25;
        if (isInKeepHostCollection(r101) == true) goto L25;
        return toStringWithoutHost(r100);
    L25:
        return r100.toString();
    L16:
        return toStringWithoutHost(r100);
    L27:
        if (isNoHostCollectionEmpty() == true) goto L29;
        String r102 = r100.getHost();
        if (r102 == null) goto L37;
        if (isInNoHostCollection(r102) == false) goto L37;
        return toStringWithoutHost(r100);
    L37:
        return r100.toString();
    L29:
        return r100.toString();
    }

    private boolean isInKeepHostCollection(String r100) {
        return isInHostCollection(r100, this.cacheKeepHostAllowlist, this.cacheKeepHostAllowSet);
    }

    private boolean isInNoHostCollection(String r100) {
        return isInHostCollection(r100, this.cacheNoHostAllowlist, this.cacheNoHostAllowSet);
    }

    @Nullable
    private ResizeOptions resolveResizeOptions(ImageRequest r100) {
        ResizeOptions r101 = r100.getResizeOptions();
        if (r101 == null) goto L6;
        return r101;
    L6:
        if (FrescoCacheMonitorUtil.isAutoDownsampleKeyOpt() == true) goto L8;
    L27:
        return null;
    L8:
        if (r100.isAutoDownsampleDisabled() == true) goto L27;
        SizeDeterminer r102 = r100.getSizeDeterminer();
        if (r102 != null) goto L13;
        return null;
    L13:
        View r103 = r102.getView();
        if (r103 != null) goto L16;
        return null;
    L16:
        int r104 = r103.getWidth();
        int r105 = r103.getHeight();
        if (r104 <= 0) goto L19;
        if (r105 <= 0) goto L19;
    L22:
        if (r104 <= 0) goto L27;
        if (r105 <= 0) goto L27;
        return ResizeOptions.forDimensions(r104, r105);
    L19:
        Pair<Integer, Integer> r106 = r102.getSize();
        if (r106 == null) goto L22;
        r104 = ((Integer) r106.first).intValue();
        r105 = ((Integer) r106.second).intValue();
        goto L22
    }

    private String toStringWithoutHost(Uri r100) {
        StringBuilder r101 = new StringBuilder();
        if (this.ignoreHttpScheme == true) goto L6;
        r101.append(r100.getScheme());
        r101.append(":");
    L6:
        if (r100.getEncodedAuthority() == null) goto L8;
        r101.append("//");
    L8:
        String r102 = r100.getEncodedPath();
        if (r102 == null) goto L12;
        r101.append(r102);
    L12:
        if (this.cacheKeyOnlyPath == true) goto L14;
        String r103 = r100.getEncodedQuery();
        if (r103 == null) goto L18;
        r101.append("?");
        r101.append(r103);
    L18:
        String r104 = r100.getEncodedFragment();
        if (r104 == null) goto L22;
        r101.append("#");
        r101.append(r104);
    L22:
        return r101.toString();
    L14:
        return r101.toString();
    }

    public String getCacheKeySourceUriStr(Uri r100) {
        if (this.useUriWithoutHost == false) goto L7;
        return getUriCacheKey(r100);
    L7:
        return r100.toString();
    }

    public void setCacheKeyOnlyPath(boolean r100) {
        this.cacheKeyOnlyPath = r100;
    }

    public void setCacheKeyUseSet(boolean r100) {
        this.cacheKeyUseSet = r100;
        if (r100 == false) goto L6;
        generateCacheSet();
        return;
    }

    public void setIgnoreHttpScheme(boolean r100) {
        this.ignoreHttpScheme = r100;
    }

    public void setIgnoreRotationOptions(boolean r100) {
        this.ignoreRotationOptions = r100;
    }

    private boolean isHostCollectionEmpty(String[] r100, Set<String> r101) {
        if (this.cacheKeyUseSet == false) goto L9;
        if (r101 != null) goto L6;
    L7:
        return true;
    L6:
        if (r101.size() <= 0) goto L7;
        return false;
    L9:
        if (r100 != null) goto L11;
    L12:
        return true;
    L11:
        if (r100.length <= 0) goto L12;
        return false;
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getBitmapCacheKey(ImageRequest r110, Object r111) {
        String r100 = getCacheKeySourceUriStr(getCacheKeySourceUri(r110));
        boolean r101 = r110.isLoadThumbnailOnly();
        ResizeOptions r102 = resolveResizeOptions(r110);
        if (this.ignoreRotationOptions == false) goto L5;
        RotationOptions r103 = null;
    L7:
        return new BitmapMemoryCacheKey(r100, r101, r102, r103, r110.getImageDecodeOptions(), null, null, r111);
    L5:
        r103 = r110.getRotationOptions();
        goto L7
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getEncodedCacheKey(ImageRequest r100, @Nullable Object r101) {
        return getEncodedCacheKey(r100, getCacheKeySourceUri(r100), r101);
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getPostprocessedBitmapCacheKey(ImageRequest r110, Object r111) {
        Postprocessor r100 = r110.getPostprocessor();
        RotationOptions r101 = null;
        if (r100 == null) goto L5;
        CacheKey r102 = r100.getPostprocessorCacheKey();
        String r112 = r100.getClass().getName();
        CacheKey r103 = r102;
    L6:
        String r104 = getCacheKeySourceUriStr(getCacheKeySourceUri(r110));
        boolean r105 = r110.isLoadThumbnailOnly();
        ResizeOptions r106 = r110.getResizeOptions();
        if (this.ignoreRotationOptions == true) goto L11;
        r101 = r110.getRotationOptions();
    L11:
        return new BitmapMemoryCacheKey(r104, r105, r106, r101, r110.getImageDecodeOptions(), r103, r112, r111);
    L5:
        r103 = null;
        r112 = null;
        goto L6
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getResizedImageCacheKey(ImageRequest r100, @Nullable Object r101) {
        return new ResizedImageCacheKey(getCacheKeySourceUri(r100).toString(), r100.getResizeOptions(), r100.getSourceFile());
    }

    public void setUseUriWithoutHost(boolean r100, String[] r101) {
        this.useUriWithoutHost = r100;
        this.cacheNoHostAllowlist = r101;
        if (this.cacheKeyUseSet == false) goto L6;
        generateCacheSet();
        return;
    }

    public void setUseUriWithoutHostBlackList(boolean r100, String[] r101) {
        this.useUriWithoutHostBlackList = r100;
        this.cacheKeepHostAllowlist = r101;
        if (this.cacheKeyUseSet == false) goto L6;
        generateCacheSet();
        return;
    }

    private boolean isInHostCollection(String r100, String[] r101, Set<String> r102) {
        if (this.cacheKeyUseSet == true) goto L5;
        int r103 = r101.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        String r105 = r101[r104];
        if (r105 == null) goto L14;
        if (r100.endsWith(r105) == false) goto L14;
        return true;
    L14:
        r104 = r104 + 1;
    L15:
        return false;
    L5:
        if (r102.contains(r100) == false) goto L15;
        return true;
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getEncodedCacheKey(ImageRequest r100, Uri r101, @Nullable Object r102) {
        return new SimpleCacheKey(getCacheKeySourceUriStr(getCacheKeySourceUri(r101)));
    }
}
