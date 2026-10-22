package com.tencent.wcdb.core;

import com.tencent.wcdb.base.WCDBException;

/* JADX INFO: loaded from: classes35.dex */
public interface Transaction {
    boolean insideTransaction(Handle r100) throws WCDBException;
}
