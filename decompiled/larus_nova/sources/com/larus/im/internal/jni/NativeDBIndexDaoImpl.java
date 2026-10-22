package com.larus.im.internal.jni;

import com.larus.im.internal.database.dao.DBIndexDAO;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096 J\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\f\u001a\u00020\tH\u0096 J!\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0096 J'\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H\u0096 J\u0011\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/im/internal/jni/NativeDBIndexDaoImpl;", "Lcom/larus/im/internal/database/dao/DBIndexDAO;", "nativePtr", "", "<init>", "(J)V", "isIndexExists", "", "indexName", "", "getIndexesForTable", "", "tableName", "createSingleIndex", "column", "createCompositeIndex", "columns", "", "dropIndex", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativeDBIndexDaoImpl implements DBIndexDAO {
    private final long nativePtr;

    @Override // com.larus.im.internal.database.dao.DBIndexDAO
    public native boolean createCompositeIndex(String r100, String r101, List<String> r102);

    @Override // com.larus.im.internal.database.dao.DBIndexDAO
    public native boolean createSingleIndex(String r100, String r101, String r102);

    @Override // com.larus.im.internal.database.dao.DBIndexDAO
    public native boolean dropIndex(String r100);

    @Override // com.larus.im.internal.database.dao.DBIndexDAO
    public native List<String> getIndexesForTable(String r100);

    @Override // com.larus.im.internal.database.dao.DBIndexDAO
    public native boolean isIndexExists(String r100);

    public NativeDBIndexDaoImpl(long r100) {
        this.nativePtr = r100;
    }
}
