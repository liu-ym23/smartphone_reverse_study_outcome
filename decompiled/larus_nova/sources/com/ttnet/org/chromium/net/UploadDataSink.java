package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: classes5.dex */
public abstract class UploadDataSink {
    public UploadDataSink() {
    }

    public abstract void onReadError(Exception r100);

    public abstract void onReadSucceeded(boolean r100);

    public abstract void onRewindError(Exception r100);

    public abstract void onRewindSucceeded();
}
