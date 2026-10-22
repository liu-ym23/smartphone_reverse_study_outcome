package com.bytedance.ee.docsdk.impl.document.plugins.offline.storage;

/* JADX INFO: loaded from: classes18.dex */
public class ResourceDataDelegate {
    private Long accessTime;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f242636id;
    private String obj_token;
    private String reskey;
    private String resvalueFilePath;
    private String token;
    private String type;
    private String url;

    public ResourceDataDelegate() {
    }

    public Long getAccessTime() {
        return this.accessTime;
    }

    public int getId() {
        return this.f242636id;
    }

    public String getObj_token() {
        return this.obj_token;
    }

    public String getReskey() {
        return this.reskey;
    }

    public String getResvalueFilePath() {
        return this.resvalueFilePath;
    }

    public String getToken() {
        return this.token;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setAccessTime(Long r100) {
        this.accessTime = r100;
    }

    public void setId(int r100) {
        this.f242636id = r100;
    }

    public void setObj_token(String r100) {
        this.obj_token = r100;
    }

    public void setReskey(String r100) {
        this.reskey = r100;
    }

    public void setResvalueFilePath(String r100) {
        this.resvalueFilePath = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setType(String r100) {
        this.type = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }
}
