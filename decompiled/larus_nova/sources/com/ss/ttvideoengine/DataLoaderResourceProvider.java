package com.ss.ttvideoengine;

/* JADX INFO: loaded from: classes34.dex */
public interface DataLoaderResourceProvider {

    /* JADX INFO: renamed from: com.ss.ttvideoengine.DataLoaderResourceProvider$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static String $default$getCacheDir(DataLoaderResourceProvider r100) {
            return null;
        }
    }

    String getCacheDir();

    String getKey();

    long getPreloadSize();

    String[] getUrls();
}
