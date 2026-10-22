package com.tencent.wcdb.core;

import com.tencent.wcdb.base.WCDBException;

/* JADX INFO: loaded from: classes35.dex */
public interface PausableTransaction {
    boolean insideTransaction(Handle r100, boolean r101) throws WCDBException;
}
