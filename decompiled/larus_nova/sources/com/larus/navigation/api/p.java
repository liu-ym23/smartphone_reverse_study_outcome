package com.larus.navigation.api;

/* JADX INFO: loaded from: classes30.dex */
public interface p {

    public static final class a {
        public static /* synthetic */ void a(p r100, String r110, String r111, Integer r112, String r113, String r114, String r115, int r116) {
            if ((r116 & 4) == 0) goto L5;
            Integer r101 = null;
        L7:
            if ((r116 & 8) == 0) goto L9;
            String r102 = null;
        L11:
            if ((r116 & 16) == 0) goto L13;
            String r103 = null;
        L15:
            if ((r116 & 32) == 0) goto L17;
            String r104 = null;
        L18:
            r100.b(r110, r111, r101, r102, r103, r104);
            return;
        L17:
            r104 = r115;
            goto L18
        L13:
            r103 = r114;
            goto L15
        L9:
            r102 = r113;
            goto L11
        L5:
            r101 = r112;
            goto L7
        }
    }

    void a();

    void b(String r100, String r101, Integer r102, String r103, String r104, String r105);

    void c();
}
