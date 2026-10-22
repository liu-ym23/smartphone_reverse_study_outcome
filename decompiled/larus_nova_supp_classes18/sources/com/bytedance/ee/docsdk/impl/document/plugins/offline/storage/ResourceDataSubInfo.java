package com.bytedance.ee.docsdk.impl.document.plugins.offline.storage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ResourceDataSubInfo {
    private int id;
    private int page;
    private int subblock_preload_status;
    private int totalPage;

    public ResourceDataSubInfo() {
    }

    public int getId() {
        return this.id;
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

    public void setId(int r1) {
        this.id = r1;
    }

    public void setPage(int r1) {
        this.page = r1;
    }

    public void setSubblock_preload_status(int r1) {
        this.subblock_preload_status = r1;
    }

    public void setTotalPage(int r1) {
        this.totalPage = r1;
    }
}
