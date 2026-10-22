package com.ss.android.lark.officewebview.pool;

/* JADX INFO: loaded from: classes37.dex */
public class DuplicateRegisterException extends Exception {
    public DuplicateRegisterException(String r100) {
        super("found duplicate biz tag register , biz tag " + r100 + " already exist.");
    }
}
