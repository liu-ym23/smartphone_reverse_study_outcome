package com.bytedance.ee.larkwebview.pool;

/* JADX INFO: loaded from: classes19.dex */
public class BizTagNotFoundException extends Exception {
    public BizTagNotFoundException(String r100) {
        super("not found target biz tag " + r100 + ".");
    }
}
