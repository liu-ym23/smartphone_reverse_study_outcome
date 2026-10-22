package com.ss.android.socialbase.downloader.core.module.pcdn;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class PCDNChunkUrlPolicy {
    public static final int TYPE_CDN = 2;
    public static final int TYPE_PCDN = 1;
    private int mCdnIndex;
    private List<String> mCdnUrls;
    private int mPcdnIndex;
    private List<String> mPcdnUrls;
    private int mType;

    public PCDNChunkUrlPolicy copy() {
        PCDNChunkUrlPolicy r100 = new PCDNChunkUrlPolicy(this.mPcdnUrls, this.mCdnUrls);
        r100.mType = this.mType;
        r100.mPcdnIndex = this.mPcdnIndex;
        r100.mCdnIndex = this.mCdnIndex;
        return r100;
    }

    public boolean isPCDN() {
        if (this.mType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String obtainUrl() {
        int r100 = this.mType;
        if (r100 == 1) goto L14;
        if (r100 == 2) goto L9;
        return null;
    L9:
        if (this.mCdnIndex >= 0) goto L11;
        this.mCdnIndex = 0;
    L11:
        List<String> r101 = this.mCdnUrls;
        return (String) ListProtector.get(r101, this.mCdnIndex % r101.size());
    L14:
        if (this.mPcdnIndex >= 0) goto L16;
        this.mPcdnIndex = 0;
    L16:
        List<String> r102 = this.mPcdnUrls;
        return (String) ListProtector.get(r102, this.mPcdnIndex % r102.size());
    }

    public boolean switchToCdn() {
        if (this.mCdnUrls.isEmpty() == false) goto L5;
        return false;
    L5:
        if (this.mType == 2) goto L11;
        this.mType = 2;
        return true;
    L11:
        return false;
    }

    public void onError() {
        if (isPCDN() == false) goto L13;
        if (this.mPcdnUrls.isEmpty() == true) goto L13;
        if (this.mPcdnIndex >= (this.mPcdnUrls.size() - 1)) goto L9;
    L10:
        this.mPcdnIndex++;
        return;
    L9:
        if (this.mCdnUrls.isEmpty() == true) goto L10;
    L13:
        if (this.mCdnUrls.isEmpty() == true) goto L16;
        this.mCdnIndex++;
        this.mType = 2;
        return;
    }

    public PCDNChunkUrlPolicy(List<String> r100, List<String> r101) {
        this.mCdnUrls = new ArrayList();
        this.mPcdnUrls = new ArrayList();
        this.mCdnIndex = -1;
        this.mPcdnIndex = -1;
        if (r100 != null) goto L5;
    L7:
        if (r101 == null) goto L12;
        if (r101.isEmpty() == true) goto L12;
        this.mCdnUrls.addAll(r101);
    L12:
        if (this.mPcdnUrls.isEmpty() == true) goto L14;
        this.mType = 1;
        return;
    L14:
        this.mType = 2;
        return;
    L5:
        if (r100.isEmpty() == true) goto L7;
        this.mPcdnUrls.addAll(r100);
        goto L7
    }
}
