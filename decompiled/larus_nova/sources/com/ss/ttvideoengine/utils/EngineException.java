package com.ss.ttvideoengine.utils;

/* JADX INFO: loaded from: classes35.dex */
public class EngineException extends Exception {
    private final Error mError;

    public Error getError() {
        return this.mError;
    }

    public EngineException(Error r100) {
        super(r100.toString());
        this.mError = r100;
    }

    public EngineException(Error r100, Throwable r101) {
        super(r100.toString(), r101);
        this.mError = r100;
    }
}
