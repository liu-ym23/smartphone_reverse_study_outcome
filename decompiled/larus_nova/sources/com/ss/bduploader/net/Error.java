package com.ss.bduploader.net;

/* JADX INFO: loaded from: classes40.dex */
public class Error {
    int code;
    public String errStr;
    public String host;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public String f456076id;

    public Error(int r100, String r101, String r102) {
        this.code = r100;
        this.host = r101;
        this.f456076id = r102;
        this.errStr = null;
    }

    public Error(int r100, String r101, String r102, String r103) {
        this.code = r100;
        this.host = r101;
        this.f456076id = r102;
        this.errStr = r103;
    }
}
