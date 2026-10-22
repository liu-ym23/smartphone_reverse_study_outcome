package ps8;

import com.larus.platform.api.IVideoController;

/* JADX INFO: loaded from: classes26.dex */
public interface a {

    /* JADX INFO: renamed from: ps8.a$a, reason: collision with other inner class name */
    public static final class C7235a {
        public static /* synthetic */ IVideoController a(a r100, String r101, int r102) {
            if ((r102 & 1) == 0) goto L5;
            r101 = "default";
        L5:
            String r103 = null;
            if ((r102 & 2) == 0) goto L8;
            String r104 = "";
        L10:
            if ((r102 & 4) == 0) goto L13;
            r103 = "";
        L13:
            return r100.a(r101, r104, r103);
        L8:
            r104 = null;
            goto L10
        }
    }

    IVideoController a(String r100, String r101, String r102);

    void b(String r100);

    IVideoController c(String r100, Integer r101, String r102);
}
