package com.bytedance.ugc.glue;

import ep7.a;

/* JADX INFO: loaded from: classes22.dex */
public class UGCLog {
    private static UGCLog instance;

    public void dImpl(String r100, String r101) {
    }

    public void eImpl(String r100, String r101) {
    }

    public void eImpl(String r100, String r101, Throwable r102) {
    }

    public void iImpl(String r100, String r101) {
    }

    static {
        instance = new UGCLog();
    }

    private static UGCLog getInstance() {
        int r100 = a.f473437a;
        return instance;
    }

    public UGCLog() {
    }

    public final void register() {
        instance = this;
    }

    public static void d(String r100, String r101) {
        getInstance().dImpl(r100, r101);
    }

    public static void e(String r100, String r101) {
        getInstance().eImpl(r100, r101);
    }

    public static void i(String r100, String r101) {
        getInstance().iImpl(r100, r101);
    }

    public static void e(String r100, String r101, Throwable r102) {
        getInstance().eImpl(r100, r101, r102);
    }
}
