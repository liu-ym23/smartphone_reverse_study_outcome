package com.bytedance.badger.collect.impl.pseudo.model;

import com.bytedance.badger.collect.impl.constants.Constants;

/* JADX INFO: loaded from: classes47.dex */
public class PseudoCodeResult {
    public String data;
    public boolean enableSimCardListen;
    public Integer errorCode;
    public String errorMsg;

    public String toString() {
        return "PseudoCodeResult{errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + "', data='" + this.data + "', enableSimCardListen=" + this.enableSimCardListen + '}';
    }

    public static PseudoCodeResult failed(String r100) {
        return new PseudoCodeResult(Constants.StatusCode.FAILED, r100, "");
    }

    public static PseudoCodeResult success(String r100) {
        return new PseudoCodeResult(Constants.StatusCode.SUCCESS, "", r100);
    }

    public static PseudoCodeResult failed(String r100, boolean r101) {
        return new PseudoCodeResult(Constants.StatusCode.FAILED, r100, "", r101);
    }

    private PseudoCodeResult(Integer r100, String r101, String r102) {
        this.enableSimCardListen = false;
        this.errorCode = r100;
        this.errorMsg = r101;
        this.data = r102;
    }

    public PseudoCodeResult(Integer r100, String r101, String r102, boolean r103) {
        this.errorCode = r100;
        this.errorMsg = r101;
        this.data = r102;
        this.enableSimCardListen = r103;
    }
}
