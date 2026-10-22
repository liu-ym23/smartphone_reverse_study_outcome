package com.facebook.soloader;

import android.os.StrictMode;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public abstract class SoSource {
    public static final int LOAD_FLAG_ALLOW_IMPLICIT_PROVISION = 1;
    public static final int LOAD_FLAG_ALLOW_SOURCE_CHANGE = 2;
    public static final int LOAD_FLAG_MIN_CUSTOM_FLAG = 4;
    public static final int LOAD_RESULT_CORRUPTED_LIB_FILE = 3;
    public static final int LOAD_RESULT_IMPLICITLY_PROVIDED = 2;
    public static final int LOAD_RESULT_LOADED = 1;
    public static final int LOAD_RESULT_NOT_FOUND = 0;
    public static final int PREPARE_FLAG_ALLOW_ASYNC_INIT = 1;
    public static final int PREPARE_FLAG_FORCE_REFRESH = 2;

    public SoSource() {
    }

    public void addToLdLibraryPath(Collection<String> r100) {
    }

    @Nullable
    public String[] getLibraryDependencies(String r100) throws IOException {
        return null;
    }

    @Nullable
    public String getLibraryPath(String r100) throws IOException {
        return null;
    }

    @Nullable
    public File getSoFileByName(String r100) throws IOException {
        return null;
    }

    public abstract int loadLibrary(String r100, int r101, StrictMode.ThreadPolicy r102) throws IOException;

    public void prepare(int r100) throws IOException {
    }

    @Nullable
    public abstract File unpackLibrary(String r100) throws IOException;

    public String[] getSoSourceAbis() {
        return SysUtil.getSupportedAbis();
    }

    public String toString() {
        return getClass().getName();
    }
}
