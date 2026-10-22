package com.bytedance.ee.docsdk.impl.document.plugins.offline.storage;

/* JADX INFO: loaded from: classes18.dex */
public class ResourceDataSubInfo {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f242637id;
    private int page;
    private int subblock_preload_status;
    private int totalPage;

    public ResourceDataSubInfo() {
    }

    public int getId() {
        return this.f242637id;
    }

    public int getPage() {
        return this.page;
    }

    public int getSubblock_preload_status() {
        return this.subblock_preload_status;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public void setId(int r100) {
        this.f242637id = r100;
    }

    public void setPage(int r100) {
        this.page = r100;
    }

    public void setSubblock_preload_status(int r100) {
        this.subblock_preload_status = r100;
    }

    public void setTotalPage(int r100) {
        this.totalPage = r100;
    }
}
