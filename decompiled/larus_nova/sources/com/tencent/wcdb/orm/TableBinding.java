package com.tencent.wcdb.orm;

import com.tencent.wcdb.core.PreparedStatement;

/* JADX INFO: loaded from: classes35.dex */
public interface TableBinding<T> {
    Field<T>[] allBindingFields();

    Binding baseBinding();

    void bindField(T r100, Field<T> r101, int r102, PreparedStatement r103);

    Class<T> bindingType();

    <R extends T> R extractObject(Field<T>[] r100, PreparedStatement r101, Class<R> r102) throws ReflectiveOperationException;

    boolean isAutoIncrement(T r100);

    void setLastInsertRowId(T r100, long r101);
}
