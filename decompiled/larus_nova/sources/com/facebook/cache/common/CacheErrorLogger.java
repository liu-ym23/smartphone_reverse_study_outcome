package com.facebook.cache.common;

import com.larus.dora.api.model.FlowDoraWifiScene;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface CacheErrorLogger {

    /* JADX INFO: loaded from: classes22.dex */
    public static final enum CacheErrorCategory extends Enum<CacheErrorCategory> {
        private static final /* synthetic */ CacheErrorCategory[] $VALUES = null;
        public static final CacheErrorCategory DELETE_FILE = null;
        public static final CacheErrorCategory EVICTION = null;
        public static final CacheErrorCategory GENERIC_IO = null;
        public static final CacheErrorCategory OTHER = null;
        public static final CacheErrorCategory READ_DECODE = null;
        public static final CacheErrorCategory READ_FILE = null;
        public static final CacheErrorCategory READ_FILE_NOT_FOUND = null;
        public static final CacheErrorCategory READ_INVALID_ENTRY = null;
        public static final CacheErrorCategory WRITE_CALLBACK_ERROR = null;
        public static final CacheErrorCategory WRITE_CREATE_DIR = null;
        public static final CacheErrorCategory WRITE_CREATE_TEMPFILE = null;
        public static final CacheErrorCategory WRITE_ENCODE = null;
        public static final CacheErrorCategory WRITE_INVALID_ENTRY = null;
        public static final CacheErrorCategory WRITE_RENAME_FILE_OTHER = null;
        public static final CacheErrorCategory WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND = null;
        public static final CacheErrorCategory WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND = null;
        public static final CacheErrorCategory WRITE_UPDATE_FILE_NOT_FOUND = null;

        static {
            CacheErrorCategory r100 = new CacheErrorCategory("READ_DECODE", 0);
            READ_DECODE = r100;
            CacheErrorCategory r101 = new CacheErrorCategory("READ_FILE", 1);
            READ_FILE = r101;
            CacheErrorCategory r102 = new CacheErrorCategory("READ_FILE_NOT_FOUND", 2);
            READ_FILE_NOT_FOUND = r102;
            CacheErrorCategory r103 = new CacheErrorCategory("READ_INVALID_ENTRY", 3);
            READ_INVALID_ENTRY = r103;
            CacheErrorCategory r104 = new CacheErrorCategory("WRITE_ENCODE", 4);
            WRITE_ENCODE = r104;
            CacheErrorCategory r105 = new CacheErrorCategory("WRITE_CREATE_TEMPFILE", 5);
            WRITE_CREATE_TEMPFILE = r105;
            CacheErrorCategory r110 = new CacheErrorCategory("WRITE_UPDATE_FILE_NOT_FOUND", 6);
            WRITE_UPDATE_FILE_NOT_FOUND = r110;
            CacheErrorCategory r111 = new CacheErrorCategory("WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND", 7);
            WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND = r111;
            CacheErrorCategory r112 = new CacheErrorCategory("WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND", 8);
            WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND = r112;
            CacheErrorCategory r113 = new CacheErrorCategory("WRITE_RENAME_FILE_OTHER", 9);
            WRITE_RENAME_FILE_OTHER = r113;
            CacheErrorCategory r114 = new CacheErrorCategory("WRITE_CREATE_DIR", 10);
            WRITE_CREATE_DIR = r114;
            CacheErrorCategory r115 = new CacheErrorCategory("WRITE_CALLBACK_ERROR", 11);
            WRITE_CALLBACK_ERROR = r115;
            CacheErrorCategory r106 = new CacheErrorCategory("WRITE_INVALID_ENTRY", 12);
            WRITE_INVALID_ENTRY = r106;
            CacheErrorCategory r107 = new CacheErrorCategory("DELETE_FILE", 13);
            DELETE_FILE = r107;
            CacheErrorCategory r108 = new CacheErrorCategory("EVICTION", 14);
            EVICTION = r108;
            CacheErrorCategory r109 = new CacheErrorCategory("GENERIC_IO", 15);
            GENERIC_IO = r109;
            CacheErrorCategory r116 = new CacheErrorCategory(FlowDoraWifiScene.OTHER, 16);
            OTHER = r116;
            $VALUES = new CacheErrorCategory[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116};
        }

        public static CacheErrorCategory[] values() {
            return (CacheErrorCategory[]) $VALUES.clone();
        }

        public static CacheErrorCategory valueOf(String r100) {
            return (CacheErrorCategory) Enum.valueOf(CacheErrorCategory.class, r100);
        }

        private CacheErrorCategory(String r100, int r101) {
            super(r100, r101);
        }
    }

    void logError(CacheErrorCategory r100, Class<?> r101, String r102, @Nullable Throwable r103);
}
