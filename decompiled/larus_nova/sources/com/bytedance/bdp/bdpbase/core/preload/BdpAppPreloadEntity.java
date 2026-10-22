package com.bytedance.bdp.bdpbase.core.preload;

import com.bytedance.bdp.bdpbase.schema.SchemaInfo;

/* JADX INFO: loaded from: classes11.dex */
public class BdpAppPreloadEntity {
    public static final int DOWNLOAD_PRIORITY_HIGH = 1;
    public static final int DOWNLOAD_PRIORITY_HIGHEST = 2;
    public static final int DOWNLOAD_PRIORITY_NORMAL = 0;
    private int mDownloadPriority;
    private int mOriginDownloadPriority;
    private final SchemaInfo mSchemaInfo;

    public static boolean compareDownloadPriority(int r100, int r101) {
        if (r100 <= r101) goto L4;
        return true;
    L4:
        return false;
    }

    public void downgradePriority() {
        this.mDownloadPriority = 0;
    }

    public boolean downgraded() {
        int r100 = this.mDownloadPriority;
        if (r100 == 0) goto L5;
    L7:
        return false;
    L5:
        if (r100 == this.mOriginDownloadPriority) goto L7;
        return true;
    }

    public String getAppId() {
        return this.mSchemaInfo.a();
    }

    public int getAppType() {
        return this.mSchemaInfo.o();
    }

    public String toString() {
        return "mSchema: " + this.mSchemaInfo + " mDownloadPriority: " + this.mDownloadPriority + " mOriginDownloadPriority: " + this.mOriginDownloadPriority;
    }

    public int getDownloadPriority() {
        return this.mDownloadPriority;
    }

    public int getOriginDownloadPriority() {
        return this.mOriginDownloadPriority;
    }

    public SchemaInfo getSchemaInfo() {
        return this.mSchemaInfo;
    }

    public BdpAppPreloadEntity(BdpAppPreloadEntity r100) {
        int r101 = r100.mOriginDownloadPriority;
        this.mOriginDownloadPriority = r101;
        this.mDownloadPriority = r101;
        this.mSchemaInfo = r100.mSchemaInfo;
    }

    public BdpAppPreloadEntity(String r100, int r101) {
        this.mSchemaInfo = SchemaInfo.r(r100);
        this.mOriginDownloadPriority = r101;
        this.mDownloadPriority = r101;
    }

    public BdpAppPreloadEntity(SchemaInfo r100, int r101) {
        this.mSchemaInfo = r100;
        this.mOriginDownloadPriority = r101;
        this.mDownloadPriority = r101;
    }
}
