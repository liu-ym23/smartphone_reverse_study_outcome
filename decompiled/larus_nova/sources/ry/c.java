package ry;

import java.util.HashMap;

/* JADX INFO: loaded from: classes45.dex */
public interface c {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f539881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap<String, String> f539882b;

        public a(int r100) {
            this.f539882b = new HashMap();
            this.f539881a = r100;
        }
    }

    void onEvent(a r100);
}
