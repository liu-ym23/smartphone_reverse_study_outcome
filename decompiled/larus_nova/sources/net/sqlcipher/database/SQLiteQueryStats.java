package net.sqlcipher.database;

/* JADX INFO: loaded from: classes42.dex */
public class SQLiteQueryStats {
    long largestIndividualRowSize;
    long totalQueryResultSize;

    public long getLargestIndividualRowSize() {
        return this.largestIndividualRowSize;
    }

    public long getTotalQueryResultSize() {
        return this.totalQueryResultSize;
    }

    public SQLiteQueryStats(long r100, long r101) {
        this.totalQueryResultSize = r100;
        this.largestIndividualRowSize = r101;
    }
}
