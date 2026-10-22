package com.huawei.secure.android.common.encrypt.aes;

import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes23.dex */
public class CipherConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Cipher f277953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f277954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f277955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f277956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f277957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f277958f;

    public Cipher getCipher() {
        return this.f277953a;
    }

    public byte[] getInput() {
        return this.f277954b;
    }

    public int getInputLen() {
        return this.f277956d;
    }

    public int getInputOffset() {
        return this.f277955c;
    }

    public byte[] getOutput() {
        return this.f277957e;
    }

    public int getOutputOffset() {
        return this.f277958f;
    }

    public void setCipher(Cipher r100) {
        this.f277953a = r100;
    }

    public void setInput(byte[] r100) {
        this.f277954b = r100;
    }

    public void setInputLen(int r100) {
        this.f277956d = r100;
    }

    public void setInputOffset(int r100) {
        this.f277955c = r100;
    }

    public void setOutput(byte[] r100) {
        this.f277957e = r100;
    }

    public void setOutputOffset(int r100) {
        this.f277958f = r100;
    }

    public CipherConfig(Cipher r100, byte[] r101, int r102, int r103, byte[] r104, int r105) {
        this.f277953a = r100;
        this.f277954b = r101;
        this.f277955c = r102;
        this.f277956d = r103;
        this.f277957e = r104;
        this.f277958f = r105;
    }
}
