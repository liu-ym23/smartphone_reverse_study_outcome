package com.ss.ttvideoengine.preload;

import android.text.TextUtils;
import com.ss.ttvideoengine.DataLoaderResourceProvider;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes34.dex */
public class PreloadURLMedia extends PreloadMedia {
    private HashMap<String, String> mHeaders;
    private DataLoaderResourceProvider mProvider;
    private String[] mUrls;

    @Override // com.ss.ttvideoengine.preload.PreloadMedia
    public int hashCode() {
        int r100 = super.hashCode();
        if (this.mProvider == null) goto L5;
        r100 = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.mProvider});
    L5:
        String[] r101 = this.mUrls;
        if (r101 != null) goto L8;
        return r100;
    L8:
        return (r100 * 31) + Arrays.hashCode(r101);
    }

    public HashMap<String, String> customHeaders() {
        return this.mHeaders;
    }

    public DataLoaderResourceProvider getProvider() {
        return this.mProvider;
    }

    public String[] getUrls() {
        return this.mUrls;
    }

    @Override // com.ss.ttvideoengine.preload.PreloadMedia
    public boolean equals(Object r100) {
        boolean r101 = false;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (super.equals(r100) == false) goto L9;
        return true;
    L9:
        if ((r100 instanceof PreloadURLMedia) == true) goto L11;
        return false;
    L11:
        PreloadURLMedia r102 = (PreloadURLMedia) r100;
        if (this.mPreloadSize != r102.mPreloadSize) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == true) goto L17;
    L19:
        boolean r104 = false;
    L21:
        if (getCallBackListener() != null) goto L25;
        if (r102.getCallBackListener() != null) goto L25;
    L35:
        DataLoaderResourceProvider r105 = this.mProvider;
        if (r105 == null) goto L38;
    L39:
        if (r105 != null) goto L41;
    L42:
        r104 = false;
    L43:
        if (r104 == false) goto L51;
        if (r104 == false) goto L49;
        if (r105 != r102.mProvider) goto L49;
        r101 = true;
    L49:
        return r101;
    L51:
        return r104;
    L41:
        if (r102.mProvider != null) goto L43;
    L38:
        if (r102.mProvider != null) goto L39;
        return r104;
    L25:
        if (getCallBackListener() != null) goto L27;
    L28:
        r104 = false;
    L29:
        if (r104 == false) goto L35;
        if (r104 == true) goto L32;
    L34:
        r104 = false;
        goto L35
    L32:
        if (getCallBackListener() != r102.getCallBackListener()) goto L34;
        r104 = true;
        goto L35
    L27:
        if (r102.getCallBackListener() != null) goto L29;
    L17:
        if (this.mCacheKey.equals(r102.mCacheKey) == false) goto L19;
        r104 = true;
        goto L21
    L14:
        r103 = false;
        goto L15
    }

    public void setProvider(DataLoaderResourceProvider r100) {
        this.mProvider = r100;
    }

    public void setUrls(String[] r100) {
        this.mUrls = r100;
    }

    public void setCustomHeader(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (this.mHeaders != null) goto L8;
        this.mHeaders = new HashMap();
    L8:
        this.mHeaders.put(r100.substring(0, 1).toUpperCase() + r100.substring(1), r101);
    }

    public PreloadURLMedia(String r100, String r101, long r102, DataLoaderResourceProvider r103) {
        this.mUrls = null;
        this.mHeaders = null;
        this.mProvider = r103;
        this.mVideoId = r101;
        this.mPreloadSize = r102;
        this.mCacheKey = r100;
    }

    public PreloadURLMedia(String r100, String r101, long r102, String[] r103) {
        this.mProvider = null;
        this.mHeaders = null;
        this.mCacheKey = r100;
        this.mVideoId = r101;
        this.mPreloadSize = r102;
        this.mUrls = r103;
    }
}
