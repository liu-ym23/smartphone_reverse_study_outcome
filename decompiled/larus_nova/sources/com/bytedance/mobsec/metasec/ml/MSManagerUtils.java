package com.bytedance.mobsec.metasec.ml;

import android.content.Context;
import ms.bd.c.k2;
import ms.bd.c.n;
import ms.bd.c.n2;
import ms.bd.c.p2;

/* JADX INFO: loaded from: classes3.dex */
public final class MSManagerUtils {

    /* JADX INFO: loaded from: classes21.dex */
    public interface IMsBundleCallback {
        void callBack(int r100, String r101, String r102);
    }

    /* JADX INFO: loaded from: classes21.dex */
    public static class MSBusinessHelper {
        private byte[] data;
        private int event;
        private int type;

        public static class MSBpEvent {
            public static final int _1f137e7ca8e2b6875b5ff7e05434a31c = 1;
            public static final int _e4589bc87b7549ba5e7875168dd20ddd = 0;

            public MSBpEvent() {
            }
        }

        public static class MSBpType {
            public static final int _196e216d4eb8fae8f995f75bc16112c2 = 0;
            public static final int _bd7fe0e9fad446f93311fad566672b69 = 1;

            public MSBpType() {
            }
        }

        public MSBusinessHelper(int r100, int r101, byte[] r102) {
            this.type = r100;
            this.event = r101;
            this.data = r102;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public interface ScenePageNameCallback {
        int getScenePageName();
    }

    public static synchronized MSManager get(String r100) {
        monitor-enter(MSManagerUtils.class);
        k2 r101 = n2.a(r100);     // Catch: Throwable -> L11
        if (r101 == null) goto L8;
        MSManager r102 = new MSManager(r101);     // Catch: Throwable -> L11
    L9:
        monitor-exit(MSManagerUtils.class);
        return r102;
    L8:
        r102 = null;
    L11:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean init(Context r100, MSConfig r101) {
        monitor-enter(MSManagerUtils.class);
        boolean r102 = n2.c(r100, r101.a());     // Catch: Throwable -> L7
        monitor-exit(MSManagerUtils.class);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public static String versionInfo() {
        boolean r100 = n2.f515244d;
        return (String) p2.a(67108867, 0, 0, null, null);
    }

    public static int registerScenePageNameCallback(int r100, ScenePageNameCallback r101) {
        if (r101 == null) goto L4;
        n.f515226d.put(Integer.valueOf(r100), r101);
        return 0;
    L4:
        int r102 = n.f515223a;
        return -1;
    }
}
