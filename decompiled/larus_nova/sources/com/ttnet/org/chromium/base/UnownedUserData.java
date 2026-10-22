package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes41.dex */
public interface UnownedUserData {

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.UnownedUserData$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$informOnDetachmentFromHost(UnownedUserData r100) {
            return true;
        }

        public static void $default$onDetachedFromHost(UnownedUserData r100, UnownedUserDataHost r101) {
        }
    }

    boolean informOnDetachmentFromHost();

    void onDetachedFromHost(UnownedUserDataHost r100);
}
