package com.tencent.wcdb.core;

import com.tencent.wcdb.orm.TableBinding;

/* JADX INFO: loaded from: classes35.dex */
public class Table<T> extends TableORMOperation<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    static {
    }

    public Table(String r100, TableBinding<T> r101, Database r102) {
        this.tableName = r100;
        this.binding = r101;
        this.database = r102;
    }
}
