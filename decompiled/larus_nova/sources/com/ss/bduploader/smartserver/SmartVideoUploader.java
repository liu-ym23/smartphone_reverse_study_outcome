package com.ss.bduploader.smartserver;

/* JADX INFO: loaded from: classes40.dex */
public class SmartVideoUploader {
    private static final String ROUTING_ENGINE_TYPE = "mlsdk";
    private static final String ROUTING_OUTPUT_TYPE = "regression";
    private static final String ROUTING_SERVER_NAME = "smart_upload_tcp_quic";
    private SmartServiceInterface mIntelligentService;
    private String mIntelligentURL;

    public void configServer() {
        this.mIntelligentService.setStringValue(1000, ROUTING_ENGINE_TYPE);
        this.mIntelligentService.setStringValue(1001, ROUTING_OUTPUT_TYPE);
        this.mIntelligentService.setStringValue(1002, ROUTING_SERVER_NAME);
        this.mIntelligentService.setStringValue(1003, this.mIntelligentURL);
        this.mIntelligentService.configServer();
    }

    public void init() {
        this.mIntelligentService = new SmartServiceWrapper();
    }

    public void preloadEnv() {
        SmartServiceInterface r100 = this.mIntelligentService;
        if (r100 == null) goto L6;
        r100.preloadEnv();
        return;
    }

    public SmartVideoUploader() {
        this.mIntelligentURL = "";
    }
}
