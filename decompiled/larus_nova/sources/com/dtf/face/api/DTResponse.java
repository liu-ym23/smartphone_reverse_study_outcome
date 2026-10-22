package com.dtf.face.api;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class DTResponse {
    public byte[] bitmap;
    public int code;
    public String deviceToken;
    public Map<String, Object> extInfo;
    public List<byte[]> faceImageContent;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public String f273631id;
    public byte[] lastBitmap;
    public String msg;
    public byte[] ocrBackBitmap;
    public byte[] ocrFrontBitmap;
    public String reason;
    public String retMessageSub;
    public String videoFilePath;

    public DTResponse() {
    }
}
