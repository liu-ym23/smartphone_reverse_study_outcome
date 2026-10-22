package com.bytedance.bdlocation.log;

/* JADX INFO: loaded from: classes3.dex */
public class LogPrinter implements Printer {
    private volatile boolean mEnable;

    public LogPrinter() {
    }

    @Override // com.bytedance.bdlocation.log.Printer
    public void d(String r100, String r101, Throwable r102) {
    }

    @Override // com.bytedance.bdlocation.log.Printer
    public void e(String r100, String r101, Throwable r102) {
    }

    @Override // com.bytedance.bdlocation.log.Printer
    public void i(String r100, String r101, Throwable r102) {
    }

    @Override // com.bytedance.bdlocation.log.Printer
    public void v(String r100, String r101, Throwable r102) {
    }

    @Override // com.bytedance.bdlocation.log.Printer
    public void w(String r100, String r101, Throwable r102) {
    }

    public void setEnable(boolean r100) {
        this.mEnable = r100;
    }
}
