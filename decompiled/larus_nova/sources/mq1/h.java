package mq1;

/* JADX INFO: loaded from: classes8.dex */
public interface h {

    public static final class a {
        public static /* synthetic */ void a(h r100, boolean r101, int r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r102 = 0;
        L6:
            if ((r103 & 4) == 0) goto L8;
            String r104 = "default";
        L9:
            r100.a(r101, r102, r104, false);
            return;
        L8:
            r104 = "replay";
            goto L9
        }
    }

    public interface b {
        void p8(boolean r100, int r101, String r102);
    }

    void a(boolean r100, int r101, String r102, boolean r103);

    void c(b r100);

    void d(b r100);
}
