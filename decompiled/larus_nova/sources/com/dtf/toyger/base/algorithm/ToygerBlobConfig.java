package com.dtf.toyger.base.algorithm;

/* JADX INFO: loaded from: classes22.dex */
public abstract class ToygerBlobConfig {
    public String pubkey;

    public abstract float getCompressRate();

    public Integer getDesiredWidth() {
        return -1;
    }

    public ToygerBlobConfig() {
    }
}
