package com.bytedance.ee.larkwebview.pool;

/* JADX INFO: loaded from: classes19.dex */
public class DuplicateRegisterException extends Exception {
    public DuplicateRegisterException(String r100) {
        super("found duplicate biz tag register , biz tag " + r100 + " already exist.");
    }
}
