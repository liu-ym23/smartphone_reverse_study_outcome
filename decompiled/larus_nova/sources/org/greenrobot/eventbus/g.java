package org.greenrobot.eventbus;

import java.util.logging.Level;

/* JADX INFO: loaded from: classes42.dex */
public interface g {

    public static class a implements g {
        public a() {
        }

        @Override // org.greenrobot.eventbus.g
        public final void b(Level r100, String r101) {
            System.out.println("[" + r100 + "] " + r101);
        }

        @Override // org.greenrobot.eventbus.g
        public final void a(Level r100, String r101, Throwable r102) {
            System.out.println("[" + r100 + "] " + r101);
            r102.printStackTrace(System.out);
        }
    }

    void a(Level r100, String r101, Throwable r102);

    void b(Level r100, String r101);
}
