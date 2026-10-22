package com.larus.bmhome.chat.standarduikit.coderenderandinterceptor.view;

/* JADX INFO: loaded from: classes26.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.bmhome.chat.standarduikit.coderenderandinterceptor.view.a$a, reason: collision with other inner class name */
    public static final class C4072a {
        public static /* synthetic */ void a(a r100, String r101, String r110, String r111, String r112, int r113, int r114) {
            if ((r114 & 2) == 0) goto L5;
            String r102 = null;
        L7:
            if ((r114 & 4) == 0) goto L9;
            String r103 = null;
        L11:
            if ((r114 & 8) == 0) goto L13;
            String r104 = null;
        L15:
            if ((r114 & 16) == 0) goto L17;
            int r105 = -1;
        L18:
            r100.b(r101, r102, r103, r104, r105);
            return;
        L17:
            r105 = r113;
            goto L18
        L13:
            r104 = r112;
            goto L15
        L9:
            r103 = r111;
            goto L11
        L5:
            r102 = r110;
            goto L7
        }
    }

    void a();

    void b(String r100, String r101, String r102, String r103, int r104);

    void c(String r100, String r101, String r102, String r103, int r104, Boolean r105, Long r106);
}
