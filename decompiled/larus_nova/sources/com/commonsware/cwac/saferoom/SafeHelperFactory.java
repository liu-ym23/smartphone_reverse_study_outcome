package com.commonsware.cwac.saferoom;

import android.content.Context;
import android.text.Editable;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes22.dex */
public class SafeHelperFactory implements SupportSQLiteOpenHelper.Factory {
    public static final String POST_KEY_SQL_MIGRATE = "PRAGMA cipher_migrate;";
    public static final String POST_KEY_SQL_V3 = "PRAGMA cipher_compatibility = 3;";
    private final Options options;
    private final byte[] passphrase;

    /* JADX INFO: renamed from: com.commonsware.cwac.saferoom.SafeHelperFactory$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Options {
        public final boolean clearPassphrase;
        public final String postKeySql;
        public final String preKeySql;

        public static class Builder {
            private boolean clearPassphrase;
            private String postKeySql;
            private String preKeySql;

            public Options build() {
                return new Options(this.preKeySql, this.postKeySql, this.clearPassphrase, null);
            }

            private Builder() {
                this.clearPassphrase = true;
            }

            public /* synthetic */ Builder(AnonymousClass1 r100) {
                this();
            }

            public Builder setClearPassphrase(boolean r100) {
                this.clearPassphrase = r100;
                return this;
            }

            public Builder setPostKeySql(String r100) {
                this.postKeySql = r100;
                return this;
            }

            public Builder setPreKeySql(String r100) {
                this.preKeySql = r100;
                return this;
            }
        }

        public static Builder builder() {
            return new Builder(null);
        }

        private Options(String r100, String r101, boolean r102) {
            this.preKeySql = r100;
            this.postKeySql = r101;
            this.clearPassphrase = r102;
        }

        public /* synthetic */ Options(String r100, String r101, boolean r102, AnonymousClass1 r103) {
            this(r100, r101, r102);
        }
    }

    public SafeHelperFactory(byte[] r100) {
        this(r100, new Options.Builder(null).build());
    }

    private void clearPassphrase(char[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.length) goto L6;
        r100[r101] = 0;
        r101 = r101 + 1;
        goto L4
    }

    public static SafeHelperFactory fromUser(Editable r100) {
        return fromUser(r100, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration r100) {
        return create(r100.context, r100.name, r100.callback);
    }

    public SafeHelperFactory(char[] r100) {
        this(r100, null);
    }

    public SafeHelperFactory(byte[] r100, String r101) {
        this(r100, new Options.Builder(null).setPostKeySql(r101).build());
    }

    public static SafeHelperFactory fromUser(Editable r100, Options r101) {
        char[] r102 = new char[r100.length()];
        r100.getChars(0, r100.length(), r102, 0);
        SafeHelperFactory r103 = new SafeHelperFactory(r102, r101);     // Catch: Throwable -> L6
        r100.clear();
        return r103;
    L6:
        th = move-exception;
        r100.clear();
        throw th;
    }

    public static void rekey(SupportSQLiteDatabase r100, Editable r101) {
        if ((r100 instanceof Database) == false) goto L7;
        ((Database) r100).rekey(r101);
        return;
    L7:
        throw new IllegalArgumentException("Database is not from CWAC-SafeRoom");
    }

    public SafeHelperFactory(char[] r100, String r101) {
        this(SQLiteDatabase.getBytes(r100), r101);
        if (this.options.clearPassphrase == false) goto L6;
        clearPassphrase(r100);
        return;
    }

    public static SafeHelperFactory fromUser(Editable r100, String r101) {
        return fromUser(r100, Options.builder().setPostKeySql(r101).build());
    }

    public static void rekey(SupportSQLiteDatabase r100, char[] r101) {
        if ((r100 instanceof Database) == false) goto L7;
        ((Database) r100).rekey(r101);
        return;
    L7:
        throw new IllegalArgumentException("Database is not from CWAC-SafeRoom");
    }

    public SafeHelperFactory(char[] r100, Options r101) {
        this(SQLiteDatabase.getBytes(r100), r101);
        if (r101.clearPassphrase == false) goto L6;
        clearPassphrase(r100);
        return;
    }

    public SafeHelperFactory(byte[] r100, Options r101) {
        this.passphrase = r100;
        this.options = r101;
    }

    public SupportSQLiteOpenHelper create(Context r100, String r101, SupportSQLiteOpenHelper.Callback r110) {
        return new Helper(r100, r101, r110, this.passphrase, this.options);
    }
}
