package com.larus.im.internal.database.dao;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\b\u001a\u00020\u0005H&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&J&\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lcom/larus/im/internal/database/dao/DBIndexDAO;", "", "isIndexExists", "", "indexName", "", "getIndexesForTable", "", "tableName", "createSingleIndex", "column", "createCompositeIndex", "columns", "", "dropIndex", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface DBIndexDAO {
    boolean createCompositeIndex(String r100, String r101, List<String> r102);

    boolean createSingleIndex(String r100, String r101, String r102);

    boolean dropIndex(String r100);

    List<String> getIndexesForTable(String r100);

    boolean isIndexExists(String r100);
}
