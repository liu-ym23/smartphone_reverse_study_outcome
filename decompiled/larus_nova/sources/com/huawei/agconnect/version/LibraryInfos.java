package com.huawei.agconnect.version;

/* JADX INFO: loaded from: classes23.dex */
public class LibraryInfos {
    private static final LibraryInfos INSTANCE = null;
    private String libraryType;

    static {
        INSTANCE = new LibraryInfos();
    }

    public LibraryInfos() {
        this.libraryType = "Java";
    }

    public static LibraryInfos getInstance() {
        return INSTANCE;
    }

    public String getLibraryType() {
        return this.libraryType;
    }

    public void registerLibraryType(String r100) {
        this.libraryType = r100;
    }
}
