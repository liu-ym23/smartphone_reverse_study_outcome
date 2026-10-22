package com.ss.ttvideoengine.database;

/* JADX INFO: loaded from: classes34.dex */
public interface IKVStorageProvider {

    /* JADX INFO: renamed from: com.ss.ttvideoengine.database.IKVStorageProvider$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static IKVStorage $default$getKVStorage(IKVStorageProvider r100, String r101) {
            throw new UnsupportedOperationException("Not implemented on this provider");
        }
    }

    IKVStorage getKVStorage(String r100);
}
