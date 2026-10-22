package com.ss.ttvideoengine.database;

/* JADX INFO: loaded from: classes34.dex */
public interface IKVStorage {

    /* JADX INFO: renamed from: com.ss.ttvideoengine.database.IKVStorage$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$clear(IKVStorage r100) {
            throw new UnsupportedOperationException("Not implemented on this kv store");
        }

        public static String $default$getString(IKVStorage r100, String r101) {
            throw new UnsupportedOperationException("Not implemented on this kv store");
        }

        public static boolean $default$removeString(IKVStorage r100, String r101) {
            throw new UnsupportedOperationException("Not implemented on this kv store");
        }

        public static boolean $default$putString(IKVStorage r100, String r101, String r102) {
            throw new UnsupportedOperationException("Not implemented on this kv store");
        }
    }

    boolean clear();

    String getString(String r100);

    boolean putString(String r100, String r101);

    boolean removeString(String r100);
}
