package com.larus.bmhome.chat.model.irepo;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/chat/model/irepo/SqlExceptionCategory;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SQL_LITE_EXCEPTION", "SQL_LITE_ABORT_EXCEPTION", "SQL_LITE_ACCESS_PERM", "SQL_LITE_BIND_OR_COLUMN_INDEX_OUT_OF_RANGE", "SQL_LITE_BLOB_TOO_BIG", "SQL_LITE_CANT_OPEN_DATABASE", "SQL_LITE_CONSTRAINT", "SQL_LITE_DATABASE_CORRUPT", "SQL_LITE_DATABASE_LOCKED", "SQL_LITE_DATA_TYPE_MISMATCH", "SQL_LITE_DISK_IO", "SQL_LITE_DONE", "SQL_LITE_FULL_EXCEPTION", "SQL_LITE_MIS_USE", "SQL_LITE_OUT_OF_MEMORY", "SQL_LITE_READ_ONLY_DATABASE", "SQL_LITE_TABLE_LOCKED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SqlExceptionCategory extends Enum<SqlExceptionCategory> {
    public static final SqlExceptionCategory SQL_LITE_ABORT_EXCEPTION = null;
    public static final SqlExceptionCategory SQL_LITE_ACCESS_PERM = null;
    public static final SqlExceptionCategory SQL_LITE_BIND_OR_COLUMN_INDEX_OUT_OF_RANGE = null;
    public static final SqlExceptionCategory SQL_LITE_BLOB_TOO_BIG = null;
    public static final SqlExceptionCategory SQL_LITE_CANT_OPEN_DATABASE = null;
    public static final SqlExceptionCategory SQL_LITE_CONSTRAINT = null;
    public static final SqlExceptionCategory SQL_LITE_DATABASE_CORRUPT = null;
    public static final SqlExceptionCategory SQL_LITE_DATABASE_LOCKED = null;
    public static final SqlExceptionCategory SQL_LITE_DATA_TYPE_MISMATCH = null;
    public static final SqlExceptionCategory SQL_LITE_DISK_IO = null;
    public static final SqlExceptionCategory SQL_LITE_DONE = null;
    public static final SqlExceptionCategory SQL_LITE_EXCEPTION = null;
    public static final SqlExceptionCategory SQL_LITE_FULL_EXCEPTION = null;
    public static final SqlExceptionCategory SQL_LITE_MIS_USE = null;
    public static final SqlExceptionCategory SQL_LITE_OUT_OF_MEMORY = null;
    public static final SqlExceptionCategory SQL_LITE_READ_ONLY_DATABASE = null;
    public static final SqlExceptionCategory SQL_LITE_TABLE_LOCKED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SqlExceptionCategory[] f307516a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f307517b = null;
    private final String value;

    public static EnumEntries<SqlExceptionCategory> getEntries() {
        return f307517b;
    }

    static {
        SqlExceptionCategory r100 = new SqlExceptionCategory("SQL_LITE_EXCEPTION", 0, "sql_lite_exception");
        SQL_LITE_EXCEPTION = r100;
        SqlExceptionCategory r101 = new SqlExceptionCategory("SQL_LITE_ABORT_EXCEPTION", 1, "sql_lite_abort_exception");
        SQL_LITE_ABORT_EXCEPTION = r101;
        SqlExceptionCategory r102 = new SqlExceptionCategory("SQL_LITE_ACCESS_PERM", 2, "sql_lite_access_perm_exception");
        SQL_LITE_ACCESS_PERM = r102;
        SqlExceptionCategory r103 = new SqlExceptionCategory("SQL_LITE_BIND_OR_COLUMN_INDEX_OUT_OF_RANGE", 3, "sql_lite_bind_or_column_index_out_of_range");
        SQL_LITE_BIND_OR_COLUMN_INDEX_OUT_OF_RANGE = r103;
        SqlExceptionCategory r104 = new SqlExceptionCategory("SQL_LITE_BLOB_TOO_BIG", 4, "sql_lite_blob_too_big");
        SQL_LITE_BLOB_TOO_BIG = r104;
        SqlExceptionCategory r105 = new SqlExceptionCategory("SQL_LITE_CANT_OPEN_DATABASE", 5, "sql_lite_cant_open_database");
        SQL_LITE_CANT_OPEN_DATABASE = r105;
        SqlExceptionCategory r110 = new SqlExceptionCategory("SQL_LITE_CONSTRAINT", 6, "sql_lite_constraint");
        SQL_LITE_CONSTRAINT = r110;
        SqlExceptionCategory r111 = new SqlExceptionCategory("SQL_LITE_DATABASE_CORRUPT", 7, "sql_lite_database_corrupt");
        SQL_LITE_DATABASE_CORRUPT = r111;
        SqlExceptionCategory r112 = new SqlExceptionCategory("SQL_LITE_DATABASE_LOCKED", 8, "sql_lite_database_locked");
        SQL_LITE_DATABASE_LOCKED = r112;
        SqlExceptionCategory r113 = new SqlExceptionCategory("SQL_LITE_DATA_TYPE_MISMATCH", 9, "sql_lite_data_type_mismatch");
        SQL_LITE_DATA_TYPE_MISMATCH = r113;
        SqlExceptionCategory r114 = new SqlExceptionCategory("SQL_LITE_DISK_IO", 10, "sql_lite_disk_io");
        SQL_LITE_DISK_IO = r114;
        SqlExceptionCategory r106 = new SqlExceptionCategory("SQL_LITE_DONE", 11, "sql_lite_done");
        SQL_LITE_DONE = r106;
        SqlExceptionCategory r107 = new SqlExceptionCategory("SQL_LITE_FULL_EXCEPTION", 12, "sql_lite_full");
        SQL_LITE_FULL_EXCEPTION = r107;
        SqlExceptionCategory r108 = new SqlExceptionCategory("SQL_LITE_MIS_USE", 13, "sql_lite_mis_use");
        SQL_LITE_MIS_USE = r108;
        SqlExceptionCategory r109 = new SqlExceptionCategory("SQL_LITE_OUT_OF_MEMORY", 14, "sql_lite_out_of_memory");
        SQL_LITE_OUT_OF_MEMORY = r109;
        SqlExceptionCategory r115 = new SqlExceptionCategory("SQL_LITE_READ_ONLY_DATABASE", 15, "sql_lite_read_only_database");
        SQL_LITE_READ_ONLY_DATABASE = r115;
        SqlExceptionCategory r116 = new SqlExceptionCategory("SQL_LITE_TABLE_LOCKED", 16, "sql_lite_table_locked");
        SQL_LITE_TABLE_LOCKED = r116;
        SqlExceptionCategory[] r117 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116};
        f307516a = r117;
        f307517b = EnumEntriesKt.enumEntries(r117);
    }

    public static SqlExceptionCategory[] values() {
        return (SqlExceptionCategory[]) f307516a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static SqlExceptionCategory valueOf(String r100) {
        return (SqlExceptionCategory) a.a(SqlExceptionCategory.class, r100);
    }

    public SqlExceptionCategory(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
